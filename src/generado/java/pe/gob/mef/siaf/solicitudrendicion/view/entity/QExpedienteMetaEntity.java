package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExpedienteMetaEntity is a Querydsl query type for ExpedienteMetaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExpedienteMetaEntity extends EntityPathBase<ExpedienteMetaEntity> {

    private static final long serialVersionUID = 663942584L;

    public static final QExpedienteMetaEntity expedienteMetaEntity = new QExpedienteMetaEntity("expedienteMetaEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final NumberPath<Integer> correlativo = createNumber("correlativo", Integer.class);

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final NumberPath<Integer> expediente = createNumber("expediente", Integer.class);

    public final StringPath idClasificador = createString("idClasificador");

    public final NumberPath<Double> montoNacional = createNumber("montoNacional", Double.class);

    public final NumberPath<Integer> secuencia = createNumber("secuencia", Integer.class);

    public final NumberPath<Integer> secuenciaFuncional = createNumber("secuenciaFuncional", Integer.class);

    public QExpedienteMetaEntity(String variable) {
        super(ExpedienteMetaEntity.class, forVariable(variable));
    }

    public QExpedienteMetaEntity(Path<? extends ExpedienteMetaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExpedienteMetaEntity(PathMetadata metadata) {
        super(ExpedienteMetaEntity.class, metadata);
    }

}

