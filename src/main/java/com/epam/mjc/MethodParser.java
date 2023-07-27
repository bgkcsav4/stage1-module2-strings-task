package com.epam.mjc;

import java.util.Arrays;
import java.util.List;

public class MethodParser {

    public MethodSignature parseFunction(String signatureString) throws UnsupportedOperationException {
        String[] parts = signatureString.split("\\s+");
        String accessModifier = null;
        String returnType;
        String methodName;


        if (parts[0].matches("public|protected|private")) {
            accessModifier = (parts[0]);
            parts = Arrays.copyOfRange(parts, 1, parts.length);
        }
        returnType = parts[0];
        parts = Arrays.copyOfRange(parts, 1, parts.length);
        methodName = parts[0];
        String argumentsString = signatureString.substring(signatureString.indexOf("(") + 1, signatureString.indexOf(")"));
        String[] arguments = argumentsString.split(",\\s*");
        List<MethodSignature.Argument> methodArguments = null;
        for (String arg : arguments) {
            String[] argParts = arg.split("\\s+");
            MethodSignature.Argument argument = new MethodSignature.Argument(argParts[0], argParts[1]);
            methodArguments = null;
            methodArguments.add(argument);
        }
        MethodSignature methodSignature = new MethodSignature(methodName, methodArguments);
        methodSignature.setAccessModifier(accessModifier);
        methodSignature.setReturnType(returnType);

        return methodSignature;

    }
}
