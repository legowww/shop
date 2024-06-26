## 📌 프로젝트 구현
- MySQL의 전문검색(n-gram parser)을 사용하여 상품 검색 구현
- Spring의 캐시 라이브러리인 Caffaine Cache를 이용한 검색어 결과 캐싱
- Redis의 ZSET 자료구조를 사용하여 최저가 상품 관리
- gzip, ETag 적용
- Locust 를 사용하여 성능 테스트 수행'
- README 정리: https://steadfast-perch-679.notion.site/shop-5483b3af48684f96ac12f92735625e12?pvs=4 

### 상품 검색 결과
<details>
<summary>JSON</summary>
  
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

</details>


## 🏛️ 아키텍처
<img width="953" alt="result2" src="https://github.com/legowww/shop/assets/70372188/bc8d1cab-a0ae-4b5e-9026-da18f9dab906">

## 🛜 네트워크 구성
<img width="810" alt="result1" src="https://github.com/legowww/shop/assets/70372188/ad0e5642-eee9-4079-9766-9f9010cd4bda">

Public IP를 가지는 Nginx를 통해서만 Private IP를 가지는 WAS와 통신할 수 있도록 인프라 구축

## 🔨 기술
- Nginx
- Spring Boot 3.2
- MySQL 8.0.35
- Docker
- Redis

## ✅ 캐싱 적용 & 성능 테스트

### 환경
- EC2 t2.micro 인스턴스
- MySQL ProductGroup 테이블 레코드 8개
- MySQL Product 테이블 레코드 20만개

### 캐싱 적용 전
쿠팡, 지마켓 등의 사이트에서 상품 검색 시 소요되는 응답 시간을 확인한 결과, 800ms~1600ms 사이의 응답시간을 가짐을 확인함 
현재 시스템은 VUser 값을 16명으로 테스트했을 때, 5.2 RPS 의 처리량을 보장하며, 위의 사이트들과 유사한 응답시간을 가질 수 있었음
| VUser | Average Response Time  | RPS | 
|---|---|---|
| 16  | 1574ms  | 5.2|

<img width="824" alt="f1" src="https://github.com/legowww/shop/assets/70372188/f117c6f6-6417-4111-8b5e-c6c27d50a5f9">


### 캐싱 적용 후
#### 검색어 캐싱(Caffaine Cache)
<img width="909" alt="f2" src="https://github.com/legowww/shop/assets/70372188/0c05c845-f3ad-48ea-8594-6f309987df22">


#### 최저가 상품 캐싱(Redis)
<img width="895" alt="f3" src="https://github.com/legowww/shop/assets/70372188/32c88206-6bfa-490e-8187-6b3b76a22c25">


![image](https://github.com/legowww/shop/assets/70372188/65c38a8a-86d1-4a55-afe9-a757f6bf02d7)

| VUser | Average Response Time  | RPS | 
|---|---|---|
| 300  | 206ms  | 162.2|

위 차트를 살펴보면 Cache Miss가 잦게 발생한 후 일정 시간이 흐른 뒤에는 처리량과 응답 속도가 안정화되는 것을 볼 수 있다. 이는 모든 요청에 Cache Hit이 적용되었다는 것을 의미하며, 이로 인해 VUser 수를 300명까지 늘려도 문제가 발생하지 않았다. 하지만, 테스트 환경 설정의 한계로 인해 Cache Hit이 100%에 도달한 이번 결과는 일반적인 상황에서 기대하기 어려운 극적인 성능 향상 사례입니다. 실제 업무 환경에서는 자주 사용되는 검색어나 상품 정보를 분석하여 캐시 히트 비율을 약 70% 정도로만 유지해도, 기존 시스템 대비 상당한 성능 향상을 기대할 수 있을 것으로 판단됩니다.

## ✅ 기타 성능 개선

### gzip
| 적용 전| 적용 후  |
|---|---|
| 1247Bytes  | 617Bytes  |

서버 응답에 사용되는 네트워크 비용을 절감시키기 위해 application/json MIME 에 대해 gzip 압축 적용
### ETag
정적 리소스인 상품검색 화면 HTML 에 대해 조건부 캐싱 요청을 적용할 수 있도록 ETag 를 적용









