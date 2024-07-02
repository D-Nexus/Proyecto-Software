
function filterTable() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.querySelector(".table");
    tr = table.getElementsByTagName("tr");

    for (i = 1; i < tr.length; i++) {
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
    filterTable();
}

function showAll() {
    var table, tr;
    table = document.querySelector(".table");
    tr = table.getElementsByTagName("tr");

    for (var i = 1; i < tr.length; i++) {
        tr[i].style.display = "";
    }
}

function filterByBono(percentage) {
    var table, tr, td, porcentaje;
    table = document.querySelector(".table");
    tr = table.getElementsByTagName("tr");

    for (var i = 1; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[6]; // Columna de porcentaje (índice 6)
        if (td) {
            porcentaje = parseFloat(td.textContent || td.innerText);
            if (porcentaje === percentage) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }

    exportToExcel(percentage);
}

function filterByBoth() {
    var table, tr, td, porcentaje;
    table = document.querySelector(".table");
    tr = table.getElementsByTagName("tr");

    for (var i = 1; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[6]; // Columna de porcentaje (índice 6)
        if (td) {
            porcentaje = parseFloat(td.textContent || td.innerText);
            if (porcentaje === 25 || porcentaje === 45) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }

    exportToExcel("25_45");
}

function exportToExcel(percentage) {
    let filename;
    if (percentage === "25_45") {
        filename = 'reporte_pagos_25_45.xlsx';
    } else {
        filename = 'reporte_pagos_' + percentage + '%.xlsx';
    }

    const table = document.querySelector('.table');
    const wsData = XLSX.utils.table_to_sheet(table);

    const wb = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, wsData, 'Pagos');

    XLSX.writeFile(wb, filename);
}





