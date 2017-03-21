package Readers;

import Models.Items;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Ксения Горская on 21.01.2017.
 * Updated by Nikolay Kanatov on 02.03.2017
 */
public class ReadData {

    private ArrayList<String[]> matrix = new ArrayList<>();

    public ArrayList<String[]> readerSpecial(String fileName) throws Exception {
        if (fileName.contains("Warehouse")) {
            Warehouse warehouse = new Warehouse();
            warehouse.readWarehouse(fileName);
            return matrix;
        }
        if (fileName.contains("Result")) {
            ReadResult result = new ReadResult();
            result.readResult(fileName);
            fileName = "C:\\Users\\dns\\Desktop\\Латас\\LatnaView\\LatnaView\\test_log.1";
            //fileName = "C:\\Users\\ksgo0816\\Documents\\LatasProject\\LatnaView\\test_log.1";
            result.readLog(fileName);
            return matrix;
        }


        System.out.println("Done");
        return matrix;
    }
    public Items items;
    public ArrayList<String[]> readerDoc(String fileName) throws Exception {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        boolean headline = true;//headline contains names of columns
        boolean parametersFile = false;
        if (fileName.contains("Parameters")) parametersFile = true;

        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                if (parametersFile) {
                    matrix.add(row);
                    parametersFile = false;
                }
                if (!headline) {
                    matrix.add(row);
                }
                headline = false;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return matrix;
    }
}
