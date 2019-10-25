var datos = []

function standardDeviation(values) {
    let avg = average(values);

    let squareDiffs = values.map(function (value) {
        let diff = value - avg;
        let sqrDiff = diff * diff;
        return sqrDiff;
    });

    let avgSquareDiff = average(squareDiffs);

    return Math.sqrt(avgSquareDiff);
}

function average(data) {
    var sum = data.reduce(function (sum, value) {
        return sum + value;
    }, 0);

    var avg = sum / data.length;
    return avg;
}

$("form").submit((event) => {
    event.preventDefault();
    var dato = {
        id: "",
        valor: 0
    };
    dato.valor = parseFloat($("#valordato").val());
    if (!isNaN(dato.valor)) {
        dato.id = datos.length + 1;
        document.getElementById("tabla").insertRow(-1).innerHTML = '<td>' + dato.id + '</td><td>' + dato.valor + '</td>';
        datos.push(dato);
        console.log(datos.map(e => e.valor));
        console.log(datos);
        var mapped = datos.map(e => e.valor);
        $("#valor").html(standardDeviation(mapped));

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
        var myBar = new Chart(document.getElementById("mycanvas").getContext("2d")).Bar(BarData, opts);
    } else {
        $("#myModal").modal({ backdrop: true });
    }

})

var canvas = $("#mycanvas");
canvas.width(canvas.parent().width());
$("#tabla>tbody").empty();