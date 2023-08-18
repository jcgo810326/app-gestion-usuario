package pe.gob.mef.siaf.solicitudrendicion.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.common.data.SortUtil;
import pe.gob.mef.siaf.solicitudrendicion.application.mapper.QueryMapper;
import pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository.SolicitudRendicionRepository;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ListaSolicitudesRendicionProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionSecProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionDetalleClasificadoresProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionExpMetaOrigenProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionMarcoPresupuestoProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.query.ConsultarSolicitudesRendicionQuery;

@Service
@Transactional(readOnly = true)
public class SolicitudRendicionQueryServiceImpl implements SolicitudRendicionQueryService {

  @Autowired
  private SolicitudRendicionRepository solicitudRendicionRepository;

  @Override
  public Page<ListaSolicitudesRendicionProjection> listarSolicitudRendicion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return this.solicitudRendicionRepository.listarSolicitudesRendicion(
        consultarSolicitudesRendicionQuery,
        PageRequest.of(consultarSolicitudesRendicionQuery.getPage(),
            consultarSolicitudesRendicionQuery.getPageSize(), Sort.by(SortUtil
                .queryToSort(QueryMapper.aDomain(consultarSolicitudesRendicionQuery.getSort())))));
  }

  @Override
  public SolicitudRendicionDetalleProjection obtenerSolicitudRendicion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return this.solicitudRendicionRepository
        .obtenerSolicitudRendicion(consultarSolicitudesRendicionQuery);
  }

  @Override
  public List<SolicitudRendicionExpMetaOrigenProjection> obtenerSolicitudRendicionExpMetaOrigen(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return this.solicitudRendicionRepository
        .obtenerSolicitudRendicionExpMetaOrigen(consultarSolicitudesRendicionQuery);
  }

  @Override
  public Page<SolicitudRendicionMarcoPresupuestoProjection> obtenerListaSolicitudRendicionMarcoPresupuesto(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return this.solicitudRendicionRepository.obtenerSolicitudRendicionMarcoPresupuesto(
        consultarSolicitudesRendicionQuery,
        PageRequest.of(consultarSolicitudesRendicionQuery.getPage(),
            consultarSolicitudesRendicionQuery.getPageSize()));
  }

  @Override
  public Page<SolicitudReasignacionProjection> listarSolicitudesReasignacion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return this.solicitudRendicionRepository.listarSolicitudesReasignacion(
        consultarSolicitudesRendicionQuery,
        PageRequest.of(consultarSolicitudesRendicionQuery.getPage(),
            consultarSolicitudesRendicionQuery.getPageSize(), Sort.by(SortUtil
                .queryToSort(QueryMapper.aDomain(consultarSolicitudesRendicionQuery.getSort())))));
  }

  @Override
  public List<SolicitudReasignacionDetalleProjection> obtenerSolicitudReasignacionDetalle(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return this.solicitudRendicionRepository
        .obtenerSolicitudReasignacionDetalle(consultarSolicitudesRendicionQuery);
  }

  @Override
  public List<SolicitudReasignacionSecProjection> listarSolicitudesReasignacionSec(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return this.solicitudRendicionRepository
        .listarSolicitudesReasignacionSec(consultarSolicitudesRendicionQuery);
  }

  @Override
  public List<SolicitudRendicionDetalleClasificadoresProjection> obtenerSolicitudRendicionDetClasifOrigen(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return this.solicitudRendicionRepository
        .obtenerSolicitudRendicionDetalleClasifOrigen(consultarSolicitudesRendicionQuery);
  }

  @Override
  public List<SolicitudRendicionDetalleClasificadoresProjection> obtenerSolicitudRendicionDetClasifDestino(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    return this.solicitudRendicionRepository
        .obtenerSolicitudRendicionDetalleClasifDestino(consultarSolicitudesRendicionQuery);
  }

}
