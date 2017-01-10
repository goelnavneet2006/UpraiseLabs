/**
 * Simple "flyout" plugin for AngularJS.
 *
 * Usage:
 * Flyout configuration:
 *
 * // Initializing flyout.
 * It can be used as HTML element or attribute.
 *
 *    <flyout
 *      flyout-position="" // (Optional) Can be "left" or "right"
 *                         // with respect to parent/given element, default is "left"
 *      flyout-close-left-text="" // (Optional) Text to show on the left hand
 *                                // side of close link, default is ""
 *      flyout-close-right-text="" // (Optional) Text to show on the right hand
 *                                 // side of close link, default is ""
 *      flyout-width="" // (Optional) Width of flyout.
 *      flyout-height="" // (Optional) Height of flyout.
 *      flyout-id="" // (Optional) Id for flyout.
 *      flyout-positioning-selector="" // (Optional) CSS selector string of an
 *                                     // element which can act as parent
 *                                     // selector for positioning flyout,
 *                                     // default is immediate parent
 *    >{{HTML_CONTENT_TO_SHOW_INSIDE_FLYOUT}}</flyout>
 *
 */

(function () {

  angular.module("samsApp").directive("flyout", flyoutDirective);

  function flyoutDirective() {
    var flyoutDirective = {
      restrict: "EA",
      // priority: 0,
      templateUrl: "static/common_components/flyout/flyout.html",
      // css: "static/common_components/flyout/flyout.css",
      replace: true,
      transclude: true,
      scope: {
        closeLinkLeftText: "@flyoutCloseLeftText",
        closeLinkRightText: "@flyoutCloseRightText",
        id: "@flyoutId"
      },
      // controller: controllerConstructor,
      // require: string,
      compile: function compile(tElement, tAttrs, transclude) {
        return {
          // pre: preLink,
          post: postLink
        }
      }
    };
    return flyoutDirective;
  }

  // function controllerConstructor($scope, $element, $attrs, $transclude) {
  // }

  // function preLink(scope, iElement, iAttrs, controller) {
  // }

  function postLink(scope, iElement, iAttrs, controller) {
    var ESCAPE_KEY = 27;
    var $flyout = $(iElement);

    
    var $parent = $flyout.parent();
    if (iAttrs.flyoutPositioningSelector) {
      $parent = $(iAttrs.flyoutPositioningSelector);
    }

    $($parent).css({"position": "relative"});

    if (iAttrs.flyoutWidth) {
      $flyout.css("width", iAttrs.flyoutWidth);
    }
    if (iAttrs.flyoutHeight) {
      $flyout.css("height", iAttrs.flyoutHeight);
    }

    var flyoutTop = $parent.outerHeight();

    if (iAttrs.flyoutPosition === "left") {
      $flyout.css({
        top: flyoutTop,
        left: 0
      });
    } else {
      $flyout.css({
        top: flyoutTop,
        right: 0
      });
    }

    var $flyoutCloseLink = $(iElement).find(".flyout-close-link-container");
    $flyoutCloseLink.click(function () {
      $flyout.addClass("ng-hide");
    });

    $(document).on("keydown", function (ev) {
      if (ev.which === ESCAPE_KEY) {
        $flyout.addClass("ng-hide");
      }
    });

    $(document).on("click", function (ev) {
      if ($flyout.parent().find(ev.target).addBack(ev.target).length === 0) {
        $flyout.addClass("ng-hide");
      }
    });
  }

})();
