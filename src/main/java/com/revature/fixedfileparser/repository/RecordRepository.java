package com.revature.fixedfileparser.repository;

import com.revature.fixedfileparser.model.Record;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *  Repository class dealing with the database interactions for Record
 */
@Repository
public interface RecordRepository extends MongoRepository<Record, ObjectId> {
    /**
     * Retrieves all the records that came from a specific fixed file from database
     *
     * @param fixedFileId the id to check
     * @return list of records that came from the fixed file
     */
    Optional<List<Record>> findAllByFixedFileId(ObjectId fixedFileId);

    /**
     * Retrieves all the records that were parsed using a specific spec file from database
     * @param specFileId the id to check
     * @return list of records parsed using the spec file
     */
    Optional<List<Record>> findAllBySpecFileId(ObjectId specFileId);
}
