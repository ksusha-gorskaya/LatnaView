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

        //Order to index of storekeepers starts with 1, therefore added  empty st(as index 0)
        Storekeeper st = new Storekeeper();
        listStorekeeper.add(st);

        for (int i=1; i<=numberOfWarehousemen; i++){
            Storekeeper storekeeper = new Storekeeper();
            storekeeper.setId(i);
            storekeeper.setNumberOfTask(Integer.valueOf(InfoAboutWarehousemen.get(i)[1]));
            storekeeper.setSummLength(Double.valueOf(InfoAboutWarehousemen.get(i)[2].replace(",", ".")));
            storekeeper.setTimeOnMove(Integer.valueOf(InfoAboutWarehousemen.get(i)[3]));
            storekeeper.setTimeOnSort(Integer.valueOf(InfoAboutWarehousemen.get(i)[4]));
            storekeeper.setSummTime(Integer.valueOf(InfoAboutWarehousemen.get(i)[5]));
            listStorekeeper.add(storekeeper);
            /*System.out.println(storekeeper.getId() + " "
                + storekeeper.getNumberOfTask() + " "
                + storekeeper.getSummLength() + " "
                + storekeeper.getTimeOnMove() + " "
                + storekeeper.getTimeOnSort() + " "
                + storekeeper.getSummTime() + " ");*/
        }
    }

    public void parseAndSetTasksOfStorekeeper(ArrayList<Task> taskArrayList){
        String[] elements = line.split("\\[");
        String[] idStorekeeper = elements[0].split(" ");
        //System.out.println(Integer.parseInt(idStorekeeper[0]));
        String[] idTasks = elements[1].split("\\]");
        idTasks = idTasks[0].split(" ");
        Integer[] idTask = new Integer[idTasks.length];
        ArrayList<Task> tasksOfStorekeeper = new ArrayList<>();//need tasks of storekeeper 1
        for (int i=0; i<idTasks.length; i++){
            idTask[i] = Integer.parseInt(idTasks[i].split(";")[0]);
            tasksOfStorekeeper.add(taskArrayList.get(idTask[i]-1));
            //System.out.print(idTask[i] + " ");
        }

        listStorekeeper.get(Integer.parseInt(idStorekeeper[0])).setTasks(tasksOfStorekeeper);
        //System.out.println(listStorekeeper.get(1).getTasks().get(0).getListTask().get(0)[0]
        //        + " " + listStorekeeper.get(1).getTasks().get(1).getListTask().get(0)[0]);
        //listStorekeeper.get(1) = info about 1 storekeeper
        //listStorekeeper.get(1).getTasks().get(0) = get first task from list from 1 storekeeper
        //listStorekeeper.get(1).getTasks().get(0).getListTask().get(0)[0] = get first element of first task from list from 1 storekeeper
        //listStorekeeper.get(1).getTasks().get(1).getListTask().get(0)[0]) = get first element of second task from list from 1 storekeeper

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
            ArrayList<Task> taskArrayList = new ArrayList<>();

            while (((line = br.readLine()) != null) && (line.contains(":"))) {
                Task task = new Task();
                ArrayList<String[]> visitedCell = new ArrayList<>();
                String[] elements = line.split("\\[");
                String[] subElements = elements[0].split(" ");
                task.setId(Integer.parseInt(subElements[0]));
                //System.out.print(task.getId() + " ");
                subElements = elements[1].split(" ");
                task.setTime(subElements[3].split(";")[0]);
                //System.out.print(task.getTime() + " ");
                subElements = elements[2].split("\\]]");
                int index=0;
                subElements = subElements[0].split(" ");
                for (int i=0; i<subElements.length/2; i++)
                    visitedCell.add(new String[2]);
                for (int j=0; j<subElements.length; j+=2){
                    String[] cells = new String[2];
                    cells[0] = subElements[j].split(":")[0];
                    cells[1] = subElements[j+1].split(";")[0];
                    visitedCell.get(index)[0] = cells[0];
                    visitedCell.get(index)[1] = cells[1];
                    index++;
                }
                task.setListTask(visitedCell);
                /*if (task.getId()==2) {
                    for (int j = 0; j < task.getListTask().size(); j++) {
                        System.out.print(" " + task.getListTask().get(j)[0] + " " + task.getListTask().get(j)[1]);
                    }
                }*/
                //System.out.println();
                taskArrayList.add(task);
            }
            while (!line.contains("]")) {
                line = br.readLine();
            }
            parseAndSetTasksOfStorekeeper(taskArrayList);
            while ((line = br.readLine()) != null && (line.contains("]"))) {
                parseAndSetTasksOfStorekeeper(taskArrayList);
            }

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
