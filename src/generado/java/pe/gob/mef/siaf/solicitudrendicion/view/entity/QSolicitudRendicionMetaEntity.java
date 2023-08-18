package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSolicitudRendicionMetaEntity is a Querydsl query type for SolicitudRendicionMetaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSolicitudRendicionMetaEntity extends EntityPathBase<SolicitudRendicionMetaEntity> {

    private static final long serialVersionUID = -1916875182L;

    public static final QSolicitudRendicionMetaEntity solicitudRendicionMetaEntity = new QSolicitudRendicionMetaEntity("solicitudRendicionMetaEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final StringPath estadoRegistro = createString("estadoRegistro");

    public final StringPath idClasificador = createString("idClasificador");

    public final NumberPath<Double> monto = createNumber("monto", Double.class);

    public final NumberPath<Double> montoNacional = createNumber("montoNacional", Double.class);

    public final NumberPath<Integer> secuenciaFuncional = createNumber("secuenciaFuncional", Integer.class);

    public final NumberPath<Integer> secuenciaPorExpediente = createNumber("secuenciaPorExpediente", Integer.class);

    public final NumberPath<Integer> secuenciaSolicitud = createNumber("secuenciaSolicitud", Integer.class);

    public QSolicitudRendicionMetaEntity(String variable) {
        super(SolicitudRendicionMetaEntity.class, forVariable(variable));
    }

    public QSolicitudRendicionMetaEntity(Path<? extends SolicitudRendicionMetaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSolicitudRendicionMetaEntity(PathMetadata metadata) {
        super(SolicitudRendicionMetaEntity.class, metadata);
    }

}

