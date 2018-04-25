var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sport_category = [];
    $http.get('http://localhost:8080/api/sport_category').then(function (response){
        $scope.sport_category=response.data;
        console.log(response);
    });
    this.del_sport_category= function del(id) {
        $http.get('/api/sport_category/del?id='+id).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Спортивну категорію "' + response.data.name + '" було успішно видалено!');
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