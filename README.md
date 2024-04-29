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
- localhost:8080/security/main
- localhost:8080/security/login (로그인 화면)
- localhost:8080/security/join (회원가입 화면)
- localhost:8080/security/loginProc (로그인 요청)
- localhost:8080/security/joinProc (회원가입 요청)
- localhost:8086/ -> localhost:8081/ms1/data (10초 지연응답 서킷브레이커 테스트)
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
- webFluxMongodb : 8084
- security : 8085
- resilience4j : 8086
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
  - userEntity
- localhost:3306/msa_project2
  - second_entity
---
### mongodb
- USER : "admin"
- PASSWORD : "1234"
- localhost:27017/database
  - table1
---
### circuitbreaker
##### 슬라이딩 윈도우 공통 사항
- sliding-window-type: count_based #실패 및 지연을 체크할 슬라이딩 윈도우 타입
- sliding-window-szie: 5 #슬라이딩 윈도우 크기 
##### 실패에 대한 설정
- failure-rate-threshold: 10 #서킷을 오픈할 실패 비율 (실패 수 / 슬라이딩 윈도우 크기) %
- minimum-number-of-calls: 5 #서킷을 오픈하기 위해 최소 실패 수 (슬라이딩 윈도우를 다 채우지 못했지만 최소값을 설정 가능)
##### 지연에 대한 설정
- slow-call-rate-threshold: 10 #서킷을 오픈할 지연 비율 (지연 수 / 슬라이딩 윈도우 크기)
- slow-call-duration-threshold: 3000ms #지연으로 판단할 시간
##### half open 상태 설정
- permitted-number-of-calls-in-half-open-state: 10 #half open 상태에서 다른 상태로 전환하기 위한 판단 수
- max-wait-duration-in-half-open-state: 0 #half open 상태 유지 시간 (만약 0이면 위에서 설정한 값 만큼 수행 후 다음 상태로 전환)
- wait-duration-in-open-state: 600000ms #open 상태에서 half open으로 전환까지 기다리는 시간
- automatic-transition-from-open-to-half-open-enabled: true #open 상태에서 half open 으로 자동 전환 (true시 일정 시간이 지난 후 자동 전환)
- register-health-indicator: true #상태 체크 표시 (actuator용)
##### 예외처리
- ignore-exceptions: java.io.IOException, java.util.concurrent.TimeoutException, org.springframework.web.client.HttpServerErrorException
---