angular.module('frontendApp')
	.directive('vidmatch',function(){
		return {
			restrict: 'E',
			scope: {
        		mymatch: '=mymatch'
        	},
      		/*link: function(scope, element, attrs){},*/
			templateUrl: '/app/shared/match/matchView.html'
		};
});