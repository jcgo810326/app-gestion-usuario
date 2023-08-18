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
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionClasifCommand;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionClasifId;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "solicitud_rend_reasig_clasif", schema = "ejecucion")
@IdClass(SolicitudRendicionClasifId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SolicitudRendicionClasifEntity implements Serializable {

  private static final long serialVersionUID = 1257476103421279843L;

  @Id
  @Column(name = "ano_eje")
  Integer anoEje;

  @Id
  @Column(name = "sec_ejec")
  Integer entidad;
  
  @Id
  @Column(name = "secuencia_solicitud")
  Integer secuenciaSolicitud;
  
  @Id
  @Column(name = "sec_x_expediente")
  Integer secuenciaPorExpediente;

  @Id
  @Column(name = "id_clasificador")
  String idClasificador;
  
  @Column(name = "monto")
  Double monto; 
  
  @Column(name = "monto_nacional")
  Double montoNacional;
  
  @Column(name = "estado_registro")
  String estadoRegistro;

  public SolicitudRendicionClasifEntity(
      SolicitudRendicionClasifCommand solicitudRendicionClasifCommand) {
    this.anoEje = solicitudRendicionClasifCommand.getAnoEje();
    this.entidad = solicitudRendicionClasifCommand.getEntidad();
    this.secuenciaSolicitud = solicitudRendicionClasifCommand.getSecuenciaSolicitud();
    this.secuenciaPorExpediente = solicitudRendicionClasifCommand.getSecuenciaPorExpediente();
    this.idClasificador = solicitudRendicionClasifCommand.getIdClasificador();
    this.monto = solicitudRendicionClasifCommand.getMonto();
    this.montoNacional = solicitudRendicionClasifCommand.getMontoNacional();
    this.estadoRegistro = solicitudRendicionClasifCommand.getEstadoRegistro();
  }

  public SolicitudRendicionClasifEntity() {
    super();
  }

}
