-- Ajustar el contador de IDs para que no colision con los IDs anteriores
UPDATE USUARIO_GEN set GEN_VAL=100 WHERE GEN_NAME='USUARIO_GEN';


-- Administrador inicial con login "admin" y contraseña "admin"
INSERT INTO `ADMINISTRADOR` (`ID`,`FECHAALTA`,`LOGIN`,`NOMBRE`,
                             `PASSWORD`,`TIPO_USUARIO`,`ULTIMOACCESO`)
   VALUES (1,'2017-11-11 01:04:42','admin','Administrador inicial',
           'ggm44T97GWJ6Rryx3do4yvl1bZ+gmUfG','ADMINISTRADOR','2017-11-11 01:04:42');

-- Medico con dni "11111111A", num. colegiado "11111" y contraseña "11111"
INSERT INTO `CENTROSALUD` (`ID`,`NOMBRE`,`TELEFONO`,`CODIGOPOSTAL`,
                           `DOMICILIO`,`LOCALIDAD`,`PROVINCIA`)
   VALUES (1,'Centro salud pepe','988888888','12345',
           'C/. Pepe, nº 3','Ourense','Ourense');
INSERT INTO `MEDICO` (`ID`,`APELLIDOS`,`DNI`,`EMAIL`,`FECHAALTA`,`NOMBRE`,
                      `NUMEROCOLEGIADO`,`PASSWORD`,`TELEFONO`,`TIPO_USUARIO`,
                      `ULTIMOACCESO`,`CENTROSALUD_ID`)
   VALUES (2,'Gomez Gomez','11111111A','a@a.com','2017-11-11 01:04:42','Antonio',
           '11111','lUTQ2zg2voe4Z5OqpITFIjcBziNH10d6','988123456','MEDICO',
           '2017-11-11 01:04:42',1);

-- Paciente con dni "22222222B", num. tarjeta sanitaria "2222222222", num seg. social "2222222222222" y contraseña "22222"
INSERT INTO `PACIENTE` (`ID`,`APELLIDOS`,`DNI`,`EMAIL`,`FECHAALTA`,
                        `NOMBRE`,`NUMEROSEGURIDADSOCIAL`,`NUMEROTARJETASANITARIA`,
                        `PASSWORD`,`TELEFONO`,`TIPO_USUARIO`,`ULTIMOACCESO`,
                        `CODIGOPOSTAL`,`DOMICILIO`,`LOCALIDAD`,`PROVINCIA`,`MEDICO_ID`)
   VALUES (3,'Benito Carmona','22222222B','b@b.com','2017-11-11 01:04:42',
           'Ana','2222222222222','2222222222',
           'auJIfVxFAN0IKkDVovGmzfUENiABIC5g','981123456','PACIENTE','2017-11-11 01:04:42',
           '12345','C/. Benito, nº 2, 4º N','Coruña','Coruña',2);

-- Cita con fecha "2017-11-23" y hora "09:00:00"
INSERT INTO `CITA`(`ID`,`DURACION`,`ESTADO`,`FECHA`,`HORA`,`MEDICO_ID`,`PACIENTE_ID`)
   VALUES (1, 15, 'PLANIFICADA', '2017-11-23', '09:00:00', '2', '3');

-- Farmacia con nif "33333333C" y contraseña "33333"
INSERT INTO `FARMACIA`(`ID`,`FECHAALTA`,`NIF`,`NOMBREFARMACIA`,
                       `PASSWORD`,`TIPO_USUARIO`,`ULTIMOACCESO`,
                       `CODIGOPOSTAL`,`DOMICILIO`,`LOCALIDAD`,`PROVINCIA`)
   VALUES (4,'2017-11-11 01:04:42','33333333C','Farmacia de prueba',
           '/QpUw+ZRH3ndoNb3N4gRpT5cz0C7pT9v','FARMACIA','2017-11-11 01:04:42',
           '12345','C/. Farmacia, nº 2, 4º N','Coruña','Coruña');


		   -- 
-- Volcado de datos para la tabla `MEDICAMENTO`
--

INSERT INTO `MEDICAMENTO` (`ID`, `FABRICANTE`, `FAMILIA`, `NOMBRE`, `NUMERODOSIS`, `PRINCIPIOACTIVO`) VALUES
(1, 'Cinfa', 'Antiinflamatorios', 'Ibuprofeno', 3, 'Ibuprofeno');

-- --------------------------------------------------------
--
-- Volcado de datos para la tabla `CITA`
--

INSERT INTO `CITA` (`ID`, `DURACION`, `ESTADO`, `FECHA`, `HORA`, `MEDICO_ID`, `PACIENTE_ID`) VALUES

(2, 15, 'PLANIFICADA', '2019-01-14', '09:00:00', 2, 3),
(3, 15, 'PLANIFICADA', '2019-01-15', '09:00:00', 2, 3),
(4, 15, 'PLANIFICADA', '2019-01-16', '09:00:00', 2, 3),
(5, 15, 'PLANIFICADA', '2019-01-17', '09:00:00', 2, 3),
(6, 15, 'PLANIFICADA', '2019-01-18', '09:00:00', 2, 3),
(7, 15, 'PLANIFICADA', '2019-01-19', '09:00:00', 2, 3),
(8, 15, 'PLANIFICADA', '2019-01-20', '09:00:00', 2, 3),
(9, 15, 'PLANIFICADA', '2019-01-21', '09:00:00', 2, 3),
(10, 15, 'PLANIFICADA', '2019-01-22', '09:00:00', 2, 3),
(11, 15, 'PLANIFICADA', '2019-01-23', '09:00:00', 2, 3),
(12, 15, 'PLANIFICADA', '2019-01-24', '09:00:00', 2, 3),
(13, 15, 'PLANIFICADA', '2019-01-25', '09:00:00', 2, 3),
(14, 15, 'PLANIFICADA', '2019-01-26', '09:00:00', 2, 3),
(15, 15, 'PLANIFICADA', '2019-01-27', '09:00:00', 2, 3),
(16, 15, 'PLANIFICADA', '2019-01-28', '09:00:00', 2, 3),
(17, 15, 'PLANIFICADA', '2019-01-29', '09:00:00', 2, 3),
(18, 15, 'PLANIFICADA', '2019-01-30', '09:00:00', 2, 3),
(19, 15, 'PLANIFICADA', '2019-01-31', '09:00:00', 2, 3),
(20, 15, 'PLANIFICADA', '2019-02-01', '09:00:00', 2, 3),
(21, 15, 'PLANIFICADA', '2019-02-02', '09:00:00', 2, 3),
(22, 15, 'PLANIFICADA', '2019-01-12', '09:00:00', 2, 3),
(23, 15, 'PLANIFICADA', '2019-01-13', '09:00:00', 2, 3);

-- --------------------------------------------------------


--
-- Volcado de datos para la tabla `PRESCRIPCION`
--

INSERT INTO `PRESCRIPCION` (`ID`, `DOSIS`, `FECHAFIN`, `FECHAINICIO`, `INDICACIONES`, `MEDICAMENTO_ID`, `MEDICO_ID`, `PACIENTE_ID`) VALUES
(1, 5, '2019-02-20', '2019-01-10', NULL, 1, 2, 3);

-- --------------------------------------------------------
--
-- Volcado de datos para la tabla `RECETA`
--
INSERT INTO `RECETA` (`ID`, `CANTIDAD`, `ESTADORECETA`, `FINVALIDEZ`, `INICIOVALIDEZ`, `FARMACIADISPENSADORA_ID`, `PRESCRIPCION_ID`) VALUES ('1', '5', 'GENERADA', '2019-02-28', '2019-01-10', NULL, '1');
