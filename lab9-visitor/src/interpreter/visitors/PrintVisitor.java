package interpreter.visitors;

import interpreter.ast.Assignment;
import interpreter.ast.Division;
import interpreter.ast.IntegerLiteral;
import interpreter.ast.Print;
import interpreter.ast.Product;
import interpreter.ast.Program;
import interpreter.ast.Read;
import interpreter.ast.Statement;
import interpreter.ast.Sum;
import interpreter.ast.Variable;

public class PrintVisitor implements Visitor {

    @Override
	public Object visit(Assignment assignment, Object param) {
		System.out.println("assignment ");
		assignment.expression.accept(this, null);
		System.out.println(" = ");
		assignment.variable.accept(this, null);
		return null;
	}

	@Override
	public Object visit(Division division, Object param) {
		division.left.accept(this, null);
		System.out.print(" / ");
		division.right.accept(this, null);
		return null;
	}

	@Override
	public Object visit(IntegerLiteral integerLiteral, Object param) {
		System.out.print(integerLiteral.value);
		return null;

	}

	@Override
	public Object visit(Print print, Object param) {
		System.out.print("print ");
		print.expression.accept(this, null);
		System.out.print(";");
		return null;
	}

	@Override
	public Object visit(Product product, Object param) {
		product.left.accept(this, null);
		System.out.print(" * ");
		product.right.accept(this, null);
		return null;
	}

	@Override
	public Object visit(Program program, Object param) {
		for (Statement statement : program.statements) {
			statement.accept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(Read read, Object param) {
		System.out.print("read ");
		read.variable.accept(this, null);
		System.out.print(";");
		return null;
	}

	@Override
	public Object visit(Statement statement, Object param) {
		System.out.println("statement ");
		statement.accept(this, null);
		return null;
	}

	@Override
	public Object visit(Sum sum, Object param) {
		sum.left.accept(this, null);
		System.out.print(" + ");
		sum.right.accept(this, null);
		return null;
	}

	@Override
	public Object visit(Variable variable, Object param) {
		System.out.print(variable.name);
		return null;
	}



}
