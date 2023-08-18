package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionDestinoEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionDestinoId;

@Repository
public interface SolicitudRendicionDstWriteRepository
    extends JpaRepository<SolicitudRendicionDestinoEntity, SolicitudRendicionDestinoId> {

}