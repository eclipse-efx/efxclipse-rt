package org.eclipse.fx.code.editor.ldef.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.fx.code.editor.ldef.services.LDefGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalLDefParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'*'", "'import'", "'{'", "'}'", "'integration'", "'javafx'", "'swt'", "'partitioning'", "'partition'", "'script'", "'rule'", "'single_line'", "'=>'", "'escaped'", "'by'", "'multi_line'", "'lexical_highlighting'", "'keywords'", "'['", "']'", "','", "'since'", "'character'", "'whitespace'", "'codegeneration'", "'e4'", "'default'", "'javawhitespace'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalLDefParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLDefParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLDefParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g"; }


     
     	private LDefGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(LDefGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleRoot"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:61:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:62:1: ( ruleRoot EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:63:1: ruleRoot EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootRule()); 
            }
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot67);
            ruleRoot();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot74); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:70:1: ruleRoot : ( ( rule__Root__Group__0 ) ) ;
    public final void ruleRoot() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:74:2: ( ( ( rule__Root__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:75:1: ( ( rule__Root__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:75:1: ( ( rule__Root__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:76:1: ( rule__Root__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:77:1: ( rule__Root__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:77:2: rule__Root__Group__0
            {
            pushFollow(FOLLOW_rule__Root__Group__0_in_ruleRoot100);
            rule__Root__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleValidID"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:89:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:90:1: ( ruleValidID EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:91:1: ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID127);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValidIDRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID134); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:98:1: ruleValidID : ( RULE_ID ) ;
    public final void ruleValidID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:102:2: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:103:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:103:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:104:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID160); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:117:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:118:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:119:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName186);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName193); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:126:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:130:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:131:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:131:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:132:1: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:133:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:133:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName219);
            rule__QualifiedName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:145:1: entryRuleQualifiedNameWithWildCard : ruleQualifiedNameWithWildCard EOF ;
    public final void entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:146:1: ( ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:147:1: ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard246);
            ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard253); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:154:1: ruleQualifiedNameWithWildCard : ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildCard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:158:2: ( ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:159:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:159:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:160:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:161:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:161:2: rule__QualifiedNameWithWildCard__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__0_in_ruleQualifiedNameWithWildCard279);
            rule__QualifiedNameWithWildCard__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:173:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:174:1: ( ruleImport EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:175:1: ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport306);
            ruleImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport313); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:182:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:186:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:187:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:187:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:188:1: ( rule__Import__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:189:1: ( rule__Import__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:189:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport339);
            rule__Import__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleLanguageDef"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:201:1: entryRuleLanguageDef : ruleLanguageDef EOF ;
    public final void entryRuleLanguageDef() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:202:1: ( ruleLanguageDef EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:203:1: ruleLanguageDef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefRule()); 
            }
            pushFollow(FOLLOW_ruleLanguageDef_in_entryRuleLanguageDef366);
            ruleLanguageDef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLanguageDef373); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLanguageDef"


    // $ANTLR start "ruleLanguageDef"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:210:1: ruleLanguageDef : ( ( rule__LanguageDef__Group__0 ) ) ;
    public final void ruleLanguageDef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:214:2: ( ( ( rule__LanguageDef__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:215:1: ( ( rule__LanguageDef__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:215:1: ( ( rule__LanguageDef__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:216:1: ( rule__LanguageDef__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:217:1: ( rule__LanguageDef__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:217:2: rule__LanguageDef__Group__0
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__0_in_ruleLanguageDef399);
            rule__LanguageDef__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLanguageDef"


    // $ANTLR start "entryRuleIntegration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:229:1: entryRuleIntegration : ruleIntegration EOF ;
    public final void entryRuleIntegration() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:230:1: ( ruleIntegration EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:231:1: ruleIntegration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationRule()); 
            }
            pushFollow(FOLLOW_ruleIntegration_in_entryRuleIntegration426);
            ruleIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegration433); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntegration"


    // $ANTLR start "ruleIntegration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:238:1: ruleIntegration : ( ( rule__Integration__Group__0 ) ) ;
    public final void ruleIntegration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:242:2: ( ( ( rule__Integration__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:243:1: ( ( rule__Integration__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:243:1: ( ( rule__Integration__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:244:1: ( rule__Integration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:245:1: ( rule__Integration__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:245:2: rule__Integration__Group__0
            {
            pushFollow(FOLLOW_rule__Integration__Group__0_in_ruleIntegration459);
            rule__Integration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegration"


    // $ANTLR start "entryRuleCodeIntegration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:257:1: entryRuleCodeIntegration : ruleCodeIntegration EOF ;
    public final void entryRuleCodeIntegration() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:258:1: ( ruleCodeIntegration EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:259:1: ruleCodeIntegration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCodeIntegrationRule()); 
            }
            pushFollow(FOLLOW_ruleCodeIntegration_in_entryRuleCodeIntegration486);
            ruleCodeIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCodeIntegrationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodeIntegration493); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCodeIntegration"


    // $ANTLR start "ruleCodeIntegration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:266:1: ruleCodeIntegration : ( ( rule__CodeIntegration__Alternatives ) ) ;
    public final void ruleCodeIntegration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:270:2: ( ( ( rule__CodeIntegration__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:271:1: ( ( rule__CodeIntegration__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:271:1: ( ( rule__CodeIntegration__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:272:1: ( rule__CodeIntegration__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCodeIntegrationAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:273:1: ( rule__CodeIntegration__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:273:2: rule__CodeIntegration__Alternatives
            {
            pushFollow(FOLLOW_rule__CodeIntegration__Alternatives_in_ruleCodeIntegration519);
            rule__CodeIntegration__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCodeIntegrationAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCodeIntegration"


    // $ANTLR start "entryRuleJavaFXIntegration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:285:1: entryRuleJavaFXIntegration : ruleJavaFXIntegration EOF ;
    public final void entryRuleJavaFXIntegration() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:286:1: ( ruleJavaFXIntegration EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:287:1: ruleJavaFXIntegration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationRule()); 
            }
            pushFollow(FOLLOW_ruleJavaFXIntegration_in_entryRuleJavaFXIntegration546);
            ruleJavaFXIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaFXIntegration553); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJavaFXIntegration"


    // $ANTLR start "ruleJavaFXIntegration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:294:1: ruleJavaFXIntegration : ( ( rule__JavaFXIntegration__Group__0 ) ) ;
    public final void ruleJavaFXIntegration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:298:2: ( ( ( rule__JavaFXIntegration__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:299:1: ( ( rule__JavaFXIntegration__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:299:1: ( ( rule__JavaFXIntegration__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:300:1: ( rule__JavaFXIntegration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:301:1: ( rule__JavaFXIntegration__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:301:2: rule__JavaFXIntegration__Group__0
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__0_in_ruleJavaFXIntegration579);
            rule__JavaFXIntegration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJavaFXIntegration"


    // $ANTLR start "entryRuleSWTIntegration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:313:1: entryRuleSWTIntegration : ruleSWTIntegration EOF ;
    public final void entryRuleSWTIntegration() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:314:1: ( ruleSWTIntegration EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:315:1: ruleSWTIntegration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationRule()); 
            }
            pushFollow(FOLLOW_ruleSWTIntegration_in_entryRuleSWTIntegration606);
            ruleSWTIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSWTIntegration613); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSWTIntegration"


    // $ANTLR start "ruleSWTIntegration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:322:1: ruleSWTIntegration : ( ( rule__SWTIntegration__Group__0 ) ) ;
    public final void ruleSWTIntegration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:326:2: ( ( ( rule__SWTIntegration__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:327:1: ( ( rule__SWTIntegration__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:327:1: ( ( rule__SWTIntegration__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:328:1: ( rule__SWTIntegration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:329:1: ( rule__SWTIntegration__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:329:2: rule__SWTIntegration__Group__0
            {
            pushFollow(FOLLOW_rule__SWTIntegration__Group__0_in_ruleSWTIntegration639);
            rule__SWTIntegration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSWTIntegration"


    // $ANTLR start "entryRuleParitioning"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:341:1: entryRuleParitioning : ruleParitioning EOF ;
    public final void entryRuleParitioning() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:342:1: ( ruleParitioning EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:343:1: ruleParitioning EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningRule()); 
            }
            pushFollow(FOLLOW_ruleParitioning_in_entryRuleParitioning666);
            ruleParitioning();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioning673); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParitioning"


    // $ANTLR start "ruleParitioning"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:350:1: ruleParitioning : ( ( rule__Paritioning__Group__0 ) ) ;
    public final void ruleParitioning() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:354:2: ( ( ( rule__Paritioning__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:355:1: ( ( rule__Paritioning__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:355:1: ( ( rule__Paritioning__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:356:1: ( rule__Paritioning__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:357:1: ( rule__Paritioning__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:357:2: rule__Paritioning__Group__0
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__0_in_ruleParitioning699);
            rule__Paritioning__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParitioning"


    // $ANTLR start "entryRulePartition"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:369:1: entryRulePartition : rulePartition EOF ;
    public final void entryRulePartition() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:370:1: ( rulePartition EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:371:1: rulePartition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionRule()); 
            }
            pushFollow(FOLLOW_rulePartition_in_entryRulePartition726);
            rulePartition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition733); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePartition"


    // $ANTLR start "rulePartition"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:378:1: rulePartition : ( ( rule__Partition__Group__0 ) ) ;
    public final void rulePartition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:382:2: ( ( ( rule__Partition__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:383:1: ( ( rule__Partition__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:383:1: ( ( rule__Partition__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:384:1: ( rule__Partition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:385:1: ( rule__Partition__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:385:2: rule__Partition__Group__0
            {
            pushFollow(FOLLOW_rule__Partition__Group__0_in_rulePartition759);
            rule__Partition__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePartition"


    // $ANTLR start "entryRulePartitioner"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:397:1: entryRulePartitioner : rulePartitioner EOF ;
    public final void entryRulePartitioner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:398:1: ( rulePartitioner EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:399:1: rulePartitioner EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionerRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_in_entryRulePartitioner786);
            rulePartitioner();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionerRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner793); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePartitioner"


    // $ANTLR start "rulePartitioner"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:406:1: rulePartitioner : ( ( rule__Partitioner__Alternatives ) ) ;
    public final void rulePartitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:410:2: ( ( ( rule__Partitioner__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:411:1: ( ( rule__Partitioner__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:411:1: ( ( rule__Partitioner__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:412:1: ( rule__Partitioner__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionerAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:413:1: ( rule__Partitioner__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:413:2: rule__Partitioner__Alternatives
            {
            pushFollow(FOLLOW_rule__Partitioner__Alternatives_in_rulePartitioner819);
            rule__Partitioner__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionerAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePartitioner"


    // $ANTLR start "entryRuleParitioner_JS"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:425:1: entryRuleParitioner_JS : ruleParitioner_JS EOF ;
    public final void entryRuleParitioner_JS() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:426:1: ( ruleParitioner_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:427:1: ruleParitioner_JS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSRule()); 
            }
            pushFollow(FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS846);
            ruleParitioner_JS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioner_JSRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioner_JS853); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParitioner_JS"


    // $ANTLR start "ruleParitioner_JS"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:434:1: ruleParitioner_JS : ( ( rule__Paritioner_JS__Group__0 ) ) ;
    public final void ruleParitioner_JS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:438:2: ( ( ( rule__Paritioner_JS__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:439:1: ( ( rule__Paritioner_JS__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:439:1: ( ( rule__Paritioner_JS__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:440:1: ( rule__Paritioner_JS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:441:1: ( rule__Paritioner_JS__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:441:2: rule__Paritioner_JS__Group__0
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__0_in_ruleParitioner_JS879);
            rule__Paritioner_JS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioner_JSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParitioner_JS"


    // $ANTLR start "entryRulePartitioner_Rule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:453:1: entryRulePartitioner_Rule : rulePartitioner_Rule EOF ;
    public final void entryRulePartitioner_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:454:1: ( rulePartitioner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:455:1: rulePartitioner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule906);
            rulePartitioner_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner_Rule913); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePartitioner_Rule"


    // $ANTLR start "rulePartitioner_Rule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:462:1: rulePartitioner_Rule : ( ( rule__Partitioner_Rule__Group__0 ) ) ;
    public final void rulePartitioner_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:466:2: ( ( ( rule__Partitioner_Rule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:467:1: ( ( rule__Partitioner_Rule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:467:1: ( ( rule__Partitioner_Rule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:468:1: ( rule__Partitioner_Rule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:469:1: ( rule__Partitioner_Rule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:469:2: rule__Partitioner_Rule__Group__0
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__0_in_rulePartitioner_Rule939);
            rule__Partitioner_Rule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePartitioner_Rule"


    // $ANTLR start "entryRulePartition_Rule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:481:1: entryRulePartition_Rule : rulePartition_Rule EOF ;
    public final void entryRulePartition_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:482:1: ( rulePartition_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:483:1: rulePartition_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule966);
            rulePartition_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_Rule973); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePartition_Rule"


    // $ANTLR start "rulePartition_Rule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:490:1: rulePartition_Rule : ( ( rule__Partition_Rule__Alternatives ) ) ;
    public final void rulePartition_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:494:2: ( ( ( rule__Partition_Rule__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:495:1: ( ( rule__Partition_Rule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:495:1: ( ( rule__Partition_Rule__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:496:1: ( rule__Partition_Rule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_RuleAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:497:1: ( rule__Partition_Rule__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:497:2: rule__Partition_Rule__Alternatives
            {
            pushFollow(FOLLOW_rule__Partition_Rule__Alternatives_in_rulePartition_Rule999);
            rule__Partition_Rule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_RuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePartition_Rule"


    // $ANTLR start "entryRulePartition_SingleLineRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:509:1: entryRulePartition_SingleLineRule : rulePartition_SingleLineRule EOF ;
    public final void entryRulePartition_SingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:510:1: ( rulePartition_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:511:1: rulePartition_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule1026);
            rulePartition_SingleLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_SingleLineRule1033); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePartition_SingleLineRule"


    // $ANTLR start "rulePartition_SingleLineRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:518:1: rulePartition_SingleLineRule : ( ( rule__Partition_SingleLineRule__Group__0 ) ) ;
    public final void rulePartition_SingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:522:2: ( ( ( rule__Partition_SingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:523:1: ( ( rule__Partition_SingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:523:1: ( ( rule__Partition_SingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:524:1: ( rule__Partition_SingleLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:525:1: ( rule__Partition_SingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:525:2: rule__Partition_SingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__0_in_rulePartition_SingleLineRule1059);
            rule__Partition_SingleLineRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePartition_SingleLineRule"


    // $ANTLR start "entryRulePartition_MultiLineRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:537:1: entryRulePartition_MultiLineRule : rulePartition_MultiLineRule EOF ;
    public final void entryRulePartition_MultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:538:1: ( rulePartition_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:539:1: rulePartition_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule1086);
            rulePartition_MultiLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_MultiLineRule1093); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePartition_MultiLineRule"


    // $ANTLR start "rulePartition_MultiLineRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:546:1: rulePartition_MultiLineRule : ( ( rule__Partition_MultiLineRule__Group__0 ) ) ;
    public final void rulePartition_MultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:550:2: ( ( ( rule__Partition_MultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:551:1: ( ( rule__Partition_MultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:551:1: ( ( rule__Partition_MultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:552:1: ( rule__Partition_MultiLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:553:1: ( rule__Partition_MultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:553:2: rule__Partition_MultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__0_in_rulePartition_MultiLineRule1119);
            rule__Partition_MultiLineRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePartition_MultiLineRule"


    // $ANTLR start "entryRuleLexicalHighlighting"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:565:1: entryRuleLexicalHighlighting : ruleLexicalHighlighting EOF ;
    public final void entryRuleLexicalHighlighting() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:566:1: ( ruleLexicalHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:567:1: ruleLexicalHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting1146);
            ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalHighlighting1153); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLexicalHighlighting"


    // $ANTLR start "ruleLexicalHighlighting"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:574:1: ruleLexicalHighlighting : ( ( rule__LexicalHighlighting__Group__0 ) ) ;
    public final void ruleLexicalHighlighting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:578:2: ( ( ( rule__LexicalHighlighting__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:579:1: ( ( rule__LexicalHighlighting__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:579:1: ( ( rule__LexicalHighlighting__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:580:1: ( rule__LexicalHighlighting__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:581:1: ( rule__LexicalHighlighting__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:581:2: rule__LexicalHighlighting__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__0_in_ruleLexicalHighlighting1179);
            rule__LexicalHighlighting__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLexicalHighlighting"


    // $ANTLR start "entryRuleLexicalPartitionHighlighting"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:593:1: entryRuleLexicalPartitionHighlighting : ruleLexicalPartitionHighlighting EOF ;
    public final void entryRuleLexicalPartitionHighlighting() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:594:1: ( ruleLexicalPartitionHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:595:1: ruleLexicalPartitionHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting1206);
            ruleLexicalPartitionHighlighting();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting1213); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLexicalPartitionHighlighting"


    // $ANTLR start "ruleLexicalPartitionHighlighting"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:602:1: ruleLexicalPartitionHighlighting : ( ( rule__LexicalPartitionHighlighting__Alternatives ) ) ;
    public final void ruleLexicalPartitionHighlighting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:606:2: ( ( ( rule__LexicalPartitionHighlighting__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:607:1: ( ( rule__LexicalPartitionHighlighting__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:607:1: ( ( rule__LexicalPartitionHighlighting__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:608:1: ( rule__LexicalPartitionHighlighting__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlightingAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:609:1: ( rule__LexicalPartitionHighlighting__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:609:2: rule__LexicalPartitionHighlighting__Alternatives
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting__Alternatives_in_ruleLexicalPartitionHighlighting1239);
            rule__LexicalPartitionHighlighting__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlightingAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLexicalPartitionHighlighting"


    // $ANTLR start "entryRuleLexicalPartitionHighlighting_JS"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:621:1: entryRuleLexicalPartitionHighlighting_JS : ruleLexicalPartitionHighlighting_JS EOF ;
    public final void entryRuleLexicalPartitionHighlighting_JS() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:622:1: ( ruleLexicalPartitionHighlighting_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:623:1: ruleLexicalPartitionHighlighting_JS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS1266);
            ruleLexicalPartitionHighlighting_JS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS1273); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLexicalPartitionHighlighting_JS"


    // $ANTLR start "ruleLexicalPartitionHighlighting_JS"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:630:1: ruleLexicalPartitionHighlighting_JS : ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) ) ;
    public final void ruleLexicalPartitionHighlighting_JS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:634:2: ( ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:635:1: ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:635:1: ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:636:1: ( rule__LexicalPartitionHighlighting_JS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:637:1: ( rule__LexicalPartitionHighlighting_JS__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:637:2: rule__LexicalPartitionHighlighting_JS__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0_in_ruleLexicalPartitionHighlighting_JS1299);
            rule__LexicalPartitionHighlighting_JS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLexicalPartitionHighlighting_JS"


    // $ANTLR start "entryRuleLexicalPartitionHighlighting_Rule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:649:1: entryRuleLexicalPartitionHighlighting_Rule : ruleLexicalPartitionHighlighting_Rule EOF ;
    public final void entryRuleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:650:1: ( ruleLexicalPartitionHighlighting_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:651:1: ruleLexicalPartitionHighlighting_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule1326);
            ruleLexicalPartitionHighlighting_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule1333); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLexicalPartitionHighlighting_Rule"


    // $ANTLR start "ruleLexicalPartitionHighlighting_Rule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:658:1: ruleLexicalPartitionHighlighting_Rule : ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) ) ;
    public final void ruleLexicalPartitionHighlighting_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:662:2: ( ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:663:1: ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:663:1: ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:664:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:665:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:665:2: rule__LexicalPartitionHighlighting_Rule__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0_in_ruleLexicalPartitionHighlighting_Rule1359);
            rule__LexicalPartitionHighlighting_Rule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLexicalPartitionHighlighting_Rule"


    // $ANTLR start "entryRuleToken"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:677:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:678:1: ( ruleToken EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:679:1: ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_ruleToken_in_entryRuleToken1386);
            ruleToken();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleToken1393); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleToken"


    // $ANTLR start "ruleToken"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:686:1: ruleToken : ( ( rule__Token__Group__0 ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:690:2: ( ( ( rule__Token__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:691:1: ( ( rule__Token__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:691:1: ( ( rule__Token__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:692:1: ( rule__Token__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:693:1: ( rule__Token__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:693:2: rule__Token__Group__0
            {
            pushFollow(FOLLOW_rule__Token__Group__0_in_ruleToken1419);
            rule__Token__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleToken"


    // $ANTLR start "entryRuleScanner"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:705:1: entryRuleScanner : ruleScanner EOF ;
    public final void entryRuleScanner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:706:1: ( ruleScanner EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:707:1: ruleScanner EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScannerRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_in_entryRuleScanner1446);
            ruleScanner();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScannerRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner1453); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScanner"


    // $ANTLR start "ruleScanner"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:714:1: ruleScanner : ( ( rule__Scanner__Alternatives ) ) ;
    public final void ruleScanner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:718:2: ( ( ( rule__Scanner__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:719:1: ( ( rule__Scanner__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:719:1: ( ( rule__Scanner__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:720:1: ( rule__Scanner__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScannerAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:721:1: ( rule__Scanner__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:721:2: rule__Scanner__Alternatives
            {
            pushFollow(FOLLOW_rule__Scanner__Alternatives_in_ruleScanner1479);
            rule__Scanner__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScannerAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScanner"


    // $ANTLR start "entryRuleScanner_Keyword"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:733:1: entryRuleScanner_Keyword : ruleScanner_Keyword EOF ;
    public final void entryRuleScanner_Keyword() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:734:1: ( ruleScanner_Keyword EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:735:1: ruleScanner_Keyword EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword1506);
            ruleScanner_Keyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Keyword1513); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScanner_Keyword"


    // $ANTLR start "ruleScanner_Keyword"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:742:1: ruleScanner_Keyword : ( ( rule__Scanner_Keyword__Group__0 ) ) ;
    public final void ruleScanner_Keyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:746:2: ( ( ( rule__Scanner_Keyword__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:747:1: ( ( rule__Scanner_Keyword__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:747:1: ( ( rule__Scanner_Keyword__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:748:1: ( rule__Scanner_Keyword__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:749:1: ( rule__Scanner_Keyword__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:749:2: rule__Scanner_Keyword__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__0_in_ruleScanner_Keyword1539);
            rule__Scanner_Keyword__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScanner_Keyword"


    // $ANTLR start "entryRuleKeyword"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:761:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:762:1: ( ruleKeyword EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:763:1: ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword1566);
            ruleKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword1573); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:770:1: ruleKeyword : ( ( rule__Keyword__Group__0 ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:774:2: ( ( ( rule__Keyword__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:775:1: ( ( rule__Keyword__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:775:1: ( ( rule__Keyword__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:776:1: ( rule__Keyword__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:777:1: ( rule__Keyword__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:777:2: rule__Keyword__Group__0
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0_in_ruleKeyword1599);
            rule__Keyword__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleScanner_Rule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:789:1: entryRuleScanner_Rule : ruleScanner_Rule EOF ;
    public final void entryRuleScanner_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:790:1: ( ruleScanner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:791:1: ruleScanner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule1626);
            ruleScanner_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Rule1633); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScanner_Rule"


    // $ANTLR start "ruleScanner_Rule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:798:1: ruleScanner_Rule : ( ( rule__Scanner_Rule__Alternatives ) ) ;
    public final void ruleScanner_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:802:2: ( ( ( rule__Scanner_Rule__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:803:1: ( ( rule__Scanner_Rule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:803:1: ( ( rule__Scanner_Rule__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:804:1: ( rule__Scanner_Rule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_RuleAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:805:1: ( rule__Scanner_Rule__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:805:2: rule__Scanner_Rule__Alternatives
            {
            pushFollow(FOLLOW_rule__Scanner_Rule__Alternatives_in_ruleScanner_Rule1659);
            rule__Scanner_Rule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_RuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScanner_Rule"


    // $ANTLR start "entryRuleScanner_SingleLineRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:817:1: entryRuleScanner_SingleLineRule : ruleScanner_SingleLineRule EOF ;
    public final void entryRuleScanner_SingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:818:1: ( ruleScanner_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:819:1: ruleScanner_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule1686);
            ruleScanner_SingleLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_SingleLineRule1693); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScanner_SingleLineRule"


    // $ANTLR start "ruleScanner_SingleLineRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:826:1: ruleScanner_SingleLineRule : ( ( rule__Scanner_SingleLineRule__Group__0 ) ) ;
    public final void ruleScanner_SingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:830:2: ( ( ( rule__Scanner_SingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:831:1: ( ( rule__Scanner_SingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:831:1: ( ( rule__Scanner_SingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:832:1: ( rule__Scanner_SingleLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:833:1: ( rule__Scanner_SingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:833:2: rule__Scanner_SingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__0_in_ruleScanner_SingleLineRule1719);
            rule__Scanner_SingleLineRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScanner_SingleLineRule"


    // $ANTLR start "entryRuleScanner_MultiLineRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:845:1: entryRuleScanner_MultiLineRule : ruleScanner_MultiLineRule EOF ;
    public final void entryRuleScanner_MultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:846:1: ( ruleScanner_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:847:1: ruleScanner_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule1746);
            ruleScanner_MultiLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_MultiLineRule1753); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScanner_MultiLineRule"


    // $ANTLR start "ruleScanner_MultiLineRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:854:1: ruleScanner_MultiLineRule : ( ( rule__Scanner_MultiLineRule__Group__0 ) ) ;
    public final void ruleScanner_MultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:858:2: ( ( ( rule__Scanner_MultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:859:1: ( ( rule__Scanner_MultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:859:1: ( ( rule__Scanner_MultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:860:1: ( rule__Scanner_MultiLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:861:1: ( rule__Scanner_MultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:861:2: rule__Scanner_MultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__0_in_ruleScanner_MultiLineRule1779);
            rule__Scanner_MultiLineRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScanner_MultiLineRule"


    // $ANTLR start "entryRuleScanner_CharacterRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:873:1: entryRuleScanner_CharacterRule : ruleScanner_CharacterRule EOF ;
    public final void entryRuleScanner_CharacterRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:874:1: ( ruleScanner_CharacterRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:875:1: ruleScanner_CharacterRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule1806);
            ruleScanner_CharacterRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_CharacterRule1813); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScanner_CharacterRule"


    // $ANTLR start "ruleScanner_CharacterRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:882:1: ruleScanner_CharacterRule : ( ( rule__Scanner_CharacterRule__Group__0 ) ) ;
    public final void ruleScanner_CharacterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:886:2: ( ( ( rule__Scanner_CharacterRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:887:1: ( ( rule__Scanner_CharacterRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:887:1: ( ( rule__Scanner_CharacterRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:888:1: ( rule__Scanner_CharacterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:889:1: ( rule__Scanner_CharacterRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:889:2: rule__Scanner_CharacterRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__0_in_ruleScanner_CharacterRule1839);
            rule__Scanner_CharacterRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScanner_CharacterRule"


    // $ANTLR start "entryRuleScanner_JSRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:901:1: entryRuleScanner_JSRule : ruleScanner_JSRule EOF ;
    public final void entryRuleScanner_JSRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:902:1: ( ruleScanner_JSRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:903:1: ruleScanner_JSRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule1866);
            ruleScanner_JSRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_JSRule1873); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScanner_JSRule"


    // $ANTLR start "ruleScanner_JSRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:910:1: ruleScanner_JSRule : ( ( rule__Scanner_JSRule__Group__0 ) ) ;
    public final void ruleScanner_JSRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:914:2: ( ( ( rule__Scanner_JSRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:915:1: ( ( rule__Scanner_JSRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:915:1: ( ( rule__Scanner_JSRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:916:1: ( rule__Scanner_JSRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:917:1: ( rule__Scanner_JSRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:917:2: rule__Scanner_JSRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__0_in_ruleScanner_JSRule1899);
            rule__Scanner_JSRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScanner_JSRule"


    // $ANTLR start "entryRuleWhitespaceRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:929:1: entryRuleWhitespaceRule : ruleWhitespaceRule EOF ;
    public final void entryRuleWhitespaceRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:930:1: ( ruleWhitespaceRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:931:1: ruleWhitespaceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleRule()); 
            }
            pushFollow(FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule1926);
            ruleWhitespaceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhitespaceRule1933); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWhitespaceRule"


    // $ANTLR start "ruleWhitespaceRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:938:1: ruleWhitespaceRule : ( ( rule__WhitespaceRule__Group__0 ) ) ;
    public final void ruleWhitespaceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:942:2: ( ( ( rule__WhitespaceRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:943:1: ( ( rule__WhitespaceRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:943:1: ( ( rule__WhitespaceRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:944:1: ( rule__WhitespaceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:945:1: ( rule__WhitespaceRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:945:2: rule__WhitespaceRule__Group__0
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__0_in_ruleWhitespaceRule1959);
            rule__WhitespaceRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWhitespaceRule"


    // $ANTLR start "rule__CodeIntegration__Alternatives"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:957:1: rule__CodeIntegration__Alternatives : ( ( ruleJavaFXIntegration ) | ( ruleSWTIntegration ) );
    public final void rule__CodeIntegration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:961:1: ( ( ruleJavaFXIntegration ) | ( ruleSWTIntegration ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==18) ) {
                alt1=1;
            }
            else if ( (LA1_0==19) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:962:1: ( ruleJavaFXIntegration )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:962:1: ( ruleJavaFXIntegration )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:963:1: ruleJavaFXIntegration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCodeIntegrationAccess().getJavaFXIntegrationParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleJavaFXIntegration_in_rule__CodeIntegration__Alternatives1995);
                    ruleJavaFXIntegration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCodeIntegrationAccess().getJavaFXIntegrationParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:968:6: ( ruleSWTIntegration )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:968:6: ( ruleSWTIntegration )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:969:1: ruleSWTIntegration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCodeIntegrationAccess().getSWTIntegrationParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleSWTIntegration_in_rule__CodeIntegration__Alternatives2012);
                    ruleSWTIntegration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCodeIntegrationAccess().getSWTIntegrationParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeIntegration__Alternatives"


    // $ANTLR start "rule__Partitioner__Alternatives"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:979:1: rule__Partitioner__Alternatives : ( ( rulePartitioner_Rule ) | ( ruleParitioner_JS ) );
    public final void rule__Partitioner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:983:1: ( ( rulePartitioner_Rule ) | ( ruleParitioner_JS ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==23) ) {
                alt2=1;
            }
            else if ( (LA2_0==22) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:984:1: ( rulePartitioner_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:984:1: ( rulePartitioner_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:985:1: rulePartitioner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePartitioner_Rule_in_rule__Partitioner__Alternatives2044);
                    rulePartitioner_Rule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:990:6: ( ruleParitioner_JS )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:990:6: ( ruleParitioner_JS )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:991:1: ruleParitioner_JS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleParitioner_JS_in_rule__Partitioner__Alternatives2061);
                    ruleParitioner_JS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partitioner__Alternatives"


    // $ANTLR start "rule__Partition_Rule__Alternatives"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1001:1: rule__Partition_Rule__Alternatives : ( ( rulePartition_SingleLineRule ) | ( rulePartition_MultiLineRule ) );
    public final void rule__Partition_Rule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1005:1: ( ( rulePartition_SingleLineRule ) | ( rulePartition_MultiLineRule ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==24) ) {
                alt3=1;
            }
            else if ( (LA3_0==28) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1006:1: ( rulePartition_SingleLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1006:1: ( rulePartition_SingleLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1007:1: rulePartition_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePartition_SingleLineRule_in_rule__Partition_Rule__Alternatives2093);
                    rulePartition_SingleLineRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1012:6: ( rulePartition_MultiLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1012:6: ( rulePartition_MultiLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1013:1: rulePartition_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_rulePartition_MultiLineRule_in_rule__Partition_Rule__Alternatives2110);
                    rulePartition_MultiLineRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_Rule__Alternatives"


    // $ANTLR start "rule__LexicalPartitionHighlighting__Alternatives"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1023:1: rule__LexicalPartitionHighlighting__Alternatives : ( ( ruleLexicalPartitionHighlighting_Rule ) | ( ruleLexicalPartitionHighlighting_JS ) );
    public final void rule__LexicalPartitionHighlighting__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1027:1: ( ( ruleLexicalPartitionHighlighting_Rule ) | ( ruleLexicalPartitionHighlighting_JS ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            else if ( (LA4_0==22) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1028:1: ( ruleLexicalPartitionHighlighting_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1028:1: ( ruleLexicalPartitionHighlighting_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1029:1: ruleLexicalPartitionHighlighting_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_rule__LexicalPartitionHighlighting__Alternatives2142);
                    ruleLexicalPartitionHighlighting_Rule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1034:6: ( ruleLexicalPartitionHighlighting_JS )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1034:6: ( ruleLexicalPartitionHighlighting_JS )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1035:1: ruleLexicalPartitionHighlighting_JS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_rule__LexicalPartitionHighlighting__Alternatives2159);
                    ruleLexicalPartitionHighlighting_JS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting__Alternatives"


    // $ANTLR start "rule__Scanner__Alternatives"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1045:1: rule__Scanner__Alternatives : ( ( ruleScanner_Keyword ) | ( ruleScanner_Rule ) );
    public final void rule__Scanner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1049:1: ( ( ruleScanner_Keyword ) | ( ruleScanner_Rule ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==30) ) {
                alt5=1;
            }
            else if ( (LA5_0==22||LA5_0==24||LA5_0==28||LA5_0==35) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1050:1: ( ruleScanner_Keyword )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1050:1: ( ruleScanner_Keyword )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1051:1: ruleScanner_Keyword
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_Keyword_in_rule__Scanner__Alternatives2191);
                    ruleScanner_Keyword();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1056:6: ( ruleScanner_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1056:6: ( ruleScanner_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1057:1: ruleScanner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_Rule_in_rule__Scanner__Alternatives2208);
                    ruleScanner_Rule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Alternatives"


    // $ANTLR start "rule__Scanner_Rule__Alternatives"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1067:1: rule__Scanner_Rule__Alternatives : ( ( ruleScanner_SingleLineRule ) | ( ruleScanner_MultiLineRule ) | ( ruleScanner_CharacterRule ) | ( ruleScanner_JSRule ) );
    public final void rule__Scanner_Rule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1071:1: ( ( ruleScanner_SingleLineRule ) | ( ruleScanner_MultiLineRule ) | ( ruleScanner_CharacterRule ) | ( ruleScanner_JSRule ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt6=1;
                }
                break;
            case 28:
                {
                alt6=2;
                }
                break;
            case 35:
                {
                alt6=3;
                }
                break;
            case 22:
                {
                alt6=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1072:1: ( ruleScanner_SingleLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1072:1: ( ruleScanner_SingleLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1073:1: ruleScanner_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_rule__Scanner_Rule__Alternatives2240);
                    ruleScanner_SingleLineRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1078:6: ( ruleScanner_MultiLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1078:6: ( ruleScanner_MultiLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1079:1: ruleScanner_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_rule__Scanner_Rule__Alternatives2257);
                    ruleScanner_MultiLineRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1084:6: ( ruleScanner_CharacterRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1084:6: ( ruleScanner_CharacterRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1085:1: ruleScanner_CharacterRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_CharacterRule_in_rule__Scanner_Rule__Alternatives2274);
                    ruleScanner_CharacterRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1090:6: ( ruleScanner_JSRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1090:6: ( ruleScanner_JSRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1091:1: ruleScanner_JSRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_JSRule_in_rule__Scanner_Rule__Alternatives2291);
                    ruleScanner_JSRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Rule__Alternatives"


    // $ANTLR start "rule__WhitespaceRule__Alternatives_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1101:1: rule__WhitespaceRule__Alternatives_1 : ( ( ( rule__WhitespaceRule__Group_1_0__0 ) ) | ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) ) | ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) ) );
    public final void rule__WhitespaceRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1105:1: ( ( ( rule__WhitespaceRule__Group_1_0__0 ) ) | ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) ) | ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt7=1;
                }
                break;
            case 40:
                {
                alt7=2;
                }
                break;
            case RULE_STRING:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1106:1: ( ( rule__WhitespaceRule__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1106:1: ( ( rule__WhitespaceRule__Group_1_0__0 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1107:1: ( rule__WhitespaceRule__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1108:1: ( rule__WhitespaceRule__Group_1_0__0 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1108:2: rule__WhitespaceRule__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__0_in_rule__WhitespaceRule__Alternatives_12323);
                    rule__WhitespaceRule__Group_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getWhitespaceRuleAccess().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1112:6: ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1112:6: ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1113:1: ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceAssignment_1_1()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1114:1: ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1114:2: rule__WhitespaceRule__JavawhitespaceAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__WhitespaceRule__JavawhitespaceAssignment_1_1_in_rule__WhitespaceRule__Alternatives_12341);
                    rule__WhitespaceRule__JavawhitespaceAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceAssignment_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1118:6: ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1118:6: ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1119:1: ( rule__WhitespaceRule__FileURIAssignment_1_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getFileURIAssignment_1_2()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1120:1: ( rule__WhitespaceRule__FileURIAssignment_1_2 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1120:2: rule__WhitespaceRule__FileURIAssignment_1_2
                    {
                    pushFollow(FOLLOW_rule__WhitespaceRule__FileURIAssignment_1_2_in_rule__WhitespaceRule__Alternatives_12359);
                    rule__WhitespaceRule__FileURIAssignment_1_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getWhitespaceRuleAccess().getFileURIAssignment_1_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Alternatives_1"


    // $ANTLR start "rule__Root__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1131:1: rule__Root__Group__0 : rule__Root__Group__0__Impl rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1135:1: ( rule__Root__Group__0__Impl rule__Root__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1136:2: rule__Root__Group__0__Impl rule__Root__Group__1
            {
            pushFollow(FOLLOW_rule__Root__Group__0__Impl_in_rule__Root__Group__02390);
            rule__Root__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Root__Group__1_in_rule__Root__Group__02393);
            rule__Root__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__0"


    // $ANTLR start "rule__Root__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1143:1: rule__Root__Group__0__Impl : ( 'package' ) ;
    public final void rule__Root__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1147:1: ( ( 'package' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1148:1: ( 'package' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1148:1: ( 'package' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1149:1: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getPackageKeyword_0()); 
            }
            match(input,11,FOLLOW_11_in_rule__Root__Group__0__Impl2421); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootAccess().getPackageKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__0__Impl"


    // $ANTLR start "rule__Root__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1162:1: rule__Root__Group__1 : rule__Root__Group__1__Impl rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1166:1: ( rule__Root__Group__1__Impl rule__Root__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1167:2: rule__Root__Group__1__Impl rule__Root__Group__2
            {
            pushFollow(FOLLOW_rule__Root__Group__1__Impl_in_rule__Root__Group__12452);
            rule__Root__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Root__Group__2_in_rule__Root__Group__12455);
            rule__Root__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__1"


    // $ANTLR start "rule__Root__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1174:1: rule__Root__Group__1__Impl : ( ( rule__Root__NameAssignment_1 ) ) ;
    public final void rule__Root__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1178:1: ( ( ( rule__Root__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1179:1: ( ( rule__Root__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1179:1: ( ( rule__Root__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1180:1: ( rule__Root__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1181:1: ( rule__Root__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1181:2: rule__Root__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Root__NameAssignment_1_in_rule__Root__Group__1__Impl2482);
            rule__Root__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__1__Impl"


    // $ANTLR start "rule__Root__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1191:1: rule__Root__Group__2 : rule__Root__Group__2__Impl rule__Root__Group__3 ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1195:1: ( rule__Root__Group__2__Impl rule__Root__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1196:2: rule__Root__Group__2__Impl rule__Root__Group__3
            {
            pushFollow(FOLLOW_rule__Root__Group__2__Impl_in_rule__Root__Group__22512);
            rule__Root__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Root__Group__3_in_rule__Root__Group__22515);
            rule__Root__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__2"


    // $ANTLR start "rule__Root__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1203:1: rule__Root__Group__2__Impl : ( ( rule__Root__ImportsAssignment_2 )* ) ;
    public final void rule__Root__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1207:1: ( ( ( rule__Root__ImportsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1208:1: ( ( rule__Root__ImportsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1208:1: ( ( rule__Root__ImportsAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1209:1: ( rule__Root__ImportsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getImportsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1210:1: ( rule__Root__ImportsAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==14) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1210:2: rule__Root__ImportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Root__ImportsAssignment_2_in_rule__Root__Group__2__Impl2542);
            	    rule__Root__ImportsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootAccess().getImportsAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__2__Impl"


    // $ANTLR start "rule__Root__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1220:1: rule__Root__Group__3 : rule__Root__Group__3__Impl ;
    public final void rule__Root__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1224:1: ( rule__Root__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1225:2: rule__Root__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Root__Group__3__Impl_in_rule__Root__Group__32573);
            rule__Root__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__3"


    // $ANTLR start "rule__Root__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1231:1: rule__Root__Group__3__Impl : ( ( rule__Root__LanguageDefinitionAssignment_3 ) ) ;
    public final void rule__Root__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1235:1: ( ( ( rule__Root__LanguageDefinitionAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1236:1: ( ( rule__Root__LanguageDefinitionAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1236:1: ( ( rule__Root__LanguageDefinitionAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1237:1: ( rule__Root__LanguageDefinitionAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLanguageDefinitionAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1238:1: ( rule__Root__LanguageDefinitionAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1238:2: rule__Root__LanguageDefinitionAssignment_3
            {
            pushFollow(FOLLOW_rule__Root__LanguageDefinitionAssignment_3_in_rule__Root__Group__3__Impl2600);
            rule__Root__LanguageDefinitionAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootAccess().getLanguageDefinitionAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__3__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1256:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1260:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1261:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02638);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02641);
            rule__QualifiedName__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1268:1: rule__QualifiedName__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1272:1: ( ( ruleValidID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1273:1: ( ruleValidID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1273:1: ( ruleValidID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1274:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl2668);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1285:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1289:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1290:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12697);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1296:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1300:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1301:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1301:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1302:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1303:1: ( rule__QualifiedName__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==12) ) {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2==RULE_ID) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1303:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2724);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1317:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1321:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1322:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02759);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02762);
            rule__QualifiedName__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1329:1: rule__QualifiedName__Group_1__0__Impl : ( ( '.' ) ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1333:1: ( ( ( '.' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1334:1: ( ( '.' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1334:1: ( ( '.' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1335:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1336:1: ( '.' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1337:2: '.'
            {
            match(input,12,FOLLOW_12_in_rule__QualifiedName__Group_1__0__Impl2791); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1348:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1352:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1353:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12823);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1359:1: rule__QualifiedName__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1363:1: ( ( ruleValidID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1364:1: ( ruleValidID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1364:1: ( ruleValidID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1365:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl2850);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1380:1: rule__QualifiedNameWithWildCard__Group__0 : rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 ;
    public final void rule__QualifiedNameWithWildCard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1384:1: ( rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1385:2: rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__0__Impl_in_rule__QualifiedNameWithWildCard__Group__02883);
            rule__QualifiedNameWithWildCard__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__02886);
            rule__QualifiedNameWithWildCard__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__0"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1392:1: rule__QualifiedNameWithWildCard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildCard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1396:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1397:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1397:1: ( ruleQualifiedName )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1398:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__0__Impl2913);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1409:1: rule__QualifiedNameWithWildCard__Group__1 : rule__QualifiedNameWithWildCard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1413:1: ( rule__QualifiedNameWithWildCard__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1414:2: rule__QualifiedNameWithWildCard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__1__Impl_in_rule__QualifiedNameWithWildCard__Group__12942);
            rule__QualifiedNameWithWildCard__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__1"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1420:1: rule__QualifiedNameWithWildCard__Group__1__Impl : ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? ) ;
    public final void rule__QualifiedNameWithWildCard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1424:1: ( ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1425:1: ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1425:1: ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1426:1: ( rule__QualifiedNameWithWildCard__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1427:1: ( rule__QualifiedNameWithWildCard__Group_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==12) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1427:2: rule__QualifiedNameWithWildCard__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0_in_rule__QualifiedNameWithWildCard__Group__1__Impl2969);
                    rule__QualifiedNameWithWildCard__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group_1__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1441:1: rule__QualifiedNameWithWildCard__Group_1__0 : rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1 ;
    public final void rule__QualifiedNameWithWildCard__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1445:1: ( rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1446:2: rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0__Impl_in_rule__QualifiedNameWithWildCard__Group_1__03004);
            rule__QualifiedNameWithWildCard__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1_in_rule__QualifiedNameWithWildCard__Group_1__03007);
            rule__QualifiedNameWithWildCard__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group_1__0"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group_1__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1453:1: rule__QualifiedNameWithWildCard__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedNameWithWildCard__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1457:1: ( ( '.' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1458:1: ( '.' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1458:1: ( '.' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1459:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
            }
            match(input,12,FOLLOW_12_in_rule__QualifiedNameWithWildCard__Group_1__0__Impl3035); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group_1__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1472:1: rule__QualifiedNameWithWildCard__Group_1__1 : rule__QualifiedNameWithWildCard__Group_1__1__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1476:1: ( rule__QualifiedNameWithWildCard__Group_1__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1477:2: rule__QualifiedNameWithWildCard__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1__Impl_in_rule__QualifiedNameWithWildCard__Group_1__13066);
            rule__QualifiedNameWithWildCard__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group_1__1"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group_1__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1483:1: rule__QualifiedNameWithWildCard__Group_1__1__Impl : ( '*' ) ;
    public final void rule__QualifiedNameWithWildCard__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1487:1: ( ( '*' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1488:1: ( '*' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1488:1: ( '*' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1489:1: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1()); 
            }
            match(input,13,FOLLOW_13_in_rule__QualifiedNameWithWildCard__Group_1__1__Impl3094); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group_1__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1506:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1510:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1511:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03129);
            rule__Import__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03132);
            rule__Import__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1518:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1522:1: ( ( 'import' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1523:1: ( 'import' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1523:1: ( 'import' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1524:1: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }
            match(input,14,FOLLOW_14_in_rule__Import__Group__0__Impl3160); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1537:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1541:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1542:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13191);
            rule__Import__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1548:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1552:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1553:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1553:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1554:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1555:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1555:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3218);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__LanguageDef__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1569:1: rule__LanguageDef__Group__0 : rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1 ;
    public final void rule__LanguageDef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1573:1: ( rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1574:2: rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__0__Impl_in_rule__LanguageDef__Group__03252);
            rule__LanguageDef__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__1_in_rule__LanguageDef__Group__03255);
            rule__LanguageDef__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__0"


    // $ANTLR start "rule__LanguageDef__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1581:1: rule__LanguageDef__Group__0__Impl : ( ( rule__LanguageDef__NameAssignment_0 ) ) ;
    public final void rule__LanguageDef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1585:1: ( ( ( rule__LanguageDef__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1586:1: ( ( rule__LanguageDef__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1586:1: ( ( rule__LanguageDef__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1587:1: ( rule__LanguageDef__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1588:1: ( rule__LanguageDef__NameAssignment_0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1588:2: rule__LanguageDef__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__LanguageDef__NameAssignment_0_in_rule__LanguageDef__Group__0__Impl3282);
            rule__LanguageDef__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getNameAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__0__Impl"


    // $ANTLR start "rule__LanguageDef__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1598:1: rule__LanguageDef__Group__1 : rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2 ;
    public final void rule__LanguageDef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1602:1: ( rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1603:2: rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__1__Impl_in_rule__LanguageDef__Group__13312);
            rule__LanguageDef__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__2_in_rule__LanguageDef__Group__13315);
            rule__LanguageDef__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__1"


    // $ANTLR start "rule__LanguageDef__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1610:1: rule__LanguageDef__Group__1__Impl : ( '{' ) ;
    public final void rule__LanguageDef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1614:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1615:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1615:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1616:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__LanguageDef__Group__1__Impl3343); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__1__Impl"


    // $ANTLR start "rule__LanguageDef__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1629:1: rule__LanguageDef__Group__2 : rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3 ;
    public final void rule__LanguageDef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1633:1: ( rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1634:2: rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__2__Impl_in_rule__LanguageDef__Group__23374);
            rule__LanguageDef__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__3_in_rule__LanguageDef__Group__23377);
            rule__LanguageDef__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__2"


    // $ANTLR start "rule__LanguageDef__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1641:1: rule__LanguageDef__Group__2__Impl : ( ( rule__LanguageDef__ParitioningAssignment_2 ) ) ;
    public final void rule__LanguageDef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1645:1: ( ( ( rule__LanguageDef__ParitioningAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1646:1: ( ( rule__LanguageDef__ParitioningAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1646:1: ( ( rule__LanguageDef__ParitioningAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1647:1: ( rule__LanguageDef__ParitioningAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getParitioningAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1648:1: ( rule__LanguageDef__ParitioningAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1648:2: rule__LanguageDef__ParitioningAssignment_2
            {
            pushFollow(FOLLOW_rule__LanguageDef__ParitioningAssignment_2_in_rule__LanguageDef__Group__2__Impl3404);
            rule__LanguageDef__ParitioningAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getParitioningAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__2__Impl"


    // $ANTLR start "rule__LanguageDef__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1658:1: rule__LanguageDef__Group__3 : rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4 ;
    public final void rule__LanguageDef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1662:1: ( rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1663:2: rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__3__Impl_in_rule__LanguageDef__Group__33434);
            rule__LanguageDef__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__4_in_rule__LanguageDef__Group__33437);
            rule__LanguageDef__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__3"


    // $ANTLR start "rule__LanguageDef__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1670:1: rule__LanguageDef__Group__3__Impl : ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) ) ;
    public final void rule__LanguageDef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1674:1: ( ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1675:1: ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1675:1: ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1676:1: ( rule__LanguageDef__LexicalHighlightingAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLexicalHighlightingAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1677:1: ( rule__LanguageDef__LexicalHighlightingAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1677:2: rule__LanguageDef__LexicalHighlightingAssignment_3
            {
            pushFollow(FOLLOW_rule__LanguageDef__LexicalHighlightingAssignment_3_in_rule__LanguageDef__Group__3__Impl3464);
            rule__LanguageDef__LexicalHighlightingAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getLexicalHighlightingAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__3__Impl"


    // $ANTLR start "rule__LanguageDef__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1687:1: rule__LanguageDef__Group__4 : rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5 ;
    public final void rule__LanguageDef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1691:1: ( rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1692:2: rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__4__Impl_in_rule__LanguageDef__Group__43494);
            rule__LanguageDef__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__5_in_rule__LanguageDef__Group__43497);
            rule__LanguageDef__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__4"


    // $ANTLR start "rule__LanguageDef__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1699:1: rule__LanguageDef__Group__4__Impl : ( ( rule__LanguageDef__IntegrationAssignment_4 )? ) ;
    public final void rule__LanguageDef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1703:1: ( ( ( rule__LanguageDef__IntegrationAssignment_4 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1704:1: ( ( rule__LanguageDef__IntegrationAssignment_4 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1704:1: ( ( rule__LanguageDef__IntegrationAssignment_4 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1705:1: ( rule__LanguageDef__IntegrationAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getIntegrationAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1706:1: ( rule__LanguageDef__IntegrationAssignment_4 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1706:2: rule__LanguageDef__IntegrationAssignment_4
                    {
                    pushFollow(FOLLOW_rule__LanguageDef__IntegrationAssignment_4_in_rule__LanguageDef__Group__4__Impl3524);
                    rule__LanguageDef__IntegrationAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getIntegrationAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__4__Impl"


    // $ANTLR start "rule__LanguageDef__Group__5"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1716:1: rule__LanguageDef__Group__5 : rule__LanguageDef__Group__5__Impl ;
    public final void rule__LanguageDef__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1720:1: ( rule__LanguageDef__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1721:2: rule__LanguageDef__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__5__Impl_in_rule__LanguageDef__Group__53555);
            rule__LanguageDef__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__5"


    // $ANTLR start "rule__LanguageDef__Group__5__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1727:1: rule__LanguageDef__Group__5__Impl : ( '}' ) ;
    public final void rule__LanguageDef__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1731:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1732:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1732:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1733:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,16,FOLLOW_16_in_rule__LanguageDef__Group__5__Impl3583); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getRightCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__Group__5__Impl"


    // $ANTLR start "rule__Integration__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1758:1: rule__Integration__Group__0 : rule__Integration__Group__0__Impl rule__Integration__Group__1 ;
    public final void rule__Integration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1762:1: ( rule__Integration__Group__0__Impl rule__Integration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1763:2: rule__Integration__Group__0__Impl rule__Integration__Group__1
            {
            pushFollow(FOLLOW_rule__Integration__Group__0__Impl_in_rule__Integration__Group__03626);
            rule__Integration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Integration__Group__1_in_rule__Integration__Group__03629);
            rule__Integration__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integration__Group__0"


    // $ANTLR start "rule__Integration__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1770:1: rule__Integration__Group__0__Impl : ( 'integration' ) ;
    public final void rule__Integration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1774:1: ( ( 'integration' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1775:1: ( 'integration' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1775:1: ( 'integration' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1776:1: 'integration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getIntegrationKeyword_0()); 
            }
            match(input,17,FOLLOW_17_in_rule__Integration__Group__0__Impl3657); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationAccess().getIntegrationKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integration__Group__0__Impl"


    // $ANTLR start "rule__Integration__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1789:1: rule__Integration__Group__1 : rule__Integration__Group__1__Impl rule__Integration__Group__2 ;
    public final void rule__Integration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1793:1: ( rule__Integration__Group__1__Impl rule__Integration__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1794:2: rule__Integration__Group__1__Impl rule__Integration__Group__2
            {
            pushFollow(FOLLOW_rule__Integration__Group__1__Impl_in_rule__Integration__Group__13688);
            rule__Integration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Integration__Group__2_in_rule__Integration__Group__13691);
            rule__Integration__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integration__Group__1"


    // $ANTLR start "rule__Integration__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1801:1: rule__Integration__Group__1__Impl : ( '{' ) ;
    public final void rule__Integration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1805:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1806:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1806:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1807:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__Integration__Group__1__Impl3719); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integration__Group__1__Impl"


    // $ANTLR start "rule__Integration__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1820:1: rule__Integration__Group__2 : rule__Integration__Group__2__Impl rule__Integration__Group__3 ;
    public final void rule__Integration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1824:1: ( rule__Integration__Group__2__Impl rule__Integration__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1825:2: rule__Integration__Group__2__Impl rule__Integration__Group__3
            {
            pushFollow(FOLLOW_rule__Integration__Group__2__Impl_in_rule__Integration__Group__23750);
            rule__Integration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Integration__Group__3_in_rule__Integration__Group__23753);
            rule__Integration__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integration__Group__2"


    // $ANTLR start "rule__Integration__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1832:1: rule__Integration__Group__2__Impl : ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) ) ;
    public final void rule__Integration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1836:1: ( ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1837:1: ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1837:1: ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1838:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1838:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1839:1: ( rule__Integration__CodeIntegrationListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1840:1: ( rule__Integration__CodeIntegrationListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1840:2: rule__Integration__CodeIntegrationListAssignment_2
            {
            pushFollow(FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl3782);
            rule__Integration__CodeIntegrationListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1843:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1844:1: ( rule__Integration__CodeIntegrationListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1845:1: ( rule__Integration__CodeIntegrationListAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=18 && LA12_0<=19)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1845:2: rule__Integration__CodeIntegrationListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl3794);
            	    rule__Integration__CodeIntegrationListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integration__Group__2__Impl"


    // $ANTLR start "rule__Integration__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1856:1: rule__Integration__Group__3 : rule__Integration__Group__3__Impl ;
    public final void rule__Integration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1860:1: ( rule__Integration__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1861:2: rule__Integration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Integration__Group__3__Impl_in_rule__Integration__Group__33827);
            rule__Integration__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integration__Group__3"


    // $ANTLR start "rule__Integration__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1867:1: rule__Integration__Group__3__Impl : ( '}' ) ;
    public final void rule__Integration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1871:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1872:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1872:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1873:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__Integration__Group__3__Impl3855); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationAccess().getRightCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integration__Group__3__Impl"


    // $ANTLR start "rule__JavaFXIntegration__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1894:1: rule__JavaFXIntegration__Group__0 : rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1 ;
    public final void rule__JavaFXIntegration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1898:1: ( rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1899:2: rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__0__Impl_in_rule__JavaFXIntegration__Group__03894);
            rule__JavaFXIntegration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__1_in_rule__JavaFXIntegration__Group__03897);
            rule__JavaFXIntegration__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__0"


    // $ANTLR start "rule__JavaFXIntegration__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1906:1: rule__JavaFXIntegration__Group__0__Impl : ( 'javafx' ) ;
    public final void rule__JavaFXIntegration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1910:1: ( ( 'javafx' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1911:1: ( 'javafx' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1911:1: ( 'javafx' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1912:1: 'javafx'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getJavafxKeyword_0()); 
            }
            match(input,18,FOLLOW_18_in_rule__JavaFXIntegration__Group__0__Impl3925); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getJavafxKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__0__Impl"


    // $ANTLR start "rule__JavaFXIntegration__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1925:1: rule__JavaFXIntegration__Group__1 : rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2 ;
    public final void rule__JavaFXIntegration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1929:1: ( rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1930:2: rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__1__Impl_in_rule__JavaFXIntegration__Group__13956);
            rule__JavaFXIntegration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__2_in_rule__JavaFXIntegration__Group__13959);
            rule__JavaFXIntegration__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__1"


    // $ANTLR start "rule__JavaFXIntegration__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1937:1: rule__JavaFXIntegration__Group__1__Impl : ( '{' ) ;
    public final void rule__JavaFXIntegration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1941:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1942:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1942:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1943:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__JavaFXIntegration__Group__1__Impl3987); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__1__Impl"


    // $ANTLR start "rule__JavaFXIntegration__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1956:1: rule__JavaFXIntegration__Group__2 : rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3 ;
    public final void rule__JavaFXIntegration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1960:1: ( rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1961:2: rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__2__Impl_in_rule__JavaFXIntegration__Group__24018);
            rule__JavaFXIntegration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__3_in_rule__JavaFXIntegration__Group__24021);
            rule__JavaFXIntegration__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__2"


    // $ANTLR start "rule__JavaFXIntegration__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1968:1: rule__JavaFXIntegration__Group__2__Impl : ( () ) ;
    public final void rule__JavaFXIntegration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1972:1: ( ( () ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1973:1: ( () )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1973:1: ( () )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1974:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getJavaFXIntegrationAction_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1975:1: ()
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1977:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getJavaFXIntegrationAction_2()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__2__Impl"


    // $ANTLR start "rule__JavaFXIntegration__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1987:1: rule__JavaFXIntegration__Group__3 : rule__JavaFXIntegration__Group__3__Impl rule__JavaFXIntegration__Group__4 ;
    public final void rule__JavaFXIntegration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1991:1: ( rule__JavaFXIntegration__Group__3__Impl rule__JavaFXIntegration__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1992:2: rule__JavaFXIntegration__Group__3__Impl rule__JavaFXIntegration__Group__4
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__3__Impl_in_rule__JavaFXIntegration__Group__34079);
            rule__JavaFXIntegration__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__4_in_rule__JavaFXIntegration__Group__34082);
            rule__JavaFXIntegration__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__3"


    // $ANTLR start "rule__JavaFXIntegration__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1999:1: rule__JavaFXIntegration__Group__3__Impl : ( ( rule__JavaFXIntegration__CodegenAssignment_3 )? ) ;
    public final void rule__JavaFXIntegration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2003:1: ( ( ( rule__JavaFXIntegration__CodegenAssignment_3 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2004:1: ( ( rule__JavaFXIntegration__CodegenAssignment_3 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2004:1: ( ( rule__JavaFXIntegration__CodegenAssignment_3 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2005:1: ( rule__JavaFXIntegration__CodegenAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2006:1: ( rule__JavaFXIntegration__CodegenAssignment_3 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==37) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2006:2: rule__JavaFXIntegration__CodegenAssignment_3
                    {
                    pushFollow(FOLLOW_rule__JavaFXIntegration__CodegenAssignment_3_in_rule__JavaFXIntegration__Group__3__Impl4109);
                    rule__JavaFXIntegration__CodegenAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getCodegenAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__3__Impl"


    // $ANTLR start "rule__JavaFXIntegration__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2016:1: rule__JavaFXIntegration__Group__4 : rule__JavaFXIntegration__Group__4__Impl rule__JavaFXIntegration__Group__5 ;
    public final void rule__JavaFXIntegration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2020:1: ( rule__JavaFXIntegration__Group__4__Impl rule__JavaFXIntegration__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2021:2: rule__JavaFXIntegration__Group__4__Impl rule__JavaFXIntegration__Group__5
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__4__Impl_in_rule__JavaFXIntegration__Group__44140);
            rule__JavaFXIntegration__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__5_in_rule__JavaFXIntegration__Group__44143);
            rule__JavaFXIntegration__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__4"


    // $ANTLR start "rule__JavaFXIntegration__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2028:1: rule__JavaFXIntegration__Group__4__Impl : ( ( rule__JavaFXIntegration__E4Assignment_4 )? ) ;
    public final void rule__JavaFXIntegration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2032:1: ( ( ( rule__JavaFXIntegration__E4Assignment_4 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2033:1: ( ( rule__JavaFXIntegration__E4Assignment_4 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2033:1: ( ( rule__JavaFXIntegration__E4Assignment_4 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2034:1: ( rule__JavaFXIntegration__E4Assignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getE4Assignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2035:1: ( rule__JavaFXIntegration__E4Assignment_4 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==38) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2035:2: rule__JavaFXIntegration__E4Assignment_4
                    {
                    pushFollow(FOLLOW_rule__JavaFXIntegration__E4Assignment_4_in_rule__JavaFXIntegration__Group__4__Impl4170);
                    rule__JavaFXIntegration__E4Assignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getE4Assignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__4__Impl"


    // $ANTLR start "rule__JavaFXIntegration__Group__5"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2045:1: rule__JavaFXIntegration__Group__5 : rule__JavaFXIntegration__Group__5__Impl ;
    public final void rule__JavaFXIntegration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2049:1: ( rule__JavaFXIntegration__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2050:2: rule__JavaFXIntegration__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__5__Impl_in_rule__JavaFXIntegration__Group__54201);
            rule__JavaFXIntegration__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__5"


    // $ANTLR start "rule__JavaFXIntegration__Group__5__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2056:1: rule__JavaFXIntegration__Group__5__Impl : ( '}' ) ;
    public final void rule__JavaFXIntegration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2060:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2061:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2061:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2062:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,16,FOLLOW_16_in_rule__JavaFXIntegration__Group__5__Impl4229); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getRightCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__Group__5__Impl"


    // $ANTLR start "rule__SWTIntegration__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2087:1: rule__SWTIntegration__Group__0 : rule__SWTIntegration__Group__0__Impl rule__SWTIntegration__Group__1 ;
    public final void rule__SWTIntegration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2091:1: ( rule__SWTIntegration__Group__0__Impl rule__SWTIntegration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2092:2: rule__SWTIntegration__Group__0__Impl rule__SWTIntegration__Group__1
            {
            pushFollow(FOLLOW_rule__SWTIntegration__Group__0__Impl_in_rule__SWTIntegration__Group__04272);
            rule__SWTIntegration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SWTIntegration__Group__1_in_rule__SWTIntegration__Group__04275);
            rule__SWTIntegration__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__0"


    // $ANTLR start "rule__SWTIntegration__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2099:1: rule__SWTIntegration__Group__0__Impl : ( 'swt' ) ;
    public final void rule__SWTIntegration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2103:1: ( ( 'swt' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2104:1: ( 'swt' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2104:1: ( 'swt' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2105:1: 'swt'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getSwtKeyword_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__SWTIntegration__Group__0__Impl4303); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getSwtKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__0__Impl"


    // $ANTLR start "rule__SWTIntegration__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2118:1: rule__SWTIntegration__Group__1 : rule__SWTIntegration__Group__1__Impl rule__SWTIntegration__Group__2 ;
    public final void rule__SWTIntegration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2122:1: ( rule__SWTIntegration__Group__1__Impl rule__SWTIntegration__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2123:2: rule__SWTIntegration__Group__1__Impl rule__SWTIntegration__Group__2
            {
            pushFollow(FOLLOW_rule__SWTIntegration__Group__1__Impl_in_rule__SWTIntegration__Group__14334);
            rule__SWTIntegration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SWTIntegration__Group__2_in_rule__SWTIntegration__Group__14337);
            rule__SWTIntegration__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__1"


    // $ANTLR start "rule__SWTIntegration__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2130:1: rule__SWTIntegration__Group__1__Impl : ( '{' ) ;
    public final void rule__SWTIntegration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2134:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2135:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2135:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2136:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__SWTIntegration__Group__1__Impl4365); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__1__Impl"


    // $ANTLR start "rule__SWTIntegration__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2149:1: rule__SWTIntegration__Group__2 : rule__SWTIntegration__Group__2__Impl rule__SWTIntegration__Group__3 ;
    public final void rule__SWTIntegration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2153:1: ( rule__SWTIntegration__Group__2__Impl rule__SWTIntegration__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2154:2: rule__SWTIntegration__Group__2__Impl rule__SWTIntegration__Group__3
            {
            pushFollow(FOLLOW_rule__SWTIntegration__Group__2__Impl_in_rule__SWTIntegration__Group__24396);
            rule__SWTIntegration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SWTIntegration__Group__3_in_rule__SWTIntegration__Group__24399);
            rule__SWTIntegration__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__2"


    // $ANTLR start "rule__SWTIntegration__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2161:1: rule__SWTIntegration__Group__2__Impl : ( () ) ;
    public final void rule__SWTIntegration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2165:1: ( ( () ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2166:1: ( () )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2166:1: ( () )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2167:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getSWTIntegrationAction_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2168:1: ()
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2170:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getSWTIntegrationAction_2()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__2__Impl"


    // $ANTLR start "rule__SWTIntegration__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2180:1: rule__SWTIntegration__Group__3 : rule__SWTIntegration__Group__3__Impl rule__SWTIntegration__Group__4 ;
    public final void rule__SWTIntegration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2184:1: ( rule__SWTIntegration__Group__3__Impl rule__SWTIntegration__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2185:2: rule__SWTIntegration__Group__3__Impl rule__SWTIntegration__Group__4
            {
            pushFollow(FOLLOW_rule__SWTIntegration__Group__3__Impl_in_rule__SWTIntegration__Group__34457);
            rule__SWTIntegration__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SWTIntegration__Group__4_in_rule__SWTIntegration__Group__34460);
            rule__SWTIntegration__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__3"


    // $ANTLR start "rule__SWTIntegration__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2192:1: rule__SWTIntegration__Group__3__Impl : ( ( rule__SWTIntegration__CodegenAssignment_3 )? ) ;
    public final void rule__SWTIntegration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2196:1: ( ( ( rule__SWTIntegration__CodegenAssignment_3 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2197:1: ( ( rule__SWTIntegration__CodegenAssignment_3 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2197:1: ( ( rule__SWTIntegration__CodegenAssignment_3 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2198:1: ( rule__SWTIntegration__CodegenAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getCodegenAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2199:1: ( rule__SWTIntegration__CodegenAssignment_3 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==37) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2199:2: rule__SWTIntegration__CodegenAssignment_3
                    {
                    pushFollow(FOLLOW_rule__SWTIntegration__CodegenAssignment_3_in_rule__SWTIntegration__Group__3__Impl4487);
                    rule__SWTIntegration__CodegenAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getCodegenAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__3__Impl"


    // $ANTLR start "rule__SWTIntegration__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2209:1: rule__SWTIntegration__Group__4 : rule__SWTIntegration__Group__4__Impl rule__SWTIntegration__Group__5 ;
    public final void rule__SWTIntegration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2213:1: ( rule__SWTIntegration__Group__4__Impl rule__SWTIntegration__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2214:2: rule__SWTIntegration__Group__4__Impl rule__SWTIntegration__Group__5
            {
            pushFollow(FOLLOW_rule__SWTIntegration__Group__4__Impl_in_rule__SWTIntegration__Group__44518);
            rule__SWTIntegration__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SWTIntegration__Group__5_in_rule__SWTIntegration__Group__44521);
            rule__SWTIntegration__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__4"


    // $ANTLR start "rule__SWTIntegration__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2221:1: rule__SWTIntegration__Group__4__Impl : ( ( rule__SWTIntegration__E4Assignment_4 )? ) ;
    public final void rule__SWTIntegration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2225:1: ( ( ( rule__SWTIntegration__E4Assignment_4 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2226:1: ( ( rule__SWTIntegration__E4Assignment_4 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2226:1: ( ( rule__SWTIntegration__E4Assignment_4 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2227:1: ( rule__SWTIntegration__E4Assignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getE4Assignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2228:1: ( rule__SWTIntegration__E4Assignment_4 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==38) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2228:2: rule__SWTIntegration__E4Assignment_4
                    {
                    pushFollow(FOLLOW_rule__SWTIntegration__E4Assignment_4_in_rule__SWTIntegration__Group__4__Impl4548);
                    rule__SWTIntegration__E4Assignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getE4Assignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__4__Impl"


    // $ANTLR start "rule__SWTIntegration__Group__5"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2238:1: rule__SWTIntegration__Group__5 : rule__SWTIntegration__Group__5__Impl ;
    public final void rule__SWTIntegration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2242:1: ( rule__SWTIntegration__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2243:2: rule__SWTIntegration__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__SWTIntegration__Group__5__Impl_in_rule__SWTIntegration__Group__54579);
            rule__SWTIntegration__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__5"


    // $ANTLR start "rule__SWTIntegration__Group__5__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2249:1: rule__SWTIntegration__Group__5__Impl : ( '}' ) ;
    public final void rule__SWTIntegration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2253:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2254:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2254:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2255:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,16,FOLLOW_16_in_rule__SWTIntegration__Group__5__Impl4607); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getRightCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__Group__5__Impl"


    // $ANTLR start "rule__Paritioning__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2280:1: rule__Paritioning__Group__0 : rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1 ;
    public final void rule__Paritioning__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2284:1: ( rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2285:2: rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__0__Impl_in_rule__Paritioning__Group__04650);
            rule__Paritioning__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__1_in_rule__Paritioning__Group__04653);
            rule__Paritioning__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__Group__0"


    // $ANTLR start "rule__Paritioning__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2292:1: rule__Paritioning__Group__0__Impl : ( 'partitioning' ) ;
    public final void rule__Paritioning__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2296:1: ( ( 'partitioning' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2297:1: ( 'partitioning' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2297:1: ( 'partitioning' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2298:1: 'partitioning'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitioningKeyword_0()); 
            }
            match(input,20,FOLLOW_20_in_rule__Paritioning__Group__0__Impl4681); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getPartitioningKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__Group__0__Impl"


    // $ANTLR start "rule__Paritioning__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2311:1: rule__Paritioning__Group__1 : rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2 ;
    public final void rule__Paritioning__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2315:1: ( rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2316:2: rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__1__Impl_in_rule__Paritioning__Group__14712);
            rule__Paritioning__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__2_in_rule__Paritioning__Group__14715);
            rule__Paritioning__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__Group__1"


    // $ANTLR start "rule__Paritioning__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2323:1: rule__Paritioning__Group__1__Impl : ( '{' ) ;
    public final void rule__Paritioning__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2327:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2328:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2328:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2329:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__Paritioning__Group__1__Impl4743); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__Group__1__Impl"


    // $ANTLR start "rule__Paritioning__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2342:1: rule__Paritioning__Group__2 : rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3 ;
    public final void rule__Paritioning__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2346:1: ( rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2347:2: rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__2__Impl_in_rule__Paritioning__Group__24774);
            rule__Paritioning__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__3_in_rule__Paritioning__Group__24777);
            rule__Paritioning__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__Group__2"


    // $ANTLR start "rule__Paritioning__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2354:1: rule__Paritioning__Group__2__Impl : ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) ) ;
    public final void rule__Paritioning__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2358:1: ( ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2359:1: ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2359:1: ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2360:1: ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2360:1: ( ( rule__Paritioning__PartitionsAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2361:1: ( rule__Paritioning__PartitionsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2362:1: ( rule__Paritioning__PartitionsAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2362:2: rule__Paritioning__PartitionsAssignment_2
            {
            pushFollow(FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl4806);
            rule__Paritioning__PartitionsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2365:1: ( ( rule__Paritioning__PartitionsAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2366:1: ( rule__Paritioning__PartitionsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2367:1: ( rule__Paritioning__PartitionsAssignment_2 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==21) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2367:2: rule__Paritioning__PartitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl4818);
            	    rule__Paritioning__PartitionsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__Group__2__Impl"


    // $ANTLR start "rule__Paritioning__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2378:1: rule__Paritioning__Group__3 : rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4 ;
    public final void rule__Paritioning__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2382:1: ( rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2383:2: rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__3__Impl_in_rule__Paritioning__Group__34851);
            rule__Paritioning__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__4_in_rule__Paritioning__Group__34854);
            rule__Paritioning__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__Group__3"


    // $ANTLR start "rule__Paritioning__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2390:1: rule__Paritioning__Group__3__Impl : ( ( rule__Paritioning__PartitionerAssignment_3 ) ) ;
    public final void rule__Paritioning__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2394:1: ( ( ( rule__Paritioning__PartitionerAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2395:1: ( ( rule__Paritioning__PartitionerAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2395:1: ( ( rule__Paritioning__PartitionerAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2396:1: ( rule__Paritioning__PartitionerAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionerAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2397:1: ( rule__Paritioning__PartitionerAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2397:2: rule__Paritioning__PartitionerAssignment_3
            {
            pushFollow(FOLLOW_rule__Paritioning__PartitionerAssignment_3_in_rule__Paritioning__Group__3__Impl4881);
            rule__Paritioning__PartitionerAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getPartitionerAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__Group__3__Impl"


    // $ANTLR start "rule__Paritioning__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2407:1: rule__Paritioning__Group__4 : rule__Paritioning__Group__4__Impl ;
    public final void rule__Paritioning__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2411:1: ( rule__Paritioning__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2412:2: rule__Paritioning__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__4__Impl_in_rule__Paritioning__Group__44911);
            rule__Paritioning__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__Group__4"


    // $ANTLR start "rule__Paritioning__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2418:1: rule__Paritioning__Group__4__Impl : ( '}' ) ;
    public final void rule__Paritioning__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2422:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2423:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2423:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2424:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,16,FOLLOW_16_in_rule__Paritioning__Group__4__Impl4939); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__Group__4__Impl"


    // $ANTLR start "rule__Partition__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2447:1: rule__Partition__Group__0 : rule__Partition__Group__0__Impl rule__Partition__Group__1 ;
    public final void rule__Partition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2451:1: ( rule__Partition__Group__0__Impl rule__Partition__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2452:2: rule__Partition__Group__0__Impl rule__Partition__Group__1
            {
            pushFollow(FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__04980);
            rule__Partition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__04983);
            rule__Partition__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition__Group__0"


    // $ANTLR start "rule__Partition__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2459:1: rule__Partition__Group__0__Impl : ( 'partition' ) ;
    public final void rule__Partition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2463:1: ( ( 'partition' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2464:1: ( 'partition' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2464:1: ( 'partition' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2465:1: 'partition'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__Partition__Group__0__Impl5011); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition__Group__0__Impl"


    // $ANTLR start "rule__Partition__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2478:1: rule__Partition__Group__1 : rule__Partition__Group__1__Impl ;
    public final void rule__Partition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2482:1: ( rule__Partition__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2483:2: rule__Partition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__15042);
            rule__Partition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition__Group__1"


    // $ANTLR start "rule__Partition__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2489:1: rule__Partition__Group__1__Impl : ( ( rule__Partition__NameAssignment_1 ) ) ;
    public final void rule__Partition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2493:1: ( ( ( rule__Partition__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2494:1: ( ( rule__Partition__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2494:1: ( ( rule__Partition__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2495:1: ( rule__Partition__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2496:1: ( rule__Partition__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2496:2: rule__Partition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl5069);
            rule__Partition__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition__Group__1__Impl"


    // $ANTLR start "rule__Paritioner_JS__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2510:1: rule__Paritioner_JS__Group__0 : rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1 ;
    public final void rule__Paritioner_JS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2514:1: ( rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2515:2: rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__0__Impl_in_rule__Paritioner_JS__Group__05103);
            rule__Paritioner_JS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__1_in_rule__Paritioner_JS__Group__05106);
            rule__Paritioner_JS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioner_JS__Group__0"


    // $ANTLR start "rule__Paritioner_JS__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2522:1: rule__Paritioner_JS__Group__0__Impl : ( 'script' ) ;
    public final void rule__Paritioner_JS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2526:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2527:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2527:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2528:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptKeyword_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__Paritioner_JS__Group__0__Impl5134); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioner_JSAccess().getScriptKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioner_JS__Group__0__Impl"


    // $ANTLR start "rule__Paritioner_JS__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2541:1: rule__Paritioner_JS__Group__1 : rule__Paritioner_JS__Group__1__Impl ;
    public final void rule__Paritioner_JS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2545:1: ( rule__Paritioner_JS__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2546:2: rule__Paritioner_JS__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__1__Impl_in_rule__Paritioner_JS__Group__15165);
            rule__Paritioner_JS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioner_JS__Group__1"


    // $ANTLR start "rule__Paritioner_JS__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2552:1: rule__Paritioner_JS__Group__1__Impl : ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) ) ;
    public final void rule__Paritioner_JS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2556:1: ( ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2557:1: ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2557:1: ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2558:1: ( rule__Paritioner_JS__ScriptURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptURIAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2559:1: ( rule__Paritioner_JS__ScriptURIAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2559:2: rule__Paritioner_JS__ScriptURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__ScriptURIAssignment_1_in_rule__Paritioner_JS__Group__1__Impl5192);
            rule__Paritioner_JS__ScriptURIAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioner_JSAccess().getScriptURIAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioner_JS__Group__1__Impl"


    // $ANTLR start "rule__Partitioner_Rule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2573:1: rule__Partitioner_Rule__Group__0 : rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1 ;
    public final void rule__Partitioner_Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2577:1: ( rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2578:2: rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__0__Impl_in_rule__Partitioner_Rule__Group__05226);
            rule__Partitioner_Rule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__1_in_rule__Partitioner_Rule__Group__05229);
            rule__Partitioner_Rule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partitioner_Rule__Group__0"


    // $ANTLR start "rule__Partitioner_Rule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2585:1: rule__Partitioner_Rule__Group__0__Impl : ( 'rule' ) ;
    public final void rule__Partitioner_Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2589:1: ( ( 'rule' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2590:1: ( 'rule' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2590:1: ( 'rule' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2591:1: 'rule'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__Partitioner_Rule__Group__0__Impl5257); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partitioner_Rule__Group__0__Impl"


    // $ANTLR start "rule__Partitioner_Rule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2604:1: rule__Partitioner_Rule__Group__1 : rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2 ;
    public final void rule__Partitioner_Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2608:1: ( rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2609:2: rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__1__Impl_in_rule__Partitioner_Rule__Group__15288);
            rule__Partitioner_Rule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__2_in_rule__Partitioner_Rule__Group__15291);
            rule__Partitioner_Rule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partitioner_Rule__Group__1"


    // $ANTLR start "rule__Partitioner_Rule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2616:1: rule__Partitioner_Rule__Group__1__Impl : ( '{' ) ;
    public final void rule__Partitioner_Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2620:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2621:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2621:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2622:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__Partitioner_Rule__Group__1__Impl5319); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partitioner_Rule__Group__1__Impl"


    // $ANTLR start "rule__Partitioner_Rule__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2635:1: rule__Partitioner_Rule__Group__2 : rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3 ;
    public final void rule__Partitioner_Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2639:1: ( rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2640:2: rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__2__Impl_in_rule__Partitioner_Rule__Group__25350);
            rule__Partitioner_Rule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__3_in_rule__Partitioner_Rule__Group__25353);
            rule__Partitioner_Rule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partitioner_Rule__Group__2"


    // $ANTLR start "rule__Partitioner_Rule__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2647:1: rule__Partitioner_Rule__Group__2__Impl : ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) ) ;
    public final void rule__Partitioner_Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2651:1: ( ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2652:1: ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2652:1: ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2653:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2653:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2654:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2655:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2655:2: rule__Partitioner_Rule__RuleListAssignment_2
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl5382);
            rule__Partitioner_Rule__RuleListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2658:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2659:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2660:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==24||LA18_0==28) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2660:2: rule__Partitioner_Rule__RuleListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl5394);
            	    rule__Partitioner_Rule__RuleListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partitioner_Rule__Group__2__Impl"


    // $ANTLR start "rule__Partitioner_Rule__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2671:1: rule__Partitioner_Rule__Group__3 : rule__Partitioner_Rule__Group__3__Impl ;
    public final void rule__Partitioner_Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2675:1: ( rule__Partitioner_Rule__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2676:2: rule__Partitioner_Rule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__3__Impl_in_rule__Partitioner_Rule__Group__35427);
            rule__Partitioner_Rule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partitioner_Rule__Group__3"


    // $ANTLR start "rule__Partitioner_Rule__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2682:1: rule__Partitioner_Rule__Group__3__Impl : ( '}' ) ;
    public final void rule__Partitioner_Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2686:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2687:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2687:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2688:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__Partitioner_Rule__Group__3__Impl5455); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleAccess().getRightCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partitioner_Rule__Group__3__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2709:1: rule__Partition_SingleLineRule__Group__0 : rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1 ;
    public final void rule__Partition_SingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2713:1: ( rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2714:2: rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__0__Impl_in_rule__Partition_SingleLineRule__Group__05494);
            rule__Partition_SingleLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__1_in_rule__Partition_SingleLineRule__Group__05497);
            rule__Partition_SingleLineRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__0"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2721:1: rule__Partition_SingleLineRule__Group__0__Impl : ( 'single_line' ) ;
    public final void rule__Partition_SingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2725:1: ( ( 'single_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2726:1: ( 'single_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2726:1: ( 'single_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2727:1: 'single_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__Partition_SingleLineRule__Group__0__Impl5525); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__0__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2740:1: rule__Partition_SingleLineRule__Group__1 : rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2 ;
    public final void rule__Partition_SingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2744:1: ( rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2745:2: rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__1__Impl_in_rule__Partition_SingleLineRule__Group__15556);
            rule__Partition_SingleLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__2_in_rule__Partition_SingleLineRule__Group__15559);
            rule__Partition_SingleLineRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__1"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2752:1: rule__Partition_SingleLineRule__Group__1__Impl : ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__Partition_SingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2756:1: ( ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2757:1: ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2757:1: ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2758:1: ( rule__Partition_SingleLineRule__ParitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2759:1: ( rule__Partition_SingleLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2759:2: rule__Partition_SingleLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__ParitionAssignment_1_in_rule__Partition_SingleLineRule__Group__1__Impl5586);
            rule__Partition_SingleLineRule__ParitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getParitionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__1__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2769:1: rule__Partition_SingleLineRule__Group__2 : rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3 ;
    public final void rule__Partition_SingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2773:1: ( rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2774:2: rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__2__Impl_in_rule__Partition_SingleLineRule__Group__25616);
            rule__Partition_SingleLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__3_in_rule__Partition_SingleLineRule__Group__25619);
            rule__Partition_SingleLineRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__2"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2781:1: rule__Partition_SingleLineRule__Group__2__Impl : ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__Partition_SingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2785:1: ( ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2786:1: ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2786:1: ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2787:1: ( rule__Partition_SingleLineRule__StartSeqAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2788:1: ( rule__Partition_SingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2788:2: rule__Partition_SingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__StartSeqAssignment_2_in_rule__Partition_SingleLineRule__Group__2__Impl5646);
            rule__Partition_SingleLineRule__StartSeqAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__2__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2798:1: rule__Partition_SingleLineRule__Group__3 : rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4 ;
    public final void rule__Partition_SingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2802:1: ( rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2803:2: rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__3__Impl_in_rule__Partition_SingleLineRule__Group__35676);
            rule__Partition_SingleLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__4_in_rule__Partition_SingleLineRule__Group__35679);
            rule__Partition_SingleLineRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__3"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2810:1: rule__Partition_SingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__Partition_SingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2814:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2815:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2815:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2816:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            }
            match(input,25,FOLLOW_25_in_rule__Partition_SingleLineRule__Group__3__Impl5707); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__3__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2829:1: rule__Partition_SingleLineRule__Group__4 : rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5 ;
    public final void rule__Partition_SingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2833:1: ( rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2834:2: rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__4__Impl_in_rule__Partition_SingleLineRule__Group__45738);
            rule__Partition_SingleLineRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__5_in_rule__Partition_SingleLineRule__Group__45741);
            rule__Partition_SingleLineRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__4"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2841:1: rule__Partition_SingleLineRule__Group__4__Impl : ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2845:1: ( ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2846:1: ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2846:1: ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2847:1: ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2848:1: ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_STRING) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2848:2: rule__Partition_SingleLineRule__EndSeqAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Partition_SingleLineRule__EndSeqAssignment_4_in_rule__Partition_SingleLineRule__Group__4__Impl5768);
                    rule__Partition_SingleLineRule__EndSeqAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__4__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__5"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2858:1: rule__Partition_SingleLineRule__Group__5 : rule__Partition_SingleLineRule__Group__5__Impl ;
    public final void rule__Partition_SingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2862:1: ( rule__Partition_SingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2863:2: rule__Partition_SingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__5__Impl_in_rule__Partition_SingleLineRule__Group__55799);
            rule__Partition_SingleLineRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__5"


    // $ANTLR start "rule__Partition_SingleLineRule__Group__5__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2869:1: rule__Partition_SingleLineRule__Group__5__Impl : ( ( rule__Partition_SingleLineRule__Group_5__0 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2873:1: ( ( ( rule__Partition_SingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2874:1: ( ( rule__Partition_SingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2874:1: ( ( rule__Partition_SingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2875:1: ( rule__Partition_SingleLineRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_5()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2876:1: ( rule__Partition_SingleLineRule__Group_5__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==26) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2876:2: rule__Partition_SingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__0_in_rule__Partition_SingleLineRule__Group__5__Impl5826);
                    rule__Partition_SingleLineRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group__5__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_5__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2898:1: rule__Partition_SingleLineRule__Group_5__0 : rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1 ;
    public final void rule__Partition_SingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2902:1: ( rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2903:2: rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__0__Impl_in_rule__Partition_SingleLineRule__Group_5__05869);
            rule__Partition_SingleLineRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__1_in_rule__Partition_SingleLineRule__Group_5__05872);
            rule__Partition_SingleLineRule__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group_5__0"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_5__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2910:1: rule__Partition_SingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__Partition_SingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2914:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2915:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2915:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2916:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_5_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__Partition_SingleLineRule__Group_5__0__Impl5900); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group_5__0__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_5__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2929:1: rule__Partition_SingleLineRule__Group_5__1 : rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2 ;
    public final void rule__Partition_SingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2933:1: ( rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2934:2: rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__1__Impl_in_rule__Partition_SingleLineRule__Group_5__15931);
            rule__Partition_SingleLineRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__2_in_rule__Partition_SingleLineRule__Group_5__15934);
            rule__Partition_SingleLineRule__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group_5__1"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_5__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2941:1: rule__Partition_SingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__Partition_SingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2945:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2946:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2946:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2947:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_5_1()); 
            }
            match(input,27,FOLLOW_27_in_rule__Partition_SingleLineRule__Group_5__1__Impl5962); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group_5__1__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_5__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2960:1: rule__Partition_SingleLineRule__Group_5__2 : rule__Partition_SingleLineRule__Group_5__2__Impl ;
    public final void rule__Partition_SingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2964:1: ( rule__Partition_SingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2965:2: rule__Partition_SingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__2__Impl_in_rule__Partition_SingleLineRule__Group_5__25993);
            rule__Partition_SingleLineRule__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group_5__2"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_5__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2971:1: rule__Partition_SingleLineRule__Group_5__2__Impl : ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__Partition_SingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2975:1: ( ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2976:1: ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2976:1: ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2977:1: ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2978:1: ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2978:2: rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_SingleLineRule__Group_5__2__Impl6020);
            rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__Group_5__2__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2994:1: rule__Partition_MultiLineRule__Group__0 : rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1 ;
    public final void rule__Partition_MultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2998:1: ( rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2999:2: rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__0__Impl_in_rule__Partition_MultiLineRule__Group__06056);
            rule__Partition_MultiLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__1_in_rule__Partition_MultiLineRule__Group__06059);
            rule__Partition_MultiLineRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__0"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3006:1: rule__Partition_MultiLineRule__Group__0__Impl : ( 'multi_line' ) ;
    public final void rule__Partition_MultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3010:1: ( ( 'multi_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3011:1: ( 'multi_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3011:1: ( 'multi_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3012:1: 'multi_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__Partition_MultiLineRule__Group__0__Impl6087); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__0__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3025:1: rule__Partition_MultiLineRule__Group__1 : rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2 ;
    public final void rule__Partition_MultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3029:1: ( rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3030:2: rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__1__Impl_in_rule__Partition_MultiLineRule__Group__16118);
            rule__Partition_MultiLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__2_in_rule__Partition_MultiLineRule__Group__16121);
            rule__Partition_MultiLineRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__1"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3037:1: rule__Partition_MultiLineRule__Group__1__Impl : ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3041:1: ( ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3042:1: ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3042:1: ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3043:1: ( rule__Partition_MultiLineRule__ParitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3044:1: ( rule__Partition_MultiLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3044:2: rule__Partition_MultiLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__ParitionAssignment_1_in_rule__Partition_MultiLineRule__Group__1__Impl6148);
            rule__Partition_MultiLineRule__ParitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getParitionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__1__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3054:1: rule__Partition_MultiLineRule__Group__2 : rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3 ;
    public final void rule__Partition_MultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3058:1: ( rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3059:2: rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__2__Impl_in_rule__Partition_MultiLineRule__Group__26178);
            rule__Partition_MultiLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__3_in_rule__Partition_MultiLineRule__Group__26181);
            rule__Partition_MultiLineRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__2"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3066:1: rule__Partition_MultiLineRule__Group__2__Impl : ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3070:1: ( ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3071:1: ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3071:1: ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3072:1: ( rule__Partition_MultiLineRule__StartSeqAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3073:1: ( rule__Partition_MultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3073:2: rule__Partition_MultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__StartSeqAssignment_2_in_rule__Partition_MultiLineRule__Group__2__Impl6208);
            rule__Partition_MultiLineRule__StartSeqAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__2__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3083:1: rule__Partition_MultiLineRule__Group__3 : rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4 ;
    public final void rule__Partition_MultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3087:1: ( rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3088:2: rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__3__Impl_in_rule__Partition_MultiLineRule__Group__36238);
            rule__Partition_MultiLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__4_in_rule__Partition_MultiLineRule__Group__36241);
            rule__Partition_MultiLineRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__3"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3095:1: rule__Partition_MultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__Partition_MultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3099:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3100:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3100:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3101:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            }
            match(input,25,FOLLOW_25_in_rule__Partition_MultiLineRule__Group__3__Impl6269); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__3__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3114:1: rule__Partition_MultiLineRule__Group__4 : rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5 ;
    public final void rule__Partition_MultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3118:1: ( rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3119:2: rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__4__Impl_in_rule__Partition_MultiLineRule__Group__46300);
            rule__Partition_MultiLineRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__5_in_rule__Partition_MultiLineRule__Group__46303);
            rule__Partition_MultiLineRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__4"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3126:1: rule__Partition_MultiLineRule__Group__4__Impl : ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3130:1: ( ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3131:1: ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3131:1: ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3132:1: ( rule__Partition_MultiLineRule__EndSeqAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3133:1: ( rule__Partition_MultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3133:2: rule__Partition_MultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__EndSeqAssignment_4_in_rule__Partition_MultiLineRule__Group__4__Impl6330);
            rule__Partition_MultiLineRule__EndSeqAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__4__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__5"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3143:1: rule__Partition_MultiLineRule__Group__5 : rule__Partition_MultiLineRule__Group__5__Impl ;
    public final void rule__Partition_MultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3147:1: ( rule__Partition_MultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3148:2: rule__Partition_MultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__5__Impl_in_rule__Partition_MultiLineRule__Group__56360);
            rule__Partition_MultiLineRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__5"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__5__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3154:1: rule__Partition_MultiLineRule__Group__5__Impl : ( ( rule__Partition_MultiLineRule__Group_5__0 )? ) ;
    public final void rule__Partition_MultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3158:1: ( ( ( rule__Partition_MultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3159:1: ( ( rule__Partition_MultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3159:1: ( ( rule__Partition_MultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3160:1: ( rule__Partition_MultiLineRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup_5()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3161:1: ( rule__Partition_MultiLineRule__Group_5__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==26) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3161:2: rule__Partition_MultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__0_in_rule__Partition_MultiLineRule__Group__5__Impl6387);
                    rule__Partition_MultiLineRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__5__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_5__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3183:1: rule__Partition_MultiLineRule__Group_5__0 : rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1 ;
    public final void rule__Partition_MultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3187:1: ( rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3188:2: rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__0__Impl_in_rule__Partition_MultiLineRule__Group_5__06430);
            rule__Partition_MultiLineRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__1_in_rule__Partition_MultiLineRule__Group_5__06433);
            rule__Partition_MultiLineRule__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_5__0"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_5__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3195:1: rule__Partition_MultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__Partition_MultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3199:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3200:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3200:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3201:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_5_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__Partition_MultiLineRule__Group_5__0__Impl6461); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_5__0__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_5__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3214:1: rule__Partition_MultiLineRule__Group_5__1 : rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2 ;
    public final void rule__Partition_MultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3218:1: ( rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3219:2: rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__1__Impl_in_rule__Partition_MultiLineRule__Group_5__16492);
            rule__Partition_MultiLineRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__2_in_rule__Partition_MultiLineRule__Group_5__16495);
            rule__Partition_MultiLineRule__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_5__1"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_5__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3226:1: rule__Partition_MultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__Partition_MultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3230:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3231:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3231:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3232:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_5_1()); 
            }
            match(input,27,FOLLOW_27_in_rule__Partition_MultiLineRule__Group_5__1__Impl6523); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_5__1__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_5__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3245:1: rule__Partition_MultiLineRule__Group_5__2 : rule__Partition_MultiLineRule__Group_5__2__Impl ;
    public final void rule__Partition_MultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3249:1: ( rule__Partition_MultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3250:2: rule__Partition_MultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__2__Impl_in_rule__Partition_MultiLineRule__Group_5__26554);
            rule__Partition_MultiLineRule__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_5__2"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_5__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3256:1: rule__Partition_MultiLineRule__Group_5__2__Impl : ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__Partition_MultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3260:1: ( ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3261:1: ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3261:1: ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3262:1: ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3263:1: ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3263:2: rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_MultiLineRule__Group_5__2__Impl6581);
            rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_5__2__Impl"


    // $ANTLR start "rule__LexicalHighlighting__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3279:1: rule__LexicalHighlighting__Group__0 : rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1 ;
    public final void rule__LexicalHighlighting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3283:1: ( rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3284:2: rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__0__Impl_in_rule__LexicalHighlighting__Group__06617);
            rule__LexicalHighlighting__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__1_in_rule__LexicalHighlighting__Group__06620);
            rule__LexicalHighlighting__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__Group__0"


    // $ANTLR start "rule__LexicalHighlighting__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3291:1: rule__LexicalHighlighting__Group__0__Impl : ( 'lexical_highlighting' ) ;
    public final void rule__LexicalHighlighting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3295:1: ( ( 'lexical_highlighting' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3296:1: ( 'lexical_highlighting' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3296:1: ( 'lexical_highlighting' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3297:1: 'lexical_highlighting'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0()); 
            }
            match(input,29,FOLLOW_29_in_rule__LexicalHighlighting__Group__0__Impl6648); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__Group__0__Impl"


    // $ANTLR start "rule__LexicalHighlighting__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3310:1: rule__LexicalHighlighting__Group__1 : rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2 ;
    public final void rule__LexicalHighlighting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3314:1: ( rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3315:2: rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__1__Impl_in_rule__LexicalHighlighting__Group__16679);
            rule__LexicalHighlighting__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__2_in_rule__LexicalHighlighting__Group__16682);
            rule__LexicalHighlighting__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__Group__1"


    // $ANTLR start "rule__LexicalHighlighting__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3322:1: rule__LexicalHighlighting__Group__1__Impl : ( '{' ) ;
    public final void rule__LexicalHighlighting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3326:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3327:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3327:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3328:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__LexicalHighlighting__Group__1__Impl6710); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__Group__1__Impl"


    // $ANTLR start "rule__LexicalHighlighting__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3341:1: rule__LexicalHighlighting__Group__2 : rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3 ;
    public final void rule__LexicalHighlighting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3345:1: ( rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3346:2: rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__2__Impl_in_rule__LexicalHighlighting__Group__26741);
            rule__LexicalHighlighting__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__3_in_rule__LexicalHighlighting__Group__26744);
            rule__LexicalHighlighting__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__Group__2"


    // $ANTLR start "rule__LexicalHighlighting__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3353:1: rule__LexicalHighlighting__Group__2__Impl : ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) ) ;
    public final void rule__LexicalHighlighting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3357:1: ( ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3358:1: ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3358:1: ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3359:1: ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3359:1: ( ( rule__LexicalHighlighting__ListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3360:1: ( rule__LexicalHighlighting__ListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3361:1: ( rule__LexicalHighlighting__ListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3361:2: rule__LexicalHighlighting__ListAssignment_2
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl6773);
            rule__LexicalHighlighting__ListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3364:1: ( ( rule__LexicalHighlighting__ListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3365:1: ( rule__LexicalHighlighting__ListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3366:1: ( rule__LexicalHighlighting__ListAssignment_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=22 && LA22_0<=23)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3366:2: rule__LexicalHighlighting__ListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl6785);
            	    rule__LexicalHighlighting__ListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__Group__2__Impl"


    // $ANTLR start "rule__LexicalHighlighting__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3377:1: rule__LexicalHighlighting__Group__3 : rule__LexicalHighlighting__Group__3__Impl ;
    public final void rule__LexicalHighlighting__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3381:1: ( rule__LexicalHighlighting__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3382:2: rule__LexicalHighlighting__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__3__Impl_in_rule__LexicalHighlighting__Group__36818);
            rule__LexicalHighlighting__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__Group__3"


    // $ANTLR start "rule__LexicalHighlighting__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3388:1: rule__LexicalHighlighting__Group__3__Impl : ( '}' ) ;
    public final void rule__LexicalHighlighting__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3392:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3393:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3393:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3394:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__LexicalHighlighting__Group__3__Impl6846); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getRightCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__Group__3__Impl"


    // $ANTLR start "rule__LexicalPartitionHighlighting_JS__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3415:1: rule__LexicalPartitionHighlighting_JS__Group__0 : rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1 ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3419:1: ( rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3420:2: rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__06885);
            rule__LexicalPartitionHighlighting_JS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1_in_rule__LexicalPartitionHighlighting_JS__Group__06888);
            rule__LexicalPartitionHighlighting_JS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_JS__Group__0"


    // $ANTLR start "rule__LexicalPartitionHighlighting_JS__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3427:1: rule__LexicalPartitionHighlighting_JS__Group__0__Impl : ( 'script' ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3431:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3432:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3432:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3433:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__LexicalPartitionHighlighting_JS__Group__0__Impl6916); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_JS__Group__0__Impl"


    // $ANTLR start "rule__LexicalPartitionHighlighting_JS__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3446:1: rule__LexicalPartitionHighlighting_JS__Group__1 : rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2 ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3450:1: ( rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3451:2: rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__16947);
            rule__LexicalPartitionHighlighting_JS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2_in_rule__LexicalPartitionHighlighting_JS__Group__16950);
            rule__LexicalPartitionHighlighting_JS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_JS__Group__1"


    // $ANTLR start "rule__LexicalPartitionHighlighting_JS__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3458:1: rule__LexicalPartitionHighlighting_JS__Group__1__Impl : ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3462:1: ( ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3463:1: ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3463:1: ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3464:1: ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3465:1: ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3465:2: rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_JS__Group__1__Impl6977);
            rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_JS__Group__1__Impl"


    // $ANTLR start "rule__LexicalPartitionHighlighting_JS__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3475:1: rule__LexicalPartitionHighlighting_JS__Group__2 : rule__LexicalPartitionHighlighting_JS__Group__2__Impl ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3479:1: ( rule__LexicalPartitionHighlighting_JS__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3480:2: rule__LexicalPartitionHighlighting_JS__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__27007);
            rule__LexicalPartitionHighlighting_JS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_JS__Group__2"


    // $ANTLR start "rule__LexicalPartitionHighlighting_JS__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3486:1: rule__LexicalPartitionHighlighting_JS__Group__2__Impl : ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3490:1: ( ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3491:1: ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3491:1: ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3492:1: ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURIAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3493:1: ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3493:2: rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2_in_rule__LexicalPartitionHighlighting_JS__Group__2__Impl7034);
            rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURIAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_JS__Group__2__Impl"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3509:1: rule__LexicalPartitionHighlighting_Rule__Group__0 : rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3513:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3514:2: rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__07070);
            rule__LexicalPartitionHighlighting_Rule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1_in_rule__LexicalPartitionHighlighting_Rule__Group__07073);
            rule__LexicalPartitionHighlighting_Rule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__0"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3521:1: rule__LexicalPartitionHighlighting_Rule__Group__0__Impl : ( 'rule' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3525:1: ( ( 'rule' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3526:1: ( 'rule' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3526:1: ( 'rule' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3527:1: 'rule'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl7101); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__0__Impl"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3540:1: rule__LexicalPartitionHighlighting_Rule__Group__1 : rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3544:1: ( rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3545:2: rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__17132);
            rule__LexicalPartitionHighlighting_Rule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2_in_rule__LexicalPartitionHighlighting_Rule__Group__17135);
            rule__LexicalPartitionHighlighting_Rule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__1"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3552:1: rule__LexicalPartitionHighlighting_Rule__Group__1__Impl : ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3556:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3557:1: ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3557:1: ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3558:1: ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3559:1: ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3559:2: rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl7162);
            rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__1__Impl"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3569:1: rule__LexicalPartitionHighlighting_Rule__Group__2 : rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3573:1: ( rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3574:2: rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__27192);
            rule__LexicalPartitionHighlighting_Rule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3_in_rule__LexicalPartitionHighlighting_Rule__Group__27195);
            rule__LexicalPartitionHighlighting_Rule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__2"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3581:1: rule__LexicalPartitionHighlighting_Rule__Group__2__Impl : ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3585:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3586:1: ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3586:1: ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3587:1: ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3588:1: ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==36) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3588:2: rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2
                    {
                    pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2_in_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl7222);
                    rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__2__Impl"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3598:1: rule__LexicalPartitionHighlighting_Rule__Group__3 : rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3602:1: ( rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3603:2: rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__37253);
            rule__LexicalPartitionHighlighting_Rule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4_in_rule__LexicalPartitionHighlighting_Rule__Group__37256);
            rule__LexicalPartitionHighlighting_Rule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__3"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3610:1: rule__LexicalPartitionHighlighting_Rule__Group__3__Impl : ( '{' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3614:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3615:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3615:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3616:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,15,FOLLOW_15_in_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl7284); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__3__Impl"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3629:1: rule__LexicalPartitionHighlighting_Rule__Group__4 : rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3633:1: ( rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3634:2: rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__47315);
            rule__LexicalPartitionHighlighting_Rule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5_in_rule__LexicalPartitionHighlighting_Rule__Group__47318);
            rule__LexicalPartitionHighlighting_Rule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__4"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3641:1: rule__LexicalPartitionHighlighting_Rule__Group__4__Impl : ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3645:1: ( ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3646:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3646:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3647:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3647:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3648:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3649:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3649:2: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl7347);
            rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3652:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3653:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3654:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID||LA24_0==39) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3654:2: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl7359);
            	    rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__4__Impl"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__5"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3665:1: rule__LexicalPartitionHighlighting_Rule__Group__5 : rule__LexicalPartitionHighlighting_Rule__Group__5__Impl ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3669:1: ( rule__LexicalPartitionHighlighting_Rule__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3670:2: rule__LexicalPartitionHighlighting_Rule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__57392);
            rule__LexicalPartitionHighlighting_Rule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__5"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__Group__5__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3676:1: rule__LexicalPartitionHighlighting_Rule__Group__5__Impl : ( '}' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3680:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3681:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3681:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3682:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,16,FOLLOW_16_in_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl7420); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRightCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__Group__5__Impl"


    // $ANTLR start "rule__Token__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3707:1: rule__Token__Group__0 : rule__Token__Group__0__Impl rule__Token__Group__1 ;
    public final void rule__Token__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3711:1: ( rule__Token__Group__0__Impl rule__Token__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3712:2: rule__Token__Group__0__Impl rule__Token__Group__1
            {
            pushFollow(FOLLOW_rule__Token__Group__0__Impl_in_rule__Token__Group__07463);
            rule__Token__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group__1_in_rule__Token__Group__07466);
            rule__Token__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group__0"


    // $ANTLR start "rule__Token__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3719:1: rule__Token__Group__0__Impl : ( ( rule__Token__DefaultAssignment_0 )? ) ;
    public final void rule__Token__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3723:1: ( ( ( rule__Token__DefaultAssignment_0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3724:1: ( ( rule__Token__DefaultAssignment_0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3724:1: ( ( rule__Token__DefaultAssignment_0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3725:1: ( rule__Token__DefaultAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultAssignment_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3726:1: ( rule__Token__DefaultAssignment_0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==39) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3726:2: rule__Token__DefaultAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Token__DefaultAssignment_0_in_rule__Token__Group__0__Impl7493);
                    rule__Token__DefaultAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getDefaultAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group__0__Impl"


    // $ANTLR start "rule__Token__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3736:1: rule__Token__Group__1 : rule__Token__Group__1__Impl rule__Token__Group__2 ;
    public final void rule__Token__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3740:1: ( rule__Token__Group__1__Impl rule__Token__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3741:2: rule__Token__Group__1__Impl rule__Token__Group__2
            {
            pushFollow(FOLLOW_rule__Token__Group__1__Impl_in_rule__Token__Group__17524);
            rule__Token__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group__2_in_rule__Token__Group__17527);
            rule__Token__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group__1"


    // $ANTLR start "rule__Token__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3748:1: rule__Token__Group__1__Impl : ( ( rule__Token__NameAssignment_1 ) ) ;
    public final void rule__Token__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3752:1: ( ( ( rule__Token__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3753:1: ( ( rule__Token__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3753:1: ( ( rule__Token__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3754:1: ( rule__Token__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3755:1: ( rule__Token__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3755:2: rule__Token__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Token__NameAssignment_1_in_rule__Token__Group__1__Impl7554);
            rule__Token__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group__1__Impl"


    // $ANTLR start "rule__Token__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3765:1: rule__Token__Group__2 : rule__Token__Group__2__Impl ;
    public final void rule__Token__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3769:1: ( rule__Token__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3770:2: rule__Token__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Token__Group__2__Impl_in_rule__Token__Group__27584);
            rule__Token__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group__2"


    // $ANTLR start "rule__Token__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3776:1: rule__Token__Group__2__Impl : ( ( rule__Token__Group_2__0 )? ) ;
    public final void rule__Token__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3780:1: ( ( ( rule__Token__Group_2__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3781:1: ( ( rule__Token__Group_2__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3781:1: ( ( rule__Token__Group_2__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3782:1: ( rule__Token__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getGroup_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3783:1: ( rule__Token__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==15) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3783:2: rule__Token__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Token__Group_2__0_in_rule__Token__Group__2__Impl7611);
                    rule__Token__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group__2__Impl"


    // $ANTLR start "rule__Token__Group_2__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3799:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3803:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3804:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
            {
            pushFollow(FOLLOW_rule__Token__Group_2__0__Impl_in_rule__Token__Group_2__07648);
            rule__Token__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group_2__1_in_rule__Token__Group_2__07651);
            rule__Token__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_2__0"


    // $ANTLR start "rule__Token__Group_2__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3811:1: rule__Token__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3815:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3816:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3816:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3817:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__Token__Group_2__0__Impl7679); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_2__0__Impl"


    // $ANTLR start "rule__Token__Group_2__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3830:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl rule__Token__Group_2__2 ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3834:1: ( rule__Token__Group_2__1__Impl rule__Token__Group_2__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3835:2: rule__Token__Group_2__1__Impl rule__Token__Group_2__2
            {
            pushFollow(FOLLOW_rule__Token__Group_2__1__Impl_in_rule__Token__Group_2__17710);
            rule__Token__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group_2__2_in_rule__Token__Group_2__17713);
            rule__Token__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_2__1"


    // $ANTLR start "rule__Token__Group_2__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3842:1: rule__Token__Group_2__1__Impl : ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3846:1: ( ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3847:1: ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3847:1: ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3848:1: ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3848:1: ( ( rule__Token__ScannerListAssignment_2_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3849:1: ( rule__Token__ScannerListAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3850:1: ( rule__Token__ScannerListAssignment_2_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3850:2: rule__Token__ScannerListAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl7742);
            rule__Token__ScannerListAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3853:1: ( ( rule__Token__ScannerListAssignment_2_1 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3854:1: ( rule__Token__ScannerListAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3855:1: ( rule__Token__ScannerListAssignment_2_1 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==22||LA27_0==24||LA27_0==28||LA27_0==30||LA27_0==35) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3855:2: rule__Token__ScannerListAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl7754);
            	    rule__Token__ScannerListAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_2__1__Impl"


    // $ANTLR start "rule__Token__Group_2__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3866:1: rule__Token__Group_2__2 : rule__Token__Group_2__2__Impl ;
    public final void rule__Token__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3870:1: ( rule__Token__Group_2__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3871:2: rule__Token__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Token__Group_2__2__Impl_in_rule__Token__Group_2__27787);
            rule__Token__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_2__2"


    // $ANTLR start "rule__Token__Group_2__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3877:1: rule__Token__Group_2__2__Impl : ( '}' ) ;
    public final void rule__Token__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3881:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3882:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3882:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3883:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,16,FOLLOW_16_in_rule__Token__Group_2__2__Impl7815); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getRightCurlyBracketKeyword_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_2__2__Impl"


    // $ANTLR start "rule__Scanner_Keyword__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3902:1: rule__Scanner_Keyword__Group__0 : rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1 ;
    public final void rule__Scanner_Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3906:1: ( rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3907:2: rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__0__Impl_in_rule__Scanner_Keyword__Group__07852);
            rule__Scanner_Keyword__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__1_in_rule__Scanner_Keyword__Group__07855);
            rule__Scanner_Keyword__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group__0"


    // $ANTLR start "rule__Scanner_Keyword__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3914:1: rule__Scanner_Keyword__Group__0__Impl : ( 'keywords' ) ;
    public final void rule__Scanner_Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3918:1: ( ( 'keywords' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3919:1: ( 'keywords' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3919:1: ( 'keywords' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3920:1: 'keywords'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__Scanner_Keyword__Group__0__Impl7883); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group__0__Impl"


    // $ANTLR start "rule__Scanner_Keyword__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3933:1: rule__Scanner_Keyword__Group__1 : rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2 ;
    public final void rule__Scanner_Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3937:1: ( rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3938:2: rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__1__Impl_in_rule__Scanner_Keyword__Group__17914);
            rule__Scanner_Keyword__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__2_in_rule__Scanner_Keyword__Group__17917);
            rule__Scanner_Keyword__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group__1"


    // $ANTLR start "rule__Scanner_Keyword__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3945:1: rule__Scanner_Keyword__Group__1__Impl : ( '[' ) ;
    public final void rule__Scanner_Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3949:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3950:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3950:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3951:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,31,FOLLOW_31_in_rule__Scanner_Keyword__Group__1__Impl7945); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group__1__Impl"


    // $ANTLR start "rule__Scanner_Keyword__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3964:1: rule__Scanner_Keyword__Group__2 : rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3 ;
    public final void rule__Scanner_Keyword__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3968:1: ( rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3969:2: rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__2__Impl_in_rule__Scanner_Keyword__Group__27976);
            rule__Scanner_Keyword__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__3_in_rule__Scanner_Keyword__Group__27979);
            rule__Scanner_Keyword__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group__2"


    // $ANTLR start "rule__Scanner_Keyword__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3976:1: rule__Scanner_Keyword__Group__2__Impl : ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) ) ;
    public final void rule__Scanner_Keyword__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3980:1: ( ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3981:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3981:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3982:1: ( rule__Scanner_Keyword__KeywordsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3983:1: ( rule__Scanner_Keyword__KeywordsAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3983:2: rule__Scanner_Keyword__KeywordsAssignment_2
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_2_in_rule__Scanner_Keyword__Group__2__Impl8006);
            rule__Scanner_Keyword__KeywordsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group__2__Impl"


    // $ANTLR start "rule__Scanner_Keyword__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3993:1: rule__Scanner_Keyword__Group__3 : rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4 ;
    public final void rule__Scanner_Keyword__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3997:1: ( rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3998:2: rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__3__Impl_in_rule__Scanner_Keyword__Group__38036);
            rule__Scanner_Keyword__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__4_in_rule__Scanner_Keyword__Group__38039);
            rule__Scanner_Keyword__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group__3"


    // $ANTLR start "rule__Scanner_Keyword__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4005:1: rule__Scanner_Keyword__Group__3__Impl : ( ( rule__Scanner_Keyword__Group_3__0 )* ) ;
    public final void rule__Scanner_Keyword__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4009:1: ( ( ( rule__Scanner_Keyword__Group_3__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4010:1: ( ( rule__Scanner_Keyword__Group_3__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4010:1: ( ( rule__Scanner_Keyword__Group_3__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4011:1: ( rule__Scanner_Keyword__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getGroup_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4012:1: ( rule__Scanner_Keyword__Group_3__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==33) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4012:2: rule__Scanner_Keyword__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__0_in_rule__Scanner_Keyword__Group__3__Impl8066);
            	    rule__Scanner_Keyword__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group__3__Impl"


    // $ANTLR start "rule__Scanner_Keyword__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4022:1: rule__Scanner_Keyword__Group__4 : rule__Scanner_Keyword__Group__4__Impl ;
    public final void rule__Scanner_Keyword__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4026:1: ( rule__Scanner_Keyword__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4027:2: rule__Scanner_Keyword__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__4__Impl_in_rule__Scanner_Keyword__Group__48097);
            rule__Scanner_Keyword__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group__4"


    // $ANTLR start "rule__Scanner_Keyword__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4033:1: rule__Scanner_Keyword__Group__4__Impl : ( ']' ) ;
    public final void rule__Scanner_Keyword__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4037:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4038:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4038:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4039:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,32,FOLLOW_32_in_rule__Scanner_Keyword__Group__4__Impl8125); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordAccess().getRightSquareBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group__4__Impl"


    // $ANTLR start "rule__Scanner_Keyword__Group_3__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4062:1: rule__Scanner_Keyword__Group_3__0 : rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1 ;
    public final void rule__Scanner_Keyword__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4066:1: ( rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4067:2: rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__0__Impl_in_rule__Scanner_Keyword__Group_3__08166);
            rule__Scanner_Keyword__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__1_in_rule__Scanner_Keyword__Group_3__08169);
            rule__Scanner_Keyword__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group_3__0"


    // $ANTLR start "rule__Scanner_Keyword__Group_3__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4074:1: rule__Scanner_Keyword__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Scanner_Keyword__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4078:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4079:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4079:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4080:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0()); 
            }
            match(input,33,FOLLOW_33_in_rule__Scanner_Keyword__Group_3__0__Impl8197); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group_3__0__Impl"


    // $ANTLR start "rule__Scanner_Keyword__Group_3__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4093:1: rule__Scanner_Keyword__Group_3__1 : rule__Scanner_Keyword__Group_3__1__Impl ;
    public final void rule__Scanner_Keyword__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4097:1: ( rule__Scanner_Keyword__Group_3__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4098:2: rule__Scanner_Keyword__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__1__Impl_in_rule__Scanner_Keyword__Group_3__18228);
            rule__Scanner_Keyword__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group_3__1"


    // $ANTLR start "rule__Scanner_Keyword__Group_3__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4104:1: rule__Scanner_Keyword__Group_3__1__Impl : ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) ) ;
    public final void rule__Scanner_Keyword__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4108:1: ( ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4109:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4109:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4110:1: ( rule__Scanner_Keyword__KeywordsAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_3_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4111:1: ( rule__Scanner_Keyword__KeywordsAssignment_3_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4111:2: rule__Scanner_Keyword__KeywordsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_3_1_in_rule__Scanner_Keyword__Group_3__1__Impl8255);
            rule__Scanner_Keyword__KeywordsAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__Group_3__1__Impl"


    // $ANTLR start "rule__Keyword__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4125:1: rule__Keyword__Group__0 : rule__Keyword__Group__0__Impl rule__Keyword__Group__1 ;
    public final void rule__Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4129:1: ( rule__Keyword__Group__0__Impl rule__Keyword__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4130:2: rule__Keyword__Group__0__Impl rule__Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__08289);
            rule__Keyword__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__08292);
            rule__Keyword__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__Group__0"


    // $ANTLR start "rule__Keyword__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4137:1: rule__Keyword__Group__0__Impl : ( ( rule__Keyword__NameAssignment_0 ) ) ;
    public final void rule__Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4141:1: ( ( ( rule__Keyword__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4142:1: ( ( rule__Keyword__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4142:1: ( ( rule__Keyword__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4143:1: ( rule__Keyword__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4144:1: ( rule__Keyword__NameAssignment_0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4144:2: rule__Keyword__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl8319);
            rule__Keyword__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__Group__0__Impl"


    // $ANTLR start "rule__Keyword__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4154:1: rule__Keyword__Group__1 : rule__Keyword__Group__1__Impl ;
    public final void rule__Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4158:1: ( rule__Keyword__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4159:2: rule__Keyword__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__18349);
            rule__Keyword__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__Group__1"


    // $ANTLR start "rule__Keyword__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4165:1: rule__Keyword__Group__1__Impl : ( ( rule__Keyword__Group_1__0 )? ) ;
    public final void rule__Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4169:1: ( ( ( rule__Keyword__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4170:1: ( ( rule__Keyword__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4170:1: ( ( rule__Keyword__Group_1__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4171:1: ( rule__Keyword__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getGroup_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4172:1: ( rule__Keyword__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4172:2: rule__Keyword__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl8376);
                    rule__Keyword__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__Group__1__Impl"


    // $ANTLR start "rule__Keyword__Group_1__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4186:1: rule__Keyword__Group_1__0 : rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 ;
    public final void rule__Keyword__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4190:1: ( rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4191:2: rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__08411);
            rule__Keyword__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__08414);
            rule__Keyword__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__Group_1__0"


    // $ANTLR start "rule__Keyword__Group_1__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4198:1: rule__Keyword__Group_1__0__Impl : ( 'since' ) ;
    public final void rule__Keyword__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4202:1: ( ( 'since' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4203:1: ( 'since' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4203:1: ( 'since' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4204:1: 'since'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            }
            match(input,34,FOLLOW_34_in_rule__Keyword__Group_1__0__Impl8442); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__Group_1__0__Impl"


    // $ANTLR start "rule__Keyword__Group_1__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4217:1: rule__Keyword__Group_1__1 : rule__Keyword__Group_1__1__Impl ;
    public final void rule__Keyword__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4221:1: ( rule__Keyword__Group_1__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4222:2: rule__Keyword__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__18473);
            rule__Keyword__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__Group_1__1"


    // $ANTLR start "rule__Keyword__Group_1__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4228:1: rule__Keyword__Group_1__1__Impl : ( ( rule__Keyword__VersionAssignment_1_1 ) ) ;
    public final void rule__Keyword__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4232:1: ( ( ( rule__Keyword__VersionAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4233:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4233:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4234:1: ( rule__Keyword__VersionAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4235:1: ( rule__Keyword__VersionAssignment_1_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4235:2: rule__Keyword__VersionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl8500);
            rule__Keyword__VersionAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__Group_1__1__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4249:1: rule__Scanner_SingleLineRule__Group__0 : rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1 ;
    public final void rule__Scanner_SingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4253:1: ( rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4254:2: rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__0__Impl_in_rule__Scanner_SingleLineRule__Group__08534);
            rule__Scanner_SingleLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__1_in_rule__Scanner_SingleLineRule__Group__08537);
            rule__Scanner_SingleLineRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group__0"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4261:1: rule__Scanner_SingleLineRule__Group__0__Impl : ( 'single_line' ) ;
    public final void rule__Scanner_SingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4265:1: ( ( 'single_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4266:1: ( 'single_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4266:1: ( 'single_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4267:1: 'single_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__Scanner_SingleLineRule__Group__0__Impl8565); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group__0__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4280:1: rule__Scanner_SingleLineRule__Group__1 : rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2 ;
    public final void rule__Scanner_SingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4284:1: ( rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4285:2: rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__1__Impl_in_rule__Scanner_SingleLineRule__Group__18596);
            rule__Scanner_SingleLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__2_in_rule__Scanner_SingleLineRule__Group__18599);
            rule__Scanner_SingleLineRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group__1"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4292:1: rule__Scanner_SingleLineRule__Group__1__Impl : ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4296:1: ( ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4297:1: ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4297:1: ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4298:1: ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4299:1: ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4299:2: rule__Scanner_SingleLineRule__StartSeqAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__StartSeqAssignment_1_in_rule__Scanner_SingleLineRule__Group__1__Impl8626);
            rule__Scanner_SingleLineRule__StartSeqAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group__1__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4309:1: rule__Scanner_SingleLineRule__Group__2 : rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3 ;
    public final void rule__Scanner_SingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4313:1: ( rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4314:2: rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__2__Impl_in_rule__Scanner_SingleLineRule__Group__28656);
            rule__Scanner_SingleLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__3_in_rule__Scanner_SingleLineRule__Group__28659);
            rule__Scanner_SingleLineRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group__2"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4321:1: rule__Scanner_SingleLineRule__Group__2__Impl : ( '=>' ) ;
    public final void rule__Scanner_SingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4325:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4326:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4326:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4327:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 
            }
            match(input,25,FOLLOW_25_in_rule__Scanner_SingleLineRule__Group__2__Impl8687); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group__2__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4340:1: rule__Scanner_SingleLineRule__Group__3 : rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4 ;
    public final void rule__Scanner_SingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4344:1: ( rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4345:2: rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__3__Impl_in_rule__Scanner_SingleLineRule__Group__38718);
            rule__Scanner_SingleLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__4_in_rule__Scanner_SingleLineRule__Group__38721);
            rule__Scanner_SingleLineRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group__3"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4352:1: rule__Scanner_SingleLineRule__Group__3__Impl : ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4356:1: ( ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4357:1: ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4357:1: ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4358:1: ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4359:1: ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_STRING) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4359:2: rule__Scanner_SingleLineRule__EndSeqAssignment_3
                    {
                    pushFollow(FOLLOW_rule__Scanner_SingleLineRule__EndSeqAssignment_3_in_rule__Scanner_SingleLineRule__Group__3__Impl8748);
                    rule__Scanner_SingleLineRule__EndSeqAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group__3__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4369:1: rule__Scanner_SingleLineRule__Group__4 : rule__Scanner_SingleLineRule__Group__4__Impl ;
    public final void rule__Scanner_SingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4373:1: ( rule__Scanner_SingleLineRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4374:2: rule__Scanner_SingleLineRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__4__Impl_in_rule__Scanner_SingleLineRule__Group__48779);
            rule__Scanner_SingleLineRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group__4"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4380:1: rule__Scanner_SingleLineRule__Group__4__Impl : ( ( rule__Scanner_SingleLineRule__Group_4__0 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4384:1: ( ( ( rule__Scanner_SingleLineRule__Group_4__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4385:1: ( ( rule__Scanner_SingleLineRule__Group_4__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4385:1: ( ( rule__Scanner_SingleLineRule__Group_4__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4386:1: ( rule__Scanner_SingleLineRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4387:1: ( rule__Scanner_SingleLineRule__Group_4__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==26) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4387:2: rule__Scanner_SingleLineRule__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__0_in_rule__Scanner_SingleLineRule__Group__4__Impl8806);
                    rule__Scanner_SingleLineRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group__4__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_4__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4407:1: rule__Scanner_SingleLineRule__Group_4__0 : rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1 ;
    public final void rule__Scanner_SingleLineRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4411:1: ( rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4412:2: rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__0__Impl_in_rule__Scanner_SingleLineRule__Group_4__08847);
            rule__Scanner_SingleLineRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__1_in_rule__Scanner_SingleLineRule__Group_4__08850);
            rule__Scanner_SingleLineRule__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_4__0"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_4__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4419:1: rule__Scanner_SingleLineRule__Group_4__0__Impl : ( 'escaped' ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4423:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4424:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4424:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4425:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_4_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__Scanner_SingleLineRule__Group_4__0__Impl8878); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_4__0__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_4__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4438:1: rule__Scanner_SingleLineRule__Group_4__1 : rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2 ;
    public final void rule__Scanner_SingleLineRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4442:1: ( rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4443:2: rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__1__Impl_in_rule__Scanner_SingleLineRule__Group_4__18909);
            rule__Scanner_SingleLineRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__2_in_rule__Scanner_SingleLineRule__Group_4__18912);
            rule__Scanner_SingleLineRule__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_4__1"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_4__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4450:1: rule__Scanner_SingleLineRule__Group_4__1__Impl : ( 'by' ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4454:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4455:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4455:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4456:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_4_1()); 
            }
            match(input,27,FOLLOW_27_in_rule__Scanner_SingleLineRule__Group_4__1__Impl8940); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_4__1__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_4__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4469:1: rule__Scanner_SingleLineRule__Group_4__2 : rule__Scanner_SingleLineRule__Group_4__2__Impl ;
    public final void rule__Scanner_SingleLineRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4473:1: ( rule__Scanner_SingleLineRule__Group_4__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4474:2: rule__Scanner_SingleLineRule__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__2__Impl_in_rule__Scanner_SingleLineRule__Group_4__28971);
            rule__Scanner_SingleLineRule__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_4__2"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_4__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4480:1: rule__Scanner_SingleLineRule__Group_4__2__Impl : ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4484:1: ( ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4485:1: ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4485:1: ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4486:1: ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4487:1: ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4487:2: rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_SingleLineRule__Group_4__2__Impl8998);
            rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_4__2__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4503:1: rule__Scanner_MultiLineRule__Group__0 : rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1 ;
    public final void rule__Scanner_MultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4507:1: ( rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4508:2: rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__0__Impl_in_rule__Scanner_MultiLineRule__Group__09034);
            rule__Scanner_MultiLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__1_in_rule__Scanner_MultiLineRule__Group__09037);
            rule__Scanner_MultiLineRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__0"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4515:1: rule__Scanner_MultiLineRule__Group__0__Impl : ( 'multi_line' ) ;
    public final void rule__Scanner_MultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4519:1: ( ( 'multi_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4520:1: ( 'multi_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4520:1: ( 'multi_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4521:1: 'multi_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__Scanner_MultiLineRule__Group__0__Impl9065); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__0__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4534:1: rule__Scanner_MultiLineRule__Group__1 : rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2 ;
    public final void rule__Scanner_MultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4538:1: ( rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4539:2: rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__1__Impl_in_rule__Scanner_MultiLineRule__Group__19096);
            rule__Scanner_MultiLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__2_in_rule__Scanner_MultiLineRule__Group__19099);
            rule__Scanner_MultiLineRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__1"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4546:1: rule__Scanner_MultiLineRule__Group__1__Impl : ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4550:1: ( ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4551:1: ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4551:1: ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4552:1: ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4553:1: ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4553:2: rule__Scanner_MultiLineRule__StartSeqAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__StartSeqAssignment_1_in_rule__Scanner_MultiLineRule__Group__1__Impl9126);
            rule__Scanner_MultiLineRule__StartSeqAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__1__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4563:1: rule__Scanner_MultiLineRule__Group__2 : rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3 ;
    public final void rule__Scanner_MultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4567:1: ( rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4568:2: rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__2__Impl_in_rule__Scanner_MultiLineRule__Group__29156);
            rule__Scanner_MultiLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__3_in_rule__Scanner_MultiLineRule__Group__29159);
            rule__Scanner_MultiLineRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__2"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4575:1: rule__Scanner_MultiLineRule__Group__2__Impl : ( '=>' ) ;
    public final void rule__Scanner_MultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4579:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4580:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4580:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4581:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 
            }
            match(input,25,FOLLOW_25_in_rule__Scanner_MultiLineRule__Group__2__Impl9187); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__2__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4594:1: rule__Scanner_MultiLineRule__Group__3 : rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4 ;
    public final void rule__Scanner_MultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4598:1: ( rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4599:2: rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__3__Impl_in_rule__Scanner_MultiLineRule__Group__39218);
            rule__Scanner_MultiLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__4_in_rule__Scanner_MultiLineRule__Group__39221);
            rule__Scanner_MultiLineRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__3"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4606:1: rule__Scanner_MultiLineRule__Group__3__Impl : ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4610:1: ( ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4611:1: ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4611:1: ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4612:1: ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4613:1: ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4613:2: rule__Scanner_MultiLineRule__EndSeqAssignment_3
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__EndSeqAssignment_3_in_rule__Scanner_MultiLineRule__Group__3__Impl9248);
            rule__Scanner_MultiLineRule__EndSeqAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__3__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4623:1: rule__Scanner_MultiLineRule__Group__4 : rule__Scanner_MultiLineRule__Group__4__Impl ;
    public final void rule__Scanner_MultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4627:1: ( rule__Scanner_MultiLineRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4628:2: rule__Scanner_MultiLineRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__4__Impl_in_rule__Scanner_MultiLineRule__Group__49278);
            rule__Scanner_MultiLineRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__4"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4634:1: rule__Scanner_MultiLineRule__Group__4__Impl : ( ( rule__Scanner_MultiLineRule__Group_4__0 )? ) ;
    public final void rule__Scanner_MultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4638:1: ( ( ( rule__Scanner_MultiLineRule__Group_4__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4639:1: ( ( rule__Scanner_MultiLineRule__Group_4__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4639:1: ( ( rule__Scanner_MultiLineRule__Group_4__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4640:1: ( rule__Scanner_MultiLineRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4641:1: ( rule__Scanner_MultiLineRule__Group_4__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==26) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4641:2: rule__Scanner_MultiLineRule__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__0_in_rule__Scanner_MultiLineRule__Group__4__Impl9305);
                    rule__Scanner_MultiLineRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__4__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_4__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4661:1: rule__Scanner_MultiLineRule__Group_4__0 : rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1 ;
    public final void rule__Scanner_MultiLineRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4665:1: ( rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4666:2: rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__0__Impl_in_rule__Scanner_MultiLineRule__Group_4__09346);
            rule__Scanner_MultiLineRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__1_in_rule__Scanner_MultiLineRule__Group_4__09349);
            rule__Scanner_MultiLineRule__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_4__0"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_4__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4673:1: rule__Scanner_MultiLineRule__Group_4__0__Impl : ( 'escaped' ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4677:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4678:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4678:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4679:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_4_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__Scanner_MultiLineRule__Group_4__0__Impl9377); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_4__0__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_4__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4692:1: rule__Scanner_MultiLineRule__Group_4__1 : rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2 ;
    public final void rule__Scanner_MultiLineRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4696:1: ( rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4697:2: rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__1__Impl_in_rule__Scanner_MultiLineRule__Group_4__19408);
            rule__Scanner_MultiLineRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__2_in_rule__Scanner_MultiLineRule__Group_4__19411);
            rule__Scanner_MultiLineRule__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_4__1"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_4__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4704:1: rule__Scanner_MultiLineRule__Group_4__1__Impl : ( 'by' ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4708:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4709:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4709:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4710:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_4_1()); 
            }
            match(input,27,FOLLOW_27_in_rule__Scanner_MultiLineRule__Group_4__1__Impl9439); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_4__1__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_4__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4723:1: rule__Scanner_MultiLineRule__Group_4__2 : rule__Scanner_MultiLineRule__Group_4__2__Impl ;
    public final void rule__Scanner_MultiLineRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4727:1: ( rule__Scanner_MultiLineRule__Group_4__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4728:2: rule__Scanner_MultiLineRule__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__2__Impl_in_rule__Scanner_MultiLineRule__Group_4__29470);
            rule__Scanner_MultiLineRule__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_4__2"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_4__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4734:1: rule__Scanner_MultiLineRule__Group_4__2__Impl : ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4738:1: ( ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4739:1: ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4739:1: ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4740:1: ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4741:1: ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4741:2: rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_MultiLineRule__Group_4__2__Impl9497);
            rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_4__2__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4757:1: rule__Scanner_CharacterRule__Group__0 : rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1 ;
    public final void rule__Scanner_CharacterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4761:1: ( rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4762:2: rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__0__Impl_in_rule__Scanner_CharacterRule__Group__09533);
            rule__Scanner_CharacterRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__1_in_rule__Scanner_CharacterRule__Group__09536);
            rule__Scanner_CharacterRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__0"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4769:1: rule__Scanner_CharacterRule__Group__0__Impl : ( 'character' ) ;
    public final void rule__Scanner_CharacterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4773:1: ( ( 'character' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4774:1: ( 'character' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4774:1: ( 'character' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4775:1: 'character'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__Scanner_CharacterRule__Group__0__Impl9564); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__0__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4788:1: rule__Scanner_CharacterRule__Group__1 : rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2 ;
    public final void rule__Scanner_CharacterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4792:1: ( rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4793:2: rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__1__Impl_in_rule__Scanner_CharacterRule__Group__19595);
            rule__Scanner_CharacterRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__2_in_rule__Scanner_CharacterRule__Group__19598);
            rule__Scanner_CharacterRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__1"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4800:1: rule__Scanner_CharacterRule__Group__1__Impl : ( '[' ) ;
    public final void rule__Scanner_CharacterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4804:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4805:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4805:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4806:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,31,FOLLOW_31_in_rule__Scanner_CharacterRule__Group__1__Impl9626); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__1__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4819:1: rule__Scanner_CharacterRule__Group__2 : rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3 ;
    public final void rule__Scanner_CharacterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4823:1: ( rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4824:2: rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__2__Impl_in_rule__Scanner_CharacterRule__Group__29657);
            rule__Scanner_CharacterRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__3_in_rule__Scanner_CharacterRule__Group__29660);
            rule__Scanner_CharacterRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__2"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4831:1: rule__Scanner_CharacterRule__Group__2__Impl : ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) ) ;
    public final void rule__Scanner_CharacterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4835:1: ( ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4836:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4836:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4837:1: ( rule__Scanner_CharacterRule__CharactersAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4838:1: ( rule__Scanner_CharacterRule__CharactersAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4838:2: rule__Scanner_CharacterRule__CharactersAssignment_2
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_2_in_rule__Scanner_CharacterRule__Group__2__Impl9687);
            rule__Scanner_CharacterRule__CharactersAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__2__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4848:1: rule__Scanner_CharacterRule__Group__3 : rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4 ;
    public final void rule__Scanner_CharacterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4852:1: ( rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4853:2: rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__3__Impl_in_rule__Scanner_CharacterRule__Group__39717);
            rule__Scanner_CharacterRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__4_in_rule__Scanner_CharacterRule__Group__39720);
            rule__Scanner_CharacterRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__3"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4860:1: rule__Scanner_CharacterRule__Group__3__Impl : ( ( rule__Scanner_CharacterRule__Group_3__0 )* ) ;
    public final void rule__Scanner_CharacterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4864:1: ( ( ( rule__Scanner_CharacterRule__Group_3__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4865:1: ( ( rule__Scanner_CharacterRule__Group_3__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4865:1: ( ( rule__Scanner_CharacterRule__Group_3__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4866:1: ( rule__Scanner_CharacterRule__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getGroup_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4867:1: ( rule__Scanner_CharacterRule__Group_3__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==33) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4867:2: rule__Scanner_CharacterRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__0_in_rule__Scanner_CharacterRule__Group__3__Impl9747);
            	    rule__Scanner_CharacterRule__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__3__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4877:1: rule__Scanner_CharacterRule__Group__4 : rule__Scanner_CharacterRule__Group__4__Impl ;
    public final void rule__Scanner_CharacterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4881:1: ( rule__Scanner_CharacterRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4882:2: rule__Scanner_CharacterRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__4__Impl_in_rule__Scanner_CharacterRule__Group__49778);
            rule__Scanner_CharacterRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__4"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4888:1: rule__Scanner_CharacterRule__Group__4__Impl : ( ']' ) ;
    public final void rule__Scanner_CharacterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4892:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4893:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4893:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4894:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,32,FOLLOW_32_in_rule__Scanner_CharacterRule__Group__4__Impl9806); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getRightSquareBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__4__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group_3__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4917:1: rule__Scanner_CharacterRule__Group_3__0 : rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1 ;
    public final void rule__Scanner_CharacterRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4921:1: ( rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4922:2: rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__0__Impl_in_rule__Scanner_CharacterRule__Group_3__09847);
            rule__Scanner_CharacterRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__1_in_rule__Scanner_CharacterRule__Group_3__09850);
            rule__Scanner_CharacterRule__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group_3__0"


    // $ANTLR start "rule__Scanner_CharacterRule__Group_3__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4929:1: rule__Scanner_CharacterRule__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Scanner_CharacterRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4933:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4934:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4934:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4935:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0()); 
            }
            match(input,33,FOLLOW_33_in_rule__Scanner_CharacterRule__Group_3__0__Impl9878); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group_3__0__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group_3__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4948:1: rule__Scanner_CharacterRule__Group_3__1 : rule__Scanner_CharacterRule__Group_3__1__Impl ;
    public final void rule__Scanner_CharacterRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4952:1: ( rule__Scanner_CharacterRule__Group_3__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4953:2: rule__Scanner_CharacterRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__1__Impl_in_rule__Scanner_CharacterRule__Group_3__19909);
            rule__Scanner_CharacterRule__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group_3__1"


    // $ANTLR start "rule__Scanner_CharacterRule__Group_3__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4959:1: rule__Scanner_CharacterRule__Group_3__1__Impl : ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) ) ;
    public final void rule__Scanner_CharacterRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4963:1: ( ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4964:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4964:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4965:1: ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_3_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4966:1: ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4966:2: rule__Scanner_CharacterRule__CharactersAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_3_1_in_rule__Scanner_CharacterRule__Group_3__1__Impl9936);
            rule__Scanner_CharacterRule__CharactersAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group_3__1__Impl"


    // $ANTLR start "rule__Scanner_JSRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4980:1: rule__Scanner_JSRule__Group__0 : rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1 ;
    public final void rule__Scanner_JSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4984:1: ( rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4985:2: rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__0__Impl_in_rule__Scanner_JSRule__Group__09970);
            rule__Scanner_JSRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__1_in_rule__Scanner_JSRule__Group__09973);
            rule__Scanner_JSRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__Group__0"


    // $ANTLR start "rule__Scanner_JSRule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4992:1: rule__Scanner_JSRule__Group__0__Impl : ( 'script' ) ;
    public final void rule__Scanner_JSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4996:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4997:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4997:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4998:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__Scanner_JSRule__Group__0__Impl10001); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__Group__0__Impl"


    // $ANTLR start "rule__Scanner_JSRule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5011:1: rule__Scanner_JSRule__Group__1 : rule__Scanner_JSRule__Group__1__Impl ;
    public final void rule__Scanner_JSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5015:1: ( rule__Scanner_JSRule__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5016:2: rule__Scanner_JSRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__1__Impl_in_rule__Scanner_JSRule__Group__110032);
            rule__Scanner_JSRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__Group__1"


    // $ANTLR start "rule__Scanner_JSRule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5022:1: rule__Scanner_JSRule__Group__1__Impl : ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) ) ;
    public final void rule__Scanner_JSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5026:1: ( ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5027:1: ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5027:1: ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5028:1: ( rule__Scanner_JSRule__FileURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getFileURIAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5029:1: ( rule__Scanner_JSRule__FileURIAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5029:2: rule__Scanner_JSRule__FileURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__FileURIAssignment_1_in_rule__Scanner_JSRule__Group__1__Impl10059);
            rule__Scanner_JSRule__FileURIAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleAccess().getFileURIAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__Group__1__Impl"


    // $ANTLR start "rule__WhitespaceRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5043:1: rule__WhitespaceRule__Group__0 : rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1 ;
    public final void rule__WhitespaceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5047:1: ( rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5048:2: rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__0__Impl_in_rule__WhitespaceRule__Group__010093);
            rule__WhitespaceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__1_in_rule__WhitespaceRule__Group__010096);
            rule__WhitespaceRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group__0"


    // $ANTLR start "rule__WhitespaceRule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5055:1: rule__WhitespaceRule__Group__0__Impl : ( 'whitespace' ) ;
    public final void rule__WhitespaceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5059:1: ( ( 'whitespace' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5060:1: ( 'whitespace' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5060:1: ( 'whitespace' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5061:1: 'whitespace'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getWhitespaceKeyword_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__WhitespaceRule__Group__0__Impl10124); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getWhitespaceKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group__0__Impl"


    // $ANTLR start "rule__WhitespaceRule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5074:1: rule__WhitespaceRule__Group__1 : rule__WhitespaceRule__Group__1__Impl ;
    public final void rule__WhitespaceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5078:1: ( rule__WhitespaceRule__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5079:2: rule__WhitespaceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__1__Impl_in_rule__WhitespaceRule__Group__110155);
            rule__WhitespaceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group__1"


    // $ANTLR start "rule__WhitespaceRule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5085:1: rule__WhitespaceRule__Group__1__Impl : ( ( rule__WhitespaceRule__Alternatives_1 ) ) ;
    public final void rule__WhitespaceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5089:1: ( ( ( rule__WhitespaceRule__Alternatives_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5090:1: ( ( rule__WhitespaceRule__Alternatives_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5090:1: ( ( rule__WhitespaceRule__Alternatives_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5091:1: ( rule__WhitespaceRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5092:1: ( rule__WhitespaceRule__Alternatives_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5092:2: rule__WhitespaceRule__Alternatives_1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Alternatives_1_in_rule__WhitespaceRule__Group__1__Impl10182);
            rule__WhitespaceRule__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group__1__Impl"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5106:1: rule__WhitespaceRule__Group_1_0__0 : rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1 ;
    public final void rule__WhitespaceRule__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5110:1: ( rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5111:2: rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__0__Impl_in_rule__WhitespaceRule__Group_1_0__010216);
            rule__WhitespaceRule__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__1_in_rule__WhitespaceRule__Group_1_0__010219);
            rule__WhitespaceRule__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0__0"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5118:1: rule__WhitespaceRule__Group_1_0__0__Impl : ( '[' ) ;
    public final void rule__WhitespaceRule__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5122:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5123:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5123:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5124:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0()); 
            }
            match(input,31,FOLLOW_31_in_rule__WhitespaceRule__Group_1_0__0__Impl10247); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0__0__Impl"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5137:1: rule__WhitespaceRule__Group_1_0__1 : rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2 ;
    public final void rule__WhitespaceRule__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5141:1: ( rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5142:2: rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__1__Impl_in_rule__WhitespaceRule__Group_1_0__110278);
            rule__WhitespaceRule__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__2_in_rule__WhitespaceRule__Group_1_0__110281);
            rule__WhitespaceRule__Group_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0__1"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5149:1: rule__WhitespaceRule__Group_1_0__1__Impl : ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) ) ;
    public final void rule__WhitespaceRule__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5153:1: ( ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5154:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5154:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5155:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersAssignment_1_0_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5156:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5156:2: rule__WhitespaceRule__CharactersAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_1_in_rule__WhitespaceRule__Group_1_0__1__Impl10308);
            rule__WhitespaceRule__CharactersAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getCharactersAssignment_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0__1__Impl"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5166:1: rule__WhitespaceRule__Group_1_0__2 : rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3 ;
    public final void rule__WhitespaceRule__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5170:1: ( rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5171:2: rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__2__Impl_in_rule__WhitespaceRule__Group_1_0__210338);
            rule__WhitespaceRule__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__3_in_rule__WhitespaceRule__Group_1_0__210341);
            rule__WhitespaceRule__Group_1_0__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0__2"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5178:1: rule__WhitespaceRule__Group_1_0__2__Impl : ( ( rule__WhitespaceRule__Group_1_0_2__0 )* ) ;
    public final void rule__WhitespaceRule__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5182:1: ( ( ( rule__WhitespaceRule__Group_1_0_2__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5183:1: ( ( rule__WhitespaceRule__Group_1_0_2__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5183:1: ( ( rule__WhitespaceRule__Group_1_0_2__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5184:1: ( rule__WhitespaceRule__Group_1_0_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getGroup_1_0_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5185:1: ( rule__WhitespaceRule__Group_1_0_2__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==33) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5185:2: rule__WhitespaceRule__Group_1_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__0_in_rule__WhitespaceRule__Group_1_0__2__Impl10368);
            	    rule__WhitespaceRule__Group_1_0_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getGroup_1_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0__2__Impl"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5195:1: rule__WhitespaceRule__Group_1_0__3 : rule__WhitespaceRule__Group_1_0__3__Impl ;
    public final void rule__WhitespaceRule__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5199:1: ( rule__WhitespaceRule__Group_1_0__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5200:2: rule__WhitespaceRule__Group_1_0__3__Impl
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__3__Impl_in_rule__WhitespaceRule__Group_1_0__310399);
            rule__WhitespaceRule__Group_1_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0__3"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5206:1: rule__WhitespaceRule__Group_1_0__3__Impl : ( ']' ) ;
    public final void rule__WhitespaceRule__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5210:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5211:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5211:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5212:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3()); 
            }
            match(input,32,FOLLOW_32_in_rule__WhitespaceRule__Group_1_0__3__Impl10427); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0__3__Impl"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0_2__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5233:1: rule__WhitespaceRule__Group_1_0_2__0 : rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1 ;
    public final void rule__WhitespaceRule__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5237:1: ( rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5238:2: rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__0__Impl_in_rule__WhitespaceRule__Group_1_0_2__010466);
            rule__WhitespaceRule__Group_1_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__1_in_rule__WhitespaceRule__Group_1_0_2__010469);
            rule__WhitespaceRule__Group_1_0_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0_2__0"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0_2__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5245:1: rule__WhitespaceRule__Group_1_0_2__0__Impl : ( ',' ) ;
    public final void rule__WhitespaceRule__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5249:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5250:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5250:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5251:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCommaKeyword_1_0_2_0()); 
            }
            match(input,33,FOLLOW_33_in_rule__WhitespaceRule__Group_1_0_2__0__Impl10497); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getCommaKeyword_1_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0_2__0__Impl"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0_2__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5264:1: rule__WhitespaceRule__Group_1_0_2__1 : rule__WhitespaceRule__Group_1_0_2__1__Impl ;
    public final void rule__WhitespaceRule__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5268:1: ( rule__WhitespaceRule__Group_1_0_2__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5269:2: rule__WhitespaceRule__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__1__Impl_in_rule__WhitespaceRule__Group_1_0_2__110528);
            rule__WhitespaceRule__Group_1_0_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0_2__1"


    // $ANTLR start "rule__WhitespaceRule__Group_1_0_2__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5275:1: rule__WhitespaceRule__Group_1_0_2__1__Impl : ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) ) ;
    public final void rule__WhitespaceRule__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5279:1: ( ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5280:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5280:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5281:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersAssignment_1_0_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5282:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5282:2: rule__WhitespaceRule__CharactersAssignment_1_0_2_1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_2_1_in_rule__WhitespaceRule__Group_1_0_2__1__Impl10555);
            rule__WhitespaceRule__CharactersAssignment_1_0_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getCharactersAssignment_1_0_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__Group_1_0_2__1__Impl"


    // $ANTLR start "rule__Root__NameAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5297:1: rule__Root__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Root__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5301:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5302:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5302:1: ( ruleQualifiedName )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5303:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Root__NameAssignment_110594);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__NameAssignment_1"


    // $ANTLR start "rule__Root__ImportsAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5312:1: rule__Root__ImportsAssignment_2 : ( ruleImport ) ;
    public final void rule__Root__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5316:1: ( ( ruleImport ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5317:1: ( ruleImport )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5317:1: ( ruleImport )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5318:1: ruleImport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getImportsImportParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleImport_in_rule__Root__ImportsAssignment_210625);
            ruleImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootAccess().getImportsImportParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__ImportsAssignment_2"


    // $ANTLR start "rule__Root__LanguageDefinitionAssignment_3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5327:1: rule__Root__LanguageDefinitionAssignment_3 : ( ruleLanguageDef ) ;
    public final void rule__Root__LanguageDefinitionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5331:1: ( ( ruleLanguageDef ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5332:1: ( ruleLanguageDef )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5332:1: ( ruleLanguageDef )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5333:1: ruleLanguageDef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLanguageDefinitionLanguageDefParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleLanguageDef_in_rule__Root__LanguageDefinitionAssignment_310656);
            ruleLanguageDef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootAccess().getLanguageDefinitionLanguageDefParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__LanguageDefinitionAssignment_3"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5342:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildCard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5346:1: ( ( ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5347:1: ( ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5347:1: ( ruleQualifiedNameWithWildCard )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5348:1: ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_110687);
            ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__LanguageDef__NameAssignment_0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5357:1: rule__LanguageDef__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__LanguageDef__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5361:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5362:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5362:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5363:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LanguageDef__NameAssignment_010718); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getNameIDTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__NameAssignment_0"


    // $ANTLR start "rule__LanguageDef__ParitioningAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5372:1: rule__LanguageDef__ParitioningAssignment_2 : ( ruleParitioning ) ;
    public final void rule__LanguageDef__ParitioningAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5376:1: ( ( ruleParitioning ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5377:1: ( ruleParitioning )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5377:1: ( ruleParitioning )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5378:1: ruleParitioning
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getParitioningParitioningParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleParitioning_in_rule__LanguageDef__ParitioningAssignment_210749);
            ruleParitioning();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getParitioningParitioningParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__ParitioningAssignment_2"


    // $ANTLR start "rule__LanguageDef__LexicalHighlightingAssignment_3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5387:1: rule__LanguageDef__LexicalHighlightingAssignment_3 : ( ruleLexicalHighlighting ) ;
    public final void rule__LanguageDef__LexicalHighlightingAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5391:1: ( ( ruleLexicalHighlighting ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5392:1: ( ruleLexicalHighlighting )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5392:1: ( ruleLexicalHighlighting )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5393:1: ruleLexicalHighlighting
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLexicalHighlightingLexicalHighlightingParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_rule__LanguageDef__LexicalHighlightingAssignment_310780);
            ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getLexicalHighlightingLexicalHighlightingParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__LexicalHighlightingAssignment_3"


    // $ANTLR start "rule__LanguageDef__IntegrationAssignment_4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5402:1: rule__LanguageDef__IntegrationAssignment_4 : ( ruleIntegration ) ;
    public final void rule__LanguageDef__IntegrationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5406:1: ( ( ruleIntegration ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5407:1: ( ruleIntegration )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5407:1: ( ruleIntegration )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5408:1: ruleIntegration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getIntegrationIntegrationParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleIntegration_in_rule__LanguageDef__IntegrationAssignment_410811);
            ruleIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefAccess().getIntegrationIntegrationParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageDef__IntegrationAssignment_4"


    // $ANTLR start "rule__Integration__CodeIntegrationListAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5417:1: rule__Integration__CodeIntegrationListAssignment_2 : ( ruleCodeIntegration ) ;
    public final void rule__Integration__CodeIntegrationListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5421:1: ( ( ruleCodeIntegration ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5422:1: ( ruleCodeIntegration )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5422:1: ( ruleCodeIntegration )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5423:1: ruleCodeIntegration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListCodeIntegrationParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleCodeIntegration_in_rule__Integration__CodeIntegrationListAssignment_210842);
            ruleCodeIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationAccess().getCodeIntegrationListCodeIntegrationParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integration__CodeIntegrationListAssignment_2"


    // $ANTLR start "rule__JavaFXIntegration__CodegenAssignment_3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5432:1: rule__JavaFXIntegration__CodegenAssignment_3 : ( ( 'codegeneration' ) ) ;
    public final void rule__JavaFXIntegration__CodegenAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5436:1: ( ( ( 'codegeneration' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5437:1: ( ( 'codegeneration' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5437:1: ( ( 'codegeneration' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5438:1: ( 'codegeneration' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenCodegenerationKeyword_3_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5439:1: ( 'codegeneration' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5440:1: 'codegeneration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenCodegenerationKeyword_3_0()); 
            }
            match(input,37,FOLLOW_37_in_rule__JavaFXIntegration__CodegenAssignment_310878); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getCodegenCodegenerationKeyword_3_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getCodegenCodegenerationKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__CodegenAssignment_3"


    // $ANTLR start "rule__JavaFXIntegration__E4Assignment_4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5455:1: rule__JavaFXIntegration__E4Assignment_4 : ( ( 'e4' ) ) ;
    public final void rule__JavaFXIntegration__E4Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5459:1: ( ( ( 'e4' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5460:1: ( ( 'e4' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5460:1: ( ( 'e4' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5461:1: ( 'e4' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getE4E4Keyword_4_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5462:1: ( 'e4' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5463:1: 'e4'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getE4E4Keyword_4_0()); 
            }
            match(input,38,FOLLOW_38_in_rule__JavaFXIntegration__E4Assignment_410922); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getE4E4Keyword_4_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getE4E4Keyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaFXIntegration__E4Assignment_4"


    // $ANTLR start "rule__SWTIntegration__CodegenAssignment_3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5478:1: rule__SWTIntegration__CodegenAssignment_3 : ( ( 'codegeneration' ) ) ;
    public final void rule__SWTIntegration__CodegenAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5482:1: ( ( ( 'codegeneration' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5483:1: ( ( 'codegeneration' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5483:1: ( ( 'codegeneration' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5484:1: ( 'codegeneration' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getCodegenCodegenerationKeyword_3_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5485:1: ( 'codegeneration' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5486:1: 'codegeneration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getCodegenCodegenerationKeyword_3_0()); 
            }
            match(input,37,FOLLOW_37_in_rule__SWTIntegration__CodegenAssignment_310966); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getCodegenCodegenerationKeyword_3_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getCodegenCodegenerationKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__CodegenAssignment_3"


    // $ANTLR start "rule__SWTIntegration__E4Assignment_4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5501:1: rule__SWTIntegration__E4Assignment_4 : ( ( 'e4' ) ) ;
    public final void rule__SWTIntegration__E4Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5505:1: ( ( ( 'e4' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5506:1: ( ( 'e4' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5506:1: ( ( 'e4' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5507:1: ( 'e4' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getE4E4Keyword_4_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5508:1: ( 'e4' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5509:1: 'e4'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSWTIntegrationAccess().getE4E4Keyword_4_0()); 
            }
            match(input,38,FOLLOW_38_in_rule__SWTIntegration__E4Assignment_411010); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getE4E4Keyword_4_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSWTIntegrationAccess().getE4E4Keyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SWTIntegration__E4Assignment_4"


    // $ANTLR start "rule__Paritioning__PartitionsAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5524:1: rule__Paritioning__PartitionsAssignment_2 : ( rulePartition ) ;
    public final void rule__Paritioning__PartitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5528:1: ( ( rulePartition ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5529:1: ( rulePartition )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5529:1: ( rulePartition )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5530:1: rulePartition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_rulePartition_in_rule__Paritioning__PartitionsAssignment_211049);
            rulePartition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__PartitionsAssignment_2"


    // $ANTLR start "rule__Paritioning__PartitionerAssignment_3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5539:1: rule__Paritioning__PartitionerAssignment_3 : ( rulePartitioner ) ;
    public final void rule__Paritioning__PartitionerAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5543:1: ( ( rulePartitioner ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5544:1: ( rulePartitioner )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5544:1: ( rulePartitioner )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5545:1: rulePartitioner
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_rulePartitioner_in_rule__Paritioning__PartitionerAssignment_311080);
            rulePartitioner();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioning__PartitionerAssignment_3"


    // $ANTLR start "rule__Partition__NameAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5554:1: rule__Partition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Partition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5558:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5559:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5559:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5560:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_111111); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition__NameAssignment_1"


    // $ANTLR start "rule__Paritioner_JS__ScriptURIAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5569:1: rule__Paritioner_JS__ScriptURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Paritioner_JS__ScriptURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5573:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5574:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5574:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5575:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptURISTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Paritioner_JS__ScriptURIAssignment_111142); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioner_JSAccess().getScriptURISTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paritioner_JS__ScriptURIAssignment_1"


    // $ANTLR start "rule__Partitioner_Rule__RuleListAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5584:1: rule__Partitioner_Rule__RuleListAssignment_2 : ( rulePartition_Rule ) ;
    public final void rule__Partitioner_Rule__RuleListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5588:1: ( ( rulePartition_Rule ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5589:1: ( rulePartition_Rule )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5589:1: ( rulePartition_Rule )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5590:1: rulePartition_Rule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_rulePartition_Rule_in_rule__Partitioner_Rule__RuleListAssignment_211173);
            rulePartition_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partitioner_Rule__RuleListAssignment_2"


    // $ANTLR start "rule__Partition_SingleLineRule__ParitionAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5599:1: rule__Partition_SingleLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Partition_SingleLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5603:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5604:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5604:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5605:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5606:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5607:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition_SingleLineRule__ParitionAssignment_111208); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__ParitionAssignment_1"


    // $ANTLR start "rule__Partition_SingleLineRule__StartSeqAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5618:1: rule__Partition_SingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5622:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5623:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5623:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5624:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__StartSeqAssignment_211243); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__StartSeqAssignment_2"


    // $ANTLR start "rule__Partition_SingleLineRule__EndSeqAssignment_4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5633:1: rule__Partition_SingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5637:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5638:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5638:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5639:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EndSeqAssignment_411274); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__EndSeqAssignment_4"


    // $ANTLR start "rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5648:1: rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5652:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5653:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5653:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5654:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_211305); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2"


    // $ANTLR start "rule__Partition_MultiLineRule__ParitionAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5663:1: rule__Partition_MultiLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Partition_MultiLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5667:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5668:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5668:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5669:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5670:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5671:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition_MultiLineRule__ParitionAssignment_111340); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__ParitionAssignment_1"


    // $ANTLR start "rule__Partition_MultiLineRule__StartSeqAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5682:1: rule__Partition_MultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5686:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5687:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5687:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5688:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__StartSeqAssignment_211375); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__StartSeqAssignment_2"


    // $ANTLR start "rule__Partition_MultiLineRule__EndSeqAssignment_4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5697:1: rule__Partition_MultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5701:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5702:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5702:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5703:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EndSeqAssignment_411406); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__EndSeqAssignment_4"


    // $ANTLR start "rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5712:1: rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5716:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5717:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5717:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5718:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_211437); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2"


    // $ANTLR start "rule__LexicalHighlighting__ListAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5727:1: rule__LexicalHighlighting__ListAssignment_2 : ( ruleLexicalPartitionHighlighting ) ;
    public final void rule__LexicalHighlighting__ListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5731:1: ( ( ruleLexicalPartitionHighlighting ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5732:1: ( ruleLexicalPartitionHighlighting )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5732:1: ( ruleLexicalPartitionHighlighting )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5733:1: ruleLexicalPartitionHighlighting
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_rule__LexicalHighlighting__ListAssignment_211468);
            ruleLexicalPartitionHighlighting();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__ListAssignment_2"


    // $ANTLR start "rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5742:1: rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5746:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5747:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5747:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5748:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5749:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5750:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_111503); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1"


    // $ANTLR start "rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5761:1: rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5765:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5766:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5766:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5767:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURISTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_211538); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURISTRINGTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5776:1: rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5780:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5781:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5781:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5782:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5783:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5784:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_111573); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5795:1: rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 : ( ruleWhitespaceRule ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5799:1: ( ( ruleWhitespaceRule ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5800:1: ( ruleWhitespaceRule )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5800:1: ( ruleWhitespaceRule )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5801:1: ruleWhitespaceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceWhitespaceRuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleWhitespaceRule_in_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_211608);
            ruleWhitespaceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceWhitespaceRuleParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2"


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5810:1: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 : ( ruleToken ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5814:1: ( ( ruleToken ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5815:1: ( ruleToken )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5815:1: ( ruleToken )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5816:1: ruleToken
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleToken_in_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_411639);
            ruleToken();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4"


    // $ANTLR start "rule__Token__DefaultAssignment_0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5825:1: rule__Token__DefaultAssignment_0 : ( ( 'default' ) ) ;
    public final void rule__Token__DefaultAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5829:1: ( ( ( 'default' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5830:1: ( ( 'default' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5830:1: ( ( 'default' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5831:1: ( 'default' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5832:1: ( 'default' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5833:1: 'default'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            }
            match(input,39,FOLLOW_39_in_rule__Token__DefaultAssignment_011675); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__DefaultAssignment_0"


    // $ANTLR start "rule__Token__NameAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5848:1: rule__Token__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Token__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5852:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5853:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5853:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5854:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Token__NameAssignment_111714); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__NameAssignment_1"


    // $ANTLR start "rule__Token__ScannerListAssignment_2_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5863:1: rule__Token__ScannerListAssignment_2_1 : ( ruleScanner ) ;
    public final void rule__Token__ScannerListAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5867:1: ( ( ruleScanner ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5868:1: ( ruleScanner )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5868:1: ( ruleScanner )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5869:1: ruleScanner
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleScanner_in_rule__Token__ScannerListAssignment_2_111745);
            ruleScanner();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__ScannerListAssignment_2_1"


    // $ANTLR start "rule__Scanner_Keyword__KeywordsAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5878:1: rule__Scanner_Keyword__KeywordsAssignment_2 : ( ruleKeyword ) ;
    public final void rule__Scanner_Keyword__KeywordsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5882:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5883:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5883:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5884:1: ruleKeyword
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_211776);
            ruleKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__KeywordsAssignment_2"


    // $ANTLR start "rule__Scanner_Keyword__KeywordsAssignment_3_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5893:1: rule__Scanner_Keyword__KeywordsAssignment_3_1 : ( ruleKeyword ) ;
    public final void rule__Scanner_Keyword__KeywordsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5897:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5898:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5898:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5899:1: ruleKeyword
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_3_111807);
            ruleKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_Keyword__KeywordsAssignment_3_1"


    // $ANTLR start "rule__Keyword__NameAssignment_0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5908:1: rule__Keyword__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Keyword__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5912:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5913:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5913:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5914:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_011838); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__NameAssignment_0"


    // $ANTLR start "rule__Keyword__VersionAssignment_1_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5923:1: rule__Keyword__VersionAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Keyword__VersionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5927:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5928:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5928:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5929:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_111869); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__VersionAssignment_1_1"


    // $ANTLR start "rule__Scanner_SingleLineRule__StartSeqAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5938:1: rule__Scanner_SingleLineRule__StartSeqAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__StartSeqAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5942:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5943:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5943:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5944:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__StartSeqAssignment_111900); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__StartSeqAssignment_1"


    // $ANTLR start "rule__Scanner_SingleLineRule__EndSeqAssignment_3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5953:1: rule__Scanner_SingleLineRule__EndSeqAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__EndSeqAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5957:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5958:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5958:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5959:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EndSeqAssignment_311931); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__EndSeqAssignment_3"


    // $ANTLR start "rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5968:1: rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5972:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5973:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5973:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5974:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_211962); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2"


    // $ANTLR start "rule__Scanner_MultiLineRule__StartSeqAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5983:1: rule__Scanner_MultiLineRule__StartSeqAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__StartSeqAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5987:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5988:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5988:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5989:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__StartSeqAssignment_111993); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__StartSeqAssignment_1"


    // $ANTLR start "rule__Scanner_MultiLineRule__EndSeqAssignment_3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5998:1: rule__Scanner_MultiLineRule__EndSeqAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__EndSeqAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6002:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6003:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6003:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6004:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EndSeqAssignment_312024); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__EndSeqAssignment_3"


    // $ANTLR start "rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6013:1: rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6017:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6018:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6018:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6019:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_212055); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2"


    // $ANTLR start "rule__Scanner_CharacterRule__CharactersAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6028:1: rule__Scanner_CharacterRule__CharactersAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_CharacterRule__CharactersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6032:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6033:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6033:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6034:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_212086); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__CharactersAssignment_2"


    // $ANTLR start "rule__Scanner_CharacterRule__CharactersAssignment_3_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6043:1: rule__Scanner_CharacterRule__CharactersAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_CharacterRule__CharactersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6047:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6048:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6048:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6049:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_3_112117); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__CharactersAssignment_3_1"


    // $ANTLR start "rule__Scanner_JSRule__FileURIAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6058:1: rule__Scanner_JSRule__FileURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_JSRule__FileURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6062:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6063:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6063:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6064:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_JSRule__FileURIAssignment_112148); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__FileURIAssignment_1"


    // $ANTLR start "rule__WhitespaceRule__CharactersAssignment_1_0_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6073:1: rule__WhitespaceRule__CharactersAssignment_1_0_1 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__CharactersAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6077:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6078:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6078:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6079:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_112179); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__CharactersAssignment_1_0_1"


    // $ANTLR start "rule__WhitespaceRule__CharactersAssignment_1_0_2_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6088:1: rule__WhitespaceRule__CharactersAssignment_1_0_2_1 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__CharactersAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6092:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6093:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6093:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6094:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_2_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_2_112210); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__CharactersAssignment_1_0_2_1"


    // $ANTLR start "rule__WhitespaceRule__JavawhitespaceAssignment_1_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6103:1: rule__WhitespaceRule__JavawhitespaceAssignment_1_1 : ( ( 'javawhitespace' ) ) ;
    public final void rule__WhitespaceRule__JavawhitespaceAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6107:1: ( ( ( 'javawhitespace' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6108:1: ( ( 'javawhitespace' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6108:1: ( ( 'javawhitespace' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6109:1: ( 'javawhitespace' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6110:1: ( 'javawhitespace' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6111:1: 'javawhitespace'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            }
            match(input,40,FOLLOW_40_in_rule__WhitespaceRule__JavawhitespaceAssignment_1_112246); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__JavawhitespaceAssignment_1_1"


    // $ANTLR start "rule__WhitespaceRule__FileURIAssignment_1_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6126:1: rule__WhitespaceRule__FileURIAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__FileURIAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6130:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6131:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6131:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6132:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__WhitespaceRule__FileURIAssignment_1_212285); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhitespaceRule__FileURIAssignment_1_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__Group__0_in_ruleRoot100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__0_in_ruleQualifiedNameWithWildCard279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLanguageDef_in_entryRuleLanguageDef366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageDef373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__0_in_ruleLanguageDef399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegration_in_entryRuleIntegration426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegration433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__Group__0_in_ruleIntegration459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeIntegration_in_entryRuleCodeIntegration486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodeIntegration493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CodeIntegration__Alternatives_in_ruleCodeIntegration519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaFXIntegration_in_entryRuleJavaFXIntegration546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaFXIntegration553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__0_in_ruleJavaFXIntegration579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSWTIntegration_in_entryRuleSWTIntegration606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSWTIntegration613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__0_in_ruleSWTIntegration639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioning_in_entryRuleParitioning666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioning673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__0_in_ruleParitioning699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_entryRulePartition726 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__0_in_rulePartition759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_entryRulePartitioner786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner__Alternatives_in_rulePartitioner819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioner_JS853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__0_in_ruleParitioner_JS879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule906 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner_Rule913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__0_in_rulePartitioner_Rule939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule966 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_Rule973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_Rule__Alternatives_in_rulePartition_Rule999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule1026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_SingleLineRule1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__0_in_rulePartition_SingleLineRule1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule1086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_MultiLineRule1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__0_in_rulePartition_MultiLineRule1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting1146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalHighlighting1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__0_in_ruleLexicalHighlighting1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting1206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting__Alternatives_in_ruleLexicalPartitionHighlighting1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS1266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0_in_ruleLexicalPartitionHighlighting_JS1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule1326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0_in_ruleLexicalPartitionHighlighting_Rule1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_entryRuleToken1386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleToken1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__0_in_ruleToken1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_entryRuleScanner1446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__Alternatives_in_ruleScanner1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword1506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Keyword1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__0_in_ruleScanner_Keyword1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword1566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0_in_ruleKeyword1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule1626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Rule1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Rule__Alternatives_in_ruleScanner_Rule1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule1686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_SingleLineRule1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__0_in_ruleScanner_SingleLineRule1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule1746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_MultiLineRule1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__0_in_ruleScanner_MultiLineRule1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule1806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_CharacterRule1813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__0_in_ruleScanner_CharacterRule1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule1866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_JSRule1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__0_in_ruleScanner_JSRule1899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule1926 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhitespaceRule1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__0_in_ruleWhitespaceRule1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaFXIntegration_in_rule__CodeIntegration__Alternatives1995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSWTIntegration_in_rule__CodeIntegration__Alternatives2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_rule__Partitioner__Alternatives2044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_rule__Partitioner__Alternatives2061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_rule__Partition_Rule__Alternatives2093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_rule__Partition_Rule__Alternatives2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_rule__LexicalPartitionHighlighting__Alternatives2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_rule__LexicalPartitionHighlighting__Alternatives2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_rule__Scanner__Alternatives2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_rule__Scanner__Alternatives2208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_rule__Scanner_Rule__Alternatives2240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_rule__Scanner_Rule__Alternatives2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_rule__Scanner_Rule__Alternatives2274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_rule__Scanner_Rule__Alternatives2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__0_in_rule__WhitespaceRule__Alternatives_12323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__JavawhitespaceAssignment_1_1_in_rule__WhitespaceRule__Alternatives_12341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__FileURIAssignment_1_2_in_rule__WhitespaceRule__Alternatives_12359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__Group__0__Impl_in_rule__Root__Group__02390 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Root__Group__1_in_rule__Root__Group__02393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Root__Group__0__Impl2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__Group__1__Impl_in_rule__Root__Group__12452 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Root__Group__2_in_rule__Root__Group__12455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__NameAssignment_1_in_rule__Root__Group__1__Impl2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__Group__2__Impl_in_rule__Root__Group__22512 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Root__Group__3_in_rule__Root__Group__22515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__ImportsAssignment_2_in_rule__Root__Group__2__Impl2542 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Root__Group__3__Impl_in_rule__Root__Group__32573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__LanguageDefinitionAssignment_3_in_rule__Root__Group__3__Impl2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02638 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl2668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2724 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02759 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QualifiedName__Group_1__0__Impl2791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__0__Impl_in_rule__QualifiedNameWithWildCard__Group__02883 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__02886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__0__Impl2913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1__Impl_in_rule__QualifiedNameWithWildCard__Group__12942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0_in_rule__QualifiedNameWithWildCard__Group__1__Impl2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0__Impl_in_rule__QualifiedNameWithWildCard__Group_1__03004 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1_in_rule__QualifiedNameWithWildCard__Group_1__03007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QualifiedNameWithWildCard__Group_1__0__Impl3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1__Impl_in_rule__QualifiedNameWithWildCard__Group_1__13066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__QualifiedNameWithWildCard__Group_1__1__Impl3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03129 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Import__Group__0__Impl3160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__0__Impl_in_rule__LanguageDef__Group__03252 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__1_in_rule__LanguageDef__Group__03255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__NameAssignment_0_in_rule__LanguageDef__Group__0__Impl3282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__1__Impl_in_rule__LanguageDef__Group__13312 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__2_in_rule__LanguageDef__Group__13315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LanguageDef__Group__1__Impl3343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__2__Impl_in_rule__LanguageDef__Group__23374 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__3_in_rule__LanguageDef__Group__23377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__ParitioningAssignment_2_in_rule__LanguageDef__Group__2__Impl3404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__3__Impl_in_rule__LanguageDef__Group__33434 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__4_in_rule__LanguageDef__Group__33437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__LexicalHighlightingAssignment_3_in_rule__LanguageDef__Group__3__Impl3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__4__Impl_in_rule__LanguageDef__Group__43494 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__5_in_rule__LanguageDef__Group__43497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__IntegrationAssignment_4_in_rule__LanguageDef__Group__4__Impl3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__5__Impl_in_rule__LanguageDef__Group__53555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LanguageDef__Group__5__Impl3583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__Group__0__Impl_in_rule__Integration__Group__03626 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Integration__Group__1_in_rule__Integration__Group__03629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Integration__Group__0__Impl3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__Group__1__Impl_in_rule__Integration__Group__13688 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_rule__Integration__Group__2_in_rule__Integration__Group__13691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Integration__Group__1__Impl3719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__Group__2__Impl_in_rule__Integration__Group__23750 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Integration__Group__3_in_rule__Integration__Group__23753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl3782 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl3794 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_rule__Integration__Group__3__Impl_in_rule__Integration__Group__33827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Integration__Group__3__Impl3855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__0__Impl_in_rule__JavaFXIntegration__Group__03894 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__1_in_rule__JavaFXIntegration__Group__03897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__JavaFXIntegration__Group__0__Impl3925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__1__Impl_in_rule__JavaFXIntegration__Group__13956 = new BitSet(new long[]{0x0000006000010000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__2_in_rule__JavaFXIntegration__Group__13959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JavaFXIntegration__Group__1__Impl3987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__2__Impl_in_rule__JavaFXIntegration__Group__24018 = new BitSet(new long[]{0x0000006000010000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__3_in_rule__JavaFXIntegration__Group__24021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__3__Impl_in_rule__JavaFXIntegration__Group__34079 = new BitSet(new long[]{0x0000006000010000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__4_in_rule__JavaFXIntegration__Group__34082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__CodegenAssignment_3_in_rule__JavaFXIntegration__Group__3__Impl4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__4__Impl_in_rule__JavaFXIntegration__Group__44140 = new BitSet(new long[]{0x0000006000010000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__5_in_rule__JavaFXIntegration__Group__44143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__E4Assignment_4_in_rule__JavaFXIntegration__Group__4__Impl4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__5__Impl_in_rule__JavaFXIntegration__Group__54201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JavaFXIntegration__Group__5__Impl4229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__0__Impl_in_rule__SWTIntegration__Group__04272 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__1_in_rule__SWTIntegration__Group__04275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__SWTIntegration__Group__0__Impl4303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__1__Impl_in_rule__SWTIntegration__Group__14334 = new BitSet(new long[]{0x0000006000010000L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__2_in_rule__SWTIntegration__Group__14337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__SWTIntegration__Group__1__Impl4365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__2__Impl_in_rule__SWTIntegration__Group__24396 = new BitSet(new long[]{0x0000006000010000L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__3_in_rule__SWTIntegration__Group__24399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__3__Impl_in_rule__SWTIntegration__Group__34457 = new BitSet(new long[]{0x0000006000010000L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__4_in_rule__SWTIntegration__Group__34460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SWTIntegration__CodegenAssignment_3_in_rule__SWTIntegration__Group__3__Impl4487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__4__Impl_in_rule__SWTIntegration__Group__44518 = new BitSet(new long[]{0x0000006000010000L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__5_in_rule__SWTIntegration__Group__44521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SWTIntegration__E4Assignment_4_in_rule__SWTIntegration__Group__4__Impl4548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SWTIntegration__Group__5__Impl_in_rule__SWTIntegration__Group__54579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SWTIntegration__Group__5__Impl4607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__0__Impl_in_rule__Paritioning__Group__04650 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__1_in_rule__Paritioning__Group__04653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Paritioning__Group__0__Impl4681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__1__Impl_in_rule__Paritioning__Group__14712 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__2_in_rule__Paritioning__Group__14715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Paritioning__Group__1__Impl4743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__2__Impl_in_rule__Paritioning__Group__24774 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__3_in_rule__Paritioning__Group__24777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl4806 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl4818 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__3__Impl_in_rule__Paritioning__Group__34851 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__4_in_rule__Paritioning__Group__34854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionerAssignment_3_in_rule__Paritioning__Group__3__Impl4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__4__Impl_in_rule__Paritioning__Group__44911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Paritioning__Group__4__Impl4939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__04980 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__04983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Partition__Group__0__Impl5011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__15042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl5069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__0__Impl_in_rule__Paritioner_JS__Group__05103 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__1_in_rule__Paritioner_JS__Group__05106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Paritioner_JS__Group__0__Impl5134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__1__Impl_in_rule__Paritioner_JS__Group__15165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__ScriptURIAssignment_1_in_rule__Paritioner_JS__Group__1__Impl5192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__0__Impl_in_rule__Partitioner_Rule__Group__05226 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__1_in_rule__Partitioner_Rule__Group__05229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Partitioner_Rule__Group__0__Impl5257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__1__Impl_in_rule__Partitioner_Rule__Group__15288 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__2_in_rule__Partitioner_Rule__Group__15291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Partitioner_Rule__Group__1__Impl5319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__2__Impl_in_rule__Partitioner_Rule__Group__25350 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__3_in_rule__Partitioner_Rule__Group__25353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl5382 = new BitSet(new long[]{0x0000000011000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl5394 = new BitSet(new long[]{0x0000000011000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__3__Impl_in_rule__Partitioner_Rule__Group__35427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Partitioner_Rule__Group__3__Impl5455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__0__Impl_in_rule__Partition_SingleLineRule__Group__05494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__1_in_rule__Partition_SingleLineRule__Group__05497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Partition_SingleLineRule__Group__0__Impl5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__1__Impl_in_rule__Partition_SingleLineRule__Group__15556 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__2_in_rule__Partition_SingleLineRule__Group__15559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__ParitionAssignment_1_in_rule__Partition_SingleLineRule__Group__1__Impl5586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__2__Impl_in_rule__Partition_SingleLineRule__Group__25616 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__3_in_rule__Partition_SingleLineRule__Group__25619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__StartSeqAssignment_2_in_rule__Partition_SingleLineRule__Group__2__Impl5646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__3__Impl_in_rule__Partition_SingleLineRule__Group__35676 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__4_in_rule__Partition_SingleLineRule__Group__35679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Partition_SingleLineRule__Group__3__Impl5707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__4__Impl_in_rule__Partition_SingleLineRule__Group__45738 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__5_in_rule__Partition_SingleLineRule__Group__45741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__EndSeqAssignment_4_in_rule__Partition_SingleLineRule__Group__4__Impl5768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__5__Impl_in_rule__Partition_SingleLineRule__Group__55799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__0_in_rule__Partition_SingleLineRule__Group__5__Impl5826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__0__Impl_in_rule__Partition_SingleLineRule__Group_5__05869 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__1_in_rule__Partition_SingleLineRule__Group_5__05872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Partition_SingleLineRule__Group_5__0__Impl5900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__1__Impl_in_rule__Partition_SingleLineRule__Group_5__15931 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__2_in_rule__Partition_SingleLineRule__Group_5__15934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Partition_SingleLineRule__Group_5__1__Impl5962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__2__Impl_in_rule__Partition_SingleLineRule__Group_5__25993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_SingleLineRule__Group_5__2__Impl6020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__0__Impl_in_rule__Partition_MultiLineRule__Group__06056 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__1_in_rule__Partition_MultiLineRule__Group__06059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Partition_MultiLineRule__Group__0__Impl6087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__1__Impl_in_rule__Partition_MultiLineRule__Group__16118 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__2_in_rule__Partition_MultiLineRule__Group__16121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__ParitionAssignment_1_in_rule__Partition_MultiLineRule__Group__1__Impl6148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__2__Impl_in_rule__Partition_MultiLineRule__Group__26178 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__3_in_rule__Partition_MultiLineRule__Group__26181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__StartSeqAssignment_2_in_rule__Partition_MultiLineRule__Group__2__Impl6208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__3__Impl_in_rule__Partition_MultiLineRule__Group__36238 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__4_in_rule__Partition_MultiLineRule__Group__36241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Partition_MultiLineRule__Group__3__Impl6269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__4__Impl_in_rule__Partition_MultiLineRule__Group__46300 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__5_in_rule__Partition_MultiLineRule__Group__46303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__EndSeqAssignment_4_in_rule__Partition_MultiLineRule__Group__4__Impl6330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__5__Impl_in_rule__Partition_MultiLineRule__Group__56360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__0_in_rule__Partition_MultiLineRule__Group__5__Impl6387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__0__Impl_in_rule__Partition_MultiLineRule__Group_5__06430 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__1_in_rule__Partition_MultiLineRule__Group_5__06433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Partition_MultiLineRule__Group_5__0__Impl6461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__1__Impl_in_rule__Partition_MultiLineRule__Group_5__16492 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__2_in_rule__Partition_MultiLineRule__Group_5__16495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Partition_MultiLineRule__Group_5__1__Impl6523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__2__Impl_in_rule__Partition_MultiLineRule__Group_5__26554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_MultiLineRule__Group_5__2__Impl6581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__0__Impl_in_rule__LexicalHighlighting__Group__06617 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__1_in_rule__LexicalHighlighting__Group__06620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__LexicalHighlighting__Group__0__Impl6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__1__Impl_in_rule__LexicalHighlighting__Group__16679 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__2_in_rule__LexicalHighlighting__Group__16682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LexicalHighlighting__Group__1__Impl6710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__2__Impl_in_rule__LexicalHighlighting__Group__26741 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__3_in_rule__LexicalHighlighting__Group__26744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl6773 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl6785 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__3__Impl_in_rule__LexicalHighlighting__Group__36818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LexicalHighlighting__Group__3__Impl6846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__06885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1_in_rule__LexicalPartitionHighlighting_JS__Group__06888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__LexicalPartitionHighlighting_JS__Group__0__Impl6916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__16947 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2_in_rule__LexicalPartitionHighlighting_JS__Group__16950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_JS__Group__1__Impl6977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__27007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2_in_rule__LexicalPartitionHighlighting_JS__Group__2__Impl7034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__07070 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1_in_rule__LexicalPartitionHighlighting_Rule__Group__07073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl7101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__17132 = new BitSet(new long[]{0x0000001000008000L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2_in_rule__LexicalPartitionHighlighting_Rule__Group__17135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl7162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__27192 = new BitSet(new long[]{0x0000001000008000L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3_in_rule__LexicalPartitionHighlighting_Rule__Group__27195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2_in_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl7222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__37253 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4_in_rule__LexicalPartitionHighlighting_Rule__Group__37256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl7284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__47315 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5_in_rule__LexicalPartitionHighlighting_Rule__Group__47318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl7347 = new BitSet(new long[]{0x0000008000000012L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl7359 = new BitSet(new long[]{0x0000008000000012L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__57392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl7420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__0__Impl_in_rule__Token__Group__07463 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_rule__Token__Group__1_in_rule__Token__Group__07466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__DefaultAssignment_0_in_rule__Token__Group__0__Impl7493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__1__Impl_in_rule__Token__Group__17524 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Token__Group__2_in_rule__Token__Group__17527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__NameAssignment_1_in_rule__Token__Group__1__Impl7554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__2__Impl_in_rule__Token__Group__27584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__0_in_rule__Token__Group__2__Impl7611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__0__Impl_in_rule__Token__Group_2__07648 = new BitSet(new long[]{0x0000000851400000L});
    public static final BitSet FOLLOW_rule__Token__Group_2__1_in_rule__Token__Group_2__07651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Token__Group_2__0__Impl7679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__1__Impl_in_rule__Token__Group_2__17710 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Token__Group_2__2_in_rule__Token__Group_2__17713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl7742 = new BitSet(new long[]{0x0000000851400002L});
    public static final BitSet FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl7754 = new BitSet(new long[]{0x0000000851400002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__2__Impl_in_rule__Token__Group_2__27787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Token__Group_2__2__Impl7815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__0__Impl_in_rule__Scanner_Keyword__Group__07852 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__1_in_rule__Scanner_Keyword__Group__07855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Scanner_Keyword__Group__0__Impl7883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__1__Impl_in_rule__Scanner_Keyword__Group__17914 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__2_in_rule__Scanner_Keyword__Group__17917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Scanner_Keyword__Group__1__Impl7945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__2__Impl_in_rule__Scanner_Keyword__Group__27976 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__3_in_rule__Scanner_Keyword__Group__27979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_2_in_rule__Scanner_Keyword__Group__2__Impl8006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__3__Impl_in_rule__Scanner_Keyword__Group__38036 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__4_in_rule__Scanner_Keyword__Group__38039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__0_in_rule__Scanner_Keyword__Group__3__Impl8066 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__4__Impl_in_rule__Scanner_Keyword__Group__48097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Scanner_Keyword__Group__4__Impl8125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__0__Impl_in_rule__Scanner_Keyword__Group_3__08166 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__1_in_rule__Scanner_Keyword__Group_3__08169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Scanner_Keyword__Group_3__0__Impl8197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__1__Impl_in_rule__Scanner_Keyword__Group_3__18228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_3_1_in_rule__Scanner_Keyword__Group_3__1__Impl8255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__08289 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__08292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl8319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__18349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl8376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__08411 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__08414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Keyword__Group_1__0__Impl8442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__18473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl8500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__0__Impl_in_rule__Scanner_SingleLineRule__Group__08534 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__1_in_rule__Scanner_SingleLineRule__Group__08537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Scanner_SingleLineRule__Group__0__Impl8565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__1__Impl_in_rule__Scanner_SingleLineRule__Group__18596 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__2_in_rule__Scanner_SingleLineRule__Group__18599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__StartSeqAssignment_1_in_rule__Scanner_SingleLineRule__Group__1__Impl8626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__2__Impl_in_rule__Scanner_SingleLineRule__Group__28656 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__3_in_rule__Scanner_SingleLineRule__Group__28659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Scanner_SingleLineRule__Group__2__Impl8687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__3__Impl_in_rule__Scanner_SingleLineRule__Group__38718 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__4_in_rule__Scanner_SingleLineRule__Group__38721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__EndSeqAssignment_3_in_rule__Scanner_SingleLineRule__Group__3__Impl8748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__4__Impl_in_rule__Scanner_SingleLineRule__Group__48779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__0_in_rule__Scanner_SingleLineRule__Group__4__Impl8806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__0__Impl_in_rule__Scanner_SingleLineRule__Group_4__08847 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__1_in_rule__Scanner_SingleLineRule__Group_4__08850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Scanner_SingleLineRule__Group_4__0__Impl8878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__1__Impl_in_rule__Scanner_SingleLineRule__Group_4__18909 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__2_in_rule__Scanner_SingleLineRule__Group_4__18912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Scanner_SingleLineRule__Group_4__1__Impl8940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__2__Impl_in_rule__Scanner_SingleLineRule__Group_4__28971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_SingleLineRule__Group_4__2__Impl8998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__0__Impl_in_rule__Scanner_MultiLineRule__Group__09034 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__1_in_rule__Scanner_MultiLineRule__Group__09037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Scanner_MultiLineRule__Group__0__Impl9065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__1__Impl_in_rule__Scanner_MultiLineRule__Group__19096 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__2_in_rule__Scanner_MultiLineRule__Group__19099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__StartSeqAssignment_1_in_rule__Scanner_MultiLineRule__Group__1__Impl9126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__2__Impl_in_rule__Scanner_MultiLineRule__Group__29156 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__3_in_rule__Scanner_MultiLineRule__Group__29159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Scanner_MultiLineRule__Group__2__Impl9187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__3__Impl_in_rule__Scanner_MultiLineRule__Group__39218 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__4_in_rule__Scanner_MultiLineRule__Group__39221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__EndSeqAssignment_3_in_rule__Scanner_MultiLineRule__Group__3__Impl9248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__4__Impl_in_rule__Scanner_MultiLineRule__Group__49278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__0_in_rule__Scanner_MultiLineRule__Group__4__Impl9305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__0__Impl_in_rule__Scanner_MultiLineRule__Group_4__09346 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__1_in_rule__Scanner_MultiLineRule__Group_4__09349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Scanner_MultiLineRule__Group_4__0__Impl9377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__1__Impl_in_rule__Scanner_MultiLineRule__Group_4__19408 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__2_in_rule__Scanner_MultiLineRule__Group_4__19411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Scanner_MultiLineRule__Group_4__1__Impl9439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__2__Impl_in_rule__Scanner_MultiLineRule__Group_4__29470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_MultiLineRule__Group_4__2__Impl9497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__0__Impl_in_rule__Scanner_CharacterRule__Group__09533 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__1_in_rule__Scanner_CharacterRule__Group__09536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Scanner_CharacterRule__Group__0__Impl9564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__1__Impl_in_rule__Scanner_CharacterRule__Group__19595 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__2_in_rule__Scanner_CharacterRule__Group__19598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Scanner_CharacterRule__Group__1__Impl9626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__2__Impl_in_rule__Scanner_CharacterRule__Group__29657 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__3_in_rule__Scanner_CharacterRule__Group__29660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_2_in_rule__Scanner_CharacterRule__Group__2__Impl9687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__3__Impl_in_rule__Scanner_CharacterRule__Group__39717 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__4_in_rule__Scanner_CharacterRule__Group__39720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__0_in_rule__Scanner_CharacterRule__Group__3__Impl9747 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__4__Impl_in_rule__Scanner_CharacterRule__Group__49778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Scanner_CharacterRule__Group__4__Impl9806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__0__Impl_in_rule__Scanner_CharacterRule__Group_3__09847 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__1_in_rule__Scanner_CharacterRule__Group_3__09850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Scanner_CharacterRule__Group_3__0__Impl9878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__1__Impl_in_rule__Scanner_CharacterRule__Group_3__19909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_3_1_in_rule__Scanner_CharacterRule__Group_3__1__Impl9936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__0__Impl_in_rule__Scanner_JSRule__Group__09970 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__1_in_rule__Scanner_JSRule__Group__09973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Scanner_JSRule__Group__0__Impl10001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__1__Impl_in_rule__Scanner_JSRule__Group__110032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__FileURIAssignment_1_in_rule__Scanner_JSRule__Group__1__Impl10059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__0__Impl_in_rule__WhitespaceRule__Group__010093 = new BitSet(new long[]{0x0000010080000020L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__1_in_rule__WhitespaceRule__Group__010096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__WhitespaceRule__Group__0__Impl10124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__1__Impl_in_rule__WhitespaceRule__Group__110155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Alternatives_1_in_rule__WhitespaceRule__Group__1__Impl10182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__0__Impl_in_rule__WhitespaceRule__Group_1_0__010216 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__1_in_rule__WhitespaceRule__Group_1_0__010219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__WhitespaceRule__Group_1_0__0__Impl10247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__1__Impl_in_rule__WhitespaceRule__Group_1_0__110278 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__2_in_rule__WhitespaceRule__Group_1_0__110281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_1_in_rule__WhitespaceRule__Group_1_0__1__Impl10308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__2__Impl_in_rule__WhitespaceRule__Group_1_0__210338 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__3_in_rule__WhitespaceRule__Group_1_0__210341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__0_in_rule__WhitespaceRule__Group_1_0__2__Impl10368 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__3__Impl_in_rule__WhitespaceRule__Group_1_0__310399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__WhitespaceRule__Group_1_0__3__Impl10427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__0__Impl_in_rule__WhitespaceRule__Group_1_0_2__010466 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__1_in_rule__WhitespaceRule__Group_1_0_2__010469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__WhitespaceRule__Group_1_0_2__0__Impl10497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__1__Impl_in_rule__WhitespaceRule__Group_1_0_2__110528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_2_1_in_rule__WhitespaceRule__Group_1_0_2__1__Impl10555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Root__NameAssignment_110594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Root__ImportsAssignment_210625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLanguageDef_in_rule__Root__LanguageDefinitionAssignment_310656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_110687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LanguageDef__NameAssignment_010718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioning_in_rule__LanguageDef__ParitioningAssignment_210749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_rule__LanguageDef__LexicalHighlightingAssignment_310780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegration_in_rule__LanguageDef__IntegrationAssignment_410811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeIntegration_in_rule__Integration__CodeIntegrationListAssignment_210842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__JavaFXIntegration__CodegenAssignment_310878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__JavaFXIntegration__E4Assignment_410922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__SWTIntegration__CodegenAssignment_310966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__SWTIntegration__E4Assignment_411010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_rule__Paritioning__PartitionsAssignment_211049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_rule__Paritioning__PartitionerAssignment_311080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_111111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Paritioner_JS__ScriptURIAssignment_111142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_rule__Partitioner_Rule__RuleListAssignment_211173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition_SingleLineRule__ParitionAssignment_111208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__StartSeqAssignment_211243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EndSeqAssignment_411274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_211305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition_MultiLineRule__ParitionAssignment_111340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__StartSeqAssignment_211375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EndSeqAssignment_411406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_211437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_rule__LexicalHighlighting__ListAssignment_211468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_111503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_211538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_111573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_211608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_411639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Token__DefaultAssignment_011675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Token__NameAssignment_111714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_rule__Token__ScannerListAssignment_2_111745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_211776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_3_111807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_011838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_111869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__StartSeqAssignment_111900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EndSeqAssignment_311931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_211962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__StartSeqAssignment_111993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EndSeqAssignment_312024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_212055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_212086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_3_112117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_JSRule__FileURIAssignment_112148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_112179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_2_112210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__WhitespaceRule__JavawhitespaceAssignment_1_112246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__WhitespaceRule__FileURIAssignment_1_212285 = new BitSet(new long[]{0x0000000000000002L});

}