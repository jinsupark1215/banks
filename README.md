# Bank
* * *
## Project
- 해외 주식 회사 이름을 이용한 6개월 간 최대 수익을 낼 수 있는 매수날짜와 매도날짜 산출.

## 실행 환경
- 자체 Spring boot Tomcat 서버 사용

## 사용 기술
- Backend : Spring boot(java version: 8)
- frontend : html, css, jQuery
- API : IEXcloud OpenAPI

## 시나리오
#### - search 창에 회사명 입력

<img src="/img/1.png" width="100%" height="80%" alt="입력"></img>

#### - select 창의 회사 선택

<img src="/img/2.png" width="100%" height="80%" alt="선택"></img>

#### - 결과

<img src="/img/3.png" width="100%" height="80%" alt="결과"></img>


## 시나리오 이유
- 회사 symbol을 잘 모르는 사용자를 위해 회사 이름으로 검색 후 선택하여 확인할 수 있도록 사용

## 알고리즘
- 최저점과 최고점 찾아서 반환
- 시간복잡도 O(N)

## Class 설명
- 각 Class 마다 Method에 Description 활용해 설명
- Testcode 작성

## 오류 노트
1. StockService에서 api 호출 과정에서 CORS현상 발생
- 해결 : CrossOrigin 활용해 해결

2. PathVariable : QueryString만 사용하는 경우 Request 2번 오는 현상
- 해결 : QueryString 앞에 문자 붙여 해결

3. 회사 이름 API 호출 시 API 할당량 초과
- 해결 : 별도의 JSON 파일 생성 후 Server 실행 시 파싱

4. 회사 이름 전체 Response 시 서버 딜레이 현상
- 해결 : 전체를 Response 않고 사용자가 회사명 검색 시마다 맞는 회사만 반환

## 코드리뷰
[CodeReview](https://github.com/jinsupark1215/banks/blob/master/CodeReview.md)
