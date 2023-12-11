package codeGenerator.typeAddress;

public class Imidiate implements TypeAddress {
    private static Imidiate instance = null;

    public static Imidiate getInstance() {
        if (instance == null) {
            instance = new Imidiate();
        }
        return instance;
    }

    @Override
    public String getString(int num) {
        return "#" + num;
    }
}
