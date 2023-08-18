package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSolicitudRendicionDetEntity is a Querydsl query type for SolicitudRendicionDetEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSolicitudRendicionDetEntity extends EntityPathBase<SolicitudRendicionDetEntity> {

    private static final long serialVersionUID = 617107596L;

    public static final QSolicitudRendicionDetEntity solicitudRendicionDetEntity = new QSolicitudRendicionDetEntity("solicitudRendicionDetEntity");

    public final NumberPath<Integer> anioEje = createNumber("anioEje", Integer.class);

    public final NumberPath<Integer> certificado = createNumber("certificado", Integer.class);

    public final NumberPath<Integer> certificadoSecuencia = createNumber("certificadoSecuencia", Integer.class);

    public final StringPath ciclo = createString("ciclo");

    public final StringPath codTipoDocIdentidad = createString("codTipoDocIdentidad");

    public final NumberPath<Integer> correlativo = createNumber("correlativo", Integer.class);

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final NumberPath<Integer> entidadReciproca = createNumber("entidadReciproca", Integer.class);

    public final StringPath estadoRegistro = createString("estadoRegistro");

    public final NumberPath<Integer> expediente = createNumber("expediente", Integer.class);

    public final StringPath fase = createString("fase");

    public final StringPath fuenteFinanciamiento = createString("fuenteFinanciamiento");

    public final StringPath moneda = createString("moneda");

    public final NumberPath<Double> monto = createNumber("monto", Double.class);

    public final NumberPath<Double> montoNacional = createNumber("montoNacional", Double.class);

    public final StringPath ruc = createString("ruc");

    public final NumberPath<Integer> secNotaModificatoria = createNumber("secNotaModificatoria", Integer.class);

    public final NumberPath<Integer> secuencia = createNumber("secuencia", Integer.class);

    public final NumberPath<Integer> secuenciaAnterior = createNumber("secuenciaAnterior", Integer.class);

    public final NumberPath<Integer> secuenciaPadre = createNumber("secuenciaPadre", Integer.class);

    public final NumberPath<Integer> secuenciaPorExpediente = createNumber("secuenciaPorExpediente", Integer.class);

    public final NumberPath<Integer> secuenciaSolicitud = createNumber("secuenciaSolicitud", Integer.class);

    public final NumberPath<Integer> secuenciaSolicitudPadre = createNumber("secuenciaSolicitudPadre", Integer.class);

    public final NumberPath<Double> tipoCambio = createNumber("tipoCambio", Double.class);

    public QSolicitudRendicionDetEntity(String variable) {
        super(SolicitudRendicionDetEntity.class, forVariable(variable));
    }

    public QSolicitudRendicionDetEntity(Path<? extends SolicitudRendicionDetEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSolicitudRendicionDetEntity(PathMetadata metadata) {
        super(SolicitudRendicionDetEntity.class, metadata);
    }

}

