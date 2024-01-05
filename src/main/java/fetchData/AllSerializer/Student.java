package fetchData.AllSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
public class Student {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("attendance")
    private List<Attendance> attendance;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }
}
