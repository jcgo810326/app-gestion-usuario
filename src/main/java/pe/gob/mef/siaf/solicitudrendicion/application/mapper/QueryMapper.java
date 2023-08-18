package pe.gob.mef.siaf.solicitudrendicion.application.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Clase que convierte el parámetro sort a su correspondiente en value object/atributos del
 * aggregate.
 *
 * @author Mariano Alcántara
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QueryMapper {

  public static String aDomain(String querystring) {
    return querystring.replace("anio", "anoEje").replace("ctabanco", "cuentaBanco")
        .replace("expedienteSec", "expediente");
  }

}
