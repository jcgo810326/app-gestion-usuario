package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.EmployeesEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.id.EmployeesId;

@Repository
public interface EmployeesWriteRepository
    extends JpaRepository<EmployeesEntity, EmployeesId> {

}