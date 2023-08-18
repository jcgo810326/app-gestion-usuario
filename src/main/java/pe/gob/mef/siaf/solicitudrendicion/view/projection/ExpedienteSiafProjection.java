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
public class ExpedienteSiafProjection {

  Integer expediente;
  
  String ciclo;
  
  String fase;

  Integer secuencia;

  String rubro;

  String tipoOperacion;
  
  String descriTipoOperacion;
  
  String codigoDocumento;

  String numeroDocumento;

  String fecha;

  Integer certificado;

  Integer certificadoSecuencia;

  Double monto;

  Double montoNacional;

}
