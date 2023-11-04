angular.module('app', []).controller('notesController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081/notes';

    $scope.loadNotes = function () {
        $http.get(contextPath + '/')
            .then(function (responce) {
                console.log(responce.data);
                $scope.notesList = responce.data;
            });
    };

    $scope.delete = function (noteId) {
        $http.delete(contextPath + '/delete/' + noteId)
            .then(function (responce) {
                alert("Удалено!");
                $scope.loadNotes();
            });
    }

    $scope.content = function (noteId) {
        $http.get(contextPath + '/' + noteId)
            .then(function (responce) {
                alert(responce.data.content);
                $scope.loadNotes();
            });
    }

    $scope.loadHomePage = function () {
        window.location.href = 'http://localhost:8081/home.html';
    };


    $scope.loadNotes();


});