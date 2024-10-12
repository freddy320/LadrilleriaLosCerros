package com.ladrillera.ladrillera.controldepagos.entify;

public class PlanPagoDTO {

    private Long id;
    private String nombre_Plan;
    private String periodo_tiempo; // "Semanal", "Quincenal", "Mensual"

    // Getter y Setters

    public Long getIdplan() {
        return id;
    }

    public void setIdplan(Long id) {
        this.id = id;
    }

    public String getNombre_Plan() {
        return nombre_Plan;
    }

    public void setNombre_Plan(String nombre_Plan) {
        this.nombre_Plan = nombre_Plan;
    }

    public String getPeriodo_Tiempo() {
        return periodo_tiempo;
    }

    public void setPeriodo_Tiempo(String periodo_tiempo) {
        this.periodo_tiempo = periodo_tiempo;
    }
}
