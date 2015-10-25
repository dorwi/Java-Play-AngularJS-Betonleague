frontendApp.directive('vidheader',function(){
		return {
			restrict: 'E',
			scope: {
				name: '@',
				year: '@'
			},
			templateUrl: '/app/core/header/headerView.html',
		};
});
