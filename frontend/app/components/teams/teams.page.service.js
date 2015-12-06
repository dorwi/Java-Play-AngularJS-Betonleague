(function () {
    'use strict';
 
    angular
        .module('frontendApp')
        .factory('TeamsPageService', TeamsPageService);
 
    TeamsPageService.$inject = ['$http'];
    function TeamsPageService($http) {
        var service = {};
 
        service.showTeam = "";
        service.setTeam = setTeam;
        return service; 

        function setTeam(team){
            console.log(team);
            service.showTeam = team.id;
        }
    }
 
})();