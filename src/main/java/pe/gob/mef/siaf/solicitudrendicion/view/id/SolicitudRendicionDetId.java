package pe.gob.mef.siaf.solicitudrendicion.view.id;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SolicitudRendicionDetId implements Serializable {

  private static final long serialVersionUID = 6183242701092462098L;

  Integer anioEje;

  Integer entidad;
  
  Integer secuenciaSolicitud;
  
  Integer secuenciaPorExpediente;

}
