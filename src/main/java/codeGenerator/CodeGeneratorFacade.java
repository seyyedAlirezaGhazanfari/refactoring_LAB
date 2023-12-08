package codeGenerator;

public class CodeGeneratorFacade {
    public static Address createAddress(int num, String varType_str, String type_str) {
        return new Address(num, varType.valueOf(varType_str), TypeAddress.valueOf(type_str));
    }
}
