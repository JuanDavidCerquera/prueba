function save() {

    data = {
        "nombreProducto": $("#nombreProducto").val(),
        "descripcion": $("#descripcion").val(),
        "cantidad": $("#cantidad").val(),
        "precio": $("#precio").val(),
        "porcentajeIva": $("#porcentajeIva").val(),
        "porcentajeDescuento": $("#porcentajeDescuento").val(),
        "estado": $("#estado").val(),
    }

    var jsondata = JSON.stringify(data)

    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/productos",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: jsondata,
        success: function (data) {
            console.log(data.data);
            alert("registro agregado con exito");
            window.location.href = "clientes.html";
        },
        error: function (error) {
            console.log("No se pudo agregar el registro" + error);
            alert("No se pudo agregar el registro")
        }
    })
}


function findById() {
    var id = localStorage.getItem("productoId");
    if (id != null) {
        $(".botonagregar").text("actualizar");
        $(".botonagregar").attr("onclick", "update()");
    }
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/productos/" + id,
        method: "GET",
        dataType: "json",
        success: function (response) {
            var data = response.data;
            console.log(data);
            $("#nombreProducto").val(data.nombreProducto),
                $("#descripcion").val(data.descripcion),
                $("#cantidad").val(data.cantidad),
                $("#precio").val(data.precio),
                $("#porcentajeIva").val(data.porcentajeIva),
                $("#porcentajeDescuento").val(data.porcentajeDescuento),
                $("#estado").val(data.estado)
        },

    })


}

function update() {
    var id = localStorage.getItem("productoId");
    data = {
        "nombreProducto": $("#nombreProducto").val(),
        "descripcion": $("#descripcion").val(),
        "cantidad": $("#cantidad").val(),
        "precio": $("#precio").val(),
        "porcentajeIva": $("#porcentajeIva").val(),
        "porcentajeDescuento": $("#porcentajeDescuento").val(),
        "estado": $("#estado").val(),
    }

    var jsondata = JSON.stringify(data)

    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/productos/" + id,
        method: "PUT",
        dataType: "json",
        contentType: "application/json",
        data: jsondata,
        success: function (data) {
            console.log(data.data);
            alert("registro actualizado con exito");
            window.location.href = "clientes.html";
        },
        error: function (error) {
            console.log("No se pudo actualizar el registro" + error);
            alert("No se pudo actualizar el registro")
        }
    })
    localStorage.setItem("productoId", null);
    window.location.href = "productos.html";
}
