var app = angular.module('app', [ 'ngRoute', 'controllers','factorys' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'partials/home.html',
		controller : 'HomeController'
	}).when('/listarDenuncias', {
		templateUrl : 'partials/denuncias.html',
		controller : 'DenunciaController'
	}).otherwise({
		redirectTo : '/'
	});
} ]);