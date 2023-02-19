package com.saleken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ElasticSearchController {

    @Autowired
    private ElasticSearchQuery elasticSearchq;


    @Autowired
    ElasticSearchController(ElasticSearchQuery elasticSearchQuery) {
        this.elasticSearchq = elasticSearchQuery;
    }

    @PostMapping("/UpdateDocument")
    public ResponseEntity<Object> createOrUpdateDocument(@RequestBody Students students) throws IOException {
        String response = elasticSearchq.createOrUpdateDocument(students);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findAverageInRecentSemester")
    public ResponseEntity<Object> findAveragePercentageOfWholeClassInRecentSemester() throws Exception {
        double response = elasticSearchq.getAveragePercentageOfWholeClassInRecentSemester();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findAverageMarksOfStudents")
    public ResponseEntity<Object> findAverageMarksOfStudentsInASubject(@RequestParam String subjectName) throws Exception {
        double response = elasticSearchq.getAverageMarksOfStudentsInASubject(subjectName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findTop2ConsistentStudents")
    public ResponseEntity<Object> findTop2ConsistentStudentsAcrossAllSemesters() throws Exception {
        String response = elasticSearchq.getTop2ConsistentStudentsAcrossAllSemesters();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getDoc")
    public ResponseEntity<Object> getDocumentById(@RequestParam String productId) throws IOException {
        Students students =  elasticSearchq.getDocumentById(productId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDoc")
    public ResponseEntity<Object> deleteDocumentById(@RequestParam String productId) throws IOException {
        String response =  elasticSearchq.deleteDocumentById(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/searchDoc")
    public ResponseEntity<Object> searchAllDocument() throws IOException {
        List<Students> students = elasticSearchq.searchAllDocuments();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }





}
