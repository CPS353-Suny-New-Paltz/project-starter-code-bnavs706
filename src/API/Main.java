package API;

public class Main {
    public static void main(String[] args) {
        StorageAPI storage = new StorageAPI() {
            @Override public void readInput(String source) {
                System.out.println("readInput: " + source);
            }
            @Override public void writeOutput(String destination) {
                System.out.println("writeOutput: " + destination);
            }
        };
        new StorageAPIPrototype().prototype(storage);
    }
}
