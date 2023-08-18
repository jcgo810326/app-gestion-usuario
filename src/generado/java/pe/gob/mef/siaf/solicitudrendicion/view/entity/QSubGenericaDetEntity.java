package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubGenericaDetEntity is a Querydsl query type for SubGenericaDetEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubGenericaDetEntity extends EntityPathBase<SubGenericaDetEntity> {

    private static final long serialVersionUID = -472514955L;

    public static final QSubGenericaDetEntity subGenericaDetEntity = new QSubGenericaDetEntity("subGenericaDetEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final StringPath descriSubGenericaDet = createString("descriSubGenericaDet");

    public final StringPath estado = createString("estado");

    public final NumberPath<Integer> generica = createNumber("generica", Integer.class);

    public final NumberPath<Integer> subGenerica = createNumber("subGenerica", Integer.class);

    public final NumberPath<Integer> subGenericaDet = createNumber("subGenericaDet", Integer.class);

    public final NumberPath<Integer> tipoTransaccion = createNumber("tipoTransaccion", Integer.class);

    public QSubGenericaDetEntity(String variable) {
        super(SubGenericaDetEntity.class, forVariable(variable));
    }

    public QSubGenericaDetEntity(Path<? extends SubGenericaDetEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubGenericaDetEntity(PathMetadata metadata) {
        super(SubGenericaDetEntity.class, metadata);
    }

}

