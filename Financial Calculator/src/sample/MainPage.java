package sample;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.Window;
import javafx.scene.paint.*;

public class MainPage extends Application {
    Stage window1;


    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window1 = primaryStage;
        window1.setTitle("Manager Log in");

        GridPane gridMainPage=new GridPane();
        gridMainPage.setAlignment(Pos.TOP_CENTER);
        gridMainPage.setVgap(10);

        gridMainPage.setPadding(new Insets(0,1,2,1));
        Image backgroundImage = new Image(getClass().getResourceAsStream("back.jpg"));

        BackgroundImage backgroundimage = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        //       create Background
        Background background = new Background(backgroundimage);
        gridMainPage.setBackground(background);

        Scene scene=new Scene(gridMainPage,1050,550);
        window1.setScene(scene);
        window1.show();

        Label lblMainPageTitle=new Label("Financial Calculator");
        lblMainPageTitle.setFont(Font.font("Verdana", FontWeight.BOLD,36));
        gridMainPage.add(lblMainPageTitle,1,3);

        Button btnComSavings= new Button("Compound Savings");
        btnComSavings.setFont(Font.font("Arial", FontWeight.BOLD,24));
        gridMainPage.add(btnComSavings,1,5);


        Button btnSimSavings= new Button("Simple Savings");
        btnSimSavings.setFont(Font.font("Arial", FontWeight.BOLD,24));
        gridMainPage.add(btnSimSavings,1,7);


        Button btnLoan= new Button("Loans");
        btnLoan.setFont(Font.font("Arial", FontWeight.BOLD,24));
        gridMainPage.add(btnLoan,1,9);


        Button btnMortgage= new Button("Mortgage");
        btnMortgage.setFont(Font.font("Arial", FontWeight.BOLD,24));
        gridMainPage.add(btnMortgage,1,11);


        Button btnHistory= new Button("History");
        gridMainPage.add(btnHistory,1,13);
        btnHistory.setFont(Font.font("Arial", FontWeight.BOLD,24));




    }
}
