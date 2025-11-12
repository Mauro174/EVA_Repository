package pe.edu.upc.demoeva.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "familiares")

public class Familiar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK: usuario_id
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "id", length = 40)
    private String id;

    @Column(name = "creado_un", length = 10)
    private String creadoUn;

    public Familiar() {}
    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public String getCreadoUn() { return creadoUn; }
    public void setCreadoUn(String creadoun) { this.creadoUn = creadoun; }
}
