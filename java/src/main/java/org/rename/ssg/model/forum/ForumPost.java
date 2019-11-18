package org.rename.ssg.model.forum;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


public class ForumPost {
	private Long id;
	
	@NotBlank(message="Username is required")
    @Size(max=20, message="Username can not be over {max} characters")
	private String username;
	
	@Size(min=2, max=200, message="Subject must be at least {min} characters and not exceed {max} characters.")
	private String subject;
	
	@NotBlank(message="Forum post text is required")
	private String message;
	
	
	private LocalDateTime datePosted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(LocalDateTime datePosted) {
		this.datePosted = datePosted;
	}
}
