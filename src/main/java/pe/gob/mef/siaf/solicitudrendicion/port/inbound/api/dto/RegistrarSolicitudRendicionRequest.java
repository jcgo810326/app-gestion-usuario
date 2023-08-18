package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * RegistrarSolicitudRendicionRequest
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class RegistrarSolicitudRendicionRequest {

  Integer anio;

  Integer secuenciaSolicitud;

  Integer secuenciaPorExpediente;

  String idClasificador;

  Integer secuenciaFuncional;

  String estadoRegistro;

  Double monto;

  Double montoNacional;

  RegistrarSolicitudRendicionCab solicitudRendicionCab;

  RegistrarSolicitudRendicionDet solicitudRendicionDet;

  RegistrarSolicitudRendicionDestino solicitudRendicionDestino;

  RegistrarSolicitudRendicionSec solicitudRendicionSec;

}
