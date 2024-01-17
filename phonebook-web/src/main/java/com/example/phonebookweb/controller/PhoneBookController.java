package com.example.phonebookweb.controller;

import com.example.phonebookweb.entity.PhoneBook;
import com.example.phonebookweb.service.PhoneBookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phone_book")
public class PhoneBookController {
    private final PhoneBookService phoneBookService;
    public PhoneBookController(PhoneBookService phoneBookService){
        this.phoneBookService = phoneBookService;
    }
    @PostMapping("/add")
    public PhoneBook addPhoneBook(@Valid @RequestBody PhoneBook phoneBook){
        return phoneBookService.addNewPhoneBook(phoneBook);
    }
    @GetMapping("/get")
    public List<PhoneBook> getPhoneBookList(){
        return phoneBookService.fetchAllPhoneBook();
    }
    @GetMapping("/get/{id}")
    public PhoneBook getPhoneBookByID(@PathVariable("id")Integer id){
        return phoneBookService.fetchPhoneBookByID(id);
    }
    @PutMapping("/update")
    public PhoneBook updatePhoneBook(@Valid@RequestBody PhoneBook phoneBook){
        return phoneBookService.updatePhoneBook(phoneBook);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePhoneBook(@Valid@PathVariable("id") Integer id){
        phoneBookService.deletePhoneBook(id);
    }
}
