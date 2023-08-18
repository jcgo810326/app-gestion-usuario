package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionSecEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionSecId;

@Repository
public interface SolicitudRendicionSecWriteRepository
    extends JpaRepository<SolicitudRendicionSecEntity, SolicitudRendicionSecId> {

}