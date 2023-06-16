package com.example.emailapp.service;

import org.springframework.stereotype.Service;
import com.example.emailapp.entitymodel.Email;
import java.util.List;

@Service
public interface IEmailService {
    List<Email> getAllEmails();
    Email getEmailById(Long id);
    Email saveEmail(Email email);
    void deleteEmail(Long id);

}