package sirma.academy.employeeproject.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HelperFunctions {
    private static long intersectRanges(Range firstRange, Range secondRange) {
        LocalDate startDate = firstRange.getStartDate().isBefore(secondRange.getStartDate()) ? secondRange.getStartDate() : firstRange.getStartDate();
        LocalDate endDate = firstRange.getEndDate().isBefore(secondRange.getEndDate()) ? firstRange.getEndDate() : secondRange.getEndDate();

        if (ChronoUnit.DAYS.between(startDate, endDate) > 0) {
            return ChronoUnit.DAYS.between(startDate, endDate);
        }

        return 0;
    }

    private static long getTimeTogetherOnProject(Map<Integer, Range> firstEmployeeProjects, Map<Integer, Range> secondEmployeeProjects) {
        long timeTogether = 0;

        for (Integer project : firstEmployeeProjects.keySet()) {
            if (secondEmployeeProjects.containsKey(project)) {
                timeTogether += intersectRanges(firstEmployeeProjects.get(project), secondEmployeeProjects.get(project));
            }
        }
        
        return timeTogether;
    }

    public static String getPairWithLongestTimeTogether(Map<Integer, Map<Integer, Range>> records) {
        Integer pairFirstEmployee = 0;
        Integer pairSecondEmployee = 0;
        long longestTimeTogether = 0;
        List<Integer> employees = new ArrayList<>(records.keySet());

        for (int i = 0; i < employees.size() - 1; i++) {
            Integer firstEmployee = employees.get(i);
            for (int j = i + 1; j < employees.size(); j ++) {
                Integer secondEmployee = employees.get(j);

                long timeTogether = getTimeTogetherOnProject(records.get(firstEmployee), records.get(secondEmployee));

                if (longestTimeTogether < timeTogether) {
                    pairFirstEmployee = firstEmployee;
                    pairSecondEmployee = secondEmployee;
                    longestTimeTogether = timeTogether;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder("Employee 1: " + pairFirstEmployee + " Employee 2: " + pairSecondEmployee + " Time worked together: " + longestTimeTogether + " Projects: { ");
        Map<Integer, Range> firstEmployeeProjects = records.get(pairFirstEmployee);
        Map<Integer, Range> secondEmployeeProjects = records.get(pairSecondEmployee);

        for (Integer project : firstEmployeeProjects.keySet()) {
            if (secondEmployeeProjects.containsKey(project)) {
                long timeWorkTogetherOnProject = intersectRanges(firstEmployeeProjects.get(project), secondEmployeeProjects.get(project));

                if (timeWorkTogetherOnProject > 0) {
                    stringBuilder.append("Project: " + project + " Time on project: " + timeWorkTogetherOnProject + "; ");
                }
            }
        }

        return stringBuilder.append("}").toString();
    }
}
