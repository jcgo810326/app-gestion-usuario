package pe.gob.mef.siaf.solicitudrendicion.domain.query;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class ObtenerCuentaBancoQuery {

  Integer anio;

  Integer entidad;

  Integer secejec2;

  String origen;

  String rubro;

  String tipoRecurso;

}
