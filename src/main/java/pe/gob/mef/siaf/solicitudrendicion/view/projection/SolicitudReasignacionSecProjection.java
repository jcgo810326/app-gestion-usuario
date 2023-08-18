package pe.gob.mef.siaf.solicitudrendicion.view.projection;

import java.time.LocalDate;
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
public class SolicitudReasignacionSecProjection {

  Integer anioEje;

  Integer entidad;
  
  Integer secuenciaSolicitud;
  
  Integer correlativoSolicitud;
  
  String tipoRegistro;
  
  String codigoDocumento;
  
  String numeroDocumento;
  
  LocalDate fechaDocumento;

  LocalDate fechaRegistro;

  LocalDate fechaProceso;

  String estadoRegistro;
  
  String estadoEnvio;

}
