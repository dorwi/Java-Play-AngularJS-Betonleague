angular.module('frontendApp')
	   .factory('jsonGetter', function($http) {
  			var promise = {};
		    return function(url) {
          console.log(promise);
          console.log(url);
    			if (promise[url]) {
	      			return promise[url];
    			} else {
      				promise[url] = $http.get(url, { cache: true});
      				return promise[url];
    			}
  			};
});