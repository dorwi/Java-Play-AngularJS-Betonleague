angular.module('frontendApp')
	.directive('vidHome',['jsonGetter', function(){
		function HomeCtrl(jsonGetter){
		  	var self = this;
		  	
		    jsonGetter('http://shielded-castle-7285.herokuapp.com/home?seasonName=Betonleague%202015/2016&leagueName1=West&leagueName2=East&roundNumber2=1&roundNumber2=2').success(function(data){
		      self.response = data;
		    });
		}

		function Link( scope, element, attrs){}

		return {
			restrict: 'E',
      		scope: {
      		},
      		controller: ['jsonGetter', HomeCtrl],
      		controllerAs: 'home',
      		link: Link,
			templateUrl: '/app/components/home/homeTemplate.html'
		};

	   }]);