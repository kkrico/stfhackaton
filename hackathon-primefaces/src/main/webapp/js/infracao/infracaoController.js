App.controller('InfracaoCtrl',
		function($scope, InfracaoService, AgenteService) {

			$scope.infracoes = [];
			$scope.agentes = [];
			$scope.localInfracoes = [];
			$scope.tipoInfracoes = [];
			$scope.infracao = {};
			$scope.infracao.agente = {};
			$scope.infracao.localInfracao = {};
			$scope.infracao.tipoInfracao = {};
			$scope.endereco = '';

			InfracaoService.list().then(function(data) {
				debugger;
				$scope.infracoes = data.data;
				console.log("data", $scope.agentes);
				if (data.data.length == 0) {
					$scope.notFound = true;
				}
			}, function(data) {
				console.log("data", data);
			});

			InfracaoService.listLocalInfracoes().then(function(data) {
				$scope.localInfracoes = data.data;
				console.log("local infracoes data:", $scope.localInfracoes);
				if (data.data.length == 0) {
					$scope.notFound = true;
				}
			}, function(data) {
				console.log("data", data);
			});

			$scope.setLocal = function(local) {
				console.log("calld set local");
				console.log("latitude:", local);
				$scope.setAddres(local.latitude, local.longitude);
				geoCode(local.latitude, local.longitude);

			}

			InfracaoService.listTipoInfracoes().then(function(data) {
				$scope.TipoInfracoes = data.data;
				console.log("tipo de infracoes data:", $scope.localInfracoes);
				if (data.data.length == 0) {
					$scope.notFound = true;
				}
			}, function(data) {
				console.log("data", data);
			});

			$scope.cadastra = function() {
				InfracaoService.cadastra().then(function(data) {
					// $scope.TipoInfracoes = data.data;
					console.log("sucesso:", data);
					if (data.data.length == 0) {
						$scope.notFound = true;
					}
				}, function(data) {
					console.log("data", data);
				});
			}

			$scope.salvar = function() {
				debugger;
				console.log("salvar: ", $scope.infracao);
				InfracaoService.cadastra($scope.infracao).then(function(data) {
					console.log("retorno:", data);
				}, function(err) {

				});

			}

			var vm = this;

			$scope.lat = 0;
			$scope.lng = 0;
			$scope.result = '';

			$scope.teste = function() {
				console.log("chamou");
			}

			var newMap = new google.maps.LatLng(-15.7942, -47.8821);

			$scope.getCurrentLocation = function() {
				if (navigator.geolocation) {
					navigator.geolocation
							.getCurrentPosition(function(position) {
								$scope.lat = position.coords.latitude;
								$scope.lng = position.coords.longitude;
								$scope.setAddres($scope.lat, $scope.lng)
								console.info("Position: " + $scope.lat + " "
										+ $scope.lng);
							})
				}
			};

			$scope.mapOptions = {
				center : newMap,
				zoom : 15,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};

			$scope.onMapIdle = function() {
				console.info("====> called onMapIdle")
				if ($scope.myMarkers === undefined) {
					var marker = new google.maps.Marker({
						map : $scope.myMap,
						draggable : true,
						position : newMap
					});
					google.maps.event.addListener(marker, 'dragend', function(
							evt) {
						$scope.setAddres(evt.latLng.lat().toFixed(3),
								evt.latLng.lng().toFixed(3));

					});
					$scope.myMarkers = [ marker, ];
				}
			};

			$scope.setAddres = function(lat, lng) {
				console.info("====> set addres " + lat, lng)
				$scope.lat = lat;
				$scope.lng = lng;
			}

			function geoCode(lat, lng) {
				console.log("getCode: " + lat + " " + lng);
				var geocoder = new google.maps.Geocoder();
				var latlng = new google.maps.LatLng(lat, lng);
				geocoder.geocode({
					'latLng' : latlng
				}, function(results, status) {
					if (status == google.maps.GeocoderStatus.OK) {
						if (results[1]) {
							console.log(results[1].formatted_address);
							$scope.endereco = results[1].formatted_address;
						} else {
							$scope.endereco = 'Ops, cidade não encontrada';
						}
					} else {
						console.log('Geocoder failed due to: ' + status);
						$scope.endereco = 'Mapa não caregado';

					}
				});
			}

			$scope.$watchGroup([ 'lat', 'lng' ], function(newValues, oldValues,
					scope) {
				geoCode(newValues[0], newValues[1]);
			});

			$scope.labels = InfracaoService.listGrafico().then(function(data) {
				debugger;
			});
			  $scope.data = [300, 500, 100];
		});