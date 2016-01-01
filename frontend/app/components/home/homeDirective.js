angular.module('frontendApp')
	.directive('vidHome',['jsonGetter', function(){
		function HomeCtrl(jsonGetter){
		  	var self = this;
 		    self.url = 'http://46.101.169.15:9000/home?seasonName=Betonleague%202015/2016&leagueName1=West&leagueName2=East&roundNumber1=6&roundNumber2=6'
 		    //self.url = 'http://shielded-castle-7285.herokuapp.com/home?seasonName=Betonleague%202015/2016&leagueName1=West&leagueName2=East&roundNumber1=5&roundNumber2=5'
		    jsonGetter(self.url).success(function(data){
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