'use strict';


frontendApp.config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'app/components/home/homeView.html',
        controller: 'HomeCtrl',
        controllerAs: 'home'
      })
      .when('/fixtures',{
        templateUrl: 'app/components/fixtures/fixturesView.html',
        controller: 'FixturesCtrl',
        controllerAs: 'fixtures'
      })
      .when('/rules', {
        templateUrl: 'app/components/rules/rulesView.html'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

/*
frontendApp.config(function($stateProvider, $urlRouterProvider){
      
      // For any unmatched url, send to /
      $urlRouterProvider.otherwise("/")
      
      $stateProvider
        .state('home', {
            url: '/',
            templateUrl: 'app/components/home/homeView.html',
            controller: 'HomeCtrl',
            controllerAs: 'home',
            cache: false

        })
          .state('fixtures', {
              url: "/fixtures",
              templateUrl: 'app/components/fixtures/fixturesView.html',
              controller: 'FixturesCtrl',
              controllerAs: 'fixtures',
              cache: false
          })
          
        .state('rules', {
            url: "/rules",
            templateUrl: 'app/components/rules/rulesView.html'
        })
    })
    */