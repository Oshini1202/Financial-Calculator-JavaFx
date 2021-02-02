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

public class CompoundSavingHelpView {


    public static void displayCompHelp()
    {
        Stage popupwindowComp=new Stage();

        popupwindowComp.initModality(Modality.APPLICATION_MODAL);
        popupwindowComp.setTitle("Compound Saving Help View");


        Label labelComp1= new Label("\tHow to use Compound Saving Calculator ");
        labelComp1.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        Label labelComp2= new Label("\tCalculate Future Value ");
        labelComp2.setFont(Font.font(20));
        Label labelComp3= new Label("\tTo calculate future value of your compound saving please input \n" +
                "\t\t* The amount of money(Principal Investment) that your going to invest or already invested in rupees \n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* invested time period in years\n" +
                "\t\t* Monthly payment in rupees\n" +
                "\t\t* and leave space on Future value input.\n" +
                "\tAfter entering appropriate inputs then choose Future Value from Solve for drop down list and click on Calculate button. ");

        Label labelComp4= new Label("\tCalculate Monthly Payment ");
        labelComp4.setFont(Font.font(20));
        Label labelComp5= new Label("\tTo calculate  the monthly payment of your compound saving please input \n" +
                "\t\t* The amount of money(Principal Investment) that your going to invest or already invested in rupees \n" +
                "\t\t* The future value of your saving in rupees \n" +
                "\t\t* invested time period in years\n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* and leave space on Monthly Payment input.\n" +
                "\tAfter entering appropriate inputs then choose Monthly Payment from Solve for drop down list and click on Calculate button. ");

        Label labelComp6= new Label("\tCalculate Present Value ");
        labelComp6.setFont(Font.font(20));
        Label labelComp7= new Label("\tTo calculate the Present Value of your Compound savings please input \n" +
                "\t\t* The future value of your saving in rupees \n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* Monthly payment in rupees\n" +
                "\t\t* invested time period in years\n" +
                "\t\t* and leave space on Principal investment input.\n" +
                "\tAfter entering appropriate inputs then choose Present Value from Solve for drop down list and click on Calculate button. ");

        Label labelComp8= new Label("\tCalculate the Invested Time Period ");
        labelComp8.setFont(Font.font(20));
        Label labelComp9= new Label("\tTo calculate the Invested  Time Period of your compound savings in years please input \n" +
                "\t\t* The future value of your saving in rupees \n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* Monthly payment in rupees\n" +
                "\t\t* The amount of money(Principal Investment) that your going to invest or already invested in rupees \n" +
                "\t\t* and leave space on Time Period input.\n" +
                "\tAfter entering appropriate inputs then choose Time period from Solve for drop down list and click on Calculate button. ");


        Button buttonComp1= new Button("Back");
        //button1.setLayoutX(1120);
        //button1.setLayoutY(30);


        buttonComp1.setOnAction(e -> popupwindowComp.close());


        VBox layout= new VBox(10);


        layout.getChildren().addAll(labelComp1,labelComp2,labelComp3,labelComp4,labelComp5,labelComp6,labelComp7,labelComp8,labelComp9,buttonComp1);

        layout.setAlignment(Pos.TOP_LEFT);

        Scene CompHelp= new Scene(layout, 900, 900);

        popupwindowComp.setScene(CompHelp);

        popupwindowComp.showAndWait();

    }

}

