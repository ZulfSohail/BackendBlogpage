package com.example.demo.dto;




	public class Comment_FormDTO {

	    private Long id;
	    private String comment;
	    private String title;

	    // Default constructor
	    public Comment_FormDTO() {}

	    // Constructor to initialize fields
	    public Comment_FormDTO(Long id, String title, String comment) {
	        this.id = id;
	        this.title = title;
	        this.comment = comment;
	    }

	    // Getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getComment() {
	        return comment;
	    }

	    public void setComment(String comment) {
	        this.comment = comment;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }
	}


