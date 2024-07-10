-- Antes de ejecutar deben crear la base de datos proyectobdd y asignarla por default con click derecho sobre ella y seleccionan "Set as default schema", luego ejecutan.


-- Insertar datos en la tabla empleados (reordenado)
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('17.920.971-2','Juan', 'Perez', 'Gomez', 'Empleado de Planta', 500000, '2020-01-15', 'Contrato por obra');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('11.420.671-2','Ana', 'Martinez', 'Lopez', 'Ingeniero Civil de Obras', 1500000, '2018-03-20', 'Contrato por obra');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('16.920.971-2','Carlos', 'Garcia', 'Fernandez', 'Ingeniero en Construcción', 1400000, '2019-07-10', 'Contrato indefinido');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('12.920.971-2','Maria', 'Rodriguez', 'Diaz', 'Arquitecto', 1300000, '2021-05-25', 'Contrato por obra');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('18.220.371-2','Luis', 'Hernandez', 'Ramirez', 'Personal Administrativo', 700000, '2022-02-17', 'Contrato indefinido');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('10.920.971-2','Jose', 'Lopez', 'Sanchez', 'Empleado de Planta', 520000, '2020-03-22', 'Contrato por obra');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('13.320.971-2','Lucia', 'Perez', 'Gomez', 'Ingeniero Civil de Obras', 1550000, '2018-05-30', 'Contrato indefinido');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('19.920.271-2','Miguel', 'Garcia', 'Fernandez', 'Ingeniero en Construcción', 1450000, '2019-09-15', 'Contrato indefinido');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('16.120.471-2','Elena', 'Rodriguez', 'Diaz', 'Arquitecto', 1350000, '2021-07-18', 'Contrato indefinido');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('12.720.971-2','Jorge', 'Hernandez', 'Ramirez', 'Personal Administrativo', 710000, '2022-04-28', 'Contrato por obra');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('22.920.571-2','Pedro', 'Lopez', 'Sanchez', 'Empleado de Planta', 540000, '2020-05-10', 'Contrato indefinido');
INSERT INTO empleados (rut,nombre, apellido_paterno, apellido_materno, tipo_cargo, sueldo_bruto, fecha_ingreso, tipo_contrato) VALUES ('21.120.971-2','Laura', 'Perez', 'Gomez', 'Ingeniero Civil de Obras', 1600000, '2018-08-25', 'Contrato por obra');


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

-- Insertar registros
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (2, 2, 'Sí', '10%', 150000, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (3, 4, 'Sí', '25%', 350000, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (4, 5, 'Sí', '45%', 585000, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (5, 6, 'Sí', '10%', 70000, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (6, 7, 'Sí', '25%', 130000, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (7, 8, 'Sí', '45%', 697500, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (8, 9, 'Sí', '10%', 155000, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (9, 10, 'Sí', '25%', 337500, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (10, 11, 'Sí', '45%', 319500, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (11, 12, 'Sí', '10%', 54000, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (12, 1, 'Sí', '25%', 400000, 'Aprobado');
INSERT INTO registros (id_empleado, id_proyecto, Recibe_Bono, porcentaje, monto_Bono, estado) VALUES (1, 2, 'Sí', '45%', 225000, 'Aprobado');

