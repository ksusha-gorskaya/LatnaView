package Models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Parent;

/**
 * Created by Ксения Горская on 11.03.2017.
 */
public class ParameterModel {
    private final SimpleStringProperty Parameter;
    private final SimpleStringProperty Value;

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
}
