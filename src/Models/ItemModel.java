package Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Nikolay Kanatov on 01.03.2017.
 */
public class ItemModel {
    private final SimpleStringProperty MO;     //что-то
    private final SimpleLongProperty Index;//код товара
    private final SimpleIntegerProperty Count;     //количество
    private final SimpleDoubleProperty Volume; //объем
    private final SimpleIntegerProperty Rigidity;  //жесткость

    public int getCountField(){return 5;}

    public ItemModel(String mo, Long index, Integer count, Double volume, Integer rigidity){

        MO = new SimpleStringProperty(mo);
        this.Index =new SimpleLongProperty(index);
        this.Count = new SimpleIntegerProperty(count);
        this.Volume = new SimpleDoubleProperty(volume);
        this.Rigidity = new SimpleIntegerProperty(rigidity);
    }

    public final long getIndex(){
        return Index.get();
    }

    public final int getRigidity(){
        return Rigidity.get();
    }

    public final double getVolume() {
        return Volume.get();
    }

    public final String getMO(){return MO.get();}

    public final int getCount(){return Count.get();}

    public void setIndex(long index){ Index.set(index);    }

    public void setRigidity(int rigidity){
        Rigidity.set(rigidity);
    }

    public void setVolume (double volume){ Volume.set(volume);}

    public void setMO(String mo){ MO.set(mo); }

    public void setCount(int count){this.Count.set(count);}
}
