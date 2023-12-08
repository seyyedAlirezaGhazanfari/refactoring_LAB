package scanner.token;

public class TokenFacade {
    public static Token createToken(String value) {
        return new Token(Token.getTypeFormString(value), value);
    }
}
