package interpreter.ast;

import interpreter.visitors.Visitor;

public class Variable implements Expression {
	
	public String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param); 
	}
}
