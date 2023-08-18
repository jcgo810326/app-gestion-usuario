package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEspecificaEntity is a Querydsl query type for EspecificaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEspecificaEntity extends EntityPathBase<EspecificaEntity> {

    private static final long serialVersionUID = -1647499018L;

    public static final QEspecificaEntity especificaEntity = new QEspecificaEntity("especificaEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final StringPath descriEspecifica = createString("descriEspecifica");

    public final NumberPath<Integer> especifica = createNumber("especifica", Integer.class);

    public final StringPath estado = createString("estado");

    public final NumberPath<Integer> generica = createNumber("generica", Integer.class);

    public final NumberPath<Integer> subGenerica = createNumber("subGenerica", Integer.class);

    public final NumberPath<Integer> subGenericaDet = createNumber("subGenericaDet", Integer.class);

    public final NumberPath<Integer> tipoTransaccion = createNumber("tipoTransaccion", Integer.class);

    public QEspecificaEntity(String variable) {
        super(EspecificaEntity.class, forVariable(variable));
    }

    public QEspecificaEntity(Path<? extends EspecificaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEspecificaEntity(PathMetadata metadata) {
        super(EspecificaEntity.class, metadata);
    }

}

