package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * RegistrarSolicitudReasignacionCab
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class RegistrarSolicitudReasignacionCab {

  Integer mesEjec;

  Integer tipoSolicitud;

  String indicadorCertifica;

  String tipoOperacion;

  Integer tipoRendicion;

  Integer secuenciaNota;

  String estadoCertificacion;

}
