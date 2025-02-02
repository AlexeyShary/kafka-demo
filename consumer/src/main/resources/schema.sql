DROP TABLE IF EXISTS metrics_logs;

CREATE TABLE IF NOT EXISTS metrics_logs
(
    log_id        BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    log_status    VARCHAR NOT NULL,
    log_uptime    REAL    NOT NULL,
    log_timestamp TIMESTAMP WITHOUT TIME ZONE NOT NULL
)