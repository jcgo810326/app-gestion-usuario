package pe.gob.mef.siaf.solicitudrendicion.domain.command;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SolicitudRendicionSecCommand {

  Integer anioEje;

  Integer entidad;
  
  Integer secuenciaSolicitud;
  
  Integer secNota;
  
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
