package com.example.demo.Service;

import com.twilio.Twilio;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;

public class OtpService {

    public static void main(String[] args) {
        try {
            Twilio.init("AC4d3b875b9679b502151c921067ca5cce", "6752a2c59e434abc5e69ab7562f89f30");

            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("+91" + "8523963885"),
                    new com.twilio.type.PhoneNumber("+13417991033"),
                    "Your OTP is: " + "0402")
                    .create();

            System.out.println("OTP sent successfully. SID: " + message.getSid());
        } catch (TwilioException e) {
            // Handle Twilio exception (e.g., log the error)
            e.printStackTrace();
        }

    }
}
