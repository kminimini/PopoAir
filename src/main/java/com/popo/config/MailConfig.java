package com.popo.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

//    @Bean
//    public JavaMailSender javaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587); // Change port if needed
//        mailSender.setUsername("rladidgus78@gmail.com");
//        mailSender.setPassword("udta vcen bxpt jsph");
//
//        Properties properties = mailSender.getJavaMailProperties();
//        properties.put("mail.smtp.auth", true);
//        properties.put("mail.smtp.starttls.enable", true);
//
//        return mailSender;
//    }
}
