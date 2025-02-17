## Q1. 도메인 클래스의 멤버 변수는 final로 선언해야 하는가?
- "불변성을 유지해야 하는가?"
- "값 변경이 얼마나 잦은가?"
- "**ProductStock**을 **가변 객체**(Mutable Object)로 선언하고, **Redis 락**(Redisson) 적용하면 대안이 될까?"


## Q2. ProductService 가 CategoryRepository를 의존하는게 나을까 CategoryService를 의존하는게 나을까?