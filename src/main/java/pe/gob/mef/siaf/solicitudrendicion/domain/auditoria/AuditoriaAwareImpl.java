package pe.gob.mef.siaf.solicitudrendicion.domain.auditoria;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.util.ExceptionConstantes;

/**
 * Clase que coloca el usuario del token JWT en los campos de auditoría.
 *
 * @author Mariano Alcántara
 * @version 1.0, 23/05/21
 */
public class AuditoriaAwareImpl { // implements AuditorAware<String> {

  /*
  @Override
  public Optional<String> getCurrentAuditor() {

    return Optional
        .of(((JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication())
            .getToken().getClaim(ExceptionConstantes.CLAIM_USUARIO));

  }
  */

}
