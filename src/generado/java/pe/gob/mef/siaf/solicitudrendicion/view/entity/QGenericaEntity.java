package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGenericaEntity is a Querydsl query type for GenericaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGenericaEntity extends EntityPathBase<GenericaEntity> {

    private static final long serialVersionUID = 449071606L;

    public static final QGenericaEntity genericaEntity = new QGenericaEntity("genericaEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final StringPath descriGenerica = createString("descriGenerica");

    public final StringPath estado = createString("estado");

    public final NumberPath<Integer> generica = createNumber("generica", Integer.class);

    public final NumberPath<Integer> tipoTransaccion = createNumber("tipoTransaccion", Integer.class);

    public QGenericaEntity(String variable) {
        super(GenericaEntity.class, forVariable(variable));
    }

    public QGenericaEntity(Path<? extends GenericaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGenericaEntity(PathMetadata metadata) {
        super(GenericaEntity.class, metadata);
    }

}

