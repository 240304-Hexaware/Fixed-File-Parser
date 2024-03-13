package com.revature.fixedfileparser.controller;

import com.revature.fixedfileparser.exception.AlreadyExistsException;
import com.revature.fixedfileparser.exception.NotFoundException;
import com.revature.fixedfileparser.model.User;
import com.revature.fixedfileparser.service.FixedFileService;
import com.revature.fixedfileparser.service.RecordService;
import com.revature.fixedfileparser.service.SpecificationFileService;
import com.revature.fixedfileparser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that defines REST endpoints and handles HTTP Requests
 */
@RestController
public class ParserController {

    private UserService userService;
    //private SpecificationFileService specificationFileService;
    //private FixedFileService fixedFileService;
    //private RecordService recordService;


    /**
     * Constructor with all fields
     *
     * @param userService Service class for managing business logic for User
     * @param specificationFileService Service class for managing business logic for SpecificationFile
     * @param fixedFileService Service class for managing business logic for FixedFile
     * @param recordService Service class for managing business logic for Record

    @Autowired
    public ParserController(UserService userService, SpecificationFileService specificationFileService, FixedFileService fixedFileService, RecordService recordService) {
        this.userService = userService;
        this.specificationFileService = specificationFileService;
        this.fixedFileService = fixedFileService;
        this.recordService = recordService;
    }
    */
    public ParserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong!";
    }

    // User authentication
    /**
     * POST /api/auth/register: Register a new user
     */
    @PostMapping("/api/auth/register")
    @ResponseStatus(HttpStatus.OK)
    public User register(@RequestParam("username") String username, @RequestParam("password") String password,
                         @RequestParam("role") String role) throws AlreadyExistsException {
        return userService.registerUser(username, password, role);
    }

    /**
     * POST /api/auth/login: Authenticate user login
     */
    @PostMapping("/api/auth/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam("username") String username, @RequestParam("password") String password) throws NotFoundException {
        return userService.loginUser(username, password);
    }

    // FixedFile
    /**
     * POST /api/fixed-files/upload: Upload a fixed-length file.
     */

    /**
     * GET /api/fixed-files/users/{userID}: Get all fixed files uploaded by a user
     */

    /**
     * GET /api/fixed-files/download/{fileID}: Download a copy of the original fixed-length file
     */

    // SpecificationFile
    /**
     * POST /api/specifications/upload: Upload a custom specification file
     */


    // Record

    //TODO rethink info taken in and uri
    /**
     * GET /api/records/fixed-files/{fileID}: Get all parsed records from a file grouped by file
     */

    //TODO same as above
    /**
     * GET /api/records/type/{fileID}: Get all parsed records from a file grouped by type
     */

    /**
     * GET /api/records/download/{fileID}: Download a JSON representation of all records from a file.
     */

    /**
     * Exception handler method to handle NotFoundException
     *
     * @param ex The NotFoundException object that was thrown
     * @return A string representing the error message
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String queryNotFound(NotFoundException ex){
        //TODO change to log message
        System.out.println("NotFoundException occurred: " + ex.getMessage());
        return ex.getMessage();
    }

    /**
     * Exception handler method to handle AlreadyExistsException
     *
     * @param ex The AlreadyExistsException object that was thrown
     * @return A string representing the error message
     */
    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleAlreadyExistsException(AlreadyExistsException ex) {
        //TODO change to log message
        System.out.println("AlreadyExistsException occurred: " + ex.getMessage());
        return ex.getMessage();
    }




}
