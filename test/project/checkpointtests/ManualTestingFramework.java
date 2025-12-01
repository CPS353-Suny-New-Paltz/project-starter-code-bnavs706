package project.checkpointtests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import conceptualapi.ComputeAPI;
import implementations.ComputeImplement;
import implementations.StorageImplement;
import implementations.UserImplement;
import networkapi.UserAPI;
import processapi.StorageAPI;

/**
 * Manual testing entry point for Checkpoint 4.
 *
 * This class wires together the real API implementations in src/ and
 * runs a simple computation over the contents of {@link #INPUT}, writing
 * the results to {@link #OUTPUT}.
 */
public class ManualTestingFramework {

    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    public static void main(String[] args) {
        try {
            runComputation();
        } catch (IOException e) {
            // For manual testing it's fine to print the stack trace.
            e.printStackTrace();
        }
    }

    /**
     * Reads all lines from the input file, runs them through the compute
     * engine, and writes a single comma-separated line of results.
     *
     * The Checkpoint 4 tests expect:
     *  - the output file to exist after this method runs
     *  - exactly one line in the file
     *  - exactly one comma-separated result for each input line
     */
    private static void runComputation() throws IOException {
        // TODO 1 equivalent:
        // Instantiate real implementations of all three APIs.
        ComputeAPI engine = new ComputeImplement();
        StorageAPI storage = new StorageImplement();
        UserAPI user = new UserImplement(engine, storage);

        // Simple example configuration using the UserAPI.
        user.setInput(INPUT);
        user.setOutput(OUTPUT);
        user.setDelimiters(",", "=");

        Path inputPath = Paths.get(INPUT);
        Path outputPath = Paths.get(OUTPUT);

        List<String> lines = Files.readAllLines(inputPath);
        List<String> outputs = new ArrayList<>();

        for (String line : lines) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            try {
                int value = Integer.parseInt(trimmed);
                // Use the conceptual compute engine to calculate primes.
                String primeResult = engine.calculatePrimes(value);
                outputs.add(primeResult);
            } catch (NumberFormatException e) {
                // If a line is not a valid integer, still reserve a slot
                // so that there is one output for each input.
                outputs.add("");
            }
        }

        // If there were no valid lines, still create the file,
        // but the checkpoint tests focus on the non-empty case.
        if (outputs.isEmpty()) {
            Files.write(outputPath, List.of(""));
        } else {
            String singleLine = String.join(",", outputs);
            Files.write(outputPath, List.of(singleLine));
        }
    }
}
