function validateForm() {
    let nombre = document.getElementById('nombre').value;
    let comuna = document.getElementById('apellidoPaterno').value;
    let cantEmpleados = document.getElementById('apellidoMaterno').value;
    let fechaInicio = document.getElementById('tipoCargo').value;
    let fechaTerminoPactada = document.getElementById('sueldoBruto').value;
    let fechaTerminoReal = document.getElementById('tipoContrato').value;

    if (/\d/.test(nombre)) {
        alert('El nombre no puede contener números.');
        return false;
    }
    if (/\d/.test(comuna)) {
        alert('La comuna no puede contener números.');
        return false;
    }
    if (!/^\d+$/.test(cantEmpleados)) {
        alert('La cantidad de empleados debe ser un número.');
        return false;
    }
    if (!isValidDate(fechaInicio)) {
        alert('La fecha de inicio debe ser YYYY-MM-DD.');
        return false;
    }
    if (!isValidDate(fechaTerminoPactada)) {
        alert('La fecha de término pactada debe ser una fecha válida.');
        return false;
    }
    if (!isValidDate(fechaTerminoReal)) {
        alert('La fecha de término real debe ser una fecha válida.');
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
