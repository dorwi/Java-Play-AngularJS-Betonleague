angular.module('frontendApp')
       .controller('TabsCtrl', ['$window'/*,'$state'*/,'$scope','$location', TabsCtrl]);

function TabsCtrl($window, $scope, $location) {
  $scope.tabs = [
      { state : 'home', label : 'Home', link: '#home' },
      { state : 'fixtures', label : 'Fixtures', link: '#fixtures' },
      { state : 'teams', label : 'Teams', link: '#teams' },
      { state : 'rules', label : 'Rules', link: '#rules' }
    ]; 
    
  $scope.selectedTab = $scope.tabs[0];    
  $scope.setSelectedTab = function(tab) {
    $scope.selectedTab = tab;
    //$state.transitionTo($state.current, $state.$current.params, { reload: true, inherit: true, notify: true });
    //$state.reload();
    //$state.go($state.current.name, $state.params, { reload: true });
    //$window.location.reload(true)
  }
  
  $scope.tabClass = function(tab) {
    if ($scope.selectedTab == tab) {
      return "active";
    } else {
      return "";
    }
  }
}