angular.module('app', ['ngStorage']).controller('homeController', function ($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8081';


    $scope.tryToAuth = function () {
        $http.post('http://localhost:8081/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.serviceUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(responce) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        $scope.user = null;
    };

    $scope.clearUser = function () {
        delete $localStorage.serviceUser;
        $http.defaults.headers.common.Authorization = '';
    };
    $scope.isUserLoggedIn = function () {
        if ($localStorage.serviceUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.checkAuth = function () {
        $http.get('http://localhost:8189/shop/auth_check').then(function (response) {
            alert(response.data.value);
        });
    };

    if ($localStorage.serviceUser) {
        try {
            let jwt = $localStorage.serviceUser.token;
            let payload = JSON.parse(atob(jwt.split('.')[1]));
            let currentTime = parseInt(new Date().getTime() / 100);
            if (currentTime > payload.exp) {
                console.log("Token is expired!");
                delete $localStorage.serviceUser;
                $http.defaults.headers.common.Authorization = '';
            }
        } catch (e) {
        }
        $http.defaults.headers.common.Autorization = 'Bearer ' + $localStorage.serviceUser.token;
    }

    $scope.loadNotes = function () {
        window.location.href = contextPath + '/notes.html';
    };

    $scope.loadToDo = function () {
        window.location.href = contextPath + '/todo_tasks.html';
    };

});