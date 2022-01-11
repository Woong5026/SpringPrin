package springPrin.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springPrin.core.member.Grade;
import springPrin.core.member.Member;
import springPrin.core.member.MemberService;
import springPrin.core.member.MemberServiceImpl;
import springPrin.core.order.Order;
import springPrin.core.order.OrderService;
import springPrin.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA" , 20000);

        System.out.println("order = " + order);
//        System.out.println("order.calculationPrice() = " + order.calculationPrice());
    }
}
