package com.revature.fixedfileparser.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Class that models an User
 */
@Document("user")
public class User {

    /**
     * An id for this User
     */
    @Field("_id")
    @MongoId(FieldType.OBJECT_ID)
    private ObjectId user_id;

    /**
     * A username for this User (must be unique and not blank)
     */
    private String username;

    /**
     * A password for this User (must be over 4 characters)
     */
    private String password;

    private String role;

    public User(){}

    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
    }

    public ObjectId getUser_id() {
        return user_id;
    }

    public void setId(ObjectId id){
        this.user_id = id;
    }







}
