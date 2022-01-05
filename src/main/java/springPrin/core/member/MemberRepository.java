package springPrin.core.member;

public interface MemberRepository {

    void save(Member member); // 회원저장

    Member findById(Long memberId); // 회원찾기기

    // 해동에 따른 구현체로 MemoryMemberRepository 생성하기
}
