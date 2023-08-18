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
public class SolicitudRendicionMarcoPresupuestoProjection implements Serializable {

  private static final long serialVersionUID = -9085233464844803484L;

  Integer anoEje;
  
  Integer meta;

  Integer tipoTransaccion;
  
  Integer generica;
  
  Integer subGenerica;
  
  Integer subGenericaDet;
  
  Integer especifica;
  
  Integer especificaDet;

  Double marcoDisponible;
  
  public String getClasificador() {
    return tipoTransaccion.toString() + "" + generica.toString() + "." + 
           subGenerica.toString() + " " + subGenericaDet.toString() + ". " + 
           especifica.toString() + "" + especificaDet.toString();
  }

}
