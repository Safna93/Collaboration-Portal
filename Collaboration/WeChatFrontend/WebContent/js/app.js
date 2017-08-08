/**
 * Angular JS module and routeprovider configuration 
 */
var app=angular.module("app",['ngRoute'])
app.config(function($routeProvider){
	$routeProvider
	.when('/home',{
		templateUrl:'views/home.html'
	})
	.when('/aboutus',{
		templateUrl:'views/aboutus.html'
	})
	.when('/register',{
		templateUrl:'views/registrationform.html',
		controller:'UserController'
	})
	.otherwise({
		templateUrl:'views/home.html'
	})
})