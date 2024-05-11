function countClientes() {
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/clientes/count",
        method: "GET",
        dataType: "JSON",
        success: function (success) {
            var cantidad = success
            $("#numeroCliente").val(cantidad);
        }
    })
}

function countVentas() {
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/ventas/count",
        method: "GET",
        dataType: "JSON",
        success: function (success) {
            var cantidad = success
            $("#numeroVentas").val(cantidad);
        }
    })
}
function countProductos() {
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/productos/count",
        method: "GET",
        dataType: "JSON",
        success: function (success) {
            var cantidad = success
            $("#numeroProductos").val(cantidad);
        }
    })
}

function count() {
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/productos/cantidad",
        method: "GET",
        DataType: "JSON",
        success: function (response) {
            var html = ""
            var data = response.data
            data.forEach(function (item) {
                html += `<tr>
                <td>` + item.id + `</td>
                <td>` + item.nombreProducto + `</td>
                <td>` + item.cantidad + `</td>
                </tr>`;
            });
            $("#resultData").html(html);
            console.log(html);

        }
    })
}