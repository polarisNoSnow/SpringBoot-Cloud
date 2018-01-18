/**
 * Created by 北辰不落雪 on 2017/12/26.
 */
app.service('requestService',function($http,$q){
    var deferred = $q.defer();
    /*get请求*/
    this.HttpGet = function(url){
        $http({
            method: 'GET',
            url: url
        }).then(function successCallback(response) {
            // 请求成功执行代码
            deferred.resolve(response.data);
        }, function errorCallback(response) {
            // 请求失败执行代码
            alert("请求出错！");
            console.log(response.data);
        });
        return deferred.promise;
    }
    /*post请求*/
    this.HttpPost = function(url){
        $http({
            method: 'GET',
            url: url
        }).then(function successCallback(response) {
            // 请求成功执行代码
            deferred.resolve(response.data);
        }, function errorCallback(response) {
            // 请求失败执行代码
            alert("请求出错！");
            console.log(response.data);
        });
        return deferred.promise;
    }

    /*跨域请求*/
    this.HttpJsonp = function(url){
        $http.jsonp(url+"?callback=JSON_CALLBACK","").then(function (response) {
            deferred.resolve(response.data);
        });
        return deferred.promise;
    }
});