package codeGenerator;

import codeGenerator.typeAddress.Imidiate;

public class CodeGeneratorFacade {
    public static Address createImmidiateAddress(int num, String varType_str) {
        return new Address(num, varType.valueOf(varType_str), Imidiate.getInstance());
    }
}
