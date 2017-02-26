package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import sample.ReadData;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    ReadData readData = new ReadData();
    public static ArrayList<String[]> result = new ArrayList<String[]>();

    private Parent root;
    private MenuBar menu;

    public void openMyFile() throws Exception {
        String FileName = null;
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            FileName = file.getName();
            result = readData.reader(file.getAbsolutePath());
        }


        root=FXMLLoader.load(getClass().getResource("../views/mainWindow.fxml"));
        MenuItem menuItem = new MenuItem();
        menuItem.setText(FileName);
        menu = (MenuBar)root.lookup("#MenuBarID");
        menu.getMenus().get(1).getItems().add(menuItem); //добавляет ко второму меню menuItem

    }


    public void showData() throws IOException {

        Controller2 ct2 = new Controller2();
        ct2.setResult(result, FXMLLoader.load(getClass().getResource("../views/showData.fxml")));

    }
}
