package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionDetEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionDetId;

@Repository
public interface SolicitudRendicionDetWriteRepository
    extends JpaRepository<SolicitudRendicionDetEntity, SolicitudRendicionDetId> {

}