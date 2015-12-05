(function () {
    'use strict';

    angular
        .module('frontendApp')
        .controller('LogoutController', LogoutController);

    LogoutController.$inject = ['$location', '$localStorage','AuthenticationService'];
    function LogoutController($location, $localStorage, AuthenticationService) {
        var vm = this;

        AuthenticationService.ClearCredentials();
        $location.path('/home');
    }

})();