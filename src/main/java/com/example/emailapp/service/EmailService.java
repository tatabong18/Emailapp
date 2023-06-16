package com.example.emailapp.service;

import com.example.emailapp.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.emailapp.entitymodel.Email;
import java.util.List;
import java.util.Optional;

@Service
public class EmailService implements IEmailService {
    private final EmailRepository emailRepository;
    private Email Id;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    public Email getEmailById(Long id) {
        Optional<Email> byId = emailRepository.findById(id);
        return Id;
       // optional conveys the absence of a value instead of returning null.
    }

    @Override
    public Email saveEmail(Email email) {
        return null;
    }

    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }
}

