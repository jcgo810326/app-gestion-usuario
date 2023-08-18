package pe.gob.mef.siaf.solicitudrendicion.application.service;

import java.util.List;
import org.springframework.data.domain.Page;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ExpdienteSiafDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ExpedienteSiafProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.query.ConsultarSolicitudesRendicionQuery;

public interface ExpedienteQueryService {
  
  Page<ExpedienteSiafProjection> listarExpedienteSiaf(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);
  
  List<ExpdienteSiafDetalleProjection> obtenerExpedienteSiafDetalle(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

}
