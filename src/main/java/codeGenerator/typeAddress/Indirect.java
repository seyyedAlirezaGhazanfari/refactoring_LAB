package codeGenerator.typeAddress;

public class Indirect implements TypeAddress {
    private static Indirect instance = null;

    public static Indirect getInstance() {
        if (instance == null) {
            instance = new Indirect();
        }
        return instance;
    }

    @Override
    public String getString(int num) {
        return "@" + num;
    }
}
