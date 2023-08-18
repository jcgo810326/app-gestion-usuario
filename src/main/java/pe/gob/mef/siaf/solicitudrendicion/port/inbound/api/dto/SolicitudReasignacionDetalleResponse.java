package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * SolicitudReasignacionDetalleResponse
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class SolicitudReasignacionDetalleResponse {

  Integer anio;

  Integer entidad;

  Integer secNota;

  Integer secuenciaSolicitud;

  String codDocumento;

  String numDocumento;

  String fechaDocumento;

  String codEstadoRegistro;

  String descriEstadoRegistro;

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

  Double tipoCambio;

  Double montoNacional;

  String fuenteFinanciamiento;

  String descriFuenteFinanc;

  String clasificador;

  String descriClasificador;

  Integer secuenciaFuncional;

  String descriSecuenciaFuncional;

  Double montoNacionalMeta;

  String clasificadorDestino;

  String descriClasificadorDestino;

  Integer secuenciaFuncionalDestino;

  String descriSecuenciaFuncionalDestino;

  Double montoNacionalDestino;

}
