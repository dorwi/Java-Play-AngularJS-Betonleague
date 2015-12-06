angular.module('frontendApp')
	.directive('vidTeam',function(){

		function TeamController($http, TeamsPageService) {
        	var self = this;

          self.isFull = function(){
            return self.full;
          }

          self.isShow = function(){
            return self.team.id == TeamsPageService.showTeam;
          }

          self.toggle = function(){
            TeamsPageService.setTeam(self.team);
          }
    	}

		return {
			restrict: 'EA',
			transclude: true,
			scope: {
        		team: '=team',
            full: '=full'
      },
      controller: ['$http','TeamsPageService', TeamController],
     	controllerAs: 'teamctrl',
     	bindToController: true,
			templateUrl: '/app/components/teams/team/team.template.html'
		};
});