function RegistroServices ($http,constants) {
  this.registroAdministrador = function(administrador) {
    return $http({
        method: 'POST',
        url: constants.url + '/registro/registroAdministrador',
        data : administrador
      });
  }

  this.registroAdministradorCE = function(administradorCE) {
    return $http({
        method: 'POST',
        url: constants.url + '/registro/registroAdministradorCe',
        data : administradorCE
      });
  }
  this.registroClinica = function(clinica) {
    return $http({
        method: 'POST',
        url: constants.url + '/registro/registroClinica',
        data : clinica
      });
  }

  this.registroDoctor = function(doctor) {
    return $http({
        method: 'POST',
        url: constants.url + '/registro/registroDoctor',
        data : doctor
      });
  }
  this.registroEnfermero = function(enfermero) {
    return $http({
        method: 'POST',
        url: constants.url + '/registro/registroEnfermero',
        data : enfermero
      });
  }
  this.registroFarmacologo = function(farmacologo) {
    return $http({
        method: 'POST',
        url: constants.url + '/registro/registroFarmacologo',
        data : farmacologo
      });
  }

  this.registroLaboratorista = function(laboratorista) {
    return $http({
        method: 'POST',
        url: constants.url + '/registro/registroLaboratorista',
        data : laboratorista
      });
  }
}

RegistroServices.$inject =  ["$http","constants"]
angular.module("app.services").service('RegistroServices', RegistroServices)
