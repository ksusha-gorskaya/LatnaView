package sample;

import java.util.ArrayList;

/**
 * Created by Ксения Горская on 04.02.2017.
 */
public class Storekeeper {
    private Integer id;
    private ArrayList<Task> tasks;
    private Integer numberOfTask;//Число заданий
    private Double SummLength;//Суммарный пробег кладовщика в метрах
    private Integer timeOnMove;//Время, потраченное на движение (сек)
    private Integer timeOnSort;//Время, потраченное на отборку (сек)
    private Integer summTime;//Общее время (сек)

    public Storekeeper() {
        super();
        tasks = new ArrayList<>();
        numberOfTask=0;
        SummLength=null;
        timeOnMove=0;
        timeOnSort=0;
        summTime=0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Integer getNumberOfTask() {
        return numberOfTask;
    }

    public void setNumberOfTask(Integer numberOfTask) {
        this.numberOfTask = numberOfTask;
    }

    public Double getSummLength() {
        return SummLength;
    }

    public void setSummLength(Double summLength) {
        SummLength = summLength;
    }

    public Integer getTimeOnMove() {
        return timeOnMove;
    }

    public void setTimeOnMove(Integer timeOnMove) {
        this.timeOnMove = timeOnMove;
    }

    public Integer getTimeOnSort() {
        return timeOnSort;
    }

    public void setTimeOnSort(Integer timeOnSort) {
        this.timeOnSort = timeOnSort;
    }

    public Integer getSummTime() {
        return summTime;
    }

    public void setSummTime(Integer summTime) {
        this.summTime = summTime;
    }
}
