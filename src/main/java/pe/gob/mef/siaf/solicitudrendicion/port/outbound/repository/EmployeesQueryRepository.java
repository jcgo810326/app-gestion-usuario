package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.EmployeesEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.id.EmployeesId;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.EmployeesProjection;

@Repository
public interface EmployeesQueryRepository extends JpaRepository<EmployeesEntity, EmployeesId> {

  @Query(value = """
      SELECT e.id, e.nombres
        FROM gestion_usuario.employees e
          """, nativeQuery = true)
  List<EmployeesProjection> list();
  
  @Query(value = """
      SELECT e.id, e.nombres
        FROM gestion_usuario.employees e
       WHERE e.id = :id
          """, nativeQuery = true)
  EmployeesProjection get(@Param("id") Integer id);
  
  @Query(value = """
      INSERT INTO gestion_usuario.employees (nombres) VALUES (:nombres)
          """, nativeQuery = true)
  void save(@Param("nombres") String nombres);


}
