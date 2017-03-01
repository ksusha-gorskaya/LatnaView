package controllers;

import Models.Items;
import Models.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Nikolay Kanatov on 01.03.2017.
 */

public class EditDocController{


    public TableView fileTableView = new TableView<>();


    public Items itemsVector;
    public Orders ordersVector;

    public final ObservableList resultList = FXCollections.observableArrayList();
    private final HBox hb = new HBox();

    public void setResult(String fileName,String filePath){
        Scene scene = new Scene(new Group());

        try {
            Stage stage = new Stage();
            int countField=0;
            switch (fileName){
                case "Items.csv":
                    itemsVector = new Items(filePath);
                    resultList.addAll(itemsVector.toItemsArray());
                    countField = itemsVector.getItem(0).getCountField();
                    break;
                case "Orders.csv":
                    ordersVector = new Orders(filePath);
                    resultList.addAll( ordersVector.toOrdersArray());
                    countField = ordersVector.getOrder(0).getCountField();
                    break;
            }
            FillTable(resultList,countField);

            fileTableView.setMinWidth(365);
            Button addButton = new Button("Add row");
            Button editButton = new Button("Edit");
            Button deleteButton = new Button("Delete");


            hb.getChildren().addAll(addButton,editButton,deleteButton);
            hb.setSpacing(5);

            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10,10,0,10));
            vbox.setFillWidth(true);
            vbox.setMinWidth(fileTableView.getFixedCellSize()*5);//getMaxWidth()+100);
            vbox.getChildren().addAll(fileTableView,hb);


            ((Group)scene.getRoot()).getChildren().addAll(vbox);
            stage.setTitle(fileName);
            stage.setMinHeight(500);
            stage.setMinWidth(500);
            stage.setScene(scene);
            stage.show();

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void FillTable(ObservableList resultList,int countField) {
        fileTableView.setItems(resultList);
        String str =resultList.get(0).getClass().toString();
        switch (str){
            case "class Models.ItemModel":
                for (int i = 0; i < countField; i++) {
                    TableColumn tableColumn = new TableColumn(itemsVector.getHeaders()[i]);
                    tableColumn.setCellValueFactory(
                            new PropertyValueFactory<>(itemsVector.getHeaders()[i]));
                    fileTableView.getColumns().add(tableColumn);
                }
                break;
            case "class Models.OrderModel":
                for (int i = 0; i < countField; i++) {
                    TableColumn tableColumn = new TableColumn(ordersVector.getHeaders()[i]);
                    tableColumn.setCellValueFactory(
                            new PropertyValueFactory<>(ordersVector.getHeaders()[i]));
                    fileTableView.getColumns().add(tableColumn);
                }
                break;

        }

    }

}
