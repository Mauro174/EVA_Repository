package pe.edu.upc.demoeva.dtos;

import java.time.LocalDateTime;

public class FamiliarAdultoDTOList {
    private int id;
    private int adultoId;
    private String familiaId;
    private String relacion;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getAdultoId() { return adultoId; }
    public void setAdultoId(int adultoId) { this.adultoId = adultoId; }
    public String getFamiliaId() { return familiaId; }
    public void setFamiliaId(String familiaId) { this.familiaId = familiaId; }
    public String getRelacion() { return relacion; }
    public void setRelacion(String relacion) { this.relacion = relacion; }
}
