package pe.gob.mef.siaf.solicitudrendicion;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuración del dominio y repositorio para las pruebas.
 *
 * @author Mariano Alcántara, mariano@booleancore.com
 * @version 1.0, 22/12/2021
 */
@Configuration
@EntityScan({"pe.gob.mef.siaf.solicitudrendicion.domain",
    "pe.gob.mef.siaf.solicitudrendicion.view.entity"})
@EnableJpaRepositories(
    basePackages = {"pe.gob.mef.siaf.solicitudrendicion.port.outbound.repository"})
@EnableAutoConfiguration
public class UnitTestConfig {


}
