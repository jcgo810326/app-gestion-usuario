package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class JwtRequest implements Serializable {

  private static final long serialVersionUID = 5926468583005150707L;
  
  private String username;
  
  private String password;

}
