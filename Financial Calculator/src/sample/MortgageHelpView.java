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

public class MortgageHelpView {


    public static void displayMortgageHelp()
    {
        Stage popupwindowMort=new Stage();

        popupwindowMort.initModality(Modality.APPLICATION_MODAL);
        popupwindowMort.setTitle("Mortgage Help View");


        Label labelMort1= new Label("\tHow to use Mortgage Calculator\n ");
        labelMort1.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        Label labelMort2= new Label("\tTime Period");
        labelMort2.setFont(Font.font(20));
        Label labelMort3= new Label("\tTo calculate Time Period of your mortgage please input \n" +
                "\t\t* The Home Price of your mortgage in rupees \n" +
                "\t\t* If there is a down payment input the value on Down Payment input area or put zero on the down payment input.\n"+
                "\t\t* The monthly payment of your mortgage in rupees \n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\tAfter entering appropriate inputs then choose Time Period from Solve for drop down list and click on Calculate button.\n" +
                "\tThen you can see the results of your calculation in the right side of the calculator \n");

        Label labelMort4= new Label("\tMonthly Payment ");
        labelMort4.setFont(Font.font(20));
        Label labelMort5= new Label("\tTo calculate Your monthly mortgage payment please input \n" +
                "\t\t* The Home Price of your mortgage in rupees \n" +
                "\t\t* If there is a down payment input the value on Down Payment input area or put zero on the down payment input.\n"+
                "\t\t* invested time period in years\n" +
                "\t\t* Annual interest rate as a percentage\n" +
                "\t\t* and leave space on Monthly Payment input.\n" +
                "\tAfter entering appropriate inputs then choose Monthly Payment from Solve for drop down list and click on Calculate button.\n ");


        Button buttonMort1= new Button("Back");

        //button1.setLayoutX(1120);
        //button1.setLayoutY(30);


        buttonMort1.setOnAction(e -> popupwindowMort.close());



        VBox layout= new VBox(10);


        layout.getChildren().addAll(labelMort1,labelMort2,labelMort3,labelMort4,labelMort5,buttonMort1);

        layout.setAlignment(Pos.TOP_LEFT);

        Scene sceneMortHelp= new Scene(layout, 900, 750);

        popupwindowMort.setScene(sceneMortHelp);

        popupwindowMort.showAndWait();

    }

}

