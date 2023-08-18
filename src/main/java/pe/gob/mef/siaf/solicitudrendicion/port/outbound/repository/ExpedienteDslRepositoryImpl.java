package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.ExpedienteEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QEspecificaDetEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QEspecificaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QExpedienteEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QExpedienteFaseEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QExpedienteMetaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QExpedienteSecuenciaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QGenericaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QSubGenericaDetEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QSubGenericaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QTipoOperacionEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QTipoTransaccionEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ExpdienteSiafDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ExpedienteSiafProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.query.ConsultarSolicitudesRendicionQuery;
import pe.gob.mef.siaf.solicitudrendicion.view.util.ViewConstantes;

public class ExpedienteDslRepositoryImpl extends QuerydslRepositorySupport
    implements ExpedienteDslRepository {

  public ExpedienteDslRepositoryImpl() {
    super(ExpedienteEntity.class);
  }

  @Override
  public Page<ExpedienteSiafProjection> listarExpedienteSiaf(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery, Pageable pageable) {
    
    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var expedienteSecuencia = QExpedienteSecuenciaEntity.expedienteSecuenciaEntity;
    var expedienteFase = QExpedienteFaseEntity.expedienteFaseEntity;
    var expediente = QExpedienteEntity.expedienteEntity;
    var tipoOperacion = QTipoOperacionEntity.tipoOperacionEntity;
    var builder = new BooleanBuilder();

    builder.and(expedienteSecuencia.anoEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(expedienteSecuencia.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));
    builder.and(expedienteSecuencia.ciclo.eq(consultarSolicitudesRendicionQuery.getCiclo()));
    builder.and(expedienteSecuencia.fase.eq(consultarSolicitudesRendicionQuery.getFase()));
    builder.and(
        expediente.tipoOperacion.trim().notIn(
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_A),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_AV),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_E),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_F),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_C),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_EO),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_TC),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_YG),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_S),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_YC),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_PD)));
    
    var query =  queryDsl.createQuery()
        .select(Projections.constructor(ExpedienteSiafProjection.class,
            expedienteSecuencia.expedienteSec, expedienteSecuencia.ciclo, expedienteSecuencia.fase,
            expedienteSecuencia.secuencia, expedienteFase.fuenteFinanc, expediente.tipoOperacion,
            tipoOperacion.descriTipoOperacion, expedienteSecuencia.codigoDocumento,
            expedienteSecuencia.numeroDocumento, expedienteSecuencia.fechaDocumento,
            expedienteFase.certificado, expedienteFase.certificadoSecuencia,
            expedienteSecuencia.monto.sum(), expedienteSecuencia.montoNacional.sum()
            )
         )
        .from(expedienteSecuencia)
        .leftJoin(expediente)
        .on(expediente.anoEje.eq(expedienteSecuencia.anoEje)
            .and(expediente.entidad.eq(expedienteSecuencia.entidad))
            .and(expediente.expediente.eq(expedienteSecuencia.expedienteSec)))
        .leftJoin(expedienteFase)
        .on(expedienteFase.anoEje.eq(expedienteSecuencia.anoEje)
            .and(expedienteFase.entidad.eq(expedienteSecuencia.entidad))
            .and(expedienteFase.expediente.eq(expedienteSecuencia.expedienteSec))
            .and(expedienteFase.ciclo.eq(expedienteSecuencia.ciclo))
            .and(expedienteFase.fase.eq(expedienteSecuencia.fase))
            .and(expedienteFase.secuencia.eq(expedienteSecuencia.secuencia))
            .and(expedienteFase.estado.eq(expedienteSecuencia.estado)))
        .leftJoin(tipoOperacion)
        .on(tipoOperacion.anoEje.eq(expedienteSecuencia.anoEje)
            .and(tipoOperacion.codTipoOperacion.eq(expediente.tipoOperacion)))
        .where(builder)
        .groupBy(expedienteSecuencia.expedienteSec, expedienteSecuencia.ciclo,
            expedienteSecuencia.fase, expedienteSecuencia.secuencia,expedienteFase.fuenteFinanc,
            expediente.tipoOperacion, tipoOperacion.descriTipoOperacion,
            expedienteSecuencia.codigoDocumento, expedienteSecuencia.numeroDocumento,
            expedienteSecuencia.fechaDocumento, expedienteFase.certificado,
            expedienteFase.certificadoSecuencia
            )
        .orderBy(expediente.tipoOperacion.asc());

    var res = queryDsl.applyPagination(pageable, query);
    return new PageImpl<>(res.fetch(), pageable, query.fetchCount());

  }

  @Override
  public List<ExpdienteSiafDetalleProjection> obtenerExpedienteSiafDetalle(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var expedienteSecuencia = QExpedienteSecuenciaEntity.expedienteSecuenciaEntity;
    var expedienteFase = QExpedienteFaseEntity.expedienteFaseEntity;
    var expediente = QExpedienteEntity.expedienteEntity;
    var expedienteMeta = QExpedienteMetaEntity.expedienteMetaEntity;    
    var tipoOperacion = QTipoOperacionEntity.tipoOperacionEntity;
    var especificaDet = QEspecificaDetEntity.especificaDetEntity;
    var especifica = QEspecificaEntity.especificaEntity;
    var subGenericaDet = QSubGenericaDetEntity.subGenericaDetEntity;
    var subGenerica = QSubGenericaEntity.subGenericaEntity;
    var generica = QGenericaEntity.genericaEntity;
    var tipoTransaccion = QTipoTransaccionEntity.tipoTransaccionEntity;
    var builder = new BooleanBuilder();

    builder.and(expedienteSecuencia.anoEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(expedienteSecuencia.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));
    builder.and(expedienteSecuencia.ciclo.eq(consultarSolicitudesRendicionQuery.getCiclo()));
    builder.and(expedienteSecuencia.fase.eq(consultarSolicitudesRendicionQuery.getFase()));
    builder.and(expediente.expediente.eq(consultarSolicitudesRendicionQuery.getExpediente()));

    return queryDsl.createQuery()
        .select(Projections.constructor(ExpdienteSiafDetalleProjection.class,
            expedienteSecuencia.anoEje, expedienteSecuencia.entidad, expedienteSecuencia.ciclo,
            expedienteSecuencia.fase, expedienteSecuencia.expedienteSec, expedienteSecuencia.secuencia,
            expedienteSecuencia.correlativo, expedienteFase.fuenteFinanc, expediente.tipoOperacion,
            tipoOperacion.descriTipoOperacion, expedienteSecuencia.codigoDocumento, 
            expedienteSecuencia.numeroDocumento, expedienteSecuencia.fechaDocumento, 
            expedienteFase.certificado, expedienteFase.certificadoSecuencia,
            tipoTransaccion.codTipoTransaccion, generica.generica, subGenerica.subGenerica,
            subGenericaDet.subGenericaDet, especifica.especifica, especificaDet.especificaDet,
            expedienteMeta.secuenciaFuncional, tipoTransaccion.descripcionTipoTransaccon,
            generica.descriGenerica, subGenerica.descriSubGenerica, 
            subGenericaDet.descriSubGenericaDet, especifica.descriEspecifica, 
            especificaDet.descriClasificador, expedienteSecuencia.montoNacional.sum()
            ))
        .from(expedienteSecuencia).leftJoin(expedienteFase)
        .on(expedienteFase.anoEje.eq(expedienteSecuencia.anoEje)
            .and(expedienteFase.entidad.eq(expedienteSecuencia.entidad))
            .and(expedienteFase.expediente.eq(expedienteSecuencia.expedienteSec))
            .and(expedienteFase.ciclo.eq(expedienteSecuencia.ciclo))
            .and(expedienteFase.fase.eq(expedienteSecuencia.fase))
            .and(expedienteFase.secuencia.eq(expedienteSecuencia.secuencia))
            .and(expedienteFase.estado.eq(expedienteSecuencia.estado)))
        .leftJoin(expediente)
        .on(expediente.anoEje.eq(expedienteSecuencia.anoEje)
            .and(expediente.entidad.eq(expedienteSecuencia.entidad))
            .and(expediente.expediente.eq(expedienteSecuencia.expedienteSec)))
        .leftJoin(expedienteMeta)
        .on(expedienteMeta.anoEje.eq(expedienteSecuencia.anoEje)
            .and(expedienteMeta.entidad.eq(expedienteSecuencia.entidad))
            .and(expedienteMeta.expediente.eq(expedienteSecuencia.expedienteSec))
            .and(expedienteMeta.secuencia.eq(expedienteSecuencia.secuencia))
            .and(expedienteMeta.correlativo.eq(expedienteSecuencia.correlativo)))
        .leftJoin(tipoOperacion)
        .on(tipoOperacion.anoEje.eq(expedienteSecuencia.anoEje)
            .and(tipoOperacion.codTipoOperacion.eq(expediente.tipoOperacion)))
        .leftJoin(especificaDet)
        .on(especificaDet.anoEje.eq(expedienteMeta.anoEje)
            .and(especificaDet.idClasificador.eq(expedienteMeta.idClasificador)))
        .leftJoin(especifica)
        .on(especifica.anoEje.eq(especificaDet.anoEje)
            .and(especifica.tipoTransaccion.eq(especificaDet.tipoTransaccion))
            .and(especifica.generica.eq(especificaDet.generica))
            .and(especifica.subGenerica.eq(especificaDet.subGenerica))
            .and(especifica.subGenericaDet.eq(especificaDet.subGenericaDet))
            .and(especifica.especifica.eq(especificaDet.especifica))
            .and(especifica.estado.eq(especificaDet.estado)))
        .leftJoin(subGenericaDet)
        .on(subGenericaDet.anoEje.eq(especificaDet.anoEje)
            .and(subGenericaDet.tipoTransaccion.eq(especificaDet.tipoTransaccion))
            .and(subGenericaDet.generica.eq(especificaDet.generica))
            .and(subGenericaDet.subGenerica.eq(especificaDet.subGenerica))
            .and(subGenericaDet.subGenericaDet.eq(especificaDet.subGenericaDet))
            .and(subGenericaDet.estado.eq(especificaDet.estado)))
        .leftJoin(subGenerica)
        .on(subGenerica.anoEje.eq(especificaDet.anoEje)
            .and(subGenerica.tipoTransaccion.eq(especificaDet.tipoTransaccion))
            .and(subGenerica.generica.eq(especificaDet.generica))
            .and(subGenerica.subGenerica.eq(especificaDet.subGenerica))
            .and(subGenerica.estado.eq(especificaDet.estado)))
        .leftJoin(generica)
        .on(generica.anoEje.eq(especificaDet.anoEje)
            .and(generica.tipoTransaccion.eq(especificaDet.tipoTransaccion))
            .and(generica.generica.eq(especificaDet.generica))
            .and(generica.estado.eq(especificaDet.estado)))
        .leftJoin(tipoTransaccion)
        .on(tipoTransaccion.anoEje.eq(especificaDet.anoEje)
            .and(tipoTransaccion.codTipoTransaccion.eq(especificaDet.tipoTransaccion))
            .and(tipoTransaccion.estado.eq(especificaDet.estado)))
        .where(builder)
        .groupBy(expedienteSecuencia.anoEje, expedienteSecuencia.entidad, expedienteSecuencia.ciclo,
            expedienteSecuencia.fase, expedienteSecuencia.expedienteSec,
            expedienteSecuencia.secuencia, expedienteSecuencia.correlativo,
            expedienteFase.fuenteFinanc, expediente.tipoOperacion,
            tipoOperacion.descriTipoOperacion, expedienteSecuencia.codigoDocumento,
            expedienteSecuencia.numeroDocumento, expedienteSecuencia.fechaDocumento,
            expedienteFase.certificado, expedienteFase.certificadoSecuencia,
            tipoTransaccion.codTipoTransaccion, generica.generica, subGenerica.subGenerica,
            subGenericaDet.subGenericaDet, especifica.especifica, especificaDet.especificaDet,
            expedienteMeta.secuenciaFuncional, tipoTransaccion.descripcionTipoTransaccon,
            generica.descriGenerica, subGenerica.descriSubGenerica,
            subGenericaDet.descriSubGenericaDet, especifica.descriEspecifica,
            especificaDet.descriClasificador)
        .fetch();

  }

}
