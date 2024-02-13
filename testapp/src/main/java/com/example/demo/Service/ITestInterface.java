package com.example.demo.Service;

import com.example.demo.DTO.GlobalResponseDTO;

public interface ITestInterface {
    String generateOtp();

    GlobalResponseDTO sendOtp(String mobileNumber, String otp);

    GlobalResponseDTO sendWhatsAppMessage(String to, String msg);
}
