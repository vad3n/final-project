package sirma.academy.employeeproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sirma.academy.employeeproject.repository.PairRepository;

@Service
public class PairService {
    @Autowired
    private PairRepository pairRepository;

    public String getPair() {
        return pairRepository.getPair();
    }
}
