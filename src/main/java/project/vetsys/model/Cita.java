/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class Cita {
    
    private Integer idCita;
    private Integer idClinica;
    private Integer idCliente;
    private String NombreCliente;
    private Integer idMascota;
    private String NombreMascota;
    private Integer idVeterinario;
    private String NombreVeterinario;
    private Timestamp fecha;
    private String estado; // programada, atendida, cancelada

    public Cita() {}
    
    
    // yyyy-mm-dd
    public String getFechaSeparada() {
        if (fecha == null) return "";
        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(fecha);
    }

    //HH:mm
    public String getHoraSeparada() {
        if (fecha == null) return "";
        return new java.text.SimpleDateFormat("HH:mm").format(fecha);
    }


    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Integer getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Integer idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getNombreMascota() {
        return NombreMascota;
    }

    public void setNombreMascota(String NombreMascota) {
        this.NombreMascota = NombreMascota;
    }

    public String getNombreVeterinario() {
        return NombreVeterinario;
    }

    public void setNombreVeterinario(String NombreVeterinario) {
        this.NombreVeterinario = NombreVeterinario;
    }
    
    

    
    
}
