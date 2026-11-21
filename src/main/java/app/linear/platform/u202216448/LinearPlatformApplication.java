package app.linear.platform.u202216448;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Bootstrap class for the Linear Platform application.
 *
 * <p>Initializes Spring Boot auto-configuration and JPA auditing infrastructure.</p>
 *
 * @author Gustavo Alonso Olivares Lao
 */
@EnableJpaAuditing
@SpringBootApplication
public class LinearPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinearPlatformApplication.class, args);
    }

}
