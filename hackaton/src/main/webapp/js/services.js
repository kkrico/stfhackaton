var factorys = angular.module("factorys", []);

factorys.factory("denuncianteService", [ '$http', function($http) {

	var denuncianteService = {};
	
	denuncianteService.salvarDenunciante = function(denunciante) {
		return $http.post("service/denunciantes", denunciante);
	};
	
	denuncianteService.consultarDenunciante = function(denunciante) {
		return $http.post("service/denunciantes/consultar", denunciante);
	};
	
	denuncianteService.excluirDenunciante = function(id) {
		return $http.delete('service/denunciantes/' + id, {params: {id: id}});
	};
	
	denuncianteService.listarDenunciantes = function() {
		return $http.get("service/denunciantes");
	};

	return denuncianteService;
} ]);
