angular.module('frontendApp')
	.directive('vidMatch',function(){

		function MatchController(AuthenticationService, FlashService, $http) {
        	var self = this;
          self.url = 'http://46.101.169.15:9000/updateMatch'
          //self.url = 'https://shielded-castle-7285.herokuapp.com/updateMatch';
          //self.url = 'http://localhost:9000/updateMatch';

	        self.isAdmin = function() {
	        	//console.log(AuthenticationService.isAdmin());
    	      return AuthenticationService.isAdmin();
        	}

          self.notAdminAndPlayed = function() {
            //console.log(AuthenticationService.isAdmin());
            return !self.isAdmin() && self.match.played;
          }

          self.notAdminAndNotPlayed = function() {
            //console.log(AuthenticationService.isAdmin());
            return ((!self.isAdmin()) && (!self.match.played));
          }

	        self.submit = function() {
	           $http.post(self.url, self.match)
                    .success(function (response) {
                        console.log(response)
                    });        	
           }
    	}

		return {
			restrict: 'EA',
			transclude: true,
			scope: {
        		match: '=match'
        	},
      		/*link: function(scope, element, attrs){},*/
      		controller: ['AuthenticationService','FlashService','$http', MatchController],
     		controllerAs: 'matchctrl',
     		bindToController: true,
			templateUrl: '/app/shared/match/match.template.html'
		};
});