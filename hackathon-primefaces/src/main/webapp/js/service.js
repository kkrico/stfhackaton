var App = angular.module('services', []);

App.factory('Tipo', function($http, API){
	return {
		list: function(){
			return $http.get(API+'tipo');
		},
		create: function(item){
			return $http.post(API+'tipo', item);
		},
		update: function(item, id){
			return $http.put(API+'tipo/'+id, item);	
		}
	}
})


App.service('EnvioService', function($http){
	var parametro = {};

	  var addParametro = function(newObj) {
		  parametro = newObj;
	  };

	  var getParametro = function(){
	      return parametro;
	  };

	  return {
		  addParametro: addParametro,
		  getParametro: getParametro
	  };

})