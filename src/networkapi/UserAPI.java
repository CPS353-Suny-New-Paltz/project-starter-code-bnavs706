package networkapi;

import project.annotations.NetworkAPI;

/**
 * Describes the configuration a network client must perform before it
 * can send or receive data. Each method returns the value that was
 * configured so the client can log or verify its setup.
 */
@NetworkAPI
public interface UserAPI {

    /**
     * Configure where input data should be read from.
     *
     * @param sourceUri URI or path for the input
     * @return the URI that was configured
     */
    String setInput(String sourceUri);

    /**
     * Configure where output data should be written to.
     *
     * @param sinkUri URI or path for the output
     * @return the URI that was configured
     */
    String setOutput(String sinkUri);

    /**
     * Configure how key/value pairs are delimited in the network payload.
     *
     * @param pairDelimiter delimiter between pairs
     * @param kvDelimiter   delimiter between key and value
     * @return an array containing the configured delimiters
     */
    String[] setDelimiters(String pairDelimiter, String kvDelimiter);

    /**
     * Reset delimiters to their defaults and return the active values so
     * the client can confirm what will be used.
     *
     * @return an array containing the default pair and key/value delimiters
     */
    String[] useDefaultDelimiters();
}
