package com.example.emailapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
