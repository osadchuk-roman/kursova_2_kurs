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
    this.insert_organizer = function add() {
        var name = document.getElementById("Name").value;
        var adminName = document.getElementById("AdminName").value;
        var phone = document.getElementById("Phone").value;
        var address = document.getElementById("Address").value;
        // window.alert('Вид спорту "' + name + '" був успішно доданий!');
        // window.location.reload();

        $http.get('/api/organizer/insert?name='+name+'&adminName='+adminName+'&phone='+phone+'&address='+address)
            .then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Організатора "' + response.data.name + '" було успішно додано!');
            window.location.reload();
        });

    };
    var thisId;
    this.start_update_organizer = function updt(id) {
        thisId=id;
    };
    this.update_organizer = function upd() {
        var name = document.getElementById("NameUPD").value;
        var adminName = document.getElementById("AdminNameUPD").value;
        var phone = document.getElementById("PhoneUPD").value;
        var address = document.getElementById("AddressUPD").value;


        $http.get('/api/organizer/update?id='+thisId+'&name='+name+'&adminName='+adminName+'&phone='+phone+'&address='+address)
            .then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            //window.alert('Вид спорту "' + response.data.name + '" був успішно доданий!');
            window.location.reload();
        });
        //window.location.reload();

    };
});