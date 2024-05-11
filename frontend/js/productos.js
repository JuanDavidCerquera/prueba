
function loadData() {
    console.log("ejecutando loadData");
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/productos",
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
                    <td>` + item.nombreProducto + `</td>
                    <td>` + item.descripcion + `</td>
                    <td>` + item.cantidad + `</td>
                    <td>` + item.precio + `</td>
                    <td>` + item.porcentajeIva + `</td>
                    <td>` + item.porcentajeDescuento + `</td>
                    <td>` + item.estado + `</td>
                    <td><button  class="ButtonEditar buttonLista" data-id="${item.id}">Editar</button>
                        <button class="ButtonEliminar buttonLista" data-id="${item.id}">Eliminar</button>
                        <button class="ButtonDesactivar buttonLista" data-id="${item.id}">Desactivar</button>
                        </td>
                    </tr>`;
            });
            $("#resultData").html(html);
            $(".ButtonEditar").click(function () {
                var id = $(this).data("id")
                $("#id").val(id);
                localStorage.setItem("productoId", id)
                window.location.href = "agregarProductos.html";

            })

            $(".ButtonEliminar").click(function () {
                var id = $(this).data("id")
                $("#id").val(id);
                deleteById(id)
            })

            $(".ButtonDesactivar").click(function () {
                var id = $(this).data("id")
                $("#id").val(id);
                desactivar(id);
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
        url: "http://localhost:9000/prueba/v1/api/productos/" + id,
        method: "DELETE",
        Headers: {
            "Content-Type": "application/json",
        }
    }).done(function (result) {
        alert("Registro eliminado");
        loadData();
    })
}


function desactivar(id) {
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/productos/estate/" + id,
        method: "PUT",
        dataType: "json",
        success: function (data) {
            console.log(data.data);
            alert("registro actualizado con exito");
            loadData();
        },
        error: function (error) {
            console.log("No se pudo actualizar el registro" + error);
            alert("No se pudo actualizar el registro")
        }
    })
    console.log("el id es:" + id);
}

function filtrar() {
    var data = {
        "nombre": $("#filtername").val(),
        "estado": $("#estados").val(),
    }
    var DataJson = JSON.stringify(data);
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/productos/filter",
        method: "POST",
        dataType: "JSON",
        contentType: "application/json",
        data: DataJson,
        success: function (response) {
            var html = ""
            var data = response.data
            data.forEach(function (item) {
                html += `<tr>
                <td>` + item.id + `</td>
                <td>` + item.tipo_identificaion + `</td>
                <td>` + item.identificacion + `</td>
                <td>` + item.nombre + `</td>
                <td>` + item.apellido + `</td>
                <td>` + item.telefono + `</td>
                <td>` + item.direccion + `</td>
                <td>` + item.ciudad + `</td>
                <td>` + item.estado + `</td>
                <td><button  class="ButtonEditar buttonLista" data-id="${item.id}">Editar</button>
                    <button class="ButtonEliminar buttonLista" data-id="${item.id}">Eliminar</button>
                    <button class="ButtonDesactivar buttonLista" data-id="${item.id}">Desactivar</button>
                    </td>
                </tr>`;
            })
            $("#resultData").html(html);
            console.log(response);
            $(".ButtonEditar").click(function () {
                var id = $(this).data("id")
                $("#id").val(id);
                localStorage.setItem("productoId", id)
                window.location.href = "agregarProductos.html";

            })

            $(".ButtonEliminar").click(function () {
                var id = $(this).data("id")
                $("#id").val(id);
                deleteById(id)
            })

            $(".ButtonDesactivar").click(function () {
                var id = $(this).data("id")
                $("#id").val(id);
                desactivar(id);
            })
        },
        error: function (error) {
            console.log(error);
        }
    })
}