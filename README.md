## 설명
- MySQL 의 Full-text-Search(n-gram parser)를 이용한 검색 구현
- Spring 의 고성능 캐시 라이브러리인 Caffaine Cache 를 이용한 검색 결과 캐싱  
- Redis 의 Sorted Set 자료구조를 이용하여 상품 그룹 별 최저가 상품 정보 조회 구현
- gzip, ETag,캐싱을 통한 성능 개선
- Locust 를 통한 Stress Test 수행

![image](https://github.com/legowww/shop/assets/70372188/d7619524-6e96-44f2-a4e1-2ff94abcd2b3)

<details>
<summary>상품 검색 JSON 반환값</summary>
  
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


## 아키텍처
<img width="953" alt="result2" src="https://github.com/legowww/shop/assets/70372188/bc8d1cab-a0ae-4b5e-9026-da18f9dab906">

## 네트워크 구성
<img width="810" alt="result1" src="https://github.com/legowww/shop/assets/70372188/ad0e5642-eee9-4079-9766-9f9010cd4bda">

## 기술
- Nginx
- Spring Boot 3.2
- MySQL 8.0.35
- Docker
- Redis

## 캐싱 적용 & 성능 테스트

### 환경
- EC2 t2.micro
- Product 레코드 20만개

### 캐싱 적용 전
쿠팡, 지마켓 등의 사이트에서 상품 검색 시 소요되는 응답 시간을 확인한 결과, 800ms~1600ms 사이의 응답시간을 가짐을 확인함 
이와 비슷한 응답시간을 가지기 위해서는 현재 시스템은 VUser 값을 16명으로 테스트했을 때, 5.2 RPS 의 처리량을 보장함


| VUser | Average Response Time  | RPS | 
|---|---|---|
| 16  | 1574ms  | 5.2|

---

### 캐싱 적용 후
#### 검색어 캐싱
| KEY | VALUE |
|---|---|
| 검색어 | List<ProductGroups>(productGroupId, productGroupName) |
Caffaine Cache 에 저장

##### 최저가 상품 캐싱
| KEY | VALUE |
|---|---|
| ProductGroupId | List<ProductPreview>(productId, productName, productPrice) |
최저가 가격 순으로 정렬된 5개의 데이터를 Redis 의 SortedSet 자료구조에 저장

![image](https://github.com/legowww/shop/assets/70372188/00a20b32-8b4c-459f-b7f4-ac4fa07bf230)
![image](https://github.com/legowww/shop/assets/70372188/65c38a8a-86d1-4a55-afe9-a757f6bf02d7)

| VUser | Average Response Time  | RPS | 
|---|---|---|
| 300  | 206ms  | 162.2|

위의 차트에서 볼 수 있듯, cache miss 가 빈번하게 발생한 후 일정 구간이 지난 후 부터는 처리량과 응답 속도가 일정해진 것을 볼 수 있다.
즉, 어느 순간부터는 모든 GET 요청에 대해 cache hit 이 적용됐다고 해석할 수 있다. 덕분에 VUser 를 300명으로 늘려도 큰 문제가 없었다.

하지만 위의 결과는 테스트 특성상 cache hit 비율이 100%가 됐기 때문에 비현실적인 성능 개선이 이뤄진 경우이다.

실제 환경에서는 자주 사용되는 검색어나 상품들은 로깅을 통해 알아내어 cache hit 비율을 70% 정도까지만 향상시켜도 기존 시스템에 비해 큰 성능 향상을 할 수 있을것이라고 생각한다.

## 기타 성능 개선

### gzip
| 적용 전| 적용 후  |
|---|---|
| 1247Bytes  | 617Bytes  |

서버 응답 데이터 전송 시 발생하는 네트워크 비용을 절감시키기 위해 `application/json` MIME 에 대해 gzip 압축을 적용 

### ETag
정적 리소스인 HTML 파일에 대해서는 조건부 캐싱 요청을 사용하기 위해 ETag 를 적용함










