package springPrin.core.discount;

import springPrin.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
