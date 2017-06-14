    var demoApp = angular.module('demoApp', []);
demoApp.directive('sortableTable', function() {
    return {
        restrict: 'E',
        template: $('#table-template').html(),
        scope: {
          data: '=',
          headers: '=',
          fields: '=',
          sortOn: '@',
          asc: '@',
          title: '@'
        }, 
        transclude: true,
        controller: function($scope){
            if($scope.sortOn && $scope.asc==undefined){
                $scope.asc = 'true'
            }

            updateOrdering();

            $scope.sortOnHeader = function(field){
                if($scope.sortOn!=field){
                    $scope.sortOn=field;
                    $scope.asc='true';
                    updateOrdering();
                } else {
                    toggleAsc();
                }
            }

            function toggleAsc() {
                $scope.asc = ($scope.asc=='true') ? 'false' : 'true';
                updateOrdering();
            }

            function updateOrdering() {
                var newOrdering = ($scope.asc=='false') ? '-' : '';
                newOrdering += $scope.sortOn;
                $scope._order = newOrdering;
            }
        }
    };
});