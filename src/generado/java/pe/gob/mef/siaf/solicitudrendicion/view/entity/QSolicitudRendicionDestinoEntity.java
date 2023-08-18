package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSolicitudRendicionDestinoEntity is a Querydsl query type for SolicitudRendicionDestinoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSolicitudRendicionDestinoEntity extends EntityPathBase<SolicitudRendicionDestinoEntity> {

    private static final long serialVersionUID = -862194751L;

    public static final QSolicitudRendicionDestinoEntity solicitudRendicionDestinoEntity = new QSolicitudRendicionDestinoEntity("solicitudRendicionDestinoEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final StringPath estadoRegistro = createString("estadoRegistro");

    public final StringPath idClasificador = createString("idClasificador");

    public final StringPath idClasificadorDestino = createString("idClasificadorDestino");

    public final NumberPath<Double> monto = createNumber("monto", Double.class);

    public final NumberPath<Double> montoNacional = createNumber("montoNacional", Double.class);

    public final NumberPath<Integer> secuenciaFuncional = createNumber("secuenciaFuncional", Integer.class);

    public final NumberPath<Integer> secuenciaFuncionalDestino = createNumber("secuenciaFuncionalDestino", Integer.class);

    public final NumberPath<Integer> secuenciaPorExpediente = createNumber("secuenciaPorExpediente", Integer.class);

    public final NumberPath<Integer> secuenciaSolicitud = createNumber("secuenciaSolicitud", Integer.class);

    public QSolicitudRendicionDestinoEntity(String variable) {
        super(SolicitudRendicionDestinoEntity.class, forVariable(variable));
    }

    public QSolicitudRendicionDestinoEntity(Path<? extends SolicitudRendicionDestinoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSolicitudRendicionDestinoEntity(PathMetadata metadata) {
        super(SolicitudRendicionDestinoEntity.class, metadata);
    }

}

