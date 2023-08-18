package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEjecutoraEntity is a Querydsl query type for EjecutoraEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEjecutoraEntity extends EntityPathBase<EjecutoraEntity> {

    private static final long serialVersionUID = 457949654L;

    public static final QEjecutoraEntity ejecutoraEntity = new QEjecutoraEntity("ejecutoraEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final StringPath nombreEjecutora = createString("nombreEjecutora");

    public QEjecutoraEntity(String variable) {
        super(EjecutoraEntity.class, forVariable(variable));
    }

    public QEjecutoraEntity(Path<? extends EjecutoraEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEjecutoraEntity(PathMetadata metadata) {
        super(EjecutoraEntity.class, metadata);
    }

}

