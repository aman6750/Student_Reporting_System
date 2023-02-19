package com.saleken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class UIController {

    @Autowired
    private ElasticSearchQuery elasticSearch;

    @GetMapping("/")
    public String viewHomePage(Model model) throws IOException {
        model.addAttribute("listStudentsDocuments",elasticSearch.searchAllDocuments());
        return "index";
    }

    @PostMapping("/saveStudent")
    public String saveProduct(@ModelAttribute("Students") Students students) throws IOException {
    	elasticSearch.createOrUpdateDocument(students);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) throws IOException {

        Students students = elasticSearch.getDocumentById(id);
        model.addAttribute("product", students);
        return "updateStudentsDocument";
    }

    @GetMapping("/shownewForm")
    public String showStudentForm(Model model) {
        // create model attribute to bind form data
        Students students = new Students();
        model.addAttribute("students", students);
        return "newStudentsDocument";
    }

    @GetMapping("/deleteStudentByid/{id}")
    public String deleteProduct(@PathVariable(value = "id") String id) throws IOException {

        this.elasticSearch.deleteDocumentById(id);
        return "redirect:/";
    }
}
