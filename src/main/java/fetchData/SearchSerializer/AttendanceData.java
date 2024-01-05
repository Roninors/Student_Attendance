package fetchData.SearchSerializer;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceData {
    private final Map<String, SectionData> csc200 = new HashMap<>();

    @JsonAnySetter
    public void setCsc200(String key, SectionData value) {
        csc200.put(key, value);
    }

    public Map<String, SectionData> getCsc200() {
        return csc200;
    }

    public static class SectionData {
        @JsonProperty("total_students")
        private int totalStudents;

        @JsonProperty("data")
        private Map<String, List<Student>> sectionData = new HashMap<>();

        public int getTotalStudents() {
            return totalStudents;
        }

        public Map<String, List<Student>> getSectionData() {
            return sectionData;
        }
    }
}