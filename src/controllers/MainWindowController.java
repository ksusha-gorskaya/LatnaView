package controllers;

import Readers.Warehouse;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nikolay Kanatov on 01.03.2017.
 */

public class MainWindowController {

    @FXML
    public MenuBar MenuBarID;

    @FXML
    public ScrollPane WHouse;

    public void openMyFile()  throws Exception {

        MenuItem menuItem = new MenuItem();
        String FileName = null;
        String FilePath = null;
        JFileChooser fileopen = new JFileChooser();
        fileopen.setCurrentDirectory(new File("."));
        if (fileopen.showDialog(null, "Выбрать файл") == JFileChooser.APPROVE_OPTION) {
            for (MenuItem item:MenuBarID.getMenus().get(1).getItems()) {
                String tmp1 = item.getUserData().toString();
                String tmp2 =fileopen.getSelectedFile().getAbsolutePath();
                if(tmp1.equals(tmp2))
                    return;
            }
            FileName = fileopen.getSelectedFile().getName();
            FilePath=fileopen.getSelectedFile().getAbsolutePath();
            menuItem.setUserData(FilePath);
        }

        menuItem.setText(FileName);
        final String finalFilePath = FilePath;
        final String finalFileName = FileName;
        menuItem.setOnAction(event -> {
            try{
                if(menuItem.getText().equals("Warehouse.csv"))
                    GetWareHouse(finalFilePath);
                else
                    ShowFile(finalFileName,finalFilePath);
            }
            catch (Exception ex){
              ex.printStackTrace();
            }

        });

        MenuBarID.getMenus().get(1).getItems().add(menuItem); //добавляет ко второму меню menuItem

    }

    public void ShowFile(String fileName,String filePath) throws IOException {

        EditDocController edc = new EditDocController();
        edc.setResult(fileName,filePath);
    }

    public void GetWareHouse(String path) throws Exception {
        Warehouse wr = new Warehouse();
        wr.readWarehouse(path);

        Rectangle[] rect = new Rectangle[61*wr.numberOfColumns+1];
        VBox[] vb = new VBox[wr.numberOfColumns+1];
        final Pane container = new Pane();

        for(int i =0;i<wr.numberOfColumns;i++) {
            vb[i]=new VBox();
            for (int j = 0; j < 61; j++) {
                rect[(61*i) + j] = new Rectangle();
                rect[(61*i) + j].setWidth(20);
                rect[(61*i) + j].setHeight(15);
                rect[(61*i) + j].setFill(Color.AZURE);
                rect[(61*i) + j].setStroke(Color.BLACK);
                rect[(61*i) +j].setUserData(wr.shelves.get(i).get(j));
                rect[(61*i) +j].setOnMouseClicked(getInfoShelvesEvent());
                vb[i].getChildren().add(rect[(61*i) + j]);
            }

            if(i>0) {
                if ((i+1) % 3 == 0)
                    vb[i].setLayoutX(vb[i - 1].getLayoutX() + 20);
                else
                    vb[i].setLayoutX(vb[i - 1].getLayoutX() + 40);
            }else{
                vb[0].setLayoutX(20);
            }
            vb[i].setLayoutY(50);
            container.getChildren().add(vb[i]);
        }
        WHouse.setContent(container);
    }

    public EventHandler<MouseEvent> getInfoShelvesEvent(){
        return event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(((Rectangle)event.getSource()).getUserData().toString());
            alert.show();
        };
    }
}
