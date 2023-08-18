package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import java.time.LocalDate;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * RegistrarAnulaSolicitudRendicionRequest
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class RegistrarAnulaSolicitudRendicionRequest {

  Integer anio;

  Integer secuenciaSolicitud;

  Integer correlativoSolicitud;

  String tipoRegistro;

  String codigoDocumento;

  String numeroDocumento;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  LocalDate fechaDocumento;

  String estadoRegistro;

}
