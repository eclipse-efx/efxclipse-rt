package org.eclipse.fx.code.editor.ldef.generator;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.Root;
import org.eclipse.fx.code.editor.ldef.lDef.Token;
import org.eclipse.fx.code.editor.ldef.lDef.TokenVisual;
import org.eclipse.fx.code.editor.ldef.lDef.TokenVisuals;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DeclarativeStyleingGenerator {
  public void generate(final LanguageDef model, final IFileSystemAccess access) {
    LexicalHighlighting _lexicalHighlighting = null;
    if (model!=null) {
      _lexicalHighlighting=model.getLexicalHighlighting();
    }
    TokenVisuals _vistual = null;
    if (_lexicalHighlighting!=null) {
      _vistual=_lexicalHighlighting.getVistual();
    }
    boolean _notEquals = (!Objects.equal(_vistual, null));
    if (_notEquals) {
      EObject _eContainer = model.eContainer();
      String _name = ((Root) _eContainer).getName();
      String _replace = _name.replace(".", "/");
      String _plus = (_replace + "/");
      String _name_1 = model.getName();
      String _plus_1 = (_plus + _name_1);
      String _plus_2 = (_plus_1 + ".css");
      CharSequence _generateJavaFXCSS = this.generateJavaFXCSS(model);
      access.generateFile(_plus_2, _generateJavaFXCSS);
      EObject _eContainer_1 = model.eContainer();
      String _name_2 = ((Root) _eContainer_1).getName();
      String _replace_1 = _name_2.replace(".", "/");
      String _plus_3 = (_replace_1 + "/");
      String _name_3 = model.getName();
      String _plus_4 = (_plus_3 + _name_3);
      String _plus_5 = (_plus_4 + "-swt-style.json");
      CharSequence _generateSWTStyleing = this.generateSWTStyleing(model);
      access.generateFile(_plus_5, _generateSWTStyleing);
    }
  }
  
  public CharSequence generateJavaFXCSS(final LanguageDef model) {
    StringConcatenation _builder = new StringConcatenation();
    {
      LexicalHighlighting _lexicalHighlighting = model.getLexicalHighlighting();
      TokenVisuals _vistual = _lexicalHighlighting.getVistual();
      EList<TokenVisual> _tokenVisuals = _vistual.getTokenVisuals();
      for(final TokenVisual tv : _tokenVisuals) {
        _builder.append(".styled-text-area .");
        String _name = model.getName();
        _builder.append(_name, "");
        _builder.append(".");
        Token _token = tv.getToken();
        String _name_1 = _token.getName();
        _builder.append(_name_1, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("-styled-text-color: ");
        String _colorSpec = tv.getColorSpec();
        _builder.append(_colorSpec, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        {
          boolean _isBold = tv.isBold();
          if (_isBold) {
            _builder.append("\t");
            _builder.append("-fx-font-weight: bold;");
            _builder.newLine();
          }
        }
        {
          boolean _isItalic = tv.isItalic();
          if (_isItalic) {
            _builder.append("\t");
            _builder.append("-fx-font-style: italic;");
            _builder.newLine();
          }
        }
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence generateSWTStyleing(final LanguageDef model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"$gtype\": \"StylesheetDefinition\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"colorList\": [],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"elementList\": [");
    _builder.newLine();
    {
      LexicalHighlighting _lexicalHighlighting = model.getLexicalHighlighting();
      TokenVisuals _vistual = _lexicalHighlighting.getVistual();
      EList<TokenVisual> _tokenVisuals = _vistual.getTokenVisuals();
      for(final TokenVisual tv : _tokenVisuals) {
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("  ");
        _builder.append("\"$gtype\": \"StyleDefinition\",");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("  ");
        _builder.append("\"bold\": ");
        boolean _isBold = tv.isBold();
        _builder.append(_isBold, "\t  ");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("  ");
        _builder.append("\"italic\": ");
        boolean _isItalic = tv.isItalic();
        _builder.append(_isItalic, "\t  ");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("  ");
        _builder.append("\"name\": \"");
        String _name = model.getName();
        _builder.append(_name, "\t  ");
        _builder.append(".");
        Token _token = tv.getToken();
        String _name_1 = _token.getName();
        _builder.append(_name_1, "\t  ");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("  ");
        _builder.append("\"textRefColor\": \"");
        String _colorSpec = tv.getColorSpec();
        _builder.append(_colorSpec, "\t  ");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        {
          LexicalHighlighting _lexicalHighlighting_1 = model.getLexicalHighlighting();
          TokenVisuals _vistual_1 = _lexicalHighlighting_1.getVistual();
          EList<TokenVisual> _tokenVisuals_1 = _vistual_1.getTokenVisuals();
          TokenVisual _last = IterableExtensions.<TokenVisual>last(_tokenVisuals_1);
          boolean _notEquals = (!Objects.equal(_last, tv));
          if (_notEquals) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
