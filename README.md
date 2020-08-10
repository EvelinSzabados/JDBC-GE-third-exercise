# JDBC-GE-third-exercise

Simple Java program with JDBC for displaying results from database for specified questions.

## Questions and queries:
 - Get the 4th busiest machine:
 ```SQL
  SELECT device.name,
         COUNT(*) AS count 
         FROM device
         INNER JOIN study ON study.ae_key = device.id
         GROUP BY device.name
         ORDER BY count DESC
         LIMIT 3,1;
```
- Get busiest day:
```SQL
SELECT DATE_FORMAT(study_datetime,'%Y-%m-%d') as day,
       COUNT(*) as count 
       FROM study 
       ORDER BY count DESC 
       LIMIT 1;
```
- Get average series_duration per series_type:
```SQL
SELECT series_type,
       TRUNCATE(AVG(series_duration),2) AS average
       FROM serie
       GROUP BY series_type;
```
- Get data_type with highest diagnostic
```SQL
SELECT device.data_type,
       COUNT(*) AS count 
       FROM device
       INNER JOIN study ON study.ae_key = device.id
       INNER JOIN serie ON study.id = serie.study_key
       WHERE serie.diagnostic = 'Y'
       GROUP BY device.data_type
       ORDER BY count DESC LIMIT 1;
```
