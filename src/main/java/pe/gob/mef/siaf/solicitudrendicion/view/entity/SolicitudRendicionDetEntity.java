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
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionDetCommand;
import pe.gob.mef.siaf.solicitudrendicion.view.id.SolicitudRendicionDetId;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "solicitud_rend_reasig_det", schema = "ejecucion")
@IdClass(SolicitudRendicionDetId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SolicitudRendicionDetEntity implements Serializable {

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
  @Column(name = "sec_x_expediente")
  Integer secuenciaPorExpediente;

  @Column(name = "expediente")
  Integer expediente;
  
  @Column(name = "fuente_financ")
  String fuenteFinanciamiento;

  @Column(name = "sec_ejec_reciproca")
  Integer entidadReciproca;
  
  @Column(name = "tipo_id")
  String codTipoDocIdentidad;

  @Column(name = "ruc")
  String ruc;
  
  @Column(name = "ciclo")
  String ciclo;

  @Column(name = "fase")
  String fase;

  @Column(name = "correlativo")
  Integer correlativo;
  
  @Column(name = "secuencia")
  Integer secuencia;
  
  @Column(name = "secuencia_anterior")
  Integer secuenciaAnterior;

  @Column(name = "secuencia_padre")
  Integer secuenciaPadre;
  
  @Column(name = "sec_nota_modificatoria")
  Integer secNotaModificatoria;
  
  @Column(name = "certificado")
  Integer certificado;
  
  @Column(name = "certificado_secuencia")
  Integer certificadoSecuencia;
  
  @Column(name = "moneda")
  String moneda;
  
  @Column(name = "tipo_cambio")
  Double tipoCambio;

  @Column(name = "monto")
  Double monto;
  
  @Column(name = "monto_nacional")
  Double montoNacional;
  
  @Column(name = "estado_registro")
  String estadoRegistro; 
  
  @Column(name = "secuencia_solicitud_padre")
  Integer secuenciaSolicitudPadre;

  public SolicitudRendicionDetEntity(SolicitudRendicionDetCommand solicitudRendicionDetCommand) {
    this.anioEje = solicitudRendicionDetCommand.getAnioEje();
    this.entidad = solicitudRendicionDetCommand.getEntidad();
    this.secuenciaSolicitud = solicitudRendicionDetCommand.getSecuenciaSolicitud();
    this.secuenciaPorExpediente = solicitudRendicionDetCommand.getSecuenciaPorExpediente();
    this.expediente = solicitudRendicionDetCommand.getExpediente();
    this.fuenteFinanciamiento = solicitudRendicionDetCommand.getFuenteFinanciamiento();
    this.entidadReciproca = solicitudRendicionDetCommand.getEntidadReciproca();
    this.codTipoDocIdentidad = solicitudRendicionDetCommand.getCodTipoDocIdentidad();
    this.ruc = solicitudRendicionDetCommand.getRuc();
    this.ciclo = solicitudRendicionDetCommand.getCiclo();
    this.fase = solicitudRendicionDetCommand.getFase();
    this.correlativo = solicitudRendicionDetCommand.getCorrelativo();
    this.secuencia = solicitudRendicionDetCommand.getSecuencia();
    this.secuenciaAnterior = solicitudRendicionDetCommand.getSecuenciaAnterior();
    this.secuenciaPadre = solicitudRendicionDetCommand.getSecuenciaPadre();
    this.secNotaModificatoria = solicitudRendicionDetCommand.getSecNotaModificatoria();
    this.certificado = solicitudRendicionDetCommand.getCertificado();
    this.certificadoSecuencia = solicitudRendicionDetCommand.getCertificadoSecuencia();
    this.moneda = solicitudRendicionDetCommand.getMoneda();
    this.tipoCambio = solicitudRendicionDetCommand.getTipoCambio();
    this.monto = solicitudRendicionDetCommand.getMonto();
    this.montoNacional = solicitudRendicionDetCommand.getMontoNacional();
    this.estadoRegistro = solicitudRendicionDetCommand.getEstadoRegistro();
    this.secuenciaSolicitudPadre = solicitudRendicionDetCommand.getSecuenciaPadre();
  }

  public SolicitudRendicionDetEntity() {
    super();
  }

}
