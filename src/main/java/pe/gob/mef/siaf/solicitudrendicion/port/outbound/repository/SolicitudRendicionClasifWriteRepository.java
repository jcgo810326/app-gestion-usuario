package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionClasifEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionClasifId;

@Repository
public interface SolicitudRendicionClasifWriteRepository
    extends JpaRepository<SolicitudRendicionClasifEntity, SolicitudRendicionClasifId> {

}