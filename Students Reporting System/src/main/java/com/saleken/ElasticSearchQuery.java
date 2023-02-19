package com.saleken;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ElasticSearchQuery {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Autowired
    private ElasticSearchRepo elasticRepo;

    private final String indexName = "students";


    public String createOrUpdateDocument(Students students) throws IOException {

        IndexResponse response = elasticsearchClient.index(i -> i
                .index(indexName)
                .id(students.getStudentRollNo())
                .document(students)
        );
        if(response.result().name().equals("Created")){
            return new StringBuilder("Document has been successfully created.").toString();
        }else if(response.result().name().equals("Updated")){
            return new StringBuilder("Document has been successfully updated.").toString();
        }
        return new StringBuilder("Error while performing the operation.").toString();
    }

    public double getAveragePercentageOfWholeClassInRecentSemester() throws Exception{
        return elasticRepo.findAveragePercentageInRecentSemester();
    }

    public double getAverageMarksOfStudentsInASubject(String subjectName) throws Exception{
        return elasticRepo.findAverageMarksOfStudents(subjectName);
    }

    public String getTop2ConsistentStudentsAcrossAllSemesters() throws Exception{
        return elasticRepo.findTop2ConsistentStudents();
    }

    public Students getDocumentById(String studentRollNo) throws IOException{
        Students students = null;
        GetResponse<Students> response = elasticsearchClient.get(g -> g
                        .index(indexName)
                        .id(studentRollNo),
                Students.class);

        if (response.found()) {
            students = response.source();
            System.out.println("Student name " + students.getStudentName());
        } else {
            System.out.println ("Student not found");
        }

        return students;
    }

    public String deleteDocumentById(String productId) throws IOException {

        DeleteRequest request = DeleteRequest.of(d -> d.index(indexName).id(productId));

        DeleteResponse deleteResponse = elasticsearchClient.delete(request);
        if (Objects.nonNull(deleteResponse.result()) && !deleteResponse.result().name().equals("NotFound")) {
            return new StringBuilder("Student with id " + deleteResponse.id() + " has been deleted.").toString();
        }
        System.out.println("Student not found");
        return new StringBuilder("Student with id " + deleteResponse.id()+" does not exist.").toString();

    }

    public  List<Students> searchAllDocuments() throws IOException {

        SearchRequest searchRequest =  SearchRequest.of(s -> s.index(indexName));
        SearchResponse searchResponse =  elasticsearchClient.search(searchRequest, Students.class);
        List<Hit> hits = searchResponse.hits().hits();
        List<Students> students = new ArrayList<>();
        for(Hit object : hits){

            System.out.print(((Students) object.source()));
            students.add((Students) object.source());

        }
        return students;
    }





}
