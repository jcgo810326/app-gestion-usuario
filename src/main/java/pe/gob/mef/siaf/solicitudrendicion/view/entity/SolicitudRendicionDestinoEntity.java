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
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionDestinoCommand;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionDestinoId;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "solicitud_rend_reasig_dst", schema = "ejecucion")
@IdClass(SolicitudRendicionDestinoId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SolicitudRendicionDestinoEntity implements Serializable {

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
  
  @Id
  @Column(name = "id_clasificador_dst")
  String idClasificadorDestino;
  
  @Id
  @Column(name = "sec_func_dst")
  Integer secuenciaFuncionalDestino;

  @Column(name = "monto")
  Double monto; 
  
  @Column(name = "monto_nacional")
  Double montoNacional;
  
  @Column(name = "estado_registro")
  String estadoRegistro;

  public SolicitudRendicionDestinoEntity(
      SolicitudRendicionDestinoCommand solicitudRendicionDestinoCommand) {
    this.anoEje = solicitudRendicionDestinoCommand.getAnoEje();
    this.entidad = solicitudRendicionDestinoCommand.getEntidad();
    this.secuenciaSolicitud = solicitudRendicionDestinoCommand.getSecuenciaSolicitud();
    this.secuenciaPorExpediente = solicitudRendicionDestinoCommand.getSecuenciaPorExpediente();
    this.idClasificador = solicitudRendicionDestinoCommand.getIdClasificador();
    this.secuenciaFuncional = solicitudRendicionDestinoCommand.getSecuenciaFuncional();
    this.idClasificadorDestino = solicitudRendicionDestinoCommand.getIdClasificadorDestino();
    this.secuenciaFuncionalDestino = solicitudRendicionDestinoCommand.getSecuenciaFuncionalDestino();
    this.monto = solicitudRendicionDestinoCommand.getMonto();
    this.montoNacional = solicitudRendicionDestinoCommand.getMontoNacional();
    this.estadoRegistro = solicitudRendicionDestinoCommand.getEstadoRegistro();
  }

  public SolicitudRendicionDestinoEntity() {
    super();
  }

}
