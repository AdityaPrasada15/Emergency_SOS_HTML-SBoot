package com.prasadaaditya.emergencySOSApp.service;

import com.prasadaaditya.emergencySOSApp.dto.SOSRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {

    @Value("${fast2sms.api.key}")
    private String fast2SmsApiKey;
    private static final String fast2SmsURL = "https://www.fast2sms.com/dev/bulkV2";

    public boolean sendSosSms(SOSRequestDTO sosRequestDTO) {
        //message and Ph no
        String message = "Hello, I Need help, Call me ASAP!!";
        String phoneNumber = "7008432050";
        try {
            RestTemplate restTemplate = new RestTemplate();

            // Headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.set("authorization", fast2SmsApiKey);

            // Body (format according to Fast2SMS docs)
            String body = "sender_id=FSTSMS&message=" + message +
                    "&route=v3&numbers=" + phoneNumber;

            HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    fast2SmsURL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

            // Success if HTTP 200 and contains success response
            return response.getStatusCode() == HttpStatus.OK && response.getBody().contains("true");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
