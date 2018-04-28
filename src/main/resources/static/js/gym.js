var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.gym = [];
    $http.get('http://localhost:8080/api/gym').then(function (response){
        $scope.gym=response.data;
        console.log(response);
    });
    this.del_gym= function del(id) {
        $http.get('/api/gym/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Спортивну залу "' + response.data.sportBuilding.name + '" було успішно видалено!');
        });
    };

    this.start_insert_gym = function add() {

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
        });

        var selector2 = document.getElementById("Cardio");
        $(selector2).empty();

        var option2_1 = document.createElement("option");
        option2_1.text = "Так";
        option2_1.value = true;
        selector2.add(option2_1);

        var option2_2 = document.createElement("option");
        option2_2.text = "Ні";
        option2_2.value = false;
        selector2.add(option2_2);


        var selector3 = document.getElementById("Crossfit");
        $(selector3).empty();

        var option3_1 = document.createElement("option");
        option3_1.text = "Так";
        option3_1.value = true;
        selector3.add(option3_1);

        var option3_2 = document.createElement("option");
        option3_2.text = "Ні";
        option3_2.value = false;
        selector3.add(option3_2);


        var selector4 = document.getElementById("Box");
        $(selector4).empty();

        var option4_1 = document.createElement("option");
        option4_1.text = "Так";
        option4_1.value = true;
        selector4.add(option4_1);

        var option4_2 = document.createElement("option");
        option4_2.text = "Ні";
        option4_2.value = false;
        selector4.add(option4_2);



    };

    this.insert_gym = function add() {
        var indexOfSportBuilding = document.getElementById("SportBuilding").selectedIndex;
        var sportBuildingId = document.getElementById("SportBuilding").options[indexOfSportBuilding].value;

        var indexOfCardio = document.getElementById("Cardio").selectedIndex;
        var cardio = document.getElementById("Cardio").options[indexOfCardio].value;

        var indexOfSportCrossfit = document.getElementById("Crossfit").selectedIndex;
        var crossfit = document.getElementById("Crossfit").options[indexOfSportCrossfit].value;

        var indexOfBox = document.getElementById("Box").selectedIndex;
        var box = document.getElementById("Box").options[indexOfBox].value;

        $http.get('/api/gym/insert?sportBuildingId='+sportBuildingId+'&cardioZone='
            +cardio+'&crossfitZone='+crossfit+'&boxingRing='+box).then(function (response){
            window.location.reload();
            window.alert('Спортивну залу  було успішно додано!');
        });

    };
    var thisId;

    this.start_update_gym = function upd(id,sportBuildingName,cardio,crossfit,box) {
        thisId=id;
        var thisIndex;
        var thisId;
        $http.get('/api/sport_building').then(function (response){
            var sportBuilding = response.data;
            var selector = document.getElementById("SportBuildingUPD");
            $(selector).empty();
            for (var i = 0; i < sportBuilding.length; i++) {
                var option = document.createElement("option");
                option.text = sportBuilding[i].name;
                option.value = sportBuilding[i].id;
                if(sportBuilding[i].name==sportBuildingName){
                    thisIndex=i;
                    thisId=sportBuilding[i].id;
                }
                selector.add(option);
            }
            document.getElementById("SportBuildingUPD").selectedIndex=thisIndex;

        });


        var selector2 = document.getElementById("CardioUPD");
        $(selector2).empty();

        var option2_1 = document.createElement("option");
        option2_1.text = "Так";
        option2_1.value = true;
        selector2.add(option2_1);

        var option2_2 = document.createElement("option");
        option2_2.text = "Ні";
        option2_2.value = false;
        selector2.add(option2_2);
        if (cardio) selector2.selectedIndex=0;
        else selector2.selectedIndex=1;


        var selector3 = document.getElementById("CrossfitUPD");
        $(selector3).empty();

        var option3_1 = document.createElement("option");
        option3_1.text = "Так";
        option3_1.value = true;
        selector3.add(option3_1);

        var option3_2 = document.createElement("option");
        option3_2.text = "Ні";
        option3_2.value = false;
        selector3.add(option3_2);
        if (crossfit) selector3.selectedIndex=0;
        else selector3.selectedIndex=1;


        var selector4 = document.getElementById("BoxUPD");
        $(selector4).empty();

        var option4_1 = document.createElement("option");
        option4_1.text = "Так";
        option4_1.value = true;
        selector4.add(option4_1);

        var option4_2 = document.createElement("option");
        option4_2.text = "Ні";
        option4_2.value = false;
        selector4.add(option4_2);
        if (box) selector4.selectedIndex=0;
        else selector4.selectedIndex=1;


        document.getElementById("SportBuildingUPD").selectedIndex=thisIndex;
        //document.getElementById("SportBuildingUPD").value=thisId;
        //document.getElementById("SportBuildingUPD").text=sportBuildingName;



    };
    this.update_gym = function upd() {
        var indexOfSportBuilding = document.getElementById("SportBuildingUPD").selectedIndex;
        var sportBuildingId = document.getElementById("SportBuildingUPD").options[indexOfSportBuilding].value;

        var indexOfCardio = document.getElementById("CardioUPD").selectedIndex;
        var cardio = document.getElementById("CardioUPD").options[indexOfCardio].value;

        var indexOfSportCrossfit = document.getElementById("CrossfitUPD").selectedIndex;
        var crossfit = document.getElementById("CrossfitUPD").options[indexOfSportCrossfit].value;

        var indexOfBox = document.getElementById("BoxUPD").selectedIndex;
        var box = document.getElementById("BoxUPD").options[indexOfBox].value;

        $http.get('/api/gym/update?id='+thisId+'&sportBuildingId='+sportBuildingId+'&cardioZone='
            +cardio+'&crossfitZone='+crossfit+'&boxingRing='+box).then(function (response){
            window.location.reload();
        });

    };
});