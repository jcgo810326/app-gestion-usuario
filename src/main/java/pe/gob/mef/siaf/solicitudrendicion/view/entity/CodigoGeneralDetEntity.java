package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "codigo_general_det", schema = "siafmef")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CodigoGeneralDetEntity implements Serializable {

  private static final long serialVersionUID = 1257476103421279843L;

  @Id
  @Column(name = "codigo_det")
  String codigoDet;

  @Id
  @Column(name = "codigo")
  String codigo;

  @Column(name = "descripcion")
  String descripcion;

}
