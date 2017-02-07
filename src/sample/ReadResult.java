package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ksgo0816 on 27.01.2017.
 */
public class ReadResult {
    private Integer numberOfWarehousemen;
    private ArrayList<String[]> InfoAboutWarehousemen;
    private ArrayList<String[]> replenishment;
    private ArrayList<Storekeeper> listStorekeeper;

    String line = "";
    BufferedReader br = null;

    public void readInfoAboutWarehousemen(int numberOfWarehousemen) throws Exception {
        InfoAboutWarehousemen = new ArrayList<String[]>();

        for (int i=0; i<=numberOfWarehousemen; i++) {
            String[] rows = line.split(";");
            InfoAboutWarehousemen.add(rows);
            line = br.readLine();
        }
    }

    public void readReplenishment() throws Exception {
        replenishment = new ArrayList<String[]>();

        while ((line = br.readLine()) != null) {
            String[] rows = line.split(";");
            replenishment.add(rows);
        }
    }

    public void setListStorekeeper(){
        listStorekeeper = new ArrayList<>();
        Storekeeper storekeeper = new Storekeeper();
        for (int i=1; i<=numberOfWarehousemen; i++){
            storekeeper.setId(i);
            storekeeper.setNumberOfTask(Integer.valueOf(InfoAboutWarehousemen.get(i)[1]));
            storekeeper.setSummLength(Double.valueOf(InfoAboutWarehousemen.get(i)[2].replace(",", ".")));
            storekeeper.setTimeOnMove(Integer.valueOf(InfoAboutWarehousemen.get(i)[3]));
            storekeeper.setTimeOnSort(Integer.valueOf(InfoAboutWarehousemen.get(i)[4]));
            storekeeper.setSummTime(Integer.valueOf(InfoAboutWarehousemen.get(i)[5]));

            /*System.out.println(storekeeper.getId() + "  "
                    + storekeeper.getNumberOfTask() + "  "
                    + storekeeper.getSummLength() + "  "
                    + storekeeper.getTimeOnMove() + "  "
                    + storekeeper.getTimeOnSort() + "  "
                    + storekeeper.getSummTime() + "  ");*/
        }
    }

    public void readResult(String filename) throws Exception {
        try {
            br = new BufferedReader(new FileReader(filename));
            line = br.readLine();
            String[] elements = line.split(";");
            try {
                numberOfWarehousemen = Integer.parseInt(elements[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //System.out.println(numberOfWarehousemen);

            line = br.readLine();
            readInfoAboutWarehousemen(numberOfWarehousemen);

            //write all data in console
            /*for (int i=1; i<InfoAboutWarehousemen.size(); i++){
                for (int j=1; j<InfoAboutWarehousemen.get(i).length; j++) {
                    System.out.print(InfoAboutWarehousemen.get(i)[j] + " ");
                }
                System.out.println();
            }*/

            readReplenishment();

            //write all data in console
            /*for (int i=0; i<replenishment.size(); i++){
                for (int j=0; j<replenishment.get(i).length; j++) {
                    System.out.print(replenishment.get(i)[j] + " ");
                }
                System.out.println();
            }*/

            setListStorekeeper();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");
    }

    public void readLog(String filename) throws IOException{
        try {
            br = new BufferedReader(new FileReader(filename));
            line = br.readLine();
            line = br.readLine();
            //String[] elements = line.split(";");
            //String tmp = elements[0];
            //System.out.println(tmp);

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");
    }
}
