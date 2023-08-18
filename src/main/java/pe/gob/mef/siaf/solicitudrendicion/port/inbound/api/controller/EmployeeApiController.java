package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import pe.gob.mef.siaf.solicitudrendicion.application.service.EmployeesCommandService;
import pe.gob.mef.siaf.solicitudrendicion.application.service.EmployeesQueryService;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.EmployeeRequest;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.EmployeeResponse;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.mapper.EmployeesMapper;

@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION, HttpHeaders.CONTENT_TYPE})
@RestController
public class EmployeeApiController implements EmployeeApi {

  @Autowired
  private EmployeesQueryService employeesQueryService;
  
  @Autowired
  private EmployeesCommandService employeesCommandService;
  
  @Override
  public ResponseEntity<List<EmployeeResponse>> list() {
    return ResponseEntity
        .ok(EmployeesMapper.aObtenerListaEmployeesResponse(employeesQueryService.list()));
  }
  
  @Override
  public ResponseEntity<EmployeeResponse> get(Integer id) {
    return ResponseEntity
        .ok(EmployeesMapper.aObtenerEmployeesResponse(employeesQueryService.get(id)));
  }

  @Override
  public ResponseEntity<Void> save(EmployeeRequest employeeRequest,
      UriComponentsBuilder uriBuilder) {
    
    employeesCommandService.registrar(EmployeesMapper.aObtenerEmployeesCommand(employeeRequest));
    
    return ResponseEntity.created(uriBuilder
        .path("/employees/{id}")
        .buildAndExpand(employeeRequest.getId())
        .toUri()).build();
  }

  @Override
  public ResponseEntity<Void> update(Integer id, EmployeeRequest employeeRequest) {
    employeeRequest.setId(id);
    employeesCommandService.actualizar(EmployeesMapper.aObtenerEmployeesCommand(employeeRequest));
    
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Void> delete(Integer id) {
    var employeeRequest = EmployeeRequest.builder().id(id).build();
    employeesCommandService.eliminar(EmployeesMapper.aObtenerEmployeesCommand(employeeRequest));
    return ResponseEntity.noContent().build();
  }





}
