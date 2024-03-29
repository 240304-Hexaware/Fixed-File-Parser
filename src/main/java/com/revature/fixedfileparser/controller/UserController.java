package com.revature.fixedfileparser.controller;

import com.revature.fixedfileparser.exception.AlreadyExistsException;
import com.revature.fixedfileparser.exception.NotFoundException;
import com.revature.fixedfileparser.model.User;
import com.revature.fixedfileparser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that defines REST endpoints and handles HTTP Requests
 */
@RestController
@RequestMapping("/api/auth")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Register a new user
     * POST /api/auth/register
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public User register(@RequestParam("username") String username, @RequestParam("password") String password,
                         @RequestParam("role") String role) throws AlreadyExistsException {
        return userService.registerUser(username, password, role);
    }

    /**
     * Authenticate user login
     * POST /api/auth/login
     */
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam("username") String username, @RequestParam("password") String password) throws NotFoundException {
        return userService.loginUser(username, password);
    }

    //Exception Handlers
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String queryNotFound(NotFoundException e) {
        //TODO: change this out for a log message
        System.out.println(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String addAlreadyExists(AlreadyExistsException e) {
        //TODO: change this out for a log message
        System.out.println(e.getMessage());
        return e.getMessage();
    }
}
