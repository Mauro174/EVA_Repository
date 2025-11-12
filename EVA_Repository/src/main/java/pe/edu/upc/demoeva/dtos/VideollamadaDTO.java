package pe.edu.upc.demoeva.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class VideollamadaDTO {

    private int idUsuario;

    private String familiarId;

    private String adultoId;

    private String programada;


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFamiliarId() {
        return familiarId;
    }

    public void setFamiliarId(String familiarId) {
        this.familiarId = familiarId;
    }

    public String getAdultoId() {
        return adultoId;
    }

    public void setAdultoId(String adultoId) {
        this.adultoId = adultoId;
    }

    public String getProgramada() {
        return programada;
    }

    public void setProgramada(String programada) {
        this.programada = programada;
    }
