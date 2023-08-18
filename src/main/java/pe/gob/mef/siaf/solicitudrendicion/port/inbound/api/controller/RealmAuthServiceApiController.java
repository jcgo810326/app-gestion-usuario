package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mef.siaf.solicitudrendicion.application.service.JwtUserDetailsService;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.config.JwtTokenUtil;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.JwtResponse;

/**
 * <p>
 * Api para el listado de endpoints principales.
 * </p>
 * <p>
 * Agregar además el requerimiento con el formato: <CÓDIGO DEL PROYECTO> <(NÚMERO DE AR)>
 * </p>
 *
 * @version 1.0, 04/08/2023
 * @author 
 */
@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION, HttpHeaders.CONTENT_TYPE})
@RestController
public class RealmAuthServiceApiController implements RealmAuthServiceApi {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private JwtUserDetailsService userDetailsService;
  
  @Override
  public ResponseEntity<String> helloWorld() {
    return ResponseEntity.ok("Hello World!!");
  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
  
  @Override
  public ResponseEntity<?> createAuthenticationToken(@RequestParam("user") String username,
      @RequestParam("password") String pwd)
      throws Exception {
    
    authenticate(username, pwd);
    final UserDetails userDetails =
        userDetailsService.loadUserByUsername(username);
    final String token = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new JwtResponse(token));
  }


}
