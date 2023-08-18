package pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository;

import java.util.List;
import java.util.Objects;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QCodigoGeneralDetEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QEjecutoraEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QEspecificaDetEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QEspecificaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QExpedienteEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QExpedienteFaseEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QExpedienteMetaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QExpedienteSecuenciaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QFinalidadEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QFuenteFinancEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QGastoEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QGenericaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QMetaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QMonedaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QSolicitudRendicionCabEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QSolicitudRendicionClasifEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QSolicitudRendicionDestinoEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QSolicitudRendicionDetEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QSolicitudRendicionMetaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QSolicitudRendicionSecEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QSubGenericaDetEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QSubGenericaEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QTipoOperacionEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.QTipoTransaccionEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.entity.SolicitudRendicionCabEntity;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.ListaSolicitudesRendicionProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudReasignacionSecProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionDetalleClasificadoresProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionExpMetaOrigenProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionMarcoPresupuestoProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.projection.SolicitudRendicionDetalleProjection;
import pe.gob.mef.siaf.solicitudrendicion.view.query.ConsultarSolicitudesRendicionQuery;
import pe.gob.mef.siaf.solicitudrendicion.view.util.ViewConstantes;

public class SolicitudRendicionDslRepositoryImpl extends QuerydslRepositorySupport
    implements SolicitudRendicionDslRepository {

  public SolicitudRendicionDslRepositoryImpl() {
    super(SolicitudRendicionCabEntity.class);
  }

  @Override
  public Page<ListaSolicitudesRendicionProjection> listarSolicitudesRendicion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery, Pageable pageable) {
    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var solRendicionCab = QSolicitudRendicionCabEntity.solicitudRendicionCabEntity;
    var solRendicionDet = QSolicitudRendicionDetEntity.solicitudRendicionDetEntity;
    var solRendicionSec = QSolicitudRendicionSecEntity.solicitudRendicionSecEntity;
    var codigoGeneralDet = QCodigoGeneralDetEntity.codigoGeneralDetEntity;

    var builder = new BooleanBuilder();

    builder.and(solRendicionCab.anoEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(solRendicionCab.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));

    if (Objects.nonNull(consultarSolicitudesRendicionQuery.getExpediente())) {
      builder.and(solRendicionCab.secNota
          .like("%" + consultarSolicitudesRendicionQuery.getExpediente() + "%")
          .or(solRendicionDet.expediente
              .like("%" + consultarSolicitudesRendicionQuery.getExpediente() + "%")));
    } else {

      if (Objects.nonNull(consultarSolicitudesRendicionQuery.getMesEje())) {
        builder.and(solRendicionCab.mesEje.eq(consultarSolicitudesRendicionQuery.getMesEje()));
      }

      if (Objects.nonNull(consultarSolicitudesRendicionQuery.getTipoSolicitud())) {
        builder.and(solRendicionCab.tipoSolicitud
            .eq(consultarSolicitudesRendicionQuery.getTipoSolicitud()));
      }

      if (Objects.nonNull(consultarSolicitudesRendicionQuery.getEstadoRegistro())
          && !consultarSolicitudesRendicionQuery.getEstadoRegistro().isEmpty()) {
        builder.and(solRendicionCab.estadoRegistro
            .eq(consultarSolicitudesRendicionQuery.getEstadoRegistro()));
      }

      if (Objects.nonNull(consultarSolicitudesRendicionQuery.getFuenteFinanciamiento())
          && !consultarSolicitudesRendicionQuery.getFuenteFinanciamiento().isEmpty()) {
        builder.and(solRendicionDet.fuenteFinanciamiento
            .eq(consultarSolicitudesRendicionQuery.getFuenteFinanciamiento()));
      }

    }

    var query = queryDsl.createQuery()
        .select(Projections.constructor(ListaSolicitudesRendicionProjection.class,
            solRendicionCab.anoEje, solRendicionCab.entidad, solRendicionCab.mesEje,
            solRendicionCab.secNota, solRendicionDet.expediente, solRendicionCab.estadoRegistro,
            codigoGeneralDet.descripcion))
        .from(solRendicionCab).innerJoin(solRendicionSec)
        .on(solRendicionSec.anioEje.eq(solRendicionCab.anoEje)
            .and(solRendicionSec.entidad.eq(solRendicionCab.entidad))
            .and(solRendicionSec.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
        .innerJoin(solRendicionDet)
        .on(solRendicionDet.anioEje.eq(solRendicionCab.anoEje)
            .and(solRendicionDet.entidad.eq(solRendicionCab.entidad))
            .and(solRendicionDet.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
        .innerJoin(codigoGeneralDet)
        .on(codigoGeneralDet.codigoDet.eq(solRendicionCab.estadoRegistro)
            .and(codigoGeneralDet.codigo.eq(ViewConstantes.CODIGO_ESTADO_REGISTRO)))
        .where(builder);

    var res = queryDsl.applyPagination(pageable, query);
    return new PageImpl<>(res.fetch(), pageable, query.fetchCount());

  }

  @Override
  public SolicitudRendicionDetalleProjection obtenerSolicitudRendicion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var solRendicionCab = QSolicitudRendicionCabEntity.solicitudRendicionCabEntity;
    var solRendicionDet = QSolicitudRendicionDetEntity.solicitudRendicionDetEntity;
    var solRendicionSec = QSolicitudRendicionSecEntity.solicitudRendicionSecEntity;
    // var solRendicionClasif = QSolicitudRendicionClasifEntity.solicitudRendicionClasifEntity;
    // var solRendicionMeta = QSolicitudRendicionMetaEntity.solicitudRendicionMetaEntity;
    // var solRendicionDestino = QSolicitudRendicionDestinoEntity.solicitudRendicionDestinoEntity;
    var fuenteFinanc = QFuenteFinancEntity.fuenteFinancEntity;
    /*
    var especificaDet1 = new QEspecificaDetEntity("especificaDetOrigen");
    var especificaDet2 = new QEspecificaDetEntity("especificaDetDestino");
    var meta1 = new QMetaEntity("metaOrigen");
    var meta2 = new QMetaEntity("metaDestino");
    var finalidad1 = new QFinalidadEntity("finalidadOrigen");
    var finalidad2 = new QFinalidadEntity("finalidadDestino");
    */
    var tipoOperacion = QTipoOperacionEntity.tipoOperacionEntity;
    var ejecutora = QEjecutoraEntity.ejecutoraEntity;
    var moneda = QMonedaEntity.monedaEntity;
    var codigoGeneralDet1 = new QCodigoGeneralDetEntity(ViewConstantes.CODIGO_ESTADO_REGISTRO);
    var codigoGeneralDet2 = new QCodigoGeneralDetEntity(ViewConstantes.CODIGO_TIPO_RENDICION);
    var codigoGeneralDet3 = new QCodigoGeneralDetEntity(ViewConstantes.CODIGO_ESTADO_ENVIO);

    var builder = new BooleanBuilder();

    builder.and(solRendicionCab.anoEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(solRendicionCab.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));
    builder.and(solRendicionCab.secNota.eq(consultarSolicitudesRendicionQuery.getSecuenciaNota()));

    return queryDsl.createQuery()
        .select(Projections.constructor(SolicitudRendicionDetalleProjection.class,
            solRendicionCab.anoEje, solRendicionCab.entidad, solRendicionCab.mesEje,
            solRendicionCab.secNota, solRendicionCab.secuenciaSolicitud,
            solRendicionCab.tipoRendicion, codigoGeneralDet2.descripcion,
            solRendicionSec.codigoDocumento, solRendicionSec.numeroDocumento,
            solRendicionSec.fechaDocumento, solRendicionCab.estadoRegistro,
            codigoGeneralDet1.descripcion, solRendicionCab.estadoEnvio,
            codigoGeneralDet3.descripcion, solRendicionCab.codTipoOperacion,
            tipoOperacion.descriTipoOperacion, solRendicionDet.codTipoDocIdentidad,
            solRendicionDet.ruc, solRendicionDet.entidadReciproca, ejecutora.nombreEjecutora,
            solRendicionDet.expediente, solRendicionDet.ciclo, solRendicionDet.fase,
            solRendicionDet.secuencia, solRendicionDet.certificado,
            solRendicionDet.certificadoSecuencia, solRendicionDet.moneda, moneda.nombre,
            solRendicionDet.tipoCambio, solRendicionDet.montoNacional,
            solRendicionDet.fuenteFinanciamiento, fuenteFinanc.nombre,
            solRendicionCab.tipoSolicitud, solRendicionCab.indicadorCertificacion,
            solRendicionCab.tipoRendicion))
        .from(solRendicionCab).innerJoin(solRendicionSec)
        .on(solRendicionSec.anioEje.eq(solRendicionCab.anoEje)
            .and(solRendicionSec.entidad.eq(solRendicionCab.entidad))
            .and(solRendicionSec.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
        .innerJoin(solRendicionDet)
        .on(solRendicionDet.anioEje.eq(solRendicionCab.anoEje)
            .and(solRendicionDet.entidad.eq(solRendicionCab.entidad))
            .and(solRendicionDet.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
        /*
        .innerJoin(solRendicionClasif)
        .on(solRendicionClasif.anoEje.eq(solRendicionDet.anioEje)
            .and(solRendicionClasif.entidad.eq(solRendicionDet.entidad))
            .and(solRendicionClasif.secuenciaSolicitud.eq(solRendicionDet.secuenciaSolicitud))
            .and(solRendicionClasif.secuenciaPorExpediente
                .eq(solRendicionDet.secuenciaPorExpediente)))
        .innerJoin(solRendicionMeta)
        .on(solRendicionMeta.anoEje.eq(solRendicionClasif.anoEje)
            .and(solRendicionMeta.entidad.eq(solRendicionClasif.entidad))
            .and(solRendicionMeta.secuenciaSolicitud.eq(solRendicionClasif.secuenciaSolicitud))
            .and(solRendicionMeta.secuenciaPorExpediente
                .eq(solRendicionClasif.secuenciaPorExpediente))
            .and(solRendicionMeta.idClasificador.eq(solRendicionClasif.idClasificador)))
        .innerJoin(solRendicionDestino)
        .on(solRendicionDestino.anoEje.eq(solRendicionMeta.anoEje)
            .and(solRendicionDestino.entidad.eq(solRendicionMeta.entidad))
            .and(solRendicionDestino.secuenciaSolicitud.eq(solRendicionMeta.secuenciaSolicitud))
            .and(solRendicionDestino.secuenciaPorExpediente
                .eq(solRendicionMeta.secuenciaPorExpediente))
            .and(solRendicionDestino.idClasificador.eq(solRendicionMeta.idClasificador)))
        */
        .leftJoin(fuenteFinanc)
        .on(fuenteFinanc.anoEje.eq(solRendicionDet.anioEje)
            .and(fuenteFinanc.origen.eq(ViewConstantes.CODIGO_TIPO_ORIGEN))
            .and(fuenteFinanc.fuenteFinanc.eq(solRendicionDet.fuenteFinanciamiento)))
        .leftJoin(codigoGeneralDet1)
        .on(codigoGeneralDet1.codigoDet.eq(solRendicionCab.estadoRegistro)
            .and(codigoGeneralDet1.codigo.eq(ViewConstantes.CODIGO_ESTADO_REGISTRO)))
        .leftJoin(codigoGeneralDet2)
        .on(codigoGeneralDet2.codigoDet.castToNum(Integer.class).eq(solRendicionCab.tipoRendicion)
            .and(codigoGeneralDet2.codigo.eq(ViewConstantes.CODIGO_TIPO_RENDICION)))
        .leftJoin(codigoGeneralDet3)
        .on(codigoGeneralDet3.codigoDet.eq(solRendicionCab.estadoEnvio)
            .and(codigoGeneralDet3.codigo.eq(ViewConstantes.CODIGO_ESTADO_ENVIO)))
        .leftJoin(moneda)
        .on(moneda.moneda.eq(solRendicionDet.moneda))

        /*
        .leftJoin(especificaDet1)
        .on(especificaDet1.anoEje.eq(solRendicionClasif.anoEje)
            .and(especificaDet1.idClasificador.eq(solRendicionClasif.idClasificador)))
        .leftJoin(meta1)
        .on(meta1.anoEje.eq(solRendicionMeta.anoEje).and(meta1.entidad.eq(solRendicionMeta.entidad))
            .and(meta1.secuenciaFuncional.eq(solRendicionMeta.secuenciaFuncional)))
        .leftJoin(finalidad1)
        .on(finalidad1.anioEje.eq(meta1.anoEje).and(finalidad1.codFinalidad.eq(meta1.codFinalidad)))
        .leftJoin(especificaDet2)
        .on(especificaDet2.anoEje.eq(solRendicionDestino.anoEje)
            .and(especificaDet2.idClasificador.eq(solRendicionDestino.idClasificador)))
        .leftJoin(meta2)
        .on(meta2.anoEje.eq(solRendicionDestino.anoEje)
            .and(meta2.entidad.eq(solRendicionDestino.entidad))
            .and(meta2.secuenciaFuncional.eq(solRendicionDestino.secuenciaFuncional)))
        .leftJoin(finalidad2)
        .on(finalidad2.anioEje.eq(meta2.anoEje).and(finalidad2.codFinalidad.eq(meta2.codFinalidad)))
        */
        .leftJoin(tipoOperacion)
        .on(tipoOperacion.anoEje.eq(solRendicionDet.anioEje)
            .and(tipoOperacion.codTipoOperacion.eq(solRendicionCab.codTipoOperacion)))
        .leftJoin(ejecutora).on(ejecutora.anoEje.eq(solRendicionDet.anioEje)
            .and(ejecutora.entidad.eq(solRendicionDet.entidadReciproca)))
        .where(builder).fetchOne();
  }

  @Override
  public List<SolicitudRendicionExpMetaOrigenProjection> obtenerSolicitudRendicionExpMetaOrigen(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {

    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var expedienteSecuencia = QExpedienteSecuenciaEntity.expedienteSecuenciaEntity;
    var expedienteFase = QExpedienteFaseEntity.expedienteFaseEntity;
    var expedienteEnt = QExpedienteEntity.expedienteEntity;
    var expedienteMeta = QExpedienteMetaEntity.expedienteMetaEntity;
    var especificaDet = QEspecificaDetEntity.especificaDetEntity;
    var especifica = QEspecificaEntity.especificaEntity;
    var subGenericaDet = QSubGenericaDetEntity.subGenericaDetEntity;
    var subGenerica = QSubGenericaEntity.subGenericaEntity;
    var generica = QGenericaEntity.genericaEntity;
    var tipoTransaccion = QTipoTransaccionEntity.tipoTransaccionEntity;

    var builder = new BooleanBuilder();

    builder.and(expedienteSecuencia.anoEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(expedienteSecuencia.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));
    builder.and(
        expedienteSecuencia.expedienteSec.eq(consultarSolicitudesRendicionQuery.getExpediente()));
    builder.and(expedienteSecuencia.ciclo.eq(consultarSolicitudesRendicionQuery.getCiclo()));
    builder.and(expedienteSecuencia.fase.eq(consultarSolicitudesRendicionQuery.getFase()));
    builder.and(
        expedienteEnt.tipoOperacion.in(Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_A),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_AV),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_E),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_F),
            Expressions.constant(ViewConstantes.CODIGO_TIPO_OPERACION_C)));

    return queryDsl.createQuery()
        .select(Projections.constructor(SolicitudRendicionExpMetaOrigenProjection.class,
            tipoTransaccion.codTipoTransaccion, generica.generica, subGenerica.subGenerica,
            subGenericaDet.subGenericaDet, especifica.especifica, especificaDet.especificaDet,
            expedienteMeta.secuenciaFuncional, expedienteMeta.montoNacional.sum(),
            tipoTransaccion.descripcionTipoTransaccon, generica.descriGenerica,
            subGenerica.descriSubGenerica, subGenericaDet.descriSubGenericaDet,
            especifica.descriEspecifica, especificaDet.descriClasificador))
        .from(expedienteSecuencia).leftJoin(expedienteFase)
        .on(expedienteFase.anoEje.eq(expedienteSecuencia.anoEje)
            .and(expedienteFase.entidad.eq(expedienteSecuencia.entidad))
            .and(expedienteFase.expediente.eq(expedienteSecuencia.expedienteSec))
            .and(expedienteFase.ciclo.eq(expedienteSecuencia.ciclo))
            .and(expedienteFase.fase.eq(expedienteSecuencia.fase))
            .and(expedienteFase.secuencia.eq(expedienteSecuencia.secuencia))
            .and(expedienteFase.estado.eq(expedienteSecuencia.estado)))
        .leftJoin(expedienteEnt)
        .on(expedienteEnt.anoEje.eq(expedienteSecuencia.anoEje)
            .and(expedienteEnt.entidad.eq(expedienteSecuencia.entidad))
            .and(expedienteEnt.expediente.eq(expedienteSecuencia.expedienteSec)))
        .leftJoin(expedienteMeta)
        .on(expedienteMeta.anoEje.eq(expedienteSecuencia.anoEje)
            .and(expedienteMeta.entidad.eq(expedienteSecuencia.entidad))
            .and(expedienteMeta.expediente.eq(expedienteSecuencia.expedienteSec))
            .and(expedienteMeta.secuencia.eq(expedienteSecuencia.secuencia))
            .and(expedienteMeta.correlativo.eq(expedienteSecuencia.correlativo)))
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
        .groupBy(tipoTransaccion.codTipoTransaccion, generica.generica, subGenerica.subGenerica,
            subGenericaDet.subGenericaDet, especifica.especifica, especificaDet.especificaDet,
            expedienteMeta.secuenciaFuncional, tipoTransaccion.descripcionTipoTransaccon,
            generica.descriGenerica, subGenerica.descriSubGenerica,
            subGenericaDet.descriSubGenericaDet, especifica.descriEspecifica,
            especificaDet.descriClasificador)
        .fetch();

  }

  @Override
  public Page<SolicitudRendicionMarcoPresupuestoProjection> obtenerSolicitudRendicionMarcoPresupuesto(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery, Pageable pageable) {

    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var gasto = QGastoEntity.gastoEntity;
    var especificaDet = QEspecificaDetEntity.especificaDetEntity;

    var builder = new BooleanBuilder();

    builder.and(gasto.anoEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(gasto.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));

    var query = queryDsl.createQuery()
        .select(Projections.constructor(SolicitudRendicionMarcoPresupuestoProjection.class,
            gasto.anoEje, gasto.secuenciaFuncional, especificaDet.tipoTransaccion,
            especificaDet.generica, especificaDet.subGenerica, especificaDet.subGenericaDet,
            especificaDet.especifica, especificaDet.especificaDet,
            gasto.presupuesto.add(gasto.modificacion).subtract(gasto.comprometido).sum()))
        .from(gasto).leftJoin(especificaDet)
        .on(especificaDet.anoEje.eq(gasto.anoEje)
            .and(especificaDet.idClasificador.eq(gasto.idClasificador)))
        .where(builder).groupBy(gasto.anoEje, gasto.secuenciaFuncional,
            especificaDet.tipoTransaccion, especificaDet.generica, especificaDet.subGenerica,
            especificaDet.subGenericaDet, especificaDet.especifica, especificaDet.especificaDet);
    // .orderBy()

    var res = queryDsl.applyPagination(pageable, query);
    return new PageImpl<>(res.fetch(), pageable, query.fetchCount());

  }

  @Override
  public Page<SolicitudReasignacionProjection> listarSolicitudesReasignacion(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery, Pageable pageable) {

    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var solRendicionCab = QSolicitudRendicionCabEntity.solicitudRendicionCabEntity;
    var solRendicionDet = QSolicitudRendicionDetEntity.solicitudRendicionDetEntity;
    var solRendicionSec = QSolicitudRendicionSecEntity.solicitudRendicionSecEntity;
    var codigoGeneralDet = new QCodigoGeneralDetEntity("ESTADO_REGISTRO_WEB");

    var builder = new BooleanBuilder();

    builder.and(solRendicionCab.anoEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(solRendicionCab.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));

    if (Objects.nonNull(consultarSolicitudesRendicionQuery.getExpediente())) {
      builder.and(solRendicionCab.secNota
          .like("%" + consultarSolicitudesRendicionQuery.getExpediente() + "%")
          .or(solRendicionDet.expediente
              .like("%" + consultarSolicitudesRendicionQuery.getExpediente() + "%")));
    } else {

      if (Objects.nonNull(consultarSolicitudesRendicionQuery.getMesEje())) {
        builder.and(solRendicionCab.mesEje.eq(consultarSolicitudesRendicionQuery.getMesEje()));
      }

      if (Objects.nonNull(consultarSolicitudesRendicionQuery.getTipoSolicitud())) {
        builder.and(solRendicionCab.tipoSolicitud
            .eq(consultarSolicitudesRendicionQuery.getTipoSolicitud()));
      }

      if (Objects.nonNull(consultarSolicitudesRendicionQuery.getEstadoRegistro())
          && !consultarSolicitudesRendicionQuery.getEstadoRegistro().isEmpty()) {
        builder.and(solRendicionCab.estadoRegistro
            .eq(consultarSolicitudesRendicionQuery.getEstadoRegistro()));
      }

      if (Objects.nonNull(consultarSolicitudesRendicionQuery.getFuenteFinanciamiento())
          && !consultarSolicitudesRendicionQuery.getFuenteFinanciamiento().isEmpty()) {
        builder.and(solRendicionDet.fuenteFinanciamiento
            .eq(consultarSolicitudesRendicionQuery.getFuenteFinanciamiento()));
      }

    }

    var query =
        queryDsl.createQuery()
            .select(Projections.constructor(SolicitudReasignacionProjection.class,
                solRendicionCab.anoEje, solRendicionCab.entidad, solRendicionCab.secNota,
                solRendicionDet.expediente, solRendicionCab.estadoRegistro,
                codigoGeneralDet.descripcion))
            .from(solRendicionCab).innerJoin(solRendicionSec)
            .on(solRendicionSec.anioEje.eq(solRendicionCab.anoEje)
                .and(solRendicionSec.entidad.eq(solRendicionCab.entidad))
                .and(solRendicionSec.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
            .innerJoin(solRendicionDet)
            .on(solRendicionDet.anioEje.eq(solRendicionCab.anoEje)
                .and(solRendicionDet.entidad.eq(solRendicionCab.entidad))
                .and(solRendicionDet.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
            .leftJoin(codigoGeneralDet)
            .on(codigoGeneralDet.codigoDet.castToNum(Integer.class)
                .eq(solRendicionCab.tipoRendicion)
                .and(codigoGeneralDet.codigo.eq(ViewConstantes.CODIGO_ESTADO_REGISTRO)))
            .where(builder);

    var res = queryDsl.applyPagination(pageable, query);
    return new PageImpl<>(res.fetch(), pageable, query.fetchCount());

  }

  @Override
  public List<SolicitudReasignacionDetalleProjection> obtenerSolicitudReasignacionDetalle(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var solRendicionCab = QSolicitudRendicionCabEntity.solicitudRendicionCabEntity;
    var solRendicionSec = QSolicitudRendicionSecEntity.solicitudRendicionSecEntity;
    var solRendicionDet = QSolicitudRendicionDetEntity.solicitudRendicionDetEntity;
    var solRendicionClasif = QSolicitudRendicionClasifEntity.solicitudRendicionClasifEntity;
    var solRendicionMeta = QSolicitudRendicionMetaEntity.solicitudRendicionMetaEntity;
    var solRendicionDestino = QSolicitudRendicionDestinoEntity.solicitudRendicionDestinoEntity;
    var fuenteFinanc = QFuenteFinancEntity.fuenteFinancEntity;
    var codigoGeneralDet1 = new QCodigoGeneralDetEntity(ViewConstantes.CODIGO_ESTADO_REGISTRO);
    // var codigoGeneralDet2 = new QCodigoGeneralDetEntity(ViewConstantes.CODIGO_TIPO_RENDICION);
    var especificaDet1 = new QEspecificaDetEntity("especificaDetOrigen");
    var especificaDet2 = new QEspecificaDetEntity("especificaDetDestino");
    var meta1 = new QMetaEntity("metaOrigen");
    var meta2 = new QMetaEntity("metaDestino");
    var finalidad1 = new QFinalidadEntity("finalidadOrigen");
    var finalidad2 = new QFinalidadEntity("finalidadDestino");
    var tipoOperacion = QTipoOperacionEntity.tipoOperacionEntity;
    var ejecutora = QEjecutoraEntity.ejecutoraEntity;

    var builder = new BooleanBuilder();

    builder.and(solRendicionCab.anoEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(solRendicionCab.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));
    builder.and(solRendicionCab.tipoSolicitud.eq(ViewConstantes.CODIGO_TIPO_SOLICITUD_RENDICION));
    builder.and(solRendicionCab.secNota.eq(consultarSolicitudesRendicionQuery.getSecuenciaNota()));

    return queryDsl.createQuery()
        .select(Projections.constructor(SolicitudReasignacionDetalleProjection.class,
            solRendicionCab.anoEje, solRendicionCab.mesEje, solRendicionCab.entidad,
            solRendicionCab.secNota, solRendicionCab.secuenciaSolicitud,
            solRendicionSec.codigoDocumento, solRendicionSec.numeroDocumento,
            solRendicionSec.fechaDocumento, solRendicionCab.estadoRegistro,
            codigoGeneralDet1.descripcion, solRendicionCab.codTipoOperacion,
            tipoOperacion.descriTipoOperacion, solRendicionDet.codTipoDocIdentidad,
            solRendicionDet.ruc, solRendicionDet.entidadReciproca, ejecutora.nombreEjecutora,
            solRendicionDet.expediente, solRendicionDet.ciclo, solRendicionDet.fase,
            solRendicionDet.secuencia, solRendicionDet.certificado,
            solRendicionDet.certificadoSecuencia, solRendicionDet.moneda,
            solRendicionDet.tipoCambio, solRendicionDet.montoNacional,
            solRendicionDet.fuenteFinanciamiento, fuenteFinanc.nombre,
            especificaDet1.tipoTransaccion, especificaDet1.generica, especificaDet1.subGenerica,
            especificaDet1.subGenericaDet, especificaDet1.especifica, especificaDet1.especificaDet,
            especificaDet1.descriClasificador, solRendicionMeta.secuenciaFuncional,
            finalidad1.descriFinalidad, solRendicionMeta.montoNacional,
            especificaDet2.tipoTransaccion, especificaDet2.generica, especificaDet2.subGenerica,
            especificaDet2.subGenericaDet, especificaDet2.especifica, especificaDet2.especificaDet,
            especificaDet2.descriClasificador, solRendicionDestino.secuenciaFuncionalDestino,
            finalidad2.descriFinalidad, solRendicionDestino.montoNacional,
            solRendicionCab.tipoSolicitud, solRendicionCab.indicadorCertificacion,
            solRendicionCab.tipoRendicion
            ))
        .from(solRendicionCab).leftJoin(solRendicionSec)
        .on(solRendicionSec.anioEje.eq(solRendicionCab.anoEje)
            .and(solRendicionSec.entidad.eq(solRendicionCab.entidad))
            .and(solRendicionSec.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
        .leftJoin(solRendicionDet)
        .on(solRendicionDet.anioEje.eq(solRendicionCab.anoEje)
            .and(solRendicionDet.entidad.eq(solRendicionCab.entidad))
            .and(solRendicionDet.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
        .leftJoin(solRendicionClasif)
        .on(solRendicionClasif.anoEje.eq(solRendicionDet.anioEje)
            .and(solRendicionClasif.entidad.eq(solRendicionDet.entidad))
            .and(solRendicionClasif.secuenciaSolicitud.eq(solRendicionDet.secuenciaSolicitud))
            .and(solRendicionClasif.secuenciaPorExpediente
                .eq(solRendicionDet.secuenciaPorExpediente)))
        .leftJoin(solRendicionMeta)
        .on(solRendicionMeta.anoEje.eq(solRendicionClasif.anoEje)
            .and(solRendicionMeta.entidad.eq(solRendicionClasif.entidad))
            .and(solRendicionMeta.secuenciaSolicitud.eq(solRendicionClasif.secuenciaSolicitud))
            .and(solRendicionMeta.secuenciaPorExpediente
                .eq(solRendicionClasif.secuenciaPorExpediente))
            .and(solRendicionMeta.idClasificador.eq(solRendicionClasif.idClasificador)))
        .leftJoin(solRendicionDestino)
        .on(solRendicionDestino.anoEje.eq(solRendicionMeta.anoEje)
            .and(solRendicionDestino.entidad.eq(solRendicionMeta.entidad))
            .and(solRendicionDestino.secuenciaSolicitud.eq(solRendicionMeta.secuenciaSolicitud))
            .and(solRendicionDestino.secuenciaPorExpediente
                .eq(solRendicionMeta.secuenciaPorExpediente))
            .and(solRendicionDestino.idClasificador.eq(solRendicionMeta.idClasificador)))
        .leftJoin(fuenteFinanc)
        .on(fuenteFinanc.anoEje.eq(solRendicionDet.anioEje)
            .and(fuenteFinanc.origen.eq(ViewConstantes.CODIGO_TIPO_ORIGEN))
            .and(fuenteFinanc.fuenteFinanc.eq(solRendicionDet.fuenteFinanciamiento)))
        .leftJoin(codigoGeneralDet1)
        .on(codigoGeneralDet1.codigoDet.eq(solRendicionCab.estadoRegistro)
            .and(codigoGeneralDet1.codigo.eq(ViewConstantes.CODIGO_ESTADO_REGISTRO)))
        /*
         * .leftJoin(codigoGeneralDet2)
         * .on(codigoGeneralDet2.codigoDet.castToNum(Integer.class).eq(solRendicionCab.
         * tipoRendicion) .and(codigoGeneralDet2.codigo.eq(ViewConstantes.CODIGO_TIPO_RENDICION)))
         */
        .leftJoin(especificaDet1)
        .on(especificaDet1.anoEje.eq(solRendicionClasif.anoEje)
            .and(especificaDet1.idClasificador.eq(solRendicionClasif.idClasificador)))
        .leftJoin(meta1)
        .on(meta1.anoEje.eq(solRendicionMeta.anoEje).and(meta1.entidad.eq(solRendicionMeta.entidad))
            .and(meta1.secuenciaFuncional.eq(solRendicionMeta.secuenciaFuncional)))
        .leftJoin(finalidad1)
        .on(finalidad1.anioEje.eq(meta1.anoEje).and(finalidad1.codFinalidad.eq(meta1.codFinalidad)))
        .leftJoin(especificaDet2)
        .on(especificaDet2.anoEje.eq(solRendicionDestino.anoEje)
            .and(especificaDet2.idClasificador.eq(solRendicionDestino.idClasificador)))
        .leftJoin(meta2)
        .on(meta2.anoEje.eq(solRendicionDestino.anoEje)
            .and(meta2.entidad.eq(solRendicionDestino.entidad))
            .and(meta2.secuenciaFuncional.eq(solRendicionDestino.secuenciaFuncional)))
        .leftJoin(finalidad2)
        .on(finalidad2.anioEje.eq(meta2.anoEje).and(finalidad2.codFinalidad.eq(meta2.codFinalidad)))
        .leftJoin(tipoOperacion)
        .on(tipoOperacion.anoEje.eq(solRendicionDet.anioEje)
            .and(tipoOperacion.codTipoOperacion.eq(solRendicionCab.codTipoOperacion)))
        .leftJoin(ejecutora).on(ejecutora.anoEje.eq(solRendicionDet.anioEje)
            .and(ejecutora.entidad.eq(solRendicionDet.entidadReciproca)))
        .where(builder).fetch();

  }

  @Override
  public List<SolicitudReasignacionSecProjection> listarSolicitudesReasignacionSec(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var solRendicionSec = QSolicitudRendicionSecEntity.solicitudRendicionSecEntity;
    var builder = new BooleanBuilder();

    builder.and(solRendicionSec.anioEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(solRendicionSec.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));
    builder.and(solRendicionSec.secuenciaSolicitud
        .eq(consultarSolicitudesRendicionQuery.getSecuenciaSolicitud()));

    return queryDsl.createQuery()
        .select(Projections.constructor(SolicitudReasignacionSecProjection.class,
            solRendicionSec.anioEje, solRendicionSec.entidad, solRendicionSec.secuenciaSolicitud,
            solRendicionSec.correlativoSolicitud, solRendicionSec.tipoRegistro,
            solRendicionSec.codigoDocumento, solRendicionSec.numeroDocumento,
            solRendicionSec.fechaDocumento, solRendicionSec.fechaRegistro,
            solRendicionSec.fechaProceso, solRendicionSec.estadoRegistro,
            solRendicionSec.estadoEnvio))
        .from(solRendicionSec).where(builder).fetch();


  }

  @Override
  public List<SolicitudRendicionDetalleClasificadoresProjection> obtenerSolicitudRendicionDetalleClasifOrigen(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var solRendicionCab = QSolicitudRendicionCabEntity.solicitudRendicionCabEntity;
    var solRendicionDet = QSolicitudRendicionDetEntity.solicitudRendicionDetEntity;
    var solRendicionSec = QSolicitudRendicionSecEntity.solicitudRendicionSecEntity;
    var solRendicionClasif = QSolicitudRendicionClasifEntity.solicitudRendicionClasifEntity;
    var solRendicionMeta = QSolicitudRendicionMetaEntity.solicitudRendicionMetaEntity;
    // var solRendicionDestino = QSolicitudRendicionDestinoEntity.solicitudRendicionDestinoEntity;
    // var fuenteFinanc = QFuenteFinancEntity.fuenteFinancEntity;
    var especificaDet1 = new QEspecificaDetEntity("especificaDetOrigen");
    // var especificaDet2 = new QEspecificaDetEntity("especificaDetDestino");
    var meta1 = new QMetaEntity("metaOrigen");
    // var meta2 = new QMetaEntity("metaDestino");
    var finalidad1 = new QFinalidadEntity("finalidadOrigen");
    // var finalidad2 = new QFinalidadEntity("finalidadDestino");
    // var tipoOperacion = QTipoOperacionEntity.tipoOperacionEntity;
    // var ejecutora = QEjecutoraEntity.ejecutoraEntity;
    // var codigoGeneralDet1 = new QCodigoGeneralDetEntity(ViewConstantes.CODIGO_ESTADO_REGISTRO);
    // var codigoGeneralDet2 = new QCodigoGeneralDetEntity(ViewConstantes.CODIGO_TIPO_RENDICION);
    var tipoTransaccion = QTipoTransaccionEntity.tipoTransaccionEntity;
    var generica = QGenericaEntity.genericaEntity;
    var subGenerica = QSubGenericaEntity.subGenericaEntity;
    var subGenericaDet = QSubGenericaDetEntity.subGenericaDetEntity;
    var especifica = QEspecificaEntity.especificaEntity;

    var builder = new BooleanBuilder();

    builder.and(solRendicionCab.anoEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(solRendicionCab.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));
    builder.and(solRendicionCab.secNota.eq(consultarSolicitudesRendicionQuery.getSecuenciaNota()));

    return queryDsl.createQuery()
        .select(Projections.constructor(SolicitudRendicionDetalleClasificadoresProjection.class, 
            especificaDet1.tipoTransaccion, tipoTransaccion.descripcionTipoTransaccon,
            especificaDet1.generica, generica.descriGenerica,
            especificaDet1.subGenerica, subGenerica.descriSubGenerica,
            especificaDet1.subGenericaDet, subGenericaDet.descriSubGenericaDet,
            especificaDet1.especifica, especifica.descriEspecifica,
            especificaDet1.especificaDet, especificaDet1.descriClasificador, 
            solRendicionMeta.secuenciaFuncional, finalidad1.descriFinalidad, 
            solRendicionMeta.montoNacional))
        .from(solRendicionCab).innerJoin(solRendicionSec)
        .on(solRendicionSec.anioEje.eq(solRendicionCab.anoEje)
            .and(solRendicionSec.entidad.eq(solRendicionCab.entidad))
            .and(solRendicionSec.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
        .innerJoin(solRendicionDet)
        .on(solRendicionDet.anioEje.eq(solRendicionCab.anoEje)
            .and(solRendicionDet.entidad.eq(solRendicionCab.entidad))
            .and(solRendicionDet.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
        .innerJoin(solRendicionClasif)
        .on(solRendicionClasif.anoEje.eq(solRendicionDet.anioEje)
            .and(solRendicionClasif.entidad.eq(solRendicionDet.entidad))
            .and(solRendicionClasif.secuenciaSolicitud.eq(solRendicionDet.secuenciaSolicitud))
            .and(solRendicionClasif.secuenciaPorExpediente
                .eq(solRendicionDet.secuenciaPorExpediente)))
        .innerJoin(solRendicionMeta)
        .on(solRendicionMeta.anoEje.eq(solRendicionClasif.anoEje)
            .and(solRendicionMeta.entidad.eq(solRendicionClasif.entidad))
            .and(solRendicionMeta.secuenciaSolicitud.eq(solRendicionClasif.secuenciaSolicitud))
            .and(solRendicionMeta.secuenciaPorExpediente
                .eq(solRendicionClasif.secuenciaPorExpediente))
            .and(solRendicionMeta.idClasificador.eq(solRendicionClasif.idClasificador)))
        /*
        .innerJoin(solRendicionDestino)
        .on(solRendicionDestino.anoEje.eq(solRendicionMeta.anoEje)
            .and(solRendicionDestino.entidad.eq(solRendicionMeta.entidad))
            .and(solRendicionDestino.secuenciaSolicitud.eq(solRendicionMeta.secuenciaSolicitud))
            .and(solRendicionDestino.secuenciaPorExpediente
                .eq(solRendicionMeta.secuenciaPorExpediente))
            .and(solRendicionDestino.idClasificador.eq(solRendicionMeta.idClasificador)))
        .leftJoin(fuenteFinanc)
        .on(fuenteFinanc.anoEje.eq(solRendicionDet.anioEje)
            .and(fuenteFinanc.origen.eq(ViewConstantes.CODIGO_TIPO_ORIGEN))
            .and(fuenteFinanc.fuenteFinanc.eq(solRendicionDet.fuenteFinanciamiento)))
        .leftJoin(codigoGeneralDet1)
        .on(codigoGeneralDet1.codigoDet.eq(solRendicionCab.estadoRegistro)
            .and(codigoGeneralDet1.codigo.eq(ViewConstantes.CODIGO_ESTADO_REGISTRO)))
        .leftJoin(codigoGeneralDet2)
        .on(codigoGeneralDet2.codigoDet.castToNum(Integer.class).eq(solRendicionCab.tipoRendicion)
            .and(codigoGeneralDet2.codigo.eq(ViewConstantes.CODIGO_TIPO_RENDICION)))
        */
        .leftJoin(especificaDet1)
        .on(especificaDet1.anoEje.eq(solRendicionClasif.anoEje)
            .and(especificaDet1.idClasificador.eq(solRendicionClasif.idClasificador)))
        .leftJoin(meta1)
        .on(meta1.anoEje.eq(solRendicionMeta.anoEje).and(meta1.entidad.eq(solRendicionMeta.entidad))
            .and(meta1.secuenciaFuncional.eq(solRendicionMeta.secuenciaFuncional)))
        .leftJoin(finalidad1)
        .on(finalidad1.anioEje.eq(meta1.anoEje).and(finalidad1.codFinalidad.eq(meta1.codFinalidad)))
        .leftJoin(tipoTransaccion)
        .on(tipoTransaccion.anoEje.eq(especificaDet1.anoEje)
            .and(tipoTransaccion.codTipoTransaccion.eq(especificaDet1.tipoTransaccion)))
        .leftJoin(generica)
        .on(generica.anoEje.eq(especificaDet1.anoEje)
            .and(generica.tipoTransaccion.eq(especificaDet1.tipoTransaccion))
            .and(generica.generica.eq(especificaDet1.generica)))
        .leftJoin(subGenerica)
        .on(subGenerica.anoEje.eq(especificaDet1.anoEje)
            .and(subGenerica.tipoTransaccion.eq(especificaDet1.tipoTransaccion))
            .and(subGenerica.generica.eq(especificaDet1.generica))
            .and(subGenerica.subGenerica.eq(especificaDet1.subGenerica)))
        .leftJoin(subGenericaDet)
        .on(subGenericaDet.anoEje.eq(especificaDet1.anoEje)
            .and(subGenericaDet.tipoTransaccion.eq(especificaDet1.tipoTransaccion))
            .and(subGenericaDet.generica.eq(especificaDet1.generica))
            .and(subGenericaDet.subGenerica.eq(especificaDet1.subGenerica))
            .and(subGenericaDet.subGenericaDet.eq(especificaDet1.subGenericaDet)))
        .leftJoin(especifica)
        .on(especifica.anoEje.eq(especificaDet1.anoEje)
            .and(especifica.tipoTransaccion.eq(especificaDet1.tipoTransaccion))
            .and(especifica.generica.eq(especificaDet1.generica))
            .and(especifica.subGenerica.eq(especificaDet1.subGenerica))
            .and(especifica.subGenericaDet.eq(especificaDet1.subGenericaDet))
            .and(especifica.especifica.eq(especificaDet1.especifica)))

        /*
        .leftJoin(especificaDet2)
        .on(especificaDet2.anoEje.eq(solRendicionDestino.anoEje)
            .and(especificaDet2.idClasificador.eq(solRendicionDestino.idClasificador)))
        .leftJoin(meta2)
        .on(meta2.anoEje.eq(solRendicionDestino.anoEje)
            .and(meta2.entidad.eq(solRendicionDestino.entidad))
            .and(meta2.secuenciaFuncional.eq(solRendicionDestino.secuenciaFuncional)))
        .leftJoin(finalidad2)
        .on(finalidad2.anioEje.eq(meta2.anoEje).and(finalidad2.codFinalidad.eq(meta2.codFinalidad)))
        .leftJoin(tipoOperacion)
        .on(tipoOperacion.anoEje.eq(solRendicionDet.anioEje)
            .and(tipoOperacion.codTipoOperacion.eq(solRendicionCab.codTipoOperacion)))
        .leftJoin(ejecutora).on(ejecutora.anoEje.eq(solRendicionDet.anioEje)
            .and(ejecutora.entidad.eq(solRendicionDet.entidadReciproca)))
        */
        .where(builder).fetch();
  }

  @Override
  public List<SolicitudRendicionDetalleClasificadoresProjection> obtenerSolicitudRendicionDetalleClasifDestino(
      ConsultarSolicitudesRendicionQuery consultarSolicitudesRendicionQuery) {
    var queryDsl = super.getQuerydsl();

    if (Objects.isNull(queryDsl)) {
      return null;
    }

    var solRendicionCab = QSolicitudRendicionCabEntity.solicitudRendicionCabEntity;
    var solRendicionDet = QSolicitudRendicionDetEntity.solicitudRendicionDetEntity;
    var solRendicionSec = QSolicitudRendicionSecEntity.solicitudRendicionSecEntity;
    var solRendicionClasif = QSolicitudRendicionClasifEntity.solicitudRendicionClasifEntity;
    var solRendicionMeta = QSolicitudRendicionMetaEntity.solicitudRendicionMetaEntity;
    var solRendicionDestino = QSolicitudRendicionDestinoEntity.solicitudRendicionDestinoEntity;
    // var fuenteFinanc = QFuenteFinancEntity.fuenteFinancEntity;
    // var especificaDet1 = new QEspecificaDetEntity("especificaDetOrigen");
    var especificaDet2 = new QEspecificaDetEntity("especificaDetDestino");
    // var meta1 = new QMetaEntity("metaOrigen");
    var meta2 = new QMetaEntity("metaDestino");
    // var finalidad1 = new QFinalidadEntity("finalidadOrigen");
    var finalidad2 = new QFinalidadEntity("finalidadDestino");
    // var tipoOperacion = QTipoOperacionEntity.tipoOperacionEntity;
    // var ejecutora = QEjecutoraEntity.ejecutoraEntity;
    // var codigoGeneralDet1 = new QCodigoGeneralDetEntity(ViewConstantes.CODIGO_ESTADO_REGISTRO);
    // var codigoGeneralDet2 = new QCodigoGeneralDetEntity(ViewConstantes.CODIGO_TIPO_RENDICION);
    var tipoTransaccion = QTipoTransaccionEntity.tipoTransaccionEntity;
    var generica = QGenericaEntity.genericaEntity;
    var subGenerica = QSubGenericaEntity.subGenericaEntity;
    var subGenericaDet = QSubGenericaDetEntity.subGenericaDetEntity;
    var especifica = QEspecificaEntity.especificaEntity;

    var builder = new BooleanBuilder();

    builder.and(solRendicionCab.anoEje.eq(consultarSolicitudesRendicionQuery.getAnoEje()));
    builder.and(solRendicionCab.entidad.eq(consultarSolicitudesRendicionQuery.getSecEjec()));
    builder.and(solRendicionCab.secNota.eq(consultarSolicitudesRendicionQuery.getSecuenciaNota()));

    return queryDsl.createQuery()
        .select(Projections.constructor(SolicitudRendicionDetalleClasificadoresProjection.class,
            especificaDet2.tipoTransaccion, tipoTransaccion.descripcionTipoTransaccon,
            especificaDet2.generica, generica.descriGenerica, especificaDet2.subGenerica,
            subGenerica.descriSubGenerica, especificaDet2.subGenericaDet,
            subGenericaDet.descriSubGenericaDet, especificaDet2.especifica,
            especifica.descriEspecifica, especificaDet2.especificaDet,
            especificaDet2.descriClasificador, solRendicionMeta.secuenciaFuncional,
            finalidad2.descriFinalidad, solRendicionDestino.montoNacional))
        .from(solRendicionCab).innerJoin(solRendicionSec)
        .on(solRendicionSec.anioEje.eq(solRendicionCab.anoEje)
            .and(solRendicionSec.entidad.eq(solRendicionCab.entidad))
            .and(solRendicionSec.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
        .innerJoin(solRendicionDet)
        .on(solRendicionDet.anioEje.eq(solRendicionCab.anoEje)
            .and(solRendicionDet.entidad.eq(solRendicionCab.entidad))
            .and(solRendicionDet.secuenciaSolicitud.eq(solRendicionCab.secuenciaSolicitud)))
        .innerJoin(solRendicionClasif)
        .on(solRendicionClasif.anoEje.eq(solRendicionDet.anioEje)
            .and(solRendicionClasif.entidad.eq(solRendicionDet.entidad))
            .and(solRendicionClasif.secuenciaSolicitud.eq(solRendicionDet.secuenciaSolicitud))
            .and(solRendicionClasif.secuenciaPorExpediente
                .eq(solRendicionDet.secuenciaPorExpediente)))
        .innerJoin(solRendicionMeta)
        .on(solRendicionMeta.anoEje.eq(solRendicionClasif.anoEje)
            .and(solRendicionMeta.entidad.eq(solRendicionClasif.entidad))
            .and(solRendicionMeta.secuenciaSolicitud.eq(solRendicionClasif.secuenciaSolicitud))
            .and(solRendicionMeta.secuenciaPorExpediente
                .eq(solRendicionClasif.secuenciaPorExpediente))
            .and(solRendicionMeta.idClasificador.eq(solRendicionClasif.idClasificador)))
        .innerJoin(solRendicionDestino)
        .on(solRendicionDestino.anoEje.eq(solRendicionMeta.anoEje)
            .and(solRendicionDestino.entidad.eq(solRendicionMeta.entidad))
            .and(solRendicionDestino.secuenciaSolicitud.eq(solRendicionMeta.secuenciaSolicitud))
            .and(solRendicionDestino.secuenciaPorExpediente
                .eq(solRendicionMeta.secuenciaPorExpediente))
            .and(solRendicionDestino.idClasificador.eq(solRendicionMeta.idClasificador)))
        /*
        .leftJoin(fuenteFinanc)
        .on(fuenteFinanc.anoEje.eq(solRendicionDet.anioEje)
            .and(fuenteFinanc.origen.eq(ViewConstantes.CODIGO_TIPO_ORIGEN))
            .and(fuenteFinanc.fuenteFinanc.eq(solRendicionDet.fuenteFinanciamiento)))
        .leftJoin(codigoGeneralDet1)
        .on(codigoGeneralDet1.codigoDet.eq(solRendicionCab.estadoRegistro)
            .and(codigoGeneralDet1.codigo.eq(ViewConstantes.CODIGO_ESTADO_REGISTRO)))
        .leftJoin(codigoGeneralDet2)
        .on(codigoGeneralDet2.codigoDet.castToNum(Integer.class).eq(solRendicionCab.tipoRendicion)
            .and(codigoGeneralDet2.codigo.eq(ViewConstantes.CODIGO_TIPO_RENDICION)))
        .leftJoin(especificaDet1)
        .on(especificaDet1.anoEje.eq(solRendicionClasif.anoEje)
            .and(especificaDet1.idClasificador.eq(solRendicionClasif.idClasificador)))
        .leftJoin(meta1)
        .on(meta1.anoEje.eq(solRendicionMeta.anoEje).and(meta1.entidad.eq(solRendicionMeta.entidad))
            .and(meta1.secuenciaFuncional.eq(solRendicionMeta.secuenciaFuncional)))
        .leftJoin(finalidad1)
        .on(finalidad1.anioEje.eq(meta1.anoEje).and(finalidad1.codFinalidad.eq(meta1.codFinalidad)))
        */

        .leftJoin(especificaDet2)
        .on(especificaDet2.anoEje.eq(solRendicionDestino.anoEje)
            .and(especificaDet2.idClasificador.eq(solRendicionDestino.idClasificador)))
        .leftJoin(meta2)
        .on(meta2.anoEje.eq(solRendicionDestino.anoEje)
            .and(meta2.entidad.eq(solRendicionDestino.entidad))
            .and(meta2.secuenciaFuncional.eq(solRendicionDestino.secuenciaFuncional)))
        .leftJoin(finalidad2)
        .on(finalidad2.anioEje.eq(meta2.anoEje).and(finalidad2.codFinalidad.eq(meta2.codFinalidad)))        
        .leftJoin(tipoTransaccion)
        .on(tipoTransaccion.anoEje.eq(especificaDet2.anoEje)
            .and(tipoTransaccion.codTipoTransaccion.eq(especificaDet2.tipoTransaccion)))
        .leftJoin(generica)
        .on(generica.anoEje.eq(especificaDet2.anoEje)
            .and(generica.tipoTransaccion.eq(especificaDet2.tipoTransaccion))
            .and(generica.generica.eq(especificaDet2.generica)))
        .leftJoin(subGenerica)
        .on(subGenerica.anoEje.eq(especificaDet2.anoEje)
            .and(subGenerica.tipoTransaccion.eq(especificaDet2.tipoTransaccion))
            .and(subGenerica.generica.eq(especificaDet2.generica))
            .and(subGenerica.subGenerica.eq(especificaDet2.subGenerica)))
        .leftJoin(subGenericaDet)
        .on(subGenericaDet.anoEje.eq(especificaDet2.anoEje)
            .and(subGenericaDet.tipoTransaccion.eq(especificaDet2.tipoTransaccion))
            .and(subGenericaDet.generica.eq(especificaDet2.generica))
            .and(subGenericaDet.subGenerica.eq(especificaDet2.subGenerica))
            .and(subGenericaDet.subGenericaDet.eq(especificaDet2.subGenericaDet)))
        .leftJoin(especifica)
        .on(especifica.anoEje.eq(especificaDet2.anoEje)
            .and(especifica.tipoTransaccion.eq(especificaDet2.tipoTransaccion))
            .and(especifica.generica.eq(especificaDet2.generica))
            .and(especifica.subGenerica.eq(especificaDet2.subGenerica))
            .and(especifica.subGenericaDet.eq(especificaDet2.subGenericaDet))
            .and(especifica.especifica.eq(especificaDet2.especifica)))
        /*
        .leftJoin(tipoOperacion)
        .on(tipoOperacion.anoEje.eq(solRendicionDet.anioEje)
            .and(tipoOperacion.codTipoOperacion.eq(solRendicionCab.codTipoOperacion)))
        .leftJoin(ejecutora).on(ejecutora.anoEje.eq(solRendicionDet.anioEje)
            .and(ejecutora.entidad.eq(solRendicionDet.entidadReciproca)))
        */
        .where(builder).fetch();
  }

}
