package pe.gob.mef.siaf.solicitudrendicion.view.projection;

import java.io.Serializable;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SolicitudRendicionDetalleProjection implements Serializable {

  private static final long serialVersionUID = -9085233464844803484L;

  @JsonProperty(value = "anio")
  Integer anoEje;

  @JsonProperty(value = "entidad")
  Integer secEjec;
  
  Integer mesEjec;

  Integer secNota;

  Integer secuenciaSolicitud;

  Integer idTipoRendicion;

  String descriTipoRendicion;

  String codDocumento;

  String numDocumento;

  LocalDate fechaDocumento;

  String codEstadoRegistro;

  String descriEstadoRegistro;
  
  String estadoEnvio;
  
  String descriEstadoEnvio;

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
  
  String descriMoneda;

  Double tipoCambio;

  Double montoNacional;

  String fuenteFinanciamiento;

  String descriFuenteFinanc;
  
  Integer tipoSolicitud;
  
  String indCertificacion;
  
  Integer tipoRendicion;

}
