package pe.gob.mef.siaf.solicitudrendicion.domain.auditoria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
// @EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditoriaConfig {

  /*
  @Bean
  AuditorAware<String> auditorProvider() {
    return new AuditoriaAwareImpl();
  }
  */

}
