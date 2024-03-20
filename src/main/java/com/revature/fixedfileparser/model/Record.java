package com.revature.fixedfileparser.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Class that models a record parsed from
 * a fixed file
 */
@Document("record")
public class Record {
    @Field("_id")
    @MongoId(FieldType.OBJECT_ID)
    private ObjectId recordId;

    @Field("fixedFileId")
    private ObjectId fixedFileId;

    @Field("specFileId")
    private ObjectId specFileId;

    @Field("keys")
    private String[] keys;
    @Field("values")
    private String[] values;

    /**
     * No arg constructor
     */
    public Record() {
    }

    /**
     * Constructor with all args
     *
     * @param recordId
     * @param fixedFileId
     * @param specFileId
     * @param keys
     * @param values
     */
    public Record(ObjectId recordId, ObjectId fixedFileId, ObjectId specFileId,
                  String[] keys, String[] values) {
        this.recordId = recordId;
        this.fixedFileId = fixedFileId;
        this.specFileId = specFileId;
        this.keys = keys;
        this.values = values;
    }

    /**
     * Constructor with recordId generated
     *
     * @param fixedFileId
     * @param specFileId
     * @param keys
     * @param values
     */
    public Record(ObjectId fixedFileId, ObjectId specFileId, String[] keys, String[] values) {
        this.fixedFileId = fixedFileId;
        this.specFileId = specFileId;
        this.keys = keys;
        this.values = values;
    }
}
