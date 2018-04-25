var app = angular.module("kursova", [])



app.controller("AppCtrl", function ($http, $scope) {

    $scope.kind_of_sport = [];
    $http.get('http://localhost:8080/api/kind_of_sport').then(function (response){
        $scope.kind_of_sport=response.data;
        console.log(response);
    });
    this.del_kind_of_sport= function del(id) {
        $http.get('/api/kind_of_sport/del?id='+id).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Вид спорту "' + response.data.name + '" був успішно видалений!');
            window.location.reload();
        });
    };
    this.insert_kind_of_sport= function del(id) {
        $http.get('/api/kind_of_sport/del?id='+id).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Вид спорту  ' + response.data.name + ' був успішно видалений!');
            window.location.reload();
        });
    }
});