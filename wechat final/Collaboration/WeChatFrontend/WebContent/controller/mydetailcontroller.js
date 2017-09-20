/**
 * 
 */
app.controller('MyDetailController',function($scope,$location,MyService,$routeParams){
	var fromId=$routeParams.fromId

	
		MyService.getMyDetails(fromId).then(function(response){
			$scope.user=response.data;
		
		},function(response){
			console.log(response.status)
			if(response.status==401)
				
				$location.path('/login')
				console.log(response.status)
			})
	})