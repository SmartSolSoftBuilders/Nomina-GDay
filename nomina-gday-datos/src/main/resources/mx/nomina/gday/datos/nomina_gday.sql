-- Table: "EJECUTIVO"

-- DROP TABLE "EJECUTIVO";

CREATE TABLE "EJECUTIVO"
(
  "ID_EJECUTIVO" integer NOT NULL,
  "APP_PATERNO_EJECUTIVO" character varying(25),
  "APP_MATERNO_EJECUTIVO" character varying(25),
  "NOMBRE_EJECUTIVO" character varying(30),
  CONSTRAINT "ID_EJECUTIVO_PK" PRIMARY KEY ("ID_EJECUTIVO")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "EJECUTIVO"
  OWNER TO postgres;

  
  
-- Table: "TIPO_CALENDARIO"

-- DROP TABLE "TIPO_CALENDARIO";

CREATE TABLE "TIPO_CALENDARIO"
(
  "ID_CALENDARIO" integer NOT NULL,
  "TIPO_CALENDARIO" character varying(25),
  "SIGLAS" character varying(2),
  "PR" character varying(4),
  CONSTRAINT "ID_CALENDARIO_PK" PRIMARY KEY ("ID_CALENDARIO")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "TIPO_CALENDARIO"
  OWNER TO postgres;

  
-- Table: "ESQUEMA"

-- DROP TABLE "ESQUEMA";

CREATE TABLE "ESQUEMA"
(
  "ID_ESQUEMA" integer NOT NULL,
  "NOMBRE_ESQUEMA" character varying(25),
  CONSTRAINT "ID_ESQUEMA_PK" PRIMARY KEY ("ID_ESQUEMA")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "ESQUEMA"
  OWNER TO postgres;


-- Table: "GRUPO"

-- DROP TABLE "GRUPO";

CREATE TABLE "GRUPO"
(
  "ID_GRUPO" integer NOT NULL,
  "NOMBRE_CORTO_GRUPO" character varying(15),
  "NOMBRE_GRUPO" character varying(25),
  CONSTRAINT "ID_GRUPO_PK" PRIMARY KEY ("ID_GRUPO")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "GRUPO"
  OWNER TO postgres;

  
  
-- Table: "RAZON_SOCIAL"

-- DROP TABLE "RAZON_SOCIAL";

CREATE TABLE "RAZON_SOCIAL"
(
  "ID_RAZON_SOCIAL" integer NOT NULL,
  "ID_GRUPO" integer NOT NULL,
  "NOMBRE_RAZON_SOCIAL" character varying(40),
  "RFC" character varying(13),
  "NOMBRE_CORTO_RAZON_S" character varying(15),
  "COD_CLIENTE" character varying(20),
  "COMISION" double precision,
  "ACT_CONSTITUTIVA" integer,
  "FECHA_ACT_CONSTITUTIVA" date,
  "FECHA_INICIO_OPERACION" date,
  "PATERNO_REPRESENTANTE" character varying(25),
  "MATERNO_REPRESENTANTE" character varying(25),
  "NOMBRES_REPRESENTANTE" character varying(30),
  "CALLE_FISCAL" character varying(30),
  "COLONIA_FISCAL" character varying(30),
  "NUM_EXTERIOR_FISCAL" character varying(20),
  "NUM_INTERIOR_FISCAL" character varying(20),
  "CP_FISCAL" integer,
  "MUNICIPIO_FISCAL" character varying(40),
  "ESTADO_FISCAL" character varying(20),
  "CONTACTO1_NOMBRE" character varying(80),
  "CONTACTO1_TELEFONO" character varying(10),
  "CONTACTO1_CORREO" character varying(30),
  "CONTACTO2_NOMBRE" character varying(80),
  "CONTACTO2_TELEFONO" character varying(10),
  "CONTACTO2_CORREO" character varying(30),
  "CONTACTO3_NOMBRE" character varying(80),
  "CONTACTO3_TELEFONO" character varying(10),
  "CONTACTO3_CORREO" character varying(30),
  "REFERENCIANTES" json,
  "OBJETO_SOCIAL" character varying(256),
  "REGISTRO_PUBLICO_PROPIEDAD" character varying,
  "FECHA_REGISTRO_PUBLICO_PROPIEDAD" date,
  CONSTRAINT "ID_RAZON_SOCIAL_PK" PRIMARY KEY ("ID_RAZON_SOCIAL"),
  CONSTRAINT "ID_GRUPO_FK" FOREIGN KEY ("ID_GRUPO")
      REFERENCES "GRUPO" ("ID_GRUPO") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "RAZON_SOCIAL"
  OWNER TO postgres;

-- Table: "TIPO_REGIMEN"

-- DROP TABLE "TIPO_REGIMEN";

CREATE TABLE "TIPO_REGIMEN"
(
  "ID_TIPO_REGIMEN" integer NOT NULL,
  "TIPO_REGIMEN" character varying(40),
  CONSTRAINT "ID_TIPO_REGIMEN_PK" PRIMARY KEY ("ID_TIPO_REGIMEN")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "TIPO_REGIMEN"
  OWNER TO postgres;

  

-- Table: "PATRONA"

-- DROP TABLE "PATRONA";

CREATE TABLE "PATRONA"
(
  "ID_PATRONA" integer NOT NULL,
  "RAZON_SOCIAL" character varying(20),
  "NOMBRE_CORTO" character varying(15),
  "ES_INTERMEDIARIA" boolean,
  "FOLIO_MERCANTIL" integer,
  "CALLE_FISCAL" character varying(20),
  "COLONIA_FISCAL" character varying,
  "NUM_INTERIOR_FISCAL" integer,
  "CP_FISCAL" integer,
  "MUNICIPIO_FISCAL" character varying(20),
  "ESTADO_FISCAL" character varying(20),
  "FISCAL_NUM_PAGO" integer,
  "ACTA_NUMERO" integer,
  "ACTA_NOTARIA" integer,
  "ACTA_FECHA" date,
  "ACTA_NOTARIO" integer,
  "ACTA_CIUDAD" character varying(25),
  "ACTA_ESTADO" character varying(25),
  "NUM_EXTERIOR_FISCAL" integer,
  "TEL_CONTACTO" integer,
  "RFC" character varying(13),
  "DOM_VIRTUALES" json,
  "ACCIONISTA" json,
  "POD_NOTA_PLEITOS_Y_COBRANZAS" json,
  "REP_LEG_PLEITOS_COBR" json,
  "POD_NOTA_LAB" json,
  "REP_LEG_LAB" json,
  CONSTRAINT "ID_PATRONA_PK" PRIMARY KEY ("ID_PATRONA")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "PATRONA"
  OWNER TO postgres;


  
-- Table: "NOMINA"

-- DROP TABLE "NOMINA";

CREATE TABLE "NOMINA"
(
  "ID_NOMINA" integer NOT NULL,
  "ID_PATRONA" integer NOT NULL,
  "ID_INTERMEDIARIA" integer NOT NULL,
  "ID_ESQUEMA" integer NOT NULL,
  "ID_EJECUTIVO" integer NOT NULL,
  "ID_CALENDARIO" integer NOT NULL,
  "NOMBRE_CORTO" character varying(15),
  "PROVISION_AGUINALDO" boolean,
  "PROVISION_VACACIONES" boolean,
  "PROVISION_PRIMA_VACACIONAL" boolean,
  "DIAS_AGUINALDO" integer,
  "FONDO_AHORRO" boolean,
  "FACTURA_SUBSIDIO" boolean,
  "IVA_EXENTO" boolean,
  "RECONOCE_ANTIGUEDAD" boolean,
  "COMISION_COST_SOCIAL" boolean,
  "TIPO_PAGO" character varying(15),
  "CLASE_RIESGO" character varying(10),
  "REGISTRO_PATRONAL" character varying(15),
  "PERIODICIDAD" character varying(2),
  "TIPO_CALENDARIO" character varying(30),
  "PORC_PRIMA_VACACIONAL" double precision,
  "FECHA_CONTRATO" date,
  CONSTRAINT "ID_NOMINA_PK" PRIMARY KEY ("ID_NOMINA"),
  CONSTRAINT "FK_INT" FOREIGN KEY ("ID_INTERMEDIARIA")
      REFERENCES "PATRONA" ("ID_PATRONA") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "ID_CALENDARIO_FK" FOREIGN KEY ("ID_CALENDARIO")
      REFERENCES "TIPO_CALENDARIO" ("ID_CALENDARIO") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "ID_EJECUTIVO_FK" FOREIGN KEY ("ID_EJECUTIVO")
      REFERENCES "EJECUTIVO" ("ID_EJECUTIVO") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "ID_ESQUEMA_FK" FOREIGN KEY ("ID_ESQUEMA")
      REFERENCES "ESQUEMA" ("ID_ESQUEMA") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "NOMINA"
  OWNER TO postgres;

-- Table: "NOMINA_RAZON"

-- DROP TABLE "NOMINA_RAZON";

CREATE TABLE "NOMINA_RAZON"
(
  "ID_NOMINA" integer NOT NULL,
  "ID_RAZON_SOCIAL" integer NOT NULL,
  "PORCENTAJE" double precision,
  CONSTRAINT "ID_NOMINA_FK" FOREIGN KEY ("ID_NOMINA")
      REFERENCES "NOMINA" ("ID_NOMINA") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "ID_RAZON_SOCIAL_FK" FOREIGN KEY ("ID_RAZON_SOCIAL")
      REFERENCES "RAZON_SOCIAL" ("ID_RAZON_SOCIAL") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "NOMINA_RAZON"
  OWNER TO postgres;


-- Table: "HOJA_DE_TRABAJO"

-- DROP TABLE "HOJA_DE_TRABAJO";

CREATE TABLE "HOJA_DE_TRABAJO"
(
  "ID_HOJA_DE_TRABAJO" integer NOT NULL,
  "ID_NOMINA" integer NOT NULL,
  "ARCHIVO_ACUMULADO" bytea,
  "ESTATUS" character varying(10),
  "PERIODO" character varying(15),
  CONSTRAINT "ID_HOJA_DE_TRABAJO_PK" PRIMARY KEY ("ID_HOJA_DE_TRABAJO"),
  CONSTRAINT "ID_NOMINA_FK" FOREIGN KEY ("ID_NOMINA")
      REFERENCES "NOMINA" ("ID_NOMINA") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "HOJA_DE_TRABAJO"
  OWNER TO postgres;


-- Table: "EMPLEADO"

-- DROP TABLE "EMPLEADO";

CREATE TABLE "EMPLEADO"
(
  "ID_EMPLEADO" integer NOT NULL,
  "NO_CONTROL" character varying(8),
  "NSS" character varying(10),
  "CURP" character varying(18),
  "APELLIDO_PATERNO" character varying(25),
  "APELLIDO_MATERNO" character varying(25),
  "NOMBRE" character varying(30),
  "RFC" character varying(13),
  "FECHA_NACIMIENTO" date,
  "EDAD" integer,
  "SEXO" character varying(2),
  "PAIS_ORIGEN" character varying(20),
  "NACIONALIDAD" character varying(20),
  "ESTADO_CIVIL" character varying(15),
  "CORREO_ELECTRONICO" character varying(30),
  "FECHA_INGRESO" date,
  "LISTA_NEGRA" boolean,
  "CALLE" character varying(20),
  "NUM_EXTERIOR" character varying(20),
  "NUM_INTERIOR" character varying(20),
  "COLONIA" character varying(25),
  "CODIGO_POSTAL" integer,
  "MUNICIPIO_DEL" character varying(20),
  "ENT_FEDERATIVA" character varying(20),
  "DOC_IFE" boolean,
  "DOC_ACT_NAN" boolean,
  "DOC_CURP" boolean,
  "DOC_RFC" boolean,
  "DOC_COMPROBANTE" boolean,
  "DOC_COMP_EST" boolean,
  "DOC_CORREO" boolean,
  "DOC_CLABE" boolean,
  "DOC_PREAFILIACION" boolean,
  "CUENTA" character varying(20),
  "BANCO" character varying(25),
  "TIPO_PAGO" character varying(20),
  "DESC_INFONAVIT_VSMG" double precision,
  "DESC_INFONAVIT_PORC" double precision,
  "DESC_INFONAVIT_IMP" double precision,
  "DESC_FONACOT_PAGO" double precision,
  "DESC_FONACOT_NUM" double precision,
  "PENSION_ALIM_IMP" double precision,
  "PENSION_ALIM_PORC" double precision,
  "PENSION_ALIM_ACRED" character varying(40),
  "PENSION_ALIM_OBS" character varying(100),
  "NO_CRED_INFONAVIT" integer,
  CONSTRAINT "ID_EMPLEADO_PK" PRIMARY KEY ("ID_EMPLEADO")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "EMPLEADO"
  OWNER TO postgres;



-- Table: "PATRONA_EMPLEADO"

-- DROP TABLE "PATRONA_EMPLEADO";

CREATE TABLE "PATRONA_EMPLEADO"
(
  "ID_PATRONA" integer NOT NULL,
  "ID_EMPLEADO" integer NOT NULL,
  "NUMERO_CONSECUTIVO" integer NOT NULL,
  CONSTRAINT "ID_EMPLEADO_FK" FOREIGN KEY ("ID_EMPLEADO")
      REFERENCES "EMPLEADO" ("ID_EMPLEADO") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "ID_PATRONA_PK" FOREIGN KEY ("ID_PATRONA")
      REFERENCES "PATRONA" ("ID_PATRONA") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "PATRONA_EMPLEADO"
  OWNER TO postgres;


-- Table: "PERIODO"

-- DROP TABLE "PERIODO";

CREATE TABLE "PERIODO"
(
  "ID_PERIODO" integer NOT NULL,
  "NO_PAGO" integer,
  "FECHA_INICIAL_PAGO" date,
  "FECHA_FINAL_PAGO" date,
  CONSTRAINT "ID_PERIODO_PK" PRIMARY KEY ("ID_PERIODO")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "PERIODO"
  OWNER TO postgres;

  
-- Table: "ACUMULADO_POR_PERIODO"

-- DROP TABLE "ACUMULADO_POR_PERIODO";

CREATE TABLE "ACUMULADO_POR_PERIODO"
(
  "ID_ACUMULADO_PERIODO" integer NOT NULL,
  "ID_PERIODO" integer NOT NULL,
  "ID_NOMINA" integer NOT NULL,
  "ARCHIVO_ACUMULADO" bytea,
  "ESTATUS" character varying(10),
  "PERIODO" character varying(15),
  CONSTRAINT "ID_ACUMULADO_PERIODO_PK" PRIMARY KEY ("ID_ACUMULADO_PERIODO"),
  CONSTRAINT "ID_NOMINA_FK" FOREIGN KEY ("ID_NOMINA")
      REFERENCES "NOMINA" ("ID_NOMINA") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "ID_PERIODO_FK" FOREIGN KEY ("ID_PERIODO")
      REFERENCES "PERIODO" ("ID_PERIODO") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "ACUMULADO_POR_PERIODO"
  OWNER TO postgres;

-- Table: "PUESTO"

-- DROP TABLE "PUESTO";

CREATE TABLE "PUESTO"
(
  "ID_PUESTO" integer NOT NULL,
  "DESCRIPCION" character varying(30),
  CONSTRAINT "ID_PUESTO_PK" PRIMARY KEY ("ID_PUESTO")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "PUESTO"
  OWNER TO postgres;

-- Table: "DEPARTAMENTO"

-- DROP TABLE "DEPARTAMENTO";

CREATE TABLE "DEPARTAMENTO"
(
  "ID_DEPARTAMENTO" integer NOT NULL,
  "DESCRIPCION" character varying(30),
  CONSTRAINT "ID_DEPARTAMENTO_PK" PRIMARY KEY ("ID_DEPARTAMENTO")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "DEPARTAMENTO"
  OWNER TO postgres;


-- Table: "AREA"

-- DROP TABLE "AREA";

CREATE TABLE "AREA"
(
  "ID_AREA" integer NOT NULL,
  "DESCRIPCION" character varying(30),
  CONSTRAINT "ID_AREA_PK" PRIMARY KEY ("ID_AREA")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "AREA"
  OWNER TO postgres;

-- Table: "PROCESO"

-- DROP TABLE "PROCESO";

CREATE TABLE "PROCESO"
(
  "ID_PROCESO" integer NOT NULL,
  "DESCRIPCION" character varying(30),
  CONSTRAINT "ID_PROCESO_PK" PRIMARY KEY ("ID_PROCESO")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "PROCESO"
  OWNER TO postgres;
  
 
-- Table: "EMPLEADO_NOMINA"

-- DROP TABLE "EMPLEADO_NOMINA";

CREATE TABLE "EMPLEADO_NOMINA"
(
  "ID_NOMINA" integer NOT NULL,
  "ID_EMPLEADO" integer NOT NULL,
  "FECHA_INGRESO" date,
  "ESTATUS" character varying(12),
  "TIPO_SALARIO" character varying(15),
  "FECHA_BAJA" date,
  "LOTE_MOV_IMSS_ALTA2" integer,
  "FECHA_VENCIMIENTO" date,
  "SUELDO_MENSUAL" double precision,
  "SALARIO_DIARIO_INT" double precision,
  "PLAZA_TRABAJO" character varying(25),
  "OTRO_PATRON" boolean,
  "RFC_OTRO_PATRON" character varying(13),
  "NOMBRE_OTRO_PATRON" character varying(80),
  "PERMANENCIA" boolean,
  "CALLE" character varying(30),
  "NUM_EXTERIOR" character varying(20),
  "NUM_INTERIOR" character varying(20),
  "COLONIA" character varying(25),
  "MUNICIPIO_DEL" character varying(20),
  "ENT_FEDERATIVA" character varying(20),
  "LOTE_MOV_IMSS_BAJA" integer,
  "APLICA_FINIQUITO" boolean,
  "MONTO_FINIQUITO" double precision,
  "LOTE_MOV_IMSS_ALTA" character varying(30),
  "NUMERO_TRABAJADOR_CLIENTE" character varying(30),
  "CODIGO_POSTAL" character varying(10),
  CONSTRAINT "EMPLEADO_NOMINA_PK" PRIMARY KEY ("ID_NOMINA", "ID_EMPLEADO"),
  CONSTRAINT "ID_EMPLEADO_FK" FOREIGN KEY ("ID_EMPLEADO")
      REFERENCES "EMPLEADO" ("ID_EMPLEADO") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "ID_NOMINA_FK" FOREIGN KEY ("ID_NOMINA")
      REFERENCES "NOMINA" ("ID_NOMINA") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "EMPLEADO_NOMINA"
  OWNER TO postgres;
