# Banksalad
* * *
## Project
- 해외 주식 회사 이름을 이용한 6개월 간 최대 수익을 낼 수 있는 매수날짜와 매도날짜 산출.

## 실행 환경
- 자체 Spring boot Tomcat 서버 사용
- http://localhost:8080/

## 사용 기술
- Backend : Spring boot(java version: 8)
- frontend : html, css, jqury
- API : IEXcloud OpenAPI

## 시나리오
- search 창에 회사명 입력

<img src="/img/1.png" width="50%" height="40%" alt="입력"></img>

- select 창의 회사 선택

<img src="/img/2.png" width="50%" height="40%" alt="선택"></img>

- 결과

<img src="/img/3.png" width="50%" height="40%" alt="결과"></img>

##시나리오 이유
- 회사 symbol을 잘 모르는 사용자를 위해 회사 이름으로 검색 후 선택 후 확인할 수 있도록 사용

## 사용 알고리즘
- 최저점과 최고점 찾아서 반환
- 시간복잡도 O(N)

## Class 설명
- 각 class 마다 method에 Description 활용해 설명
- testcode 작성

## 오류 노트
1. StockService에서 api 호출 과정에서 cors현상 발생
- 해결 : corssOrigin 활용해 해결

2. PathVariable : 쿼리스트링만 사용하는 경우 리퀘스트 2번 오는 현상
- 해결 : 쿼리스트링 앞에 문자 붙여 해결

3. 회사 이름 api 호출 시 api 할당량 초과
- 해결 : 별도의 json 파일 생성 후 Server 실행 시 파싱

4. 회사 이름 전체 response 시 서버 딜레이 현상
- 해결 : 전체를 response 않고 사용자가 회사명 검색 시마다 맞는 회사만 반환
