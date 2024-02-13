package com.example.demo.Service;

import com.example.demo.Config.TwilioConfig;
import com.example.demo.DTO.GlobalResponseDTO;
import com.twilio.Twilio;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService implements ITestInterface{

    @Autowired
    private TwilioConfig twilioConfig;

    @Override
    public String generateOtp() {
        // Implement your OTP generation logic here (e.g., using Random)
        // Return the generated OTP
        return "0402";
    }

    @Override
    public GlobalResponseDTO sendOtp(String mobileNumber, String otp) {
        GlobalResponseDTO res = new GlobalResponseDTO();
        try {
            Twilio.init(twilioConfig.getTwilioaccountSid(), twilioConfig.getTwilioauthToken());

            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("+91" + mobileNumber),
                    new com.twilio.type.PhoneNumber(twilioConfig.getTwilioPhoneNumber()),
                    "Your OTP is: " + otp)
                    .create();

            System.out.println("OTP sent successfully. SID: " + message.getSid());
        } catch (TwilioException e) {
            // Handle Twilio exception (e.g., log the error)
            e.printStackTrace();
        }
        res.setMessage("OTP Sent Successfully!!!");
        return res;

    }

    @Override
    public GlobalResponseDTO sendWhatsAppMessage(String to, String msg) {
        GlobalResponseDTO res = new GlobalResponseDTO();
        try {
            Twilio.init(twilioConfig.getTwilioaccountSid(), twilioConfig.getTwilioauthToken());

            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:+91" + to),
                    new com.twilio.type.PhoneNumber("whatsapp:"+twilioConfig.getTwilioWhatsAppNumber()),
                    msg)
                    .create();

            System.out.println("What's App Message sent successfully. SID: " + message.getSid());
        } catch (TwilioException e) {
            // Handle Twilio exception (e.g., log the error)
            e.printStackTrace();
        }
        res.setMessage("What's App Message sent successfully!!!");
        return res;

    }
}
