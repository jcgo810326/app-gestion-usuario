package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionSecCommand;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionSecId;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "solicitud_rend_reasig_sec", schema = "ejecucion")
@IdClass(SolicitudRendicionSecId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SolicitudRendicionSecEntity implements Serializable {

  private static final long serialVersionUID = 1257476103421279843L;

  @Id
  @Column(name = "ano_eje")
  Integer anioEje;

  @Id
  @Column(name = "sec_ejec")
  Integer entidad;
  
  @Id
  @Column(name = "secuencia_solicitud")
  Integer secuenciaSolicitud;
  
  @Id
  @Column(name = "correlativo_solicitud")
  Integer correlativoSolicitud;
  
  @Column(name = "tipo_registro")
  String tipoRegistro;
  
  @Column(name = "cod_doc")
  String codigoDocumento;
  
  @Column(name = "num_doc")
  String numeroDocumento;
  
  @Column(name = "fecha_doc")
  LocalDate fechaDocumento;

  @Column(name = "fecha_registro")
  LocalDate fechaRegistro;

  @Column(name = "fecha_proceso")
  LocalDate fechaProceso;

  @Column(name = "estado_registro")
  String estadoRegistro;
  
  @Column(name = "estado_envio")
  String estadoEnvio;

  public SolicitudRendicionSecEntity(SolicitudRendicionSecCommand solicitudRendicionSecCommand) {
    this.anioEje = solicitudRendicionSecCommand.getAnioEje();
    this.entidad = solicitudRendicionSecCommand.getEntidad();
    this.secuenciaSolicitud = solicitudRendicionSecCommand.getSecuenciaSolicitud();
    this.correlativoSolicitud = solicitudRendicionSecCommand.getCorrelativoSolicitud();
    this.tipoRegistro = solicitudRendicionSecCommand.getTipoRegistro();
    this.codigoDocumento = solicitudRendicionSecCommand.getCodigoDocumento();
    this.numeroDocumento = solicitudRendicionSecCommand.getNumeroDocumento();
    this.fechaDocumento = solicitudRendicionSecCommand.getFechaDocumento();
    this.fechaRegistro = solicitudRendicionSecCommand.getFechaRegistro();
    this.fechaProceso = solicitudRendicionSecCommand.getFechaProceso();
    this.estadoRegistro = solicitudRendicionSecCommand.getEstadoRegistro();
    this.estadoEnvio = solicitudRendicionSecCommand.getEstadoEnvio();
  }

  public SolicitudRendicionSecEntity() {
    super();
  }
  
}
