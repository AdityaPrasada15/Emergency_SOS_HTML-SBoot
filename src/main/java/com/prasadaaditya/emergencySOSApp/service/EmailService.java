package com.prasadaaditya.emergencySOSApp.service;

import com.prasadaaditya.emergencySOSApp.dto.SOSRequestDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendSosEmail(SOSRequestDTO sosRequestDTO) throws MessagingException {

        //get the current date & time
        LocalDateTime localDateTime = LocalDateTime.now();
        String currentDateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        //get the IP address
        String ipAddress;
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        //get the ISP address and location-- later implementation with external API

        //Message to be sent
        String message = "\n SOS Alert \n" +
                         "----------------\n" +
                         "Message: " + sosRequestDTO.getMessage() + "\n" +
                         "Phone: " + sosRequestDTO.getPhoneNumber() + "\n" +
                         "IP Address: " + ipAddress + "\n" +
                         "Time: " +currentDateTime;

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setSubject("EMERGENCY SoS Alert!!");
        mimeMessageHelper.setTo("adityaprasada97@yahoo.com");
        mimeMessageHelper.setText("Hi, I need help ASAP. PFB the details. Please connect with me. \n\n\n" + message);

        //location will be a part of the message- will implement later.
        //mimeMessageHelper.addAttachment();  //later will be used to send the photo

        mimeMessageHelper.setFrom("aditya257661@gmail.com");  //name

        //send the mail
        javaMailSender.send(mimeMessage);
        System.out.println("Mail sent successfully");

    }
}
