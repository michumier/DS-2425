package interpreter.ast;

import interpreter.visitors.Visitor;

public class Assignment implements Statement {
	
	public Variable variable;
	public Expression expression;

	public Assignment(Variable variable, Expression expression) {
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param); 
	}
}
