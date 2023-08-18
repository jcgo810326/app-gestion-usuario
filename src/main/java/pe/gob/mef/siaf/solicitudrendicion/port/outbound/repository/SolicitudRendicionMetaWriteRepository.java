package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionMetaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionMetaId;

@Repository
public interface SolicitudRendicionMetaWriteRepository
    extends JpaRepository<SolicitudRendicionMetaEntity, SolicitudRendicionMetaId> {

}