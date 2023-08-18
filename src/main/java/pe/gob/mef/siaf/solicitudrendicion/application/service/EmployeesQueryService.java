package pe.gob.mef.siaf.solicitudrendicion.application.service;

import java.util.List;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.EmployeesProjection;

public interface EmployeesQueryService {
  
  List<EmployeesProjection> list();
  
  EmployeesProjection get(Integer id);

}
