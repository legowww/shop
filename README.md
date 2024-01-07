## 프로젝트 설명
- MySQL 의 Full-text-Search(n-gram parser)를 이용한 제품 검색
- Spring 의 고성능 캐시 라이브러리인 Caffaine Cache 를 이용한 keyword 검색 결과 캐싱  
- Redis 의 Sorted Set 자료구조를 이용하여 상품 그룹 별 최저가 상품 정보 조회 구현
- gzip, Etag, local/global cache 을 적용한 후 Locust 를 활용한 성능 테스트 수행

## 아키텍처
<img width="953" alt="result2" src="https://github.com/legowww/shop/assets/70372188/bc8d1cab-a0ae-4b5e-9026-da18f9dab906">

## 네트워크 구성
<img width="810" alt="result1" src="https://github.com/legowww/shop/assets/70372188/ad0e5642-eee9-4079-9766-9f9010cd4bda">

## 사용 기술
- Nginx
- Spring Boot 3.2
  - Caffine Cache
- MySQL 8.0.35
- Docker
- Redis

