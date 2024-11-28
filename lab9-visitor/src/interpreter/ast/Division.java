package interpreter.ast;

import interpreter.visitors.Visitor;

public class Division implements Expression {
	public Expression left, right;

	public Division(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param); 
	}
}
