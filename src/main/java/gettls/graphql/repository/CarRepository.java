package gettls.graphql.repository;

import gettls.graphql.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByMemberId(int memberId);

}
