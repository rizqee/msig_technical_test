package com.example.phonebookweb.service;

import com.example.phonebookweb.entity.PhoneBook;

import java.util.List;

public interface PhoneBookService {
    public PhoneBook addNewPhoneBook(PhoneBook phoneBook);
    public List<PhoneBook> fetchAllPhoneBook();
    public PhoneBook updatePhoneBook(PhoneBook phoneBook,Integer id);
    public void deletePhoneBook(Integer id);
    public PhoneBook fetchPhoneBookByID(Integer id);
}
