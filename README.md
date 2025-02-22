## Q1. 도메인 클래스의 멤버 변수는 final로 선언해야 하는가?
- "불변성을 유지해야 하는가?"
- "값 변경이 얼마나 잦은가?"
- "**ProductStock**을 **가변 객체**(Mutable Object)로 선언하고, **Redis 락**(Redisson) 적용하면 대안이 될까?"

## final을 붙여야 할지 판단하는 기준

| 상황                              | final을 사용해야 할까? | 이유                                          |
|----------------------------------|-------------------------|-----------------------------------------------|
| 객체 생성 후 변경되지 않는 필드  | ✅ 사용                  | 불변성을 유지하고 객체의 정체성을 보장      |
| 불변 객체(Immutable Object) 또는 값 객체(Value Object) | ✅ 사용                  | 한 번 설정된 값이 변하면 안 됨               |
| 멀티스레드 환경에서 공유되는 값   | ✅ 사용                  | 동기화 없이 안전하게 공유 가능               |
| 상태가 자주 변경되는 필드 (ex: 재고, 가격) | ❌ 사용 금지             | 값 변경이 필요하므로 final을 제거해야 함     |
| JPA 엔티티(@Entity)의 필드        | ❌ 사용 금지             | JPA가 내부적으로 값을 변경할 수 있어야 함    |
| Spring 의존성 주입(DI)을 통한 필드 | ✅ 사용                  | @RequiredArgsConstructor를 활용하여 생성자 주입 가능 |



## Q2. Validation은 어디서 해야할까?
- Domain 레이어 : 생성 시 자기 검증
- Infrastructure 레이어(RepositoryImpl) : DB 관련 예외 반환
- Controller 레이어(DTO) : 요청 데이터 검증

- Maven lombok 오류 : 버전 명시 후 해결

&nbsp;

---

&nbsp;

## ✅ 언제 static을 사용할까?
- 모든 객체에서 공유해야 하는 값 (static int totalCount)
- 객체 생성 없이 사용해야 하는 메서드 (Math.max(), UUID.randomUUID())
- 클래스 내부에서 독립적으로 동작하는 중첩 클래스 (static class InnerClass)

## ✅ 언제 final을 사용할까?
- 한 번만 할당하고 변경할 수 없는 값 (final String appName)
- 메서드를 오버라이딩하지 못하게 할 때 (final void print())
- 클래스를 상속하지 못하게 할 때 (final class String)

## ✅ 언제 static final을 사용할까?
- 변하지 않는 전역 상수 (Math.PI, Integer.MAX_VALUE)
- 모든 객체가 공유해야 하는 불변 데이터 (static final String ERROR_MESSAGE = "Invalid Input")

---

## Q3. 멀티스레드와 final과 AtomicInteger

## Q4. ProductRepositoryImpl에서 CategoryRepository에 의존하는게 나을까, ProductRepositoryImpl에서 CategoryJpaRepository에 의존하는 게 나을까 아니면 ProductService에서 CategoryRepository에 의존하는게 나을까?
- 하위 레이어가 상위 레이어에 의존하면 안됨
- 서비스 레이어는 도메인 레이어에 의존
- (내 생각엔 )ProductRepositoryImpl에서 CategoryJpaRepository에 의존하는 게 나을 것 같아서 product의 멤버변수를 categoryId로 수정
- 동일 로직이 CategoryRepositoryImpl에 구현되어 있는데, 이걸 가져다 쓰기에는 RepositoryImpl(인프라스트럭처 레이어)가 CategoryRepository(비즈니스 레이어)에 의존하는 게 되어버려서 코드 중복을 허용

### ✅ 이 방식의 장점
- 서비스는 도메인 모델(Product)만 다룸 → JPA 엔티티와 결합되지 않음
- Repository 계층에서 JPA 관련 로직을 전담 → 역할이 분리됨
- 트랜잭션 관리도 자연스럽게 처리됨 → 조회 후 저장이 같은 트랜잭션 내에서 처리됨


## Q5. JPAEntity와 도메인 구조가 같을 필요는 없음
- 도메인은 책임 분리에 의해 보다 세분화 될 수 있음 ex) ProductPrice, ProductStock
