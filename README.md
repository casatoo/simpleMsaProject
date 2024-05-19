# simpleMsaProject
##### 스프링부트 MSA 기본구성 및 추가기능 테스트를 위한 프로젝트
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
- singleMongodb : 8087
- springJWT : 8088
- OAuthSession : 8089
- OAuthJWT : 8090
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
##### retry
- max-attempts: 3 # 재요청 시도 횟수
- wait-duration: 3000ms # 재요청 간격
- retry-exception: # 예외처리 포함
  - java.io.IOException
- ignore-exceptions: # 예외처리 미 포함
  - java.io.IOException
##### bulkhead
(SEMAPHORE)  
- max-concurrent-calls: 1 # 최대 요청 카운터 수
- max-wait-duration: 1000ms # 동시요청 초과 시 웨이팅 시간
(THREAD-POOL)
- max-thread-pool-size: 10 # 최대 스레드 풀
- core-thread-pool-size: 5 # 기본 스레드 풀
- queue-capacity: 50 # 스레드 풀 초과 시 요청이 기다릴 대기 큐 크기
---