package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSolicitudRendicionSecEntity is a Querydsl query type for SolicitudRendicionSecEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSolicitudRendicionSecEntity extends EntityPathBase<SolicitudRendicionSecEntity> {

    private static final long serialVersionUID = 1367401034L;

    public static final QSolicitudRendicionSecEntity solicitudRendicionSecEntity = new QSolicitudRendicionSecEntity("solicitudRendicionSecEntity");

    public final NumberPath<Integer> anioEje = createNumber("anioEje", Integer.class);

    public final StringPath codigoDocumento = createString("codigoDocumento");

    public final NumberPath<Integer> correlativoSolicitud = createNumber("correlativoSolicitud", Integer.class);

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final StringPath estadoEnvio = createString("estadoEnvio");

    public final StringPath estadoRegistro = createString("estadoRegistro");

    public final DatePath<java.time.LocalDate> fechaDocumento = createDate("fechaDocumento", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> fechaProceso = createDate("fechaProceso", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> fechaRegistro = createDate("fechaRegistro", java.time.LocalDate.class);

    public final StringPath numeroDocumento = createString("numeroDocumento");

    public final NumberPath<Integer> secuenciaSolicitud = createNumber("secuenciaSolicitud", Integer.class);

    public final StringPath tipoRegistro = createString("tipoRegistro");

    public QSolicitudRendicionSecEntity(String variable) {
        super(SolicitudRendicionSecEntity.class, forVariable(variable));
    }

    public QSolicitudRendicionSecEntity(Path<? extends SolicitudRendicionSecEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSolicitudRendicionSecEntity(PathMetadata metadata) {
        super(SolicitudRendicionSecEntity.class, metadata);
    }

}

