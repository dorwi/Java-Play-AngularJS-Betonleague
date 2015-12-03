(function () {
    'use strict';

    angular
        .module('frontendApp')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', '$rootScope','AuthenticationService', 'FlashService'];
    function LoginController($location, $rootScope, AuthenticationService, FlashService) {
        $rootScope.faszkalap = false    

        var vm = this;

        vm.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (response) {
                console.log("Finally here")
                console.log(response)
                console.log(response.success)
                if (response.success) {
                    $rootScope.faszkalap = true;
                    AuthenticationService.SetCredentials(vm.username, vm.password);
                    $location.path('/home');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    }

})();