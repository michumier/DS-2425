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

public interface Visitor {

    Object visit(Assignment assignment, Object param);
    Object visit(Division division, Object param);
    Object visit(IntegerLiteral integerLiteral, Object param);
    Object visit(Print print, Object param);
    Object visit(Product product, Object param);
    Object visit(Program program, Object param);
    Object visit(Read read, Object param);
    Object visit(Statement statement, Object param);
    Object visit(Sum sum, Object param);
    Object visit(Variable variable, Object param);

}
