package com.nicolas.hostal.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Correo {
    private static final String correo_salida = "trendyco.es@gmail.com";
    private static final String clave = "cvvm rnhr ikhr hrcl";

    private Properties props;
    private Session session;
    private MimeMessage mimeMessage;

    public Correo(String correo_destino, String asunto, String mensaje) {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", correo_salida);
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        props.setProperty("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(props);

        try {
            mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(correo_salida));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(correo_destino));
            mimeMessage.setSubject(asunto);
            mimeMessage.setText(correo_destino, "ISO-8859-1", "html");
        } catch (AddressException e) {
        } catch (MessagingException e) {
        }
    }

    public void enviar() {
        try {
            Transport transport = session.getTransport("smtp");
            transport.connect(correo_salida, clave);
            transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
            transport.close();
            System.out.println("Correo enviado");
        } catch (NoSuchProviderException e) {
        } catch (MessagingException e) {
        }
    }
}
