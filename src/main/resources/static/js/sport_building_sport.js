var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sport_building_sport = [];
    $http.get('http://localhost:8080/api/sport_building_sport').then(function (response){
        $scope.sport_building_sport=response.data;
        console.log(response);
    });
    this.del_sport_building_sport= function del(id) {
        $http.get('/api/sport_building_sport/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Запис було успішно видалено!');
        });
    };

    this.start_insert_sport_building_sport = function add() {

        $http.get('/api/sport_building').then(function (response){
            var types = response.data;
            var selector = document.getElementById("SportBuilding");
            $(selector).empty();
            for (var i = 0; i < types.length; i++) {
                var option = document.createElement("option");
                option.text = types[i].name;
                option.value = types[i].id;
                selector.add(option);
            }


            $http.get('/api/kind_of_sport').then(function (response){
                var types = response.data;
                var selector = document.getElementById("Sport");
                $(selector).empty();
                for (var i = 0; i < types.length; i++) {
                    var option = document.createElement("option");
                    option.text = types[i].name;
                    option.value = types[i].id;
                    selector.add(option);
                }
            });
        });



    };

    this.insert_sport_building_sport = function add() {

        var indexOfSportBuilding = document.getElementById("SportBuilding").selectedIndex;
        var buildingID = document.getElementById("SportBuilding").options[indexOfSportBuilding].value;


        var indexOfSport = document.getElementById("SportBuilding").selectedIndex;
        var sportID = document.getElementById("SportBuilding").options[indexOfSport].value;

        $http.get('/api/sport_building_sport/insert?sportBuildingId='+buildingID+'&sportId='+sportID).then(function (response){
            window.location.reload();
            window.alert('Запис було успішно додано!');
        });

    };
    var thisId;

    this.start_update_sport_building_sport = function upd(id,buildingName,sportName) {
        thisId=id;
        var thisIndex;
        $http.get('/api/sport_building').then(function (response){
            var types = response.data;
            var selector = document.getElementById("SportBuildingUPD");
            $(selector).empty();
            for (var i = 0; i < types.length; i++) {
                var option = document.createElement("option");
                option.text = types[i].name;
                option.value = types[i].id;
                if(types[i].name==buildingName) {
                    thisIndex = i;
                }
                selector.add(option);
                selector.selectedIndex=thisIndex;
            }
            //document.getElementById("SportBuildingUPD").selectedIndex=thisIndex;


            $http.get('/api/kind_of_sport').then(function (response){
                var types = response.data;
                var selector = document.getElementById("SportUPD");
                $(selector).empty();
                for (var i = 0; i < types.length; i++) {
                    var option = document.createElement("option");
                    option.text = types[i].name;
                    option.value = types[i].id;
                    if(types[i].name==sportName) {
                        thisIndex = i;
                    }
                    selector.add(option);
                    selector.selectedIndex=thisIndex;
                }
                //document.getElementById("SportUPD").selectedIndex=thisIndex;
            });
        });



    };
    this.update_sport_building_sport = function upd() {
        var indexOfSportBuilding = document.getElementById("SportBuildingUPD").selectedIndex;
        var buildingID = document.getElementById("SportBuildingUPD").options[indexOfSportBuilding].value;


        var indexOfSport = document.getElementById("SportUPD").selectedIndex;
        var sportID = document.getElementById("SportUPD").options[indexOfSport].value;

        $http.get('/api/sport_building_sport/update?id='+thisId+'&sportBuildingId='+buildingID+'&sportId='+sportID).then(function (response){
            window.location.reload();
            window.alert('Запис було успішно додано!');
        });

    };
});