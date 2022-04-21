package com.senac.ac.service;

import com.senac.ac.models.EmailModel;
import com.senac.ac.models.StatusEmail;
import com.senac.ac.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {

        emailModel.setSendDateEmail(LocalDateTime.now());

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSuject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatus(StatusEmail.SENT);

        }
        catch (MailException e){
            emailModel.setStatus(StatusEmail.ERROR);

        }
        finally {

            return emailRepository.save(emailModel);

        }
    }
}