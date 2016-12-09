angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    // $http.get('localhost:8080/greeting').
    //     then(function(response) {
    //         $scope.greeting = response.data;
    //     });
    $scope.greeting = 
    {
    	id : "sadkas",
    	content: "jsdaiojdsai"
    }
});