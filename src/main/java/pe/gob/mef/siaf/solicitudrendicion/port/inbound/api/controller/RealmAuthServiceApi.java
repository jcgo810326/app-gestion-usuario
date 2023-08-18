package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public interface RealmAuthServiceApi {

  @GetMapping(value = "/hello", produces = {"application/json"})
  ResponseEntity<String> helloWorld();
  
  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestParam("user") String username,
      @RequestParam("password") String pwd) throws Exception;

}
