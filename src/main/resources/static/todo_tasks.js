angular.module('app', []).controller('taskController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081/todo_list';

    $scope.loadTasks = function () {
        $http.get(contextPath + '/')
            .then(function (responce) {
                console.log(responce.data);
                $scope.tasksList = responce.data;
            });
    };

    $scope.showDeadline = function (taskId) {
        $http.get(contextPath + '/show_deadline/' + taskId)
            .then(function (responce) {
                alert(responce.data.deadline);
                console.log(responce.data);
            });
    }

    $scope.showDescription = function (taskId) {
        $http.get(contextPath + '/find_by_id/' + taskId)
            .then(function (responce) {
                alert(responce.data.description);
            });
    }

    $scope.makeDone = function (taskId) {
        $http.put(contextPath + '/done/' + taskId)
            .then(function (responce) {
                $scope.loadTasks();
            });
    }

    $scope.delete = function (taskId) {
        $http.delete(contextPath + '/delete/' + taskId)
            .then(function (responce) {
                alert("Удалено!");
                $scope.loadTasks();
            });
    }

    $scope.loadHomePage = function () {
        window.location.href = 'http://localhost:8081/home.html';
    };

    $scope.loadTasks();


});