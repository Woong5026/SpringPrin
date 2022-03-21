현재 AppConfig를 보면 중복이 있고, 역할에 따른 구현이 잘 안보인다

아래 코드처럼 주문서비스 역할을 통해 뭐가 회원 저장소이고 뭐가 할인 정책을 위한 코드인지 잘 보이지 않음

```java

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}

```

---

리팩토링된 코드

```java

public class AppConfig {

    // 애플리케이션 전체를 설정하고 구성한다는 클래스
    // 이제 배우를 정하는 역할은 AppConfig에서 모두 구현하겠다(애플리케이션에 대한 환경구성)

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepositiory());
    }

    private MemberRepository memberRepositiory() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepositiory(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}

```

위와 같이 구성한다면 코드만 봐도 역할이 다 드러난다. 만약에 나중에 DB가 JDBC로 바뀌더라도 return에 해당하는 코드만 바꿔주면 된다

new MemoryMemberRepository() 이 부분이 중복 제거되었다.
이제 MemoryMemberRepository 를다른 구현체로 변경할 때 한 부분만 변경하면 된다.

AppConfig 를 보면 역할과 구현 클래스가 한눈에 들어온다. 애플리케이션 전체 구성이 어떻게 되어있는지
빠르게 파악할 수 있다






