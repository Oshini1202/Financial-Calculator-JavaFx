package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SimpleSavingHelpView {


    public static void displaySavingHelp()
    {
        Stage popupwindowSav=new Stage();

        popupwindowSav.initModality(Modality.APPLICATION_MODAL);
        popupwindowSav.setTitle("\nSimple Saving Help View");


        Label labelSav1= new Label("\tHow to use Simple Saving Calculator ");
        labelSav1.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        Label labelSav2= new Label("\tCalculate Future Value ");
        labelSav1.setFont(Font.font(20));
        Label labelSav3= new Label("\tTo calculate future value of your saving please input \n" +
                "\t\t* The amount of money(Principal value) that your going to invest or already invested in rupees \n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* invested time period in years\n" +
                "\t\t* and leave space on Future value input.\n" +
                "\tAfter entering appropriate inputs then choose Future Value from Solve for drop down list and click on Calculate button. ");

        Label labelSav4= new Label("\tCalculate Interest Rate ");
        labelSav4.setFont(Font.font(20));
        Label labelSav5= new Label("\tTo calculate Yearly Interest rate  of your saving please input \n" +
                "\t\t* The amount of money(Principal value) that your going to invest or already invested in rupees \n" +
                "\t\t* The future value of your saving in rupees \n" +
                "\t\t* invested time period in years\n" +
                "\t\t* and leave space on Interest Rate input.\n" +
                "\tAfter entering appropriate inputs then choose Interest Rate from Solve for drop down list and click on Calculate button. ");

        Label labelSav6= new Label("\tCalculate Invested Time ");
        labelSav6.setFont(Font.font(20));
        Label labelSav7= new Label("\tTo calculate the Invested time of your savings in years please input \n" +
                "\t\t* The amount of money(Principal value) that your going to invest or already invested in rupees \n" +
                "\t\t* The future value of your saving in rupees \n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* The amount of money(Principal value) that your going to invest or already invested in rupees \n" +
                "\t\t* and leave space on Time Period input.\n" +
                "\tAfter entering appropriate inputs then choose Time Period from Solve for drop down list and click on Calculate button. ");

        Label labelSav8= new Label("\tCalculate the Invested money as a Simple Saving ");
        labelSav8.setFont(Font.font(20));
        Label labelSav9= new Label("\tTo calculate the Invested money  of your savings in years please input \n" +
                "\t\t* The future value of your saving in rupees \n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* invested time period in years\n" +
                "\t\t* and leave space on Start Principal input.\n" +
                "\tAfter entering appropriate inputs then choose Start Principal from Solve for drop down list and click on Calculate button. ");


        Button buttonSav1= new Button("Back");
        //button1.setLayoutX(1120);
        //button1.setLayoutY(30);


        buttonSav1.setOnAction(e -> popupwindowSav.close());



        VBox layoutSav= new VBox(10);


        layoutSav.getChildren().addAll(labelSav1 ,labelSav2,labelSav3,labelSav4,labelSav5,labelSav6,labelSav7,labelSav8,labelSav9,buttonSav1);

        layoutSav.setAlignment(Pos.TOP_LEFT);

        Scene sceneSavHelp= new Scene(layoutSav, 900, 900);

        popupwindowSav.setScene(sceneSavHelp);

        popupwindowSav.showAndWait();

    }

}


