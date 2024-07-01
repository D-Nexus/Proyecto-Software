function filterTable() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.querySelector(".table");
    tr = table.getElementsByTagName("tr");

    for (i = 1; i < tr.length; i++) { // Comienza desde 1 para omitir la primera fila (títulos)
        var found = false;
        for (var j = 0; j < tr[i].getElementsByTagName("td").length; j++) {
            td = tr[i].getElementsByTagName("td")[j];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    found = true;
                    break;
                }
            }
        }
        tr[i].style.display = found ? "" : "none";
    }
}

function clearFilter() {
    var input = document.getElementById("searchInput");
    input.value = "";
    filterTable(); // Llama a la función filterTable para mostrar todos los elementos nuevamente
}

function showAll() {
    var table, tr;
    table = document.querySelector(".table");
    tr = table.getElementsByTagName("tr");

    for (var i = 1; i < tr.length; i++) { // Comienza desde 1 para omitir la primera fila (títulos)
        tr[i].style.display = "";
    }
}

function filterByBono(percentage) {
    var table, tr, td, bono, porcentaje;
    table = document.querySelector(".table");
    tr = table.getElementsByTagName("tr");

    for (var i = 1; i < tr.length; i++) { // Comienza desde 1 para omitir la primera fila (títulos)
        td = tr[i].getElementsByTagName("td")[5]; // Índice 5 corresponde a la columna de porcentaje de bono
        if (td) {
            porcentaje = parseFloat(td.textContent || td.innerText);
            if (porcentaje === percentage) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }

}
function exportToExcel() {
    const filename = 'reporte_pagos.xlsx';
    const table = document.querySelector('.table');
    const wsData = XLSX.utils.table_to_sheet(table);

    const wb = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, wsData, 'Pagos');

    XLSX.writeFile(wb, filename);
}
