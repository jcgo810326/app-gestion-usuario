package pe.gob.mef.siaf.solicitudrendicion.port.inbound.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionConstantes {

  public static final String ERROR_PAIS_PROHIBIDO = "1001";
  public static final String MENSAJE_PAIS_PROHIBIDO = "El país se encuentra prohibido.";

  public static final String ERROR_PERSONA_NO_EXISTE = "1002";
  public static final String MENSAJE_PERSONA_NO_EXISTE = "La persona no existe en el sistema.";
  
  public static final String ERROR_CONEXION_BD_CODIGO = "1003";
  public static final String ERROR_CONEXION_BD_MENSAJE = "Error de conexión a la base de datos.";

  public static final String ERROR_SOL_RESIGNA_NO_EXISTE = "1004";
  public static final String MENSAJE_SOL_REASIGNA_NO_EXISTE = "Error de conexión a la base de datos.";

  public static final String CLAIM_USUARIO = "preferred_username";

}
