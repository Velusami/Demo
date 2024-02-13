package com.example.demo.Config;

import com.twilio.http.TwilioRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Value("${twilio.whatsapp.number}")
    private String twilioWhatsAppNumber;

    @Bean
    public TwilioRestClient twilioRestClient() {
        return new TwilioRestClient.Builder(accountSid, authToken).build();
    }

    public String getTwilioaccountSid() {
        return accountSid;
    }

    public String getTwilioauthToken() {
        return authToken;
    }

    public String getTwilioPhoneNumber() {
        return twilioPhoneNumber;
    }

    public String getTwilioWhatsAppNumber() {
        return twilioWhatsAppNumber;
    }

}
