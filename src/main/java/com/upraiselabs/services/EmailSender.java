package com.upraiselabs.services;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public abstract class EmailSender {

  private static final String EMAIL_CONTENT_TYPE = "text/html";

  private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
  private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
  private static final String MAIL_SMTP_HOST = "mail.smtp.host";
  private static final String MAIL_SMTP_PORT = "mail.smtp.port";
  private static final String USERNAME = "mail.username";
  private static final String PASSWORD = "mail.password";

  public static void sendEmail(String email, String emailSubject,
      String emailContent) {

    try {
      String username = ConfigAccessor.getConfig(USERNAME);
      String password = ConfigAccessor.getConfig(PASSWORD);

      Properties props = new Properties();
      props.put(MAIL_SMTP_AUTH, ConfigAccessor.getConfig(MAIL_SMTP_AUTH));
      props.put(MAIL_SMTP_STARTTLS_ENABLE,
          ConfigAccessor.getConfig(MAIL_SMTP_STARTTLS_ENABLE));
      props.put(MAIL_SMTP_HOST, ConfigAccessor.getConfig(MAIL_SMTP_HOST));
      props.put(MAIL_SMTP_PORT, ConfigAccessor.getConfig(MAIL_SMTP_PORT));

      Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(username, password);
            }
          });

      Message message = new MimeMessage(session);
      message.setHeader("Content-Type", EMAIL_CONTENT_TYPE);
      message.setFrom(new InternetAddress(username));
      message.setRecipients(Message.RecipientType.TO,
          InternetAddress.parse(email));
      message.setSubject(emailSubject);
      message.setContent(emailContent, EMAIL_CONTENT_TYPE);
      Transport.send(message);
    } catch (IOException e) {
      System.out.println(Class.class.getName() + ":" + e);
    } catch (MessagingException e) {
      System.out.println(Class.class.getName() + ":" + e);
    }
  }
}