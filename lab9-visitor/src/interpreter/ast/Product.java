package interpreter.ast;

import interpreter.visitors.Visitor;

public class Product implements Expression {
	
	public Expression left, right;

	public Product(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param); 
	}
}
