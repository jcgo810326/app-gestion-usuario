package pe.gob.mef.siaf.solicitudrendicion.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository.EmployeesQueryRepository;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.EmployeesProjection;

@Service
@Transactional(readOnly = true)
public class EmployeesQueryServiceImpl implements EmployeesQueryService {

  @Autowired
  private EmployeesQueryRepository employeesQueryRepository;

  @Override
  public List<EmployeesProjection> list() {
    return employeesQueryRepository.list();
  }

  @Override
  public EmployeesProjection get(Integer id) {
    return employeesQueryRepository.get(id);
  }

}
