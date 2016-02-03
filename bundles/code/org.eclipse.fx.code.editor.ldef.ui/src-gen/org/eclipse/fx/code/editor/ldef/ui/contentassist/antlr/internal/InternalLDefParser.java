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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "'['", "')'", "']'", "'package'", "'.'", "'*'", "'import'", "'{'", "'}'", "'integration'", "'javafx'", "'java'", "'e4'", "':'", "'partitioning'", "'partition'", "'script'", "'rule'", "'single_line'", "'col'", "'=>'", "'escaped'", "'by'", "'multi_line'", "'lexical_highlighting'", "'token_def'", "';'", "'keywords'", "','", "'since'", "'pattern'", "'containing'", "'character'", "'eq'", "'in'", "'whitespace'", "'bold'", "'italic'", "'default'", "'javawhitespace'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int RULE_ID=4;
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
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalLDefParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLDefParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLDefParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLDef.g"; }


     
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
    // InternalLDef.g:61:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // InternalLDef.g:62:1: ( ruleRoot EOF )
            // InternalLDef.g:63:1: ruleRoot EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRoot();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:70:1: ruleRoot : ( ( rule__Root__Group__0 ) ) ;
    public final void ruleRoot() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:74:2: ( ( ( rule__Root__Group__0 ) ) )
            // InternalLDef.g:75:1: ( ( rule__Root__Group__0 ) )
            {
            // InternalLDef.g:75:1: ( ( rule__Root__Group__0 ) )
            // InternalLDef.g:76:1: ( rule__Root__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getGroup()); 
            }
            // InternalLDef.g:77:1: ( rule__Root__Group__0 )
            // InternalLDef.g:77:2: rule__Root__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:89:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // InternalLDef.g:90:1: ( ruleValidID EOF )
            // InternalLDef.g:91:1: ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValidIDRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:98:1: ruleValidID : ( RULE_ID ) ;
    public final void ruleValidID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:102:2: ( ( RULE_ID ) )
            // InternalLDef.g:103:1: ( RULE_ID )
            {
            // InternalLDef.g:103:1: ( RULE_ID )
            // InternalLDef.g:104:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:117:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalLDef.g:118:1: ( ruleQualifiedName EOF )
            // InternalLDef.g:119:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:126:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:130:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalLDef.g:131:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalLDef.g:131:1: ( ( rule__QualifiedName__Group__0 ) )
            // InternalLDef.g:132:1: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalLDef.g:133:1: ( rule__QualifiedName__Group__0 )
            // InternalLDef.g:133:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:145:1: entryRuleQualifiedNameWithWildCard : ruleQualifiedNameWithWildCard EOF ;
    public final void entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        try {
            // InternalLDef.g:146:1: ( ruleQualifiedNameWithWildCard EOF )
            // InternalLDef.g:147:1: ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:154:1: ruleQualifiedNameWithWildCard : ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildCard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:158:2: ( ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) )
            // InternalLDef.g:159:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            {
            // InternalLDef.g:159:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            // InternalLDef.g:160:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup()); 
            }
            // InternalLDef.g:161:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            // InternalLDef.g:161:2: rule__QualifiedNameWithWildCard__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:173:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalLDef.g:174:1: ( ruleImport EOF )
            // InternalLDef.g:175:1: ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:182:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:186:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalLDef.g:187:1: ( ( rule__Import__Group__0 ) )
            {
            // InternalLDef.g:187:1: ( ( rule__Import__Group__0 ) )
            // InternalLDef.g:188:1: ( rule__Import__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getGroup()); 
            }
            // InternalLDef.g:189:1: ( rule__Import__Group__0 )
            // InternalLDef.g:189:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:201:1: entryRuleLanguageDef : ruleLanguageDef EOF ;
    public final void entryRuleLanguageDef() throws RecognitionException {
        try {
            // InternalLDef.g:202:1: ( ruleLanguageDef EOF )
            // InternalLDef.g:203:1: ruleLanguageDef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLanguageDef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageDefRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:210:1: ruleLanguageDef : ( ( rule__LanguageDef__Group__0 ) ) ;
    public final void ruleLanguageDef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:214:2: ( ( ( rule__LanguageDef__Group__0 ) ) )
            // InternalLDef.g:215:1: ( ( rule__LanguageDef__Group__0 ) )
            {
            // InternalLDef.g:215:1: ( ( rule__LanguageDef__Group__0 ) )
            // InternalLDef.g:216:1: ( rule__LanguageDef__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getGroup()); 
            }
            // InternalLDef.g:217:1: ( rule__LanguageDef__Group__0 )
            // InternalLDef.g:217:2: rule__LanguageDef__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:229:1: entryRuleIntegration : ruleIntegration EOF ;
    public final void entryRuleIntegration() throws RecognitionException {
        try {
            // InternalLDef.g:230:1: ( ruleIntegration EOF )
            // InternalLDef.g:231:1: ruleIntegration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:238:1: ruleIntegration : ( ( rule__Integration__Group__0 ) ) ;
    public final void ruleIntegration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:242:2: ( ( ( rule__Integration__Group__0 ) ) )
            // InternalLDef.g:243:1: ( ( rule__Integration__Group__0 ) )
            {
            // InternalLDef.g:243:1: ( ( rule__Integration__Group__0 ) )
            // InternalLDef.g:244:1: ( rule__Integration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getGroup()); 
            }
            // InternalLDef.g:245:1: ( rule__Integration__Group__0 )
            // InternalLDef.g:245:2: rule__Integration__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:257:1: entryRuleCodeIntegration : ruleCodeIntegration EOF ;
    public final void entryRuleCodeIntegration() throws RecognitionException {
        try {
            // InternalLDef.g:258:1: ( ruleCodeIntegration EOF )
            // InternalLDef.g:259:1: ruleCodeIntegration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCodeIntegrationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCodeIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCodeIntegrationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:266:1: ruleCodeIntegration : ( ruleJavaFXIntegration ) ;
    public final void ruleCodeIntegration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:270:2: ( ( ruleJavaFXIntegration ) )
            // InternalLDef.g:271:1: ( ruleJavaFXIntegration )
            {
            // InternalLDef.g:271:1: ( ruleJavaFXIntegration )
            // InternalLDef.g:272:1: ruleJavaFXIntegration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCodeIntegrationAccess().getJavaFXIntegrationParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:285:1: entryRuleJavaFXIntegration : ruleJavaFXIntegration EOF ;
    public final void entryRuleJavaFXIntegration() throws RecognitionException {
        try {
            // InternalLDef.g:286:1: ( ruleJavaFXIntegration EOF )
            // InternalLDef.g:287:1: ruleJavaFXIntegration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleJavaFXIntegration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:294:1: ruleJavaFXIntegration : ( ( rule__JavaFXIntegration__Group__0 ) ) ;
    public final void ruleJavaFXIntegration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:298:2: ( ( ( rule__JavaFXIntegration__Group__0 ) ) )
            // InternalLDef.g:299:1: ( ( rule__JavaFXIntegration__Group__0 ) )
            {
            // InternalLDef.g:299:1: ( ( rule__JavaFXIntegration__Group__0 ) )
            // InternalLDef.g:300:1: ( rule__JavaFXIntegration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getGroup()); 
            }
            // InternalLDef.g:301:1: ( rule__JavaFXIntegration__Group__0 )
            // InternalLDef.g:301:2: rule__JavaFXIntegration__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:313:1: entryRuleCodegeneration : ruleCodegeneration EOF ;
    public final void entryRuleCodegeneration() throws RecognitionException {
        try {
            // InternalLDef.g:314:1: ( ruleCodegeneration EOF )
            // InternalLDef.g:315:1: ruleCodegeneration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCodegenerationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCodegeneration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCodegenerationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:322:1: ruleCodegeneration : ( ( rule__Codegeneration__Alternatives ) ) ;
    public final void ruleCodegeneration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:326:2: ( ( ( rule__Codegeneration__Alternatives ) ) )
            // InternalLDef.g:327:1: ( ( rule__Codegeneration__Alternatives ) )
            {
            // InternalLDef.g:327:1: ( ( rule__Codegeneration__Alternatives ) )
            // InternalLDef.g:328:1: ( rule__Codegeneration__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCodegenerationAccess().getAlternatives()); 
            }
            // InternalLDef.g:329:1: ( rule__Codegeneration__Alternatives )
            // InternalLDef.g:329:2: rule__Codegeneration__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:341:1: entryRuleJavaCodeGeneration : ruleJavaCodeGeneration EOF ;
    public final void entryRuleJavaCodeGeneration() throws RecognitionException {
        try {
            // InternalLDef.g:342:1: ( ruleJavaCodeGeneration EOF )
            // InternalLDef.g:343:1: ruleJavaCodeGeneration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleJavaCodeGeneration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:350:1: ruleJavaCodeGeneration : ( ( rule__JavaCodeGeneration__Group__0 ) ) ;
    public final void ruleJavaCodeGeneration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:354:2: ( ( ( rule__JavaCodeGeneration__Group__0 ) ) )
            // InternalLDef.g:355:1: ( ( rule__JavaCodeGeneration__Group__0 ) )
            {
            // InternalLDef.g:355:1: ( ( rule__JavaCodeGeneration__Group__0 ) )
            // InternalLDef.g:356:1: ( rule__JavaCodeGeneration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getGroup()); 
            }
            // InternalLDef.g:357:1: ( rule__JavaCodeGeneration__Group__0 )
            // InternalLDef.g:357:2: rule__JavaCodeGeneration__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:369:1: entryRuleE4CodeGeneration : ruleE4CodeGeneration EOF ;
    public final void entryRuleE4CodeGeneration() throws RecognitionException {
        try {
            // InternalLDef.g:370:1: ( ruleE4CodeGeneration EOF )
            // InternalLDef.g:371:1: ruleE4CodeGeneration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleE4CodeGeneration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:378:1: ruleE4CodeGeneration : ( ( rule__E4CodeGeneration__Group__0 ) ) ;
    public final void ruleE4CodeGeneration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:382:2: ( ( ( rule__E4CodeGeneration__Group__0 ) ) )
            // InternalLDef.g:383:1: ( ( rule__E4CodeGeneration__Group__0 ) )
            {
            // InternalLDef.g:383:1: ( ( rule__E4CodeGeneration__Group__0 ) )
            // InternalLDef.g:384:1: ( rule__E4CodeGeneration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getGroup()); 
            }
            // InternalLDef.g:385:1: ( rule__E4CodeGeneration__Group__0 )
            // InternalLDef.g:385:2: rule__E4CodeGeneration__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:397:1: entryRuleConfigValue : ruleConfigValue EOF ;
    public final void entryRuleConfigValue() throws RecognitionException {
        try {
            // InternalLDef.g:398:1: ( ruleConfigValue EOF )
            // InternalLDef.g:399:1: ruleConfigValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConfigValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:406:1: ruleConfigValue : ( ( rule__ConfigValue__Group__0 ) ) ;
    public final void ruleConfigValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:410:2: ( ( ( rule__ConfigValue__Group__0 ) ) )
            // InternalLDef.g:411:1: ( ( rule__ConfigValue__Group__0 ) )
            {
            // InternalLDef.g:411:1: ( ( rule__ConfigValue__Group__0 ) )
            // InternalLDef.g:412:1: ( rule__ConfigValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getGroup()); 
            }
            // InternalLDef.g:413:1: ( rule__ConfigValue__Group__0 )
            // InternalLDef.g:413:2: rule__ConfigValue__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:425:1: entryRuleParitioning : ruleParitioning EOF ;
    public final void entryRuleParitioning() throws RecognitionException {
        try {
            // InternalLDef.g:426:1: ( ruleParitioning EOF )
            // InternalLDef.g:427:1: ruleParitioning EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleParitioning();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:434:1: ruleParitioning : ( ( rule__Paritioning__Group__0 ) ) ;
    public final void ruleParitioning() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:438:2: ( ( ( rule__Paritioning__Group__0 ) ) )
            // InternalLDef.g:439:1: ( ( rule__Paritioning__Group__0 ) )
            {
            // InternalLDef.g:439:1: ( ( rule__Paritioning__Group__0 ) )
            // InternalLDef.g:440:1: ( rule__Paritioning__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getGroup()); 
            }
            // InternalLDef.g:441:1: ( rule__Paritioning__Group__0 )
            // InternalLDef.g:441:2: rule__Paritioning__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:453:1: entryRulePartition : rulePartition EOF ;
    public final void entryRulePartition() throws RecognitionException {
        try {
            // InternalLDef.g:454:1: ( rulePartition EOF )
            // InternalLDef.g:455:1: rulePartition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePartition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:462:1: rulePartition : ( ( rule__Partition__Group__0 ) ) ;
    public final void rulePartition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:466:2: ( ( ( rule__Partition__Group__0 ) ) )
            // InternalLDef.g:467:1: ( ( rule__Partition__Group__0 ) )
            {
            // InternalLDef.g:467:1: ( ( rule__Partition__Group__0 ) )
            // InternalLDef.g:468:1: ( rule__Partition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getGroup()); 
            }
            // InternalLDef.g:469:1: ( rule__Partition__Group__0 )
            // InternalLDef.g:469:2: rule__Partition__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:481:1: entryRulePartitioner : rulePartitioner EOF ;
    public final void entryRulePartitioner() throws RecognitionException {
        try {
            // InternalLDef.g:482:1: ( rulePartitioner EOF )
            // InternalLDef.g:483:1: rulePartitioner EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionerRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePartitioner();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitionerRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:490:1: rulePartitioner : ( ( rule__Partitioner__Alternatives ) ) ;
    public final void rulePartitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:494:2: ( ( ( rule__Partitioner__Alternatives ) ) )
            // InternalLDef.g:495:1: ( ( rule__Partitioner__Alternatives ) )
            {
            // InternalLDef.g:495:1: ( ( rule__Partitioner__Alternatives ) )
            // InternalLDef.g:496:1: ( rule__Partitioner__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionerAccess().getAlternatives()); 
            }
            // InternalLDef.g:497:1: ( rule__Partitioner__Alternatives )
            // InternalLDef.g:497:2: rule__Partitioner__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:509:1: entryRuleParitioner_JS : ruleParitioner_JS EOF ;
    public final void entryRuleParitioner_JS() throws RecognitionException {
        try {
            // InternalLDef.g:510:1: ( ruleParitioner_JS EOF )
            // InternalLDef.g:511:1: ruleParitioner_JS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleParitioner_JS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioner_JSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:518:1: ruleParitioner_JS : ( ( rule__Paritioner_JS__Group__0 ) ) ;
    public final void ruleParitioner_JS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:522:2: ( ( ( rule__Paritioner_JS__Group__0 ) ) )
            // InternalLDef.g:523:1: ( ( rule__Paritioner_JS__Group__0 ) )
            {
            // InternalLDef.g:523:1: ( ( rule__Paritioner_JS__Group__0 ) )
            // InternalLDef.g:524:1: ( rule__Paritioner_JS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getGroup()); 
            }
            // InternalLDef.g:525:1: ( rule__Paritioner_JS__Group__0 )
            // InternalLDef.g:525:2: rule__Paritioner_JS__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:537:1: entryRulePartitioner_Rule : rulePartitioner_Rule EOF ;
    public final void entryRulePartitioner_Rule() throws RecognitionException {
        try {
            // InternalLDef.g:538:1: ( rulePartitioner_Rule EOF )
            // InternalLDef.g:539:1: rulePartitioner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePartitioner_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:546:1: rulePartitioner_Rule : ( ( rule__Partitioner_Rule__Group__0 ) ) ;
    public final void rulePartitioner_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:550:2: ( ( ( rule__Partitioner_Rule__Group__0 ) ) )
            // InternalLDef.g:551:1: ( ( rule__Partitioner_Rule__Group__0 ) )
            {
            // InternalLDef.g:551:1: ( ( rule__Partitioner_Rule__Group__0 ) )
            // InternalLDef.g:552:1: ( rule__Partitioner_Rule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getGroup()); 
            }
            // InternalLDef.g:553:1: ( rule__Partitioner_Rule__Group__0 )
            // InternalLDef.g:553:2: rule__Partitioner_Rule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:565:1: entryRulePartition_Rule : rulePartition_Rule EOF ;
    public final void entryRulePartition_Rule() throws RecognitionException {
        try {
            // InternalLDef.g:566:1: ( rulePartition_Rule EOF )
            // InternalLDef.g:567:1: rulePartition_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_RuleRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePartition_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_RuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:574:1: rulePartition_Rule : ( ( rule__Partition_Rule__Alternatives ) ) ;
    public final void rulePartition_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:578:2: ( ( ( rule__Partition_Rule__Alternatives ) ) )
            // InternalLDef.g:579:1: ( ( rule__Partition_Rule__Alternatives ) )
            {
            // InternalLDef.g:579:1: ( ( rule__Partition_Rule__Alternatives ) )
            // InternalLDef.g:580:1: ( rule__Partition_Rule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_RuleAccess().getAlternatives()); 
            }
            // InternalLDef.g:581:1: ( rule__Partition_Rule__Alternatives )
            // InternalLDef.g:581:2: rule__Partition_Rule__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:593:1: entryRulePartition_SingleLineRule : rulePartition_SingleLineRule EOF ;
    public final void entryRulePartition_SingleLineRule() throws RecognitionException {
        try {
            // InternalLDef.g:594:1: ( rulePartition_SingleLineRule EOF )
            // InternalLDef.g:595:1: rulePartition_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePartition_SingleLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:602:1: rulePartition_SingleLineRule : ( ( rule__Partition_SingleLineRule__Group__0 ) ) ;
    public final void rulePartition_SingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:606:2: ( ( ( rule__Partition_SingleLineRule__Group__0 ) ) )
            // InternalLDef.g:607:1: ( ( rule__Partition_SingleLineRule__Group__0 ) )
            {
            // InternalLDef.g:607:1: ( ( rule__Partition_SingleLineRule__Group__0 ) )
            // InternalLDef.g:608:1: ( rule__Partition_SingleLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup()); 
            }
            // InternalLDef.g:609:1: ( rule__Partition_SingleLineRule__Group__0 )
            // InternalLDef.g:609:2: rule__Partition_SingleLineRule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:621:1: entryRulePartition_MultiLineRule : rulePartition_MultiLineRule EOF ;
    public final void entryRulePartition_MultiLineRule() throws RecognitionException {
        try {
            // InternalLDef.g:622:1: ( rulePartition_MultiLineRule EOF )
            // InternalLDef.g:623:1: rulePartition_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePartition_MultiLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:630:1: rulePartition_MultiLineRule : ( ( rule__Partition_MultiLineRule__Group__0 ) ) ;
    public final void rulePartition_MultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:634:2: ( ( ( rule__Partition_MultiLineRule__Group__0 ) ) )
            // InternalLDef.g:635:1: ( ( rule__Partition_MultiLineRule__Group__0 ) )
            {
            // InternalLDef.g:635:1: ( ( rule__Partition_MultiLineRule__Group__0 ) )
            // InternalLDef.g:636:1: ( rule__Partition_MultiLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup()); 
            }
            // InternalLDef.g:637:1: ( rule__Partition_MultiLineRule__Group__0 )
            // InternalLDef.g:637:2: rule__Partition_MultiLineRule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:649:1: entryRuleLexicalHighlighting : ruleLexicalHighlighting EOF ;
    public final void entryRuleLexicalHighlighting() throws RecognitionException {
        try {
            // InternalLDef.g:650:1: ( ruleLexicalHighlighting EOF )
            // InternalLDef.g:651:1: ruleLexicalHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:658:1: ruleLexicalHighlighting : ( ( rule__LexicalHighlighting__Group__0 ) ) ;
    public final void ruleLexicalHighlighting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:662:2: ( ( ( rule__LexicalHighlighting__Group__0 ) ) )
            // InternalLDef.g:663:1: ( ( rule__LexicalHighlighting__Group__0 ) )
            {
            // InternalLDef.g:663:1: ( ( rule__LexicalHighlighting__Group__0 ) )
            // InternalLDef.g:664:1: ( rule__LexicalHighlighting__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getGroup()); 
            }
            // InternalLDef.g:665:1: ( rule__LexicalHighlighting__Group__0 )
            // InternalLDef.g:665:2: rule__LexicalHighlighting__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleTokenVisuals"
    // InternalLDef.g:677:1: entryRuleTokenVisuals : ruleTokenVisuals EOF ;
    public final void entryRuleTokenVisuals() throws RecognitionException {
        try {
            // InternalLDef.g:678:1: ( ruleTokenVisuals EOF )
            // InternalLDef.g:679:1: ruleTokenVisuals EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualsRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTokenVisuals();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualsRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTokenVisuals"


    // $ANTLR start "ruleTokenVisuals"
    // InternalLDef.g:686:1: ruleTokenVisuals : ( ( rule__TokenVisuals__Group__0 ) ) ;
    public final void ruleTokenVisuals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:690:2: ( ( ( rule__TokenVisuals__Group__0 ) ) )
            // InternalLDef.g:691:1: ( ( rule__TokenVisuals__Group__0 ) )
            {
            // InternalLDef.g:691:1: ( ( rule__TokenVisuals__Group__0 ) )
            // InternalLDef.g:692:1: ( rule__TokenVisuals__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualsAccess().getGroup()); 
            }
            // InternalLDef.g:693:1: ( rule__TokenVisuals__Group__0 )
            // InternalLDef.g:693:2: rule__TokenVisuals__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TokenVisuals__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualsAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTokenVisuals"


    // $ANTLR start "entryRuleTokenVisual"
    // InternalLDef.g:705:1: entryRuleTokenVisual : ruleTokenVisual EOF ;
    public final void entryRuleTokenVisual() throws RecognitionException {
        try {
            // InternalLDef.g:706:1: ( ruleTokenVisual EOF )
            // InternalLDef.g:707:1: ruleTokenVisual EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTokenVisual();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTokenVisual"


    // $ANTLR start "ruleTokenVisual"
    // InternalLDef.g:714:1: ruleTokenVisual : ( ( rule__TokenVisual__Group__0 ) ) ;
    public final void ruleTokenVisual() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:718:2: ( ( ( rule__TokenVisual__Group__0 ) ) )
            // InternalLDef.g:719:1: ( ( rule__TokenVisual__Group__0 ) )
            {
            // InternalLDef.g:719:1: ( ( rule__TokenVisual__Group__0 ) )
            // InternalLDef.g:720:1: ( rule__TokenVisual__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getGroup()); 
            }
            // InternalLDef.g:721:1: ( rule__TokenVisual__Group__0 )
            // InternalLDef.g:721:2: rule__TokenVisual__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TokenVisual__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTokenVisual"


    // $ANTLR start "entryRuleLexicalPartitionHighlighting"
    // InternalLDef.g:733:1: entryRuleLexicalPartitionHighlighting : ruleLexicalPartitionHighlighting EOF ;
    public final void entryRuleLexicalPartitionHighlighting() throws RecognitionException {
        try {
            // InternalLDef.g:734:1: ( ruleLexicalPartitionHighlighting EOF )
            // InternalLDef.g:735:1: ruleLexicalPartitionHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLexicalPartitionHighlighting();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:742:1: ruleLexicalPartitionHighlighting : ( ( rule__LexicalPartitionHighlighting__Alternatives ) ) ;
    public final void ruleLexicalPartitionHighlighting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:746:2: ( ( ( rule__LexicalPartitionHighlighting__Alternatives ) ) )
            // InternalLDef.g:747:1: ( ( rule__LexicalPartitionHighlighting__Alternatives ) )
            {
            // InternalLDef.g:747:1: ( ( rule__LexicalPartitionHighlighting__Alternatives ) )
            // InternalLDef.g:748:1: ( rule__LexicalPartitionHighlighting__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlightingAccess().getAlternatives()); 
            }
            // InternalLDef.g:749:1: ( rule__LexicalPartitionHighlighting__Alternatives )
            // InternalLDef.g:749:2: rule__LexicalPartitionHighlighting__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:761:1: entryRuleLexicalPartitionHighlighting_JS : ruleLexicalPartitionHighlighting_JS EOF ;
    public final void entryRuleLexicalPartitionHighlighting_JS() throws RecognitionException {
        try {
            // InternalLDef.g:762:1: ( ruleLexicalPartitionHighlighting_JS EOF )
            // InternalLDef.g:763:1: ruleLexicalPartitionHighlighting_JS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLexicalPartitionHighlighting_JS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:770:1: ruleLexicalPartitionHighlighting_JS : ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) ) ;
    public final void ruleLexicalPartitionHighlighting_JS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:774:2: ( ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) ) )
            // InternalLDef.g:775:1: ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) )
            {
            // InternalLDef.g:775:1: ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) )
            // InternalLDef.g:776:1: ( rule__LexicalPartitionHighlighting_JS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getGroup()); 
            }
            // InternalLDef.g:777:1: ( rule__LexicalPartitionHighlighting_JS__Group__0 )
            // InternalLDef.g:777:2: rule__LexicalPartitionHighlighting_JS__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:789:1: entryRuleLexicalPartitionHighlighting_Rule : ruleLexicalPartitionHighlighting_Rule EOF ;
    public final void entryRuleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        try {
            // InternalLDef.g:790:1: ( ruleLexicalPartitionHighlighting_Rule EOF )
            // InternalLDef.g:791:1: ruleLexicalPartitionHighlighting_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLexicalPartitionHighlighting_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:798:1: ruleLexicalPartitionHighlighting_Rule : ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) ) ;
    public final void ruleLexicalPartitionHighlighting_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:802:2: ( ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) ) )
            // InternalLDef.g:803:1: ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) )
            {
            // InternalLDef.g:803:1: ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) )
            // InternalLDef.g:804:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getGroup()); 
            }
            // InternalLDef.g:805:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0 )
            // InternalLDef.g:805:2: rule__LexicalPartitionHighlighting_Rule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:817:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // InternalLDef.g:818:1: ( ruleToken EOF )
            // InternalLDef.g:819:1: ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleToken();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:826:1: ruleToken : ( ( rule__Token__Group__0 ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:830:2: ( ( ( rule__Token__Group__0 ) ) )
            // InternalLDef.g:831:1: ( ( rule__Token__Group__0 ) )
            {
            // InternalLDef.g:831:1: ( ( rule__Token__Group__0 ) )
            // InternalLDef.g:832:1: ( rule__Token__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getGroup()); 
            }
            // InternalLDef.g:833:1: ( rule__Token__Group__0 )
            // InternalLDef.g:833:2: rule__Token__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:845:1: entryRuleScanner : ruleScanner EOF ;
    public final void entryRuleScanner() throws RecognitionException {
        try {
            // InternalLDef.g:846:1: ( ruleScanner EOF )
            // InternalLDef.g:847:1: ruleScanner EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScannerRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleScanner();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScannerRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:854:1: ruleScanner : ( ( rule__Scanner__Alternatives ) ) ;
    public final void ruleScanner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:858:2: ( ( ( rule__Scanner__Alternatives ) ) )
            // InternalLDef.g:859:1: ( ( rule__Scanner__Alternatives ) )
            {
            // InternalLDef.g:859:1: ( ( rule__Scanner__Alternatives ) )
            // InternalLDef.g:860:1: ( rule__Scanner__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScannerAccess().getAlternatives()); 
            }
            // InternalLDef.g:861:1: ( rule__Scanner__Alternatives )
            // InternalLDef.g:861:2: rule__Scanner__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:873:1: entryRuleScanner_Keyword : ruleScanner_Keyword EOF ;
    public final void entryRuleScanner_Keyword() throws RecognitionException {
        try {
            // InternalLDef.g:874:1: ( ruleScanner_Keyword EOF )
            // InternalLDef.g:875:1: ruleScanner_Keyword EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleScanner_Keyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_KeywordRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:882:1: ruleScanner_Keyword : ( ( rule__Scanner_Keyword__Group__0 ) ) ;
    public final void ruleScanner_Keyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:886:2: ( ( ( rule__Scanner_Keyword__Group__0 ) ) )
            // InternalLDef.g:887:1: ( ( rule__Scanner_Keyword__Group__0 ) )
            {
            // InternalLDef.g:887:1: ( ( rule__Scanner_Keyword__Group__0 ) )
            // InternalLDef.g:888:1: ( rule__Scanner_Keyword__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getGroup()); 
            }
            // InternalLDef.g:889:1: ( rule__Scanner_Keyword__Group__0 )
            // InternalLDef.g:889:2: rule__Scanner_Keyword__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:901:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalLDef.g:902:1: ( ruleKeyword EOF )
            // InternalLDef.g:903:1: ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:910:1: ruleKeyword : ( ( rule__Keyword__Group__0 ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:914:2: ( ( ( rule__Keyword__Group__0 ) ) )
            // InternalLDef.g:915:1: ( ( rule__Keyword__Group__0 ) )
            {
            // InternalLDef.g:915:1: ( ( rule__Keyword__Group__0 ) )
            // InternalLDef.g:916:1: ( rule__Keyword__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getGroup()); 
            }
            // InternalLDef.g:917:1: ( rule__Keyword__Group__0 )
            // InternalLDef.g:917:2: rule__Keyword__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:929:1: entryRuleScanner_Rule : ruleScanner_Rule EOF ;
    public final void entryRuleScanner_Rule() throws RecognitionException {
        try {
            // InternalLDef.g:930:1: ( ruleScanner_Rule EOF )
            // InternalLDef.g:931:1: ruleScanner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_RuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleScanner_Rule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_RuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:938:1: ruleScanner_Rule : ( ( rule__Scanner_Rule__Alternatives ) ) ;
    public final void ruleScanner_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:942:2: ( ( ( rule__Scanner_Rule__Alternatives ) ) )
            // InternalLDef.g:943:1: ( ( rule__Scanner_Rule__Alternatives ) )
            {
            // InternalLDef.g:943:1: ( ( rule__Scanner_Rule__Alternatives ) )
            // InternalLDef.g:944:1: ( rule__Scanner_Rule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_RuleAccess().getAlternatives()); 
            }
            // InternalLDef.g:945:1: ( rule__Scanner_Rule__Alternatives )
            // InternalLDef.g:945:2: rule__Scanner_Rule__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:957:1: entryRuleScanner_SingleLineRule : ruleScanner_SingleLineRule EOF ;
    public final void entryRuleScanner_SingleLineRule() throws RecognitionException {
        try {
            // InternalLDef.g:958:1: ( ruleScanner_SingleLineRule EOF )
            // InternalLDef.g:959:1: ruleScanner_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleScanner_SingleLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:966:1: ruleScanner_SingleLineRule : ( ( rule__Scanner_SingleLineRule__Group__0 ) ) ;
    public final void ruleScanner_SingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:970:2: ( ( ( rule__Scanner_SingleLineRule__Group__0 ) ) )
            // InternalLDef.g:971:1: ( ( rule__Scanner_SingleLineRule__Group__0 ) )
            {
            // InternalLDef.g:971:1: ( ( rule__Scanner_SingleLineRule__Group__0 ) )
            // InternalLDef.g:972:1: ( rule__Scanner_SingleLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup()); 
            }
            // InternalLDef.g:973:1: ( rule__Scanner_SingleLineRule__Group__0 )
            // InternalLDef.g:973:2: rule__Scanner_SingleLineRule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:985:1: entryRuleScanner_MultiLineRule : ruleScanner_MultiLineRule EOF ;
    public final void entryRuleScanner_MultiLineRule() throws RecognitionException {
        try {
            // InternalLDef.g:986:1: ( ruleScanner_MultiLineRule EOF )
            // InternalLDef.g:987:1: ruleScanner_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleScanner_MultiLineRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:994:1: ruleScanner_MultiLineRule : ( ( rule__Scanner_MultiLineRule__Group__0 ) ) ;
    public final void ruleScanner_MultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:998:2: ( ( ( rule__Scanner_MultiLineRule__Group__0 ) ) )
            // InternalLDef.g:999:1: ( ( rule__Scanner_MultiLineRule__Group__0 ) )
            {
            // InternalLDef.g:999:1: ( ( rule__Scanner_MultiLineRule__Group__0 ) )
            // InternalLDef.g:1000:1: ( rule__Scanner_MultiLineRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup()); 
            }
            // InternalLDef.g:1001:1: ( rule__Scanner_MultiLineRule__Group__0 )
            // InternalLDef.g:1001:2: rule__Scanner_MultiLineRule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1013:1: entryRuleScanner_PatternRule : ruleScanner_PatternRule EOF ;
    public final void entryRuleScanner_PatternRule() throws RecognitionException {
        try {
            // InternalLDef.g:1014:1: ( ruleScanner_PatternRule EOF )
            // InternalLDef.g:1015:1: ruleScanner_PatternRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleScanner_PatternRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:1022:1: ruleScanner_PatternRule : ( ( rule__Scanner_PatternRule__Group__0 ) ) ;
    public final void ruleScanner_PatternRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1026:2: ( ( ( rule__Scanner_PatternRule__Group__0 ) ) )
            // InternalLDef.g:1027:1: ( ( rule__Scanner_PatternRule__Group__0 ) )
            {
            // InternalLDef.g:1027:1: ( ( rule__Scanner_PatternRule__Group__0 ) )
            // InternalLDef.g:1028:1: ( rule__Scanner_PatternRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getGroup()); 
            }
            // InternalLDef.g:1029:1: ( rule__Scanner_PatternRule__Group__0 )
            // InternalLDef.g:1029:2: rule__Scanner_PatternRule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1041:1: entryRuleScanner_CharacterRule : ruleScanner_CharacterRule EOF ;
    public final void entryRuleScanner_CharacterRule() throws RecognitionException {
        try {
            // InternalLDef.g:1042:1: ( ruleScanner_CharacterRule EOF )
            // InternalLDef.g:1043:1: ruleScanner_CharacterRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleScanner_CharacterRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:1050:1: ruleScanner_CharacterRule : ( ( rule__Scanner_CharacterRule__Group__0 ) ) ;
    public final void ruleScanner_CharacterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1054:2: ( ( ( rule__Scanner_CharacterRule__Group__0 ) ) )
            // InternalLDef.g:1055:1: ( ( rule__Scanner_CharacterRule__Group__0 ) )
            {
            // InternalLDef.g:1055:1: ( ( rule__Scanner_CharacterRule__Group__0 ) )
            // InternalLDef.g:1056:1: ( rule__Scanner_CharacterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getGroup()); 
            }
            // InternalLDef.g:1057:1: ( rule__Scanner_CharacterRule__Group__0 )
            // InternalLDef.g:1057:2: rule__Scanner_CharacterRule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1069:1: entryRuleScanner_JSRule : ruleScanner_JSRule EOF ;
    public final void entryRuleScanner_JSRule() throws RecognitionException {
        try {
            // InternalLDef.g:1070:1: ( ruleScanner_JSRule EOF )
            // InternalLDef.g:1071:1: ruleScanner_JSRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleScanner_JSRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:1078:1: ruleScanner_JSRule : ( ( rule__Scanner_JSRule__Group__0 ) ) ;
    public final void ruleScanner_JSRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1082:2: ( ( ( rule__Scanner_JSRule__Group__0 ) ) )
            // InternalLDef.g:1083:1: ( ( rule__Scanner_JSRule__Group__0 ) )
            {
            // InternalLDef.g:1083:1: ( ( rule__Scanner_JSRule__Group__0 ) )
            // InternalLDef.g:1084:1: ( rule__Scanner_JSRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getGroup()); 
            }
            // InternalLDef.g:1085:1: ( rule__Scanner_JSRule__Group__0 )
            // InternalLDef.g:1085:2: rule__Scanner_JSRule__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleCheck"
    // InternalLDef.g:1097:1: entryRuleCheck : ruleCheck EOF ;
    public final void entryRuleCheck() throws RecognitionException {
        try {
            // InternalLDef.g:1098:1: ( ruleCheck EOF )
            // InternalLDef.g:1099:1: ruleCheck EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCheckRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCheck();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCheckRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleCheck"


    // $ANTLR start "ruleCheck"
    // InternalLDef.g:1106:1: ruleCheck : ( ( rule__Check__Alternatives ) ) ;
    public final void ruleCheck() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1110:2: ( ( ( rule__Check__Alternatives ) ) )
            // InternalLDef.g:1111:1: ( ( rule__Check__Alternatives ) )
            {
            // InternalLDef.g:1111:1: ( ( rule__Check__Alternatives ) )
            // InternalLDef.g:1112:1: ( rule__Check__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCheckAccess().getAlternatives()); 
            }
            // InternalLDef.g:1113:1: ( rule__Check__Alternatives )
            // InternalLDef.g:1113:2: rule__Check__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Check__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCheckAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCheck"


    // $ANTLR start "entryRuleEquals"
    // InternalLDef.g:1125:1: entryRuleEquals : ruleEquals EOF ;
    public final void entryRuleEquals() throws RecognitionException {
        try {
            // InternalLDef.g:1126:1: ( ruleEquals EOF )
            // InternalLDef.g:1127:1: ruleEquals EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEquals();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleEquals"


    // $ANTLR start "ruleEquals"
    // InternalLDef.g:1134:1: ruleEquals : ( ( rule__Equals__Group__0 ) ) ;
    public final void ruleEquals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1138:2: ( ( ( rule__Equals__Group__0 ) ) )
            // InternalLDef.g:1139:1: ( ( rule__Equals__Group__0 ) )
            {
            // InternalLDef.g:1139:1: ( ( rule__Equals__Group__0 ) )
            // InternalLDef.g:1140:1: ( rule__Equals__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getGroup()); 
            }
            // InternalLDef.g:1141:1: ( rule__Equals__Group__0 )
            // InternalLDef.g:1141:2: rule__Equals__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Equals__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquals"


    // $ANTLR start "entryRuleRange"
    // InternalLDef.g:1153:1: entryRuleRange : ruleRange EOF ;
    public final void entryRuleRange() throws RecognitionException {
        try {
            // InternalLDef.g:1154:1: ( ruleRange EOF )
            // InternalLDef.g:1155:1: ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRange();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // InternalLDef.g:1162:1: ruleRange : ( ( rule__Range__Group__0 ) ) ;
    public final void ruleRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1166:2: ( ( ( rule__Range__Group__0 ) ) )
            // InternalLDef.g:1167:1: ( ( rule__Range__Group__0 ) )
            {
            // InternalLDef.g:1167:1: ( ( rule__Range__Group__0 ) )
            // InternalLDef.g:1168:1: ( rule__Range__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getGroup()); 
            }
            // InternalLDef.g:1169:1: ( rule__Range__Group__0 )
            // InternalLDef.g:1169:2: rule__Range__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Range__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleWhitespaceRule"
    // InternalLDef.g:1181:1: entryRuleWhitespaceRule : ruleWhitespaceRule EOF ;
    public final void entryRuleWhitespaceRule() throws RecognitionException {
        try {
            // InternalLDef.g:1182:1: ( ruleWhitespaceRule EOF )
            // InternalLDef.g:1183:1: ruleWhitespaceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleWhitespaceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWhitespaceRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:1190:1: ruleWhitespaceRule : ( ( rule__WhitespaceRule__Group__0 ) ) ;
    public final void ruleWhitespaceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1194:2: ( ( ( rule__WhitespaceRule__Group__0 ) ) )
            // InternalLDef.g:1195:1: ( ( rule__WhitespaceRule__Group__0 ) )
            {
            // InternalLDef.g:1195:1: ( ( rule__WhitespaceRule__Group__0 ) )
            // InternalLDef.g:1196:1: ( rule__WhitespaceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getGroup()); 
            }
            // InternalLDef.g:1197:1: ( rule__WhitespaceRule__Group__0 )
            // InternalLDef.g:1197:2: rule__WhitespaceRule__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1209:1: rule__Codegeneration__Alternatives : ( ( ruleJavaCodeGeneration ) | ( ruleE4CodeGeneration ) );
    public final void rule__Codegeneration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1213:1: ( ( ruleJavaCodeGeneration ) | ( ruleE4CodeGeneration ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==23) ) {
                alt1=1;
            }
            else if ( (LA1_0==24) ) {
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
                    // InternalLDef.g:1214:1: ( ruleJavaCodeGeneration )
                    {
                    // InternalLDef.g:1214:1: ( ruleJavaCodeGeneration )
                    // InternalLDef.g:1215:1: ruleJavaCodeGeneration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCodegenerationAccess().getJavaCodeGenerationParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1220:6: ( ruleE4CodeGeneration )
                    {
                    // InternalLDef.g:1220:6: ( ruleE4CodeGeneration )
                    // InternalLDef.g:1221:1: ruleE4CodeGeneration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCodegenerationAccess().getE4CodeGenerationParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1231:1: rule__ConfigValue__Alternatives_2 : ( ( ( rule__ConfigValue__SimpleValueAssignment_2_0 ) ) | ( ( rule__ConfigValue__Group_2_1__0 ) ) );
    public final void rule__ConfigValue__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1235:1: ( ( ( rule__ConfigValue__SimpleValueAssignment_2_0 ) ) | ( ( rule__ConfigValue__Group_2_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==19) ) {
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
                    // InternalLDef.g:1236:1: ( ( rule__ConfigValue__SimpleValueAssignment_2_0 ) )
                    {
                    // InternalLDef.g:1236:1: ( ( rule__ConfigValue__SimpleValueAssignment_2_0 ) )
                    // InternalLDef.g:1237:1: ( rule__ConfigValue__SimpleValueAssignment_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigValueAccess().getSimpleValueAssignment_2_0()); 
                    }
                    // InternalLDef.g:1238:1: ( rule__ConfigValue__SimpleValueAssignment_2_0 )
                    // InternalLDef.g:1238:2: rule__ConfigValue__SimpleValueAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1242:6: ( ( rule__ConfigValue__Group_2_1__0 ) )
                    {
                    // InternalLDef.g:1242:6: ( ( rule__ConfigValue__Group_2_1__0 ) )
                    // InternalLDef.g:1243:1: ( rule__ConfigValue__Group_2_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigValueAccess().getGroup_2_1()); 
                    }
                    // InternalLDef.g:1244:1: ( rule__ConfigValue__Group_2_1__0 )
                    // InternalLDef.g:1244:2: rule__ConfigValue__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1253:1: rule__Partitioner__Alternatives : ( ( rulePartitioner_Rule ) | ( ruleParitioner_JS ) );
    public final void rule__Partitioner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1257:1: ( ( rulePartitioner_Rule ) | ( ruleParitioner_JS ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==29) ) {
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
                    // InternalLDef.g:1258:1: ( rulePartitioner_Rule )
                    {
                    // InternalLDef.g:1258:1: ( rulePartitioner_Rule )
                    // InternalLDef.g:1259:1: rulePartitioner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1264:6: ( ruleParitioner_JS )
                    {
                    // InternalLDef.g:1264:6: ( ruleParitioner_JS )
                    // InternalLDef.g:1265:1: ruleParitioner_JS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1275:1: rule__Partition_Rule__Alternatives : ( ( rulePartition_SingleLineRule ) | ( rulePartition_MultiLineRule ) );
    public final void rule__Partition_Rule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1279:1: ( ( rulePartition_SingleLineRule ) | ( rulePartition_MultiLineRule ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==30) ) {
                alt4=1;
            }
            else if ( (LA4_0==35) ) {
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
                    // InternalLDef.g:1280:1: ( rulePartition_SingleLineRule )
                    {
                    // InternalLDef.g:1280:1: ( rulePartition_SingleLineRule )
                    // InternalLDef.g:1281:1: rulePartition_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1286:6: ( rulePartition_MultiLineRule )
                    {
                    // InternalLDef.g:1286:6: ( rulePartition_MultiLineRule )
                    // InternalLDef.g:1287:1: rulePartition_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1297:1: rule__LexicalPartitionHighlighting__Alternatives : ( ( ruleLexicalPartitionHighlighting_Rule ) | ( ruleLexicalPartitionHighlighting_JS ) );
    public final void rule__LexicalPartitionHighlighting__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1301:1: ( ( ruleLexicalPartitionHighlighting_Rule ) | ( ruleLexicalPartitionHighlighting_JS ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==29) ) {
                alt5=1;
            }
            else if ( (LA5_0==28) ) {
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
                    // InternalLDef.g:1302:1: ( ruleLexicalPartitionHighlighting_Rule )
                    {
                    // InternalLDef.g:1302:1: ( ruleLexicalPartitionHighlighting_Rule )
                    // InternalLDef.g:1303:1: ruleLexicalPartitionHighlighting_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1308:6: ( ruleLexicalPartitionHighlighting_JS )
                    {
                    // InternalLDef.g:1308:6: ( ruleLexicalPartitionHighlighting_JS )
                    // InternalLDef.g:1309:1: ruleLexicalPartitionHighlighting_JS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1319:1: rule__Scanner__Alternatives : ( ( ruleScanner_Keyword ) | ( ruleScanner_Rule ) );
    public final void rule__Scanner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1323:1: ( ( ruleScanner_Keyword ) | ( ruleScanner_Rule ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==39) ) {
                alt6=1;
            }
            else if ( (LA6_0==28||LA6_0==30||LA6_0==35||LA6_0==42||LA6_0==44) ) {
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
                    // InternalLDef.g:1324:1: ( ruleScanner_Keyword )
                    {
                    // InternalLDef.g:1324:1: ( ruleScanner_Keyword )
                    // InternalLDef.g:1325:1: ruleScanner_Keyword
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1330:6: ( ruleScanner_Rule )
                    {
                    // InternalLDef.g:1330:6: ( ruleScanner_Rule )
                    // InternalLDef.g:1331:1: ruleScanner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1341:1: rule__Scanner_Rule__Alternatives : ( ( ruleScanner_SingleLineRule ) | ( ruleScanner_MultiLineRule ) | ( ruleScanner_CharacterRule ) | ( ruleScanner_JSRule ) | ( ruleScanner_PatternRule ) );
    public final void rule__Scanner_Rule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1345:1: ( ( ruleScanner_SingleLineRule ) | ( ruleScanner_MultiLineRule ) | ( ruleScanner_CharacterRule ) | ( ruleScanner_JSRule ) | ( ruleScanner_PatternRule ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt7=1;
                }
                break;
            case 35:
                {
                alt7=2;
                }
                break;
            case 44:
                {
                alt7=3;
                }
                break;
            case 28:
                {
                alt7=4;
                }
                break;
            case 42:
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
                    // InternalLDef.g:1346:1: ( ruleScanner_SingleLineRule )
                    {
                    // InternalLDef.g:1346:1: ( ruleScanner_SingleLineRule )
                    // InternalLDef.g:1347:1: ruleScanner_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1352:6: ( ruleScanner_MultiLineRule )
                    {
                    // InternalLDef.g:1352:6: ( ruleScanner_MultiLineRule )
                    // InternalLDef.g:1353:1: ruleScanner_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1358:6: ( ruleScanner_CharacterRule )
                    {
                    // InternalLDef.g:1358:6: ( ruleScanner_CharacterRule )
                    // InternalLDef.g:1359:1: ruleScanner_CharacterRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1364:6: ( ruleScanner_JSRule )
                    {
                    // InternalLDef.g:1364:6: ( ruleScanner_JSRule )
                    // InternalLDef.g:1365:1: ruleScanner_JSRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1370:6: ( ruleScanner_PatternRule )
                    {
                    // InternalLDef.g:1370:6: ( ruleScanner_PatternRule )
                    // InternalLDef.g:1371:1: ruleScanner_PatternRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScanner_RuleAccess().getScanner_PatternRuleParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Check__Alternatives"
    // InternalLDef.g:1381:1: rule__Check__Alternatives : ( ( ruleRange ) | ( ruleEquals ) );
    public final void rule__Check__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1385:1: ( ( ruleRange ) | ( ruleEquals ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==46) ) {
                alt8=1;
            }
            else if ( (LA8_0==45) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalLDef.g:1386:1: ( ruleRange )
                    {
                    // InternalLDef.g:1386:1: ( ruleRange )
                    // InternalLDef.g:1387:1: ruleRange
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCheckAccess().getRangeParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRange();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCheckAccess().getRangeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalLDef.g:1392:6: ( ruleEquals )
                    {
                    // InternalLDef.g:1392:6: ( ruleEquals )
                    // InternalLDef.g:1393:1: ruleEquals
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCheckAccess().getEqualsParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleEquals();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCheckAccess().getEqualsParserRuleCall_1()); 
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
    // $ANTLR end "rule__Check__Alternatives"


    // $ANTLR start "rule__Range__LtInclAlternatives_1_0"
    // InternalLDef.g:1403:1: rule__Range__LtInclAlternatives_1_0 : ( ( '(' ) | ( '[' ) );
    public final void rule__Range__LtInclAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1407:1: ( ( '(' ) | ( '[' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==11) ) {
                alt9=1;
            }
            else if ( (LA9_0==12) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalLDef.g:1408:1: ( '(' )
                    {
                    // InternalLDef.g:1408:1: ( '(' )
                    // InternalLDef.g:1409:1: '('
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRangeAccess().getLtInclLeftParenthesisKeyword_1_0_0()); 
                    }
                    match(input,11,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRangeAccess().getLtInclLeftParenthesisKeyword_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalLDef.g:1416:6: ( '[' )
                    {
                    // InternalLDef.g:1416:6: ( '[' )
                    // InternalLDef.g:1417:1: '['
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRangeAccess().getLtInclLeftSquareBracketKeyword_1_0_1()); 
                    }
                    match(input,12,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRangeAccess().getLtInclLeftSquareBracketKeyword_1_0_1()); 
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
    // $ANTLR end "rule__Range__LtInclAlternatives_1_0"


    // $ANTLR start "rule__Range__GtInclAlternatives_5_0"
    // InternalLDef.g:1429:1: rule__Range__GtInclAlternatives_5_0 : ( ( ')' ) | ( ']' ) );
    public final void rule__Range__GtInclAlternatives_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1433:1: ( ( ')' ) | ( ']' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            else if ( (LA10_0==14) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalLDef.g:1434:1: ( ')' )
                    {
                    // InternalLDef.g:1434:1: ( ')' )
                    // InternalLDef.g:1435:1: ')'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRangeAccess().getGtInclRightParenthesisKeyword_5_0_0()); 
                    }
                    match(input,13,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRangeAccess().getGtInclRightParenthesisKeyword_5_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalLDef.g:1442:6: ( ']' )
                    {
                    // InternalLDef.g:1442:6: ( ']' )
                    // InternalLDef.g:1443:1: ']'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRangeAccess().getGtInclRightSquareBracketKeyword_5_0_1()); 
                    }
                    match(input,14,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRangeAccess().getGtInclRightSquareBracketKeyword_5_0_1()); 
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
    // $ANTLR end "rule__Range__GtInclAlternatives_5_0"


    // $ANTLR start "rule__WhitespaceRule__Alternatives_1"
    // InternalLDef.g:1455:1: rule__WhitespaceRule__Alternatives_1 : ( ( ( rule__WhitespaceRule__Group_1_0__0 ) ) | ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) ) | ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) ) );
    public final void rule__WhitespaceRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1459:1: ( ( ( rule__WhitespaceRule__Group_1_0__0 ) ) | ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) ) | ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt11=1;
                }
                break;
            case 51:
                {
                alt11=2;
                }
                break;
            case RULE_STRING:
                {
                alt11=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalLDef.g:1460:1: ( ( rule__WhitespaceRule__Group_1_0__0 ) )
                    {
                    // InternalLDef.g:1460:1: ( ( rule__WhitespaceRule__Group_1_0__0 ) )
                    // InternalLDef.g:1461:1: ( rule__WhitespaceRule__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getGroup_1_0()); 
                    }
                    // InternalLDef.g:1462:1: ( rule__WhitespaceRule__Group_1_0__0 )
                    // InternalLDef.g:1462:2: rule__WhitespaceRule__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1466:6: ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) )
                    {
                    // InternalLDef.g:1466:6: ( ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 ) )
                    // InternalLDef.g:1467:1: ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceAssignment_1_1()); 
                    }
                    // InternalLDef.g:1468:1: ( rule__WhitespaceRule__JavawhitespaceAssignment_1_1 )
                    // InternalLDef.g:1468:2: rule__WhitespaceRule__JavawhitespaceAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
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
                    // InternalLDef.g:1472:6: ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) )
                    {
                    // InternalLDef.g:1472:6: ( ( rule__WhitespaceRule__FileURIAssignment_1_2 ) )
                    // InternalLDef.g:1473:1: ( rule__WhitespaceRule__FileURIAssignment_1_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWhitespaceRuleAccess().getFileURIAssignment_1_2()); 
                    }
                    // InternalLDef.g:1474:1: ( rule__WhitespaceRule__FileURIAssignment_1_2 )
                    // InternalLDef.g:1474:2: rule__WhitespaceRule__FileURIAssignment_1_2
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1485:1: rule__Root__Group__0 : rule__Root__Group__0__Impl rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1489:1: ( rule__Root__Group__0__Impl rule__Root__Group__1 )
            // InternalLDef.g:1490:2: rule__Root__Group__0__Impl rule__Root__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Root__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1497:1: rule__Root__Group__0__Impl : ( 'package' ) ;
    public final void rule__Root__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1501:1: ( ( 'package' ) )
            // InternalLDef.g:1502:1: ( 'package' )
            {
            // InternalLDef.g:1502:1: ( 'package' )
            // InternalLDef.g:1503:1: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getPackageKeyword_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:1516:1: rule__Root__Group__1 : rule__Root__Group__1__Impl rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1520:1: ( rule__Root__Group__1__Impl rule__Root__Group__2 )
            // InternalLDef.g:1521:2: rule__Root__Group__1__Impl rule__Root__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Root__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1528:1: rule__Root__Group__1__Impl : ( ( rule__Root__NameAssignment_1 ) ) ;
    public final void rule__Root__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1532:1: ( ( ( rule__Root__NameAssignment_1 ) ) )
            // InternalLDef.g:1533:1: ( ( rule__Root__NameAssignment_1 ) )
            {
            // InternalLDef.g:1533:1: ( ( rule__Root__NameAssignment_1 ) )
            // InternalLDef.g:1534:1: ( rule__Root__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameAssignment_1()); 
            }
            // InternalLDef.g:1535:1: ( rule__Root__NameAssignment_1 )
            // InternalLDef.g:1535:2: rule__Root__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1545:1: rule__Root__Group__2 : rule__Root__Group__2__Impl rule__Root__Group__3 ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1549:1: ( rule__Root__Group__2__Impl rule__Root__Group__3 )
            // InternalLDef.g:1550:2: rule__Root__Group__2__Impl rule__Root__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Root__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1557:1: rule__Root__Group__2__Impl : ( ( rule__Root__ImportsAssignment_2 )* ) ;
    public final void rule__Root__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1561:1: ( ( ( rule__Root__ImportsAssignment_2 )* ) )
            // InternalLDef.g:1562:1: ( ( rule__Root__ImportsAssignment_2 )* )
            {
            // InternalLDef.g:1562:1: ( ( rule__Root__ImportsAssignment_2 )* )
            // InternalLDef.g:1563:1: ( rule__Root__ImportsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getImportsAssignment_2()); 
            }
            // InternalLDef.g:1564:1: ( rule__Root__ImportsAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==18) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalLDef.g:1564:2: rule__Root__ImportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Root__ImportsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // InternalLDef.g:1574:1: rule__Root__Group__3 : rule__Root__Group__3__Impl ;
    public final void rule__Root__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1578:1: ( rule__Root__Group__3__Impl )
            // InternalLDef.g:1579:2: rule__Root__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1585:1: rule__Root__Group__3__Impl : ( ( rule__Root__LanguageDefinitionAssignment_3 ) ) ;
    public final void rule__Root__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1589:1: ( ( ( rule__Root__LanguageDefinitionAssignment_3 ) ) )
            // InternalLDef.g:1590:1: ( ( rule__Root__LanguageDefinitionAssignment_3 ) )
            {
            // InternalLDef.g:1590:1: ( ( rule__Root__LanguageDefinitionAssignment_3 ) )
            // InternalLDef.g:1591:1: ( rule__Root__LanguageDefinitionAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLanguageDefinitionAssignment_3()); 
            }
            // InternalLDef.g:1592:1: ( rule__Root__LanguageDefinitionAssignment_3 )
            // InternalLDef.g:1592:2: rule__Root__LanguageDefinitionAssignment_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1610:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1614:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalLDef.g:1615:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1622:1: rule__QualifiedName__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1626:1: ( ( ruleValidID ) )
            // InternalLDef.g:1627:1: ( ruleValidID )
            {
            // InternalLDef.g:1627:1: ( ruleValidID )
            // InternalLDef.g:1628:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1639:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1643:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalLDef.g:1644:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1650:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1654:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalLDef.g:1655:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalLDef.g:1655:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalLDef.g:1656:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalLDef.g:1657:1: ( rule__QualifiedName__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==16) ) {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2==RULE_ID) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // InternalLDef.g:1657:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalLDef.g:1671:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1675:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalLDef.g:1676:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1683:1: rule__QualifiedName__Group_1__0__Impl : ( ( '.' ) ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1687:1: ( ( ( '.' ) ) )
            // InternalLDef.g:1688:1: ( ( '.' ) )
            {
            // InternalLDef.g:1688:1: ( ( '.' ) )
            // InternalLDef.g:1689:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            // InternalLDef.g:1690:1: ( '.' )
            // InternalLDef.g:1691:2: '.'
            {
            match(input,16,FOLLOW_2); if (state.failed) return ;

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
    // InternalLDef.g:1702:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1706:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalLDef.g:1707:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1713:1: rule__QualifiedName__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1717:1: ( ( ruleValidID ) )
            // InternalLDef.g:1718:1: ( ruleValidID )
            {
            // InternalLDef.g:1718:1: ( ruleValidID )
            // InternalLDef.g:1719:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1734:1: rule__QualifiedNameWithWildCard__Group__0 : rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 ;
    public final void rule__QualifiedNameWithWildCard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1738:1: ( rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 )
            // InternalLDef.g:1739:2: rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__QualifiedNameWithWildCard__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1746:1: rule__QualifiedNameWithWildCard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildCard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1750:1: ( ( ruleQualifiedName ) )
            // InternalLDef.g:1751:1: ( ruleQualifiedName )
            {
            // InternalLDef.g:1751:1: ( ruleQualifiedName )
            // InternalLDef.g:1752:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1763:1: rule__QualifiedNameWithWildCard__Group__1 : rule__QualifiedNameWithWildCard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1767:1: ( rule__QualifiedNameWithWildCard__Group__1__Impl )
            // InternalLDef.g:1768:2: rule__QualifiedNameWithWildCard__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1774:1: rule__QualifiedNameWithWildCard__Group__1__Impl : ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? ) ;
    public final void rule__QualifiedNameWithWildCard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1778:1: ( ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? ) )
            // InternalLDef.g:1779:1: ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? )
            {
            // InternalLDef.g:1779:1: ( ( rule__QualifiedNameWithWildCard__Group_1__0 )? )
            // InternalLDef.g:1780:1: ( rule__QualifiedNameWithWildCard__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup_1()); 
            }
            // InternalLDef.g:1781:1: ( rule__QualifiedNameWithWildCard__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==16) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalLDef.g:1781:2: rule__QualifiedNameWithWildCard__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1795:1: rule__QualifiedNameWithWildCard__Group_1__0 : rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1 ;
    public final void rule__QualifiedNameWithWildCard__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1799:1: ( rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1 )
            // InternalLDef.g:1800:2: rule__QualifiedNameWithWildCard__Group_1__0__Impl rule__QualifiedNameWithWildCard__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__QualifiedNameWithWildCard__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1807:1: rule__QualifiedNameWithWildCard__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedNameWithWildCard__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1811:1: ( ( '.' ) )
            // InternalLDef.g:1812:1: ( '.' )
            {
            // InternalLDef.g:1812:1: ( '.' )
            // InternalLDef.g:1813:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
            }
            match(input,16,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:1826:1: rule__QualifiedNameWithWildCard__Group_1__1 : rule__QualifiedNameWithWildCard__Group_1__1__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1830:1: ( rule__QualifiedNameWithWildCard__Group_1__1__Impl )
            // InternalLDef.g:1831:2: rule__QualifiedNameWithWildCard__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1837:1: rule__QualifiedNameWithWildCard__Group_1__1__Impl : ( '*' ) ;
    public final void rule__QualifiedNameWithWildCard__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1841:1: ( ( '*' ) )
            // InternalLDef.g:1842:1: ( '*' )
            {
            // InternalLDef.g:1842:1: ( '*' )
            // InternalLDef.g:1843:1: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:1860:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1864:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalLDef.g:1865:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Import__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1872:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1876:1: ( ( 'import' ) )
            // InternalLDef.g:1877:1: ( 'import' )
            {
            // InternalLDef.g:1877:1: ( 'import' )
            // InternalLDef.g:1878:1: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:1891:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1895:1: ( rule__Import__Group__1__Impl )
            // InternalLDef.g:1896:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1902:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1906:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalLDef.g:1907:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalLDef.g:1907:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalLDef.g:1908:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            }
            // InternalLDef.g:1909:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalLDef.g:1909:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1923:1: rule__LanguageDef__Group__0 : rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1 ;
    public final void rule__LanguageDef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1927:1: ( rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1 )
            // InternalLDef.g:1928:2: rule__LanguageDef__Group__0__Impl rule__LanguageDef__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__LanguageDef__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1935:1: rule__LanguageDef__Group__0__Impl : ( ( rule__LanguageDef__NameAssignment_0 ) ) ;
    public final void rule__LanguageDef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1939:1: ( ( ( rule__LanguageDef__NameAssignment_0 ) ) )
            // InternalLDef.g:1940:1: ( ( rule__LanguageDef__NameAssignment_0 ) )
            {
            // InternalLDef.g:1940:1: ( ( rule__LanguageDef__NameAssignment_0 ) )
            // InternalLDef.g:1941:1: ( rule__LanguageDef__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getNameAssignment_0()); 
            }
            // InternalLDef.g:1942:1: ( rule__LanguageDef__NameAssignment_0 )
            // InternalLDef.g:1942:2: rule__LanguageDef__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1952:1: rule__LanguageDef__Group__1 : rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2 ;
    public final void rule__LanguageDef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1956:1: ( rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2 )
            // InternalLDef.g:1957:2: rule__LanguageDef__Group__1__Impl rule__LanguageDef__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__LanguageDef__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1964:1: rule__LanguageDef__Group__1__Impl : ( '{' ) ;
    public final void rule__LanguageDef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1968:1: ( ( '{' ) )
            // InternalLDef.g:1969:1: ( '{' )
            {
            // InternalLDef.g:1969:1: ( '{' )
            // InternalLDef.g:1970:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:1983:1: rule__LanguageDef__Group__2 : rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3 ;
    public final void rule__LanguageDef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1987:1: ( rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3 )
            // InternalLDef.g:1988:2: rule__LanguageDef__Group__2__Impl rule__LanguageDef__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__LanguageDef__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:1995:1: rule__LanguageDef__Group__2__Impl : ( ( rule__LanguageDef__ParitioningAssignment_2 ) ) ;
    public final void rule__LanguageDef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:1999:1: ( ( ( rule__LanguageDef__ParitioningAssignment_2 ) ) )
            // InternalLDef.g:2000:1: ( ( rule__LanguageDef__ParitioningAssignment_2 ) )
            {
            // InternalLDef.g:2000:1: ( ( rule__LanguageDef__ParitioningAssignment_2 ) )
            // InternalLDef.g:2001:1: ( rule__LanguageDef__ParitioningAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getParitioningAssignment_2()); 
            }
            // InternalLDef.g:2002:1: ( rule__LanguageDef__ParitioningAssignment_2 )
            // InternalLDef.g:2002:2: rule__LanguageDef__ParitioningAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2012:1: rule__LanguageDef__Group__3 : rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4 ;
    public final void rule__LanguageDef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2016:1: ( rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4 )
            // InternalLDef.g:2017:2: rule__LanguageDef__Group__3__Impl rule__LanguageDef__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__LanguageDef__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2024:1: rule__LanguageDef__Group__3__Impl : ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) ) ;
    public final void rule__LanguageDef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2028:1: ( ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) ) )
            // InternalLDef.g:2029:1: ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) )
            {
            // InternalLDef.g:2029:1: ( ( rule__LanguageDef__LexicalHighlightingAssignment_3 ) )
            // InternalLDef.g:2030:1: ( rule__LanguageDef__LexicalHighlightingAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLexicalHighlightingAssignment_3()); 
            }
            // InternalLDef.g:2031:1: ( rule__LanguageDef__LexicalHighlightingAssignment_3 )
            // InternalLDef.g:2031:2: rule__LanguageDef__LexicalHighlightingAssignment_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2041:1: rule__LanguageDef__Group__4 : rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5 ;
    public final void rule__LanguageDef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2045:1: ( rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5 )
            // InternalLDef.g:2046:2: rule__LanguageDef__Group__4__Impl rule__LanguageDef__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__LanguageDef__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2053:1: rule__LanguageDef__Group__4__Impl : ( ( rule__LanguageDef__IntegrationAssignment_4 )? ) ;
    public final void rule__LanguageDef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2057:1: ( ( ( rule__LanguageDef__IntegrationAssignment_4 )? ) )
            // InternalLDef.g:2058:1: ( ( rule__LanguageDef__IntegrationAssignment_4 )? )
            {
            // InternalLDef.g:2058:1: ( ( rule__LanguageDef__IntegrationAssignment_4 )? )
            // InternalLDef.g:2059:1: ( rule__LanguageDef__IntegrationAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getIntegrationAssignment_4()); 
            }
            // InternalLDef.g:2060:1: ( rule__LanguageDef__IntegrationAssignment_4 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==21) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalLDef.g:2060:2: rule__LanguageDef__IntegrationAssignment_4
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2070:1: rule__LanguageDef__Group__5 : rule__LanguageDef__Group__5__Impl ;
    public final void rule__LanguageDef__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2074:1: ( rule__LanguageDef__Group__5__Impl )
            // InternalLDef.g:2075:2: rule__LanguageDef__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2081:1: rule__LanguageDef__Group__5__Impl : ( '}' ) ;
    public final void rule__LanguageDef__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2085:1: ( ( '}' ) )
            // InternalLDef.g:2086:1: ( '}' )
            {
            // InternalLDef.g:2086:1: ( '}' )
            // InternalLDef.g:2087:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2112:1: rule__Integration__Group__0 : rule__Integration__Group__0__Impl rule__Integration__Group__1 ;
    public final void rule__Integration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2116:1: ( rule__Integration__Group__0__Impl rule__Integration__Group__1 )
            // InternalLDef.g:2117:2: rule__Integration__Group__0__Impl rule__Integration__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Integration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2124:1: rule__Integration__Group__0__Impl : ( 'integration' ) ;
    public final void rule__Integration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2128:1: ( ( 'integration' ) )
            // InternalLDef.g:2129:1: ( 'integration' )
            {
            // InternalLDef.g:2129:1: ( 'integration' )
            // InternalLDef.g:2130:1: 'integration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getIntegrationKeyword_0()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2143:1: rule__Integration__Group__1 : rule__Integration__Group__1__Impl rule__Integration__Group__2 ;
    public final void rule__Integration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2147:1: ( rule__Integration__Group__1__Impl rule__Integration__Group__2 )
            // InternalLDef.g:2148:2: rule__Integration__Group__1__Impl rule__Integration__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__Integration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2155:1: rule__Integration__Group__1__Impl : ( '{' ) ;
    public final void rule__Integration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2159:1: ( ( '{' ) )
            // InternalLDef.g:2160:1: ( '{' )
            {
            // InternalLDef.g:2160:1: ( '{' )
            // InternalLDef.g:2161:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2174:1: rule__Integration__Group__2 : rule__Integration__Group__2__Impl rule__Integration__Group__3 ;
    public final void rule__Integration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2178:1: ( rule__Integration__Group__2__Impl rule__Integration__Group__3 )
            // InternalLDef.g:2179:2: rule__Integration__Group__2__Impl rule__Integration__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__Integration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2186:1: rule__Integration__Group__2__Impl : ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) ) ;
    public final void rule__Integration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2190:1: ( ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) ) )
            // InternalLDef.g:2191:1: ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) )
            {
            // InternalLDef.g:2191:1: ( ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* ) )
            // InternalLDef.g:2192:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 ) ) ( ( rule__Integration__CodeIntegrationListAssignment_2 )* )
            {
            // InternalLDef.g:2192:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 ) )
            // InternalLDef.g:2193:1: ( rule__Integration__CodeIntegrationListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }
            // InternalLDef.g:2194:1: ( rule__Integration__CodeIntegrationListAssignment_2 )
            // InternalLDef.g:2194:2: rule__Integration__CodeIntegrationListAssignment_2
            {
            pushFollow(FOLLOW_15);
            rule__Integration__CodeIntegrationListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }

            }

            // InternalLDef.g:2197:1: ( ( rule__Integration__CodeIntegrationListAssignment_2 )* )
            // InternalLDef.g:2198:1: ( rule__Integration__CodeIntegrationListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListAssignment_2()); 
            }
            // InternalLDef.g:2199:1: ( rule__Integration__CodeIntegrationListAssignment_2 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==22) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalLDef.g:2199:2: rule__Integration__CodeIntegrationListAssignment_2
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Integration__CodeIntegrationListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalLDef.g:2210:1: rule__Integration__Group__3 : rule__Integration__Group__3__Impl ;
    public final void rule__Integration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2214:1: ( rule__Integration__Group__3__Impl )
            // InternalLDef.g:2215:2: rule__Integration__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2221:1: rule__Integration__Group__3__Impl : ( '}' ) ;
    public final void rule__Integration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2225:1: ( ( '}' ) )
            // InternalLDef.g:2226:1: ( '}' )
            {
            // InternalLDef.g:2226:1: ( '}' )
            // InternalLDef.g:2227:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2248:1: rule__JavaFXIntegration__Group__0 : rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1 ;
    public final void rule__JavaFXIntegration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2252:1: ( rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1 )
            // InternalLDef.g:2253:2: rule__JavaFXIntegration__Group__0__Impl rule__JavaFXIntegration__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__JavaFXIntegration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2260:1: rule__JavaFXIntegration__Group__0__Impl : ( 'javafx' ) ;
    public final void rule__JavaFXIntegration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2264:1: ( ( 'javafx' ) )
            // InternalLDef.g:2265:1: ( 'javafx' )
            {
            // InternalLDef.g:2265:1: ( 'javafx' )
            // InternalLDef.g:2266:1: 'javafx'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getJavafxKeyword_0()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2279:1: rule__JavaFXIntegration__Group__1 : rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2 ;
    public final void rule__JavaFXIntegration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2283:1: ( rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2 )
            // InternalLDef.g:2284:2: rule__JavaFXIntegration__Group__1__Impl rule__JavaFXIntegration__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__JavaFXIntegration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2291:1: rule__JavaFXIntegration__Group__1__Impl : ( '{' ) ;
    public final void rule__JavaFXIntegration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2295:1: ( ( '{' ) )
            // InternalLDef.g:2296:1: ( '{' )
            {
            // InternalLDef.g:2296:1: ( '{' )
            // InternalLDef.g:2297:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2310:1: rule__JavaFXIntegration__Group__2 : rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3 ;
    public final void rule__JavaFXIntegration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2314:1: ( rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3 )
            // InternalLDef.g:2315:2: rule__JavaFXIntegration__Group__2__Impl rule__JavaFXIntegration__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__JavaFXIntegration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2322:1: rule__JavaFXIntegration__Group__2__Impl : ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) ) ;
    public final void rule__JavaFXIntegration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2326:1: ( ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) ) )
            // InternalLDef.g:2327:1: ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) )
            {
            // InternalLDef.g:2327:1: ( ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* ) )
            // InternalLDef.g:2328:1: ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) ) ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* )
            {
            // InternalLDef.g:2328:1: ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 ) )
            // InternalLDef.g:2329:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListAssignment_2()); 
            }
            // InternalLDef.g:2330:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )
            // InternalLDef.g:2330:2: rule__JavaFXIntegration__CodegenerationListAssignment_2
            {
            pushFollow(FOLLOW_17);
            rule__JavaFXIntegration__CodegenerationListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListAssignment_2()); 
            }

            }

            // InternalLDef.g:2333:1: ( ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )* )
            // InternalLDef.g:2334:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListAssignment_2()); 
            }
            // InternalLDef.g:2335:1: ( rule__JavaFXIntegration__CodegenerationListAssignment_2 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=23 && LA17_0<=24)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalLDef.g:2335:2: rule__JavaFXIntegration__CodegenerationListAssignment_2
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__JavaFXIntegration__CodegenerationListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalLDef.g:2346:1: rule__JavaFXIntegration__Group__3 : rule__JavaFXIntegration__Group__3__Impl ;
    public final void rule__JavaFXIntegration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2350:1: ( rule__JavaFXIntegration__Group__3__Impl )
            // InternalLDef.g:2351:2: rule__JavaFXIntegration__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2357:1: rule__JavaFXIntegration__Group__3__Impl : ( '}' ) ;
    public final void rule__JavaFXIntegration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2361:1: ( ( '}' ) )
            // InternalLDef.g:2362:1: ( '}' )
            {
            // InternalLDef.g:2362:1: ( '}' )
            // InternalLDef.g:2363:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2384:1: rule__JavaCodeGeneration__Group__0 : rule__JavaCodeGeneration__Group__0__Impl rule__JavaCodeGeneration__Group__1 ;
    public final void rule__JavaCodeGeneration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2388:1: ( rule__JavaCodeGeneration__Group__0__Impl rule__JavaCodeGeneration__Group__1 )
            // InternalLDef.g:2389:2: rule__JavaCodeGeneration__Group__0__Impl rule__JavaCodeGeneration__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__JavaCodeGeneration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2396:1: rule__JavaCodeGeneration__Group__0__Impl : ( 'java' ) ;
    public final void rule__JavaCodeGeneration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2400:1: ( ( 'java' ) )
            // InternalLDef.g:2401:1: ( 'java' )
            {
            // InternalLDef.g:2401:1: ( 'java' )
            // InternalLDef.g:2402:1: 'java'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getJavaKeyword_0()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2415:1: rule__JavaCodeGeneration__Group__1 : rule__JavaCodeGeneration__Group__1__Impl rule__JavaCodeGeneration__Group__2 ;
    public final void rule__JavaCodeGeneration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2419:1: ( rule__JavaCodeGeneration__Group__1__Impl rule__JavaCodeGeneration__Group__2 )
            // InternalLDef.g:2420:2: rule__JavaCodeGeneration__Group__1__Impl rule__JavaCodeGeneration__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__JavaCodeGeneration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2427:1: rule__JavaCodeGeneration__Group__1__Impl : ( ( rule__JavaCodeGeneration__NameAssignment_1 ) ) ;
    public final void rule__JavaCodeGeneration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2431:1: ( ( ( rule__JavaCodeGeneration__NameAssignment_1 ) ) )
            // InternalLDef.g:2432:1: ( ( rule__JavaCodeGeneration__NameAssignment_1 ) )
            {
            // InternalLDef.g:2432:1: ( ( rule__JavaCodeGeneration__NameAssignment_1 ) )
            // InternalLDef.g:2433:1: ( rule__JavaCodeGeneration__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getNameAssignment_1()); 
            }
            // InternalLDef.g:2434:1: ( rule__JavaCodeGeneration__NameAssignment_1 )
            // InternalLDef.g:2434:2: rule__JavaCodeGeneration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2444:1: rule__JavaCodeGeneration__Group__2 : rule__JavaCodeGeneration__Group__2__Impl ;
    public final void rule__JavaCodeGeneration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2448:1: ( rule__JavaCodeGeneration__Group__2__Impl )
            // InternalLDef.g:2449:2: rule__JavaCodeGeneration__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2455:1: rule__JavaCodeGeneration__Group__2__Impl : ( ( rule__JavaCodeGeneration__Group_2__0 )? ) ;
    public final void rule__JavaCodeGeneration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2459:1: ( ( ( rule__JavaCodeGeneration__Group_2__0 )? ) )
            // InternalLDef.g:2460:1: ( ( rule__JavaCodeGeneration__Group_2__0 )? )
            {
            // InternalLDef.g:2460:1: ( ( rule__JavaCodeGeneration__Group_2__0 )? )
            // InternalLDef.g:2461:1: ( rule__JavaCodeGeneration__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getGroup_2()); 
            }
            // InternalLDef.g:2462:1: ( rule__JavaCodeGeneration__Group_2__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalLDef.g:2462:2: rule__JavaCodeGeneration__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2478:1: rule__JavaCodeGeneration__Group_2__0 : rule__JavaCodeGeneration__Group_2__0__Impl rule__JavaCodeGeneration__Group_2__1 ;
    public final void rule__JavaCodeGeneration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2482:1: ( rule__JavaCodeGeneration__Group_2__0__Impl rule__JavaCodeGeneration__Group_2__1 )
            // InternalLDef.g:2483:2: rule__JavaCodeGeneration__Group_2__0__Impl rule__JavaCodeGeneration__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__JavaCodeGeneration__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2490:1: rule__JavaCodeGeneration__Group_2__0__Impl : ( '{' ) ;
    public final void rule__JavaCodeGeneration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2494:1: ( ( '{' ) )
            // InternalLDef.g:2495:1: ( '{' )
            {
            // InternalLDef.g:2495:1: ( '{' )
            // InternalLDef.g:2496:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2509:1: rule__JavaCodeGeneration__Group_2__1 : rule__JavaCodeGeneration__Group_2__1__Impl rule__JavaCodeGeneration__Group_2__2 ;
    public final void rule__JavaCodeGeneration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2513:1: ( rule__JavaCodeGeneration__Group_2__1__Impl rule__JavaCodeGeneration__Group_2__2 )
            // InternalLDef.g:2514:2: rule__JavaCodeGeneration__Group_2__1__Impl rule__JavaCodeGeneration__Group_2__2
            {
            pushFollow(FOLLOW_14);
            rule__JavaCodeGeneration__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2521:1: rule__JavaCodeGeneration__Group_2__1__Impl : ( ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* ) ) ;
    public final void rule__JavaCodeGeneration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2525:1: ( ( ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* ) ) )
            // InternalLDef.g:2526:1: ( ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* ) )
            {
            // InternalLDef.g:2526:1: ( ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* ) )
            // InternalLDef.g:2527:1: ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* )
            {
            // InternalLDef.g:2527:1: ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 ) )
            // InternalLDef.g:2528:1: ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }
            // InternalLDef.g:2529:1: ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )
            // InternalLDef.g:2529:2: rule__JavaCodeGeneration__ConfigValueAssignment_2_1
            {
            pushFollow(FOLLOW_19);
            rule__JavaCodeGeneration__ConfigValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJavaCodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }

            }

            // InternalLDef.g:2532:1: ( ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )* )
            // InternalLDef.g:2533:1: ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }
            // InternalLDef.g:2534:1: ( rule__JavaCodeGeneration__ConfigValueAssignment_2_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalLDef.g:2534:2: rule__JavaCodeGeneration__ConfigValueAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__JavaCodeGeneration__ConfigValueAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalLDef.g:2545:1: rule__JavaCodeGeneration__Group_2__2 : rule__JavaCodeGeneration__Group_2__2__Impl ;
    public final void rule__JavaCodeGeneration__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2549:1: ( rule__JavaCodeGeneration__Group_2__2__Impl )
            // InternalLDef.g:2550:2: rule__JavaCodeGeneration__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2556:1: rule__JavaCodeGeneration__Group_2__2__Impl : ( '}' ) ;
    public final void rule__JavaCodeGeneration__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2560:1: ( ( '}' ) )
            // InternalLDef.g:2561:1: ( '}' )
            {
            // InternalLDef.g:2561:1: ( '}' )
            // InternalLDef.g:2562:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2581:1: rule__E4CodeGeneration__Group__0 : rule__E4CodeGeneration__Group__0__Impl rule__E4CodeGeneration__Group__1 ;
    public final void rule__E4CodeGeneration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2585:1: ( rule__E4CodeGeneration__Group__0__Impl rule__E4CodeGeneration__Group__1 )
            // InternalLDef.g:2586:2: rule__E4CodeGeneration__Group__0__Impl rule__E4CodeGeneration__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__E4CodeGeneration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2593:1: rule__E4CodeGeneration__Group__0__Impl : ( 'e4' ) ;
    public final void rule__E4CodeGeneration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2597:1: ( ( 'e4' ) )
            // InternalLDef.g:2598:1: ( 'e4' )
            {
            // InternalLDef.g:2598:1: ( 'e4' )
            // InternalLDef.g:2599:1: 'e4'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getE4Keyword_0()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2612:1: rule__E4CodeGeneration__Group__1 : rule__E4CodeGeneration__Group__1__Impl rule__E4CodeGeneration__Group__2 ;
    public final void rule__E4CodeGeneration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2616:1: ( rule__E4CodeGeneration__Group__1__Impl rule__E4CodeGeneration__Group__2 )
            // InternalLDef.g:2617:2: rule__E4CodeGeneration__Group__1__Impl rule__E4CodeGeneration__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__E4CodeGeneration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2624:1: rule__E4CodeGeneration__Group__1__Impl : ( ( rule__E4CodeGeneration__NameAssignment_1 ) ) ;
    public final void rule__E4CodeGeneration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2628:1: ( ( ( rule__E4CodeGeneration__NameAssignment_1 ) ) )
            // InternalLDef.g:2629:1: ( ( rule__E4CodeGeneration__NameAssignment_1 ) )
            {
            // InternalLDef.g:2629:1: ( ( rule__E4CodeGeneration__NameAssignment_1 ) )
            // InternalLDef.g:2630:1: ( rule__E4CodeGeneration__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getNameAssignment_1()); 
            }
            // InternalLDef.g:2631:1: ( rule__E4CodeGeneration__NameAssignment_1 )
            // InternalLDef.g:2631:2: rule__E4CodeGeneration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2641:1: rule__E4CodeGeneration__Group__2 : rule__E4CodeGeneration__Group__2__Impl ;
    public final void rule__E4CodeGeneration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2645:1: ( rule__E4CodeGeneration__Group__2__Impl )
            // InternalLDef.g:2646:2: rule__E4CodeGeneration__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2652:1: rule__E4CodeGeneration__Group__2__Impl : ( ( rule__E4CodeGeneration__Group_2__0 )? ) ;
    public final void rule__E4CodeGeneration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2656:1: ( ( ( rule__E4CodeGeneration__Group_2__0 )? ) )
            // InternalLDef.g:2657:1: ( ( rule__E4CodeGeneration__Group_2__0 )? )
            {
            // InternalLDef.g:2657:1: ( ( rule__E4CodeGeneration__Group_2__0 )? )
            // InternalLDef.g:2658:1: ( rule__E4CodeGeneration__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getGroup_2()); 
            }
            // InternalLDef.g:2659:1: ( rule__E4CodeGeneration__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==19) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalLDef.g:2659:2: rule__E4CodeGeneration__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2675:1: rule__E4CodeGeneration__Group_2__0 : rule__E4CodeGeneration__Group_2__0__Impl rule__E4CodeGeneration__Group_2__1 ;
    public final void rule__E4CodeGeneration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2679:1: ( rule__E4CodeGeneration__Group_2__0__Impl rule__E4CodeGeneration__Group_2__1 )
            // InternalLDef.g:2680:2: rule__E4CodeGeneration__Group_2__0__Impl rule__E4CodeGeneration__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__E4CodeGeneration__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2687:1: rule__E4CodeGeneration__Group_2__0__Impl : ( '{' ) ;
    public final void rule__E4CodeGeneration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2691:1: ( ( '{' ) )
            // InternalLDef.g:2692:1: ( '{' )
            {
            // InternalLDef.g:2692:1: ( '{' )
            // InternalLDef.g:2693:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2706:1: rule__E4CodeGeneration__Group_2__1 : rule__E4CodeGeneration__Group_2__1__Impl rule__E4CodeGeneration__Group_2__2 ;
    public final void rule__E4CodeGeneration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2710:1: ( rule__E4CodeGeneration__Group_2__1__Impl rule__E4CodeGeneration__Group_2__2 )
            // InternalLDef.g:2711:2: rule__E4CodeGeneration__Group_2__1__Impl rule__E4CodeGeneration__Group_2__2
            {
            pushFollow(FOLLOW_14);
            rule__E4CodeGeneration__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2718:1: rule__E4CodeGeneration__Group_2__1__Impl : ( ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* ) ) ;
    public final void rule__E4CodeGeneration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2722:1: ( ( ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* ) ) )
            // InternalLDef.g:2723:1: ( ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* ) )
            {
            // InternalLDef.g:2723:1: ( ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* ) )
            // InternalLDef.g:2724:1: ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) ) ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* )
            {
            // InternalLDef.g:2724:1: ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 ) )
            // InternalLDef.g:2725:1: ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }
            // InternalLDef.g:2726:1: ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )
            // InternalLDef.g:2726:2: rule__E4CodeGeneration__ConfigValueAssignment_2_1
            {
            pushFollow(FOLLOW_19);
            rule__E4CodeGeneration__ConfigValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getE4CodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }

            }

            // InternalLDef.g:2729:1: ( ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )* )
            // InternalLDef.g:2730:1: ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getConfigValueAssignment_2_1()); 
            }
            // InternalLDef.g:2731:1: ( rule__E4CodeGeneration__ConfigValueAssignment_2_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalLDef.g:2731:2: rule__E4CodeGeneration__ConfigValueAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__E4CodeGeneration__ConfigValueAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalLDef.g:2742:1: rule__E4CodeGeneration__Group_2__2 : rule__E4CodeGeneration__Group_2__2__Impl ;
    public final void rule__E4CodeGeneration__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2746:1: ( rule__E4CodeGeneration__Group_2__2__Impl )
            // InternalLDef.g:2747:2: rule__E4CodeGeneration__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2753:1: rule__E4CodeGeneration__Group_2__2__Impl : ( '}' ) ;
    public final void rule__E4CodeGeneration__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2757:1: ( ( '}' ) )
            // InternalLDef.g:2758:1: ( '}' )
            {
            // InternalLDef.g:2758:1: ( '}' )
            // InternalLDef.g:2759:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2778:1: rule__ConfigValue__Group__0 : rule__ConfigValue__Group__0__Impl rule__ConfigValue__Group__1 ;
    public final void rule__ConfigValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2782:1: ( rule__ConfigValue__Group__0__Impl rule__ConfigValue__Group__1 )
            // InternalLDef.g:2783:2: rule__ConfigValue__Group__0__Impl rule__ConfigValue__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__ConfigValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2790:1: rule__ConfigValue__Group__0__Impl : ( ( rule__ConfigValue__KeyAssignment_0 ) ) ;
    public final void rule__ConfigValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2794:1: ( ( ( rule__ConfigValue__KeyAssignment_0 ) ) )
            // InternalLDef.g:2795:1: ( ( rule__ConfigValue__KeyAssignment_0 ) )
            {
            // InternalLDef.g:2795:1: ( ( rule__ConfigValue__KeyAssignment_0 ) )
            // InternalLDef.g:2796:1: ( rule__ConfigValue__KeyAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getKeyAssignment_0()); 
            }
            // InternalLDef.g:2797:1: ( rule__ConfigValue__KeyAssignment_0 )
            // InternalLDef.g:2797:2: rule__ConfigValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2807:1: rule__ConfigValue__Group__1 : rule__ConfigValue__Group__1__Impl rule__ConfigValue__Group__2 ;
    public final void rule__ConfigValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2811:1: ( rule__ConfigValue__Group__1__Impl rule__ConfigValue__Group__2 )
            // InternalLDef.g:2812:2: rule__ConfigValue__Group__1__Impl rule__ConfigValue__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__ConfigValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2819:1: rule__ConfigValue__Group__1__Impl : ( ':' ) ;
    public final void rule__ConfigValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2823:1: ( ( ':' ) )
            // InternalLDef.g:2824:1: ( ':' )
            {
            // InternalLDef.g:2824:1: ( ':' )
            // InternalLDef.g:2825:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getColonKeyword_1()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2838:1: rule__ConfigValue__Group__2 : rule__ConfigValue__Group__2__Impl ;
    public final void rule__ConfigValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2842:1: ( rule__ConfigValue__Group__2__Impl )
            // InternalLDef.g:2843:2: rule__ConfigValue__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2849:1: rule__ConfigValue__Group__2__Impl : ( ( rule__ConfigValue__Alternatives_2 ) ) ;
    public final void rule__ConfigValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2853:1: ( ( ( rule__ConfigValue__Alternatives_2 ) ) )
            // InternalLDef.g:2854:1: ( ( rule__ConfigValue__Alternatives_2 ) )
            {
            // InternalLDef.g:2854:1: ( ( rule__ConfigValue__Alternatives_2 ) )
            // InternalLDef.g:2855:1: ( rule__ConfigValue__Alternatives_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getAlternatives_2()); 
            }
            // InternalLDef.g:2856:1: ( rule__ConfigValue__Alternatives_2 )
            // InternalLDef.g:2856:2: rule__ConfigValue__Alternatives_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2872:1: rule__ConfigValue__Group_2_1__0 : rule__ConfigValue__Group_2_1__0__Impl rule__ConfigValue__Group_2_1__1 ;
    public final void rule__ConfigValue__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2876:1: ( rule__ConfigValue__Group_2_1__0__Impl rule__ConfigValue__Group_2_1__1 )
            // InternalLDef.g:2877:2: rule__ConfigValue__Group_2_1__0__Impl rule__ConfigValue__Group_2_1__1
            {
            pushFollow(FOLLOW_3);
            rule__ConfigValue__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2884:1: rule__ConfigValue__Group_2_1__0__Impl : ( '{' ) ;
    public final void rule__ConfigValue__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2888:1: ( ( '{' ) )
            // InternalLDef.g:2889:1: ( '{' )
            {
            // InternalLDef.g:2889:1: ( '{' )
            // InternalLDef.g:2890:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getLeftCurlyBracketKeyword_2_1_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2903:1: rule__ConfigValue__Group_2_1__1 : rule__ConfigValue__Group_2_1__1__Impl rule__ConfigValue__Group_2_1__2 ;
    public final void rule__ConfigValue__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2907:1: ( rule__ConfigValue__Group_2_1__1__Impl rule__ConfigValue__Group_2_1__2 )
            // InternalLDef.g:2908:2: rule__ConfigValue__Group_2_1__1__Impl rule__ConfigValue__Group_2_1__2
            {
            pushFollow(FOLLOW_14);
            rule__ConfigValue__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2915:1: rule__ConfigValue__Group_2_1__1__Impl : ( ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) ) ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* ) ) ;
    public final void rule__ConfigValue__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2919:1: ( ( ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) ) ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* ) ) )
            // InternalLDef.g:2920:1: ( ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) ) ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* ) )
            {
            // InternalLDef.g:2920:1: ( ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) ) ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* ) )
            // InternalLDef.g:2921:1: ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) ) ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* )
            {
            // InternalLDef.g:2921:1: ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 ) )
            // InternalLDef.g:2922:1: ( rule__ConfigValue__ChildrenAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getChildrenAssignment_2_1_1()); 
            }
            // InternalLDef.g:2923:1: ( rule__ConfigValue__ChildrenAssignment_2_1_1 )
            // InternalLDef.g:2923:2: rule__ConfigValue__ChildrenAssignment_2_1_1
            {
            pushFollow(FOLLOW_19);
            rule__ConfigValue__ChildrenAssignment_2_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getChildrenAssignment_2_1_1()); 
            }

            }

            // InternalLDef.g:2926:1: ( ( rule__ConfigValue__ChildrenAssignment_2_1_1 )* )
            // InternalLDef.g:2927:1: ( rule__ConfigValue__ChildrenAssignment_2_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getChildrenAssignment_2_1_1()); 
            }
            // InternalLDef.g:2928:1: ( rule__ConfigValue__ChildrenAssignment_2_1_1 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalLDef.g:2928:2: rule__ConfigValue__ChildrenAssignment_2_1_1
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__ConfigValue__ChildrenAssignment_2_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalLDef.g:2939:1: rule__ConfigValue__Group_2_1__2 : rule__ConfigValue__Group_2_1__2__Impl ;
    public final void rule__ConfigValue__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2943:1: ( rule__ConfigValue__Group_2_1__2__Impl )
            // InternalLDef.g:2944:2: rule__ConfigValue__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2950:1: rule__ConfigValue__Group_2_1__2__Impl : ( '}' ) ;
    public final void rule__ConfigValue__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2954:1: ( ( '}' ) )
            // InternalLDef.g:2955:1: ( '}' )
            {
            // InternalLDef.g:2955:1: ( '}' )
            // InternalLDef.g:2956:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getRightCurlyBracketKeyword_2_1_2()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:2975:1: rule__Paritioning__Group__0 : rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1 ;
    public final void rule__Paritioning__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2979:1: ( rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1 )
            // InternalLDef.g:2980:2: rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Paritioning__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:2987:1: rule__Paritioning__Group__0__Impl : ( 'partitioning' ) ;
    public final void rule__Paritioning__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:2991:1: ( ( 'partitioning' ) )
            // InternalLDef.g:2992:1: ( 'partitioning' )
            {
            // InternalLDef.g:2992:1: ( 'partitioning' )
            // InternalLDef.g:2993:1: 'partitioning'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitioningKeyword_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3006:1: rule__Paritioning__Group__1 : rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2 ;
    public final void rule__Paritioning__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3010:1: ( rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2 )
            // InternalLDef.g:3011:2: rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__Paritioning__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3018:1: rule__Paritioning__Group__1__Impl : ( '{' ) ;
    public final void rule__Paritioning__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3022:1: ( ( '{' ) )
            // InternalLDef.g:3023:1: ( '{' )
            {
            // InternalLDef.g:3023:1: ( '{' )
            // InternalLDef.g:3024:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3037:1: rule__Paritioning__Group__2 : rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3 ;
    public final void rule__Paritioning__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3041:1: ( rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3 )
            // InternalLDef.g:3042:2: rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__Paritioning__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3049:1: rule__Paritioning__Group__2__Impl : ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) ) ;
    public final void rule__Paritioning__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3053:1: ( ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) ) )
            // InternalLDef.g:3054:1: ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) )
            {
            // InternalLDef.g:3054:1: ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) )
            // InternalLDef.g:3055:1: ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* )
            {
            // InternalLDef.g:3055:1: ( ( rule__Paritioning__PartitionsAssignment_2 ) )
            // InternalLDef.g:3056:1: ( rule__Paritioning__PartitionsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }
            // InternalLDef.g:3057:1: ( rule__Paritioning__PartitionsAssignment_2 )
            // InternalLDef.g:3057:2: rule__Paritioning__PartitionsAssignment_2
            {
            pushFollow(FOLLOW_24);
            rule__Paritioning__PartitionsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }

            }

            // InternalLDef.g:3060:1: ( ( rule__Paritioning__PartitionsAssignment_2 )* )
            // InternalLDef.g:3061:1: ( rule__Paritioning__PartitionsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            }
            // InternalLDef.g:3062:1: ( rule__Paritioning__PartitionsAssignment_2 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==27) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalLDef.g:3062:2: rule__Paritioning__PartitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__Paritioning__PartitionsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalLDef.g:3073:1: rule__Paritioning__Group__3 : rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4 ;
    public final void rule__Paritioning__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3077:1: ( rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4 )
            // InternalLDef.g:3078:2: rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__Paritioning__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3085:1: rule__Paritioning__Group__3__Impl : ( ( rule__Paritioning__PartitionerAssignment_3 ) ) ;
    public final void rule__Paritioning__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3089:1: ( ( ( rule__Paritioning__PartitionerAssignment_3 ) ) )
            // InternalLDef.g:3090:1: ( ( rule__Paritioning__PartitionerAssignment_3 ) )
            {
            // InternalLDef.g:3090:1: ( ( rule__Paritioning__PartitionerAssignment_3 ) )
            // InternalLDef.g:3091:1: ( rule__Paritioning__PartitionerAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionerAssignment_3()); 
            }
            // InternalLDef.g:3092:1: ( rule__Paritioning__PartitionerAssignment_3 )
            // InternalLDef.g:3092:2: rule__Paritioning__PartitionerAssignment_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3102:1: rule__Paritioning__Group__4 : rule__Paritioning__Group__4__Impl ;
    public final void rule__Paritioning__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3106:1: ( rule__Paritioning__Group__4__Impl )
            // InternalLDef.g:3107:2: rule__Paritioning__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3113:1: rule__Paritioning__Group__4__Impl : ( '}' ) ;
    public final void rule__Paritioning__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3117:1: ( ( '}' ) )
            // InternalLDef.g:3118:1: ( '}' )
            {
            // InternalLDef.g:3118:1: ( '}' )
            // InternalLDef.g:3119:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3142:1: rule__Partition__Group__0 : rule__Partition__Group__0__Impl rule__Partition__Group__1 ;
    public final void rule__Partition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3146:1: ( rule__Partition__Group__0__Impl rule__Partition__Group__1 )
            // InternalLDef.g:3147:2: rule__Partition__Group__0__Impl rule__Partition__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Partition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3154:1: rule__Partition__Group__0__Impl : ( 'partition' ) ;
    public final void rule__Partition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3158:1: ( ( 'partition' ) )
            // InternalLDef.g:3159:1: ( 'partition' )
            {
            // InternalLDef.g:3159:1: ( 'partition' )
            // InternalLDef.g:3160:1: 'partition'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3173:1: rule__Partition__Group__1 : rule__Partition__Group__1__Impl ;
    public final void rule__Partition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3177:1: ( rule__Partition__Group__1__Impl )
            // InternalLDef.g:3178:2: rule__Partition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3184:1: rule__Partition__Group__1__Impl : ( ( rule__Partition__NameAssignment_1 ) ) ;
    public final void rule__Partition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3188:1: ( ( ( rule__Partition__NameAssignment_1 ) ) )
            // InternalLDef.g:3189:1: ( ( rule__Partition__NameAssignment_1 ) )
            {
            // InternalLDef.g:3189:1: ( ( rule__Partition__NameAssignment_1 ) )
            // InternalLDef.g:3190:1: ( rule__Partition__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            }
            // InternalLDef.g:3191:1: ( rule__Partition__NameAssignment_1 )
            // InternalLDef.g:3191:2: rule__Partition__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3205:1: rule__Paritioner_JS__Group__0 : rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1 ;
    public final void rule__Paritioner_JS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3209:1: ( rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1 )
            // InternalLDef.g:3210:2: rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Paritioner_JS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3217:1: rule__Paritioner_JS__Group__0__Impl : ( 'script' ) ;
    public final void rule__Paritioner_JS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3221:1: ( ( 'script' ) )
            // InternalLDef.g:3222:1: ( 'script' )
            {
            // InternalLDef.g:3222:1: ( 'script' )
            // InternalLDef.g:3223:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptKeyword_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3236:1: rule__Paritioner_JS__Group__1 : rule__Paritioner_JS__Group__1__Impl ;
    public final void rule__Paritioner_JS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3240:1: ( rule__Paritioner_JS__Group__1__Impl )
            // InternalLDef.g:3241:2: rule__Paritioner_JS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3247:1: rule__Paritioner_JS__Group__1__Impl : ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) ) ;
    public final void rule__Paritioner_JS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3251:1: ( ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) ) )
            // InternalLDef.g:3252:1: ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) )
            {
            // InternalLDef.g:3252:1: ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) )
            // InternalLDef.g:3253:1: ( rule__Paritioner_JS__ScriptURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptURIAssignment_1()); 
            }
            // InternalLDef.g:3254:1: ( rule__Paritioner_JS__ScriptURIAssignment_1 )
            // InternalLDef.g:3254:2: rule__Paritioner_JS__ScriptURIAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3268:1: rule__Partitioner_Rule__Group__0 : rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1 ;
    public final void rule__Partitioner_Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3272:1: ( rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1 )
            // InternalLDef.g:3273:2: rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Partitioner_Rule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3280:1: rule__Partitioner_Rule__Group__0__Impl : ( 'rule' ) ;
    public final void rule__Partitioner_Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3284:1: ( ( 'rule' ) )
            // InternalLDef.g:3285:1: ( 'rule' )
            {
            // InternalLDef.g:3285:1: ( 'rule' )
            // InternalLDef.g:3286:1: 'rule'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3299:1: rule__Partitioner_Rule__Group__1 : rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2 ;
    public final void rule__Partitioner_Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3303:1: ( rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2 )
            // InternalLDef.g:3304:2: rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Partitioner_Rule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3311:1: rule__Partitioner_Rule__Group__1__Impl : ( '{' ) ;
    public final void rule__Partitioner_Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3315:1: ( ( '{' ) )
            // InternalLDef.g:3316:1: ( '{' )
            {
            // InternalLDef.g:3316:1: ( '{' )
            // InternalLDef.g:3317:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3330:1: rule__Partitioner_Rule__Group__2 : rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3 ;
    public final void rule__Partitioner_Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3334:1: ( rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3 )
            // InternalLDef.g:3335:2: rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__Partitioner_Rule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3342:1: rule__Partitioner_Rule__Group__2__Impl : ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) ) ;
    public final void rule__Partitioner_Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3346:1: ( ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) ) )
            // InternalLDef.g:3347:1: ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) )
            {
            // InternalLDef.g:3347:1: ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) )
            // InternalLDef.g:3348:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* )
            {
            // InternalLDef.g:3348:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) )
            // InternalLDef.g:3349:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }
            // InternalLDef.g:3350:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )
            // InternalLDef.g:3350:2: rule__Partitioner_Rule__RuleListAssignment_2
            {
            pushFollow(FOLLOW_26);
            rule__Partitioner_Rule__RuleListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }

            }

            // InternalLDef.g:3353:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* )
            // InternalLDef.g:3354:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            }
            // InternalLDef.g:3355:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==30||LA24_0==35) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalLDef.g:3355:2: rule__Partitioner_Rule__RuleListAssignment_2
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__Partitioner_Rule__RuleListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalLDef.g:3366:1: rule__Partitioner_Rule__Group__3 : rule__Partitioner_Rule__Group__3__Impl ;
    public final void rule__Partitioner_Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3370:1: ( rule__Partitioner_Rule__Group__3__Impl )
            // InternalLDef.g:3371:2: rule__Partitioner_Rule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3377:1: rule__Partitioner_Rule__Group__3__Impl : ( '}' ) ;
    public final void rule__Partitioner_Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3381:1: ( ( '}' ) )
            // InternalLDef.g:3382:1: ( '}' )
            {
            // InternalLDef.g:3382:1: ( '}' )
            // InternalLDef.g:3383:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3404:1: rule__Partition_SingleLineRule__Group__0 : rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1 ;
    public final void rule__Partition_SingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3408:1: ( rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1 )
            // InternalLDef.g:3409:2: rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Partition_SingleLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3416:1: rule__Partition_SingleLineRule__Group__0__Impl : ( 'single_line' ) ;
    public final void rule__Partition_SingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3420:1: ( ( 'single_line' ) )
            // InternalLDef.g:3421:1: ( 'single_line' )
            {
            // InternalLDef.g:3421:1: ( 'single_line' )
            // InternalLDef.g:3422:1: 'single_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3435:1: rule__Partition_SingleLineRule__Group__1 : rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2 ;
    public final void rule__Partition_SingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3439:1: ( rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2 )
            // InternalLDef.g:3440:2: rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Partition_SingleLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3447:1: rule__Partition_SingleLineRule__Group__1__Impl : ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__Partition_SingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3451:1: ( ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) ) )
            // InternalLDef.g:3452:1: ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) )
            {
            // InternalLDef.g:3452:1: ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) )
            // InternalLDef.g:3453:1: ( rule__Partition_SingleLineRule__ParitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionAssignment_1()); 
            }
            // InternalLDef.g:3454:1: ( rule__Partition_SingleLineRule__ParitionAssignment_1 )
            // InternalLDef.g:3454:2: rule__Partition_SingleLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3464:1: rule__Partition_SingleLineRule__Group__2 : rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3 ;
    public final void rule__Partition_SingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3468:1: ( rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3 )
            // InternalLDef.g:3469:2: rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__Partition_SingleLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3476:1: rule__Partition_SingleLineRule__Group__2__Impl : ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__Partition_SingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3480:1: ( ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) ) )
            // InternalLDef.g:3481:1: ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) )
            {
            // InternalLDef.g:3481:1: ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) )
            // InternalLDef.g:3482:1: ( rule__Partition_SingleLineRule__StartSeqAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqAssignment_2()); 
            }
            // InternalLDef.g:3483:1: ( rule__Partition_SingleLineRule__StartSeqAssignment_2 )
            // InternalLDef.g:3483:2: rule__Partition_SingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3493:1: rule__Partition_SingleLineRule__Group__3 : rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4 ;
    public final void rule__Partition_SingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3497:1: ( rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4 )
            // InternalLDef.g:3498:2: rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__Partition_SingleLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3505:1: rule__Partition_SingleLineRule__Group__3__Impl : ( ( rule__Partition_SingleLineRule__Group_3__0 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3509:1: ( ( ( rule__Partition_SingleLineRule__Group_3__0 )? ) )
            // InternalLDef.g:3510:1: ( ( rule__Partition_SingleLineRule__Group_3__0 )? )
            {
            // InternalLDef.g:3510:1: ( ( rule__Partition_SingleLineRule__Group_3__0 )? )
            // InternalLDef.g:3511:1: ( rule__Partition_SingleLineRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_3()); 
            }
            // InternalLDef.g:3512:1: ( rule__Partition_SingleLineRule__Group_3__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==31) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalLDef.g:3512:2: rule__Partition_SingleLineRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3522:1: rule__Partition_SingleLineRule__Group__4 : rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5 ;
    public final void rule__Partition_SingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3526:1: ( rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5 )
            // InternalLDef.g:3527:2: rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5
            {
            pushFollow(FOLLOW_27);
            rule__Partition_SingleLineRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3534:1: rule__Partition_SingleLineRule__Group__4__Impl : ( ( rule__Partition_SingleLineRule__Group_4__0 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3538:1: ( ( ( rule__Partition_SingleLineRule__Group_4__0 )? ) )
            // InternalLDef.g:3539:1: ( ( rule__Partition_SingleLineRule__Group_4__0 )? )
            {
            // InternalLDef.g:3539:1: ( ( rule__Partition_SingleLineRule__Group_4__0 )? )
            // InternalLDef.g:3540:1: ( rule__Partition_SingleLineRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_4()); 
            }
            // InternalLDef.g:3541:1: ( rule__Partition_SingleLineRule__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalLDef.g:3541:2: rule__Partition_SingleLineRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Partition_SingleLineRule__Group__5"
    // InternalLDef.g:3551:1: rule__Partition_SingleLineRule__Group__5 : rule__Partition_SingleLineRule__Group__5__Impl ;
    public final void rule__Partition_SingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3555:1: ( rule__Partition_SingleLineRule__Group__5__Impl )
            // InternalLDef.g:3556:2: rule__Partition_SingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3562:1: rule__Partition_SingleLineRule__Group__5__Impl : ( ( rule__Partition_SingleLineRule__Group_5__0 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3566:1: ( ( ( rule__Partition_SingleLineRule__Group_5__0 )? ) )
            // InternalLDef.g:3567:1: ( ( rule__Partition_SingleLineRule__Group_5__0 )? )
            {
            // InternalLDef.g:3567:1: ( ( rule__Partition_SingleLineRule__Group_5__0 )? )
            // InternalLDef.g:3568:1: ( rule__Partition_SingleLineRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_5()); 
            }
            // InternalLDef.g:3569:1: ( rule__Partition_SingleLineRule__Group_5__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalLDef.g:3569:2: rule__Partition_SingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Partition_SingleLineRule__Group_3__0"
    // InternalLDef.g:3591:1: rule__Partition_SingleLineRule__Group_3__0 : rule__Partition_SingleLineRule__Group_3__0__Impl rule__Partition_SingleLineRule__Group_3__1 ;
    public final void rule__Partition_SingleLineRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3595:1: ( rule__Partition_SingleLineRule__Group_3__0__Impl rule__Partition_SingleLineRule__Group_3__1 )
            // InternalLDef.g:3596:2: rule__Partition_SingleLineRule__Group_3__0__Impl rule__Partition_SingleLineRule__Group_3__1
            {
            pushFollow(FOLLOW_28);
            rule__Partition_SingleLineRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3603:1: rule__Partition_SingleLineRule__Group_3__0__Impl : ( 'col' ) ;
    public final void rule__Partition_SingleLineRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3607:1: ( ( 'col' ) )
            // InternalLDef.g:3608:1: ( 'col' )
            {
            // InternalLDef.g:3608:1: ( 'col' )
            // InternalLDef.g:3609:1: 'col'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getColKeyword_3_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getColKeyword_3_0()); 
            }

            }


            }

        }
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
    // InternalLDef.g:3622:1: rule__Partition_SingleLineRule__Group_3__1 : rule__Partition_SingleLineRule__Group_3__1__Impl ;
    public final void rule__Partition_SingleLineRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3626:1: ( rule__Partition_SingleLineRule__Group_3__1__Impl )
            // InternalLDef.g:3627:2: rule__Partition_SingleLineRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3633:1: rule__Partition_SingleLineRule__Group_3__1__Impl : ( ( rule__Partition_SingleLineRule__CheckAssignment_3_1 ) ) ;
    public final void rule__Partition_SingleLineRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3637:1: ( ( ( rule__Partition_SingleLineRule__CheckAssignment_3_1 ) ) )
            // InternalLDef.g:3638:1: ( ( rule__Partition_SingleLineRule__CheckAssignment_3_1 ) )
            {
            // InternalLDef.g:3638:1: ( ( rule__Partition_SingleLineRule__CheckAssignment_3_1 ) )
            // InternalLDef.g:3639:1: ( rule__Partition_SingleLineRule__CheckAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getCheckAssignment_3_1()); 
            }
            // InternalLDef.g:3640:1: ( rule__Partition_SingleLineRule__CheckAssignment_3_1 )
            // InternalLDef.g:3640:2: rule__Partition_SingleLineRule__CheckAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Partition_SingleLineRule__CheckAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getCheckAssignment_3_1()); 
            }

            }


            }

        }
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
    // InternalLDef.g:3654:1: rule__Partition_SingleLineRule__Group_4__0 : rule__Partition_SingleLineRule__Group_4__0__Impl rule__Partition_SingleLineRule__Group_4__1 ;
    public final void rule__Partition_SingleLineRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3658:1: ( rule__Partition_SingleLineRule__Group_4__0__Impl rule__Partition_SingleLineRule__Group_4__1 )
            // InternalLDef.g:3659:2: rule__Partition_SingleLineRule__Group_4__0__Impl rule__Partition_SingleLineRule__Group_4__1
            {
            pushFollow(FOLLOW_18);
            rule__Partition_SingleLineRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3666:1: rule__Partition_SingleLineRule__Group_4__0__Impl : ( '=>' ) ;
    public final void rule__Partition_SingleLineRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3670:1: ( ( '=>' ) )
            // InternalLDef.g:3671:1: ( '=>' )
            {
            // InternalLDef.g:3671:1: ( '=>' )
            // InternalLDef.g:3672:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_4_0()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_4_0()); 
            }

            }


            }

        }
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
    // InternalLDef.g:3685:1: rule__Partition_SingleLineRule__Group_4__1 : rule__Partition_SingleLineRule__Group_4__1__Impl ;
    public final void rule__Partition_SingleLineRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3689:1: ( rule__Partition_SingleLineRule__Group_4__1__Impl )
            // InternalLDef.g:3690:2: rule__Partition_SingleLineRule__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Partition_SingleLineRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalLDef.g:3696:1: rule__Partition_SingleLineRule__Group_4__1__Impl : ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4_1 )? ) ;
    public final void rule__Partition_SingleLineRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3700:1: ( ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4_1 )? ) )
            // InternalLDef.g:3701:1: ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4_1 )? )
            {
            // InternalLDef.g:3701:1: ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4_1 )? )
            // InternalLDef.g:3702:1: ( rule__Partition_SingleLineRule__EndSeqAssignment_4_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqAssignment_4_1()); 
            }
            // InternalLDef.g:3703:1: ( rule__Partition_SingleLineRule__EndSeqAssignment_4_1 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_STRING) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalLDef.g:3703:2: rule__Partition_SingleLineRule__EndSeqAssignment_4_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Partition_SingleLineRule__EndSeqAssignment_4_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqAssignment_4_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Partition_SingleLineRule__Group_5__0"
    // InternalLDef.g:3717:1: rule__Partition_SingleLineRule__Group_5__0 : rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1 ;
    public final void rule__Partition_SingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3721:1: ( rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1 )
            // InternalLDef.g:3722:2: rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_29);
            rule__Partition_SingleLineRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3729:1: rule__Partition_SingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__Partition_SingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3733:1: ( ( 'escaped' ) )
            // InternalLDef.g:3734:1: ( 'escaped' )
            {
            // InternalLDef.g:3734:1: ( 'escaped' )
            // InternalLDef.g:3735:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_5_0()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3748:1: rule__Partition_SingleLineRule__Group_5__1 : rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2 ;
    public final void rule__Partition_SingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3752:1: ( rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2 )
            // InternalLDef.g:3753:2: rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_18);
            rule__Partition_SingleLineRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3760:1: rule__Partition_SingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__Partition_SingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3764:1: ( ( 'by' ) )
            // InternalLDef.g:3765:1: ( 'by' )
            {
            // InternalLDef.g:3765:1: ( 'by' )
            // InternalLDef.g:3766:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_5_1()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3779:1: rule__Partition_SingleLineRule__Group_5__2 : rule__Partition_SingleLineRule__Group_5__2__Impl ;
    public final void rule__Partition_SingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3783:1: ( rule__Partition_SingleLineRule__Group_5__2__Impl )
            // InternalLDef.g:3784:2: rule__Partition_SingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3790:1: rule__Partition_SingleLineRule__Group_5__2__Impl : ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__Partition_SingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3794:1: ( ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // InternalLDef.g:3795:1: ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // InternalLDef.g:3795:1: ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) )
            // InternalLDef.g:3796:1: ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            }
            // InternalLDef.g:3797:1: ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 )
            // InternalLDef.g:3797:2: rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3813:1: rule__Partition_MultiLineRule__Group__0 : rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1 ;
    public final void rule__Partition_MultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3817:1: ( rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1 )
            // InternalLDef.g:3818:2: rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Partition_MultiLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3825:1: rule__Partition_MultiLineRule__Group__0__Impl : ( 'multi_line' ) ;
    public final void rule__Partition_MultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3829:1: ( ( 'multi_line' ) )
            // InternalLDef.g:3830:1: ( 'multi_line' )
            {
            // InternalLDef.g:3830:1: ( 'multi_line' )
            // InternalLDef.g:3831:1: 'multi_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:3844:1: rule__Partition_MultiLineRule__Group__1 : rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2 ;
    public final void rule__Partition_MultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3848:1: ( rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2 )
            // InternalLDef.g:3849:2: rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Partition_MultiLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3856:1: rule__Partition_MultiLineRule__Group__1__Impl : ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3860:1: ( ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) ) )
            // InternalLDef.g:3861:1: ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) )
            {
            // InternalLDef.g:3861:1: ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) )
            // InternalLDef.g:3862:1: ( rule__Partition_MultiLineRule__ParitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionAssignment_1()); 
            }
            // InternalLDef.g:3863:1: ( rule__Partition_MultiLineRule__ParitionAssignment_1 )
            // InternalLDef.g:3863:2: rule__Partition_MultiLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3873:1: rule__Partition_MultiLineRule__Group__2 : rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3 ;
    public final void rule__Partition_MultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3877:1: ( rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3 )
            // InternalLDef.g:3878:2: rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3
            {
            pushFollow(FOLLOW_30);
            rule__Partition_MultiLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3885:1: rule__Partition_MultiLineRule__Group__2__Impl : ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3889:1: ( ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) ) )
            // InternalLDef.g:3890:1: ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) )
            {
            // InternalLDef.g:3890:1: ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) )
            // InternalLDef.g:3891:1: ( rule__Partition_MultiLineRule__StartSeqAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqAssignment_2()); 
            }
            // InternalLDef.g:3892:1: ( rule__Partition_MultiLineRule__StartSeqAssignment_2 )
            // InternalLDef.g:3892:2: rule__Partition_MultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3902:1: rule__Partition_MultiLineRule__Group__3 : rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4 ;
    public final void rule__Partition_MultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3906:1: ( rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4 )
            // InternalLDef.g:3907:2: rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4
            {
            pushFollow(FOLLOW_30);
            rule__Partition_MultiLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3914:1: rule__Partition_MultiLineRule__Group__3__Impl : ( ( rule__Partition_MultiLineRule__Group_3__0 )? ) ;
    public final void rule__Partition_MultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3918:1: ( ( ( rule__Partition_MultiLineRule__Group_3__0 )? ) )
            // InternalLDef.g:3919:1: ( ( rule__Partition_MultiLineRule__Group_3__0 )? )
            {
            // InternalLDef.g:3919:1: ( ( rule__Partition_MultiLineRule__Group_3__0 )? )
            // InternalLDef.g:3920:1: ( rule__Partition_MultiLineRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup_3()); 
            }
            // InternalLDef.g:3921:1: ( rule__Partition_MultiLineRule__Group_3__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==31) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalLDef.g:3921:2: rule__Partition_MultiLineRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Partition_MultiLineRule__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getGroup_3()); 
            }

            }


            }

        }
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
    // InternalLDef.g:3931:1: rule__Partition_MultiLineRule__Group__4 : rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5 ;
    public final void rule__Partition_MultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3935:1: ( rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5 )
            // InternalLDef.g:3936:2: rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5
            {
            pushFollow(FOLLOW_18);
            rule__Partition_MultiLineRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:3943:1: rule__Partition_MultiLineRule__Group__4__Impl : ( '=>' ) ;
    public final void rule__Partition_MultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3947:1: ( ( '=>' ) )
            // InternalLDef.g:3948:1: ( '=>' )
            {
            // InternalLDef.g:3948:1: ( '=>' )
            // InternalLDef.g:3949:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_4()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_4()); 
            }

            }


            }

        }
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
    // InternalLDef.g:3962:1: rule__Partition_MultiLineRule__Group__5 : rule__Partition_MultiLineRule__Group__5__Impl rule__Partition_MultiLineRule__Group__6 ;
    public final void rule__Partition_MultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3966:1: ( rule__Partition_MultiLineRule__Group__5__Impl rule__Partition_MultiLineRule__Group__6 )
            // InternalLDef.g:3967:2: rule__Partition_MultiLineRule__Group__5__Impl rule__Partition_MultiLineRule__Group__6
            {
            pushFollow(FOLLOW_31);
            rule__Partition_MultiLineRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Partition_MultiLineRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalLDef.g:3974:1: rule__Partition_MultiLineRule__Group__5__Impl : ( ( rule__Partition_MultiLineRule__EndSeqAssignment_5 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3978:1: ( ( ( rule__Partition_MultiLineRule__EndSeqAssignment_5 ) ) )
            // InternalLDef.g:3979:1: ( ( rule__Partition_MultiLineRule__EndSeqAssignment_5 ) )
            {
            // InternalLDef.g:3979:1: ( ( rule__Partition_MultiLineRule__EndSeqAssignment_5 ) )
            // InternalLDef.g:3980:1: ( rule__Partition_MultiLineRule__EndSeqAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqAssignment_5()); 
            }
            // InternalLDef.g:3981:1: ( rule__Partition_MultiLineRule__EndSeqAssignment_5 )
            // InternalLDef.g:3981:2: rule__Partition_MultiLineRule__EndSeqAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Partition_MultiLineRule__EndSeqAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqAssignment_5()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Partition_MultiLineRule__Group__6"
    // InternalLDef.g:3991:1: rule__Partition_MultiLineRule__Group__6 : rule__Partition_MultiLineRule__Group__6__Impl ;
    public final void rule__Partition_MultiLineRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:3995:1: ( rule__Partition_MultiLineRule__Group__6__Impl )
            // InternalLDef.g:3996:2: rule__Partition_MultiLineRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Partition_MultiLineRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__6"


    // $ANTLR start "rule__Partition_MultiLineRule__Group__6__Impl"
    // InternalLDef.g:4002:1: rule__Partition_MultiLineRule__Group__6__Impl : ( ( rule__Partition_MultiLineRule__Group_6__0 )? ) ;
    public final void rule__Partition_MultiLineRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4006:1: ( ( ( rule__Partition_MultiLineRule__Group_6__0 )? ) )
            // InternalLDef.g:4007:1: ( ( rule__Partition_MultiLineRule__Group_6__0 )? )
            {
            // InternalLDef.g:4007:1: ( ( rule__Partition_MultiLineRule__Group_6__0 )? )
            // InternalLDef.g:4008:1: ( rule__Partition_MultiLineRule__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup_6()); 
            }
            // InternalLDef.g:4009:1: ( rule__Partition_MultiLineRule__Group_6__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==33) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalLDef.g:4009:2: rule__Partition_MultiLineRule__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Partition_MultiLineRule__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group__6__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_3__0"
    // InternalLDef.g:4033:1: rule__Partition_MultiLineRule__Group_3__0 : rule__Partition_MultiLineRule__Group_3__0__Impl rule__Partition_MultiLineRule__Group_3__1 ;
    public final void rule__Partition_MultiLineRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4037:1: ( rule__Partition_MultiLineRule__Group_3__0__Impl rule__Partition_MultiLineRule__Group_3__1 )
            // InternalLDef.g:4038:2: rule__Partition_MultiLineRule__Group_3__0__Impl rule__Partition_MultiLineRule__Group_3__1
            {
            pushFollow(FOLLOW_28);
            rule__Partition_MultiLineRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Partition_MultiLineRule__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_3__0"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_3__0__Impl"
    // InternalLDef.g:4045:1: rule__Partition_MultiLineRule__Group_3__0__Impl : ( 'col' ) ;
    public final void rule__Partition_MultiLineRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4049:1: ( ( 'col' ) )
            // InternalLDef.g:4050:1: ( 'col' )
            {
            // InternalLDef.g:4050:1: ( 'col' )
            // InternalLDef.g:4051:1: 'col'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getColKeyword_3_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getColKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_3__0__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_3__1"
    // InternalLDef.g:4064:1: rule__Partition_MultiLineRule__Group_3__1 : rule__Partition_MultiLineRule__Group_3__1__Impl ;
    public final void rule__Partition_MultiLineRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4068:1: ( rule__Partition_MultiLineRule__Group_3__1__Impl )
            // InternalLDef.g:4069:2: rule__Partition_MultiLineRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Partition_MultiLineRule__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_3__1"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_3__1__Impl"
    // InternalLDef.g:4075:1: rule__Partition_MultiLineRule__Group_3__1__Impl : ( ( rule__Partition_MultiLineRule__CheckAssignment_3_1 ) ) ;
    public final void rule__Partition_MultiLineRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4079:1: ( ( ( rule__Partition_MultiLineRule__CheckAssignment_3_1 ) ) )
            // InternalLDef.g:4080:1: ( ( rule__Partition_MultiLineRule__CheckAssignment_3_1 ) )
            {
            // InternalLDef.g:4080:1: ( ( rule__Partition_MultiLineRule__CheckAssignment_3_1 ) )
            // InternalLDef.g:4081:1: ( rule__Partition_MultiLineRule__CheckAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getCheckAssignment_3_1()); 
            }
            // InternalLDef.g:4082:1: ( rule__Partition_MultiLineRule__CheckAssignment_3_1 )
            // InternalLDef.g:4082:2: rule__Partition_MultiLineRule__CheckAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Partition_MultiLineRule__CheckAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getCheckAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_3__1__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_6__0"
    // InternalLDef.g:4096:1: rule__Partition_MultiLineRule__Group_6__0 : rule__Partition_MultiLineRule__Group_6__0__Impl rule__Partition_MultiLineRule__Group_6__1 ;
    public final void rule__Partition_MultiLineRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4100:1: ( rule__Partition_MultiLineRule__Group_6__0__Impl rule__Partition_MultiLineRule__Group_6__1 )
            // InternalLDef.g:4101:2: rule__Partition_MultiLineRule__Group_6__0__Impl rule__Partition_MultiLineRule__Group_6__1
            {
            pushFollow(FOLLOW_29);
            rule__Partition_MultiLineRule__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Partition_MultiLineRule__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_6__0"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_6__0__Impl"
    // InternalLDef.g:4108:1: rule__Partition_MultiLineRule__Group_6__0__Impl : ( 'escaped' ) ;
    public final void rule__Partition_MultiLineRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4112:1: ( ( 'escaped' ) )
            // InternalLDef.g:4113:1: ( 'escaped' )
            {
            // InternalLDef.g:4113:1: ( 'escaped' )
            // InternalLDef.g:4114:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_6_0()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_6__0__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_6__1"
    // InternalLDef.g:4127:1: rule__Partition_MultiLineRule__Group_6__1 : rule__Partition_MultiLineRule__Group_6__1__Impl rule__Partition_MultiLineRule__Group_6__2 ;
    public final void rule__Partition_MultiLineRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4131:1: ( rule__Partition_MultiLineRule__Group_6__1__Impl rule__Partition_MultiLineRule__Group_6__2 )
            // InternalLDef.g:4132:2: rule__Partition_MultiLineRule__Group_6__1__Impl rule__Partition_MultiLineRule__Group_6__2
            {
            pushFollow(FOLLOW_18);
            rule__Partition_MultiLineRule__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Partition_MultiLineRule__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_6__1"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_6__1__Impl"
    // InternalLDef.g:4139:1: rule__Partition_MultiLineRule__Group_6__1__Impl : ( 'by' ) ;
    public final void rule__Partition_MultiLineRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4143:1: ( ( 'by' ) )
            // InternalLDef.g:4144:1: ( 'by' )
            {
            // InternalLDef.g:4144:1: ( 'by' )
            // InternalLDef.g:4145:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_6_1()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_6__1__Impl"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_6__2"
    // InternalLDef.g:4158:1: rule__Partition_MultiLineRule__Group_6__2 : rule__Partition_MultiLineRule__Group_6__2__Impl ;
    public final void rule__Partition_MultiLineRule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4162:1: ( rule__Partition_MultiLineRule__Group_6__2__Impl )
            // InternalLDef.g:4163:2: rule__Partition_MultiLineRule__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Partition_MultiLineRule__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_6__2"


    // $ANTLR start "rule__Partition_MultiLineRule__Group_6__2__Impl"
    // InternalLDef.g:4169:1: rule__Partition_MultiLineRule__Group_6__2__Impl : ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2 ) ) ;
    public final void rule__Partition_MultiLineRule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4173:1: ( ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2 ) ) )
            // InternalLDef.g:4174:1: ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2 ) )
            {
            // InternalLDef.g:4174:1: ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2 ) )
            // InternalLDef.g:4175:1: ( rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqAssignment_6_2()); 
            }
            // InternalLDef.g:4176:1: ( rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2 )
            // InternalLDef.g:4176:2: rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqAssignment_6_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__Group_6__2__Impl"


    // $ANTLR start "rule__LexicalHighlighting__Group__0"
    // InternalLDef.g:4192:1: rule__LexicalHighlighting__Group__0 : rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1 ;
    public final void rule__LexicalHighlighting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4196:1: ( rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1 )
            // InternalLDef.g:4197:2: rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__LexicalHighlighting__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4204:1: rule__LexicalHighlighting__Group__0__Impl : ( 'lexical_highlighting' ) ;
    public final void rule__LexicalHighlighting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4208:1: ( ( 'lexical_highlighting' ) )
            // InternalLDef.g:4209:1: ( 'lexical_highlighting' )
            {
            // InternalLDef.g:4209:1: ( 'lexical_highlighting' )
            // InternalLDef.g:4210:1: 'lexical_highlighting'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0()); 
            }
            match(input,36,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:4223:1: rule__LexicalHighlighting__Group__1 : rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2 ;
    public final void rule__LexicalHighlighting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4227:1: ( rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2 )
            // InternalLDef.g:4228:2: rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__LexicalHighlighting__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4235:1: rule__LexicalHighlighting__Group__1__Impl : ( '{' ) ;
    public final void rule__LexicalHighlighting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4239:1: ( ( '{' ) )
            // InternalLDef.g:4240:1: ( '{' )
            {
            // InternalLDef.g:4240:1: ( '{' )
            // InternalLDef.g:4241:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:4254:1: rule__LexicalHighlighting__Group__2 : rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3 ;
    public final void rule__LexicalHighlighting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4258:1: ( rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3 )
            // InternalLDef.g:4259:2: rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__LexicalHighlighting__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4266:1: rule__LexicalHighlighting__Group__2__Impl : ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) ) ;
    public final void rule__LexicalHighlighting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4270:1: ( ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) ) )
            // InternalLDef.g:4271:1: ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) )
            {
            // InternalLDef.g:4271:1: ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) )
            // InternalLDef.g:4272:1: ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* )
            {
            // InternalLDef.g:4272:1: ( ( rule__LexicalHighlighting__ListAssignment_2 ) )
            // InternalLDef.g:4273:1: ( rule__LexicalHighlighting__ListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }
            // InternalLDef.g:4274:1: ( rule__LexicalHighlighting__ListAssignment_2 )
            // InternalLDef.g:4274:2: rule__LexicalHighlighting__ListAssignment_2
            {
            pushFollow(FOLLOW_33);
            rule__LexicalHighlighting__ListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }

            }

            // InternalLDef.g:4277:1: ( ( rule__LexicalHighlighting__ListAssignment_2 )* )
            // InternalLDef.g:4278:1: ( rule__LexicalHighlighting__ListAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            }
            // InternalLDef.g:4279:1: ( rule__LexicalHighlighting__ListAssignment_2 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=28 && LA31_0<=29)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalLDef.g:4279:2: rule__LexicalHighlighting__ListAssignment_2
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__LexicalHighlighting__ListAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalLDef.g:4290:1: rule__LexicalHighlighting__Group__3 : rule__LexicalHighlighting__Group__3__Impl rule__LexicalHighlighting__Group__4 ;
    public final void rule__LexicalHighlighting__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4294:1: ( rule__LexicalHighlighting__Group__3__Impl rule__LexicalHighlighting__Group__4 )
            // InternalLDef.g:4295:2: rule__LexicalHighlighting__Group__3__Impl rule__LexicalHighlighting__Group__4
            {
            pushFollow(FOLLOW_32);
            rule__LexicalHighlighting__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LexicalHighlighting__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalLDef.g:4302:1: rule__LexicalHighlighting__Group__3__Impl : ( ( rule__LexicalHighlighting__VistualAssignment_3 )? ) ;
    public final void rule__LexicalHighlighting__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4306:1: ( ( ( rule__LexicalHighlighting__VistualAssignment_3 )? ) )
            // InternalLDef.g:4307:1: ( ( rule__LexicalHighlighting__VistualAssignment_3 )? )
            {
            // InternalLDef.g:4307:1: ( ( rule__LexicalHighlighting__VistualAssignment_3 )? )
            // InternalLDef.g:4308:1: ( rule__LexicalHighlighting__VistualAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getVistualAssignment_3()); 
            }
            // InternalLDef.g:4309:1: ( rule__LexicalHighlighting__VistualAssignment_3 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==37) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalLDef.g:4309:2: rule__LexicalHighlighting__VistualAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__LexicalHighlighting__VistualAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getVistualAssignment_3()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__LexicalHighlighting__Group__4"
    // InternalLDef.g:4319:1: rule__LexicalHighlighting__Group__4 : rule__LexicalHighlighting__Group__4__Impl ;
    public final void rule__LexicalHighlighting__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4323:1: ( rule__LexicalHighlighting__Group__4__Impl )
            // InternalLDef.g:4324:2: rule__LexicalHighlighting__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LexicalHighlighting__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__Group__4"


    // $ANTLR start "rule__LexicalHighlighting__Group__4__Impl"
    // InternalLDef.g:4330:1: rule__LexicalHighlighting__Group__4__Impl : ( '}' ) ;
    public final void rule__LexicalHighlighting__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4334:1: ( ( '}' ) )
            // InternalLDef.g:4335:1: ( '}' )
            {
            // InternalLDef.g:4335:1: ( '}' )
            // InternalLDef.g:4336:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__Group__4__Impl"


    // $ANTLR start "rule__TokenVisuals__Group__0"
    // InternalLDef.g:4359:1: rule__TokenVisuals__Group__0 : rule__TokenVisuals__Group__0__Impl rule__TokenVisuals__Group__1 ;
    public final void rule__TokenVisuals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4363:1: ( rule__TokenVisuals__Group__0__Impl rule__TokenVisuals__Group__1 )
            // InternalLDef.g:4364:2: rule__TokenVisuals__Group__0__Impl rule__TokenVisuals__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__TokenVisuals__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TokenVisuals__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group__0"


    // $ANTLR start "rule__TokenVisuals__Group__0__Impl"
    // InternalLDef.g:4371:1: rule__TokenVisuals__Group__0__Impl : ( 'token_def' ) ;
    public final void rule__TokenVisuals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4375:1: ( ( 'token_def' ) )
            // InternalLDef.g:4376:1: ( 'token_def' )
            {
            // InternalLDef.g:4376:1: ( 'token_def' )
            // InternalLDef.g:4377:1: 'token_def'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualsAccess().getToken_defKeyword_0()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualsAccess().getToken_defKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group__0__Impl"


    // $ANTLR start "rule__TokenVisuals__Group__1"
    // InternalLDef.g:4390:1: rule__TokenVisuals__Group__1 : rule__TokenVisuals__Group__1__Impl rule__TokenVisuals__Group__2 ;
    public final void rule__TokenVisuals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4394:1: ( rule__TokenVisuals__Group__1__Impl rule__TokenVisuals__Group__2 )
            // InternalLDef.g:4395:2: rule__TokenVisuals__Group__1__Impl rule__TokenVisuals__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__TokenVisuals__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TokenVisuals__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group__1"


    // $ANTLR start "rule__TokenVisuals__Group__1__Impl"
    // InternalLDef.g:4402:1: rule__TokenVisuals__Group__1__Impl : ( '{' ) ;
    public final void rule__TokenVisuals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4406:1: ( ( '{' ) )
            // InternalLDef.g:4407:1: ( '{' )
            {
            // InternalLDef.g:4407:1: ( '{' )
            // InternalLDef.g:4408:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualsAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualsAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group__1__Impl"


    // $ANTLR start "rule__TokenVisuals__Group__2"
    // InternalLDef.g:4421:1: rule__TokenVisuals__Group__2 : rule__TokenVisuals__Group__2__Impl rule__TokenVisuals__Group__3 ;
    public final void rule__TokenVisuals__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4425:1: ( rule__TokenVisuals__Group__2__Impl rule__TokenVisuals__Group__3 )
            // InternalLDef.g:4426:2: rule__TokenVisuals__Group__2__Impl rule__TokenVisuals__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__TokenVisuals__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TokenVisuals__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group__2"


    // $ANTLR start "rule__TokenVisuals__Group__2__Impl"
    // InternalLDef.g:4433:1: rule__TokenVisuals__Group__2__Impl : ( ( ( rule__TokenVisuals__Group_2__0 ) ) ( ( rule__TokenVisuals__Group_2__0 )* ) ) ;
    public final void rule__TokenVisuals__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4437:1: ( ( ( ( rule__TokenVisuals__Group_2__0 ) ) ( ( rule__TokenVisuals__Group_2__0 )* ) ) )
            // InternalLDef.g:4438:1: ( ( ( rule__TokenVisuals__Group_2__0 ) ) ( ( rule__TokenVisuals__Group_2__0 )* ) )
            {
            // InternalLDef.g:4438:1: ( ( ( rule__TokenVisuals__Group_2__0 ) ) ( ( rule__TokenVisuals__Group_2__0 )* ) )
            // InternalLDef.g:4439:1: ( ( rule__TokenVisuals__Group_2__0 ) ) ( ( rule__TokenVisuals__Group_2__0 )* )
            {
            // InternalLDef.g:4439:1: ( ( rule__TokenVisuals__Group_2__0 ) )
            // InternalLDef.g:4440:1: ( rule__TokenVisuals__Group_2__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualsAccess().getGroup_2()); 
            }
            // InternalLDef.g:4441:1: ( rule__TokenVisuals__Group_2__0 )
            // InternalLDef.g:4441:2: rule__TokenVisuals__Group_2__0
            {
            pushFollow(FOLLOW_19);
            rule__TokenVisuals__Group_2__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualsAccess().getGroup_2()); 
            }

            }

            // InternalLDef.g:4444:1: ( ( rule__TokenVisuals__Group_2__0 )* )
            // InternalLDef.g:4445:1: ( rule__TokenVisuals__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualsAccess().getGroup_2()); 
            }
            // InternalLDef.g:4446:1: ( rule__TokenVisuals__Group_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalLDef.g:4446:2: rule__TokenVisuals__Group_2__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__TokenVisuals__Group_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualsAccess().getGroup_2()); 
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
    // $ANTLR end "rule__TokenVisuals__Group__2__Impl"


    // $ANTLR start "rule__TokenVisuals__Group__3"
    // InternalLDef.g:4457:1: rule__TokenVisuals__Group__3 : rule__TokenVisuals__Group__3__Impl ;
    public final void rule__TokenVisuals__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4461:1: ( rule__TokenVisuals__Group__3__Impl )
            // InternalLDef.g:4462:2: rule__TokenVisuals__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TokenVisuals__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group__3"


    // $ANTLR start "rule__TokenVisuals__Group__3__Impl"
    // InternalLDef.g:4468:1: rule__TokenVisuals__Group__3__Impl : ( '}' ) ;
    public final void rule__TokenVisuals__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4472:1: ( ( '}' ) )
            // InternalLDef.g:4473:1: ( '}' )
            {
            // InternalLDef.g:4473:1: ( '}' )
            // InternalLDef.g:4474:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualsAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualsAccess().getRightCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group__3__Impl"


    // $ANTLR start "rule__TokenVisuals__Group_2__0"
    // InternalLDef.g:4495:1: rule__TokenVisuals__Group_2__0 : rule__TokenVisuals__Group_2__0__Impl rule__TokenVisuals__Group_2__1 ;
    public final void rule__TokenVisuals__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4499:1: ( rule__TokenVisuals__Group_2__0__Impl rule__TokenVisuals__Group_2__1 )
            // InternalLDef.g:4500:2: rule__TokenVisuals__Group_2__0__Impl rule__TokenVisuals__Group_2__1
            {
            pushFollow(FOLLOW_34);
            rule__TokenVisuals__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TokenVisuals__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group_2__0"


    // $ANTLR start "rule__TokenVisuals__Group_2__0__Impl"
    // InternalLDef.g:4507:1: rule__TokenVisuals__Group_2__0__Impl : ( ( rule__TokenVisuals__TokenVisualsAssignment_2_0 ) ) ;
    public final void rule__TokenVisuals__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4511:1: ( ( ( rule__TokenVisuals__TokenVisualsAssignment_2_0 ) ) )
            // InternalLDef.g:4512:1: ( ( rule__TokenVisuals__TokenVisualsAssignment_2_0 ) )
            {
            // InternalLDef.g:4512:1: ( ( rule__TokenVisuals__TokenVisualsAssignment_2_0 ) )
            // InternalLDef.g:4513:1: ( rule__TokenVisuals__TokenVisualsAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualsAccess().getTokenVisualsAssignment_2_0()); 
            }
            // InternalLDef.g:4514:1: ( rule__TokenVisuals__TokenVisualsAssignment_2_0 )
            // InternalLDef.g:4514:2: rule__TokenVisuals__TokenVisualsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__TokenVisuals__TokenVisualsAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualsAccess().getTokenVisualsAssignment_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group_2__0__Impl"


    // $ANTLR start "rule__TokenVisuals__Group_2__1"
    // InternalLDef.g:4524:1: rule__TokenVisuals__Group_2__1 : rule__TokenVisuals__Group_2__1__Impl ;
    public final void rule__TokenVisuals__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4528:1: ( rule__TokenVisuals__Group_2__1__Impl )
            // InternalLDef.g:4529:2: rule__TokenVisuals__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TokenVisuals__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group_2__1"


    // $ANTLR start "rule__TokenVisuals__Group_2__1__Impl"
    // InternalLDef.g:4535:1: rule__TokenVisuals__Group_2__1__Impl : ( ';' ) ;
    public final void rule__TokenVisuals__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4539:1: ( ( ';' ) )
            // InternalLDef.g:4540:1: ( ';' )
            {
            // InternalLDef.g:4540:1: ( ';' )
            // InternalLDef.g:4541:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualsAccess().getSemicolonKeyword_2_1()); 
            }
            match(input,38,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualsAccess().getSemicolonKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__Group_2__1__Impl"


    // $ANTLR start "rule__TokenVisual__Group__0"
    // InternalLDef.g:4558:1: rule__TokenVisual__Group__0 : rule__TokenVisual__Group__0__Impl rule__TokenVisual__Group__1 ;
    public final void rule__TokenVisual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4562:1: ( rule__TokenVisual__Group__0__Impl rule__TokenVisual__Group__1 )
            // InternalLDef.g:4563:2: rule__TokenVisual__Group__0__Impl rule__TokenVisual__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__TokenVisual__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TokenVisual__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__Group__0"


    // $ANTLR start "rule__TokenVisual__Group__0__Impl"
    // InternalLDef.g:4570:1: rule__TokenVisual__Group__0__Impl : ( ( rule__TokenVisual__TokenAssignment_0 ) ) ;
    public final void rule__TokenVisual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4574:1: ( ( ( rule__TokenVisual__TokenAssignment_0 ) ) )
            // InternalLDef.g:4575:1: ( ( rule__TokenVisual__TokenAssignment_0 ) )
            {
            // InternalLDef.g:4575:1: ( ( rule__TokenVisual__TokenAssignment_0 ) )
            // InternalLDef.g:4576:1: ( rule__TokenVisual__TokenAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getTokenAssignment_0()); 
            }
            // InternalLDef.g:4577:1: ( rule__TokenVisual__TokenAssignment_0 )
            // InternalLDef.g:4577:2: rule__TokenVisual__TokenAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TokenVisual__TokenAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getTokenAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__Group__0__Impl"


    // $ANTLR start "rule__TokenVisual__Group__1"
    // InternalLDef.g:4587:1: rule__TokenVisual__Group__1 : rule__TokenVisual__Group__1__Impl rule__TokenVisual__Group__2 ;
    public final void rule__TokenVisual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4591:1: ( rule__TokenVisual__Group__1__Impl rule__TokenVisual__Group__2 )
            // InternalLDef.g:4592:2: rule__TokenVisual__Group__1__Impl rule__TokenVisual__Group__2
            {
            pushFollow(FOLLOW_35);
            rule__TokenVisual__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TokenVisual__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__Group__1"


    // $ANTLR start "rule__TokenVisual__Group__1__Impl"
    // InternalLDef.g:4599:1: rule__TokenVisual__Group__1__Impl : ( ( rule__TokenVisual__ColorSpecAssignment_1 ) ) ;
    public final void rule__TokenVisual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4603:1: ( ( ( rule__TokenVisual__ColorSpecAssignment_1 ) ) )
            // InternalLDef.g:4604:1: ( ( rule__TokenVisual__ColorSpecAssignment_1 ) )
            {
            // InternalLDef.g:4604:1: ( ( rule__TokenVisual__ColorSpecAssignment_1 ) )
            // InternalLDef.g:4605:1: ( rule__TokenVisual__ColorSpecAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getColorSpecAssignment_1()); 
            }
            // InternalLDef.g:4606:1: ( rule__TokenVisual__ColorSpecAssignment_1 )
            // InternalLDef.g:4606:2: rule__TokenVisual__ColorSpecAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TokenVisual__ColorSpecAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getColorSpecAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__Group__1__Impl"


    // $ANTLR start "rule__TokenVisual__Group__2"
    // InternalLDef.g:4616:1: rule__TokenVisual__Group__2 : rule__TokenVisual__Group__2__Impl rule__TokenVisual__Group__3 ;
    public final void rule__TokenVisual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4620:1: ( rule__TokenVisual__Group__2__Impl rule__TokenVisual__Group__3 )
            // InternalLDef.g:4621:2: rule__TokenVisual__Group__2__Impl rule__TokenVisual__Group__3
            {
            pushFollow(FOLLOW_35);
            rule__TokenVisual__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TokenVisual__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__Group__2"


    // $ANTLR start "rule__TokenVisual__Group__2__Impl"
    // InternalLDef.g:4628:1: rule__TokenVisual__Group__2__Impl : ( ( rule__TokenVisual__BoldAssignment_2 )? ) ;
    public final void rule__TokenVisual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4632:1: ( ( ( rule__TokenVisual__BoldAssignment_2 )? ) )
            // InternalLDef.g:4633:1: ( ( rule__TokenVisual__BoldAssignment_2 )? )
            {
            // InternalLDef.g:4633:1: ( ( rule__TokenVisual__BoldAssignment_2 )? )
            // InternalLDef.g:4634:1: ( rule__TokenVisual__BoldAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getBoldAssignment_2()); 
            }
            // InternalLDef.g:4635:1: ( rule__TokenVisual__BoldAssignment_2 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==48) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalLDef.g:4635:2: rule__TokenVisual__BoldAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__TokenVisual__BoldAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getBoldAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__Group__2__Impl"


    // $ANTLR start "rule__TokenVisual__Group__3"
    // InternalLDef.g:4645:1: rule__TokenVisual__Group__3 : rule__TokenVisual__Group__3__Impl ;
    public final void rule__TokenVisual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4649:1: ( rule__TokenVisual__Group__3__Impl )
            // InternalLDef.g:4650:2: rule__TokenVisual__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TokenVisual__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__Group__3"


    // $ANTLR start "rule__TokenVisual__Group__3__Impl"
    // InternalLDef.g:4656:1: rule__TokenVisual__Group__3__Impl : ( ( rule__TokenVisual__ItalicAssignment_3 )? ) ;
    public final void rule__TokenVisual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4660:1: ( ( ( rule__TokenVisual__ItalicAssignment_3 )? ) )
            // InternalLDef.g:4661:1: ( ( rule__TokenVisual__ItalicAssignment_3 )? )
            {
            // InternalLDef.g:4661:1: ( ( rule__TokenVisual__ItalicAssignment_3 )? )
            // InternalLDef.g:4662:1: ( rule__TokenVisual__ItalicAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getItalicAssignment_3()); 
            }
            // InternalLDef.g:4663:1: ( rule__TokenVisual__ItalicAssignment_3 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==49) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalLDef.g:4663:2: rule__TokenVisual__ItalicAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__TokenVisual__ItalicAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getItalicAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__Group__3__Impl"


    // $ANTLR start "rule__LexicalPartitionHighlighting_JS__Group__0"
    // InternalLDef.g:4681:1: rule__LexicalPartitionHighlighting_JS__Group__0 : rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1 ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4685:1: ( rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1 )
            // InternalLDef.g:4686:2: rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__LexicalPartitionHighlighting_JS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4693:1: rule__LexicalPartitionHighlighting_JS__Group__0__Impl : ( 'script' ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4697:1: ( ( 'script' ) )
            // InternalLDef.g:4698:1: ( 'script' )
            {
            // InternalLDef.g:4698:1: ( 'script' )
            // InternalLDef.g:4699:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:4712:1: rule__LexicalPartitionHighlighting_JS__Group__1 : rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2 ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4716:1: ( rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2 )
            // InternalLDef.g:4717:2: rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__LexicalPartitionHighlighting_JS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4724:1: rule__LexicalPartitionHighlighting_JS__Group__1__Impl : ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4728:1: ( ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) ) )
            // InternalLDef.g:4729:1: ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) )
            {
            // InternalLDef.g:4729:1: ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) )
            // InternalLDef.g:4730:1: ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionAssignment_1()); 
            }
            // InternalLDef.g:4731:1: ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 )
            // InternalLDef.g:4731:2: rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4741:1: rule__LexicalPartitionHighlighting_JS__Group__2 : rule__LexicalPartitionHighlighting_JS__Group__2__Impl ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4745:1: ( rule__LexicalPartitionHighlighting_JS__Group__2__Impl )
            // InternalLDef.g:4746:2: rule__LexicalPartitionHighlighting_JS__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4752:1: rule__LexicalPartitionHighlighting_JS__Group__2__Impl : ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4756:1: ( ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) ) )
            // InternalLDef.g:4757:1: ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) )
            {
            // InternalLDef.g:4757:1: ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) )
            // InternalLDef.g:4758:1: ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURIAssignment_2()); 
            }
            // InternalLDef.g:4759:1: ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 )
            // InternalLDef.g:4759:2: rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4775:1: rule__LexicalPartitionHighlighting_Rule__Group__0 : rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4779:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1 )
            // InternalLDef.g:4780:2: rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__LexicalPartitionHighlighting_Rule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4787:1: rule__LexicalPartitionHighlighting_Rule__Group__0__Impl : ( 'rule' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4791:1: ( ( 'rule' ) )
            // InternalLDef.g:4792:1: ( 'rule' )
            {
            // InternalLDef.g:4792:1: ( 'rule' )
            // InternalLDef.g:4793:1: 'rule'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:4806:1: rule__LexicalPartitionHighlighting_Rule__Group__1 : rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4810:1: ( rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2 )
            // InternalLDef.g:4811:2: rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2
            {
            pushFollow(FOLLOW_36);
            rule__LexicalPartitionHighlighting_Rule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4818:1: rule__LexicalPartitionHighlighting_Rule__Group__1__Impl : ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4822:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) ) )
            // InternalLDef.g:4823:1: ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) )
            {
            // InternalLDef.g:4823:1: ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) )
            // InternalLDef.g:4824:1: ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionAssignment_1()); 
            }
            // InternalLDef.g:4825:1: ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 )
            // InternalLDef.g:4825:2: rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4835:1: rule__LexicalPartitionHighlighting_Rule__Group__2 : rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4839:1: ( rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3 )
            // InternalLDef.g:4840:2: rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3
            {
            pushFollow(FOLLOW_36);
            rule__LexicalPartitionHighlighting_Rule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4847:1: rule__LexicalPartitionHighlighting_Rule__Group__2__Impl : ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4851:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? ) )
            // InternalLDef.g:4852:1: ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? )
            {
            // InternalLDef.g:4852:1: ( ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )? )
            // InternalLDef.g:4853:1: ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceAssignment_2()); 
            }
            // InternalLDef.g:4854:1: ( rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==47) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalLDef.g:4854:2: rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4864:1: rule__LexicalPartitionHighlighting_Rule__Group__3 : rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4868:1: ( rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4 )
            // InternalLDef.g:4869:2: rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4
            {
            pushFollow(FOLLOW_37);
            rule__LexicalPartitionHighlighting_Rule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4876:1: rule__LexicalPartitionHighlighting_Rule__Group__3__Impl : ( '{' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4880:1: ( ( '{' ) )
            // InternalLDef.g:4881:1: ( '{' )
            {
            // InternalLDef.g:4881:1: ( '{' )
            // InternalLDef.g:4882:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:4895:1: rule__LexicalPartitionHighlighting_Rule__Group__4 : rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4899:1: ( rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5 )
            // InternalLDef.g:4900:2: rule__LexicalPartitionHighlighting_Rule__Group__4__Impl rule__LexicalPartitionHighlighting_Rule__Group__5
            {
            pushFollow(FOLLOW_14);
            rule__LexicalPartitionHighlighting_Rule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4907:1: rule__LexicalPartitionHighlighting_Rule__Group__4__Impl : ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4911:1: ( ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) ) )
            // InternalLDef.g:4912:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) )
            {
            // InternalLDef.g:4912:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* ) )
            // InternalLDef.g:4913:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* )
            {
            // InternalLDef.g:4913:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 ) )
            // InternalLDef.g:4914:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }
            // InternalLDef.g:4915:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )
            // InternalLDef.g:4915:2: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4
            {
            pushFollow(FOLLOW_38);
            rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }

            }

            // InternalLDef.g:4918:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )* )
            // InternalLDef.g:4919:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_4()); 
            }
            // InternalLDef.g:4920:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID||LA37_0==50) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalLDef.g:4920:2: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalLDef.g:4931:1: rule__LexicalPartitionHighlighting_Rule__Group__5 : rule__LexicalPartitionHighlighting_Rule__Group__5__Impl ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4935:1: ( rule__LexicalPartitionHighlighting_Rule__Group__5__Impl )
            // InternalLDef.g:4936:2: rule__LexicalPartitionHighlighting_Rule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4942:1: rule__LexicalPartitionHighlighting_Rule__Group__5__Impl : ( '}' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4946:1: ( ( '}' ) )
            // InternalLDef.g:4947:1: ( '}' )
            {
            // InternalLDef.g:4947:1: ( '}' )
            // InternalLDef.g:4948:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:4973:1: rule__Token__Group__0 : rule__Token__Group__0__Impl rule__Token__Group__1 ;
    public final void rule__Token__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4977:1: ( rule__Token__Group__0__Impl rule__Token__Group__1 )
            // InternalLDef.g:4978:2: rule__Token__Group__0__Impl rule__Token__Group__1
            {
            pushFollow(FOLLOW_37);
            rule__Token__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:4985:1: rule__Token__Group__0__Impl : ( ( rule__Token__DefaultAssignment_0 )? ) ;
    public final void rule__Token__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:4989:1: ( ( ( rule__Token__DefaultAssignment_0 )? ) )
            // InternalLDef.g:4990:1: ( ( rule__Token__DefaultAssignment_0 )? )
            {
            // InternalLDef.g:4990:1: ( ( rule__Token__DefaultAssignment_0 )? )
            // InternalLDef.g:4991:1: ( rule__Token__DefaultAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultAssignment_0()); 
            }
            // InternalLDef.g:4992:1: ( rule__Token__DefaultAssignment_0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==50) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalLDef.g:4992:2: rule__Token__DefaultAssignment_0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5002:1: rule__Token__Group__1 : rule__Token__Group__1__Impl rule__Token__Group__2 ;
    public final void rule__Token__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5006:1: ( rule__Token__Group__1__Impl rule__Token__Group__2 )
            // InternalLDef.g:5007:2: rule__Token__Group__1__Impl rule__Token__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__Token__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5014:1: rule__Token__Group__1__Impl : ( ( rule__Token__NameAssignment_1 ) ) ;
    public final void rule__Token__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5018:1: ( ( ( rule__Token__NameAssignment_1 ) ) )
            // InternalLDef.g:5019:1: ( ( rule__Token__NameAssignment_1 ) )
            {
            // InternalLDef.g:5019:1: ( ( rule__Token__NameAssignment_1 ) )
            // InternalLDef.g:5020:1: ( rule__Token__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getNameAssignment_1()); 
            }
            // InternalLDef.g:5021:1: ( rule__Token__NameAssignment_1 )
            // InternalLDef.g:5021:2: rule__Token__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5031:1: rule__Token__Group__2 : rule__Token__Group__2__Impl ;
    public final void rule__Token__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5035:1: ( rule__Token__Group__2__Impl )
            // InternalLDef.g:5036:2: rule__Token__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5042:1: rule__Token__Group__2__Impl : ( ( rule__Token__Group_2__0 )? ) ;
    public final void rule__Token__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5046:1: ( ( ( rule__Token__Group_2__0 )? ) )
            // InternalLDef.g:5047:1: ( ( rule__Token__Group_2__0 )? )
            {
            // InternalLDef.g:5047:1: ( ( rule__Token__Group_2__0 )? )
            // InternalLDef.g:5048:1: ( rule__Token__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getGroup_2()); 
            }
            // InternalLDef.g:5049:1: ( rule__Token__Group_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==19) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalLDef.g:5049:2: rule__Token__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5065:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5069:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // InternalLDef.g:5070:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
            {
            pushFollow(FOLLOW_39);
            rule__Token__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5077:1: rule__Token__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5081:1: ( ( '{' ) )
            // InternalLDef.g:5082:1: ( '{' )
            {
            // InternalLDef.g:5082:1: ( '{' )
            // InternalLDef.g:5083:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5096:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl rule__Token__Group_2__2 ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5100:1: ( rule__Token__Group_2__1__Impl rule__Token__Group_2__2 )
            // InternalLDef.g:5101:2: rule__Token__Group_2__1__Impl rule__Token__Group_2__2
            {
            pushFollow(FOLLOW_14);
            rule__Token__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5108:1: rule__Token__Group_2__1__Impl : ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5112:1: ( ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) ) )
            // InternalLDef.g:5113:1: ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) )
            {
            // InternalLDef.g:5113:1: ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) )
            // InternalLDef.g:5114:1: ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* )
            {
            // InternalLDef.g:5114:1: ( ( rule__Token__ScannerListAssignment_2_1 ) )
            // InternalLDef.g:5115:1: ( rule__Token__ScannerListAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }
            // InternalLDef.g:5116:1: ( rule__Token__ScannerListAssignment_2_1 )
            // InternalLDef.g:5116:2: rule__Token__ScannerListAssignment_2_1
            {
            pushFollow(FOLLOW_40);
            rule__Token__ScannerListAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }

            }

            // InternalLDef.g:5119:1: ( ( rule__Token__ScannerListAssignment_2_1 )* )
            // InternalLDef.g:5120:1: ( rule__Token__ScannerListAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            }
            // InternalLDef.g:5121:1: ( rule__Token__ScannerListAssignment_2_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==28||LA40_0==30||LA40_0==35||LA40_0==39||LA40_0==42||LA40_0==44) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalLDef.g:5121:2: rule__Token__ScannerListAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_40);
            	    rule__Token__ScannerListAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop40;
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
    // InternalLDef.g:5132:1: rule__Token__Group_2__2 : rule__Token__Group_2__2__Impl ;
    public final void rule__Token__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5136:1: ( rule__Token__Group_2__2__Impl )
            // InternalLDef.g:5137:2: rule__Token__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5143:1: rule__Token__Group_2__2__Impl : ( '}' ) ;
    public final void rule__Token__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5147:1: ( ( '}' ) )
            // InternalLDef.g:5148:1: ( '}' )
            {
            // InternalLDef.g:5148:1: ( '}' )
            // InternalLDef.g:5149:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5168:1: rule__Scanner_Keyword__Group__0 : rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1 ;
    public final void rule__Scanner_Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5172:1: ( rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1 )
            // InternalLDef.g:5173:2: rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__Scanner_Keyword__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5180:1: rule__Scanner_Keyword__Group__0__Impl : ( 'keywords' ) ;
    public final void rule__Scanner_Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5184:1: ( ( 'keywords' ) )
            // InternalLDef.g:5185:1: ( 'keywords' )
            {
            // InternalLDef.g:5185:1: ( 'keywords' )
            // InternalLDef.g:5186:1: 'keywords'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0()); 
            }
            match(input,39,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5199:1: rule__Scanner_Keyword__Group__1 : rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2 ;
    public final void rule__Scanner_Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5203:1: ( rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2 )
            // InternalLDef.g:5204:2: rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_Keyword__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5211:1: rule__Scanner_Keyword__Group__1__Impl : ( '[' ) ;
    public final void rule__Scanner_Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5215:1: ( ( '[' ) )
            // InternalLDef.g:5216:1: ( '[' )
            {
            // InternalLDef.g:5216:1: ( '[' )
            // InternalLDef.g:5217:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5230:1: rule__Scanner_Keyword__Group__2 : rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3 ;
    public final void rule__Scanner_Keyword__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5234:1: ( rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3 )
            // InternalLDef.g:5235:2: rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3
            {
            pushFollow(FOLLOW_42);
            rule__Scanner_Keyword__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5242:1: rule__Scanner_Keyword__Group__2__Impl : ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) ) ;
    public final void rule__Scanner_Keyword__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5246:1: ( ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) ) )
            // InternalLDef.g:5247:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) )
            {
            // InternalLDef.g:5247:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) )
            // InternalLDef.g:5248:1: ( rule__Scanner_Keyword__KeywordsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_2()); 
            }
            // InternalLDef.g:5249:1: ( rule__Scanner_Keyword__KeywordsAssignment_2 )
            // InternalLDef.g:5249:2: rule__Scanner_Keyword__KeywordsAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5259:1: rule__Scanner_Keyword__Group__3 : rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4 ;
    public final void rule__Scanner_Keyword__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5263:1: ( rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4 )
            // InternalLDef.g:5264:2: rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4
            {
            pushFollow(FOLLOW_42);
            rule__Scanner_Keyword__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5271:1: rule__Scanner_Keyword__Group__3__Impl : ( ( rule__Scanner_Keyword__Group_3__0 )* ) ;
    public final void rule__Scanner_Keyword__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5275:1: ( ( ( rule__Scanner_Keyword__Group_3__0 )* ) )
            // InternalLDef.g:5276:1: ( ( rule__Scanner_Keyword__Group_3__0 )* )
            {
            // InternalLDef.g:5276:1: ( ( rule__Scanner_Keyword__Group_3__0 )* )
            // InternalLDef.g:5277:1: ( rule__Scanner_Keyword__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getGroup_3()); 
            }
            // InternalLDef.g:5278:1: ( rule__Scanner_Keyword__Group_3__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==40) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalLDef.g:5278:2: rule__Scanner_Keyword__Group_3__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__Scanner_Keyword__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // InternalLDef.g:5288:1: rule__Scanner_Keyword__Group__4 : rule__Scanner_Keyword__Group__4__Impl ;
    public final void rule__Scanner_Keyword__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5292:1: ( rule__Scanner_Keyword__Group__4__Impl )
            // InternalLDef.g:5293:2: rule__Scanner_Keyword__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5299:1: rule__Scanner_Keyword__Group__4__Impl : ( ']' ) ;
    public final void rule__Scanner_Keyword__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5303:1: ( ( ']' ) )
            // InternalLDef.g:5304:1: ( ']' )
            {
            // InternalLDef.g:5304:1: ( ']' )
            // InternalLDef.g:5305:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,14,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5328:1: rule__Scanner_Keyword__Group_3__0 : rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1 ;
    public final void rule__Scanner_Keyword__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5332:1: ( rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1 )
            // InternalLDef.g:5333:2: rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_Keyword__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5340:1: rule__Scanner_Keyword__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Scanner_Keyword__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5344:1: ( ( ',' ) )
            // InternalLDef.g:5345:1: ( ',' )
            {
            // InternalLDef.g:5345:1: ( ',' )
            // InternalLDef.g:5346:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5359:1: rule__Scanner_Keyword__Group_3__1 : rule__Scanner_Keyword__Group_3__1__Impl ;
    public final void rule__Scanner_Keyword__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5363:1: ( rule__Scanner_Keyword__Group_3__1__Impl )
            // InternalLDef.g:5364:2: rule__Scanner_Keyword__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5370:1: rule__Scanner_Keyword__Group_3__1__Impl : ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) ) ;
    public final void rule__Scanner_Keyword__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5374:1: ( ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) ) )
            // InternalLDef.g:5375:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) )
            {
            // InternalLDef.g:5375:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) )
            // InternalLDef.g:5376:1: ( rule__Scanner_Keyword__KeywordsAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_3_1()); 
            }
            // InternalLDef.g:5377:1: ( rule__Scanner_Keyword__KeywordsAssignment_3_1 )
            // InternalLDef.g:5377:2: rule__Scanner_Keyword__KeywordsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5391:1: rule__Keyword__Group__0 : rule__Keyword__Group__0__Impl rule__Keyword__Group__1 ;
    public final void rule__Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5395:1: ( rule__Keyword__Group__0__Impl rule__Keyword__Group__1 )
            // InternalLDef.g:5396:2: rule__Keyword__Group__0__Impl rule__Keyword__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__Keyword__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5403:1: rule__Keyword__Group__0__Impl : ( ( rule__Keyword__NameAssignment_0 ) ) ;
    public final void rule__Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5407:1: ( ( ( rule__Keyword__NameAssignment_0 ) ) )
            // InternalLDef.g:5408:1: ( ( rule__Keyword__NameAssignment_0 ) )
            {
            // InternalLDef.g:5408:1: ( ( rule__Keyword__NameAssignment_0 ) )
            // InternalLDef.g:5409:1: ( rule__Keyword__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            }
            // InternalLDef.g:5410:1: ( rule__Keyword__NameAssignment_0 )
            // InternalLDef.g:5410:2: rule__Keyword__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5420:1: rule__Keyword__Group__1 : rule__Keyword__Group__1__Impl ;
    public final void rule__Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5424:1: ( rule__Keyword__Group__1__Impl )
            // InternalLDef.g:5425:2: rule__Keyword__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5431:1: rule__Keyword__Group__1__Impl : ( ( rule__Keyword__Group_1__0 )? ) ;
    public final void rule__Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5435:1: ( ( ( rule__Keyword__Group_1__0 )? ) )
            // InternalLDef.g:5436:1: ( ( rule__Keyword__Group_1__0 )? )
            {
            // InternalLDef.g:5436:1: ( ( rule__Keyword__Group_1__0 )? )
            // InternalLDef.g:5437:1: ( rule__Keyword__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getGroup_1()); 
            }
            // InternalLDef.g:5438:1: ( rule__Keyword__Group_1__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==41) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalLDef.g:5438:2: rule__Keyword__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5452:1: rule__Keyword__Group_1__0 : rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 ;
    public final void rule__Keyword__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5456:1: ( rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 )
            // InternalLDef.g:5457:2: rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1
            {
            pushFollow(FOLLOW_18);
            rule__Keyword__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5464:1: rule__Keyword__Group_1__0__Impl : ( 'since' ) ;
    public final void rule__Keyword__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5468:1: ( ( 'since' ) )
            // InternalLDef.g:5469:1: ( 'since' )
            {
            // InternalLDef.g:5469:1: ( 'since' )
            // InternalLDef.g:5470:1: 'since'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5483:1: rule__Keyword__Group_1__1 : rule__Keyword__Group_1__1__Impl ;
    public final void rule__Keyword__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5487:1: ( rule__Keyword__Group_1__1__Impl )
            // InternalLDef.g:5488:2: rule__Keyword__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5494:1: rule__Keyword__Group_1__1__Impl : ( ( rule__Keyword__VersionAssignment_1_1 ) ) ;
    public final void rule__Keyword__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5498:1: ( ( ( rule__Keyword__VersionAssignment_1_1 ) ) )
            // InternalLDef.g:5499:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            {
            // InternalLDef.g:5499:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            // InternalLDef.g:5500:1: ( rule__Keyword__VersionAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            }
            // InternalLDef.g:5501:1: ( rule__Keyword__VersionAssignment_1_1 )
            // InternalLDef.g:5501:2: rule__Keyword__VersionAssignment_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5515:1: rule__Scanner_SingleLineRule__Group__0 : rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1 ;
    public final void rule__Scanner_SingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5519:1: ( rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1 )
            // InternalLDef.g:5520:2: rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_SingleLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5527:1: rule__Scanner_SingleLineRule__Group__0__Impl : ( 'single_line' ) ;
    public final void rule__Scanner_SingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5531:1: ( ( 'single_line' ) )
            // InternalLDef.g:5532:1: ( 'single_line' )
            {
            // InternalLDef.g:5532:1: ( 'single_line' )
            // InternalLDef.g:5533:1: 'single_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5546:1: rule__Scanner_SingleLineRule__Group__1 : rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2 ;
    public final void rule__Scanner_SingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5550:1: ( rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2 )
            // InternalLDef.g:5551:2: rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__Scanner_SingleLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5558:1: rule__Scanner_SingleLineRule__Group__1__Impl : ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5562:1: ( ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) ) )
            // InternalLDef.g:5563:1: ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) )
            {
            // InternalLDef.g:5563:1: ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) )
            // InternalLDef.g:5564:1: ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqAssignment_1()); 
            }
            // InternalLDef.g:5565:1: ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 )
            // InternalLDef.g:5565:2: rule__Scanner_SingleLineRule__StartSeqAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5575:1: rule__Scanner_SingleLineRule__Group__2 : rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3 ;
    public final void rule__Scanner_SingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5579:1: ( rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3 )
            // InternalLDef.g:5580:2: rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__Scanner_SingleLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5587:1: rule__Scanner_SingleLineRule__Group__2__Impl : ( ( rule__Scanner_SingleLineRule__Group_2__0 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5591:1: ( ( ( rule__Scanner_SingleLineRule__Group_2__0 )? ) )
            // InternalLDef.g:5592:1: ( ( rule__Scanner_SingleLineRule__Group_2__0 )? )
            {
            // InternalLDef.g:5592:1: ( ( rule__Scanner_SingleLineRule__Group_2__0 )? )
            // InternalLDef.g:5593:1: ( rule__Scanner_SingleLineRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_2()); 
            }
            // InternalLDef.g:5594:1: ( rule__Scanner_SingleLineRule__Group_2__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==31) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalLDef.g:5594:2: rule__Scanner_SingleLineRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5604:1: rule__Scanner_SingleLineRule__Group__3 : rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4 ;
    public final void rule__Scanner_SingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5608:1: ( rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4 )
            // InternalLDef.g:5609:2: rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__Scanner_SingleLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5616:1: rule__Scanner_SingleLineRule__Group__3__Impl : ( ( rule__Scanner_SingleLineRule__Group_3__0 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5620:1: ( ( ( rule__Scanner_SingleLineRule__Group_3__0 )? ) )
            // InternalLDef.g:5621:1: ( ( rule__Scanner_SingleLineRule__Group_3__0 )? )
            {
            // InternalLDef.g:5621:1: ( ( rule__Scanner_SingleLineRule__Group_3__0 )? )
            // InternalLDef.g:5622:1: ( rule__Scanner_SingleLineRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_3()); 
            }
            // InternalLDef.g:5623:1: ( rule__Scanner_SingleLineRule__Group_3__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==32) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalLDef.g:5623:2: rule__Scanner_SingleLineRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__4"
    // InternalLDef.g:5633:1: rule__Scanner_SingleLineRule__Group__4 : rule__Scanner_SingleLineRule__Group__4__Impl ;
    public final void rule__Scanner_SingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5637:1: ( rule__Scanner_SingleLineRule__Group__4__Impl )
            // InternalLDef.g:5638:2: rule__Scanner_SingleLineRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5644:1: rule__Scanner_SingleLineRule__Group__4__Impl : ( ( rule__Scanner_SingleLineRule__Group_4__0 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5648:1: ( ( ( rule__Scanner_SingleLineRule__Group_4__0 )? ) )
            // InternalLDef.g:5649:1: ( ( rule__Scanner_SingleLineRule__Group_4__0 )? )
            {
            // InternalLDef.g:5649:1: ( ( rule__Scanner_SingleLineRule__Group_4__0 )? )
            // InternalLDef.g:5650:1: ( rule__Scanner_SingleLineRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_4()); 
            }
            // InternalLDef.g:5651:1: ( rule__Scanner_SingleLineRule__Group_4__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==33) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalLDef.g:5651:2: rule__Scanner_SingleLineRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_2__0"
    // InternalLDef.g:5671:1: rule__Scanner_SingleLineRule__Group_2__0 : rule__Scanner_SingleLineRule__Group_2__0__Impl rule__Scanner_SingleLineRule__Group_2__1 ;
    public final void rule__Scanner_SingleLineRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5675:1: ( rule__Scanner_SingleLineRule__Group_2__0__Impl rule__Scanner_SingleLineRule__Group_2__1 )
            // InternalLDef.g:5676:2: rule__Scanner_SingleLineRule__Group_2__0__Impl rule__Scanner_SingleLineRule__Group_2__1
            {
            pushFollow(FOLLOW_28);
            rule__Scanner_SingleLineRule__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5683:1: rule__Scanner_SingleLineRule__Group_2__0__Impl : ( 'col' ) ;
    public final void rule__Scanner_SingleLineRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5687:1: ( ( 'col' ) )
            // InternalLDef.g:5688:1: ( 'col' )
            {
            // InternalLDef.g:5688:1: ( 'col' )
            // InternalLDef.g:5689:1: 'col'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getColKeyword_2_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getColKeyword_2_0()); 
            }

            }


            }

        }
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
    // InternalLDef.g:5702:1: rule__Scanner_SingleLineRule__Group_2__1 : rule__Scanner_SingleLineRule__Group_2__1__Impl ;
    public final void rule__Scanner_SingleLineRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5706:1: ( rule__Scanner_SingleLineRule__Group_2__1__Impl )
            // InternalLDef.g:5707:2: rule__Scanner_SingleLineRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5713:1: rule__Scanner_SingleLineRule__Group_2__1__Impl : ( ( rule__Scanner_SingleLineRule__CheckAssignment_2_1 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5717:1: ( ( ( rule__Scanner_SingleLineRule__CheckAssignment_2_1 ) ) )
            // InternalLDef.g:5718:1: ( ( rule__Scanner_SingleLineRule__CheckAssignment_2_1 ) )
            {
            // InternalLDef.g:5718:1: ( ( rule__Scanner_SingleLineRule__CheckAssignment_2_1 ) )
            // InternalLDef.g:5719:1: ( rule__Scanner_SingleLineRule__CheckAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getCheckAssignment_2_1()); 
            }
            // InternalLDef.g:5720:1: ( rule__Scanner_SingleLineRule__CheckAssignment_2_1 )
            // InternalLDef.g:5720:2: rule__Scanner_SingleLineRule__CheckAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_SingleLineRule__CheckAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getCheckAssignment_2_1()); 
            }

            }


            }

        }
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
    // InternalLDef.g:5734:1: rule__Scanner_SingleLineRule__Group_3__0 : rule__Scanner_SingleLineRule__Group_3__0__Impl rule__Scanner_SingleLineRule__Group_3__1 ;
    public final void rule__Scanner_SingleLineRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5738:1: ( rule__Scanner_SingleLineRule__Group_3__0__Impl rule__Scanner_SingleLineRule__Group_3__1 )
            // InternalLDef.g:5739:2: rule__Scanner_SingleLineRule__Group_3__0__Impl rule__Scanner_SingleLineRule__Group_3__1
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_SingleLineRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5746:1: rule__Scanner_SingleLineRule__Group_3__0__Impl : ( '=>' ) ;
    public final void rule__Scanner_SingleLineRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5750:1: ( ( '=>' ) )
            // InternalLDef.g:5751:1: ( '=>' )
            {
            // InternalLDef.g:5751:1: ( '=>' )
            // InternalLDef.g:5752:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3_0()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3_0()); 
            }

            }


            }

        }
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
    // InternalLDef.g:5765:1: rule__Scanner_SingleLineRule__Group_3__1 : rule__Scanner_SingleLineRule__Group_3__1__Impl ;
    public final void rule__Scanner_SingleLineRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5769:1: ( rule__Scanner_SingleLineRule__Group_3__1__Impl )
            // InternalLDef.g:5770:2: rule__Scanner_SingleLineRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_SingleLineRule__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalLDef.g:5776:1: rule__Scanner_SingleLineRule__Group_3__1__Impl : ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3_1 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5780:1: ( ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3_1 )? ) )
            // InternalLDef.g:5781:1: ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3_1 )? )
            {
            // InternalLDef.g:5781:1: ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3_1 )? )
            // InternalLDef.g:5782:1: ( rule__Scanner_SingleLineRule__EndSeqAssignment_3_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqAssignment_3_1()); 
            }
            // InternalLDef.g:5783:1: ( rule__Scanner_SingleLineRule__EndSeqAssignment_3_1 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_STRING) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalLDef.g:5783:2: rule__Scanner_SingleLineRule__EndSeqAssignment_3_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Scanner_SingleLineRule__EndSeqAssignment_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqAssignment_3_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Scanner_SingleLineRule__Group_4__0"
    // InternalLDef.g:5797:1: rule__Scanner_SingleLineRule__Group_4__0 : rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1 ;
    public final void rule__Scanner_SingleLineRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5801:1: ( rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1 )
            // InternalLDef.g:5802:2: rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1
            {
            pushFollow(FOLLOW_29);
            rule__Scanner_SingleLineRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5809:1: rule__Scanner_SingleLineRule__Group_4__0__Impl : ( 'escaped' ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5813:1: ( ( 'escaped' ) )
            // InternalLDef.g:5814:1: ( 'escaped' )
            {
            // InternalLDef.g:5814:1: ( 'escaped' )
            // InternalLDef.g:5815:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_4_0()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5828:1: rule__Scanner_SingleLineRule__Group_4__1 : rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2 ;
    public final void rule__Scanner_SingleLineRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5832:1: ( rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2 )
            // InternalLDef.g:5833:2: rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_SingleLineRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5840:1: rule__Scanner_SingleLineRule__Group_4__1__Impl : ( 'by' ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5844:1: ( ( 'by' ) )
            // InternalLDef.g:5845:1: ( 'by' )
            {
            // InternalLDef.g:5845:1: ( 'by' )
            // InternalLDef.g:5846:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_4_1()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5859:1: rule__Scanner_SingleLineRule__Group_4__2 : rule__Scanner_SingleLineRule__Group_4__2__Impl ;
    public final void rule__Scanner_SingleLineRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5863:1: ( rule__Scanner_SingleLineRule__Group_4__2__Impl )
            // InternalLDef.g:5864:2: rule__Scanner_SingleLineRule__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5870:1: rule__Scanner_SingleLineRule__Group_4__2__Impl : ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5874:1: ( ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) ) )
            // InternalLDef.g:5875:1: ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) )
            {
            // InternalLDef.g:5875:1: ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) )
            // InternalLDef.g:5876:1: ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            }
            // InternalLDef.g:5877:1: ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 )
            // InternalLDef.g:5877:2: rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5893:1: rule__Scanner_MultiLineRule__Group__0 : rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1 ;
    public final void rule__Scanner_MultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5897:1: ( rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1 )
            // InternalLDef.g:5898:2: rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_MultiLineRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5905:1: rule__Scanner_MultiLineRule__Group__0__Impl : ( 'multi_line' ) ;
    public final void rule__Scanner_MultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5909:1: ( ( 'multi_line' ) )
            // InternalLDef.g:5910:1: ( 'multi_line' )
            {
            // InternalLDef.g:5910:1: ( 'multi_line' )
            // InternalLDef.g:5911:1: 'multi_line'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:5924:1: rule__Scanner_MultiLineRule__Group__1 : rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2 ;
    public final void rule__Scanner_MultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5928:1: ( rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2 )
            // InternalLDef.g:5929:2: rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2
            {
            pushFollow(FOLLOW_30);
            rule__Scanner_MultiLineRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5936:1: rule__Scanner_MultiLineRule__Group__1__Impl : ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5940:1: ( ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) ) )
            // InternalLDef.g:5941:1: ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) )
            {
            // InternalLDef.g:5941:1: ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) )
            // InternalLDef.g:5942:1: ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqAssignment_1()); 
            }
            // InternalLDef.g:5943:1: ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 )
            // InternalLDef.g:5943:2: rule__Scanner_MultiLineRule__StartSeqAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5953:1: rule__Scanner_MultiLineRule__Group__2 : rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3 ;
    public final void rule__Scanner_MultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5957:1: ( rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3 )
            // InternalLDef.g:5958:2: rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3
            {
            pushFollow(FOLLOW_30);
            rule__Scanner_MultiLineRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5965:1: rule__Scanner_MultiLineRule__Group__2__Impl : ( ( rule__Scanner_MultiLineRule__Group_2__0 )? ) ;
    public final void rule__Scanner_MultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5969:1: ( ( ( rule__Scanner_MultiLineRule__Group_2__0 )? ) )
            // InternalLDef.g:5970:1: ( ( rule__Scanner_MultiLineRule__Group_2__0 )? )
            {
            // InternalLDef.g:5970:1: ( ( rule__Scanner_MultiLineRule__Group_2__0 )? )
            // InternalLDef.g:5971:1: ( rule__Scanner_MultiLineRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup_2()); 
            }
            // InternalLDef.g:5972:1: ( rule__Scanner_MultiLineRule__Group_2__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==31) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalLDef.g:5972:2: rule__Scanner_MultiLineRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Scanner_MultiLineRule__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getGroup_2()); 
            }

            }


            }

        }
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
    // InternalLDef.g:5982:1: rule__Scanner_MultiLineRule__Group__3 : rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4 ;
    public final void rule__Scanner_MultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5986:1: ( rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4 )
            // InternalLDef.g:5987:2: rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_MultiLineRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:5994:1: rule__Scanner_MultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__Scanner_MultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:5998:1: ( ( '=>' ) )
            // InternalLDef.g:5999:1: ( '=>' )
            {
            // InternalLDef.g:5999:1: ( '=>' )
            // InternalLDef.g:6000:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            }

            }


            }

        }
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
    // InternalLDef.g:6013:1: rule__Scanner_MultiLineRule__Group__4 : rule__Scanner_MultiLineRule__Group__4__Impl rule__Scanner_MultiLineRule__Group__5 ;
    public final void rule__Scanner_MultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6017:1: ( rule__Scanner_MultiLineRule__Group__4__Impl rule__Scanner_MultiLineRule__Group__5 )
            // InternalLDef.g:6018:2: rule__Scanner_MultiLineRule__Group__4__Impl rule__Scanner_MultiLineRule__Group__5
            {
            pushFollow(FOLLOW_31);
            rule__Scanner_MultiLineRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Scanner_MultiLineRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalLDef.g:6025:1: rule__Scanner_MultiLineRule__Group__4__Impl : ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6029:1: ( ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_4 ) ) )
            // InternalLDef.g:6030:1: ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_4 ) )
            {
            // InternalLDef.g:6030:1: ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_4 ) )
            // InternalLDef.g:6031:1: ( rule__Scanner_MultiLineRule__EndSeqAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqAssignment_4()); 
            }
            // InternalLDef.g:6032:1: ( rule__Scanner_MultiLineRule__EndSeqAssignment_4 )
            // InternalLDef.g:6032:2: rule__Scanner_MultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_MultiLineRule__EndSeqAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqAssignment_4()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__5"
    // InternalLDef.g:6042:1: rule__Scanner_MultiLineRule__Group__5 : rule__Scanner_MultiLineRule__Group__5__Impl ;
    public final void rule__Scanner_MultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6046:1: ( rule__Scanner_MultiLineRule__Group__5__Impl )
            // InternalLDef.g:6047:2: rule__Scanner_MultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_MultiLineRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__5"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group__5__Impl"
    // InternalLDef.g:6053:1: rule__Scanner_MultiLineRule__Group__5__Impl : ( ( rule__Scanner_MultiLineRule__Group_5__0 )? ) ;
    public final void rule__Scanner_MultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6057:1: ( ( ( rule__Scanner_MultiLineRule__Group_5__0 )? ) )
            // InternalLDef.g:6058:1: ( ( rule__Scanner_MultiLineRule__Group_5__0 )? )
            {
            // InternalLDef.g:6058:1: ( ( rule__Scanner_MultiLineRule__Group_5__0 )? )
            // InternalLDef.g:6059:1: ( rule__Scanner_MultiLineRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup_5()); 
            }
            // InternalLDef.g:6060:1: ( rule__Scanner_MultiLineRule__Group_5__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==33) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalLDef.g:6060:2: rule__Scanner_MultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Scanner_MultiLineRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group__5__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_2__0"
    // InternalLDef.g:6082:1: rule__Scanner_MultiLineRule__Group_2__0 : rule__Scanner_MultiLineRule__Group_2__0__Impl rule__Scanner_MultiLineRule__Group_2__1 ;
    public final void rule__Scanner_MultiLineRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6086:1: ( rule__Scanner_MultiLineRule__Group_2__0__Impl rule__Scanner_MultiLineRule__Group_2__1 )
            // InternalLDef.g:6087:2: rule__Scanner_MultiLineRule__Group_2__0__Impl rule__Scanner_MultiLineRule__Group_2__1
            {
            pushFollow(FOLLOW_28);
            rule__Scanner_MultiLineRule__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Scanner_MultiLineRule__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_2__0"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_2__0__Impl"
    // InternalLDef.g:6094:1: rule__Scanner_MultiLineRule__Group_2__0__Impl : ( 'col' ) ;
    public final void rule__Scanner_MultiLineRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6098:1: ( ( 'col' ) )
            // InternalLDef.g:6099:1: ( 'col' )
            {
            // InternalLDef.g:6099:1: ( 'col' )
            // InternalLDef.g:6100:1: 'col'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getColKeyword_2_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getColKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_2__0__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_2__1"
    // InternalLDef.g:6113:1: rule__Scanner_MultiLineRule__Group_2__1 : rule__Scanner_MultiLineRule__Group_2__1__Impl ;
    public final void rule__Scanner_MultiLineRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6117:1: ( rule__Scanner_MultiLineRule__Group_2__1__Impl )
            // InternalLDef.g:6118:2: rule__Scanner_MultiLineRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_MultiLineRule__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_2__1"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_2__1__Impl"
    // InternalLDef.g:6124:1: rule__Scanner_MultiLineRule__Group_2__1__Impl : ( ( rule__Scanner_MultiLineRule__CheckAssignment_2_1 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6128:1: ( ( ( rule__Scanner_MultiLineRule__CheckAssignment_2_1 ) ) )
            // InternalLDef.g:6129:1: ( ( rule__Scanner_MultiLineRule__CheckAssignment_2_1 ) )
            {
            // InternalLDef.g:6129:1: ( ( rule__Scanner_MultiLineRule__CheckAssignment_2_1 ) )
            // InternalLDef.g:6130:1: ( rule__Scanner_MultiLineRule__CheckAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getCheckAssignment_2_1()); 
            }
            // InternalLDef.g:6131:1: ( rule__Scanner_MultiLineRule__CheckAssignment_2_1 )
            // InternalLDef.g:6131:2: rule__Scanner_MultiLineRule__CheckAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_MultiLineRule__CheckAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getCheckAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_2__1__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_5__0"
    // InternalLDef.g:6145:1: rule__Scanner_MultiLineRule__Group_5__0 : rule__Scanner_MultiLineRule__Group_5__0__Impl rule__Scanner_MultiLineRule__Group_5__1 ;
    public final void rule__Scanner_MultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6149:1: ( rule__Scanner_MultiLineRule__Group_5__0__Impl rule__Scanner_MultiLineRule__Group_5__1 )
            // InternalLDef.g:6150:2: rule__Scanner_MultiLineRule__Group_5__0__Impl rule__Scanner_MultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_29);
            rule__Scanner_MultiLineRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Scanner_MultiLineRule__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_5__0"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_5__0__Impl"
    // InternalLDef.g:6157:1: rule__Scanner_MultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__Scanner_MultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6161:1: ( ( 'escaped' ) )
            // InternalLDef.g:6162:1: ( 'escaped' )
            {
            // InternalLDef.g:6162:1: ( 'escaped' )
            // InternalLDef.g:6163:1: 'escaped'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_5_0()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_5__0__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_5__1"
    // InternalLDef.g:6176:1: rule__Scanner_MultiLineRule__Group_5__1 : rule__Scanner_MultiLineRule__Group_5__1__Impl rule__Scanner_MultiLineRule__Group_5__2 ;
    public final void rule__Scanner_MultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6180:1: ( rule__Scanner_MultiLineRule__Group_5__1__Impl rule__Scanner_MultiLineRule__Group_5__2 )
            // InternalLDef.g:6181:2: rule__Scanner_MultiLineRule__Group_5__1__Impl rule__Scanner_MultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_MultiLineRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Scanner_MultiLineRule__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_5__1"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_5__1__Impl"
    // InternalLDef.g:6188:1: rule__Scanner_MultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__Scanner_MultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6192:1: ( ( 'by' ) )
            // InternalLDef.g:6193:1: ( 'by' )
            {
            // InternalLDef.g:6193:1: ( 'by' )
            // InternalLDef.g:6194:1: 'by'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_5_1()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_5__1__Impl"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_5__2"
    // InternalLDef.g:6207:1: rule__Scanner_MultiLineRule__Group_5__2 : rule__Scanner_MultiLineRule__Group_5__2__Impl ;
    public final void rule__Scanner_MultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6211:1: ( rule__Scanner_MultiLineRule__Group_5__2__Impl )
            // InternalLDef.g:6212:2: rule__Scanner_MultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_MultiLineRule__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_5__2"


    // $ANTLR start "rule__Scanner_MultiLineRule__Group_5__2__Impl"
    // InternalLDef.g:6218:1: rule__Scanner_MultiLineRule__Group_5__2__Impl : ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6222:1: ( ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // InternalLDef.g:6223:1: ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // InternalLDef.g:6223:1: ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2 ) )
            // InternalLDef.g:6224:1: ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            }
            // InternalLDef.g:6225:1: ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2 )
            // InternalLDef.g:6225:2: rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__Group_5__2__Impl"


    // $ANTLR start "rule__Scanner_PatternRule__Group__0"
    // InternalLDef.g:6241:1: rule__Scanner_PatternRule__Group__0 : rule__Scanner_PatternRule__Group__0__Impl rule__Scanner_PatternRule__Group__1 ;
    public final void rule__Scanner_PatternRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6245:1: ( rule__Scanner_PatternRule__Group__0__Impl rule__Scanner_PatternRule__Group__1 )
            // InternalLDef.g:6246:2: rule__Scanner_PatternRule__Group__0__Impl rule__Scanner_PatternRule__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_PatternRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6253:1: rule__Scanner_PatternRule__Group__0__Impl : ( 'pattern' ) ;
    public final void rule__Scanner_PatternRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6257:1: ( ( 'pattern' ) )
            // InternalLDef.g:6258:1: ( 'pattern' )
            {
            // InternalLDef.g:6258:1: ( 'pattern' )
            // InternalLDef.g:6259:1: 'pattern'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getPatternKeyword_0()); 
            }
            match(input,42,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:6272:1: rule__Scanner_PatternRule__Group__1 : rule__Scanner_PatternRule__Group__1__Impl rule__Scanner_PatternRule__Group__2 ;
    public final void rule__Scanner_PatternRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6276:1: ( rule__Scanner_PatternRule__Group__1__Impl rule__Scanner_PatternRule__Group__2 )
            // InternalLDef.g:6277:2: rule__Scanner_PatternRule__Group__1__Impl rule__Scanner_PatternRule__Group__2
            {
            pushFollow(FOLLOW_45);
            rule__Scanner_PatternRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6284:1: rule__Scanner_PatternRule__Group__1__Impl : ( ( rule__Scanner_PatternRule__StartPatternAssignment_1 ) ) ;
    public final void rule__Scanner_PatternRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6288:1: ( ( ( rule__Scanner_PatternRule__StartPatternAssignment_1 ) ) )
            // InternalLDef.g:6289:1: ( ( rule__Scanner_PatternRule__StartPatternAssignment_1 ) )
            {
            // InternalLDef.g:6289:1: ( ( rule__Scanner_PatternRule__StartPatternAssignment_1 ) )
            // InternalLDef.g:6290:1: ( rule__Scanner_PatternRule__StartPatternAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getStartPatternAssignment_1()); 
            }
            // InternalLDef.g:6291:1: ( rule__Scanner_PatternRule__StartPatternAssignment_1 )
            // InternalLDef.g:6291:2: rule__Scanner_PatternRule__StartPatternAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6301:1: rule__Scanner_PatternRule__Group__2 : rule__Scanner_PatternRule__Group__2__Impl rule__Scanner_PatternRule__Group__3 ;
    public final void rule__Scanner_PatternRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6305:1: ( rule__Scanner_PatternRule__Group__2__Impl rule__Scanner_PatternRule__Group__3 )
            // InternalLDef.g:6306:2: rule__Scanner_PatternRule__Group__2__Impl rule__Scanner_PatternRule__Group__3
            {
            pushFollow(FOLLOW_45);
            rule__Scanner_PatternRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6313:1: rule__Scanner_PatternRule__Group__2__Impl : ( ( rule__Scanner_PatternRule__LengthAssignment_2 )? ) ;
    public final void rule__Scanner_PatternRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6317:1: ( ( ( rule__Scanner_PatternRule__LengthAssignment_2 )? ) )
            // InternalLDef.g:6318:1: ( ( rule__Scanner_PatternRule__LengthAssignment_2 )? )
            {
            // InternalLDef.g:6318:1: ( ( rule__Scanner_PatternRule__LengthAssignment_2 )? )
            // InternalLDef.g:6319:1: ( rule__Scanner_PatternRule__LengthAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getLengthAssignment_2()); 
            }
            // InternalLDef.g:6320:1: ( rule__Scanner_PatternRule__LengthAssignment_2 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_INT) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalLDef.g:6320:2: rule__Scanner_PatternRule__LengthAssignment_2
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6330:1: rule__Scanner_PatternRule__Group__3 : rule__Scanner_PatternRule__Group__3__Impl rule__Scanner_PatternRule__Group__4 ;
    public final void rule__Scanner_PatternRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6334:1: ( rule__Scanner_PatternRule__Group__3__Impl rule__Scanner_PatternRule__Group__4 )
            // InternalLDef.g:6335:2: rule__Scanner_PatternRule__Group__3__Impl rule__Scanner_PatternRule__Group__4
            {
            pushFollow(FOLLOW_45);
            rule__Scanner_PatternRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6342:1: rule__Scanner_PatternRule__Group__3__Impl : ( ( rule__Scanner_PatternRule__Group_3__0 )? ) ;
    public final void rule__Scanner_PatternRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6346:1: ( ( ( rule__Scanner_PatternRule__Group_3__0 )? ) )
            // InternalLDef.g:6347:1: ( ( rule__Scanner_PatternRule__Group_3__0 )? )
            {
            // InternalLDef.g:6347:1: ( ( rule__Scanner_PatternRule__Group_3__0 )? )
            // InternalLDef.g:6348:1: ( rule__Scanner_PatternRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getGroup_3()); 
            }
            // InternalLDef.g:6349:1: ( rule__Scanner_PatternRule__Group_3__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==31) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalLDef.g:6349:2: rule__Scanner_PatternRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Scanner_PatternRule__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getGroup_3()); 
            }

            }


            }

        }
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
    // InternalLDef.g:6359:1: rule__Scanner_PatternRule__Group__4 : rule__Scanner_PatternRule__Group__4__Impl rule__Scanner_PatternRule__Group__5 ;
    public final void rule__Scanner_PatternRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6363:1: ( rule__Scanner_PatternRule__Group__4__Impl rule__Scanner_PatternRule__Group__5 )
            // InternalLDef.g:6364:2: rule__Scanner_PatternRule__Group__4__Impl rule__Scanner_PatternRule__Group__5
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_PatternRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Scanner_PatternRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalLDef.g:6371:1: rule__Scanner_PatternRule__Group__4__Impl : ( 'containing' ) ;
    public final void rule__Scanner_PatternRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6375:1: ( ( 'containing' ) )
            // InternalLDef.g:6376:1: ( 'containing' )
            {
            // InternalLDef.g:6376:1: ( 'containing' )
            // InternalLDef.g:6377:1: 'containing'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getContainingKeyword_4()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getContainingKeyword_4()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Scanner_PatternRule__Group__5"
    // InternalLDef.g:6390:1: rule__Scanner_PatternRule__Group__5 : rule__Scanner_PatternRule__Group__5__Impl ;
    public final void rule__Scanner_PatternRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6394:1: ( rule__Scanner_PatternRule__Group__5__Impl )
            // InternalLDef.g:6395:2: rule__Scanner_PatternRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_PatternRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_PatternRule__Group__5"


    // $ANTLR start "rule__Scanner_PatternRule__Group__5__Impl"
    // InternalLDef.g:6401:1: rule__Scanner_PatternRule__Group__5__Impl : ( ( rule__Scanner_PatternRule__ContentPatternAssignment_5 ) ) ;
    public final void rule__Scanner_PatternRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6405:1: ( ( ( rule__Scanner_PatternRule__ContentPatternAssignment_5 ) ) )
            // InternalLDef.g:6406:1: ( ( rule__Scanner_PatternRule__ContentPatternAssignment_5 ) )
            {
            // InternalLDef.g:6406:1: ( ( rule__Scanner_PatternRule__ContentPatternAssignment_5 ) )
            // InternalLDef.g:6407:1: ( rule__Scanner_PatternRule__ContentPatternAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getContentPatternAssignment_5()); 
            }
            // InternalLDef.g:6408:1: ( rule__Scanner_PatternRule__ContentPatternAssignment_5 )
            // InternalLDef.g:6408:2: rule__Scanner_PatternRule__ContentPatternAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_PatternRule__ContentPatternAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getContentPatternAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_PatternRule__Group__5__Impl"


    // $ANTLR start "rule__Scanner_PatternRule__Group_3__0"
    // InternalLDef.g:6430:1: rule__Scanner_PatternRule__Group_3__0 : rule__Scanner_PatternRule__Group_3__0__Impl rule__Scanner_PatternRule__Group_3__1 ;
    public final void rule__Scanner_PatternRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6434:1: ( rule__Scanner_PatternRule__Group_3__0__Impl rule__Scanner_PatternRule__Group_3__1 )
            // InternalLDef.g:6435:2: rule__Scanner_PatternRule__Group_3__0__Impl rule__Scanner_PatternRule__Group_3__1
            {
            pushFollow(FOLLOW_28);
            rule__Scanner_PatternRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Scanner_PatternRule__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_PatternRule__Group_3__0"


    // $ANTLR start "rule__Scanner_PatternRule__Group_3__0__Impl"
    // InternalLDef.g:6442:1: rule__Scanner_PatternRule__Group_3__0__Impl : ( 'col' ) ;
    public final void rule__Scanner_PatternRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6446:1: ( ( 'col' ) )
            // InternalLDef.g:6447:1: ( 'col' )
            {
            // InternalLDef.g:6447:1: ( 'col' )
            // InternalLDef.g:6448:1: 'col'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getColKeyword_3_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getColKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_PatternRule__Group_3__0__Impl"


    // $ANTLR start "rule__Scanner_PatternRule__Group_3__1"
    // InternalLDef.g:6461:1: rule__Scanner_PatternRule__Group_3__1 : rule__Scanner_PatternRule__Group_3__1__Impl ;
    public final void rule__Scanner_PatternRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6465:1: ( rule__Scanner_PatternRule__Group_3__1__Impl )
            // InternalLDef.g:6466:2: rule__Scanner_PatternRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_PatternRule__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_PatternRule__Group_3__1"


    // $ANTLR start "rule__Scanner_PatternRule__Group_3__1__Impl"
    // InternalLDef.g:6472:1: rule__Scanner_PatternRule__Group_3__1__Impl : ( ( rule__Scanner_PatternRule__CheckAssignment_3_1 ) ) ;
    public final void rule__Scanner_PatternRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6476:1: ( ( ( rule__Scanner_PatternRule__CheckAssignment_3_1 ) ) )
            // InternalLDef.g:6477:1: ( ( rule__Scanner_PatternRule__CheckAssignment_3_1 ) )
            {
            // InternalLDef.g:6477:1: ( ( rule__Scanner_PatternRule__CheckAssignment_3_1 ) )
            // InternalLDef.g:6478:1: ( rule__Scanner_PatternRule__CheckAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getCheckAssignment_3_1()); 
            }
            // InternalLDef.g:6479:1: ( rule__Scanner_PatternRule__CheckAssignment_3_1 )
            // InternalLDef.g:6479:2: rule__Scanner_PatternRule__CheckAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_PatternRule__CheckAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getCheckAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_PatternRule__Group_3__1__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__0"
    // InternalLDef.g:6493:1: rule__Scanner_CharacterRule__Group__0 : rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1 ;
    public final void rule__Scanner_CharacterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6497:1: ( rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1 )
            // InternalLDef.g:6498:2: rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__Scanner_CharacterRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6505:1: rule__Scanner_CharacterRule__Group__0__Impl : ( 'character' ) ;
    public final void rule__Scanner_CharacterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6509:1: ( ( 'character' ) )
            // InternalLDef.g:6510:1: ( 'character' )
            {
            // InternalLDef.g:6510:1: ( 'character' )
            // InternalLDef.g:6511:1: 'character'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:6524:1: rule__Scanner_CharacterRule__Group__1 : rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2 ;
    public final void rule__Scanner_CharacterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6528:1: ( rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2 )
            // InternalLDef.g:6529:2: rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_CharacterRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6536:1: rule__Scanner_CharacterRule__Group__1__Impl : ( '[' ) ;
    public final void rule__Scanner_CharacterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6540:1: ( ( '[' ) )
            // InternalLDef.g:6541:1: ( '[' )
            {
            // InternalLDef.g:6541:1: ( '[' )
            // InternalLDef.g:6542:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:6555:1: rule__Scanner_CharacterRule__Group__2 : rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3 ;
    public final void rule__Scanner_CharacterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6559:1: ( rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3 )
            // InternalLDef.g:6560:2: rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3
            {
            pushFollow(FOLLOW_42);
            rule__Scanner_CharacterRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6567:1: rule__Scanner_CharacterRule__Group__2__Impl : ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) ) ;
    public final void rule__Scanner_CharacterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6571:1: ( ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) ) )
            // InternalLDef.g:6572:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) )
            {
            // InternalLDef.g:6572:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) )
            // InternalLDef.g:6573:1: ( rule__Scanner_CharacterRule__CharactersAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_2()); 
            }
            // InternalLDef.g:6574:1: ( rule__Scanner_CharacterRule__CharactersAssignment_2 )
            // InternalLDef.g:6574:2: rule__Scanner_CharacterRule__CharactersAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6584:1: rule__Scanner_CharacterRule__Group__3 : rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4 ;
    public final void rule__Scanner_CharacterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6588:1: ( rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4 )
            // InternalLDef.g:6589:2: rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4
            {
            pushFollow(FOLLOW_42);
            rule__Scanner_CharacterRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6596:1: rule__Scanner_CharacterRule__Group__3__Impl : ( ( rule__Scanner_CharacterRule__Group_3__0 )* ) ;
    public final void rule__Scanner_CharacterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6600:1: ( ( ( rule__Scanner_CharacterRule__Group_3__0 )* ) )
            // InternalLDef.g:6601:1: ( ( rule__Scanner_CharacterRule__Group_3__0 )* )
            {
            // InternalLDef.g:6601:1: ( ( rule__Scanner_CharacterRule__Group_3__0 )* )
            // InternalLDef.g:6602:1: ( rule__Scanner_CharacterRule__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getGroup_3()); 
            }
            // InternalLDef.g:6603:1: ( rule__Scanner_CharacterRule__Group_3__0 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==40) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalLDef.g:6603:2: rule__Scanner_CharacterRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__Scanner_CharacterRule__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop51;
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
    // InternalLDef.g:6613:1: rule__Scanner_CharacterRule__Group__4 : rule__Scanner_CharacterRule__Group__4__Impl rule__Scanner_CharacterRule__Group__5 ;
    public final void rule__Scanner_CharacterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6617:1: ( rule__Scanner_CharacterRule__Group__4__Impl rule__Scanner_CharacterRule__Group__5 )
            // InternalLDef.g:6618:2: rule__Scanner_CharacterRule__Group__4__Impl rule__Scanner_CharacterRule__Group__5
            {
            pushFollow(FOLLOW_46);
            rule__Scanner_CharacterRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Scanner_CharacterRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalLDef.g:6625:1: rule__Scanner_CharacterRule__Group__4__Impl : ( ']' ) ;
    public final void rule__Scanner_CharacterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6629:1: ( ( ']' ) )
            // InternalLDef.g:6630:1: ( ']' )
            {
            // InternalLDef.g:6630:1: ( ']' )
            // InternalLDef.g:6631:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,14,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__Scanner_CharacterRule__Group__5"
    // InternalLDef.g:6644:1: rule__Scanner_CharacterRule__Group__5 : rule__Scanner_CharacterRule__Group__5__Impl ;
    public final void rule__Scanner_CharacterRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6648:1: ( rule__Scanner_CharacterRule__Group__5__Impl )
            // InternalLDef.g:6649:2: rule__Scanner_CharacterRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_CharacterRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__5"


    // $ANTLR start "rule__Scanner_CharacterRule__Group__5__Impl"
    // InternalLDef.g:6655:1: rule__Scanner_CharacterRule__Group__5__Impl : ( ( rule__Scanner_CharacterRule__Group_5__0 )? ) ;
    public final void rule__Scanner_CharacterRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6659:1: ( ( ( rule__Scanner_CharacterRule__Group_5__0 )? ) )
            // InternalLDef.g:6660:1: ( ( rule__Scanner_CharacterRule__Group_5__0 )? )
            {
            // InternalLDef.g:6660:1: ( ( rule__Scanner_CharacterRule__Group_5__0 )? )
            // InternalLDef.g:6661:1: ( rule__Scanner_CharacterRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getGroup_5()); 
            }
            // InternalLDef.g:6662:1: ( rule__Scanner_CharacterRule__Group_5__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==31) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalLDef.g:6662:2: rule__Scanner_CharacterRule__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Scanner_CharacterRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group__5__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group_3__0"
    // InternalLDef.g:6684:1: rule__Scanner_CharacterRule__Group_3__0 : rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1 ;
    public final void rule__Scanner_CharacterRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6688:1: ( rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1 )
            // InternalLDef.g:6689:2: rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_CharacterRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6696:1: rule__Scanner_CharacterRule__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Scanner_CharacterRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6700:1: ( ( ',' ) )
            // InternalLDef.g:6701:1: ( ',' )
            {
            // InternalLDef.g:6701:1: ( ',' )
            // InternalLDef.g:6702:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:6715:1: rule__Scanner_CharacterRule__Group_3__1 : rule__Scanner_CharacterRule__Group_3__1__Impl ;
    public final void rule__Scanner_CharacterRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6719:1: ( rule__Scanner_CharacterRule__Group_3__1__Impl )
            // InternalLDef.g:6720:2: rule__Scanner_CharacterRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6726:1: rule__Scanner_CharacterRule__Group_3__1__Impl : ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) ) ;
    public final void rule__Scanner_CharacterRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6730:1: ( ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) ) )
            // InternalLDef.g:6731:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) )
            {
            // InternalLDef.g:6731:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) )
            // InternalLDef.g:6732:1: ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_3_1()); 
            }
            // InternalLDef.g:6733:1: ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 )
            // InternalLDef.g:6733:2: rule__Scanner_CharacterRule__CharactersAssignment_3_1
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Scanner_CharacterRule__Group_5__0"
    // InternalLDef.g:6747:1: rule__Scanner_CharacterRule__Group_5__0 : rule__Scanner_CharacterRule__Group_5__0__Impl rule__Scanner_CharacterRule__Group_5__1 ;
    public final void rule__Scanner_CharacterRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6751:1: ( rule__Scanner_CharacterRule__Group_5__0__Impl rule__Scanner_CharacterRule__Group_5__1 )
            // InternalLDef.g:6752:2: rule__Scanner_CharacterRule__Group_5__0__Impl rule__Scanner_CharacterRule__Group_5__1
            {
            pushFollow(FOLLOW_28);
            rule__Scanner_CharacterRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Scanner_CharacterRule__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group_5__0"


    // $ANTLR start "rule__Scanner_CharacterRule__Group_5__0__Impl"
    // InternalLDef.g:6759:1: rule__Scanner_CharacterRule__Group_5__0__Impl : ( 'col' ) ;
    public final void rule__Scanner_CharacterRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6763:1: ( ( 'col' ) )
            // InternalLDef.g:6764:1: ( 'col' )
            {
            // InternalLDef.g:6764:1: ( 'col' )
            // InternalLDef.g:6765:1: 'col'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getColKeyword_5_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getColKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group_5__0__Impl"


    // $ANTLR start "rule__Scanner_CharacterRule__Group_5__1"
    // InternalLDef.g:6778:1: rule__Scanner_CharacterRule__Group_5__1 : rule__Scanner_CharacterRule__Group_5__1__Impl ;
    public final void rule__Scanner_CharacterRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6782:1: ( rule__Scanner_CharacterRule__Group_5__1__Impl )
            // InternalLDef.g:6783:2: rule__Scanner_CharacterRule__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_CharacterRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group_5__1"


    // $ANTLR start "rule__Scanner_CharacterRule__Group_5__1__Impl"
    // InternalLDef.g:6789:1: rule__Scanner_CharacterRule__Group_5__1__Impl : ( ( rule__Scanner_CharacterRule__CheckAssignment_5_1 ) ) ;
    public final void rule__Scanner_CharacterRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6793:1: ( ( ( rule__Scanner_CharacterRule__CheckAssignment_5_1 ) ) )
            // InternalLDef.g:6794:1: ( ( rule__Scanner_CharacterRule__CheckAssignment_5_1 ) )
            {
            // InternalLDef.g:6794:1: ( ( rule__Scanner_CharacterRule__CheckAssignment_5_1 ) )
            // InternalLDef.g:6795:1: ( rule__Scanner_CharacterRule__CheckAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCheckAssignment_5_1()); 
            }
            // InternalLDef.g:6796:1: ( rule__Scanner_CharacterRule__CheckAssignment_5_1 )
            // InternalLDef.g:6796:2: rule__Scanner_CharacterRule__CheckAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_CharacterRule__CheckAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getCheckAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__Group_5__1__Impl"


    // $ANTLR start "rule__Scanner_JSRule__Group__0"
    // InternalLDef.g:6810:1: rule__Scanner_JSRule__Group__0 : rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1 ;
    public final void rule__Scanner_JSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6814:1: ( rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1 )
            // InternalLDef.g:6815:2: rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Scanner_JSRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:6822:1: rule__Scanner_JSRule__Group__0__Impl : ( 'script' ) ;
    public final void rule__Scanner_JSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6826:1: ( ( 'script' ) )
            // InternalLDef.g:6827:1: ( 'script' )
            {
            // InternalLDef.g:6827:1: ( 'script' )
            // InternalLDef.g:6828:1: 'script'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:6841:1: rule__Scanner_JSRule__Group__1 : rule__Scanner_JSRule__Group__1__Impl rule__Scanner_JSRule__Group__2 ;
    public final void rule__Scanner_JSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6845:1: ( rule__Scanner_JSRule__Group__1__Impl rule__Scanner_JSRule__Group__2 )
            // InternalLDef.g:6846:2: rule__Scanner_JSRule__Group__1__Impl rule__Scanner_JSRule__Group__2
            {
            pushFollow(FOLLOW_46);
            rule__Scanner_JSRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Scanner_JSRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalLDef.g:6853:1: rule__Scanner_JSRule__Group__1__Impl : ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) ) ;
    public final void rule__Scanner_JSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6857:1: ( ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) ) )
            // InternalLDef.g:6858:1: ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) )
            {
            // InternalLDef.g:6858:1: ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) )
            // InternalLDef.g:6859:1: ( rule__Scanner_JSRule__FileURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getFileURIAssignment_1()); 
            }
            // InternalLDef.g:6860:1: ( rule__Scanner_JSRule__FileURIAssignment_1 )
            // InternalLDef.g:6860:2: rule__Scanner_JSRule__FileURIAssignment_1
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Scanner_JSRule__Group__2"
    // InternalLDef.g:6870:1: rule__Scanner_JSRule__Group__2 : rule__Scanner_JSRule__Group__2__Impl ;
    public final void rule__Scanner_JSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6874:1: ( rule__Scanner_JSRule__Group__2__Impl )
            // InternalLDef.g:6875:2: rule__Scanner_JSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_JSRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__Group__2"


    // $ANTLR start "rule__Scanner_JSRule__Group__2__Impl"
    // InternalLDef.g:6881:1: rule__Scanner_JSRule__Group__2__Impl : ( ( rule__Scanner_JSRule__Group_2__0 )? ) ;
    public final void rule__Scanner_JSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6885:1: ( ( ( rule__Scanner_JSRule__Group_2__0 )? ) )
            // InternalLDef.g:6886:1: ( ( rule__Scanner_JSRule__Group_2__0 )? )
            {
            // InternalLDef.g:6886:1: ( ( rule__Scanner_JSRule__Group_2__0 )? )
            // InternalLDef.g:6887:1: ( rule__Scanner_JSRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getGroup_2()); 
            }
            // InternalLDef.g:6888:1: ( rule__Scanner_JSRule__Group_2__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==31) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalLDef.g:6888:2: rule__Scanner_JSRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Scanner_JSRule__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__Group__2__Impl"


    // $ANTLR start "rule__Scanner_JSRule__Group_2__0"
    // InternalLDef.g:6904:1: rule__Scanner_JSRule__Group_2__0 : rule__Scanner_JSRule__Group_2__0__Impl rule__Scanner_JSRule__Group_2__1 ;
    public final void rule__Scanner_JSRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6908:1: ( rule__Scanner_JSRule__Group_2__0__Impl rule__Scanner_JSRule__Group_2__1 )
            // InternalLDef.g:6909:2: rule__Scanner_JSRule__Group_2__0__Impl rule__Scanner_JSRule__Group_2__1
            {
            pushFollow(FOLLOW_28);
            rule__Scanner_JSRule__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Scanner_JSRule__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__Group_2__0"


    // $ANTLR start "rule__Scanner_JSRule__Group_2__0__Impl"
    // InternalLDef.g:6916:1: rule__Scanner_JSRule__Group_2__0__Impl : ( 'col' ) ;
    public final void rule__Scanner_JSRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6920:1: ( ( 'col' ) )
            // InternalLDef.g:6921:1: ( 'col' )
            {
            // InternalLDef.g:6921:1: ( 'col' )
            // InternalLDef.g:6922:1: 'col'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getColKeyword_2_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleAccess().getColKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__Group_2__0__Impl"


    // $ANTLR start "rule__Scanner_JSRule__Group_2__1"
    // InternalLDef.g:6935:1: rule__Scanner_JSRule__Group_2__1 : rule__Scanner_JSRule__Group_2__1__Impl ;
    public final void rule__Scanner_JSRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6939:1: ( rule__Scanner_JSRule__Group_2__1__Impl )
            // InternalLDef.g:6940:2: rule__Scanner_JSRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_JSRule__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__Group_2__1"


    // $ANTLR start "rule__Scanner_JSRule__Group_2__1__Impl"
    // InternalLDef.g:6946:1: rule__Scanner_JSRule__Group_2__1__Impl : ( ( rule__Scanner_JSRule__CheckAssignment_2_1 ) ) ;
    public final void rule__Scanner_JSRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6950:1: ( ( ( rule__Scanner_JSRule__CheckAssignment_2_1 ) ) )
            // InternalLDef.g:6951:1: ( ( rule__Scanner_JSRule__CheckAssignment_2_1 ) )
            {
            // InternalLDef.g:6951:1: ( ( rule__Scanner_JSRule__CheckAssignment_2_1 ) )
            // InternalLDef.g:6952:1: ( rule__Scanner_JSRule__CheckAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getCheckAssignment_2_1()); 
            }
            // InternalLDef.g:6953:1: ( rule__Scanner_JSRule__CheckAssignment_2_1 )
            // InternalLDef.g:6953:2: rule__Scanner_JSRule__CheckAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Scanner_JSRule__CheckAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleAccess().getCheckAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__Group_2__1__Impl"


    // $ANTLR start "rule__Equals__Group__0"
    // InternalLDef.g:6967:1: rule__Equals__Group__0 : rule__Equals__Group__0__Impl rule__Equals__Group__1 ;
    public final void rule__Equals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6971:1: ( rule__Equals__Group__0__Impl rule__Equals__Group__1 )
            // InternalLDef.g:6972:2: rule__Equals__Group__0__Impl rule__Equals__Group__1
            {
            pushFollow(FOLLOW_47);
            rule__Equals__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Equals__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__0"


    // $ANTLR start "rule__Equals__Group__0__Impl"
    // InternalLDef.g:6979:1: rule__Equals__Group__0__Impl : ( 'eq' ) ;
    public final void rule__Equals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:6983:1: ( ( 'eq' ) )
            // InternalLDef.g:6984:1: ( 'eq' )
            {
            // InternalLDef.g:6984:1: ( 'eq' )
            // InternalLDef.g:6985:1: 'eq'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getEqKeyword_0()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getEqKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__0__Impl"


    // $ANTLR start "rule__Equals__Group__1"
    // InternalLDef.g:6998:1: rule__Equals__Group__1 : rule__Equals__Group__1__Impl ;
    public final void rule__Equals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7002:1: ( rule__Equals__Group__1__Impl )
            // InternalLDef.g:7003:2: rule__Equals__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equals__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__1"


    // $ANTLR start "rule__Equals__Group__1__Impl"
    // InternalLDef.g:7009:1: rule__Equals__Group__1__Impl : ( ( rule__Equals__ValueAssignment_1 ) ) ;
    public final void rule__Equals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7013:1: ( ( ( rule__Equals__ValueAssignment_1 ) ) )
            // InternalLDef.g:7014:1: ( ( rule__Equals__ValueAssignment_1 ) )
            {
            // InternalLDef.g:7014:1: ( ( rule__Equals__ValueAssignment_1 ) )
            // InternalLDef.g:7015:1: ( rule__Equals__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getValueAssignment_1()); 
            }
            // InternalLDef.g:7016:1: ( rule__Equals__ValueAssignment_1 )
            // InternalLDef.g:7016:2: rule__Equals__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Equals__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__1__Impl"


    // $ANTLR start "rule__Range__Group__0"
    // InternalLDef.g:7030:1: rule__Range__Group__0 : rule__Range__Group__0__Impl rule__Range__Group__1 ;
    public final void rule__Range__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7034:1: ( rule__Range__Group__0__Impl rule__Range__Group__1 )
            // InternalLDef.g:7035:2: rule__Range__Group__0__Impl rule__Range__Group__1
            {
            pushFollow(FOLLOW_48);
            rule__Range__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Range__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__0"


    // $ANTLR start "rule__Range__Group__0__Impl"
    // InternalLDef.g:7042:1: rule__Range__Group__0__Impl : ( 'in' ) ;
    public final void rule__Range__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7046:1: ( ( 'in' ) )
            // InternalLDef.g:7047:1: ( 'in' )
            {
            // InternalLDef.g:7047:1: ( 'in' )
            // InternalLDef.g:7048:1: 'in'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getInKeyword_0()); 
            }
            match(input,46,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getInKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__0__Impl"


    // $ANTLR start "rule__Range__Group__1"
    // InternalLDef.g:7061:1: rule__Range__Group__1 : rule__Range__Group__1__Impl rule__Range__Group__2 ;
    public final void rule__Range__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7065:1: ( rule__Range__Group__1__Impl rule__Range__Group__2 )
            // InternalLDef.g:7066:2: rule__Range__Group__1__Impl rule__Range__Group__2
            {
            pushFollow(FOLLOW_49);
            rule__Range__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Range__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__1"


    // $ANTLR start "rule__Range__Group__1__Impl"
    // InternalLDef.g:7073:1: rule__Range__Group__1__Impl : ( ( rule__Range__LtInclAssignment_1 ) ) ;
    public final void rule__Range__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7077:1: ( ( ( rule__Range__LtInclAssignment_1 ) ) )
            // InternalLDef.g:7078:1: ( ( rule__Range__LtInclAssignment_1 ) )
            {
            // InternalLDef.g:7078:1: ( ( rule__Range__LtInclAssignment_1 ) )
            // InternalLDef.g:7079:1: ( rule__Range__LtInclAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getLtInclAssignment_1()); 
            }
            // InternalLDef.g:7080:1: ( rule__Range__LtInclAssignment_1 )
            // InternalLDef.g:7080:2: rule__Range__LtInclAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Range__LtInclAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getLtInclAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__1__Impl"


    // $ANTLR start "rule__Range__Group__2"
    // InternalLDef.g:7090:1: rule__Range__Group__2 : rule__Range__Group__2__Impl rule__Range__Group__3 ;
    public final void rule__Range__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7094:1: ( rule__Range__Group__2__Impl rule__Range__Group__3 )
            // InternalLDef.g:7095:2: rule__Range__Group__2__Impl rule__Range__Group__3
            {
            pushFollow(FOLLOW_49);
            rule__Range__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Range__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__2"


    // $ANTLR start "rule__Range__Group__2__Impl"
    // InternalLDef.g:7102:1: rule__Range__Group__2__Impl : ( ( rule__Range__MinValueAssignment_2 )? ) ;
    public final void rule__Range__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7106:1: ( ( ( rule__Range__MinValueAssignment_2 )? ) )
            // InternalLDef.g:7107:1: ( ( rule__Range__MinValueAssignment_2 )? )
            {
            // InternalLDef.g:7107:1: ( ( rule__Range__MinValueAssignment_2 )? )
            // InternalLDef.g:7108:1: ( rule__Range__MinValueAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMinValueAssignment_2()); 
            }
            // InternalLDef.g:7109:1: ( rule__Range__MinValueAssignment_2 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_INT) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalLDef.g:7109:2: rule__Range__MinValueAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Range__MinValueAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getMinValueAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__2__Impl"


    // $ANTLR start "rule__Range__Group__3"
    // InternalLDef.g:7119:1: rule__Range__Group__3 : rule__Range__Group__3__Impl rule__Range__Group__4 ;
    public final void rule__Range__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7123:1: ( rule__Range__Group__3__Impl rule__Range__Group__4 )
            // InternalLDef.g:7124:2: rule__Range__Group__3__Impl rule__Range__Group__4
            {
            pushFollow(FOLLOW_50);
            rule__Range__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Range__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__3"


    // $ANTLR start "rule__Range__Group__3__Impl"
    // InternalLDef.g:7131:1: rule__Range__Group__3__Impl : ( ',' ) ;
    public final void rule__Range__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7135:1: ( ( ',' ) )
            // InternalLDef.g:7136:1: ( ',' )
            {
            // InternalLDef.g:7136:1: ( ',' )
            // InternalLDef.g:7137:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getCommaKeyword_3()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getCommaKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__3__Impl"


    // $ANTLR start "rule__Range__Group__4"
    // InternalLDef.g:7150:1: rule__Range__Group__4 : rule__Range__Group__4__Impl rule__Range__Group__5 ;
    public final void rule__Range__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7154:1: ( rule__Range__Group__4__Impl rule__Range__Group__5 )
            // InternalLDef.g:7155:2: rule__Range__Group__4__Impl rule__Range__Group__5
            {
            pushFollow(FOLLOW_50);
            rule__Range__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Range__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__4"


    // $ANTLR start "rule__Range__Group__4__Impl"
    // InternalLDef.g:7162:1: rule__Range__Group__4__Impl : ( ( rule__Range__MaxValueAssignment_4 )? ) ;
    public final void rule__Range__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7166:1: ( ( ( rule__Range__MaxValueAssignment_4 )? ) )
            // InternalLDef.g:7167:1: ( ( rule__Range__MaxValueAssignment_4 )? )
            {
            // InternalLDef.g:7167:1: ( ( rule__Range__MaxValueAssignment_4 )? )
            // InternalLDef.g:7168:1: ( rule__Range__MaxValueAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMaxValueAssignment_4()); 
            }
            // InternalLDef.g:7169:1: ( rule__Range__MaxValueAssignment_4 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_INT) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalLDef.g:7169:2: rule__Range__MaxValueAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Range__MaxValueAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getMaxValueAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__4__Impl"


    // $ANTLR start "rule__Range__Group__5"
    // InternalLDef.g:7179:1: rule__Range__Group__5 : rule__Range__Group__5__Impl ;
    public final void rule__Range__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7183:1: ( rule__Range__Group__5__Impl )
            // InternalLDef.g:7184:2: rule__Range__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Range__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__5"


    // $ANTLR start "rule__Range__Group__5__Impl"
    // InternalLDef.g:7190:1: rule__Range__Group__5__Impl : ( ( rule__Range__GtInclAssignment_5 ) ) ;
    public final void rule__Range__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7194:1: ( ( ( rule__Range__GtInclAssignment_5 ) ) )
            // InternalLDef.g:7195:1: ( ( rule__Range__GtInclAssignment_5 ) )
            {
            // InternalLDef.g:7195:1: ( ( rule__Range__GtInclAssignment_5 ) )
            // InternalLDef.g:7196:1: ( rule__Range__GtInclAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getGtInclAssignment_5()); 
            }
            // InternalLDef.g:7197:1: ( rule__Range__GtInclAssignment_5 )
            // InternalLDef.g:7197:2: rule__Range__GtInclAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Range__GtInclAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getGtInclAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__5__Impl"


    // $ANTLR start "rule__WhitespaceRule__Group__0"
    // InternalLDef.g:7219:1: rule__WhitespaceRule__Group__0 : rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1 ;
    public final void rule__WhitespaceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7223:1: ( rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1 )
            // InternalLDef.g:7224:2: rule__WhitespaceRule__Group__0__Impl rule__WhitespaceRule__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__WhitespaceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7231:1: rule__WhitespaceRule__Group__0__Impl : ( 'whitespace' ) ;
    public final void rule__WhitespaceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7235:1: ( ( 'whitespace' ) )
            // InternalLDef.g:7236:1: ( 'whitespace' )
            {
            // InternalLDef.g:7236:1: ( 'whitespace' )
            // InternalLDef.g:7237:1: 'whitespace'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getWhitespaceKeyword_0()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7250:1: rule__WhitespaceRule__Group__1 : rule__WhitespaceRule__Group__1__Impl ;
    public final void rule__WhitespaceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7254:1: ( rule__WhitespaceRule__Group__1__Impl )
            // InternalLDef.g:7255:2: rule__WhitespaceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7261:1: rule__WhitespaceRule__Group__1__Impl : ( ( rule__WhitespaceRule__Alternatives_1 ) ) ;
    public final void rule__WhitespaceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7265:1: ( ( ( rule__WhitespaceRule__Alternatives_1 ) ) )
            // InternalLDef.g:7266:1: ( ( rule__WhitespaceRule__Alternatives_1 ) )
            {
            // InternalLDef.g:7266:1: ( ( rule__WhitespaceRule__Alternatives_1 ) )
            // InternalLDef.g:7267:1: ( rule__WhitespaceRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getAlternatives_1()); 
            }
            // InternalLDef.g:7268:1: ( rule__WhitespaceRule__Alternatives_1 )
            // InternalLDef.g:7268:2: rule__WhitespaceRule__Alternatives_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7282:1: rule__WhitespaceRule__Group_1_0__0 : rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1 ;
    public final void rule__WhitespaceRule__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7286:1: ( rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1 )
            // InternalLDef.g:7287:2: rule__WhitespaceRule__Group_1_0__0__Impl rule__WhitespaceRule__Group_1_0__1
            {
            pushFollow(FOLLOW_18);
            rule__WhitespaceRule__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7294:1: rule__WhitespaceRule__Group_1_0__0__Impl : ( '[' ) ;
    public final void rule__WhitespaceRule__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7298:1: ( ( '[' ) )
            // InternalLDef.g:7299:1: ( '[' )
            {
            // InternalLDef.g:7299:1: ( '[' )
            // InternalLDef.g:7300:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7313:1: rule__WhitespaceRule__Group_1_0__1 : rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2 ;
    public final void rule__WhitespaceRule__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7317:1: ( rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2 )
            // InternalLDef.g:7318:2: rule__WhitespaceRule__Group_1_0__1__Impl rule__WhitespaceRule__Group_1_0__2
            {
            pushFollow(FOLLOW_42);
            rule__WhitespaceRule__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7325:1: rule__WhitespaceRule__Group_1_0__1__Impl : ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) ) ;
    public final void rule__WhitespaceRule__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7329:1: ( ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) ) )
            // InternalLDef.g:7330:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) )
            {
            // InternalLDef.g:7330:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_1 ) )
            // InternalLDef.g:7331:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersAssignment_1_0_1()); 
            }
            // InternalLDef.g:7332:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_1 )
            // InternalLDef.g:7332:2: rule__WhitespaceRule__CharactersAssignment_1_0_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7342:1: rule__WhitespaceRule__Group_1_0__2 : rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3 ;
    public final void rule__WhitespaceRule__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7346:1: ( rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3 )
            // InternalLDef.g:7347:2: rule__WhitespaceRule__Group_1_0__2__Impl rule__WhitespaceRule__Group_1_0__3
            {
            pushFollow(FOLLOW_42);
            rule__WhitespaceRule__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7354:1: rule__WhitespaceRule__Group_1_0__2__Impl : ( ( rule__WhitespaceRule__Group_1_0_2__0 )* ) ;
    public final void rule__WhitespaceRule__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7358:1: ( ( ( rule__WhitespaceRule__Group_1_0_2__0 )* ) )
            // InternalLDef.g:7359:1: ( ( rule__WhitespaceRule__Group_1_0_2__0 )* )
            {
            // InternalLDef.g:7359:1: ( ( rule__WhitespaceRule__Group_1_0_2__0 )* )
            // InternalLDef.g:7360:1: ( rule__WhitespaceRule__Group_1_0_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getGroup_1_0_2()); 
            }
            // InternalLDef.g:7361:1: ( rule__WhitespaceRule__Group_1_0_2__0 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==40) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalLDef.g:7361:2: rule__WhitespaceRule__Group_1_0_2__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__WhitespaceRule__Group_1_0_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop56;
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
    // InternalLDef.g:7371:1: rule__WhitespaceRule__Group_1_0__3 : rule__WhitespaceRule__Group_1_0__3__Impl ;
    public final void rule__WhitespaceRule__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7375:1: ( rule__WhitespaceRule__Group_1_0__3__Impl )
            // InternalLDef.g:7376:2: rule__WhitespaceRule__Group_1_0__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7382:1: rule__WhitespaceRule__Group_1_0__3__Impl : ( ']' ) ;
    public final void rule__WhitespaceRule__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7386:1: ( ( ']' ) )
            // InternalLDef.g:7387:1: ( ']' )
            {
            // InternalLDef.g:7387:1: ( ']' )
            // InternalLDef.g:7388:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3()); 
            }
            match(input,14,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7409:1: rule__WhitespaceRule__Group_1_0_2__0 : rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1 ;
    public final void rule__WhitespaceRule__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7413:1: ( rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1 )
            // InternalLDef.g:7414:2: rule__WhitespaceRule__Group_1_0_2__0__Impl rule__WhitespaceRule__Group_1_0_2__1
            {
            pushFollow(FOLLOW_18);
            rule__WhitespaceRule__Group_1_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7421:1: rule__WhitespaceRule__Group_1_0_2__0__Impl : ( ',' ) ;
    public final void rule__WhitespaceRule__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7425:1: ( ( ',' ) )
            // InternalLDef.g:7426:1: ( ',' )
            {
            // InternalLDef.g:7426:1: ( ',' )
            // InternalLDef.g:7427:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCommaKeyword_1_0_2_0()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7440:1: rule__WhitespaceRule__Group_1_0_2__1 : rule__WhitespaceRule__Group_1_0_2__1__Impl ;
    public final void rule__WhitespaceRule__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7444:1: ( rule__WhitespaceRule__Group_1_0_2__1__Impl )
            // InternalLDef.g:7445:2: rule__WhitespaceRule__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7451:1: rule__WhitespaceRule__Group_1_0_2__1__Impl : ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) ) ;
    public final void rule__WhitespaceRule__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7455:1: ( ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) ) )
            // InternalLDef.g:7456:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) )
            {
            // InternalLDef.g:7456:1: ( ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 ) )
            // InternalLDef.g:7457:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersAssignment_1_0_2_1()); 
            }
            // InternalLDef.g:7458:1: ( rule__WhitespaceRule__CharactersAssignment_1_0_2_1 )
            // InternalLDef.g:7458:2: rule__WhitespaceRule__CharactersAssignment_1_0_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7473:1: rule__Root__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Root__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7477:1: ( ( ruleQualifiedName ) )
            // InternalLDef.g:7478:1: ( ruleQualifiedName )
            {
            // InternalLDef.g:7478:1: ( ruleQualifiedName )
            // InternalLDef.g:7479:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7488:1: rule__Root__ImportsAssignment_2 : ( ruleImport ) ;
    public final void rule__Root__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7492:1: ( ( ruleImport ) )
            // InternalLDef.g:7493:1: ( ruleImport )
            {
            // InternalLDef.g:7493:1: ( ruleImport )
            // InternalLDef.g:7494:1: ruleImport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getImportsImportParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7503:1: rule__Root__LanguageDefinitionAssignment_3 : ( ruleLanguageDef ) ;
    public final void rule__Root__LanguageDefinitionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7507:1: ( ( ruleLanguageDef ) )
            // InternalLDef.g:7508:1: ( ruleLanguageDef )
            {
            // InternalLDef.g:7508:1: ( ruleLanguageDef )
            // InternalLDef.g:7509:1: ruleLanguageDef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootAccess().getLanguageDefinitionLanguageDefParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7518:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildCard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7522:1: ( ( ruleQualifiedNameWithWildCard ) )
            // InternalLDef.g:7523:1: ( ruleQualifiedNameWithWildCard )
            {
            // InternalLDef.g:7523:1: ( ruleQualifiedNameWithWildCard )
            // InternalLDef.g:7524:1: ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7533:1: rule__LanguageDef__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__LanguageDef__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7537:1: ( ( RULE_ID ) )
            // InternalLDef.g:7538:1: ( RULE_ID )
            {
            // InternalLDef.g:7538:1: ( RULE_ID )
            // InternalLDef.g:7539:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7548:1: rule__LanguageDef__ParitioningAssignment_2 : ( ruleParitioning ) ;
    public final void rule__LanguageDef__ParitioningAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7552:1: ( ( ruleParitioning ) )
            // InternalLDef.g:7553:1: ( ruleParitioning )
            {
            // InternalLDef.g:7553:1: ( ruleParitioning )
            // InternalLDef.g:7554:1: ruleParitioning
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getParitioningParitioningParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7563:1: rule__LanguageDef__LexicalHighlightingAssignment_3 : ( ruleLexicalHighlighting ) ;
    public final void rule__LanguageDef__LexicalHighlightingAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7567:1: ( ( ruleLexicalHighlighting ) )
            // InternalLDef.g:7568:1: ( ruleLexicalHighlighting )
            {
            // InternalLDef.g:7568:1: ( ruleLexicalHighlighting )
            // InternalLDef.g:7569:1: ruleLexicalHighlighting
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getLexicalHighlightingLexicalHighlightingParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7578:1: rule__LanguageDef__IntegrationAssignment_4 : ( ruleIntegration ) ;
    public final void rule__LanguageDef__IntegrationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7582:1: ( ( ruleIntegration ) )
            // InternalLDef.g:7583:1: ( ruleIntegration )
            {
            // InternalLDef.g:7583:1: ( ruleIntegration )
            // InternalLDef.g:7584:1: ruleIntegration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageDefAccess().getIntegrationIntegrationParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7593:1: rule__Integration__CodeIntegrationListAssignment_2 : ( ruleCodeIntegration ) ;
    public final void rule__Integration__CodeIntegrationListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7597:1: ( ( ruleCodeIntegration ) )
            // InternalLDef.g:7598:1: ( ruleCodeIntegration )
            {
            // InternalLDef.g:7598:1: ( ruleCodeIntegration )
            // InternalLDef.g:7599:1: ruleCodeIntegration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegrationAccess().getCodeIntegrationListCodeIntegrationParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7608:1: rule__JavaFXIntegration__CodegenerationListAssignment_2 : ( ruleCodegeneration ) ;
    public final void rule__JavaFXIntegration__CodegenerationListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7612:1: ( ( ruleCodegeneration ) )
            // InternalLDef.g:7613:1: ( ruleCodegeneration )
            {
            // InternalLDef.g:7613:1: ( ruleCodegeneration )
            // InternalLDef.g:7614:1: ruleCodegeneration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListCodegenerationParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7623:1: rule__JavaCodeGeneration__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JavaCodeGeneration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7627:1: ( ( RULE_STRING ) )
            // InternalLDef.g:7628:1: ( RULE_STRING )
            {
            // InternalLDef.g:7628:1: ( RULE_STRING )
            // InternalLDef.g:7629:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7638:1: rule__JavaCodeGeneration__ConfigValueAssignment_2_1 : ( ruleConfigValue ) ;
    public final void rule__JavaCodeGeneration__ConfigValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7642:1: ( ( ruleConfigValue ) )
            // InternalLDef.g:7643:1: ( ruleConfigValue )
            {
            // InternalLDef.g:7643:1: ( ruleConfigValue )
            // InternalLDef.g:7644:1: ruleConfigValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJavaCodeGenerationAccess().getConfigValueConfigValueParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7653:1: rule__E4CodeGeneration__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__E4CodeGeneration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7657:1: ( ( RULE_STRING ) )
            // InternalLDef.g:7658:1: ( RULE_STRING )
            {
            // InternalLDef.g:7658:1: ( RULE_STRING )
            // InternalLDef.g:7659:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7668:1: rule__E4CodeGeneration__ConfigValueAssignment_2_1 : ( ruleConfigValue ) ;
    public final void rule__E4CodeGeneration__ConfigValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7672:1: ( ( ruleConfigValue ) )
            // InternalLDef.g:7673:1: ( ruleConfigValue )
            {
            // InternalLDef.g:7673:1: ( ruleConfigValue )
            // InternalLDef.g:7674:1: ruleConfigValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getE4CodeGenerationAccess().getConfigValueConfigValueParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7683:1: rule__ConfigValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__ConfigValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7687:1: ( ( RULE_ID ) )
            // InternalLDef.g:7688:1: ( RULE_ID )
            {
            // InternalLDef.g:7688:1: ( RULE_ID )
            // InternalLDef.g:7689:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7698:1: rule__ConfigValue__SimpleValueAssignment_2_0 : ( RULE_STRING ) ;
    public final void rule__ConfigValue__SimpleValueAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7702:1: ( ( RULE_STRING ) )
            // InternalLDef.g:7703:1: ( RULE_STRING )
            {
            // InternalLDef.g:7703:1: ( RULE_STRING )
            // InternalLDef.g:7704:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getSimpleValueSTRINGTerminalRuleCall_2_0_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7713:1: rule__ConfigValue__ChildrenAssignment_2_1_1 : ( ruleConfigValue ) ;
    public final void rule__ConfigValue__ChildrenAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7717:1: ( ( ruleConfigValue ) )
            // InternalLDef.g:7718:1: ( ruleConfigValue )
            {
            // InternalLDef.g:7718:1: ( ruleConfigValue )
            // InternalLDef.g:7719:1: ruleConfigValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getChildrenConfigValueParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7728:1: rule__Paritioning__PartitionsAssignment_2 : ( rulePartition ) ;
    public final void rule__Paritioning__PartitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7732:1: ( ( rulePartition ) )
            // InternalLDef.g:7733:1: ( rulePartition )
            {
            // InternalLDef.g:7733:1: ( rulePartition )
            // InternalLDef.g:7734:1: rulePartition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7743:1: rule__Paritioning__PartitionerAssignment_3 : ( rulePartitioner ) ;
    public final void rule__Paritioning__PartitionerAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7747:1: ( ( rulePartitioner ) )
            // InternalLDef.g:7748:1: ( rulePartitioner )
            {
            // InternalLDef.g:7748:1: ( rulePartitioner )
            // InternalLDef.g:7749:1: rulePartitioner
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7758:1: rule__Partition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Partition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7762:1: ( ( RULE_ID ) )
            // InternalLDef.g:7763:1: ( RULE_ID )
            {
            // InternalLDef.g:7763:1: ( RULE_ID )
            // InternalLDef.g:7764:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7773:1: rule__Paritioner_JS__ScriptURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Paritioner_JS__ScriptURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7777:1: ( ( RULE_STRING ) )
            // InternalLDef.g:7778:1: ( RULE_STRING )
            {
            // InternalLDef.g:7778:1: ( RULE_STRING )
            // InternalLDef.g:7779:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParitioner_JSAccess().getScriptURISTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7788:1: rule__Partitioner_Rule__RuleListAssignment_2 : ( rulePartition_Rule ) ;
    public final void rule__Partitioner_Rule__RuleListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7792:1: ( ( rulePartition_Rule ) )
            // InternalLDef.g:7793:1: ( rulePartition_Rule )
            {
            // InternalLDef.g:7793:1: ( rulePartition_Rule )
            // InternalLDef.g:7794:1: rulePartition_Rule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:7803:1: rule__Partition_SingleLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Partition_SingleLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7807:1: ( ( ( RULE_ID ) ) )
            // InternalLDef.g:7808:1: ( ( RULE_ID ) )
            {
            // InternalLDef.g:7808:1: ( ( RULE_ID ) )
            // InternalLDef.g:7809:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            }
            // InternalLDef.g:7810:1: ( RULE_ID )
            // InternalLDef.g:7811:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7822:1: rule__Partition_SingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7826:1: ( ( RULE_STRING ) )
            // InternalLDef.g:7827:1: ( RULE_STRING )
            {
            // InternalLDef.g:7827:1: ( RULE_STRING )
            // InternalLDef.g:7828:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__Partition_SingleLineRule__CheckAssignment_3_1"
    // InternalLDef.g:7837:1: rule__Partition_SingleLineRule__CheckAssignment_3_1 : ( ruleCheck ) ;
    public final void rule__Partition_SingleLineRule__CheckAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7841:1: ( ( ruleCheck ) )
            // InternalLDef.g:7842:1: ( ruleCheck )
            {
            // InternalLDef.g:7842:1: ( ruleCheck )
            // InternalLDef.g:7843:1: ruleCheck
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCheck();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__CheckAssignment_3_1"


    // $ANTLR start "rule__Partition_SingleLineRule__EndSeqAssignment_4_1"
    // InternalLDef.g:7852:1: rule__Partition_SingleLineRule__EndSeqAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__EndSeqAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7856:1: ( ( RULE_STRING ) )
            // InternalLDef.g:7857:1: ( RULE_STRING )
            {
            // InternalLDef.g:7857:1: ( RULE_STRING )
            // InternalLDef.g:7858:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_SingleLineRule__EndSeqAssignment_4_1"


    // $ANTLR start "rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2"
    // InternalLDef.g:7867:1: rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7871:1: ( ( RULE_STRING ) )
            // InternalLDef.g:7872:1: ( RULE_STRING )
            {
            // InternalLDef.g:7872:1: ( RULE_STRING )
            // InternalLDef.g:7873:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7882:1: rule__Partition_MultiLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Partition_MultiLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7886:1: ( ( ( RULE_ID ) ) )
            // InternalLDef.g:7887:1: ( ( RULE_ID ) )
            {
            // InternalLDef.g:7887:1: ( ( RULE_ID ) )
            // InternalLDef.g:7888:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            }
            // InternalLDef.g:7889:1: ( RULE_ID )
            // InternalLDef.g:7890:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:7901:1: rule__Partition_MultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7905:1: ( ( RULE_STRING ) )
            // InternalLDef.g:7906:1: ( RULE_STRING )
            {
            // InternalLDef.g:7906:1: ( RULE_STRING )
            // InternalLDef.g:7907:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__Partition_MultiLineRule__CheckAssignment_3_1"
    // InternalLDef.g:7916:1: rule__Partition_MultiLineRule__CheckAssignment_3_1 : ( ruleCheck ) ;
    public final void rule__Partition_MultiLineRule__CheckAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7920:1: ( ( ruleCheck ) )
            // InternalLDef.g:7921:1: ( ruleCheck )
            {
            // InternalLDef.g:7921:1: ( ruleCheck )
            // InternalLDef.g:7922:1: ruleCheck
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCheck();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__CheckAssignment_3_1"


    // $ANTLR start "rule__Partition_MultiLineRule__EndSeqAssignment_5"
    // InternalLDef.g:7931:1: rule__Partition_MultiLineRule__EndSeqAssignment_5 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__EndSeqAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7935:1: ( ( RULE_STRING ) )
            // InternalLDef.g:7936:1: ( RULE_STRING )
            {
            // InternalLDef.g:7936:1: ( RULE_STRING )
            // InternalLDef.g:7937:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_5_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__EndSeqAssignment_5"


    // $ANTLR start "rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2"
    // InternalLDef.g:7946:1: rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7950:1: ( ( RULE_STRING ) )
            // InternalLDef.g:7951:1: ( RULE_STRING )
            {
            // InternalLDef.g:7951:1: ( RULE_STRING )
            // InternalLDef.g:7952:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_6_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_6_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Partition_MultiLineRule__EscapeSeqAssignment_6_2"


    // $ANTLR start "rule__LexicalHighlighting__ListAssignment_2"
    // InternalLDef.g:7961:1: rule__LexicalHighlighting__ListAssignment_2 : ( ruleLexicalPartitionHighlighting ) ;
    public final void rule__LexicalHighlighting__ListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7965:1: ( ( ruleLexicalPartitionHighlighting ) )
            // InternalLDef.g:7966:1: ( ruleLexicalPartitionHighlighting )
            {
            // InternalLDef.g:7966:1: ( ruleLexicalPartitionHighlighting )
            // InternalLDef.g:7967:1: ruleLexicalPartitionHighlighting
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__LexicalHighlighting__VistualAssignment_3"
    // InternalLDef.g:7976:1: rule__LexicalHighlighting__VistualAssignment_3 : ( ruleTokenVisuals ) ;
    public final void rule__LexicalHighlighting__VistualAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7980:1: ( ( ruleTokenVisuals ) )
            // InternalLDef.g:7981:1: ( ruleTokenVisuals )
            {
            // InternalLDef.g:7981:1: ( ruleTokenVisuals )
            // InternalLDef.g:7982:1: ruleTokenVisuals
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalHighlightingAccess().getVistualTokenVisualsParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTokenVisuals();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLexicalHighlightingAccess().getVistualTokenVisualsParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalHighlighting__VistualAssignment_3"


    // $ANTLR start "rule__TokenVisuals__TokenVisualsAssignment_2_0"
    // InternalLDef.g:7991:1: rule__TokenVisuals__TokenVisualsAssignment_2_0 : ( ruleTokenVisual ) ;
    public final void rule__TokenVisuals__TokenVisualsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:7995:1: ( ( ruleTokenVisual ) )
            // InternalLDef.g:7996:1: ( ruleTokenVisual )
            {
            // InternalLDef.g:7996:1: ( ruleTokenVisual )
            // InternalLDef.g:7997:1: ruleTokenVisual
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualsAccess().getTokenVisualsTokenVisualParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTokenVisual();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualsAccess().getTokenVisualsTokenVisualParserRuleCall_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisuals__TokenVisualsAssignment_2_0"


    // $ANTLR start "rule__TokenVisual__TokenAssignment_0"
    // InternalLDef.g:8006:1: rule__TokenVisual__TokenAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__TokenVisual__TokenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8010:1: ( ( ( RULE_ID ) ) )
            // InternalLDef.g:8011:1: ( ( RULE_ID ) )
            {
            // InternalLDef.g:8011:1: ( ( RULE_ID ) )
            // InternalLDef.g:8012:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getTokenTokenCrossReference_0_0()); 
            }
            // InternalLDef.g:8013:1: ( RULE_ID )
            // InternalLDef.g:8014:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getTokenTokenIDTerminalRuleCall_0_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getTokenTokenIDTerminalRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getTokenTokenCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__TokenAssignment_0"


    // $ANTLR start "rule__TokenVisual__ColorSpecAssignment_1"
    // InternalLDef.g:8025:1: rule__TokenVisual__ColorSpecAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TokenVisual__ColorSpecAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8029:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8030:1: ( RULE_STRING )
            {
            // InternalLDef.g:8030:1: ( RULE_STRING )
            // InternalLDef.g:8031:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getColorSpecSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getColorSpecSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__ColorSpecAssignment_1"


    // $ANTLR start "rule__TokenVisual__BoldAssignment_2"
    // InternalLDef.g:8040:1: rule__TokenVisual__BoldAssignment_2 : ( ( 'bold' ) ) ;
    public final void rule__TokenVisual__BoldAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8044:1: ( ( ( 'bold' ) ) )
            // InternalLDef.g:8045:1: ( ( 'bold' ) )
            {
            // InternalLDef.g:8045:1: ( ( 'bold' ) )
            // InternalLDef.g:8046:1: ( 'bold' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getBoldBoldKeyword_2_0()); 
            }
            // InternalLDef.g:8047:1: ( 'bold' )
            // InternalLDef.g:8048:1: 'bold'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getBoldBoldKeyword_2_0()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getBoldBoldKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getBoldBoldKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__BoldAssignment_2"


    // $ANTLR start "rule__TokenVisual__ItalicAssignment_3"
    // InternalLDef.g:8063:1: rule__TokenVisual__ItalicAssignment_3 : ( ( 'italic' ) ) ;
    public final void rule__TokenVisual__ItalicAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8067:1: ( ( ( 'italic' ) ) )
            // InternalLDef.g:8068:1: ( ( 'italic' ) )
            {
            // InternalLDef.g:8068:1: ( ( 'italic' ) )
            // InternalLDef.g:8069:1: ( 'italic' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getItalicItalicKeyword_3_0()); 
            }
            // InternalLDef.g:8070:1: ( 'italic' )
            // InternalLDef.g:8071:1: 'italic'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenVisualAccess().getItalicItalicKeyword_3_0()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getItalicItalicKeyword_3_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenVisualAccess().getItalicItalicKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TokenVisual__ItalicAssignment_3"


    // $ANTLR start "rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1"
    // InternalLDef.g:8086:1: rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8090:1: ( ( ( RULE_ID ) ) )
            // InternalLDef.g:8091:1: ( ( RULE_ID ) )
            {
            // InternalLDef.g:8091:1: ( ( RULE_ID ) )
            // InternalLDef.g:8092:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
            }
            // InternalLDef.g:8093:1: ( RULE_ID )
            // InternalLDef.g:8094:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8105:1: rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8109:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8110:1: ( RULE_STRING )
            {
            // InternalLDef.g:8110:1: ( RULE_STRING )
            // InternalLDef.g:8111:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURISTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8120:1: rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8124:1: ( ( ( RULE_ID ) ) )
            // InternalLDef.g:8125:1: ( ( RULE_ID ) )
            {
            // InternalLDef.g:8125:1: ( ( RULE_ID ) )
            // InternalLDef.g:8126:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
            }
            // InternalLDef.g:8127:1: ( RULE_ID )
            // InternalLDef.g:8128:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8139:1: rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2 : ( ruleWhitespaceRule ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__WhitespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8143:1: ( ( ruleWhitespaceRule ) )
            // InternalLDef.g:8144:1: ( ruleWhitespaceRule )
            {
            // InternalLDef.g:8144:1: ( ruleWhitespaceRule )
            // InternalLDef.g:8145:1: ruleWhitespaceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceWhitespaceRuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:8154:1: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4 : ( ruleToken ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8158:1: ( ( ruleToken ) )
            // InternalLDef.g:8159:1: ( ruleToken )
            {
            // InternalLDef.g:8159:1: ( ruleToken )
            // InternalLDef.g:8160:1: ruleToken
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:8169:1: rule__Token__DefaultAssignment_0 : ( ( 'default' ) ) ;
    public final void rule__Token__DefaultAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8173:1: ( ( ( 'default' ) ) )
            // InternalLDef.g:8174:1: ( ( 'default' ) )
            {
            // InternalLDef.g:8174:1: ( ( 'default' ) )
            // InternalLDef.g:8175:1: ( 'default' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            }
            // InternalLDef.g:8176:1: ( 'default' )
            // InternalLDef.g:8177:1: 'default'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8192:1: rule__Token__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Token__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8196:1: ( ( RULE_ID ) )
            // InternalLDef.g:8197:1: ( RULE_ID )
            {
            // InternalLDef.g:8197:1: ( RULE_ID )
            // InternalLDef.g:8198:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8207:1: rule__Token__ScannerListAssignment_2_1 : ( ruleScanner ) ;
    public final void rule__Token__ScannerListAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8211:1: ( ( ruleScanner ) )
            // InternalLDef.g:8212:1: ( ruleScanner )
            {
            // InternalLDef.g:8212:1: ( ruleScanner )
            // InternalLDef.g:8213:1: ruleScanner
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:8222:1: rule__Scanner_Keyword__KeywordsAssignment_2 : ( ruleKeyword ) ;
    public final void rule__Scanner_Keyword__KeywordsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8226:1: ( ( ruleKeyword ) )
            // InternalLDef.g:8227:1: ( ruleKeyword )
            {
            // InternalLDef.g:8227:1: ( ruleKeyword )
            // InternalLDef.g:8228:1: ruleKeyword
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:8237:1: rule__Scanner_Keyword__KeywordsAssignment_3_1 : ( ruleKeyword ) ;
    public final void rule__Scanner_Keyword__KeywordsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8241:1: ( ( ruleKeyword ) )
            // InternalLDef.g:8242:1: ( ruleKeyword )
            {
            // InternalLDef.g:8242:1: ( ruleKeyword )
            // InternalLDef.g:8243:1: ruleKeyword
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalLDef.g:8252:1: rule__Keyword__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Keyword__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8256:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8257:1: ( RULE_STRING )
            {
            // InternalLDef.g:8257:1: ( RULE_STRING )
            // InternalLDef.g:8258:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8267:1: rule__Keyword__VersionAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Keyword__VersionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8271:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8272:1: ( RULE_STRING )
            {
            // InternalLDef.g:8272:1: ( RULE_STRING )
            // InternalLDef.g:8273:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8282:1: rule__Scanner_SingleLineRule__StartSeqAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__StartSeqAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8286:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8287:1: ( RULE_STRING )
            {
            // InternalLDef.g:8287:1: ( RULE_STRING )
            // InternalLDef.g:8288:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__Scanner_SingleLineRule__CheckAssignment_2_1"
    // InternalLDef.g:8297:1: rule__Scanner_SingleLineRule__CheckAssignment_2_1 : ( ruleCheck ) ;
    public final void rule__Scanner_SingleLineRule__CheckAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8301:1: ( ( ruleCheck ) )
            // InternalLDef.g:8302:1: ( ruleCheck )
            {
            // InternalLDef.g:8302:1: ( ruleCheck )
            // InternalLDef.g:8303:1: ruleCheck
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getCheckCheckParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCheck();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getCheckCheckParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__CheckAssignment_2_1"


    // $ANTLR start "rule__Scanner_SingleLineRule__EndSeqAssignment_3_1"
    // InternalLDef.g:8312:1: rule__Scanner_SingleLineRule__EndSeqAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__EndSeqAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8316:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8317:1: ( RULE_STRING )
            {
            // InternalLDef.g:8317:1: ( RULE_STRING )
            // InternalLDef.g:8318:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_SingleLineRule__EndSeqAssignment_3_1"


    // $ANTLR start "rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2"
    // InternalLDef.g:8327:1: rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8331:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8332:1: ( RULE_STRING )
            {
            // InternalLDef.g:8332:1: ( RULE_STRING )
            // InternalLDef.g:8333:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8342:1: rule__Scanner_MultiLineRule__StartSeqAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__StartSeqAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8346:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8347:1: ( RULE_STRING )
            {
            // InternalLDef.g:8347:1: ( RULE_STRING )
            // InternalLDef.g:8348:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__Scanner_MultiLineRule__CheckAssignment_2_1"
    // InternalLDef.g:8357:1: rule__Scanner_MultiLineRule__CheckAssignment_2_1 : ( ruleCheck ) ;
    public final void rule__Scanner_MultiLineRule__CheckAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8361:1: ( ( ruleCheck ) )
            // InternalLDef.g:8362:1: ( ruleCheck )
            {
            // InternalLDef.g:8362:1: ( ruleCheck )
            // InternalLDef.g:8363:1: ruleCheck
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getCheckCheckParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCheck();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getCheckCheckParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__CheckAssignment_2_1"


    // $ANTLR start "rule__Scanner_MultiLineRule__EndSeqAssignment_4"
    // InternalLDef.g:8372:1: rule__Scanner_MultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8376:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8377:1: ( RULE_STRING )
            {
            // InternalLDef.g:8377:1: ( RULE_STRING )
            // InternalLDef.g:8378:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__EndSeqAssignment_4"


    // $ANTLR start "rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2"
    // InternalLDef.g:8387:1: rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8391:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8392:1: ( RULE_STRING )
            {
            // InternalLDef.g:8392:1: ( RULE_STRING )
            // InternalLDef.g:8393:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_MultiLineRule__EscapeSeqAssignment_5_2"


    // $ANTLR start "rule__Scanner_PatternRule__StartPatternAssignment_1"
    // InternalLDef.g:8402:1: rule__Scanner_PatternRule__StartPatternAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_PatternRule__StartPatternAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8406:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8407:1: ( RULE_STRING )
            {
            // InternalLDef.g:8407:1: ( RULE_STRING )
            // InternalLDef.g:8408:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getStartPatternSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8417:1: rule__Scanner_PatternRule__LengthAssignment_2 : ( RULE_INT ) ;
    public final void rule__Scanner_PatternRule__LengthAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8421:1: ( ( RULE_INT ) )
            // InternalLDef.g:8422:1: ( RULE_INT )
            {
            // InternalLDef.g:8422:1: ( RULE_INT )
            // InternalLDef.g:8423:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getLengthINTTerminalRuleCall_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__Scanner_PatternRule__CheckAssignment_3_1"
    // InternalLDef.g:8432:1: rule__Scanner_PatternRule__CheckAssignment_3_1 : ( ruleCheck ) ;
    public final void rule__Scanner_PatternRule__CheckAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8436:1: ( ( ruleCheck ) )
            // InternalLDef.g:8437:1: ( ruleCheck )
            {
            // InternalLDef.g:8437:1: ( ruleCheck )
            // InternalLDef.g:8438:1: ruleCheck
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCheck();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_PatternRule__CheckAssignment_3_1"


    // $ANTLR start "rule__Scanner_PatternRule__ContentPatternAssignment_5"
    // InternalLDef.g:8447:1: rule__Scanner_PatternRule__ContentPatternAssignment_5 : ( RULE_STRING ) ;
    public final void rule__Scanner_PatternRule__ContentPatternAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8451:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8452:1: ( RULE_STRING )
            {
            // InternalLDef.g:8452:1: ( RULE_STRING )
            // InternalLDef.g:8453:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_PatternRuleAccess().getContentPatternSTRINGTerminalRuleCall_5_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_PatternRuleAccess().getContentPatternSTRINGTerminalRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_PatternRule__ContentPatternAssignment_5"


    // $ANTLR start "rule__Scanner_CharacterRule__CharactersAssignment_2"
    // InternalLDef.g:8462:1: rule__Scanner_CharacterRule__CharactersAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_CharacterRule__CharactersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8466:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8467:1: ( RULE_STRING )
            {
            // InternalLDef.g:8467:1: ( RULE_STRING )
            // InternalLDef.g:8468:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8477:1: rule__Scanner_CharacterRule__CharactersAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_CharacterRule__CharactersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8481:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8482:1: ( RULE_STRING )
            {
            // InternalLDef.g:8482:1: ( RULE_STRING )
            // InternalLDef.g:8483:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__Scanner_CharacterRule__CheckAssignment_5_1"
    // InternalLDef.g:8492:1: rule__Scanner_CharacterRule__CheckAssignment_5_1 : ( ruleCheck ) ;
    public final void rule__Scanner_CharacterRule__CheckAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8496:1: ( ( ruleCheck ) )
            // InternalLDef.g:8497:1: ( ruleCheck )
            {
            // InternalLDef.g:8497:1: ( ruleCheck )
            // InternalLDef.g:8498:1: ruleCheck
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_CharacterRuleAccess().getCheckCheckParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCheck();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_CharacterRuleAccess().getCheckCheckParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_CharacterRule__CheckAssignment_5_1"


    // $ANTLR start "rule__Scanner_JSRule__FileURIAssignment_1"
    // InternalLDef.g:8507:1: rule__Scanner_JSRule__FileURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_JSRule__FileURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8511:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8512:1: ( RULE_STRING )
            {
            // InternalLDef.g:8512:1: ( RULE_STRING )
            // InternalLDef.g:8513:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__Scanner_JSRule__CheckAssignment_2_1"
    // InternalLDef.g:8522:1: rule__Scanner_JSRule__CheckAssignment_2_1 : ( ruleCheck ) ;
    public final void rule__Scanner_JSRule__CheckAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8526:1: ( ( ruleCheck ) )
            // InternalLDef.g:8527:1: ( ruleCheck )
            {
            // InternalLDef.g:8527:1: ( ruleCheck )
            // InternalLDef.g:8528:1: ruleCheck
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScanner_JSRuleAccess().getCheckCheckParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCheck();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScanner_JSRuleAccess().getCheckCheckParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_JSRule__CheckAssignment_2_1"


    // $ANTLR start "rule__Equals__ValueAssignment_1"
    // InternalLDef.g:8537:1: rule__Equals__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__Equals__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8541:1: ( ( RULE_INT ) )
            // InternalLDef.g:8542:1: ( RULE_INT )
            {
            // InternalLDef.g:8542:1: ( RULE_INT )
            // InternalLDef.g:8543:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getValueINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getValueINTTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__ValueAssignment_1"


    // $ANTLR start "rule__Range__LtInclAssignment_1"
    // InternalLDef.g:8552:1: rule__Range__LtInclAssignment_1 : ( ( rule__Range__LtInclAlternatives_1_0 ) ) ;
    public final void rule__Range__LtInclAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8556:1: ( ( ( rule__Range__LtInclAlternatives_1_0 ) ) )
            // InternalLDef.g:8557:1: ( ( rule__Range__LtInclAlternatives_1_0 ) )
            {
            // InternalLDef.g:8557:1: ( ( rule__Range__LtInclAlternatives_1_0 ) )
            // InternalLDef.g:8558:1: ( rule__Range__LtInclAlternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getLtInclAlternatives_1_0()); 
            }
            // InternalLDef.g:8559:1: ( rule__Range__LtInclAlternatives_1_0 )
            // InternalLDef.g:8559:2: rule__Range__LtInclAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Range__LtInclAlternatives_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getLtInclAlternatives_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__LtInclAssignment_1"


    // $ANTLR start "rule__Range__MinValueAssignment_2"
    // InternalLDef.g:8568:1: rule__Range__MinValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__Range__MinValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8572:1: ( ( RULE_INT ) )
            // InternalLDef.g:8573:1: ( RULE_INT )
            {
            // InternalLDef.g:8573:1: ( RULE_INT )
            // InternalLDef.g:8574:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMinValueINTTerminalRuleCall_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getMinValueINTTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__MinValueAssignment_2"


    // $ANTLR start "rule__Range__MaxValueAssignment_4"
    // InternalLDef.g:8583:1: rule__Range__MaxValueAssignment_4 : ( RULE_INT ) ;
    public final void rule__Range__MaxValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8587:1: ( ( RULE_INT ) )
            // InternalLDef.g:8588:1: ( RULE_INT )
            {
            // InternalLDef.g:8588:1: ( RULE_INT )
            // InternalLDef.g:8589:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMaxValueINTTerminalRuleCall_4_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getMaxValueINTTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__MaxValueAssignment_4"


    // $ANTLR start "rule__Range__GtInclAssignment_5"
    // InternalLDef.g:8598:1: rule__Range__GtInclAssignment_5 : ( ( rule__Range__GtInclAlternatives_5_0 ) ) ;
    public final void rule__Range__GtInclAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8602:1: ( ( ( rule__Range__GtInclAlternatives_5_0 ) ) )
            // InternalLDef.g:8603:1: ( ( rule__Range__GtInclAlternatives_5_0 ) )
            {
            // InternalLDef.g:8603:1: ( ( rule__Range__GtInclAlternatives_5_0 ) )
            // InternalLDef.g:8604:1: ( rule__Range__GtInclAlternatives_5_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getGtInclAlternatives_5_0()); 
            }
            // InternalLDef.g:8605:1: ( rule__Range__GtInclAlternatives_5_0 )
            // InternalLDef.g:8605:2: rule__Range__GtInclAlternatives_5_0
            {
            pushFollow(FOLLOW_2);
            rule__Range__GtInclAlternatives_5_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getGtInclAlternatives_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__GtInclAssignment_5"


    // $ANTLR start "rule__WhitespaceRule__CharactersAssignment_1_0_1"
    // InternalLDef.g:8614:1: rule__WhitespaceRule__CharactersAssignment_1_0_1 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__CharactersAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8618:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8619:1: ( RULE_STRING )
            {
            // InternalLDef.g:8619:1: ( RULE_STRING )
            // InternalLDef.g:8620:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8629:1: rule__WhitespaceRule__CharactersAssignment_1_0_2_1 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__CharactersAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8633:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8634:1: ( RULE_STRING )
            {
            // InternalLDef.g:8634:1: ( RULE_STRING )
            // InternalLDef.g:8635:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_2_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8644:1: rule__WhitespaceRule__JavawhitespaceAssignment_1_1 : ( ( 'javawhitespace' ) ) ;
    public final void rule__WhitespaceRule__JavawhitespaceAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8648:1: ( ( ( 'javawhitespace' ) ) )
            // InternalLDef.g:8649:1: ( ( 'javawhitespace' ) )
            {
            // InternalLDef.g:8649:1: ( ( 'javawhitespace' ) )
            // InternalLDef.g:8650:1: ( 'javawhitespace' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            }
            // InternalLDef.g:8651:1: ( 'javawhitespace' )
            // InternalLDef.g:8652:1: 'javawhitespace'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
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
    // InternalLDef.g:8667:1: rule__WhitespaceRule__FileURIAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__WhitespaceRule__FileURIAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLDef.g:8671:1: ( ( RULE_STRING ) )
            // InternalLDef.g:8672:1: ( RULE_STRING )
            {
            // InternalLDef.g:8672:1: ( RULE_STRING )
            // InternalLDef.g:8673:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000840000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000380000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000100000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000800000080000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0004000000000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000000012L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000148850000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000148850000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000010000004000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000080080000040L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000010000000040L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000006040L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0008000000001020L});

}