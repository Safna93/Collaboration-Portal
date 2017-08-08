
/**
 * UserController
 */
app.controller('UserController',function(UserService,$scope,$location){
	$scope.user={}
	
	$scope.registerUser=function(){
		UserService.registerUser($scope.user).then(function(response){
			$scope.message="Registered successfully.. please login again"
			$location.path('/login')
		},function(response){
			console.log(respone.status)
			console.log(response.data)
			$scope.error=response.data
			$location.path('/register')
		})
	}
	
})