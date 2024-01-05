package fetchData.AllSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
public class Section {
    @JsonProperty("total_students")
    private int totalStudents;

    @JsonProperty("data")
    private List<Student> data;

    public int getTotalStudents() {
        return totalStudents;
    }

    public List<Student> getData() {
        return data;
    }
}
