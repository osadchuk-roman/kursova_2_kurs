var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.court = [];
    $http.get('http://localhost:8080/api/court').then(function (response){
        $scope.court=response.data;
        console.log(response);
    });
    this.del_court= function del(id) {
        $http.get('/api/court/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Корт "' + response.data.sportBuilding.name + '" було успішно видалено!');
        });
    };

    this.start_insert_court = function add() {

        $http.get('/api/sport_building').then(function (response){
            var sportBuilding = response.data;
            var selector = document.getElementById("SportBuilding");
            $(selector).empty();
            for (var i = 0; i < sportBuilding.length; i++) {
                var option = document.createElement("option");
                option.text = sportBuilding[i].name;
                option.value = sportBuilding[i].id;
                selector.add(option);
            }

            $http.get('/api/type_of_cover').then(function (response){
                var typeOfCover = response.data;
                var selector = document.getElementById("TypeOfCover");
                $(selector).empty();
                for (var i = 0; i < typeOfCover.length; i++) {
                    var option = document.createElement("option");
                    option.text = typeOfCover[i].name;
                    option.value = typeOfCover[i].id;
                    selector.add(option);
                }
            });
        });



    };

    this.insert_court = function add() {
        var indexOfSportBuilding = document.getElementById("SportBuilding").selectedIndex;
        var sportBuildingId = document.getElementById("SportBuilding").options[indexOfSportBuilding].value;

        var indexOfCover = document.getElementById("TypeOfCover").selectedIndex;
        var coverId = document.getElementById("TypeOfCover").options[indexOfCover].value;

        var width = document.getElementById("Width").value;
        var length = document.getElementById("Length").value;

        $http.get('/api/court/insert?sportBuildingId='+sportBuildingId+'&typeOfCoverId='
            +coverId+'&width='+width+'&length='+length).then(function (response){
            window.location.reload();
            window.alert('Корт було успішно додано!');
        });

    };
    var thisId;

    this.start_update_court = function upd(id,sportBuildingName,typeOfCoverName,width,length) {
        thisId=id;
        $http.get('/api/sport_building').then(function (response){
            var sportBuilding = response.data;
            var selector = document.getElementById("SportBuildingUPD");
            $(selector).empty();
            for (var i = 0; i < sportBuilding.length; i++) {
                var option = document.createElement("option");
                option.text = sportBuilding[i].name;
                option.value = sportBuilding[i].id;
                selector.add(option);
                if(sportBuilding[i].name==sportBuildingName){
                    selector.selectedIndex=i;
                }
            }

            $http.get('/api/type_of_cover').then(function (response){
                var typeOfCover = response.data;
                var selector = document.getElementById("TypeOfCoverUPD");
                $(selector).empty();
                for (var i = 0; i < typeOfCover.length; i++) {
                    var option = document.createElement("option");
                    option.text = typeOfCover[i].name;
                    option.value = typeOfCover[i].id;
                    selector.add(option);
                    if(typeOfCover[i].name==typeOfCoverName){
                        selector.selectedIndex=i;
                    }
                }
            });
        });
        document.getElementById("WidthUPD").value=width;
        document.getElementById("LengthUPD").value=length;

    };

    this.update_court = function upd() {
        var indexOfSportBuilding = document.getElementById("SportBuildingUPD").selectedIndex;
        var sportBuildingId = document.getElementById("SportBuildingUPD").options[indexOfSportBuilding].value;

        var indexOfCover = document.getElementById("TypeOfCoverUPD").selectedIndex;
        var coverId = document.getElementById("TypeOfCoverUPD").options[indexOfCover].value;

        var length = document.getElementById("LengthUPD").value;
        var width = document.getElementById("WidthUPD").value;

        $http.get('/api/court/update?id='+thisId+'&sportBuildingId='+sportBuildingId+'&typeOfCoverId='
            +coverId+'&width='+width+'&length='+length).then(function (response){
            window.location.reload();
        });

    };
});