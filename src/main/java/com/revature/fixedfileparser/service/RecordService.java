package com.revature.fixedfileparser.service;

import com.revature.fixedfileparser.exception.NotFoundException;
import com.revature.fixedfileparser.model.Record;
import com.revature.fixedfileparser.repository.RecordRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing business logic for Record
 */
@Service
public class RecordService {
    private RecordRepository recordRepository;

    /**
     * Construct a new RecordService with the provided RecordRepository
     *
     * @param recordRepository the RecordRepository to be used for database operations
     */
    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    /**
     * Retrieves a list of all the records that came from a specific fixed file
     *
     * @param fixedFileId the id from where all the records came from
     * @return list of records
     * @throws NotFoundException if no record associated with the fixed file id was found
     */
    public List<Record> getRecordListByFixedFile(ObjectId fixedFileId) throws NotFoundException {
        return recordRepository.findAllByFixedFileId(fixedFileId)
                .orElseThrow(() -> new NotFoundException("No Record was found associated with the file id"));
    }

    /**
     * Retrieves a list of all the records that were parsed from a specific spec file
     *
     * @param specFileId the id of the spec file that was used to parse the records
     * @return list of records
     * @throws NotFoundException if no record associated with the spec file id
     */
    public List<Record> getRecordListBySpecFile(ObjectId specFileId) throws NotFoundException {
        return recordRepository.findAllBySpecFileId(specFileId)
                .orElseThrow(() -> new NotFoundException("No Record was found associated with the fixed file id"));
    }

    /**
     * Adds and creates a new Record
     *
     * @param fixedFileId the id from where all the records came from
     * @param specFileId the id of the spec file that was used to parse the records
     * @param keys string array representing variable name
     * @param values string array representing variable data
     * @return newly created Record
     */
    public Record addRecord(String fixedFileId, String specFileId, String[] keys, String[] values){
        // change from hex string to ObjectId
        ObjectId fixedFileObjectId = new ObjectId(fixedFileId);
        ObjectId specFileObjectId = new ObjectId(specFileId);
        // create new Record and save to database
        return recordRepository.save(new Record(fixedFileObjectId, specFileObjectId, keys, values));
    }

    //TODO method to take 2 arrays and create dictionary for
}
