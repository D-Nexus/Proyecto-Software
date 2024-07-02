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
        td = tr[i].getElementsByTagName("td")[6]; // Índice 5 corresponde a la columna de porcentaje de bono
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

function exportToExcel(columns, filename) {
    const table = document.querySelector('.table');
    const rows = table.querySelectorAll('tr');
    const data = [];

    // Obtener los índices de las columnas especificadas
    const columnIndices = [];
    const headerCells = rows[0].querySelectorAll('th');
    columns.forEach(column => {
        for (let i = 0; i < headerCells.length; i++) {
            if (headerCells[i].innerText === column) {
                columnIndices.push(i);
                break;
            }
        }
    });

    // Extraer datos de las columnas especificadas y filtrar por porcentaje 25%
    rows.forEach(row => {
        const cells = row.querySelectorAll('td');
        const percentageCell = cells[6]; // Índice 6 corresponde a la columna de porcentaje
        if (percentageCell && percentageCell.innerText === '10%') {
            const rowData = [];
            columnIndices.forEach(index => {
                rowData.push(cells[index].innerText);
            });
            data.push(rowData);
        }
    });

    // Crear libro y hoja de trabajo
    const wb = XLSX.utils.book_new();
    const ws = XLSX.utils.aoa_to_sheet(data);
    XLSX.utils.book_append_sheet(wb, ws, "Sheet1");

    // Exportar a archivo Excel
    XLSX.writeFile(wb, filename);
}

function exportToExcel2(columns, filename) {
    const table = document.querySelector('.table');
    const rows = table.querySelectorAll('tr');
    const data = [];

    // Obtener los índices de las columnas especificadas
    const columnIndices = [];
    const headerCells = rows[0].querySelectorAll('th');
    columns.forEach(column => {
        for (let i = 0; i < headerCells.length; i++) {
            if (headerCells[i].innerText === column) {
                columnIndices.push(i);
                break;
            }
        }
    });

    // Extraer datos de las columnas especificadas y filtrar por porcentaje 25%
    rows.forEach(row => {
        const cells = row.querySelectorAll('td');
        const percentageCell = cells[6]; // Índice 6 corresponde a la columna de porcentaje
        if (percentageCell && percentageCell.innerText === '25%') {
            const rowData = [];
            columnIndices.forEach(index => {
                rowData.push(cells[index].innerText);
            });
            data.push(rowData);
        }
    });

    // Crear libro y hoja de trabajo
    const wb = XLSX.utils.book_new();
    const ws = XLSX.utils.aoa_to_sheet(data);
    XLSX.utils.book_append_sheet(wb, ws, "Sheet1");

    // Exportar a archivo Excel
    XLSX.writeFile(wb, filename);
}

function exportToExcel3(columns, filename) {
    const table = document.querySelector('.table');
    const rows = table.querySelectorAll('tr');
    const data = [];

    // Obtener los índices de las columnas especificadas
    const columnIndices = [];
    const headerCells = rows[0].querySelectorAll('th');
    columns.forEach(column => {
        for (let i = 0; i < headerCells.length; i++) {
            if (headerCells[i].innerText === column) {
                columnIndices.push(i);
                break;
            }
        }
    });

    // Extraer datos de las columnas especificadas y filtrar por porcentaje 25%
    rows.forEach(row => {
        const cells = row.querySelectorAll('td');
        const percentageCell = cells[6]; // Índice 6 corresponde a la columna de porcentaje
        if (percentageCell && percentageCell.innerText === '45%') {
            const rowData = [];
            columnIndices.forEach(index => {
                rowData.push(cells[index].innerText);
            });
            data.push(rowData);
        }
    });

    // Crear libro y hoja de trabajo
    const wb = XLSX.utils.book_new();
    const ws = XLSX.utils.aoa_to_sheet(data);
    XLSX.utils.book_append_sheet(wb, ws, "Sheet1");

    // Exportar a archivo Excel
    XLSX.writeFile(wb, filename);
}

function exportToExcel4(columns, filename) {
    const table = document.querySelector('.table');
    const rows = table.querySelectorAll('tr');
    const data = [];

    // Obtener los índices de las columnas especificadas
    const columnIndices = [];
    const headerCells = rows[0].querySelectorAll('th');
    columns.forEach(column => {
        for (let i = 0; i < headerCells.length; i++) {
            if (headerCells[i].innerText === column) {
                columnIndices.push(i);
                break;
            }
        }
    });

    // Extraer datos de las columnas especificadas y filtrar por porcentaje 25%
    rows.forEach(row => {
        const cells = row.querySelectorAll('td');
        const percentageCell = cells[6]; // Índice 6 corresponde a la columna de porcentaje
        if (percentageCell && percentageCell.innerText !== '10%') {
            const rowData = [];
            columnIndices.forEach(index => {
                rowData.push(cells[index].innerText);
            });
            data.push(rowData);
        }
    });

    // Crear libro y hoja de trabajo
    const wb = XLSX.utils.book_new();
    const ws = XLSX.utils.aoa_to_sheet(data);
    XLSX.utils.book_append_sheet(wb, ws, "Sheet1");

    // Exportar a archivo Excel
    XLSX.writeFile(wb, filename);
}