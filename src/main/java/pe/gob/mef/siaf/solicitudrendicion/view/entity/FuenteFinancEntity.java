
package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pe.gob.mef.siaf.solicitudrendicion.view.id.FuenteFinancId;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@IdClass(FuenteFinancId.class)
@Table(name = "fuente_financ", schema="siafmef")
public class FuenteFinancEntity implements Serializable {

  static final long serialVersionUID = 1730287773742128957L;

  @Id
  @Column(name = "ano_eje")
  Integer anoEje;

  @Id
  @Column(name = "origen")
  String origen;

  @Id
  @Column(name = "fuente_financ")
  String fuenteFinanc;

  String nombre;

}
