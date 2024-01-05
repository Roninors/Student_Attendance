package fetchData.AllSerializer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
public class Attendance {
    @JsonProperty("is_present")
    private boolean isPresent;

    @JsonProperty("date")
    private String date;

    public boolean isPresent() {
        return isPresent;
    }

    public String getDate() {
        return date;
    }

}
