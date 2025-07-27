package com.prasadaaditya.emergencySOSApp.controller;

import com.prasadaaditya.emergencySOSApp.dto.SOSRequestDTO;
import com.prasadaaditya.emergencySOSApp.service.EmailService;
import com.prasadaaditya.emergencySOSApp.service.SmsService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SOSController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private SmsService smsService;

    @PostMapping("/sos")
    public ResponseEntity<String> sendSOS(@RequestBody SOSRequestDTO sosRequestDTO) throws MessagingException {
        //System.out.println("SOS triggered !! Message: " + sosRequestDTO.getMessage() + ", Phone: " + sosRequestDTO.getPhoneNumber());

        //will implement sms as well as email service

        //calling email_service
        try {
            System.out.println("Sending SOS email....");
            emailService.sendSosEmail(sosRequestDTO);
            System.out.println("Email Sent.");
            return ResponseEntity.ok("SOS message sent successfully.");
        } catch (MessagingException e){
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to send SOS email.");
        }

        //calling sms_service
        //smsService.sendSosSms(sosRequestDTO);

    }
}
