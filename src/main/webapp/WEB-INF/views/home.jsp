<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html ng-app="medicalWeb">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="PT_2">
    <meta name="author" content="Patricia G.">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/font-awesome.min.css" rel="stylesheet">
    <link href="/assets/css/style.css" rel="stylesheet">
    <link href="/assets/css/autocomplete.css" rel="stylesheet">
    <link href="/css/angular-material.min.css" rel="stylesheet">
    <link href="/css/loading-bar.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="/assets/medicalweb.ico">
  </head>
  <body>
    <header ng-controller="navBarController as navCtrl">
      <nav role="navigation" class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
          <div class="navbar-header">
            <button type="button" data-toggle="collapse" data-target=".navbar-ex1-collapse" class="navbar-toggle"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
          </div>
          <div class="collapse navbar-collapse navbar-ex1-collapse"><a href="#inicio" class="navbar-brand"><img src="/assets/img/logo.png" style="max-width: 180px;position: relative;top: -60px;"></a>
            <ul ng-if="!navCtrl.logged" class="nav navbar-nav navbar-right">
              <li><a href="#inicio"> Inicio</a></li>
              <li><a href="#caracteristicas">Caracteristicas</a></li>
              <li><a href="#sistemas">Sistemas</a></li>
              <li><a href="#price-sec">Precios</a></li>
              <li><a href="#/registro">Subscripcion</a></li>
            </ul>
            <ul ng-if="navCtrl.logged" class="nav navbar-nav navbar-right">
              <li><a href="" ng-click="navCtrl.logout()" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-user fa-fw"></i>Mi Perfil</a>
                <ul class="dropdown-menu">
                  <li><a href="" ng-click="navCtrl.logout()"> Cerrar Sesion</a></li>
                </ul>
              </li>
            </ul>
            <!--block navbar-->
          </div>
        </div>
      </nav>
    </header>
    <div ng-view></div>
    <!--block content-->
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div id="social-icon"><a href="https://www.facebook.com/"><i class="fa fa-facebook fa-1x"></i></a></div>
        </div>
      </div>
    </div>
    <div id="footer" class="for-full-back">2016 www.medicalweb.com | Patricia G.</div>
    <script src="/assets/plugins/jquery-1.10.2.js"></script>
    <script src="/js/angular.min.js"></script>
    <script src="/js/angular-messages.min.js"></script>
    <script src="/js/angular-route.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/assets/plugins/jquery.parallax-1.1.3.js"></script>
    <script src="/js/angular-animate.min.js"></script>
    <script src="/js/angular-aria.min.js"></script>
    <script src="/js/angular-material.min.js"></script>
    <script src="/js/loading-bar.min.js"></script>
    <script src="/assets/js/custom.js"></script>
    <script src="/js/app.js">   </script>
    <script src="/js/app.constants.js"></script>
    <script src="/js/navbar.controller.js"></script>
    <script src="/js/common.directives.js"></script>
    <script src="/js/cps.service.js"></script>
    <script src="/js/autocomplete.js"></script>
    <script src="/js/home.controller.js"></script>
    <script src="/js/registro.controller.js"></script>
    <script src="/js/paciente.controller.js"></script>
    <script src="/js/home.services.js"></script>
    <script src="/js/registro.services.js"></script>
    <script src="/js/inventario.controller.js"></script>
    <script src="/js/inventario.services.js"></script>
    <script src="/js/registroClinica.controller.js"></script>
    <script src="/js/entidades.controller.js"></script>
    <script src="/js/entidades.services.js"></script>
    <script src="/js/app.routes.js"></script>
  </body>
</html>