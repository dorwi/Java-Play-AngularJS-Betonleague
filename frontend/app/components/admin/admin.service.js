(function () {
    'use strict';

    angular
        .module('frontendApp')
        .factory('AdminService', AdminService);

    AdminService.$inject = ['$http'];
    function AdminService($http) {
        var service = {};

        service.GetById = GetById;
        service.GetByUsername = GetByUsername;

        return service;

        function GetById(id) {
            return $http.get('http://localhost:9000/admin/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByUsername(username) {
            return $http.get('http://localhost:9000/admin/' + username).then(handleSuccess, handleError('Error getting user by username'));
        }


        // private functions

        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();