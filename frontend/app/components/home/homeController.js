function HomeCtrl(jsonGetter){
  	var self = this;
    jsonGetter('http://shielded-castle-7285.herokuapp.com/home?seasonName=Betonleague%202015/2016&leagueName1=West&leagueName2=East&roundNumber1=1&roundNumber2=1').success(function(data){
      self.response = data;
    })
}

frontendApp.controller('HomeCtrl',[
  'jsonGetter', 
  HomeCtrl
]);
