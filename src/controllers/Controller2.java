package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller2 {

    @FXML
    public TableView gridData;
    @FXML
    public TextField textField;

    private ObservableList<String[]> resultList;

    public void setResult(ArrayList<String[]> result, Parent root){
        try {
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            resultList = FXCollections.observableArrayList();

            for(int i=0;i<result.size();i++)
                resultList.add(result.get(i));
            gridData = new TableView();
            gridData.setItems(resultList);

            for(int i=0;i<result.get(0).length;i++)
                gridData.getColumns().add(new TableColumn(""+i));


//            gridData.getItems().add(resultList);

            stage.show();

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void AddItem(ActionEvent event){
        ObservableList<String[]> data = gridData.getItems();
        data.add(new String[]{"1","2","3"});
    }
    @FXML
    public void EditItem(ActionEvent event){
        int i = ((TableCell)event.getSource()).getIndex();
        gridData.edit(i, new TableColumn(textField.getText()));
    }
    @FXML
    public void DeleteItem(ActionEvent event){
        int i = ((TableCell)event.getSource()).getIndex();
        gridData.getItems().remove(i);
    }
}
