package pe.gob.mef.siaf.solicitudrendicion.domain.command;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class RegisterEmployeeCommand {

  Integer id;
  
  String nombres;
  
}
