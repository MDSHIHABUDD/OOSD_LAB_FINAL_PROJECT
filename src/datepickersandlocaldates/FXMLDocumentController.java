/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package datepickersandlocaldates;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MAHIR
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private Button selectDateButton;
    @FXML
    private DatePicker datePicker1;
    @FXML
    private Label outputLabel;
    @FXML
    private Button resetDateButton;
    @FXML
    private Button todayButton;
    @FXML
    private Button defaultButton;
    @FXML
    private DatePicker datePicker2;
    @FXML
    private Button compareDateButton;
    @FXML
    private Label compareLabel;
    @FXML
    private Button differDaysButton;
    @FXML
    private Label differLabel;
    @FXML
    private Button calculateAgeButton;
    @FXML
    private Label ageLabel;
        /**
     * Initializes the controller class.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("“Time is what we want most but what we use worst.”");
    }  
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
     // TODO
        //LocalDate localDate1 = 
    }    

    @FXML
    private void selectDateButtonHandler(ActionEvent event) 
    {
        LocalDate localDate1 = datePicker1.getValue();
        
        outputLabel.setText ("You selected " + localDate1);
    }

    @FXML
    private void resetDateButtonHandler(ActionEvent event) 
    {
        datePicker1.setValue (null);
    }

    @FXML
    private void todayButtonHandler(ActionEvent event) 
    {
        //LocalDate today = LocalDate.now();
        //datePicker1.setValue (today);
        datePicker1.setValue (LocalDate.now());
    }

    @FXML
    private void defaultButtonHandler(ActionEvent event) 
    {
        LocalDate defaultDate = LocalDate.of (2021, 8, 1);
        
        datePicker1.setValue (defaultDate);
    }

    @FXML
    private void compareDateButtonHandler(ActionEvent event) 
    {
        LocalDate localDate1 = datePicker1.getValue();
        LocalDate localDate2 = datePicker2.getValue();
        
        if (localDate1 == null)
            compareLabel.setText ("First Date is null");
        else if (localDate2 == null)
            compareLabel.setText ("Second Date is null");
        else
        {
            // Date are NOT null
            int result = localDate1.compareTo (localDate2);
            
            if (result < 0)
                compareLabel.setText ("First Date < Second Date");
            else if (result > 0)
                compareLabel.setText ("First Date > Second Date");
            else 
                compareLabel.setText ("First Date = Second Date");
        }
    }
    @FXML
    
    private void differDaysButtonhandler(ActionEvent event) 
    {
        LocalDate localDate1 = datePicker1.getValue();
    
        LocalDate localDate2 = datePicker2.getValue();
    
    if (localDate1 == null || localDate2 == null) {
        differLabel.setText("Please select both dates.");
    } else {
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(localDate1, localDate2);
        differLabel.setText("Days between: " + Math.abs(daysBetween));
        
    }
      
    datePicker1.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
    @Override
    public void updateItem(LocalDate date, boolean empty) {
        super.updateItem(date, empty);
        if (date != null && (date.getDayOfWeek() == java.time.DayOfWeek.SATURDAY 
                             || date.getDayOfWeek() == java.time.DayOfWeek.SUNDAY)) {
            this.setStyle("-fx-background-color: #FFCCCC;"); // Highlight weekends in light red
        }
    }
});
    datePicker1.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
    @Override
    public void updateItem(LocalDate date, boolean empty) {
        super.updateItem(date, empty);
        if (date.isBefore(LocalDate.now())) {
            setDisable(true); // Disable past dates
            setStyle("-fx-background-color: #EEEEEE;"); // Optional: Grey out past dates
        }
    }
});
    }

    @FXML
    private void calculateAgeButtonHandler(ActionEvent event) 
    {
        LocalDate birthDate = datePicker2.getValue(); // Get the selected birthdate
    if (birthDate == null) {
        ageLabel.setText("Please select your birthdate.");
    } else {
        LocalDate currentDate = LocalDate.now(); // Get today's date
        int age = calculateAge(birthDate, currentDate); // Calculate the age
        
        ageLabel.setText("Your age is: " + age + " years");
    }
}

// Utility method to calculate age
private int calculateAge(LocalDate birthDate, LocalDate currentDate) {
    if ((birthDate != null) && (currentDate != null)) {
        return currentDate.getYear() - birthDate.getYear() - 
               ((currentDate.getDayOfYear() < birthDate.getDayOfYear()) ? 1 : 0);
    } else {
        return 0;
    }
}
    
}
    

    
