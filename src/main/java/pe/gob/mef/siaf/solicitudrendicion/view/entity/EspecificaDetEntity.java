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
@Table(name = "especifica_det")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EspecificaDetEntity implements Serializable {

  private static final long serialVersionUID = 1257476103421279843L;

  @Id
  @Column(name = "ano_eje")
  Integer anoEje;

  @Id
  @Column(name = "id_clasificador")
  String idClasificador;

  @Column(name = "tipo_transaccion")
  Integer tipoTransaccion;

  @Column(name = "generica")
  Integer generica;

  @Column(name = "subgenerica")
  Integer subGenerica;

  @Column(name = "subgenerica_det")
  Integer subGenericaDet;

  @Column(name = "especifica")
  Integer especifica;

  @Column(name = "especifica_det")
  Integer especificaDet;
  
  @Column(name = "descripcion")
  String descriClasificador;
  
  @Column(name = "estado")
  String estado;
  
  @Column(name = "tipo_operacion")
  String codTipoOperacion;

}
