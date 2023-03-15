package com.dvargas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * Configures a connection to a MongoDB instance and provides a {@link MongoTemplate} bean for accessing it.
 * 
 * <p>
 * This configuration class is annotated with {@code @Configuration} to indicate that it provides bean definitions.
 * The {@code @EnableMongoRepositories} annotation enables Spring Data MongoDB repositories and specifies the base
 * package(s) for repository classes.
 * </p>
 * 
 * <p>
 * A bean is an object managed by the Spring container, which can be accessed by other objects in the application.
 * The {@link MongoTemplate} class provides a high-level API for interacting with MongoDB, and can be used to perform
 * various CRUD (create, read, update, delete) operations on MongoDB documents.
 * </p>
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.dvargas.pplanner.repository")
public class MongoDBConfig {
    
	/**
	Creates and configures a {@link MongoClient} bean that connects to a MongoDB instance located at the specified address
	and port. The MongoDB database to connect to is specified in the connection string. This method creates a connection
	pool for the client and returns a new instance of {@link MongoClient} with the provided configuration settings.
	@return a new instance of {@link MongoClient} configured with the provided connection settings
	*/
	@Bean
    MongoClient mongoClient() {
        ConnectionString connectionString = 
        		new ConnectionString("mongodb://localhost:27017/pantry-planner");
        
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        
        return MongoClients.create(mongoClientSettings);
    }
   
	/**
	Returns a configured {@link MongoTemplate} instance for accessing the MongoDB instance
	specified by the {@link MongoClient} bean returned by the {@link #mongoClient()} method.
	The "pantry-planner" database is used by default for operations performed by this template.
	@return A {@link MongoTemplate} instance configured with the MongoDB client settings
	specified by the {@link #mongoClient()} bean.
	*/
    @Bean
    MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = 
        		new MongoTemplate(mongoClient(), "pantry-planner");
		return mongoTemplate;
    }
}
