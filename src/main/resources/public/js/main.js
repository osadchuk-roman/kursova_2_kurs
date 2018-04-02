var app = angular.module("kursova", []);

app.controller("AppCtrl", function($scope, $http){

    /*

   $scope.students = [{
       id: 1,
       firstName: "paul",
       lastName: "mccartney",
       group: 235
   }];

     */



    ///це було розкоментоване
    /$scope.kindOfSport = [];
     $http.get('/api/kind_of_sport').then(function (response){
        $scope.kinfOfSport=response.data;
        console.log(response);
    });
   /* $scope.students = [];
    $http.get('/api/students').then(function (response){
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.students=response.data;
        console.log(response);
    });*/








    // this.delstud = function del(id) {
    //     $http.get('/api/student/del?id='+id).then(function (response){
    //         //  $http.get('http://localhost:8080/api/students').then(function (response){
    //         // $scope.students=response.data;
    //         window.alert('Student ' + response.data.lastName + ' ' + response.data.firstName + ' has been succesfully deleted!');
    //         window.location.reload();
    //     });
    // }
    //
    // $scope.groups = [];
    // $http.get('/api/groups').then(function (response){
    //     //  $http.get('http://localhost:8080/api/students').then(function (response){
    //     $scope.groups=response.data;
    //     console.log(response);
    // });
    //
    //*


    ///це було розкоментоване
    /*this.delchair = function del(id) {
                 $http.get('/api/chair/del?id='+id).then(function (response){
                     window.alert('Chair '  + ' ' +response.data.name + ' ' +response.data.id + ' ' +response.data.abr + ' ' +  ' has been succesfully deleted!');
                     window.location.reload();
                 });
    };*/




});

