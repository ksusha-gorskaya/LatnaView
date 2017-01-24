package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Ксения Горская on 23.01.2017.
 */
public class Warehouse {
    private Integer directionOfMovement;
    private Vector<Point> northDelivery;
    private Vector<Point> southDelivery;
    private int numberOfRows;
    private Vector<Point> coordinatesUpperLeftVertexRow;
    private Vector<Point> coordinatesLowerRightVertexRow;
    private ArrayList<String[]> shelves;

    String line = "";
    BufferedReader br = null;

    public Warehouse() {
        super();
        northDelivery = new Vector<Point>();
        southDelivery = new Vector<Point>();
        numberOfRows = 0;
        coordinatesUpperLeftVertexRow = new Vector<Point>();
        coordinatesLowerRightVertexRow = new Vector<Point>();
    }

    public void clearAll() {
        try {
            northDelivery.clear();
            southDelivery.clear();
            coordinatesUpperLeftVertexRow.clear();
            coordinatesLowerRightVertexRow.clear();
        } catch (NullPointerException npe) {

        }
    }

    public Point createPointTmp(String[] elements, int i){
        Point tmp = new Point(0,0);
        String x="", y="";
        if (elements.length >= 1 || (elements[i].startsWith("(") && elements[i+1].endsWith(")"))) {
            x = elements[i].replace(",", ".").substring(2);
            y = elements[i + 1].replace(",", ".").substring(0, elements[i + 1].length() - 2);
            //System.out.println("x " + x + " y " + y);
        }
        try {
            tmp = new Point(x,y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public void readExpedition(Vector<Point> delivery) throws Exception {
        line = br.readLine();
        line = br.readLine();
        String[] elements = line.split(";");
        for (int i = 0; i < elements.length; i+=2) {
            Point tmp = createPointTmp(elements, i);
            delivery.add(tmp);
        }
    }

    public void readCoordinates(Vector<Point> coordinatesVertexRow) throws Exception {
        String[] elements = line.split(";");
        for (int i = 1; i < elements.length; i+=2) {
            Point tmp = createPointTmp(elements, i);
            coordinatesVertexRow.add(tmp);
        }
    }

    public void readShelves(int numberOfRows) throws Exception {
        shelves = new ArrayList<String[]>();

        while ((line = br.readLine()) != null) {
            String[] rows = line.split(";");
            shelves.add(rows);
        }
    }

    public void readWarehouse(String filename) throws Exception {
        clearAll();
        try {
            br = new BufferedReader(new FileReader(filename));
            line = br.readLine();
            String[] elements = line.split(";");
            try {
                directionOfMovement = Integer.parseInt(elements[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //System.out.println(directionOfMovement);

            readExpedition(northDelivery);

            /*for (int i=0; i<northDelivery.size(); i++){
                System.out.println(northDelivery.get(i).getX() + "; " + northDelivery.get(i).getY());
            }
            System.out.println();*/

            readExpedition(southDelivery);

            /*for (int i=0; i<southDelivery.size(); i++){
                System.out.println(southDelivery.get(i).getX() + "; " + southDelivery.get(i).getY());
            }
            System.out.println();*/

            line = br.readLine();//read number of rows
            elements = line.split(";");
            try {
                numberOfRows = Integer.parseInt(elements[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //System.out.println(numberOfRows);

            line = br.readLine();
            line = br.readLine();
            line = br.readLine();
            readCoordinates(coordinatesUpperLeftVertexRow);

            /*for (int i=0; i<coordinatesUpperLeftVertexRow.size(); i++){
                System.out.println(coordinatesUpperLeftVertexRow.get(i).getX() + "; " + coordinatesUpperLeftVertexRow.get(i).getY() );
            }
            System.out.println();*/

            line = br.readLine();
            readCoordinates(coordinatesLowerRightVertexRow);

            /*for (int i=0; i<coordinatesLowerRightVertexRow.size(); i++){
                System.out.println(coordinatesLowerRightVertexRow.get(i).getX() + "; " + coordinatesLowerRightVertexRow.get(i).getY());
            }
            System.out.println();*/

            line = br.readLine();
            readShelves(numberOfRows);

            /*for (int i=1; i<shelves.size(); i++){
                for (int j=1; j<shelves.get(i).length; j++) {
                    System.out.print(shelves.get(i)[j] + " ");
                }
                System.out.println();
            }*/

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
