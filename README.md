# Banksalad
* * *
## Project
- 해외 주식 회사 이름을 이용한 6개월 간 최대 수익을 낼 수 있는 매수날짜와 매도날짜 산출.

## 사용 기술
- Backend : Spring boot(java version: 8)
- frontend : html, css, jqury
- API : IEXcloud OpenAPI

## 시나리오
- search 창에 회사이름 입력
![Alt text](/path/to/1.jpg)

- select 창의 회사 선택
![Alt text](/path/to/2.jpg)

- 결과
![Alt text](/path/to/3.jpg)

## 사용 알고리즘
- 최저점과 최고점 찾아서 반환
- 시간복잡도 O(N)

## 오류 노트
1. StockService에서 api 호출 과정에서 cors현상 발생

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  
- 해결 : corssOrigin 활용해 해결

2. PathVariable : 쿼리스트링만 사용하는 경우 리퀘스트 2번 오는 현상
- 해결 : 쿼리스트링 앞에 문자 붙여 해결

3. 
