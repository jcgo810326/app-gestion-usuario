package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ExpdienteSiafDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ExpedienteSiafProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.query.ConsultarSolicitudesRendicionQuery;

public interface ExpedienteDslRepository {

  Page<ExpedienteSiafProjection> listarExpedienteSiaf(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery, Pageable pageable);
  
  List<ExpdienteSiafDetalleProjection> obtenerExpedienteSiafDetalle(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);


}
