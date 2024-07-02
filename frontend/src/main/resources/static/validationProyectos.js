function validateForm() {
    let nombre = document.getElementById('nombreProyecto').value;
    let comuna = document.getElementById('comuna').value;
    let cantEmpleados = document.getElementById('cantEmpleados').value;
    let fechaInicio = document.getElementById('fechaInicio').value;
    let fechaTerminoPactada = document.getElementById('fechaTerminoPactada').value;
    let fechaTerminoReal = document.getElementById('fechaTerminoReal').value;
    let estado = document.getElementById('estado').value;

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
    if (!isDateAfterMinDate(fechaInicio, '1946-01-01')) {
        alert('La fecha de inicio no puede ser menor a 1946-01-01.');
        return false;
    }
    if (!isDateAfterMinDate(fechaTerminoPactada, '1946-01-01')) {
        alert('La fecha de término pactada no puede ser menor a 1946-01-01.');
        return false;
    }
    if (!isStartDateBeforeEndDate(fechaInicio, fechaTerminoPactada)) {
        alert('La fecha de inicio debe ser anterior a la fecha de término pactada.');
        return false;
    }
    if (estado === "Terminado" && fechaTerminoReal === "") {
        alert('No se puede marcar como "Terminado" sin una fecha de término real.');
        return false;
    }
    if (fechaTerminoReal) {
        if (!isValidDate(fechaTerminoReal)) {
            alert('La fecha de término real debe ser YYYY-MM-DD.');
            return false;
        }
        if (!isDateAfterMinDate(fechaTerminoReal, '1946-01-01')) {
            alert('La fecha de término real no puede ser menor a 1946-01-01.');
            return false;
        }
        if (!isStartDateBeforeEndDate(fechaInicio, fechaTerminoReal)) {
            alert('La fecha de término real debe ser posterior a la fecha de inicio.');
            return false;
        }
        if (estado === "En Proceso") {
            alert('No se puede marcar como "En Proceso" si hay una fecha de término real.');
            return false;
        }
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

function isStartDateBeforeEndDate(startDate, endDate) {
    const start = new Date(startDate);
    const end = new Date(endDate);
    return start < end;
}

function isDateAfterMinDate(dateString, minDateString) {
    const date = new Date(dateString);
    const minDate = new Date(minDateString);
    return date >= minDate;
}
