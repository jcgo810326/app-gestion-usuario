package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFuenteFinancEntity is a Querydsl query type for FuenteFinancEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFuenteFinancEntity extends EntityPathBase<FuenteFinancEntity> {

    private static final long serialVersionUID = 408827392L;

    public static final QFuenteFinancEntity fuenteFinancEntity = new QFuenteFinancEntity("fuenteFinancEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final StringPath fuenteFinanc = createString("fuenteFinanc");

    public final StringPath nombre = createString("nombre");

    public final StringPath origen = createString("origen");

    public QFuenteFinancEntity(String variable) {
        super(FuenteFinancEntity.class, forVariable(variable));
    }

    public QFuenteFinancEntity(Path<? extends FuenteFinancEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFuenteFinancEntity(PathMetadata metadata) {
        super(FuenteFinancEntity.class, metadata);
    }

}

