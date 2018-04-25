var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sport_building = [];
    $http.get('http://localhost:8080/api/sport_building').then(function (response){
        $scope.sport_building=response.data;
        console.log(response);
    });
    this.del_sport_building= function del(id) {
        $http.get('/api/sport_building/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Спортивну будівлю "' + response.data.name + '" було успішно видалено!');
        });
    };

    this.start_insert_sport_building = function add() {

        $http.get('/api/type_of_sport_building').then(function (response){
            var types = response.data;
            var selector = document.getElementById("TypeOfSportBuilding");
            $(selector).empty();
            for (var i = 0; i < types.length; i++) {
                var option = document.createElement("option");
                option.text = types[i].name;
                option.value = types[i].id;
                selector.add(option);
            }
            });



    };

    this.insert_sport_building = function add() {
        var name = document.getElementById("Name").value;
        var indexOfType = document.getElementById("TypeOfSportBuilding").selectedIndex;
        var typeID = document.getElementById("TypeOfSportBuilding").options[indexOfType].value;
        var phone = document.getElementById("Phone").value;
        var address = document.getElementById("Address").value;

        $http.get('/api/sport_building/insert?name='+name+'&typeOfSportBuildingId='
            +typeID+'&phone='+phone+'&address='+address).then(function (response){
                window.location.reload();
                window.alert('Спортивну будівлю "' + response.data.name + '" було успішно додано!');
            });

    };
    var thisId;

    this.start_update_sport_building = function upd(id,name,type,phone,address) {
        thisId=id;
        var thisIndex;
        $http.get('/api/type_of_sport_building').then(function (response){
            var types = response.data;
            var selector = document.getElementById("TypeOfSportBuildingUPD");
            $(selector).empty();
            for (var i = 0; i < types.length; i++) {
                var option = document.createElement("option");
                option.text = types[i].name;
                option.value = types[i].id;
                if (types[i]==type) thisIndex=i;
                selector.add(option);
            }
            //document.getElementById("TypeOfSportBuildingUPD").selectedIndex = thisIndex;
            //var typeID = document.getElementById("TypeOfSportBuildingUPD").options[indexOfType].value;
        });
        document.getElementById("nameUPD").value=name;

        document.getElementById("PhoneUPD").value=phone;
        document.getElementById("AddressUPD").value=address;



    };
    this.update_sport_building = function upd() {
        var name = document.getElementById("NameUPD").value;
        var indexOfType = document.getElementById("TypeOfSportBuildingUPD").selectedIndex;
        var typeID = document.getElementById("TypeOfSportBuildingUPD").options[indexOfType].value;
        var phone = document.getElementById("PhoneUPD").value;
        var address = document.getElementById("AddressUPD").value;

        $http.get('/api/sport_building/update?id='+thisId+'&name='+name+'&typeOfSportBuildingId='
            +typeID+'&phone='+phone+'&address='+address).then(function (response){
                window.location.reload();
            });

    };
});