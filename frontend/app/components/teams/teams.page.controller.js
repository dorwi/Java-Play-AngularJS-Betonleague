(function () {
    'use strict';

    angular
        .module('frontendApp')
        .controller('TeamsPageController', TeamsPageController);

    TeamsPageController.$inject = ['jsonGetter'];
    function TeamsPageController(jsonGetter) {
        var self = this;
        //self.url = 'http://localhost:9000/teams';
        self.url = 'http://46.101.169.15:9000/teams'
        //self.url = 'http://shielded-castle-7285.herokuapp.com/teams';
        jsonGetter(self.url).success(function(data){
              self.teams = data;
        });
    }

})();