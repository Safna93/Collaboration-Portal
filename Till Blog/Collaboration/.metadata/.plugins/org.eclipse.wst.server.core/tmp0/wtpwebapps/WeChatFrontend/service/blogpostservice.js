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
		console.log("--------")
		return $http.get("http://localhost:8087/WeChatBackend/getblogpostbyid/"+id)
	}
	return blogPostService;
}())