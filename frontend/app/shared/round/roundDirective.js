angular.module('frontendApp')
	.directive('vidround',function(){
		return {
			restrict: 'E',
			scope: {
        		name: '=name',
        		matches: '=matches'
      		},
      		/*link: function(scope, element, attrs){},*/
			templateUrl: '/app/shared/round/roundView.html'
		};
});