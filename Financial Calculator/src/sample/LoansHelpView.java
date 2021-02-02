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

public class LoansHelpView {


    public static void displayLoanHelp()
    {
        Stage popupwindowLoan=new Stage();

        popupwindowLoan.initModality(Modality.APPLICATION_MODAL);
        popupwindowLoan.setTitle("Loan Help View");


        Label labelLoan1= new Label("\tHow to use Loan Calculator ");
        labelLoan1.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        Label labelLoan2= new Label("\tCalculate Monthly Payment\n");
        labelLoan2.setFont(Font.font(20));
        Label labelLoan3= new Label("\tTo calculate Monthly of your Loan please input \n" +
                "\t\t* The loan amount in rupees \n" +
                "\t\t* invested time period in years as Loan Term\n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* If there is a down payment, input the value to the appropriate text box\n"+
                "\t\t* and leave space on Monthly Payment input.\n" +
                "\tAfter entering appropriate inputs then choose Monthly Payment from Solve for drop down list and click on Calculate button.\n");

        Label labelLoan4= new Label("\tLoan Period\n");
        labelLoan4.setFont(Font.font(20));
        Label labelLoan5= new Label("\tTo calculate Yearly Interest rate  of your loan please input \n" +
                "\t\t* The loan amount in rupees \n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* If there is a down payment, input the value to the appropriate text box\n"+
                "\t\t* Input the Monthly Payment in rupees.\n" +
                "\t\t* and leave space on Loan Period input.\n" +
                "\tAfter entering appropriate inputs then choose Loan Period from Solve for drop down list and click on Calculate button.\n ");

        Label labelLoan6= new Label("\tPresent Value \n");
        labelLoan6.setFont(Font.font(20));
        Label labelLoan7= new Label("\tTo calculate the Invested time of your loan in years please input \n" +
                "\t\t* Input the Monthly Payment in rupees.\n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* Input the Monthly Payment in rupees.\n" +
                "\t\t* If there is a down payment, input the value to the appropriate text box\n"+
                "\t\t* and leave space on Loan Amount input.\n" +
                "\tAfter entering appropriate inputs then choose Present Value from Solve for drop down list and click on Calculate button. \n");




        Button buttonLoan1= new Button("Back");
        //button1.setLayoutX(1120);
        //button1.setLayoutY(30);


        buttonLoan1.setOnAction(e -> popupwindowLoan.close());



        VBox layoutLoan= new VBox(10);


        layoutLoan.getChildren().addAll(labelLoan1,labelLoan2,labelLoan3,labelLoan4,labelLoan5,labelLoan6,labelLoan7,buttonLoan1);

        layoutLoan.setAlignment(Pos.TOP_LEFT);

        Scene scene1= new Scene(layoutLoan, 900, 700);

        popupwindowLoan.setScene(scene1);

        popupwindowLoan.showAndWait();

    }

}


