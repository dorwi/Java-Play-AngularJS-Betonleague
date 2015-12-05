(function () {
    'use strict';

    angular
        .module('frontendApp')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', '$localStorage','AuthenticationService'];
    function LoginController($location, $localStorage, AuthenticationService) {
        var vm = this;

        vm.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (response) {
                console.log(response.success)
                if (response.success) {
                    AuthenticationService.SetCredentials(vm.username, vm.password);
                    $location.path('/fixtures');
                }
            });
        };
    }

})();