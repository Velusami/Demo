package com.example.demo.Controller;

import com.example.demo.DTO.GlobalResponseDTO;
import com.example.demo.DTO.WhatsAppNotificationRequest;
import com.example.demo.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("send-otp")
    public ResponseEntity<?> sendOtp(@RequestParam("mobileNo") String mobileNo){
        GlobalResponseDTO res = testService.sendOtp(mobileNo,"0402");
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/send-whatsapp")
    public void sendWhatsAppMessage(@RequestBody WhatsAppNotificationRequest request) {
        testService.sendWhatsAppMessage(request.getTo(), request.getMessage());
    }

}
