package org.testingground.mower.argsparser;

import com.beust.jcommander.Parameter;

public class Args {
    /**
     * file path argument. It looks for a file name typed
     * after -f or --file.
     */
    @Parameter(names = { "-f", "--file" },
            description = "reference to the path of the mower details file",
            required = true)
    private String filePath;

    /**
     * Help Path argument. It looks for --help flag.
     */
    @Parameter(names = "--help", help = true)
    private boolean help;

    /**
     * getter for filePath.
     * @return filePath value.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * setter for filePath.
     * @param filePathParam filePath value
     */
    public void setFilePath(final String filePathParam) {
        this.filePath = filePathParam;
    }

    /**
     * getter for help bool flag.
     * @return the value of the help
     */
    public boolean isHelp() {
        return help;
    }

    /**
     * setter for Help bool flag.
     * @param helpParam help flag value.
     */
    public void setHelp(final boolean helpParam) {
        this.help = helpParam;
    }
}
