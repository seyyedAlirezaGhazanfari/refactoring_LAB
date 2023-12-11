package codeGenerator.typeAddress;

public class Direct implements TypeAddress {
    private static Direct instance = null;

    public static Direct getInstance() {
        if (instance == null) {
            instance = new Direct();
        }
        return instance;
    }

    @Override
    public String getString(int num) {
        return num + "";
    }
}
