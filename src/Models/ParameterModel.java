package Models;

import Exceptions.EditException;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Ксения Горская on 11.03.2017.
 */
public class ParameterModel {
    private final SimpleStringProperty Parameter;
    private final SimpleStringProperty Value;

    @Override
    public String toString(){
        return Parameter.getValue()+";"+Value.getValue();
    }
    public int getCountField(){return 2;}

    public ParameterModel(String parameter, String value){
        Parameter = new SimpleStringProperty(parameter);
        Value = new SimpleStringProperty(value);
    }
    public ParameterModel(String model){
        String[] tmp = model.split(";");
        Parameter = new SimpleStringProperty(tmp[0]);
        Value = new SimpleStringProperty(tmp[1]);
    }
    public String getParameter() {
        return Parameter.get();
    }

    public void setParameter(String parameter) {
        this.Parameter.set(parameter);
    }

    public String getValue() {
        return Value.get();
    }

    public void setValue(String value) {
        this.Value.set(value);
    }

    public void applyEdit(String str, int column) throws EditException{
        if(column==0) setParameter(str);
        if(column==1) setValue(str);
    }
}
