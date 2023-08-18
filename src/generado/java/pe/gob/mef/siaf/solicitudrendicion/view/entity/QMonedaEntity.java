package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMonedaEntity is a Querydsl query type for MonedaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMonedaEntity extends EntityPathBase<MonedaEntity> {

    private static final long serialVersionUID = -1946154270L;

    public static final QMonedaEntity monedaEntity = new QMonedaEntity("monedaEntity");

    public final StringPath moneda = createString("moneda");

    public final StringPath nombre = createString("nombre");

    public QMonedaEntity(String variable) {
        super(MonedaEntity.class, forVariable(variable));
    }

    public QMonedaEntity(Path<? extends MonedaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMonedaEntity(PathMetadata metadata) {
        super(MonedaEntity.class, metadata);
    }

}

