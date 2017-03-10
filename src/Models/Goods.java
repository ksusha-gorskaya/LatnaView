package Models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
                GoodModel g = new GoodModel(Long.parseLong(elements[0]), Long.parseLong(elements[1]), Float.parseFloat(elements[2]), Float.parseFloat(elements[3]), Integer.parseInt(elements[4]), Integer.parseInt(elements[5]));
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
        return new String[]{"IndexOfShop","IndexOfProduct","InPieces","InLiters", "InBoxes", "1-inpieces"};
    }

    public GoodModel[] toGoodsArray(){
        GoodModel[] array=new GoodModel[goods.size()];
        for (int i=0;i<goods.size();i++){
            array[i]=goods.get(i);
        }
        return array;
    }
}
