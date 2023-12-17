package sirma.academy.employeeproject.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Value;

public class CsvParser {
    //@Value("${file.name}")
    private static String fileName = "src/main/resources/file.csv";
    
    public static void loadData(Map<Integer, Map<Integer, Range>> records) {
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length != 4) {
                    System.out.println("Invalid data format: " + line);
                    continue;
                }

                Integer employeeId = Integer.parseInt(values[0]);
                Integer projectId = Integer.parseInt(values[1]);

                LocalDate startDate = DateHelper.parseDate(values[2]);
                LocalDate endDate = values[3].equals("NULL") ? LocalDate.now() : DateHelper.parseDate(values[3]);

                Range range = new Range(startDate, endDate);
                Map<Integer, Range> employeeProjects = records.getOrDefault(employeeId, new HashMap<>());
                employeeProjects.put(projectId, range);
                records.put(employeeId, employeeProjects);
            }
        } catch (Exception e) {
            System.out.println("Problem with file!");
            e.printStackTrace();
        }

    }
}
