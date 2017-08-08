/**
 * UserService
 */
app.factory('UserService',function($http){
	var userService={}; //instantiation
	var BASE_URL="http://localhost:8080/project2_backend"
	userService.registerUser=function(user){
		return $http.post(BASE_URL+"/registeruser",user)
	}
	userService.validateUser=function(user){
		return $http.post(BASE_URL+"/login",user)
	}
	
	return userService; //returning the instance
})
