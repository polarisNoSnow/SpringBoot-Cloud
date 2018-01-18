/**
 * creat by polaris on 20171218
 *
 */

var app = angular.module('polaris',['ngRoute']);
app.config(['$routeProvider', function($routeProvider){
    $routeProvider
    .when('/',{
    	template:'测试主页'
    })
    .when('/friend',{
    	templateUrl: 'modules/friend/friend.html',
    	controller : 'FriendController'
    })
    .when('/index',{
    	templateUrl: 'modules/index/index.html',
    	controller : 'IndexController'
    }) 
    .otherwise({redirectTo:'/'});
}]);