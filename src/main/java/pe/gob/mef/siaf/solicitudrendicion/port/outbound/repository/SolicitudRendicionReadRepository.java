package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionCabEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionCabId;

@Repository
public interface SolicitudRendicionReadRepository
    extends JpaRepository<SolicitudRendicionCabEntity, SolicitudRendicionCabId> {

}
