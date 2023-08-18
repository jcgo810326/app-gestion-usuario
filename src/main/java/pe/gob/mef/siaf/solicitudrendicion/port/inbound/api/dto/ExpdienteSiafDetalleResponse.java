package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * ExpdienteSiafDetalleResponse
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class ExpdienteSiafDetalleResponse {

  Integer anio;

  Integer entidad;

  String ciclo;

  String fase;

  Integer expediente;

  Integer secuencia;

  Integer correlativo;

  String fuenteFinanciamiento;

  String codTipoOperacion;

  String descriTipoOperacion;

  String codDocumento;

  String numDocumento;

  String fechaDocumento;

  Integer certificado;

  Integer certificadoSecuencia;

  String clasificador;

  Integer meta;

  String descriTipoTransaccion;

  String descriGenerica;

  String descriSubGenerica;

  String descriSubGenericaDet;

  String descriEspecifica;

  String descriEspecificaDet;

  Double montoNacional;

}
