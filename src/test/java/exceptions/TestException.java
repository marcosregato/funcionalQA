package exceptions;

public class TestException extends RuntimeException {
    
    private final String testName;
    private final String methodName;
    
    public TestException(String message) {
        super(message);
        this.testName = "Unknown";
        this.methodName = "Unknown";
    }
    
    public TestException(String testName, String methodName, String message) {
        super(message);
        this.testName = testName;
        this.methodName = methodName;
    }
    
    public TestException(String testName, String methodName, String message, Throwable cause) {
        super(message, cause);
        this.testName = testName;
        this.methodName = methodName;
    }
    
    public String getTestName() {
        return testName;
    }
    
    public String getMethodName() {
        return methodName;
    }
    
    @Override
    public String toString() {
        return String.format("TestException in %s.%s: %s", testName, methodName, getMessage());
    }
}
