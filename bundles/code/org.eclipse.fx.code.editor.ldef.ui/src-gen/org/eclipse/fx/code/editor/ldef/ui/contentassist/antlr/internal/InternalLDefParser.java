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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'*'", "'import'", "'{'", "'}'", "'integration'", "'javafx'", "'java'", "'e4'", "':'", "'partitioning'", "'partition'", "'script'", "'rule'", "'single_line'", "'=>'", "'escaped'", "'by'", "'multi_line'", "'lexical_highlighting'", "'keywords'", "'['", "']'", "','", "'since'", "'pattern'", "'containing'", "'character'", "'whitespace'", "'default'", "'javawhitespace'"
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
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__42=42;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:266:1: ruleCodeIntegration : ( ruleJavaFXIntegration ) ;
    public final void ruleCodeIntegration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:270:2: ( ( ruleJavaFXIntegration ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:271:1: ( ruleJavaFXIntegration )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:271:1: ( ruleJavaFXIntegration )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:272:1: ruleJavaFXIntegration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCodeIntegrationAccess().getJavaFXIntegrationParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleJavaFXIntegration_in_ruleCodeIntegration519);
            ruleJavaFXIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCodeIntegrationAccess().getJavaFXIntegrationParserRuleCall()); 
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
            pushFollow(FOLLOW_ruleJavaFXIntegration_in_entryRuleJavaFXIntegration545);
            ruleJavaFXIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaFXIntegration552); if (state.failed) return ;

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
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__0_in_ruleJavaFXIntegration578);
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


    // $ANTLR start "entryRuleCodegeneration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:313:1: entryRuleCodegeneration : ruleCodegeneration EOF ;
    public final void entryRuleCodegeneration() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:314:1: ( ruleCodegeneration EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:315:1: ruleCodegeneration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCodegenerationRule()); 
            }
            pushFollow(FOLLOW_ruleCodegeneration_in_entryRuleCodegeneration605);
            ruleCodegeneration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCodegenerationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodegeneration612); if (state.failed) return ;

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
    // $ANTLR end "entryRuleCodegeneration"


    // $ANTLR start "ruleCodegeneration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:322:1: ruleCodegeneration : ( ( rule__Codegeneration__Alternatives ) ) ;
    public final void ruleCodegeneration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:326:2: ( ( ( rule__Codegeneration__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:327:1: ( ( rule__Codegeneration__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:327:1: ( ( rule__Codegeneration__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:328:1: ( rule__Codegeneration__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCodegenerationAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:329:1: ( rule__Codegeneration__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:329:2: rule__Codegeneration__Alternatives
            {
            pushFollow(FOLLOW_rule__Codegeneration__Alternatives_in_ruleCodegeneration638);
            rule__Codegeneration__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCodegenerationAccess().getAlternatives()); 
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
    // $ANTLR end "ruleCodegeneration"


    // $ANTLR start "entryRuleJavaCodeGeneration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:341:1: entryRuleJavaCodeGeneration : ruleJavaCodeGeneration EOF ;
    public final void entryRuleJavaCodeGeneration() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:342:1: ( ruleJavaCodeGeneration EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:343:1: ruleJavaCodeGeneration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationRule()); 
            }
            pushFollow(FOLLOW_ruleJavaCodeGeneration_in_entryRuleJavaCodeGeneration665);
            ruleJavaCodeGeneration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaCodeGeneration672); if (state.failed) return ;

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
    // $ANTLR end "entryRuleJavaCodeGeneration"


    // $ANTLR start "ruleJavaCodeGeneration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:350:1: ruleJavaCodeGeneration : ( ( rule__JavaCodeGeneration__Group__0 ) ) ;
    public final void ruleJavaCodeGeneration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:354:2: ( ( ( rule__JavaCodeGeneration__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:355:1: ( ( rule__JavaCodeGeneration__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:355:1: ( ( rule__JavaCodeGeneration__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:356:1: ( rule__JavaCodeGeneration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:357:1: ( rule__JavaCodeGeneration__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:357:2: rule__JavaCodeGeneration__Group__0
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group__0_in_ruleJavaCodeGeneration698);
            rule__JavaCodeGeneration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getGroup()); 
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
    // $ANTLR end "ruleJavaCodeGeneration"


    // $ANTLR start "entryRuleE4CodeGeneration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:369:1: entryRuleE4CodeGeneration : ruleE4CodeGeneration EOF ;
    public final void entryRuleE4CodeGeneration() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:370:1: ( ruleE4CodeGeneration EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:371:1: ruleE4CodeGeneration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationRule()); 
            }
            pushFollow(FOLLOW_ruleE4CodeGeneration_in_entryRuleE4CodeGeneration725);
            ruleE4CodeGeneration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleE4CodeGeneration732); if (state.failed) return ;

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
    // $ANTLR end "entryRuleE4CodeGeneration"


    // $ANTLR start "ruleE4CodeGeneration"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:378:1: ruleE4CodeGeneration : ( ( rule__E4CodeGeneration__Group__0 ) ) ;
    public final void ruleE4CodeGeneration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:382:2: ( ( ( rule__E4CodeGeneration__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:383:1: ( ( rule__E4CodeGeneration__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:383:1: ( ( rule__E4CodeGeneration__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:384:1: ( rule__E4CodeGeneration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:385:1: ( rule__E4CodeGeneration__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:385:2: rule__E4CodeGeneration__Group__0
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group__0_in_ruleE4CodeGeneration758);
            rule__E4CodeGeneration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getGroup()); 
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
    // $ANTLR end "ruleE4CodeGeneration"


    // $ANTLR start "entryRuleConfigValue"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:397:1: entryRuleConfigValue : ruleConfigValue EOF ;
    public final void entryRuleConfigValue() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:398:1: ( ruleConfigValue EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:399:1: ruleConfigValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueRule()); 
            }
            pushFollow(FOLLOW_ruleConfigValue_in_entryRuleConfigValue785);
            ruleConfigValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigValue792); if (state.failed) return ;

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
    // $ANTLR end "entryRuleConfigValue"


    // $ANTLR start "ruleConfigValue"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:406:1: ruleConfigValue : ( ( rule__ConfigValue__Group__0 ) ) ;
    public final void ruleConfigValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:410:2: ( ( ( rule__ConfigValue__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:411:1: ( ( rule__ConfigValue__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:411:1: ( ( rule__ConfigValue__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:412:1: ( rule__ConfigValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:413:1: ( rule__ConfigValue__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:413:2: rule__ConfigValue__Group__0
            {
            pushFollow(FOLLOW_rule__ConfigValue__Group__0_in_ruleConfigValue818);
            rule__ConfigValue__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getGroup()); 
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
    // $ANTLR end "ruleConfigValue"


    // $ANTLR start "entryRuleParitioning"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:425:1: entryRuleParitioning : ruleParitioning EOF ;
    public final void entryRuleParitioning() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:426:1: ( ruleParitioning EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:427:1: ruleParitioning EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningRule()); 
            }
            pushFollow(FOLLOW_ruleParitioning_in_entryRuleParitioning845);
            ruleParitioning();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioning852); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:434:1: ruleParitioning : ( ( rule__Paritioning__Group__0 ) ) ;
    public final void ruleParitioning() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:438:2: ( ( ( rule__Paritioning__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:439:1: ( ( rule__Paritioning__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:439:1: ( ( rule__Paritioning__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:440:1: ( rule__Paritioning__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:441:1: ( rule__Paritioning__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:441:2: rule__Paritioning__Group__0
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__0_in_ruleParitioning878);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:453:1: entryRulePartition : rulePartition EOF ;
    public final void entryRulePartition() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:454:1: ( rulePartition EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:455:1: rulePartition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionRule()); 
            }
            pushFollow(FOLLOW_rulePartition_in_entryRulePartition905);
            rulePartition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition912); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:462:1: rulePartition : ( ( rule__Partition__Group__0 ) ) ;
    public final void rulePartition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:466:2: ( ( ( rule__Partition__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:467:1: ( ( rule__Partition__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:467:1: ( ( rule__Partition__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:468:1: ( rule__Partition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:469:1: ( rule__Partition__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:469:2: rule__Partition__Group__0
            {
            pushFollow(FOLLOW_rule__Partition__Group__0_in_rulePartition938);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:481:1: entryRulePartitioner : rulePartitioner EOF ;
    public final void entryRulePartitioner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:482:1: ( rulePartitioner EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:483:1: rulePartitioner EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionerRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_in_entryRulePartitioner965);
            rulePartitioner();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionerRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner972); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:490:1: rulePartitioner : ( ( rule__Partitioner__Alternatives ) ) ;
    public final void rulePartitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:494:2: ( ( ( rule__Partitioner__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:495:1: ( ( rule__Partitioner__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:495:1: ( ( rule__Partitioner__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:496:1: ( rule__Partitioner__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionerAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:497:1: ( rule__Partitioner__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:497:2: rule__Partitioner__Alternatives
            {
            pushFollow(FOLLOW_rule__Partitioner__Alternatives_in_rulePartitioner998);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:509:1: entryRuleParitioner_JS : ruleParitioner_JS EOF ;
    public final void entryRuleParitioner_JS() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:510:1: ( ruleParitioner_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:511:1: ruleParitioner_JS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSRule()); 
            }
            pushFollow(FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS1025);
            ruleParitioner_JS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioner_JSRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioner_JS1032); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:518:1: ruleParitioner_JS : ( ( rule__Paritioner_JS__Group__0 ) ) ;
    public final void ruleParitioner_JS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:522:2: ( ( ( rule__Paritioner_JS__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:523:1: ( ( rule__Paritioner_JS__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:523:1: ( ( rule__Paritioner_JS__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:524:1: ( rule__Paritioner_JS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:525:1: ( rule__Paritioner_JS__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:525:2: rule__Paritioner_JS__Group__0
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__0_in_ruleParitioner_JS1058);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:537:1: entryRulePartitioner_Rule : rulePartitioner_Rule EOF ;
    public final void entryRulePartitioner_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:538:1: ( rulePartitioner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:539:1: rulePartitioner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule1085);
            rulePartitioner_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner_Rule1092); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:546:1: rulePartitioner_Rule : ( ( rule__Partitioner_Rule__Group__0 ) ) ;
    public final void rulePartitioner_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:550:2: ( ( ( rule__Partitioner_Rule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:551:1: ( ( rule__Partitioner_Rule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:551:1: ( ( rule__Partitioner_Rule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:552:1: ( rule__Partitioner_Rule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:553:1: ( rule__Partitioner_Rule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:553:2: rule__Partitioner_Rule__Group__0
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__0_in_rulePartitioner_Rule1118);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:565:1: entryRulePartition_Rule : rulePartition_Rule EOF ;
    public final void entryRulePartition_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:566:1: ( rulePartition_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:567:1: rulePartition_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule1145);
            rulePartition_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_Rule1152); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:574:1: rulePartition_Rule : ( ( rule__Partition_Rule__Alternatives ) ) ;
    public final void rulePartition_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:578:2: ( ( ( rule__Partition_Rule__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:579:1: ( ( rule__Partition_Rule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:579:1: ( ( rule__Partition_Rule__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:580:1: ( rule__Partition_Rule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_RuleAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:581:1: ( rule__Partition_Rule__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:581:2: rule__Partition_Rule__Alternatives
            {
            pushFollow(FOLLOW_rule__Partition_Rule__Alternatives_in_rulePartition_Rule1178);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:593:1: entryRulePartition_SingleLineRule : rulePartition_SingleLineRule EOF ;
    public final void entryRulePartition_SingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:594:1: ( rulePartition_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:595:1: rulePartition_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule1205);
            rulePartition_SingleLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_SingleLineRule1212); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:602:1: rulePartition_SingleLineRule : ( ( rule__Partition_SingleLineRule__Group__0 ) ) ;
    public final void rulePartition_SingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:606:2: ( ( ( rule__Partition_SingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:607:1: ( ( rule__Partition_SingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:607:1: ( ( rule__Partition_SingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:608:1: ( rule__Partition_SingleLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:609:1: ( rule__Partition_SingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:609:2: rule__Partition_SingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__0_in_rulePartition_SingleLineRule1238);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:621:1: entryRulePartition_MultiLineRule : rulePartition_MultiLineRule EOF ;
    public final void entryRulePartition_MultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:622:1: ( rulePartition_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:623:1: rulePartition_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule1265);
            rulePartition_MultiLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_MultiLineRule1272); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:630:1: rulePartition_MultiLineRule : ( ( rule__Partition_MultiLineRule__Group__0 ) ) ;
    public final void rulePartition_MultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:634:2: ( ( ( rule__Partition_MultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:635:1: ( ( rule__Partition_MultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:635:1: ( ( rule__Partition_MultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:636:1: ( rule__Partition_MultiLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:637:1: ( rule__Partition_MultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:637:2: rule__Partition_MultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__0_in_rulePartition_MultiLineRule1298);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:649:1: entryRuleLexicalHighlighting : ruleLexicalHighlighting EOF ;
    public final void entryRuleLexicalHighlighting() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:650:1: ( ruleLexicalHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:651:1: ruleLexicalHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting1325);
            ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalHighlighting1332); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:658:1: ruleLexicalHighlighting : ( ( rule__LexicalHighlighting__Group__0 ) ) ;
    public final void ruleLexicalHighlighting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:662:2: ( ( ( rule__LexicalHighlighting__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:663:1: ( ( rule__LexicalHighlighting__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:663:1: ( ( rule__LexicalHighlighting__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:664:1: ( rule__LexicalHighlighting__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:665:1: ( rule__LexicalHighlighting__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:665:2: rule__LexicalHighlighting__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__0_in_ruleLexicalHighlighting1358);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:677:1: entryRuleLexicalPartitionHighlighting : ruleLexicalPartitionHighlighting EOF ;
    public final void entryRuleLexicalPartitionHighlighting() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:678:1: ( ruleLexicalPartitionHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:679:1: ruleLexicalPartitionHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting1385);
            ruleLexicalPartitionHighlighting();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting1392); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:686:1: ruleLexicalPartitionHighlighting : ( ( rule__LexicalPartitionHighlighting__Alternatives ) ) ;
    public final void ruleLexicalPartitionHighlighting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:690:2: ( ( ( rule__LexicalPartitionHighlighting__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:691:1: ( ( rule__LexicalPartitionHighlighting__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:691:1: ( ( rule__LexicalPartitionHighlighting__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:692:1: ( rule__LexicalPartitionHighlighting__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlightingAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:693:1: ( rule__LexicalPartitionHighlighting__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:693:2: rule__LexicalPartitionHighlighting__Alternatives
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting__Alternatives_in_ruleLexicalPartitionHighlighting1418);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:705:1: entryRuleLexicalPartitionHighlighting_JS : ruleLexicalPartitionHighlighting_JS EOF ;
    public final void entryRuleLexicalPartitionHighlighting_JS() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:706:1: ( ruleLexicalPartitionHighlighting_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:707:1: ruleLexicalPartitionHighlighting_JS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS1445);
            ruleLexicalPartitionHighlighting_JS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS1452); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:714:1: ruleLexicalPartitionHighlighting_JS : ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) ) ;
    public final void ruleLexicalPartitionHighlighting_JS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:718:2: ( ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:719:1: ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:719:1: ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:720:1: ( rule__LexicalPartitionHighlighting_JS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:721:1: ( rule__LexicalPartitionHighlighting_JS__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:721:2: rule__LexicalPartitionHighlighting_JS__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0_in_ruleLexicalPartitionHighlighting_JS1478);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:733:1: entryRuleLexicalPartitionHighlighting_Rule : ruleLexicalPartitionHighlighting_Rule EOF ;
    public final void entryRuleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:734:1: ( ruleLexicalPartitionHighlighting_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:735:1: ruleLexicalPartitionHighlighting_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule1505);
            ruleLexicalPartitionHighlighting_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule1512); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:742:1: ruleLexicalPartitionHighlighting_Rule : ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) ) ;
    public final void ruleLexicalPartitionHighlighting_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:746:2: ( ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:747:1: ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:747:1: ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:748:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:749:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:749:2: rule__LexicalPartitionHighlighting_Rule__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0_in_ruleLexicalPartitionHighlighting_Rule1538);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:761:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:762:1: ( ruleToken EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:763:1: ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_ruleToken_in_entryRuleToken1565);
            ruleToken();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleToken1572); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:770:1: ruleToken : ( ( rule__Token__Group__0 ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:774:2: ( ( ( rule__Token__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:775:1: ( ( rule__Token__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:775:1: ( ( rule__Token__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:776:1: ( rule__Token__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:777:1: ( rule__Token__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:777:2: rule__Token__Group__0
            {
            pushFollow(FOLLOW_rule__Token__Group__0_in_ruleToken1598);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:789:1: entryRuleScanner : ruleScanner EOF ;
    public final void entryRuleScanner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:790:1: ( ruleScanner EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:791:1: ruleScanner EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScannerRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_in_entryRuleScanner1625);
            ruleScanner();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScannerRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner1632); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:798:1: ruleScanner : ( ( rule__Scanner__Alternatives ) ) ;
    public final void ruleScanner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:802:2: ( ( ( rule__Scanner__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:803:1: ( ( rule__Scanner__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:803:1: ( ( rule__Scanner__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:804:1: ( rule__Scanner__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScannerAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:805:1: ( rule__Scanner__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:805:2: rule__Scanner__Alternatives
            {
            pushFollow(FOLLOW_rule__Scanner__Alternatives_in_ruleScanner1658);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:817:1: entryRuleScanner_Keyword : ruleScanner_Keyword EOF ;
    public final void entryRuleScanner_Keyword() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:818:1: ( ruleScanner_Keyword EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:819:1: ruleScanner_Keyword EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword1685);
            ruleScanner_Keyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Keyword1692); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:826:1: ruleScanner_Keyword : ( ( rule__Scanner_Keyword__Group__0 ) ) ;
    public final void ruleScanner_Keyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:830:2: ( ( ( rule__Scanner_Keyword__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:831:1: ( ( rule__Scanner_Keyword__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:831:1: ( ( rule__Scanner_Keyword__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:832:1: ( rule__Scanner_Keyword__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:833:1: ( rule__Scanner_Keyword__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:833:2: rule__Scanner_Keyword__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__0_in_ruleScanner_Keyword1718);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:845:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:846:1: ( ruleKeyword EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:847:1: ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword1745);
            ruleKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword1752); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:854:1: ruleKeyword : ( ( rule__Keyword__Group__0 ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:858:2: ( ( ( rule__Keyword__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:859:1: ( ( rule__Keyword__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:859:1: ( ( rule__Keyword__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:860:1: ( rule__Keyword__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:861:1: ( rule__Keyword__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:861:2: rule__Keyword__Group__0
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0_in_ruleKeyword1778);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:873:1: entryRuleScanner_Rule : ruleScanner_Rule EOF ;
    public final void entryRuleScanner_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:874:1: ( ruleScanner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:875:1: ruleScanner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule1805);
            ruleScanner_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Rule1812); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:882:1: ruleScanner_Rule : ( ( rule__Scanner_Rule__Alternatives ) ) ;
    public final void ruleScanner_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:886:2: ( ( ( rule__Scanner_Rule__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:887:1: ( ( rule__Scanner_Rule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:887:1: ( ( rule__Scanner_Rule__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:888:1: ( rule__Scanner_Rule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_RuleAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:889:1: ( rule__Scanner_Rule__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:889:2: rule__Scanner_Rule__Alternatives
            {
            pushFollow(FOLLOW_rule__Scanner_Rule__Alternatives_in_ruleScanner_Rule1838);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:901:1: entryRuleScanner_SingleLineRule : ruleScanner_SingleLineRule EOF ;
    public final void entryRuleScanner_SingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:902:1: ( ruleScanner_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:903:1: ruleScanner_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule1865);
            ruleScanner_SingleLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_SingleLineRule1872); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:910:1: ruleScanner_SingleLineRule : ( ( rule__Scanner_SingleLineRule__Group__0 ) ) ;
    public final void ruleScanner_SingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:914:2: ( ( ( rule__Scanner_SingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:915:1: ( ( rule__Scanner_SingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:915:1: ( ( rule__Scanner_SingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:916:1: ( rule__Scanner_SingleLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:917:1: ( rule__Scanner_SingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:917:2: rule__Scanner_SingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__0_in_ruleScanner_SingleLineRule1898);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:929:1: entryRuleScanner_MultiLineRule : ruleScanner_MultiLineRule EOF ;
    public final void entryRuleScanner_MultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:930:1: ( ruleScanner_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:931:1: ruleScanner_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule1925);
            ruleScanner_MultiLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_MultiLineRule1932); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:938:1: ruleScanner_MultiLineRule : ( ( rule__Scanner_MultiLineRule__Group__0 ) ) ;
    public final void ruleScanner_MultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:942:2: ( ( ( rule__Scanner_MultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:943:1: ( ( rule__Scanner_MultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:943:1: ( ( rule__Scanner_MultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:944:1: ( rule__Scanner_MultiLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:945:1: ( rule__Scanner_MultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:945:2: rule__Scanner_MultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__0_in_ruleScanner_MultiLineRule1958);
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


    // $ANTLR start "entryRuleScanner_PatternRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:957:1: entryRuleScanner_PatternRule : ruleScanner_PatternRule EOF ;
    public final void entryRuleScanner_PatternRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:958:1: ( ruleScanner_PatternRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:959:1: ruleScanner_PatternRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_PatternRule_in_entryRuleScanner_PatternRule1985);
            ruleScanner_PatternRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_PatternRule1992); if (state.failed) return ;

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
    // $ANTLR end "entryRuleScanner_PatternRule"


    // $ANTLR start "ruleScanner_PatternRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:966:1: ruleScanner_PatternRule : ( ( rule__Scanner_PatternRule__Group__0 ) ) ;
    public final void ruleScanner_PatternRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:970:2: ( ( ( rule__Scanner_PatternRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:971:1: ( ( rule__Scanner_PatternRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:971:1: ( ( rule__Scanner_PatternRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:972:1: ( rule__Scanner_PatternRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:973:1: ( rule__Scanner_PatternRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:973:2: rule__Scanner_PatternRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_PatternRule__Group__0_in_ruleScanner_PatternRule2018);
            rule__Scanner_PatternRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getGroup()); 
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
    // $ANTLR end "ruleScanner_PatternRule"


    // $ANTLR start "entryRuleScanner_CharacterRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:985:1: entryRuleScanner_CharacterRule : ruleScanner_CharacterRule EOF ;
    public final void entryRuleScanner_CharacterRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:986:1: ( ruleScanner_CharacterRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:987:1: ruleScanner_CharacterRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule2045);
            ruleScanner_CharacterRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_CharacterRule2052); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:994:1: ruleScanner_CharacterRule : ( ( rule__Scanner_CharacterRule__Group__0 ) ) ;
    public final void ruleScanner_CharacterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:998:2: ( ( ( rule__Scanner_CharacterRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:999:1: ( ( rule__Scanner_CharacterRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:999:1: ( ( rule__Scanner_CharacterRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1000:1: ( rule__Scanner_CharacterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1001:1: ( rule__Scanner_CharacterRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1001:2: rule__Scanner_CharacterRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__0_in_ruleScanner_CharacterRule2078);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1013:1: entryRuleScanner_JSRule : ruleScanner_JSRule EOF ;
    public final void entryRuleScanner_JSRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1014:1: ( ruleScanner_JSRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1015:1: ruleScanner_JSRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule2105);
            ruleScanner_JSRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_JSRule2112); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1022:1: ruleScanner_JSRule : ( ( rule__Scanner_JSRule__Group__0 ) ) ;
    public final void ruleScanner_JSRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1026:2: ( ( ( rule__Scanner_JSRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1027:1: ( ( rule__Scanner_JSRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1027:1: ( ( rule__Scanner_JSRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1028:1: ( rule__Scanner_JSRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1029:1: ( rule__Scanner_JSRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1029:2: rule__Scanner_JSRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__0_in_ruleScanner_JSRule2138);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1041:1: entryRuleWhitespaceRule : ruleWhitespaceRule EOF ;
    public final void entryRuleWhitespaceRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1042:1: ( ruleWhitespaceRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1043:1: ruleWhitespaceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleRule()); 
            }
            pushFollow(FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule2165);
            ruleWhitespaceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhitespaceRule2172); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1050:1: ruleWhitespaceRule : ( ( rule__WhitespaceRule__Group__0 ) ) ;
    public final void ruleWhitespaceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1054:2: ( ( ( rule__WhitespaceRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1055:1: ( ( rule__WhitespaceRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1055:1: ( ( rule__WhitespaceRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1056:1: ( rule__WhitespaceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1057:1: ( rule__WhitespaceRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1057:2: rule__WhitespaceRule__Group__0
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__0_in_ruleWhitespaceRule2198);
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


    // $ANTLR start "rule__Codegeneration__Alternatives"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1069:1: rule__Codegeneration__Alternatives : ( ( ruleJavaCodeGeneration ) | ( ruleE4CodeGeneration ) );
    public final void rule__Codegeneration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1073:1: ( ( ruleJavaCodeGeneration ) | ( ruleE4CodeGeneration ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==19) ) {
                alt1=1;
            }
            else if ( (LA1_0==20) ) {
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1074:1: ( ruleJavaCodeGeneration )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1074:1: ( ruleJavaCodeGeneration )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1075:1: ruleJavaCodeGeneration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCodegenerationAccess().getJavaCodeGenerationParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleJavaCodeGeneration_in_rule__Codegeneration__Alternatives2234);
                    ruleJavaCodeGeneration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCodegenerationAccess().getJavaCodeGenerationParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1080:6: ( ruleE4CodeGeneration )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1080:6: ( ruleE4CodeGeneration )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1081:1: ruleE4CodeGeneration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCodegenerationAccess().getE4CodeGenerationParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleE4CodeGeneration_in_rule__Codegeneration__Alternatives2251);
                    ruleE4CodeGeneration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCodegenerationAccess().getE4CodeGenerationParserRuleCall_1()); 
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
    // $ANTLR end "rule__Codegeneration__Alternatives"


    // $ANTLR start "rule__ConfigValue__Alternatives_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1091:1: rule__ConfigValue__Alternatives_2 : ( ( ( rule__ConfigValue__SimpleValueAssignment_2_0 ) ) | ( ( rule__ConfigValue__Group_2_1__0 ) ) );
    public final void rule__ConfigValue__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1095:1: ( ( ( rule__ConfigValue__SimpleValueAssignment_2_0 ) ) | ( ( rule__ConfigValue__Group_2_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==15) ) {
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1096:1: ( ( rule__ConfigValue__SimpleValueAssignment_2_0 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1096:1: ( ( rule__ConfigValue__SimpleValueAssignment_2_0 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1097:1: ( rule__ConfigValue__SimpleValueAssignment_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigValueAccess().getSimpleValueAssignment_2_0()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1098:1: ( rule__ConfigValue__SimpleValueAssignment_2_0 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1098:2: rule__ConfigValue__SimpleValueAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__ConfigValue__SimpleValueAssignment_2_0_in_rule__ConfigValue__Alternatives_22283);
                    rule__ConfigValue__SimpleValueAssignment_2_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConfigValueAccess().getSimpleValueAssignment_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1102:6: ( ( rule__ConfigValue__Group_2_1__0 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1102:6: ( ( rule__ConfigValue__Group_2_1__0 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1103:1: ( rule__ConfigValue__Group_2_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigValueAccess().getGroup_2_1()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1104:1: ( rule__ConfigValue__Group_2_1__0 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1104:2: rule__ConfigValue__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__ConfigValue__Group_2_1__0_in_rule__ConfigValue__Alternatives_22301);
                    rule__ConfigValue__Group_2_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConfigValueAccess().getGroup_2_1()); 
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
    // $ANTLR end "rule__ConfigValue__Alternatives_2"


    // $ANTLR start "rule__Partitioner__Alternatives"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1113:1: rule__Partitioner__Alternatives : ( ( rulePartitioner_Rule ) | ( ruleParitioner_JS ) );
    public final void rule__Partitioner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1117:1: ( ( rulePartitioner_Rule ) | ( ruleParitioner_JS ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==25) ) {
                alt3=1;
            }
            else if ( (LA3_0==24) ) {
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1118:1: ( rulePartitioner_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1118:1: ( rulePartitioner_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1119:1: rulePartitioner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePartitioner_Rule_in_rule__Partitioner__Alternatives2334);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1124:6: ( ruleParitioner_JS )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1124:6: ( ruleParitioner_JS )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1125:1: ruleParitioner_JS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleParitioner_JS_in_rule__Partitioner__Alternatives2351);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1135:1: rule__Partition_Rule__Alternatives : ( ( rulePartition_SingleLineRule ) | ( rulePartition_MultiLineRule ) );
    public final void rule__Partition_Rule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1139:1: ( ( rulePartition_SingleLineRule ) | ( rulePartition_MultiLineRule ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==26) ) {
                alt4=1;
            }
            else if ( (LA4_0==30) ) {
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1140:1: ( rulePartition_SingleLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1140:1: ( rulePartition_SingleLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1141:1: rulePartition_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePartition_SingleLineRule_in_rule__Partition_Rule__Alternatives2383);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1146:6: ( rulePartition_MultiLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1146:6: ( rulePartition_MultiLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1147:1: rulePartition_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_rulePartition_MultiLineRule_in_rule__Partition_Rule__Alternatives2400);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1157:1: rule__LexicalPartitionHighlighting__Alternatives : ( ( ruleLexicalPartitionHighlighting_Rule ) | ( ruleLexicalPartitionHighlighting_JS ) );
    public final void rule__LexicalPartitionHighlighting__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1161:1: ( ( ruleLexicalPartitionHighlighting_Rule ) | ( ruleLexicalPartitionHighlighting_JS ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==25) ) {
                alt5=1;
            }
            else if ( (LA5_0==24) ) {
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1162:1: ( ruleLexicalPartitionHighlighting_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1162:1: ( ruleLexicalPartitionHighlighting_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1163:1: ruleLexicalPartitionHighlighting_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_rule__LexicalPartitionHighlighting__Alternatives2432);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1168:6: ( ruleLexicalPartitionHighlighting_JS )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1168:6: ( ruleLexicalPartitionHighlighting_JS )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1169:1: ruleLexicalPartitionHighlighting_JS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_rule__LexicalPartitionHighlighting__Alternatives2449);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1179:1: rule__Scanner__Alternatives : ( ( ruleScanner_Keyword ) | ( ruleScanner_Rule ) );
    public final void rule__Scanner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1183:1: ( ( ruleScanner_Keyword ) | ( ruleScanner_Rule ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==32) ) {
                alt6=1;
            }
            else if ( (LA6_0==24||LA6_0==26||LA6_0==30||LA6_0==37||LA6_0==39) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1184:1: ( ruleScanner_Keyword )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1184:1: ( ruleScanner_Keyword )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1185:1: ruleScanner_Keyword
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_Keyword_in_rule__Scanner__Alternatives2481);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1190:6: ( ruleScanner_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1190:6: ( ruleScanner_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1191:1: ruleScanner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_Rule_in_rule__Scanner__Alternatives2498);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1201:1: rule__Scanner_Rule__Alternatives : ( ( ruleScanner_SingleLineRule ) | ( ruleScanner_MultiLineRule ) | ( ruleScanner_CharacterRule ) | ( ruleScanner_JSRule ) | ( ruleScanner_PatternRule ) );
    public final void rule__Scanner_Rule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1205:1: ( ( ruleScanner_SingleLineRule ) | ( ruleScanner_MultiLineRule ) | ( ruleScanner_CharacterRule ) | ( ruleScanner_JSRule ) | ( ruleScanner_PatternRule ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt7=1;
                }
                break;
            case 30:
                {
                alt7=2;
                }
                break;
            case 39:
                {
                alt7=3;
                }
                break;
            case 24:
                {
                alt7=4;
                }
                break;
            case 37:
                {
                alt7=5;
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1206:1: ( ruleScanner_SingleLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1206:1: ( ruleScanner_SingleLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1207:1: ruleScanner_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_rule__Scanner_Rule__Alternatives2530);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1212:6: ( ruleScanner_MultiLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1212:6: ( ruleScanner_MultiLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1213:1: ruleScanner_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_rule__Scanner_Rule__Alternatives2547);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1218:6: ( ruleScanner_CharacterRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1218:6: ( ruleScanner_CharacterRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1219:1: ruleScanner_CharacterRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_CharacterRule_in_rule__Scanner_Rule__Alternatives2564);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1224:6: ( ruleScanner_JSRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1224:6: ( ruleScanner_JSRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1225:1: ruleScanner_JSRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_JSRule_in_rule__Scanner_Rule__Alternatives2581);
                    ruleScanner_JSRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1230:6: ( ruleScanner_PatternRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1230:6: ( ruleScanner_PatternRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1231:1: ruleScanner_PatternRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_PatternRuleParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_PatternRule_in_rule__Scanner_Rule__Alternatives2598);
                    ruleScanner_PatternRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScanner_RuleAccess().getScanner_PatternRuleParserRuleCall_4()); 
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1241:1: rule__WhitespaceRule__Alternatives_1 : ( ( ( rule__WhitespaceRule__Group_1_0__0 ) ) | ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) ) | ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) ) );
    public final void rule__WhitespaceRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1245:1: ( ( ( rule__WhitespaceRule__Group_1_0__0 ) ) | ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) ) | ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt8=1;
                }
                break;
            case 42:
                {
                alt8=2;
                }
                break;
            case RULE_STRING:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1246:1: ( ( rule__WhitespaceRule__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1246:1: ( ( rule__WhitespaceRule__Group_1_0__0 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1247:1: ( rule__WhitespaceRule__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1248:1: ( rule__WhitespaceRule__Group_1_0__0 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1248:2: rule__WhitespaceRule__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__0_in_rule__WhitespaceRule__Alternatives_12630);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1252:6: ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1252:6: ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1253:1: ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceAssignment_1_1()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1254:1: ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1254:2: rule__WhitespaceRule__JavawhitespaceAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__WhitespaceRule__JavawhitespaceAssignment_1_1_in_rule__WhitespaceRule__Alternatives_12648);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1258:6: ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1258:6: ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1259:1: ( rule__WhitespaceRule__FileURIAssignment_1_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getFileURIAssignment_1_2()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1260:1: ( rule__WhitespaceRule__FileURIAssignment_1_2 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1260:2: rule__WhitespaceRule__FileURIAssignment_1_2
                    {
                    pushFollow(FOLLOW_rule__WhitespaceRule__FileURIAssignment_1_2_in_rule__WhitespaceRule__Alternatives_12666);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1271:1: rule__Root__Group__0 : rule__Root__Group__0__Impl rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1275:1: ( rule__Root__Group__0__Impl rule__Root__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1276:2: rule__Root__Group__0__Impl rule__Root__Group__1
            {
            pushFollow(FOLLOW_rule__Root__Group__0__Impl_in_rule__Root__Group__02697);
            rule__Root__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Root__Group__1_in_rule__Root__Group__02700);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1283:1: rule__Root__Group__0__Impl : ( 'package' ) ;
    public final void rule__Root__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1287:1: ( ( 'package' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1288:1: ( 'package' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1288:1: ( 'package' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1289:1: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getPackageKeyword_0()); 
            }
            match(input,11,FOLLOW_11_in_rule__Root__Group__0__Impl2728); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1302:1: rule__Root__Group__1 : rule__Root__Group__1__Impl rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1306:1: ( rule__Root__Group__1__Impl rule__Root__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1307:2: rule__Root__Group__1__Impl rule__Root__Group__2
            {
            pushFollow(FOLLOW_rule__Root__Group__1__Impl_in_rule__Root__Group__12759);
            rule__Root__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Root__Group__2_in_rule__Root__Group__12762);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1314:1: rule__Root__Group__1__Impl : ( ( rule__Root__NameAssignment_1 ) ) ;
    public final void rule__Root__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1318:1: ( ( ( rule__Root__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1319:1: ( ( rule__Root__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1319:1: ( ( rule__Root__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1320:1: ( rule__Root__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1321:1: ( rule__Root__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1321:2: rule__Root__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Root__NameAssignment_1_in_rule__Root__Group__1__Impl2789);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1331:1: rule__Root__Group__2 : rule__Root__Group__2__Impl rule__Root__Group__3 ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1335:1: ( rule__Root__Group__2__Impl rule__Root__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1336:2: rule__Root__Group__2__Impl rule__Root__Group__3
            {
            pushFollow(FOLLOW_rule__Root__Group__2__Impl_in_rule__Root__Group__22819);
            rule__Root__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Root__Group__3_in_rule__Root__Group__22822);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1343:1: rule__Root__Group__2__Impl : ( ( rule__Root__ImportsAssignment_2 )* ) ;
    public final void rule__Root__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1347:1: ( ( ( rule__Root__ImportsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1348:1: ( ( rule__Root__ImportsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1348:1: ( ( rule__Root__ImportsAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1349:1: ( rule__Root__ImportsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getImportsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1350:1: ( rule__Root__ImportsAssignment_2 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==14) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1350:2: rule__Root__ImportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Root__ImportsAssignment_2_in_rule__Root__Group__2__Impl2849);
            	    rule__Root__ImportsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1360:1: rule__Root__Group__3 : rule__Root__Group__3__Impl ;
    public final void rule__Root__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1364:1: ( rule__Root__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1365:2: rule__Root__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Root__Group__3__Impl_in_rule__Root__Group__32880);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1371:1: rule__Root__Group__3__Impl : ( ( rule__Root__LanguageDefinitionAssignment_3 ) ) ;
    public final void rule__Root__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1375:1: ( ( ( rule__Root__LanguageDefinitionAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1376:1: ( ( rule__Root__LanguageDefinitionAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1376:1: ( ( rule__Root__LanguageDefinitionAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1377:1: ( rule__Root__LanguageDefinitionAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLanguageDefinitionAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1378:1: ( rule__Root__LanguageDefinitionAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1378:2: rule__Root__LanguageDefinitionAssignment_3
            {
            pushFollow(FOLLOW_rule__Root__LanguageDefinitionAssignment_3_in_rule__Root__Group__3__Impl2907);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1396:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1400:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1401:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02945);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02948);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1408:1: rule__QualifiedName__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1412:1: ( ( ruleValidID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1413:1: ( ruleValidID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1413:1: ( ruleValidID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1414:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl2975);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1425:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1429:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1430:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13004);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1436:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1440:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1441:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1441:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1442:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1443:1: ( rule__QualifiedName__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==12) ) {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2==RULE_ID) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1443:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3031);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1457:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1461:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1462:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03066);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03069);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1469:1: rule__QualifiedName__Group_1__0__Impl : ( ( '.' ) ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1473:1: ( ( ( '.' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1474:1: ( ( '.' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1474:1: ( ( '.' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1475:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1476:1: ( '.' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1477:2: '.'
            {
            match(input,12,FOLLOW_12_in_rule__QualifiedName__Group_1__0__Impl3098); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1488:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1492:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1493:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13130);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1499:1: rule__QualifiedName__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1503:1: ( ( ruleValidID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1504:1: ( ruleValidID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1504:1: ( ruleValidID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1505:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl3157);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1520:1: rule__QualifiedNameWithWildCard__Group__0 : rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 ;
    public final void rule__QualifiedNameWithWildCard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1524:1: ( rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1525:2: rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__0__Impl_in_rule__QualifiedNameWithWildCard__Group__03190);
            rule__QualifiedNameWithWildCard__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__03193);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1532:1: rule__QualifiedNameWithWildCard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildCard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1536:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1537:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1537:1: ( ruleQualifiedName )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1538:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__0__Impl3220);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1549:1: rule__QualifiedNameWithWildCard__Group__1 : rule__QualifiedNameWithWildCard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1553:1: ( rule__QualifiedNameWithWildCard__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1554:2: rule__QualifiedNameWithWildCard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__1__Impl_in_rule__QualifiedNameWithWildCard__Group__13249);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1560:1: rule__QualifiedNameWithWildCard__Group__1__Impl : ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? ) ;
    public final void rule__QualifiedNameWithWildCard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1564:1: ( ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1565:1: ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1565:1: ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1566:1: ( rule__QualifiedNameWithWildCard__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1567:1: ( rule__QualifiedNameWithWildCard__Group_1__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==12) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1567:2: rule__QualifiedNameWithWildCard__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0_in_rule__QualifiedNameWithWildCard__Group__1__Impl3276);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1581:1: rule__QualifiedNameWithWildCard__Group_1__0 : rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1 ;
    public final void rule__QualifiedNameWithWildCard__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1585:1: ( rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1586:2: rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0__Impl_in_rule__QualifiedNameWithWildCard__Group_1__03311);
            rule__QualifiedNameWithWildCard__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1_in_rule__QualifiedNameWithWildCard__Group_1__03314);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1593:1: rule__QualifiedNameWithWildCard__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedNameWithWildCard__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1597:1: ( ( '.' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1598:1: ( '.' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1598:1: ( '.' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1599:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
            }
            match(input,12,FOLLOW_12_in_rule__QualifiedNameWithWildCard__Group_1__0__Impl3342); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1612:1: rule__QualifiedNameWithWildCard__Group_1__1 : rule__QualifiedNameWithWildCard__Group_1__1__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1616:1: ( rule__QualifiedNameWithWildCard__Group_1__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1617:2: rule__QualifiedNameWithWildCard__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1__Impl_in_rule__QualifiedNameWithWildCard__Group_1__13373);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1623:1: rule__QualifiedNameWithWildCard__Group_1__1__Impl : ( '*' ) ;
    public final void rule__QualifiedNameWithWildCard__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1627:1: ( ( '*' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1628:1: ( '*' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1628:1: ( '*' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1629:1: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1()); 
            }
            match(input,13,FOLLOW_13_in_rule__QualifiedNameWithWildCard__Group_1__1__Impl3401); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1646:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1650:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1651:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03436);
            rule__Import__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03439);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1658:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1662:1: ( ( 'import' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1663:1: ( 'import' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1663:1: ( 'import' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1664:1: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }
            match(input,14,FOLLOW_14_in_rule__Import__Group__0__Impl3467); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1677:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1681:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1682:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13498);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1688:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1692:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1693:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1693:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1694:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1695:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1695:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3525);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1709:1: rule__LanguageDef__Group__0 : rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1 ;
    public final void rule__LanguageDef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1713:1: ( rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1714:2: rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__0__Impl_in_rule__LanguageDef__Group__03559);
            rule__LanguageDef__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__1_in_rule__LanguageDef__Group__03562);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1721:1: rule__LanguageDef__Group__0__Impl : ( ( rule__LanguageDef__NameAssignment_0 ) ) ;
    public final void rule__LanguageDef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1725:1: ( ( ( rule__LanguageDef__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1726:1: ( ( rule__LanguageDef__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1726:1: ( ( rule__LanguageDef__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1727:1: ( rule__LanguageDef__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1728:1: ( rule__LanguageDef__NameAssignment_0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1728:2: rule__LanguageDef__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__LanguageDef__NameAssignment_0_in_rule__LanguageDef__Group__0__Impl3589);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1738:1: rule__LanguageDef__Group__1 : rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2 ;
    public final void rule__LanguageDef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1742:1: ( rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1743:2: rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__1__Impl_in_rule__LanguageDef__Group__13619);
            rule__LanguageDef__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__2_in_rule__LanguageDef__Group__13622);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1750:1: rule__LanguageDef__Group__1__Impl : ( '{' ) ;
    public final void rule__LanguageDef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1754:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1755:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1755:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1756:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__LanguageDef__Group__1__Impl3650); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1769:1: rule__LanguageDef__Group__2 : rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3 ;
    public final void rule__LanguageDef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1773:1: ( rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1774:2: rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__2__Impl_in_rule__LanguageDef__Group__23681);
            rule__LanguageDef__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__3_in_rule__LanguageDef__Group__23684);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1781:1: rule__LanguageDef__Group__2__Impl : ( ( rule__LanguageDef__ParitioningAssignment_2 ) ) ;
    public final void rule__LanguageDef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1785:1: ( ( ( rule__LanguageDef__ParitioningAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1786:1: ( ( rule__LanguageDef__ParitioningAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1786:1: ( ( rule__LanguageDef__ParitioningAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1787:1: ( rule__LanguageDef__ParitioningAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getParitioningAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1788:1: ( rule__LanguageDef__ParitioningAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1788:2: rule__LanguageDef__ParitioningAssignment_2
            {
            pushFollow(FOLLOW_rule__LanguageDef__ParitioningAssignment_2_in_rule__LanguageDef__Group__2__Impl3711);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1798:1: rule__LanguageDef__Group__3 : rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4 ;
    public final void rule__LanguageDef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1802:1: ( rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1803:2: rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__3__Impl_in_rule__LanguageDef__Group__33741);
            rule__LanguageDef__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__4_in_rule__LanguageDef__Group__33744);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1810:1: rule__LanguageDef__Group__3__Impl : ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) ) ;
    public final void rule__LanguageDef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1814:1: ( ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1815:1: ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1815:1: ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1816:1: ( rule__LanguageDef__LexicalHighlightingAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLexicalHighlightingAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1817:1: ( rule__LanguageDef__LexicalHighlightingAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1817:2: rule__LanguageDef__LexicalHighlightingAssignment_3
            {
            pushFollow(FOLLOW_rule__LanguageDef__LexicalHighlightingAssignment_3_in_rule__LanguageDef__Group__3__Impl3771);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1827:1: rule__LanguageDef__Group__4 : rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5 ;
    public final void rule__LanguageDef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1831:1: ( rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1832:2: rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__4__Impl_in_rule__LanguageDef__Group__43801);
            rule__LanguageDef__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__5_in_rule__LanguageDef__Group__43804);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1839:1: rule__LanguageDef__Group__4__Impl : ( ( rule__LanguageDef__IntegrationAssignment_4 )? ) ;
    public final void rule__LanguageDef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1843:1: ( ( ( rule__LanguageDef__IntegrationAssignment_4 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1844:1: ( ( rule__LanguageDef__IntegrationAssignment_4 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1844:1: ( ( rule__LanguageDef__IntegrationAssignment_4 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1845:1: ( rule__LanguageDef__IntegrationAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getIntegrationAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1846:1: ( rule__LanguageDef__IntegrationAssignment_4 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1846:2: rule__LanguageDef__IntegrationAssignment_4
                    {
                    pushFollow(FOLLOW_rule__LanguageDef__IntegrationAssignment_4_in_rule__LanguageDef__Group__4__Impl3831);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1856:1: rule__LanguageDef__Group__5 : rule__LanguageDef__Group__5__Impl ;
    public final void rule__LanguageDef__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1860:1: ( rule__LanguageDef__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1861:2: rule__LanguageDef__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__5__Impl_in_rule__LanguageDef__Group__53862);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1867:1: rule__LanguageDef__Group__5__Impl : ( '}' ) ;
    public final void rule__LanguageDef__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1871:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1872:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1872:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1873:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,16,FOLLOW_16_in_rule__LanguageDef__Group__5__Impl3890); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1898:1: rule__Integration__Group__0 : rule__Integration__Group__0__Impl rule__Integration__Group__1 ;
    public final void rule__Integration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1902:1: ( rule__Integration__Group__0__Impl rule__Integration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1903:2: rule__Integration__Group__0__Impl rule__Integration__Group__1
            {
            pushFollow(FOLLOW_rule__Integration__Group__0__Impl_in_rule__Integration__Group__03933);
            rule__Integration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Integration__Group__1_in_rule__Integration__Group__03936);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1910:1: rule__Integration__Group__0__Impl : ( 'integration' ) ;
    public final void rule__Integration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1914:1: ( ( 'integration' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1915:1: ( 'integration' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1915:1: ( 'integration' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1916:1: 'integration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getIntegrationKeyword_0()); 
            }
            match(input,17,FOLLOW_17_in_rule__Integration__Group__0__Impl3964); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1929:1: rule__Integration__Group__1 : rule__Integration__Group__1__Impl rule__Integration__Group__2 ;
    public final void rule__Integration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1933:1: ( rule__Integration__Group__1__Impl rule__Integration__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1934:2: rule__Integration__Group__1__Impl rule__Integration__Group__2
            {
            pushFollow(FOLLOW_rule__Integration__Group__1__Impl_in_rule__Integration__Group__13995);
            rule__Integration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Integration__Group__2_in_rule__Integration__Group__13998);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1941:1: rule__Integration__Group__1__Impl : ( '{' ) ;
    public final void rule__Integration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1945:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1946:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1946:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1947:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__Integration__Group__1__Impl4026); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1960:1: rule__Integration__Group__2 : rule__Integration__Group__2__Impl rule__Integration__Group__3 ;
    public final void rule__Integration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1964:1: ( rule__Integration__Group__2__Impl rule__Integration__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1965:2: rule__Integration__Group__2__Impl rule__Integration__Group__3
            {
            pushFollow(FOLLOW_rule__Integration__Group__2__Impl_in_rule__Integration__Group__24057);
            rule__Integration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Integration__Group__3_in_rule__Integration__Group__24060);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1972:1: rule__Integration__Group__2__Impl : ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) ) ;
    public final void rule__Integration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1976:1: ( ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1977:1: ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1977:1: ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1978:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1978:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1979:1: ( rule__Integration__CodeIntegrationListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1980:1: ( rule__Integration__CodeIntegrationListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1980:2: rule__Integration__CodeIntegrationListAssignment_2
            {
            pushFollow(FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl4089);
            rule__Integration__CodeIntegrationListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1983:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1984:1: ( rule__Integration__CodeIntegrationListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1985:1: ( rule__Integration__CodeIntegrationListAssignment_2 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==18) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1985:2: rule__Integration__CodeIntegrationListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl4101);
            	    rule__Integration__CodeIntegrationListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1996:1: rule__Integration__Group__3 : rule__Integration__Group__3__Impl ;
    public final void rule__Integration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2000:1: ( rule__Integration__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2001:2: rule__Integration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Integration__Group__3__Impl_in_rule__Integration__Group__34134);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2007:1: rule__Integration__Group__3__Impl : ( '}' ) ;
    public final void rule__Integration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2011:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2012:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2012:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2013:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__Integration__Group__3__Impl4162); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2034:1: rule__JavaFXIntegration__Group__0 : rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1 ;
    public final void rule__JavaFXIntegration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2038:1: ( rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2039:2: rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__0__Impl_in_rule__JavaFXIntegration__Group__04201);
            rule__JavaFXIntegration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__1_in_rule__JavaFXIntegration__Group__04204);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2046:1: rule__JavaFXIntegration__Group__0__Impl : ( 'javafx' ) ;
    public final void rule__JavaFXIntegration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2050:1: ( ( 'javafx' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2051:1: ( 'javafx' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2051:1: ( 'javafx' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2052:1: 'javafx'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getJavafxKeyword_0()); 
            }
            match(input,18,FOLLOW_18_in_rule__JavaFXIntegration__Group__0__Impl4232); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2065:1: rule__JavaFXIntegration__Group__1 : rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2 ;
    public final void rule__JavaFXIntegration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2069:1: ( rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2070:2: rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__1__Impl_in_rule__JavaFXIntegration__Group__14263);
            rule__JavaFXIntegration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__2_in_rule__JavaFXIntegration__Group__14266);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2077:1: rule__JavaFXIntegration__Group__1__Impl : ( '{' ) ;
    public final void rule__JavaFXIntegration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2081:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2082:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2082:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2083:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__JavaFXIntegration__Group__1__Impl4294); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2096:1: rule__JavaFXIntegration__Group__2 : rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3 ;
    public final void rule__JavaFXIntegration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2100:1: ( rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2101:2: rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__2__Impl_in_rule__JavaFXIntegration__Group__24325);
            rule__JavaFXIntegration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__3_in_rule__JavaFXIntegration__Group__24328);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2108:1: rule__JavaFXIntegration__Group__2__Impl : ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) ) ;
    public final void rule__JavaFXIntegration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2112:1: ( ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2113:1: ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2113:1: ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2114:1: ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2114:1: ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2115:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2116:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2116:2: rule__JavaFXIntegration__CodegenerationListAssignment_2
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__CodegenerationListAssignment_2_in_rule__JavaFXIntegration__Group__2__Impl4357);
            rule__JavaFXIntegration__CodegenerationListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2119:1: ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2120:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2121:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=19 && LA14_0<=20)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2121:2: rule__JavaFXIntegration__CodegenerationListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__JavaFXIntegration__CodegenerationListAssignment_2_in_rule__JavaFXIntegration__Group__2__Impl4369);
            	    rule__JavaFXIntegration__CodegenerationListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListAssignment_2()); 
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
    // $ANTLR end "rule__JavaFXIntegration__Group__2__Impl"


    // $ANTLR start "rule__JavaFXIntegration__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2132:1: rule__JavaFXIntegration__Group__3 : rule__JavaFXIntegration__Group__3__Impl ;
    public final void rule__JavaFXIntegration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2136:1: ( rule__JavaFXIntegration__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2137:2: rule__JavaFXIntegration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__3__Impl_in_rule__JavaFXIntegration__Group__34402);
            rule__JavaFXIntegration__Group__3__Impl();

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2143:1: rule__JavaFXIntegration__Group__3__Impl : ( '}' ) ;
    public final void rule__JavaFXIntegration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2147:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2148:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2148:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2149:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__JavaFXIntegration__Group__3__Impl4430); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getRightCurlyBracketKeyword_3()); 
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


    // $ANTLR start "rule__JavaCodeGeneration__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2170:1: rule__JavaCodeGeneration__Group__0 : rule__JavaCodeGeneration__Group__0__Impl rule__JavaCodeGeneration__Group__1 ;
    public final void rule__JavaCodeGeneration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2174:1: ( rule__JavaCodeGeneration__Group__0__Impl rule__JavaCodeGeneration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2175:2: rule__JavaCodeGeneration__Group__0__Impl rule__JavaCodeGeneration__Group__1
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group__0__Impl_in_rule__JavaCodeGeneration__Group__04469);
            rule__JavaCodeGeneration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group__1_in_rule__JavaCodeGeneration__Group__04472);
            rule__JavaCodeGeneration__Group__1();

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
    // $ANTLR end "rule__JavaCodeGeneration__Group__0"


    // $ANTLR start "rule__JavaCodeGeneration__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2182:1: rule__JavaCodeGeneration__Group__0__Impl : ( 'java' ) ;
    public final void rule__JavaCodeGeneration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2186:1: ( ( 'java' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2187:1: ( 'java' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2187:1: ( 'java' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2188:1: 'java'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getJavaKeyword_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__JavaCodeGeneration__Group__0__Impl4500); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getJavaKeyword_0()); 
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
    // $ANTLR end "rule__JavaCodeGeneration__Group__0__Impl"


    // $ANTLR start "rule__JavaCodeGeneration__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2201:1: rule__JavaCodeGeneration__Group__1 : rule__JavaCodeGeneration__Group__1__Impl rule__JavaCodeGeneration__Group__2 ;
    public final void rule__JavaCodeGeneration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2205:1: ( rule__JavaCodeGeneration__Group__1__Impl rule__JavaCodeGeneration__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2206:2: rule__JavaCodeGeneration__Group__1__Impl rule__JavaCodeGeneration__Group__2
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group__1__Impl_in_rule__JavaCodeGeneration__Group__14531);
            rule__JavaCodeGeneration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group__2_in_rule__JavaCodeGeneration__Group__14534);
            rule__JavaCodeGeneration__Group__2();

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
    // $ANTLR end "rule__JavaCodeGeneration__Group__1"


    // $ANTLR start "rule__JavaCodeGeneration__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2213:1: rule__JavaCodeGeneration__Group__1__Impl : ( ( rule__JavaCodeGeneration__NameAssignment_1 ) ) ;
    public final void rule__JavaCodeGeneration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2217:1: ( ( ( rule__JavaCodeGeneration__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2218:1: ( ( rule__JavaCodeGeneration__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2218:1: ( ( rule__JavaCodeGeneration__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2219:1: ( rule__JavaCodeGeneration__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2220:1: ( rule__JavaCodeGeneration__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2220:2: rule__JavaCodeGeneration__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__NameAssignment_1_in_rule__JavaCodeGeneration__Group__1__Impl4561);
            rule__JavaCodeGeneration__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__JavaCodeGeneration__Group__1__Impl"


    // $ANTLR start "rule__JavaCodeGeneration__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2230:1: rule__JavaCodeGeneration__Group__2 : rule__JavaCodeGeneration__Group__2__Impl ;
    public final void rule__JavaCodeGeneration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2234:1: ( rule__JavaCodeGeneration__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2235:2: rule__JavaCodeGeneration__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group__2__Impl_in_rule__JavaCodeGeneration__Group__24591);
            rule__JavaCodeGeneration__Group__2__Impl();

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
    // $ANTLR end "rule__JavaCodeGeneration__Group__2"


    // $ANTLR start "rule__JavaCodeGeneration__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2241:1: rule__JavaCodeGeneration__Group__2__Impl : ( ( rule__JavaCodeGeneration__Group_2__0 )? ) ;
    public final void rule__JavaCodeGeneration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2245:1: ( ( ( rule__JavaCodeGeneration__Group_2__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2246:1: ( ( rule__JavaCodeGeneration__Group_2__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2246:1: ( ( rule__JavaCodeGeneration__Group_2__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2247:1: ( rule__JavaCodeGeneration__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getGroup_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2248:1: ( rule__JavaCodeGeneration__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2248:2: rule__JavaCodeGeneration__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__JavaCodeGeneration__Group_2__0_in_rule__JavaCodeGeneration__Group__2__Impl4618);
                    rule__JavaCodeGeneration__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getGroup_2()); 
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
    // $ANTLR end "rule__JavaCodeGeneration__Group__2__Impl"


    // $ANTLR start "rule__JavaCodeGeneration__Group_2__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2264:1: rule__JavaCodeGeneration__Group_2__0 : rule__JavaCodeGeneration__Group_2__0__Impl rule__JavaCodeGeneration__Group_2__1 ;
    public final void rule__JavaCodeGeneration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2268:1: ( rule__JavaCodeGeneration__Group_2__0__Impl rule__JavaCodeGeneration__Group_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2269:2: rule__JavaCodeGeneration__Group_2__0__Impl rule__JavaCodeGeneration__Group_2__1
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group_2__0__Impl_in_rule__JavaCodeGeneration__Group_2__04655);
            rule__JavaCodeGeneration__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group_2__1_in_rule__JavaCodeGeneration__Group_2__04658);
            rule__JavaCodeGeneration__Group_2__1();

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
    // $ANTLR end "rule__JavaCodeGeneration__Group_2__0"


    // $ANTLR start "rule__JavaCodeGeneration__Group_2__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2276:1: rule__JavaCodeGeneration__Group_2__0__Impl : ( '{' ) ;
    public final void rule__JavaCodeGeneration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2280:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2281:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2281:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2282:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__JavaCodeGeneration__Group_2__0__Impl4686); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getLeftCurlyBracketKeyword_2_0()); 
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
    // $ANTLR end "rule__JavaCodeGeneration__Group_2__0__Impl"


    // $ANTLR start "rule__JavaCodeGeneration__Group_2__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2295:1: rule__JavaCodeGeneration__Group_2__1 : rule__JavaCodeGeneration__Group_2__1__Impl rule__JavaCodeGeneration__Group_2__2 ;
    public final void rule__JavaCodeGeneration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2299:1: ( rule__JavaCodeGeneration__Group_2__1__Impl rule__JavaCodeGeneration__Group_2__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2300:2: rule__JavaCodeGeneration__Group_2__1__Impl rule__JavaCodeGeneration__Group_2__2
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group_2__1__Impl_in_rule__JavaCodeGeneration__Group_2__14717);
            rule__JavaCodeGeneration__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group_2__2_in_rule__JavaCodeGeneration__Group_2__14720);
            rule__JavaCodeGeneration__Group_2__2();

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
    // $ANTLR end "rule__JavaCodeGeneration__Group_2__1"


    // $ANTLR start "rule__JavaCodeGeneration__Group_2__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2307:1: rule__JavaCodeGeneration__Group_2__1__Impl : ( ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* ) ) ;
    public final void rule__JavaCodeGeneration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2311:1: ( ( ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2312:1: ( ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2312:1: ( ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2313:1: ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2313:1: ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2314:1: ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2315:1: ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2315:2: rule__JavaCodeGeneration__ConfigValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__ConfigValueAssignment_2_1_in_rule__JavaCodeGeneration__Group_2__1__Impl4749);
            rule__JavaCodeGeneration__ConfigValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2318:1: ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2319:1: ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2320:1: ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2320:2: rule__JavaCodeGeneration__ConfigValueAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__JavaCodeGeneration__ConfigValueAssignment_2_1_in_rule__JavaCodeGeneration__Group_2__1__Impl4761);
            	    rule__JavaCodeGeneration__ConfigValueAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getConfigValueAssignment_2_1()); 
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
    // $ANTLR end "rule__JavaCodeGeneration__Group_2__1__Impl"


    // $ANTLR start "rule__JavaCodeGeneration__Group_2__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2331:1: rule__JavaCodeGeneration__Group_2__2 : rule__JavaCodeGeneration__Group_2__2__Impl ;
    public final void rule__JavaCodeGeneration__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2335:1: ( rule__JavaCodeGeneration__Group_2__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2336:2: rule__JavaCodeGeneration__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group_2__2__Impl_in_rule__JavaCodeGeneration__Group_2__24794);
            rule__JavaCodeGeneration__Group_2__2__Impl();

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
    // $ANTLR end "rule__JavaCodeGeneration__Group_2__2"


    // $ANTLR start "rule__JavaCodeGeneration__Group_2__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2342:1: rule__JavaCodeGeneration__Group_2__2__Impl : ( '}' ) ;
    public final void rule__JavaCodeGeneration__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2346:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2347:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2347:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2348:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,16,FOLLOW_16_in_rule__JavaCodeGeneration__Group_2__2__Impl4822); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getRightCurlyBracketKeyword_2_2()); 
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
    // $ANTLR end "rule__JavaCodeGeneration__Group_2__2__Impl"


    // $ANTLR start "rule__E4CodeGeneration__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2367:1: rule__E4CodeGeneration__Group__0 : rule__E4CodeGeneration__Group__0__Impl rule__E4CodeGeneration__Group__1 ;
    public final void rule__E4CodeGeneration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2371:1: ( rule__E4CodeGeneration__Group__0__Impl rule__E4CodeGeneration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2372:2: rule__E4CodeGeneration__Group__0__Impl rule__E4CodeGeneration__Group__1
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group__0__Impl_in_rule__E4CodeGeneration__Group__04859);
            rule__E4CodeGeneration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group__1_in_rule__E4CodeGeneration__Group__04862);
            rule__E4CodeGeneration__Group__1();

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
    // $ANTLR end "rule__E4CodeGeneration__Group__0"


    // $ANTLR start "rule__E4CodeGeneration__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2379:1: rule__E4CodeGeneration__Group__0__Impl : ( 'e4' ) ;
    public final void rule__E4CodeGeneration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2383:1: ( ( 'e4' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2384:1: ( 'e4' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2384:1: ( 'e4' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2385:1: 'e4'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getE4Keyword_0()); 
            }
            match(input,20,FOLLOW_20_in_rule__E4CodeGeneration__Group__0__Impl4890); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getE4Keyword_0()); 
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
    // $ANTLR end "rule__E4CodeGeneration__Group__0__Impl"


    // $ANTLR start "rule__E4CodeGeneration__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2398:1: rule__E4CodeGeneration__Group__1 : rule__E4CodeGeneration__Group__1__Impl rule__E4CodeGeneration__Group__2 ;
    public final void rule__E4CodeGeneration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2402:1: ( rule__E4CodeGeneration__Group__1__Impl rule__E4CodeGeneration__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2403:2: rule__E4CodeGeneration__Group__1__Impl rule__E4CodeGeneration__Group__2
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group__1__Impl_in_rule__E4CodeGeneration__Group__14921);
            rule__E4CodeGeneration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group__2_in_rule__E4CodeGeneration__Group__14924);
            rule__E4CodeGeneration__Group__2();

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
    // $ANTLR end "rule__E4CodeGeneration__Group__1"


    // $ANTLR start "rule__E4CodeGeneration__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2410:1: rule__E4CodeGeneration__Group__1__Impl : ( ( rule__E4CodeGeneration__NameAssignment_1 ) ) ;
    public final void rule__E4CodeGeneration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2414:1: ( ( ( rule__E4CodeGeneration__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2415:1: ( ( rule__E4CodeGeneration__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2415:1: ( ( rule__E4CodeGeneration__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2416:1: ( rule__E4CodeGeneration__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2417:1: ( rule__E4CodeGeneration__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2417:2: rule__E4CodeGeneration__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__NameAssignment_1_in_rule__E4CodeGeneration__Group__1__Impl4951);
            rule__E4CodeGeneration__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__E4CodeGeneration__Group__1__Impl"


    // $ANTLR start "rule__E4CodeGeneration__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2427:1: rule__E4CodeGeneration__Group__2 : rule__E4CodeGeneration__Group__2__Impl ;
    public final void rule__E4CodeGeneration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2431:1: ( rule__E4CodeGeneration__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2432:2: rule__E4CodeGeneration__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group__2__Impl_in_rule__E4CodeGeneration__Group__24981);
            rule__E4CodeGeneration__Group__2__Impl();

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
    // $ANTLR end "rule__E4CodeGeneration__Group__2"


    // $ANTLR start "rule__E4CodeGeneration__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2438:1: rule__E4CodeGeneration__Group__2__Impl : ( ( rule__E4CodeGeneration__Group_2__0 )? ) ;
    public final void rule__E4CodeGeneration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2442:1: ( ( ( rule__E4CodeGeneration__Group_2__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2443:1: ( ( rule__E4CodeGeneration__Group_2__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2443:1: ( ( rule__E4CodeGeneration__Group_2__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2444:1: ( rule__E4CodeGeneration__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getGroup_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2445:1: ( rule__E4CodeGeneration__Group_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==15) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2445:2: rule__E4CodeGeneration__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__E4CodeGeneration__Group_2__0_in_rule__E4CodeGeneration__Group__2__Impl5008);
                    rule__E4CodeGeneration__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getGroup_2()); 
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
    // $ANTLR end "rule__E4CodeGeneration__Group__2__Impl"


    // $ANTLR start "rule__E4CodeGeneration__Group_2__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2461:1: rule__E4CodeGeneration__Group_2__0 : rule__E4CodeGeneration__Group_2__0__Impl rule__E4CodeGeneration__Group_2__1 ;
    public final void rule__E4CodeGeneration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2465:1: ( rule__E4CodeGeneration__Group_2__0__Impl rule__E4CodeGeneration__Group_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2466:2: rule__E4CodeGeneration__Group_2__0__Impl rule__E4CodeGeneration__Group_2__1
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group_2__0__Impl_in_rule__E4CodeGeneration__Group_2__05045);
            rule__E4CodeGeneration__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group_2__1_in_rule__E4CodeGeneration__Group_2__05048);
            rule__E4CodeGeneration__Group_2__1();

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
    // $ANTLR end "rule__E4CodeGeneration__Group_2__0"


    // $ANTLR start "rule__E4CodeGeneration__Group_2__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2473:1: rule__E4CodeGeneration__Group_2__0__Impl : ( '{' ) ;
    public final void rule__E4CodeGeneration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2477:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2478:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2478:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2479:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__E4CodeGeneration__Group_2__0__Impl5076); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getLeftCurlyBracketKeyword_2_0()); 
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
    // $ANTLR end "rule__E4CodeGeneration__Group_2__0__Impl"


    // $ANTLR start "rule__E4CodeGeneration__Group_2__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2492:1: rule__E4CodeGeneration__Group_2__1 : rule__E4CodeGeneration__Group_2__1__Impl rule__E4CodeGeneration__Group_2__2 ;
    public final void rule__E4CodeGeneration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2496:1: ( rule__E4CodeGeneration__Group_2__1__Impl rule__E4CodeGeneration__Group_2__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2497:2: rule__E4CodeGeneration__Group_2__1__Impl rule__E4CodeGeneration__Group_2__2
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group_2__1__Impl_in_rule__E4CodeGeneration__Group_2__15107);
            rule__E4CodeGeneration__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group_2__2_in_rule__E4CodeGeneration__Group_2__15110);
            rule__E4CodeGeneration__Group_2__2();

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
    // $ANTLR end "rule__E4CodeGeneration__Group_2__1"


    // $ANTLR start "rule__E4CodeGeneration__Group_2__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2504:1: rule__E4CodeGeneration__Group_2__1__Impl : ( ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* ) ) ;
    public final void rule__E4CodeGeneration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2508:1: ( ( ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2509:1: ( ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2509:1: ( ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2510:1: ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2510:1: ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2511:1: ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2512:1: ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2512:2: rule__E4CodeGeneration__ConfigValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__ConfigValueAssignment_2_1_in_rule__E4CodeGeneration__Group_2__1__Impl5139);
            rule__E4CodeGeneration__ConfigValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2515:1: ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2516:1: ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2517:1: ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2517:2: rule__E4CodeGeneration__ConfigValueAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__E4CodeGeneration__ConfigValueAssignment_2_1_in_rule__E4CodeGeneration__Group_2__1__Impl5151);
            	    rule__E4CodeGeneration__ConfigValueAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getConfigValueAssignment_2_1()); 
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
    // $ANTLR end "rule__E4CodeGeneration__Group_2__1__Impl"


    // $ANTLR start "rule__E4CodeGeneration__Group_2__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2528:1: rule__E4CodeGeneration__Group_2__2 : rule__E4CodeGeneration__Group_2__2__Impl ;
    public final void rule__E4CodeGeneration__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2532:1: ( rule__E4CodeGeneration__Group_2__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2533:2: rule__E4CodeGeneration__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group_2__2__Impl_in_rule__E4CodeGeneration__Group_2__25184);
            rule__E4CodeGeneration__Group_2__2__Impl();

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
    // $ANTLR end "rule__E4CodeGeneration__Group_2__2"


    // $ANTLR start "rule__E4CodeGeneration__Group_2__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2539:1: rule__E4CodeGeneration__Group_2__2__Impl : ( '}' ) ;
    public final void rule__E4CodeGeneration__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2543:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2544:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2544:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2545:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,16,FOLLOW_16_in_rule__E4CodeGeneration__Group_2__2__Impl5212); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getRightCurlyBracketKeyword_2_2()); 
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
    // $ANTLR end "rule__E4CodeGeneration__Group_2__2__Impl"


    // $ANTLR start "rule__ConfigValue__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2564:1: rule__ConfigValue__Group__0 : rule__ConfigValue__Group__0__Impl rule__ConfigValue__Group__1 ;
    public final void rule__ConfigValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2568:1: ( rule__ConfigValue__Group__0__Impl rule__ConfigValue__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2569:2: rule__ConfigValue__Group__0__Impl rule__ConfigValue__Group__1
            {
            pushFollow(FOLLOW_rule__ConfigValue__Group__0__Impl_in_rule__ConfigValue__Group__05249);
            rule__ConfigValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConfigValue__Group__1_in_rule__ConfigValue__Group__05252);
            rule__ConfigValue__Group__1();

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
    // $ANTLR end "rule__ConfigValue__Group__0"


    // $ANTLR start "rule__ConfigValue__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2576:1: rule__ConfigValue__Group__0__Impl : ( ( rule__ConfigValue__KeyAssignment_0 ) ) ;
    public final void rule__ConfigValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2580:1: ( ( ( rule__ConfigValue__KeyAssignment_0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2581:1: ( ( rule__ConfigValue__KeyAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2581:1: ( ( rule__ConfigValue__KeyAssignment_0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2582:1: ( rule__ConfigValue__KeyAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getKeyAssignment_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2583:1: ( rule__ConfigValue__KeyAssignment_0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2583:2: rule__ConfigValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__ConfigValue__KeyAssignment_0_in_rule__ConfigValue__Group__0__Impl5279);
            rule__ConfigValue__KeyAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getKeyAssignment_0()); 
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
    // $ANTLR end "rule__ConfigValue__Group__0__Impl"


    // $ANTLR start "rule__ConfigValue__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2593:1: rule__ConfigValue__Group__1 : rule__ConfigValue__Group__1__Impl rule__ConfigValue__Group__2 ;
    public final void rule__ConfigValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2597:1: ( rule__ConfigValue__Group__1__Impl rule__ConfigValue__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2598:2: rule__ConfigValue__Group__1__Impl rule__ConfigValue__Group__2
            {
            pushFollow(FOLLOW_rule__ConfigValue__Group__1__Impl_in_rule__ConfigValue__Group__15309);
            rule__ConfigValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConfigValue__Group__2_in_rule__ConfigValue__Group__15312);
            rule__ConfigValue__Group__2();

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
    // $ANTLR end "rule__ConfigValue__Group__1"


    // $ANTLR start "rule__ConfigValue__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2605:1: rule__ConfigValue__Group__1__Impl : ( ':' ) ;
    public final void rule__ConfigValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2609:1: ( ( ':' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2610:1: ( ':' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2610:1: ( ':' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2611:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getColonKeyword_1()); 
            }
            match(input,21,FOLLOW_21_in_rule__ConfigValue__Group__1__Impl5340); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getColonKeyword_1()); 
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
    // $ANTLR end "rule__ConfigValue__Group__1__Impl"


    // $ANTLR start "rule__ConfigValue__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2624:1: rule__ConfigValue__Group__2 : rule__ConfigValue__Group__2__Impl ;
    public final void rule__ConfigValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2628:1: ( rule__ConfigValue__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2629:2: rule__ConfigValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ConfigValue__Group__2__Impl_in_rule__ConfigValue__Group__25371);
            rule__ConfigValue__Group__2__Impl();

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
    // $ANTLR end "rule__ConfigValue__Group__2"


    // $ANTLR start "rule__ConfigValue__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2635:1: rule__ConfigValue__Group__2__Impl : ( ( rule__ConfigValue__Alternatives_2 ) ) ;
    public final void rule__ConfigValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2639:1: ( ( ( rule__ConfigValue__Alternatives_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2640:1: ( ( rule__ConfigValue__Alternatives_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2640:1: ( ( rule__ConfigValue__Alternatives_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2641:1: ( rule__ConfigValue__Alternatives_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getAlternatives_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2642:1: ( rule__ConfigValue__Alternatives_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2642:2: rule__ConfigValue__Alternatives_2
            {
            pushFollow(FOLLOW_rule__ConfigValue__Alternatives_2_in_rule__ConfigValue__Group__2__Impl5398);
            rule__ConfigValue__Alternatives_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getAlternatives_2()); 
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
    // $ANTLR end "rule__ConfigValue__Group__2__Impl"


    // $ANTLR start "rule__ConfigValue__Group_2_1__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2658:1: rule__ConfigValue__Group_2_1__0 : rule__ConfigValue__Group_2_1__0__Impl rule__ConfigValue__Group_2_1__1 ;
    public final void rule__ConfigValue__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2662:1: ( rule__ConfigValue__Group_2_1__0__Impl rule__ConfigValue__Group_2_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2663:2: rule__ConfigValue__Group_2_1__0__Impl rule__ConfigValue__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ConfigValue__Group_2_1__0__Impl_in_rule__ConfigValue__Group_2_1__05434);
            rule__ConfigValue__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConfigValue__Group_2_1__1_in_rule__ConfigValue__Group_2_1__05437);
            rule__ConfigValue__Group_2_1__1();

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
    // $ANTLR end "rule__ConfigValue__Group_2_1__0"


    // $ANTLR start "rule__ConfigValue__Group_2_1__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2670:1: rule__ConfigValue__Group_2_1__0__Impl : ( '{' ) ;
    public final void rule__ConfigValue__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2674:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2675:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2675:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2676:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getLeftCurlyBracketKeyword_2_1_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__ConfigValue__Group_2_1__0__Impl5465); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getLeftCurlyBracketKeyword_2_1_0()); 
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
    // $ANTLR end "rule__ConfigValue__Group_2_1__0__Impl"


    // $ANTLR start "rule__ConfigValue__Group_2_1__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2689:1: rule__ConfigValue__Group_2_1__1 : rule__ConfigValue__Group_2_1__1__Impl rule__ConfigValue__Group_2_1__2 ;
    public final void rule__ConfigValue__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2693:1: ( rule__ConfigValue__Group_2_1__1__Impl rule__ConfigValue__Group_2_1__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2694:2: rule__ConfigValue__Group_2_1__1__Impl rule__ConfigValue__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__ConfigValue__Group_2_1__1__Impl_in_rule__ConfigValue__Group_2_1__15496);
            rule__ConfigValue__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConfigValue__Group_2_1__2_in_rule__ConfigValue__Group_2_1__15499);
            rule__ConfigValue__Group_2_1__2();

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
    // $ANTLR end "rule__ConfigValue__Group_2_1__1"


    // $ANTLR start "rule__ConfigValue__Group_2_1__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2701:1: rule__ConfigValue__Group_2_1__1__Impl : ( ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) ) ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* ) ) ;
    public final void rule__ConfigValue__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2705:1: ( ( ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) ) ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2706:1: ( ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) ) ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2706:1: ( ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) ) ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2707:1: ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) ) ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2707:1: ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2708:1: ( rule__ConfigValue__ChildrenAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getChildrenAssignment_2_1_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2709:1: ( rule__ConfigValue__ChildrenAssignment_2_1_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2709:2: rule__ConfigValue__ChildrenAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__ConfigValue__ChildrenAssignment_2_1_1_in_rule__ConfigValue__Group_2_1__1__Impl5528);
            rule__ConfigValue__ChildrenAssignment_2_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getChildrenAssignment_2_1_1()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2712:1: ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2713:1: ( rule__ConfigValue__ChildrenAssignment_2_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getChildrenAssignment_2_1_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2714:1: ( rule__ConfigValue__ChildrenAssignment_2_1_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2714:2: rule__ConfigValue__ChildrenAssignment_2_1_1
            	    {
            	    pushFollow(FOLLOW_rule__ConfigValue__ChildrenAssignment_2_1_1_in_rule__ConfigValue__Group_2_1__1__Impl5540);
            	    rule__ConfigValue__ChildrenAssignment_2_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getChildrenAssignment_2_1_1()); 
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
    // $ANTLR end "rule__ConfigValue__Group_2_1__1__Impl"


    // $ANTLR start "rule__ConfigValue__Group_2_1__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2725:1: rule__ConfigValue__Group_2_1__2 : rule__ConfigValue__Group_2_1__2__Impl ;
    public final void rule__ConfigValue__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2729:1: ( rule__ConfigValue__Group_2_1__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2730:2: rule__ConfigValue__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ConfigValue__Group_2_1__2__Impl_in_rule__ConfigValue__Group_2_1__25573);
            rule__ConfigValue__Group_2_1__2__Impl();

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
    // $ANTLR end "rule__ConfigValue__Group_2_1__2"


    // $ANTLR start "rule__ConfigValue__Group_2_1__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2736:1: rule__ConfigValue__Group_2_1__2__Impl : ( '}' ) ;
    public final void rule__ConfigValue__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2740:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2741:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2741:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2742:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getRightCurlyBracketKeyword_2_1_2()); 
            }
            match(input,16,FOLLOW_16_in_rule__ConfigValue__Group_2_1__2__Impl5601); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getRightCurlyBracketKeyword_2_1_2()); 
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
    // $ANTLR end "rule__ConfigValue__Group_2_1__2__Impl"


    // $ANTLR start "rule__Paritioning__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2761:1: rule__Paritioning__Group__0 : rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1 ;
    public final void rule__Paritioning__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2765:1: ( rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2766:2: rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__0__Impl_in_rule__Paritioning__Group__05638);
            rule__Paritioning__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__1_in_rule__Paritioning__Group__05641);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2773:1: rule__Paritioning__Group__0__Impl : ( 'partitioning' ) ;
    public final void rule__Paritioning__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2777:1: ( ( 'partitioning' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2778:1: ( 'partitioning' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2778:1: ( 'partitioning' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2779:1: 'partitioning'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitioningKeyword_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__Paritioning__Group__0__Impl5669); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2792:1: rule__Paritioning__Group__1 : rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2 ;
    public final void rule__Paritioning__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2796:1: ( rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2797:2: rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__1__Impl_in_rule__Paritioning__Group__15700);
            rule__Paritioning__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__2_in_rule__Paritioning__Group__15703);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2804:1: rule__Paritioning__Group__1__Impl : ( '{' ) ;
    public final void rule__Paritioning__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2808:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2809:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2809:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2810:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__Paritioning__Group__1__Impl5731); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2823:1: rule__Paritioning__Group__2 : rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3 ;
    public final void rule__Paritioning__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2827:1: ( rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2828:2: rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__2__Impl_in_rule__Paritioning__Group__25762);
            rule__Paritioning__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__3_in_rule__Paritioning__Group__25765);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2835:1: rule__Paritioning__Group__2__Impl : ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) ) ;
    public final void rule__Paritioning__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2839:1: ( ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2840:1: ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2840:1: ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2841:1: ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2841:1: ( ( rule__Paritioning__PartitionsAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2842:1: ( rule__Paritioning__PartitionsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2843:1: ( rule__Paritioning__PartitionsAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2843:2: rule__Paritioning__PartitionsAssignment_2
            {
            pushFollow(FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl5794);
            rule__Paritioning__PartitionsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2846:1: ( ( rule__Paritioning__PartitionsAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2847:1: ( rule__Paritioning__PartitionsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2848:1: ( rule__Paritioning__PartitionsAssignment_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==23) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2848:2: rule__Paritioning__PartitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl5806);
            	    rule__Paritioning__PartitionsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2859:1: rule__Paritioning__Group__3 : rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4 ;
    public final void rule__Paritioning__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2863:1: ( rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2864:2: rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__3__Impl_in_rule__Paritioning__Group__35839);
            rule__Paritioning__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__4_in_rule__Paritioning__Group__35842);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2871:1: rule__Paritioning__Group__3__Impl : ( ( rule__Paritioning__PartitionerAssignment_3 ) ) ;
    public final void rule__Paritioning__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2875:1: ( ( ( rule__Paritioning__PartitionerAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2876:1: ( ( rule__Paritioning__PartitionerAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2876:1: ( ( rule__Paritioning__PartitionerAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2877:1: ( rule__Paritioning__PartitionerAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionerAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2878:1: ( rule__Paritioning__PartitionerAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2878:2: rule__Paritioning__PartitionerAssignment_3
            {
            pushFollow(FOLLOW_rule__Paritioning__PartitionerAssignment_3_in_rule__Paritioning__Group__3__Impl5869);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2888:1: rule__Paritioning__Group__4 : rule__Paritioning__Group__4__Impl ;
    public final void rule__Paritioning__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2892:1: ( rule__Paritioning__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2893:2: rule__Paritioning__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__4__Impl_in_rule__Paritioning__Group__45899);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2899:1: rule__Paritioning__Group__4__Impl : ( '}' ) ;
    public final void rule__Paritioning__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2903:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2904:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2904:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2905:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,16,FOLLOW_16_in_rule__Paritioning__Group__4__Impl5927); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2928:1: rule__Partition__Group__0 : rule__Partition__Group__0__Impl rule__Partition__Group__1 ;
    public final void rule__Partition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2932:1: ( rule__Partition__Group__0__Impl rule__Partition__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2933:2: rule__Partition__Group__0__Impl rule__Partition__Group__1
            {
            pushFollow(FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__05968);
            rule__Partition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__05971);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2940:1: rule__Partition__Group__0__Impl : ( 'partition' ) ;
    public final void rule__Partition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2944:1: ( ( 'partition' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2945:1: ( 'partition' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2945:1: ( 'partition' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2946:1: 'partition'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__Partition__Group__0__Impl5999); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2959:1: rule__Partition__Group__1 : rule__Partition__Group__1__Impl ;
    public final void rule__Partition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2963:1: ( rule__Partition__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2964:2: rule__Partition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__16030);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2970:1: rule__Partition__Group__1__Impl : ( ( rule__Partition__NameAssignment_1 ) ) ;
    public final void rule__Partition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2974:1: ( ( ( rule__Partition__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2975:1: ( ( rule__Partition__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2975:1: ( ( rule__Partition__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2976:1: ( rule__Partition__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2977:1: ( rule__Partition__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2977:2: rule__Partition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl6057);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2991:1: rule__Paritioner_JS__Group__0 : rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1 ;
    public final void rule__Paritioner_JS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2995:1: ( rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2996:2: rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__0__Impl_in_rule__Paritioner_JS__Group__06091);
            rule__Paritioner_JS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__1_in_rule__Paritioner_JS__Group__06094);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3003:1: rule__Paritioner_JS__Group__0__Impl : ( 'script' ) ;
    public final void rule__Paritioner_JS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3007:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3008:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3008:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3009:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptKeyword_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__Paritioner_JS__Group__0__Impl6122); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3022:1: rule__Paritioner_JS__Group__1 : rule__Paritioner_JS__Group__1__Impl ;
    public final void rule__Paritioner_JS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3026:1: ( rule__Paritioner_JS__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3027:2: rule__Paritioner_JS__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__1__Impl_in_rule__Paritioner_JS__Group__16153);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3033:1: rule__Paritioner_JS__Group__1__Impl : ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) ) ;
    public final void rule__Paritioner_JS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3037:1: ( ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3038:1: ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3038:1: ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3039:1: ( rule__Paritioner_JS__ScriptURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptURIAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3040:1: ( rule__Paritioner_JS__ScriptURIAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3040:2: rule__Paritioner_JS__ScriptURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__ScriptURIAssignment_1_in_rule__Paritioner_JS__Group__1__Impl6180);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3054:1: rule__Partitioner_Rule__Group__0 : rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1 ;
    public final void rule__Partitioner_Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3058:1: ( rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3059:2: rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__0__Impl_in_rule__Partitioner_Rule__Group__06214);
            rule__Partitioner_Rule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__1_in_rule__Partitioner_Rule__Group__06217);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3066:1: rule__Partitioner_Rule__Group__0__Impl : ( 'rule' ) ;
    public final void rule__Partitioner_Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3070:1: ( ( 'rule' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3071:1: ( 'rule' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3071:1: ( 'rule' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3072:1: 'rule'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__Partitioner_Rule__Group__0__Impl6245); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3085:1: rule__Partitioner_Rule__Group__1 : rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2 ;
    public final void rule__Partitioner_Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3089:1: ( rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3090:2: rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__1__Impl_in_rule__Partitioner_Rule__Group__16276);
            rule__Partitioner_Rule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__2_in_rule__Partitioner_Rule__Group__16279);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3097:1: rule__Partitioner_Rule__Group__1__Impl : ( '{' ) ;
    public final void rule__Partitioner_Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3101:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3102:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3102:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3103:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__Partitioner_Rule__Group__1__Impl6307); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3116:1: rule__Partitioner_Rule__Group__2 : rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3 ;
    public final void rule__Partitioner_Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3120:1: ( rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3121:2: rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__2__Impl_in_rule__Partitioner_Rule__Group__26338);
            rule__Partitioner_Rule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__3_in_rule__Partitioner_Rule__Group__26341);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3128:1: rule__Partitioner_Rule__Group__2__Impl : ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) ) ;
    public final void rule__Partitioner_Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3132:1: ( ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3133:1: ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3133:1: ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3134:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3134:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3135:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3136:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3136:2: rule__Partitioner_Rule__RuleListAssignment_2
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl6370);
            rule__Partitioner_Rule__RuleListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3139:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3140:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3141:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==26||LA21_0==30) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3141:2: rule__Partitioner_Rule__RuleListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl6382);
            	    rule__Partitioner_Rule__RuleListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3152:1: rule__Partitioner_Rule__Group__3 : rule__Partitioner_Rule__Group__3__Impl ;
    public final void rule__Partitioner_Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3156:1: ( rule__Partitioner_Rule__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3157:2: rule__Partitioner_Rule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__3__Impl_in_rule__Partitioner_Rule__Group__36415);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3163:1: rule__Partitioner_Rule__Group__3__Impl : ( '}' ) ;
    public final void rule__Partitioner_Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3167:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3168:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3168:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3169:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__Partitioner_Rule__Group__3__Impl6443); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3190:1: rule__Partition_SingleLineRule__Group__0 : rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1 ;
    public final void rule__Partition_SingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3194:1: ( rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3195:2: rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__0__Impl_in_rule__Partition_SingleLineRule__Group__06482);
            rule__Partition_SingleLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__1_in_rule__Partition_SingleLineRule__Group__06485);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3202:1: rule__Partition_SingleLineRule__Group__0__Impl : ( 'single_line' ) ;
    public final void rule__Partition_SingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3206:1: ( ( 'single_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3207:1: ( 'single_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3207:1: ( 'single_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3208:1: 'single_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__Partition_SingleLineRule__Group__0__Impl6513); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3221:1: rule__Partition_SingleLineRule__Group__1 : rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2 ;
    public final void rule__Partition_SingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3225:1: ( rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3226:2: rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__1__Impl_in_rule__Partition_SingleLineRule__Group__16544);
            rule__Partition_SingleLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__2_in_rule__Partition_SingleLineRule__Group__16547);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3233:1: rule__Partition_SingleLineRule__Group__1__Impl : ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__Partition_SingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3237:1: ( ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3238:1: ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3238:1: ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3239:1: ( rule__Partition_SingleLineRule__ParitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3240:1: ( rule__Partition_SingleLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3240:2: rule__Partition_SingleLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__ParitionAssignment_1_in_rule__Partition_SingleLineRule__Group__1__Impl6574);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3250:1: rule__Partition_SingleLineRule__Group__2 : rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3 ;
    public final void rule__Partition_SingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3254:1: ( rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3255:2: rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__2__Impl_in_rule__Partition_SingleLineRule__Group__26604);
            rule__Partition_SingleLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__3_in_rule__Partition_SingleLineRule__Group__26607);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3262:1: rule__Partition_SingleLineRule__Group__2__Impl : ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__Partition_SingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3266:1: ( ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3267:1: ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3267:1: ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3268:1: ( rule__Partition_SingleLineRule__StartSeqAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3269:1: ( rule__Partition_SingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3269:2: rule__Partition_SingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__StartSeqAssignment_2_in_rule__Partition_SingleLineRule__Group__2__Impl6634);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3279:1: rule__Partition_SingleLineRule__Group__3 : rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4 ;
    public final void rule__Partition_SingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3283:1: ( rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3284:2: rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__3__Impl_in_rule__Partition_SingleLineRule__Group__36664);
            rule__Partition_SingleLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__4_in_rule__Partition_SingleLineRule__Group__36667);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3291:1: rule__Partition_SingleLineRule__Group__3__Impl : ( ( rule__Partition_SingleLineRule__Group_3__0 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3295:1: ( ( ( rule__Partition_SingleLineRule__Group_3__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3296:1: ( ( rule__Partition_SingleLineRule__Group_3__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3296:1: ( ( rule__Partition_SingleLineRule__Group_3__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3297:1: ( rule__Partition_SingleLineRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3298:1: ( rule__Partition_SingleLineRule__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==27) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3298:2: rule__Partition_SingleLineRule__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_3__0_in_rule__Partition_SingleLineRule__Group__3__Impl6694);
                    rule__Partition_SingleLineRule__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_3()); 
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3308:1: rule__Partition_SingleLineRule__Group__4 : rule__Partition_SingleLineRule__Group__4__Impl ;
    public final void rule__Partition_SingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3312:1: ( rule__Partition_SingleLineRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3313:2: rule__Partition_SingleLineRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__4__Impl_in_rule__Partition_SingleLineRule__Group__46725);
            rule__Partition_SingleLineRule__Group__4__Impl();

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3319:1: rule__Partition_SingleLineRule__Group__4__Impl : ( ( rule__Partition_SingleLineRule__Group_4__0 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3323:1: ( ( ( rule__Partition_SingleLineRule__Group_4__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3324:1: ( ( rule__Partition_SingleLineRule__Group_4__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3324:1: ( ( rule__Partition_SingleLineRule__Group_4__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3325:1: ( rule__Partition_SingleLineRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3326:1: ( rule__Partition_SingleLineRule__Group_4__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==28) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3326:2: rule__Partition_SingleLineRule__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_4__0_in_rule__Partition_SingleLineRule__Group__4__Impl6752);
                    rule__Partition_SingleLineRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_4()); 
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


    // $ANTLR start "rule__Partition_SingleLineRule__Group_3__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3346:1: rule__Partition_SingleLineRule__Group_3__0 : rule__Partition_SingleLineRule__Group_3__0__Impl rule__Partition_SingleLineRule__Group_3__1 ;
    public final void rule__Partition_SingleLineRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3350:1: ( rule__Partition_SingleLineRule__Group_3__0__Impl rule__Partition_SingleLineRule__Group_3__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3351:2: rule__Partition_SingleLineRule__Group_3__0__Impl rule__Partition_SingleLineRule__Group_3__1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_3__0__Impl_in_rule__Partition_SingleLineRule__Group_3__06793);
            rule__Partition_SingleLineRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_3__1_in_rule__Partition_SingleLineRule__Group_3__06796);
            rule__Partition_SingleLineRule__Group_3__1();

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
    // $ANTLR end "rule__Partition_SingleLineRule__Group_3__0"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_3__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3358:1: rule__Partition_SingleLineRule__Group_3__0__Impl : ( '=>' ) ;
    public final void rule__Partition_SingleLineRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3362:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3363:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3363:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3364:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__Partition_SingleLineRule__Group_3__0__Impl6824); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3_0()); 
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
    // $ANTLR end "rule__Partition_SingleLineRule__Group_3__0__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_3__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3377:1: rule__Partition_SingleLineRule__Group_3__1 : rule__Partition_SingleLineRule__Group_3__1__Impl ;
    public final void rule__Partition_SingleLineRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3381:1: ( rule__Partition_SingleLineRule__Group_3__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3382:2: rule__Partition_SingleLineRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_3__1__Impl_in_rule__Partition_SingleLineRule__Group_3__16855);
            rule__Partition_SingleLineRule__Group_3__1__Impl();

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
    // $ANTLR end "rule__Partition_SingleLineRule__Group_3__1"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_3__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3388:1: rule__Partition_SingleLineRule__Group_3__1__Impl : ( ( rule__Partition_SingleLineRule__EndSeqAssignment_3_1 )? ) ;
    public final void rule__Partition_SingleLineRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3392:1: ( ( ( rule__Partition_SingleLineRule__EndSeqAssignment_3_1 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3393:1: ( ( rule__Partition_SingleLineRule__EndSeqAssignment_3_1 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3393:1: ( ( rule__Partition_SingleLineRule__EndSeqAssignment_3_1 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3394:1: ( rule__Partition_SingleLineRule__EndSeqAssignment_3_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqAssignment_3_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3395:1: ( rule__Partition_SingleLineRule__EndSeqAssignment_3_1 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_STRING) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3395:2: rule__Partition_SingleLineRule__EndSeqAssignment_3_1
                    {
                    pushFollow(FOLLOW_rule__Partition_SingleLineRule__EndSeqAssignment_3_1_in_rule__Partition_SingleLineRule__Group_3__1__Impl6882);
                    rule__Partition_SingleLineRule__EndSeqAssignment_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqAssignment_3_1()); 
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
    // $ANTLR end "rule__Partition_SingleLineRule__Group_3__1__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_4__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3409:1: rule__Partition_SingleLineRule__Group_4__0 : rule__Partition_SingleLineRule__Group_4__0__Impl rule__Partition_SingleLineRule__Group_4__1 ;
    public final void rule__Partition_SingleLineRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3413:1: ( rule__Partition_SingleLineRule__Group_4__0__Impl rule__Partition_SingleLineRule__Group_4__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3414:2: rule__Partition_SingleLineRule__Group_4__0__Impl rule__Partition_SingleLineRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_4__0__Impl_in_rule__Partition_SingleLineRule__Group_4__06917);
            rule__Partition_SingleLineRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_4__1_in_rule__Partition_SingleLineRule__Group_4__06920);
            rule__Partition_SingleLineRule__Group_4__1();

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
    // $ANTLR end "rule__Partition_SingleLineRule__Group_4__0"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_4__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3421:1: rule__Partition_SingleLineRule__Group_4__0__Impl : ( 'escaped' ) ;
    public final void rule__Partition_SingleLineRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3425:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3426:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3426:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3427:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_4_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__Partition_SingleLineRule__Group_4__0__Impl6948); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_4_0()); 
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
    // $ANTLR end "rule__Partition_SingleLineRule__Group_4__0__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_4__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3440:1: rule__Partition_SingleLineRule__Group_4__1 : rule__Partition_SingleLineRule__Group_4__1__Impl rule__Partition_SingleLineRule__Group_4__2 ;
    public final void rule__Partition_SingleLineRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3444:1: ( rule__Partition_SingleLineRule__Group_4__1__Impl rule__Partition_SingleLineRule__Group_4__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3445:2: rule__Partition_SingleLineRule__Group_4__1__Impl rule__Partition_SingleLineRule__Group_4__2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_4__1__Impl_in_rule__Partition_SingleLineRule__Group_4__16979);
            rule__Partition_SingleLineRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_4__2_in_rule__Partition_SingleLineRule__Group_4__16982);
            rule__Partition_SingleLineRule__Group_4__2();

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
    // $ANTLR end "rule__Partition_SingleLineRule__Group_4__1"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_4__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3452:1: rule__Partition_SingleLineRule__Group_4__1__Impl : ( 'by' ) ;
    public final void rule__Partition_SingleLineRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3456:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3457:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3457:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3458:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_4_1()); 
            }
            match(input,29,FOLLOW_29_in_rule__Partition_SingleLineRule__Group_4__1__Impl7010); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_4_1()); 
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
    // $ANTLR end "rule__Partition_SingleLineRule__Group_4__1__Impl"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_4__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3471:1: rule__Partition_SingleLineRule__Group_4__2 : rule__Partition_SingleLineRule__Group_4__2__Impl ;
    public final void rule__Partition_SingleLineRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3475:1: ( rule__Partition_SingleLineRule__Group_4__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3476:2: rule__Partition_SingleLineRule__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_4__2__Impl_in_rule__Partition_SingleLineRule__Group_4__27041);
            rule__Partition_SingleLineRule__Group_4__2__Impl();

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
    // $ANTLR end "rule__Partition_SingleLineRule__Group_4__2"


    // $ANTLR start "rule__Partition_SingleLineRule__Group_4__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3482:1: rule__Partition_SingleLineRule__Group_4__2__Impl : ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2 ) ) ;
    public final void rule__Partition_SingleLineRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3486:1: ( ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3487:1: ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3487:1: ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3488:1: ( rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3489:1: ( rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3489:2: rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2_in_rule__Partition_SingleLineRule__Group_4__2__Impl7068);
            rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqAssignment_4_2()); 
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
    // $ANTLR end "rule__Partition_SingleLineRule__Group_4__2__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3505:1: rule__Partition_MultiLineRule__Group__0 : rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1 ;
    public final void rule__Partition_MultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3509:1: ( rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3510:2: rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__0__Impl_in_rule__Partition_MultiLineRule__Group__07104);
            rule__Partition_MultiLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__1_in_rule__Partition_MultiLineRule__Group__07107);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3517:1: rule__Partition_MultiLineRule__Group__0__Impl : ( 'multi_line' ) ;
    public final void rule__Partition_MultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3521:1: ( ( 'multi_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3522:1: ( 'multi_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3522:1: ( 'multi_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3523:1: 'multi_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__Partition_MultiLineRule__Group__0__Impl7135); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3536:1: rule__Partition_MultiLineRule__Group__1 : rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2 ;
    public final void rule__Partition_MultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3540:1: ( rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3541:2: rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__1__Impl_in_rule__Partition_MultiLineRule__Group__17166);
            rule__Partition_MultiLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__2_in_rule__Partition_MultiLineRule__Group__17169);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3548:1: rule__Partition_MultiLineRule__Group__1__Impl : ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3552:1: ( ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3553:1: ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3553:1: ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3554:1: ( rule__Partition_MultiLineRule__ParitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3555:1: ( rule__Partition_MultiLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3555:2: rule__Partition_MultiLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__ParitionAssignment_1_in_rule__Partition_MultiLineRule__Group__1__Impl7196);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3565:1: rule__Partition_MultiLineRule__Group__2 : rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3 ;
    public final void rule__Partition_MultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3569:1: ( rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3570:2: rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__2__Impl_in_rule__Partition_MultiLineRule__Group__27226);
            rule__Partition_MultiLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__3_in_rule__Partition_MultiLineRule__Group__27229);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3577:1: rule__Partition_MultiLineRule__Group__2__Impl : ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3581:1: ( ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3582:1: ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3582:1: ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3583:1: ( rule__Partition_MultiLineRule__StartSeqAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3584:1: ( rule__Partition_MultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3584:2: rule__Partition_MultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__StartSeqAssignment_2_in_rule__Partition_MultiLineRule__Group__2__Impl7256);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3594:1: rule__Partition_MultiLineRule__Group__3 : rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4 ;
    public final void rule__Partition_MultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3598:1: ( rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3599:2: rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__3__Impl_in_rule__Partition_MultiLineRule__Group__37286);
            rule__Partition_MultiLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__4_in_rule__Partition_MultiLineRule__Group__37289);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3606:1: rule__Partition_MultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__Partition_MultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3610:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3611:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3611:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3612:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            }
            match(input,27,FOLLOW_27_in_rule__Partition_MultiLineRule__Group__3__Impl7317); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3625:1: rule__Partition_MultiLineRule__Group__4 : rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5 ;
    public final void rule__Partition_MultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3629:1: ( rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3630:2: rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__4__Impl_in_rule__Partition_MultiLineRule__Group__47348);
            rule__Partition_MultiLineRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__5_in_rule__Partition_MultiLineRule__Group__47351);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3637:1: rule__Partition_MultiLineRule__Group__4__Impl : ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3641:1: ( ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3642:1: ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3642:1: ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3643:1: ( rule__Partition_MultiLineRule__EndSeqAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3644:1: ( rule__Partition_MultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3644:2: rule__Partition_MultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__EndSeqAssignment_4_in_rule__Partition_MultiLineRule__Group__4__Impl7378);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3654:1: rule__Partition_MultiLineRule__Group__5 : rule__Partition_MultiLineRule__Group__5__Impl ;
    public final void rule__Partition_MultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3658:1: ( rule__Partition_MultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3659:2: rule__Partition_MultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__5__Impl_in_rule__Partition_MultiLineRule__Group__57408);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3665:1: rule__Partition_MultiLineRule__Group__5__Impl : ( ( rule__Partition_MultiLineRule__Group_5__0 )? ) ;
    public final void rule__Partition_MultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3669:1: ( ( ( rule__Partition_MultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3670:1: ( ( rule__Partition_MultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3670:1: ( ( rule__Partition_MultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3671:1: ( rule__Partition_MultiLineRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup_5()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3672:1: ( rule__Partition_MultiLineRule__Group_5__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==28) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3672:2: rule__Partition_MultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__0_in_rule__Partition_MultiLineRule__Group__5__Impl7435);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3694:1: rule__Partition_MultiLineRule__Group_5__0 : rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1 ;
    public final void rule__Partition_MultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3698:1: ( rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3699:2: rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__0__Impl_in_rule__Partition_MultiLineRule__Group_5__07478);
            rule__Partition_MultiLineRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__1_in_rule__Partition_MultiLineRule__Group_5__07481);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3706:1: rule__Partition_MultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__Partition_MultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3710:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3711:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3711:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3712:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_5_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__Partition_MultiLineRule__Group_5__0__Impl7509); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3725:1: rule__Partition_MultiLineRule__Group_5__1 : rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2 ;
    public final void rule__Partition_MultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3729:1: ( rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3730:2: rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__1__Impl_in_rule__Partition_MultiLineRule__Group_5__17540);
            rule__Partition_MultiLineRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__2_in_rule__Partition_MultiLineRule__Group_5__17543);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3737:1: rule__Partition_MultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__Partition_MultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3741:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3742:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3742:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3743:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_5_1()); 
            }
            match(input,29,FOLLOW_29_in_rule__Partition_MultiLineRule__Group_5__1__Impl7571); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3756:1: rule__Partition_MultiLineRule__Group_5__2 : rule__Partition_MultiLineRule__Group_5__2__Impl ;
    public final void rule__Partition_MultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3760:1: ( rule__Partition_MultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3761:2: rule__Partition_MultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__2__Impl_in_rule__Partition_MultiLineRule__Group_5__27602);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3767:1: rule__Partition_MultiLineRule__Group_5__2__Impl : ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__Partition_MultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3771:1: ( ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3772:1: ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3772:1: ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3773:1: ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3774:1: ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3774:2: rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_MultiLineRule__Group_5__2__Impl7629);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3790:1: rule__LexicalHighlighting__Group__0 : rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1 ;
    public final void rule__LexicalHighlighting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3794:1: ( rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3795:2: rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__0__Impl_in_rule__LexicalHighlighting__Group__07665);
            rule__LexicalHighlighting__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__1_in_rule__LexicalHighlighting__Group__07668);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3802:1: rule__LexicalHighlighting__Group__0__Impl : ( 'lexical_highlighting' ) ;
    public final void rule__LexicalHighlighting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3806:1: ( ( 'lexical_highlighting' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3807:1: ( 'lexical_highlighting' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3807:1: ( 'lexical_highlighting' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3808:1: 'lexical_highlighting'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0()); 
            }
            match(input,31,FOLLOW_31_in_rule__LexicalHighlighting__Group__0__Impl7696); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3821:1: rule__LexicalHighlighting__Group__1 : rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2 ;
    public final void rule__LexicalHighlighting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3825:1: ( rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3826:2: rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__1__Impl_in_rule__LexicalHighlighting__Group__17727);
            rule__LexicalHighlighting__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__2_in_rule__LexicalHighlighting__Group__17730);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3833:1: rule__LexicalHighlighting__Group__1__Impl : ( '{' ) ;
    public final void rule__LexicalHighlighting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3837:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3838:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3838:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3839:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__LexicalHighlighting__Group__1__Impl7758); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3852:1: rule__LexicalHighlighting__Group__2 : rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3 ;
    public final void rule__LexicalHighlighting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3856:1: ( rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3857:2: rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__2__Impl_in_rule__LexicalHighlighting__Group__27789);
            rule__LexicalHighlighting__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__3_in_rule__LexicalHighlighting__Group__27792);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3864:1: rule__LexicalHighlighting__Group__2__Impl : ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) ) ;
    public final void rule__LexicalHighlighting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3868:1: ( ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3869:1: ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3869:1: ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3870:1: ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3870:1: ( ( rule__LexicalHighlighting__ListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3871:1: ( rule__LexicalHighlighting__ListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3872:1: ( rule__LexicalHighlighting__ListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3872:2: rule__LexicalHighlighting__ListAssignment_2
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl7821);
            rule__LexicalHighlighting__ListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3875:1: ( ( rule__LexicalHighlighting__ListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3876:1: ( rule__LexicalHighlighting__ListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3877:1: ( rule__LexicalHighlighting__ListAssignment_2 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=24 && LA26_0<=25)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3877:2: rule__LexicalHighlighting__ListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl7833);
            	    rule__LexicalHighlighting__ListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3888:1: rule__LexicalHighlighting__Group__3 : rule__LexicalHighlighting__Group__3__Impl ;
    public final void rule__LexicalHighlighting__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3892:1: ( rule__LexicalHighlighting__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3893:2: rule__LexicalHighlighting__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__3__Impl_in_rule__LexicalHighlighting__Group__37866);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3899:1: rule__LexicalHighlighting__Group__3__Impl : ( '}' ) ;
    public final void rule__LexicalHighlighting__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3903:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3904:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3904:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3905:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__LexicalHighlighting__Group__3__Impl7894); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3926:1: rule__LexicalPartitionHighlighting_JS__Group__0 : rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1 ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3930:1: ( rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3931:2: rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__07933);
            rule__LexicalPartitionHighlighting_JS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1_in_rule__LexicalPartitionHighlighting_JS__Group__07936);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3938:1: rule__LexicalPartitionHighlighting_JS__Group__0__Impl : ( 'script' ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3942:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3943:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3943:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3944:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__LexicalPartitionHighlighting_JS__Group__0__Impl7964); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3957:1: rule__LexicalPartitionHighlighting_JS__Group__1 : rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2 ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3961:1: ( rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3962:2: rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__17995);
            rule__LexicalPartitionHighlighting_JS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2_in_rule__LexicalPartitionHighlighting_JS__Group__17998);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3969:1: rule__LexicalPartitionHighlighting_JS__Group__1__Impl : ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3973:1: ( ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3974:1: ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3974:1: ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3975:1: ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3976:1: ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3976:2: rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_JS__Group__1__Impl8025);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3986:1: rule__LexicalPartitionHighlighting_JS__Group__2 : rule__LexicalPartitionHighlighting_JS__Group__2__Impl ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3990:1: ( rule__LexicalPartitionHighlighting_JS__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3991:2: rule__LexicalPartitionHighlighting_JS__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__28055);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3997:1: rule__LexicalPartitionHighlighting_JS__Group__2__Impl : ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4001:1: ( ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4002:1: ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4002:1: ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4003:1: ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURIAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4004:1: ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4004:2: rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2_in_rule__LexicalPartitionHighlighting_JS__Group__2__Impl8082);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4020:1: rule__LexicalPartitionHighlighting_Rule__Group__0 : rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4024:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4025:2: rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__08118);
            rule__LexicalPartitionHighlighting_Rule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1_in_rule__LexicalPartitionHighlighting_Rule__Group__08121);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4032:1: rule__LexicalPartitionHighlighting_Rule__Group__0__Impl : ( 'rule' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4036:1: ( ( 'rule' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4037:1: ( 'rule' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4037:1: ( 'rule' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4038:1: 'rule'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl8149); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4051:1: rule__LexicalPartitionHighlighting_Rule__Group__1 : rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4055:1: ( rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4056:2: rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__18180);
            rule__LexicalPartitionHighlighting_Rule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2_in_rule__LexicalPartitionHighlighting_Rule__Group__18183);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4063:1: rule__LexicalPartitionHighlighting_Rule__Group__1__Impl : ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4067:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4068:1: ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4068:1: ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4069:1: ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4070:1: ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4070:2: rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl8210);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4080:1: rule__LexicalPartitionHighlighting_Rule__Group__2 : rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4084:1: ( rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4085:2: rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__28240);
            rule__LexicalPartitionHighlighting_Rule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3_in_rule__LexicalPartitionHighlighting_Rule__Group__28243);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4092:1: rule__LexicalPartitionHighlighting_Rule__Group__2__Impl : ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4096:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4097:1: ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4097:1: ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4098:1: ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4099:1: ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4099:2: rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2
                    {
                    pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2_in_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl8270);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4109:1: rule__LexicalPartitionHighlighting_Rule__Group__3 : rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4113:1: ( rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4114:2: rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__38301);
            rule__LexicalPartitionHighlighting_Rule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4_in_rule__LexicalPartitionHighlighting_Rule__Group__38304);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4121:1: rule__LexicalPartitionHighlighting_Rule__Group__3__Impl : ( '{' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4125:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4126:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4126:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4127:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,15,FOLLOW_15_in_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl8332); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4140:1: rule__LexicalPartitionHighlighting_Rule__Group__4 : rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4144:1: ( rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4145:2: rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__48363);
            rule__LexicalPartitionHighlighting_Rule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5_in_rule__LexicalPartitionHighlighting_Rule__Group__48366);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4152:1: rule__LexicalPartitionHighlighting_Rule__Group__4__Impl : ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4156:1: ( ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4157:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4157:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4158:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4158:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4159:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4160:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4160:2: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl8395);
            rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4163:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4164:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4165:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID||LA28_0==41) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4165:2: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl8407);
            	    rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4176:1: rule__LexicalPartitionHighlighting_Rule__Group__5 : rule__LexicalPartitionHighlighting_Rule__Group__5__Impl ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4180:1: ( rule__LexicalPartitionHighlighting_Rule__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4181:2: rule__LexicalPartitionHighlighting_Rule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__58440);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4187:1: rule__LexicalPartitionHighlighting_Rule__Group__5__Impl : ( '}' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4191:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4192:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4192:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4193:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,16,FOLLOW_16_in_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl8468); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4218:1: rule__Token__Group__0 : rule__Token__Group__0__Impl rule__Token__Group__1 ;
    public final void rule__Token__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4222:1: ( rule__Token__Group__0__Impl rule__Token__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4223:2: rule__Token__Group__0__Impl rule__Token__Group__1
            {
            pushFollow(FOLLOW_rule__Token__Group__0__Impl_in_rule__Token__Group__08511);
            rule__Token__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group__1_in_rule__Token__Group__08514);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4230:1: rule__Token__Group__0__Impl : ( ( rule__Token__DefaultAssignment_0 )? ) ;
    public final void rule__Token__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4234:1: ( ( ( rule__Token__DefaultAssignment_0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4235:1: ( ( rule__Token__DefaultAssignment_0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4235:1: ( ( rule__Token__DefaultAssignment_0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4236:1: ( rule__Token__DefaultAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultAssignment_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4237:1: ( rule__Token__DefaultAssignment_0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==41) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4237:2: rule__Token__DefaultAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Token__DefaultAssignment_0_in_rule__Token__Group__0__Impl8541);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4247:1: rule__Token__Group__1 : rule__Token__Group__1__Impl rule__Token__Group__2 ;
    public final void rule__Token__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4251:1: ( rule__Token__Group__1__Impl rule__Token__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4252:2: rule__Token__Group__1__Impl rule__Token__Group__2
            {
            pushFollow(FOLLOW_rule__Token__Group__1__Impl_in_rule__Token__Group__18572);
            rule__Token__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group__2_in_rule__Token__Group__18575);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4259:1: rule__Token__Group__1__Impl : ( ( rule__Token__NameAssignment_1 ) ) ;
    public final void rule__Token__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4263:1: ( ( ( rule__Token__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4264:1: ( ( rule__Token__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4264:1: ( ( rule__Token__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4265:1: ( rule__Token__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4266:1: ( rule__Token__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4266:2: rule__Token__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Token__NameAssignment_1_in_rule__Token__Group__1__Impl8602);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4276:1: rule__Token__Group__2 : rule__Token__Group__2__Impl ;
    public final void rule__Token__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4280:1: ( rule__Token__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4281:2: rule__Token__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Token__Group__2__Impl_in_rule__Token__Group__28632);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4287:1: rule__Token__Group__2__Impl : ( ( rule__Token__Group_2__0 )? ) ;
    public final void rule__Token__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4291:1: ( ( ( rule__Token__Group_2__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4292:1: ( ( rule__Token__Group_2__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4292:1: ( ( rule__Token__Group_2__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4293:1: ( rule__Token__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getGroup_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4294:1: ( rule__Token__Group_2__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==15) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4294:2: rule__Token__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Token__Group_2__0_in_rule__Token__Group__2__Impl8659);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4310:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4314:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4315:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
            {
            pushFollow(FOLLOW_rule__Token__Group_2__0__Impl_in_rule__Token__Group_2__08696);
            rule__Token__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group_2__1_in_rule__Token__Group_2__08699);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4322:1: rule__Token__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4326:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4327:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4327:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4328:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__Token__Group_2__0__Impl8727); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4341:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl rule__Token__Group_2__2 ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4345:1: ( rule__Token__Group_2__1__Impl rule__Token__Group_2__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4346:2: rule__Token__Group_2__1__Impl rule__Token__Group_2__2
            {
            pushFollow(FOLLOW_rule__Token__Group_2__1__Impl_in_rule__Token__Group_2__18758);
            rule__Token__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group_2__2_in_rule__Token__Group_2__18761);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4353:1: rule__Token__Group_2__1__Impl : ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4357:1: ( ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4358:1: ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4358:1: ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4359:1: ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4359:1: ( ( rule__Token__ScannerListAssignment_2_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4360:1: ( rule__Token__ScannerListAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4361:1: ( rule__Token__ScannerListAssignment_2_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4361:2: rule__Token__ScannerListAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl8790);
            rule__Token__ScannerListAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4364:1: ( ( rule__Token__ScannerListAssignment_2_1 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4365:1: ( rule__Token__ScannerListAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4366:1: ( rule__Token__ScannerListAssignment_2_1 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==24||LA31_0==26||LA31_0==30||LA31_0==32||LA31_0==37||LA31_0==39) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4366:2: rule__Token__ScannerListAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl8802);
            	    rule__Token__ScannerListAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4377:1: rule__Token__Group_2__2 : rule__Token__Group_2__2__Impl ;
    public final void rule__Token__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4381:1: ( rule__Token__Group_2__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4382:2: rule__Token__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Token__Group_2__2__Impl_in_rule__Token__Group_2__28835);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4388:1: rule__Token__Group_2__2__Impl : ( '}' ) ;
    public final void rule__Token__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4392:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4393:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4393:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4394:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,16,FOLLOW_16_in_rule__Token__Group_2__2__Impl8863); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4413:1: rule__Scanner_Keyword__Group__0 : rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1 ;
    public final void rule__Scanner_Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4417:1: ( rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4418:2: rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__0__Impl_in_rule__Scanner_Keyword__Group__08900);
            rule__Scanner_Keyword__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__1_in_rule__Scanner_Keyword__Group__08903);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4425:1: rule__Scanner_Keyword__Group__0__Impl : ( 'keywords' ) ;
    public final void rule__Scanner_Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4429:1: ( ( 'keywords' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4430:1: ( 'keywords' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4430:1: ( 'keywords' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4431:1: 'keywords'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__Scanner_Keyword__Group__0__Impl8931); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4444:1: rule__Scanner_Keyword__Group__1 : rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2 ;
    public final void rule__Scanner_Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4448:1: ( rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4449:2: rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__1__Impl_in_rule__Scanner_Keyword__Group__18962);
            rule__Scanner_Keyword__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__2_in_rule__Scanner_Keyword__Group__18965);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4456:1: rule__Scanner_Keyword__Group__1__Impl : ( '[' ) ;
    public final void rule__Scanner_Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4460:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4461:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4461:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4462:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,33,FOLLOW_33_in_rule__Scanner_Keyword__Group__1__Impl8993); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4475:1: rule__Scanner_Keyword__Group__2 : rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3 ;
    public final void rule__Scanner_Keyword__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4479:1: ( rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4480:2: rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__2__Impl_in_rule__Scanner_Keyword__Group__29024);
            rule__Scanner_Keyword__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__3_in_rule__Scanner_Keyword__Group__29027);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4487:1: rule__Scanner_Keyword__Group__2__Impl : ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) ) ;
    public final void rule__Scanner_Keyword__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4491:1: ( ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4492:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4492:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4493:1: ( rule__Scanner_Keyword__KeywordsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4494:1: ( rule__Scanner_Keyword__KeywordsAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4494:2: rule__Scanner_Keyword__KeywordsAssignment_2
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_2_in_rule__Scanner_Keyword__Group__2__Impl9054);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4504:1: rule__Scanner_Keyword__Group__3 : rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4 ;
    public final void rule__Scanner_Keyword__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4508:1: ( rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4509:2: rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__3__Impl_in_rule__Scanner_Keyword__Group__39084);
            rule__Scanner_Keyword__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__4_in_rule__Scanner_Keyword__Group__39087);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4516:1: rule__Scanner_Keyword__Group__3__Impl : ( ( rule__Scanner_Keyword__Group_3__0 )* ) ;
    public final void rule__Scanner_Keyword__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4520:1: ( ( ( rule__Scanner_Keyword__Group_3__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4521:1: ( ( rule__Scanner_Keyword__Group_3__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4521:1: ( ( rule__Scanner_Keyword__Group_3__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4522:1: ( rule__Scanner_Keyword__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getGroup_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4523:1: ( rule__Scanner_Keyword__Group_3__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==35) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4523:2: rule__Scanner_Keyword__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__0_in_rule__Scanner_Keyword__Group__3__Impl9114);
            	    rule__Scanner_Keyword__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4533:1: rule__Scanner_Keyword__Group__4 : rule__Scanner_Keyword__Group__4__Impl ;
    public final void rule__Scanner_Keyword__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4537:1: ( rule__Scanner_Keyword__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4538:2: rule__Scanner_Keyword__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__4__Impl_in_rule__Scanner_Keyword__Group__49145);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4544:1: rule__Scanner_Keyword__Group__4__Impl : ( ']' ) ;
    public final void rule__Scanner_Keyword__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4548:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4549:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4549:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4550:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,34,FOLLOW_34_in_rule__Scanner_Keyword__Group__4__Impl9173); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4573:1: rule__Scanner_Keyword__Group_3__0 : rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1 ;
    public final void rule__Scanner_Keyword__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4577:1: ( rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4578:2: rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__0__Impl_in_rule__Scanner_Keyword__Group_3__09214);
            rule__Scanner_Keyword__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__1_in_rule__Scanner_Keyword__Group_3__09217);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4585:1: rule__Scanner_Keyword__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Scanner_Keyword__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4589:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4590:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4590:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4591:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__Scanner_Keyword__Group_3__0__Impl9245); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4604:1: rule__Scanner_Keyword__Group_3__1 : rule__Scanner_Keyword__Group_3__1__Impl ;
    public final void rule__Scanner_Keyword__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4608:1: ( rule__Scanner_Keyword__Group_3__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4609:2: rule__Scanner_Keyword__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__1__Impl_in_rule__Scanner_Keyword__Group_3__19276);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4615:1: rule__Scanner_Keyword__Group_3__1__Impl : ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) ) ;
    public final void rule__Scanner_Keyword__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4619:1: ( ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4620:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4620:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4621:1: ( rule__Scanner_Keyword__KeywordsAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_3_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4622:1: ( rule__Scanner_Keyword__KeywordsAssignment_3_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4622:2: rule__Scanner_Keyword__KeywordsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_3_1_in_rule__Scanner_Keyword__Group_3__1__Impl9303);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4636:1: rule__Keyword__Group__0 : rule__Keyword__Group__0__Impl rule__Keyword__Group__1 ;
    public final void rule__Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4640:1: ( rule__Keyword__Group__0__Impl rule__Keyword__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4641:2: rule__Keyword__Group__0__Impl rule__Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__09337);
            rule__Keyword__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__09340);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4648:1: rule__Keyword__Group__0__Impl : ( ( rule__Keyword__NameAssignment_0 ) ) ;
    public final void rule__Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4652:1: ( ( ( rule__Keyword__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4653:1: ( ( rule__Keyword__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4653:1: ( ( rule__Keyword__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4654:1: ( rule__Keyword__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4655:1: ( rule__Keyword__NameAssignment_0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4655:2: rule__Keyword__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl9367);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4665:1: rule__Keyword__Group__1 : rule__Keyword__Group__1__Impl ;
    public final void rule__Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4669:1: ( rule__Keyword__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4670:2: rule__Keyword__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__19397);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4676:1: rule__Keyword__Group__1__Impl : ( ( rule__Keyword__Group_1__0 )? ) ;
    public final void rule__Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4680:1: ( ( ( rule__Keyword__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4681:1: ( ( rule__Keyword__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4681:1: ( ( rule__Keyword__Group_1__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4682:1: ( rule__Keyword__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getGroup_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4683:1: ( rule__Keyword__Group_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==36) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4683:2: rule__Keyword__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl9424);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4697:1: rule__Keyword__Group_1__0 : rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 ;
    public final void rule__Keyword__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4701:1: ( rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4702:2: rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__09459);
            rule__Keyword__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__09462);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4709:1: rule__Keyword__Group_1__0__Impl : ( 'since' ) ;
    public final void rule__Keyword__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4713:1: ( ( 'since' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4714:1: ( 'since' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4714:1: ( 'since' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4715:1: 'since'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__Keyword__Group_1__0__Impl9490); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4728:1: rule__Keyword__Group_1__1 : rule__Keyword__Group_1__1__Impl ;
    public final void rule__Keyword__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4732:1: ( rule__Keyword__Group_1__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4733:2: rule__Keyword__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__19521);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4739:1: rule__Keyword__Group_1__1__Impl : ( ( rule__Keyword__VersionAssignment_1_1 ) ) ;
    public final void rule__Keyword__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4743:1: ( ( ( rule__Keyword__VersionAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4744:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4744:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4745:1: ( rule__Keyword__VersionAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4746:1: ( rule__Keyword__VersionAssignment_1_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4746:2: rule__Keyword__VersionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl9548);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4760:1: rule__Scanner_SingleLineRule__Group__0 : rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1 ;
    public final void rule__Scanner_SingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4764:1: ( rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4765:2: rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__0__Impl_in_rule__Scanner_SingleLineRule__Group__09582);
            rule__Scanner_SingleLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__1_in_rule__Scanner_SingleLineRule__Group__09585);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4772:1: rule__Scanner_SingleLineRule__Group__0__Impl : ( 'single_line' ) ;
    public final void rule__Scanner_SingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4776:1: ( ( 'single_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4777:1: ( 'single_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4777:1: ( 'single_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4778:1: 'single_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__Scanner_SingleLineRule__Group__0__Impl9613); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4791:1: rule__Scanner_SingleLineRule__Group__1 : rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2 ;
    public final void rule__Scanner_SingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4795:1: ( rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4796:2: rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__1__Impl_in_rule__Scanner_SingleLineRule__Group__19644);
            rule__Scanner_SingleLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__2_in_rule__Scanner_SingleLineRule__Group__19647);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4803:1: rule__Scanner_SingleLineRule__Group__1__Impl : ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4807:1: ( ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4808:1: ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4808:1: ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4809:1: ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4810:1: ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4810:2: rule__Scanner_SingleLineRule__StartSeqAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__StartSeqAssignment_1_in_rule__Scanner_SingleLineRule__Group__1__Impl9674);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4820:1: rule__Scanner_SingleLineRule__Group__2 : rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3 ;
    public final void rule__Scanner_SingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4824:1: ( rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4825:2: rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__2__Impl_in_rule__Scanner_SingleLineRule__Group__29704);
            rule__Scanner_SingleLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__3_in_rule__Scanner_SingleLineRule__Group__29707);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4832:1: rule__Scanner_SingleLineRule__Group__2__Impl : ( ( rule__Scanner_SingleLineRule__Group_2__0 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4836:1: ( ( ( rule__Scanner_SingleLineRule__Group_2__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4837:1: ( ( rule__Scanner_SingleLineRule__Group_2__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4837:1: ( ( rule__Scanner_SingleLineRule__Group_2__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4838:1: ( rule__Scanner_SingleLineRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4839:1: ( rule__Scanner_SingleLineRule__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==27) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4839:2: rule__Scanner_SingleLineRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_2__0_in_rule__Scanner_SingleLineRule__Group__2__Impl9734);
                    rule__Scanner_SingleLineRule__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_2()); 
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4849:1: rule__Scanner_SingleLineRule__Group__3 : rule__Scanner_SingleLineRule__Group__3__Impl ;
    public final void rule__Scanner_SingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4853:1: ( rule__Scanner_SingleLineRule__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4854:2: rule__Scanner_SingleLineRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__3__Impl_in_rule__Scanner_SingleLineRule__Group__39765);
            rule__Scanner_SingleLineRule__Group__3__Impl();

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4860:1: rule__Scanner_SingleLineRule__Group__3__Impl : ( ( rule__Scanner_SingleLineRule__Group_3__0 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4864:1: ( ( ( rule__Scanner_SingleLineRule__Group_3__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4865:1: ( ( rule__Scanner_SingleLineRule__Group_3__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4865:1: ( ( rule__Scanner_SingleLineRule__Group_3__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4866:1: ( rule__Scanner_SingleLineRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4867:1: ( rule__Scanner_SingleLineRule__Group_3__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==28) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4867:2: rule__Scanner_SingleLineRule__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_3__0_in_rule__Scanner_SingleLineRule__Group__3__Impl9792);
                    rule__Scanner_SingleLineRule__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_3()); 
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


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_2__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4885:1: rule__Scanner_SingleLineRule__Group_2__0 : rule__Scanner_SingleLineRule__Group_2__0__Impl rule__Scanner_SingleLineRule__Group_2__1 ;
    public final void rule__Scanner_SingleLineRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4889:1: ( rule__Scanner_SingleLineRule__Group_2__0__Impl rule__Scanner_SingleLineRule__Group_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4890:2: rule__Scanner_SingleLineRule__Group_2__0__Impl rule__Scanner_SingleLineRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_2__0__Impl_in_rule__Scanner_SingleLineRule__Group_2__09831);
            rule__Scanner_SingleLineRule__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_2__1_in_rule__Scanner_SingleLineRule__Group_2__09834);
            rule__Scanner_SingleLineRule__Group_2__1();

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
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_2__0"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_2__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4897:1: rule__Scanner_SingleLineRule__Group_2__0__Impl : ( '=>' ) ;
    public final void rule__Scanner_SingleLineRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4901:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4902:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4902:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4903:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__Scanner_SingleLineRule__Group_2__0__Impl9862); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2_0()); 
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
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_2__0__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_2__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4916:1: rule__Scanner_SingleLineRule__Group_2__1 : rule__Scanner_SingleLineRule__Group_2__1__Impl ;
    public final void rule__Scanner_SingleLineRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4920:1: ( rule__Scanner_SingleLineRule__Group_2__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4921:2: rule__Scanner_SingleLineRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_2__1__Impl_in_rule__Scanner_SingleLineRule__Group_2__19893);
            rule__Scanner_SingleLineRule__Group_2__1__Impl();

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
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_2__1"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_2__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4927:1: rule__Scanner_SingleLineRule__Group_2__1__Impl : ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_2_1 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4931:1: ( ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_2_1 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4932:1: ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_2_1 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4932:1: ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_2_1 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4933:1: ( rule__Scanner_SingleLineRule__EndSeqAssignment_2_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4934:1: ( rule__Scanner_SingleLineRule__EndSeqAssignment_2_1 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_STRING) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4934:2: rule__Scanner_SingleLineRule__EndSeqAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__Scanner_SingleLineRule__EndSeqAssignment_2_1_in_rule__Scanner_SingleLineRule__Group_2__1__Impl9920);
                    rule__Scanner_SingleLineRule__EndSeqAssignment_2_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqAssignment_2_1()); 
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
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_2__1__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_3__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4948:1: rule__Scanner_SingleLineRule__Group_3__0 : rule__Scanner_SingleLineRule__Group_3__0__Impl rule__Scanner_SingleLineRule__Group_3__1 ;
    public final void rule__Scanner_SingleLineRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4952:1: ( rule__Scanner_SingleLineRule__Group_3__0__Impl rule__Scanner_SingleLineRule__Group_3__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4953:2: rule__Scanner_SingleLineRule__Group_3__0__Impl rule__Scanner_SingleLineRule__Group_3__1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_3__0__Impl_in_rule__Scanner_SingleLineRule__Group_3__09955);
            rule__Scanner_SingleLineRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_3__1_in_rule__Scanner_SingleLineRule__Group_3__09958);
            rule__Scanner_SingleLineRule__Group_3__1();

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
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_3__0"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_3__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4960:1: rule__Scanner_SingleLineRule__Group_3__0__Impl : ( 'escaped' ) ;
    public final void rule__Scanner_SingleLineRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4964:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4965:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4965:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4966:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_3_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__Scanner_SingleLineRule__Group_3__0__Impl9986); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_3_0()); 
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
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_3__0__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_3__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4979:1: rule__Scanner_SingleLineRule__Group_3__1 : rule__Scanner_SingleLineRule__Group_3__1__Impl rule__Scanner_SingleLineRule__Group_3__2 ;
    public final void rule__Scanner_SingleLineRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4983:1: ( rule__Scanner_SingleLineRule__Group_3__1__Impl rule__Scanner_SingleLineRule__Group_3__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4984:2: rule__Scanner_SingleLineRule__Group_3__1__Impl rule__Scanner_SingleLineRule__Group_3__2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_3__1__Impl_in_rule__Scanner_SingleLineRule__Group_3__110017);
            rule__Scanner_SingleLineRule__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_3__2_in_rule__Scanner_SingleLineRule__Group_3__110020);
            rule__Scanner_SingleLineRule__Group_3__2();

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
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_3__1"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_3__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4991:1: rule__Scanner_SingleLineRule__Group_3__1__Impl : ( 'by' ) ;
    public final void rule__Scanner_SingleLineRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4995:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4996:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4996:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4997:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_3_1()); 
            }
            match(input,29,FOLLOW_29_in_rule__Scanner_SingleLineRule__Group_3__1__Impl10048); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_3_1()); 
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
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_3__1__Impl"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_3__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5010:1: rule__Scanner_SingleLineRule__Group_3__2 : rule__Scanner_SingleLineRule__Group_3__2__Impl ;
    public final void rule__Scanner_SingleLineRule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5014:1: ( rule__Scanner_SingleLineRule__Group_3__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5015:2: rule__Scanner_SingleLineRule__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_3__2__Impl_in_rule__Scanner_SingleLineRule__Group_3__210079);
            rule__Scanner_SingleLineRule__Group_3__2__Impl();

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
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_3__2"


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_3__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5021:1: rule__Scanner_SingleLineRule__Group_3__2__Impl : ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5025:1: ( ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5026:1: ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5026:1: ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5027:1: ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqAssignment_3_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5028:1: ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5028:2: rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2_in_rule__Scanner_SingleLineRule__Group_3__2__Impl10106);
            rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqAssignment_3_2()); 
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
    // $ANTLR end "rule__Scanner_SingleLineRule__Group_3__2__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5044:1: rule__Scanner_MultiLineRule__Group__0 : rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1 ;
    public final void rule__Scanner_MultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5048:1: ( rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5049:2: rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__0__Impl_in_rule__Scanner_MultiLineRule__Group__010142);
            rule__Scanner_MultiLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__1_in_rule__Scanner_MultiLineRule__Group__010145);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5056:1: rule__Scanner_MultiLineRule__Group__0__Impl : ( 'multi_line' ) ;
    public final void rule__Scanner_MultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5060:1: ( ( 'multi_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5061:1: ( 'multi_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5061:1: ( 'multi_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5062:1: 'multi_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__Scanner_MultiLineRule__Group__0__Impl10173); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5075:1: rule__Scanner_MultiLineRule__Group__1 : rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2 ;
    public final void rule__Scanner_MultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5079:1: ( rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5080:2: rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__1__Impl_in_rule__Scanner_MultiLineRule__Group__110204);
            rule__Scanner_MultiLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__2_in_rule__Scanner_MultiLineRule__Group__110207);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5087:1: rule__Scanner_MultiLineRule__Group__1__Impl : ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5091:1: ( ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5092:1: ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5092:1: ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5093:1: ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5094:1: ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5094:2: rule__Scanner_MultiLineRule__StartSeqAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__StartSeqAssignment_1_in_rule__Scanner_MultiLineRule__Group__1__Impl10234);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5104:1: rule__Scanner_MultiLineRule__Group__2 : rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3 ;
    public final void rule__Scanner_MultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5108:1: ( rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5109:2: rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__2__Impl_in_rule__Scanner_MultiLineRule__Group__210264);
            rule__Scanner_MultiLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__3_in_rule__Scanner_MultiLineRule__Group__210267);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5116:1: rule__Scanner_MultiLineRule__Group__2__Impl : ( '=>' ) ;
    public final void rule__Scanner_MultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5120:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5121:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5121:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5122:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 
            }
            match(input,27,FOLLOW_27_in_rule__Scanner_MultiLineRule__Group__2__Impl10295); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5135:1: rule__Scanner_MultiLineRule__Group__3 : rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4 ;
    public final void rule__Scanner_MultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5139:1: ( rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5140:2: rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__3__Impl_in_rule__Scanner_MultiLineRule__Group__310326);
            rule__Scanner_MultiLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__4_in_rule__Scanner_MultiLineRule__Group__310329);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5147:1: rule__Scanner_MultiLineRule__Group__3__Impl : ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5151:1: ( ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5152:1: ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5152:1: ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5153:1: ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5154:1: ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5154:2: rule__Scanner_MultiLineRule__EndSeqAssignment_3
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__EndSeqAssignment_3_in_rule__Scanner_MultiLineRule__Group__3__Impl10356);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5164:1: rule__Scanner_MultiLineRule__Group__4 : rule__Scanner_MultiLineRule__Group__4__Impl ;
    public final void rule__Scanner_MultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5168:1: ( rule__Scanner_MultiLineRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5169:2: rule__Scanner_MultiLineRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__4__Impl_in_rule__Scanner_MultiLineRule__Group__410386);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5175:1: rule__Scanner_MultiLineRule__Group__4__Impl : ( ( rule__Scanner_MultiLineRule__Group_4__0 )? ) ;
    public final void rule__Scanner_MultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5179:1: ( ( ( rule__Scanner_MultiLineRule__Group_4__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5180:1: ( ( rule__Scanner_MultiLineRule__Group_4__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5180:1: ( ( rule__Scanner_MultiLineRule__Group_4__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5181:1: ( rule__Scanner_MultiLineRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5182:1: ( rule__Scanner_MultiLineRule__Group_4__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==28) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5182:2: rule__Scanner_MultiLineRule__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__0_in_rule__Scanner_MultiLineRule__Group__4__Impl10413);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5202:1: rule__Scanner_MultiLineRule__Group_4__0 : rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1 ;
    public final void rule__Scanner_MultiLineRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5206:1: ( rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5207:2: rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__0__Impl_in_rule__Scanner_MultiLineRule__Group_4__010454);
            rule__Scanner_MultiLineRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__1_in_rule__Scanner_MultiLineRule__Group_4__010457);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5214:1: rule__Scanner_MultiLineRule__Group_4__0__Impl : ( 'escaped' ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5218:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5219:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5219:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5220:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_4_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__Scanner_MultiLineRule__Group_4__0__Impl10485); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5233:1: rule__Scanner_MultiLineRule__Group_4__1 : rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2 ;
    public final void rule__Scanner_MultiLineRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5237:1: ( rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5238:2: rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__1__Impl_in_rule__Scanner_MultiLineRule__Group_4__110516);
            rule__Scanner_MultiLineRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__2_in_rule__Scanner_MultiLineRule__Group_4__110519);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5245:1: rule__Scanner_MultiLineRule__Group_4__1__Impl : ( 'by' ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5249:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5250:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5250:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5251:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_4_1()); 
            }
            match(input,29,FOLLOW_29_in_rule__Scanner_MultiLineRule__Group_4__1__Impl10547); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5264:1: rule__Scanner_MultiLineRule__Group_4__2 : rule__Scanner_MultiLineRule__Group_4__2__Impl ;
    public final void rule__Scanner_MultiLineRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5268:1: ( rule__Scanner_MultiLineRule__Group_4__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5269:2: rule__Scanner_MultiLineRule__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__2__Impl_in_rule__Scanner_MultiLineRule__Group_4__210578);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5275:1: rule__Scanner_MultiLineRule__Group_4__2__Impl : ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5279:1: ( ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5280:1: ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5280:1: ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5281:1: ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5282:1: ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5282:2: rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_MultiLineRule__Group_4__2__Impl10605);
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


    // $ANTLR start "rule__Scanner_PatternRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5298:1: rule__Scanner_PatternRule__Group__0 : rule__Scanner_PatternRule__Group__0__Impl rule__Scanner_PatternRule__Group__1 ;
    public final void rule__Scanner_PatternRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5302:1: ( rule__Scanner_PatternRule__Group__0__Impl rule__Scanner_PatternRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5303:2: rule__Scanner_PatternRule__Group__0__Impl rule__Scanner_PatternRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_PatternRule__Group__0__Impl_in_rule__Scanner_PatternRule__Group__010641);
            rule__Scanner_PatternRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_PatternRule__Group__1_in_rule__Scanner_PatternRule__Group__010644);
            rule__Scanner_PatternRule__Group__1();

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
    // $ANTLR end "rule__Scanner_PatternRule__Group__0"


    // $ANTLR start "rule__Scanner_PatternRule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5310:1: rule__Scanner_PatternRule__Group__0__Impl : ( 'pattern' ) ;
    public final void rule__Scanner_PatternRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5314:1: ( ( 'pattern' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5315:1: ( 'pattern' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5315:1: ( 'pattern' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5316:1: 'pattern'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getPatternKeyword_0()); 
            }
            match(input,37,FOLLOW_37_in_rule__Scanner_PatternRule__Group__0__Impl10672); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getPatternKeyword_0()); 
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
    // $ANTLR end "rule__Scanner_PatternRule__Group__0__Impl"


    // $ANTLR start "rule__Scanner_PatternRule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5329:1: rule__Scanner_PatternRule__Group__1 : rule__Scanner_PatternRule__Group__1__Impl rule__Scanner_PatternRule__Group__2 ;
    public final void rule__Scanner_PatternRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5333:1: ( rule__Scanner_PatternRule__Group__1__Impl rule__Scanner_PatternRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5334:2: rule__Scanner_PatternRule__Group__1__Impl rule__Scanner_PatternRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_PatternRule__Group__1__Impl_in_rule__Scanner_PatternRule__Group__110703);
            rule__Scanner_PatternRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_PatternRule__Group__2_in_rule__Scanner_PatternRule__Group__110706);
            rule__Scanner_PatternRule__Group__2();

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
    // $ANTLR end "rule__Scanner_PatternRule__Group__1"


    // $ANTLR start "rule__Scanner_PatternRule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5341:1: rule__Scanner_PatternRule__Group__1__Impl : ( ( rule__Scanner_PatternRule__StartPatternAssignment_1 ) ) ;
    public final void rule__Scanner_PatternRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5345:1: ( ( ( rule__Scanner_PatternRule__StartPatternAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5346:1: ( ( rule__Scanner_PatternRule__StartPatternAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5346:1: ( ( rule__Scanner_PatternRule__StartPatternAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5347:1: ( rule__Scanner_PatternRule__StartPatternAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getStartPatternAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5348:1: ( rule__Scanner_PatternRule__StartPatternAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5348:2: rule__Scanner_PatternRule__StartPatternAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_PatternRule__StartPatternAssignment_1_in_rule__Scanner_PatternRule__Group__1__Impl10733);
            rule__Scanner_PatternRule__StartPatternAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getStartPatternAssignment_1()); 
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
    // $ANTLR end "rule__Scanner_PatternRule__Group__1__Impl"


    // $ANTLR start "rule__Scanner_PatternRule__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5358:1: rule__Scanner_PatternRule__Group__2 : rule__Scanner_PatternRule__Group__2__Impl rule__Scanner_PatternRule__Group__3 ;
    public final void rule__Scanner_PatternRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5362:1: ( rule__Scanner_PatternRule__Group__2__Impl rule__Scanner_PatternRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5363:2: rule__Scanner_PatternRule__Group__2__Impl rule__Scanner_PatternRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_PatternRule__Group__2__Impl_in_rule__Scanner_PatternRule__Group__210763);
            rule__Scanner_PatternRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_PatternRule__Group__3_in_rule__Scanner_PatternRule__Group__210766);
            rule__Scanner_PatternRule__Group__3();

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
    // $ANTLR end "rule__Scanner_PatternRule__Group__2"


    // $ANTLR start "rule__Scanner_PatternRule__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5370:1: rule__Scanner_PatternRule__Group__2__Impl : ( ( rule__Scanner_PatternRule__LengthAssignment_2 )? ) ;
    public final void rule__Scanner_PatternRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5374:1: ( ( ( rule__Scanner_PatternRule__LengthAssignment_2 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5375:1: ( ( rule__Scanner_PatternRule__LengthAssignment_2 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5375:1: ( ( rule__Scanner_PatternRule__LengthAssignment_2 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5376:1: ( rule__Scanner_PatternRule__LengthAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getLengthAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5377:1: ( rule__Scanner_PatternRule__LengthAssignment_2 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_INT) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5377:2: rule__Scanner_PatternRule__LengthAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Scanner_PatternRule__LengthAssignment_2_in_rule__Scanner_PatternRule__Group__2__Impl10793);
                    rule__Scanner_PatternRule__LengthAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getLengthAssignment_2()); 
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
    // $ANTLR end "rule__Scanner_PatternRule__Group__2__Impl"


    // $ANTLR start "rule__Scanner_PatternRule__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5387:1: rule__Scanner_PatternRule__Group__3 : rule__Scanner_PatternRule__Group__3__Impl rule__Scanner_PatternRule__Group__4 ;
    public final void rule__Scanner_PatternRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5391:1: ( rule__Scanner_PatternRule__Group__3__Impl rule__Scanner_PatternRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5392:2: rule__Scanner_PatternRule__Group__3__Impl rule__Scanner_PatternRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_PatternRule__Group__3__Impl_in_rule__Scanner_PatternRule__Group__310824);
            rule__Scanner_PatternRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_PatternRule__Group__4_in_rule__Scanner_PatternRule__Group__310827);
            rule__Scanner_PatternRule__Group__4();

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
    // $ANTLR end "rule__Scanner_PatternRule__Group__3"


    // $ANTLR start "rule__Scanner_PatternRule__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5399:1: rule__Scanner_PatternRule__Group__3__Impl : ( 'containing' ) ;
    public final void rule__Scanner_PatternRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5403:1: ( ( 'containing' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5404:1: ( 'containing' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5404:1: ( 'containing' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5405:1: 'containing'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getContainingKeyword_3()); 
            }
            match(input,38,FOLLOW_38_in_rule__Scanner_PatternRule__Group__3__Impl10855); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getContainingKeyword_3()); 
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
    // $ANTLR end "rule__Scanner_PatternRule__Group__3__Impl"


    // $ANTLR start "rule__Scanner_PatternRule__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5418:1: rule__Scanner_PatternRule__Group__4 : rule__Scanner_PatternRule__Group__4__Impl ;
    public final void rule__Scanner_PatternRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5422:1: ( rule__Scanner_PatternRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5423:2: rule__Scanner_PatternRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_PatternRule__Group__4__Impl_in_rule__Scanner_PatternRule__Group__410886);
            rule__Scanner_PatternRule__Group__4__Impl();

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
    // $ANTLR end "rule__Scanner_PatternRule__Group__4"


    // $ANTLR start "rule__Scanner_PatternRule__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5429:1: rule__Scanner_PatternRule__Group__4__Impl : ( ( rule__Scanner_PatternRule__ContentPatternAssignment_4 ) ) ;
    public final void rule__Scanner_PatternRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5433:1: ( ( ( rule__Scanner_PatternRule__ContentPatternAssignment_4 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5434:1: ( ( rule__Scanner_PatternRule__ContentPatternAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5434:1: ( ( rule__Scanner_PatternRule__ContentPatternAssignment_4 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5435:1: ( rule__Scanner_PatternRule__ContentPatternAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getContentPatternAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5436:1: ( rule__Scanner_PatternRule__ContentPatternAssignment_4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5436:2: rule__Scanner_PatternRule__ContentPatternAssignment_4
            {
            pushFollow(FOLLOW_rule__Scanner_PatternRule__ContentPatternAssignment_4_in_rule__Scanner_PatternRule__Group__4__Impl10913);
            rule__Scanner_PatternRule__ContentPatternAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getContentPatternAssignment_4()); 
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
    // $ANTLR end "rule__Scanner_PatternRule__Group__4__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5456:1: rule__Scanner_CharacterRule__Group__0 : rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1 ;
    public final void rule__Scanner_CharacterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5460:1: ( rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5461:2: rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__0__Impl_in_rule__Scanner_CharacterRule__Group__010953);
            rule__Scanner_CharacterRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__1_in_rule__Scanner_CharacterRule__Group__010956);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5468:1: rule__Scanner_CharacterRule__Group__0__Impl : ( 'character' ) ;
    public final void rule__Scanner_CharacterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5472:1: ( ( 'character' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5473:1: ( 'character' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5473:1: ( 'character' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5474:1: 'character'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0()); 
            }
            match(input,39,FOLLOW_39_in_rule__Scanner_CharacterRule__Group__0__Impl10984); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5487:1: rule__Scanner_CharacterRule__Group__1 : rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2 ;
    public final void rule__Scanner_CharacterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5491:1: ( rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5492:2: rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__1__Impl_in_rule__Scanner_CharacterRule__Group__111015);
            rule__Scanner_CharacterRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__2_in_rule__Scanner_CharacterRule__Group__111018);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5499:1: rule__Scanner_CharacterRule__Group__1__Impl : ( '[' ) ;
    public final void rule__Scanner_CharacterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5503:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5504:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5504:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5505:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,33,FOLLOW_33_in_rule__Scanner_CharacterRule__Group__1__Impl11046); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5518:1: rule__Scanner_CharacterRule__Group__2 : rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3 ;
    public final void rule__Scanner_CharacterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5522:1: ( rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5523:2: rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__2__Impl_in_rule__Scanner_CharacterRule__Group__211077);
            rule__Scanner_CharacterRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__3_in_rule__Scanner_CharacterRule__Group__211080);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5530:1: rule__Scanner_CharacterRule__Group__2__Impl : ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) ) ;
    public final void rule__Scanner_CharacterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5534:1: ( ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5535:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5535:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5536:1: ( rule__Scanner_CharacterRule__CharactersAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5537:1: ( rule__Scanner_CharacterRule__CharactersAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5537:2: rule__Scanner_CharacterRule__CharactersAssignment_2
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_2_in_rule__Scanner_CharacterRule__Group__2__Impl11107);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5547:1: rule__Scanner_CharacterRule__Group__3 : rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4 ;
    public final void rule__Scanner_CharacterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5551:1: ( rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5552:2: rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__3__Impl_in_rule__Scanner_CharacterRule__Group__311137);
            rule__Scanner_CharacterRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__4_in_rule__Scanner_CharacterRule__Group__311140);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5559:1: rule__Scanner_CharacterRule__Group__3__Impl : ( ( rule__Scanner_CharacterRule__Group_3__0 )* ) ;
    public final void rule__Scanner_CharacterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5563:1: ( ( ( rule__Scanner_CharacterRule__Group_3__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5564:1: ( ( rule__Scanner_CharacterRule__Group_3__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5564:1: ( ( rule__Scanner_CharacterRule__Group_3__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5565:1: ( rule__Scanner_CharacterRule__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getGroup_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5566:1: ( rule__Scanner_CharacterRule__Group_3__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==35) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5566:2: rule__Scanner_CharacterRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__0_in_rule__Scanner_CharacterRule__Group__3__Impl11167);
            	    rule__Scanner_CharacterRule__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5576:1: rule__Scanner_CharacterRule__Group__4 : rule__Scanner_CharacterRule__Group__4__Impl ;
    public final void rule__Scanner_CharacterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5580:1: ( rule__Scanner_CharacterRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5581:2: rule__Scanner_CharacterRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__4__Impl_in_rule__Scanner_CharacterRule__Group__411198);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5587:1: rule__Scanner_CharacterRule__Group__4__Impl : ( ']' ) ;
    public final void rule__Scanner_CharacterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5591:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5592:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5592:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5593:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,34,FOLLOW_34_in_rule__Scanner_CharacterRule__Group__4__Impl11226); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5616:1: rule__Scanner_CharacterRule__Group_3__0 : rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1 ;
    public final void rule__Scanner_CharacterRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5620:1: ( rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5621:2: rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__0__Impl_in_rule__Scanner_CharacterRule__Group_3__011267);
            rule__Scanner_CharacterRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__1_in_rule__Scanner_CharacterRule__Group_3__011270);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5628:1: rule__Scanner_CharacterRule__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Scanner_CharacterRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5632:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5633:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5633:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5634:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__Scanner_CharacterRule__Group_3__0__Impl11298); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5647:1: rule__Scanner_CharacterRule__Group_3__1 : rule__Scanner_CharacterRule__Group_3__1__Impl ;
    public final void rule__Scanner_CharacterRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5651:1: ( rule__Scanner_CharacterRule__Group_3__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5652:2: rule__Scanner_CharacterRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__1__Impl_in_rule__Scanner_CharacterRule__Group_3__111329);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5658:1: rule__Scanner_CharacterRule__Group_3__1__Impl : ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) ) ;
    public final void rule__Scanner_CharacterRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5662:1: ( ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5663:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5663:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5664:1: ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_3_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5665:1: ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5665:2: rule__Scanner_CharacterRule__CharactersAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_3_1_in_rule__Scanner_CharacterRule__Group_3__1__Impl11356);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5679:1: rule__Scanner_JSRule__Group__0 : rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1 ;
    public final void rule__Scanner_JSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5683:1: ( rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5684:2: rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__0__Impl_in_rule__Scanner_JSRule__Group__011390);
            rule__Scanner_JSRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__1_in_rule__Scanner_JSRule__Group__011393);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5691:1: rule__Scanner_JSRule__Group__0__Impl : ( 'script' ) ;
    public final void rule__Scanner_JSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5695:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5696:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5696:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5697:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__Scanner_JSRule__Group__0__Impl11421); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5710:1: rule__Scanner_JSRule__Group__1 : rule__Scanner_JSRule__Group__1__Impl ;
    public final void rule__Scanner_JSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5714:1: ( rule__Scanner_JSRule__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5715:2: rule__Scanner_JSRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__1__Impl_in_rule__Scanner_JSRule__Group__111452);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5721:1: rule__Scanner_JSRule__Group__1__Impl : ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) ) ;
    public final void rule__Scanner_JSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5725:1: ( ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5726:1: ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5726:1: ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5727:1: ( rule__Scanner_JSRule__FileURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getFileURIAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5728:1: ( rule__Scanner_JSRule__FileURIAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5728:2: rule__Scanner_JSRule__FileURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__FileURIAssignment_1_in_rule__Scanner_JSRule__Group__1__Impl11479);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5742:1: rule__WhitespaceRule__Group__0 : rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1 ;
    public final void rule__WhitespaceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5746:1: ( rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5747:2: rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__0__Impl_in_rule__WhitespaceRule__Group__011513);
            rule__WhitespaceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__1_in_rule__WhitespaceRule__Group__011516);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5754:1: rule__WhitespaceRule__Group__0__Impl : ( 'whitespace' ) ;
    public final void rule__WhitespaceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5758:1: ( ( 'whitespace' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5759:1: ( 'whitespace' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5759:1: ( 'whitespace' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5760:1: 'whitespace'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getWhitespaceKeyword_0()); 
            }
            match(input,40,FOLLOW_40_in_rule__WhitespaceRule__Group__0__Impl11544); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5773:1: rule__WhitespaceRule__Group__1 : rule__WhitespaceRule__Group__1__Impl ;
    public final void rule__WhitespaceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5777:1: ( rule__WhitespaceRule__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5778:2: rule__WhitespaceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__1__Impl_in_rule__WhitespaceRule__Group__111575);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5784:1: rule__WhitespaceRule__Group__1__Impl : ( ( rule__WhitespaceRule__Alternatives_1 ) ) ;
    public final void rule__WhitespaceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5788:1: ( ( ( rule__WhitespaceRule__Alternatives_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5789:1: ( ( rule__WhitespaceRule__Alternatives_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5789:1: ( ( rule__WhitespaceRule__Alternatives_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5790:1: ( rule__WhitespaceRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5791:1: ( rule__WhitespaceRule__Alternatives_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5791:2: rule__WhitespaceRule__Alternatives_1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Alternatives_1_in_rule__WhitespaceRule__Group__1__Impl11602);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5805:1: rule__WhitespaceRule__Group_1_0__0 : rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1 ;
    public final void rule__WhitespaceRule__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5809:1: ( rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5810:2: rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__0__Impl_in_rule__WhitespaceRule__Group_1_0__011636);
            rule__WhitespaceRule__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__1_in_rule__WhitespaceRule__Group_1_0__011639);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5817:1: rule__WhitespaceRule__Group_1_0__0__Impl : ( '[' ) ;
    public final void rule__WhitespaceRule__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5821:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5822:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5822:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5823:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0()); 
            }
            match(input,33,FOLLOW_33_in_rule__WhitespaceRule__Group_1_0__0__Impl11667); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5836:1: rule__WhitespaceRule__Group_1_0__1 : rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2 ;
    public final void rule__WhitespaceRule__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5840:1: ( rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5841:2: rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__1__Impl_in_rule__WhitespaceRule__Group_1_0__111698);
            rule__WhitespaceRule__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__2_in_rule__WhitespaceRule__Group_1_0__111701);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5848:1: rule__WhitespaceRule__Group_1_0__1__Impl : ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) ) ;
    public final void rule__WhitespaceRule__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5852:1: ( ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5853:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5853:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5854:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersAssignment_1_0_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5855:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5855:2: rule__WhitespaceRule__CharactersAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_1_in_rule__WhitespaceRule__Group_1_0__1__Impl11728);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5865:1: rule__WhitespaceRule__Group_1_0__2 : rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3 ;
    public final void rule__WhitespaceRule__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5869:1: ( rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5870:2: rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__2__Impl_in_rule__WhitespaceRule__Group_1_0__211758);
            rule__WhitespaceRule__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__3_in_rule__WhitespaceRule__Group_1_0__211761);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5877:1: rule__WhitespaceRule__Group_1_0__2__Impl : ( ( rule__WhitespaceRule__Group_1_0_2__0 )* ) ;
    public final void rule__WhitespaceRule__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5881:1: ( ( ( rule__WhitespaceRule__Group_1_0_2__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5882:1: ( ( rule__WhitespaceRule__Group_1_0_2__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5882:1: ( ( rule__WhitespaceRule__Group_1_0_2__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5883:1: ( rule__WhitespaceRule__Group_1_0_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getGroup_1_0_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5884:1: ( rule__WhitespaceRule__Group_1_0_2__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==35) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5884:2: rule__WhitespaceRule__Group_1_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__0_in_rule__WhitespaceRule__Group_1_0__2__Impl11788);
            	    rule__WhitespaceRule__Group_1_0_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop40;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5894:1: rule__WhitespaceRule__Group_1_0__3 : rule__WhitespaceRule__Group_1_0__3__Impl ;
    public final void rule__WhitespaceRule__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5898:1: ( rule__WhitespaceRule__Group_1_0__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5899:2: rule__WhitespaceRule__Group_1_0__3__Impl
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__3__Impl_in_rule__WhitespaceRule__Group_1_0__311819);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5905:1: rule__WhitespaceRule__Group_1_0__3__Impl : ( ']' ) ;
    public final void rule__WhitespaceRule__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5909:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5910:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5910:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5911:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3()); 
            }
            match(input,34,FOLLOW_34_in_rule__WhitespaceRule__Group_1_0__3__Impl11847); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5932:1: rule__WhitespaceRule__Group_1_0_2__0 : rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1 ;
    public final void rule__WhitespaceRule__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5936:1: ( rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5937:2: rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__0__Impl_in_rule__WhitespaceRule__Group_1_0_2__011886);
            rule__WhitespaceRule__Group_1_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__1_in_rule__WhitespaceRule__Group_1_0_2__011889);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5944:1: rule__WhitespaceRule__Group_1_0_2__0__Impl : ( ',' ) ;
    public final void rule__WhitespaceRule__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5948:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5949:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5949:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5950:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCommaKeyword_1_0_2_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__WhitespaceRule__Group_1_0_2__0__Impl11917); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5963:1: rule__WhitespaceRule__Group_1_0_2__1 : rule__WhitespaceRule__Group_1_0_2__1__Impl ;
    public final void rule__WhitespaceRule__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5967:1: ( rule__WhitespaceRule__Group_1_0_2__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5968:2: rule__WhitespaceRule__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__1__Impl_in_rule__WhitespaceRule__Group_1_0_2__111948);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5974:1: rule__WhitespaceRule__Group_1_0_2__1__Impl : ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) ) ;
    public final void rule__WhitespaceRule__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5978:1: ( ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5979:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5979:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5980:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersAssignment_1_0_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5981:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5981:2: rule__WhitespaceRule__CharactersAssignment_1_0_2_1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_2_1_in_rule__WhitespaceRule__Group_1_0_2__1__Impl11975);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5996:1: rule__Root__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Root__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6000:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6001:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6001:1: ( ruleQualifiedName )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6002:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Root__NameAssignment_112014);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6011:1: rule__Root__ImportsAssignment_2 : ( ruleImport ) ;
    public final void rule__Root__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6015:1: ( ( ruleImport ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6016:1: ( ruleImport )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6016:1: ( ruleImport )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6017:1: ruleImport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getImportsImportParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleImport_in_rule__Root__ImportsAssignment_212045);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6026:1: rule__Root__LanguageDefinitionAssignment_3 : ( ruleLanguageDef ) ;
    public final void rule__Root__LanguageDefinitionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6030:1: ( ( ruleLanguageDef ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6031:1: ( ruleLanguageDef )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6031:1: ( ruleLanguageDef )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6032:1: ruleLanguageDef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLanguageDefinitionLanguageDefParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleLanguageDef_in_rule__Root__LanguageDefinitionAssignment_312076);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6041:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildCard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6045:1: ( ( ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6046:1: ( ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6046:1: ( ruleQualifiedNameWithWildCard )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6047:1: ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_112107);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6056:1: rule__LanguageDef__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__LanguageDef__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6060:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6061:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6061:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6062:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LanguageDef__NameAssignment_012138); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6071:1: rule__LanguageDef__ParitioningAssignment_2 : ( ruleParitioning ) ;
    public final void rule__LanguageDef__ParitioningAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6075:1: ( ( ruleParitioning ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6076:1: ( ruleParitioning )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6076:1: ( ruleParitioning )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6077:1: ruleParitioning
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getParitioningParitioningParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleParitioning_in_rule__LanguageDef__ParitioningAssignment_212169);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6086:1: rule__LanguageDef__LexicalHighlightingAssignment_3 : ( ruleLexicalHighlighting ) ;
    public final void rule__LanguageDef__LexicalHighlightingAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6090:1: ( ( ruleLexicalHighlighting ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6091:1: ( ruleLexicalHighlighting )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6091:1: ( ruleLexicalHighlighting )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6092:1: ruleLexicalHighlighting
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLexicalHighlightingLexicalHighlightingParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_rule__LanguageDef__LexicalHighlightingAssignment_312200);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6101:1: rule__LanguageDef__IntegrationAssignment_4 : ( ruleIntegration ) ;
    public final void rule__LanguageDef__IntegrationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6105:1: ( ( ruleIntegration ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6106:1: ( ruleIntegration )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6106:1: ( ruleIntegration )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6107:1: ruleIntegration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getIntegrationIntegrationParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleIntegration_in_rule__LanguageDef__IntegrationAssignment_412231);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6116:1: rule__Integration__CodeIntegrationListAssignment_2 : ( ruleCodeIntegration ) ;
    public final void rule__Integration__CodeIntegrationListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6120:1: ( ( ruleCodeIntegration ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6121:1: ( ruleCodeIntegration )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6121:1: ( ruleCodeIntegration )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6122:1: ruleCodeIntegration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListCodeIntegrationParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleCodeIntegration_in_rule__Integration__CodeIntegrationListAssignment_212262);
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


    // $ANTLR start "rule__JavaFXIntegration__CodegenerationListAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6131:1: rule__JavaFXIntegration__CodegenerationListAssignment_2 : ( ruleCodegeneration ) ;
    public final void rule__JavaFXIntegration__CodegenerationListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6135:1: ( ( ruleCodegeneration ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6136:1: ( ruleCodegeneration )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6136:1: ( ruleCodegeneration )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6137:1: ruleCodegeneration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListCodegenerationParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleCodegeneration_in_rule__JavaFXIntegration__CodegenerationListAssignment_212293);
            ruleCodegeneration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListCodegenerationParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__JavaFXIntegration__CodegenerationListAssignment_2"


    // $ANTLR start "rule__JavaCodeGeneration__NameAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6146:1: rule__JavaCodeGeneration__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JavaCodeGeneration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6150:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6151:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6151:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6152:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JavaCodeGeneration__NameAssignment_112324); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getNameSTRINGTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__JavaCodeGeneration__NameAssignment_1"


    // $ANTLR start "rule__JavaCodeGeneration__ConfigValueAssignment_2_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6161:1: rule__JavaCodeGeneration__ConfigValueAssignment_2_1 : ( ruleConfigValue ) ;
    public final void rule__JavaCodeGeneration__ConfigValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6165:1: ( ( ruleConfigValue ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6166:1: ( ruleConfigValue )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6166:1: ( ruleConfigValue )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6167:1: ruleConfigValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getConfigValueConfigValueParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleConfigValue_in_rule__JavaCodeGeneration__ConfigValueAssignment_2_112355);
            ruleConfigValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getConfigValueConfigValueParserRuleCall_2_1_0()); 
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
    // $ANTLR end "rule__JavaCodeGeneration__ConfigValueAssignment_2_1"


    // $ANTLR start "rule__E4CodeGeneration__NameAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6176:1: rule__E4CodeGeneration__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__E4CodeGeneration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6180:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6181:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6181:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6182:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__E4CodeGeneration__NameAssignment_112386); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getNameSTRINGTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__E4CodeGeneration__NameAssignment_1"


    // $ANTLR start "rule__E4CodeGeneration__ConfigValueAssignment_2_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6191:1: rule__E4CodeGeneration__ConfigValueAssignment_2_1 : ( ruleConfigValue ) ;
    public final void rule__E4CodeGeneration__ConfigValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6195:1: ( ( ruleConfigValue ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6196:1: ( ruleConfigValue )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6196:1: ( ruleConfigValue )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6197:1: ruleConfigValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getConfigValueConfigValueParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleConfigValue_in_rule__E4CodeGeneration__ConfigValueAssignment_2_112417);
            ruleConfigValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getConfigValueConfigValueParserRuleCall_2_1_0()); 
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
    // $ANTLR end "rule__E4CodeGeneration__ConfigValueAssignment_2_1"


    // $ANTLR start "rule__ConfigValue__KeyAssignment_0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6206:1: rule__ConfigValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__ConfigValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6210:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6211:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6211:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6212:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConfigValue__KeyAssignment_012448); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getKeyIDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__ConfigValue__KeyAssignment_0"


    // $ANTLR start "rule__ConfigValue__SimpleValueAssignment_2_0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6221:1: rule__ConfigValue__SimpleValueAssignment_2_0 : ( RULE_STRING ) ;
    public final void rule__ConfigValue__SimpleValueAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6225:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6226:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6226:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6227:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getSimpleValueSTRINGTerminalRuleCall_2_0_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ConfigValue__SimpleValueAssignment_2_012479); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getSimpleValueSTRINGTerminalRuleCall_2_0_0()); 
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
    // $ANTLR end "rule__ConfigValue__SimpleValueAssignment_2_0"


    // $ANTLR start "rule__ConfigValue__ChildrenAssignment_2_1_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6236:1: rule__ConfigValue__ChildrenAssignment_2_1_1 : ( ruleConfigValue ) ;
    public final void rule__ConfigValue__ChildrenAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6240:1: ( ( ruleConfigValue ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6241:1: ( ruleConfigValue )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6241:1: ( ruleConfigValue )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6242:1: ruleConfigValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getChildrenConfigValueParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleConfigValue_in_rule__ConfigValue__ChildrenAssignment_2_1_112510);
            ruleConfigValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getChildrenConfigValueParserRuleCall_2_1_1_0()); 
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
    // $ANTLR end "rule__ConfigValue__ChildrenAssignment_2_1_1"


    // $ANTLR start "rule__Paritioning__PartitionsAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6251:1: rule__Paritioning__PartitionsAssignment_2 : ( rulePartition ) ;
    public final void rule__Paritioning__PartitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6255:1: ( ( rulePartition ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6256:1: ( rulePartition )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6256:1: ( rulePartition )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6257:1: rulePartition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_rulePartition_in_rule__Paritioning__PartitionsAssignment_212541);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6266:1: rule__Paritioning__PartitionerAssignment_3 : ( rulePartitioner ) ;
    public final void rule__Paritioning__PartitionerAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6270:1: ( ( rulePartitioner ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6271:1: ( rulePartitioner )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6271:1: ( rulePartitioner )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6272:1: rulePartitioner
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_rulePartitioner_in_rule__Paritioning__PartitionerAssignment_312572);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6281:1: rule__Partition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Partition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6285:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6286:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6286:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6287:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_112603); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6296:1: rule__Paritioner_JS__ScriptURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Paritioner_JS__ScriptURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6300:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6301:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6301:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6302:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptURISTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Paritioner_JS__ScriptURIAssignment_112634); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6311:1: rule__Partitioner_Rule__RuleListAssignment_2 : ( rulePartition_Rule ) ;
    public final void rule__Partitioner_Rule__RuleListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6315:1: ( ( rulePartition_Rule ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6316:1: ( rulePartition_Rule )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6316:1: ( rulePartition_Rule )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6317:1: rulePartition_Rule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_rulePartition_Rule_in_rule__Partitioner_Rule__RuleListAssignment_212665);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6326:1: rule__Partition_SingleLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Partition_SingleLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6330:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6331:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6331:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6332:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6333:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6334:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition_SingleLineRule__ParitionAssignment_112700); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6345:1: rule__Partition_SingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6349:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6350:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6350:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6351:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__StartSeqAssignment_212735); if (state.failed) return ;
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


    // $ANTLR start "rule__Partition_SingleLineRule__EndSeqAssignment_3_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6360:1: rule__Partition_SingleLineRule__EndSeqAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__EndSeqAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6364:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6365:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6365:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6366:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EndSeqAssignment_3_112766); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_1_0()); 
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
    // $ANTLR end "rule__Partition_SingleLineRule__EndSeqAssignment_3_1"


    // $ANTLR start "rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6375:1: rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6379:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6380:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6380:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6381:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EscapeSeqAssignment_4_212797); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
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
    // $ANTLR end "rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2"


    // $ANTLR start "rule__Partition_MultiLineRule__ParitionAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6390:1: rule__Partition_MultiLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Partition_MultiLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6394:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6395:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6395:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6396:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6397:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6398:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition_MultiLineRule__ParitionAssignment_112832); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6409:1: rule__Partition_MultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6413:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6414:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6414:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6415:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__StartSeqAssignment_212867); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6424:1: rule__Partition_MultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6428:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6429:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6429:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6430:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EndSeqAssignment_412898); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6439:1: rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6443:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6444:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6444:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6445:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_212929); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6454:1: rule__LexicalHighlighting__ListAssignment_2 : ( ruleLexicalPartitionHighlighting ) ;
    public final void rule__LexicalHighlighting__ListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6458:1: ( ( ruleLexicalPartitionHighlighting ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6459:1: ( ruleLexicalPartitionHighlighting )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6459:1: ( ruleLexicalPartitionHighlighting )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6460:1: ruleLexicalPartitionHighlighting
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_rule__LexicalHighlighting__ListAssignment_212960);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6469:1: rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6473:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6474:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6474:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6475:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6476:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6477:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_112995); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6488:1: rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6492:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6493:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6493:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6494:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURISTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_213030); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6503:1: rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6507:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6508:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6508:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6509:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6510:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6511:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_113065); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6522:1: rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 : ( ruleWhitespaceRule ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6526:1: ( ( ruleWhitespaceRule ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6527:1: ( ruleWhitespaceRule )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6527:1: ( ruleWhitespaceRule )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6528:1: ruleWhitespaceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceWhitespaceRuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleWhitespaceRule_in_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_213100);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6537:1: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 : ( ruleToken ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6541:1: ( ( ruleToken ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6542:1: ( ruleToken )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6542:1: ( ruleToken )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6543:1: ruleToken
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleToken_in_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_413131);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6552:1: rule__Token__DefaultAssignment_0 : ( ( 'default' ) ) ;
    public final void rule__Token__DefaultAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6556:1: ( ( ( 'default' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6557:1: ( ( 'default' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6557:1: ( ( 'default' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6558:1: ( 'default' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6559:1: ( 'default' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6560:1: 'default'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            }
            match(input,41,FOLLOW_41_in_rule__Token__DefaultAssignment_013167); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6575:1: rule__Token__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Token__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6579:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6580:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6580:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6581:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Token__NameAssignment_113206); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6590:1: rule__Token__ScannerListAssignment_2_1 : ( ruleScanner ) ;
    public final void rule__Token__ScannerListAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6594:1: ( ( ruleScanner ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6595:1: ( ruleScanner )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6595:1: ( ruleScanner )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6596:1: ruleScanner
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleScanner_in_rule__Token__ScannerListAssignment_2_113237);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6605:1: rule__Scanner_Keyword__KeywordsAssignment_2 : ( ruleKeyword ) ;
    public final void rule__Scanner_Keyword__KeywordsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6609:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6610:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6610:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6611:1: ruleKeyword
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_213268);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6620:1: rule__Scanner_Keyword__KeywordsAssignment_3_1 : ( ruleKeyword ) ;
    public final void rule__Scanner_Keyword__KeywordsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6624:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6625:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6625:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6626:1: ruleKeyword
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_3_113299);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6635:1: rule__Keyword__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Keyword__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6639:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6640:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6640:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6641:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_013330); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6650:1: rule__Keyword__VersionAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Keyword__VersionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6654:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6655:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6655:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6656:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_113361); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6665:1: rule__Scanner_SingleLineRule__StartSeqAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__StartSeqAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6669:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6670:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6670:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6671:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__StartSeqAssignment_113392); if (state.failed) return ;
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


    // $ANTLR start "rule__Scanner_SingleLineRule__EndSeqAssignment_2_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6680:1: rule__Scanner_SingleLineRule__EndSeqAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__EndSeqAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6684:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6685:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6685:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6686:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EndSeqAssignment_2_113423); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_2_1_0()); 
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
    // $ANTLR end "rule__Scanner_SingleLineRule__EndSeqAssignment_2_1"


    // $ANTLR start "rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6695:1: rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6699:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6700:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6700:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6701:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_3_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_213454); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_3_2_0()); 
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
    // $ANTLR end "rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2"


    // $ANTLR start "rule__Scanner_MultiLineRule__StartSeqAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6710:1: rule__Scanner_MultiLineRule__StartSeqAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__StartSeqAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6714:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6715:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6715:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6716:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__StartSeqAssignment_113485); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6725:1: rule__Scanner_MultiLineRule__EndSeqAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__EndSeqAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6729:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6730:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6730:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6731:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EndSeqAssignment_313516); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6740:1: rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6744:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6745:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6745:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6746:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_213547); if (state.failed) return ;
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


    // $ANTLR start "rule__Scanner_PatternRule__StartPatternAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6755:1: rule__Scanner_PatternRule__StartPatternAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_PatternRule__StartPatternAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6759:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6760:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6760:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6761:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getStartPatternSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_PatternRule__StartPatternAssignment_113578); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getStartPatternSTRINGTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Scanner_PatternRule__StartPatternAssignment_1"


    // $ANTLR start "rule__Scanner_PatternRule__LengthAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6770:1: rule__Scanner_PatternRule__LengthAssignment_2 : ( RULE_INT ) ;
    public final void rule__Scanner_PatternRule__LengthAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6774:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6775:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6775:1: ( RULE_INT )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6776:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getLengthINTTerminalRuleCall_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Scanner_PatternRule__LengthAssignment_213609); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getLengthINTTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__Scanner_PatternRule__LengthAssignment_2"


    // $ANTLR start "rule__Scanner_PatternRule__ContentPatternAssignment_4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6785:1: rule__Scanner_PatternRule__ContentPatternAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Scanner_PatternRule__ContentPatternAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6789:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6790:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6790:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6791:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getContentPatternSTRINGTerminalRuleCall_4_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_PatternRule__ContentPatternAssignment_413640); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getContentPatternSTRINGTerminalRuleCall_4_0()); 
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
    // $ANTLR end "rule__Scanner_PatternRule__ContentPatternAssignment_4"


    // $ANTLR start "rule__Scanner_CharacterRule__CharactersAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6800:1: rule__Scanner_CharacterRule__CharactersAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_CharacterRule__CharactersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6804:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6805:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6805:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6806:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_213671); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6815:1: rule__Scanner_CharacterRule__CharactersAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_CharacterRule__CharactersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6819:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6820:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6820:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6821:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_3_113702); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6830:1: rule__Scanner_JSRule__FileURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_JSRule__FileURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6834:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6835:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6835:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6836:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_JSRule__FileURIAssignment_113733); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6845:1: rule__WhitespaceRule__CharactersAssignment_1_0_1 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__CharactersAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6849:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6850:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6850:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6851:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_113764); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6860:1: rule__WhitespaceRule__CharactersAssignment_1_0_2_1 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__CharactersAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6864:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6865:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6865:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6866:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_2_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_2_113795); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6875:1: rule__WhitespaceRule__JavawhitespaceAssignment_1_1 : ( ( 'javawhitespace' ) ) ;
    public final void rule__WhitespaceRule__JavawhitespaceAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6879:1: ( ( ( 'javawhitespace' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6880:1: ( ( 'javawhitespace' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6880:1: ( ( 'javawhitespace' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6881:1: ( 'javawhitespace' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6882:1: ( 'javawhitespace' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6883:1: 'javawhitespace'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            }
            match(input,42,FOLLOW_42_in_rule__WhitespaceRule__JavawhitespaceAssignment_1_113831); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6898:1: rule__WhitespaceRule__FileURIAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__FileURIAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6902:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6903:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6903:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6904:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__WhitespaceRule__FileURIAssignment_1_213870); if (state.failed) return ;
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
    public static final BitSet FOLLOW_ruleJavaFXIntegration_in_ruleCodeIntegration519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaFXIntegration_in_entryRuleJavaFXIntegration545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaFXIntegration552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__0_in_ruleJavaFXIntegration578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodegeneration_in_entryRuleCodegeneration605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodegeneration612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codegeneration__Alternatives_in_ruleCodegeneration638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaCodeGeneration_in_entryRuleJavaCodeGeneration665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaCodeGeneration672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group__0_in_ruleJavaCodeGeneration698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleE4CodeGeneration_in_entryRuleE4CodeGeneration725 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleE4CodeGeneration732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group__0_in_ruleE4CodeGeneration758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigValue_in_entryRuleConfigValue785 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigValue792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group__0_in_ruleConfigValue818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioning_in_entryRuleParitioning845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioning852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__0_in_ruleParitioning878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_entryRulePartition905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__0_in_rulePartition938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_entryRulePartitioner965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner__Alternatives_in_rulePartitioner998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS1025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioner_JS1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__0_in_ruleParitioner_JS1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule1085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner_Rule1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__0_in_rulePartitioner_Rule1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule1145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_Rule1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_Rule__Alternatives_in_rulePartition_Rule1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule1205 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_SingleLineRule1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__0_in_rulePartition_SingleLineRule1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule1265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_MultiLineRule1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__0_in_rulePartition_MultiLineRule1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting1325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalHighlighting1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__0_in_ruleLexicalHighlighting1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting1385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting__Alternatives_in_ruleLexicalPartitionHighlighting1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS1445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0_in_ruleLexicalPartitionHighlighting_JS1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule1505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0_in_ruleLexicalPartitionHighlighting_Rule1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_entryRuleToken1565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleToken1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__0_in_ruleToken1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_entryRuleScanner1625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__Alternatives_in_ruleScanner1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword1685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Keyword1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__0_in_ruleScanner_Keyword1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword1745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0_in_ruleKeyword1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule1805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Rule1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Rule__Alternatives_in_ruleScanner_Rule1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule1865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_SingleLineRule1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__0_in_ruleScanner_SingleLineRule1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule1925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_MultiLineRule1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__0_in_ruleScanner_MultiLineRule1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_PatternRule_in_entryRuleScanner_PatternRule1985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_PatternRule1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__Group__0_in_ruleScanner_PatternRule2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule2045 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_CharacterRule2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__0_in_ruleScanner_CharacterRule2078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule2105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_JSRule2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__0_in_ruleScanner_JSRule2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule2165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhitespaceRule2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__0_in_ruleWhitespaceRule2198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaCodeGeneration_in_rule__Codegeneration__Alternatives2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleE4CodeGeneration_in_rule__Codegeneration__Alternatives2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__SimpleValueAssignment_2_0_in_rule__ConfigValue__Alternatives_22283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group_2_1__0_in_rule__ConfigValue__Alternatives_22301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_rule__Partitioner__Alternatives2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_rule__Partitioner__Alternatives2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_rule__Partition_Rule__Alternatives2383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_rule__Partition_Rule__Alternatives2400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_rule__LexicalPartitionHighlighting__Alternatives2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_rule__LexicalPartitionHighlighting__Alternatives2449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_rule__Scanner__Alternatives2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_rule__Scanner__Alternatives2498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_rule__Scanner_Rule__Alternatives2530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_rule__Scanner_Rule__Alternatives2547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_rule__Scanner_Rule__Alternatives2564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_rule__Scanner_Rule__Alternatives2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_PatternRule_in_rule__Scanner_Rule__Alternatives2598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__0_in_rule__WhitespaceRule__Alternatives_12630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__JavawhitespaceAssignment_1_1_in_rule__WhitespaceRule__Alternatives_12648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__FileURIAssignment_1_2_in_rule__WhitespaceRule__Alternatives_12666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__Group__0__Impl_in_rule__Root__Group__02697 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Root__Group__1_in_rule__Root__Group__02700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Root__Group__0__Impl2728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__Group__1__Impl_in_rule__Root__Group__12759 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Root__Group__2_in_rule__Root__Group__12762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__NameAssignment_1_in_rule__Root__Group__1__Impl2789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__Group__2__Impl_in_rule__Root__Group__22819 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Root__Group__3_in_rule__Root__Group__22822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__ImportsAssignment_2_in_rule__Root__Group__2__Impl2849 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Root__Group__3__Impl_in_rule__Root__Group__32880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__LanguageDefinitionAssignment_3_in_rule__Root__Group__3__Impl2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02945 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3031 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03066 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QualifiedName__Group_1__0__Impl3098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__0__Impl_in_rule__QualifiedNameWithWildCard__Group__03190 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__03193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__0__Impl3220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1__Impl_in_rule__QualifiedNameWithWildCard__Group__13249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0_in_rule__QualifiedNameWithWildCard__Group__1__Impl3276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0__Impl_in_rule__QualifiedNameWithWildCard__Group_1__03311 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1_in_rule__QualifiedNameWithWildCard__Group_1__03314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QualifiedNameWithWildCard__Group_1__0__Impl3342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1__Impl_in_rule__QualifiedNameWithWildCard__Group_1__13373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__QualifiedNameWithWildCard__Group_1__1__Impl3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03436 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Import__Group__0__Impl3467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__0__Impl_in_rule__LanguageDef__Group__03559 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__1_in_rule__LanguageDef__Group__03562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__NameAssignment_0_in_rule__LanguageDef__Group__0__Impl3589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__1__Impl_in_rule__LanguageDef__Group__13619 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__2_in_rule__LanguageDef__Group__13622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LanguageDef__Group__1__Impl3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__2__Impl_in_rule__LanguageDef__Group__23681 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__3_in_rule__LanguageDef__Group__23684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__ParitioningAssignment_2_in_rule__LanguageDef__Group__2__Impl3711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__3__Impl_in_rule__LanguageDef__Group__33741 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__4_in_rule__LanguageDef__Group__33744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__LexicalHighlightingAssignment_3_in_rule__LanguageDef__Group__3__Impl3771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__4__Impl_in_rule__LanguageDef__Group__43801 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__5_in_rule__LanguageDef__Group__43804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__IntegrationAssignment_4_in_rule__LanguageDef__Group__4__Impl3831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__5__Impl_in_rule__LanguageDef__Group__53862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LanguageDef__Group__5__Impl3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__Group__0__Impl_in_rule__Integration__Group__03933 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Integration__Group__1_in_rule__Integration__Group__03936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Integration__Group__0__Impl3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__Group__1__Impl_in_rule__Integration__Group__13995 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Integration__Group__2_in_rule__Integration__Group__13998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Integration__Group__1__Impl4026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__Group__2__Impl_in_rule__Integration__Group__24057 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Integration__Group__3_in_rule__Integration__Group__24060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl4089 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl4101 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Integration__Group__3__Impl_in_rule__Integration__Group__34134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Integration__Group__3__Impl4162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__0__Impl_in_rule__JavaFXIntegration__Group__04201 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__1_in_rule__JavaFXIntegration__Group__04204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__JavaFXIntegration__Group__0__Impl4232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__1__Impl_in_rule__JavaFXIntegration__Group__14263 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__2_in_rule__JavaFXIntegration__Group__14266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JavaFXIntegration__Group__1__Impl4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__2__Impl_in_rule__JavaFXIntegration__Group__24325 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__3_in_rule__JavaFXIntegration__Group__24328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__CodegenerationListAssignment_2_in_rule__JavaFXIntegration__Group__2__Impl4357 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__CodegenerationListAssignment_2_in_rule__JavaFXIntegration__Group__2__Impl4369 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__3__Impl_in_rule__JavaFXIntegration__Group__34402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JavaFXIntegration__Group__3__Impl4430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group__0__Impl_in_rule__JavaCodeGeneration__Group__04469 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group__1_in_rule__JavaCodeGeneration__Group__04472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__JavaCodeGeneration__Group__0__Impl4500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group__1__Impl_in_rule__JavaCodeGeneration__Group__14531 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group__2_in_rule__JavaCodeGeneration__Group__14534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__NameAssignment_1_in_rule__JavaCodeGeneration__Group__1__Impl4561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group__2__Impl_in_rule__JavaCodeGeneration__Group__24591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group_2__0_in_rule__JavaCodeGeneration__Group__2__Impl4618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group_2__0__Impl_in_rule__JavaCodeGeneration__Group_2__04655 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group_2__1_in_rule__JavaCodeGeneration__Group_2__04658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JavaCodeGeneration__Group_2__0__Impl4686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group_2__1__Impl_in_rule__JavaCodeGeneration__Group_2__14717 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group_2__2_in_rule__JavaCodeGeneration__Group_2__14720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__ConfigValueAssignment_2_1_in_rule__JavaCodeGeneration__Group_2__1__Impl4749 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__ConfigValueAssignment_2_1_in_rule__JavaCodeGeneration__Group_2__1__Impl4761 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group_2__2__Impl_in_rule__JavaCodeGeneration__Group_2__24794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JavaCodeGeneration__Group_2__2__Impl4822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group__0__Impl_in_rule__E4CodeGeneration__Group__04859 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group__1_in_rule__E4CodeGeneration__Group__04862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__E4CodeGeneration__Group__0__Impl4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group__1__Impl_in_rule__E4CodeGeneration__Group__14921 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group__2_in_rule__E4CodeGeneration__Group__14924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__NameAssignment_1_in_rule__E4CodeGeneration__Group__1__Impl4951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group__2__Impl_in_rule__E4CodeGeneration__Group__24981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group_2__0_in_rule__E4CodeGeneration__Group__2__Impl5008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group_2__0__Impl_in_rule__E4CodeGeneration__Group_2__05045 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group_2__1_in_rule__E4CodeGeneration__Group_2__05048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__E4CodeGeneration__Group_2__0__Impl5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group_2__1__Impl_in_rule__E4CodeGeneration__Group_2__15107 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group_2__2_in_rule__E4CodeGeneration__Group_2__15110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__ConfigValueAssignment_2_1_in_rule__E4CodeGeneration__Group_2__1__Impl5139 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__ConfigValueAssignment_2_1_in_rule__E4CodeGeneration__Group_2__1__Impl5151 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group_2__2__Impl_in_rule__E4CodeGeneration__Group_2__25184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__E4CodeGeneration__Group_2__2__Impl5212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group__0__Impl_in_rule__ConfigValue__Group__05249 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group__1_in_rule__ConfigValue__Group__05252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__KeyAssignment_0_in_rule__ConfigValue__Group__0__Impl5279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group__1__Impl_in_rule__ConfigValue__Group__15309 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group__2_in_rule__ConfigValue__Group__15312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ConfigValue__Group__1__Impl5340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group__2__Impl_in_rule__ConfigValue__Group__25371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__Alternatives_2_in_rule__ConfigValue__Group__2__Impl5398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group_2_1__0__Impl_in_rule__ConfigValue__Group_2_1__05434 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group_2_1__1_in_rule__ConfigValue__Group_2_1__05437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ConfigValue__Group_2_1__0__Impl5465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group_2_1__1__Impl_in_rule__ConfigValue__Group_2_1__15496 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group_2_1__2_in_rule__ConfigValue__Group_2_1__15499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigValue__ChildrenAssignment_2_1_1_in_rule__ConfigValue__Group_2_1__1__Impl5528 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ConfigValue__ChildrenAssignment_2_1_1_in_rule__ConfigValue__Group_2_1__1__Impl5540 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ConfigValue__Group_2_1__2__Impl_in_rule__ConfigValue__Group_2_1__25573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ConfigValue__Group_2_1__2__Impl5601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__0__Impl_in_rule__Paritioning__Group__05638 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__1_in_rule__Paritioning__Group__05641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Paritioning__Group__0__Impl5669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__1__Impl_in_rule__Paritioning__Group__15700 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__2_in_rule__Paritioning__Group__15703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Paritioning__Group__1__Impl5731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__2__Impl_in_rule__Paritioning__Group__25762 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__3_in_rule__Paritioning__Group__25765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl5794 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl5806 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__3__Impl_in_rule__Paritioning__Group__35839 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__4_in_rule__Paritioning__Group__35842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionerAssignment_3_in_rule__Paritioning__Group__3__Impl5869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__4__Impl_in_rule__Paritioning__Group__45899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Paritioning__Group__4__Impl5927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__05968 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__05971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Partition__Group__0__Impl5999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__16030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl6057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__0__Impl_in_rule__Paritioner_JS__Group__06091 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__1_in_rule__Paritioner_JS__Group__06094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Paritioner_JS__Group__0__Impl6122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__1__Impl_in_rule__Paritioner_JS__Group__16153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__ScriptURIAssignment_1_in_rule__Paritioner_JS__Group__1__Impl6180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__0__Impl_in_rule__Partitioner_Rule__Group__06214 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__1_in_rule__Partitioner_Rule__Group__06217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Partitioner_Rule__Group__0__Impl6245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__1__Impl_in_rule__Partitioner_Rule__Group__16276 = new BitSet(new long[]{0x0000000044000000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__2_in_rule__Partitioner_Rule__Group__16279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Partitioner_Rule__Group__1__Impl6307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__2__Impl_in_rule__Partitioner_Rule__Group__26338 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__3_in_rule__Partitioner_Rule__Group__26341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl6370 = new BitSet(new long[]{0x0000000044000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl6382 = new BitSet(new long[]{0x0000000044000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__3__Impl_in_rule__Partitioner_Rule__Group__36415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Partitioner_Rule__Group__3__Impl6443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__0__Impl_in_rule__Partition_SingleLineRule__Group__06482 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__1_in_rule__Partition_SingleLineRule__Group__06485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Partition_SingleLineRule__Group__0__Impl6513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__1__Impl_in_rule__Partition_SingleLineRule__Group__16544 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__2_in_rule__Partition_SingleLineRule__Group__16547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__ParitionAssignment_1_in_rule__Partition_SingleLineRule__Group__1__Impl6574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__2__Impl_in_rule__Partition_SingleLineRule__Group__26604 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__3_in_rule__Partition_SingleLineRule__Group__26607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__StartSeqAssignment_2_in_rule__Partition_SingleLineRule__Group__2__Impl6634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__3__Impl_in_rule__Partition_SingleLineRule__Group__36664 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__4_in_rule__Partition_SingleLineRule__Group__36667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_3__0_in_rule__Partition_SingleLineRule__Group__3__Impl6694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__4__Impl_in_rule__Partition_SingleLineRule__Group__46725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_4__0_in_rule__Partition_SingleLineRule__Group__4__Impl6752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_3__0__Impl_in_rule__Partition_SingleLineRule__Group_3__06793 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_3__1_in_rule__Partition_SingleLineRule__Group_3__06796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Partition_SingleLineRule__Group_3__0__Impl6824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_3__1__Impl_in_rule__Partition_SingleLineRule__Group_3__16855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__EndSeqAssignment_3_1_in_rule__Partition_SingleLineRule__Group_3__1__Impl6882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_4__0__Impl_in_rule__Partition_SingleLineRule__Group_4__06917 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_4__1_in_rule__Partition_SingleLineRule__Group_4__06920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Partition_SingleLineRule__Group_4__0__Impl6948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_4__1__Impl_in_rule__Partition_SingleLineRule__Group_4__16979 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_4__2_in_rule__Partition_SingleLineRule__Group_4__16982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Partition_SingleLineRule__Group_4__1__Impl7010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_4__2__Impl_in_rule__Partition_SingleLineRule__Group_4__27041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__EscapeSeqAssignment_4_2_in_rule__Partition_SingleLineRule__Group_4__2__Impl7068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__0__Impl_in_rule__Partition_MultiLineRule__Group__07104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__1_in_rule__Partition_MultiLineRule__Group__07107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Partition_MultiLineRule__Group__0__Impl7135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__1__Impl_in_rule__Partition_MultiLineRule__Group__17166 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__2_in_rule__Partition_MultiLineRule__Group__17169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__ParitionAssignment_1_in_rule__Partition_MultiLineRule__Group__1__Impl7196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__2__Impl_in_rule__Partition_MultiLineRule__Group__27226 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__3_in_rule__Partition_MultiLineRule__Group__27229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__StartSeqAssignment_2_in_rule__Partition_MultiLineRule__Group__2__Impl7256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__3__Impl_in_rule__Partition_MultiLineRule__Group__37286 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__4_in_rule__Partition_MultiLineRule__Group__37289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Partition_MultiLineRule__Group__3__Impl7317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__4__Impl_in_rule__Partition_MultiLineRule__Group__47348 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__5_in_rule__Partition_MultiLineRule__Group__47351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__EndSeqAssignment_4_in_rule__Partition_MultiLineRule__Group__4__Impl7378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__5__Impl_in_rule__Partition_MultiLineRule__Group__57408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__0_in_rule__Partition_MultiLineRule__Group__5__Impl7435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__0__Impl_in_rule__Partition_MultiLineRule__Group_5__07478 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__1_in_rule__Partition_MultiLineRule__Group_5__07481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Partition_MultiLineRule__Group_5__0__Impl7509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__1__Impl_in_rule__Partition_MultiLineRule__Group_5__17540 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__2_in_rule__Partition_MultiLineRule__Group_5__17543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Partition_MultiLineRule__Group_5__1__Impl7571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__2__Impl_in_rule__Partition_MultiLineRule__Group_5__27602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_MultiLineRule__Group_5__2__Impl7629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__0__Impl_in_rule__LexicalHighlighting__Group__07665 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__1_in_rule__LexicalHighlighting__Group__07668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__LexicalHighlighting__Group__0__Impl7696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__1__Impl_in_rule__LexicalHighlighting__Group__17727 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__2_in_rule__LexicalHighlighting__Group__17730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LexicalHighlighting__Group__1__Impl7758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__2__Impl_in_rule__LexicalHighlighting__Group__27789 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__3_in_rule__LexicalHighlighting__Group__27792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl7821 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl7833 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__3__Impl_in_rule__LexicalHighlighting__Group__37866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LexicalHighlighting__Group__3__Impl7894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__07933 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1_in_rule__LexicalPartitionHighlighting_JS__Group__07936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__LexicalPartitionHighlighting_JS__Group__0__Impl7964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__17995 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2_in_rule__LexicalPartitionHighlighting_JS__Group__17998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_JS__Group__1__Impl8025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__28055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2_in_rule__LexicalPartitionHighlighting_JS__Group__2__Impl8082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__08118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1_in_rule__LexicalPartitionHighlighting_Rule__Group__08121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl8149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__18180 = new BitSet(new long[]{0x0000010000008000L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2_in_rule__LexicalPartitionHighlighting_Rule__Group__18183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl8210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__28240 = new BitSet(new long[]{0x0000010000008000L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3_in_rule__LexicalPartitionHighlighting_Rule__Group__28243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2_in_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl8270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__38301 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4_in_rule__LexicalPartitionHighlighting_Rule__Group__38304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl8332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__48363 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5_in_rule__LexicalPartitionHighlighting_Rule__Group__48366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl8395 = new BitSet(new long[]{0x0000020000000012L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl8407 = new BitSet(new long[]{0x0000020000000012L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__58440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl8468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__0__Impl_in_rule__Token__Group__08511 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_rule__Token__Group__1_in_rule__Token__Group__08514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__DefaultAssignment_0_in_rule__Token__Group__0__Impl8541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__1__Impl_in_rule__Token__Group__18572 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Token__Group__2_in_rule__Token__Group__18575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__NameAssignment_1_in_rule__Token__Group__1__Impl8602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__2__Impl_in_rule__Token__Group__28632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__0_in_rule__Token__Group__2__Impl8659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__0__Impl_in_rule__Token__Group_2__08696 = new BitSet(new long[]{0x000000A145000000L});
    public static final BitSet FOLLOW_rule__Token__Group_2__1_in_rule__Token__Group_2__08699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Token__Group_2__0__Impl8727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__1__Impl_in_rule__Token__Group_2__18758 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Token__Group_2__2_in_rule__Token__Group_2__18761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl8790 = new BitSet(new long[]{0x000000A145000002L});
    public static final BitSet FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl8802 = new BitSet(new long[]{0x000000A145000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__2__Impl_in_rule__Token__Group_2__28835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Token__Group_2__2__Impl8863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__0__Impl_in_rule__Scanner_Keyword__Group__08900 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__1_in_rule__Scanner_Keyword__Group__08903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Scanner_Keyword__Group__0__Impl8931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__1__Impl_in_rule__Scanner_Keyword__Group__18962 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__2_in_rule__Scanner_Keyword__Group__18965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Scanner_Keyword__Group__1__Impl8993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__2__Impl_in_rule__Scanner_Keyword__Group__29024 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__3_in_rule__Scanner_Keyword__Group__29027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_2_in_rule__Scanner_Keyword__Group__2__Impl9054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__3__Impl_in_rule__Scanner_Keyword__Group__39084 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__4_in_rule__Scanner_Keyword__Group__39087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__0_in_rule__Scanner_Keyword__Group__3__Impl9114 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__4__Impl_in_rule__Scanner_Keyword__Group__49145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Scanner_Keyword__Group__4__Impl9173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__0__Impl_in_rule__Scanner_Keyword__Group_3__09214 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__1_in_rule__Scanner_Keyword__Group_3__09217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Scanner_Keyword__Group_3__0__Impl9245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__1__Impl_in_rule__Scanner_Keyword__Group_3__19276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_3_1_in_rule__Scanner_Keyword__Group_3__1__Impl9303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__09337 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__09340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl9367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__19397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl9424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__09459 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__09462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Keyword__Group_1__0__Impl9490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__19521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl9548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__0__Impl_in_rule__Scanner_SingleLineRule__Group__09582 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__1_in_rule__Scanner_SingleLineRule__Group__09585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Scanner_SingleLineRule__Group__0__Impl9613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__1__Impl_in_rule__Scanner_SingleLineRule__Group__19644 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__2_in_rule__Scanner_SingleLineRule__Group__19647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__StartSeqAssignment_1_in_rule__Scanner_SingleLineRule__Group__1__Impl9674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__2__Impl_in_rule__Scanner_SingleLineRule__Group__29704 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__3_in_rule__Scanner_SingleLineRule__Group__29707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_2__0_in_rule__Scanner_SingleLineRule__Group__2__Impl9734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__3__Impl_in_rule__Scanner_SingleLineRule__Group__39765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_3__0_in_rule__Scanner_SingleLineRule__Group__3__Impl9792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_2__0__Impl_in_rule__Scanner_SingleLineRule__Group_2__09831 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_2__1_in_rule__Scanner_SingleLineRule__Group_2__09834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Scanner_SingleLineRule__Group_2__0__Impl9862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_2__1__Impl_in_rule__Scanner_SingleLineRule__Group_2__19893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__EndSeqAssignment_2_1_in_rule__Scanner_SingleLineRule__Group_2__1__Impl9920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_3__0__Impl_in_rule__Scanner_SingleLineRule__Group_3__09955 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_3__1_in_rule__Scanner_SingleLineRule__Group_3__09958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Scanner_SingleLineRule__Group_3__0__Impl9986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_3__1__Impl_in_rule__Scanner_SingleLineRule__Group_3__110017 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_3__2_in_rule__Scanner_SingleLineRule__Group_3__110020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Scanner_SingleLineRule__Group_3__1__Impl10048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_3__2__Impl_in_rule__Scanner_SingleLineRule__Group_3__210079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_2_in_rule__Scanner_SingleLineRule__Group_3__2__Impl10106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__0__Impl_in_rule__Scanner_MultiLineRule__Group__010142 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__1_in_rule__Scanner_MultiLineRule__Group__010145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Scanner_MultiLineRule__Group__0__Impl10173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__1__Impl_in_rule__Scanner_MultiLineRule__Group__110204 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__2_in_rule__Scanner_MultiLineRule__Group__110207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__StartSeqAssignment_1_in_rule__Scanner_MultiLineRule__Group__1__Impl10234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__2__Impl_in_rule__Scanner_MultiLineRule__Group__210264 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__3_in_rule__Scanner_MultiLineRule__Group__210267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Scanner_MultiLineRule__Group__2__Impl10295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__3__Impl_in_rule__Scanner_MultiLineRule__Group__310326 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__4_in_rule__Scanner_MultiLineRule__Group__310329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__EndSeqAssignment_3_in_rule__Scanner_MultiLineRule__Group__3__Impl10356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__4__Impl_in_rule__Scanner_MultiLineRule__Group__410386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__0_in_rule__Scanner_MultiLineRule__Group__4__Impl10413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__0__Impl_in_rule__Scanner_MultiLineRule__Group_4__010454 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__1_in_rule__Scanner_MultiLineRule__Group_4__010457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Scanner_MultiLineRule__Group_4__0__Impl10485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__1__Impl_in_rule__Scanner_MultiLineRule__Group_4__110516 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__2_in_rule__Scanner_MultiLineRule__Group_4__110519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Scanner_MultiLineRule__Group_4__1__Impl10547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__2__Impl_in_rule__Scanner_MultiLineRule__Group_4__210578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_MultiLineRule__Group_4__2__Impl10605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__Group__0__Impl_in_rule__Scanner_PatternRule__Group__010641 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__Group__1_in_rule__Scanner_PatternRule__Group__010644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Scanner_PatternRule__Group__0__Impl10672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__Group__1__Impl_in_rule__Scanner_PatternRule__Group__110703 = new BitSet(new long[]{0x0000004000000040L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__Group__2_in_rule__Scanner_PatternRule__Group__110706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__StartPatternAssignment_1_in_rule__Scanner_PatternRule__Group__1__Impl10733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__Group__2__Impl_in_rule__Scanner_PatternRule__Group__210763 = new BitSet(new long[]{0x0000004000000040L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__Group__3_in_rule__Scanner_PatternRule__Group__210766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__LengthAssignment_2_in_rule__Scanner_PatternRule__Group__2__Impl10793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__Group__3__Impl_in_rule__Scanner_PatternRule__Group__310824 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__Group__4_in_rule__Scanner_PatternRule__Group__310827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Scanner_PatternRule__Group__3__Impl10855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__Group__4__Impl_in_rule__Scanner_PatternRule__Group__410886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_PatternRule__ContentPatternAssignment_4_in_rule__Scanner_PatternRule__Group__4__Impl10913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__0__Impl_in_rule__Scanner_CharacterRule__Group__010953 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__1_in_rule__Scanner_CharacterRule__Group__010956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Scanner_CharacterRule__Group__0__Impl10984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__1__Impl_in_rule__Scanner_CharacterRule__Group__111015 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__2_in_rule__Scanner_CharacterRule__Group__111018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Scanner_CharacterRule__Group__1__Impl11046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__2__Impl_in_rule__Scanner_CharacterRule__Group__211077 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__3_in_rule__Scanner_CharacterRule__Group__211080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_2_in_rule__Scanner_CharacterRule__Group__2__Impl11107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__3__Impl_in_rule__Scanner_CharacterRule__Group__311137 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__4_in_rule__Scanner_CharacterRule__Group__311140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__0_in_rule__Scanner_CharacterRule__Group__3__Impl11167 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__4__Impl_in_rule__Scanner_CharacterRule__Group__411198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Scanner_CharacterRule__Group__4__Impl11226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__0__Impl_in_rule__Scanner_CharacterRule__Group_3__011267 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__1_in_rule__Scanner_CharacterRule__Group_3__011270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Scanner_CharacterRule__Group_3__0__Impl11298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__1__Impl_in_rule__Scanner_CharacterRule__Group_3__111329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_3_1_in_rule__Scanner_CharacterRule__Group_3__1__Impl11356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__0__Impl_in_rule__Scanner_JSRule__Group__011390 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__1_in_rule__Scanner_JSRule__Group__011393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Scanner_JSRule__Group__0__Impl11421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__1__Impl_in_rule__Scanner_JSRule__Group__111452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__FileURIAssignment_1_in_rule__Scanner_JSRule__Group__1__Impl11479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__0__Impl_in_rule__WhitespaceRule__Group__011513 = new BitSet(new long[]{0x0000040200000020L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__1_in_rule__WhitespaceRule__Group__011516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__WhitespaceRule__Group__0__Impl11544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__1__Impl_in_rule__WhitespaceRule__Group__111575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Alternatives_1_in_rule__WhitespaceRule__Group__1__Impl11602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__0__Impl_in_rule__WhitespaceRule__Group_1_0__011636 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__1_in_rule__WhitespaceRule__Group_1_0__011639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__WhitespaceRule__Group_1_0__0__Impl11667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__1__Impl_in_rule__WhitespaceRule__Group_1_0__111698 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__2_in_rule__WhitespaceRule__Group_1_0__111701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_1_in_rule__WhitespaceRule__Group_1_0__1__Impl11728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__2__Impl_in_rule__WhitespaceRule__Group_1_0__211758 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__3_in_rule__WhitespaceRule__Group_1_0__211761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__0_in_rule__WhitespaceRule__Group_1_0__2__Impl11788 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__3__Impl_in_rule__WhitespaceRule__Group_1_0__311819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__WhitespaceRule__Group_1_0__3__Impl11847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__0__Impl_in_rule__WhitespaceRule__Group_1_0_2__011886 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__1_in_rule__WhitespaceRule__Group_1_0_2__011889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__WhitespaceRule__Group_1_0_2__0__Impl11917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__1__Impl_in_rule__WhitespaceRule__Group_1_0_2__111948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_2_1_in_rule__WhitespaceRule__Group_1_0_2__1__Impl11975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Root__NameAssignment_112014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Root__ImportsAssignment_212045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLanguageDef_in_rule__Root__LanguageDefinitionAssignment_312076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_112107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LanguageDef__NameAssignment_012138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioning_in_rule__LanguageDef__ParitioningAssignment_212169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_rule__LanguageDef__LexicalHighlightingAssignment_312200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegration_in_rule__LanguageDef__IntegrationAssignment_412231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeIntegration_in_rule__Integration__CodeIntegrationListAssignment_212262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodegeneration_in_rule__JavaFXIntegration__CodegenerationListAssignment_212293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JavaCodeGeneration__NameAssignment_112324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigValue_in_rule__JavaCodeGeneration__ConfigValueAssignment_2_112355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__E4CodeGeneration__NameAssignment_112386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigValue_in_rule__E4CodeGeneration__ConfigValueAssignment_2_112417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConfigValue__KeyAssignment_012448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ConfigValue__SimpleValueAssignment_2_012479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigValue_in_rule__ConfigValue__ChildrenAssignment_2_1_112510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_rule__Paritioning__PartitionsAssignment_212541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_rule__Paritioning__PartitionerAssignment_312572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_112603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Paritioner_JS__ScriptURIAssignment_112634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_rule__Partitioner_Rule__RuleListAssignment_212665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition_SingleLineRule__ParitionAssignment_112700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__StartSeqAssignment_212735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EndSeqAssignment_3_112766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EscapeSeqAssignment_4_212797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition_MultiLineRule__ParitionAssignment_112832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__StartSeqAssignment_212867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EndSeqAssignment_412898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_212929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_rule__LexicalHighlighting__ListAssignment_212960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_112995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_213030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_113065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_213100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_413131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Token__DefaultAssignment_013167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Token__NameAssignment_113206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_rule__Token__ScannerListAssignment_2_113237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_213268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_3_113299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_013330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_113361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__StartSeqAssignment_113392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EndSeqAssignment_2_113423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EscapeSeqAssignment_3_213454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__StartSeqAssignment_113485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EndSeqAssignment_313516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_213547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_PatternRule__StartPatternAssignment_113578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Scanner_PatternRule__LengthAssignment_213609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_PatternRule__ContentPatternAssignment_413640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_213671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_3_113702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_JSRule__FileURIAssignment_113733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_113764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_2_113795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__WhitespaceRule__JavawhitespaceAssignment_1_113831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__WhitespaceRule__FileURIAssignment_1_213870 = new BitSet(new long[]{0x0000000000000002L});

}