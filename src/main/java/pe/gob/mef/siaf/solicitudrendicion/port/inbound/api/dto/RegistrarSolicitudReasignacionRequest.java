package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * RegistrarSolicitudReasignacionRequest
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class RegistrarSolicitudReasignacionRequest {

  Integer anio;

  Integer secuenciaSolicitud;

  Integer secuenciaPorExpediente;

  String idClasificador;

  Integer secuenciaFuncional;

  Double monto;

  Double montoNacional;

  String estadoRegistro;

  RegistrarSolicitudReasignacionCab solicitudReasignacionCab;

  RegistrarSolicitudReasignacionDet solicitudReasignacionDet;

  RegistrarSolicitudReasignacionDestino solicitudReasignacionDestino;

  RegistrarSolicitudReasignacionSec solicitudReasignacionSec;

}
