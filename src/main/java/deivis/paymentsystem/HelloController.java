package deivis.paymentsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    public Button createGroupButton;
    @FXML
    public Button groupPaymentButton;
    @FXML
    public Button loadFromFileButton;
    @FXML
    public Button printToCvsFile;
    @FXML
    public Button printToPdfFile;
    @FXML
    public Button createStudentButton;
    @FXML
    public Button loadTableButton;

    @FXML
    public TextField createGroupName;
    @FXML
    public TextField groupMonthPayment;
    @FXML
    public TextField loadFromFileName;
    @FXML
    public TextField studentName;
    @FXML
    public TextField studentSurname;
    @FXML
    public TextField studentId;


    @FXML
    public ChoiceBox<String> groupPayment;
    @FXML
    public ChoiceBox<String> selectMonth;
    @FXML
    public ChoiceBox<String> selectGroup;

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


    public void pressButton(ActionEvent event) {
        System.out.println("s");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}