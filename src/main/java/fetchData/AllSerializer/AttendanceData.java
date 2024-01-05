package fetchData.AllSerializer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class AttendanceData {

    @JsonProperty("csc200")
    private Map<String, Section> csc200;

    public Map<String, Section> getCsc200() {
        return csc200;
    }
}