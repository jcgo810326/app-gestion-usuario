package pe.gob.mef.siaf.solicitudrendicion.domain.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SolicitudRendicionClasifCommand {

  Integer anoEje;

  Integer entidad;
  
  Integer secuenciaSolicitud;
  
  Integer secuenciaPorExpediente;

  String idClasificador;
  
  Double monto; 
  
  Double montoNacional;
  
  String estadoRegistro;

}
