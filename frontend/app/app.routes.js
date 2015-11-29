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
      .when('/rules', {
        templateUrl: 'app/components/rules/rulesView.html'
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

  run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
    function run($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
 
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }