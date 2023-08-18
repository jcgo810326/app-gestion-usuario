package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import javax.annotation.Generated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * SolicitudRendicionDetalleClasificadoresResponse
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class SolicitudRendicionDetalleClasificadoresResponse {

  String clasificador;

  String descriClasificador;

  Integer secuenciaFuncional;

  String descriSecuenciaFuncional;

  Double montoNacionalMeta;

  Integer tipoTransaccion;

  String descriTipoTransaccion;

  Integer generica;

  String descriGenerica;

  Integer subGenerica;

  String descriSubGenerica;

  Integer subGenericaDet;

  String descriSubGenericaDet;

  Integer especifica;

  String descriEspecifica;

  Integer especificaDet;

  String descriEspecificaDet;

}
