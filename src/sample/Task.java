package sample;

import java.util.ArrayList;

/**
 * Created by Ксения Горская on 04.02.2017.
 */
public class Task {
    private Integer id;
    private String time;
    private ArrayList<String[]> listTask;

    public Task() {
        super();
        listTask = new ArrayList<>();
        id=0;
        time="";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<String[]> getListTask() {
        return listTask;
    }

    public void setListTask(ArrayList<String[]> listTask) {
        this.listTask = listTask;
    }
}
