package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by User on 29.01.2017.
 */
public class Controller2 {

    public TableView gridData;

    private ObservableList<String[]> resultList;
    private Button myButs;

    public void setResult(ArrayList<String[]> result, Parent root){
        try {
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            resultList = FXCollections.observableArrayList();

            for(int i=0;i<result.size();i++)
                resultList.add(result.get(i));

            gridData = (TableView) root.lookup("#gridData");
//            gridData.
//
            for(int i=0;i<result.get(0).length;i++)
                gridData.getColumns().add(new TableColumn(""+i));


            gridData.setItems(resultList);
//            for(int i=0;i<100;i++){
//                for(int j=0;j<4;j++)
//                    gridData.add(new Label(result.get(i)[j]),j,i);
//            }

            stage.show();

        }
        catch(Exception e) {
            e.printStackTrace();
        }

//        this.result = result;
//        for(int i=0;i<result.size();i++){
//            for(int j=0;j<result.get(i).length;j++)
//                gridData.add(new Label(result.get(i)[j]),j,i);
//        }

    }

    //    public openData(Window mod) throws IOException {
//        Stage stage = new Stage();
//        FXMLLoader root = FXMLLoader.load(getClass().getResource("/src/views/showData.fxml"));
//        Scene scene = new Scene(root.load());
//        stage.setScene(scene);
//        stage.show();
//    }

}
