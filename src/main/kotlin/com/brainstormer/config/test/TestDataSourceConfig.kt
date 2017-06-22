package com.brainstormer.config.test

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@Profile("test")
class TestDataSourceConfig {

    /**
     * Creates the embedded database to be used as a datasouce
     * @return
     *  The embedded database datasource
     */
    @Bean
    @Primary
    fun dataSource(): DataSource {
        return EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("db/schema.sql")
                .build()
    }

    /**
     * Creates a manager for entities that will create tables in the database for the specified entity in the
     * transaction if there are no tables for the entity currently in the database.
     * @return
     *  EntityManagerFactory that does the above.
     */
    @Bean
    fun entityManagerFactory(): EntityManagerFactory {
        var vendorAdapter: HibernateJpaVendorAdapter = HibernateJpaVendorAdapter()
        vendorAdapter.setGenerateDdl(true)

        var factory: LocalContainerEntityManagerFactoryBean = LocalContainerEntityManagerFactoryBean()
        factory.jpaVendorAdapter = vendorAdapter
        factory.setPackagesToScan("com.brainstormer")
        factory.dataSource = dataSource()
        factory.afterPropertiesSet()

        return factory.`object`
    }
}

