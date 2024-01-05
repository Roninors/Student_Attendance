package fetchData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {

    private int total_students;
    private List <String> data;

    private String name;



    public int getTotalStudents(){
        return total_students;
    }

    public List <String> getLength(){
        return data;
    }

    public void setTotal_students(int total_students){
        this.total_students = total_students;
    }
    public void setLength(List <String> data){
        this.data = data;
    }

    @Override
    public  String toString(){
        return "Total Students:'" + total_students + '\'' + ", Data: " + data;
    }
}
