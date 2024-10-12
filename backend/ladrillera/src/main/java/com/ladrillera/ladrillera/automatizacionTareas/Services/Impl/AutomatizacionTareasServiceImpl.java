package com.ladrillera.ladrillera.automatizacionTareas.Services.Impl;

import com.ladrillera.ladrillera.automatizacionTareas.Services.AutomatizacionTareasService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class AutomatizacionTareasServiceImpl implements AutomatizacionTareasService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarMensajeRecordatorio(String destinatario, String nombre, String periodo) {
        String asunto = "Te extrañamos en nuestra tienda";
        String cuerpo = "Estimado " + nombre + ",\n\n" +
                "Hemos notado que no has realizado compras en el último " + periodo + ". ¡Te invitamos a visitarnos y disfrutar de nuestras promociones exclusivas!\n\n" +
                "Saludos cordiales,\n" +
                "El equipo de ventas";

        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject(asunto);
        mensaje.setText(cuerpo);
        mensaje.setFrom("cibershop22@gmail.com");

        try {
            mailSender.send(mensaje);
            System.out.println("Correo enviado a: " + destinatario);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error enviando correo: " + e.getMessage());
        }
    }
}




