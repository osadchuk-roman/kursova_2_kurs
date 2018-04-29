var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sport_arena = [];
    $http.get('http://localhost:8080/api/sport_arena').then(function (response){
        $scope.sport_arena=response.data;
        console.log(response);
    });
    this.del_sport_arena= function del(id) {
        $http.get('/api/sport_arena/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Спортивний манеж було успішно видалено!');
        });
    };

    this.start_insert_sport_arena = function add() {

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

        var selector2 = document.getElementById("Gymnastic");
        $(selector2).empty();

        var option2_1 = document.createElement("option");
        option2_1.text = "Так";
        option2_1.value = true;
        selector2.add(option2_1);

        var option2_2 = document.createElement("option");
        option2_2.text = "Ні";
        option2_2.value = false;
        selector2.add(option2_2);


        var selector3 = document.getElementById("Box");
        $(selector3).empty();

        var option3_1 = document.createElement("option");
        option3_1.text = "Так";
        option3_1.value = true;
        selector3.add(option3_1);

        var option3_2 = document.createElement("option");
        option3_2.text = "Ні";
        option3_2.value = false;
        selector3.add(option3_2);



        var selector4 = document.getElementById("MatirialArts");
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

    this.insert_sport_arena = function add() {
        var indexOfSportBuilding = document.getElementById("SportBuilding").selectedIndex;
        var sportBuildingId = document.getElementById("SportBuilding").options[indexOfSportBuilding].value;

        var indexOfBox = document.getElementById("Box").selectedIndex;
        var box = document.getElementById("Box").options[indexOfBox].value;

        var indexOfGymnastic = document.getElementById("Gymnastic").selectedIndex;
        var gymnastic = document.getElementById("Gymnastic").options[indexOfGymnastic].value;

        var indexOfMatirialArts = document.getElementById("MatirialArts").selectedIndex;
        var matirialArts = document.getElementById("MatirialArts").options[indexOfMatirialArts].value;

        var capacity=document.getElementById("Capacity").value;

        $http.get('/api/sport_arena/insert?sportBuildingId='+sportBuildingId+'&capacity='+capacity
            +'&gymnastic='+gymnastic+'&box='+box+'&matirialArts='+matirialArts).then(function (response){
            window.location.reload();
            window.alert('Спортивний манеж було успішно додано!');
        });

    };
    var thisId;

    this.start_update_sport_arena = function upd(id,sportBuildingName,capacity,gymnastic,box,matirialArts) {
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
                if(sportBuilding[i].name==sportBuildingName)
                    selector.selectedIndex=i;
            }
        });



        var selector2 = document.getElementById("BoxUPD");
        $(selector2).empty();

        var option2_1 = document.createElement("option");
        option2_1.text = "Так";
        option2_1.value = true;
        selector2.add(option2_1);

        var option2_2 = document.createElement("option");
        option2_2.text = "Ні";
        option2_2.value = false;
        selector2.add(option2_2);
        if(box) selector2.selectedIndex=0;
        else selector2.selectedIndex=1;


        var selector3 = document.getElementById("GymnasticUPD");
        $(selector3).empty();

        var option3_1 = document.createElement("option");
        option3_1.text = "Так";
        option3_1.value = true;
        selector3.add(option3_1);

        var option3_2 = document.createElement("option");
        option3_2.text = "Ні";
        option3_2.value = false;
        selector3.add(option3_2);
        if(gymnastic) selector3.selectedIndex=0;
        else selector3.selectedIndex=1;



        var selector4 = document.getElementById("MatirialArtsUPD");
        $(selector4).empty();

        var option4_1 = document.createElement("option");
        option4_1.text = "Так";
        option4_1.value = true;
        selector4.add(option4_1);

        var option4_2 = document.createElement("option");
        option4_2.text = "Ні";
        option4_2.value = false;
        selector4.add(option4_2);
        if(matirialArts) selector4.selectedIndex=0;
        else selector4.selectedIndex=1;

        document.getElementById("CapacityUPD").value=capacity;

    };
    this.update_sport_arena = function upd() {
        var indexOfSportBuilding = document.getElementById("SportBuildingUPD").selectedIndex;
        var sportBuildingId = document.getElementById("SportBuildingUPD").options[indexOfSportBuilding].value;

        var indexOfBox = document.getElementById("BoxUPD").selectedIndex;
        var box = document.getElementById("BoxUPD").options[indexOfBox].value;

        var indexOfGymnastic = document.getElementById("GymnasticUPD").selectedIndex;
        var gymnastic = document.getElementById("GymnasticUPD").options[indexOfGymnastic].value;

        var indexOfMatirialArts = document.getElementById("MatirialArtsUPD").selectedIndex;
        var matirialArts = document.getElementById("MatirialArtsUPD").options[indexOfMatirialArts].value;

        var capacity=document.getElementById("CapacityUPD").value;

        $http.get('/api/sport_arena/update?id='+thisId+'&sportBuildingId='+sportBuildingId+'&capacity='+capacity
            +'&gymnastic='+gymnastic+'&box='+box+'&matirialArts='+matirialArts).then(function (response){
            window.location.reload();
        });

    };
});