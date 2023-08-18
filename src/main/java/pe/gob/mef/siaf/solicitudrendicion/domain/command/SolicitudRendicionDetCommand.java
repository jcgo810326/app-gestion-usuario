package pe.gob.mef.siaf.solicitudrendicion.domain.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SolicitudRendicionDetCommand {

  Integer anioEje;

  Integer entidad;
  
  Integer secuenciaSolicitud;
  
  Integer secuenciaPorExpediente;

  Integer expediente;
  
  String fuenteFinanciamiento;

  Integer entidadReciproca;
  
  String codTipoDocIdentidad;

  String ruc;
  
  String ciclo;

  String fase;

  Integer correlativo;
  
  Integer secuencia;
  
  Integer secuenciaAnterior;

  Integer secuenciaPadre;
  
  Integer secNotaModificatoria;
  
  Integer certificado;
  
  Integer certificadoSecuencia;
  
  String moneda;
  
  Double tipoCambio;

  Double monto;
  
  Double montoNacional;
  
  String estadoRegistro; 
  
  Integer secuenciaSolicitudPadre;

}
