package com.example.emailapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.emailapp.entitymodel.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
