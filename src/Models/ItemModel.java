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

    @Override
    public String toString(){
        return MO.getValue()+";"+Index.getValue()+";"+Count.getValue()+";"+Volume.getValue()+";"+Rigidity.getValue();
    }
    public int getCountField(){return 5;}

    public ItemModel(String mo, Long index, Integer count, Double volume, Integer rigidity){

        MO = new SimpleStringProperty(mo);
        this.Index =new SimpleLongProperty(index);
        this.Count = new SimpleIntegerProperty(count);
        this.Volume = new SimpleDoubleProperty(volume);
        this.Rigidity = new SimpleIntegerProperty(rigidity);
    }
    public ItemModel(String model){
        String[] tmp = model.split(";");
        MO=new SimpleStringProperty(tmp[0]);
        this.Index=new SimpleLongProperty(Long.parseLong(tmp[1]));
        this.Count = new SimpleIntegerProperty(Integer.parseInt(tmp[2]));
        this.Volume=new SimpleDoubleProperty(Double.parseDouble(tmp[3]));
        this.Rigidity=new SimpleIntegerProperty(Integer.parseInt(tmp[4]));
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

    public void editCell(int count,String str){
        switch (count){
            case 0:
                setMO(str);
                break;
            case 1:
                setIndex(Long.parseLong(str));
                break;
            case 2:
                setCount(Integer.parseInt(str));
                break;
            case 3:
                setVolume(Double.parseDouble(str));
                break;
            case 4:
                setRigidity(Integer.parseInt(str));
                break;

        }
    }
}
