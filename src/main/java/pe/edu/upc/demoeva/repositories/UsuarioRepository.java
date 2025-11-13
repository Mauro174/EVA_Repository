package pe.edu.upc.demoeva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeva.entities.Usuario;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneByNombreUsuario(String username);

    @Query("select s from Usuario s where s.emailUsuario like %:eUsuario%")
    public List<Usuario> buscar(@Param("eUsuario") String eUsuario );

    @Query(value = "select s.nombre_usuario, l.parentesco_relacion,count(l.id_relacion)\n" +
            " from usuarios s inner join relaciones_usuarios l\n" +
            " on s.id_usuario=l.usuario_id\n" +
            " group by s.nombre_usuario,l.parentesco_relacion",nativeQuery = true)
    public List<String[]> cantidadRelaciones();

    @Query(value = "select s.nombre_usuario, SUM(CASE WHEN l.activo THEN 1 ELSE 0 END) AS activos,\n" +
            "SUM(CASE WHEN NOT l.activo THEN 1 ELSE 0 END) AS inactivos,\n"+
            "COUNT(*) AS total\n"+
            " from usuarios s inner join medicamentos l\n" +
            " on s.id_usuario=l.usuario_id\n" +
            " group by s.nombre_usuario",nativeQuery = true)
    public List<String[]> cantidadMedicamentos();

}
