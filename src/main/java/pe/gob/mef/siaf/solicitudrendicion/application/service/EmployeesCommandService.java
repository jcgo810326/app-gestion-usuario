package pe.gob.mef.siaf.solicitudrendicion.application.service;

import pe.gob.mef.siaf.solicitudrendicion.domain.command.RegisterEmployeeCommand;

public interface EmployeesCommandService {

  void registrar(RegisterEmployeeCommand registerEmployeeCommand);
  
  void actualizar(RegisterEmployeeCommand registerEmployeeCommand);
  
  void eliminar(RegisterEmployeeCommand registerEmployeeCommand);

}
