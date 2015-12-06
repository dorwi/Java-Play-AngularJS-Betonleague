angular.module('frontendApp')
	.directive('vidMatch',function(){

		function MatchController(AuthenticationService, FlashService, $http) {
        	var self = this;

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
	           $http.post('http://localhost:9000/updateMatch', self.match)
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