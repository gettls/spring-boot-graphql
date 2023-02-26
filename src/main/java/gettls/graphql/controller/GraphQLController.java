package gettls.graphql.controller;

import gettls.graphql.entity.Car;
import gettls.graphql.entity.Member;
import gettls.graphql.exception.MemberNotFoundException;
import gettls.graphql.repository.CarRepository;
import gettls.graphql.repository.MemberRepository;
import graphql.GraphQLContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GraphQLController {

    private final MemberRepository memberRepository;
    private final CarRepository carRepository;

    @SchemaMapping
    public Car car(Member member){
        return carRepository.findByMemberId(member.getId().intValue());
    }

    @MutationMapping
    public Car saveCar(@Argument String name, @Argument int memberId){

        Car car = Car.builder()
                .name(name)
                .memberId(memberId)
                .build();

        return carRepository.save(car);
    }

    @QueryMapping
    public Member getMember(@Argument Long id, GraphQLContext context){
        context.put("token", "test");
        return memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
    }

    @QueryMapping
    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    @MutationMapping
    public Member save(@Argument String name, @Argument int age){
        Member member = Member.builder()
                .name(name)
                .age(age)
                .build();
        return memberRepository.save(member);
    }

    @QueryMapping
    public boolean exception(){

        throw new MemberNotFoundException();

//        return true;
    }

}
