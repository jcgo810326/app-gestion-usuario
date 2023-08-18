package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMetaEntity is a Querydsl query type for MetaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMetaEntity extends EntityPathBase<MetaEntity> {

    private static final long serialVersionUID = 444955345L;

    public static final QMetaEntity metaEntity = new QMetaEntity("metaEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final StringPath codFinalidad = createString("codFinalidad");

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final NumberPath<Integer> secuenciaFuncional = createNumber("secuenciaFuncional", Integer.class);

    public QMetaEntity(String variable) {
        super(MetaEntity.class, forVariable(variable));
    }

    public QMetaEntity(Path<? extends MetaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMetaEntity(PathMetadata metadata) {
        super(MetaEntity.class, metadata);
    }

}

