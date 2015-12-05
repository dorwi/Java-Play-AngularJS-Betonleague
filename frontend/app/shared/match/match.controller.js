(function () {
    'use strict';

    angular
        .module('frontendApp')
        .controller('MatchController', MatchController);

    RoundController.$inject = ['AuthenticationService','$scope'];
    function MatchController(AuthenticationService, $scope) {
        var self = this;
        console.log(self)

        $scope.isAdmin = function() {
            return AuthenticationService.isAdmin();
        }

        $scope.submit = function(record) {
            console.log(record)
        }
    }

})();