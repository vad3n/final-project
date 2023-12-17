package sirma.academy.employeeproject.repository;

import java.util.HashMap;
import java.util.Map;

import sirma.academy.employeeproject.utils.CsvParser;
import sirma.academy.employeeproject.utils.HelperFunctions;
import sirma.academy.employeeproject.utils.Range;

import org.springframework.stereotype.Repository;

@Repository
public class PairRepository {

    public String getPair() {
        Map<Integer, Map<Integer, Range>> records = new HashMap<>();

        CsvParser.loadData(records);
        return HelperFunctions.getPairWithLongestTimeTogether(records);
    }
}
