var findStudents = function () {
    var chair = $("#chair").val();
    $.ajax({
        url: "http://localhost:8080/byChair?chair=" + chair
    }).then(
        function (value) {
            console.log(value);
            printTable(value)
        }
    )
};

var printTable = function (array) {
    var str = "";
    str += "<tr>";
    for (field1 in array[0]) {
        str += "<td>";
        str += field1;
        str += "</td>";
    }
    str += "</tr>";
    console.log(str);
    for (var i = 0; i < array.length; i++) {
        str += "<tr>";
        for (field in array[i]) {
            str += "<td>";
            if (field != "chair") {
                str += array[i][field];
            } else {
                str += array[i][field].name;
            }
            str += "</td>";
        }
        str += "</tr>";
    }
    console.log(str);
    $("#resultTable").append(str);

}