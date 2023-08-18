package pe.gob.mef.siaf.solicitudrendicion.view.projection;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SolicitudReasignacionProjection {

  Integer anio;

  Integer entidad;

  Integer secNota;

  Integer expediente;

  String codEstadoRegistro;

  String descriEstadoRegistro;

}
