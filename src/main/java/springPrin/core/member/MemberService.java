package springPrin.core.member;

public interface MemberService {
    // 회원가입, 조회의 두 가지 기능이 있어야함

    void join(Member member);

    Member findMember(Long memberId);

}
