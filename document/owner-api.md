# B2B 회원 관리 HTTP API
## B2B 회원 전체 조회
> B2B 회원 전체를 조회한다.

```POST``` /api/owner/list
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|ownerKey | int | 20 |○|
|ownerNm| char | 20|○|
|storeId| char | 20|○|
|storeNm| char | 20|○|
|state| char |1|○|state 는 Y(정상), N(삭제), B(잠금), W(대기)로 구성되어있다.|

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
        "ownerKey" : "test",
        "ownerNm" : "test",
        "storeCnt" : 1,
        "state" : "Y"
      }
    ]
  }
]
```

## B2B 회원 정보 등록
> B2B 회원 정보를 등록한다.

```POST``` /api/owner/mod
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|ownerKey | int | 20 |○|자동으로 부여받는다.|
|ownerNm| char | 20|●|
|state| char | 1|●| Y(정상), N(삭제), B(잠금), W(대기)

### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| object | |○|
### RESPONSE SAMPLE
- 200 SUCCESS
```
[
  {
    "code" : "0000",
    "msg" : "success",
    "data" : {
      "ownerKey" :"1",
      "ownerNm":"test",
      "state":"Y"
    }
  }
]
```

## B2B 회원 정보 수정
> B2B 회원 정보를 수정한다.

```POST``` /api/owner/mod
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|ownerKey | int | 20 |●|
|ownerNm| char | 20|●|
|state| char | 1|●| Y(정상), N(삭제), B(잠금), W(대기)

### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| object | |○|
### RESPONSE SAMPLE
- 200 SUCCESS
```
[
  {
    "code" : "0000",
    "msg" : "success",
    "data" : {
      "ownerKey" :"1",
      "ownerNm":"test",
      "state":"Y"
    }
  }
]
```
## B2B회원 계좌정보 조회
> B2B회원 계좌정보 조회하는 API 이다.

> 사용 중인 계좌는 B2B 회원 1명당 1개만 사용 가능하다.

```POST``` /api/account/list
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|ownerKey | int | 20 |○|
|useYn | char | 1 |○|Y(사용),N(미사용)

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
        "accountId":"1",
        "ownerKey":"1",
        "ownerNm":"test",
        "account":"123123123123",
        "bank":"KB",
        "useYn":"Y"
      },
      {
        "accountId":"1",
        "ownerKey":"1",
        "ownerNm":"test",
        "account":"123123123123",
        "bank":"KB",
        "useYn":"N"
      }
    ]
  }
]
```
## B2B회원 계좌정보 등록
> B2B회원 계좌정보 등록하는 API 이다.

```POST``` /api/account/add
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|accountId | char | 20 |○|등록 시에 accountId는 자동으로 부여받는다.
|ownerKey|char|20|●|
|useYn|char|1|○|Y(사용), N(미사용)
|bank|char|20|●|은행
|account|char|200|●|계좌번호


### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| object | |○|
### RESPONSE SAMPLE
- 200 SUCCESS
```
[
  {
    "code" : "0000",
    "msg" : "success",
    "data" : 
      {
      "accountId" : "1",
      "ownerKey" : "1",
      "useYn" : "Y",
      "bank" : "WOORI",
      "account" : "123123123123",
      "regDtm" : "YYYY-MM-DD HH24MISS",
      "modDtm" : "YYYY-MM-DD HH24MISS"
      }
  }
]
```

## B2B회원 계좌정보 수정
> B2B회원 계좌정보 수정하는 API 이다.

```POST``` /api/account/mod
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|accountId | char | 20 |●|
|ownerKey|char|20|●|
|useYn|char|1|●|Y(사용), N(미사용)
|bank|char|20|●|은행
|account|char|200|●|계좌번호


### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| object | |○|
### RESPONSE SAMPLE
- 200 SUCCESS
```
[
  {
    "code" : "0000",
    "msg" : "success",
    "data" : 
      {
      "accountId" : "1",
      "ownerKey" : "1",
      "useYn" : "Y",
      "bank" : "WOORI",
      "account" : "123123123123",
      "regDtm" : "YYYY-MM-DD HH24MISS",
      "modDtm" : "YYYY-MM-DD HH24MISS"
      }
  }
]
```
## 매장 정보 전체 조회
> 매장 정보 전체 조회 API 이다.

```POST``` /api/store/list
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|storeId | char | 20 |○|
|ownerKey | int | 20 |○|
|storeNm| char | 20|○|
|state| char | 20|○|state 는 Y(정상), N(삭제), B(잠금), W(대기)로 구성되어있다.

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
        "storeId":"1",
        "ownerKey":"1",
        "storeNm":"동해번쩍횟집",
        "state":"Y",
        "regDtm" : "YYYY-MM-DD HH24MISS",
        "modDtm" : "YYYY-MM-DD HH24MISS"
      },
      {
        "storeId":"3",
        "ownerKey":"2",
        "storeNm":"남산돈까스2호점",
        "state":"W",
        "regDtm" : "YYYY-MM-DD HH24MISS",
        "modDtm" : "YYYY-MM-DD HH24MISS"
      },
      {
        "storeId":"2",
        "ownerKey":"2",
        "storeNm":"남산돈까스1호점",
        "state":"Y",
        "regDtm" : "YYYY-MM-DD HH24MISS",
        "modDtm" : "YYYY-MM-DD HH24MISS"
      }
    ]
  }
]
```
## 매장 정보 등록
> 매장 정보 등록 API

```POST``` /api/store/add
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|storeId | char | 20 |○|등록 시에 storeId는 자동으로 부여받는다.
|ownerKey | int | 20 |●|
|storeNm| char | 20|●|
|state| char | 20|●|state 는 Y(정상), N(삭제), B(잠금), W(대기)로 구성되어있다.

### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| object | |○|
### RESPONSE SAMPLE
- 200 SUCCESS
```
[
  {
    "code" : "0000",
    "msg" : "success",
    "data" :
      {
        "storeId":"1",
        "ownerKey":"1",
        "storeNm":"동해번쩍횟집",
        "state":"Y",
        "regDtm" : "YYYY-MM-DD HH24MISS",
        "modDtm" : "YYYY-MM-DD HH24MISS"
      }
  }
]
```

## 매장 정보 수정
> 매장 정보 수정 API

```POST``` /api/store/mod
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|storeId | char | 20 |●|
|ownerKey | int | 20 |●|
|storeNm| char | 20|●|
|state| char | 20|●|state 는 Y(정상), N(삭제), B(잠금), W(대기)로 구성되어있다.

### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| object | |○|
### RESPONSE SAMPLE
- 200 SUCCESS
```
[
  {
    "code" : "0000",
    "msg" : "success",
    "data" :
      {
        "storeId":"1",
        "ownerKey":"1",
        "storeNm":"동해번쩍횟집",
        "state":"Y",
        "regDtm" : "YYYY-MM-DD HH24MISS",
        "modDtm" : "YYYY-MM-DD HH24MISS"
      }
  }
]
```