angular.module('frontendApp')
	   .controller('FixturesCtrl', ['jsonGetter', function(jsonGetter){
	   		var self = this;
    		jsonGetter('https://shielded-castle-7285.herokuapp.com/rounds?seasonName=Betonleague%202015/2016&leagueName1=West&leagueName2=East').success(function(data){
      			self.response = data;
    		});
	   }]);