package pe.gob.mef.siaf.solicitudrendicion.view.projection;

import java.io.Serializable;
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
public class ListaSolicitudesRendicionProjection implements Serializable {

  private static final long serialVersionUID = -9085233464844803484L;

  @JsonProperty(value = "anio")
  Integer anoEje;

  @JsonProperty(value = "entidad")
  Integer secEjec;
  
  Integer mesEje;
  
  Integer secNota;
  
  Integer expediente;
  
  String codEstadoRegistro;
  
  String descriEstadoRegistro;

}
