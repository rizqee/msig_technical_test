package com.example.phonebookweb.repository;

import com.example.phonebookweb.entity.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook,Integer> {
}
