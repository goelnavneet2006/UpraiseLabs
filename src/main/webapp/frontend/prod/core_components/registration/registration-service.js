(function() {
  "use strict";

  angular.module("upraiseLabsApp").service("ULRegisterService",
      ULRegisterService);

  ULRegisterService.$inject = [ "$location", "$http", "$q",
      "$httpParamSerializerJQLike" ];

  function ULRegisterService($location, $http, $q, $httpParamSerializerJQLike) {

    this.registerUser = registerUser;

    function registerUser(registerFirstName, registerMiddleName,
        registerLastName, registerMobile, registerLandlineSTD,
        registerLandlineNumber, registerDOB, registerPAN, registerAddLine1,
        registerAddLine2, registerCity, registerState, registerPincode,
        registerEmail, registerPassword) {
      var deferred = $q.defer();

      var userData = {
        registerFirstName : registerFirstName,
        registerMiddleName : registerMiddleName,
        registerLastName : registerLastName,
        registerMobile : registerMobile,
        registerLandlineSTD : registerLandlineSTD,
        registerLandlineNumber : registerLandlineNumber,
        registerDOB : registerDOB,
        registerPAN : registerPAN,
        registerAddLine1 : registerAddLine1,
        registerAddLine2 : registerAddLine2,
        registerCity : registerCity,
        registerState : registerState,
        registerPincode : registerPincode,
        registerEmail : registerEmail,
        registerPassword : registerPassword
      };

      var locationHost = $location.host();
      if (locationHost == "localhost") {
        locationHost += ":8443";
      }

      var request = {
        url : "https://" + locationHost
            + frontEndConfig.urlMapping.registerUserApiUrl,
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
