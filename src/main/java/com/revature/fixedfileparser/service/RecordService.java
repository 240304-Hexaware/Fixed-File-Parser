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

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<Record> getRecordListByFixedFile(ObjectId fixedFileId) throws NotFoundException {
        return recordRepository.findAllByFixedFileId(fixedFileId)
                .orElseThrow(() -> new NotFoundException("No Record was found associated with the file id"));
    }

    public List<Record> getRecordListBySpecFile(ObjectId specFileId) throws NotFoundException {
        return recordRepository.findAllBySpecFileId(specFileId)
                .orElseThrow(() -> new NotFoundException("No Record was found associated with the fixed file id"));
    }

    /**
     * Adds and creates a new Record
     *
     * @param fixedFileId
     * @param specFileId
     * @param keys
     * @param values
     * @return newly created Record
     */
    public Record addRecord(String fixedFileId, String specFileId, String[] keys, String[] values){
        // change from hex string to ObjectId
        ObjectId fixedFileObjectId = new ObjectId(fixedFileId);
        ObjectId specFileObjectId = new ObjectId(specFileId);
        // create new Record and save to database
        return recordRepository.save(new Record(fixedFileObjectId, specFileObjectId, keys, values));
    }
}
