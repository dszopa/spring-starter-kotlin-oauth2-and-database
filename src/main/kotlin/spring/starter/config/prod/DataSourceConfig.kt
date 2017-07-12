package spring.starter.config.prod

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@Profile("prod")
class DataSourceConfig(
        private val dataSource: DataSource
) {

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
        factory.setPackagesToScan("spring.starter")
        factory.dataSource = dataSource
        factory.afterPropertiesSet()

        return factory.`object`
    }
}

