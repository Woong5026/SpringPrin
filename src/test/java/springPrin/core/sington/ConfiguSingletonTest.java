package springPrin.core.sington;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springPrin.core.AppConfig;
import springPrin.core.member.MemberRepository;
import springPrin.core.member.MemberServiceImpl;
import springPrin.core.order.OrderServiceImpl;

public class ConfiguSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderservice = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderservice.getMemberRepository();

        System.out.println("memberService > memberRepository = " + memberRepository1);
        System.out.println("orderservice > memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass()); // getClass 는 클래스 타입이 뭔지 알려준다
    }
}
