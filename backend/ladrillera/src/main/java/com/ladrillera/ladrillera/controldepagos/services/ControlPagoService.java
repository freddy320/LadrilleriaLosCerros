package com.ladrillera.ladrillera.controldepagos.services;




import com.ladrillera.ladrillera.controldepagos.entify.Control_Pagos;
import com.ladrillera.ladrillera.controldepagos.repository.ControlPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlPagoService {

    @Autowired
    private ControlPagoRepository controlPagoRepository;

    public List<Control_Pagos> listarControles() {
        return controlPagoRepository.findAll();
    }

    public Control_Pagos guardarControl(Control_Pagos control) {
        return controlPagoRepository.save(control);
    }
  
}



