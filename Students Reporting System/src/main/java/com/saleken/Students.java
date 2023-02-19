package com.saleken;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@Document(indexName = "students")
public class Students {

    @Id
    private String studentRollNo;

    @Field(type = FieldType.Text, name = "student_name")
    private String studentName;

    @Field(type = FieldType.Integer, name = "english_marks")
    private String englishMarks;

    @Field(type = FieldType.Integer, name = "maths_marks")
    private String mathsMarks;

    @Field(type = FieldType.Integer, name = "science_marks")
    private String scienceMarks;

    @Field(type = FieldType.Integer, name = "semester_number")
    private String semesterNumber;


}
