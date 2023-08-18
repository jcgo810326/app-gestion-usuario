package pe.gob.mef.siaf.solicitudrendicion.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.RegisterEmployeeCommand;
import pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository.EmployeesWriteRepository;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.EmployeesEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.id.EmployeesId;

@Service
@Transactional
public class EmployeesCommandServiceImpl implements EmployeesCommandService {

  // @Autowired
  // private EmployeesWriteRepository employeesWriteRepository;
  
  @Override
  public void registrar(RegisterEmployeeCommand registerEmployeeCommand) {
    System.out.println("Registrando");
    // employeesWriteRepository.save(new EmployeesEntity(registerEmployeeCommand));
  }

  @Override
  public void actualizar(RegisterEmployeeCommand registerEmployeeCommand) {
   
    /*
    var employeeId = new EmployeesId();
    employeeId.setId(registerEmployeeCommand.getId());
    
    var result = employeesWriteRepository.findById(employeeId);
    if (result.isPresent()) {
      var employee = result.get();
      
      employee.setNombres(registerEmployeeCommand.getNombres());
      employeesWriteRepository.save(employee);
    }
    */

  }

  @Override
  public void eliminar(RegisterEmployeeCommand registerEmployeeCommand) {

    /*
    var employeeId = new EmployeesId();
    employeeId.setId(registerEmployeeCommand.getId());
    
    var result = employeesWriteRepository.findById(employeeId);
    if (result.isPresent()) {
      var employee = result.get();
      
      employeesWriteRepository.delete(employee);
    }
    */

  }

}
