## 구현
- MySQL 의 Full-text-Search(n-gram parser)를 통한 제품 검색  
- Redis 의 Sorted Set 자료구조를 활용한 제품 그룹 별 최저가 제품 리스트 조회 기능
- gzip, Etag, local/global cache 적용

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

