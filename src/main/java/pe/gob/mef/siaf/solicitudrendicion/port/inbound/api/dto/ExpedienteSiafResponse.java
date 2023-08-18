package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * ExpedienteSiafResponse
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class ExpedienteSiafResponse {

  Integer expediente;

  Integer secuencia;

  String rubro;

  String tipoOperacion;

  String descriTipoOperacion;

  String codigoDocumento;

  String numeroDocumento;

  String fecha;

  Integer certificado;

  Integer certificadoSecuencia;

  Double monto;

  Double montoNacional;

}
