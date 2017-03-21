package Models;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Nikolay Kanatov on 01.03.2017.
 */
public class OrderModel {
    private final SimpleLongProperty IndexOfShop;
    private final SimpleStringProperty Deadline;
    private final SimpleStringProperty DeliverySide;
    private final SimpleStringProperty Wtf;

    public int getCountField(){return 4;}

    public OrderModel(long indexOfShop,String wtf, String deadline, Expedition deliverySide){
        IndexOfShop=new SimpleLongProperty(indexOfShop);
        Wtf = new SimpleStringProperty(wtf);
        Deadline = new SimpleStringProperty(deadline);
        DeliverySide = new SimpleStringProperty(deliverySide.name());
    }

    public long getIndexOfShop(){return IndexOfShop.get();}
    public void setIndexOfShop(long index){IndexOfShop.set(index);}

    public String getDeadline(){return Deadline.get();}
    public void setDeadline(String deadline){Deadline.set(deadline);}

    public String getDeliverySide(){return DeliverySide.get();}
    public void setDeliverySide(String side){DeliverySide.set(side);}

    public String getWtf(){return Wtf.get();}
    public void setWtf(String wtf){Wtf.set(wtf);}

}
