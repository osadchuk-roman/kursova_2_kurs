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
    this.insert_sport_club = function add() {
        var name = document.getElementById("Name").value;
        var adminName = document.getElementById("AdminName").value;
        var phone = document.getElementById("Phone").value;
        var address = document.getElementById("Address").value;
        // window.alert('Вид спорту "' + name + '" був успішно доданий!');
        // window.location.reload();

        $http.get('/api/sport_club/insert?name='+name+'&adminName='+adminName+'&phone='+phone+'&address='+address)
            .then(function (response){
                //  $http.get('http://localhost:8080/api/students').then(function (response){
                // $scope.students=response.data;
                window.alert('Спортивний клуб "' + response.data.name + '" було успішно додано!');
                window.location.reload();
            });

    };
    var thisId;
    this.start_update_sport_club = function upd(id,name,adminName,phone,address) {
        thisId=id;
        document.getElementById("NameUPD").value=name;
        document.getElementById("AdminNameUPD").value=adminName;
        document.getElementById("PhoneUPD").value=phone;
        document.getElementById("AddressUPD").value=address;
    };
    this.update_sport_club = function upd() {
        var name = document.getElementById("NameUPD").value;
        var adminName = document.getElementById("AdminNameUPD").value;
        var phone = document.getElementById("PhoneUPD").value;
        var address = document.getElementById("AddressUPD").value;


        $http.get('/api/sport_club/update?id='+thisId+'&name='+name+'&adminName='+adminName+'&phone='+phone+'&address='+address)
            .then(function (response){
                //  $http.get('http://localhost:8080/api/students').then(function (response){
                // $scope.students=response.data;
                //window.alert('Вид спорту "' + response.data.name + '" був успішно доданий!');
                window.location.reload();
            });
        //window.location.reload();

    };
});