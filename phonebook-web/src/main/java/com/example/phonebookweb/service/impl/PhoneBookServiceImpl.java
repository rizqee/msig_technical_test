package com.example.phonebookweb.service.impl;

import com.example.phonebookweb.entity.PhoneBook;
import com.example.phonebookweb.repository.PhoneBookRepository;
import com.example.phonebookweb.service.PhoneBookService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    private final PhoneBookRepository repository;
    public PhoneBookServiceImpl(PhoneBookRepository repository){
        this.repository = repository;
    }
    @Override
    public PhoneBook addNewPhoneBook(PhoneBook phoneBook){
        return repository.save(phoneBook);
    }
    public List<PhoneBook> fetchAllPhoneBook(){
        return repository.findAll();
    }

    @Override
    public PhoneBook updatePhoneBook(PhoneBook phoneBook, Integer id) {
        PhoneBook oldPhoneBook = repository.findById(id).orElse(null);
        if(Objects.nonNull(oldPhoneBook)){
            if(!phoneBook.getName().isBlank() && !phoneBook.getName().equalsIgnoreCase(oldPhoneBook.getName())){
                oldPhoneBook.setName(phoneBook.getName());
            }
            if(!phoneBook.getPhoneNumber().isBlank() && !phoneBook.getPhoneNumber().equalsIgnoreCase(oldPhoneBook.getPhoneNumber())){
                oldPhoneBook.setPhoneNumber(phoneBook.getPhoneNumber());
            }
            if(!phoneBook.getAddress().isBlank() && !phoneBook.getAddress().equalsIgnoreCase(oldPhoneBook.getAddress())){
                oldPhoneBook.setAddress(phoneBook.getAddress());
            }
        }
        return repository.save(phoneBook);
    }

    @Override
    public void deletePhoneBook(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public PhoneBook fetchPhoneBookByID(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
