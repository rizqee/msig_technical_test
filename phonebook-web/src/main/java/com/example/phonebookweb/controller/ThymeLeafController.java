package com.example.phonebookweb.controller;

import com.example.phonebookweb.entity.PhoneBook;
import com.example.phonebookweb.service.PhoneBookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ThymeLeafController {
    private final PhoneBookService phoneBookService;
    public ThymeLeafController(PhoneBookService phoneBookService){
        this.phoneBookService = phoneBookService;
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("phonebooks",phoneBookService.fetchAllPhoneBook());
        return "index";
    }
    @GetMapping("/add-form")
    public String showAddForm(PhoneBook phoneBook,Model model){
        model.addAttribute("phonebook",phoneBook);
        return "add-form";
    }
    @PostMapping("/add")
    public String addPhoneBook(@Valid PhoneBook phoneBook, Model model){
        phoneBookService.addNewPhoneBook(phoneBook);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Integer id,Model model){
        PhoneBook phoneBook = phoneBookService.fetchPhoneBookByID(id);
        model.addAttribute("phonebook",phoneBook);
        return "update-form";
    }
    @PostMapping("/update")
    public String updatePhoneBook(PhoneBook phoneBook,Model model){
        Integer id = phoneBook.getId();
        phoneBookService.updatePhoneBook(phoneBook,id);
        return "redirect:/";
    }
    @DeleteMapping("/delete/{id}")
    public String deletePhoneBook(@Valid@PathVariable("id") Integer id){
        phoneBookService.deletePhoneBook(id);
        return "redirect:/";
    }
}
