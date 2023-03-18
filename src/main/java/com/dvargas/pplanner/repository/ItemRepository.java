package com.dvargas.pplanner.repository;

import com.dvargas.pplanner.model.Item;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * <h1>Repository interface for managing items in the MongoDB database.</h1>
 * <p>Provides basic CRUD operations and additional methods for querying items.</p>
 */
public interface ItemRepository extends MongoRepository<Item, String> {}
