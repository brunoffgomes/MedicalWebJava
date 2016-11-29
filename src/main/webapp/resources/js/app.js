'use strict'
angular.module("app.controllers",["ngMessages"]);
angular.module("app.services",[]);
angular.module("app.directives",[]);

angular.module("medicalWeb",[
,"app.controllers",'app.constants',"app.routes","app.services","app.directives","ngMaterial"
,"angular-loading-bar"
]).config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    $httpProvider.defaults.withCredentials = true;
    delete $httpProvider.defaults.headers.common["X-Requested-With"];
    $httpProvider.defaults.headers.common["Accept"] = "application/json";
    $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
  }
])
.run(run);


config.$inject = ["$locationProvider"]
function config($locationProvider){
  $locationProvider.html5Mode({ enabled: true,requireBase: false});
}


run.$inject = ['$rootScope', '$location', '$http'];
function run($rootScope, $location, $http) {
        $rootScope.logged = false;
        $rootScope.$on("logged", function(){
          if(!$rootScope.logged)
            $location.path('/');
          });
        }