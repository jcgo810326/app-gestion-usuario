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
@Table(name = "expediente_fase", schema = "ejecucion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ExpedienteFaseEntity implements Serializable {

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

  @Id
  @Column(name = "ciclo")
  String ciclo;

  @Id
  @Column(name = "fase")
  String fase;
  
  @Id
  @Column(name = "secuencia")
  Integer secuencia;  

  @Column(name = "estado")
  String estado;
  
  @Column(name = "fuente_financ")
  String fuenteFinanc;
  
  @Column(name = "certificado")
  Integer certificado;
  
  @Column(name = "certificado_secuencia")
  Integer certificadoSecuencia;


}