/**
 * creat by polaris 
 * 20171218
 */
app.controller("FriendController",function($scope,friendService,$http){
	friendService.listGet(function(data){
		console.log(data);
		$scope.description=friendService.test("本地服务ok，后台服务：")+data.data;
    })
});