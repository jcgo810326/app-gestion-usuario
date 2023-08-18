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
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionCabCommand;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionCabId;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "solicitud_rend_reasig_cab", schema = "ejecucion")
@IdClass(SolicitudRendicionCabId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SolicitudRendicionCabEntity implements Serializable {

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
  
  @Column(name = "mes_eje")
  Integer mesEje;
  
  @Column(name = "sec_nota")
  Integer secNota;  

  @Column(name = "estado_registro")
  String estadoRegistro;
  
  @Column(name = "estado_envio")
  String estadoEnvio;  
  
  @Column(name = "tipo_solicitud")
  Integer tipoSolicitud;

  @Column(name = "tipo_operacion")
  String codTipoOperacion;
  
  @Column(name = "tipo_rendicion")
  Integer tipoRendicion;
  
  @Column(name = "ind_certificacion")
  String indicadorCertificacion;
  
  public SolicitudRendicionCabEntity(SolicitudRendicionCabCommand solicitudRendicionCabCommand) {
    this.anoEje = solicitudRendicionCabCommand.getAnoEje();
    this.entidad = solicitudRendicionCabCommand.getEntidad();
    this.secuenciaSolicitud = solicitudRendicionCabCommand.getSecuenciaSolicitud();
    this.mesEje = solicitudRendicionCabCommand.getMesEje();
    this.secNota = solicitudRendicionCabCommand.getSecNota();
    this.estadoRegistro = solicitudRendicionCabCommand.getEstadoRegistro();
    this.tipoSolicitud = solicitudRendicionCabCommand.getTipoSolicitud();
    this.codTipoOperacion = solicitudRendicionCabCommand.getCodTipoOperacion();
    this.indicadorCertificacion = solicitudRendicionCabCommand.getIndicadorCertificacion();
    this.tipoRendicion = solicitudRendicionCabCommand.getTipoRendicion();
  }

  public SolicitudRendicionCabEntity() {
    super();
  }

}
