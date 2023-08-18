package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSolicitudRendicionCabEntity is a Querydsl query type for SolicitudRendicionCabEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSolicitudRendicionCabEntity extends EntityPathBase<SolicitudRendicionCabEntity> {

    private static final long serialVersionUID = 953090941L;

    public static final QSolicitudRendicionCabEntity solicitudRendicionCabEntity = new QSolicitudRendicionCabEntity("solicitudRendicionCabEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final StringPath codTipoOperacion = createString("codTipoOperacion");

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final StringPath estadoEnvio = createString("estadoEnvio");

    public final StringPath estadoRegistro = createString("estadoRegistro");

    public final StringPath indicadorCertificacion = createString("indicadorCertificacion");

    public final NumberPath<Integer> mesEje = createNumber("mesEje", Integer.class);

    public final NumberPath<Integer> secNota = createNumber("secNota", Integer.class);

    public final NumberPath<Integer> secuenciaSolicitud = createNumber("secuenciaSolicitud", Integer.class);

    public final NumberPath<Integer> tipoRendicion = createNumber("tipoRendicion", Integer.class);

    public final NumberPath<Integer> tipoSolicitud = createNumber("tipoSolicitud", Integer.class);

    public QSolicitudRendicionCabEntity(String variable) {
        super(SolicitudRendicionCabEntity.class, forVariable(variable));
    }

    public QSolicitudRendicionCabEntity(Path<? extends SolicitudRendicionCabEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSolicitudRendicionCabEntity(PathMetadata metadata) {
        super(SolicitudRendicionCabEntity.class, metadata);
    }

}

