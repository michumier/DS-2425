package fylesystem.filters;

import java.io.IOException;

import fylesystem.Output;

public class NormalizeOutput implements Output{

    private Output output;
    private boolean jumpLineCondition;
    

    public NormalizeOutput(Output output) {
        this.output = output;
    }

    @Override
    public void open() throws IOException {
        output.open();
    }

    @Override
    public void write(char c) throws IOException {
        if (jumpLineCondition) {
            if (c == '\n') {
                output.write('\n'); // Escribimos solo '\n' para normalizar
            } else {
                output.write('\r'); // Si no es '\n', escribimos '\r' seguido del carácter actual
                output.write(c);
            }
            jumpLineCondition = false;
        } else {
            if (c == '\r') { // Si es \r esperamos a ver si hay luego \n
                jumpLineCondition = true;
            } else {
                output.write(c); 
            }
        }
    }

    @Override
    public void close() throws IOException {
        output.close();
    }

}
