var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.organizer = [];
    $http.get('http://localhost:8080/api/organizer').then(function (response){
        $scope.organizer=response.data;
        console.log(response);
    });
    this.del_organizer= function del(id) {
        $http.get('/api/organizer/del?id='+id).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Організатор "' + response.data.name + '" був успішно видалений!');
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