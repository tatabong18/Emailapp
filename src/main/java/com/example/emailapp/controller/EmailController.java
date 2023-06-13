package com.example.emailapp.controller;

import com.example.emailapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;


@Controller
public class EmailController {
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/emails")
    public String showEmailList(Model model) {
        List<Email> emails = emailService.getAllEmails();
        model.addAttribute("emails", emails);
        return "emaillist";
    }

    @GetMapping("/emails/register")
    public String showEmailRegisterForm(Model model) {
        model.addAttribute("email", new Email());
        return "emailregister";
    }

    @PostMapping("/emails/register")
    public String registerEmail(
            @Valid @ModelAttribute("email") Email email,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "emailregister";
        }

        emailService.saveEmail(email);
        return "redirect:/emails";
    }

    @GetMapping("/emails/edit/{id}")
    public String showEmailEditForm(@PathVariable("id") Long id, Model model) {
        Email email = emailService.getEmailById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email ID: " + id));
        model.addAttribute("email", email);
        return "emailedit";
    }

    @PostMapping("/emails/edit/{id}")
    public String updateEmail(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("email") Email updatedEmail,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "emailedit";


            Email email = emailService.getEmailById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid email ID: " + id));
            email.getClass();
            emailService.saveEmail(email);
            return "redirect:/emails";
        }

        @GetMapping("/emails/delete/{id}")
        public String deleteEmail(@PathVariable("id") Long id) {
            emailService.deleteEmail(id);
            return "redirect:/emails";

        }
    }
}