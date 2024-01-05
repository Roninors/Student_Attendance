package fetchData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fetchData.AllSerializer.Attendance;
import fetchData.AllSerializer.AttendanceData;
import fetchData.AllSerializer.Section;
import fetchData.AllSerializer.Student;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Search for a specific student");
            System.out.println("2. Get information about all students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1/2/3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    searchStudent();
                    break;
                case 2:
                    try {
                        getAllStudents();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void searchStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student name to search: ");
        String searchName = scanner.nextLine();

        // Call the method to search for the student
        try {
            searchStudentByName(searchName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchStudentByName(String searchName) throws Exception {
        try (HttpClient client = HttpClient.newHttpClient()) {
            // Modify the URI to include the search parameter
            URI uri = new URI("http://127.0.0.1:8000/api/student/search?search=" + searchName);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            handleResponse(response);
        }
    }

    private static void getAllStudents() throws Exception {
        try (HttpClient client = HttpClient.newHttpClient()) {
            URI uri = new URI("http://127.0.0.1:8000/api/all");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            handleResponse(response);
        }
    }

    private static void handleResponse(HttpResponse<String> response) throws Exception {
        int responseCode = response.statusCode();
        if (responseCode == 200) {
            ObjectMapper objectMapper = new ObjectMapper();

            // Print the raw JSON response for debugging
            System.out.println("Raw JSON Response:\n" + response.body());

            try {
                // Attempt to deserialize the JSON response
                AttendanceData attendanceData = objectMapper.readValue(response.body(), new TypeReference<AttendanceData>() {});

                // Access the data from the deserialized object
                for (Map.Entry<String, Section> entry : attendanceData.getCsc200().entrySet()) {
                    System.out.println("Section: " + entry.getKey());
                    for (Student student : entry.getValue().getData()) {
                        System.out.println("Student ID: " + student.getId());
                        System.out.println("Student Name: " + student.getName());

                        // Add more attributes as needed

                        System.out.println("Attendance:");
                        for (Attendance attendance : student.getAttendance()) {
                            System.out.println("Date: " + attendance.getDate() + ", Present: " + attendance.isPresent());
                        }
                        System.out.println("\n");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error during deserialization: " + e.getMessage());
            }
        } else {
            System.out.println("Cannot access API. HTTP Response Code: " + responseCode);
        }
    }
}
