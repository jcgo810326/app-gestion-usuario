package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import java.util.List;
import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * SolicitudRendicionDetalleResponse
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class SolicitudRendicionDetalleResponse {

  Integer anio;

  Integer entidad;

  Integer mesEjec;

  Integer secNota;

  Integer secuenciaSolicitud;

  Integer idTipoRendicion;

  String descriTipoRendicion;

  String codDocumento;

  String numDocumento;

  String fechaDocumento;

  String codEstadoRegistro;

  String descriEstadoRegistro;
  
  String estadoEnvio;
  
  String descriEstadoEnvio;

  String codTipoOperacion;

  String descriTipoOperacion;

  String codDocIdentidad;

  String numeroRUC;

  Integer secEjecEntidadReciproca;

  String entidadReciproca;

  Integer expediente;

  String ciclo;

  String fase;

  Integer secuencia;

  Integer certificado;

  Integer certificadoSecuencia;

  String moneda;
  
  String descriMoneda;

  Double tipoCambio;

  Double montoNacional;

  String fuenteFinanciamiento;

  String descriFuenteFinanc;

  List<SolicitudRendicionDetalleClasificadoresResponse> listaClasificadoresOrigen;

  List<SolicitudRendicionDetalleClasificadoresResponse> listaClasificadoresDestino;
}
