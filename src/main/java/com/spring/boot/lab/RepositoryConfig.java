package com.spring.boot.lab;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author manueljordan
 *
 */
@Configuration
@Profile(value = "!slice")
@EnableJpaRepositories(basePackages = "com.spring.boot.lab.repositorio")
@EntityScan(basePackages="com.spring.boot.lab.dominio")
class RepositoryConfig {

}
