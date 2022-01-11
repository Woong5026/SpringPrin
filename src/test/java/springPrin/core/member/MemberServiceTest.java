package springPrin.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springPrin.core.AppConfig;

public class MemberServiceTest {

    MemberService memberService;

    // 테스트 실행전에 무조건 실행되는 환경경
   @BeforeEach
    public void beforeEach(){
       AppConfig appConfig = new AppConfig(); // 실행전에 AppConfig를 만들고
       memberService = appConfig.memberService(); // 그 다음 memberService를 위의 memberService에 할당
    }

    @Test
    void join(){
        //given : ~ 가 주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : ~ 을 실행했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : ~ 가 된다(검증)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
