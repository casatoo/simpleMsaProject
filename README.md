# simpleMsaProject
##### 스프링부트 MSA 기본구성
---
### api 호출
##### getMapping
- localhost:8080/ms1/main
- localhost:8080/ms2/main
- localhost:8080/ms3/first/db
- localhost:8080/ms3/second/db
- localhost:8080/ms4/data
---
### environment
- springBoot 3.2.5
- gradle 8.7
- jdk 17(corretto)
- java 17
---
### module port
- configServer : 9080
- eurekaServer : 8761
- springCloudGateway : 8080
- webapp : 8081
- system : 8082
- webFlux : 8083
---
### configServer gitHub
- https://github.com/casatoo/config-test.git
- ms1-dev.yml : web-app
- ms2-dev.yml : system
---
### mysql
- USER : "root"
- PASSWORD : ""
- localhost:3306/msa_project
  - first_entity
- localhost:3306/msa_project2
  - second_entity
---
### mongodb
- USER : "admin"
- PASSWORD : "1234"
- localhost:27017/database
  - table1
---