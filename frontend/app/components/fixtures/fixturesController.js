angular.module('frontendApp')
	   .controller('FixturesCtrl', ['jsonGetter', function(jsonGetter){
	   		var self = this;
    		jsonGetter('http://127.0.0.1:8080/sample_responses/rounds.json').success(function(data){
      			self.response = data;
    		});
	   }]);