/*
 * (c) Copyright 2001, 2002, 2003, 2004 2004, Hewlett-Packard Development Company, LP
 * [See end of file]
 */

/* Generated By:JJTree: Do not edit this line. Q_UnaryPlus.java */

package com.hp.hpl.jena.rdql.parser;


import java.io.PrintWriter;
import com.hp.hpl.jena.graph.query.IndexValues;
import com.hp.hpl.jena.graph.query.Expression ;
import com.hp.hpl.jena.rdql.*;

public class Q_UnaryPlus extends ExprNode implements ExprNumeric {
    Expr expr ;

    private String printName = "unaryplus" ;
    private String opSymbol = "+" ;

    Q_UnaryPlus(int id) { super(id); }
    Q_UnaryPlus(RDQLParser p, int id) { super(p, id); }

    public NodeValue eval(Query q, IndexValues env)
    {
        NodeValue r = expr.eval(q, env) ;
        if ( ! r.isNumber() )
            throw new EvalTypeException("Q_UnaryPlus: Wanted a number: got "+expr) ;

        return r ;
    }

    public void jjtClose()
    {
        int n = jjtGetNumChildren() ;
        if ( n != 1 )
            throw new QueryException("Q_UnaryPlus: Wrong number of children: "+n) ;
        expr = (Expr)jjtGetChild(0) ;
    }

    // -----------
    // graph.query.Expression

    public boolean isApply()         { return true ; }
    public String getFun()           { return super.constructURI(this.getClass().getName()) ; }
    public int argCount()            { return 1; }
    public Expression getArg(int i)  
    {
        if ( i == 0 && expr instanceof Expression )
            return (Expression)expr ;
        return null;
    }

    public String asInfixString() { return QueryPrintUtils.asInfixString1(expr, printName, opSymbol) ; }

    public String asPrefixString() { return QueryPrintUtils.asPrefixString(expr, null, printName, opSymbol) ; }

    public void print(PrintWriter pw, int level) { QueryPrintUtils.print(pw, expr, null, printName, opSymbol, level) ; }

    public String toString() { return asInfixString() ; }
}


/*
 *  (c) Copyright 2001, 2002, 2003, 2004 2004 Hewlett-Packard Development Company, LP
 *  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
