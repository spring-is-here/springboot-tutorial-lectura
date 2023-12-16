package me.lectura.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 엔티티 속 데이터를 조회, 변경할 때 사용하는 인터페이스
public interface MemberRepository extends JpaRepository<Member, Long> {
}
