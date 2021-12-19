package deivis.paymentsystem;

import logic.Group;

import java.util.ArrayList;

public class Table {
    private ArrayList<Group> groups;
    private TableDataRow[] filledTable;

    public ArrayList<TableDataRow> filledArrayList = new ArrayList<>();

    public Table(ArrayList<Group> groups) {
        this.groups = groups;
        fillTable();
    }

    public void fillTable() {
        TableDataRow temp = null;
        for (logic.Group group : groups) {
            for (int j = 0; j < group.students.size(); j++) {
                for (int k = 0; k < 12; k++) {
                    temp = new TableDataRow();
                    temp.setId(group.students.get(j).getId());
                    temp.setName(group.students.get(j).getName());
                    temp.setSurname(group.students.get(j).getSurname());
                    temp.setGroup(group.getGroupName());
                    if (group.monthPayment[k] > 0) {
                        switch (k) {
                            case 0 -> {
                                temp.Month = "Sausis";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 1 -> {
                                temp.Month = "Vasaris";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 2 -> {
                                temp.Month = "Kovas";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 3 -> {
                                temp.Month = "Balandis";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 4 -> {
                                temp.Month = "Geguze";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 5 -> {
                                temp.Month = "Birzelis";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 6 -> {
                                temp.Month = "Liepa";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 7 -> {
                                temp.Month = "Rugpjutis";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 8 -> {
                                temp.Month = "Rugsejis";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 9 -> {
                                temp.Month = "Spalis";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 10 -> {
                                temp.Month = "Lapkritis";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                            case 11 -> {
                                temp.Month = "Groudis";
                                temp.PaymentAmount = group.monthPayment[k];
                                filledArrayList.add(temp);
                            }
                        }
                    }
                }
            }
        }
        filledTable = filledArrayList.toArray(new TableDataRow[0]);
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public TableDataRow[] getFilledTable() {
        return filledTable;
    }

    public void setFilledTable(TableDataRow[] filledTable) {
        this.filledTable = filledTable;
    }

    public ArrayList<TableDataRow> getFilledArrayList() {
        return filledArrayList;
    }

    public void setFilledArrayList(ArrayList<TableDataRow> filledArrayList) {
        this.filledArrayList = filledArrayList;
    }
}
