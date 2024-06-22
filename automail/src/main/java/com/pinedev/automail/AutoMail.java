package com.pinedev.automail;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class AutoMail {
    public static void main(String[] args){
        //configurações do servidor de email
        String host = "smtp.gmail.com";
        String username = "ddevpine@gmail.com";
        String password = "843657Jf@";

        //configurações adicionais

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        //Cria uma sessão de e-mail autenticada
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            //cria mensagem MIME
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ddevpine@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("jferson.smoke@gmail.com"));
            message.setSubject("Teste de AutoMail");
            message.setText("Olá,\n\nOlá este e-mail foi enviado automaticamente pelo automail!!!.");


            //Envia o e-mail
            Transport.send(message);
            System.out.println("E-mail enviado com sucesso!");

        }catch (MessagingException e){
            e.printStackTrace();

        }
    }
}
