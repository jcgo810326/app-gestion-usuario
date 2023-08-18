package pe.gob.mef.siaf.solicitudrendicion.view.projection;

import java.io.Serializable;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SolicitudRendicionExpMetaOrigenProjection implements Serializable {

  private static final long serialVersionUID = -9085233464844803484L;

  Integer tipoTransaccion;
  
  Integer generica;
  
  Integer subGenerica;
  
  Integer subGenericaDet;
  
  Integer especifica;
  
  Integer especificaDet;

  Integer meta;

  Double montoRendir;

  String descriTipoTransaccion;

  String descriGenerica;

  String descriSubGenerica;

  String descriSubGenericaDet;

  String descriEspecifica;

  String descriEspecificaDet;
  
  public String getClasificador() {
    return (Objects.isNull(tipoTransaccion) ? "" : tipoTransaccion.toString() + " ") + 
           (Objects.isNull(generica) ? "" : generica.toString() + " ") + 
           (Objects.isNull(subGenerica) ? "" : subGenerica.toString() + " ") + 
           (Objects.isNull(subGenericaDet) ? "" : subGenericaDet.toString() + " ") + 
           (Objects.isNull(especifica) ? "" : especifica.toString() + " ") + 
           (Objects.isNull(especificaDet) ? "" : especificaDet.toString());
  }

}
