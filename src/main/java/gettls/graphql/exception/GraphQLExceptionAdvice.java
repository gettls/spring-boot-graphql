package gettls.graphql.exception;

import gettls.graphql.annotation.GraphQLAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@GraphQLAdvice
public class GraphQLExceptionAdvice {
    @ExceptionHandler(MemberNotFoundException.class)
    public MemberNotFoundGraphQLError handle(MemberNotFoundException ex){

        log.info("ex msg :: {}", ex.getMessage());

        return new MemberNotFoundGraphQLError(ex);
    }
}
