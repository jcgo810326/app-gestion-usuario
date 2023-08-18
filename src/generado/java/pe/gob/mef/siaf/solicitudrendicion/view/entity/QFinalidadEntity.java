package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFinalidadEntity is a Querydsl query type for FinalidadEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFinalidadEntity extends EntityPathBase<FinalidadEntity> {

    private static final long serialVersionUID = -2061689074L;

    public static final QFinalidadEntity finalidadEntity = new QFinalidadEntity("finalidadEntity");

    public final NumberPath<Integer> anioEje = createNumber("anioEje", Integer.class);

    public final StringPath codFinalidad = createString("codFinalidad");

    public final StringPath descriFinalidad = createString("descriFinalidad");

    public QFinalidadEntity(String variable) {
        super(FinalidadEntity.class, forVariable(variable));
    }

    public QFinalidadEntity(Path<? extends FinalidadEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFinalidadEntity(PathMetadata metadata) {
        super(FinalidadEntity.class, metadata);
    }

}

