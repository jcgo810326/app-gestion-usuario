package pe.gob.mef.siaf.solicitudrendicion.domain.util;

import javax.sql.DataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pe.gob.mef.common.security.SecurityUtil;

@Aspect
@Component
public class AuditoriaAspect {

    private JdbcTemplate jdbcTemplate;
  
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Before("execution(* pe.gob.mef.*.*.application.service.*CommandService*.*(..))")
    public void registraAuditoria(JoinPoint joinPoint) {
        try {
            this.jdbcTemplate.execute("call SYSTEM.app_sec.set_username('" + SecurityUtil.getUsuario() + "')");
        }catch(Exception e) {
            
        }       
    }
}
