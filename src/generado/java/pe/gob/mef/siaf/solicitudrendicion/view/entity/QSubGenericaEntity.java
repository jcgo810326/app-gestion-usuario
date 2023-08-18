package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubGenericaEntity is a Querydsl query type for SubGenericaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubGenericaEntity extends EntityPathBase<SubGenericaEntity> {

    private static final long serialVersionUID = -1212417116L;

    public static final QSubGenericaEntity subGenericaEntity = new QSubGenericaEntity("subGenericaEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final StringPath descriSubGenerica = createString("descriSubGenerica");

    public final StringPath estado = createString("estado");

    public final NumberPath<Integer> generica = createNumber("generica", Integer.class);

    public final NumberPath<Integer> subGenerica = createNumber("subGenerica", Integer.class);

    public final NumberPath<Integer> tipoTransaccion = createNumber("tipoTransaccion", Integer.class);

    public QSubGenericaEntity(String variable) {
        super(SubGenericaEntity.class, forVariable(variable));
    }

    public QSubGenericaEntity(Path<? extends SubGenericaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubGenericaEntity(PathMetadata metadata) {
        super(SubGenericaEntity.class, metadata);
    }

}

