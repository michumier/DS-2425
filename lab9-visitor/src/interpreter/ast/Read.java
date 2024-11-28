package interpreter.ast;

import interpreter.visitors.Visitor;

public class Read implements Statement {
	
	public Variable variable;

	public Read(Variable variable) {
		this.variable = variable;
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param); 
	}
}
