package pe.gob.mef.siaf.solicitudrendicion.application.service;

import pe.gob.mef.siaf.solicitudrendicion.domain.command.RegistrarSolicitudRendicionCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionCabCommand;
import pe.gob.mef.siaf.solicitudrendicion.domain.command.SolicitudRendicionSecCommand;

public interface SolicitudRendicionCommandService {

  void registrar(RegistrarSolicitudRendicionCommand registrarSolicitudRendicionCommand);
  
  void actualizaEstadoSolReasignacion(SolicitudRendicionCabCommand solicitudRendicionCabCommand,
      SolicitudRendicionSecCommand solicitudRendicionSecCommand);

  void actualizaEstadoEnvioSolReasignacion(
      SolicitudRendicionSecCommand solicitudRendicionSecCommand);
  
  void insertarEstadoAnularSolicitudRendicionSec(
      SolicitudRendicionSecCommand solicitudRendicionSecCommand);

  void actualizaEstadoSolRendicion(SolicitudRendicionCabCommand solicitudRendicionCabCommand,
      SolicitudRendicionSecCommand solicitudRendicionSecCommand);

  void actualizaEstadoEnvioSolRendicion(
      SolicitudRendicionSecCommand solicitudRendicionSecCommand);

}
