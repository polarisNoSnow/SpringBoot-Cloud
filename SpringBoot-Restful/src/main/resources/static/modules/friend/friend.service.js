/**
 * creat by polaris 
 * 20171225
 * 友链服务
 */
app.service('friendService',function($http,requestService){
	//友链列表
	this.list = function(){
		$http.jsonp("http://localhost:9001/polaris/friends?callback=JSON_CALLBACK&name=tangyb","").then(function (response) {
			console.log(response.data.data);
		});
		return '123';
	}

	//测试
	this.test = function(message){
		return 'friendService提供服务：'+message;
	}

	this.listGet = function(){
		var data = requestService.HttpGet('http://127.0.0.1:9001/polaris/friends');
		console.log(data);
		return data;
	}
});