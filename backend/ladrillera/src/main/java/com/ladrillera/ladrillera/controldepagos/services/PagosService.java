package com.ladrillera.ladrillera.controldepagos.services;



import java.util.List;


import com.ladrillera.ladrillera.controldepagos.entify.Pagos;
import com.ladrillera.ladrillera.controldepagos.repository.PagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagosService {

    @Autowired
    private PagosRepository pagosRepository;

    public List<Pagos> ListarPagos() {
        return pagosRepository.findAll();
    }

    public Pagos guardarPago(Pagos pago){
        return pagosRepository.save(pago);
    }

}
