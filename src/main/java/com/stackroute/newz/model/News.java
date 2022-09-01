package com.stackroute.newz.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/* 
 * Annotate the class with @Component annotation. 
 * @Component annotation is used to crete singleton instance of of the class
 *
 */


/*
 * The class "News" will be acting as the data model for the News data in the ArrayList.
 */
@Component
public class News {
	
	/*
	 * This class should have five fields (newsId, title, author,
	 * description, content and publishedAt). This class should also contain the getters and
	 * setters for the fields. The value of publishedAt should not be accepted from
	 * the user but should be always initialized with the system date
	 */
    

	private int newsId;
	private String title;
	private String author;
	private String description;
	private String content;
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime publishedAt;
	
    public News() {
    	/* default constructor */
    }
    /* Override the toString() method */
    @Override
    public String toString() {
        return null;
    }


	public int getNewsId() {
		return newsId;
	}


	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}


	public void setPublishedAt(LocalDateTime localDateTime) {
		this.publishedAt = localDateTime;
	}
}
