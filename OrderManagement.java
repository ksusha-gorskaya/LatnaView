package Management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Readers.ReadData;
import com.opencsv.*;

/**
 * Created by Anna Barinova on 5.02.2017.
 */

public class OrderManagement {

    public ArrayList<String> readOrderIds(String fileName) throws Exception {
        ArrayList<String> orderIds = new ArrayList<String>();
        ReadData readData = new ReadData();
        ArrayList<String[]> orderAll = readData.readerDoc(fileName);
        if (orderAll != null) {
            for (String[] order : orderAll) {
                orderIds.add(order[0]);
            }
        }
        return orderIds;
    }

    public boolean validateWay(String way) {
        if (way.contains(" ")) {
            String[] parts = way.split(" ");
            try {
                Integer.parseInt(parts[0]);
                if (!parts[1].equals("way"))
                    return false;
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean validateTime(String time) {
        String[] parts1=time.split("-");
        String[] parts2=parts1[0].split(":");
        String[] parts3=parts1[1].split(":");
        int start=Double.valueOf(parts2[0]).intValue();
        int end=Double.valueOf(parts3[0]).intValue();
        if(start>=6&start<24&start!=13&start!=14&end>6&end<24&end!=13&end!=14&end>start)
            return true;
        return false;
    }

    public boolean validateExpedition(String expedition) {
        if (!(expedition.equalsIgnoreCase("south") || expedition.equalsIgnoreCase("north")))
            return false;
        return true;
    }

    public ArrayList<String> addOrder(String[] data, String filename) throws Exception {
        ArrayList<String> orderList = new ArrayList<>();
        if (validateWay(data[0]) & validateTime(data[1]) & validateExpedition(data[2])) {
            String p=readOrderIds(filename).get(readOrderIds(filename).size()-1);
            Integer ind = Integer.parseInt(p) + 1;
            orderList.add(Integer.toString(ind));
            orderList.add(data[0]);
            orderList.add(data[1]);
            orderList.add(data[2]);
        }
        return orderList;
    }

    public void addOrderInCSV(String readFilename, String writeFilename) throws IOException {
        ArrayList<String> orders = new ArrayList<>();
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(readFilename)));
        while ((line = in.readLine()) != null) {
            orders.add(line);
        }
        String COMMA_DELIMITER = ";";
        String NEW_LINE_SEPARATOR = "\n";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(writeFilename, true);
            for (String order : orders) {
                String[] sp = order.split(";");
                if (sp.length == 3) {
                    ArrayList<String> orderList = addOrder(sp, writeFilename);
                    if(orderList.size()!=0) {
                        fileWriter.append(orderList.get(0));
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(orderList.get(1));
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(orderList.get(2));
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(orderList.get(3));
                        fileWriter.append(NEW_LINE_SEPARATOR);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeOrder(String readFilename, String writeFilename) throws Exception {
        ArrayList<String> orders = new ArrayList<>();
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(readFilename)));
        while ((line = in.readLine()) != null) {
            orders.add(line);
        }
        CSVReader reader = new CSVReader(new FileReader(writeFilename), ';');
            for (String order : orders) {
                String[] sp = order.split(";");
                if (sp.length == 4&validateWay(sp[1])& validateTime(sp[2]) & validateExpedition(sp[3])) {
                    List<String[]> csvBody = reader.readAll();
                    ArrayList<String> Ids = readOrderIds(writeFilename);
                    csvBody.get(Ids.indexOf(sp[0])+1)[1]=sp[1];
                    csvBody.get(Ids.indexOf(sp[0])+1)[2]=sp[2];
                    csvBody.get(Ids.indexOf(sp[0])+1)[3]=sp[3];
                    reader.close();
                    CSVWriter writer = new CSVWriter(new FileWriter(writeFilename), ';');
                    writer.writeAll(csvBody);
                    writer.flush();
                    writer.close();
                }
            }
    }
}
