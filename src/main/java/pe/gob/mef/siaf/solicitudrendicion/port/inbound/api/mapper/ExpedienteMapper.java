package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.ExpdienteSiafDetalleResponse;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.ExpedienteSiafResponse;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.ObtenerExpdienteSiafDetalle;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.ObtenerListaExpedienteSiaf;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.PaginacionResponse;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ExpdienteSiafDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ExpedienteSiafProjection;

/**
 * Clase que mapea o transforma el DTO a Command.
 *
 * @author Zully Silva
 * @version 1.0, 07/04/2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExpedienteMapper {

  public static ObtenerListaExpedienteSiaf aObtenerListaExpedienteSiafResponse(
      Page<ExpedienteSiafProjection> response) {

    if (response == null) {
      return null;
    }

    var listaExpedienteSiaf = new ArrayList<ExpedienteSiafResponse>();
    response.getContent().forEach(item -> listaExpedienteSiaf.add(ExpedienteSiafResponse.builder()
        .expediente(item.getExpediente()).secuencia(item.getSecuencia()).rubro(item.getRubro())
        .tipoOperacion(item.getTipoOperacion()).descriTipoOperacion(item.getDescriTipoOperacion())
        .codigoDocumento(item.getCodigoDocumento()).numeroDocumento(item.getNumeroDocumento())
        .fecha(item.getFecha()).certificado(item.getCertificado())
        .certificadoSecuencia(item.getCertificadoSecuencia()).monto(item.getMonto())
        .montoNacional(item.getMontoNacional()).build()));

    var paginacion = PaginacionResponse.builder().first(response.isFirst()).last(response.isLast())
        .totalPages(response.getTotalPages())
        .totalElements(Math.toIntExact(response.getTotalElements()))
        .pageSize(response.getNumberOfElements()).page(response.getNumber()).build();

    return ObtenerListaExpedienteSiaf.builder().content(listaExpedienteSiaf)
        .paginacion(paginacion).build();
  }
  
  public static ObtenerExpdienteSiafDetalle aObtenerListaExpedienteSiafDetResponse(
      List<ExpdienteSiafDetalleProjection> response) {

    if (response == null) {
      return null;
    }

    var listaExpedienteDet = new ArrayList<ExpdienteSiafDetalleResponse>();
    response.forEach(item -> listaExpedienteDet.add(ExpdienteSiafDetalleResponse.builder()
        .anio(item.getAnio()).entidad(item.getEntidad()).ciclo(item.getCiclo()).fase(item.getFase())
        .expediente(item.getExpediente()).secuencia(item.getSecuencia())
        .correlativo(item.getCorrelativo()).fuenteFinanciamiento(item.getFuenteFinanciamiento())
        .codTipoOperacion(item.getCodTipoOperacion())
        .descriTipoOperacion(item.getDescriTipoOperacion()).codDocumento(item.getCodigoDocumento())
        .numDocumento(item.getNumeroDocumento()).fechaDocumento(item.getFechaDocumento())
        .certificado(item.getCertificado()).certificadoSecuencia(item.getCertificadoSecuencia())
        .clasificador(item.getClasificador()).meta(item.getSecuenciaFuncional())
        .descriTipoTransaccion(item.getDescriTipoTransaccion())
        .descriGenerica(item.getDescriGenerica()).descriSubGenerica(item.getDescriSubGenerica())
        .descriSubGenericaDet(item.getDescriSubGenericaDet())
        .descriEspecifica(item.getDescriEspecifica())
        .descriEspecificaDet(item.getDescriEspecificaDet()).montoNacional(item.getMontoNacional())
        .build()));

    return ObtenerExpdienteSiafDetalle.builder().content(listaExpedienteDet).build();
  }

}
