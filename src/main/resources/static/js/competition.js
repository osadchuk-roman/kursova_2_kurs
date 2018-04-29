var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.competition = [];
    $http.get('http://localhost:8080/api/competition').then(function (response){
        $scope.competition=response.data;
        console.log(response);
    });
    this.del_competition= function del(id) {
        $http.get('/api/competition/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Змагання "' + response.data.name + '" було успішно видалено!');
        });
    };

    this.start_insert_competition = function add() {

        $http.get('/api/organizer').then(function (response){
            var organizer = response.data;
            var selector = document.getElementById("Organizer");
            $(selector).empty();
            for (var i = 0; i < organizer.length; i++) {
                var option = document.createElement("option");
                option.text = organizer[i].name;
                option.value = organizer[i].id;
                selector.add(option);
            }

            $http.get('/api/sport_building').then(function (response){
                var sport_building = response.data;
                var selector = document.getElementById("SportBuilding");
                $(selector).empty();
                for (var i = 0; i < sport_building.length; i++) {
                    var option = document.createElement("option");
                    option.text = sport_building[i].name;
                    option.value = sport_building[i].id;
                    selector.add(option);
                }

                $http.get('/api/kind_of_sport').then(function (response){
                    var sport = response.data;
                    var selector = document.getElementById("Sport");
                    $(selector).empty();
                    for (var i = 0; i < sport.length; i++) {
                        var option = document.createElement("option");
                        option.text = sport[i].name;
                        option.value = sport[i].id;
                        selector.add(option);
                    }
                });
            });
        });

    };

    this.insert_competition = function add() {
        var name = document.getElementById("Name").value;
        var date = document.getElementById("Date").value;
        var indexOfOrganizer = document.getElementById("Organizer").selectedIndex;
        var organizer = document.getElementById("Organizer").options[indexOfOrganizer].value;
        var indexOfSportBuilding = document.getElementById("SportBuilding").selectedIndex;
        var sportBuilding = document.getElementById("SportBuilding").options[indexOfSportBuilding].value;
        var indexOfSport = document.getElementById("Sport").selectedIndex;
        var sport = document.getElementById("Sport").options[indexOfSport].value;

        $http.get('/api/competition/insert?name='+name+'&date='+date+'&organizerId='
            +organizer+'&sportBuildingId='+sportBuilding+'&sportId='+sport).then(function (response){
            window.location.reload();
            window.alert('Змагання "' + response.data.name + '" було успішно додано!');
        });

    };
    var thisId;

    this.start_update_competition = function upd(id,name,date,organizerName,
                                                 sportBuildingName, sportName) {
        thisId=id;
        $http.get('/api/organizer').then(function (response){
            var organizer = response.data;
            var selector = document.getElementById("OrganizerUPD");
            $(selector).empty();
            for (var i = 0; i < organizer.length; i++) {
                var option = document.createElement("option");
                option.text = organizer[i].name;
                option.value = organizer[i].id;
                selector.add(option);
                if(organizer[i].name==organizerName)
                    selector.selectedIndex=i;
            }

            $http.get('/api/sport_building').then(function (response){
                var sport_building = response.data;
                var selector = document.getElementById("SportBuildingUPD");
                $(selector).empty();
                for (var i = 0; i < sport_building.length; i++) {
                    var option = document.createElement("option");
                    option.text = sport_building[i].name;
                    option.value = sport_building[i].id;
                    selector.add(option);

                    if(sport_building[i].name==sportBuildingName)
                        selector.selectedIndex=i;
                }

                $http.get('/api/kind_of_sport').then(function (response){
                    var sport = response.data;
                    var selector = document.getElementById("SportUPD");
                    $(selector).empty();
                    for (var i = 0; i < sport.length; i++) {
                        var option = document.createElement("option");
                        option.text = sport[i].name;
                        option.value = sport[i].id;
                        selector.add(option);
                        if(sport[i].name==sportName)
                            selector.selectedIndex=i;
                    }
                });
            });
        });

        document.getElementById("NameUPD").value=name;
        document.getElementById("DateUPD").value=date;



    };
    this.update_competition = function upd() {
        var name = document.getElementById("NameUPD").value;
        var date = document.getElementById("DateUPD").value;
        var indexOfOrganizer = document.getElementById("OrganizerUPD").selectedIndex;
        var organizer = document.getElementById("OrganizerUPD").options[indexOfOrganizer].value;
        var indexOfSportBuilding = document.getElementById("SportBuildingUPD").selectedIndex;
        var sportBuilding = document.getElementById("SportBuildingUPD").options[indexOfSportBuilding].value;
        var indexOfSport = document.getElementById("SportUPD").selectedIndex;
        var sport = document.getElementById("SportUPD").options[indexOfSport].value;

        $http.get('/api/competition/update?id='+thisId+'&name='+name+'&date='+date+'&organizerId='
            +organizer+'&sportBuildingId='+sportBuilding+'&sportId='+sport).then(function (response){
            window.location.reload();
        });

    };
});