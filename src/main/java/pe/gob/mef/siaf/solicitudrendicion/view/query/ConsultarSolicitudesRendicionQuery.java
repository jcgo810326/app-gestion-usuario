package pe.gob.mef.siaf.solicitudrendicion.view.query;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ConsultarSolicitudesRendicionQuery {

  Integer anoEje;

  Integer secEjec;

  Integer mesEje;
  
  Integer expediente;
  
  Integer tipoSolicitud;
  
  String estadoRegistro;

  String fuenteFinanciamiento;
  
  Integer secuenciaNota;
  
  Integer secuenciaSolicitud;
  
  String ciclo;
  
  String fase;
  
  Integer page;

  Integer pageSize;

  String sort;

}
