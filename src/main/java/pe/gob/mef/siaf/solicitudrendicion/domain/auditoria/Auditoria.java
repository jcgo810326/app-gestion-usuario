package pe.gob.mef.siaf.solicitudrendicion.domain.auditoria;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Embeddable
public class Auditoria {

  @Column(name = "fecha_ing", updatable = false)
  @CreatedDate
  protected LocalDateTime fechaCreacion;

  @Column(name = "usuario_ing", updatable = false)
  @CreatedBy
  protected String usuarioCreacion;

  @LastModifiedDate
  @Column(name = "fecha_mod")
  protected LocalDateTime fechaModificacion;

  @LastModifiedBy
  @Column(name = "usuario_mod")
  protected String usuarioModificacion;

}
