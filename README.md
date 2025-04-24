# AT SOPT ANDROID
![banner_Android](https://github.com/user-attachments/assets/59daf471-b747-4696-8112-f2ef7adeb22c)

## ✨ Kotlin Scope Functions 한눈에 보기

Kotlin에는 객체를 다룰 때 유용하게 쓸 수 있는 스코프 함수들이 있습니다.  
`let`, `run`, `with`, `apply`, `also` 총 다섯 가지가 있고, 각각의 목적과 반환값이 조금씩 다릅니다.


### 🔍 간단 비교표

| 함수명 | 객체 참조 방식 | 반환값 | 주로 언제 사용하나요? |
|--------|----------------|--------|------------------------|
| `let`  | `it`           | 람다 결과 | null-safe 처리나 값 변환할 때 |
| `run`  | `this`         | 람다 결과 | 객체 초기화하면서 결과값 필요할 때 |
| `with` | `this`         | 람다 결과 | 이미 있는 객체에 작업을 여러 개 할 때 |
| `apply`| `this`         | 객체 자체 | 객체를 만들자마자 프로퍼티 초기화할 때 |
| `also` | `it`           | 객체 자체 | 로그 찍거나 디버깅 같은 부가 작업할 때 |
