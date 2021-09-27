# 보상 관리 HTTP API
## 보상 전체 조회
> 보상 내역을 전체 조회한다.

 ```POST``` /reward/list
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|rewardKey | int | 8 |○|
|orderKey|  int | 8|○|
|ownerKey|  int | 8|○|
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
      "rewardKey" : "1",
      "orderKey" : "1",
      "orderNm" : "육회비빔밥",
      "ownerNm" : "홍길동",
      "rate" : "10",
      "reason" : "EVENT",
      "state" : "Y"
      "regDtm" : "YYYY-MM-DD HH24MISS"
      "levyDtm" : "YYYY-MM-DD HH24MISS"
      }
    ]
  }
]
```