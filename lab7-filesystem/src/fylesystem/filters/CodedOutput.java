package fylesystem.filters;

import java.io.IOException;

import fylesystem.Output;

public class CodedOutput implements Output{

    private Output output;


    public CodedOutput(Output output) {
        this.output = output;
    }

    @Override
    public void open() throws IOException {
       output.open();
    }

    @Override
    public void write(char c) throws IOException {
		output.write((char) (Character.isLetterOrDigit(c) ? c + 1 : c));
    }

    @Override
    public void close() throws IOException {
        output.close();
    }

}
