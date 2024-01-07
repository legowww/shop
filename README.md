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

## 설명
- MySQL 의 Full-text-Search(n-gram parser)를 이용한 검색 구현
- Spring 의 고성능 캐시 라이브러리인 Caffaine Cache 를 이용한 검색 결과 캐싱  
- Redis 의 Sorted Set 자료구조를 이용하여 상품 그룹 별 최저가 상품 정보 조회 구현
- gzip, cache 을 적용한 후 Locust 를 통해 성능 테스트 수행

```json
{
    "status": 200,
    "data": {
        "productGroupWithProductPreviews": [
            {
                "productGroup": {
                    "id": 1,
                    "name": "노스페이스 1996 눕시"
                },
                "productPreviews": [
                    {
                        "productId": 219462,
                        "name": "노스페이스 1996",
                        "price": 3000
                    },
                    {
                        "productId": 219447,
                        "name": "노스페이스 1996",
                        "price": 30000
                    },
                    {
                        "productId": 219461,
                        "name": "노스페이스 1996",
                        "price": 30000
                    },
                    {
                        "productId": 6,
                        "name": "[노스페이스] 1996 눕시",
                        "price": 350000
                    },
                    {
                        "productId": 1,
                        "name": "노스페이스 남성 1996 눕시 점퍼",
                        "price": 360000
                    }
                ]
            },
            {
                "productGroup": {
                    "id": 2,
                    "name": "노스페이스 1992 눕시"
                },
                "productPreviews": [
                    {
                        "productId": 6336,
                        "name": "상품6336",
                        "price": 12001
                    },
                    {
                        "productId": 105184,
                        "name": "상품105184",
                        "price": 12002
                    },
                    {
                        "productId": 169676,
                        "name": "상품169676",
                        "price": 12002
                    },
                    {
                        "productId": 137584,
                        "name": "상품137584",
                        "price": 12003
                    },
                    {
                        "productId": 40680,
                        "name": "상품40680",
                        "price": 12003
                    }
                ]
            },
            {
                "productGroup": {
                    "id": 3,
                    "name": "노스페이스 힘다운"
                },
                "productPreviews": [
                    {
                        "productId": 1017,
                        "name": "상품1017",
                        "price": 12000
                    },
                    {
                        "productId": 140201,
                        "name": "상품140201",
                        "price": 12000
                    },
                    {
                        "productId": 190629,
                        "name": "상품190629",
                        "price": 12000
                    },
                    {
                        "productId": 51745,
                        "name": "상품51745",
                        "price": 12000
                    },
                    {
                        "productId": 72661,
                        "name": "상품72661",
                        "price": 12001
                    }
                ]
            }
        ]
    },
    "serverDateTime": "2024-01-06T18:34:35"
}
```
