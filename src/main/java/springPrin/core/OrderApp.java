package springPrin.core;

import springPrin.core.member.Grade;
import springPrin.core.member.Member;
import springPrin.core.member.MemberService;
import springPrin.core.member.MemberServiceImpl;
import springPrin.core.order.Order;
import springPrin.core.order.OrderService;
import springPrin.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA" , 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculationPrice() = " + order.calculationPrice());
    }
}
