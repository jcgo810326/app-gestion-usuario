package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodigoGeneralDetEntity is a Querydsl query type for CodigoGeneralDetEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodigoGeneralDetEntity extends EntityPathBase<CodigoGeneralDetEntity> {

    private static final long serialVersionUID = -22105712L;

    public static final QCodigoGeneralDetEntity codigoGeneralDetEntity = new QCodigoGeneralDetEntity("codigoGeneralDetEntity");

    public final StringPath codigo = createString("codigo");

    public final StringPath codigoDet = createString("codigoDet");

    public final StringPath descripcion = createString("descripcion");

    public QCodigoGeneralDetEntity(String variable) {
        super(CodigoGeneralDetEntity.class, forVariable(variable));
    }

    public QCodigoGeneralDetEntity(Path<? extends CodigoGeneralDetEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodigoGeneralDetEntity(PathMetadata metadata) {
        super(CodigoGeneralDetEntity.class, metadata);
    }

}

