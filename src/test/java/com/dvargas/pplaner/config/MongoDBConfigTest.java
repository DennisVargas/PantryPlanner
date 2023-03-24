package com.dvargas.pplaner.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dvargas.pplanner.config.MongoDBConfig;
import com.mongodb.client.MongoClient;

// @ExtendWith(SpringExtension.class)
@SpringBootTest(classes={MongoDBConfig.class})
public class MongoDBConfigTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoClient mongoClient;

    @Test
    void testMongoClient() {
        assertThat(mongoClient).isNotNull();
    }

    @Test
    void testMongoTemplate() {
        assertThat(mongoTemplate).isNotNull();
    }
}
