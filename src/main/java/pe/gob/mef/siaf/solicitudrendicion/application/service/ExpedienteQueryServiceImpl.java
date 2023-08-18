package pe.gob.mef.siaf.solicitudrendicion.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository.ExpedienteDslRepository;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ExpdienteSiafDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ExpedienteSiafProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.query.ConsultarSolicitudesRendicionQuery;

@Service
@Transactional(readOnly = true)
public class ExpedienteQueryServiceImpl implements ExpedienteQueryService {

  @Autowired
  private ExpedienteDslRepository expedienteRepository;

  @Override
  public Page<ExpedienteSiafProjection> listarExpedienteSiaf(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return expedienteRepository.listarExpedienteSiaf(consultarSolicitudesRendicionQuery,
        PageRequest.of(consultarSolicitudesRendicionQuery.getPage(),
            consultarSolicitudesRendicionQuery.getPageSize() /*, Sort.by(SortUtil
                .queryToSort(QueryMapper.aDomain(consultarSolicitudesRendicionQuery.getSort()))) */));
  }

  @Override
  public List<ExpdienteSiafDetalleProjection> obtenerExpedienteSiafDetalle(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return expedienteRepository.obtenerExpedienteSiafDetalle(consultarSolicitudesRendicionQuery);
  }

}
