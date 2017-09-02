/**
 * BlogPostDetailController
 
	*/
	
app.controller('BlogPostDetailController',function($scope,$location,$routeParams,BlogPostService){
	
	var id=$routeParams.id
	$scope.showcomments=false
	
	
	$scope.blogPost=BlogPostService.getBlogPostById(id).then(function(response){
		$scope.blogPost=response.data;
		console.log(response.data)
	},function(response){
		console.log(response.status)
		if(response.status==401)
			$location.path('/login')
	
})

	

	//Accepting or rejectiing blog comment
	$scope.updateBlogPost=function(){
		BlogPostService.updateBlogPost($scope.blogPost).then(function(response){
			console.log(response.status)
			alert("updated successfully")
			$location.path('/getallblogs')
		},function(response){
			console.log(response.data)
			/*
			 * For unauthorized access, 401 -> redirect the user to login page
			 * For Exception , 500  -> redirect the user to updateprofile page
			 */
			if(response.status==401)
				$location.path('/login')
			
		})
	}
	
	
	//adding blog comments
	$scope.addComment=function(){
		$scope.blogComment.blogPost=$scope.blogPost;
		console.log("===========blogpost==============="+ $scope.blogPost.id);
		console.log($scope.blogComment)
		BlogPostService.addComment($scope.blogComment)
		.then(function(response){
			console.log(response.status);
			console.log(response.data);
			$scope.blogComment.body=''
		},function(response){
			console.log(response.status)
		})
		
	}
	//getting blog comments
	function getBlogComments(){
		BlogPostService.getBlogComments(id).then(function(response){
			$scope.blogComments=response.data
		},function(response){
			if(response.staus==401)
				$location.pat('/login')
				console.log(response.status)
		})
	}
	$scope.getComments=function(){
		$scope.showcomments=true;
	}
	getBlogComments()
	
	
	})
