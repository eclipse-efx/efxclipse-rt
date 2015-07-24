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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'*'", "'import'", "'{'", "'}'", "'integration'", "'javafx'", "'java'", "'e4'", "'partitioning'", "'partition'", "'script'", "'rule'", "'single_line'", "'=>'", "'escaped'", "'by'", "'multi_line'", "'lexical_highlighting'", "'keywords'", "'['", "']'", "','", "'since'", "'character'", "'whitespace'", "'default'", "'javawhitespace'"
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


    // $ANTLR start "entryRuleParitioning"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:397:1: entryRuleParitioning : ruleParitioning EOF ;
    public final void entryRuleParitioning() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:398:1: ( ruleParitioning EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:399:1: ruleParitioning EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningRule()); 
            }
            pushFollow(FOLLOW_ruleParitioning_in_entryRuleParitioning785);
            ruleParitioning();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioning792); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:406:1: ruleParitioning : ( ( rule__Paritioning__Group__0 ) ) ;
    public final void ruleParitioning() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:410:2: ( ( ( rule__Paritioning__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:411:1: ( ( rule__Paritioning__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:411:1: ( ( rule__Paritioning__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:412:1: ( rule__Paritioning__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:413:1: ( rule__Paritioning__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:413:2: rule__Paritioning__Group__0
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__0_in_ruleParitioning818);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:425:1: entryRulePartition : rulePartition EOF ;
    public final void entryRulePartition() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:426:1: ( rulePartition EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:427:1: rulePartition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionRule()); 
            }
            pushFollow(FOLLOW_rulePartition_in_entryRulePartition845);
            rulePartition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition852); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:434:1: rulePartition : ( ( rule__Partition__Group__0 ) ) ;
    public final void rulePartition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:438:2: ( ( ( rule__Partition__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:439:1: ( ( rule__Partition__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:439:1: ( ( rule__Partition__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:440:1: ( rule__Partition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:441:1: ( rule__Partition__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:441:2: rule__Partition__Group__0
            {
            pushFollow(FOLLOW_rule__Partition__Group__0_in_rulePartition878);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:453:1: entryRulePartitioner : rulePartitioner EOF ;
    public final void entryRulePartitioner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:454:1: ( rulePartitioner EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:455:1: rulePartitioner EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionerRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_in_entryRulePartitioner905);
            rulePartitioner();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionerRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner912); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:462:1: rulePartitioner : ( ( rule__Partitioner__Alternatives ) ) ;
    public final void rulePartitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:466:2: ( ( ( rule__Partitioner__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:467:1: ( ( rule__Partitioner__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:467:1: ( ( rule__Partitioner__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:468:1: ( rule__Partitioner__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionerAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:469:1: ( rule__Partitioner__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:469:2: rule__Partitioner__Alternatives
            {
            pushFollow(FOLLOW_rule__Partitioner__Alternatives_in_rulePartitioner938);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:481:1: entryRuleParitioner_JS : ruleParitioner_JS EOF ;
    public final void entryRuleParitioner_JS() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:482:1: ( ruleParitioner_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:483:1: ruleParitioner_JS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSRule()); 
            }
            pushFollow(FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS965);
            ruleParitioner_JS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioner_JSRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioner_JS972); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:490:1: ruleParitioner_JS : ( ( rule__Paritioner_JS__Group__0 ) ) ;
    public final void ruleParitioner_JS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:494:2: ( ( ( rule__Paritioner_JS__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:495:1: ( ( rule__Paritioner_JS__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:495:1: ( ( rule__Paritioner_JS__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:496:1: ( rule__Paritioner_JS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:497:1: ( rule__Paritioner_JS__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:497:2: rule__Paritioner_JS__Group__0
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__0_in_ruleParitioner_JS998);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:509:1: entryRulePartitioner_Rule : rulePartitioner_Rule EOF ;
    public final void entryRulePartitioner_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:510:1: ( rulePartitioner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:511:1: rulePartitioner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule1025);
            rulePartitioner_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner_Rule1032); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:518:1: rulePartitioner_Rule : ( ( rule__Partitioner_Rule__Group__0 ) ) ;
    public final void rulePartitioner_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:522:2: ( ( ( rule__Partitioner_Rule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:523:1: ( ( rule__Partitioner_Rule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:523:1: ( ( rule__Partitioner_Rule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:524:1: ( rule__Partitioner_Rule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:525:1: ( rule__Partitioner_Rule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:525:2: rule__Partitioner_Rule__Group__0
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__0_in_rulePartitioner_Rule1058);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:537:1: entryRulePartition_Rule : rulePartition_Rule EOF ;
    public final void entryRulePartition_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:538:1: ( rulePartition_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:539:1: rulePartition_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule1085);
            rulePartition_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_Rule1092); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:546:1: rulePartition_Rule : ( ( rule__Partition_Rule__Alternatives ) ) ;
    public final void rulePartition_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:550:2: ( ( ( rule__Partition_Rule__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:551:1: ( ( rule__Partition_Rule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:551:1: ( ( rule__Partition_Rule__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:552:1: ( rule__Partition_Rule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_RuleAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:553:1: ( rule__Partition_Rule__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:553:2: rule__Partition_Rule__Alternatives
            {
            pushFollow(FOLLOW_rule__Partition_Rule__Alternatives_in_rulePartition_Rule1118);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:565:1: entryRulePartition_SingleLineRule : rulePartition_SingleLineRule EOF ;
    public final void entryRulePartition_SingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:566:1: ( rulePartition_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:567:1: rulePartition_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule1145);
            rulePartition_SingleLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_SingleLineRule1152); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:574:1: rulePartition_SingleLineRule : ( ( rule__Partition_SingleLineRule__Group__0 ) ) ;
    public final void rulePartition_SingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:578:2: ( ( ( rule__Partition_SingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:579:1: ( ( rule__Partition_SingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:579:1: ( ( rule__Partition_SingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:580:1: ( rule__Partition_SingleLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:581:1: ( rule__Partition_SingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:581:2: rule__Partition_SingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__0_in_rulePartition_SingleLineRule1178);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:593:1: entryRulePartition_MultiLineRule : rulePartition_MultiLineRule EOF ;
    public final void entryRulePartition_MultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:594:1: ( rulePartition_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:595:1: rulePartition_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule1205);
            rulePartition_MultiLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_MultiLineRule1212); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:602:1: rulePartition_MultiLineRule : ( ( rule__Partition_MultiLineRule__Group__0 ) ) ;
    public final void rulePartition_MultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:606:2: ( ( ( rule__Partition_MultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:607:1: ( ( rule__Partition_MultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:607:1: ( ( rule__Partition_MultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:608:1: ( rule__Partition_MultiLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:609:1: ( rule__Partition_MultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:609:2: rule__Partition_MultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__0_in_rulePartition_MultiLineRule1238);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:621:1: entryRuleLexicalHighlighting : ruleLexicalHighlighting EOF ;
    public final void entryRuleLexicalHighlighting() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:622:1: ( ruleLexicalHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:623:1: ruleLexicalHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting1265);
            ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalHighlighting1272); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:630:1: ruleLexicalHighlighting : ( ( rule__LexicalHighlighting__Group__0 ) ) ;
    public final void ruleLexicalHighlighting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:634:2: ( ( ( rule__LexicalHighlighting__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:635:1: ( ( rule__LexicalHighlighting__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:635:1: ( ( rule__LexicalHighlighting__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:636:1: ( rule__LexicalHighlighting__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:637:1: ( rule__LexicalHighlighting__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:637:2: rule__LexicalHighlighting__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__0_in_ruleLexicalHighlighting1298);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:649:1: entryRuleLexicalPartitionHighlighting : ruleLexicalPartitionHighlighting EOF ;
    public final void entryRuleLexicalPartitionHighlighting() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:650:1: ( ruleLexicalPartitionHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:651:1: ruleLexicalPartitionHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting1325);
            ruleLexicalPartitionHighlighting();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting1332); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:658:1: ruleLexicalPartitionHighlighting : ( ( rule__LexicalPartitionHighlighting__Alternatives ) ) ;
    public final void ruleLexicalPartitionHighlighting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:662:2: ( ( ( rule__LexicalPartitionHighlighting__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:663:1: ( ( rule__LexicalPartitionHighlighting__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:663:1: ( ( rule__LexicalPartitionHighlighting__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:664:1: ( rule__LexicalPartitionHighlighting__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlightingAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:665:1: ( rule__LexicalPartitionHighlighting__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:665:2: rule__LexicalPartitionHighlighting__Alternatives
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting__Alternatives_in_ruleLexicalPartitionHighlighting1358);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:677:1: entryRuleLexicalPartitionHighlighting_JS : ruleLexicalPartitionHighlighting_JS EOF ;
    public final void entryRuleLexicalPartitionHighlighting_JS() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:678:1: ( ruleLexicalPartitionHighlighting_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:679:1: ruleLexicalPartitionHighlighting_JS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS1385);
            ruleLexicalPartitionHighlighting_JS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS1392); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:686:1: ruleLexicalPartitionHighlighting_JS : ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) ) ;
    public final void ruleLexicalPartitionHighlighting_JS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:690:2: ( ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:691:1: ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:691:1: ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:692:1: ( rule__LexicalPartitionHighlighting_JS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:693:1: ( rule__LexicalPartitionHighlighting_JS__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:693:2: rule__LexicalPartitionHighlighting_JS__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0_in_ruleLexicalPartitionHighlighting_JS1418);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:705:1: entryRuleLexicalPartitionHighlighting_Rule : ruleLexicalPartitionHighlighting_Rule EOF ;
    public final void entryRuleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:706:1: ( ruleLexicalPartitionHighlighting_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:707:1: ruleLexicalPartitionHighlighting_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule1445);
            ruleLexicalPartitionHighlighting_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule1452); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:714:1: ruleLexicalPartitionHighlighting_Rule : ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) ) ;
    public final void ruleLexicalPartitionHighlighting_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:718:2: ( ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:719:1: ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:719:1: ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:720:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:721:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:721:2: rule__LexicalPartitionHighlighting_Rule__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0_in_ruleLexicalPartitionHighlighting_Rule1478);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:733:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:734:1: ( ruleToken EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:735:1: ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_ruleToken_in_entryRuleToken1505);
            ruleToken();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleToken1512); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:742:1: ruleToken : ( ( rule__Token__Group__0 ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:746:2: ( ( ( rule__Token__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:747:1: ( ( rule__Token__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:747:1: ( ( rule__Token__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:748:1: ( rule__Token__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:749:1: ( rule__Token__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:749:2: rule__Token__Group__0
            {
            pushFollow(FOLLOW_rule__Token__Group__0_in_ruleToken1538);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:761:1: entryRuleScanner : ruleScanner EOF ;
    public final void entryRuleScanner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:762:1: ( ruleScanner EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:763:1: ruleScanner EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScannerRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_in_entryRuleScanner1565);
            ruleScanner();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScannerRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner1572); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:770:1: ruleScanner : ( ( rule__Scanner__Alternatives ) ) ;
    public final void ruleScanner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:774:2: ( ( ( rule__Scanner__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:775:1: ( ( rule__Scanner__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:775:1: ( ( rule__Scanner__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:776:1: ( rule__Scanner__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScannerAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:777:1: ( rule__Scanner__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:777:2: rule__Scanner__Alternatives
            {
            pushFollow(FOLLOW_rule__Scanner__Alternatives_in_ruleScanner1598);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:789:1: entryRuleScanner_Keyword : ruleScanner_Keyword EOF ;
    public final void entryRuleScanner_Keyword() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:790:1: ( ruleScanner_Keyword EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:791:1: ruleScanner_Keyword EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword1625);
            ruleScanner_Keyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Keyword1632); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:798:1: ruleScanner_Keyword : ( ( rule__Scanner_Keyword__Group__0 ) ) ;
    public final void ruleScanner_Keyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:802:2: ( ( ( rule__Scanner_Keyword__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:803:1: ( ( rule__Scanner_Keyword__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:803:1: ( ( rule__Scanner_Keyword__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:804:1: ( rule__Scanner_Keyword__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:805:1: ( rule__Scanner_Keyword__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:805:2: rule__Scanner_Keyword__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__0_in_ruleScanner_Keyword1658);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:817:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:818:1: ( ruleKeyword EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:819:1: ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword1685);
            ruleKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword1692); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:826:1: ruleKeyword : ( ( rule__Keyword__Group__0 ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:830:2: ( ( ( rule__Keyword__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:831:1: ( ( rule__Keyword__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:831:1: ( ( rule__Keyword__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:832:1: ( rule__Keyword__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:833:1: ( rule__Keyword__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:833:2: rule__Keyword__Group__0
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0_in_ruleKeyword1718);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:845:1: entryRuleScanner_Rule : ruleScanner_Rule EOF ;
    public final void entryRuleScanner_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:846:1: ( ruleScanner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:847:1: ruleScanner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule1745);
            ruleScanner_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_RuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Rule1752); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:854:1: ruleScanner_Rule : ( ( rule__Scanner_Rule__Alternatives ) ) ;
    public final void ruleScanner_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:858:2: ( ( ( rule__Scanner_Rule__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:859:1: ( ( rule__Scanner_Rule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:859:1: ( ( rule__Scanner_Rule__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:860:1: ( rule__Scanner_Rule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_RuleAccess().getAlternatives()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:861:1: ( rule__Scanner_Rule__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:861:2: rule__Scanner_Rule__Alternatives
            {
            pushFollow(FOLLOW_rule__Scanner_Rule__Alternatives_in_ruleScanner_Rule1778);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:873:1: entryRuleScanner_SingleLineRule : ruleScanner_SingleLineRule EOF ;
    public final void entryRuleScanner_SingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:874:1: ( ruleScanner_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:875:1: ruleScanner_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule1805);
            ruleScanner_SingleLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_SingleLineRule1812); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:882:1: ruleScanner_SingleLineRule : ( ( rule__Scanner_SingleLineRule__Group__0 ) ) ;
    public final void ruleScanner_SingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:886:2: ( ( ( rule__Scanner_SingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:887:1: ( ( rule__Scanner_SingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:887:1: ( ( rule__Scanner_SingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:888:1: ( rule__Scanner_SingleLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:889:1: ( rule__Scanner_SingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:889:2: rule__Scanner_SingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__0_in_ruleScanner_SingleLineRule1838);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:901:1: entryRuleScanner_MultiLineRule : ruleScanner_MultiLineRule EOF ;
    public final void entryRuleScanner_MultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:902:1: ( ruleScanner_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:903:1: ruleScanner_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule1865);
            ruleScanner_MultiLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_MultiLineRule1872); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:910:1: ruleScanner_MultiLineRule : ( ( rule__Scanner_MultiLineRule__Group__0 ) ) ;
    public final void ruleScanner_MultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:914:2: ( ( ( rule__Scanner_MultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:915:1: ( ( rule__Scanner_MultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:915:1: ( ( rule__Scanner_MultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:916:1: ( rule__Scanner_MultiLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:917:1: ( rule__Scanner_MultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:917:2: rule__Scanner_MultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__0_in_ruleScanner_MultiLineRule1898);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:929:1: entryRuleScanner_CharacterRule : ruleScanner_CharacterRule EOF ;
    public final void entryRuleScanner_CharacterRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:930:1: ( ruleScanner_CharacterRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:931:1: ruleScanner_CharacterRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule1925);
            ruleScanner_CharacterRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_CharacterRule1932); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:938:1: ruleScanner_CharacterRule : ( ( rule__Scanner_CharacterRule__Group__0 ) ) ;
    public final void ruleScanner_CharacterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:942:2: ( ( ( rule__Scanner_CharacterRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:943:1: ( ( rule__Scanner_CharacterRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:943:1: ( ( rule__Scanner_CharacterRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:944:1: ( rule__Scanner_CharacterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:945:1: ( rule__Scanner_CharacterRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:945:2: rule__Scanner_CharacterRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__0_in_ruleScanner_CharacterRule1958);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:957:1: entryRuleScanner_JSRule : ruleScanner_JSRule EOF ;
    public final void entryRuleScanner_JSRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:958:1: ( ruleScanner_JSRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:959:1: ruleScanner_JSRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule1985);
            ruleScanner_JSRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_JSRule1992); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:966:1: ruleScanner_JSRule : ( ( rule__Scanner_JSRule__Group__0 ) ) ;
    public final void ruleScanner_JSRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:970:2: ( ( ( rule__Scanner_JSRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:971:1: ( ( rule__Scanner_JSRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:971:1: ( ( rule__Scanner_JSRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:972:1: ( rule__Scanner_JSRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:973:1: ( rule__Scanner_JSRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:973:2: rule__Scanner_JSRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__0_in_ruleScanner_JSRule2018);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:985:1: entryRuleWhitespaceRule : ruleWhitespaceRule EOF ;
    public final void entryRuleWhitespaceRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:986:1: ( ruleWhitespaceRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:987:1: ruleWhitespaceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleRule()); 
            }
            pushFollow(FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule2045);
            ruleWhitespaceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhitespaceRule2052); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:994:1: ruleWhitespaceRule : ( ( rule__WhitespaceRule__Group__0 ) ) ;
    public final void ruleWhitespaceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:998:2: ( ( ( rule__WhitespaceRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:999:1: ( ( rule__WhitespaceRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:999:1: ( ( rule__WhitespaceRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1000:1: ( rule__WhitespaceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getGroup()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1001:1: ( rule__WhitespaceRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1001:2: rule__WhitespaceRule__Group__0
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__0_in_ruleWhitespaceRule2078);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1013:1: rule__Codegeneration__Alternatives : ( ( ruleJavaCodeGeneration ) | ( ruleE4CodeGeneration ) );
    public final void rule__Codegeneration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1017:1: ( ( ruleJavaCodeGeneration ) | ( ruleE4CodeGeneration ) )
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1018:1: ( ruleJavaCodeGeneration )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1018:1: ( ruleJavaCodeGeneration )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1019:1: ruleJavaCodeGeneration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCodegenerationAccess().getJavaCodeGenerationParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleJavaCodeGeneration_in_rule__Codegeneration__Alternatives2114);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1024:6: ( ruleE4CodeGeneration )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1024:6: ( ruleE4CodeGeneration )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1025:1: ruleE4CodeGeneration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCodegenerationAccess().getE4CodeGenerationParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleE4CodeGeneration_in_rule__Codegeneration__Alternatives2131);
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


    // $ANTLR start "rule__Partitioner__Alternatives"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1035:1: rule__Partitioner__Alternatives : ( ( rulePartitioner_Rule ) | ( ruleParitioner_JS ) );
    public final void rule__Partitioner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1039:1: ( ( rulePartitioner_Rule ) | ( ruleParitioner_JS ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==24) ) {
                alt2=1;
            }
            else if ( (LA2_0==23) ) {
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1040:1: ( rulePartitioner_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1040:1: ( rulePartitioner_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1041:1: rulePartitioner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePartitioner_Rule_in_rule__Partitioner__Alternatives2163);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1046:6: ( ruleParitioner_JS )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1046:6: ( ruleParitioner_JS )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1047:1: ruleParitioner_JS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleParitioner_JS_in_rule__Partitioner__Alternatives2180);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1057:1: rule__Partition_Rule__Alternatives : ( ( rulePartition_SingleLineRule ) | ( rulePartition_MultiLineRule ) );
    public final void rule__Partition_Rule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1061:1: ( ( rulePartition_SingleLineRule ) | ( rulePartition_MultiLineRule ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==25) ) {
                alt3=1;
            }
            else if ( (LA3_0==29) ) {
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1062:1: ( rulePartition_SingleLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1062:1: ( rulePartition_SingleLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1063:1: rulePartition_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePartition_SingleLineRule_in_rule__Partition_Rule__Alternatives2212);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1068:6: ( rulePartition_MultiLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1068:6: ( rulePartition_MultiLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1069:1: rulePartition_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_rulePartition_MultiLineRule_in_rule__Partition_Rule__Alternatives2229);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1079:1: rule__LexicalPartitionHighlighting__Alternatives : ( ( ruleLexicalPartitionHighlighting_Rule ) | ( ruleLexicalPartitionHighlighting_JS ) );
    public final void rule__LexicalPartitionHighlighting__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1083:1: ( ( ruleLexicalPartitionHighlighting_Rule ) | ( ruleLexicalPartitionHighlighting_JS ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==24) ) {
                alt4=1;
            }
            else if ( (LA4_0==23) ) {
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1084:1: ( ruleLexicalPartitionHighlighting_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1084:1: ( ruleLexicalPartitionHighlighting_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1085:1: ruleLexicalPartitionHighlighting_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_rule__LexicalPartitionHighlighting__Alternatives2261);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1090:6: ( ruleLexicalPartitionHighlighting_JS )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1090:6: ( ruleLexicalPartitionHighlighting_JS )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1091:1: ruleLexicalPartitionHighlighting_JS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_rule__LexicalPartitionHighlighting__Alternatives2278);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1101:1: rule__Scanner__Alternatives : ( ( ruleScanner_Keyword ) | ( ruleScanner_Rule ) );
    public final void rule__Scanner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1105:1: ( ( ruleScanner_Keyword ) | ( ruleScanner_Rule ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==31) ) {
                alt5=1;
            }
            else if ( (LA5_0==23||LA5_0==25||LA5_0==29||LA5_0==36) ) {
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1106:1: ( ruleScanner_Keyword )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1106:1: ( ruleScanner_Keyword )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1107:1: ruleScanner_Keyword
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_Keyword_in_rule__Scanner__Alternatives2310);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1112:6: ( ruleScanner_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1112:6: ( ruleScanner_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1113:1: ruleScanner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_Rule_in_rule__Scanner__Alternatives2327);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1123:1: rule__Scanner_Rule__Alternatives : ( ( ruleScanner_SingleLineRule ) | ( ruleScanner_MultiLineRule ) | ( ruleScanner_CharacterRule ) | ( ruleScanner_JSRule ) );
    public final void rule__Scanner_Rule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1127:1: ( ( ruleScanner_SingleLineRule ) | ( ruleScanner_MultiLineRule ) | ( ruleScanner_CharacterRule ) | ( ruleScanner_JSRule ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt6=1;
                }
                break;
            case 29:
                {
                alt6=2;
                }
                break;
            case 36:
                {
                alt6=3;
                }
                break;
            case 23:
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1128:1: ( ruleScanner_SingleLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1128:1: ( ruleScanner_SingleLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1129:1: ruleScanner_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_rule__Scanner_Rule__Alternatives2359);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1134:6: ( ruleScanner_MultiLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1134:6: ( ruleScanner_MultiLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1135:1: ruleScanner_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_rule__Scanner_Rule__Alternatives2376);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1140:6: ( ruleScanner_CharacterRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1140:6: ( ruleScanner_CharacterRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1141:1: ruleScanner_CharacterRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_CharacterRule_in_rule__Scanner_Rule__Alternatives2393);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1146:6: ( ruleScanner_JSRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1146:6: ( ruleScanner_JSRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1147:1: ruleScanner_JSRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleScanner_JSRule_in_rule__Scanner_Rule__Alternatives2410);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1157:1: rule__WhitespaceRule__Alternatives_1 : ( ( ( rule__WhitespaceRule__Group_1_0__0 ) ) | ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) ) | ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) ) );
    public final void rule__WhitespaceRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1161:1: ( ( ( rule__WhitespaceRule__Group_1_0__0 ) ) | ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) ) | ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt7=1;
                }
                break;
            case 39:
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1162:1: ( ( rule__WhitespaceRule__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1162:1: ( ( rule__WhitespaceRule__Group_1_0__0 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1163:1: ( rule__WhitespaceRule__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1164:1: ( rule__WhitespaceRule__Group_1_0__0 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1164:2: rule__WhitespaceRule__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__0_in_rule__WhitespaceRule__Alternatives_12442);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1168:6: ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1168:6: ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1169:1: ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceAssignment_1_1()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1170:1: ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1170:2: rule__WhitespaceRule__JavawhitespaceAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__WhitespaceRule__JavawhitespaceAssignment_1_1_in_rule__WhitespaceRule__Alternatives_12460);
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
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1174:6: ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1174:6: ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1175:1: ( rule__WhitespaceRule__FileURIAssignment_1_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getFileURIAssignment_1_2()); 
                    }
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1176:1: ( rule__WhitespaceRule__FileURIAssignment_1_2 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1176:2: rule__WhitespaceRule__FileURIAssignment_1_2
                    {
                    pushFollow(FOLLOW_rule__WhitespaceRule__FileURIAssignment_1_2_in_rule__WhitespaceRule__Alternatives_12478);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1187:1: rule__Root__Group__0 : rule__Root__Group__0__Impl rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1191:1: ( rule__Root__Group__0__Impl rule__Root__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1192:2: rule__Root__Group__0__Impl rule__Root__Group__1
            {
            pushFollow(FOLLOW_rule__Root__Group__0__Impl_in_rule__Root__Group__02509);
            rule__Root__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Root__Group__1_in_rule__Root__Group__02512);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1199:1: rule__Root__Group__0__Impl : ( 'package' ) ;
    public final void rule__Root__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1203:1: ( ( 'package' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1204:1: ( 'package' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1204:1: ( 'package' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1205:1: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getPackageKeyword_0()); 
            }
            match(input,11,FOLLOW_11_in_rule__Root__Group__0__Impl2540); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1218:1: rule__Root__Group__1 : rule__Root__Group__1__Impl rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1222:1: ( rule__Root__Group__1__Impl rule__Root__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1223:2: rule__Root__Group__1__Impl rule__Root__Group__2
            {
            pushFollow(FOLLOW_rule__Root__Group__1__Impl_in_rule__Root__Group__12571);
            rule__Root__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Root__Group__2_in_rule__Root__Group__12574);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1230:1: rule__Root__Group__1__Impl : ( ( rule__Root__NameAssignment_1 ) ) ;
    public final void rule__Root__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1234:1: ( ( ( rule__Root__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1235:1: ( ( rule__Root__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1235:1: ( ( rule__Root__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1236:1: ( rule__Root__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1237:1: ( rule__Root__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1237:2: rule__Root__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Root__NameAssignment_1_in_rule__Root__Group__1__Impl2601);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1247:1: rule__Root__Group__2 : rule__Root__Group__2__Impl rule__Root__Group__3 ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1251:1: ( rule__Root__Group__2__Impl rule__Root__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1252:2: rule__Root__Group__2__Impl rule__Root__Group__3
            {
            pushFollow(FOLLOW_rule__Root__Group__2__Impl_in_rule__Root__Group__22631);
            rule__Root__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Root__Group__3_in_rule__Root__Group__22634);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1259:1: rule__Root__Group__2__Impl : ( ( rule__Root__ImportsAssignment_2 )* ) ;
    public final void rule__Root__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1263:1: ( ( ( rule__Root__ImportsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1264:1: ( ( rule__Root__ImportsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1264:1: ( ( rule__Root__ImportsAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1265:1: ( rule__Root__ImportsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getImportsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1266:1: ( rule__Root__ImportsAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==14) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1266:2: rule__Root__ImportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Root__ImportsAssignment_2_in_rule__Root__Group__2__Impl2661);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1276:1: rule__Root__Group__3 : rule__Root__Group__3__Impl ;
    public final void rule__Root__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1280:1: ( rule__Root__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1281:2: rule__Root__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Root__Group__3__Impl_in_rule__Root__Group__32692);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1287:1: rule__Root__Group__3__Impl : ( ( rule__Root__LanguageDefinitionAssignment_3 ) ) ;
    public final void rule__Root__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1291:1: ( ( ( rule__Root__LanguageDefinitionAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1292:1: ( ( rule__Root__LanguageDefinitionAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1292:1: ( ( rule__Root__LanguageDefinitionAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1293:1: ( rule__Root__LanguageDefinitionAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLanguageDefinitionAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1294:1: ( rule__Root__LanguageDefinitionAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1294:2: rule__Root__LanguageDefinitionAssignment_3
            {
            pushFollow(FOLLOW_rule__Root__LanguageDefinitionAssignment_3_in_rule__Root__Group__3__Impl2719);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1312:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1316:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1317:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02757);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02760);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1324:1: rule__QualifiedName__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1328:1: ( ( ruleValidID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1329:1: ( ruleValidID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1329:1: ( ruleValidID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1330:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl2787);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1341:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1345:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1346:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12816);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1352:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1356:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1357:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1357:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1358:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1359:1: ( rule__QualifiedName__Group_1__0 )*
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
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1359:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2843);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1373:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1377:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1378:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02878);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02881);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1385:1: rule__QualifiedName__Group_1__0__Impl : ( ( '.' ) ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1389:1: ( ( ( '.' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1390:1: ( ( '.' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1390:1: ( ( '.' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1391:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1392:1: ( '.' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1393:2: '.'
            {
            match(input,12,FOLLOW_12_in_rule__QualifiedName__Group_1__0__Impl2910); if (state.failed) return ;

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1404:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1408:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1409:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12942);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1415:1: rule__QualifiedName__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1419:1: ( ( ruleValidID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1420:1: ( ruleValidID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1420:1: ( ruleValidID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1421:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl2969);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1436:1: rule__QualifiedNameWithWildCard__Group__0 : rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 ;
    public final void rule__QualifiedNameWithWildCard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1440:1: ( rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1441:2: rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__0__Impl_in_rule__QualifiedNameWithWildCard__Group__03002);
            rule__QualifiedNameWithWildCard__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__03005);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1448:1: rule__QualifiedNameWithWildCard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildCard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1452:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1453:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1453:1: ( ruleQualifiedName )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1454:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__0__Impl3032);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1465:1: rule__QualifiedNameWithWildCard__Group__1 : rule__QualifiedNameWithWildCard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1469:1: ( rule__QualifiedNameWithWildCard__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1470:2: rule__QualifiedNameWithWildCard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__1__Impl_in_rule__QualifiedNameWithWildCard__Group__13061);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1476:1: rule__QualifiedNameWithWildCard__Group__1__Impl : ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? ) ;
    public final void rule__QualifiedNameWithWildCard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1480:1: ( ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1481:1: ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1481:1: ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1482:1: ( rule__QualifiedNameWithWildCard__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1483:1: ( rule__QualifiedNameWithWildCard__Group_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==12) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1483:2: rule__QualifiedNameWithWildCard__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0_in_rule__QualifiedNameWithWildCard__Group__1__Impl3088);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1497:1: rule__QualifiedNameWithWildCard__Group_1__0 : rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1 ;
    public final void rule__QualifiedNameWithWildCard__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1501:1: ( rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1502:2: rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0__Impl_in_rule__QualifiedNameWithWildCard__Group_1__03123);
            rule__QualifiedNameWithWildCard__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1_in_rule__QualifiedNameWithWildCard__Group_1__03126);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1509:1: rule__QualifiedNameWithWildCard__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedNameWithWildCard__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1513:1: ( ( '.' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1514:1: ( '.' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1514:1: ( '.' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1515:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
            }
            match(input,12,FOLLOW_12_in_rule__QualifiedNameWithWildCard__Group_1__0__Impl3154); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1528:1: rule__QualifiedNameWithWildCard__Group_1__1 : rule__QualifiedNameWithWildCard__Group_1__1__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1532:1: ( rule__QualifiedNameWithWildCard__Group_1__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1533:2: rule__QualifiedNameWithWildCard__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1__Impl_in_rule__QualifiedNameWithWildCard__Group_1__13185);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1539:1: rule__QualifiedNameWithWildCard__Group_1__1__Impl : ( '*' ) ;
    public final void rule__QualifiedNameWithWildCard__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1543:1: ( ( '*' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1544:1: ( '*' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1544:1: ( '*' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1545:1: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1()); 
            }
            match(input,13,FOLLOW_13_in_rule__QualifiedNameWithWildCard__Group_1__1__Impl3213); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1562:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1566:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1567:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03248);
            rule__Import__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03251);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1574:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1578:1: ( ( 'import' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1579:1: ( 'import' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1579:1: ( 'import' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1580:1: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }
            match(input,14,FOLLOW_14_in_rule__Import__Group__0__Impl3279); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1593:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1597:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1598:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13310);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1604:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1608:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1609:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1609:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1610:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1611:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1611:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3337);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1625:1: rule__LanguageDef__Group__0 : rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1 ;
    public final void rule__LanguageDef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1629:1: ( rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1630:2: rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__0__Impl_in_rule__LanguageDef__Group__03371);
            rule__LanguageDef__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__1_in_rule__LanguageDef__Group__03374);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1637:1: rule__LanguageDef__Group__0__Impl : ( ( rule__LanguageDef__NameAssignment_0 ) ) ;
    public final void rule__LanguageDef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1641:1: ( ( ( rule__LanguageDef__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1642:1: ( ( rule__LanguageDef__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1642:1: ( ( rule__LanguageDef__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1643:1: ( rule__LanguageDef__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1644:1: ( rule__LanguageDef__NameAssignment_0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1644:2: rule__LanguageDef__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__LanguageDef__NameAssignment_0_in_rule__LanguageDef__Group__0__Impl3401);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1654:1: rule__LanguageDef__Group__1 : rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2 ;
    public final void rule__LanguageDef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1658:1: ( rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1659:2: rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__1__Impl_in_rule__LanguageDef__Group__13431);
            rule__LanguageDef__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__2_in_rule__LanguageDef__Group__13434);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1666:1: rule__LanguageDef__Group__1__Impl : ( '{' ) ;
    public final void rule__LanguageDef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1670:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1671:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1671:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1672:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__LanguageDef__Group__1__Impl3462); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1685:1: rule__LanguageDef__Group__2 : rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3 ;
    public final void rule__LanguageDef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1689:1: ( rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1690:2: rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__2__Impl_in_rule__LanguageDef__Group__23493);
            rule__LanguageDef__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__3_in_rule__LanguageDef__Group__23496);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1697:1: rule__LanguageDef__Group__2__Impl : ( ( rule__LanguageDef__ParitioningAssignment_2 ) ) ;
    public final void rule__LanguageDef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1701:1: ( ( ( rule__LanguageDef__ParitioningAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1702:1: ( ( rule__LanguageDef__ParitioningAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1702:1: ( ( rule__LanguageDef__ParitioningAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1703:1: ( rule__LanguageDef__ParitioningAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getParitioningAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1704:1: ( rule__LanguageDef__ParitioningAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1704:2: rule__LanguageDef__ParitioningAssignment_2
            {
            pushFollow(FOLLOW_rule__LanguageDef__ParitioningAssignment_2_in_rule__LanguageDef__Group__2__Impl3523);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1714:1: rule__LanguageDef__Group__3 : rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4 ;
    public final void rule__LanguageDef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1718:1: ( rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1719:2: rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__3__Impl_in_rule__LanguageDef__Group__33553);
            rule__LanguageDef__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__4_in_rule__LanguageDef__Group__33556);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1726:1: rule__LanguageDef__Group__3__Impl : ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) ) ;
    public final void rule__LanguageDef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1730:1: ( ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1731:1: ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1731:1: ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1732:1: ( rule__LanguageDef__LexicalHighlightingAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLexicalHighlightingAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1733:1: ( rule__LanguageDef__LexicalHighlightingAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1733:2: rule__LanguageDef__LexicalHighlightingAssignment_3
            {
            pushFollow(FOLLOW_rule__LanguageDef__LexicalHighlightingAssignment_3_in_rule__LanguageDef__Group__3__Impl3583);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1743:1: rule__LanguageDef__Group__4 : rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5 ;
    public final void rule__LanguageDef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1747:1: ( rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1748:2: rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__4__Impl_in_rule__LanguageDef__Group__43613);
            rule__LanguageDef__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LanguageDef__Group__5_in_rule__LanguageDef__Group__43616);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1755:1: rule__LanguageDef__Group__4__Impl : ( ( rule__LanguageDef__IntegrationAssignment_4 )? ) ;
    public final void rule__LanguageDef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1759:1: ( ( ( rule__LanguageDef__IntegrationAssignment_4 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1760:1: ( ( rule__LanguageDef__IntegrationAssignment_4 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1760:1: ( ( rule__LanguageDef__IntegrationAssignment_4 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1761:1: ( rule__LanguageDef__IntegrationAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getIntegrationAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1762:1: ( rule__LanguageDef__IntegrationAssignment_4 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1762:2: rule__LanguageDef__IntegrationAssignment_4
                    {
                    pushFollow(FOLLOW_rule__LanguageDef__IntegrationAssignment_4_in_rule__LanguageDef__Group__4__Impl3643);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1772:1: rule__LanguageDef__Group__5 : rule__LanguageDef__Group__5__Impl ;
    public final void rule__LanguageDef__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1776:1: ( rule__LanguageDef__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1777:2: rule__LanguageDef__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__LanguageDef__Group__5__Impl_in_rule__LanguageDef__Group__53674);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1783:1: rule__LanguageDef__Group__5__Impl : ( '}' ) ;
    public final void rule__LanguageDef__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1787:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1788:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1788:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1789:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,16,FOLLOW_16_in_rule__LanguageDef__Group__5__Impl3702); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1814:1: rule__Integration__Group__0 : rule__Integration__Group__0__Impl rule__Integration__Group__1 ;
    public final void rule__Integration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1818:1: ( rule__Integration__Group__0__Impl rule__Integration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1819:2: rule__Integration__Group__0__Impl rule__Integration__Group__1
            {
            pushFollow(FOLLOW_rule__Integration__Group__0__Impl_in_rule__Integration__Group__03745);
            rule__Integration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Integration__Group__1_in_rule__Integration__Group__03748);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1826:1: rule__Integration__Group__0__Impl : ( 'integration' ) ;
    public final void rule__Integration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1830:1: ( ( 'integration' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1831:1: ( 'integration' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1831:1: ( 'integration' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1832:1: 'integration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getIntegrationKeyword_0()); 
            }
            match(input,17,FOLLOW_17_in_rule__Integration__Group__0__Impl3776); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1845:1: rule__Integration__Group__1 : rule__Integration__Group__1__Impl rule__Integration__Group__2 ;
    public final void rule__Integration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1849:1: ( rule__Integration__Group__1__Impl rule__Integration__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1850:2: rule__Integration__Group__1__Impl rule__Integration__Group__2
            {
            pushFollow(FOLLOW_rule__Integration__Group__1__Impl_in_rule__Integration__Group__13807);
            rule__Integration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Integration__Group__2_in_rule__Integration__Group__13810);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1857:1: rule__Integration__Group__1__Impl : ( '{' ) ;
    public final void rule__Integration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1861:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1862:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1862:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1863:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__Integration__Group__1__Impl3838); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1876:1: rule__Integration__Group__2 : rule__Integration__Group__2__Impl rule__Integration__Group__3 ;
    public final void rule__Integration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1880:1: ( rule__Integration__Group__2__Impl rule__Integration__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1881:2: rule__Integration__Group__2__Impl rule__Integration__Group__3
            {
            pushFollow(FOLLOW_rule__Integration__Group__2__Impl_in_rule__Integration__Group__23869);
            rule__Integration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Integration__Group__3_in_rule__Integration__Group__23872);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1888:1: rule__Integration__Group__2__Impl : ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) ) ;
    public final void rule__Integration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1892:1: ( ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1893:1: ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1893:1: ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1894:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1894:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1895:1: ( rule__Integration__CodeIntegrationListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1896:1: ( rule__Integration__CodeIntegrationListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1896:2: rule__Integration__CodeIntegrationListAssignment_2
            {
            pushFollow(FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl3901);
            rule__Integration__CodeIntegrationListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1899:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1900:1: ( rule__Integration__CodeIntegrationListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1901:1: ( rule__Integration__CodeIntegrationListAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==18) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1901:2: rule__Integration__CodeIntegrationListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl3913);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1912:1: rule__Integration__Group__3 : rule__Integration__Group__3__Impl ;
    public final void rule__Integration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1916:1: ( rule__Integration__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1917:2: rule__Integration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Integration__Group__3__Impl_in_rule__Integration__Group__33946);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1923:1: rule__Integration__Group__3__Impl : ( '}' ) ;
    public final void rule__Integration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1927:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1928:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1928:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1929:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__Integration__Group__3__Impl3974); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1950:1: rule__JavaFXIntegration__Group__0 : rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1 ;
    public final void rule__JavaFXIntegration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1954:1: ( rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1955:2: rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__0__Impl_in_rule__JavaFXIntegration__Group__04013);
            rule__JavaFXIntegration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__1_in_rule__JavaFXIntegration__Group__04016);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1962:1: rule__JavaFXIntegration__Group__0__Impl : ( 'javafx' ) ;
    public final void rule__JavaFXIntegration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1966:1: ( ( 'javafx' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1967:1: ( 'javafx' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1967:1: ( 'javafx' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1968:1: 'javafx'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getJavafxKeyword_0()); 
            }
            match(input,18,FOLLOW_18_in_rule__JavaFXIntegration__Group__0__Impl4044); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1981:1: rule__JavaFXIntegration__Group__1 : rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2 ;
    public final void rule__JavaFXIntegration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1985:1: ( rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1986:2: rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__1__Impl_in_rule__JavaFXIntegration__Group__14075);
            rule__JavaFXIntegration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__2_in_rule__JavaFXIntegration__Group__14078);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1993:1: rule__JavaFXIntegration__Group__1__Impl : ( '{' ) ;
    public final void rule__JavaFXIntegration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1997:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1998:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1998:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1999:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__JavaFXIntegration__Group__1__Impl4106); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2012:1: rule__JavaFXIntegration__Group__2 : rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3 ;
    public final void rule__JavaFXIntegration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2016:1: ( rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2017:2: rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__2__Impl_in_rule__JavaFXIntegration__Group__24137);
            rule__JavaFXIntegration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__3_in_rule__JavaFXIntegration__Group__24140);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2024:1: rule__JavaFXIntegration__Group__2__Impl : ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) ) ;
    public final void rule__JavaFXIntegration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2028:1: ( ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2029:1: ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2029:1: ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2030:1: ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2030:1: ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2031:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2032:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2032:2: rule__JavaFXIntegration__CodegenerationListAssignment_2
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__CodegenerationListAssignment_2_in_rule__JavaFXIntegration__Group__2__Impl4169);
            rule__JavaFXIntegration__CodegenerationListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2035:1: ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2036:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2037:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=19 && LA13_0<=20)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2037:2: rule__JavaFXIntegration__CodegenerationListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__JavaFXIntegration__CodegenerationListAssignment_2_in_rule__JavaFXIntegration__Group__2__Impl4181);
            	    rule__JavaFXIntegration__CodegenerationListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2048:1: rule__JavaFXIntegration__Group__3 : rule__JavaFXIntegration__Group__3__Impl ;
    public final void rule__JavaFXIntegration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2052:1: ( rule__JavaFXIntegration__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2053:2: rule__JavaFXIntegration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__JavaFXIntegration__Group__3__Impl_in_rule__JavaFXIntegration__Group__34214);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2059:1: rule__JavaFXIntegration__Group__3__Impl : ( '}' ) ;
    public final void rule__JavaFXIntegration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2063:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2064:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2064:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2065:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__JavaFXIntegration__Group__3__Impl4242); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2086:1: rule__JavaCodeGeneration__Group__0 : rule__JavaCodeGeneration__Group__0__Impl rule__JavaCodeGeneration__Group__1 ;
    public final void rule__JavaCodeGeneration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2090:1: ( rule__JavaCodeGeneration__Group__0__Impl rule__JavaCodeGeneration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2091:2: rule__JavaCodeGeneration__Group__0__Impl rule__JavaCodeGeneration__Group__1
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group__0__Impl_in_rule__JavaCodeGeneration__Group__04281);
            rule__JavaCodeGeneration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group__1_in_rule__JavaCodeGeneration__Group__04284);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2098:1: rule__JavaCodeGeneration__Group__0__Impl : ( 'java' ) ;
    public final void rule__JavaCodeGeneration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2102:1: ( ( 'java' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2103:1: ( 'java' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2103:1: ( 'java' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2104:1: 'java'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getJavaKeyword_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__JavaCodeGeneration__Group__0__Impl4312); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2117:1: rule__JavaCodeGeneration__Group__1 : rule__JavaCodeGeneration__Group__1__Impl ;
    public final void rule__JavaCodeGeneration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2121:1: ( rule__JavaCodeGeneration__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2122:2: rule__JavaCodeGeneration__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__Group__1__Impl_in_rule__JavaCodeGeneration__Group__14343);
            rule__JavaCodeGeneration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2128:1: rule__JavaCodeGeneration__Group__1__Impl : ( ( rule__JavaCodeGeneration__NameAssignment_1 ) ) ;
    public final void rule__JavaCodeGeneration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2132:1: ( ( ( rule__JavaCodeGeneration__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2133:1: ( ( rule__JavaCodeGeneration__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2133:1: ( ( rule__JavaCodeGeneration__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2134:1: ( rule__JavaCodeGeneration__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2135:1: ( rule__JavaCodeGeneration__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2135:2: rule__JavaCodeGeneration__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__JavaCodeGeneration__NameAssignment_1_in_rule__JavaCodeGeneration__Group__1__Impl4370);
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


    // $ANTLR start "rule__E4CodeGeneration__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2149:1: rule__E4CodeGeneration__Group__0 : rule__E4CodeGeneration__Group__0__Impl rule__E4CodeGeneration__Group__1 ;
    public final void rule__E4CodeGeneration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2153:1: ( rule__E4CodeGeneration__Group__0__Impl rule__E4CodeGeneration__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2154:2: rule__E4CodeGeneration__Group__0__Impl rule__E4CodeGeneration__Group__1
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group__0__Impl_in_rule__E4CodeGeneration__Group__04404);
            rule__E4CodeGeneration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group__1_in_rule__E4CodeGeneration__Group__04407);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2161:1: rule__E4CodeGeneration__Group__0__Impl : ( 'e4' ) ;
    public final void rule__E4CodeGeneration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2165:1: ( ( 'e4' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2166:1: ( 'e4' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2166:1: ( 'e4' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2167:1: 'e4'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getE4Keyword_0()); 
            }
            match(input,20,FOLLOW_20_in_rule__E4CodeGeneration__Group__0__Impl4435); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2180:1: rule__E4CodeGeneration__Group__1 : rule__E4CodeGeneration__Group__1__Impl ;
    public final void rule__E4CodeGeneration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2184:1: ( rule__E4CodeGeneration__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2185:2: rule__E4CodeGeneration__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__Group__1__Impl_in_rule__E4CodeGeneration__Group__14466);
            rule__E4CodeGeneration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2191:1: rule__E4CodeGeneration__Group__1__Impl : ( ( rule__E4CodeGeneration__IconPathAssignment_1 ) ) ;
    public final void rule__E4CodeGeneration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2195:1: ( ( ( rule__E4CodeGeneration__IconPathAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2196:1: ( ( rule__E4CodeGeneration__IconPathAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2196:1: ( ( rule__E4CodeGeneration__IconPathAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2197:1: ( rule__E4CodeGeneration__IconPathAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getIconPathAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2198:1: ( rule__E4CodeGeneration__IconPathAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2198:2: rule__E4CodeGeneration__IconPathAssignment_1
            {
            pushFollow(FOLLOW_rule__E4CodeGeneration__IconPathAssignment_1_in_rule__E4CodeGeneration__Group__1__Impl4493);
            rule__E4CodeGeneration__IconPathAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getIconPathAssignment_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Paritioning__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2212:1: rule__Paritioning__Group__0 : rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1 ;
    public final void rule__Paritioning__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2216:1: ( rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2217:2: rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__0__Impl_in_rule__Paritioning__Group__04527);
            rule__Paritioning__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__1_in_rule__Paritioning__Group__04530);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2224:1: rule__Paritioning__Group__0__Impl : ( 'partitioning' ) ;
    public final void rule__Paritioning__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2228:1: ( ( 'partitioning' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2229:1: ( 'partitioning' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2229:1: ( 'partitioning' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2230:1: 'partitioning'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitioningKeyword_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__Paritioning__Group__0__Impl4558); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2243:1: rule__Paritioning__Group__1 : rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2 ;
    public final void rule__Paritioning__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2247:1: ( rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2248:2: rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__1__Impl_in_rule__Paritioning__Group__14589);
            rule__Paritioning__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__2_in_rule__Paritioning__Group__14592);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2255:1: rule__Paritioning__Group__1__Impl : ( '{' ) ;
    public final void rule__Paritioning__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2259:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2260:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2260:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2261:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__Paritioning__Group__1__Impl4620); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2274:1: rule__Paritioning__Group__2 : rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3 ;
    public final void rule__Paritioning__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2278:1: ( rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2279:2: rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__2__Impl_in_rule__Paritioning__Group__24651);
            rule__Paritioning__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__3_in_rule__Paritioning__Group__24654);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2286:1: rule__Paritioning__Group__2__Impl : ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) ) ;
    public final void rule__Paritioning__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2290:1: ( ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2291:1: ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2291:1: ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2292:1: ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2292:1: ( ( rule__Paritioning__PartitionsAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2293:1: ( rule__Paritioning__PartitionsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2294:1: ( rule__Paritioning__PartitionsAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2294:2: rule__Paritioning__PartitionsAssignment_2
            {
            pushFollow(FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl4683);
            rule__Paritioning__PartitionsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2297:1: ( ( rule__Paritioning__PartitionsAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2298:1: ( rule__Paritioning__PartitionsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2299:1: ( rule__Paritioning__PartitionsAssignment_2 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==22) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2299:2: rule__Paritioning__PartitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl4695);
            	    rule__Paritioning__PartitionsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2310:1: rule__Paritioning__Group__3 : rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4 ;
    public final void rule__Paritioning__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2314:1: ( rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2315:2: rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__3__Impl_in_rule__Paritioning__Group__34728);
            rule__Paritioning__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioning__Group__4_in_rule__Paritioning__Group__34731);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2322:1: rule__Paritioning__Group__3__Impl : ( ( rule__Paritioning__PartitionerAssignment_3 ) ) ;
    public final void rule__Paritioning__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2326:1: ( ( ( rule__Paritioning__PartitionerAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2327:1: ( ( rule__Paritioning__PartitionerAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2327:1: ( ( rule__Paritioning__PartitionerAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2328:1: ( rule__Paritioning__PartitionerAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionerAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2329:1: ( rule__Paritioning__PartitionerAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2329:2: rule__Paritioning__PartitionerAssignment_3
            {
            pushFollow(FOLLOW_rule__Paritioning__PartitionerAssignment_3_in_rule__Paritioning__Group__3__Impl4758);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2339:1: rule__Paritioning__Group__4 : rule__Paritioning__Group__4__Impl ;
    public final void rule__Paritioning__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2343:1: ( rule__Paritioning__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2344:2: rule__Paritioning__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__4__Impl_in_rule__Paritioning__Group__44788);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2350:1: rule__Paritioning__Group__4__Impl : ( '}' ) ;
    public final void rule__Paritioning__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2354:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2355:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2355:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2356:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,16,FOLLOW_16_in_rule__Paritioning__Group__4__Impl4816); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2379:1: rule__Partition__Group__0 : rule__Partition__Group__0__Impl rule__Partition__Group__1 ;
    public final void rule__Partition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2383:1: ( rule__Partition__Group__0__Impl rule__Partition__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2384:2: rule__Partition__Group__0__Impl rule__Partition__Group__1
            {
            pushFollow(FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__04857);
            rule__Partition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__04860);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2391:1: rule__Partition__Group__0__Impl : ( 'partition' ) ;
    public final void rule__Partition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2395:1: ( ( 'partition' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2396:1: ( 'partition' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2396:1: ( 'partition' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2397:1: 'partition'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__Partition__Group__0__Impl4888); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2410:1: rule__Partition__Group__1 : rule__Partition__Group__1__Impl ;
    public final void rule__Partition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2414:1: ( rule__Partition__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2415:2: rule__Partition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__14919);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2421:1: rule__Partition__Group__1__Impl : ( ( rule__Partition__NameAssignment_1 ) ) ;
    public final void rule__Partition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2425:1: ( ( ( rule__Partition__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2426:1: ( ( rule__Partition__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2426:1: ( ( rule__Partition__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2427:1: ( rule__Partition__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2428:1: ( rule__Partition__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2428:2: rule__Partition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl4946);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2442:1: rule__Paritioner_JS__Group__0 : rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1 ;
    public final void rule__Paritioner_JS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2446:1: ( rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2447:2: rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__0__Impl_in_rule__Paritioner_JS__Group__04980);
            rule__Paritioner_JS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__1_in_rule__Paritioner_JS__Group__04983);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2454:1: rule__Paritioner_JS__Group__0__Impl : ( 'script' ) ;
    public final void rule__Paritioner_JS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2458:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2459:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2459:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2460:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptKeyword_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__Paritioner_JS__Group__0__Impl5011); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2473:1: rule__Paritioner_JS__Group__1 : rule__Paritioner_JS__Group__1__Impl ;
    public final void rule__Paritioner_JS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2477:1: ( rule__Paritioner_JS__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2478:2: rule__Paritioner_JS__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__1__Impl_in_rule__Paritioner_JS__Group__15042);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2484:1: rule__Paritioner_JS__Group__1__Impl : ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) ) ;
    public final void rule__Paritioner_JS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2488:1: ( ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2489:1: ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2489:1: ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2490:1: ( rule__Paritioner_JS__ScriptURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptURIAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2491:1: ( rule__Paritioner_JS__ScriptURIAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2491:2: rule__Paritioner_JS__ScriptURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__ScriptURIAssignment_1_in_rule__Paritioner_JS__Group__1__Impl5069);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2505:1: rule__Partitioner_Rule__Group__0 : rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1 ;
    public final void rule__Partitioner_Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2509:1: ( rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2510:2: rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__0__Impl_in_rule__Partitioner_Rule__Group__05103);
            rule__Partitioner_Rule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__1_in_rule__Partitioner_Rule__Group__05106);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2517:1: rule__Partitioner_Rule__Group__0__Impl : ( 'rule' ) ;
    public final void rule__Partitioner_Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2521:1: ( ( 'rule' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2522:1: ( 'rule' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2522:1: ( 'rule' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2523:1: 'rule'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__Partitioner_Rule__Group__0__Impl5134); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2536:1: rule__Partitioner_Rule__Group__1 : rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2 ;
    public final void rule__Partitioner_Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2540:1: ( rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2541:2: rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__1__Impl_in_rule__Partitioner_Rule__Group__15165);
            rule__Partitioner_Rule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__2_in_rule__Partitioner_Rule__Group__15168);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2548:1: rule__Partitioner_Rule__Group__1__Impl : ( '{' ) ;
    public final void rule__Partitioner_Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2552:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2553:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2553:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2554:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__Partitioner_Rule__Group__1__Impl5196); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2567:1: rule__Partitioner_Rule__Group__2 : rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3 ;
    public final void rule__Partitioner_Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2571:1: ( rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2572:2: rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__2__Impl_in_rule__Partitioner_Rule__Group__25227);
            rule__Partitioner_Rule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__3_in_rule__Partitioner_Rule__Group__25230);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2579:1: rule__Partitioner_Rule__Group__2__Impl : ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) ) ;
    public final void rule__Partitioner_Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2583:1: ( ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2584:1: ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2584:1: ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2585:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2585:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2586:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2587:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2587:2: rule__Partitioner_Rule__RuleListAssignment_2
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl5259);
            rule__Partitioner_Rule__RuleListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2590:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2591:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2592:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==25||LA15_0==29) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2592:2: rule__Partitioner_Rule__RuleListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl5271);
            	    rule__Partitioner_Rule__RuleListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2603:1: rule__Partitioner_Rule__Group__3 : rule__Partitioner_Rule__Group__3__Impl ;
    public final void rule__Partitioner_Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2607:1: ( rule__Partitioner_Rule__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2608:2: rule__Partitioner_Rule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__3__Impl_in_rule__Partitioner_Rule__Group__35304);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2614:1: rule__Partitioner_Rule__Group__3__Impl : ( '}' ) ;
    public final void rule__Partitioner_Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2618:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2619:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2619:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2620:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__Partitioner_Rule__Group__3__Impl5332); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2641:1: rule__Partition_SingleLineRule__Group__0 : rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1 ;
    public final void rule__Partition_SingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2645:1: ( rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2646:2: rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__0__Impl_in_rule__Partition_SingleLineRule__Group__05371);
            rule__Partition_SingleLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__1_in_rule__Partition_SingleLineRule__Group__05374);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2653:1: rule__Partition_SingleLineRule__Group__0__Impl : ( 'single_line' ) ;
    public final void rule__Partition_SingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2657:1: ( ( 'single_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2658:1: ( 'single_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2658:1: ( 'single_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2659:1: 'single_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__Partition_SingleLineRule__Group__0__Impl5402); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2672:1: rule__Partition_SingleLineRule__Group__1 : rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2 ;
    public final void rule__Partition_SingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2676:1: ( rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2677:2: rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__1__Impl_in_rule__Partition_SingleLineRule__Group__15433);
            rule__Partition_SingleLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__2_in_rule__Partition_SingleLineRule__Group__15436);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2684:1: rule__Partition_SingleLineRule__Group__1__Impl : ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__Partition_SingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2688:1: ( ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2689:1: ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2689:1: ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2690:1: ( rule__Partition_SingleLineRule__ParitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2691:1: ( rule__Partition_SingleLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2691:2: rule__Partition_SingleLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__ParitionAssignment_1_in_rule__Partition_SingleLineRule__Group__1__Impl5463);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2701:1: rule__Partition_SingleLineRule__Group__2 : rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3 ;
    public final void rule__Partition_SingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2705:1: ( rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2706:2: rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__2__Impl_in_rule__Partition_SingleLineRule__Group__25493);
            rule__Partition_SingleLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__3_in_rule__Partition_SingleLineRule__Group__25496);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2713:1: rule__Partition_SingleLineRule__Group__2__Impl : ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__Partition_SingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2717:1: ( ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2718:1: ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2718:1: ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2719:1: ( rule__Partition_SingleLineRule__StartSeqAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2720:1: ( rule__Partition_SingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2720:2: rule__Partition_SingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__StartSeqAssignment_2_in_rule__Partition_SingleLineRule__Group__2__Impl5523);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2730:1: rule__Partition_SingleLineRule__Group__3 : rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4 ;
    public final void rule__Partition_SingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2734:1: ( rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2735:2: rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__3__Impl_in_rule__Partition_SingleLineRule__Group__35553);
            rule__Partition_SingleLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__4_in_rule__Partition_SingleLineRule__Group__35556);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2742:1: rule__Partition_SingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__Partition_SingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2746:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2747:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2747:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2748:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            }
            match(input,26,FOLLOW_26_in_rule__Partition_SingleLineRule__Group__3__Impl5584); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2761:1: rule__Partition_SingleLineRule__Group__4 : rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5 ;
    public final void rule__Partition_SingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2765:1: ( rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2766:2: rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__4__Impl_in_rule__Partition_SingleLineRule__Group__45615);
            rule__Partition_SingleLineRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__5_in_rule__Partition_SingleLineRule__Group__45618);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2773:1: rule__Partition_SingleLineRule__Group__4__Impl : ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2777:1: ( ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2778:1: ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2778:1: ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2779:1: ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2780:1: ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2780:2: rule__Partition_SingleLineRule__EndSeqAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Partition_SingleLineRule__EndSeqAssignment_4_in_rule__Partition_SingleLineRule__Group__4__Impl5645);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2790:1: rule__Partition_SingleLineRule__Group__5 : rule__Partition_SingleLineRule__Group__5__Impl ;
    public final void rule__Partition_SingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2794:1: ( rule__Partition_SingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2795:2: rule__Partition_SingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__5__Impl_in_rule__Partition_SingleLineRule__Group__55676);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2801:1: rule__Partition_SingleLineRule__Group__5__Impl : ( ( rule__Partition_SingleLineRule__Group_5__0 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2805:1: ( ( ( rule__Partition_SingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2806:1: ( ( rule__Partition_SingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2806:1: ( ( rule__Partition_SingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2807:1: ( rule__Partition_SingleLineRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_5()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2808:1: ( rule__Partition_SingleLineRule__Group_5__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2808:2: rule__Partition_SingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__0_in_rule__Partition_SingleLineRule__Group__5__Impl5703);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2830:1: rule__Partition_SingleLineRule__Group_5__0 : rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1 ;
    public final void rule__Partition_SingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2834:1: ( rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2835:2: rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__0__Impl_in_rule__Partition_SingleLineRule__Group_5__05746);
            rule__Partition_SingleLineRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__1_in_rule__Partition_SingleLineRule__Group_5__05749);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2842:1: rule__Partition_SingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__Partition_SingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2846:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2847:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2847:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2848:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_5_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__Partition_SingleLineRule__Group_5__0__Impl5777); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2861:1: rule__Partition_SingleLineRule__Group_5__1 : rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2 ;
    public final void rule__Partition_SingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2865:1: ( rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2866:2: rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__1__Impl_in_rule__Partition_SingleLineRule__Group_5__15808);
            rule__Partition_SingleLineRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__2_in_rule__Partition_SingleLineRule__Group_5__15811);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2873:1: rule__Partition_SingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__Partition_SingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2877:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2878:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2878:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2879:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_5_1()); 
            }
            match(input,28,FOLLOW_28_in_rule__Partition_SingleLineRule__Group_5__1__Impl5839); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2892:1: rule__Partition_SingleLineRule__Group_5__2 : rule__Partition_SingleLineRule__Group_5__2__Impl ;
    public final void rule__Partition_SingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2896:1: ( rule__Partition_SingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2897:2: rule__Partition_SingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__2__Impl_in_rule__Partition_SingleLineRule__Group_5__25870);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2903:1: rule__Partition_SingleLineRule__Group_5__2__Impl : ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__Partition_SingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2907:1: ( ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2908:1: ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2908:1: ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2909:1: ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2910:1: ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2910:2: rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_SingleLineRule__Group_5__2__Impl5897);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2926:1: rule__Partition_MultiLineRule__Group__0 : rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1 ;
    public final void rule__Partition_MultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2930:1: ( rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2931:2: rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__0__Impl_in_rule__Partition_MultiLineRule__Group__05933);
            rule__Partition_MultiLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__1_in_rule__Partition_MultiLineRule__Group__05936);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2938:1: rule__Partition_MultiLineRule__Group__0__Impl : ( 'multi_line' ) ;
    public final void rule__Partition_MultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2942:1: ( ( 'multi_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2943:1: ( 'multi_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2943:1: ( 'multi_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2944:1: 'multi_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            }
            match(input,29,FOLLOW_29_in_rule__Partition_MultiLineRule__Group__0__Impl5964); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2957:1: rule__Partition_MultiLineRule__Group__1 : rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2 ;
    public final void rule__Partition_MultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2961:1: ( rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2962:2: rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__1__Impl_in_rule__Partition_MultiLineRule__Group__15995);
            rule__Partition_MultiLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__2_in_rule__Partition_MultiLineRule__Group__15998);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2969:1: rule__Partition_MultiLineRule__Group__1__Impl : ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2973:1: ( ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2974:1: ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2974:1: ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2975:1: ( rule__Partition_MultiLineRule__ParitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2976:1: ( rule__Partition_MultiLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2976:2: rule__Partition_MultiLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__ParitionAssignment_1_in_rule__Partition_MultiLineRule__Group__1__Impl6025);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2986:1: rule__Partition_MultiLineRule__Group__2 : rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3 ;
    public final void rule__Partition_MultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2990:1: ( rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2991:2: rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__2__Impl_in_rule__Partition_MultiLineRule__Group__26055);
            rule__Partition_MultiLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__3_in_rule__Partition_MultiLineRule__Group__26058);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2998:1: rule__Partition_MultiLineRule__Group__2__Impl : ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3002:1: ( ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3003:1: ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3003:1: ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3004:1: ( rule__Partition_MultiLineRule__StartSeqAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3005:1: ( rule__Partition_MultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3005:2: rule__Partition_MultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__StartSeqAssignment_2_in_rule__Partition_MultiLineRule__Group__2__Impl6085);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3015:1: rule__Partition_MultiLineRule__Group__3 : rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4 ;
    public final void rule__Partition_MultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3019:1: ( rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3020:2: rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__3__Impl_in_rule__Partition_MultiLineRule__Group__36115);
            rule__Partition_MultiLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__4_in_rule__Partition_MultiLineRule__Group__36118);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3027:1: rule__Partition_MultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__Partition_MultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3031:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3032:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3032:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3033:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            }
            match(input,26,FOLLOW_26_in_rule__Partition_MultiLineRule__Group__3__Impl6146); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3046:1: rule__Partition_MultiLineRule__Group__4 : rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5 ;
    public final void rule__Partition_MultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3050:1: ( rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3051:2: rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__4__Impl_in_rule__Partition_MultiLineRule__Group__46177);
            rule__Partition_MultiLineRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__5_in_rule__Partition_MultiLineRule__Group__46180);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3058:1: rule__Partition_MultiLineRule__Group__4__Impl : ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3062:1: ( ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3063:1: ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3063:1: ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3064:1: ( rule__Partition_MultiLineRule__EndSeqAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3065:1: ( rule__Partition_MultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3065:2: rule__Partition_MultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__EndSeqAssignment_4_in_rule__Partition_MultiLineRule__Group__4__Impl6207);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3075:1: rule__Partition_MultiLineRule__Group__5 : rule__Partition_MultiLineRule__Group__5__Impl ;
    public final void rule__Partition_MultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3079:1: ( rule__Partition_MultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3080:2: rule__Partition_MultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__5__Impl_in_rule__Partition_MultiLineRule__Group__56237);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3086:1: rule__Partition_MultiLineRule__Group__5__Impl : ( ( rule__Partition_MultiLineRule__Group_5__0 )? ) ;
    public final void rule__Partition_MultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3090:1: ( ( ( rule__Partition_MultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3091:1: ( ( rule__Partition_MultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3091:1: ( ( rule__Partition_MultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3092:1: ( rule__Partition_MultiLineRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup_5()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3093:1: ( rule__Partition_MultiLineRule__Group_5__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3093:2: rule__Partition_MultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__0_in_rule__Partition_MultiLineRule__Group__5__Impl6264);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3115:1: rule__Partition_MultiLineRule__Group_5__0 : rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1 ;
    public final void rule__Partition_MultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3119:1: ( rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3120:2: rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__0__Impl_in_rule__Partition_MultiLineRule__Group_5__06307);
            rule__Partition_MultiLineRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__1_in_rule__Partition_MultiLineRule__Group_5__06310);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3127:1: rule__Partition_MultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__Partition_MultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3131:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3132:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3132:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3133:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_5_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__Partition_MultiLineRule__Group_5__0__Impl6338); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3146:1: rule__Partition_MultiLineRule__Group_5__1 : rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2 ;
    public final void rule__Partition_MultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3150:1: ( rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3151:2: rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__1__Impl_in_rule__Partition_MultiLineRule__Group_5__16369);
            rule__Partition_MultiLineRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__2_in_rule__Partition_MultiLineRule__Group_5__16372);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3158:1: rule__Partition_MultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__Partition_MultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3162:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3163:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3163:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3164:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_5_1()); 
            }
            match(input,28,FOLLOW_28_in_rule__Partition_MultiLineRule__Group_5__1__Impl6400); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3177:1: rule__Partition_MultiLineRule__Group_5__2 : rule__Partition_MultiLineRule__Group_5__2__Impl ;
    public final void rule__Partition_MultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3181:1: ( rule__Partition_MultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3182:2: rule__Partition_MultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__2__Impl_in_rule__Partition_MultiLineRule__Group_5__26431);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3188:1: rule__Partition_MultiLineRule__Group_5__2__Impl : ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__Partition_MultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3192:1: ( ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3193:1: ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3193:1: ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3194:1: ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3195:1: ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3195:2: rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_MultiLineRule__Group_5__2__Impl6458);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3211:1: rule__LexicalHighlighting__Group__0 : rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1 ;
    public final void rule__LexicalHighlighting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3215:1: ( rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3216:2: rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__0__Impl_in_rule__LexicalHighlighting__Group__06494);
            rule__LexicalHighlighting__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__1_in_rule__LexicalHighlighting__Group__06497);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3223:1: rule__LexicalHighlighting__Group__0__Impl : ( 'lexical_highlighting' ) ;
    public final void rule__LexicalHighlighting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3227:1: ( ( 'lexical_highlighting' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3228:1: ( 'lexical_highlighting' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3228:1: ( 'lexical_highlighting' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3229:1: 'lexical_highlighting'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__LexicalHighlighting__Group__0__Impl6525); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3242:1: rule__LexicalHighlighting__Group__1 : rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2 ;
    public final void rule__LexicalHighlighting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3246:1: ( rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3247:2: rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__1__Impl_in_rule__LexicalHighlighting__Group__16556);
            rule__LexicalHighlighting__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__2_in_rule__LexicalHighlighting__Group__16559);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3254:1: rule__LexicalHighlighting__Group__1__Impl : ( '{' ) ;
    public final void rule__LexicalHighlighting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3258:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3259:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3259:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3260:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__LexicalHighlighting__Group__1__Impl6587); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3273:1: rule__LexicalHighlighting__Group__2 : rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3 ;
    public final void rule__LexicalHighlighting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3277:1: ( rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3278:2: rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__2__Impl_in_rule__LexicalHighlighting__Group__26618);
            rule__LexicalHighlighting__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__3_in_rule__LexicalHighlighting__Group__26621);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3285:1: rule__LexicalHighlighting__Group__2__Impl : ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) ) ;
    public final void rule__LexicalHighlighting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3289:1: ( ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3290:1: ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3290:1: ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3291:1: ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3291:1: ( ( rule__LexicalHighlighting__ListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3292:1: ( rule__LexicalHighlighting__ListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3293:1: ( rule__LexicalHighlighting__ListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3293:2: rule__LexicalHighlighting__ListAssignment_2
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl6650);
            rule__LexicalHighlighting__ListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3296:1: ( ( rule__LexicalHighlighting__ListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3297:1: ( rule__LexicalHighlighting__ListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3298:1: ( rule__LexicalHighlighting__ListAssignment_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=23 && LA19_0<=24)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3298:2: rule__LexicalHighlighting__ListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl6662);
            	    rule__LexicalHighlighting__ListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3309:1: rule__LexicalHighlighting__Group__3 : rule__LexicalHighlighting__Group__3__Impl ;
    public final void rule__LexicalHighlighting__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3313:1: ( rule__LexicalHighlighting__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3314:2: rule__LexicalHighlighting__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__3__Impl_in_rule__LexicalHighlighting__Group__36695);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3320:1: rule__LexicalHighlighting__Group__3__Impl : ( '}' ) ;
    public final void rule__LexicalHighlighting__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3324:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3325:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3325:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3326:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,16,FOLLOW_16_in_rule__LexicalHighlighting__Group__3__Impl6723); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3347:1: rule__LexicalPartitionHighlighting_JS__Group__0 : rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1 ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3351:1: ( rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3352:2: rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__06762);
            rule__LexicalPartitionHighlighting_JS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1_in_rule__LexicalPartitionHighlighting_JS__Group__06765);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3359:1: rule__LexicalPartitionHighlighting_JS__Group__0__Impl : ( 'script' ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3363:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3364:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3364:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3365:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__LexicalPartitionHighlighting_JS__Group__0__Impl6793); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3378:1: rule__LexicalPartitionHighlighting_JS__Group__1 : rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2 ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3382:1: ( rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3383:2: rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__16824);
            rule__LexicalPartitionHighlighting_JS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2_in_rule__LexicalPartitionHighlighting_JS__Group__16827);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3390:1: rule__LexicalPartitionHighlighting_JS__Group__1__Impl : ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3394:1: ( ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3395:1: ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3395:1: ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3396:1: ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3397:1: ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3397:2: rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_JS__Group__1__Impl6854);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3407:1: rule__LexicalPartitionHighlighting_JS__Group__2 : rule__LexicalPartitionHighlighting_JS__Group__2__Impl ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3411:1: ( rule__LexicalPartitionHighlighting_JS__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3412:2: rule__LexicalPartitionHighlighting_JS__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__26884);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3418:1: rule__LexicalPartitionHighlighting_JS__Group__2__Impl : ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3422:1: ( ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3423:1: ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3423:1: ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3424:1: ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURIAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3425:1: ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3425:2: rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2_in_rule__LexicalPartitionHighlighting_JS__Group__2__Impl6911);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3441:1: rule__LexicalPartitionHighlighting_Rule__Group__0 : rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3445:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3446:2: rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__06947);
            rule__LexicalPartitionHighlighting_Rule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1_in_rule__LexicalPartitionHighlighting_Rule__Group__06950);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3453:1: rule__LexicalPartitionHighlighting_Rule__Group__0__Impl : ( 'rule' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3457:1: ( ( 'rule' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3458:1: ( 'rule' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3458:1: ( 'rule' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3459:1: 'rule'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl6978); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3472:1: rule__LexicalPartitionHighlighting_Rule__Group__1 : rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3476:1: ( rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3477:2: rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__17009);
            rule__LexicalPartitionHighlighting_Rule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2_in_rule__LexicalPartitionHighlighting_Rule__Group__17012);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3484:1: rule__LexicalPartitionHighlighting_Rule__Group__1__Impl : ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3488:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3489:1: ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3489:1: ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3490:1: ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3491:1: ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3491:2: rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl7039);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3501:1: rule__LexicalPartitionHighlighting_Rule__Group__2 : rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3505:1: ( rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3506:2: rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__27069);
            rule__LexicalPartitionHighlighting_Rule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3_in_rule__LexicalPartitionHighlighting_Rule__Group__27072);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3513:1: rule__LexicalPartitionHighlighting_Rule__Group__2__Impl : ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3517:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3518:1: ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3518:1: ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3519:1: ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3520:1: ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==37) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3520:2: rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2
                    {
                    pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2_in_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl7099);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3530:1: rule__LexicalPartitionHighlighting_Rule__Group__3 : rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3534:1: ( rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3535:2: rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__37130);
            rule__LexicalPartitionHighlighting_Rule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4_in_rule__LexicalPartitionHighlighting_Rule__Group__37133);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3542:1: rule__LexicalPartitionHighlighting_Rule__Group__3__Impl : ( '{' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3546:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3547:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3547:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3548:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,15,FOLLOW_15_in_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl7161); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3561:1: rule__LexicalPartitionHighlighting_Rule__Group__4 : rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3565:1: ( rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3566:2: rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__47192);
            rule__LexicalPartitionHighlighting_Rule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5_in_rule__LexicalPartitionHighlighting_Rule__Group__47195);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3573:1: rule__LexicalPartitionHighlighting_Rule__Group__4__Impl : ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3577:1: ( ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3578:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3578:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3579:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3579:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3580:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3581:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3581:2: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl7224);
            rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3584:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3585:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3586:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID||LA21_0==38) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3586:2: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl7236);
            	    rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3597:1: rule__LexicalPartitionHighlighting_Rule__Group__5 : rule__LexicalPartitionHighlighting_Rule__Group__5__Impl ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3601:1: ( rule__LexicalPartitionHighlighting_Rule__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3602:2: rule__LexicalPartitionHighlighting_Rule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__57269);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3608:1: rule__LexicalPartitionHighlighting_Rule__Group__5__Impl : ( '}' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3612:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3613:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3613:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3614:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,16,FOLLOW_16_in_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl7297); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3639:1: rule__Token__Group__0 : rule__Token__Group__0__Impl rule__Token__Group__1 ;
    public final void rule__Token__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3643:1: ( rule__Token__Group__0__Impl rule__Token__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3644:2: rule__Token__Group__0__Impl rule__Token__Group__1
            {
            pushFollow(FOLLOW_rule__Token__Group__0__Impl_in_rule__Token__Group__07340);
            rule__Token__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group__1_in_rule__Token__Group__07343);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3651:1: rule__Token__Group__0__Impl : ( ( rule__Token__DefaultAssignment_0 )? ) ;
    public final void rule__Token__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3655:1: ( ( ( rule__Token__DefaultAssignment_0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3656:1: ( ( rule__Token__DefaultAssignment_0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3656:1: ( ( rule__Token__DefaultAssignment_0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3657:1: ( rule__Token__DefaultAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultAssignment_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3658:1: ( rule__Token__DefaultAssignment_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==38) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3658:2: rule__Token__DefaultAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Token__DefaultAssignment_0_in_rule__Token__Group__0__Impl7370);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3668:1: rule__Token__Group__1 : rule__Token__Group__1__Impl rule__Token__Group__2 ;
    public final void rule__Token__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3672:1: ( rule__Token__Group__1__Impl rule__Token__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3673:2: rule__Token__Group__1__Impl rule__Token__Group__2
            {
            pushFollow(FOLLOW_rule__Token__Group__1__Impl_in_rule__Token__Group__17401);
            rule__Token__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group__2_in_rule__Token__Group__17404);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3680:1: rule__Token__Group__1__Impl : ( ( rule__Token__NameAssignment_1 ) ) ;
    public final void rule__Token__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3684:1: ( ( ( rule__Token__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3685:1: ( ( rule__Token__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3685:1: ( ( rule__Token__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3686:1: ( rule__Token__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3687:1: ( rule__Token__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3687:2: rule__Token__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Token__NameAssignment_1_in_rule__Token__Group__1__Impl7431);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3697:1: rule__Token__Group__2 : rule__Token__Group__2__Impl ;
    public final void rule__Token__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3701:1: ( rule__Token__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3702:2: rule__Token__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Token__Group__2__Impl_in_rule__Token__Group__27461);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3708:1: rule__Token__Group__2__Impl : ( ( rule__Token__Group_2__0 )? ) ;
    public final void rule__Token__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3712:1: ( ( ( rule__Token__Group_2__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3713:1: ( ( rule__Token__Group_2__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3713:1: ( ( rule__Token__Group_2__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3714:1: ( rule__Token__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getGroup_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3715:1: ( rule__Token__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==15) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3715:2: rule__Token__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Token__Group_2__0_in_rule__Token__Group__2__Impl7488);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3731:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3735:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3736:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
            {
            pushFollow(FOLLOW_rule__Token__Group_2__0__Impl_in_rule__Token__Group_2__07525);
            rule__Token__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group_2__1_in_rule__Token__Group_2__07528);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3743:1: rule__Token__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3747:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3748:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3748:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3749:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__Token__Group_2__0__Impl7556); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3762:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl rule__Token__Group_2__2 ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3766:1: ( rule__Token__Group_2__1__Impl rule__Token__Group_2__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3767:2: rule__Token__Group_2__1__Impl rule__Token__Group_2__2
            {
            pushFollow(FOLLOW_rule__Token__Group_2__1__Impl_in_rule__Token__Group_2__17587);
            rule__Token__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Token__Group_2__2_in_rule__Token__Group_2__17590);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3774:1: rule__Token__Group_2__1__Impl : ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3778:1: ( ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3779:1: ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3779:1: ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3780:1: ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3780:1: ( ( rule__Token__ScannerListAssignment_2_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3781:1: ( rule__Token__ScannerListAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3782:1: ( rule__Token__ScannerListAssignment_2_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3782:2: rule__Token__ScannerListAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl7619);
            rule__Token__ScannerListAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3785:1: ( ( rule__Token__ScannerListAssignment_2_1 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3786:1: ( rule__Token__ScannerListAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3787:1: ( rule__Token__ScannerListAssignment_2_1 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==23||LA24_0==25||LA24_0==29||LA24_0==31||LA24_0==36) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3787:2: rule__Token__ScannerListAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl7631);
            	    rule__Token__ScannerListAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3798:1: rule__Token__Group_2__2 : rule__Token__Group_2__2__Impl ;
    public final void rule__Token__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3802:1: ( rule__Token__Group_2__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3803:2: rule__Token__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Token__Group_2__2__Impl_in_rule__Token__Group_2__27664);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3809:1: rule__Token__Group_2__2__Impl : ( '}' ) ;
    public final void rule__Token__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3813:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3814:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3814:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3815:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,16,FOLLOW_16_in_rule__Token__Group_2__2__Impl7692); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3834:1: rule__Scanner_Keyword__Group__0 : rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1 ;
    public final void rule__Scanner_Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3838:1: ( rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3839:2: rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__0__Impl_in_rule__Scanner_Keyword__Group__07729);
            rule__Scanner_Keyword__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__1_in_rule__Scanner_Keyword__Group__07732);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3846:1: rule__Scanner_Keyword__Group__0__Impl : ( 'keywords' ) ;
    public final void rule__Scanner_Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3850:1: ( ( 'keywords' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3851:1: ( 'keywords' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3851:1: ( 'keywords' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3852:1: 'keywords'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0()); 
            }
            match(input,31,FOLLOW_31_in_rule__Scanner_Keyword__Group__0__Impl7760); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3865:1: rule__Scanner_Keyword__Group__1 : rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2 ;
    public final void rule__Scanner_Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3869:1: ( rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3870:2: rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__1__Impl_in_rule__Scanner_Keyword__Group__17791);
            rule__Scanner_Keyword__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__2_in_rule__Scanner_Keyword__Group__17794);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3877:1: rule__Scanner_Keyword__Group__1__Impl : ( '[' ) ;
    public final void rule__Scanner_Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3881:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3882:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3882:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3883:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,32,FOLLOW_32_in_rule__Scanner_Keyword__Group__1__Impl7822); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3896:1: rule__Scanner_Keyword__Group__2 : rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3 ;
    public final void rule__Scanner_Keyword__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3900:1: ( rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3901:2: rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__2__Impl_in_rule__Scanner_Keyword__Group__27853);
            rule__Scanner_Keyword__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__3_in_rule__Scanner_Keyword__Group__27856);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3908:1: rule__Scanner_Keyword__Group__2__Impl : ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) ) ;
    public final void rule__Scanner_Keyword__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3912:1: ( ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3913:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3913:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3914:1: ( rule__Scanner_Keyword__KeywordsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3915:1: ( rule__Scanner_Keyword__KeywordsAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3915:2: rule__Scanner_Keyword__KeywordsAssignment_2
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_2_in_rule__Scanner_Keyword__Group__2__Impl7883);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3925:1: rule__Scanner_Keyword__Group__3 : rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4 ;
    public final void rule__Scanner_Keyword__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3929:1: ( rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3930:2: rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__3__Impl_in_rule__Scanner_Keyword__Group__37913);
            rule__Scanner_Keyword__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__4_in_rule__Scanner_Keyword__Group__37916);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3937:1: rule__Scanner_Keyword__Group__3__Impl : ( ( rule__Scanner_Keyword__Group_3__0 )* ) ;
    public final void rule__Scanner_Keyword__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3941:1: ( ( ( rule__Scanner_Keyword__Group_3__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3942:1: ( ( rule__Scanner_Keyword__Group_3__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3942:1: ( ( rule__Scanner_Keyword__Group_3__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3943:1: ( rule__Scanner_Keyword__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getGroup_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3944:1: ( rule__Scanner_Keyword__Group_3__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==34) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3944:2: rule__Scanner_Keyword__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__0_in_rule__Scanner_Keyword__Group__3__Impl7943);
            	    rule__Scanner_Keyword__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3954:1: rule__Scanner_Keyword__Group__4 : rule__Scanner_Keyword__Group__4__Impl ;
    public final void rule__Scanner_Keyword__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3958:1: ( rule__Scanner_Keyword__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3959:2: rule__Scanner_Keyword__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__4__Impl_in_rule__Scanner_Keyword__Group__47974);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3965:1: rule__Scanner_Keyword__Group__4__Impl : ( ']' ) ;
    public final void rule__Scanner_Keyword__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3969:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3970:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3970:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3971:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,33,FOLLOW_33_in_rule__Scanner_Keyword__Group__4__Impl8002); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3994:1: rule__Scanner_Keyword__Group_3__0 : rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1 ;
    public final void rule__Scanner_Keyword__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3998:1: ( rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3999:2: rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__0__Impl_in_rule__Scanner_Keyword__Group_3__08043);
            rule__Scanner_Keyword__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__1_in_rule__Scanner_Keyword__Group_3__08046);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4006:1: rule__Scanner_Keyword__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Scanner_Keyword__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4010:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4011:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4011:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4012:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0()); 
            }
            match(input,34,FOLLOW_34_in_rule__Scanner_Keyword__Group_3__0__Impl8074); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4025:1: rule__Scanner_Keyword__Group_3__1 : rule__Scanner_Keyword__Group_3__1__Impl ;
    public final void rule__Scanner_Keyword__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4029:1: ( rule__Scanner_Keyword__Group_3__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4030:2: rule__Scanner_Keyword__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__1__Impl_in_rule__Scanner_Keyword__Group_3__18105);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4036:1: rule__Scanner_Keyword__Group_3__1__Impl : ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) ) ;
    public final void rule__Scanner_Keyword__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4040:1: ( ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4041:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4041:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4042:1: ( rule__Scanner_Keyword__KeywordsAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_3_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4043:1: ( rule__Scanner_Keyword__KeywordsAssignment_3_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4043:2: rule__Scanner_Keyword__KeywordsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_3_1_in_rule__Scanner_Keyword__Group_3__1__Impl8132);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4057:1: rule__Keyword__Group__0 : rule__Keyword__Group__0__Impl rule__Keyword__Group__1 ;
    public final void rule__Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4061:1: ( rule__Keyword__Group__0__Impl rule__Keyword__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4062:2: rule__Keyword__Group__0__Impl rule__Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__08166);
            rule__Keyword__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__08169);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4069:1: rule__Keyword__Group__0__Impl : ( ( rule__Keyword__NameAssignment_0 ) ) ;
    public final void rule__Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4073:1: ( ( ( rule__Keyword__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4074:1: ( ( rule__Keyword__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4074:1: ( ( rule__Keyword__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4075:1: ( rule__Keyword__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4076:1: ( rule__Keyword__NameAssignment_0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4076:2: rule__Keyword__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl8196);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4086:1: rule__Keyword__Group__1 : rule__Keyword__Group__1__Impl ;
    public final void rule__Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4090:1: ( rule__Keyword__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4091:2: rule__Keyword__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__18226);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4097:1: rule__Keyword__Group__1__Impl : ( ( rule__Keyword__Group_1__0 )? ) ;
    public final void rule__Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4101:1: ( ( ( rule__Keyword__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4102:1: ( ( rule__Keyword__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4102:1: ( ( rule__Keyword__Group_1__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4103:1: ( rule__Keyword__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getGroup_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4104:1: ( rule__Keyword__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==35) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4104:2: rule__Keyword__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl8253);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4118:1: rule__Keyword__Group_1__0 : rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 ;
    public final void rule__Keyword__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4122:1: ( rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4123:2: rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__08288);
            rule__Keyword__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__08291);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4130:1: rule__Keyword__Group_1__0__Impl : ( 'since' ) ;
    public final void rule__Keyword__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4134:1: ( ( 'since' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4135:1: ( 'since' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4135:1: ( 'since' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4136:1: 'since'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__Keyword__Group_1__0__Impl8319); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4149:1: rule__Keyword__Group_1__1 : rule__Keyword__Group_1__1__Impl ;
    public final void rule__Keyword__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4153:1: ( rule__Keyword__Group_1__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4154:2: rule__Keyword__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__18350);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4160:1: rule__Keyword__Group_1__1__Impl : ( ( rule__Keyword__VersionAssignment_1_1 ) ) ;
    public final void rule__Keyword__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4164:1: ( ( ( rule__Keyword__VersionAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4165:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4165:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4166:1: ( rule__Keyword__VersionAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4167:1: ( rule__Keyword__VersionAssignment_1_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4167:2: rule__Keyword__VersionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl8377);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4181:1: rule__Scanner_SingleLineRule__Group__0 : rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1 ;
    public final void rule__Scanner_SingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4185:1: ( rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4186:2: rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__0__Impl_in_rule__Scanner_SingleLineRule__Group__08411);
            rule__Scanner_SingleLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__1_in_rule__Scanner_SingleLineRule__Group__08414);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4193:1: rule__Scanner_SingleLineRule__Group__0__Impl : ( 'single_line' ) ;
    public final void rule__Scanner_SingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4197:1: ( ( 'single_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4198:1: ( 'single_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4198:1: ( 'single_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4199:1: 'single_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__Scanner_SingleLineRule__Group__0__Impl8442); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4212:1: rule__Scanner_SingleLineRule__Group__1 : rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2 ;
    public final void rule__Scanner_SingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4216:1: ( rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4217:2: rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__1__Impl_in_rule__Scanner_SingleLineRule__Group__18473);
            rule__Scanner_SingleLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__2_in_rule__Scanner_SingleLineRule__Group__18476);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4224:1: rule__Scanner_SingleLineRule__Group__1__Impl : ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4228:1: ( ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4229:1: ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4229:1: ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4230:1: ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4231:1: ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4231:2: rule__Scanner_SingleLineRule__StartSeqAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__StartSeqAssignment_1_in_rule__Scanner_SingleLineRule__Group__1__Impl8503);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4241:1: rule__Scanner_SingleLineRule__Group__2 : rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3 ;
    public final void rule__Scanner_SingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4245:1: ( rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4246:2: rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__2__Impl_in_rule__Scanner_SingleLineRule__Group__28533);
            rule__Scanner_SingleLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__3_in_rule__Scanner_SingleLineRule__Group__28536);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4253:1: rule__Scanner_SingleLineRule__Group__2__Impl : ( '=>' ) ;
    public final void rule__Scanner_SingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4257:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4258:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4258:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4259:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 
            }
            match(input,26,FOLLOW_26_in_rule__Scanner_SingleLineRule__Group__2__Impl8564); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4272:1: rule__Scanner_SingleLineRule__Group__3 : rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4 ;
    public final void rule__Scanner_SingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4276:1: ( rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4277:2: rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__3__Impl_in_rule__Scanner_SingleLineRule__Group__38595);
            rule__Scanner_SingleLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__4_in_rule__Scanner_SingleLineRule__Group__38598);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4284:1: rule__Scanner_SingleLineRule__Group__3__Impl : ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4288:1: ( ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4289:1: ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4289:1: ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4290:1: ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4291:1: ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_STRING) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4291:2: rule__Scanner_SingleLineRule__EndSeqAssignment_3
                    {
                    pushFollow(FOLLOW_rule__Scanner_SingleLineRule__EndSeqAssignment_3_in_rule__Scanner_SingleLineRule__Group__3__Impl8625);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4301:1: rule__Scanner_SingleLineRule__Group__4 : rule__Scanner_SingleLineRule__Group__4__Impl ;
    public final void rule__Scanner_SingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4305:1: ( rule__Scanner_SingleLineRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4306:2: rule__Scanner_SingleLineRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__4__Impl_in_rule__Scanner_SingleLineRule__Group__48656);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4312:1: rule__Scanner_SingleLineRule__Group__4__Impl : ( ( rule__Scanner_SingleLineRule__Group_4__0 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4316:1: ( ( ( rule__Scanner_SingleLineRule__Group_4__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4317:1: ( ( rule__Scanner_SingleLineRule__Group_4__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4317:1: ( ( rule__Scanner_SingleLineRule__Group_4__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4318:1: ( rule__Scanner_SingleLineRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4319:1: ( rule__Scanner_SingleLineRule__Group_4__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==27) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4319:2: rule__Scanner_SingleLineRule__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__0_in_rule__Scanner_SingleLineRule__Group__4__Impl8683);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4339:1: rule__Scanner_SingleLineRule__Group_4__0 : rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1 ;
    public final void rule__Scanner_SingleLineRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4343:1: ( rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4344:2: rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__0__Impl_in_rule__Scanner_SingleLineRule__Group_4__08724);
            rule__Scanner_SingleLineRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__1_in_rule__Scanner_SingleLineRule__Group_4__08727);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4351:1: rule__Scanner_SingleLineRule__Group_4__0__Impl : ( 'escaped' ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4355:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4356:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4356:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4357:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_4_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__Scanner_SingleLineRule__Group_4__0__Impl8755); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4370:1: rule__Scanner_SingleLineRule__Group_4__1 : rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2 ;
    public final void rule__Scanner_SingleLineRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4374:1: ( rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4375:2: rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__1__Impl_in_rule__Scanner_SingleLineRule__Group_4__18786);
            rule__Scanner_SingleLineRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__2_in_rule__Scanner_SingleLineRule__Group_4__18789);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4382:1: rule__Scanner_SingleLineRule__Group_4__1__Impl : ( 'by' ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4386:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4387:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4387:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4388:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_4_1()); 
            }
            match(input,28,FOLLOW_28_in_rule__Scanner_SingleLineRule__Group_4__1__Impl8817); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4401:1: rule__Scanner_SingleLineRule__Group_4__2 : rule__Scanner_SingleLineRule__Group_4__2__Impl ;
    public final void rule__Scanner_SingleLineRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4405:1: ( rule__Scanner_SingleLineRule__Group_4__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4406:2: rule__Scanner_SingleLineRule__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__2__Impl_in_rule__Scanner_SingleLineRule__Group_4__28848);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4412:1: rule__Scanner_SingleLineRule__Group_4__2__Impl : ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4416:1: ( ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4417:1: ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4417:1: ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4418:1: ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4419:1: ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4419:2: rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_SingleLineRule__Group_4__2__Impl8875);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4435:1: rule__Scanner_MultiLineRule__Group__0 : rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1 ;
    public final void rule__Scanner_MultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4439:1: ( rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4440:2: rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__0__Impl_in_rule__Scanner_MultiLineRule__Group__08911);
            rule__Scanner_MultiLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__1_in_rule__Scanner_MultiLineRule__Group__08914);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4447:1: rule__Scanner_MultiLineRule__Group__0__Impl : ( 'multi_line' ) ;
    public final void rule__Scanner_MultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4451:1: ( ( 'multi_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4452:1: ( 'multi_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4452:1: ( 'multi_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4453:1: 'multi_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            }
            match(input,29,FOLLOW_29_in_rule__Scanner_MultiLineRule__Group__0__Impl8942); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4466:1: rule__Scanner_MultiLineRule__Group__1 : rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2 ;
    public final void rule__Scanner_MultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4470:1: ( rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4471:2: rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__1__Impl_in_rule__Scanner_MultiLineRule__Group__18973);
            rule__Scanner_MultiLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__2_in_rule__Scanner_MultiLineRule__Group__18976);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4478:1: rule__Scanner_MultiLineRule__Group__1__Impl : ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4482:1: ( ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4483:1: ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4483:1: ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4484:1: ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4485:1: ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4485:2: rule__Scanner_MultiLineRule__StartSeqAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__StartSeqAssignment_1_in_rule__Scanner_MultiLineRule__Group__1__Impl9003);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4495:1: rule__Scanner_MultiLineRule__Group__2 : rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3 ;
    public final void rule__Scanner_MultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4499:1: ( rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4500:2: rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__2__Impl_in_rule__Scanner_MultiLineRule__Group__29033);
            rule__Scanner_MultiLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__3_in_rule__Scanner_MultiLineRule__Group__29036);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4507:1: rule__Scanner_MultiLineRule__Group__2__Impl : ( '=>' ) ;
    public final void rule__Scanner_MultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4511:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4512:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4512:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4513:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 
            }
            match(input,26,FOLLOW_26_in_rule__Scanner_MultiLineRule__Group__2__Impl9064); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4526:1: rule__Scanner_MultiLineRule__Group__3 : rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4 ;
    public final void rule__Scanner_MultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4530:1: ( rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4531:2: rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__3__Impl_in_rule__Scanner_MultiLineRule__Group__39095);
            rule__Scanner_MultiLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__4_in_rule__Scanner_MultiLineRule__Group__39098);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4538:1: rule__Scanner_MultiLineRule__Group__3__Impl : ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4542:1: ( ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4543:1: ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4543:1: ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4544:1: ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqAssignment_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4545:1: ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4545:2: rule__Scanner_MultiLineRule__EndSeqAssignment_3
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__EndSeqAssignment_3_in_rule__Scanner_MultiLineRule__Group__3__Impl9125);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4555:1: rule__Scanner_MultiLineRule__Group__4 : rule__Scanner_MultiLineRule__Group__4__Impl ;
    public final void rule__Scanner_MultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4559:1: ( rule__Scanner_MultiLineRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4560:2: rule__Scanner_MultiLineRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__4__Impl_in_rule__Scanner_MultiLineRule__Group__49155);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4566:1: rule__Scanner_MultiLineRule__Group__4__Impl : ( ( rule__Scanner_MultiLineRule__Group_4__0 )? ) ;
    public final void rule__Scanner_MultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4570:1: ( ( ( rule__Scanner_MultiLineRule__Group_4__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4571:1: ( ( rule__Scanner_MultiLineRule__Group_4__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4571:1: ( ( rule__Scanner_MultiLineRule__Group_4__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4572:1: ( rule__Scanner_MultiLineRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup_4()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4573:1: ( rule__Scanner_MultiLineRule__Group_4__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==27) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4573:2: rule__Scanner_MultiLineRule__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__0_in_rule__Scanner_MultiLineRule__Group__4__Impl9182);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4593:1: rule__Scanner_MultiLineRule__Group_4__0 : rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1 ;
    public final void rule__Scanner_MultiLineRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4597:1: ( rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4598:2: rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__0__Impl_in_rule__Scanner_MultiLineRule__Group_4__09223);
            rule__Scanner_MultiLineRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__1_in_rule__Scanner_MultiLineRule__Group_4__09226);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4605:1: rule__Scanner_MultiLineRule__Group_4__0__Impl : ( 'escaped' ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4609:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4610:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4610:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4611:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_4_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__Scanner_MultiLineRule__Group_4__0__Impl9254); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4624:1: rule__Scanner_MultiLineRule__Group_4__1 : rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2 ;
    public final void rule__Scanner_MultiLineRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4628:1: ( rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4629:2: rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__1__Impl_in_rule__Scanner_MultiLineRule__Group_4__19285);
            rule__Scanner_MultiLineRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__2_in_rule__Scanner_MultiLineRule__Group_4__19288);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4636:1: rule__Scanner_MultiLineRule__Group_4__1__Impl : ( 'by' ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4640:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4641:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4641:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4642:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_4_1()); 
            }
            match(input,28,FOLLOW_28_in_rule__Scanner_MultiLineRule__Group_4__1__Impl9316); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4655:1: rule__Scanner_MultiLineRule__Group_4__2 : rule__Scanner_MultiLineRule__Group_4__2__Impl ;
    public final void rule__Scanner_MultiLineRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4659:1: ( rule__Scanner_MultiLineRule__Group_4__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4660:2: rule__Scanner_MultiLineRule__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__2__Impl_in_rule__Scanner_MultiLineRule__Group_4__29347);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4666:1: rule__Scanner_MultiLineRule__Group_4__2__Impl : ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4670:1: ( ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4671:1: ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4671:1: ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4672:1: ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4673:1: ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4673:2: rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_MultiLineRule__Group_4__2__Impl9374);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4689:1: rule__Scanner_CharacterRule__Group__0 : rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1 ;
    public final void rule__Scanner_CharacterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4693:1: ( rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4694:2: rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__0__Impl_in_rule__Scanner_CharacterRule__Group__09410);
            rule__Scanner_CharacterRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__1_in_rule__Scanner_CharacterRule__Group__09413);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4701:1: rule__Scanner_CharacterRule__Group__0__Impl : ( 'character' ) ;
    public final void rule__Scanner_CharacterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4705:1: ( ( 'character' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4706:1: ( 'character' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4706:1: ( 'character' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4707:1: 'character'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__Scanner_CharacterRule__Group__0__Impl9441); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4720:1: rule__Scanner_CharacterRule__Group__1 : rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2 ;
    public final void rule__Scanner_CharacterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4724:1: ( rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4725:2: rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__1__Impl_in_rule__Scanner_CharacterRule__Group__19472);
            rule__Scanner_CharacterRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__2_in_rule__Scanner_CharacterRule__Group__19475);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4732:1: rule__Scanner_CharacterRule__Group__1__Impl : ( '[' ) ;
    public final void rule__Scanner_CharacterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4736:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4737:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4737:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4738:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,32,FOLLOW_32_in_rule__Scanner_CharacterRule__Group__1__Impl9503); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4751:1: rule__Scanner_CharacterRule__Group__2 : rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3 ;
    public final void rule__Scanner_CharacterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4755:1: ( rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4756:2: rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__2__Impl_in_rule__Scanner_CharacterRule__Group__29534);
            rule__Scanner_CharacterRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__3_in_rule__Scanner_CharacterRule__Group__29537);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4763:1: rule__Scanner_CharacterRule__Group__2__Impl : ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) ) ;
    public final void rule__Scanner_CharacterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4767:1: ( ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4768:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4768:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4769:1: ( rule__Scanner_CharacterRule__CharactersAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4770:1: ( rule__Scanner_CharacterRule__CharactersAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4770:2: rule__Scanner_CharacterRule__CharactersAssignment_2
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_2_in_rule__Scanner_CharacterRule__Group__2__Impl9564);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4780:1: rule__Scanner_CharacterRule__Group__3 : rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4 ;
    public final void rule__Scanner_CharacterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4784:1: ( rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4785:2: rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__3__Impl_in_rule__Scanner_CharacterRule__Group__39594);
            rule__Scanner_CharacterRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__4_in_rule__Scanner_CharacterRule__Group__39597);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4792:1: rule__Scanner_CharacterRule__Group__3__Impl : ( ( rule__Scanner_CharacterRule__Group_3__0 )* ) ;
    public final void rule__Scanner_CharacterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4796:1: ( ( ( rule__Scanner_CharacterRule__Group_3__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4797:1: ( ( rule__Scanner_CharacterRule__Group_3__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4797:1: ( ( rule__Scanner_CharacterRule__Group_3__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4798:1: ( rule__Scanner_CharacterRule__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getGroup_3()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4799:1: ( rule__Scanner_CharacterRule__Group_3__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==34) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4799:2: rule__Scanner_CharacterRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__0_in_rule__Scanner_CharacterRule__Group__3__Impl9624);
            	    rule__Scanner_CharacterRule__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4809:1: rule__Scanner_CharacterRule__Group__4 : rule__Scanner_CharacterRule__Group__4__Impl ;
    public final void rule__Scanner_CharacterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4813:1: ( rule__Scanner_CharacterRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4814:2: rule__Scanner_CharacterRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__4__Impl_in_rule__Scanner_CharacterRule__Group__49655);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4820:1: rule__Scanner_CharacterRule__Group__4__Impl : ( ']' ) ;
    public final void rule__Scanner_CharacterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4824:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4825:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4825:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4826:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,33,FOLLOW_33_in_rule__Scanner_CharacterRule__Group__4__Impl9683); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4849:1: rule__Scanner_CharacterRule__Group_3__0 : rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1 ;
    public final void rule__Scanner_CharacterRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4853:1: ( rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4854:2: rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__0__Impl_in_rule__Scanner_CharacterRule__Group_3__09724);
            rule__Scanner_CharacterRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__1_in_rule__Scanner_CharacterRule__Group_3__09727);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4861:1: rule__Scanner_CharacterRule__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Scanner_CharacterRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4865:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4866:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4866:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4867:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0()); 
            }
            match(input,34,FOLLOW_34_in_rule__Scanner_CharacterRule__Group_3__0__Impl9755); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4880:1: rule__Scanner_CharacterRule__Group_3__1 : rule__Scanner_CharacterRule__Group_3__1__Impl ;
    public final void rule__Scanner_CharacterRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4884:1: ( rule__Scanner_CharacterRule__Group_3__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4885:2: rule__Scanner_CharacterRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__1__Impl_in_rule__Scanner_CharacterRule__Group_3__19786);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4891:1: rule__Scanner_CharacterRule__Group_3__1__Impl : ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) ) ;
    public final void rule__Scanner_CharacterRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4895:1: ( ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4896:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4896:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4897:1: ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_3_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4898:1: ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4898:2: rule__Scanner_CharacterRule__CharactersAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_3_1_in_rule__Scanner_CharacterRule__Group_3__1__Impl9813);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4912:1: rule__Scanner_JSRule__Group__0 : rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1 ;
    public final void rule__Scanner_JSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4916:1: ( rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4917:2: rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__0__Impl_in_rule__Scanner_JSRule__Group__09847);
            rule__Scanner_JSRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__1_in_rule__Scanner_JSRule__Group__09850);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4924:1: rule__Scanner_JSRule__Group__0__Impl : ( 'script' ) ;
    public final void rule__Scanner_JSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4928:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4929:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4929:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4930:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__Scanner_JSRule__Group__0__Impl9878); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4943:1: rule__Scanner_JSRule__Group__1 : rule__Scanner_JSRule__Group__1__Impl ;
    public final void rule__Scanner_JSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4947:1: ( rule__Scanner_JSRule__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4948:2: rule__Scanner_JSRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__1__Impl_in_rule__Scanner_JSRule__Group__19909);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4954:1: rule__Scanner_JSRule__Group__1__Impl : ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) ) ;
    public final void rule__Scanner_JSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4958:1: ( ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4959:1: ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4959:1: ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4960:1: ( rule__Scanner_JSRule__FileURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getFileURIAssignment_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4961:1: ( rule__Scanner_JSRule__FileURIAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4961:2: rule__Scanner_JSRule__FileURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__FileURIAssignment_1_in_rule__Scanner_JSRule__Group__1__Impl9936);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4975:1: rule__WhitespaceRule__Group__0 : rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1 ;
    public final void rule__WhitespaceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4979:1: ( rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4980:2: rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__0__Impl_in_rule__WhitespaceRule__Group__09970);
            rule__WhitespaceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__1_in_rule__WhitespaceRule__Group__09973);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4987:1: rule__WhitespaceRule__Group__0__Impl : ( 'whitespace' ) ;
    public final void rule__WhitespaceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4991:1: ( ( 'whitespace' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4992:1: ( 'whitespace' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4992:1: ( 'whitespace' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4993:1: 'whitespace'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getWhitespaceKeyword_0()); 
            }
            match(input,37,FOLLOW_37_in_rule__WhitespaceRule__Group__0__Impl10001); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5006:1: rule__WhitespaceRule__Group__1 : rule__WhitespaceRule__Group__1__Impl ;
    public final void rule__WhitespaceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5010:1: ( rule__WhitespaceRule__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5011:2: rule__WhitespaceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group__1__Impl_in_rule__WhitespaceRule__Group__110032);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5017:1: rule__WhitespaceRule__Group__1__Impl : ( ( rule__WhitespaceRule__Alternatives_1 ) ) ;
    public final void rule__WhitespaceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5021:1: ( ( ( rule__WhitespaceRule__Alternatives_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5022:1: ( ( rule__WhitespaceRule__Alternatives_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5022:1: ( ( rule__WhitespaceRule__Alternatives_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5023:1: ( rule__WhitespaceRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5024:1: ( rule__WhitespaceRule__Alternatives_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5024:2: rule__WhitespaceRule__Alternatives_1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Alternatives_1_in_rule__WhitespaceRule__Group__1__Impl10059);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5038:1: rule__WhitespaceRule__Group_1_0__0 : rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1 ;
    public final void rule__WhitespaceRule__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5042:1: ( rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5043:2: rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__0__Impl_in_rule__WhitespaceRule__Group_1_0__010093);
            rule__WhitespaceRule__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__1_in_rule__WhitespaceRule__Group_1_0__010096);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5050:1: rule__WhitespaceRule__Group_1_0__0__Impl : ( '[' ) ;
    public final void rule__WhitespaceRule__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5054:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5055:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5055:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5056:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__WhitespaceRule__Group_1_0__0__Impl10124); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5069:1: rule__WhitespaceRule__Group_1_0__1 : rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2 ;
    public final void rule__WhitespaceRule__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5073:1: ( rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5074:2: rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__1__Impl_in_rule__WhitespaceRule__Group_1_0__110155);
            rule__WhitespaceRule__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__2_in_rule__WhitespaceRule__Group_1_0__110158);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5081:1: rule__WhitespaceRule__Group_1_0__1__Impl : ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) ) ;
    public final void rule__WhitespaceRule__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5085:1: ( ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5086:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5086:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5087:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersAssignment_1_0_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5088:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5088:2: rule__WhitespaceRule__CharactersAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_1_in_rule__WhitespaceRule__Group_1_0__1__Impl10185);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5098:1: rule__WhitespaceRule__Group_1_0__2 : rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3 ;
    public final void rule__WhitespaceRule__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5102:1: ( rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5103:2: rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__2__Impl_in_rule__WhitespaceRule__Group_1_0__210215);
            rule__WhitespaceRule__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__3_in_rule__WhitespaceRule__Group_1_0__210218);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5110:1: rule__WhitespaceRule__Group_1_0__2__Impl : ( ( rule__WhitespaceRule__Group_1_0_2__0 )* ) ;
    public final void rule__WhitespaceRule__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5114:1: ( ( ( rule__WhitespaceRule__Group_1_0_2__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5115:1: ( ( rule__WhitespaceRule__Group_1_0_2__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5115:1: ( ( rule__WhitespaceRule__Group_1_0_2__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5116:1: ( rule__WhitespaceRule__Group_1_0_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getGroup_1_0_2()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5117:1: ( rule__WhitespaceRule__Group_1_0_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==34) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5117:2: rule__WhitespaceRule__Group_1_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__0_in_rule__WhitespaceRule__Group_1_0__2__Impl10245);
            	    rule__WhitespaceRule__Group_1_0_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5127:1: rule__WhitespaceRule__Group_1_0__3 : rule__WhitespaceRule__Group_1_0__3__Impl ;
    public final void rule__WhitespaceRule__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5131:1: ( rule__WhitespaceRule__Group_1_0__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5132:2: rule__WhitespaceRule__Group_1_0__3__Impl
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0__3__Impl_in_rule__WhitespaceRule__Group_1_0__310276);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5138:1: rule__WhitespaceRule__Group_1_0__3__Impl : ( ']' ) ;
    public final void rule__WhitespaceRule__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5142:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5143:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5143:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5144:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3()); 
            }
            match(input,33,FOLLOW_33_in_rule__WhitespaceRule__Group_1_0__3__Impl10304); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5165:1: rule__WhitespaceRule__Group_1_0_2__0 : rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1 ;
    public final void rule__WhitespaceRule__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5169:1: ( rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5170:2: rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__0__Impl_in_rule__WhitespaceRule__Group_1_0_2__010343);
            rule__WhitespaceRule__Group_1_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__1_in_rule__WhitespaceRule__Group_1_0_2__010346);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5177:1: rule__WhitespaceRule__Group_1_0_2__0__Impl : ( ',' ) ;
    public final void rule__WhitespaceRule__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5181:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5182:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5182:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5183:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCommaKeyword_1_0_2_0()); 
            }
            match(input,34,FOLLOW_34_in_rule__WhitespaceRule__Group_1_0_2__0__Impl10374); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5196:1: rule__WhitespaceRule__Group_1_0_2__1 : rule__WhitespaceRule__Group_1_0_2__1__Impl ;
    public final void rule__WhitespaceRule__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5200:1: ( rule__WhitespaceRule__Group_1_0_2__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5201:2: rule__WhitespaceRule__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__Group_1_0_2__1__Impl_in_rule__WhitespaceRule__Group_1_0_2__110405);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5207:1: rule__WhitespaceRule__Group_1_0_2__1__Impl : ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) ) ;
    public final void rule__WhitespaceRule__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5211:1: ( ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5212:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5212:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5213:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersAssignment_1_0_2_1()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5214:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5214:2: rule__WhitespaceRule__CharactersAssignment_1_0_2_1
            {
            pushFollow(FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_2_1_in_rule__WhitespaceRule__Group_1_0_2__1__Impl10432);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5229:1: rule__Root__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Root__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5233:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5234:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5234:1: ( ruleQualifiedName )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5235:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Root__NameAssignment_110471);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5244:1: rule__Root__ImportsAssignment_2 : ( ruleImport ) ;
    public final void rule__Root__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5248:1: ( ( ruleImport ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5249:1: ( ruleImport )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5249:1: ( ruleImport )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5250:1: ruleImport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getImportsImportParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleImport_in_rule__Root__ImportsAssignment_210502);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5259:1: rule__Root__LanguageDefinitionAssignment_3 : ( ruleLanguageDef ) ;
    public final void rule__Root__LanguageDefinitionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5263:1: ( ( ruleLanguageDef ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5264:1: ( ruleLanguageDef )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5264:1: ( ruleLanguageDef )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5265:1: ruleLanguageDef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLanguageDefinitionLanguageDefParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleLanguageDef_in_rule__Root__LanguageDefinitionAssignment_310533);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5274:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildCard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5278:1: ( ( ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5279:1: ( ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5279:1: ( ruleQualifiedNameWithWildCard )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5280:1: ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_110564);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5289:1: rule__LanguageDef__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__LanguageDef__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5293:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5294:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5294:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5295:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LanguageDef__NameAssignment_010595); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5304:1: rule__LanguageDef__ParitioningAssignment_2 : ( ruleParitioning ) ;
    public final void rule__LanguageDef__ParitioningAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5308:1: ( ( ruleParitioning ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5309:1: ( ruleParitioning )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5309:1: ( ruleParitioning )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5310:1: ruleParitioning
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getParitioningParitioningParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleParitioning_in_rule__LanguageDef__ParitioningAssignment_210626);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5319:1: rule__LanguageDef__LexicalHighlightingAssignment_3 : ( ruleLexicalHighlighting ) ;
    public final void rule__LanguageDef__LexicalHighlightingAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5323:1: ( ( ruleLexicalHighlighting ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5324:1: ( ruleLexicalHighlighting )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5324:1: ( ruleLexicalHighlighting )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5325:1: ruleLexicalHighlighting
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLexicalHighlightingLexicalHighlightingParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_rule__LanguageDef__LexicalHighlightingAssignment_310657);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5334:1: rule__LanguageDef__IntegrationAssignment_4 : ( ruleIntegration ) ;
    public final void rule__LanguageDef__IntegrationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5338:1: ( ( ruleIntegration ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5339:1: ( ruleIntegration )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5339:1: ( ruleIntegration )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5340:1: ruleIntegration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getIntegrationIntegrationParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleIntegration_in_rule__LanguageDef__IntegrationAssignment_410688);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5349:1: rule__Integration__CodeIntegrationListAssignment_2 : ( ruleCodeIntegration ) ;
    public final void rule__Integration__CodeIntegrationListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5353:1: ( ( ruleCodeIntegration ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5354:1: ( ruleCodeIntegration )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5354:1: ( ruleCodeIntegration )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5355:1: ruleCodeIntegration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListCodeIntegrationParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleCodeIntegration_in_rule__Integration__CodeIntegrationListAssignment_210719);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5364:1: rule__JavaFXIntegration__CodegenerationListAssignment_2 : ( ruleCodegeneration ) ;
    public final void rule__JavaFXIntegration__CodegenerationListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5368:1: ( ( ruleCodegeneration ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5369:1: ( ruleCodegeneration )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5369:1: ( ruleCodegeneration )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5370:1: ruleCodegeneration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListCodegenerationParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleCodegeneration_in_rule__JavaFXIntegration__CodegenerationListAssignment_210750);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5379:1: rule__JavaCodeGeneration__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JavaCodeGeneration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5383:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5384:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5384:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5385:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JavaCodeGeneration__NameAssignment_110781); if (state.failed) return ;
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


    // $ANTLR start "rule__E4CodeGeneration__IconPathAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5394:1: rule__E4CodeGeneration__IconPathAssignment_1 : ( RULE_STRING ) ;
    public final void rule__E4CodeGeneration__IconPathAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5398:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5399:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5399:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5400:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getIconPathSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__E4CodeGeneration__IconPathAssignment_110812); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getIconPathSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__E4CodeGeneration__IconPathAssignment_1"


    // $ANTLR start "rule__Paritioning__PartitionsAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5409:1: rule__Paritioning__PartitionsAssignment_2 : ( rulePartition ) ;
    public final void rule__Paritioning__PartitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5413:1: ( ( rulePartition ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5414:1: ( rulePartition )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5414:1: ( rulePartition )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5415:1: rulePartition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_rulePartition_in_rule__Paritioning__PartitionsAssignment_210843);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5424:1: rule__Paritioning__PartitionerAssignment_3 : ( rulePartitioner ) ;
    public final void rule__Paritioning__PartitionerAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5428:1: ( ( rulePartitioner ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5429:1: ( rulePartitioner )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5429:1: ( rulePartitioner )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5430:1: rulePartitioner
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_rulePartitioner_in_rule__Paritioning__PartitionerAssignment_310874);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5439:1: rule__Partition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Partition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5443:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5444:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5444:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5445:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_110905); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5454:1: rule__Paritioner_JS__ScriptURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Paritioner_JS__ScriptURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5458:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5459:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5459:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5460:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptURISTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Paritioner_JS__ScriptURIAssignment_110936); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5469:1: rule__Partitioner_Rule__RuleListAssignment_2 : ( rulePartition_Rule ) ;
    public final void rule__Partitioner_Rule__RuleListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5473:1: ( ( rulePartition_Rule ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5474:1: ( rulePartition_Rule )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5474:1: ( rulePartition_Rule )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5475:1: rulePartition_Rule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_rulePartition_Rule_in_rule__Partitioner_Rule__RuleListAssignment_210967);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5484:1: rule__Partition_SingleLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Partition_SingleLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5488:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5489:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5489:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5490:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5491:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5492:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition_SingleLineRule__ParitionAssignment_111002); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5503:1: rule__Partition_SingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5507:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5508:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5508:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5509:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__StartSeqAssignment_211037); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5518:1: rule__Partition_SingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5522:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5523:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5523:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5524:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EndSeqAssignment_411068); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5533:1: rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5537:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5538:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5538:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5539:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_211099); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5548:1: rule__Partition_MultiLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Partition_MultiLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5552:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5553:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5553:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5554:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5555:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5556:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition_MultiLineRule__ParitionAssignment_111134); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5567:1: rule__Partition_MultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5571:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5572:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5572:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5573:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__StartSeqAssignment_211169); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5582:1: rule__Partition_MultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5586:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5587:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5587:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5588:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EndSeqAssignment_411200); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5597:1: rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5601:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5602:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5602:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5603:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_211231); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5612:1: rule__LexicalHighlighting__ListAssignment_2 : ( ruleLexicalPartitionHighlighting ) ;
    public final void rule__LexicalHighlighting__ListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5616:1: ( ( ruleLexicalPartitionHighlighting ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5617:1: ( ruleLexicalPartitionHighlighting )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5617:1: ( ruleLexicalPartitionHighlighting )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5618:1: ruleLexicalPartitionHighlighting
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_rule__LexicalHighlighting__ListAssignment_211262);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5627:1: rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5631:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5632:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5632:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5633:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5634:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5635:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_111297); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5646:1: rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5650:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5651:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5651:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5652:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURISTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_211332); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5661:1: rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5665:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5666:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5666:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5667:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5668:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5669:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_111367); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5680:1: rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 : ( ruleWhitespaceRule ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5684:1: ( ( ruleWhitespaceRule ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5685:1: ( ruleWhitespaceRule )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5685:1: ( ruleWhitespaceRule )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5686:1: ruleWhitespaceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceWhitespaceRuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleWhitespaceRule_in_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_211402);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5695:1: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 : ( ruleToken ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5699:1: ( ( ruleToken ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5700:1: ( ruleToken )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5700:1: ( ruleToken )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5701:1: ruleToken
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleToken_in_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_411433);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5710:1: rule__Token__DefaultAssignment_0 : ( ( 'default' ) ) ;
    public final void rule__Token__DefaultAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5714:1: ( ( ( 'default' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5715:1: ( ( 'default' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5715:1: ( ( 'default' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5716:1: ( 'default' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5717:1: ( 'default' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5718:1: 'default'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            }
            match(input,38,FOLLOW_38_in_rule__Token__DefaultAssignment_011469); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5733:1: rule__Token__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Token__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5737:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5738:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5738:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5739:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Token__NameAssignment_111508); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5748:1: rule__Token__ScannerListAssignment_2_1 : ( ruleScanner ) ;
    public final void rule__Token__ScannerListAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5752:1: ( ( ruleScanner ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5753:1: ( ruleScanner )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5753:1: ( ruleScanner )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5754:1: ruleScanner
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleScanner_in_rule__Token__ScannerListAssignment_2_111539);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5763:1: rule__Scanner_Keyword__KeywordsAssignment_2 : ( ruleKeyword ) ;
    public final void rule__Scanner_Keyword__KeywordsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5767:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5768:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5768:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5769:1: ruleKeyword
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_211570);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5778:1: rule__Scanner_Keyword__KeywordsAssignment_3_1 : ( ruleKeyword ) ;
    public final void rule__Scanner_Keyword__KeywordsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5782:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5783:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5783:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5784:1: ruleKeyword
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_3_111601);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5793:1: rule__Keyword__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Keyword__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5797:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5798:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5798:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5799:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_011632); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5808:1: rule__Keyword__VersionAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Keyword__VersionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5812:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5813:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5813:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5814:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_111663); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5823:1: rule__Scanner_SingleLineRule__StartSeqAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__StartSeqAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5827:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5828:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5828:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5829:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__StartSeqAssignment_111694); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5838:1: rule__Scanner_SingleLineRule__EndSeqAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__EndSeqAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5842:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5843:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5843:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5844:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EndSeqAssignment_311725); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5853:1: rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5857:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5858:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5858:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5859:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_211756); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5868:1: rule__Scanner_MultiLineRule__StartSeqAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__StartSeqAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5872:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5873:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5873:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5874:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__StartSeqAssignment_111787); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5883:1: rule__Scanner_MultiLineRule__EndSeqAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__EndSeqAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5887:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5888:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5888:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5889:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EndSeqAssignment_311818); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5898:1: rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5902:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5903:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5903:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5904:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_211849); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5913:1: rule__Scanner_CharacterRule__CharactersAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_CharacterRule__CharactersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5917:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5918:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5918:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5919:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_211880); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5928:1: rule__Scanner_CharacterRule__CharactersAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_CharacterRule__CharactersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5932:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5933:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5933:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5934:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_3_111911); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5943:1: rule__Scanner_JSRule__FileURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_JSRule__FileURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5947:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5948:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5948:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5949:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_JSRule__FileURIAssignment_111942); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5958:1: rule__WhitespaceRule__CharactersAssignment_1_0_1 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__CharactersAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5962:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5963:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5963:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5964:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_111973); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5973:1: rule__WhitespaceRule__CharactersAssignment_1_0_2_1 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__CharactersAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5977:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5978:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5978:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5979:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_2_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_2_112004); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5988:1: rule__WhitespaceRule__JavawhitespaceAssignment_1_1 : ( ( 'javawhitespace' ) ) ;
    public final void rule__WhitespaceRule__JavawhitespaceAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5992:1: ( ( ( 'javawhitespace' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5993:1: ( ( 'javawhitespace' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5993:1: ( ( 'javawhitespace' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5994:1: ( 'javawhitespace' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            }
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5995:1: ( 'javawhitespace' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:5996:1: 'javawhitespace'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            }
            match(input,39,FOLLOW_39_in_rule__WhitespaceRule__JavawhitespaceAssignment_1_112040); if (state.failed) return ;
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6011:1: rule__WhitespaceRule__FileURIAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__FileURIAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6015:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6016:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6016:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:6017:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__WhitespaceRule__FileURIAssignment_1_212079); if (state.failed) return ;
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
    public static final BitSet FOLLOW_ruleParitioning_in_entryRuleParitioning785 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioning792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__0_in_ruleParitioning818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_entryRulePartition845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__0_in_rulePartition878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_entryRulePartitioner905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner__Alternatives_in_rulePartitioner938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioner_JS972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__0_in_ruleParitioner_JS998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule1025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner_Rule1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__0_in_rulePartitioner_Rule1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule1085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_Rule1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_Rule__Alternatives_in_rulePartition_Rule1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule1145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_SingleLineRule1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__0_in_rulePartition_SingleLineRule1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule1205 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_MultiLineRule1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__0_in_rulePartition_MultiLineRule1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting1265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalHighlighting1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__0_in_ruleLexicalHighlighting1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting1325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting__Alternatives_in_ruleLexicalPartitionHighlighting1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS1385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0_in_ruleLexicalPartitionHighlighting_JS1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule1445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0_in_ruleLexicalPartitionHighlighting_Rule1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_entryRuleToken1505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleToken1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__0_in_ruleToken1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_entryRuleScanner1565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__Alternatives_in_ruleScanner1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword1625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Keyword1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__0_in_ruleScanner_Keyword1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword1685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0_in_ruleKeyword1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule1745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Rule1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Rule__Alternatives_in_ruleScanner_Rule1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule1805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_SingleLineRule1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__0_in_ruleScanner_SingleLineRule1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule1865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_MultiLineRule1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__0_in_ruleScanner_MultiLineRule1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule1925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_CharacterRule1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__0_in_ruleScanner_CharacterRule1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule1985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_JSRule1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__0_in_ruleScanner_JSRule2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule2045 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhitespaceRule2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__0_in_ruleWhitespaceRule2078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaCodeGeneration_in_rule__Codegeneration__Alternatives2114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleE4CodeGeneration_in_rule__Codegeneration__Alternatives2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_rule__Partitioner__Alternatives2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_rule__Partitioner__Alternatives2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_rule__Partition_Rule__Alternatives2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_rule__Partition_Rule__Alternatives2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_rule__LexicalPartitionHighlighting__Alternatives2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_rule__LexicalPartitionHighlighting__Alternatives2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_rule__Scanner__Alternatives2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_rule__Scanner__Alternatives2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_rule__Scanner_Rule__Alternatives2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_rule__Scanner_Rule__Alternatives2376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_rule__Scanner_Rule__Alternatives2393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_rule__Scanner_Rule__Alternatives2410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__0_in_rule__WhitespaceRule__Alternatives_12442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__JavawhitespaceAssignment_1_1_in_rule__WhitespaceRule__Alternatives_12460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__FileURIAssignment_1_2_in_rule__WhitespaceRule__Alternatives_12478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__Group__0__Impl_in_rule__Root__Group__02509 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Root__Group__1_in_rule__Root__Group__02512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Root__Group__0__Impl2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__Group__1__Impl_in_rule__Root__Group__12571 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Root__Group__2_in_rule__Root__Group__12574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__NameAssignment_1_in_rule__Root__Group__1__Impl2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__Group__2__Impl_in_rule__Root__Group__22631 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Root__Group__3_in_rule__Root__Group__22634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__ImportsAssignment_2_in_rule__Root__Group__2__Impl2661 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Root__Group__3__Impl_in_rule__Root__Group__32692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Root__LanguageDefinitionAssignment_3_in_rule__Root__Group__3__Impl2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02757 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2843 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02878 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QualifiedName__Group_1__0__Impl2910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__0__Impl_in_rule__QualifiedNameWithWildCard__Group__03002 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__03005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__0__Impl3032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1__Impl_in_rule__QualifiedNameWithWildCard__Group__13061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0_in_rule__QualifiedNameWithWildCard__Group__1__Impl3088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__0__Impl_in_rule__QualifiedNameWithWildCard__Group_1__03123 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1_in_rule__QualifiedNameWithWildCard__Group_1__03126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QualifiedNameWithWildCard__Group_1__0__Impl3154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group_1__1__Impl_in_rule__QualifiedNameWithWildCard__Group_1__13185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__QualifiedNameWithWildCard__Group_1__1__Impl3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03248 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Import__Group__0__Impl3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__0__Impl_in_rule__LanguageDef__Group__03371 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__1_in_rule__LanguageDef__Group__03374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__NameAssignment_0_in_rule__LanguageDef__Group__0__Impl3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__1__Impl_in_rule__LanguageDef__Group__13431 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__2_in_rule__LanguageDef__Group__13434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LanguageDef__Group__1__Impl3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__2__Impl_in_rule__LanguageDef__Group__23493 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__3_in_rule__LanguageDef__Group__23496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__ParitioningAssignment_2_in_rule__LanguageDef__Group__2__Impl3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__3__Impl_in_rule__LanguageDef__Group__33553 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__4_in_rule__LanguageDef__Group__33556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__LexicalHighlightingAssignment_3_in_rule__LanguageDef__Group__3__Impl3583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__4__Impl_in_rule__LanguageDef__Group__43613 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__5_in_rule__LanguageDef__Group__43616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__IntegrationAssignment_4_in_rule__LanguageDef__Group__4__Impl3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageDef__Group__5__Impl_in_rule__LanguageDef__Group__53674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LanguageDef__Group__5__Impl3702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__Group__0__Impl_in_rule__Integration__Group__03745 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Integration__Group__1_in_rule__Integration__Group__03748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Integration__Group__0__Impl3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__Group__1__Impl_in_rule__Integration__Group__13807 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Integration__Group__2_in_rule__Integration__Group__13810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Integration__Group__1__Impl3838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__Group__2__Impl_in_rule__Integration__Group__23869 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Integration__Group__3_in_rule__Integration__Group__23872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl3901 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Integration__CodeIntegrationListAssignment_2_in_rule__Integration__Group__2__Impl3913 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Integration__Group__3__Impl_in_rule__Integration__Group__33946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Integration__Group__3__Impl3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__0__Impl_in_rule__JavaFXIntegration__Group__04013 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__1_in_rule__JavaFXIntegration__Group__04016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__JavaFXIntegration__Group__0__Impl4044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__1__Impl_in_rule__JavaFXIntegration__Group__14075 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__2_in_rule__JavaFXIntegration__Group__14078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JavaFXIntegration__Group__1__Impl4106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__2__Impl_in_rule__JavaFXIntegration__Group__24137 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__3_in_rule__JavaFXIntegration__Group__24140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__CodegenerationListAssignment_2_in_rule__JavaFXIntegration__Group__2__Impl4169 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__CodegenerationListAssignment_2_in_rule__JavaFXIntegration__Group__2__Impl4181 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__JavaFXIntegration__Group__3__Impl_in_rule__JavaFXIntegration__Group__34214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JavaFXIntegration__Group__3__Impl4242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group__0__Impl_in_rule__JavaCodeGeneration__Group__04281 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group__1_in_rule__JavaCodeGeneration__Group__04284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__JavaCodeGeneration__Group__0__Impl4312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__Group__1__Impl_in_rule__JavaCodeGeneration__Group__14343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaCodeGeneration__NameAssignment_1_in_rule__JavaCodeGeneration__Group__1__Impl4370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group__0__Impl_in_rule__E4CodeGeneration__Group__04404 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group__1_in_rule__E4CodeGeneration__Group__04407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__E4CodeGeneration__Group__0__Impl4435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__Group__1__Impl_in_rule__E4CodeGeneration__Group__14466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__E4CodeGeneration__IconPathAssignment_1_in_rule__E4CodeGeneration__Group__1__Impl4493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__0__Impl_in_rule__Paritioning__Group__04527 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__1_in_rule__Paritioning__Group__04530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Paritioning__Group__0__Impl4558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__1__Impl_in_rule__Paritioning__Group__14589 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__2_in_rule__Paritioning__Group__14592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Paritioning__Group__1__Impl4620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__2__Impl_in_rule__Paritioning__Group__24651 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__3_in_rule__Paritioning__Group__24654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl4683 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl4695 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__3__Impl_in_rule__Paritioning__Group__34728 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__4_in_rule__Paritioning__Group__34731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionerAssignment_3_in_rule__Paritioning__Group__3__Impl4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__4__Impl_in_rule__Paritioning__Group__44788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Paritioning__Group__4__Impl4816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__04857 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__04860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Partition__Group__0__Impl4888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__14919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl4946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__0__Impl_in_rule__Paritioner_JS__Group__04980 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__1_in_rule__Paritioner_JS__Group__04983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Paritioner_JS__Group__0__Impl5011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__1__Impl_in_rule__Paritioner_JS__Group__15042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__ScriptURIAssignment_1_in_rule__Paritioner_JS__Group__1__Impl5069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__0__Impl_in_rule__Partitioner_Rule__Group__05103 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__1_in_rule__Partitioner_Rule__Group__05106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Partitioner_Rule__Group__0__Impl5134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__1__Impl_in_rule__Partitioner_Rule__Group__15165 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__2_in_rule__Partitioner_Rule__Group__15168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Partitioner_Rule__Group__1__Impl5196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__2__Impl_in_rule__Partitioner_Rule__Group__25227 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__3_in_rule__Partitioner_Rule__Group__25230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl5259 = new BitSet(new long[]{0x0000000022000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl5271 = new BitSet(new long[]{0x0000000022000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__3__Impl_in_rule__Partitioner_Rule__Group__35304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Partitioner_Rule__Group__3__Impl5332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__0__Impl_in_rule__Partition_SingleLineRule__Group__05371 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__1_in_rule__Partition_SingleLineRule__Group__05374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Partition_SingleLineRule__Group__0__Impl5402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__1__Impl_in_rule__Partition_SingleLineRule__Group__15433 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__2_in_rule__Partition_SingleLineRule__Group__15436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__ParitionAssignment_1_in_rule__Partition_SingleLineRule__Group__1__Impl5463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__2__Impl_in_rule__Partition_SingleLineRule__Group__25493 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__3_in_rule__Partition_SingleLineRule__Group__25496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__StartSeqAssignment_2_in_rule__Partition_SingleLineRule__Group__2__Impl5523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__3__Impl_in_rule__Partition_SingleLineRule__Group__35553 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__4_in_rule__Partition_SingleLineRule__Group__35556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Partition_SingleLineRule__Group__3__Impl5584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__4__Impl_in_rule__Partition_SingleLineRule__Group__45615 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__5_in_rule__Partition_SingleLineRule__Group__45618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__EndSeqAssignment_4_in_rule__Partition_SingleLineRule__Group__4__Impl5645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__5__Impl_in_rule__Partition_SingleLineRule__Group__55676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__0_in_rule__Partition_SingleLineRule__Group__5__Impl5703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__0__Impl_in_rule__Partition_SingleLineRule__Group_5__05746 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__1_in_rule__Partition_SingleLineRule__Group_5__05749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Partition_SingleLineRule__Group_5__0__Impl5777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__1__Impl_in_rule__Partition_SingleLineRule__Group_5__15808 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__2_in_rule__Partition_SingleLineRule__Group_5__15811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Partition_SingleLineRule__Group_5__1__Impl5839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__2__Impl_in_rule__Partition_SingleLineRule__Group_5__25870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_SingleLineRule__Group_5__2__Impl5897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__0__Impl_in_rule__Partition_MultiLineRule__Group__05933 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__1_in_rule__Partition_MultiLineRule__Group__05936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Partition_MultiLineRule__Group__0__Impl5964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__1__Impl_in_rule__Partition_MultiLineRule__Group__15995 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__2_in_rule__Partition_MultiLineRule__Group__15998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__ParitionAssignment_1_in_rule__Partition_MultiLineRule__Group__1__Impl6025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__2__Impl_in_rule__Partition_MultiLineRule__Group__26055 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__3_in_rule__Partition_MultiLineRule__Group__26058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__StartSeqAssignment_2_in_rule__Partition_MultiLineRule__Group__2__Impl6085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__3__Impl_in_rule__Partition_MultiLineRule__Group__36115 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__4_in_rule__Partition_MultiLineRule__Group__36118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Partition_MultiLineRule__Group__3__Impl6146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__4__Impl_in_rule__Partition_MultiLineRule__Group__46177 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__5_in_rule__Partition_MultiLineRule__Group__46180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__EndSeqAssignment_4_in_rule__Partition_MultiLineRule__Group__4__Impl6207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__5__Impl_in_rule__Partition_MultiLineRule__Group__56237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__0_in_rule__Partition_MultiLineRule__Group__5__Impl6264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__0__Impl_in_rule__Partition_MultiLineRule__Group_5__06307 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__1_in_rule__Partition_MultiLineRule__Group_5__06310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Partition_MultiLineRule__Group_5__0__Impl6338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__1__Impl_in_rule__Partition_MultiLineRule__Group_5__16369 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__2_in_rule__Partition_MultiLineRule__Group_5__16372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Partition_MultiLineRule__Group_5__1__Impl6400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__2__Impl_in_rule__Partition_MultiLineRule__Group_5__26431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_MultiLineRule__Group_5__2__Impl6458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__0__Impl_in_rule__LexicalHighlighting__Group__06494 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__1_in_rule__LexicalHighlighting__Group__06497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__LexicalHighlighting__Group__0__Impl6525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__1__Impl_in_rule__LexicalHighlighting__Group__16556 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__2_in_rule__LexicalHighlighting__Group__16559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LexicalHighlighting__Group__1__Impl6587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__2__Impl_in_rule__LexicalHighlighting__Group__26618 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__3_in_rule__LexicalHighlighting__Group__26621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl6650 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl6662 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__3__Impl_in_rule__LexicalHighlighting__Group__36695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LexicalHighlighting__Group__3__Impl6723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__06762 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1_in_rule__LexicalPartitionHighlighting_JS__Group__06765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__LexicalPartitionHighlighting_JS__Group__0__Impl6793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__16824 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2_in_rule__LexicalPartitionHighlighting_JS__Group__16827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_JS__Group__1__Impl6854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__26884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2_in_rule__LexicalPartitionHighlighting_JS__Group__2__Impl6911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__06947 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1_in_rule__LexicalPartitionHighlighting_Rule__Group__06950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl6978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__17009 = new BitSet(new long[]{0x0000002000008000L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2_in_rule__LexicalPartitionHighlighting_Rule__Group__17012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl7039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__27069 = new BitSet(new long[]{0x0000002000008000L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3_in_rule__LexicalPartitionHighlighting_Rule__Group__27072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2_in_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl7099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__37130 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4_in_rule__LexicalPartitionHighlighting_Rule__Group__37133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl7161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__47192 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5_in_rule__LexicalPartitionHighlighting_Rule__Group__47195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl7224 = new BitSet(new long[]{0x0000004000000012L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl7236 = new BitSet(new long[]{0x0000004000000012L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__57269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LexicalPartitionHighlighting_Rule__Group__5__Impl7297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__0__Impl_in_rule__Token__Group__07340 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_rule__Token__Group__1_in_rule__Token__Group__07343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__DefaultAssignment_0_in_rule__Token__Group__0__Impl7370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__1__Impl_in_rule__Token__Group__17401 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Token__Group__2_in_rule__Token__Group__17404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__NameAssignment_1_in_rule__Token__Group__1__Impl7431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__2__Impl_in_rule__Token__Group__27461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__0_in_rule__Token__Group__2__Impl7488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__0__Impl_in_rule__Token__Group_2__07525 = new BitSet(new long[]{0x00000010A2800000L});
    public static final BitSet FOLLOW_rule__Token__Group_2__1_in_rule__Token__Group_2__07528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Token__Group_2__0__Impl7556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__1__Impl_in_rule__Token__Group_2__17587 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Token__Group_2__2_in_rule__Token__Group_2__17590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl7619 = new BitSet(new long[]{0x00000010A2800002L});
    public static final BitSet FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl7631 = new BitSet(new long[]{0x00000010A2800002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__2__Impl_in_rule__Token__Group_2__27664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Token__Group_2__2__Impl7692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__0__Impl_in_rule__Scanner_Keyword__Group__07729 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__1_in_rule__Scanner_Keyword__Group__07732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Scanner_Keyword__Group__0__Impl7760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__1__Impl_in_rule__Scanner_Keyword__Group__17791 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__2_in_rule__Scanner_Keyword__Group__17794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Scanner_Keyword__Group__1__Impl7822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__2__Impl_in_rule__Scanner_Keyword__Group__27853 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__3_in_rule__Scanner_Keyword__Group__27856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_2_in_rule__Scanner_Keyword__Group__2__Impl7883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__3__Impl_in_rule__Scanner_Keyword__Group__37913 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__4_in_rule__Scanner_Keyword__Group__37916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__0_in_rule__Scanner_Keyword__Group__3__Impl7943 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__4__Impl_in_rule__Scanner_Keyword__Group__47974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Scanner_Keyword__Group__4__Impl8002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__0__Impl_in_rule__Scanner_Keyword__Group_3__08043 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__1_in_rule__Scanner_Keyword__Group_3__08046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Scanner_Keyword__Group_3__0__Impl8074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__1__Impl_in_rule__Scanner_Keyword__Group_3__18105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_3_1_in_rule__Scanner_Keyword__Group_3__1__Impl8132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__08166 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__08169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl8196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__18226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl8253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__08288 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__08291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Keyword__Group_1__0__Impl8319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__18350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl8377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__0__Impl_in_rule__Scanner_SingleLineRule__Group__08411 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__1_in_rule__Scanner_SingleLineRule__Group__08414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Scanner_SingleLineRule__Group__0__Impl8442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__1__Impl_in_rule__Scanner_SingleLineRule__Group__18473 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__2_in_rule__Scanner_SingleLineRule__Group__18476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__StartSeqAssignment_1_in_rule__Scanner_SingleLineRule__Group__1__Impl8503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__2__Impl_in_rule__Scanner_SingleLineRule__Group__28533 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__3_in_rule__Scanner_SingleLineRule__Group__28536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Scanner_SingleLineRule__Group__2__Impl8564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__3__Impl_in_rule__Scanner_SingleLineRule__Group__38595 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__4_in_rule__Scanner_SingleLineRule__Group__38598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__EndSeqAssignment_3_in_rule__Scanner_SingleLineRule__Group__3__Impl8625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__4__Impl_in_rule__Scanner_SingleLineRule__Group__48656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__0_in_rule__Scanner_SingleLineRule__Group__4__Impl8683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__0__Impl_in_rule__Scanner_SingleLineRule__Group_4__08724 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__1_in_rule__Scanner_SingleLineRule__Group_4__08727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Scanner_SingleLineRule__Group_4__0__Impl8755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__1__Impl_in_rule__Scanner_SingleLineRule__Group_4__18786 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__2_in_rule__Scanner_SingleLineRule__Group_4__18789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Scanner_SingleLineRule__Group_4__1__Impl8817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__2__Impl_in_rule__Scanner_SingleLineRule__Group_4__28848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_SingleLineRule__Group_4__2__Impl8875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__0__Impl_in_rule__Scanner_MultiLineRule__Group__08911 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__1_in_rule__Scanner_MultiLineRule__Group__08914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Scanner_MultiLineRule__Group__0__Impl8942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__1__Impl_in_rule__Scanner_MultiLineRule__Group__18973 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__2_in_rule__Scanner_MultiLineRule__Group__18976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__StartSeqAssignment_1_in_rule__Scanner_MultiLineRule__Group__1__Impl9003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__2__Impl_in_rule__Scanner_MultiLineRule__Group__29033 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__3_in_rule__Scanner_MultiLineRule__Group__29036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Scanner_MultiLineRule__Group__2__Impl9064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__3__Impl_in_rule__Scanner_MultiLineRule__Group__39095 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__4_in_rule__Scanner_MultiLineRule__Group__39098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__EndSeqAssignment_3_in_rule__Scanner_MultiLineRule__Group__3__Impl9125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__4__Impl_in_rule__Scanner_MultiLineRule__Group__49155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__0_in_rule__Scanner_MultiLineRule__Group__4__Impl9182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__0__Impl_in_rule__Scanner_MultiLineRule__Group_4__09223 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__1_in_rule__Scanner_MultiLineRule__Group_4__09226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Scanner_MultiLineRule__Group_4__0__Impl9254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__1__Impl_in_rule__Scanner_MultiLineRule__Group_4__19285 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__2_in_rule__Scanner_MultiLineRule__Group_4__19288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Scanner_MultiLineRule__Group_4__1__Impl9316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__2__Impl_in_rule__Scanner_MultiLineRule__Group_4__29347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_MultiLineRule__Group_4__2__Impl9374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__0__Impl_in_rule__Scanner_CharacterRule__Group__09410 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__1_in_rule__Scanner_CharacterRule__Group__09413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Scanner_CharacterRule__Group__0__Impl9441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__1__Impl_in_rule__Scanner_CharacterRule__Group__19472 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__2_in_rule__Scanner_CharacterRule__Group__19475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Scanner_CharacterRule__Group__1__Impl9503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__2__Impl_in_rule__Scanner_CharacterRule__Group__29534 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__3_in_rule__Scanner_CharacterRule__Group__29537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_2_in_rule__Scanner_CharacterRule__Group__2__Impl9564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__3__Impl_in_rule__Scanner_CharacterRule__Group__39594 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__4_in_rule__Scanner_CharacterRule__Group__39597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__0_in_rule__Scanner_CharacterRule__Group__3__Impl9624 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__4__Impl_in_rule__Scanner_CharacterRule__Group__49655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Scanner_CharacterRule__Group__4__Impl9683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__0__Impl_in_rule__Scanner_CharacterRule__Group_3__09724 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__1_in_rule__Scanner_CharacterRule__Group_3__09727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Scanner_CharacterRule__Group_3__0__Impl9755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__1__Impl_in_rule__Scanner_CharacterRule__Group_3__19786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_3_1_in_rule__Scanner_CharacterRule__Group_3__1__Impl9813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__0__Impl_in_rule__Scanner_JSRule__Group__09847 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__1_in_rule__Scanner_JSRule__Group__09850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Scanner_JSRule__Group__0__Impl9878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__1__Impl_in_rule__Scanner_JSRule__Group__19909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__FileURIAssignment_1_in_rule__Scanner_JSRule__Group__1__Impl9936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__0__Impl_in_rule__WhitespaceRule__Group__09970 = new BitSet(new long[]{0x0000008100000020L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__1_in_rule__WhitespaceRule__Group__09973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__WhitespaceRule__Group__0__Impl10001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group__1__Impl_in_rule__WhitespaceRule__Group__110032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Alternatives_1_in_rule__WhitespaceRule__Group__1__Impl10059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__0__Impl_in_rule__WhitespaceRule__Group_1_0__010093 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__1_in_rule__WhitespaceRule__Group_1_0__010096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__WhitespaceRule__Group_1_0__0__Impl10124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__1__Impl_in_rule__WhitespaceRule__Group_1_0__110155 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__2_in_rule__WhitespaceRule__Group_1_0__110158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_1_in_rule__WhitespaceRule__Group_1_0__1__Impl10185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__2__Impl_in_rule__WhitespaceRule__Group_1_0__210215 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__3_in_rule__WhitespaceRule__Group_1_0__210218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__0_in_rule__WhitespaceRule__Group_1_0__2__Impl10245 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0__3__Impl_in_rule__WhitespaceRule__Group_1_0__310276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__WhitespaceRule__Group_1_0__3__Impl10304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__0__Impl_in_rule__WhitespaceRule__Group_1_0_2__010343 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__1_in_rule__WhitespaceRule__Group_1_0_2__010346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__WhitespaceRule__Group_1_0_2__0__Impl10374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__Group_1_0_2__1__Impl_in_rule__WhitespaceRule__Group_1_0_2__110405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhitespaceRule__CharactersAssignment_1_0_2_1_in_rule__WhitespaceRule__Group_1_0_2__1__Impl10432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Root__NameAssignment_110471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Root__ImportsAssignment_210502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLanguageDef_in_rule__Root__LanguageDefinitionAssignment_310533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_110564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LanguageDef__NameAssignment_010595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioning_in_rule__LanguageDef__ParitioningAssignment_210626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_rule__LanguageDef__LexicalHighlightingAssignment_310657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegration_in_rule__LanguageDef__IntegrationAssignment_410688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeIntegration_in_rule__Integration__CodeIntegrationListAssignment_210719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodegeneration_in_rule__JavaFXIntegration__CodegenerationListAssignment_210750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JavaCodeGeneration__NameAssignment_110781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__E4CodeGeneration__IconPathAssignment_110812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_rule__Paritioning__PartitionsAssignment_210843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_rule__Paritioning__PartitionerAssignment_310874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_110905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Paritioner_JS__ScriptURIAssignment_110936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_rule__Partitioner_Rule__RuleListAssignment_210967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition_SingleLineRule__ParitionAssignment_111002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__StartSeqAssignment_211037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EndSeqAssignment_411068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_211099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition_MultiLineRule__ParitionAssignment_111134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__StartSeqAssignment_211169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EndSeqAssignment_411200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_211231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_rule__LexicalHighlighting__ListAssignment_211262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_111297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_211332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_111367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_211402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_411433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Token__DefaultAssignment_011469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Token__NameAssignment_111508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_rule__Token__ScannerListAssignment_2_111539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_211570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_3_111601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_011632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_111663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__StartSeqAssignment_111694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EndSeqAssignment_311725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_211756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__StartSeqAssignment_111787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EndSeqAssignment_311818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_211849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_211880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_3_111911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_JSRule__FileURIAssignment_111942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_111973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__WhitespaceRule__CharactersAssignment_1_0_2_112004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__WhitespaceRule__JavawhitespaceAssignment_1_112040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__WhitespaceRule__FileURIAssignment_1_212079 = new BitSet(new long[]{0x0000000000000002L});

}