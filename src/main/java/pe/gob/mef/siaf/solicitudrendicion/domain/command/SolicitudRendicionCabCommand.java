package pe.gob.mef.siaf.solicitudrendicion.domain.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SolicitudRendicionCabCommand {

  Integer anoEje;

  Integer entidad;
  
  Integer secuenciaSolicitud;  
  
  Integer mesEje;
  
  Integer secNota;  

  String estadoRegistro;  
  
  Integer tipoSolicitud;

  String codTipoOperacion;
  
  Integer tipoRendicion;
  
  String indicadorCertificacion;
  
  String estadoCertificacion;

}
