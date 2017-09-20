/**
 * 
 */
app.factory('FriendService',function($http){
	var friendService={}
	
	friendService.listOfSuggestedUsers=function(){
	  return  $http.get("http://localhost:8085/WeChatBackend/getsuggestedusers")
	}
	friendService.friendRequest=function(toId){
		  return  $http.post("http://localhost:8085/WeChatBackend/friendRequest/"+toId)
		}
	
	friendService.listOfPendingRequests=function(toId){
		  return  $http.get("http://localhost:8085/WeChatBackend/getpendingrequests")
		}
	friendService.getUserDetails=function(fromId){
		  return  $http.get("http://localhost:8085/WeChatBackend/getuserdetails/"+fromId)
		}
	
	friendService.updatePendingRequest=function(pendingRequest){
		  return  $http.put("http://localhost:8085/WeChatBackend/updatependingrequest",pendingRequest)
		}
	friendService.listOfFriends=function(){
		return $http.get("http://localhost:8085/WeChatBackend/friendslist")
	}
	
	return friendService;
})
