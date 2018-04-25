var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.type_of_cover = [];
    $http.get('http://localhost:8080/api/type_of_cover').then(function (response){
        $scope.type_of_cover=response.data;
        console.log(response);
    });
    this.del_type_of_cover= function del(id) {
        $http.get('/api/type_of_cover/del?id='+id).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Вид поктриття "' + response.data.name + '" було успішно видалено!');
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