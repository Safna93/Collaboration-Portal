/**
 * JobService
 */

app.factory('JobService',function($http){
	var jobService={}
	
	jobService.saveJob=function(job){
	  return  $http.post("http://localhost:8085/WeChatBackend/savejob",job)
	}
	jobService.getAllJobs=function(){
		 return  $http.get("http://localhost:8085/WeChatBackend/getalljobs")
	}
	jobService.getJobDetails=function(id){
		return $http.get("http://localhost:8085/WeChatBackend/getjobbyid/"+id)
	}
	return jobService;
})
