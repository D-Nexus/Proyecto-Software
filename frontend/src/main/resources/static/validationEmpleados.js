function validateForm() {
    let nombre = document.getElementById('nombre').value;
    let apellidoPaterno = document.getElementById('apellidoPaterno').value;
    let apellidoMaterno = document.getElementById('apellidoMaterno').value;
    let tipoCargo = document.getElementById('tipoCargo').value;
    let sueldoBruto = document.getElementById('sueldoBruto').value;
    let tipoContrato = document.getElementById('tipoContrato').value;
    let fechaIngreso = document.getElementById('fechaIngreso').value;

    if (/\d/.test(nombre)) {
        alert('El nombre no puede contener números.');
        return false;
    }
    if (/\d/.test(apellidoPaterno)) {
        alert('El apellido paterno no puede contener números.');
        return false;
    }
    if (/\d/.test(apellidoMaterno)) {
        alert('El apellido materno no puede contener números.');
        return false;
    }
    if (tipoCargo === "") {
        alert('Debe seleccionar un tipo de cargo.');
        return false;
    }
    if (!/^\d+(\.\d{1,2})?$/.test(sueldoBruto)) {
        alert('El sueldo bruto debe ser un número válido.');
        return false;
    }
    if (tipoContrato === "") {
        alert('Debe seleccionar un tipo de contrato.');
        return false;
    }
    if (!isValidDate(fechaIngreso)) {
        alert('La fecha de ingreso debe ser YYYY-MM-DD.');
        return false;
    }
    if (!isDateAfterMinDate(fechaIngreso, '1946-01-01')) {
        alert('La fecha de ingreso no puede ser menor a 1946-01-01.');
        return false;
    }

    return true;
}

function isValidDate(dateString) {
    const regex = /^\d{4}-\d{2}-\d{2}$/;
    if (!dateString.match(regex)) return false;

    const date = new Date(dateString);
    const timestamp = date.getTime();

    if (typeof timestamp !== 'number' || Number.isNaN(timestamp)) return false;

    return date.toISOString().startsWith(dateString);
}

function isDateAfterMinDate(dateString, minDateString) {
    const date = new Date(dateString);
    const minDate = new Date(minDateString);
    return date >= minDate;
}


