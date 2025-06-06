DROP TABLE IF EXISTS T_INVOICE_HEADERS;
CREATE TABLE T_INVOICE_HEADERS(
    INH_ID BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    INH_NUMBER CHARACTER VARYING(100) NOT NULL,
    INH_CUS_NAME CHARACTER VARYING(255) NOT NULL,
    INH_DATE TIMESTAMP DEFAULT NOW() NOT NULL,
    INH_SUB_TOTAL NUMERIC(10, 2) NOT NULL,
    INH_VAT_AMOUNT NUMERIC(10, 2) NOT NULL,
    INH_TOTAL NUMERIC(10, 2) NOT NULL,

    CONSTRAINT PK_T_INVOICE_HEADERS_INH_ID PRIMARY KEY (INH_ID)
);