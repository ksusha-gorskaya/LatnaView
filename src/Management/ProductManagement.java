//package Management;
//
//import Readers.ReadData;
//import com.opencsv.CSVReader;
//import com.opencsv.CSVWriter;
//
//import java.io.*;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Anna Barinova on 6.02.2017.
// */
//
//public class ProductManagement {
//
//    public ArrayList<String> readProductIds(String fileName) throws Exception {
//        ArrayList<String> productIds = new ArrayList<String>();
//        ReadData readData = new ReadData();
//        ArrayList<String[]> all = readData.readerDoc(fileName);
//        if (all != null) {
//            for (String[] product : all) {
//                productIds.add(product[1]);
//            }
//        }
//        return productIds;
//    }
//
//
//    public ArrayList<String> addProduct(String[] data, String filename) throws Exception {
//        ArrayList<String> ProductList = new ArrayList<>();
//        if (validateData(data)) {
//            String p=readProductIds(filename).get(readProductIds(filename).size()-1).replace(',','.');
//            BigDecimal ind = new BigDecimal(p);
//            ProductList.add(data[0]);
//            ProductList.add(Long.toString(ind.longValue()+1));
//            ProductList.add(data[1]);
//            ProductList.add(data[2]);
//            ProductList.add(data[3]);
//            ProductList.add(data[4]);
//        }
//        return ProductList;
//    }
//
//    private boolean validateData(String[] data) throws Exception {
//        String csvOrders = "C:\\Users\\Admin\\Documents\\Учеба\\Проект Латас\\Project\\trunk\\Orders.csv";
//        OrderManagement orderManagement=new OrderManagement();
//        ArrayList<String> shops=orderManagement.readOrderIds(csvOrders);
//        if(!shops.contains(data[0]))
//            return false;
//        try {
//            Integer.parseInt(data[1]);
//            Double.parseDouble(data[2]);
//            Integer.parseInt(data[3]);
//            Integer.parseInt(data[4]);
//        } catch (NumberFormatException e) {
//            return false;
//        }
//        if(!(data[4].equals("0")||data[4].equals("1")))
//            return false;
//        return true;
//    }
//
//    public void addProductInCSV(String readFilename, String writeFilename) throws IOException {
//        ArrayList<String> Products = new ArrayList<>();
//        String line = null;
//        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(readFilename)));
//        while ((line = in.readLine()) != null) {
//            Products.add(line);
//        }
//        String COMMA_DELIMITER = ";";
//        String NEW_LINE_SEPARATOR = "\n";
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(writeFilename, true);
//            for (String Product : Products) {
//                String[] sp = Product.split(";");
//                if (sp.length == 5) {
//                    ArrayList<String> productList = addProduct(sp, writeFilename);
//                    if(productList.size()!=0) {
//                        fileWriter.append(productList.get(0));
//                        fileWriter.append(COMMA_DELIMITER);
//                        fileWriter.append(productList.get(1));
//                        fileWriter.append(COMMA_DELIMITER);
//                        fileWriter.append(productList.get(2));
//                        fileWriter.append(COMMA_DELIMITER);
//                        fileWriter.append(productList.get(3));
//                        fileWriter.append(COMMA_DELIMITER);
//                        fileWriter.append(productList.get(4));
//                        fileWriter.append(COMMA_DELIMITER);
//                        fileWriter.append(productList.get(5));
//                        fileWriter.append(NEW_LINE_SEPARATOR);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void changeProduct(String readFilename, String writeFilename) throws Exception {
//        ArrayList<String> orders = new ArrayList<>();
//        String line = null;
//        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(readFilename)));
//        while ((line = in.readLine()) != null) {
//            orders.add(line);
//        }
//        CSVReader reader = new CSVReader(new FileReader(writeFilename), ';');
//        for (String order : orders) {
//            String[] sp = order.split(";");
//            String[] spp=new String[5];
//            spp[0]=sp[0]; spp[1]=sp[2]; spp[2]=sp[3]; spp[3]=sp[4]; spp[4]=sp[5];
//            if (sp.length == 6&validateData(spp)) {
//                List<String[]> csvBody = reader.readAll();
//                ArrayList<String> Ids = readProductIds(writeFilename);
//                csvBody.get(Ids.indexOf(sp[1])+1)[0]=sp[0];
//                csvBody.get(Ids.indexOf(sp[1])+1)[2]=sp[2];
//                csvBody.get(Ids.indexOf(sp[1])+1)[3]=sp[3];
//                csvBody.get(Ids.indexOf(sp[1])+1)[4]=sp[4];
//                csvBody.get(Ids.indexOf(sp[1])+1)[5]=sp[5];
//                reader.close();
//                CSVWriter writer = new CSVWriter(new FileWriter(writeFilename), ';');
//                writer.writeAll(csvBody);
//                writer.flush();
//                writer.close();
//            }
//        }
//    }
//}
