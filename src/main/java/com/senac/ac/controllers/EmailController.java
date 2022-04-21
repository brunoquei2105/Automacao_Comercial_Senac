package com.senac.ac.controllers;

import com.senac.ac.DTO.EmailDto;
import com.senac.ac.models.EmailModel;
import com.senac.ac.service.EmailService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping(path = "/email/api")
@Api(value = "Email API")
public class EmailController {

    @Autowired
    private EmailService emailService;

    Logger _log = LoggerFactory.getLogger(EmailModel.class);

    @PostMapping(value = "/send_email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        try {

            BeanUtils.copyProperties(emailDto, emailModel);
            emailService.sendEmail(emailModel);

        }
        catch (MailException e){
            _log.error(new Date() + " :: " + _log.getName() + " :: " + e.getMessage());
            e.getMessage();
        }
        finally {
            return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
        }

    }
}