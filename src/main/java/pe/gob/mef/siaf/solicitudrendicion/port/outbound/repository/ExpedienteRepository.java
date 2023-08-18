package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.ExpedienteEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.id.ExpedienteId;

@Repository
public interface ExpedienteRepository
    extends PagingAndSortingRepository<ExpedienteEntity, ExpedienteId>,
    ExpedienteDslRepository {

}
