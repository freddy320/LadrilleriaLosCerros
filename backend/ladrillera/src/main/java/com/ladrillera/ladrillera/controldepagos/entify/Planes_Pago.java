package com.ladrillera.ladrillera.controldepagos.entify;

import jakarta.persistence.*;



@Entity
@Table(name = "planes_pago")
public class Planes_Pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_plan")
    private String nombre_plan;

    @Column(name = "periodo_tiempo")
    private String periodo_tiempo;


    //Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnombre_plan() {
        return nombre_plan;
    }

    public void setnombre_plan(String nombre_plan) {
        this.nombre_plan = nombre_plan;
    }

    public String getperiodo_tiempo() {
        return periodo_tiempo;
    }

    public void setperiodo_tiempo(String periodo_tiempo) {
        this.periodo_tiempo = periodo_tiempo;
    }

  
    
}
