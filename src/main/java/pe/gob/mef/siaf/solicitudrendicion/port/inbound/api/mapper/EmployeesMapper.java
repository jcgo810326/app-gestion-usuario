package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.mapper;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.RegisterEmployeeCommand;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.EmployeeRequest;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.EmployeeResponse;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.EmployeesProjection;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeesMapper {

  public static List<EmployeeResponse> aObtenerListaEmployeesResponse(
      List<EmployeesProjection> response) {

    if (response == null) {
      return null;
    }

    var listaEmployees = new ArrayList<EmployeeResponse>();
    response.forEach(item -> listaEmployees
        .add(EmployeeResponse.builder().id(item.getId()).nombres(item.getNombres()).build()));

    return listaEmployees;
  }
  
  public static EmployeeResponse aObtenerEmployeesResponse(
      EmployeesProjection response) {

    if (response == null) {
      return null;
    }
    
    return EmployeeResponse.builder().id(response.getId()).nombres(response.getNombres()).build();
  }
  
  public static RegisterEmployeeCommand aObtenerEmployeesCommand(EmployeeRequest employeeRequest) {

    return RegisterEmployeeCommand.builder().id(employeeRequest.getId())
        .nombres(employeeRequest.getNombres()).build();
    
  }
  

}
