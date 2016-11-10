App.controller('AgenteCtrl', function($scope, AgenteService, $route,$routeParams,$location,EnvioService){
	$scope.agente = [];
	$scope.agenteEditar = {};

	$scope.notFound = false;
	AgenteService.list().then(function(data){
		$scope.agente = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	$scope.agenteEditar = EnvioService.getParametro();
	
	$scope.deletar = function(id){
		debugger;
		AgenteService.delete(id).then(function(data){
			debugger;
			$route.reload();
		});	
	}
	
	$scope.editar = function(item){
		$scope.agenteEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarAgente');
	}
	
	$scope.adicionar = function(item) {
		$scope.agenteEditar = {};
		EnvioService.addParametro(item);
		$location.path('/create');
	}

	$scope.atualizar = function(item){
		AgenteService.update(item, item.idAgente).then(function(data){
				$location.path('/');
			});
	}
	
	$scope.criar = function(item) {
		AgenteService.create(item).then(function(data) {
			debugger;
			$location.path('/');
		});
	}
	
});