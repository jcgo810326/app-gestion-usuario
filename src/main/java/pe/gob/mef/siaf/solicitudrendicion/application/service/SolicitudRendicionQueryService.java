package pe.gob.mef.siaf.solicitudrendicion.application.service;

import java.util.List;
import org.springframework.data.domain.Page;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ListaSolicitudesRendicionProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionSecProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionDetalleClasificadoresProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionExpMetaOrigenProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionMarcoPresupuestoProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.query.ConsultarSolicitudesRendicionQuery;

public interface SolicitudRendicionQueryService {

  Page<ListaSolicitudesRendicionProjection> listarSolicitudRendicion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

  SolicitudRendicionDetalleProjection obtenerSolicitudRendicion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

  List<SolicitudRendicionExpMetaOrigenProjection> obtenerSolicitudRendicionExpMetaOrigen(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);
  
  Page<SolicitudRendicionMarcoPresupuestoProjection> obtenerListaSolicitudRendicionMarcoPresupuesto(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);
  
  Page<SolicitudReasignacionProjection> listarSolicitudesReasignacion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);
  
  List<SolicitudReasignacionDetalleProjection> obtenerSolicitudReasignacionDetalle(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);
  
  List<SolicitudReasignacionSecProjection> listarSolicitudesReasignacionSec(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

  List<SolicitudRendicionDetalleClasificadoresProjection> obtenerSolicitudRendicionDetClasifOrigen(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

  List<SolicitudRendicionDetalleClasificadoresProjection> obtenerSolicitudRendicionDetClasifDestino(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery);

}
