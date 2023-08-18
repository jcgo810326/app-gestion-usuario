package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTipoOperacionEntity is a Querydsl query type for TipoOperacionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTipoOperacionEntity extends EntityPathBase<TipoOperacionEntity> {

    private static final long serialVersionUID = -1200198434L;

    public static final QTipoOperacionEntity tipoOperacionEntity = new QTipoOperacionEntity("tipoOperacionEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final StringPath codTipoOperacion = createString("codTipoOperacion");

    public final StringPath descriTipoOperacion = createString("descriTipoOperacion");

    public QTipoOperacionEntity(String variable) {
        super(TipoOperacionEntity.class, forVariable(variable));
    }

    public QTipoOperacionEntity(Path<? extends TipoOperacionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTipoOperacionEntity(PathMetadata metadata) {
        super(TipoOperacionEntity.class, metadata);
    }

}

