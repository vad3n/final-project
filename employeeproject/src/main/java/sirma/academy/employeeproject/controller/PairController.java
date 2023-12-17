package sirma.academy.employeeproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sirma.academy.employeeproject.service.PairService;


@RestController
@RequestMapping("api/pair")
public class PairController {
    @Autowired
    private PairService pairService;

    @GetMapping()
    public ResponseEntity<?> getPair() {
        return new ResponseEntity<>(pairService.getPair(), HttpStatus.OK);
    }
}
