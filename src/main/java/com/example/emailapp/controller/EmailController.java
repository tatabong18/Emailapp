package com.example.emailapp.controller;
import com.example.emailapp.service.EmailService;
import com.example.emailapp.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import com.example.emailapp.entitymodel.Email;
import java.util.List;
import java.util.Optional;


@Controller
public class EmailController {
    private IEmailService emailService;

   @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String getAllEmails(Model model) {
       model.addAttribute("listEmails", emailService.getAllEmails());
        return "email/index";
    }

    @GetMapping("/emails/{id}")
    public String getEmailById(@PathVariable long id, Model model) throws EmailNotFoundException {
       Email emailById = emailService.getEmailById(id);
       if (emailById == null) throw new EmailNotFoundException();
       model.addAttribute("email", emailService.getEmailById(id));
       return "email/index2";
    }

    @GetMapping("/showNewEmailForm")
    public String showEmailRegisterForm(Model model) {
       Email email = new Email();
        model.addAttribute("email", email);
        return "email/new_email";
    }
    @PostMapping("/saveEmail")
    public String saveEmail(@ModelAttribute("email") @Valid Email email, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "email/new_email";
        }
        emailService.saveEmail(email);
        return "redirect:/";
    }
        @GetMapping("/showFormForUpdate/{id}")
        public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
            Email email;
            email = emailService.getEmailById(id);
            model.addAttribute("email", email);
            return "email/update_email";
        }

    @GetMapping("/deleteEmail/{id}")
    public String deleteEmail(@PathVariable(value = "id") Long id) {
       this.emailService.deleteEmail(id);
        return "redirect:/";
    }
    }
