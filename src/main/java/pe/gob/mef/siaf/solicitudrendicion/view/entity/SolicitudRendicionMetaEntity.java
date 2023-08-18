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
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionMetaCommand;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionMetaId;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "solicitud_rend_reasig_meta", schema = "ejecucion")
@IdClass(SolicitudRendicionMetaId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SolicitudRendicionMetaEntity implements Serializable {

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
  
  @Id
  @Column(name = "sec_func")
  Integer secuenciaFuncional;
  
  @Column(name = "monto")
  Double monto; 
  
  @Column(name = "monto_nacional")
  Double montoNacional;
  
  @Column(name = "estado_registro")
  String estadoRegistro;

  public SolicitudRendicionMetaEntity(SolicitudRendicionMetaCommand solicitudRendicionMetaCommand) {
    this.anoEje = solicitudRendicionMetaCommand.getAnoEje();
    this.entidad = solicitudRendicionMetaCommand.getEntidad();
    this.secuenciaSolicitud = solicitudRendicionMetaCommand.getSecuenciaSolicitud();
    this.secuenciaPorExpediente = solicitudRendicionMetaCommand.getSecuenciaPorExpediente();
    this.idClasificador = solicitudRendicionMetaCommand.getIdClasificador();
    this.secuenciaFuncional = solicitudRendicionMetaCommand.getSecuenciaFuncional();
    this.monto = solicitudRendicionMetaCommand.getMonto();
    this.montoNacional = solicitudRendicionMetaCommand.getMontoNacional();
    this.estadoRegistro = solicitudRendicionMetaCommand.getEstadoRegistro();
  }

  public SolicitudRendicionMetaEntity() {
    super();
  }

}
