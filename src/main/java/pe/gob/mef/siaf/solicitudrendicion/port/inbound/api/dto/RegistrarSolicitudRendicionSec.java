package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * RegistrarSolicitudRendicionSec
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class RegistrarSolicitudRendicionSec {

  Integer correlativoSolicitud;

  String tipoRegistro;

  String codigodocumento;

  String numeroDocumento;

  String fechaDocumento;

  String fechaRegistro;

  String fechaProceso;

}
