package org.eclipse.fx.code.compensator.project.jdt.handler;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class NewClassTemplate {
  public static CharSequence generate(final String packagename, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packagename, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
