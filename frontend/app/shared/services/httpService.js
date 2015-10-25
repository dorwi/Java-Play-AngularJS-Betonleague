angular.module('frontendApp')
	   .factory('jsonGetter', function($http) {
  			var promise = null;

		    return function(url) {
    			if (promise) {
	      			return promise;
    			} else {
      				promise = $http.get(url);
      				return promise;
    			}
  			};
});