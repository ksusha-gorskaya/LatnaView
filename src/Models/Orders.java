package Models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Nikolay Kanatov on 01.03.2017.
 */
public class Orders {
    private Vector<OrderModel> orders;

    public Orders(String filePath) throws Exception
    {
        orders = new Vector<>();
        readFromFile(filePath);
    }

    public void addOrder(OrderModel model){
        orders.add(model);
    }
    public void deleteItem(int index){
        orders.remove(index+1);
    }

    private void readFromFile(String filePath) throws Exception
    {
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            line = br.readLine();
            while((line=br.readLine())  != null){
                String[] elements = line.split(";");
                //indexForShop,-,time,expedition
                if (elements.length == 0) {
                    break;
                }

                String deadline = elements[2];
                Expedition exp = null;
                if (elements[3].equalsIgnoreCase("South")){
                    exp = Expedition.South;
                } else  if (elements[3].equalsIgnoreCase("North")) {
                    exp = Expedition.North;
                }

                OrderModel o = new OrderModel(Long.parseLong(elements[0]), elements[1], deadline, exp);
                orders.add(o);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public final OrderModel getOrder(int index)
    {
        return orders.get(index);
    }

    public String[] getHeaders(){
        return new String[]{"IndexOfShop","Wtf","Deadline","DeliverySide"};
    }

    public OrderModel[] toOrdersArray(){
        OrderModel[] array=new OrderModel[orders.size()];
        for (int i=0;i<orders.size();i++){
            array[i]=orders.get(i);
        }
        return array;
    }
    public List<String[]> toStringList(){
        List<String[]> list =new ArrayList<>(orders.size());
        for (OrderModel item: orders ) {
            list.add(item.toString().split(";"));
        }
        return list;
    }

}
