package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nikolay Kanatov on 01.03.2017.
 */

public class MainWindowController {

    @FXML
    public MenuBar MenuBarID;

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
            try {
                ShowFile(finalFileName,finalFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        MenuBarID.getMenus().get(1).getItems().add(menuItem); //добавляет ко второму меню menuItem

    }

    public void ShowFile(String fileName,String filePath) throws IOException {

        EditDocController edc = new EditDocController();
        edc.setResult(fileName,filePath);

    }

}
