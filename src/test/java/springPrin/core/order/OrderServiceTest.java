package springPrin.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springPrin.core.AppConfig;
import springPrin.core.member.Grade;
import springPrin.core.member.Member;
import springPrin.core.member.MemberService;
import springPrin.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig(); // 실행전에 AppConfig를 만들고
        memberService = appConfig.memberService(); // 그 다음 memberService를 위의 memberService에 할당
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA" , 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
