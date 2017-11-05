package com.stackroute.deploymentdashboard.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySource(value = { "application.properties" })
@EnableCassandraRepositories(basePackages = { "com.stackroute.deploymentdashboard" })
public class CassandraConfiguration extends AbstractCassandraConfiguration {
    @Autowired
    private Environment environment;
    
//    @Override
//    @Bean
//    public CassandraClusterFactoryBean cluster() {
//        final CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
//        cluster.setContactPoints(environment.getProperty("spring.data.cassandra.contact-points"));
//        cluster.setPort(Integer.parseInt(environment.getProperty("spring.data.cassandra.port")));
//       // LOGGER.info("Cluster created with contact points [" + environment.getProperty("cassandra.contactpoints") + "] " + "& port [" + Integer.parseInt(environment.getProperty("cassandra.port")) + "].");
//        return cluster;
//    }

    @Override
    protected String getKeyspaceName() {
        return environment.getProperty("spring.data.cassandra.keyspace-name");
    }

    @Bean
    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}




