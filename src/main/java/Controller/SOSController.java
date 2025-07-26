package Controller;

import DTO.SOSRequestDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SOSController {
    @PostMapping("/sos")
    public ResponseEntity<String> sendSOS(@RequestBody SOSRequestDTO sosRequestDTO){
        System.out.println("SOS triggered !! Message: " + sosRequestDTO.getMessage() + ", Phone: " + sosRequestDTO.getPhoneNumber());

        //will implement sms as well as email service
        return ResponseEntity.ok("SOS message sent successfully.");
    }
}
