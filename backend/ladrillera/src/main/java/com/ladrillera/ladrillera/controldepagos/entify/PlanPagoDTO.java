package com.ladrillera.ladrillera.controldepagos.entify;



public class PlanPagoDTO {
    
    private Long id;
    private String nombrePlan;
    private String periodo_tiempo; // "Semanal", "Quincenal", "Mensual"


    //Getter y Setters

    public Long getIdplan() {
        return id;
    }

    public void setIdplan(Long id){
        this.id = id;
    }

    
    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getPeriodo_Tiempo() {
        return periodo_tiempo;
    }

    public void setPeriodo_Tiempo(String periodo_tiempo){
        this.periodo_tiempo = periodo_tiempo;
    }
}
