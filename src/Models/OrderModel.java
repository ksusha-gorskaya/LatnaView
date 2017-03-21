package Models;

import Exceptions.EditException;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Nikolay Kanatov on 01.03.2017.
 */
public class OrderModel {
    private final SimpleStringProperty IndexOfShop;
    private final SimpleStringProperty Wtf;
    private final SimpleStringProperty Deadline;
    private final SimpleStringProperty DeliverySide;

    @Override
    public String toString(){
        return IndexOfShop.getValue()+";"+Wtf.getValue()
                +";"+Deadline.getValue()+";"+DeliverySide.getValue();
    }

    public int getCountField(){return 4;}

    public OrderModel(String indexOfShop,String wtf, String deadline, Expedition deliverySide){
        IndexOfShop=new SimpleStringProperty(indexOfShop);
        Wtf = new SimpleStringProperty(wtf);
        Deadline = new SimpleStringProperty(deadline);
        DeliverySide = new SimpleStringProperty(deliverySide.name());
    }
    public OrderModel(String model){
        String[] tmp = model.split(";");
        IndexOfShop=new SimpleStringProperty(tmp[0]);
        Wtf = new SimpleStringProperty(tmp[1]);
        Deadline = new SimpleStringProperty(tmp[2]);
        DeliverySide = new SimpleStringProperty(tmp[3]);
    }
    public String getIndexOfShop(){return IndexOfShop.get();}
    public void setIndexOfShop(String index){IndexOfShop.set(index);}

    public String getDeadline(){return Deadline.get();}
    public void setDeadline(String deadline){Deadline.set(deadline);}

    public String getDeliverySide(){return DeliverySide.get();}
    public void setDeliverySide(String side){DeliverySide.set(side);}

    public String getWtf(){return Wtf.get();}
    public void setWtf(String wtf){Wtf.set(wtf);}

    public void applyEdit(String str,int column) throws EditException{
        if(column==0) {Long.parseLong(str);setIndexOfShop(str);}
        if(column==1) setWtf(str);
        if(column==2) setDeadline(str);
        if(column==3) setDeliverySide(str);
    }
}
