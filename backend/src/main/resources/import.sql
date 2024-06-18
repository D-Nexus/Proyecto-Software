-- Antes de ejecutar deben crear la base de datos proyectobdd y asignarla por default con click derecho sobre ella y seleccionan "Set as default schema", luego ejecutan.


-- Insertar datos en la tabla empleados (reordenado)
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Juan', 'Perez', 'Gomez', 'Empleado de Planta', 500000, '2020-01-15', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Ana', 'Martinez', 'Lopez', 'Ingeniero Civil de Obras', 1500000, '2018-03-20', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Carlos', 'Garcia', 'Fernandez', 'Ingeniero en Construcción', 1400000, '2019-07-10', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Maria', 'Rodriguez', 'Diaz', 'Arquitecto', 1300000, '2021-05-25', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Luis', 'Hernandez', 'Ramirez', 'Personal Administrativo', 700000, '2022-02-17', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Jose', 'Lopez', 'Sanchez', 'Empleado de Planta', 520000, '2020-03-22', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Lucia', 'Perez', 'Gomez', 'Ingeniero Civil de Obras', 1550000, '2018-05-30', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Miguel', 'Garcia', 'Fernandez', 'Ingeniero en Construcción', 1450000, '2019-09-15', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Elena', 'Rodriguez', 'Diaz', 'Arquitecto', 1350000, '2021-07-18', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Jorge', 'Hernandez', 'Ramirez', 'Personal Administrativo', 710000, '2022-04-28', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Pedro', 'Lopez', 'Sanchez', 'Empleado de Planta', 540000, '2020-05-10', 'Indefinido');
INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('Laura', 'Perez', 'Gomez', 'Ingeniero Civil de Obras', 1600000, '2018-08-25', 'Indefinido');


-- Insertar datos en la tabla proyectos (reordenado)
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Edificio Central', 'Santiago', 100, '2021-01-10', '2022-12-20', '2022-12-15', 'Terminado');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Puente Norte', 'Valparaíso', 200, '2020-03-15', '2023-03-01', '2023-02-28', 'En Progreso');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Hospital Sur', 'Concepción', 150, '2019-07-20', '2022-07-30', '2022-07-25', 'Terminado');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Parque Oriente', 'La Serena', 250, '2018-05-25', '2021-05-10', '2021-05-05', 'Terminado');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Aeropuerto', 'Antofagasta', 300, '2022-02-01', '2024-01-15', '2024-01-10', 'En Progreso');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Centro Cultural', 'Temuco', 80, '2021-10-05', '2023-10-20', '2023-10-15', 'En Progreso');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Biblioteca Municipal', 'Rancagua', 90, '2019-12-10', '2021-12-25', '2021-12-20', 'Terminado');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Planta Solar', 'Iquique', 400, '2018-08-15', '2022-08-30', '2022-08-25', 'Terminado');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Estadio Nacional', 'Santiago', 500, '2020-04-10', '2023-04-15', '2023-04-10', 'En Progreso');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Puerto Sur', 'Valdivia', 120, '2021-06-20', '2024-06-25', '2024-06-20', 'En Progreso');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Centro Deportivo', 'Chillán', 60, '2019-11-15', '2021-11-30', '2021-11-25', 'Terminado');
INSERT INTO proyectos (nombre_proyecto, comuna, cant_empleados, fecha_inicio, fecha_termino_pactada, fecha_termino_real, estado) VALUES ('Terminal de Buses', 'Arica', 70, '2022-09-10', '2024-09-15', '2024-09-10', 'En Progreso');


-- Insertar datos en la tabla Registro
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '10%', 50000, 'Aprobado', 1, 1,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '25%', 125000, 'Aprobado', 2, 2,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '45%', 225000, 'Aprobado', 3, 3,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '10%', 45000, 'Aprobado', 4, 4,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '25%', 75000, 'Aprobado', 5, 5,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '45%', 135000, 'Aprobado', 6, 6,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '10%', 50000, 'Aprobado', 7, 7,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '25%', 125000, 'Aprobado', 8, 8,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '45%', 225000, 'Aprobado', 9, 9,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '10%', 45000, 'Aprobado', 10, 10,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '25%', 75000, 'Aprobado', 11, 11,1000);
INSERT INTO registros (recibe_bono, porcentaje, monto_bono, estado, id_empleado, id_proyecto,sueldo_Con_Bono) VALUES ('Si', '45%', 135000, 'Aprobado', 12, 12,1000);