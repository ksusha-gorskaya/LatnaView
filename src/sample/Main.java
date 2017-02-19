package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ReadData readData=new ReadData();
        String csvFile = "C:\\Users\\dns\\Desktop\\Латас\\LatnaView\\LatnaView\\Result.csv";
        //String csvFile = "C:\\Users\\dns\\Desktop\\Латас\\LatnaView\\LatnaView\\Warehouse.csv";
        //readData.reader(csvFile);
        //csvFile = "C:\\Users\\dns\\Desktop\\Латас\\LatnaView\\LatnaView\\Result.csv";
        readData.reader(csvFile);
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
