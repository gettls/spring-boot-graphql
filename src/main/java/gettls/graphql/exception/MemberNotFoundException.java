package gettls.graphql.exception;

public class MemberNotFoundException extends RuntimeException {

    private static final String msg = "해당 유저를 찾지 못했습니다";


    public MemberNotFoundException() {
        super(msg);
    }

    public MemberNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}