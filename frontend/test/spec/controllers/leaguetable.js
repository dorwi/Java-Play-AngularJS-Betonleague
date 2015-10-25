'use strict';

describe('Controller: LeaguetableCtrl', function () {

  // load the controller's module
  beforeEach(module('frontendApp'));

  var LeaguetableCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    LeaguetableCtrl = $controller('LeaguetableCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  
  it('should create a table with 6 teams', function () {
    expect(scope.json.first.standings.length).toBe(6);
  });

  it('should have a name', function(){
    expect(scope.json.first.name).toBeDefined();
  });
});
