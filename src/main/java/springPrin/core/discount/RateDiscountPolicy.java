package springPrin.core.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springPrin.core.member.Grade;
import springPrin.core.member.Member;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
