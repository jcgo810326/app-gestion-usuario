package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pe.gob.mef.siaf.solicitudrendicion.view.id.ExpedienteId;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "expediente", schema="ejecucion")
@IdClass(ExpedienteId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ExpedienteEntity implements Serializable {

  private static final long serialVersionUID = 1257476103421279843L;

  @Id
  @Column(name = "ano_eje")
  Integer anoEje;

  @Id
  @Column(name = "sec_ejec")
  Integer entidad;

  @Id
  @Column(name = "expediente")
  Integer expediente;
  
  @Column(name = "tipo_operacion")
  String tipoOperacion;

}