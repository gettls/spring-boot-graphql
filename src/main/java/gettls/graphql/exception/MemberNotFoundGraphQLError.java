package gettls.graphql.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class MemberNotFoundGraphQLError implements GraphQLError {
    private final MemberNotFoundException memberNotFoundException;


    public MemberNotFoundGraphQLError(MemberNotFoundException memberNotFoundException) {
        this.memberNotFoundException = memberNotFoundException;
    }

    @Override
    public String getMessage() {
        return this.memberNotFoundException.getMessage();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }
}
