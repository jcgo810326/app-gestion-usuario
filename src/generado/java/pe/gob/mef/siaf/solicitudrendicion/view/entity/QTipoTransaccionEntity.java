package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTipoTransaccionEntity is a Querydsl query type for TipoTransaccionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTipoTransaccionEntity extends EntityPathBase<TipoTransaccionEntity> {

    private static final long serialVersionUID = 1993494613L;

    public static final QTipoTransaccionEntity tipoTransaccionEntity = new QTipoTransaccionEntity("tipoTransaccionEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final NumberPath<Integer> codTipoTransaccion = createNumber("codTipoTransaccion", Integer.class);

    public final StringPath descripcionTipoTransaccon = createString("descripcionTipoTransaccon");

    public final StringPath estado = createString("estado");

    public QTipoTransaccionEntity(String variable) {
        super(TipoTransaccionEntity.class, forVariable(variable));
    }

    public QTipoTransaccionEntity(Path<? extends TipoTransaccionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTipoTransaccionEntity(PathMetadata metadata) {
        super(TipoTransaccionEntity.class, metadata);
    }

}

