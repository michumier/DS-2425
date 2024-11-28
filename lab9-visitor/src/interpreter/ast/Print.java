package interpreter.ast;

import interpreter.visitors.Visitor;

public class Print implements Statement {


	public Expression expression;

	public Print(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param); 
	}
}
