var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.stadium = [];
    $http.get('http://localhost:8080/api/stadium').then(function (response){
        $scope.stadium=response.data;
        console.log(response);
    });
    this.del_stadium= function del(id) {
        $http.get('/api/stadium/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Стадіон №"' + response.data.id + '" було успішно видалено!');
        });
    };

    this.start_insert_stadium = function add() {

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

        var selector2 = document.getElementById("Path");
        $(selector2).empty();

        var option2_1 = document.createElement("option");
        option2_1.text = "Так";
        option2_1.value = true;
        selector2.add(option2_1);

        var option2_2 = document.createElement("option");
        option2_2.text = "Ні";
        option2_2.value = false;
        selector2.add(option2_2);


        var selector3 = document.getElementById("Gymnastic");
        $(selector3).empty();

        var option3_1 = document.createElement("option");
        option3_1.text = "Так";
        option3_1.value = true;
        selector3.add(option3_1);

        var option3_2 = document.createElement("option");
        option3_2.text = "Ні";
        option3_2.value = false;
        selector3.add(option3_2);
    };

    this.insert_stadium = function add() {
        var indexOfSportBuilding = document.getElementById("SportBuilding").selectedIndex;
        var sportBuildingId = document.getElementById("SportBuilding").options[indexOfSportBuilding].value;

        var indexOfPath = document.getElementById("Path").selectedIndex;
        var path = document.getElementById("Path").options[indexOfPath].value;

        var indexOfGymnastic = document.getElementById("Gymnastic").selectedIndex;
        var gymnastic = document.getElementById("Gymnastic").options[indexOfGymnastic].value;

        var capacity=document.getElementById("Capacity").value;
        var fieldArea=document.getElementById("FieldArea").value;

        $http.get('/api/stadium/insert?sportBuildingId='+sportBuildingId+'&capacity='
            +capacity+'&fieldArea='+fieldArea+'&pathForRunning='+path+'&gymnasticZone='+gymnastic).then(function (response){
            window.location.reload();
            window.alert('Стадіон було успішно додано!');
        });

    };
    var thisId;

    this.start_update_stadium = function upd(id,sportBuildingName,capacity,fieldArea,path,gymnastic) {
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

        var selector2 = document.getElementById("PathUPD");
        $(selector2).empty();

        var option2_1 = document.createElement("option");
        option2_1.text = "Так";
        option2_1.value = true;
        selector2.add(option2_1);

        var option2_2 = document.createElement("option");
        option2_2.text = "Ні";
        option2_2.value = false;
        selector2.add(option2_2);
        if(path) selector2.selectedIndex=0;
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

        document.getElementById("CapacityUPD").value=capacity;
        document.getElementById("FieldAreaUPD").value=fieldArea;


    };
    this.update_stadium = function upd() {
        var indexOfSportBuilding = document.getElementById("SportBuildingUPD").selectedIndex;
        var sportBuildingId = document.getElementById("SportBuildingUPD").options[indexOfSportBuilding].value;

        var indexOfPath = document.getElementById("PathUPD").selectedIndex;
        var path = document.getElementById("PathUPD").options[indexOfPath].value;

        var indexOfGymnastic = document.getElementById("GymnasticUPD").selectedIndex;
        var gymnastic = document.getElementById("GymnasticUPD").options[indexOfGymnastic].value;

        var capacity=document.getElementById("CapacityUPD").value;
        var fieldArea=document.getElementById("FieldAreaUPD").value;


        $http.get('/api/stadium/update?id='+thisId+'&sportBuildingId='+sportBuildingId+'&capacity='
            +capacity+'&fieldArea='+fieldArea+'&pathForRunning='+path+'&gymnasticZone='+gymnastic).then(function (response){
            window.location.reload();
        });

    };
});