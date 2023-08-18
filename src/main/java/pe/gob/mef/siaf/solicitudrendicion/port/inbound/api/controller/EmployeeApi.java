package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.EmployeeRequest;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.EmployeeResponse;

@Validated
@RestController
public interface EmployeeApi {

  @GetMapping(value = "/employees", produces = {"application/json"})
  ResponseEntity<List<EmployeeResponse>> list();
  
  @GetMapping(value = "/employees/{id}", produces = {"application/json"})
  ResponseEntity<EmployeeResponse> get(@PathVariable("id") Integer id);

  @PostMapping(value = "/employees", produces = {"application/json"})
  ResponseEntity<Void> save(@RequestBody EmployeeRequest employeeRequest,
      UriComponentsBuilder uriBuilder);

  @PutMapping(value = "/employees/{id}", produces = {"application/json"})
  ResponseEntity<Void> update(@PathVariable("id") Integer id,
      @RequestBody EmployeeRequest employeeRequest);

  @DeleteMapping(value = "/employees/{id}", produces = {"application/json"})
  ResponseEntity<Void> delete(@PathVariable("id") Integer id);

}
