package project.vetsys.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HistoriaClinica {
    
    private Integer idHistoria;
    private Integer idClinica;
    private Integer idMascota;
    private Integer idVeterinario;
    private Integer idCita;
    private LocalDateTime fechaRegistro;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;
    private BigDecimal peso;

    
    public HistoriaClinica() {
    }

    
    public HistoriaClinica(Integer idHistoria, Integer idClinica, Integer idMascota, Integer idVeterinario, Integer idCita, LocalDateTime fechaRegistro, String motivoConsulta, String diagnostico, String tratamiento, BigDecimal peso) {
        this.idHistoria = idHistoria;
        this.idClinica = idClinica;
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.idCita = idCita;
        this.fechaRegistro = fechaRegistro;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.peso = peso;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Integer getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Integer idClinica) {
        this.idClinica = idClinica;
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

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
    
    
    
    
}
