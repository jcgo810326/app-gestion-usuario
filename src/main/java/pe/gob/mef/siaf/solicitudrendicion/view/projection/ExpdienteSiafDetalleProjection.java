package pe.gob.mef.siaf.solicitudrendicion.view.projection;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ExpdienteSiafDetalleProjection {

  Integer anio;

  Integer entidad;

  String ciclo;

  String fase;

  Integer expediente;

  Integer secuencia;

  Integer correlativo;

  String fuenteFinanciamiento;

  String codTipoOperacion;

  String descriTipoOperacion;

  String codigoDocumento;

  String numeroDocumento;

  String fechaDocumento;

  Integer certificado;

  Integer certificadoSecuencia;

  Integer tipoTransaccion;
  
  Integer generica;
  
  Integer subGenerica;
  
  Integer subGenericaDet;
  
  Integer especifica;
  
  Integer especificaDet;

  Integer secuenciaFuncional;

  String descriTipoTransaccion;

  String descriGenerica;

  String descriSubGenerica;

  String descriSubGenericaDet;

  String descriEspecifica;

  String descriEspecificaDet;

  Double montoNacional;
  
  public String getClasificador() {
    return tipoTransaccion + " " + generica + " " + subGenerica + " " + subGenericaDet + " "
        + especifica + " " + especificaDet;
  }

}
