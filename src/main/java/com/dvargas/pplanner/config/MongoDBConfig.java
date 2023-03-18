package com.dvargas.pplanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * 	<h1>
 * 		Configures a connection to a MongoDB instance and provides a {@link MongoTemplate} bean for accessing it.
 * 	</h1>
 * 
 * 	<p>
 * 		This configuration class is annotated with {@code @Configuration} to indicate that it provides bean definitions.
 * 		The {@code @EnableMongoRepositories} annotation enables Spring Data MongoDB repositories and specifies the base
 * 		package(s) for repository classes.
 * 	</p>
 * 
 * 	<p>
 * 		A bean is an object managed by the Spring container, which can be accessed by other objects in the application.
 * 		The {@link MongoTemplate} class provides a high-level API for interacting with MongoDB, and can be used to perform
 * 		various CRUD (create, read, update, delete) operations on MongoDB documents.
 * 	</p>
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.dvargas.pplanner.repository")
public class MongoDBConfig {
    
	/**
	 *	<h1>
	 *		Creates and configures a {@link MongoClient} bean that connects to a MongoDB instance located at the specified address and port.
	 *	</h1>
	 * 		
	 * 	<ul>
	 *		<li> 
	 * 			The database being connected to is specified in the connection string. 
	 * 		</li>
	 * 		<li>
	 * 			This method creates a connection pool for the client and returns a new instance of 
	 * 			{@link MongoClient} with the provided configuration settings.
	 * 		</li>
	
	 *  </ul>
	 *  <p>
	 *  	@return a new instance of {@link MongoClient} configured with the provided connection settings
	 *  </p>
	*/
	@Bean
    MongoClient mongoClient() {
		
//		String connectionAddress = "mongodb://localhost:27017/pantry-planner"
		String uri = System.getenv("SPRING_DATA_MONGODB_URI");
		if (uri == null)
			uri = "mongodb://root:rootpassword@mongodb:27017/pantry-planner";
        ConnectionString connectionString = 
        		new ConnectionString(uri);
        
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        
        return MongoClients.create(mongoClientSettings);
    }
   
	/**
	 * 	<h1>
	 * 		Returns a configured {@link MongoTemplate} instance for accessing the MongoDB instance specified by the 
	 * 		{@link MongoClient} bean returned by the {@link #mongoClient()} method.
	 * 	</h1>
	 * 	<p>
	 * 		The "pantry-planner" database is used by default for operations performed by this template.</p>
	 * 	<p>
	 * 		@return A {@link MongoTemplate} instance configured with the MongoDB client settings specified by the 
	 * 		{@link #mongoClient()} bean.
	 * 	</p>
	 */
    @Bean
    MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = 
        		new MongoTemplate(mongoClient(), "pantry-planner");
		return mongoTemplate;
    }
}
