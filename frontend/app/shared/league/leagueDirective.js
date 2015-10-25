angular.module('frontendApp')
	.directive('vidleaguetable',function(){
		return {
			restrict: 'E',
			scope: {
        name: '@',
        standings: '=standings'
      },
      /*link: function(scope, element, attrs){},*/
			templateUrl: '/app/shared/league/leagueView.html'
		};
});