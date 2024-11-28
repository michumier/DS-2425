package interpreter.ast;

import interpreter.visitors.Visitor;

public interface Node {

    Object accept(Visitor visitor, Object param);
}
