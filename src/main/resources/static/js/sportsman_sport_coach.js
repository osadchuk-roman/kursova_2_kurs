var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sportsman_sport_coach = [];
    $http.get('http://localhost:8080/api/sportsman_sport_coach').then(function (response){
        $scope.sportsman_sport_coach=response.data;
        console.log(response);
    });
    this.del_sportsman_sport_coach= function del(id) {
        $http.get('/api/sportsman_sport_coach/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Запис "' + response.data.id + '" було успішно видалено!');
        });
    };

    this.start_insert_sportsman_sport_coach = function add() {



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

                $http.get('/api/sport_category').then(function (response){
                    var sportCategory = response.data;
                    var selector = document.getElementById("SportCategory");
                    $(selector).empty();
                    for (var i = 0; i < sportCategory.length; i++) {
                        var option = document.createElement("option");
                        option.text = sportCategory[i].name;
                        option.value = sportCategory[i].id;
                        selector.add(option);
                    }

                    $http.get('/api/coach').then(function (response){
                        var coach = response.data;
                        var selector = document.getElementById("Coach");
                        $(selector).empty();
                        for (var i = 0; i < coach.length; i++) {
                            var option = document.createElement("option");
                            option.text = coach[i].name;
                            option.value = coach[i].id;
                            selector.add(option);
                        }
                    });
                });
            });
        });

    };

    this.insert_sportsman_sport_coach = function add() {
        var indexOfSportsman = document.getElementById("Sportsman").selectedIndex;
        var sportsmanId = document.getElementById("Sportsman").options[indexOfSportsman].value;


        var indexOfSport = document.getElementById("Sport").selectedIndex;
        var sportId = document.getElementById("Sport").options[indexOfSport].value;

        var indexOfSportCategory = document.getElementById("SportCategory").selectedIndex;
        var sportCategoryId = document.getElementById("SportCategory").options[indexOfSportCategory].value;

        var indexOfSport = document.getElementById("Coach").selectedIndex;
        var coachId = document.getElementById("Coach").options[indexOfSport].value;

        var sportsman;
        $http.get('/api/sportsman/getById?id='+sportsmanId).then(function (response){
            sportsman=response.data;
        });

        var kind_of_sport;
        $http.get('/api/kind_of_sport/getById?id='+sportId).then(function (response){
            kind_of_sport=response.data;
        });

        var sport_category;
        $http.get('/api/sport_category/getById?id='+sportCategoryId).then(function (response){
            sport_category=response.data;
        });

        var coach;
        $http.get('/api/coach/getById?id='+coachId).then(function (response){
            coach=response.data;
        });

       /* var req = {
            method: 'POST',
            url: '/api/sportsman_sport_coach/insert',
            data: {
                id: 0,
                sportsman: sportsman,
                kindOfSport: kind_of_sport,
                sportCategory: sport_category,
                coachId: coach

            }
        };
        // console.log(req);
        $http(req).then(function (response) {

            window.location.reload();
        });*/
        $http.get('/api/sportsman_sport_coach/insert?sportsmanId='+sportsmanId+'&sportId='
            +sportId+'&categoryId='+sportCategoryId+'&coachId='+coachId).then(function (response){
            window.location.reload();
            window.alert('Запис було успішно додано!');
        });

    };
    var thisId;

    this.start_update_sportsman_sport_coach = function upd(id,sportsmanName,sportName,
                                                           sportCategoryName,coachName) {
        thisId=id;
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
                $http.get('/api/sport_category').then(function (response){
                    var sportCategory = response.data;
                    var selector = document.getElementById("SportCategoryUPD");
                    $(selector).empty();
                    for (var i = 0; i < sportCategory.length; i++) {
                        var option = document.createElement("option");
                        option.text = sportCategory[i].name;
                        option.value = sportCategory[i].id;
                        selector.add(option);
                        if(sportCategory[i].name==sportCategoryName)
                            selector.selectedIndex=i;
                    }
                    $http.get('/api/coach').then(function (response){
                        var coach = response.data;
                        var selector = document.getElementById("CoachUPD");
                        $(selector).empty();
                        for (var i = 0; i < coach.length; i++) {
                            var option = document.createElement("option");
                            option.text = coach[i].name;
                            option.value = coach[i].id;
                            selector.add(option);
                            if(coach[i].name==coachName)
                                selector.selectedIndex=i;
                        }
                    });
                });
            });
        });
    };

    this.update_sportsman_sport_coach = function upd() {
        var indexOfSportsman = document.getElementById("SportsmanUPD").selectedIndex;
        var sportsmanId = document.getElementById("SportsmanUPD").options[indexOfSportsman].value;

        var indexOfSport = document.getElementById("SportUPD").selectedIndex;
        var sportId = document.getElementById("SportUPD").options[indexOfSport].value;

        var indexOfSportCategory = document.getElementById("SportCategoryUPD").selectedIndex;
        var sportCategoryId = document.getElementById("SportCategoryUPD").options[indexOfSportCategory].value;

        var indexOfSport = document.getElementById("CoachUPD").selectedIndex;
        var coachId = document.getElementById("CoachUPD").options[indexOfSport].value;

        /*var req = {
            method: 'POST',
            url: '/api/sportsman_sport_coach/update',
            data: {
                id: thisId,
                sportsmanId: sportsmanId,
                kindOfSportId: sportId,
                sportCategoryId: sportCategoryId,
                coachId: coachId

            }
        };
        // console.log(req);
        $http(req).then(function (response) {

            window.location.reload();
        });*/
        $http.get('/api/sportsman_sport_coach/update?id='+thisId+'&sportsmanId='+sportsmanId+'&sportId='
            +sportId+'&categoryId='+sportCategoryId+'&coachId='+coachId).then(function (response){
            window.location.reload();
        });


    };
});