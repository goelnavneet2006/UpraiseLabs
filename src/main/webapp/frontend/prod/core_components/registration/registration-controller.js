(function() {
  "use strict";

  angular.module("upraiseLabsApp").controller("ULRegisterCtrl", ULRegisterCtrl);

  ULRegisterCtrl.$inject = [ "$sce", "ULRegisterService" ];

  function ULRegisterCtrl($sce, ULRegisterService) {
    var vm = this;
    vm.submitForm = submitForm;

    function submitForm() {
      var userCredentials = angular.copy(vm.user);
      var formattedDOB = null;
      if (userCredentials.registerDOB) {
        var fullDate = new Date(userCredentials.registerDOB);
        var day = String(fullDate.getDate());
        if (day.length == 1) {
          day = "0" + day;
        }
        var month = String(fullDate.getMonth() + 1);
        if (month.length == 1) {
          month = "0" + month;
        }
        var year = fullDate.getFullYear();
        formattedDOB = day + "/" + month + "/" + year;
      }

      if (userCredentials && userCredentials.registerFirstName
          && userCredentials.registerMobile && formattedDOB
          && userCredentials.registerPAN && userCredentials.registerAddLine1
          && userCredentials.registerCity && userCredentials.registerState
          && userCredentials.registerPincode && userCredentials.registerEmail
          && userCredentials.registerPassword) {

        vm.isSubmitting = true;
        vm.showServerError = false;
        vm.showServerSuccess = false;

        var registerUserPromise = ULRegisterService.registerUser(
            userCredentials.registerFirstName,
            userCredentials.registerMiddleName,
            userCredentials.registerLastName, userCredentials.registerMobile,
            userCredentials.registerLandlineSTD,
            userCredentials.registerLandlineNumber, formattedDOB,
            userCredentials.registerPAN, userCredentials.registerAddLine1,
            userCredentials.registerAddLine2, userCredentials.registerCity,
            userCredentials.registerState, userCredentials.registerPincode,
            userCredentials.registerEmail, userCredentials.registerPassword);
        registerUserPromise.then(function(data) {
          if (data && data.responses && data.responses.length > 0) {
            var successes = data.responses;
            var finalSuccessString = "";
            for (var i = 0; i < successes.length; i++) {
              finalSuccessString += (successes[i].msg + "<br/>");
            }
            vm.serverSuccessMsg = $sce.trustAsHtml(finalSuccessString);
            vm.showServerError = false;
            vm.showServerSuccess = true;
            vm.hideRegisterForm = true;
          }
        }, function(error) {
          vm.isSubmitting = false;
          if (error && error.responses && error.responses.length > 0) {
            var errors = error.responses;
            var finalErrorString = "";
            for (var i = 0; i < errors.length; i++) {
              finalErrorString += (errors[i].msg + "<br/>");
            }
            vm.serverErrorMsg = $sce.trustAsHtml(finalErrorString);
            vm.showServerError = true;
            vm.showServerSuccess = false;
          } else {
            vm.isSubmitting = false;
          }
        });
      }
    }
  }
})();
