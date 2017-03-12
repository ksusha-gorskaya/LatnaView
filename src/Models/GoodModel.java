package Models;

import Exceptions.EditException;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by ksgo0816 on 10.03.2017.
 */
public class GoodModel {
    //"IndexOfShop","IndexOfProduct","InPieces","InLiters", "InBoxes", "1-in pieces, 0-in boxes"
    private final SimpleStringProperty IndexOfShop;
    private final SimpleStringProperty IndexOfProduct;
    private final SimpleStringProperty InPieces;
    private final SimpleStringProperty InLiters;
    private final SimpleStringProperty InBoxes;
    private final SimpleStringProperty OneZero;

    @Override
    public String toString(){
        return IndexOfShop.getValue()+";"+IndexOfProduct.getValue()+";"+InPieces.getValue()+
                ";"+InLiters.getValue()+";"+InBoxes.getValue()+";"+OneZero.getValue();
    }
    public int getCountField(){return 6;}

    public GoodModel(String indexOfShop, String indexOfProduct, String inpieces, String inliters, String inboxes, String onezero){
        IndexOfShop = new SimpleStringProperty(indexOfShop);
        IndexOfProduct = new SimpleStringProperty(indexOfProduct);
        InPieces = new SimpleStringProperty(inpieces);
        InLiters = new SimpleStringProperty(inliters);
        InBoxes = new SimpleStringProperty(inboxes);
        OneZero = new SimpleStringProperty(onezero);
    }
    public GoodModel(String model){
        String[] tmp = model.split(";");
        IndexOfShop=new SimpleStringProperty(tmp[0]);
        IndexOfProduct =  new SimpleStringProperty(tmp[1]);
        InPieces = new SimpleStringProperty(tmp[2]);
        InLiters = new SimpleStringProperty(tmp[3]);
        InBoxes = new SimpleStringProperty(tmp[4]);
        OneZero = new SimpleStringProperty(tmp[5]);
    }

    public String getIndexOfShop() {
        return IndexOfShop.get();
    }

    public void setIndexOfShop(String indexOfShop) {
        this.IndexOfShop.set(indexOfShop);
    }

    public String getIndexOfProduct() {
        return IndexOfProduct.get();
    }

    public void setIndexOfProduct(String indexOfProduct) {
        this.IndexOfProduct.set(indexOfProduct);
    }

    public String getInPieces() {
        return InPieces.get();
    }

    public void setInPieces(String inPieces) {
        this.InPieces.set(inPieces);
    }

    public String getInLiters() {
        return InLiters.get();
    }

    public void setInLiters(String inLiters) {
        this.InLiters.set(inLiters);
    }

    public String getInBoxes() {
        return InBoxes.get();
    }

    public void setInBoxes(String inBoxes) {
        this.InBoxes.set(inBoxes);
    }

    public String getOneZero() {
        return OneZero.get();
    }

    public void setOneZero(String oneZero) {
        this.OneZero.set(oneZero);
    }

    public void applyEdit(String str,int column) throws EditException {
        if(column==0) {Long.parseLong(str);setIndexOfShop(str);}
        if(column==1) {Long.parseLong(str);setIndexOfProduct(str);}
        if(column==2) {Float.parseFloat(str);setInPieces(str);}
        if(column==3) {Float.parseFloat(str);setInLiters(str);}
        if(column==4) {Integer.parseInt(str);setInBoxes(str);}
        if(column==5) {Integer.parseInt(str);setOneZero(str);}
    }
}
