package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSolicitudRendicionClasifEntity is a Querydsl query type for SolicitudRendicionClasifEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSolicitudRendicionClasifEntity extends EntityPathBase<SolicitudRendicionClasifEntity> {

    private static final long serialVersionUID = -830713787L;

    public static final QSolicitudRendicionClasifEntity solicitudRendicionClasifEntity = new QSolicitudRendicionClasifEntity("solicitudRendicionClasifEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final StringPath estadoRegistro = createString("estadoRegistro");

    public final StringPath idClasificador = createString("idClasificador");

    public final NumberPath<Double> monto = createNumber("monto", Double.class);

    public final NumberPath<Double> montoNacional = createNumber("montoNacional", Double.class);

    public final NumberPath<Integer> secuenciaPorExpediente = createNumber("secuenciaPorExpediente", Integer.class);

    public final NumberPath<Integer> secuenciaSolicitud = createNumber("secuenciaSolicitud", Integer.class);

    public QSolicitudRendicionClasifEntity(String variable) {
        super(SolicitudRendicionClasifEntity.class, forVariable(variable));
    }

    public QSolicitudRendicionClasifEntity(Path<? extends SolicitudRendicionClasifEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSolicitudRendicionClasifEntity(PathMetadata metadata) {
        super(SolicitudRendicionClasifEntity.class, metadata);
    }

}

