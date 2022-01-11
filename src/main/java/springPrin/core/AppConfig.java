package springPrin.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springPrin.core.discount.DiscountPolicy;
import springPrin.core.discount.FixDiscountPolicy;
import springPrin.core.discount.RateDiscountPolicy;
import springPrin.core.member.MemberRepository;
import springPrin.core.member.MemberService;
import springPrin.core.member.MemberServiceImpl;
import springPrin.core.member.MemoryMemberRepository;
import springPrin.core.order.OrderService;
import springPrin.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    // 애플리케이션 전체를 설정하고 구성한다는 클래스
    // 이제 배우를 정하는 역할은 AppConfig에서 모두 구현하겠다(애플리케이션에 대한 환경구성)

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepositiory());
    }
    @Bean
    public MemberRepository memberRepositiory() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepositiory(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
