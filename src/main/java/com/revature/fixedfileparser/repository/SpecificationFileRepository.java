package com.revature.fixedfileparser.repository;

import com.revature.fixedfileparser.model.SpecificationFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *  Repository class dealing with the database interactions for SpecificationFile
 */
@Repository
public interface SpecificationFileRepository extends MongoRepository<SpecificationFile, ObjectId> {
}
