
function loadData() {
    console.log("ejecutando loadData");
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/clientes",
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
                    <td>` + item.tipo_identificaion + `</td>
                    <td>` + item.identificacion + `</td>
                    <td>` + item.nombre + `</td>
                    <td>` + item.apellido + `</td>
                    <td>` + item.telefono + `</td>
                    <td>` + item.direccion + `</td>
                    <td>` + item.ciudad + `</td>
                    <td><button  class="botonLista">Editar</button>
                        <button class="botonLista">Eliminar</button>
                        <button class="botonLista">desactivar</button>
                        </td>
                    </tr>`;
            });
            $("#resultData").html(html);
        },
        error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        },
    });
}
