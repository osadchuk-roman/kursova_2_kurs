var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sportsman_competition = [];
    $http.get('http://localhost:8080/api/sportsman_competition').then(function (response){
        $scope.sportsman_competition=response.data;
        console.log(response);
    });
    this.del_sportsman_competition= function del(id) {
        $http.get('/api/sportsman_competition/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Учасника змагань було успішно видалено!');
        });
    };

    this.start_insert_sportsman_competition = function add() {

        $http.get('/api/sportsman').then(function (response){
            var sportsman = response.data;
            var selector = document.getElementById("Sportsman");
            $(selector).empty();
            for (var i = 0; i < sportsman.length; i++) {
                var option = document.createElement("option");
                option.text = sportsman[i].name;
                option.value = sportsman[i].id;
                selector.add(option);
            }

            $http.get('/api/competition').then(function (response){
                var competition = response.data;
                var selector = document.getElementById("Competition");
                $(selector).empty();
                for (var i = 0; i < competition.length; i++) {
                    var option = document.createElement("option");
                    option.text = competition[i].name;
                    option.value = competition[i].id;
                    selector.add(option);
                }
            });
        });


    };

    this.insert_sportsman_competition = function add() {
        var prizePlace = document.getElementById("PrizePlace").value;
        var indexOfSportsman = document.getElementById("Sportsman").selectedIndex;
        var sportsman = document.getElementById("Sportsman").options[indexOfSportsman].value;
        var indexOfCompetition = document.getElementById("Competition").selectedIndex;
        var competition = document.getElementById("Competition").options[indexOfCompetition].value;

        $http.get('/api/sportsman_competition/insert?sportsmanId='+sportsman+'&competitionId='
            +competition+'&prizePlace='+prizePlace).then(function (response){
            window.location.reload();
            window.alert('Учасника змагань було успішно додано!');
        });

    };
    var thisId;

    this.start_update_sportsman_competition = function upd(id,sportsmanName,competitionName,prizePlace) {
        thisId=id;
        $http.get('/api/sportsman').then(function (response){
            var sportsman = response.data;
            var selector = document.getElementById("SportsmanUPD");
            $(selector).empty();
            for (var i = 0; i < sportsman.length; i++) {
                var option = document.createElement("option");
                option.text = sportsman[i].name;
                option.value = sportsman[i].id;
                selector.add(option);
                if(sportsman[i].name==sportsmanName)
                    selector.selectedIndex=i;
            }

            $http.get('/api/competition').then(function (response){
                var competition = response.data;
                var selector = document.getElementById("CompetitionUPD");
                $(selector).empty();
                for (var i = 0; i < competition.length; i++) {
                    var option = document.createElement("option");
                    option.text = competition[i].name;
                    option.value = competition[i].id;
                    selector.add(option);
                    if(competition[i].name==competitionName)
                        selector.selectedIndex=i;
                }
            });
        });

        document.getElementById("PrizePlaceUPD").value=prizePlace;
    };
    this.update_sportsman_competition = function upd() {
        var prizePlace = document.getElementById("PrizePlaceUPD").value;
        var indexOfSportsman = document.getElementById("SportsmanUPD").selectedIndex;
        var sportsman = document.getElementById("SportsmanUPD").options[indexOfSportsman].value;
        var indexOfCompetition = document.getElementById("CompetitionUPD").selectedIndex;
        var competition = document.getElementById("CompetitionUPD").options[indexOfCompetition].value;

        $http.get('/api/sportsman_competition/update?id='+thisId+'&sportsmanId='+sportsman+'&competitionId='
            +competition+'&prizePlace='+prizePlace).then(function (response){
            window.location.reload();
        });

    };
});