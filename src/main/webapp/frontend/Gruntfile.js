/*
 * Grunt Script for Bootstrap less
 * http://gruntjs.com/
 */

"use strict";
module.exports = function(grunt) {

  grunt.initConfig({

    pkg : grunt.file.readJSON("package.json"),

    less : {
      // vendor : {
      // // options: {
      // // strictMath: true,
      // // sourceMap: true,
      // // outputSourceFiles: true,
      // // sourceMapURL: "<%= pkg.name %>.css.map",
      // // sourceMapFilename: "<%= pkg.frontEndBuildDirectory %>/css/<%=
      // // pkg.name %>.css.map"
      // // },
      // src : "<%= pkg.bowerComponentsDir %>/bootstrap/less/bootstrap.less",
      // dest : "<%= pkg.prodVendorStylesDir %>/bootstrap.css"
      // },

      all : {
        files : [ {
          expand : true, // Enable dynamic expansion.
          cwd : "<%= pkg.prodCoreStylesDir %>/", // Src matches are relative to
          // this path.
          src : [ "core.less" ], // Actual pattern(s) to match.
          dest : "<%= pkg.prodCoreStylesDir %>/", // Destination path prefix.
          ext : ".css" // Dest filepaths will have this extension.
        } ]
      },
    },

    watch : {
      core : {
        files : [ "<%= pkg.prodCoreScriptsDir %>/**/*.*",
            "<%= pkg.prodCoreComponentsDir %>/**/*.*",
            "<%= pkg.prodCoreStylesDir %>/*.less" ],
        tasks : [ "build" ],
        options : {
          debounceDelay : 250
        }
      }
    },

    clean : {
      all : [ "<%= pkg.prodCoreStylesDir %>/*.css",
          "<%= pkg.prodVendorScriptsDir %>/*.*"]
    },

    autoprefixer : {
      options : {
        browsers : [ "Android 2.3", "Android >= 4", "Chrome >= 20",
            "Firefox >= 24", // Firefox 24 is the latest ESR
            "Explorer >= 8", "iOS >= 6", "Opera >= 12", "Safari >= 6" ],
        map : true
      },

      all : {
        files : [ {
          expand : true,
          cwd : "<%= pkg.prodCoreStylesDir %>/",
          src : [ "core.css" ],
          dest : "<%= pkg.prodCoreStylesDir %>/",
          ext : ".css"
        } ]
      }
    },

    // cssmin: {
    // vendor: {
    // files: {
    // "<%= pkg.frontEndBuildDirectory %>/css/bootstrap.min.css":
    // ["<%= pkg.frontEndBuildDirectory %>/css/bootstrap.css"]
    // }
    // },
    //
    // core: {
    // files: [{
    // expand: true,
    // cwd: "<%= pkg.frontEndBuildDirectory %>/css/",
    // src: ["**/*.css"],
    // dest: "<%= pkg.frontEndBuildDirectory %>/css/",
    // ext: ".min.css"
    // }]
    // }
    // },

    copy : {
      vendor : {
        files : [ {
          expand : true,
          cwd : "<%= pkg.bowerComponentsDir %>/",
          src : [ "**/*.min.js" ],
          dest : "<%= pkg.prodVendorScriptsDir %>/"
        } ]
      }
    },

  // concat: {
  // vendor: {
  // files: {
  // "<%= pkg.frontEndBuildDirectory %>/js/bootstrap.js":
  // "<%= pkg.nodeModulesDirectory %>/bootstrap/js/*.js"
  // }
  // }
  // },
  //
  //
  // uglify: {
  // vendor: {
  // files: {
  // "<%= pkg.frontEndBuildDirectory %>/js/bootstrap.min.js":
  // "<%= pkg.frontEndBuildDirectory %>/js/bootstrap.js"
  // }
  // },
  //
  // core: {
  // files: [{
  // expand: true,
  // cwd: "<%= pkg.frontEndBuildDirectory %>/common_components",
  // src: ["**/*.js"],
  // dest: "<%= pkg.frontEndBuildDirectory %>/common_components/",
  // ext: ".min.js"
  // },
  //
  // {
  // expand: true,
  // cwd: "<%= pkg.frontEndBuildDirectory %>/js/",
  // src: ["**/*.js"],
  // dest: "<%= pkg.frontEndBuildDirectory %>/js/",
  // ext: ".min.js"
  // }]
  // }
  // }
  });

  // Load plugins here
  grunt.loadNpmTasks("grunt-autoprefixer");
  grunt.loadNpmTasks("grunt-contrib-watch");
  grunt.loadNpmTasks("grunt-contrib-cssmin");
  grunt.loadNpmTasks("grunt-contrib-clean");
  grunt.loadNpmTasks("grunt-contrib-uglify");
  grunt.loadNpmTasks("grunt-contrib-less");
  grunt.loadNpmTasks("grunt-contrib-copy");
  grunt.loadNpmTasks('grunt-contrib-concat');

  // grunt.registerTask("bootstrap", ["clean", "less:bootstrap",
  // "autoprefixer:bootstrap", "cssmin:bootstrap"]);
  // grunt.registerTask("samscustom", ["clean", "less:samscustom",
  // "autoprefixer:samscustom", "cssmin:samscustom"]);
  grunt.registerTask("build", [ "clean", "copy", "less", "autoprefixer" ]);
};
