package com.niit.dao;

import java.util.List;

import com.niit.model.BlogPost;

public interface BlogPostDAO {
void saveBlogPost(BlogPost blogPost);

List<BlogPost> getBlogPosts(int approved);

BlogPost getBlogPostById(int id);
}