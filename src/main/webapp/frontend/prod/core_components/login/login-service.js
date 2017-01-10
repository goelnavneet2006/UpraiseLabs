(function() {
  "use strict";

  angular.module("upraiseLabsApp").service("ULLoginService", ULLoginService);

  ULLoginService.$inject = [ "$location", "$http", "$q",
      "$httpParamSerializerJQLike" ];

  function ULLoginService($location, $http, $q, $httpParamSerializerJQLike) {

    this.loginUser = loginUser;

    function loginUser(loginEmail, loginPassword) {
      var deferred = $q.defer();

      var userData = {
        loginEmail : loginEmail,
        loginPassword : loginPassword
      };

      var locationHost = $location.host();
      if (locationHost == "localhost") {
        locationHost += ":8443";
      }

      var request = {
        url : "https://" + locationHost
            + frontEndConfig.urlMapping.loginUserApiUrl,
        method : 'POST',
        data : $httpParamSerializerJQLike(userData),
        headers : {
          'Content-Type' : 'application/x-www-form-urlencoded'
        }
      };

      $http(request).success(function(results) {
        var data = results || {};
        deferred.resolve(data);
      }).error(function(error) {
        deferred.reject(error);
      });

      return deferred.promise;
    }
  }
})();
