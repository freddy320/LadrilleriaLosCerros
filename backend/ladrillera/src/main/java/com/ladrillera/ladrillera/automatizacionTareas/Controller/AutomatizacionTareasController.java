package com.ladrillera.ladrillera.automatizacionTareas.Controller;

import com.ladrillera.ladrillera.automatizacionTareas.Services.AutomatizacionTareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/automatizacion")
public class AutomatizacionTareasController {

    @Autowired
    private AutomatizacionTareasService automatizacionTareasService;

    @PostMapping("/enviar-correo")
    public ResponseEntity<String> enviarCorreo(@RequestParam String destinatario, @RequestParam String nombre, @RequestParam String cbiBienTecnologico) {
        automatizacionTareasService.enviarMensajeRecordatorio(destinatario, nombre, cbiBienTecnologico);
        return ResponseEntity.ok("Correo enviado correctamente.");
    }

}
