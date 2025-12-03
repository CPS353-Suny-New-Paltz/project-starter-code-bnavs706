package processapi;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface StorageAPI {

    /**
     * Read data from the given source (for now, the source is treated as
     * the input data itself) and return the value so a client can use or
     * verify it immediately.
     *
     * @param source representation of where the input comes from
     * @return the data that was read from the source
     */
    String readInput(String source);

    /**
     * Write data to the given destination (for now, the destination is
     * treated as the output value) and return the value that was written
     * so that a client can log or display it.
     *
     * @param destination representation of where the output should go
     * @return the data that was written to the destination
     */
    String writeOutput(String destination);
}
