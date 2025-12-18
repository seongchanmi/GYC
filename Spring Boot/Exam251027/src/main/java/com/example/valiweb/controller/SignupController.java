package com.example.valiweb.controller;

import com.example.valiweb.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import javax.swing.*;

@Controller
public class SignupController {

    @GetMapping("/signup")
    public String showInput(@ModelAttribute("userDto") UserDto user){
        return "form/signup";
    }

    @PostMapping("/result")
    public String showOutput(@ModelAttribute("userDto") UserDto user, Model model){
        model.addAttribute("dto", user);
        return "form/signup-result";
    }

}
