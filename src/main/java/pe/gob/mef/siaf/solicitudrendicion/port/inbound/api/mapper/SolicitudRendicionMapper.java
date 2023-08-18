package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.domain.Page;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pe.gob.mef.common.security.SecurityUtil;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.RegistrarSolicitudRendicionCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionCabCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionClasifCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionDestinoCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionDetCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionMetaCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionSecCommand;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.ObtenerListaSolicitudesReasignacion;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.ObtenerListaSolicitudesRendicion;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.ObtenerListaSolicitudesRendicionExpMetaOrigen;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.ObtenerListaSolicitudesRendicionMarcoPresupuesto;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.ObtenerSolicitudReasignacionDetalle;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.PaginacionResponse;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.RegistrarAnulaSolicitudRendicionRequest;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.RegistrarSolicitudReasignacionRequest;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.RegistrarSolicitudRendicionRequest;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.SolicitudReasignacionDetalleResponse;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.SolicitudReasignacionResponse;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.SolicitudRendicionDetalleClasificadoresResponse;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.SolicitudRendicionDetalleResponse;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.SolicitudRendicionExpMetaOrigenResponse;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.SolicitudRendicionMarcoPresupuestoResponse;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.SolicitudRendicionResponse;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ListaSolicitudesRendicionProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionDetalleClasificadoresProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionExpMetaOrigenProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionMarcoPresupuestoProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionDetalleProjection;

/**
 * Clase que mapea o transforma el DTO a Command.
 *
 * @author Zully Silva
 * @version 1.0, 07/04/2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SolicitudRendicionMapper {

  public static ObtenerListaSolicitudesRendicion aObtenerListaSolicitudRendicionResponse(
      Page<ListaSolicitudesRendicionProjection> response) {

    if (response == null) {
      return null;
    }

    var listaSolicitudRendicion = new ArrayList<SolicitudRendicionResponse>();
    response.getContent()
        .forEach(item -> listaSolicitudRendicion
            .add(SolicitudRendicionResponse.builder().anio(item.getAnoEje())
                .entidad(item.getSecEjec()).mesEjec(item.getMesEje()).secNota(item.getSecNota())
                .expediente(item.getExpediente()).codEstadoRegistro(item.getCodEstadoRegistro())
                .descriEstadoRegistro(item.getDescriEstadoRegistro()).build()));

    var paginacion = PaginacionResponse.builder().first(response.isFirst()).last(response.isLast())
        .totalPages(response.getTotalPages())
        .totalElements(Math.toIntExact(response.getTotalElements()))
        .pageSize(response.getNumberOfElements()).page(response.getNumber()).build();

    return ObtenerListaSolicitudesRendicion.builder().content(listaSolicitudRendicion)
        .paginacion(paginacion).build();
  }
  
  public static SolicitudRendicionDetalleResponse aObtenerSolicitudRendicionResponse(
      SolicitudRendicionDetalleProjection response,
      List<SolicitudRendicionDetalleClasificadoresProjection> listaSolicitudRendicionDetClasifOrigen,
      List<SolicitudRendicionDetalleClasificadoresProjection> listaSolicitudRendicionDetClasifDestino) {
    
    if (response == null) {
      return null;
    }
    
    var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    var listaSolRendicionDetClasifOrigen =
        new ArrayList<SolicitudRendicionDetalleClasificadoresResponse>();
    listaSolicitudRendicionDetClasifOrigen.forEach(
        item -> listaSolRendicionDetClasifOrigen.add(SolicitudRendicionDetalleClasificadoresResponse
            .builder().tipoTransaccion(item.getTipoTransaccion())
            .descriTipoTransaccion(item.getDescriTipoTransaccion()).generica(item.getGenerica())
            .descriGenerica(item.getDescriGenerica()).subGenerica(item.getSubGenerica())
            .descriSubGenerica(item.getDescriSubGenerica()).subGenericaDet(item.getSubGenericaDet())
            .descriSubGenericaDet(item.getDescriSubGenericaDet()).especifica(item.getEspecifica())
            .descriEspecifica(item.getDescriEspecifica()).especificaDet(item.getEspecificaDet())
            .clasificador(item.getClasificador()).descriClasificador(item.getDescriClasificador())
            .secuenciaFuncional(item.getSecuenciaFuncional())
            .descriSecuenciaFuncional(item.getDescriSecuenciaFuncional())
            .montoNacionalMeta(item.getMontoNacionalMeta()).build()));
    
    var listaSolRendicionDetClasifDestino =
        new ArrayList<SolicitudRendicionDetalleClasificadoresResponse>();
    listaSolicitudRendicionDetClasifDestino.forEach(item -> listaSolRendicionDetClasifDestino
        .add(SolicitudRendicionDetalleClasificadoresResponse.builder()
            .tipoTransaccion(item.getTipoTransaccion())
            .descriTipoTransaccion(item.getDescriTipoTransaccion()).generica(item.getGenerica())
            .descriGenerica(item.getDescriGenerica()).subGenerica(item.getSubGenerica())
            .descriSubGenerica(item.getDescriSubGenerica()).subGenericaDet(item.getSubGenericaDet())
            .descriSubGenericaDet(item.getDescriSubGenericaDet()).especifica(item.getEspecifica())
            .descriEspecifica(item.getDescriEspecifica()).especificaDet(item.getEspecificaDet())
            .clasificador(item.getClasificador()).descriClasificador(item.getDescriClasificador())
            .secuenciaFuncional(item.getSecuenciaFuncional())
            .descriSecuenciaFuncional(item.getDescriSecuenciaFuncional())
            .montoNacionalMeta(item.getMontoNacionalMeta()).build()));

    return SolicitudRendicionDetalleResponse.builder().anio(response.getAnoEje())
        .entidad(response.getSecEjec()).mesEjec(response.getMesEjec())
        .secNota(response.getSecNota()).secuenciaSolicitud(response.getSecuenciaSolicitud())
        .idTipoRendicion(response.getIdTipoRendicion())
        .descriTipoRendicion(response.getDescriTipoRendicion())
        .codDocumento(response.getCodDocumento()).numDocumento(response.getNumDocumento())
        .fechaDocumento(formatter.format(response.getFechaDocumento()))
        .codEstadoRegistro(response.getCodEstadoRegistro())
        .descriEstadoRegistro(response.getDescriEstadoRegistro())
        .estadoEnvio(response.getEstadoEnvio()).descriEstadoEnvio(response.getDescriEstadoEnvio())
        .codTipoOperacion(response.getCodTipoOperacion())
        .descriTipoOperacion(response.getDescriTipoOperacion())
        .codDocIdentidad(response.getCodDocIdentidad()).numeroRUC(response.getNumeroRUC())
        .secEjecEntidadReciproca(response.getSecEjecEntidadReciproca())
        .entidadReciproca(response.getEntidadReciproca()).expediente(response.getExpediente())
        .ciclo(response.getCiclo()).fase(response.getFase()).secuencia(response.getSecuencia())
        .certificado(response.getCertificado())
        .certificadoSecuencia(response.getCertificadoSecuencia()).moneda(response.getMoneda())
        .descriMoneda(response.getDescriMoneda()).tipoCambio(response.getTipoCambio())
        .montoNacional(response.getMontoNacional())
        .fuenteFinanciamiento(response.getFuenteFinanciamiento())
        .descriFuenteFinanc(response.getDescriFuenteFinanc())
        .listaClasificadoresOrigen(listaSolRendicionDetClasifOrigen)
        .listaClasificadoresDestino(listaSolRendicionDetClasifDestino)
        .build();
  }
  
  public static ObtenerListaSolicitudesRendicionExpMetaOrigen aObtenerSolicitudRendicionExpMetaOrigenResponse(
      List<SolicitudRendicionExpMetaOrigenProjection> response) {

    if (response == null) {
      return null;
    }

    var listaSolicitudRendicionExpMetaOr = new ArrayList<SolicitudRendicionExpMetaOrigenResponse>();
    response.forEach(item -> listaSolicitudRendicionExpMetaOr
        .add(SolicitudRendicionExpMetaOrigenResponse.builder()
            .clasificador(item.getClasificador())
            .meta(item.getMeta()).montoRendir(item.getMontoRendir())
            .descriTipoTransaccion(item.getDescriTipoTransaccion())
            .descriGenerica(item.getDescriGenerica()).descriSubGenerica(item.getDescriSubGenerica())
            .descriSubGenericaDet(item.getDescriSubGenericaDet())
            .descriEspecifica(item.getDescriEspecifica())
            .descriEspecificaDet(item.getDescriEspecificaDet())
            .build()));

    return ObtenerListaSolicitudesRendicionExpMetaOrigen.builder()
        .content(listaSolicitudRendicionExpMetaOr).build();
  }
  
  public static ObtenerListaSolicitudesRendicionMarcoPresupuesto aObtenerListaSolicitudRendicionMarcoPresupuestoResponse(
      Page<SolicitudRendicionMarcoPresupuestoProjection> response) {

    if (response == null) {
      return null;
    }

    var listaSolicitudRendicionMarcoPresup =
        new ArrayList<SolicitudRendicionMarcoPresupuestoResponse>();
    response.getContent().forEach(
        item -> listaSolicitudRendicionMarcoPresup.add(SolicitudRendicionMarcoPresupuestoResponse
            .builder().anio(item.getAnoEje()).meta(item.getMeta())
            .clasificador(item.getClasificador()).disponible(item.getMarcoDisponible()).build()));

    var paginacion = PaginacionResponse.builder().first(response.isFirst()).last(response.isLast())
        .totalPages(response.getTotalPages())
        .totalElements(Math.toIntExact(response.getTotalElements()))
        .pageSize(response.getNumberOfElements()).page(response.getNumber()).build();

    return ObtenerListaSolicitudesRendicionMarcoPresupuesto.builder()
        .content(listaSolicitudRendicionMarcoPresup).paginacion(paginacion).build();
  }
  
  public static RegistrarSolicitudRendicionCommand mapToSolicitudRendicionRegistrarCommand(
      RegistrarSolicitudRendicionRequest registrarSolicitudRendicionRequest) {
    
    var formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    return RegistrarSolicitudRendicionCommand.builder()
        .solicitudRendicionCabCommand(SolicitudRendicionCabCommand.builder()
            .entidad(SecurityUtil.getUnidadEjecutora())
            .anoEje(registrarSolicitudRendicionRequest.getAnio())
            .secuenciaSolicitud(registrarSolicitudRendicionRequest.getSecuenciaSolicitud())
            .mesEje(registrarSolicitudRendicionRequest.getSolicitudRendicionCab().getMesEjec())
            .secNota(
                registrarSolicitudRendicionRequest.getSolicitudRendicionCab().getSecuenciaNota())
            .estadoRegistro(registrarSolicitudRendicionRequest.getEstadoRegistro())
            .tipoSolicitud(
                registrarSolicitudRendicionRequest.getSolicitudRendicionCab().getTipoSolicitud())
            .codTipoOperacion(
                registrarSolicitudRendicionRequest.getSolicitudRendicionCab().getTipoOperacion())
            .tipoRendicion(
                registrarSolicitudRendicionRequest.getSolicitudRendicionCab().getTipoRendicion())
            .indicadorCertificacion(registrarSolicitudRendicionRequest.getSolicitudRendicionCab()
                .getIndicadorCertifica())
            .estadoCertificacion(registrarSolicitudRendicionRequest.getSolicitudRendicionCab()
                .getEstadoCertificacion())
            .build())
        .solicitudRendicionDetCommand(SolicitudRendicionDetCommand.builder()
            .anioEje(registrarSolicitudRendicionRequest.getAnio())
            .entidad(SecurityUtil.getUnidadEjecutora())
            .secuenciaSolicitud(registrarSolicitudRendicionRequest.getSecuenciaSolicitud())
            .secuenciaPorExpediente(registrarSolicitudRendicionRequest.getSecuenciaPorExpediente())
            .expediente(
                registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getExpediente())
            .fuenteFinanciamiento(registrarSolicitudRendicionRequest.getSolicitudRendicionDet()
                .getFuenteFinanciamiento())
            .entidadReciproca(
                registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getEntidadReciproca())
            .codTipoDocIdentidad(registrarSolicitudRendicionRequest.getSolicitudRendicionDet()
                .getTipoDocumentIdent())
            .ruc(registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getRuc())
            .ciclo(registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getCiclo())
            .fase(registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getFase())
            .correlativo(
                registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getCorrelativo())
            .secuencia(registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getSecuencia())
            .secuenciaAnterior(registrarSolicitudRendicionRequest.getSolicitudRendicionDet()
                .getSecuenciaAnterior())
            .secuenciaPadre(
                registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getSecuenciaPadre())
            .secNotaModificatoria(registrarSolicitudRendicionRequest.getSolicitudRendicionDet()
                .getSecuenciaNotaModif())
            .certificado(
                registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getCertificado())
            .certificadoSecuencia(registrarSolicitudRendicionRequest.getSolicitudRendicionDet()
                .getCertificadoSecuencia())
            .moneda(registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getMoneda())
            .tipoCambio(
                registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getTipoCambio())
            .monto(registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getMonto())
            .montoNacional(
                registrarSolicitudRendicionRequest.getSolicitudRendicionDet().getMontoNacional())
            .estadoRegistro(registrarSolicitudRendicionRequest.getEstadoRegistro())
            .secuenciaSolicitudPadre(registrarSolicitudRendicionRequest.getSolicitudRendicionDet()
                .getSecuenciaSolicitudPadre())
            .build())
        .solicitudRendicionDestinoCommand(SolicitudRendicionDestinoCommand.builder()
            .anoEje(registrarSolicitudRendicionRequest.getAnio())
            .entidad(SecurityUtil.getUnidadEjecutora())
            .secuenciaSolicitud(registrarSolicitudRendicionRequest.getSecuenciaSolicitud())
            .secuenciaPorExpediente(registrarSolicitudRendicionRequest.getSecuenciaPorExpediente())
            .idClasificador(registrarSolicitudRendicionRequest.getIdClasificador())
            .secuenciaFuncional(registrarSolicitudRendicionRequest.getSecuenciaFuncional())
            .idClasificadorDestino(registrarSolicitudRendicionRequest.getSolicitudRendicionDestino()
                .getIdClasificadorDestino())
            .secuenciaFuncionalDestino(registrarSolicitudRendicionRequest
                .getSolicitudRendicionDestino().getSecuenciaFuncionalDestino())
            .monto(registrarSolicitudRendicionRequest.getMonto())
            .montoNacional(registrarSolicitudRendicionRequest.getMontoNacional())
            .estadoRegistro(registrarSolicitudRendicionRequest.getEstadoRegistro()).build())
        .solicitudRendicionClasifCommand(SolicitudRendicionClasifCommand.builder()
            .anoEje(registrarSolicitudRendicionRequest.getAnio())
            .entidad(SecurityUtil.getUnidadEjecutora())
            .secuenciaSolicitud(registrarSolicitudRendicionRequest.getSecuenciaSolicitud())
            .secuenciaPorExpediente(registrarSolicitudRendicionRequest.getSecuenciaPorExpediente())
            .idClasificador(registrarSolicitudRendicionRequest.getIdClasificador())
            .monto(registrarSolicitudRendicionRequest.getMonto())
            .montoNacional(registrarSolicitudRendicionRequest.getMontoNacional())
            .estadoRegistro(registrarSolicitudRendicionRequest.getEstadoRegistro()).build())
        .solicitudRendicionMetaCommand(SolicitudRendicionMetaCommand.builder()
            .anoEje(registrarSolicitudRendicionRequest.getAnio())
            .entidad(SecurityUtil.getUnidadEjecutora())
            .secuenciaSolicitud(registrarSolicitudRendicionRequest.getSecuenciaSolicitud())
            .secuenciaPorExpediente(registrarSolicitudRendicionRequest.getSecuenciaPorExpediente())
            .idClasificador(registrarSolicitudRendicionRequest.getIdClasificador())
            .secuenciaFuncional(registrarSolicitudRendicionRequest.getSecuenciaFuncional())
            .monto(registrarSolicitudRendicionRequest.getMonto())
            .montoNacional(registrarSolicitudRendicionRequest.getMontoNacional())
            .estadoRegistro(registrarSolicitudRendicionRequest.getEstadoRegistro()).build())
        .solicitudRendicionSecCommand(SolicitudRendicionSecCommand.builder()
            .anioEje(registrarSolicitudRendicionRequest.getAnio())
            .entidad(SecurityUtil.getUnidadEjecutora())
            .secuenciaSolicitud(registrarSolicitudRendicionRequest.getSecuenciaSolicitud())
            .correlativoSolicitud(registrarSolicitudRendicionRequest.getSolicitudRendicionSec()
                .getCorrelativoSolicitud())
            .tipoRegistro(
                registrarSolicitudRendicionRequest.getSolicitudRendicionSec().getTipoRegistro())
            .codigoDocumento(
                registrarSolicitudRendicionRequest.getSolicitudRendicionSec().getCodigodocumento())
            .numeroDocumento(
                registrarSolicitudRendicionRequest.getSolicitudRendicionSec().getNumeroDocumento())
            .fechaDocumento(LocalDate.parse(
                registrarSolicitudRendicionRequest.getSolicitudRendicionSec().getFechaDocumento(),
                formatter))
            .fechaRegistro(LocalDate.parse(
                registrarSolicitudRendicionRequest.getSolicitudRendicionSec().getFechaRegistro(),
                formatter))
            .fechaProceso(LocalDate.parse(
                registrarSolicitudRendicionRequest.getSolicitudRendicionSec().getFechaProceso(),
                formatter))
            .estadoRegistro(registrarSolicitudRendicionRequest.getEstadoRegistro()).build())
        .build();
  }
  
  public static ObtenerListaSolicitudesReasignacion aObtenerListaSolicitudReasignacionResponse(
      Page<SolicitudReasignacionProjection> response) {

    if (response == null) {
      return null;
    }

    var listaSolicitudReasignacion = new ArrayList<SolicitudReasignacionResponse>();
    response.getContent()
        .forEach(item -> listaSolicitudReasignacion.add(SolicitudReasignacionResponse.builder()
            .anio(item.getAnio()).entidad(item.getEntidad()).secNota(item.getSecNota())
            .expediente(item.getExpediente()).codEstadoRegistro(item.getCodEstadoRegistro())
            .descriEstadoRegistro(item.getDescriEstadoRegistro()).build()));

    var paginacion = PaginacionResponse.builder().first(response.isFirst()).last(response.isLast())
        .totalPages(response.getTotalPages())
        .totalElements(Math.toIntExact(response.getTotalElements()))
        .pageSize(response.getNumberOfElements()).page(response.getNumber()).build();

    return ObtenerListaSolicitudesReasignacion.builder().content(listaSolicitudReasignacion)
        .paginacion(paginacion).build();
  }
  
  public static ObtenerSolicitudReasignacionDetalle aObtenerSolicitudReasignacionResponse(
      List<SolicitudReasignacionDetalleProjection> response) {

    if (response == null) {
      return null;
    }
    
    var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    var listaSolicitudRendicionDet = new ArrayList<SolicitudReasignacionDetalleResponse>();
    response.forEach(item -> listaSolicitudRendicionDet.add(SolicitudReasignacionDetalleResponse
        .builder().anio(item.getAnio()).entidad(item.getEntidad()).secNota(item.getSecNota())
        .secuenciaSolicitud(item.getSecuenciaSolicitud()).codDocumento(item.getCodDocumento())
        .numDocumento(item.getNumDocumento())
        .fechaDocumento(Objects.isNull(item.getFechaDocumento()) ? null
            : formatter.format(item.getFechaDocumento()))
        .codEstadoRegistro(item.getCodEstadoRegistro())
        .descriEstadoRegistro(item.getDescriEstadoRegistro())
        .codTipoOperacion(item.getCodTipoOperacion())
        .descriTipoOperacion(item.getDescriTipoOperacion())
        .codDocIdentidad(item.getCodDocIdentidad()).numeroRUC(item.getNumeroRUC())
        .secEjecEntidadReciproca(item.getSecEjecEntidadReciproca())
        .entidadReciproca(item.getEntidadReciproca()).expediente(item.getExpediente())
        .ciclo(item.getCiclo()).fase(item.getFase()).secuencia(item.getSecuencia())
        .certificado(item.getCertificado()).certificadoSecuencia(item.getCertificadoSecuencia())
        .moneda(item.getMoneda()).tipoCambio(item.getTipoCambio())
        .montoNacional(item.getMontoNacional()).fuenteFinanciamiento(item.getFuenteFinanciamiento())
        .descriFuenteFinanc(item.getDescriFuenteFinanc()).clasificador(item.getClasificadorOrigen())
        .descriClasificador(item.getDescriClasificadorOrigen())
        .secuenciaFuncional(item.getSecuenciaFuncional())
        .descriSecuenciaFuncional(item.getDescriSecuenciaFuncional())
        .montoNacionalMeta(item.getMontoNacionalMeta())
        .clasificadorDestino(item.getClasificadorDestino())
        .descriClasificadorDestino(item.getDescriClasificadorDestino())
        .secuenciaFuncionalDestino(item.getSecuenciaFuncionalDestino())
        .descriSecuenciaFuncionalDestino(item.getDescriSecuenciaFuncionalDestino())
        .montoNacionalDestino(item.getMontoNacionalDestino()).build()));

    return ObtenerSolicitudReasignacionDetalle.builder().content(listaSolicitudRendicionDet)
        .build();
  }
  
  public static RegistrarSolicitudRendicionCommand mapToSolicitudReasignacionRegistrarCommand(
      RegistrarSolicitudReasignacionRequest registrarSolicitudReasignacionRequest) {
    
    var formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    
    return RegistrarSolicitudRendicionCommand.builder()
        .solicitudRendicionCabCommand(SolicitudRendicionCabCommand.builder()
            .entidad(SecurityUtil.getUnidadEjecutora())
            .anoEje(registrarSolicitudReasignacionRequest.getAnio())
            .secuenciaSolicitud(registrarSolicitudReasignacionRequest.getSecuenciaSolicitud())
            .mesEje(
                registrarSolicitudReasignacionRequest.getSolicitudReasignacionCab().getMesEjec())
            .secNota(registrarSolicitudReasignacionRequest.getSolicitudReasignacionCab()
                .getSecuenciaNota())
            .estadoRegistro(registrarSolicitudReasignacionRequest.getEstadoRegistro())
            .tipoSolicitud(registrarSolicitudReasignacionRequest.getSolicitudReasignacionCab()
                .getTipoSolicitud())
            .codTipoOperacion(registrarSolicitudReasignacionRequest.getSolicitudReasignacionCab()
                .getTipoOperacion())
            .tipoRendicion(registrarSolicitudReasignacionRequest.getSolicitudReasignacionCab()
                .getTipoRendicion())
            .indicadorCertificacion(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionCab().getIndicadorCertifica())
            .estadoCertificacion(registrarSolicitudReasignacionRequest.getSolicitudReasignacionCab()
                .getEstadoCertificacion())
            .build())
        .solicitudRendicionDetCommand(SolicitudRendicionDetCommand.builder()
            .anioEje(registrarSolicitudReasignacionRequest.getAnio())
            .entidad(SecurityUtil.getUnidadEjecutora())
            .secuenciaSolicitud(registrarSolicitudReasignacionRequest.getSecuenciaSolicitud())
            .secuenciaPorExpediente(
                registrarSolicitudReasignacionRequest.getSecuenciaPorExpediente())
            .expediente(
                registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet().getExpediente())
            .fuenteFinanciamiento(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionDet().getFuenteFinanciamiento())
            .entidadReciproca(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet()
                .getEntidadReciproca())
            .codTipoDocIdentidad(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet()
                .getTipoDocumentIdent())
            .ruc(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet().getRuc())
            .ciclo(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet().getCiclo())
            .fase(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet().getFase())
            .correlativo(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet()
                .getCorrelativo())
            .secuencia(
                registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet().getSecuencia())
            .secuenciaAnterior(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet()
                .getSecuenciaAnterior())
            .secuenciaPadre(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet()
                .getSecuenciaPadre())
            .secNotaModificatoria(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionDet().getSecuenciaNotaModif())
            .certificado(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet()
                .getCertificado())
            .certificadoSecuencia(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionDet().getCertificadoSecuencia())
            .moneda(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet().getMoneda())
            .tipoCambio(
                registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet().getTipoCambio())
            .monto(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet().getMonto())
            .montoNacional(registrarSolicitudReasignacionRequest.getSolicitudReasignacionDet()
                .getMontoNacional())
            .estadoRegistro(registrarSolicitudReasignacionRequest.getEstadoRegistro())
            .secuenciaSolicitudPadre(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionDet().getSecuenciaSolicitudPadre())
            .build())
        .solicitudRendicionDestinoCommand(SolicitudRendicionDestinoCommand.builder()
            .anoEje(registrarSolicitudReasignacionRequest.getAnio())
            .entidad(SecurityUtil.getUnidadEjecutora())
            .secuenciaSolicitud(registrarSolicitudReasignacionRequest.getSecuenciaSolicitud())
            .secuenciaPorExpediente(
                registrarSolicitudReasignacionRequest.getSecuenciaPorExpediente())
            .idClasificador(registrarSolicitudReasignacionRequest.getIdClasificador())
            .secuenciaFuncional(registrarSolicitudReasignacionRequest.getSecuenciaFuncional())
            .idClasificadorDestino(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionDestino().getIdClasificadorDestino())
            .secuenciaFuncionalDestino(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionDestino().getSecuenciaFuncionalDestino())
            .monto(registrarSolicitudReasignacionRequest.getMonto())
            .montoNacional(registrarSolicitudReasignacionRequest.getMontoNacional())
            .estadoRegistro(registrarSolicitudReasignacionRequest.getEstadoRegistro()).build())
        .solicitudRendicionClasifCommand(SolicitudRendicionClasifCommand.builder()
            .anoEje(registrarSolicitudReasignacionRequest.getAnio())
            .entidad(SecurityUtil.getUnidadEjecutora())
            .secuenciaSolicitud(registrarSolicitudReasignacionRequest.getSecuenciaSolicitud())
            .secuenciaPorExpediente(
                registrarSolicitudReasignacionRequest.getSecuenciaPorExpediente())
            .idClasificador(registrarSolicitudReasignacionRequest.getIdClasificador())
            .monto(registrarSolicitudReasignacionRequest.getMonto())
            .montoNacional(registrarSolicitudReasignacionRequest.getMontoNacional())
            .estadoRegistro(registrarSolicitudReasignacionRequest.getEstadoRegistro()).build())
        .solicitudRendicionMetaCommand(SolicitudRendicionMetaCommand.builder()
            .anoEje(registrarSolicitudReasignacionRequest.getAnio())
            .entidad(SecurityUtil.getUnidadEjecutora())
            .secuenciaSolicitud(registrarSolicitudReasignacionRequest.getSecuenciaSolicitud())
            .secuenciaPorExpediente(
                registrarSolicitudReasignacionRequest.getSecuenciaPorExpediente())
            .idClasificador(registrarSolicitudReasignacionRequest.getIdClasificador())
            .secuenciaFuncional(registrarSolicitudReasignacionRequest.getSecuenciaFuncional())
            .monto(registrarSolicitudReasignacionRequest.getMonto())
            .montoNacional(registrarSolicitudReasignacionRequest.getMontoNacional())
            .estadoRegistro(registrarSolicitudReasignacionRequest.getEstadoRegistro()).build())
        .solicitudRendicionSecCommand(SolicitudRendicionSecCommand.builder()
            .anioEje(registrarSolicitudReasignacionRequest.getAnio())
            .entidad(SecurityUtil.getUnidadEjecutora())
            .secuenciaSolicitud(registrarSolicitudReasignacionRequest.getSecuenciaSolicitud())
            .correlativoSolicitud(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionSec().getCorrelativoSolicitud())
            .tipoRegistro(registrarSolicitudReasignacionRequest.getSolicitudReasignacionSec()
                .getTipoRegistro())
            .codigoDocumento(registrarSolicitudReasignacionRequest.getSolicitudReasignacionSec()
                .getCodigoDocumento())
            .numeroDocumento(registrarSolicitudReasignacionRequest.getSolicitudReasignacionSec()
                .getNumeroDocumento())
            .fechaDocumento(Objects.isNull(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionSec().getFechaDocumento())
                    ? null
                    : LocalDate.parse(registrarSolicitudReasignacionRequest
                        .getSolicitudReasignacionSec().getFechaDocumento(), formatter))
            .fechaRegistro(Objects.isNull(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionSec().getFechaRegistro())
                    ? null
                    : LocalDate.parse(registrarSolicitudReasignacionRequest
                        .getSolicitudReasignacionSec().getFechaRegistro(), formatter))
            .fechaProceso(Objects.isNull(registrarSolicitudReasignacionRequest
                .getSolicitudReasignacionSec().getFechaProceso())
                    ? null
                    : LocalDate.parse(registrarSolicitudReasignacionRequest
                        .getSolicitudReasignacionSec().getFechaProceso(), formatter))
            .estadoRegistro(registrarSolicitudReasignacionRequest.getEstadoRegistro()).build())
        .build();
  }
  
  public static SolicitudRendicionCabCommand mapToSolicitudReasignacionCabCommand(Integer anio,
      Integer entidad, Integer secuenciaNota, String estado) {
    
    return SolicitudRendicionCabCommand.builder().anoEje(anio).entidad(entidad)
        .secNota(secuenciaNota).estadoRegistro(estado).build();
    
  }

  public static SolicitudRendicionSecCommand mapToSolicitudReasignacionSecCommand(Integer anio,
      Integer entidad, Integer secuenciaNota, String estado, String estadoEnvio) {
    
    var solReasignacionSec = SolicitudRendicionSecCommand.builder().anioEje(anio).entidad(entidad)
        .secNota(secuenciaNota).estadoRegistro(estado).build();
    
    if (!Objects.isNull(estadoEnvio)) {
      solReasignacionSec.setEstadoEnvio(estadoEnvio);
    }
    
    return solReasignacionSec;
    
  }
  
  public static SolicitudRendicionSecCommand mapToSolicitudReasignacionSecCommand(
      RegistrarAnulaSolicitudRendicionRequest registrarAnulaSolicitudRendicionRequest) {

    return SolicitudRendicionSecCommand.builder()
        .anioEje(registrarAnulaSolicitudRendicionRequest.getAnio())
        .entidad(SecurityUtil.getUnidadEjecutora())
        .secuenciaSolicitud(registrarAnulaSolicitudRendicionRequest.getSecuenciaSolicitud())
        .correlativoSolicitud(registrarAnulaSolicitudRendicionRequest.getCorrelativoSolicitud())
        .tipoRegistro(registrarAnulaSolicitudRendicionRequest.getTipoRegistro())
        .codigoDocumento(registrarAnulaSolicitudRendicionRequest.getCodigoDocumento())
        .numeroDocumento(registrarAnulaSolicitudRendicionRequest.getNumeroDocumento())
        .fechaDocumento(registrarAnulaSolicitudRendicionRequest.getFechaDocumento())
        .estadoRegistro(registrarAnulaSolicitudRendicionRequest.getEstadoRegistro()).build();

  }
  
  public static SolicitudRendicionCabCommand mapToSolicitudRendicionCabCommand(Integer anio,
      Integer entidad, Integer secuenciaNota, Integer secuenciaSolicitud, String estado) {
    
    return SolicitudRendicionCabCommand.builder().anoEje(anio).entidad(entidad)
        .secNota(secuenciaNota).secuenciaSolicitud(secuenciaSolicitud).estadoRegistro(estado)
        .build();
    
  }
  
  public static SolicitudRendicionSecCommand mapToSolicitudRendicionSecCommand(Integer anio,
      Integer entidad, Integer secuenciaNota, Integer secuenciaSolicitud, String estado,
      String estadoEnvio) {

    var solReasignacionSec =
        SolicitudRendicionSecCommand.builder().anioEje(anio).entidad(entidad).secNota(secuenciaNota)
            .secuenciaSolicitud(secuenciaSolicitud).estadoRegistro(estado).build();

    if (!Objects.isNull(estadoEnvio)) {
      solReasignacionSec.setEstadoEnvio(estadoEnvio);
    }

    return solReasignacionSec;

  }

}
