package com.example.demo.service;

import com.example.demo.dto.Comment_FormDTO;
import com.example.demo.model.Comment_Form;
import com.example.demo.repository.Comment_FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Comment_FormService {

    private final Comment_FormRepository comment_FormRepository;

    @Autowired
    public Comment_FormService(Comment_FormRepository comment_FormRepository) {
        this.comment_FormRepository = comment_FormRepository;
    }

    // Method to create a new comment
    public Comment_FormDTO createComment(Comment_FormDTO commentFormDTO) {
        // Convert DTO to entity
        Comment_Form commentForm = new Comment_Form();
        commentForm.setTitle(commentFormDTO.getTitle());
        commentForm.setComment(commentFormDTO.getComment());

        // Save the new comment entity
        Comment_Form savedCommentForm = comment_FormRepository.save(commentForm);

        // Convert entity back to DTO
        return new Comment_FormDTO(savedCommentForm.getId(), savedCommentForm.getTitle(), savedCommentForm.getComment());
    }

    // Method to get all comments
    public List<Comment_FormDTO> getAllComments() {
        List<Comment_Form> comments = comment_FormRepository.findAll();
        return comments.stream().map(comment -> new Comment_FormDTO(comment.getId(), comment.getTitle(), comment.getComment())).collect(Collectors.toList());
    }

    // Method to save a comment (could be used for updating an existing comment)
    public Comment_FormDTO saveComment(Comment_FormDTO commentFormDTO) {
        Comment_Form commentForm = new Comment_Form();
        if (commentFormDTO.getId() != null) {
            commentForm.setId(commentFormDTO.getId()); // Assumes updating an existing comment if ID is present
        }
        commentForm.setTitle(commentFormDTO.getTitle());
        commentForm.setComment(commentFormDTO.getComment());
        Comment_Form savedComment = comment_FormRepository.save(commentForm);
        return new Comment_FormDTO(savedComment.getId(), savedComment.getTitle(), savedComment.getComment());
    }
}
