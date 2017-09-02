app.factory('BlogPostService',function($http){
	var blogPostService={};
	
	blogPostService.addBlogPost=function(blogPost){
		return $http.post("http://localhost:8087/WeChatBackend/saveblogpost",blogPost)
	}
	
	blogPostService.getBlogPostsWaitingForApproval=function(){
		return $http.get("http://localhost:8087/WeChatBackend/getblogposts/"+0)
	}
	
	blogPostService.getBlogPostsApproved=function(){
		return $http.get("http://localhost:8087/WeChatBackend/getblogposts/"+1)
	}
	blogPostService.getBlogPostById=function(id){
		return $http.get("http://localhost:8087/WeChatBackend/getblogpostbyid/"+id);
	}
	blogPostService.updateBlogPost=function(blogPost){
		return $http.put("http://localhost:8087/WeChatBackend/updateblogpost",blogPost);
	}
	blogPostService.addComment=function(blogComment){
		return $http.post("http://localhost:8087/WeChatBackend/addblogcomment",blogComment);
	}
	
	
	blogPostService.getBlogComments=function(blogPostId)
	{
		//console.log('getBlogComments() in BlogPostService')
		return $http.get("http://localhost:8087/WeChatBackend/getblogcomments/"+blogPostId)
	}
	
	
	
	return blogPostService;
})