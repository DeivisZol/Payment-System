package deivis.paymentsystem;

import javafx.util.Pair;
import logic.Group;
import logic.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoadFromFile {
    public List<Group> loadFromFile(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            TableDataRow[] input = lines.stream()
                    .skip(2)
                    .map(line -> {
                        String[] tokens = line.split(",");
                        TableDataRow row = new TableDataRow();
                        row.setId(Integer.parseInt(tokens[0]));
                        row.setName(tokens[1]);
                        row.setSurname(tokens[2]);
                        row.setGroup(tokens[3]);
                        row.setMonth(tokens[4]);
                        row.setPaymentAmount(Double.parseDouble(tokens[5]));
                        return row;
                    })
                    .toArray(TableDataRow[]::new);

            // grupiu vardai
            List<Group> newGroups = Arrays.stream(input)
                    .map(TableDataRow::getGroup)
                    .distinct()
                    .map(groupName -> {
                        Group group = new Group();
                        group.setGroupName(groupName);
                        return group;
                    })
                    .collect(Collectors.toList());

            // Grupiu dydziai
            for (Group newGroup : newGroups) {
                double[] monthPayments = new double[12];
                Arrays.stream(input)
                        .filter(row -> row.getGroup().equals(newGroup.getGroupName()))
                        .map(row -> new Pair<>(monthNameToNumber(row.getMonth()) - 1, row.getPaymentAmount()))
                        .distinct()
                        .forEach(pair -> monthPayments[pair.getKey()] = pair.getValue());
                newGroup.setMonthPayment(monthPayments);
            }

            // Studentai
            for (Group newGroup : newGroups) {
                newGroup.setStudents(Arrays.stream(input)
                        .filter(row -> row.getGroup().equals(newGroup.getGroupName()))
                        .map(row -> {
                            Student student = new Student();
                            student.setId(row.getId());
                            student.setName(row.getName());
                            student.setSurname(row.getSurname());
                            return student;
                        })
                        .distinct()
                        .collect(Collectors.toList()));
            }

            return newGroups;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int monthNameToNumber(String name) {
        return switch (name) {
            case "Sausis" -> 1;
            case "Vasaris" -> 2;
            case "Kovas" -> 3;
            case "Balandis" -> 4;
            case "Geguze" -> 5;
            case "Birzelis" -> 6;
            case "Liepa" -> 7;
            case "Rugpjutis" -> 8;
            case "Rugsejis" -> 9;
            case "Spalis" -> 10;
            case "Lapkritis" -> 11;
            case "Gruodis" -> 12;
            default -> -1;
        };
    }
}
