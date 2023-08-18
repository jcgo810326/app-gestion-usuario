package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExpedienteSecuenciaEntity is a Querydsl query type for ExpedienteSecuenciaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExpedienteSecuenciaEntity extends EntityPathBase<ExpedienteSecuenciaEntity> {

    private static final long serialVersionUID = 1942542273L;

    public static final QExpedienteSecuenciaEntity expedienteSecuenciaEntity = new QExpedienteSecuenciaEntity("expedienteSecuenciaEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final StringPath ciclo = createString("ciclo");

    public final StringPath codigoDocumento = createString("codigoDocumento");

    public final NumberPath<Integer> correlativo = createNumber("correlativo", Integer.class);

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final StringPath estado = createString("estado");

    public final NumberPath<Integer> expedienteSec = createNumber("expedienteSec", Integer.class);

    public final StringPath fase = createString("fase");

    public final StringPath fechaDocumento = createString("fechaDocumento");

    public final NumberPath<Double> monto = createNumber("monto", Double.class);

    public final NumberPath<Double> montoNacional = createNumber("montoNacional", Double.class);

    public final StringPath numeroDocumento = createString("numeroDocumento");

    public final NumberPath<Integer> secuencia = createNumber("secuencia", Integer.class);

    public QExpedienteSecuenciaEntity(String variable) {
        super(ExpedienteSecuenciaEntity.class, forVariable(variable));
    }

    public QExpedienteSecuenciaEntity(Path<? extends ExpedienteSecuenciaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExpedienteSecuenciaEntity(PathMetadata metadata) {
        super(ExpedienteSecuenciaEntity.class, metadata);
    }

}

