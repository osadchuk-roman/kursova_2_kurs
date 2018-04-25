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
    this.insert_sport_category = function add() {
        var name = document.getElementById("Name").value;
        // window.alert('Вид спорту "' + name + '" був успішно доданий!');
        // window.location.reload();

        $http.get('/api/sport_category/insert?name='+name).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Спортивну категорію "' + response.data.name + '" було успішно додано!');
            window.location.reload();
        });

    };
    var thisId;
    this.start_update_sport_category = function updt(id) {
        thisId=id;
    };
    this.update_sport_category = function upd() {
        var name = document.getElementById("NameUPD").value;


        $http.get('/api/sport_category/update?id='+thisId+'&name='+name).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            //window.alert('Вид спорту "' + response.data.name + '" був успішно доданий!');
            window.location.reload();
        });
        //window.location.reload();

    };
});