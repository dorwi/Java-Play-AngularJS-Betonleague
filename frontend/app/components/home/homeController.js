function HomeCtrl(jsonGetter){
  	var self = this;
    jsonGetter('http://127.0.0.1:8081/sample_responses/home.json').success(function(data){
      self.response = data;
    })
}

frontendApp.controller('HomeCtrl',[
  'jsonGetter', 
  HomeCtrl
]);
