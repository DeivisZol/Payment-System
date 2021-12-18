package deivis.paymentsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import logic.Group;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    public Button loadTableButton;
    @FXML
    private TableView<String> table;
    @FXML
    private TableColumn<String, Integer> tableId;
    @FXML
    private TableColumn<String, Integer> tableName;
    @FXML
    private TableColumn<String, Integer> tableSurname;
    @FXML
    private TableColumn<String, Integer> tableGroup;
    @FXML
    private TableColumn<String, Integer> tableMonth;
    @FXML
    private TableColumn<String, Integer> tablePaymentAmount;

    ArrayList<Group> groups = new ArrayList<Group>();;

    private void createGroup(ActionEvent actionEvent) {
        String groupName = this.createGroupName.getText();
        Group group = new Group();
        group.setGroupName(groupName);
        groups.add(group);
        groupPayment.getItems().add(groupName);
        selectGroup.getItems().add(groupName);
    }

    private void addGroupMonthPrice(ActionEvent actionEvent) {
        String groupName = groupPayment.getSelectionModel().getSelectedItem();
        int position = 0;
        for(int i = 0; groups.size() < i ;i++) {
            if(groups.get(i).equals(groupName)) {
                position = i;
            }
        }
        Group temp;
        temp = groups.get(position);
        String monthName = selectMonth.getSelectionModel().getSelectedItem();
        int month = 1;
        if(monthName.equals("Sausis")) month = 1;
        if(monthName.equals("Vasaris")) month = 2;
        if(monthName.equals("Kovas")) month = 3;
        if(monthName.equals("Balandis")) month = 4;
        if(monthName.equals("Geguze")) month = 5;
        if(monthName.equals("Birzelis")) month = 6;
        if(monthName.equals("Liepa")) month = 7;
        if(monthName.equals("Rugpjutis")) month = 8;
        if(monthName.equals("Rugsejis")) month = 9;
        if(monthName.equals("Spalis")) month = 10;
        if(monthName.equals("Lapkritis")) month = 11;
        if(monthName.equals("Gruodis")) month = 12;
        double groupMonthPayment = Double.parseDouble(this.groupMonthPayment.getText());
        temp.addMonthPayment(month, groupMonthPayment);
        groups.add(position,temp);

        System.out.println(groups.get(0).monthPayment[3]);
    }


    private void printToPdfFile(ActionEvent actionEvent){}
    private void printToCvsFile(ActionEvent actionEvent){}
    private void loadFromFile(ActionEvent actionEvent){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createGroupButton.setOnAction(this::createGroup);
        groupPaymentButton.setOnAction(this::addGroupMonthPrice);




        loadFromFileButton.setOnAction(this::loadFromFile);
        printToCvsFile.setOnAction(this::printToCvsFile);
        printToPdfFile.setOnAction(this::printToPdfFile);
    }



}