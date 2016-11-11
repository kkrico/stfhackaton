App.factory('InfracaoService', function($http, API){
	return {
		listGrafico: function() {
			return $http.get(API + 'infracoesDaniel/InfracoesUsuarioGrafico')
		},
		list: function(){
			return $http.get(API+'infracoesDaniel');
		},
		listLocalInfracoes: function(){
			return $http.get(API+'infracoes/local');
		},

		listTipoInfracoes: function(){
			return $http.get(API+'infracoes/tipo');
		},
		
		cadastra: function(infracao){
			console.log("cadastra infracao: ",infracao);
			return $http.get(API+'infracoes/cadastra/agente/'+ infracao.agente.idAgente + '/local/' +infracao.localInfracao.idLocalInfracao + '/tipo/' + infracao.tipoInfracao.idTipoInfracao );
			
		},
		
		create: function(item){
			console.log("to create: ", item);
			return $http.post(API+'agente', item);
		},
		update: function(item, id){
			return $http.put(API+'agente/'+id, item);	
		},
		delete: function(id){
			return $http.post(API+'agente/'+ id + '/delete');
		}
	}
})