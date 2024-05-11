
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
            });
            $("#resultData").html(html);
            $(".ButtonDetalle").click(function () {
                var id = $(this).data("id")
                $("#id").val(id);
                localStorage.setItem("productoId", id)
            })
        },
        error: function (error) {
            console.error("Error en la solicitud:", error);
        },
    });
}



function deleteById(id) {
    console.log("el id es:" + id);
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/ventas/" + id,
        method: "DELETE",
        Headers: {
            "Content-Type": "application/json",
        }
    }).done(function (result) {
        alert("Registro eliminado");
        loadData();
    })
}



// function desactivar(id) {
//     if ($("#estado").val() === "true") {
//         $("#estado").val("false");
//         console.log("antes verdadero");
//     } else if ($("#estado").val() === "false") {
//         $("#estado").val("true");
//         console.log("aqui");
//     }
//     data = {

//         "estado": $("#estado").val(),
//     }

//     var jsondata = JSON.stringify(data)

//     $.ajax({
//         url: "http://localhost:9000/prueba/v1/api/ventas/" + id,
//         method: "PUT",
//         dataType: "json",
//         contentType: "application/json",
//         data: jsondata,
//         success: function (data) {
//             console.log(data.data);
//             alert("registro actualizado con exito");
//             window.location.href = "clientes.html";
//         },
//         error: function (error) {
//             console.log("No se pudo actualizar el registro" + error);
//             alert("No se pudo actualizar el registro")
//         }
//     })
//     console.log("el id es:" + id);
// }

