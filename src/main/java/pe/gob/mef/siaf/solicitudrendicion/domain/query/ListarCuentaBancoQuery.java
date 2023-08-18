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
public class ListarCuentaBancoQuery {

  Integer page;
  Integer pageSize;
  String sort;

}
