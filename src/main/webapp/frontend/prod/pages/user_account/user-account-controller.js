(function() {
  "use strict";

  angular.module("upraiseLabsApp").controller("ULUserAccountCtrl",
      ULUserAccountCtrl);

  function ULUserAccountCtrl() {
    var vm = this;
    vm.myProfileTab = true;
    vm.myMutualFundsTab = false;

    vm.activateMyProfileTab = activateMyProfileTab;
    vm.activateMyMutualFundsTab = activateMyMutualFundsTab;

    function activateMyProfileTab() {
      vm.myProfileTab = true;
      vm.myMutualFundsTab = false;
    }

    function activateMyMutualFundsTab() {
      vm.myProfileTab = false;
      vm.myMutualFundsTab = true;
    }
  }
})();
