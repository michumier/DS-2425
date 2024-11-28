package interpreter.ast;

import java.util.*;

import interpreter.visitors.Visitor;

public class Program implements Node {
    
    public List<Statement> statements;
    
    public Program(List<Statement> program) {
        this.statements = program;
    }

    @Override
	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param); 
	}
}
