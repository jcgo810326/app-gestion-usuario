package pe.gob.mef.siaf.solicitudrendicion.domain.auditoria;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditoria is a Querydsl query type for Auditoria
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QAuditoria extends BeanPath<Auditoria> {

    private static final long serialVersionUID = -2030935557L;

    public static final QAuditoria auditoria = new QAuditoria("auditoria");

    public final DateTimePath<java.time.LocalDateTime> fechaCreacion = createDateTime("fechaCreacion", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> fechaModificacion = createDateTime("fechaModificacion", java.time.LocalDateTime.class);

    public final StringPath usuarioCreacion = createString("usuarioCreacion");

    public final StringPath usuarioModificacion = createString("usuarioModificacion");

    public QAuditoria(String variable) {
        super(Auditoria.class, forVariable(variable));
    }

    public QAuditoria(Path<? extends Auditoria> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditoria(PathMetadata metadata) {
        super(Auditoria.class, metadata);
    }

}

