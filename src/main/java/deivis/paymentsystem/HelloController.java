package deivis.paymentsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.Group;
import logic.Student;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
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
        int month = 0;
        int position = 0;
        for(int i = 0; groups.size() > i ;i++) {
            if(groups.get(i).getGroupName().equals(groupPayment.getSelectionModel().getSelectedItem())) {
                position = i;
            }
        }
        temp = groups.get(position);
        switch (selectMonth.getSelectionModel().getSelectedItem()) {
            case "Sausis" -> month = 1;
            case "Vasaris" -> month = 2;
            case "Kovas" -> month = 3;
            case "Balandis" -> month = 4;
            case "Geguze" -> month = 5;
            case "Birzelis" -> month = 6;
            case "Liepa" -> month = 7;
            case "Rugpjutis" -> month = 8;
            case "Rugsejis" -> month = 9;
            case "Spalis" -> month = 10;
            case "Lapkritis" -> month = 11;
            case "Gruodis" -> month = 12;
        }
        temp.addMonthPayment(month, groupMonthPayment);
        groups.set(position,temp);
    }

    private void createStudent(ActionEvent actionEvent) {
        Student student = new Student();
        student.setName(this.studentName.getText());
        student.setSurname(this.studentSurname.getText());
        student.setId(Integer.parseInt(this.studentId.getText()));
        Group temp;
        int position = 0;
        for(int i = 0; groups.size() > i ;i++) {
            if(groups.get(i).getGroupName().equals(selectGroup.getSelectionModel().getSelectedItem())) {
                position = i;
                break;
            }
        }
        temp = groups.get(position);
        temp.addStudent(student);
        groups.set(position,temp);
    }

    private void printToScreen(ActionEvent actionEvent) {
        Table results = new Table(groups);
        table.getItems().clear();
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tableSurname.setCellValueFactory(new PropertyValueFactory<>("Surname"));
        tableMonth.setCellValueFactory(new PropertyValueFactory<>("Month"));
        tableGroup.setCellValueFactory(new PropertyValueFactory<>("Group"));
        tablePaymentAmount.setCellValueFactory(new PropertyValueFactory<>("PaymentAmount"));

        int monthFrom = monthNameToNumber(selectMonthFrom.getSelectionModel().getSelectedItem());
        int monthTo = monthNameToNumber(selectMonthTo.getSelectionModel().getSelectedItem());

        TableDataRow[] data = Arrays.stream(results.getFilledTable())
                .filter(row -> monthNameToNumber(row.getMonth()) >= monthFrom)
                .filter(row -> monthNameToNumber(row.getMonth()) <= monthTo)
                .toArray(TableDataRow[]::new);

        table.getItems().addAll(data);
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

    public void printToPdfFile(ActionEvent actionEvent){
        PrintToFilePdf print = new PrintToFilePdf();
        print.printToFile(groups);
    }
    private void printToCvsFile(ActionEvent actionEvent){
        PrintToFileCvs print = new PrintToFileCvs();
        print.printToFile(groups);
    }
    private void loadFromFile(ActionEvent actionEvent){}

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