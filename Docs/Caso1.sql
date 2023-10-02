CREATE TABLE cadenashoteles (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(250 BYTE) NOT NULL
);

ALTER TABLE cadenashoteles ADD CONSTRAINT cadenashoteles_pk PRIMARY KEY ( id );

CREATE TABLE clientes (
    id         INTEGER NOT NULL,
    nombre     VARCHAR2(250 BYTE) NOT NULL,
    edad       INTEGER NOT NULL,
    correo     VARCHAR2(250 BYTE) NOT NULL,
    teléfono   INTEGER NOT NULL,
    hoteles_id INTEGER NOT NULL
);

ALTER TABLE clientes ADD CONSTRAINT clientes_pk PRIMARY KEY ( id );

CREATE TABLE consumosreserva (
    reservas_id  INTEGER NOT NULL,
    servicios_id INTEGER NOT NULL
);

ALTER TABLE consumosreserva ADD CONSTRAINT consumosreserva_pk PRIMARY KEY ( reservas_id,
                                                                            servicios_id );

CREATE TABLE empleados (
    id               INTEGER NOT NULL,
    nombre           VARCHAR2(250 BYTE) NOT NULL,
    edad             INTEGER NOT NULL,
    correo           VARCHAR2(250 BYTE) NOT NULL,
    teléfono         INTEGER NOT NULL,
    hoteles_id       INTEGER NOT NULL,
    tiposempleado_id INTEGER NOT NULL
);

ALTER TABLE empleados ADD CONSTRAINT empleados_pk PRIMARY KEY ( id );

CREATE TABLE gimnasios (
    nombre       VARCHAR2(250 BYTE) NOT NULL,
    capacidad    INTEGER NOT NULL,
    horario      VARCHAR2(250 BYTE) NOT NULL,
    servicios_id INTEGER NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( servicios_id );

CREATE TABLE habitaciones (
    ubicación          INTEGER NOT NULL,
    televisión         BOOLEAN NOT NULL,
    minibar            BOOLEAN NOT NULL,
    jacuzzi            BOOLEAN NOT NULL,
    cafetera           BOOLEAN NOT NULL,
    comedor            BOOLEAN NOT NULL,
    cocina             BOOLEAN NOT NULL,
    precio             INTEGER NOT NULL,
    hoteles_id         INTEGER NOT NULL,
    tiposhabitación_id INTEGER NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( ubicación, hoteles_id );

CREATE TABLE hoteles (
    id               INTEGER NOT NULL,
    nombre           VARCHAR2(250 BYTE) NOT NULL,
    ciudad           VARCHAR2(250 BYTE) NOT NULL,
    pais             VARCHAR2(250 BYTE) NOT NULL,
    cadenahoteles_id INTEGER NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( id );

CREATE TABLE internet (
    capacidad    INTEGER NOT NULL,
    servicios_id INTEGER NOT NULL
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( servicios_id );

CREATE TABLE maquinas (
    id                    INTEGER NOT NULL,
    nombre                VARCHAR2(250 BYTE) NOT NULL,
    gimnasio_servicios_id INTEGER NOT NULL
);

ALTER TABLE maquinas ADD CONSTRAINT maquinas_pk PRIMARY KEY ( id );

CREATE TABLE piscinas (
    capacidad    INTEGER NOT NULL,
    profundidad  NUMBER NOT NULL,
    horario      VARCHAR2(250 BYTE) NOT NULL,
    servicios_id INTEGER NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( servicios_id );

CREATE TABLE planes (
    id         INTEGER NOT NULL,
    nombre     VARCHAR2(250 BYTE) NOT NULL,
    costo      INTEGER NOT NULL,
    hoteles_id INTEGER NOT NULL
);

ALTER TABLE planes ADD CONSTRAINT planes_pk PRIMARY KEY ( id );

CREATE TABLE productos (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(250 BYTE) NOT NULL,
    precio NUMBER NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( id );

CREATE TABLE reservas (
    id                      INTEGER NOT NULL,
    fechainicial            DATE NOT NULL,
    fechafinal              DATE NOT NULL,
    numeropersonas          INTEGER NOT NULL,
    habitaciones_ubicación  INTEGER NOT NULL,
    clientes_id             INTEGER NOT NULL,
    planes_id               INTEGER NOT NULL,
    habitaciones_hoteles_id INTEGER NOT NULL
);

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

CREATE TABLE servicios (
    id         INTEGER NOT NULL,
    costo      NUMBER NOT NULL,
    hoteles_id INTEGER NOT NULL
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id );

CREATE TABLE serviciosproductos (
    nombre       VARCHAR2(250 BYTE) NOT NULL,
    capacidad    INTEGER NOT NULL,
    tipo         INTEGER NOT NULL,
    estilo       VARCHAR2(250 BYTE) NOT NULL,
    servicios_id INTEGER NOT NULL
);

ALTER TABLE serviciosproductos ADD CONSTRAINT serviciosproductos_pk PRIMARY KEY ( servicios_id );

CREATE TABLE serviciossalas (
    nombre         VARCHAR2(250 BYTE) NOT NULL,
    capacidad      INTEGER NOT NULL,
    tiempolimpieza INTEGER,
    servicios_id   INTEGER NOT NULL
);

ALTER TABLE serviciossalas ADD CONSTRAINT serviciossalas_pk PRIMARY KEY ( servicios_id );

CREATE TABLE serviciossimples (
    tipo         VARCHAR2(250 BYTE) NOT NULL,
    servicios_id INTEGER NOT NULL
);

ALTER TABLE serviciossimples ADD CONSTRAINT serviciossimples_pk PRIMARY KEY ( servicios_id );

CREATE TABLE sirven ( 
    serviciosproductos_id INTEGER NOT NULL,
    productos_id                    INTEGER NOT NULL
);

ALTER TABLE sirven ADD CONSTRAINT sirven_pk PRIMARY KEY ( serviciosproductos_id,
                                                          productos_id );

CREATE TABLE spa (
    duracion     INTEGER NOT NULL,
    servicios_id INTEGER NOT NULL
);

ALTER TABLE spa ADD CONSTRAINT spa_pk PRIMARY KEY ( servicios_id );

CREATE TABLE tiposempleado (
    id   INTEGER NOT NULL,
    tipo VARCHAR2(250 BYTE) NOT NULL
);

ALTER TABLE tiposempleado ADD CONSTRAINT tiposempleado_pk PRIMARY KEY ( id );

CREATE TABLE tiposhabitación (
    id   INTEGER NOT NULL,
    tipo VARCHAR2(250 BYTE) NOT NULL
);

ALTER TABLE tiposhabitación ADD CONSTRAINT tiposhabitación_pk PRIMARY KEY ( id );

ALTER TABLE clientes
    ADD CONSTRAINT clientes_hoteles_fk FOREIGN KEY ( hoteles_id )
        REFERENCES hoteles ( id );

ALTER TABLE consumosreserva
    ADD CONSTRAINT consumosreserva_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE consumosreserva
    ADD CONSTRAINT consumosreserva_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE empleados
    ADD CONSTRAINT empleados_hoteles_fk FOREIGN KEY ( hoteles_id )
        REFERENCES hoteles ( id );

ALTER TABLE empleados
    ADD CONSTRAINT empleados_tiposempleado_fk FOREIGN KEY ( tiposempleado_id )
        REFERENCES tiposempleado ( id );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_hoteles_fk FOREIGN KEY ( hoteles_id )
        REFERENCES hoteles ( id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_tiposhabitación_fk FOREIGN KEY ( tiposhabitación_id )
        REFERENCES tiposhabitación ( id );

ALTER TABLE hoteles
    ADD CONSTRAINT hoteles_cadenahoteles_fk FOREIGN KEY ( cadenahoteles_id )
        REFERENCES cadenashoteles ( id );

ALTER TABLE internet
    ADD CONSTRAINT internet_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE maquinas
    ADD CONSTRAINT maquinas_gimnasio_fk FOREIGN KEY ( gimnasio_servicios_id )
        REFERENCES gimnasios ( servicios_id );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE planes
    ADD CONSTRAINT planes_hoteles_fk FOREIGN KEY ( hoteles_id )
        REFERENCES hoteles ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_cliente_fk FOREIGN KEY ( cliente_id )
        REFERENCES clientes ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_habitaciones_fk FOREIGN KEY ( habitaciones_ubicación,
                                                          habitaciones_hoteles_id )
        REFERENCES habitaciones ( ubicación,
                                  hoteles_id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_planes_fk FOREIGN KEY ( planes_id )
        REFERENCES planes ( id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_hoteles_fk FOREIGN KEY ( hoteles_id )
        REFERENCES hoteles ( id );


ALTER TABLE serviciosproductos
    ADD CONSTRAINT serviciosproductos_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE serviciossalas
    ADD CONSTRAINT serviciossalas_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE serviciossimples
    ADD CONSTRAINT serviciossimples_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE sirven
    ADD CONSTRAINT sirven_productos_fk FOREIGN KEY ( productos_id )
        REFERENCES productos ( id );

ALTER TABLE sirven
    ADD CONSTRAINT sirven_serviciosproductos_fk FOREIGN KEY ( serviciosproductos_id )
        REFERENCES serviciosproductos ( servicios_id );

ALTER TABLE spa
    ADD CONSTRAINT spa_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );
        
CREATE SEQUENCE  ID_SEQUENCE MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

INSERT INTO CADENASHOTELES (id, nombre) VALUES(ID_SEQUENCE.nextval, 'royalMonda');

INSERT INTO hoteles (id, nombre, ciudad, pais, cadenahoteles_id) VALUES(ID_SEQUENCE.nextval, 'royal1', 'tamalameque', 'colombia',2);

INSERT INTO clientes (id, nombre, edad, correo, teléfono, hoteles_id) VALUES(ID_SEQUENCE.nextval, 'juan', 24, 'agsf@hotmail.com', 3222222222, 4);

UPDATE clientes SET nombre = 'jose',edad = 24, correo = 'afde@hotmail.com', teléfono = 3111111111, hoteles_id = 4 WHERE id = 5;