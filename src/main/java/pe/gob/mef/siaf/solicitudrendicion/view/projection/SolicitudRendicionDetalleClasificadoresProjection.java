package pe.gob.mef.siaf.solicitudrendicion.view.projection;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SolicitudRendicionDetalleClasificadoresProjection implements Serializable {

  private static final long serialVersionUID = -9085233464844803484L;

  Integer tipoTransaccion;

  String descriTipoTransaccion;

  Integer generica;
  
  String descriGenerica;

  Integer subGenerica;
  
  String descriSubGenerica;

  Integer subGenericaDet;
  
  String descriSubGenericaDet;

  Integer especifica;
  
  String descriEspecifica;

  Integer especificaDet;
  
  String descriClasificador;

  Integer secuenciaFuncional;

  String descriSecuenciaFuncional;

  Double montoNacionalMeta;

  public String getClasificador() {
    return tipoTransaccion + "." + generica + "." + subGenerica + "." + subGenericaDet + "."
        + especifica + " " + especificaDet;
  }


}
