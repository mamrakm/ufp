package cz.ememsoft.ufp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = {"cz.ememsoft.ufp"},
        enableDefaultTransactions = false
)
public class ServiceConfiguration {

}
