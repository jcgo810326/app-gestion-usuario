package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.List;

/**
 * ObtenerListaSolicitudesRendicion
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class ObtenerListaSolicitudesRendicion {

  @Valid
  List<SolicitudRendicionResponse> content;

  PaginacionResponse paginacion;

}
