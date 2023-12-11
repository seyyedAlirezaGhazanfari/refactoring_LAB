package codeGenerator;

import codeGenerator.typeAddress.Direct;
import codeGenerator.typeAddress.TypeAddress;

public class Address {
    public int num;
    public TypeAddress Type;
    public varType varType;

    public Address(int num, varType varType, TypeAddress Type) {
        this.num = num;
        this.Type = Type;
        this.varType = varType;
    }

    public Address(int num, varType varType) {
        this.num = num;
        this.Type = Direct.getInstance();
        this.varType = varType;
    }

    public String toString() {
        if (Type == null) {
            return num + "";
        }
        return Type.getString(num);
    }
}
