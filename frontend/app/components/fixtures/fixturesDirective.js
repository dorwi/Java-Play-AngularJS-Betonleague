angular.module('frontendApp')
	.directive('vidFixtures',['jsonGetter', function(){
		function FixturesCtrl(jsonGetter){
	   		var self = this;
			//self.url = 'https://shielded-castle-7285.herokuapp.com/rounds?seasonName=Betonleague%202015/2016&leagueName1=West&leagueName2=East'	   		
     		self.url = 'http://localhost:9000/rounds?seasonName=Betonleague%202015/2016&leagueName1=West&leagueName2=East'	   		

    		jsonGetter(self.url).success(function(data){
//      			console.log(data);
      			self.response = data;
    		});	
		}


		function Link( scope, element, attrs){}

		return {
			restrict: 'E',
			scope: {
      		},
      		controller: ['jsonGetter', FixturesCtrl],
      		controllerAs: 'fixtures',
      		link: Link,
			templateUrl: '/app/components/fixtures/fixturesTemplate.html'
		};

	   }]);