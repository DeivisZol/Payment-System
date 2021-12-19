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
            for (int j = 0; j < group.getStudents().size(); j++) {
                for (int k = 0; k < 12; k++) {
                    temp = new TableDataRow();
                    temp.setId(group.getStudents().get(j).getId());
                    temp.setName(group.getStudents().get(j).getName());
                    temp.setSurname(group.getStudents().get(j).getSurname());
                    temp.setGroup(group.getGroupName());
                    if (group.getMonthPayment()[k] > 0) {
                        switch (k) {
                            case 0 -> {
                                temp.setMonth("Sausis");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 1 -> {
                                temp.setMonth("Vasaris");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 2 -> {
                                temp.setMonth("Kovas");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 3 -> {
                                temp.setMonth("Balandis");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 4 -> {
                                temp.setMonth("Geguze");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 5 -> {
                                temp.setMonth("Birzelis");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 6 -> {
                                temp.setMonth("Liepa");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 7 -> {
                                temp.setMonth("Rugpjutis");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 8 -> {
                                temp.setMonth("Rugsejis");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 9 -> {
                                temp.setMonth("Spalis");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 10 -> {
                                temp.setMonth("Lapkritis");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
                                filledArrayList.add(temp);
                            }
                            case 11 -> {
                                temp.setMonth("Groudis");
                                temp.setPaymentAmount(group.getMonthPayment()[k]);
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
