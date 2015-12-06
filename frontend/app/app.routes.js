'use strict';


frontendApp.config(function ($routeProvider) {
    $routeProvider
      .when('/home', {
        templateUrl: 'app/components/home/homePageView.html'
        //controller: 'HomeCtrl',
        //controllerAs: 'home'
      })
      .when('/fixtures',{
        templateUrl: 'app/components/fixtures/fixturesPageView.html'
        //controller: 'FixturesCtrl',
        //controllerAs: 'fixtures'
      })
      .when('/teams',{
        templateUrl: 'app/components/teams/teams.view.html',
        controller: 'TeamsPageController',
        controllerAs: 'teamspagectrl'
      })
      .when('/rules', {
        templateUrl: 'app/components/rules/rulesView.html'
      })
      .when('/logout', {
        controller: 'LogoutController',
        templateUrl: 'app/components/login/login.view.html'
      })
      .when('/login', {
                controller: 'LoginController',
                templateUrl: 'app/components/login/login.view.html',
                controllerAs: 'vm'
            })
      .otherwise({
        redirectTo: '/home'
      });
  });