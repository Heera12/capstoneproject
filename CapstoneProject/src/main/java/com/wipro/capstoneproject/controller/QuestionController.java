package com.wipro.capstoneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.capstoneproject.entity.Questions;
import com.wipro.capstoneproject.service.QuestionServiceImp;

@RestController
@RequestMapping("/cap/project/quest")
public class QuestionController 
{
    @Autowired
    QuestionServiceImp service;
    
         
    @GetMapping("/questions")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Questions> listQuestions = service.listAll(keyword);
        model.addAttribute("listQuestions", listQuestions);
        model.addAttribute("keyword", keyword);
         
        return "questions";
    }
        @GetMapping("/new")
        public String recentlyAddedQuestions(Model model) {
            Questions question = new Questions();
            model.addAttribute("Questions", question);             
            return "recently_added_questions";
    }
        @PostMapping("/save")
        public String saveProduct(@ModelAttribute("question") Questions question) {
            service.save(question);
             
            return "redirect:/";
        }
        @PutMapping("/edit/{id}")
        public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("edit_product");
            Questions question = service.get(id);
            mav.addObject("question", question);
             
            return mav;
        }
        @DeleteMapping("/delete/{id}")
        public String deleteProduct(@PathVariable(name = "id") int id) {
            service.delete(id);
            return "redirect:/";       
        }
   }