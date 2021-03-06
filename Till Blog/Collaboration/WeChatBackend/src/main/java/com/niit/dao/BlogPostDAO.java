package com.niit.dao;

import java.util.List;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;

public interface BlogPostDAO {
void saveBlogPost(BlogPost blogPost);

List<BlogPost> getBlogPosts(int approved);

BlogPost getBlogPostById(int id);
void updateBlogPost(BlogPost blogpost);
void addBlogComment(BlogComment blogComment);
List<BlogComment> getAllBlogComments(int blogPostId);


}