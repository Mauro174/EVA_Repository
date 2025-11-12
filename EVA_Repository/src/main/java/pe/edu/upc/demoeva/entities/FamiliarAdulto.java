package pe.edu.upc.demoeva.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "familiaradultos")

public class FamiliarAdulto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK: id
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Id id;

    @Column(name = "adulto_id", length = 40)
    private String adulto;

    @Column(name = "familia_id", length = 10)
    private String familia;

    @Column(name = "relacion", length = 10)
    private String relacion;

    public FamiliarAdulto() {}
    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAdulto() { return adulto; }
    public void setAdulto(Adulto adulto) { this.adulto = adulto; }
    public String getFamilia() { return familia; }
    public void setFamilia(String familia) { this.familia = familia; }
    public String getRelacion() { return relacion; }
    public void setRelacion(String relacion) { this.relacion = relacion; }
}
