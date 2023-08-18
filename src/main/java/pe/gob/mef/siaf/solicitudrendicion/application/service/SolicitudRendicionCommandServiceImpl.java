package pe.gob.mef.siaf.solicitudrendicion.application.service;

import java.time.LocalDate;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.RegistrarSolicitudRendicionCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionCabCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionSecCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.exception.SolicitudReasignacionNoExisteException;
import pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository.SolicitudRendicionClasifWriteRepository;
import pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository.SolicitudRendicionDetWriteRepository;
import pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository.SolicitudRendicionDstWriteRepository;
import pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository.SolicitudRendicionMetaWriteRepository;
import pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository.SolicitudRendicionSecWriteRepository;
import pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository.SolicitudRendicionWriteRepository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionCabEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionClasifEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionDestinoEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionDetEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionMetaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionSecEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionSecProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.query.ConsultarSolicitudesRendicionQuery;

@Service
@Transactional
public class SolicitudRendicionCommandServiceImpl implements SolicitudRendicionCommandService {

  @Autowired
  private SolicitudRendicionWriteRepository solicitudRendicionRepository;

  @Autowired
  private SolicitudRendicionDetWriteRepository solicitudRendicionDetRepository;

  @Autowired
  private SolicitudRendicionDstWriteRepository solicitudRendicionDstRepository;

  @Autowired
  private SolicitudRendicionClasifWriteRepository solicitudRendicionClasifRepository;

  @Autowired
  private SolicitudRendicionMetaWriteRepository solicitudRendicionMetaRepository;

  @Autowired
  private SolicitudRendicionSecWriteRepository solicitudRendicionSecRepository;
  
  @Autowired
  private SolicitudRendicionQueryService solicitudRendicionQueryService;
  
  @Override
  public void registrar(RegistrarSolicitudRendicionCommand registrarSolicitudRendicionCommand) {
    
    solicitudRendicionRepository.save(new SolicitudRendicionCabEntity(
        registrarSolicitudRendicionCommand.getSolicitudRendicionCabCommand()));
    
    solicitudRendicionDetRepository.save(new SolicitudRendicionDetEntity(
        registrarSolicitudRendicionCommand.getSolicitudRendicionDetCommand()));
    
    solicitudRendicionDstRepository.save(new SolicitudRendicionDestinoEntity(
        registrarSolicitudRendicionCommand.getSolicitudRendicionDestinoCommand()));
    
    solicitudRendicionClasifRepository.save(new SolicitudRendicionClasifEntity(
        registrarSolicitudRendicionCommand.getSolicitudRendicionClasifCommand()));
    
    solicitudRendicionMetaRepository.save(new SolicitudRendicionMetaEntity(
        registrarSolicitudRendicionCommand.getSolicitudRendicionMetaCommand()));
    
    solicitudRendicionSecRepository.save(new SolicitudRendicionSecEntity(
        registrarSolicitudRendicionCommand.getSolicitudRendicionSecCommand()));

  }

  @Override
  public void actualizaEstadoSolReasignacion(
      SolicitudRendicionCabCommand solicitudRendicionCabCommand,
      SolicitudRendicionSecCommand solicitudRendicionSecCommand) {

    var consultarSolRendicionQuery = ConsultarSolicitudesRendicionQuery.builder()
        .secEjec(solicitudRendicionCabCommand.getEntidad())
        .anoEje(solicitudRendicionCabCommand.getAnoEje())
        .secuenciaNota(solicitudRendicionCabCommand.getSecNota()).build();
    var obtenerSolRasingnaDet = solicitudRendicionQueryService
        .obtenerSolicitudReasignacionDetalle(consultarSolRendicionQuery);

    if (obtenerSolRasingnaDet.isEmpty()) {
      throw new SolicitudReasignacionNoExisteException();
    }

    solicitudRendicionCabCommand.setMesEje(obtenerSolRasingnaDet.get(0).getMes());
    solicitudRendicionCabCommand.setTipoSolicitud(obtenerSolRasingnaDet.get(0).getTipoSolicitud());
    solicitudRendicionCabCommand
        .setIndicadorCertificacion(obtenerSolRasingnaDet.get(0).getIndCertificacion());
    solicitudRendicionCabCommand
        .setCodTipoOperacion(obtenerSolRasingnaDet.get(0).getCodTipoOperacion());
    solicitudRendicionCabCommand.setTipoRendicion(obtenerSolRasingnaDet.get(0).getTipoRendicion());
    solicitudRendicionCabCommand
        .setSecuenciaSolicitud(obtenerSolRasingnaDet.get(0).getSecuenciaSolicitud());
    solicitudRendicionRepository
        .save(new SolicitudRendicionCabEntity(solicitudRendicionCabCommand));

    consultarSolRendicionQuery
        .setSecuenciaSolicitud(solicitudRendicionCabCommand.getSecuenciaSolicitud());
    var listaSolReasignaSec =
        solicitudRendicionQueryService.listarSolicitudesReasignacionSec(consultarSolRendicionQuery);

    for (SolicitudReasignacionSecProjection objSolicitudReasignacionSec : listaSolReasignaSec) {

      solicitudRendicionSecCommand
          .setSecuenciaSolicitud(solicitudRendicionCabCommand.getSecuenciaSolicitud());
      solicitudRendicionSecCommand
          .setCorrelativoSolicitud(objSolicitudReasignacionSec.getCorrelativoSolicitud());
      solicitudRendicionSecCommand.setTipoRegistro(objSolicitudReasignacionSec.getTipoRegistro());
      solicitudRendicionSecCommand
          .setCodigoDocumento(objSolicitudReasignacionSec.getCodigoDocumento());
      solicitudRendicionSecCommand
          .setNumeroDocumento(objSolicitudReasignacionSec.getNumeroDocumento());
      solicitudRendicionSecCommand
          .setFechaDocumento(objSolicitudReasignacionSec.getFechaDocumento());
      solicitudRendicionSecCommand.setFechaRegistro(objSolicitudReasignacionSec.getFechaRegistro());
      solicitudRendicionSecCommand.setFechaProceso(objSolicitudReasignacionSec.getFechaProceso());
      solicitudRendicionSecRepository
          .save(new SolicitudRendicionSecEntity(solicitudRendicionSecCommand));
    }

  }
  
  @Override
  public void actualizaEstadoEnvioSolReasignacion(
      SolicitudRendicionSecCommand solicitudRendicionSecCommand) {

    var consultarSolRendicionQuery = ConsultarSolicitudesRendicionQuery.builder()
        .secEjec(solicitudRendicionSecCommand.getEntidad())
        .anoEje(solicitudRendicionSecCommand.getAnioEje())
        .secuenciaNota(solicitudRendicionSecCommand.getSecNota()).build();
    var obtenerSolRasingnaDet = solicitudRendicionQueryService
        .obtenerSolicitudReasignacionDetalle(consultarSolRendicionQuery);

    if (obtenerSolRasingnaDet.isEmpty()) {
      throw new SolicitudReasignacionNoExisteException();
    }

    consultarSolRendicionQuery
        .setSecuenciaSolicitud(obtenerSolRasingnaDet.get(0).getSecuenciaSolicitud());
    var listaSolReasignaSec =
        solicitudRendicionQueryService.listarSolicitudesReasignacionSec(consultarSolRendicionQuery);
    for (SolicitudReasignacionSecProjection objSolicitudReasignacionSec : listaSolReasignaSec) {

      solicitudRendicionSecCommand
          .setSecuenciaSolicitud(obtenerSolRasingnaDet.get(0).getSecuenciaSolicitud());
      solicitudRendicionSecCommand
          .setCorrelativoSolicitud(objSolicitudReasignacionSec.getCorrelativoSolicitud());
      solicitudRendicionSecCommand.setTipoRegistro(objSolicitudReasignacionSec.getTipoRegistro());
      solicitudRendicionSecCommand
          .setCodigoDocumento(objSolicitudReasignacionSec.getCodigoDocumento());
      solicitudRendicionSecCommand
          .setNumeroDocumento(objSolicitudReasignacionSec.getNumeroDocumento());
      solicitudRendicionSecCommand
          .setFechaDocumento(objSolicitudReasignacionSec.getFechaDocumento());
      solicitudRendicionSecCommand.setFechaRegistro(objSolicitudReasignacionSec.getFechaRegistro());
      solicitudRendicionSecCommand.setFechaProceso(objSolicitudReasignacionSec.getFechaProceso());
      solicitudRendicionSecRepository
          .save(new SolicitudRendicionSecEntity(solicitudRendicionSecCommand));
    }

  }

  @Override
  public void insertarEstadoAnularSolicitudRendicionSec(
      SolicitudRendicionSecCommand solicitudRendicionSecCommand) {
    var consultarSolRendicionQuery = ConsultarSolicitudesRendicionQuery.builder()
        .secEjec(solicitudRendicionSecCommand.getEntidad())
        .anoEje(solicitudRendicionSecCommand.getAnioEje())
        .secuenciaSolicitud(solicitudRendicionSecCommand.getSecuenciaSolicitud()).build();

    var listaSolReasignaSec =
        solicitudRendicionQueryService.listarSolicitudesReasignacionSec(consultarSolRendicionQuery);
    
    if (listaSolReasignaSec.isEmpty()) {
      throw new SolicitudReasignacionNoExisteException();
    }
    
    for (SolicitudReasignacionSecProjection objSolicitudReasignacionSec : listaSolReasignaSec) {

      solicitudRendicionSecCommand.setEstadoEnvio(objSolicitudReasignacionSec.getEstadoEnvio());
      solicitudRendicionSecCommand.setFechaRegistro(LocalDate.now());
      solicitudRendicionSecCommand.setFechaProceso(LocalDate.now());
      solicitudRendicionSecRepository
          .save(new SolicitudRendicionSecEntity(solicitudRendicionSecCommand));
    }

  }

  @Override
  public void actualizaEstadoSolRendicion(SolicitudRendicionCabCommand solicitudRendicionCabCommand,
      SolicitudRendicionSecCommand solicitudRendicionSecCommand) {
    
    var consultarSolRendicionQuery = ConsultarSolicitudesRendicionQuery.builder()
        .secEjec(solicitudRendicionCabCommand.getEntidad())
        .anoEje(solicitudRendicionCabCommand.getAnoEje())
        .secuenciaNota(solicitudRendicionCabCommand.getSecNota())
        .secuenciaSolicitud(solicitudRendicionSecCommand.getSecuenciaSolicitud()).build();
    var obtenerSolRasingnaDet =
        solicitudRendicionQueryService.obtenerSolicitudRendicion(consultarSolRendicionQuery);

    if (Objects.isNull(obtenerSolRasingnaDet)) {
      throw new SolicitudReasignacionNoExisteException();
    }

    solicitudRendicionCabCommand.setMesEje(obtenerSolRasingnaDet.getMesEjec());
    solicitudRendicionCabCommand.setTipoSolicitud(obtenerSolRasingnaDet.getTipoSolicitud());
    solicitudRendicionCabCommand
        .setIndicadorCertificacion(obtenerSolRasingnaDet.getIndCertificacion());
    solicitudRendicionCabCommand
        .setCodTipoOperacion(obtenerSolRasingnaDet.getCodTipoOperacion());
    solicitudRendicionCabCommand.setTipoRendicion(obtenerSolRasingnaDet.getTipoRendicion());
    solicitudRendicionRepository
        .save(new SolicitudRendicionCabEntity(solicitudRendicionCabCommand));

    var listaSolReasignaSec =
        solicitudRendicionQueryService.listarSolicitudesReasignacionSec(consultarSolRendicionQuery);

    for (SolicitudReasignacionSecProjection objSolicitudReasignacionSec : listaSolReasignaSec) {

      solicitudRendicionSecCommand
          .setCorrelativoSolicitud(objSolicitudReasignacionSec.getCorrelativoSolicitud());
      solicitudRendicionSecCommand.setTipoRegistro(objSolicitudReasignacionSec.getTipoRegistro());
      solicitudRendicionSecCommand
          .setCodigoDocumento(objSolicitudReasignacionSec.getCodigoDocumento());
      solicitudRendicionSecCommand
          .setNumeroDocumento(objSolicitudReasignacionSec.getNumeroDocumento());
      solicitudRendicionSecCommand
          .setFechaDocumento(objSolicitudReasignacionSec.getFechaDocumento());
      solicitudRendicionSecCommand.setFechaRegistro(objSolicitudReasignacionSec.getFechaRegistro());
      solicitudRendicionSecCommand.setFechaProceso(objSolicitudReasignacionSec.getFechaProceso());
      solicitudRendicionSecRepository
          .save(new SolicitudRendicionSecEntity(solicitudRendicionSecCommand));
    }

  }

  @Override
  public void actualizaEstadoEnvioSolRendicion(
      SolicitudRendicionSecCommand solicitudRendicionSecCommand) {
    
    var consultarSolRendicionQuery = ConsultarSolicitudesRendicionQuery.builder()
        .secEjec(solicitudRendicionSecCommand.getEntidad())
        .anoEje(solicitudRendicionSecCommand.getAnioEje())
        .secuenciaNota(solicitudRendicionSecCommand.getSecNota())
        .secuenciaSolicitud(solicitudRendicionSecCommand.getSecuenciaSolicitud()).build();
    var obtenerSolRasingnaDet =
        solicitudRendicionQueryService.obtenerSolicitudRendicion(consultarSolRendicionQuery);

    if (Objects.isNull(obtenerSolRasingnaDet)) {
      throw new SolicitudReasignacionNoExisteException();
    }

    var listaSolReasignaSec =
        solicitudRendicionQueryService.listarSolicitudesReasignacionSec(consultarSolRendicionQuery);
    for (SolicitudReasignacionSecProjection objSolicitudReasignacionSec : listaSolReasignaSec) {

      solicitudRendicionSecCommand
          .setCorrelativoSolicitud(objSolicitudReasignacionSec.getCorrelativoSolicitud());
      solicitudRendicionSecCommand.setTipoRegistro(objSolicitudReasignacionSec.getTipoRegistro());
      solicitudRendicionSecCommand
          .setCodigoDocumento(objSolicitudReasignacionSec.getCodigoDocumento());
      solicitudRendicionSecCommand
          .setNumeroDocumento(objSolicitudReasignacionSec.getNumeroDocumento());
      solicitudRendicionSecCommand
          .setFechaDocumento(objSolicitudReasignacionSec.getFechaDocumento());
      solicitudRendicionSecCommand.setFechaRegistro(objSolicitudReasignacionSec.getFechaRegistro());
      solicitudRendicionSecCommand.setFechaProceso(objSolicitudReasignacionSec.getFechaProceso());
      solicitudRendicionSecRepository
          .save(new SolicitudRendicionSecEntity(solicitudRendicionSecCommand));
    }
    
  }

}
