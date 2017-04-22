package Models;

import Exceptions.EditException;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Nikolay Kanatov on 01.03.2017.
 */
public class ItemModel {
    private final SimpleStringProperty MO;     //что-то
    private final SimpleStringProperty Index;//код товара
    private final SimpleStringProperty Count;     //количество
    private final SimpleStringProperty Volume; //объем
    private final SimpleStringProperty Rigidity;  //жесткость

    @Override
    public String toString(){
        return MO.getValue()+";"+Index.getValue()+";"+Count.getValue()+";"+Volume.getValue()+";"+Rigidity.getValue();
    }
    public int getCountField(){return 5;}

    public ItemModel(String mo, String index, String count, String volume, String rigidity){

        MO = new SimpleStringProperty(mo);
        this.Index =new SimpleStringProperty(index);
        this.Count = new SimpleStringProperty(count);
        this.Volume = new SimpleStringProperty(volume);
        this.Rigidity = new SimpleStringProperty(rigidity);
    }
    public ItemModel(String model){
        String[] tmp = model.split(";");
        MO=new SimpleStringProperty(tmp[0]);
        this.Index=new SimpleStringProperty(tmp[1]);
        this.Count = new SimpleStringProperty(tmp[2]);
        this.Volume=new SimpleStringProperty(tmp[3]);
        this.Rigidity=new SimpleStringProperty(tmp[4]);
    }


    public final String getIndex(){
        return Index.get();
    }

    public final String getRigidity(){
        return Rigidity.get();
    }

    public final String getVolume() {
        return Volume.get();
    }

    public final String getMO(){return MO.get();}

    public final String getCount(){return Count.get();}

    public void setIndex(String index){ Index.set(index);    }

    public void setRigidity(String rigidity){
        Rigidity.set(rigidity);
    }

    public void setVolume (String volume){ Volume.set(volume);}

    public void setMO(String mo){ MO.set(mo); }

    public void setCount(String count){this.Count.set(count);}

    public void applyEdit(String str,int column) throws EditException{
        if(column==0) setMO(str);
        if(column==1) {Long.parseLong(str);setIndex(str);}
        if(column==2) {Integer.parseInt(str);setCount(str);}
        if(column==3) {Double.parseDouble(str);setVolume(str);}
        if(column==4) {Integer.parseInt(str);setRigidity(str);}
    }
}
