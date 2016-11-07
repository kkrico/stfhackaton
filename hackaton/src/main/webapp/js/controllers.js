var controllers = angular.module("controllers", []);

controllers.controller("HomeController", [ '$scope', '$http',
		function($scope, $http) {
			$scope.debug = false;
			$scope.title = 'Hello ';

			$scope.chamarController = function() {
				$http.get("service/home").success(function(data) {
					$scope.data = data;
					$scope.title += $scope.data.message;
				});
			}

			$scope.toggleDebug = function() {
				$scope.debug = !$scope.debug;
			};
		} ]);

controllers.controller("DenunciaController", [ '$scope', '$http',
		'denuncianteService', function($scope, $http, denuncianteService) {
			
			var listar = function(){
				denuncianteService.listarDenunciantes().then(
					function(resposta) {
						$scope.denunciantes = resposta.data;
					}, function error(reason) {
						alert(reason.status)
				});
			}
			
			listar();

			$scope.salvar = function() {
				denuncianteService.salvarDenunciante($scope.denunciante).then(
				function(resposta) {
					//alert(resposta.data);
					listar();
					$scope.denunciante = {};
				}, function error(reason) {
					alert(reason.status)
				});
			};
			
			$scope.consultar = function() {
				denuncianteService.consultarDenunciante($scope.denuncianteConsulta).then(
				function(resposta) {
					$scope.denunciantes = resposta.data;
				}, function error(reason) {
					alert(reason.status)
				});
			};
			
			$scope.editar = function(index){
				$scope.denunciante = $scope.denunciantes[index];
			}
			
			$scope.excluir = function(id) {
				denuncianteService.excluirDenunciante(angular.toJson(id)).then(
				function(resposta) {
					alert(resposta.data);
					listar();
					$scope.denunciante = {};
				}, function error(reason) {
					alert(reason.status)
				});
			};

		} ]);