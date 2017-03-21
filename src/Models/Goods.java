package Models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by ksgo0816 on 10.03.2017.
 */
public class Goods {
    private Vector<GoodModel> goods;

    public Goods(String filePath) throws Exception
    {
        goods = new Vector<>();
        readFromFile(filePath);
    }

    public void addGood(GoodModel model){
        goods.add(model);
    }
    public void deleteItem(int index){
        goods.remove(index+1);
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
                //"IndexOfShop","IndexOfProduct","InPieces","InLiters", "InBoxes", "1-in pieces, 0-in boxes"
                if (elements.length == 0) {
                    break;
                }
                elements[2] = elements[2].replace(",",".");
                elements[3] = elements[3].replace(",",".");
                GoodModel g = new GoodModel(elements[0],elements[1],elements[2],elements[3],elements[4],elements[5]);
                goods.add(g);
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

    public final GoodModel getGood(int index)
    {
        return goods.get(index);
    }

    public String[] getHeaders(){
        //return new String[]{"IndexOfShop","IndexOfProduct","InPieces","InLiters", "InBoxes", "1-inpieces,0-inboxes"};
        return new String[]{"IndexOfShop","IndexOfProduct","InPieces","InLiters", "InBoxes", "OneZero"};
    }

    public GoodModel[] toGoodsArray(){
        GoodModel[] array=new GoodModel[goods.size()];
        for (int i=0;i<goods.size();i++){
            array[i]=goods.get(i);
        }
        return array;
    }
    public List<String[]> toStringList(){
        List<String[]> list =new ArrayList<>(goods.size());
        for (GoodModel item: goods ) {
            list.add(item.toString().split(";"));
        }
        return list;
    }

}