package springPrin.core.order;

import springPrin.core.discount.DiscountPolicy;
import springPrin.core.discount.FixDiscountPolicy;
import springPrin.core.member.Member;
import springPrin.core.member.MemberRepository;
import springPrin.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // 실제 구현하는 OrderService를 구현하는 곳

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
