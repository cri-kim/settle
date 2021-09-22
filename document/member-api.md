# 사용자 관리 HTTP API
## 로그인
> 사용자 로그인 성공 시, 로그인 토큰을 받는다.

> 토큰의 유효시간은 발급 후, 10분이다.

> 유효시간 내에 갱신이 가능하다.


```POST``` /api/login
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|memberId | char | 20 |●|
|passwd| char | 20|●|

### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
### RESPONSE SAMPLE
- 200 SUCCESS
- 400 BAD REQUEST
- 500 INTERNAL SERVER ERROR
```
[
  {
    "code" : "4000",
    "msg" : "Bad parameter",
    "data" : ""
  }
]
```
## 토큰 갱신
> 토큰의 유효시간은 발급 후, 10분이다.

```POST``` /api/login/refresh
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|

### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| char | 20|○|
### RESPONSE SAMPLE
- 200 SUCCESS
```
[
  {
    "code" : "0000",
    "msg" : "success",
    "data" : ""
  }
]
```
## 회원가입
> 회원 가입을 요청하는 API 이다.

```POST``` /api/user/add
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|memberId | char | 20 |●|
|memberNm | char | 20 |●|
|passwd| char | 20|●|

### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| char | 20|○|
### RESPONSE SAMPLE
- 200 SUCCESS
```
[
  {
    "code" : "0000",
    "msg" : "success",
    "data" : ""
  }
]
```
## 사용자 전체 조회
> 사용자 전체를 조회하는 API 이다.

```POST``` /api/user/list
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|memberId | char | 20 |○|
|role|char|20|○|
|state|char|1|○|

### RESPONSE PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
| code | char | 20 |●|
|msg| char | 20|○|
|data| list | |○|state 는 Y(정상), N(삭제), B(잠금), W(대기)로 구성되어있다. role은 MEMBER/OWNER 두 가지이다.
### RESPONSE SAMPLE
- 200 SUCCESS
```
[
  {
    "code" : "0000",
    "msg" : "success",
    "data" : [
      {
      "memberId" : "test",
      "memberNm" : "test",
      "state" : "Y",
      "role" : "MEMBER",
      "regDtm" : "YYYY-MM-DD HH24MISS",
      "modDtm" : "YYYY-MM-DD HH24MISS"
      },
      {
      "memberId" : "test2",
      "memberNm" : "test2",
      "state" : "N",
      "role" : "MEMBER",
      "regDtm" : "YYYY-MM-DD HH24MISS",
      "modDtm" : "YYYY-MM-DD HH24MISS"
      }
    ]
  }
]
```
## 사용자 조회
```POST``` /api/user/info
### REQUEST PARAMETER
### RESPONSE PARAMETER
### RESPONSE SAMPLE

## 사용자 수정
> 사용자 정보를 수정하는 API 이다.

```POST``` /api/user/mod
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|memberId | char | 20 |●|
|memberNm | char | 20 |●|
|passwd| char | 20|●|
|state| char | 20|●|
|role|char|20|○|
|state|char|1|○|

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
      "memberId":"test",
      "memberNm":"test",
      "role":"MEMBER",
      "state":"Y"
    }
  }
]
```
## 사용자 권한 전체 조회
> 사용자 권한 전체를 조회하는 API 이다.

```POST``` /api/user/auth/list
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|memberId | char | 20 |○|
|authId| int | 8|○|

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
    "data" : [{
      "memberId":"test",
      "authId":"1",
    },
    {
      "memberId":"test",
      "authId":"2",
    },
    {
      "memberId":"test2",
      "authId":"2",
    }
    ]
  }
]
```
## 권한 등록/삭제
> 사용자 권한을 등록/삭제하는 API 이다.

```POST``` /api/user/auth/mod
### REQUEST PARAMETER
|Parameter| Type | Length | Required| Description|
|:--:|:--:|:--:|:--:|--|
|memberId | char | 20 |○|
|authId| int | 8|○|
|useYn| char | 1|○| Y(등록), N(삭제)

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
      "memberId":"test",
      "authId":"1",
      "useYn":"Y"
    }
  }
]
```
