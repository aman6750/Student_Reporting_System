package com.saleken;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchRepo extends ElasticsearchRepository<Students, String> {

    public double findAveragePercentageInRecentSemester() throws Exception;

    public double findAverageMarksOfStudents(String subjectName) throws Exception;

    public String findTop2ConsistentStudents() throws Exception;



}
