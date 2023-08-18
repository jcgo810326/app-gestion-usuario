package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * SolicitudRendicionExpMetaOrigenResponse
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class SolicitudRendicionExpMetaOrigenResponse {

  String clasificador;

  Integer meta;

  Double montoRendir;

  String descriTipoTransaccion;

  String descriGenerica;

  String descriSubGenerica;

  String descriSubGenericaDet;

  String descriEspecifica;

  String descriEspecificaDet;

}
