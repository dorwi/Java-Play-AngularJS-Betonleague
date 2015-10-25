'use strict';

frontendApp.config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'app/components/home/homeView.html',
        controller: 'HomeCtrl',
        controllerAs: 'home'
      })
      .when('/rules', {
        templateUrl: 'app/components/rules/rulesView.html'
      })
      .otherwise({
        redirectTo: '/'
      });
  });