var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sportsman = [];
    $http.get('http://localhost:8080/api/sportsman').then(function (response){
        $scope.sportsman=response.data;
        console.log(response);
    });
    this.del_sportsman= function del(id) {
        $http.get('/api/sportsman/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Спортсмена "' + response.data.name + '" було успішно видалено!');
        });
    };

    this.start_insert_sportsman = function add() {

        $http.get('/api/sport_club').then(function (response){
            var sportClub = response.data;
            var selector = document.getElementById("SportClub");
            $(selector).empty();
            for (var i = 0; i < sportClub.length; i++) {
                var option = document.createElement("option");
                option.text = sportClub[i].name;
                option.value = sportClub[i].id;
                selector.add(option);
            }
        });

        var selector2 = document.getElementById("Gender");
        $(selector2).empty();

        var option2_1 = document.createElement("option");
        option2_1.text = "чоловіча";
        option2_1.value = "чоловіча";
        selector2.add(option2_1);

        var option2_2 = document.createElement("option");
        option2_2.text = "жіноча";
        option2_2.value = "жіноча";
        selector2.add(option2_2);



    };

    this.insert_sportsman = function add() {
        var name = document.getElementById("Name").value;
        var indexOfSportClub = document.getElementById("SportClub").selectedIndex;
        var sportClubId = document.getElementById("SportClub").options[indexOfSportClub].value;
        var age = document.getElementById("Age").value;
        var indexOfGender = document.getElementById("Gender").selectedIndex;
        var gender = document.getElementById("Gender").options[indexOfGender].value;
        //var gender = document.getElementById("Gender").value;

        $http.get('/api/sportsman/insert?name='+name+'&age='
            +age+'&gender='+gender+'&sportClubId='+sportClubId).then(function (response){
            window.location.reload();
            window.alert('Спортсмена "' + response.data.name + '" було успішно додано!');
        });

    };
    var thisId;

    this.start_update_sportsman = function upd(id,name,age,gender,address) {
        thisId=id;
        var thisIndex;
        $http.get('/api/sport_club').then(function (response){
            var sportClub = response.data;
            var selector = document.getElementById("SportClubUPD");
            $(selector).empty();
            for (var i = 0; i < sportClub.length; i++) {
                var option = document.createElement("option");
                option.text = sportClub[i].name;
                option.value = sportClub[i].id;
                selector.add(option);
            }
        });



        var selector2 = document.getElementById("GenderUPD");
        $(selector2).empty();

        var option2_1 = document.createElement("option");
        option2_1.text = "чоловіча";
        option2_1.value = "чоловіча";
        selector2.add(option2_1);

        var option2_2 = document.createElement("option");
        option2_2.text = "жіноча";
        option2_2.value = "жіноча";
        selector2.add(option2_2);
        document.getElementById("nameUPD").value=name;

        document.getElementById("AgeUPD").value=age;



    };
    this.update_sportsman = function upd() {
        var name = document.getElementById("NameUPD").value;
        var indexOfSportClub = document.getElementById("SportClubUPD").selectedIndex;
        var sportClubId = document.getElementById("SportClubUPD").options[indexOfSportClub].value;
        var age = document.getElementById("AgeUPD").value;
        var indexOfGender = document.getElementById("GenderUPD").selectedIndex;
        var gender = document.getElementById("GenderUPD").options[indexOfGender].value;
        //var gender = document.getElementById("GenderUPD").value;

        $http.get('/api/sportsman/update?id='+thisId+'&name='+name+'&age='
            +age+'&gender='+gender+'&sportClubId='+sportClubId).then(function (response){
            window.location.reload();
            //window.alert('Спортсмена "' + response.data.name + '" було успішно додано!');
        });

    };
});