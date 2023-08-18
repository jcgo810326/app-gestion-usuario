package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ListaSolicitudesRendicionProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionSecProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionDetalleClasificadoresProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionExpMetaOrigenProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionMarcoPresupuestoProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.query.ConsultarSolicitudesRendicionQuery;

public interface SolicitudRendicionDslRepository {

  Page<ListaSolicitudesRendicionProjection> listarSolicitudesRendicion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery, Pageable pageable);

  SolicitudRendicionDetalleProjection obtenerSolicitudRendicion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

  List<SolicitudRendicionExpMetaOrigenProjection> obtenerSolicitudRendicionExpMetaOrigen(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

  Page<SolicitudRendicionMarcoPresupuestoProjection> obtenerSolicitudRendicionMarcoPresupuesto(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery, Pageable pageable);

  Page<SolicitudReasignacionProjection> listarSolicitudesReasignacion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery, Pageable pageable);

  List<SolicitudReasignacionDetalleProjection> obtenerSolicitudReasignacionDetalle(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

  List<SolicitudReasignacionSecProjection> listarSolicitudesReasignacionSec(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

  List<SolicitudRendicionDetalleClasificadoresProjection> obtenerSolicitudRendicionDetalleClasifOrigen(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

  List<SolicitudRendicionDetalleClasificadoresProjection> obtenerSolicitudRendicionDetalleClasifDestino(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

}
