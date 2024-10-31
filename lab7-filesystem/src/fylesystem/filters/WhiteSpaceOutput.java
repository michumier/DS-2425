package fylesystem.filters;

import java.io.IOException;

import fylesystem.Output;

public class WhiteSpaceOutput implements Output{

    private Output output;
    private boolean whiteSpace = false;


    public WhiteSpaceOutput(Output output) {
        this.output = output;
    }

    @Override
    public void open() throws IOException {
        output.open();
    }

    @Override
    public void write(char c) throws IOException {
        if(c == ' ' && !whiteSpace){
            whiteSpace = true;
            output.write(c);
        }
        else if(c == ' ' && whiteSpace){
            // Ya hubo un espacio, así que no se escribe
        }
        else{
            whiteSpace = false;
            output.write(c);
        }
    }

    @Override
    public void close() throws IOException {
        output.close();
    }


}
