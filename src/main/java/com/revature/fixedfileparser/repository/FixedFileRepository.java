package com.revature.fixedfileparser.repository;

import com.revature.fixedfileparser.model.FixedFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *  Repository class dealing with the database interactions for FixedFile
 */
@Repository
public interface FixedFileRepository extends MongoRepository<FixedFile, ObjectId> {
    /**
     * Retrieves all fixed files that were uploaded by a specific user from database
     *
     * @param userId the id pertaining to the user
     * @return list of fixed files that were uploaded by the user
     */
    Optional<List<FixedFile>> findAllByUserId(ObjectId userId);
}
