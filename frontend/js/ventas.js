function loadData() {
    console.log("ejecutando loadData");

    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/ventas",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log(response.data);
            var html = "";
            var data = response.data;
            data.forEach(function (item) {
                html +=
                    `<tr>
                    <td>` + item.id + `</td>
                    <td>` + item.cliente.id + `</td>
                    <td>` + item.total + `</td>
                    <td>` + item.fechaVenta + `</td>
                    <td>` + item.estado + `</td>
                    <td><button  class="ButtonDetalle buttonLista" data-id="${item.id}">Ver Detalle</button>
                        </td>
                    </tr>`;
                console.log(item.id);
            });
            $("#resultData").html(html);
            $(".ButtonDetalle").click(function () {
                var id = $(this).data("id")
                $("#id").val(id);
                localStorage.setItem("ventaId", id)
            })
        },
        error: function (error) {
            console.error("Error en la solicitud:", error);
        },
    });
}

function filter() {
    var data = {
        "nombre": $("#filtername").val(),
        "fechaInicio": $("#FilterDatefrom").val(),
        "fechaFin": $("#FilterDateto").val()
    }
    var DataJson = JSON.stringify(data);
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/ventas/filter",
        method: "POST",
        dataType: "JSON",
        contentType: "application/Json",
        data: DataJson,
        success: function (response) {
            console.log(response.data);
            var html = "";
            var data = response.data;
            data.forEach(function (item) {
                html +=
                    `<tr>
                    <td>` + item.id + `</td>
                    <td>` + item.cliente.id + `</td>
                    <td>` + item.total + `</td>
                    <td>` + item.fechaVenta + `</td>
                    <td>` + item.estado + `</td>
                    <td><button  class="ButtonDetalle buttonLista" data-id="${item.id}">Ver Detalle</button>
                        </td>
                    </tr>`;
            })
            $("#resultData").html(html);
        }
    })

}