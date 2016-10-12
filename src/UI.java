import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class UI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    MealRecommendations mealRecommendationChoice = new MealRecommendations();
    RestaurantRecommendations restaurantRecommendationChoice = new RestaurantRecommendations();
    private final InputListHandler createList = new InputListHandler();
    private final GridPane gridPane = new GridPane();
    private final Label title = new Label("What's For Dinner?");
    private final Label statement = new Label("Welcome to the site designed to make life's dinner decisions easier.");
    private final Label orStatement = new Label("-Or-");
    private final TextField locationInput = new TextField();
    private final TextField userInput = new TextField();
    private final TextArea userInputList = new TextArea();
    private final ScrollPane outputArea = new ScrollPane();
    private final Button addButton = new Button("Add");
    private final Button RandomButton = new Button("Random");
    private final Button ourRecommendationButton = new Button("Our Recommendation");
    private final Button clearButton = new Button("Clear List");
    private final ComboBox<String> locationSelector = new ComboBox<>();
    private final DropShadow shadow = new DropShadow();
    private final WebView browser = new WebView();
    private final WebEngine webEngine = browser.getEngine();

    @Override
    public void start(Stage primaryStage) {
        configureStage(primaryStage);
        configureShadow();
        configureTitle();
        configureStatement();
        configureComboBox();
        configureTextFields();
        configureButtons();
        configureGridPane();
        comboBoxSelectionCheck();
        inputFieldListener();
        addToListButtonListener();
        clearListButtonListener();
        recommendationButtonListener();
        randomButtonListener();
    }

    private void configureStage(Stage stage) {
        stage.setTitle("What's For Dinner?");
        stage.setScene(new Scene(gridPane, 1250, 1050));
        stage.setResizable(false);
        stage.show();
    }

    private void configureShadow() {
        shadow.setOffsetY(3.0f);
        shadow.setColor(Color.color(0.4f, 0.4f, 0.4f));
    }

    public void configureTitle() {
        title.setEffect(shadow);
        title.setFont(Font.font("Cambria", 75));
        title.setTextFill(Color.web("#ddc09e"));
    }

    private void configureStatement() {
        statement.setEffect(shadow);
        statement.setFont(Font.font("Cambria", 25));
        statement.setTextFill(Color.web("#ddc09e"));
    }

    private void configureComboBox() {
        locationSelector.getItems().addAll("Out to Eat", "Eat at Home");
        locationSelector.setValue("Select location");
        locationSelector.setEditable(false);
    }

    private void configureTextFields() {
        locationInput.setMaxWidth(300);
        locationInput.setVisible(false);
        userInput.setMaxWidth(300);
        userInput.setDisable(true);
        userInputList.setMaxWidth(300);
        userInputList.setEditable(false);
        userInputList.setDisable(true);
        // userInputList.setStyle("-fx-background-image:
        // url('file:src/assets/inputList.png')");
        outputArea.setMinWidth(533);
        outputArea.setMaxWidth(533);
        outputArea.setDisable(true);
        outputArea.setFitToWidth(true);
    }

    private void configureButtons() {
        addButton.setDisable(true);
        RandomButton.setDisable(true);
        ourRecommendationButton.setDisable(true);
        clearButton.setDisable(true);
    }

    public GridPane configureGridPane() {
        gridPane.setHgap(90);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(30, 30, 30, 185));
        gridPane.setStyle("-fx-background-image:url('file:src/assets/backGround.png')");
        configureGirdPaneData();
        return gridPane;
    }

    @SuppressWarnings("static-access")
    // setHalignement and setComumnSpan requires a suppress warning
    private void configureGirdPaneData() {
        RowConstraints titleRow = new RowConstraints();
        titleRow.setPercentHeight(10);
        gridPane.getRowConstraints().add(titleRow);
        gridPane.add(title, 0, 0);
        gridPane.setColumnSpan(title, 3);
        gridPane.setHalignment(title, HPos.CENTER);
        gridPane.add(statement, 0, 2);
        gridPane.setColumnSpan(statement, 3);
        gridPane.setHalignment(statement, HPos.CENTER);
        gridPane.add(locationSelector, 0, 9);
        gridPane.setHalignment(locationSelector, HPos.CENTER);
        gridPane.add(locationInput, 0, 13);
        gridPane.add(userInput, 0, 14);
        gridPane.add(addButton, 0, 15);
        gridPane.setHalignment(addButton, HPos.CENTER);
        gridPane.add(orStatement, 0, 16);
        gridPane.setHalignment(orStatement, HPos.CENTER);
        gridPane.add(ourRecommendationButton, 0, 17);
        gridPane.setHalignment(ourRecommendationButton, HPos.CENTER);
        gridPane.add(userInputList, 0, 18);
        gridPane.setRowSpan(userInputList, 110);
        gridPane.add(clearButton, 0, 131);
        gridPane.setHalignment(clearButton, HPos.CENTER);
        gridPane.add(RandomButton, 0, 132);
        gridPane.setHalignment(RandomButton, HPos.CENTER);
        gridPane.add(outputArea, 1, 14);
        gridPane.setRowSpan(outputArea, 120);
        gridPane.setHalignment(outputArea, HPos.CENTER);
    }

    public void comboBoxSelectionCheck() {
        locationSelector.valueProperty().addListener(new ChangeListener<String>() {
            @SuppressWarnings("rawtypes")
            // ObservableValue requires a suppressor otherwise the system will
            // crash
            @Override
            public void changed(ObservableValue selected, String eatAtHome, String outToEat) {
                if (selected.getValue().equals("Out to Eat")) {
                    configureOutToEatSelected();
                    createList.clearInputs();
                } else if (selected.getValue().equals("Eat at Home")) {
                    configureEatAtHomeSelected();
                    createList.clearInputs();
                }
            }
        });
    }

    private void configureEatAtHomeSelected() {
        RandomButton.setText("Random Meals");
        ourRecommendationButton.setText("Our Meal Suggestions");
        addButton.setText("Add Meal");
        userInputList.clear();
        configureHomeCookingInputField();
        configureSelected();
    }

    private void configureHomeCookingInputField() {
        userInput.setPromptText("Please Input Meal");
    }

    private void configureOutToEatSelected() {
        RandomButton.setText("Random Restaurants");
        ourRecommendationButton.setText("Our Restaurant Suggestions");
        addButton.setText("Add Restaurant");
        userInputList.clear();
        configureOutToEastInputField();
        configureSelected();
    }

    private void configureOutToEastInputField() {
        userInput.setPromptText("Please Input Restaurant");
        locationInput.setPromptText("Please Enter Location");
        locationInput.setVisible(true);
    }

    private void configureSelected() {
        userInput.setDisable(false);
        addButton.setDisable(false);
        ourRecommendationButton.setDisable(false);
    }

    private void inputFieldListener() {
        userInput.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
            }
        });
    }

    private void addToListButtonListener() {
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    addToList();
                    userInput.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void addToList() {
        if (userInput.getText().equals(" ") && userInput.getText().equals(null)) {
            outputArea.setAccessibleText("Please Enter Valid Value");
        } else if (ourRecommendationButton.getText().equals("Our Restaurant Suggestions")) {
            createList.addRestaurantInputs(userInput.getText());
            userInputList.appendText(userInput.getText() + "\n");
            userInputList.setDisable(false);
            RandomButton.setDisable(false);
            clearButton.setDisable(false);
        } else {
            createList.addMealInputs(userInput.getText());
            userInputList.appendText(userInput.getText() + "\n");
            userInputList.setDisable(false);
            RandomButton.setDisable(false);
            clearButton.setDisable(false);
        }
    }

    private void clearListButtonListener() {
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    userInputList.clear();
                    createList.clearInputs();
                    userInputList.setDisable(true);
                    RandomButton.setDisable(true);
                    clearButton.setDisable(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void randomButtonListener() {
        RandomButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    outputArea.setDisable(false);
                    returnInputToOutputField();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void returnInputToOutputField() {
        if (addButton.getText().equals("Add Meal")) {
            outputArea.setContent(browser);
            webEngine.load(createList.returnRandomURL());
        } else {
            outputArea.setContent(browser);
            webEngine.load(createList.returnRandomURL() + locationInput.getText());
        }
    }

    private void recommendationButtonListener() {
        ourRecommendationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    outputArea.setDisable(false);
                    returnRecommendationToOutputField();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void returnRecommendationToOutputField() {
        if (ourRecommendationButton.getText().equals("Our Restaurant Suggestions")) {
            outputArea.setContent(browser);
            webEngine.load(restaurantRecommendationChoice.makeRestaurantList() + locationInput.getText());
        } else {
            outputArea.setContent(browser);
            webEngine.load(mealRecommendationChoice.makeMealList());
        }
    }
}