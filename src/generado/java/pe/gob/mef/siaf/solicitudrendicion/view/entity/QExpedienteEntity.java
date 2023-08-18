package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExpedienteEntity is a Querydsl query type for ExpedienteEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExpedienteEntity extends EntityPathBase<ExpedienteEntity> {

    private static final long serialVersionUID = 291603283L;

    public static final QExpedienteEntity expedienteEntity = new QExpedienteEntity("expedienteEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final NumberPath<Integer> expediente = createNumber("expediente", Integer.class);

    public final StringPath tipoOperacion = createString("tipoOperacion");

    public QExpedienteEntity(String variable) {
        super(ExpedienteEntity.class, forVariable(variable));
    }

    public QExpedienteEntity(Path<? extends ExpedienteEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExpedienteEntity(PathMetadata metadata) {
        super(ExpedienteEntity.class, metadata);
    }

}

