package gettls.graphql.repository;

import gettls.graphql.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
