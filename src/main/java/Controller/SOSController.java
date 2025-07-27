package Controller;

import DTO.SOSRequestDTO;
import Service.EmailService;
import Service.SmsService;
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
        emailService.sendSosEmail();
        //calling sms_service
        smsService.sendSosSms(sosRequestDTO);



        return ResponseEntity.ok("SOS message sent successfully.");
    }
}
