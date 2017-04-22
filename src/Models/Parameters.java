package Models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Ксения Горская on 11.03.2017.
 */
public class Parameters {
    private Vector<ParameterModel> parameters;

    public Parameters(String filePath) throws Exception
    {
        parameters = new Vector<>();
        readFromFile(filePath);
    }

    public void addParameter(ParameterModel model){
        parameters.add(model);
    }
    private void readFromFile(String filePath) throws Exception
    {
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while((line=br.readLine())  != null){
                String[] elements = line.split(";");
                if (elements.length == 0) {
                    break;
                }
                ParameterModel p = new ParameterModel(elements[0], elements[1]);
                parameters.add(p);
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

    public final ParameterModel getParameter(int index)
    {
        return parameters.get(index);
    }

    public String[] getHeaders(){
        return new String[]{"Parameter","Value"};
    }
    public void deleteItem(int index){
        parameters.remove(index+1);
    }

    public ParameterModel[] toParametersArray(){
        ParameterModel[] array=new ParameterModel[parameters.size()];
        for (int i=0;i<parameters.size();i++){
            array[i]=parameters.get(i);
        }
        return array;
    }
    public List<String[]> toStringList(){
        List<String[]> list =new ArrayList<>(parameters.size());
        for (ParameterModel item: parameters ) {
            list.add(item.toString().split(";"));
        }
        return list;
    }

}
