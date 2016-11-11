var App = angular.module('controllers', []);

App.controller('AgenteCtrl', function($scope, $location, AgenteService,EnvioService, $route){
	$scope.agentes = [];
	$scope.notFound = false;
	AgenteService.list().then(function(data){
		$scope.agentes = data.data;
		console.log("",$scope.agentes);
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	
	$scope.agenteEditar = EnvioService.getParametro();
	console.log("editar",$scope.agenteEditar);
	
	//Deletar
	$scope.deletar = function(id){
		AgenteService.delete(id).then(function(data){
			console.log(data);
			$route.reload();
		});	
	}
	
	//Editar
	$scope.editar = function(item){
		$scope.agenteEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarAgente');
	}
	

	$scope.newAgente = {};
	
	//Criar
	$scope.criar = function(){
		AgenteService.create($scope.newAgente);
		$location.path('/');
	}
	
	

});