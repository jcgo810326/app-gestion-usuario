package pe.gob.mef.siaf.solicitudrendicion.view.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGastoEntity is a Querydsl query type for GastoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGastoEntity extends EntityPathBase<GastoEntity> {

    private static final long serialVersionUID = 1889083566L;

    public static final QGastoEntity gastoEntity = new QGastoEntity("gastoEntity");

    public final NumberPath<Integer> anoEje = createNumber("anoEje", Integer.class);

    public final NumberPath<Double> comprometido = createNumber("comprometido", Double.class);

    public final NumberPath<Integer> entidad = createNumber("entidad", Integer.class);

    public final StringPath idClasificador = createString("idClasificador");

    public final NumberPath<Double> modificacion = createNumber("modificacion", Double.class);

    public final NumberPath<Double> presupuesto = createNumber("presupuesto", Double.class);

    public final NumberPath<Integer> secuenciaFuncional = createNumber("secuenciaFuncional", Integer.class);

    public QGastoEntity(String variable) {
        super(GastoEntity.class, forVariable(variable));
    }

    public QGastoEntity(Path<? extends GastoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGastoEntity(PathMetadata metadata) {
        super(GastoEntity.class, metadata);
    }

}

