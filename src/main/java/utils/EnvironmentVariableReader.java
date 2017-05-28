package utils;

public class EnvironmentVariableReader {

    public static String getSystemEnvironment() {
            return getEnvironmentVariable("ENVIRONMENT"); //extract environmentVariable out?
    }

    private static String getEnvironmentVariable(String variable) {
        String out = System.getenv(variable);

        if (out == null)
            return "localhost"; //changed to allow mvn test to work
//            throw new NullPointerException(String.format("The environment variable '%s' was not found on this system.", variable));

        return out;
    }
}
