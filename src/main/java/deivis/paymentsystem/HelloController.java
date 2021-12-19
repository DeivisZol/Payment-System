package deivis.paymentsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;
import logic.Group;
import logic.Student;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HelloController implements Initializable {
    @FXML
    public Button createGroupButton;
    @FXML
    public Button groupPaymentButton;
    @FXML
    public TextField createGroupName;
    @FXML
    public TextField groupMonthPayment;
    @FXML
    public ChoiceBox<String> groupPayment;
    @FXML
    public ChoiceBox<String> selectMonth;


    @FXML
    public Button createStudentButton;
    @FXML
    public TextField studentName;
    @FXML
    public TextField studentSurname;
    @FXML
    public TextField studentId;
    @FXML
    public ChoiceBox<String> selectGroup;


    @FXML
    public Button loadFromFileButton;
    @FXML
    public Button printToCvsFile;
    @FXML
    public Button printToPdfFile;
    @FXML
    public TextField loadFromFileName;


    @FXML
    public ChoiceBox<String> selectMonthFrom;
    @FXML
    public ChoiceBox<String> selectMonthTo;


    @FXML
    public Button loadTableButton;
    @FXML
    private TableView<TableDataRow> table;
    @FXML
    private TableColumn<TableDataRow, Integer> tableId;
    @FXML
    private TableColumn<TableDataRow, Integer> tableName;
    @FXML
    private TableColumn<TableDataRow, Integer> tableSurname;
    @FXML
    private TableColumn<TableDataRow, Integer> tableGroup;
    @FXML
    private TableColumn<TableDataRow, Integer> tableMonth;
    @FXML
    private TableColumn<TableDataRow, Integer> tablePaymentAmount;

    ArrayList<Group> groups = new ArrayList<>();

    private void createGroup(ActionEvent actionEvent) {
        String groupName = this.createGroupName.getText();
        Group group = new Group();
        group.setGroupName(groupName);
        groups.add(group);
        groupPayment.getItems().add(groupName);
        selectGroup.getItems().add(groupName);
    }

    private void addGroupMonthPrice(ActionEvent actionEvent) {
        double groupMonthPayment = Double.parseDouble(this.groupMonthPayment.getText());
        Group temp;
        int position = 0;
        for (int i = 0; groups.size() > i; i++) {
            if (groups.get(i).getGroupName().equals(groupPayment.getSelectionModel().getSelectedItem())) {
                position = i;
            }
        }
        temp = groups.get(position);
        temp.addMonthPayment(monthNameToNumber(selectMonth.getSelectionModel().getSelectedItem()), groupMonthPayment);
        groups.set(position, temp);
    }

    private void createStudent(ActionEvent actionEvent) {
        Student student = new Student();
        student.setName(this.studentName.getText());
        student.setSurname(this.studentSurname.getText());
        student.setId(Integer.parseInt(this.studentId.getText()));
        Group temp;
        int position = 0;
        for (int i = 0; groups.size() > i; i++) {
            if (groups.get(i).getGroupName().equals(selectGroup.getSelectionModel().getSelectedItem())) {
                position = i;
                break;
            }
        }
        temp = groups.get(position);
        temp.addStudent(student);
        groups.set(position, temp);
    }

    private void printToScreen(ActionEvent actionEvent) {
        table.getItems().clear();
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tableSurname.setCellValueFactory(new PropertyValueFactory<>("Surname"));
        tableMonth.setCellValueFactory(new PropertyValueFactory<>("Month"));
        tableGroup.setCellValueFactory(new PropertyValueFactory<>("Group"));
        tablePaymentAmount.setCellValueFactory(new PropertyValueFactory<>("PaymentAmount"));
        table.getItems().addAll(getFilteredResults());
    }

    private TableDataRow[] getFilteredResults() {
        Table results = new Table(groups);
        int monthFrom = monthNameToNumber(selectMonthFrom.getSelectionModel().getSelectedItem());
        int monthTo = monthNameToNumber(selectMonthTo.getSelectionModel().getSelectedItem());
        return Arrays.stream(results.getFilledTable())
                .filter(row -> monthNameToNumber(row.getMonth()) >= monthFrom)
                .filter(row -> monthNameToNumber(row.getMonth()) <= monthTo)
                .toArray(TableDataRow[]::new);
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

    private String monthNumberToName(int number) {
        return switch (number) {
            case 1 -> "Sausis";
            case 2 -> "Vasaris";
            case 3 -> "Kovas";
            case 4 -> "Balandis";
            case 5 -> "Geguze";
            case 6 -> "Birzelis";
            case 7 -> "Liepa";
            case 8 -> "Rugpjutis";
            case 9 -> "Rugsejis";
            case 10 -> "Spalis";
            case 11 -> "Lapkritis";
            case 12 -> "Gruodis";
            default -> "";
        };
    }

    public void printToPdfFile(ActionEvent actionEvent) {
        PrintToFilePdf print = new PrintToFilePdf();
        print.printToFile(getFilteredResults());
    }

    private void printToCvsFile(ActionEvent actionEvent) {
        PrintToFileCvs print = new PrintToFileCvs();
        print.printToFile(getFilteredResults());
    }

    private void loadFromFile(ActionEvent actionEvent) {
        LoadFromFile fileLoader = new LoadFromFile();
        List<Group> newGroups = fileLoader.loadFromFile(loadFromFileName.getText());

        groups.addAll(newGroups);
        groupPayment.getItems().addAll(newGroups.stream().map(Group::getGroupName).collect(Collectors.toList()));
        selectGroup.getItems().addAll(newGroups.stream().map(Group::getGroupName).collect(Collectors.toList()));
        printToScreen(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createGroupButton.setOnAction(this::createGroup);
        groupPaymentButton.setOnAction(this::addGroupMonthPrice);
        createStudentButton.setOnAction(this::createStudent);

        loadTableButton.setOnAction(this::printToScreen);

        loadFromFileButton.setOnAction(this::loadFromFile);
        printToCvsFile.setOnAction(this::printToCvsFile);
        printToPdfFile.setOnAction(this::printToPdfFile);
    }


}