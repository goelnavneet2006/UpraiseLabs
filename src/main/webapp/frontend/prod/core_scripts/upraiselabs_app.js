(function() {
  var upraiseLabsApp = angular.module("upraiseLabsApp", [ 'ui.bootstrap' ]);

  upraiseLabsApp.config([ '$httpProvider', function($httpProvider) {
    $httpProvider.defaults.withCredentials = true;
  } ]);
})();
