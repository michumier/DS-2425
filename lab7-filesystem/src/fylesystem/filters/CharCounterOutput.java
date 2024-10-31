package fylesystem.filters;

import java.io.IOException;

import fylesystem.Output;

public class CharCounterOutput implements Output{

    private Output output;
    private int counter;

    public CharCounterOutput(Output output) {
        this.output = output;
        this.counter = 0;
    }

    @Override
    public void open() throws IOException {
        output.open();
    }

    @Override
    public void write(char c) throws IOException {
        if(Character.isLetterOrDigit(c)){
            
            counter++;
        }
        output.write(c);
    }

    @Override
    public void close() throws IOException {
        output.close();
    }

    public void printCharCounter(){
        System.out.println(" - Character counter: " + counter);
    }

}
