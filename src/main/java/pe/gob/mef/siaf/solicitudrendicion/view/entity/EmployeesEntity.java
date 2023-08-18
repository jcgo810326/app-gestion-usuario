package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.RegisterEmployeeCommand;
import pe.gob.mef.siaf.solicitudrendicion.view.id.EmployeesId;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "employees", schema = "gestion_usuario")
@IdClass(EmployeesId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeesEntity implements Serializable {

  private static final long serialVersionUID = 1257476103421279843L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", columnDefinition = "serial")
  Integer id;

  @Column(name = "nombres")
  String nombres;
  
  public EmployeesEntity(RegisterEmployeeCommand registerEmployeeCommand) {
    // this.id = registerEmployeeCommand.getId();
    this.nombres = registerEmployeeCommand.getNombres();
  }
  
  public EmployeesEntity() {
    super();
  }

}
