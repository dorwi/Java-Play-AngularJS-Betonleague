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

        //url = 'http://localhost:9000/admin/'
        url = 'http://46.101.169.15:9000/admin'
        function GetById(id) {
            return $http.get(url + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByUsername(username) {
            return $http.get(url + username).then(handleSuccess, handleError('Error getting user by username'));
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