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
public class SolicitudReasignacionDetalleProjection {

  Integer anio;
  
  Integer mes;

  Integer entidad;

  Integer secNota;

  Integer secuenciaSolicitud;

  String codDocumento;

  String numDocumento;

  LocalDate fechaDocumento;

  String codEstadoRegistro;

  String descriEstadoRegistro;

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

  Double tipoCambio;

  Double montoNacional;

  String fuenteFinanciamiento;

  String descriFuenteFinanc;

  Integer tipoTransaccionOrigen;
  
  Integer genericaOrigen;
  
  Integer subGenericaOrigen;
  
  Integer subGenericaDetOrigen;
  
  Integer especificaOrigen;
  
  Integer especificaDetOrigen;

  String descriClasificadorOrigen;

  Integer secuenciaFuncional;

  String descriSecuenciaFuncional;

  Double montoNacionalMeta;

  Integer tipoTransaccionDestino;
  
  Integer genericaDestino;
  
  Integer subGenericaDestino;
  
  Integer subGenericaDetDestino;
  
  Integer especificaDestino;
  
  Integer especificaDetDestino;

  String descriClasificadorDestino;

  Integer secuenciaFuncionalDestino;

  String descriSecuenciaFuncionalDestino;

  Double montoNacionalDestino;
  
  Integer tipoSolicitud;
  
  String indCertificacion;
  
  Integer tipoRendicion;
  
  public String getClasificadorOrigen() {
    return tipoTransaccionOrigen + "." + genericaOrigen + "." + 
           subGenericaOrigen + " " + subGenericaDetOrigen + "." + 
           especificaOrigen + " " + especificaDetOrigen;
  }

  public String getClasificadorDestino() {
    return tipoTransaccionDestino + "." + genericaDestino + "." + 
        subGenericaDestino + " " + subGenericaDetDestino + "." + 
        especificaDestino + " " + especificaDetDestino;
  }

}
