var datos = [];


$("#agregar").click(() => {

    var dato = {
        id: "",
        valor: 0
    };
    dato.valor = parseFloat($("#valordato").val());
    if (!isNaN(dato.valor)) {
        dato.id = datos.length + 1;
        document.getElementById("tabla").insertRow(-1).innerHTML = '<td>' + dato.id + '</td><td>' + dato.valor + '</td>';
        datos.push(dato);
        var mapped = datos.map(e => e.valor);

        $.post("./backend/process.php", { datos: mapped }, function (response) {
            $("#valor").html(response);
        })

        var BarData = {
            labels: datos.map(e => e.id),
            datasets: [
                {
                    fillColor: "rgba(129, 172, 123, 0.5)",
                    strokeColor: "rgba(129, 172, 123, 1)",
                    pointColor: "rgba(129, 172, 123, 1)",
                    drawMathDeviation: "stddev",
                    deviationStrokeColor: "#000",
                    deviationWidth: 10,
                    data: mapped,
                    title: "Datos"
                }
            ]
        }

        var opts = {
            inGraphDataShow: true, inGraphDataTmpl: '<%=meanDif(2)%>', bezierCurve: false, savePng: false, legend: true
        };
        new Chart(document.getElementById("mycanvas").getContext("2d")).Bar(BarData, opts);
    } else {
        $("#myModal").modal();
        $('#myModal').modal('open');

    }

})
$(document).ready(function () {
    M.updateTextFields();
});
var canvas = $("#mycanvas");
canvas.width(canvas.parent().width());
$("#tabla>tbody").empty();