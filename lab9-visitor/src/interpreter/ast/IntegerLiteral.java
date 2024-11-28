package interpreter.ast;

import interpreter.visitors.Visitor;

public class IntegerLiteral implements Expression {
	
	public String value;

	public IntegerLiteral(String value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param); 
	}
}
