package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEspecificaDetEntity is a Querydsl query type for EspecificaDetEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEspecificaDetEntity extends EntityPathBase<EspecificaDetEntity> {

    private static final long serialVersionUID = 213841891L;

    public static final QEspecificaDetEntity especificaDetEntity = new QEspecificaDetEntity("especificaDetEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final StringPath codTipoOperacion = createString("codTipoOperacion");

    public final StringPath descriClasificador = createString("descriClasificador");

    public final NumberPath<Integer> especifica = createNumber("especifica", Integer.class);

    public final NumberPath<Integer> especificaDet = createNumber("especificaDet", Integer.class);

    public final StringPath estado = createString("estado");

    public final NumberPath<Integer> generica = createNumber("generica", Integer.class);

    public final StringPath idClasificador = createString("idClasificador");

    public final NumberPath<Integer> subGenerica = createNumber("subGenerica", Integer.class);

    public final NumberPath<Integer> subGenericaDet = createNumber("subGenericaDet", Integer.class);

    public final NumberPath<Integer> tipoTransaccion = createNumber("tipoTransaccion", Integer.class);

    public QEspecificaDetEntity(String variable) {
        super(EspecificaDetEntity.class, forVariable(variable));
    }

    public QEspecificaDetEntity(Path<? extends EspecificaDetEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEspecificaDetEntity(PathMetadata metadata) {
        super(EspecificaDetEntity.class, metadata);
    }

}

