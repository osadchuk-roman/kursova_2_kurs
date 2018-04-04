var app = angular.module("kursova", [])

app.controller("AppCtrl", function($scope, $http){

    $scope.competition = [];
    $http.get('http://localhost:8080/api/competition').then(function (response){
        $scope.competition=response.data;
        competition.log(response);
    });
    ///це було розкоментоване


    $scope.type_of_cover = [];
    $http.get('http://localhost:8080/api/type_of_cover').then(function (response){
        $scope.type_of_cover=response.data;
        console.log(response);
    });

    $scope.type_of_sport_building = [];
    $http.get('http://localhost:8080/api/type_of_sport_building').then(function (response){
        $scope.type_of_sport_building=response.data;
        console.log(response);
    });

    $scope.sport_building = [];
    $http.get('http://localhost:8080/api/sport_building').then(function (response){
        $scope.sport_building=response.data;
        console.log(response);
    });

    $scope.gym = [];
    $http.get('http://localhost:8080/api/gym').then(function (response){
        $scope.gym=response.data;
        console.log(response);
    });

    $scope.stadium = [];
    $http.get('http://localhost:8080/api/stadium').then(function (response){
        $scope.stadium=response.data;
        stadium.log(response);
    });

    $scope.sport_arena = [];
    $http.get('http://localhost:8080/api/sport_arena').then(function (response){
        $scope.sport_arena=response.data;
        sport_arena.log(response);
    });

    $scope.court = [];
    $http.get('http://localhost:8080/api/court').then(function (response){
        $scope.court=response.data;
        court.log(response);
    });

    $scope.pool = [];
    $http.get('http://localhost:8080/api/pool').then(function (response){
        $scope.pool=response.data;
        pool.log(response);
    });

    $scope.sport_club = [];
    $http.get('http://localhost:8080/api/sport_club').then(function (response){
        $scope.sport_club=response.data;
        sport_club.log(response);
    });

    $scope.coach = [];
    $http.get('http://localhost:8080/api/coach').then(function (response){
        $scope.coach=response.data;
        coach.log(response);
    });

    $scope.sportsman = [];
    $http.get('http://localhost:8080/api/sportsman').then(function (response){
        $scope.sportsman=response.data;
        sportsman.log(response);
    });

    $scope.sport_category = [];
    $http.get('http://localhost:8080/api/sport_category').then(function (response){
        $scope.sport_category=response.data;
        sport_category.log(response);
    });

    $scope.organizer = [];
    $http.get('http://localhost:8080/api/organizer').then(function (response){
        $scope.organizer=response.data;
        organizer.log(response);
    });

    $scope.sportsman_sport_coach = [];
    $http.get('http://localhost:8080/api/sportsman_sport_coach').then(function (response){
        $scope.sportsman_sport_coach=response.data;
        sportsman_sport_coach.log(response);
    });

    $scope.kind_of_sport = [];
    $http.get('http://localhost:8080/api/kind_of_sport').then(function (response){
        $scope.kind_of_sport=response.data;
        console.log(response);
    });

    $scope.sport_building_sport = [];
    $http.get('http://localhost:8080/api/sport_building_sport').then(function (response){
        $scope.sport_building_sport=response.data;
        sport_building_sport.log(response);
    });

    $scope.sportsman_competition = [];
    $http.get('http://localhost:8080/api/sportsman_competition').then(function (response){
        $scope.sportsman_competition=response.data;
        sportsman_competition.log(response);
    });
    
});

