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
    <title>Registra tu Cl�nica</title>
  </head>
  <body>
    <header ng-controller="navBarController as navCtrl">
      <nav role="navigation" class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
          <div class="navbar-header">
            <button type="button" data-toggle="collapse" data-target=".navbar-ex1-collapse" class="navbar-toggle"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
          </div>
          <div class="collapse navbar-collapse navbar-ex1-collapse"><a href="#inicio" class="navbar-brand"><img src="/assets/img/logo.png" style="max-width: 180px;position: relative;top: -60px;"></a>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="#inicio">INICIO</a></li>
              <li><a href="#caracteristicas">CARACTERISTICAS</a></li>
              <li><a href="#sistemas">SISTEMAS</a></li>
              <li><a href="#price-sec">PRECIOS</a></li>
              <li><a href="/templates/registro.html">SUSCRIBIRSE</a></li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
    <!--div(ng-view)-->
    <div id="inicio" ng-controller="homeController as homeCtrl">
      <div class="container">
        <div class="row">
          <div class="col-md-9 col-sm-12">
            <h1 class="head-main">Administraci�n de la Salud</h1><span class="head-sub-main">En un Click</span>
            <!--
            <div class="head-last">
            Lorem ipsum dolorLorem ipsum dolorLorem ipsum dolor
            </div>
            -->
          </div>
          <!-- *************************************LOG IN**************************************-->
          <div class="col-md-3 col-sm-12">
            <div class="div-trans text-center">
              <h3>LOG IN </h3>
              <form name="form" novalidate ng-submit="homeCtrl.login()">
                <div class="col-md-12 col-sm-12">
                  <div class="form-group">
                    <input type="text" required="required" placeholder="User" ng-model="user.username" name="user" class="form-control">
                  </div>
                </div>
                <div class="col-md-12 col-sm-12">
                  <div class="form-group">
                    <input type="password" required="required" placeholder="Password" ng-model="user.password" name="password" class="form-control">
                  </div>
                </div>
                <input type="checkbox">Remember me
                <div class="form-group">
                  <button type="submit" class="btn btn-success">Login</button>
                </div>
              </form>
            </div>
          </div>
        </div>
        <!-- *************************************hasta aqui***************************************-->
      </div>
    </div>
    <!-- End Header section-->
    <section id="Parallax-one">
      <div class="container">
        <!-- AQUI IVA EL DIV-->
        <!-- *****************************************INICIO***************************************************-->
        <div class="row text-center">
          <div class="col-md-8 col-md-offset-2">
            <h2>�Software personalizado de acuerdo a sus  necesidades</h2>
            <h4><i>Plataforma desarrollada en colaboracion con profesionales en �reas de tecnolog�as de la informaci�n,</i>
              <!-- <img src="assets/img/logo.png" width="80" height="80">--><strong>Medical Web</strong><i>ayuda en las tareas de gesti�n de informaci�n cl�nica de manera eficiente, segura y siempre accesible.</i>
            </h4>
          </div>
        </div>
      </div>
    </section>
    <!-- *************************************CARACTERISTICAS***************************************-->
    <section id="caracteristicas">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-8 col-md-offset-2">
            <h2>Caracter�sticas</h2>
          </div>
        </div>
        <div class="row text-center space-pad">
          <div class="col-md-4 col-sm-4">
            <div><i class="fa fa-folder-open fa-4x main-color"></i>
              <h3>Expedientes</h3>
              <p>Accede a el historial cl�nico de tus pacientes a cualquier hora y en cualquier parte del mundo.</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-4">
            <div><i class="fa fa-flask fa-4x main-color"></i>
              <h3>Resultados en L�nea</h3>
              <p>Disponibilidad de resultados de analisis y diagn�stico de sus pacientes en l�nea.</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-4">
            <div><i class="fa fa-lock fa-4x main-color"></i>
              <h3>Confiabilidad</h3>
              <p>Respaldados por la seguridad de Microfost Azure, con las mas avanzadas medidas de seguridad.</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-4">
            <div><i class="fa fa-users fa-4x main-color"></i>
              <h3>F�cil de usar</h3>
              <p>Sistema amigable, f�cil de utilizar. Moderniza tu cl�nica con un desarrollo pensado en los usuarios.</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-4">
            <div><i class="fa fa-cloud fa-4x main-color"></i>
              <h3>Cloud Computing</h3>
              <p>Tecnolg�a de internet que permite compartir y acceder a informacion v�a remota a cualquier hora.</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-4">
            <div><i class="fa fa-mobile fa-4x main-color"></i>
              <h3>Accesibilidad</h3>
              <p>La informaci�n de su cl�nica y pacientes disponible desde cualquier dispositivo m�vil con acceso a internet.</p>
            </div>
          </div>
        </div>
        <!-- **************************************SISTEMAS***************************************-->
        <section id="sistemas">
          <div class="row text-center">
            <div class="col-md-6 col-sm-6">
              <h2>Sistema Modular</h2><i>Brindamos la posibilidad de configurar el software tantas veces lo requiera.</i><strong>Medical Web</strong><i>
                cuenta con los m�dulos de Farmacia, Laboratorio y Consulta Externa, de este modo puede
                configurar el sistema de acuerdo a los servicios que brinde en su unidad m�dica.</i>
            </div>
            <div class="col-md-6 col-sm-6">
              <div class="panel panel-default">
                <div class="panel-body">
                  <ul style="background-color: #ECECEC;" class="nav nav-pills">
                    <li><a href="#settings-pills" data-toggle="tab">Sistema</a></li>
                    <li class="active"><a href="#home-pills" data-toggle="tab">Consulta Externa</a></li>
                    <li><a href="#profile-pills" data-toggle="tab">Farmacia</a></li>
                    <li><a href="#messages-pills" data-toggle="tab">Laboratorio</a></li>
                  </ul>
                  <div class="tab-content">
                    <div id="home-pills" class="tab-pane fade active in">
                      <h4>Administraci�n</h4>
                      <p>Este m�dulo permitira una administracion de pacintes, personal e informacion referente a la cl�nica.</p>
                    </div>
                    <div id="profile-pills" class="tab-pane fade">
                      <h4>Expendio de medicamentos</h4>
                      <p>Este m�dulo permitir� la administracion de medicamentos asi como un correcto inventario de la unidad de farmacia.</p>
                    </div>
                    <div id="messages-pills" class="tab-pane fade">
                      <h4>Ex�menes m�dicos</h4>
                      <p>La implementacion de �ste m�dulo permitir� tener un control de las solicitudes de de ex�menes m�dicos as� como de sus respectivos resultados.</p>
                    </div>
                    <div id="settings-pills" class="tab-pane fade">
                      <h4>Configuraci�n</h4>
                      <p>El sistema podr� configurarse, de este modo el precio ser� de acuerdo a lo que se utilice.</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </section>
    <!-- End Services Section-->
    <!-- parallax one-->
    <!-- *********************************************************PRECIOS*************************************************************-->
    <!-- ./parallax one-->
    <!-- Pricing Section-->
    <section id="price-sec" ng-controller="homeController as homeCtrl">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-8 col-md-offset-2">
            <h2>Precios</h2>
            <h4><strong>
                Tenemos el objetivo de ayudar a los m�dicos a ejecutar mejores pr�cticas, somos empresa liider em proveer software y servicios
                de TI aplicados a la Salud, basados en Tecnolog�as de la Nube.</strong></h4>
          </div>
        </div>
        <div class="row text-center">
          <ng-repeat ng-repeat="modulo in homeCtrl.modulos">
            <div ng-click="vm.toogle(modulo)" class="col-md-4 col-sm-6">
              <ul ng-class="{'plan-active': modulo.selected }" class="plan">
                <li class="plan-head head-active">{{modulo.title}}</li>
                <li class="main-price">{{modulo.price | currency: "MXN$ ": 2}} / Mes</li>
                <li><strong>{{modulo.description}}</strong></li>
              </ul>
            </div>
          </ng-repeat>
        </div>
      </div>
    </section>
    <!-- End Pricing Section-->
    <!-- *********************************************************ULTIMO/SUSCRIPCION************************************************************-->
    <!-- parallax two-->
    <section id="Parallax-two">
      <div class="container">
        <section id="contact-sec">
          <div class="row text-center">
            <div class="col-md-8 col-md-offset-2">
              <h2><i class="fa fa-pencil-square-o fa-3x"></i>�SUSCRIPCI�N</h2>
              <h4><strong>Medical Web</strong><i>La opci�n de acuerdo a sus necesidades</i></h4>
              <!-- ****************************SUSCRIPCION***********************-->
              <div class="text-center">
                <form>
                  <div class="col-md-12 col-sm-12">
                    <div class="form-group">
                      <input type="text" required="required" placeholder="Nombre:" class="form-control">
                    </div>
                  </div>
                  <div class="col-md-12 col-sm-12">
                    <div class="form-group">
                      <input type="text" required="required" placeholder="Apellidos:" class="form-control">
                    </div>
                  </div>
                  <div class="col-md-12 col-sm-12">
                    <div class="form-group">
                      <input type="text" required="required" placeholder="Email:" class="form-control">
                    </div>
                  </div>
                  <div class="col-md-12 col-sm-12">
                    <div class="form-group">
                      <input type="text" required="required" placeholder="Cargo:" class="form-control">
                    </div>
                  </div>
                  <div class="col-md-12 col-sm-12">
                    <div class="form-group">
                      <input type="text" required="required" placeholder="Usuario:" class="form-control">
                    </div>
                  </div>
                  <div class="col-md-12 col-sm-12">
                    <div class="form-group">
                      <input type="text" required="required" placeholder="Contrase�a:" class="form-control">
                    </div>
                  </div>
                  <div class="form-group">
                    <button type="submit" class="btn btn-success">Continuar</button>
                  </div>
                </form>
              </div>
            </div>
            <!-- ./hasta aqui***************************************---->
          </div>
        </section>
      </div>
    </section>
    <!-- ./parallax two-->
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
    <script src="/js/app.routes.js"></script>
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
  </body>
</html>