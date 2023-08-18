package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * RegistrarSolicitudRendicionDet
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class RegistrarSolicitudRendicionDet {

  Integer expediente;

  String ciclo;

  String fase;

  Integer correlativo;

  Integer secuencia;

  Integer secuenciaAnterior;

  Integer secuenciaPadre;

  Integer secuenciaNotaModif;

  Integer certificado;

  Integer certificadoSecuencia;

  String fuenteFinanciamiento;

  String moneda;

  Double tipoCambio;

  Double monto;

  Double montoNacional;

  Integer secuenciaSolicitudPadre;

  String tipoDocumentIdent;

  String ruc;

  Integer entidadReciproca;

}
