(function() {
  "use strict";

  angular.module("upraiseLabsApp").controller("ULLoginCtrl", ULLoginCtrl);

  ULLoginCtrl.$inject = ["$sce", "ULLoginService" ];

  function ULLoginCtrl($sce, ULLoginService) {
    var vm = this;
    vm.submitForm = submitForm;
    vm.toggleLoginForm = toggleLoginForm;

    function toggleLoginForm() {
      if (!vm.showLoginForm) {
        vm.showServerError = false;
        vm.isSubmitting = false;
        vm.loginForm.$setUntouched();
        vm.loginForm.$setPristine();
        if (vm.user) {
          vm.user.loginEmail = "";
          vm.user.loginPassword = "";
        }
      }
      vm.showLoginForm = !vm.showLoginForm;
    }

    function submitForm() {
      var userCredentials = angular.copy(vm.user);
      if (userCredentials && userCredentials.loginEmail
          && userCredentials.loginPassword) {

        vm.isSubmitting = true;
        vm.showServerError = false;

        var loginUserPromise = ULLoginService.loginUser(
            userCredentials.loginEmail, userCredentials.loginPassword);
        loginUserPromise.then(function(data) {
          if (data && data.responses && data.responses.length > 0) {
            location.assign("/user_account");
          }
        }, function(error) {
          if (error && error.responses && error.responses.length > 0) {
            var errors = error.responses;
            var finalErrorString = "";
            for (var i = 0; i < errors.length; i++) {
              finalErrorString += (errors[i].msg + "<br/>");
            }
            vm.serverErrorMsg = $sce.trustAsHtml(finalErrorString);
            vm.isSubmitting = false;
            vm.showServerError = true;
          } else {
            vm.isSubmitting = false;
          }
        });
      }
    }
  }
})();
