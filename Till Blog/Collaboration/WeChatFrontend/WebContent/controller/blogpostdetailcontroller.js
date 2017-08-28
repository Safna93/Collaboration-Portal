/**
 * BlogPostDetailController
 */
	
	app.controller('BlogPostDetailController',function($scope,$location,BlogService,$routeParams){
	var id1=$routeParams.id;
	
	console.log("-----> id----------->"+id1)
	
	$scope.blogPost=BlogPostService.getBlogPostById(id1)
	.then(function(response){
		$scope.blogPost=response.data
	},function(response){
		console.log(response.status)
		if(response.status==401)
			$location.path('/login')
	})
	})
	