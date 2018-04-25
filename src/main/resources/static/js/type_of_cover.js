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
    this.insert_type_of_cover = function add() {
        var name = document.getElementById("typeName").value;
        // window.alert('Вид спорту "' + name + '" був успішно доданий!');
        // window.location.reload();

        $http.get('/api/type_of_cover/insert?name='+name).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Вид поктриття "' + response.data.name + '" був успішно доданий!');
            window.location.reload();
        });

    };
    var thisId;
    this.start_update_type_of_cover = function updt(id) {
        thisId=id;
    };
    this.update_type_of_cover = function upd() {
        var name = document.getElementById("typeNameUPD").value;


        $http.get('/api/type_of_cover/update?id='+thisId+'&name='+name).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            //window.alert('Вид спорту "' + response.data.name + '" був успішно доданий!');
            window.location.reload();
        });
        //window.location.reload();

    };
});