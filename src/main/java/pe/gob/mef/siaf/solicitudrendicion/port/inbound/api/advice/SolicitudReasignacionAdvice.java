package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.advice;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import pe.gob.mef.common.api.advice.ApiAdvice;
import pe.gob.mef.siaf.solicitudrendicion.domain.exception.SolicitudReasignacionNoExisteException;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.util.ExceptionConstantes;

@ControllerAdvice
public class SolicitudReasignacionAdvice extends ApiAdvice {

  /**
   * Usar prefijo "handle" y luego el nombre de la excepción
   */
  @ExceptionHandler(DataAccessResourceFailureException.class)
  protected ResponseEntity<Object> handleDataAccessResourceFailureException(
      DataAccessResourceFailureException ex, WebRequest request) {

    return handleExceptionInternal(ex, ExceptionConstantes.ERROR_CONEXION_BD_CODIGO,
        ExceptionConstantes.ERROR_CONEXION_BD_MENSAJE, new HttpHeaders(),
        HttpStatus.SERVICE_UNAVAILABLE, request);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  protected ResponseEntity<Object> handleDataIntegrityViolationException(
      DataIntegrityViolationException ex, WebRequest request) {

    return handleExceptionInternal(ex, ExceptionConstantes.ERROR_CONEXION_BD_CODIGO,
        ExceptionConstantes.ERROR_CONEXION_BD_MENSAJE, new HttpHeaders(),
        HttpStatus.SERVICE_UNAVAILABLE, request);
  }


  @ExceptionHandler(SolicitudReasignacionNoExisteException.class)
  protected ResponseEntity<Object> handleSolicitudReasignacionNoExisteException(
      SolicitudReasignacionNoExisteException ex, WebRequest request) {

    return handleExceptionInternal(ex, ExceptionConstantes.ERROR_SOL_RESIGNA_NO_EXISTE,
        ExceptionConstantes.MENSAJE_SOL_REASIGNA_NO_EXISTE, new HttpHeaders(),
        HttpStatus.SERVICE_UNAVAILABLE, request);
  }

}
