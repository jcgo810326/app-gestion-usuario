package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExpedienteFaseEntity is a Querydsl query type for ExpedienteFaseEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExpedienteFaseEntity extends EntityPathBase<ExpedienteFaseEntity> {

    private static final long serialVersionUID = -1808342528L;

    public static final QExpedienteFaseEntity expedienteFaseEntity = new QExpedienteFaseEntity("expedienteFaseEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final NumberPath<Integer> certificado = createNumber("certificado", Integer.class);

    public final NumberPath<Integer> certificadoSecuencia = createNumber("certificadoSecuencia", Integer.class);

    public final StringPath ciclo = createString("ciclo");

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final StringPath estado = createString("estado");

    public final NumberPath<Integer> expediente = createNumber("expediente", Integer.class);

    public final StringPath fase = createString("fase");

    public final StringPath fuenteFinanc = createString("fuenteFinanc");

    public final NumberPath<Integer> secuencia = createNumber("secuencia", Integer.class);

    public QExpedienteFaseEntity(String variable) {
        super(ExpedienteFaseEntity.class, forVariable(variable));
    }

    public QExpedienteFaseEntity(Path<? extends ExpedienteFaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExpedienteFaseEntity(PathMetadata metadata) {
        super(ExpedienteFaseEntity.class, metadata);
    }

}

