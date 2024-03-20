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
    Optional<List<Record>> findAllByFixedFileId(ObjectId fixedFileId);

    Optional<List<Record>> findAllBySpecFileId(ObjectId specFileId);
}
