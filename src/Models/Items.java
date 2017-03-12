package Models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by User on 01.03.2017.
 */
public class Items {
    private Vector<ItemModel> items;

    public Items(String filename) throws Exception
    {
        items = new Vector<>();
        readFromFile(filename);
    };

    public void readFromFile(String filename) throws Exception
    {
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            line = br.readLine();
            while((line = br.readLine()) != null){
                String[] elements = line.split(";");
                //shelf,index,-,volume,rigidity
                ItemModel it;
                it = new ItemModel(elements[0],Long.parseLong(elements[1]),Integer.parseInt(elements[2]),
                        Double.parseDouble(elements[3].replaceAll(" ","")),Integer.parseInt(elements[4]));

                items.add(it);
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
    };

    public final ItemModel getItem(int index)
    {
        return items.get(index);
    };

    public void addItem(ItemModel item){
        items.add(item);
    }

    public void deleteItem(int index){
        items.remove(index+1);
    }

    public final int getSize(){
        return items.size();
    }

    public final Vector <ItemModel> getItems(){
        return items;
    }

    public boolean isExist(long index) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIndex() == index) {
                return true;
            }
        }
        return false;
    }
    public ItemModel[] toItemsArray(){
        ItemModel[] array=new ItemModel[items.size()];
        for (int i=0;i<items.size();i++){
            array[i]=items.get(i);
        }
        return array;
    }
    public List<String[]> toStringList(){
        List<String[]> list =new ArrayList<>(items.size());
        for (ItemModel item: items ) {
            list.add(item.toString().split(";"));
        }
        return list;
    }
    public String[] getHeaders(){
        return new String[]{"MO","Index","Count","Volume","Rigidity"};
    }
}
