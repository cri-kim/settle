# 주문 관리 HTTP API
## 주문 전체 조회
> ```POST``` /order/list
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|orderKey | int | 8 |○|
|ownerKey|  int | 8|○|
|storeKey|  int | 8|○|
|orderNm|  char | 20|○|
|regDtm|  datetime | |○|
### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| list | |○|
### RESPONSE SAMPLE
- 200 SUCCESS
```
[
  {
    "code" : "0000",
    "msg" : "success",
    "data" : [
      {
      "orderKey" : "1",
      "orderNm" : "육회비빔밥",
      "ownerKey" : "1",
      "ownerNm" : "홍길동",
      "regDtm" : "YYYY-MM-DD HH24MISS"
      }
    ]
  }
]
```
## 주문 상세 조회
> ```POST``` /order/detail
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|orderKey | int | 8 |●|
### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| object | |○|
### RESPONSE SAMPLE
- 200 SUCCESS
```
  {
    "code" : "0000",
    "msg" : "success",
    "data" : [
      {
      "orderKey" : "1",
      "orderNm" : "육회비빔밥",
      "ownerKey" : "1",
      "ownerNm" : "홍길동",
      "paymentKey" : "1",
      "faceValue" : "50000",
      "amount" : "55000",
      "regDtm" : "YYYY-MM-DD HH24MISS"
      }
    ]
  }
```
## 일 주문 정산 조회
> ```POST``` /order/day
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| list | |○|
### RESPONSE SAMPLE