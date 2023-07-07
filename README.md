# ORM 및 Junit 연습 프로젝트
## 실시간 순위 정보
### 구현한 내용
- 조회수, 거래량, 증가율 랜덤값 생성
- 키워드 별로 페이징(최대 100개)
- JUNIT 테스트 케이스 작성
- 기타 세팅1 : 스웨거 (http://localhost:8080/swagger-ui/index.html)
- 기타 세팅2 : JPA + Querydsl
- 기타 세팅3 : H2 Database (http://localhost:8080/h2-console)
### 테이블 정보 : STOCK_COMPANY_INFO
|컬럼명|설명|
|:---:|:---:|
|id|PK|
|code|코드|
|name|이름|
|price|가격|
|increase_rate|증가율|
|view_cnt|조회수|
|buy_cnt|거래량|
### 동작설명
1. 10초마다 랜덤으로 값을 수정할 ID 추출 (최소 1개, 최대 120개)
2. 각 값들마다 증가율, 조회수, 거래량 랜덤 세팅
3. 주제별로 (많이본, 많이 오른, 많이 내린, 거래량 많은) 리스트 조회 : 20개씩 페이징, 최대 100개만 조회