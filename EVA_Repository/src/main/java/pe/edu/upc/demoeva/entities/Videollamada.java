package pe.edu.upc.demoeva.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "videollamadas")
public class Videollamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK: id
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Id id;

    @Column(name = "familiar_id", length = 40)
    private String familiar;

    @Column(name = "adulto_id", length = 10)
    private String adulto;

    @Column(name = "programada", length = 30)
    private Timestamp programada;

    public Videollamada() {}
    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFamiliar() { return familiar; }
    public void setFamiliar(Familiar familiar) { this.familiar = familiar; }
    public String getAdulto() { return adulto; }
    public void setAdulto(String adulto) { this.adulto = adulto; }
    public String getProgramada() { return programada; }
    public void setProgramada(String programada) { this.programada = programada; }
}
