package controllers;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.ReadData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    ReadData readData = new ReadData();
    public static ArrayList<String[]> result = new ArrayList<String[]>();

    public static ArrayList<String[]> getResult(){return result;}

    public void openMyFile() throws Exception {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            result = readData.reader(file.getAbsolutePath());
        }
    }


    public void showData() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/showData.fxml"));

        Controller2 ct2 = new Controller2();
        ct2.setResult(result, root);

    }
}
