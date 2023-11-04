angular.module('app', []).controller('homeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081';

    $scope.loadNotes = function () {
        window.location.href = contextPath + '/notes.html';
    };

    $scope.loadToDo = function () {
        window.location.href = contextPath + '/todo_tasks.html';
    };

});