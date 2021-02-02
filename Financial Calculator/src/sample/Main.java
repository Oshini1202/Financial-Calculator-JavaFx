package sample;

import javafx.scene.control.TextField;

import java.io.*;
import java.text.DecimalFormat;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import static java.lang.Double.parseDouble;

public class Main extends Application {

    private static DecimalFormat df = new DecimalFormat("0.00");

    Stage window;
    Scene sceneMainPage, sceneMortgage, sceneSimpleSavings, sceneCompoundSavings, sceneLoans;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        //////////////////////////////////////////////////////  Main Page Scene   ////////////////////////////////////////////////////


        window = primaryStage;

        //set the title of the application
        window.setTitle("Financial Calculator");

        GridPane gridMainPage = new GridPane();
        gridMainPage.setAlignment(Pos.TOP_CENTER);   // align the items on the grid pane to the Top center position
        gridMainPage.setVgap(10);                    // set vertical gap of the main page grid

        gridMainPage.setPadding(new Insets(0, 1, 2, 1));     // set the padding of main page grid

        // set an image as background
        Image backgroundImage = new Image(getClass().getResourceAsStream("img03.jpg"));

        BackgroundImage backgroundimage = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        //      Create Background
        Background background = new Background(backgroundimage);
        gridMainPage.setBackground(background);

        //      Set Main Page Title
        Label lblMainPageTitle = new Label("Financial Calculator");
        lblMainPageTitle.setTextFill(Color.web("white"));
        lblMainPageTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 42));
        gridMainPage.add(lblMainPageTitle, 1, 4);


        //       Add buttons to the main page to navigate the application

        //       Compound Saving button
        Button btnComSavings = new Button("Compound Savings");
        btnComSavings.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridMainPage.add(btnComSavings, 1, 10);
        btnComSavings.setOnAction(event -> window.setScene(sceneCompoundSavings));  // add on click action to switch the compound savings scene

        //       Simple saving button
        Button btnSimSavings = new Button("Simple Savings");
        btnSimSavings.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridMainPage.add(btnSimSavings, 1, 12);
        btnSimSavings.setOnAction(event -> window.setScene(sceneSimpleSavings));    // add on click action to switch the simple savings scene

        //       Loans button
        Button btnLoan = new Button("Loans");
        btnLoan.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridMainPage.add(btnLoan, 1, 14);
        btnLoan.setOnAction(event -> window.setScene(sceneLoans));                  // add on click action to switch the loans scene

        //      Mortgage button
        Button btnMortgage = new Button("Mortgage");
        btnMortgage.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridMainPage.add(btnMortgage, 1, 16);
        btnMortgage.setOnAction(event -> window.setScene(sceneMortgage));           // add on click action to switch the mortgage scene

        /*Button btnHistory= new Button("History");
        gridMainPage.add(btnHistory,1,16);
        btnHistory.setFont(Font.font("Arial", FontWeight.BOLD,24));*/

        // styling the width of buttons on main page
        btnMortgage.setMaxWidth(300);
        btnSimSavings.setMaxWidth(300);
        btnLoan.setMaxWidth(300);
        btnComSavings.setMaxWidth(300);
        //btnHistory.setMaxWidth(300);


        // manage the area size of the main page
        sceneMainPage = new Scene(gridMainPage, 800, 500);


        ////////////////////////////////////////////////// Mortgage scene ///////////////////////////////////////////////////

        // set a grid pane to the new scene
        GridPane gridMortgage = new GridPane();
        gridMortgage.setAlignment(Pos.TOP_LEFT);
        gridMortgage.setVgap(10);
        gridMortgage.setHgap(10);

        // set padding of the grid
        gridMortgage.setPadding(new Insets(0, 1, 5, 1));

        // add an image as background
        backgroundImage = new Image(getClass().getResourceAsStream("mor.jpg"));
        backgroundimage = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // Create Background
        background = new Background(backgroundimage);
        gridMortgage.setBackground(background);


        // Set Mortgage Page Title
        Label lblMortTitle = new Label("Mortgage Calculator");
        lblMortTitle.setStyle("-fx-text-fill: #D3D3D3");
        lblMortTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 28));
        gridMortgage.add(lblMortTitle, 1, 1);


        //Left side input textfields and labels set

        Label lblMortInHomePrice = new Label("Home Price");
        lblMortInHomePrice.setFont(Font.font(20));
        lblMortInHomePrice.setTextFill(Color.web("white"));
        gridMortgage.add(lblMortInHomePrice, 1, 3);
        TextField tfMortIHP = new TextField();
        tfMortIHP.setPromptText("RS.");
        tfMortIHP.setFont(Font.font(18));
        //tfMortIHP.getProperties().put("vkType", "numeric");
        gridMortgage.add(tfMortIHP, 3, 3);

        Label lblMortDownPayment = new Label("Down Payment");
        lblMortDownPayment.setFont(Font.font(20));
        lblMortDownPayment.setTextFill(Color.web("white"));
        gridMortgage.add(lblMortDownPayment, 1, 4);
        TextField tfMortIDP = new TextField();
        tfMortIDP.setPromptText("Rs.");
        tfMortIDP.setFont(Font.font(18));
        gridMortgage.add(tfMortIDP, 3, 4);

        Label lblMortLoanTerm = new Label("Loan Term");
        lblMortLoanTerm.setFont(Font.font(20));
        lblMortLoanTerm.setTextFill(Color.web("white"));
        gridMortgage.add(lblMortLoanTerm, 1, 5);
        TextField tfMortILT = new TextField();
        tfMortILT.setPromptText("years");
        tfMortILT.setFont(Font.font(18));
        gridMortgage.add(tfMortILT, 3, 5);

        Label lblMortInInterestRate = new Label("Interest Rate");
        lblMortInInterestRate.setFont(Font.font(20));
        lblMortInInterestRate.setTextFill(Color.web("white"));
        gridMortgage.add(lblMortInInterestRate, 1, 6);
        TextField tfMortIIR = new TextField();
        tfMortIIR.setPromptText("%");
        tfMortIIR.setFont(Font.font(18));
        gridMortgage.add(tfMortIIR, 3, 6);

        Label lblMortInPMT = new Label("Mortgage Payment");
        lblMortInPMT.setFont(Font.font(20));
        lblMortInPMT.setTextFill(Color.web("white"));
        gridMortgage.add(lblMortInPMT, 1, 7);
        TextField tfMortIPMT = new TextField();
        tfMortIPMT.setPromptText("Rs.");
        tfMortIPMT.setFont(Font.font(18));
        gridMortgage.add(tfMortIPMT, 3, 7);

        Label lblMorSolveFor = new Label("Solve For");
        lblMorSolveFor.setFont(Font.font(20));
        lblMorSolveFor.setTextFill(Color.web("white"));
        gridMortgage.add(lblMorSolveFor, 1, 8);
        ChoiceBox<String> MorchoiceBox = new ChoiceBox<>();

        //get items returns the observable list object which you can add items to
        MorchoiceBox.getItems().add("Time Period");
        MorchoiceBox.getItems().add("Monthly Payment");
        gridMortgage.add(MorchoiceBox, 3, 8);

        // styling the width of buttons on main page
        lblMortInHomePrice.setMaxWidth(200);
        lblMortDownPayment.setMaxWidth(200);
        lblMortLoanTerm.setMaxWidth(200);
        lblMortInInterestRate.setMaxWidth(200);
        lblMortInPMT.setMaxWidth(200);

        // file button of mortgage scene
        Button btnMortFile = new Button("File");
        btnMortFile.setStyle("-fx-background-color:  #ADD8E6");
        btnMortFile.setFont(Font.font(22));
        gridMortgage.add(btnMortFile, 11, 1);

        //Set calculate button
        Button btnMortCalculate = new Button("Calculate > ");
        btnMortCalculate.setFont(Font.font(22));
        btnMortCalculate.setStyle("-fx-background-color: red");
        btnMortCalculate.setTextFill(Color.web("white"));
        gridMortgage.add(btnMortCalculate, 1, 10);

        //Set back button
        Button btnMortBack = new Button("Back");
        btnMortBack.setFont(Font.font(22));
        btnMortBack.setStyle("-fx-background-color: blue");
        btnMortBack.setTextFill(Color.web("white"));
        gridMortgage.add(btnMortBack, 12, 10);
        btnMortBack.setOnAction(event -> window.setScene(sceneMainPage));

        //Results Title label
        Label lblMortResults = new Label("\tResults....");
        lblMortResults.setFont(Font.font("Arial", FontWeight.BOLD, 23));
        gridMortgage.add(lblMortResults, 10, 2);

        //Setting labels to get outputs

        Label lblMortOutMP = new Label("\tMonthly Payment");
        lblMortOutMP.setFont(Font.font(20));
        lblMortOutMP.setTextFill(Color.web("white"));
        gridMortgage.add(lblMortOutMP, 10, 3);
        Label lblMortOutMonthlyPayment = new Label();
        lblMortOutMonthlyPayment.setFont(Font.font(18));
        gridMortgage.add(lblMortOutMonthlyPayment, 12, 3);

        Label lblMortOutHP = new Label("\tHome Price");
        lblMortOutHP.setFont(Font.font(20));
        lblMortOutHP.setTextFill(Color.web("white"));
        gridMortgage.add(lblMortOutHP, 10, 4);
        Label lblMortOutHomePrice = new Label();
        lblMortOutHomePrice.setFont(Font.font(18));
        gridMortgage.add(lblMortOutHomePrice, 12, 4);

        Label lblMortOutLA = new Label("\tLoan Amount");
        lblMortOutLA.setFont(Font.font(20));
        lblMortOutLA.setTextFill(Color.web("white"));
        gridMortgage.add(lblMortOutLA, 10, 5);
        Label lblMortOutLoanAmount = new Label();
        lblMortOutLoanAmount.setFont(Font.font(18));
        gridMortgage.add(lblMortOutLoanAmount, 12, 5);

        Label lblMortOutIRate = new Label("\tInterest Rate");
        lblMortOutIRate.setFont(Font.font(20));
        lblMortOutIRate.setTextFill(Color.web("white"));
        gridMortgage.add(lblMortOutIRate, 10, 6);
        Label lblMortOutInterestRate = new Label();
        lblMortOutInterestRate.setFont(Font.font(18));
        gridMortgage.add(lblMortOutInterestRate, 12, 6);


        Label lblMortOutTime = new Label("\tTime Period");
        lblMortOutTime.setFont(Font.font(20));
        lblMortOutTime.setTextFill(Color.web("white"));
        gridMortgage.add(lblMortOutTime, 10, 7);
        Label lblMortOutTimePeriod = new Label();
        lblMortOutTimePeriod.setFont(Font.font(18));
        gridMortgage.add(lblMortOutTimePeriod, 12, 7);

        //mortgage help button
        Button btnMortHelp = new Button("Help");
        btnMortHelp.setFont(Font.font(22));
        btnMortHelp.setTextFill(Color.web("white"));
        btnMortHelp.setStyle("-fx-background-color:#32CD32");
        gridMortgage.add(btnMortHelp, 12, 1);
        btnMortHelp.setOnAction(e -> MortgageHelpView.displayMortgageHelp());


        ///////////////////////////////////// Mortgage Keyboard /////////////////////////////////////////////////////
        // creating buttons for the keyboard

        // button num 01 with its' stylings
        Button btnMortNum1 = new Button("1");
        btnMortNum1.setFont(Font.font(20));
        btnMortNum1.setTextFill(Color.web("white"));
        btnMortNum1.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortNum1, 5, 3);
        // handle a set on action to input text feilds
        btnMortNum1.setFocusTraversable(false);
        btnMortNum1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "1";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 2 with its' stylings
        Button btnMortNum2 = new Button("2");
        btnMortNum2.setFont(Font.font(20));
        btnMortNum2.setTextFill(Color.web("white"));
        btnMortNum2.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortNum2, 7, 3);
        // handle a set on action to input text feilds
        btnMortNum2.setFocusTraversable(false);
        btnMortNum2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "2";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 03 with its' stylings
        Button btnMortNum3 = new Button("3");
        btnMortNum3.setFont(Font.font(20));
        btnMortNum3.setTextFill(Color.web("white"));
        btnMortNum3.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortNum3, 9, 3);
        // handle a set on action to input text feilds
        btnMortNum3.setFocusTraversable(false);
        btnMortNum3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "3";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 04 with its' stylings
        Button btnMortNum4 = new Button("4");
        btnMortNum4.setFont(Font.font(20));
        btnMortNum4.setTextFill(Color.web("white"));
        btnMortNum4.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortNum4, 5, 4);
        // handle a set on action to input text fields
        btnMortNum4.setFocusTraversable(false);
        btnMortNum4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "4";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 05 with its' stylings
        Button btnMortNum5 = new Button("5");
        btnMortNum5.setFont(Font.font(20));
        btnMortNum5.setTextFill(Color.web("white"));
        btnMortNum5.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortNum5, 7, 4);
        // handle a set on action to input text fields
        btnMortNum5.setFocusTraversable(false);
        btnMortNum5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "5";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 06 with its' stylings
        Button btnMortNum6 = new Button("6");
        btnMortNum6.setFont(Font.font(20));
        btnMortNum6.setTextFill(Color.web("white"));
        btnMortNum6.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortNum6, 9, 4);
        // handle a set on action to input text fields
        btnMortNum6.setFocusTraversable(false);
        btnMortNum6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "6";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 07 with its' stylings
        Button btnMortNum7 = new Button("7");
        btnMortNum7.setFont(Font.font(20));
        btnMortNum7.setTextFill(Color.web("white"));
        btnMortNum7.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortNum7, 5, 5);
        // handle a set on action to input text fields
        btnMortNum7.setFocusTraversable(false);
        btnMortNum7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "7";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 08 with its' stylings
        Button btnMortNum8 = new Button("8");
        btnMortNum8.setFont(Font.font(20));
        btnMortNum8.setTextFill(Color.web("white"));
        btnMortNum8.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortNum8, 7, 5);
        // handle a set on action to input text fields
        btnMortNum8.setFocusTraversable(false);
        btnMortNum8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "8";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 09 with its' stylings
        Button btnMortNum9 = new Button("9");
        btnMortNum9.setFont(Font.font(20));
        btnMortNum9.setTextFill(Color.web("white"));
        btnMortNum9.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortNum9, 9, 5);
        // handle a set on action to input text fields
        btnMortNum9.setFocusTraversable(false);
        btnMortNum9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "9";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });

        // button backspace delete with its' stylings
        Button btnMortCalBack = new Button("<");
        btnMortCalBack.setFont(Font.font(20));
        btnMortCalBack.setTextFill(Color.web("white"));
        btnMortCalBack.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortCalBack, 5, 6);
        // handle a set on action to clear text fields
        btnMortCalBack.setFocusTraversable(false);
        btnMortCalBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.clear();
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.clear();
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.clear();
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.clear();
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.clear();
                }
            }
        });


        // button no zero with its' stylings
        Button btnMortDot = new Button(".");
        btnMortDot.setFont(Font.font(20));
        btnMortDot.setMaxWidth(1000);
        btnMortDot.setMaxHeight(300);
        btnMortDot.setTextFill(Color.web("white"));
        btnMortDot.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortDot, 7, 6);
        // handle a set on action to imput text fields
        btnMortDot.setFocusTraversable(false);
        btnMortDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = ".";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });

        // button decimal point with its' stylings
        Button btnMortNum0 = new Button("0");
        btnMortNum0.setFont(Font.font(20));
        btnMortNum0.setTextFill(Color.web("white"));
        btnMortNum0.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridMortgage.add(btnMortNum0, 9, 6);
        // handle a set on action to imput text fields
        btnMortNum0.setFocusTraversable(false);
        btnMortNum0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "0";
                if (tfMortIHP.isFocused()) {
                    tfMortIHP.setText(tfMortIHP.getText() + keyboardBtnVal);
                } else if (tfMortIDP.isFocused()) {
                    tfMortIDP.setText(tfMortIDP.getText() + keyboardBtnVal);
                } else if (tfMortILT.isFocused()) {
                    tfMortILT.setText(tfMortILT.getText() + keyboardBtnVal);
                } else if (tfMortIIR.isFocused()) {
                    tfMortIIR.setText(tfMortIIR.getText() + keyboardBtnVal);
                } else if (tfMortIPMT.isFocused()) {
                    tfMortIPMT.setText(tfMortIPMT.getText() + keyboardBtnVal);
                }
            }
        });


        // adjest size of the mortgage scene
        sceneMortgage = new Scene(gridMortgage, 1200, 550);


        /////////////////////////////////////////////// Simple Savings Scene ////////////////////////////////////////////////

        // takenew grid pane to the new scene
        GridPane gridSimpleSaving = new GridPane();
        gridSimpleSaving.setAlignment(Pos.TOP_CENTER); // position the gridpane to top center
        gridSimpleSaving.setVgap(10);
        gridSimpleSaving.setHgap(10);


        // set padding of the grid
        gridSimpleSaving.setPadding(new Insets(0, 1, 5, 1));
        // set background image to simple saving scene
        backgroundImage = new Image(getClass().getResourceAsStream("money.jpg"));

        backgroundimage = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(backgroundimage);
        gridSimpleSaving.setBackground(background);

        // Set Simple savings scene Title
        Label lblSimTitle = new Label("Simple Savings Calculator");
        lblSimTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        lblSimTitle.setTextFill(Color.web("white"));
        gridSimpleSaving.add(lblSimTitle, 1, 1);

        //Left side input textfields set
        Label lblSimInSprincipal = new Label("\tStart Principal");
        lblSimInSprincipal.setFont(Font.font(20));
        lblSimInSprincipal.setTextFill(Color.web("white"));
        gridSimpleSaving.add(lblSimInSprincipal, 1, 3);
        TextField tfSimIsPrincipal = new TextField();
        tfSimIsPrincipal.setPromptText("Rs.");
        tfSimIsPrincipal.setFont(Font.font(18));
        gridSimpleSaving.add(tfSimIsPrincipal, 3, 3);

        Label lblSimInIrate = new Label("\tInterest Rate");
        lblSimInIrate.setFont(Font.font(20));
        lblSimInIrate.setTextFill(Color.web("white"));
        gridSimpleSaving.add(lblSimInIrate, 1, 4);
        TextField tfSimIiRate = new TextField();
        tfSimIiRate.setPromptText("%");
        tfSimIiRate.setFont(Font.font(18));
        gridSimpleSaving.add(tfSimIiRate, 3, 4);

        Label lblSimIFV = new Label("\tFuture Value");
        lblSimIFV.setFont(Font.font(20));
        lblSimIFV.setTextFill(Color.web("white"));
        gridSimpleSaving.add(lblSimIFV, 1, 5);
        TextField tfSimIFV = new TextField();
        tfSimIFV.setPromptText("Rs.");
        tfSimIFV.setFont(Font.font(18));
        gridSimpleSaving.add(tfSimIFV, 3, 5);

        Label lblSimTimeYears = new Label("\tTime period");
        lblSimTimeYears.setFont(Font.font(20));
        lblSimTimeYears.setTextFill(Color.web("white"));
        gridSimpleSaving.add(lblSimTimeYears, 1, 6);
        TextField tfSimInTime = new TextField();
        tfSimInTime.setPromptText("Years");
        tfSimInTime.setFont(Font.font(18));
        gridSimpleSaving.add(tfSimInTime, 3, 6);

        Label lblSolveFor = new Label("\tSolve For");
        lblSolveFor.setFont(Font.font(20));
        lblSolveFor.setTextFill(Color.web("white"));
        gridSimpleSaving.add(lblSolveFor, 1, 7);
        ChoiceBox<String> SimchoiceBox = new ChoiceBox<>();

        //get items returns the observable list object which you can add items to
        SimchoiceBox.getItems().add("Future Value");
        SimchoiceBox.getItems().add("Present Value");
        SimchoiceBox.getItems().add("Invested period");
        SimchoiceBox.getItems().add("Interest Rate");
        gridSimpleSaving.add(SimchoiceBox, 3, 7);


        //Set calculate button
        Button btnSimCalculate = new Button("Calculate > ");
        btnSimCalculate.setFont(Font.font(22));
        btnSimCalculate.setStyle("-fx-background-color: red");
        btnSimCalculate.setTextFill(Color.web("white"));
        gridSimpleSaving.add(btnSimCalculate, 1, 10);

        //Set back button
        Button btnSavingBack = new Button("Back");
        btnSavingBack.setFont(Font.font(22));
        btnSavingBack.setStyle("-fx-background-color: blue");
        btnSavingBack.setTextFill(Color.web("white"));
        gridSimpleSaving.add(btnSavingBack, 12, 10);
        // set on click action to go back main page
        btnSavingBack.setOnAction(event -> window.setScene(sceneMainPage));

        // simple savings file button
        Button btnSavingFile = new Button("File");
        btnSavingFile.setFont(Font.font(22));
        btnSavingFile.setStyle("-fx-background-color:  #ADD8E6");
        gridSimpleSaving.add(btnSavingFile, 11, 1);

        // simple savings help button
        Button btnSavingHelp = new Button("Help");
        btnSavingHelp.setFont(Font.font(20));
        btnSavingHelp.setTextFill(Color.web("white"));
        btnSavingHelp.setStyle("-fx-background-color:#32CD32");
        gridSimpleSaving.add(btnSavingHelp, 12, 1);
        btnSavingHelp.setOnAction(e -> SimpleSavingHelpView.displaySavingHelp());


        ///////////////////////////////////// Simple Savings Keyboard /////////////////////////////////////////////////////
        // creating buttons for the keyboard

        // button num 01 with its' stylings
        Button btnSavNum1 = new Button("1");
        btnSavNum1.setFont(Font.font(24));
        btnSavNum1.setMaxWidth(300);
        btnSavNum1.setMaxHeight(300);
        btnSavNum1.setTextFill(Color.web("white"));
        btnSavNum1.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        // handle a set on action to input text feilds
        gridSimpleSaving.add(btnSavNum1, 5, 3);
        btnSavNum1.setFocusTraversable(false);
        btnSavNum1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "1";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfSimInTime.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 2 with its' stylings
        Button btnSavNum2 = new Button("2");
        btnSavNum2.setFont(Font.font(20));
        btnSavNum2.setTextFill(Color.web("white"));
        btnSavNum2.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavNum2, 7, 3);
        // handle a set on action to input text feilds
        btnSavNum2.setFocusTraversable(false);
        btnSavNum2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "2";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfSimInTime.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 03 with its' stylings
        Button btnSavNum3 = new Button("3");
        btnSavNum3.setFont(Font.font(20));
        btnSavNum3.setTextFill(Color.web("white"));
        btnSavNum3.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavNum3, 9, 3);
        // handle a set on action to input text feilds
        btnSavNum3.setFocusTraversable(false);
        btnSavNum3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "3";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfSimInTime.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 04 with its' stylings
        Button btnSavNum4 = new Button("4");
        btnSavNum4.setFont(Font.font(20));
        btnSavNum4.setTextFill(Color.web("white"));
        btnSavNum4.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavNum4, 5, 4);
        // handle a set on action to input text fields
        btnSavNum4.setFocusTraversable(false);
        btnSavNum4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "4";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfSimInTime.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 05 with its' stylings
        Button btnSavNum5 = new Button("5");
        btnSavNum5.setFont(Font.font(20));
        btnSavNum5.setTextFill(Color.web("white"));
        btnSavNum5.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavNum5, 7, 4);
        // handle a set on action to input text fields
        btnSavNum5.setFocusTraversable(false);
        btnSavNum5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "5";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfSimInTime.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 06 with its' stylings
        Button btnSavNum6 = new Button("6");
        btnSavNum6.setFont(Font.font(20));
        btnSavNum6.setTextFill(Color.web("white"));
        btnSavNum6.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavNum6, 9, 4);
        // handle a set on action to input text fields
        btnSavNum6.setFocusTraversable(false);
        btnSavNum6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "6";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfSimInTime.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 07 with its' stylings
        Button btnSavNum7 = new Button("7");
        btnSavNum7.setFont(Font.font(20));
        btnSavNum7.setTextFill(Color.web("white"));
        btnSavNum7.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavNum7, 5, 5);
        // handle a set on action to input text fields
        btnSavNum7.setFocusTraversable(false);
        btnSavNum7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "7";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfSimInTime.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 08 with its' stylings
        Button btnSavNum8 = new Button("8");
        btnSavNum8.setFont(Font.font(20));
        btnSavNum8.setTextFill(Color.web("white"));
        btnSavNum8.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavNum8, 7, 5);
        // handle a set on action to input text fields
        btnSavNum8.setFocusTraversable(false);
        btnSavNum8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "8";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfSimInTime.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 09 with its' stylings
        Button btnSavNum9 = new Button("9");
        btnSavNum9.setFont(Font.font(20));
        btnSavNum9.setTextFill(Color.web("white"));
        btnSavNum9.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavNum9, 9, 5);
        // handle a set on action to input text fields
        btnSavNum9.setFocusTraversable(false);
        btnSavNum9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "9";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfMortIIR.getText() + keyboardBtnVal);
                }
            }
        });

        // button backspace delete with its' stylings
        Button btnSavCalBack = new Button("<");
        btnSavCalBack.setFont(Font.font(20));
        btnSavCalBack.setTextFill(Color.web("white"));
        btnSavCalBack.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavCalBack, 5, 6);
        // handle a set on action to clear text fields
        btnSavCalBack.setFocusTraversable(false);
        btnSavCalBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.clear();
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.clear();
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.clear();
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.clear();
                }
            }
        });

        // button decimal point with its' stylings
        Button btnSavDot = new Button(".");
        btnSavDot.setFont(Font.font(20));
        btnSavDot.setMaxWidth(1000);
        btnSavDot.setMaxHeight(300);
        btnSavDot.setTextFill(Color.web("white"));
        btnSavDot.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavDot, 9, 6);
        // handle a set on action to imput text fields
        btnSavDot.setFocusTraversable(false);
        btnSavDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = ".";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfSimInTime.getText() + keyboardBtnVal);
                }
            }
        });

        // button no zero with its' stylings
        Button btnSavNum0 = new Button("0");
        btnSavNum0.setFont(Font.font(20));
        btnSavNum0.setTextFill(Color.web("white"));
        btnSavNum0.setStyle("-fx-background-color:#964B00;-fx-border-color: white; -fx-border-width: 5px;");
        gridSimpleSaving.add(btnSavNum0, 7, 6);
        // handle a set on action to imput text fields
        btnSavNum0.setFocusTraversable(false);
        btnSavNum0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "0";
                if (tfSimIsPrincipal.isFocused()) {
                    tfSimIsPrincipal.setText(tfSimIsPrincipal.getText() + keyboardBtnVal);
                } else if (tfSimIiRate.isFocused()) {
                    tfSimIiRate.setText(tfSimIiRate.getText() + keyboardBtnVal);
                } else if (tfSimIFV.isFocused()) {
                    tfSimIFV.setText(tfSimIFV.getText() + keyboardBtnVal);
                } else if (tfSimInTime.isFocused()) {
                    tfSimInTime.setText(tfSimInTime.getText() + keyboardBtnVal);
                }
            }
        });


        // adjest size of the mortgage scene
        sceneSimpleSavings = new Scene(gridSimpleSaving, 1000, 550);


        /////////////////////////////////////// Loans Scene ////////////////////////////////////////

        // set a grid pane to the new scene
        GridPane gridLoans = new GridPane();
        gridLoans.setAlignment(Pos.TOP_LEFT);
        gridLoans.setVgap(10);
        gridLoans.setHgap(10);

        // set padding of the grid
        gridLoans.setPadding(new Insets(0, 1, 5, 1));

        // add an image as background
        backgroundImage = new Image(getClass().getResourceAsStream("back03.jpg"));
        backgroundimage = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(backgroundimage);
        gridLoans.setBackground(background);

        // Set Loan scene Title
        Label lblLoanTitle = new Label("Loan Calculator");
        lblLoanTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        lblLoanTitle.setStyle("-fx-text-fill:#00008B");
        gridLoans.add(lblLoanTitle, 1, 1);


        //Left side input textfields set
        Label lblLoanAmount = new Label("Loan Amount");
        lblLoanAmount.setFont(Font.font(18));
        gridLoans.add(lblLoanAmount, 1, 3);
        TextField tfLoanAmount = new TextField();
        tfLoanAmount.setPromptText("Rs.");
        tfLoanAmount.setFont(Font.font(18));
        gridLoans.add(tfLoanAmount, 3, 3);

        Label lblLoanTerm = new Label("Loan Term");
        lblLoanTerm.setFont(Font.font(18));
        gridLoans.add(lblLoanTerm, 1, 4);
        TextField tfLoanTerm = new TextField();
        tfLoanTerm.setPromptText("years");
        tfLoanTerm.setFont(Font.font(18));
        gridLoans.add(tfLoanTerm, 3, 4);

        Label lblLoanIntRate = new Label("Yearly Interest Rate");
        lblLoanIntRate.setFont(Font.font(18));
        gridLoans.add(lblLoanIntRate, 1, 5);
        TextField tfLoanIntRate = new TextField();
        tfLoanIntRate.setPromptText("%");
        tfLoanIntRate.setFont(Font.font(18));
        gridLoans.add(tfLoanIntRate, 3, 5);

        Label lblLoanDownPay = new Label("Down Payment");
        lblLoanDownPay.setFont(Font.font(18));
        gridLoans.add(lblLoanDownPay, 1, 6);
        TextField tfLoanDPay = new TextField();
        tfLoanDPay.setPromptText("Rs. ");
        tfLoanDPay.setFont(Font.font(18));
        gridLoans.add(tfLoanDPay, 3, 6);

        Label lblLoanMonthlyPay = new Label("Monthly Payment");
        lblLoanMonthlyPay.setFont(Font.font(18));
        gridLoans.add(lblLoanMonthlyPay, 1, 7);
        TextField tfLoanMonthlyPay = new TextField();
        tfLoanMonthlyPay.setPromptText("Rs. ");
        tfLoanMonthlyPay.setFont(Font.font(18));
        gridLoans.add(tfLoanMonthlyPay, 3, 7);

        Label lblLoanSolveFor = new Label("Solve For");
        lblLoanSolveFor.setFont(Font.font(18));
        gridLoans.add(lblLoanSolveFor, 1, 8);
        ChoiceBox<String> LoanchoiceBox = new ChoiceBox<>();
        //get items returns the observable list object which you can add items to
        LoanchoiceBox.getItems().add("Loan Period");
        LoanchoiceBox.getItems().add("Monthly Payment");
        LoanchoiceBox.getItems().add("Present Value");
        //LoanchoiceBox.setFont(Font.font(16));
        gridLoans.add(LoanchoiceBox, 3, 8);

        // file button of loan scene
        Button btnLoanFile = new Button("File");
        btnLoanFile.setFont(Font.font(22));
        btnLoanFile.setStyle("-fx-background-color:  #ADD8E6");
        gridLoans.add(btnLoanFile, 13, 1);


        //Set calculate button
        Button btnLoanCalculate = new Button("Calculate > ");
        btnLoanCalculate.setFont(Font.font(22));
        btnLoanCalculate.setStyle("-fx-background-color: red");
        btnLoanCalculate.setTextFill(Color.web("white"));
        gridLoans.add(btnLoanCalculate, 1, 10);

        //Set back button
        Button btnLoanBack = new Button("Back");
        btnLoanBack.setFont(Font.font(22));
        btnLoanBack.setStyle("-fx-background-color: blue");
        btnLoanBack.setTextFill(Color.web("white"));
        gridLoans.add(btnLoanBack, 13, 10);
        // set on action to back main page
        btnLoanBack.setOnAction(event -> window.setScene(sceneMainPage));

        //Results Title label
        Label lblLoanResults = new Label("\tResults....");
        lblLoanResults.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridLoans.add(lblLoanResults, 10, 2);

        //Setting labels to get outputs
        Label lblLoanOutPMT = new Label("\tMonthly Payment");
        lblLoanOutPMT.setFont(Font.font(18));
        gridLoans.add(lblLoanOutPMT, 10, 3);
        Label lblLoanOutputPMT = new Label();
        lblLoanOutputPMT.setFont(Font.font(18));
        lblLoanOutputPMT.setStyle("-fx-text-fill:#00008B");
        gridLoans.add(lblLoanOutputPMT, 12, 3);

        Label lblLoanOutAmount = new Label("\tLoan Amount");
        lblLoanOutAmount.setFont(Font.font(18));
        gridLoans.add(lblLoanOutAmount, 10, 4);
        Label lblLoanOutputAmount = new Label();
        lblLoanOutputAmount.setFont(Font.font(18));
        lblLoanOutputAmount.setStyle("-fx-text-fill:#00008B");
        gridLoans.add(lblLoanOutputAmount, 12, 4);

        Label lblLoanTotal = new Label("\tTotal Loan Amount");
        lblLoanTotal.setFont(Font.font(18));
        gridLoans.add(lblLoanTotal, 10, 5);
        Label lblLoanOutTotal = new Label();
        lblLoanOutTotal.setFont(Font.font(18));
        lblLoanOutTotal.setStyle("-fx-text-fill:#00008B");
        gridLoans.add(lblLoanOutTotal, 12, 5);

        Label lblLoanPeriod = new Label("\tLoan Period");
        lblLoanPeriod.setFont(Font.font(18));
        gridLoans.add(lblLoanPeriod, 10, 6);
        Label lblLoanOutPeriod = new Label();
        lblLoanOutPeriod.setFont(Font.font(18));
        lblLoanOutPeriod.setStyle("-fx-text-fill:#00008B");
        gridLoans.add(lblLoanOutPeriod, 12, 6);

        Button btnLoanHelp = new Button("Help");
        btnLoanHelp.setFont(Font.font(22));
        btnLoanHelp.setTextFill(Color.web("white"));
        btnLoanHelp.setStyle("-fx-background-color:#32CD32");
        gridLoans.add(btnLoanHelp, 14, 1);
        btnLoanHelp.setOnAction(e -> LoansHelpView.displayLoanHelp());

        ///////////////////////////////////////////////// Loan Keyboard //////////////////////////////////////

        // creating buttons for the keyboard

        // button num 01 with its' stylings
        Button btnLoanNum1 = new Button("1");
        btnLoanNum1.setFont(Font.font(20));
        btnLoanNum1.setTextFill(Color.web("white"));
        btnLoanNum1.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanNum1, 5, 3);
        // handle a set on action to input text feilds
        btnLoanNum1.setFocusTraversable(false);
        btnLoanNum1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "1";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 2 with its' stylings
        Button btnLoanNum2 = new Button("2");
        btnLoanNum2.setFont(Font.font(20));
        btnLoanNum2.setTextFill(Color.web("white"));
        btnLoanNum2.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanNum2, 7, 3);
        // handle a set on action to input text feilds
        btnLoanNum2.setFocusTraversable(false);
        btnLoanNum2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "2";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 03 with its' stylings
        Button btnLoanNum3 = new Button("3");
        btnLoanNum3.setFont(Font.font(20));
        btnLoanNum3.setTextFill(Color.web("white"));
        btnLoanNum3.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanNum3, 9, 3);
        // handle a set on action to input text feilds
        btnLoanNum3.setFocusTraversable(false);
        btnLoanNum3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "3";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 04 with its' stylings
        Button btnLoanNum4 = new Button("4");
        btnLoanNum4.setFont(Font.font(20));
        btnLoanNum4.setTextFill(Color.web("white"));
        btnLoanNum4.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanNum4, 5, 4);
        btnLoanNum4.setFocusTraversable(false);
        btnLoanNum4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "4";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 05 with its' stylings
        Button btnLoanNum5 = new Button("5");
        btnLoanNum5.setFont(Font.font(20));
        btnLoanNum5.setTextFill(Color.web("white"));
        btnLoanNum5.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanNum5, 7, 4);
        // handle a set on action to input text fields
        btnLoanNum5.setFocusTraversable(false);
        btnLoanNum5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "5";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 06 with its' stylings
        Button btnLoanNum6 = new Button("6");
        btnLoanNum6.setFont(Font.font(20));
        btnLoanNum6.setTextFill(Color.web("white"));
        btnLoanNum6.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanNum6, 9, 4);
        // handle a set on action to input text fields
        btnLoanNum6.setFocusTraversable(false);
        btnLoanNum6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "6";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 07 with its' stylings
        Button btnLoanNum7 = new Button("7");
        btnLoanNum7.setFont(Font.font(20));
        btnLoanNum7.setTextFill(Color.web("white"));
        btnLoanNum7.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanNum7, 5, 5);
        // handle a set on action to input text fields
        btnLoanNum7.setFocusTraversable(false);
        btnLoanNum7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "7";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 08 with its' stylings
        Button btnLoanNum8 = new Button("8");
        btnLoanNum8.setFont(Font.font(20));
        btnLoanNum8.setTextFill(Color.web("white"));
        btnLoanNum8.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanNum8, 7, 5);
        // handle a set on action to input text fields
        btnLoanNum8.setFocusTraversable(false);
        btnLoanNum8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "8";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 09 with its' stylings
        Button btnLoanNum9 = new Button("9");
        btnLoanNum9.setFont(Font.font(20));
        btnLoanNum9.setTextFill(Color.web("white"));
        btnLoanNum9.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanNum9, 9, 5);
        // handle a set on action to input text fields
        btnLoanNum9.setFocusTraversable(false);
        btnLoanNum9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "9";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button backspace delete with its' stylings
        Button btnLoanCalBack = new Button("<");
        btnLoanCalBack.setFont(Font.font(20));
        btnLoanCalBack.setTextFill(Color.web("white"));
        btnLoanCalBack.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanCalBack, 5, 6);
        // handle a set on action to clear text fields
        btnLoanCalBack.setFocusTraversable(false);
        btnLoanCalBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.clear();
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.clear();
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.clear();
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.clear();
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.clear();
                }
            }
        });

        // button no zero with its' stylings
        Button btnLoanNum0 = new Button("0");
        btnLoanNum0.setFont(Font.font(20));
        btnLoanNum0.setTextFill(Color.web("white"));
        btnLoanNum0.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanNum0, 7, 6);
        // handle a set on action to imput text fields
        btnLoanNum0.setFocusTraversable(false);
        btnLoanNum0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "0";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button decimal point with its' stylings
        Button btnLoanDot = new Button(".");
        btnLoanDot.setFont(Font.font(20));
        btnLoanDot.setTextFill(Color.web("white"));
        btnLoanDot.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridLoans.add(btnLoanDot, 9, 6);
        // handle a set on action to imput text fields
        btnLoanDot.setFocusTraversable(false);
        btnLoanDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = ".";
                if (tfLoanAmount.isFocused()) {
                    tfLoanAmount.setText(tfLoanAmount.getText() + keyboardBtnVal);
                } else if (tfLoanTerm.isFocused()) {
                    tfLoanTerm.setText(tfLoanTerm.getText() + keyboardBtnVal);
                } else if (tfLoanIntRate.isFocused()) {
                    tfLoanIntRate.setText(tfLoanIntRate.getText() + keyboardBtnVal);
                } else if (tfLoanDPay.isFocused()) {
                    tfLoanDPay.setText(tfLoanDPay.getText() + keyboardBtnVal);
                } else if (tfLoanMonthlyPay.isFocused()) {
                    tfLoanMonthlyPay.setText(tfLoanMonthlyPay.getText() + keyboardBtnVal);
                }
            }
        });


        // adjest size of the loan scene
        sceneLoans = new Scene(gridLoans, 1200, 700);

        /////////////////////////////////////////// Compound Savings Scene//////////////////////////////////////


        // set a grid pane to the new scene
        GridPane gridCompoundSaving = new GridPane();
        gridCompoundSaving.setAlignment(Pos.TOP_LEFT);
        gridCompoundSaving.setVgap(10);
        gridCompoundSaving.setHgap(10);

        // set padding of the grid
        gridCompoundSaving.setPadding(new Insets(0, 1, 5, 1));
        // add an image as background
        backgroundImage = new Image(getClass().getResourceAsStream("sav01.jpg"));

        backgroundimage = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(backgroundimage);
        gridCompoundSaving.setBackground(background);

        Label lblCompTitle = new Label("Compound Savings Calculator");
        lblCompTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        lblCompTitle.setStyle("-fx-text-fill: #000080");
        gridCompoundSaving.add(lblCompTitle, 1, 1);

        //Left side input textfields set
        Label lblCompPrincipal = new Label("Principal Investment");
        lblCompPrincipal.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompPrincipal, 1, 3);
        TextField tfCompInPrincipal = new TextField();
        tfCompInPrincipal.setPromptText("Rs.");
        tfCompInPrincipal.setFont(Font.font(18));
        gridCompoundSaving.add(tfCompInPrincipal, 3, 3);

        Label lblCompInIR = new Label("Interest Rate");
        lblCompInIR.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompInIR, 1, 4);
        TextField tfCompInIR = new TextField();
        tfCompInIR.setPromptText("%");
        tfCompInIR.setFont(Font.font(18));
        gridCompoundSaving.add(tfCompInIR, 3, 4);

        Label lblCompInFV = new Label("Future Value");
        lblCompInFV.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompInFV, 1, 5);
        TextField tfCompInFV = new TextField();
        tfCompInFV.setPromptText("Rs.");
        tfCompInFV.setFont(Font.font(18));
        gridCompoundSaving.add(tfCompInFV, 3, 5);

        Label lblCompTimeYears = new Label("Time period");
        lblCompTimeYears.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompTimeYears, 1, 6);
        TextField tfCompInTime = new TextField();
        tfCompInTime.setPromptText("Years");
        tfCompInTime.setFont(Font.font(18));
        gridCompoundSaving.add(tfCompInTime, 3, 6);

        Label lblCompInMonthlyPay = new Label("Payment");
        lblCompInMonthlyPay.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompInMonthlyPay, 1, 7);
        TextField tfCompInMonthPay = new TextField();
        tfCompInMonthPay.setPromptText("Rs.");
        tfCompInMonthPay.setFont(Font.font(18));
        gridCompoundSaving.add(tfCompInMonthPay, 3, 7);

        Label lblCompSolveFor = new Label("Solve For");
        lblCompSolveFor.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompSolveFor, 1, 8);
        ChoiceBox<String> CompchoiceBox = new ChoiceBox<>();

        //get items returns the observable list object which you can add items to
        CompchoiceBox.getItems().add("Future Value");
        CompchoiceBox.getItems().add("Monthly Payment");
        CompchoiceBox.getItems().add("Present Value");
        CompchoiceBox.getItems().add("Invested Period");
        gridCompoundSaving.add(CompchoiceBox, 3, 8);


        //Set calculate button
        Button btnCompCalculate = new Button("Calculate > ");
        btnCompCalculate.setFont(Font.font(22));
        btnCompCalculate.setStyle("-fx-background-color: red");
        btnCompCalculate.setTextFill(Color.web("white"));
        gridCompoundSaving.add(btnCompCalculate, 1, 10);

        //Set back button
        Button btnCompBack = new Button("Back");
        btnCompBack.setFont(Font.font(22));
        btnCompBack.setStyle("-fx-background-color: blue");
        btnCompBack.setTextFill(Color.web("white"));
        gridCompoundSaving.add(btnCompBack, 13, 10);
        btnCompBack.setOnAction(event -> window.setScene(sceneMainPage));

        //Results Title label
        Label lblCompResults = new Label("\tResults....");
        lblCompResults.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        gridCompoundSaving.add(lblCompResults, 10, 2);

        //Setting labels to get outputs
        Label lblCompOutMonthPay = new Label("\tMonthly Payment");
        lblCompOutMonthPay.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompOutMonthPay, 10, 3);
        Label lblCompOutputMonthPay = new Label();
        lblCompOutputMonthPay.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompOutputMonthPay, 12, 3);

        Label lblCompOutFV = new Label("\tFuture Value");
        lblCompOutFV.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompOutFV, 10, 4);
        Label lblCompOutputFV = new Label();
        lblCompOutputFV.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompOutputFV, 12, 4);

        Label lblCompPV = new Label("\tPresent Value");
        lblCompPV.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompPV, 10, 5);
        Label lblOutCompPV = new Label();
        lblOutCompPV.setFont(Font.font(20));
        gridCompoundSaving.add(lblOutCompPV, 12, 5);

        Label lblCompOutTime = new Label("\tTime Period");
        lblCompOutTime.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompOutTime, 10, 6);
        Label lblCompOutputTime = new Label();
        lblCompOutputTime.setFont(Font.font(20));
        gridCompoundSaving.add(lblCompOutputTime, 12, 6);


        Button btnCompFile = new Button("File");
        btnCompFile.setFont(Font.font(22));
        btnCompFile.setStyle("-fx-background-color:  #ADD8E6");
        gridCompoundSaving.add(btnCompFile, 11, 1);

        Button btnCompHelp = new Button("Help");
        btnCompHelp.setFont(Font.font(22));
        btnCompHelp.setTextFill(Color.web("white"));
        btnCompHelp.setStyle("-fx-background-color:#32CD32");
        gridCompoundSaving.add(btnCompHelp, 12, 1);
        // set on action to back main page
        btnCompHelp.setOnAction(e -> CompoundSavingHelpView.displayCompHelp());


        ///////////////////////////////// Compound savings keyboard ////////////////////////////////

        // creating buttons for the keyboard

        // button num 01 with its' stylings
        Button btnCompNum1 = new Button("1");
        btnCompNum1.setFont(Font.font(20));
        btnCompNum1.setTextFill(Color.web("white"));
        btnCompNum1.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridCompoundSaving.add(btnCompNum1, 5, 3);
        // handle a set on action to input text feilds
        btnCompNum1.setFocusTraversable(false);
        btnCompNum1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "1";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 2 with its' stylings
        Button btnCompNum2 = new Button("2");
        btnCompNum2.setFont(Font.font(20));
        btnCompNum2.setTextFill(Color.web("white"));
        btnCompNum2.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridCompoundSaving.add(btnCompNum2, 7, 3);
        // handle a set on action to input text feilds
        btnCompNum2.setFocusTraversable(false);
        btnCompNum2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "2";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 03 with its' stylings
        Button btnCompNum3 = new Button("3");
        btnCompNum3.setFont(Font.font(20));
        gridCompoundSaving.add(btnCompNum3, 9, 3);
        btnCompNum3.setTextFill(Color.web("white"));
        btnCompNum3.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        // handle a set on action to input text feilds
        btnCompNum3.setFocusTraversable(false);
        btnCompNum3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "3";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 04 with its' stylings
        Button btnCompNum4 = new Button("4");
        btnCompNum4.setFont(Font.font(20));
        btnCompNum4.setTextFill(Color.web("white"));
        btnCompNum4.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridCompoundSaving.add(btnCompNum4, 5, 4);
        // handle a set on action to input text fields
        btnCompNum4.setFocusTraversable(false);
        btnCompNum4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "4";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 05 with its' stylings
        Button btnCompNum5 = new Button("5");
        btnCompNum5.setFont(Font.font(20));
        btnCompNum5.setTextFill(Color.web("white"));
        btnCompNum5.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridCompoundSaving.add(btnCompNum5, 7, 4);
        // handle a set on action to input text fields
        btnCompNum5.setFocusTraversable(false);
        btnCompNum5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "5";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 06 with its' stylings
        Button btnCompNum6 = new Button("6");
        btnCompNum6.setFont(Font.font(20));
        gridCompoundSaving.add(btnCompNum6, 9, 4);
        btnCompNum6.setTextFill(Color.web("white"));
        btnCompNum6.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        // handle a set on action to input text fields
        btnCompNum6.setFocusTraversable(false);
        btnCompNum6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "6";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 07 with its' stylings
        Button btnCompNum7 = new Button("7");
        btnCompNum7.setFont(Font.font(20));
        btnCompNum7.setTextFill(Color.web("white"));
        btnCompNum7.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridCompoundSaving.add(btnCompNum7, 5, 5);
        // handle a set on action to input text fields
        btnCompNum7.setFocusTraversable(false);
        btnCompNum7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "7";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 08 with its' stylings
        Button btnCompNum8 = new Button("8");
        btnCompNum8.setFont(Font.font(20));
        btnCompNum8.setTextFill(Color.web("white"));
        btnCompNum8.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridCompoundSaving.add(btnCompNum8, 7, 5);
        // handle a set on action to input text fields
        btnCompNum8.setFocusTraversable(false);
        btnCompNum8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "8";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button num 09 with its' stylings
        Button btnCompNum9 = new Button("9");
        btnCompNum9.setFont(Font.font(20));
        btnCompNum9.setTextFill(Color.web("white"));
        btnCompNum9.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridCompoundSaving.add(btnCompNum9, 9, 5);
        // handle a set on action to input text fields
        btnCompNum9.setFocusTraversable(false);
        btnCompNum9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "9";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button backspace delete with its' stylings
        Button btnCompCalBack = new Button("<");
        btnCompCalBack.setFont(Font.font(20));
        btnCompCalBack.setTextFill(Color.web("white"));
        btnCompCalBack.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridCompoundSaving.add(btnCompCalBack, 5, 6);
        // handle a set on action to clear text fields
        btnCompCalBack.setFocusTraversable(false);
        btnCompCalBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.clear();
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.clear();
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.clear();
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.clear();
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.clear();
                }
            }
        });

        // button no zero with its' stylings
        Button btnCompNum0 = new Button("0");
        btnCompNum0.setFont(Font.font(20));
        btnCompNum0.setTextFill(Color.web("white"));
        btnCompNum0.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridCompoundSaving.add(btnCompNum0, 7, 6);
        // handle a set on action to imput text fields
        btnCompNum0.setFocusTraversable(false);
        btnCompNum0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = "0";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });

        // button decimal point with its' stylings
        Button btnCompDot = new Button(".");
        btnCompDot.setFont(Font.font(20));
        btnCompDot.setTextFill(Color.web("white"));
        btnCompDot.setStyle("-fx-background-color:#964B00;-fx-border-color: black; -fx-border-width: 5px;");
        gridCompoundSaving.add(btnCompDot, 9, 6);
        btnCompDot.setFocusTraversable(false);
        btnCompDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyboardBtnVal = ".";
                if (tfCompInPrincipal.isFocused()) {
                    tfCompInPrincipal.setText(tfCompInPrincipal.getText() + keyboardBtnVal);
                } else if (tfCompInIR.isFocused()) {
                    tfCompInIR.setText(tfCompInIR.getText() + keyboardBtnVal);
                } else if (tfCompInFV.isFocused()) {
                    tfCompInFV.setText(tfCompInFV.getText() + keyboardBtnVal);
                } else if (tfCompInTime.isFocused()) {
                    tfCompInTime.setText(tfCompInTime.getText() + keyboardBtnVal);
                } else if (tfCompInMonthPay.isFocused()) {
                    tfCompInMonthPay.setText(tfCompInMonthPay.getText() + keyboardBtnVal);
                }
            }
        });


        // adjest size of the compound saving scene
        sceneCompoundSavings = new Scene(gridCompoundSaving, 1400, 700);

        // close the oped window
        window.setScene(sceneMainPage);
        window.show();

        //********************************************** Calculation part of the calculators ***********************************************///////


        /////////////////////////////////////////////////////////Mortgage Calculations//////////////////////////////////////

        btnMortCalculate.setOnAction(event -> {
            if (MorchoiceBox.getValue() != null) {
                String MorttempString = MorchoiceBox.getSelectionModel().getSelectedItem();

                switch (MorttempString) {
                    //calculate mortgage length of time
                    case "Time Period":
                        double M_HomePrice1 = parseDouble(tfMortIHP.getText());
                        double M_DownPayment1 = parseDouble(tfMortIDP.getText());
                        double M_InterestRate1 = parseDouble(tfMortIIR.getText());
                        double M_PMT1 = parseDouble(tfMortIPMT.getText());

                        // show home price value in Results
                        String M_HP = df.format(M_HomePrice1);
                        lblMortOutHomePrice.setText("Rs. " + M_HP);

                        // show loan amount value in Results
                        double M_LA = M_HomePrice1 - M_DownPayment1;
                        String M_LoanAmount = df.format(M_LA);
                        lblMortOutLoanAmount.setText("Rs. " + M_LoanAmount);

                        // show interest rate in Results
                        String M_IntRate = df.format(M_InterestRate1);
                        lblMortOutInterestRate.setText(M_IntRate + "%");

                        // show monthly payment value in Results
                        String M_MonthPay = df.format(M_PMT1);
                        lblMortOutMonthlyPayment.setText("Rs. " + M_MonthPay);

                        double M_a = (M_InterestRate1 * M_LA) / (M_PMT1 * 1200);
                        double M_b = 1 - M_a;
                        double M_c = Math.log(M_b);

                        double M_d = 1 + (M_InterestRate1 / 1200);
                        double M_e = Math.log(M_d);
                        double M_f = M_e * 12;

                        int M_Time = (int) (M_c / M_f);
                        int M_TimePeriod = Math.abs(M_Time);
                        // show time period value in Results
                        lblMortOutTimePeriod.setText(M_TimePeriod + " year");


                        break;
                    //calculate the mortgage payment
                    case "Monthly Payment":
                        double M_HomePrice2 = parseDouble(tfMortIHP.getText());
                        double M_DownPayment2 = Double.parseDouble(tfMortIDP.getText());
                        int M_LoanTerm2 = Integer.parseInt(tfMortILT.getText());
                        double M_InterestRate2 = parseDouble(tfMortIIR.getText());
                        //double M_PMT2 = Double.parseDouble(tfMortIPMT.getText());

                        String M_HP2 = df.format(M_HomePrice2);
                        lblMortOutHomePrice.setText("Rs. " + M_HP2);

                        // show loan amount value in Results
                        double M_LA2 = M_HomePrice2 - M_DownPayment2;
                        String M_LoanAmount2 = df.format(M_LA2);
                        lblMortOutLoanAmount.setText("Rs. " + M_LoanAmount2);

                        lblMortOutTimePeriod.setText(M_LoanTerm2 + " year");

                        double M_g = 1 + (M_InterestRate2 / 1200);
                        double M_h = 12 * M_LoanTerm2;
                        double M_i = Math.pow(M_g, M_h);
                        double M_j = M_LA2 * (M_InterestRate2 / 1200) * M_i;

                        double M_k = (12 * M_LoanTerm2);
                        double M_l = Math.pow(M_g, M_k);

                        String M_PMT = df.format(M_j / (M_l - 1));
                        lblMortOutMonthlyPayment.setText("Rs. " + M_PMT);


                        // show interest rate in Results
                        String M_IntRate2 = df.format(M_InterestRate2);
                        lblMortOutInterestRate.setText(M_IntRate2 + "%");


                }
            }
            file1(tfMortIHP,tfMortIDP,tfMortILT,tfMortIIR,tfMortILT,"Home Price","Down Payment","Loan Term","Interest Rate","Mortgage Payment","str1");


        });


        ///////////////////////////////////////////////// Simple Savings Calculations /////////////////////////////////////////////////

        btnSimCalculate.setOnAction(event -> {
            if (SimchoiceBox.getValue() != null) {
                String SavingTempString = SimchoiceBox.getSelectionModel().getSelectedItem();
                //System.out.print(tempString);
                switch (SavingTempString) {
                    //Calculate future value
                    case "Future Value":
                        double S_Principal1 = parseDouble(tfSimIsPrincipal.getText());
                        double S_interestRate1 = parseDouble(tfSimIiRate.getText());
                        int S_time1 = Integer.parseInt(tfSimInTime.getText());
                        //Double FV = Double.parseDouble(tfSimIFV.getText());

                        double Sav_a = 1 + (S_interestRate1 / 1200);
                        int Sav_t = 12 * S_time1;
                        double Sav_b = Math.pow(Sav_a, Sav_t);

                        String S_fValue = df.format(S_Principal1 * Sav_b);
                        tfSimIFV.setText("Rs." + S_fValue);


                        break;
                    //Calculate Interest rate
                    case "Interest Rate":
                        double S_Principal2 = parseDouble(tfSimIsPrincipal.getText());
                        int S_time2 = Integer.parseInt(tfSimInTime.getText());
                        double S_FV2 = parseDouble(tfSimIFV.getText());

                        double Sav_e = S_FV2 / S_Principal2;
                        double Sav_f = 1 / (12 * (double) S_time2);
                        double Sav_g = Math.pow(Sav_e, Sav_f);
                        double Sav_h = Sav_g - 1;

                        String S_IntRate = df.format(12 * Sav_h * 100);
                        tfSimIiRate.setText(S_IntRate + " %");


                        break;
                    //Calculate Invested period
                    case "Invested period":
                        double S_Principal3 = parseDouble(tfSimIsPrincipal.getText());
                        double S_FV3 = parseDouble(tfSimIFV.getText());
                        double S_interestRate3 = parseDouble(tfSimIiRate.getText());

                        double S_i = S_FV3 / S_Principal3;
                        double S_j = Math.log(S_i);

                        double S_k = 1 + (S_interestRate3 / 1200);
                        double S_m = Math.log(S_k);
                        double S_n = S_j / (12 * S_m);

                        String S_Time = df.format(S_n);
                        tfSimInTime.setText(S_Time + " years");


                        break;
                    //Calculate Present value
                    case "Present Value":
                        double S_FV4 = parseDouble(tfSimIFV.getText());
                        double S_interestRate4 = parseDouble(tfSimIiRate.getText());
                        int S_time4 = Integer.parseInt(tfSimInTime.getText());

                        double S_p = 1 + (S_interestRate4 / 1200);
                        double S_q = 12 * S_time4;
                        double S_r = Math.pow(S_p, S_q);
                        double S_u = S_FV4 / S_r;

                        String S_Principal = df.format(S_u);
                        tfSimIsPrincipal.setText("Rs." + S_Principal);

                }
            }

            file2(tfSimIFV,tfSimIiRate,tfSimInTime,tfSimIsPrincipal,"Future Value","Interest Rate","Time Period","Principal Value","str2");
        });


        /////////////////////////////////////////////////////// Loans calculation //////////////////////////////////////////////////

        btnLoanCalculate.setOnAction(event -> {
            if (LoanchoiceBox.getValue() != null) {
                String LoantempString = LoanchoiceBox.getSelectionModel().getSelectedItem();

                switch (LoantempString) {
                    //calculate mortgage length of time
                    case "Monthly Payment":
                        Double L_LoanAmount1 = Double.parseDouble(tfLoanAmount.getText());
                        double L_DownPayment1 = Double.parseDouble(tfLoanDPay.getText());
                        Integer L_LoanTerm1 = Integer.parseInt(tfLoanTerm.getText());
                        double L_IntRate1 = Double.parseDouble(tfLoanIntRate.getText()) / 1200;


                        //PMT = (PV * r) / (1 - (1 / Math.pow((1 + r), t)));

                        double L_TotLoanAmount1 = L_LoanAmount1 - L_DownPayment1;
                        String L_LA1 = df.format(L_TotLoanAmount1);
                        lblLoanOutTotal.setText("Rs. " + L_LA1);

                        String L_AmountOfLoan = df.format(L_LoanAmount1);
                        lblLoanOutputAmount.setText("Rs. " + L_AmountOfLoan);

                        lblLoanOutPeriod.setText(L_LoanTerm1 + " years");

                        double L_a = (L_TotLoanAmount1 * L_IntRate1);
                        double L_b = (1 - (1 / Math.pow((1 + L_IntRate1), L_LoanTerm1 * 12)));
                        double L_Mpay = L_a / L_b;

                        String L_MonthlyPay = df.format(L_Mpay);
                        lblLoanOutputPMT.setText("Rs. " + L_MonthlyPay);


                        break;
                    //calculate the loan period
                    case "Loan Period":
                        double L_LoanAmount2 = Double.parseDouble(tfLoanAmount.getText());
                        double L_DownPayment2 = Double.parseDouble(tfLoanDPay.getText());
                        double L_IntRate2 = Double.parseDouble(tfLoanIntRate.getText()) / 1200;
                        double L_PMT2 = Double.parseDouble(tfLoanMonthlyPay.getText());

                        //t = Math.log((PMT / r) / ((PMT / r) - PV)) / Math.log(1 + r);

                        String L_Amount = df.format(L_LoanAmount2);
                        lblLoanOutputAmount.setText(L_Amount);

                        double L_TotLoanAmount2 = L_LoanAmount2 - L_DownPayment2;
                        String L_LA2 = df.format(L_TotLoanAmount2);
                        lblLoanOutTotal.setText(L_LA2);

                        double L_g = Math.log((L_PMT2 / L_IntRate2) / ((L_PMT2 / L_IntRate2) - L_TotLoanAmount2));
                        double L_h = Math.log(1 + L_IntRate2);
                        double L_Time2 = L_g / L_h;
                        String L_TimePeriod = df.format(L_Time2 / 12);
                        lblLoanOutPeriod.setText(L_TimePeriod + " years");


                        String L_monthPay2 = df.format(L_PMT2);
                        lblLoanOutputPMT.setText("Rs. " + L_monthPay2);

                        break;
                    // calculate the present value
                    case "Present Value":
                        double L_DownPayment3 = Double.parseDouble(tfLoanDPay.getText());
                        int L_LoanTerm3 = Integer.parseInt(tfLoanTerm.getText());
                        double L_IntRate3 = Double.parseDouble(tfLoanIntRate.getText()) / 1200;
                        double L_PMT3 = Double.parseDouble(tfLoanMonthlyPay.getText());

                        //(PMT / r) * (1 - (1 / Math.pow((1 + r), t)));

                        double L_i = (L_PMT3 / L_IntRate3);
                        double L_j = (1 - (1 / Math.pow((1 + L_IntRate3), L_LoanTerm3 * 12)));
                        double L_loan = L_i * L_j;
                        //If the user entered a input about a down payment he already did we should improve this calculation to calculate total loan amount .
                        double L_tLoan = L_loan + L_DownPayment3;


                        lblLoanOutPeriod.setText(L_LoanTerm3 + " years");

                        String L_loanAm = df.format(L_loan);
                        lblLoanOutputAmount.setText("Rs. " + L_loanAm);

                        String L_TotalLoan = df.format(L_tLoan);
                        lblLoanOutTotal.setText("Rs. " + L_TotalLoan);

                        String L_MonthPayment3 = df.format(L_PMT3);
                        lblLoanOutputPMT.setText("Rs. " + L_MonthPayment3);
                        break;


                }
            }
            file3(tfLoanDPay,tfLoanTerm,tfLoanIntRate,tfLoanMonthlyPay,tfLoanAmount,"Down Payment","Loan Term","Interest Rate","Monthly Payment","Loan Amount","str3");
        });

        /////////////////////////////////////// Compound Saving Calculation /////////////////////////////////////


        btnCompCalculate.setOnAction(event -> {
            if (CompchoiceBox.getValue() != null) {
                String ComptempString = CompchoiceBox.getSelectionModel().getSelectedItem();///***************error

                switch (ComptempString) {
                    //calculate mortgage length of time
                    case "Future Value":
                        //double C_FutureValue1 = Double.parseDouble(tfCompInFV.getText());
                        double C_Principal1 = Double.parseDouble(tfCompInPrincipal.getText());
                        double C_InterestRate1 = parseDouble(tfCompInIR.getText()) / 100;
                        Integer C_TimePeriod1 = Integer.parseInt(tfCompInTime.getText());
                        double C_Payment1 = parseDouble(tfCompInMonthPay.getText());

                        lblCompOutputTime.setText(C_TimePeriod1 + " years");
                        lblCompOutputMonthPay.setText("Rs. " + C_Payment1);
                        lblOutCompPV.setText("Rs. " + C_Principal1);

                        //FV = (PV * Math.pow((1 + (r / n)), (n * t))) + (PMT * (  (Math.pow( ( 1 + (r / n) ), (n * t)  )  - 1)   / (r/n)  )      );

                        double pow = Math.pow((1 + (C_InterestRate1 / 12)), (12 * C_TimePeriod1));
                        double C_compoundInterest = (C_Principal1 * pow);
                        double C_FVseries = (C_Payment1 * ((pow - 1) / (C_InterestRate1 / 12)));
                        double C_FV = C_compoundInterest + C_FVseries;
                        String C_FutureValue = df.format(C_FV);
                        lblCompOutputFV.setText("Rs. " + C_FutureValue);


                        break;
                    //Calculate Interest rate
                    case "Present Value":
                        double C_FutureValue2 = Double.parseDouble(tfCompInFV.getText());
                        //double C_Principal2 = parseDouble(tfCompInPrincipal.getText());
                        double C_InterestRate2 = parseDouble(tfCompInIR.getText());
                        int C_TimePeriod2 = Integer.parseInt(tfCompInTime.getText());
                        double C_Payment2 = Double.parseDouble(tfCompInMonthPay.getText());

                        //PV = (FV - (PMT * ((Math.pow((1 + (r/n)), n * t) - 1) / (r/n))))/ (Math.pow((1 + (r/n)), n * t));

                        final double pow1 = Math.pow((1 + (C_InterestRate2 / 12)), 12 * C_TimePeriod2);
                        double C_f = (C_FutureValue2 - (C_Payment2 * ((pow1 - 1) / (C_InterestRate2 / 12))));
                        double C_g = pow1;
                        double C_PV = C_f / C_g;
                        String C_PresentValue = df.format(C_PV);
                        lblOutCompPV.setText("Rs. " + C_PresentValue);

                        lblCompOutputFV.setText("Rs. " + C_FutureValue2);
                        lblCompOutputMonthPay.setText("Rs. " + C_Payment2);
                        lblCompOutputTime.setText(C_TimePeriod2 + " years");


                        break;
                    //Calculate Invested period
                    case "Monthly Payment":
                        double C_FutureValue3 = parseDouble(tfCompInFV.getText());
                        double C_Principal3 = parseDouble(tfCompInPrincipal.getText());
                        double C_InterestRate3 = parseDouble(tfCompInIR.getText()) / 100;
                        int C_TimePeriod3 = Integer.parseInt(tfCompInTime.getText());


                        //PMT = (FV - (PV * Math.pow((1 + (r / n)), (n * t)))) / ((Math.pow((1 + (r / n)), (n * t)) - 1) / (r / n));

                        double C_j = (C_FutureValue3 - (C_Principal3 * Math.pow((1 + (C_InterestRate3 / 12)), (12 * C_InterestRate3))));
                        double C_k = ((Math.pow((1 + (C_InterestRate3 / 12)), (12 * C_TimePeriod3)) - 1) / (C_InterestRate3 / 12));
                        double C_PMT = C_j / C_k;
                        String C_Payment = df.format(C_PMT);
                        lblCompOutputMonthPay.setText("Rs. " + C_Payment);


                        lblOutCompPV.setText("Rs. " + C_Principal3);
                        lblCompOutputFV.setText("Rs. " + C_FutureValue3);
                        lblCompOutputTime.setText(C_TimePeriod3 + " years");


                        break;
                    //Calculate invested time period
                    case "Invested period":
                        Double C_FutureValue4 = Double.parseDouble(tfCompInFV.getText());
                        double C_Principal4 = Double.parseDouble(tfCompInPrincipal.getText());
                        double C_InterestRate4 = parseDouble(tfCompInIR.getText()) / 100;
                        double C_MonthlyPay4 = parseDouble(tfCompInMonthPay.getText());

                        //t = Math.log(((((r * FV) / n) + PMT) / (((PV * r) / n) + PMT))) / (nn * Math.log(1 + (r/n)));

                        double C_n = Math.log(((((C_InterestRate4 * C_FutureValue4) / 12) + C_MonthlyPay4) / (((C_Principal4 * C_InterestRate4) / 12) + C_MonthlyPay4)));
                        double C_p = (12 * Math.log(1 + (C_InterestRate4 / 12)));
                        double C_IP = C_n / C_p;
                        String C_Time = df.format(C_IP);


                        String C_TimePeriod = df.format(C_Time);
                        lblCompOutputTime.setText(C_TimePeriod + " years");

                        lblCompOutputFV.setText("Rs. " + C_FutureValue4);
                        lblCompOutputMonthPay.setText("Rs. " + C_MonthlyPay4);
                        lblOutCompPV.setText("Rs. " + C_Principal4);

                        break;


                }
            }
            file4(tfCompInFV, tfCompInPrincipal, tfCompInIR, tfCompInTime, tfCompInMonthPay, "FutureValue", "Principal Investment", "Interest Rate", "Time Period", "MonthlyPay", "str4");
        });


    }
    // write the data of mortgage calculator to a file
    private void file1(TextField tfMortIHP, TextField tfMortIDP, TextField tfMortILT, TextField tfMortIIR, TextField tfMortILT1, String home_price, String down_payment, String loan_term, String interest_rate, String mortgage_payment, String str1) {
        File myFile = new File("History.txt");
        PrintWriter printWrite;
        FileWriter fileWrite;
        try {
            fileWrite = new FileWriter(myFile, true);
            printWrite = new PrintWriter(fileWrite, true);


            printWrite.println(str1);
            printWrite.println(home_price + "=" + tfMortIHP.getText());
            printWrite.println( down_payment+ "=" + tfMortIDP.getText());
            printWrite.println(loan_term + "=" + tfMortILT.getText());
            printWrite.println(interest_rate + "=" + tfMortIIR.getText());
            printWrite.println(mortgage_payment + "=" + tfMortILT1.getText());
            printWrite.println("------------------------------");
            printWrite.close();

        } catch (IOException e) {
            System.out.println("Error!!!");
        }

    }

    // write the data of simple savings calculator to a file
    private void file2(TextField tfSimIFV, TextField tfSimIiRate, TextField tfSimInTime, TextField tfSimIsPrincipal, String future_value, String interest_rate, String time_period, String principal_value, String str2) {
        File myFile = new File("History.txt");
        PrintWriter printWrite;
        FileWriter fileWrite;
        try {
            fileWrite = new FileWriter(myFile, true);
            printWrite = new PrintWriter(fileWrite, true);


            printWrite.println(str2);
            printWrite.println(future_value + "=" + tfSimIFV.getText());
            printWrite.println( interest_rate+ "=" + tfSimIiRate.getText());
            printWrite.println(time_period + "=" + tfSimInTime.getText());
            printWrite.println(principal_value + "=" + tfSimIsPrincipal.getText());
            printWrite.println("------------------------------");
            printWrite.close();

        } catch (IOException e) {
            System.out.println("Error!!!");
        }

    }

    // write the data of loan calculator to a file
    private void file3(TextField tfLoanDPay, TextField tfLoanTerm, TextField tfLoanIntRate, TextField tfLoanMonthlyPay, TextField tfLoanAmount, String down_payment, String loan_term, String interest_rate, String monthly_payment, String loan_amount,String str3) {
        File myFile = new File("History.txt");
        PrintWriter printWrite;
        FileWriter fileWrite;
        try {
            fileWrite = new FileWriter(myFile, true);
            printWrite = new PrintWriter(fileWrite, true);


            printWrite.println(str3);
            printWrite.println(down_payment + "=" + tfLoanDPay.getText());
            printWrite.println( loan_term+ "=" + tfLoanTerm.getText());
            printWrite.println(interest_rate + "=" + tfLoanIntRate.getText());
            printWrite.println(monthly_payment+ "=" + tfLoanMonthlyPay.getText());
            printWrite.println(loan_amount + "=" + tfLoanAmount.getText());
            printWrite.println("------------------------------");
            printWrite.close();

        } catch (IOException e) {
            System.out.println("Error!!!");
        }


    }

    // write the data of compound saving calculatoe to a file
    private void file4(TextField tfCompInFV, TextField tfCompInPrincipal, TextField tfCompInIR, TextField tfCompInTime, TextField tfCompInMonthPay, String futureValue, String principal_investment, String interest_rate, String time_period, String monthlyPay,String str4) {

        File myFile = new File("History.txt");
        PrintWriter printWrite;
        FileWriter fileWrite;
        try {
            fileWrite = new FileWriter(myFile, true);
            printWrite = new PrintWriter(fileWrite, true);



            printWrite.println(str4);
            printWrite.println(futureValue + "=" + tfCompInFV.getText());
            printWrite.println(principal_investment + "=" + tfCompInPrincipal.getText());
            printWrite.println(interest_rate + "=" + tfCompInIR.getText());
            printWrite.println(time_period + "=" + tfCompInTime.getText());
            printWrite.println(monthlyPay + "=" + tfCompInMonthPay.getText());
            printWrite.println("------------------------------");
            printWrite.close();

        } catch (IOException e) {
            System.out.println("Error!!!");
        }

    }

    // change the calculator history
    public void calHistory(TextArea taTry01) {
        try {
            FileReader txt1 = new FileReader("History.txt");
            BufferedReader buffReader = new BufferedReader(txt1);

            String str1;
            while ((str1 = buffReader.readLine()) != null) {
                String ta = taTry01.getText();

                taTry01.setText(ta + str1 + "\n");

            }

            buffReader.close();
        } catch(IOException e) {
            System.out.println("File not found!");
        }
    }

    }




