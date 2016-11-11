var App = angular.module('App', [
'ngRoute',
'controllers',
'services',
'ngSanitize', 
'ui.select',
'ui.event',
'ui.map'
]);

App.config(function($routeProvider){
	$routeProvider
	
	.when('/', {
		templateUrl: 'views/agente/agente.html',
		controller: 'AgenteCtrl'
	})
	
	.when('/createAgente', {
		templateUrl: 'views/agente/createAgente.html',
		controller: 'AgenteCtrl'
	})

	.when('/create', {
		templateUrl: 'views/create.html',
		controller: 'CreateCtrl'
	})

	.when('/editarAgente', {
		templateUrl: 'views/agente/editarAgente.html',
		controller: 'AgenteCtrl'
	})
	
	.when('/novaInfracao', {
		templateUrl: 'views/infracao/infracao.html',
		controller: 'InfracaoCtrl'
	})
});

App.value('API', 'http://localhost:8080/primefaces-app/service/');