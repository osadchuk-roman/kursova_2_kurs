var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sport_club = [];
    $http.get('http://localhost:8080/api/sport_club').then(function (response){
        $scope.sport_club=response.data;
        console.log(response);
    });
    this.del_sport_club= function del(id) {
        $http.get('/api/sport_club/del?id='+id).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Спортивний клуб "' + response.data.name + '" був успішно видалений!');
            window.location.reload();
        });
    };
    /*this.insert_kind_of_sport= function del(id) {
        $http.get('/api/type_of_cover/del?id='+id).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Вид спорту  ' + response.data.name + ' був успішно видалений!');
            window.location.reload();
        });
    }*/
});