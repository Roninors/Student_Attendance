package fetchData.SearchSerializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section {
    private int total_students;
    private List<Student> data;

    public int getTotal_students() {
        return total_students;
    }

    public void setTotal_students(int total_students) {
        this.total_students = total_students;
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Section{" +
                "total_students=" + total_students +
                ", data=" + data +
                '}';
    }
}

