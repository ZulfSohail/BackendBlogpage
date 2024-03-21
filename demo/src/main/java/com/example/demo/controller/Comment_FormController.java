package com.example.demo.controller;

import com.example.demo.dto.Comment_FormDTO;
import com.example.demo.service.Comment_FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments") // Base path for all endpoints in this controller
@CrossOrigin // Allows cross-origin requests if needed, adjust according to your security requirements
public class Comment_FormController {

    private final Comment_FormService commentFormService;

    @Autowired
    public Comment_FormController(Comment_FormService commentFormService) {
        this.commentFormService = commentFormService;
    }

    // Endpoint to create a new comment
    @PostMapping
    public ResponseEntity<Comment_FormDTO> createComment(@RequestBody Comment_FormDTO commentFormDTO) {
        Comment_FormDTO createdComment = commentFormService.createComment(commentFormDTO);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all comments
    @GetMapping
    public ResponseEntity<List<Comment_FormDTO>> getAllComments() {
        List<Comment_FormDTO> comments = commentFormService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
