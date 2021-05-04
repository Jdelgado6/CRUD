function eliminar(id) {

    swal({
        title: "Estás seguro que desea eliminar??",
        text: "Esto se eliminara de forma permanente",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/eliminar/" + id, success:function (res) {
                        console.log(res);
                    }
                });
                swal("Se ha eliminado con éxito!!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/";
                    }

                });
            } else {
                swal("No se pudo eliminar el registro");
            }
        });
}