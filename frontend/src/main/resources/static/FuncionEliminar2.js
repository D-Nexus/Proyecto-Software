function FuncionEliminar2(id) {
    swal({
        title: "¿Esta seguro de eliminar?",
        text: "Una vez eliminado, no se podra deshacer esta acción!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/api/proyectos/Delete/"+id,
                    success:function (res) {
                        console.log(res);
                    },
                });
                swal("Se ha eliminado exitosamente!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok){
                        location.href = "/api/proyectos/Pagina";
                    }
                });
            } else {
                swal("Tu información no sufrio cambios!");
            }
        });
}