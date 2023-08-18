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
@Table(name = "expediente_secuencia", schema = "ejecucion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ExpedienteSecuenciaEntity implements Serializable {

  private static final long serialVersionUID = 1257476103421279843L;

  @Id
  @Column(name = "ano_eje")
  Integer anoEje;

  @Id
  @Column(name = "sec_ejec")
  Integer entidad;

  @Id
  @Column(name = "expediente")
  Integer expedienteSec;

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
  
  @Column(name = "correlativo")
  Integer correlativo;
  
  @Column(name = "cod_doc")
  String codigoDocumento;
  
  @Column(name = "num_doc")
  String numeroDocumento;
  
  @Column(name = "fecha_doc")
  String fechaDocumento;
  
  @Column(name = "monto")
  Double monto;
  
  @Column(name = "monto_nacional")
  Double montoNacional;

}