package com.epam.mjc;

import java.util.Arrays;
import java.util.List;

public class MethodParser {

    public MethodSignature parseFunction(String signatureString) throws UnsupportedOperationException {
        String[] parts = signatureString.split("\\s+");
        String accessModifier = null;
        String returnType;
        String methodName;

        if (parts.length > 0) {
            if (parts[0].matches("public|protected|private")) {
                accessModifier = (parts[0]);
                parts = Arrays.copyOfRange(parts, 1, parts.length);
            }
            if (parts.length > 0) {
                returnType = parts[0];
                parts = Arrays.copyOfRange(parts, 1, parts.length);
                if (parts.length > 0) {
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
                } else {
                    throw new IllegalArgumentException("Method name is missing.");
                }
            } else {
                throw new IllegalArgumentException("Return type is missing.");
            }
        } else {
            throw new IllegalArgumentException("Method signature is empty.");
        }

    }
}
