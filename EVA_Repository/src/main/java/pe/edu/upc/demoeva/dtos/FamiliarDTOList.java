package pe.edu.upc.demoeva.dtos;

import java.time.LocalDateTime;

public class FamiliarDTOList {
    private int id;
    private int usuarioId;
    private String creadoUn;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    public String getCreadoUn() { return creadoUn; }
    public void setCreadoUn(String creadoUn) { this.iniciadaPor = creadoUn; }
}
