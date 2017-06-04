INSERT INTO USUARIO VALUES(2, 'gordo porras', '$2a$04$Uqd2b/WV0DHif1RdiXSPqeTkT79pT6ezLSQ6JJ6zosk0OXDwm9jjC', 'paco@algo.com',0, 'paco', 'MED', '91685336', 'medico')
INSERT INTO USUARIO VALUES(1, 'gordo porras1', '$2a$04$Uqd2b/WV0DHif1RdiXSPqeTkT79pT6ezLSQ6JJ6zosk0OXDwm9jjC', 'paco@algo.com1',0, 'paco1', 'MED', '916853361', 'medico1')
INSERT INTO USUARIO VALUES(5, 'Gordo Porras', '$2a$04$Uqd2b/WV0DHif1RdiXSPqeTkT79pT6ezLSQ6JJ6zosk0OXDwm9jjC', 'paco@algo.com',0, 'Paco', 'PAC', '91685336', 'paciente')
INSERT INTO USUARIO VALUES(4, 'gordo porras', '$2a$04$Uqd2b/WV0DHif1RdiXSPqeTkT79pT6ezLSQ6JJ6zosk0OXDwm9jjC', 'paco@algo.com',0, 'paco', 'FAR', '91685336', 'farma')
INSERT INTO USUARIO VALUES(8, 'gordo porras', '$2a$04$Uqd2b/WV0DHif1RdiXSPqeTkT79pT6ezLSQ6JJ6zosk0OXDwm9jjC', 'paco@algo.com',0, 'paco', 'ADMIN', '91685336', 'admin')

INSERT INTO MEDICO VALUES ( 'C.S La alameda', '12/12/200057', 2)
INSERT INTO MEDICO VALUES ( 'C.S La alameda', '12/12/200057', 1)
INSERT INTO FARMACEUTICO VALUES ( '12/15/20007', 4)
INSERT INTO PACIENTE VALUES ( 'Coslada', '28822',324, '011452247', 'Madrid', 'Calle falsa 1234', '05/19', 0, 47558226334,'Madrid', 5, 2)

INSERT INTO FARMACIA VALUES ( 1, 'Madrid', '28045', 'Madrid', 'calle falsa 1234', 0 , 'farmacia Bonita' , 'madrid', '916752335', 4)
INSERT INTO FARMACIA VALUES ( 2, 'Pinto', '28475', 'Madrid', 'calle nueva 1234', 0 , 'farmacia Fea' , 'madrid', '916321447', 4)

INSERT INTO MEDICAMENTO VALUES (6527634, '400 MG 30 SOBRES', 'ZAMBON', 'ESPIDIFEN', 4.62);
INSERT INTO MEDICAMENTO VALUES (7024491, '500 MG 20 COMPRIMIDOS', 'BAYER', 'ASPIRINA', 3.36);
INSERT INTO MEDICAMENTO VALUES (9676384, '1 G 30 COMPRIMIDOS', 'EFERVESCENTE BAYER', 'REDOXON', 6.38);
INSERT INTO MEDICAMENTO VALUES (7098249, '1 G 20 SOBRES', 'GRANULADO EFERVESALTER', 'PARACETAMOL ALTER', 2.81);

INSERT INTO TRATAMIENTO VALUES (1, '2017-05-28', '2018-04-04', 3, 1, '8 horas', 6527634, 5);
INSERT INTO TRATAMIENTO VALUES (2, '2017-05-28', '2018-04-04', 4, 2, '6 horas', 9676384, 5);
INSERT INTO TRATAMIENTO VALUES (3, '2017-05-28', '2018-04-04', 6, 1, '4 horas', 7098249, 5);

INSERT INTO MENSAJE VALUES ( 1, 'EnfermedadDsdPaciente', '2017-05-28', true, 'Esto es una prueba de mensaje de 1 a 2',2,1)
INSERT INTO MENSAJE VALUES ( 2, 'EnfermedadDsdMedico', '2017-05-28', true, 'Esto es una prueba de mensaje de 2 a 1',1,2)