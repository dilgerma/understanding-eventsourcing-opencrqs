package de.nebulit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

@Configuration
class ValidatorConfig {
    @Bean
    fun localValidatorFactoryBean(): LocalValidatorFactoryBean {
        return LocalValidatorFactoryBean()
    }
}
@EnableJpaRepositories
@SpringBootApplication
@EnableScheduling
@EntityScan(
    basePackages =
    ["de.nebulit"]
)
class SpringApp {
    companion object {
        fun main(args: Array<String>) {
            runApplication<SpringApp>(*args)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringApp>(*args)
}
