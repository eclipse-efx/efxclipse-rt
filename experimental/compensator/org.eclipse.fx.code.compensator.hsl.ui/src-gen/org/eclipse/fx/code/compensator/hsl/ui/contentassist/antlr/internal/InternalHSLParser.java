package org.eclipse.fx.code.compensator.hsl.ui.contentassist.antlr.internal; 

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
import org.eclipse.fx.code.compensator.hsl.services.HSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalHSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'bold'", "'italic'", "'underline'", "'strike-through'", "'{'", "'}'", "'partition'", "'rule-partitioner'", "'js-partitioner'", "'scanner'", "'token'", "'fgcolor'", "':'", "'bgcolor'", "'font'", "'keywords'", "'['", "']'", "','", "'since'", "'single-line'", "'=>'", "'escaped'", "'by'", "'multi-line'", "'character-rule'", "'javascript-rule'", "'whitespace-rule'", "'#{'", "'}#'", "'rgb'", "'('", "')'", "'default'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
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
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=6;
    public static final int T__44=44;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalHSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalHSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalHSLParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g"; }


     
     	private HSLGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(HSLGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:76:1: ( rule__Model__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:76:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRulePartition"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:88:1: entryRulePartition : rulePartition EOF ;
    public final void entryRulePartition() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:89:1: ( rulePartition EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:90:1: rulePartition EOF
            {
             before(grammarAccess.getPartitionRule()); 
            pushFollow(FOLLOW_rulePartition_in_entryRulePartition121);
            rulePartition();

            state._fsp--;

             after(grammarAccess.getPartitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition128); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:97:1: rulePartition : ( ( rule__Partition__Group__0 ) ) ;
    public final void rulePartition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:101:2: ( ( ( rule__Partition__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:102:1: ( ( rule__Partition__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:102:1: ( ( rule__Partition__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:103:1: ( rule__Partition__Group__0 )
            {
             before(grammarAccess.getPartitionAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:104:1: ( rule__Partition__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:104:2: rule__Partition__Group__0
            {
            pushFollow(FOLLOW_rule__Partition__Group__0_in_rulePartition154);
            rule__Partition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPartitionAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:116:1: entryRulePartitioner : rulePartitioner EOF ;
    public final void entryRulePartitioner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:117:1: ( rulePartitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:118:1: rulePartitioner EOF
            {
             before(grammarAccess.getPartitionerRule()); 
            pushFollow(FOLLOW_rulePartitioner_in_entryRulePartitioner181);
            rulePartitioner();

            state._fsp--;

             after(grammarAccess.getPartitionerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner188); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:125:1: rulePartitioner : ( ( rule__Partitioner__Alternatives ) ) ;
    public final void rulePartitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:129:2: ( ( ( rule__Partitioner__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:130:1: ( ( rule__Partitioner__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:130:1: ( ( rule__Partitioner__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:131:1: ( rule__Partitioner__Alternatives )
            {
             before(grammarAccess.getPartitionerAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:132:1: ( rule__Partitioner__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:132:2: rule__Partitioner__Alternatives
            {
            pushFollow(FOLLOW_rule__Partitioner__Alternatives_in_rulePartitioner214);
            rule__Partitioner__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPartitionerAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleRulePartitioner"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:144:1: entryRuleRulePartitioner : ruleRulePartitioner EOF ;
    public final void entryRuleRulePartitioner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:145:1: ( ruleRulePartitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:146:1: ruleRulePartitioner EOF
            {
             before(grammarAccess.getRulePartitionerRule()); 
            pushFollow(FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner241);
            ruleRulePartitioner();

            state._fsp--;

             after(grammarAccess.getRulePartitionerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRulePartitioner248); 

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
    // $ANTLR end "entryRuleRulePartitioner"


    // $ANTLR start "ruleRulePartitioner"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:153:1: ruleRulePartitioner : ( ( rule__RulePartitioner__Group__0 ) ) ;
    public final void ruleRulePartitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:157:2: ( ( ( rule__RulePartitioner__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:158:1: ( ( rule__RulePartitioner__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:158:1: ( ( rule__RulePartitioner__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:159:1: ( rule__RulePartitioner__Group__0 )
            {
             before(grammarAccess.getRulePartitionerAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:160:1: ( rule__RulePartitioner__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:160:2: rule__RulePartitioner__Group__0
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__0_in_ruleRulePartitioner274);
            rule__RulePartitioner__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRulePartitionerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRulePartitioner"


    // $ANTLR start "entryRuleJSParitioner"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:172:1: entryRuleJSParitioner : ruleJSParitioner EOF ;
    public final void entryRuleJSParitioner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:173:1: ( ruleJSParitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:174:1: ruleJSParitioner EOF
            {
             before(grammarAccess.getJSParitionerRule()); 
            pushFollow(FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner301);
            ruleJSParitioner();

            state._fsp--;

             after(grammarAccess.getJSParitionerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSParitioner308); 

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
    // $ANTLR end "entryRuleJSParitioner"


    // $ANTLR start "ruleJSParitioner"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:181:1: ruleJSParitioner : ( ( rule__JSParitioner__Group__0 ) ) ;
    public final void ruleJSParitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:185:2: ( ( ( rule__JSParitioner__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:186:1: ( ( rule__JSParitioner__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:186:1: ( ( rule__JSParitioner__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:187:1: ( rule__JSParitioner__Group__0 )
            {
             before(grammarAccess.getJSParitionerAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:188:1: ( rule__JSParitioner__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:188:2: rule__JSParitioner__Group__0
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__0_in_ruleJSParitioner334);
            rule__JSParitioner__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJSParitionerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJSParitioner"


    // $ANTLR start "entryRuleScanner"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:200:1: entryRuleScanner : ruleScanner EOF ;
    public final void entryRuleScanner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:201:1: ( ruleScanner EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:202:1: ruleScanner EOF
            {
             before(grammarAccess.getScannerRule()); 
            pushFollow(FOLLOW_ruleScanner_in_entryRuleScanner361);
            ruleScanner();

            state._fsp--;

             after(grammarAccess.getScannerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner368); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:209:1: ruleScanner : ( ( rule__Scanner__Group__0 ) ) ;
    public final void ruleScanner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:213:2: ( ( ( rule__Scanner__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:214:1: ( ( rule__Scanner__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:214:1: ( ( rule__Scanner__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:215:1: ( rule__Scanner__Group__0 )
            {
             before(grammarAccess.getScannerAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:216:1: ( rule__Scanner__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:216:2: rule__Scanner__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner__Group__0_in_ruleScanner394);
            rule__Scanner__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScannerAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleScannerToken"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:228:1: entryRuleScannerToken : ruleScannerToken EOF ;
    public final void entryRuleScannerToken() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:229:1: ( ruleScannerToken EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:230:1: ruleScannerToken EOF
            {
             before(grammarAccess.getScannerTokenRule()); 
            pushFollow(FOLLOW_ruleScannerToken_in_entryRuleScannerToken421);
            ruleScannerToken();

            state._fsp--;

             after(grammarAccess.getScannerTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerToken428); 

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
    // $ANTLR end "entryRuleScannerToken"


    // $ANTLR start "ruleScannerToken"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:237:1: ruleScannerToken : ( ( rule__ScannerToken__Group__0 ) ) ;
    public final void ruleScannerToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:241:2: ( ( ( rule__ScannerToken__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:242:1: ( ( rule__ScannerToken__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:242:1: ( ( rule__ScannerToken__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:243:1: ( rule__ScannerToken__Group__0 )
            {
             before(grammarAccess.getScannerTokenAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:244:1: ( rule__ScannerToken__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:244:2: rule__ScannerToken__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__0_in_ruleScannerToken454);
            rule__ScannerToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScannerTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScannerToken"


    // $ANTLR start "entryRuleKeywordGroup"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:256:1: entryRuleKeywordGroup : ruleKeywordGroup EOF ;
    public final void entryRuleKeywordGroup() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:257:1: ( ruleKeywordGroup EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:258:1: ruleKeywordGroup EOF
            {
             before(grammarAccess.getKeywordGroupRule()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup481);
            ruleKeywordGroup();

            state._fsp--;

             after(grammarAccess.getKeywordGroupRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordGroup488); 

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
    // $ANTLR end "entryRuleKeywordGroup"


    // $ANTLR start "ruleKeywordGroup"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:265:1: ruleKeywordGroup : ( ( rule__KeywordGroup__Group__0 ) ) ;
    public final void ruleKeywordGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:269:2: ( ( ( rule__KeywordGroup__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:270:1: ( ( rule__KeywordGroup__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:270:1: ( ( rule__KeywordGroup__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:271:1: ( rule__KeywordGroup__Group__0 )
            {
             before(grammarAccess.getKeywordGroupAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:272:1: ( rule__KeywordGroup__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:272:2: rule__KeywordGroup__Group__0
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__0_in_ruleKeywordGroup514);
            rule__KeywordGroup__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getKeywordGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKeywordGroup"


    // $ANTLR start "entryRuleKeyword"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:284:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:285:1: ( ruleKeyword EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:286:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword541);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword548); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:293:1: ruleKeyword : ( ( rule__Keyword__Group__0 ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:297:2: ( ( ( rule__Keyword__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:298:1: ( ( rule__Keyword__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:298:1: ( ( rule__Keyword__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:299:1: ( rule__Keyword__Group__0 )
            {
             before(grammarAccess.getKeywordAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:300:1: ( rule__Keyword__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:300:2: rule__Keyword__Group__0
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0_in_ruleKeyword574);
            rule__Keyword__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getKeywordAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleScannerRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:312:1: entryRuleScannerRule : ruleScannerRule EOF ;
    public final void entryRuleScannerRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:313:1: ( ruleScannerRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:314:1: ruleScannerRule EOF
            {
             before(grammarAccess.getScannerRuleRule()); 
            pushFollow(FOLLOW_ruleScannerRule_in_entryRuleScannerRule601);
            ruleScannerRule();

            state._fsp--;

             after(grammarAccess.getScannerRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerRule608); 

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
    // $ANTLR end "entryRuleScannerRule"


    // $ANTLR start "ruleScannerRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:321:1: ruleScannerRule : ( ( rule__ScannerRule__Alternatives ) ) ;
    public final void ruleScannerRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:325:2: ( ( ( rule__ScannerRule__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:326:1: ( ( rule__ScannerRule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:326:1: ( ( rule__ScannerRule__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:327:1: ( rule__ScannerRule__Alternatives )
            {
             before(grammarAccess.getScannerRuleAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:328:1: ( rule__ScannerRule__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:328:2: rule__ScannerRule__Alternatives
            {
            pushFollow(FOLLOW_rule__ScannerRule__Alternatives_in_ruleScannerRule634);
            rule__ScannerRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getScannerRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScannerRule"


    // $ANTLR start "entryRuleParitionRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:340:1: entryRuleParitionRule : ruleParitionRule EOF ;
    public final void entryRuleParitionRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:341:1: ( ruleParitionRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:342:1: ruleParitionRule EOF
            {
             before(grammarAccess.getParitionRuleRule()); 
            pushFollow(FOLLOW_ruleParitionRule_in_entryRuleParitionRule661);
            ruleParitionRule();

            state._fsp--;

             after(grammarAccess.getParitionRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitionRule668); 

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
    // $ANTLR end "entryRuleParitionRule"


    // $ANTLR start "ruleParitionRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:349:1: ruleParitionRule : ( ( rule__ParitionRule__Alternatives ) ) ;
    public final void ruleParitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:353:2: ( ( ( rule__ParitionRule__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:354:1: ( ( rule__ParitionRule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:354:1: ( ( rule__ParitionRule__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:355:1: ( rule__ParitionRule__Alternatives )
            {
             before(grammarAccess.getParitionRuleAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:356:1: ( rule__ParitionRule__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:356:2: rule__ParitionRule__Alternatives
            {
            pushFollow(FOLLOW_rule__ParitionRule__Alternatives_in_ruleParitionRule694);
            rule__ParitionRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getParitionRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParitionRule"


    // $ANTLR start "entryRuleScannerSingleLineRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:368:1: entryRuleScannerSingleLineRule : ruleScannerSingleLineRule EOF ;
    public final void entryRuleScannerSingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:369:1: ( ruleScannerSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:370:1: ruleScannerSingleLineRule EOF
            {
             before(grammarAccess.getScannerSingleLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule721);
            ruleScannerSingleLineRule();

            state._fsp--;

             after(grammarAccess.getScannerSingleLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerSingleLineRule728); 

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
    // $ANTLR end "entryRuleScannerSingleLineRule"


    // $ANTLR start "ruleScannerSingleLineRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:377:1: ruleScannerSingleLineRule : ( ( rule__ScannerSingleLineRule__Group__0 ) ) ;
    public final void ruleScannerSingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:381:2: ( ( ( rule__ScannerSingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:382:1: ( ( rule__ScannerSingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:382:1: ( ( rule__ScannerSingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:383:1: ( rule__ScannerSingleLineRule__Group__0 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:384:1: ( rule__ScannerSingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:384:2: rule__ScannerSingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__0_in_ruleScannerSingleLineRule754);
            rule__ScannerSingleLineRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScannerSingleLineRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScannerSingleLineRule"


    // $ANTLR start "entryRulePartitionSingleLineRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:396:1: entryRulePartitionSingleLineRule : rulePartitionSingleLineRule EOF ;
    public final void entryRulePartitionSingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:397:1: ( rulePartitionSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:398:1: rulePartitionSingleLineRule EOF
            {
             before(grammarAccess.getPartitionSingleLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule781);
            rulePartitionSingleLineRule();

            state._fsp--;

             after(grammarAccess.getPartitionSingleLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionSingleLineRule788); 

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
    // $ANTLR end "entryRulePartitionSingleLineRule"


    // $ANTLR start "rulePartitionSingleLineRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:405:1: rulePartitionSingleLineRule : ( ( rule__PartitionSingleLineRule__Group__0 ) ) ;
    public final void rulePartitionSingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:409:2: ( ( ( rule__PartitionSingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:410:1: ( ( rule__PartitionSingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:410:1: ( ( rule__PartitionSingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:411:1: ( rule__PartitionSingleLineRule__Group__0 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:412:1: ( rule__PartitionSingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:412:2: rule__PartitionSingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__0_in_rulePartitionSingleLineRule814);
            rule__PartitionSingleLineRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPartitionSingleLineRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePartitionSingleLineRule"


    // $ANTLR start "entryRuleScannerMultiLineRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:424:1: entryRuleScannerMultiLineRule : ruleScannerMultiLineRule EOF ;
    public final void entryRuleScannerMultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:425:1: ( ruleScannerMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:426:1: ruleScannerMultiLineRule EOF
            {
             before(grammarAccess.getScannerMultiLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule841);
            ruleScannerMultiLineRule();

            state._fsp--;

             after(grammarAccess.getScannerMultiLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerMultiLineRule848); 

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
    // $ANTLR end "entryRuleScannerMultiLineRule"


    // $ANTLR start "ruleScannerMultiLineRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:433:1: ruleScannerMultiLineRule : ( ( rule__ScannerMultiLineRule__Group__0 ) ) ;
    public final void ruleScannerMultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:437:2: ( ( ( rule__ScannerMultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:438:1: ( ( rule__ScannerMultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:438:1: ( ( rule__ScannerMultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:439:1: ( rule__ScannerMultiLineRule__Group__0 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:440:1: ( rule__ScannerMultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:440:2: rule__ScannerMultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__0_in_ruleScannerMultiLineRule874);
            rule__ScannerMultiLineRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScannerMultiLineRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScannerMultiLineRule"


    // $ANTLR start "entryRulePartitionMultiLineRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:452:1: entryRulePartitionMultiLineRule : rulePartitionMultiLineRule EOF ;
    public final void entryRulePartitionMultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:453:1: ( rulePartitionMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:454:1: rulePartitionMultiLineRule EOF
            {
             before(grammarAccess.getPartitionMultiLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule901);
            rulePartitionMultiLineRule();

            state._fsp--;

             after(grammarAccess.getPartitionMultiLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionMultiLineRule908); 

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
    // $ANTLR end "entryRulePartitionMultiLineRule"


    // $ANTLR start "rulePartitionMultiLineRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:461:1: rulePartitionMultiLineRule : ( ( rule__PartitionMultiLineRule__Group__0 ) ) ;
    public final void rulePartitionMultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:465:2: ( ( ( rule__PartitionMultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:466:1: ( ( rule__PartitionMultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:466:1: ( ( rule__PartitionMultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:467:1: ( rule__PartitionMultiLineRule__Group__0 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:468:1: ( rule__PartitionMultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:468:2: rule__PartitionMultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__0_in_rulePartitionMultiLineRule934);
            rule__PartitionMultiLineRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPartitionMultiLineRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePartitionMultiLineRule"


    // $ANTLR start "entryRuleScannerCharacterRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:480:1: entryRuleScannerCharacterRule : ruleScannerCharacterRule EOF ;
    public final void entryRuleScannerCharacterRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:481:1: ( ruleScannerCharacterRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:482:1: ruleScannerCharacterRule EOF
            {
             before(grammarAccess.getScannerCharacterRuleRule()); 
            pushFollow(FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule961);
            ruleScannerCharacterRule();

            state._fsp--;

             after(grammarAccess.getScannerCharacterRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerCharacterRule968); 

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
    // $ANTLR end "entryRuleScannerCharacterRule"


    // $ANTLR start "ruleScannerCharacterRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:489:1: ruleScannerCharacterRule : ( ( rule__ScannerCharacterRule__Group__0 ) ) ;
    public final void ruleScannerCharacterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:493:2: ( ( ( rule__ScannerCharacterRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:494:1: ( ( rule__ScannerCharacterRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:494:1: ( ( rule__ScannerCharacterRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:495:1: ( rule__ScannerCharacterRule__Group__0 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:496:1: ( rule__ScannerCharacterRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:496:2: rule__ScannerCharacterRule__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__0_in_ruleScannerCharacterRule994);
            rule__ScannerCharacterRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScannerCharacterRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScannerCharacterRule"


    // $ANTLR start "entryRuleScannerJSRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:508:1: entryRuleScannerJSRule : ruleScannerJSRule EOF ;
    public final void entryRuleScannerJSRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:509:1: ( ruleScannerJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:510:1: ruleScannerJSRule EOF
            {
             before(grammarAccess.getScannerJSRuleRule()); 
            pushFollow(FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule1021);
            ruleScannerJSRule();

            state._fsp--;

             after(grammarAccess.getScannerJSRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerJSRule1028); 

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
    // $ANTLR end "entryRuleScannerJSRule"


    // $ANTLR start "ruleScannerJSRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:517:1: ruleScannerJSRule : ( ( rule__ScannerJSRule__Group__0 ) ) ;
    public final void ruleScannerJSRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:521:2: ( ( ( rule__ScannerJSRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:522:1: ( ( rule__ScannerJSRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:522:1: ( ( rule__ScannerJSRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:523:1: ( rule__ScannerJSRule__Group__0 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:524:1: ( rule__ScannerJSRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:524:2: rule__ScannerJSRule__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__0_in_ruleScannerJSRule1054);
            rule__ScannerJSRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScannerJSRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScannerJSRule"


    // $ANTLR start "entryRulePartitionJSRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:536:1: entryRulePartitionJSRule : rulePartitionJSRule EOF ;
    public final void entryRulePartitionJSRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:537:1: ( rulePartitionJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:538:1: rulePartitionJSRule EOF
            {
             before(grammarAccess.getPartitionJSRuleRule()); 
            pushFollow(FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule1081);
            rulePartitionJSRule();

            state._fsp--;

             after(grammarAccess.getPartitionJSRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionJSRule1088); 

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
    // $ANTLR end "entryRulePartitionJSRule"


    // $ANTLR start "rulePartitionJSRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:545:1: rulePartitionJSRule : ( ( rule__PartitionJSRule__Group__0 ) ) ;
    public final void rulePartitionJSRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:549:2: ( ( ( rule__PartitionJSRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:550:1: ( ( rule__PartitionJSRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:550:1: ( ( rule__PartitionJSRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:551:1: ( rule__PartitionJSRule__Group__0 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:552:1: ( rule__PartitionJSRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:552:2: rule__PartitionJSRule__Group__0
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__0_in_rulePartitionJSRule1114);
            rule__PartitionJSRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPartitionJSRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePartitionJSRule"


    // $ANTLR start "entryRuleScannerWhitespaceRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:564:1: entryRuleScannerWhitespaceRule : ruleScannerWhitespaceRule EOF ;
    public final void entryRuleScannerWhitespaceRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:565:1: ( ruleScannerWhitespaceRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:566:1: ruleScannerWhitespaceRule EOF
            {
             before(grammarAccess.getScannerWhitespaceRuleRule()); 
            pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule1141);
            ruleScannerWhitespaceRule();

            state._fsp--;

             after(grammarAccess.getScannerWhitespaceRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerWhitespaceRule1148); 

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
    // $ANTLR end "entryRuleScannerWhitespaceRule"


    // $ANTLR start "ruleScannerWhitespaceRule"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:573:1: ruleScannerWhitespaceRule : ( ( rule__ScannerWhitespaceRule__Alternatives ) ) ;
    public final void ruleScannerWhitespaceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:577:2: ( ( ( rule__ScannerWhitespaceRule__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:578:1: ( ( rule__ScannerWhitespaceRule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:578:1: ( ( rule__ScannerWhitespaceRule__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:579:1: ( rule__ScannerWhitespaceRule__Alternatives )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:580:1: ( rule__ScannerWhitespaceRule__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:580:2: rule__ScannerWhitespaceRule__Alternatives
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Alternatives_in_ruleScannerWhitespaceRule1174);
            rule__ScannerWhitespaceRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScannerWhitespaceRule"


    // $ANTLR start "entryRuleColor"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:592:1: entryRuleColor : ruleColor EOF ;
    public final void entryRuleColor() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:593:1: ( ruleColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:594:1: ruleColor EOF
            {
             before(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor1201);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getColorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor1208); 

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
    // $ANTLR end "entryRuleColor"


    // $ANTLR start "ruleColor"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:601:1: ruleColor : ( ruleRGBColor ) ;
    public final void ruleColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:605:2: ( ( ruleRGBColor ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:606:1: ( ruleRGBColor )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:606:1: ( ruleRGBColor )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:607:1: ruleRGBColor
            {
             before(grammarAccess.getColorAccess().getRGBColorParserRuleCall()); 
            pushFollow(FOLLOW_ruleRGBColor_in_ruleColor1234);
            ruleRGBColor();

            state._fsp--;

             after(grammarAccess.getColorAccess().getRGBColorParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColor"


    // $ANTLR start "entryRuleRGBColor"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:620:1: entryRuleRGBColor : ruleRGBColor EOF ;
    public final void entryRuleRGBColor() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:621:1: ( ruleRGBColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:622:1: ruleRGBColor EOF
            {
             before(grammarAccess.getRGBColorRule()); 
            pushFollow(FOLLOW_ruleRGBColor_in_entryRuleRGBColor1260);
            ruleRGBColor();

            state._fsp--;

             after(grammarAccess.getRGBColorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGBColor1267); 

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
    // $ANTLR end "entryRuleRGBColor"


    // $ANTLR start "ruleRGBColor"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:629:1: ruleRGBColor : ( ( rule__RGBColor__Group__0 ) ) ;
    public final void ruleRGBColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:633:2: ( ( ( rule__RGBColor__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:634:1: ( ( rule__RGBColor__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:634:1: ( ( rule__RGBColor__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:635:1: ( rule__RGBColor__Group__0 )
            {
             before(grammarAccess.getRGBColorAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:636:1: ( rule__RGBColor__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:636:2: rule__RGBColor__Group__0
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__0_in_ruleRGBColor1293);
            rule__RGBColor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRGBColor"


    // $ANTLR start "entryRuleFont"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:648:1: entryRuleFont : ruleFont EOF ;
    public final void entryRuleFont() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:649:1: ( ruleFont EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:650:1: ruleFont EOF
            {
             before(grammarAccess.getFontRule()); 
            pushFollow(FOLLOW_ruleFont_in_entryRuleFont1320);
            ruleFont();

            state._fsp--;

             after(grammarAccess.getFontRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFont1327); 

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
    // $ANTLR end "entryRuleFont"


    // $ANTLR start "ruleFont"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:657:1: ruleFont : ( ( rule__Font__Group__0 ) ) ;
    public final void ruleFont() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:661:2: ( ( ( rule__Font__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:662:1: ( ( rule__Font__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:662:1: ( ( rule__Font__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:663:1: ( rule__Font__Group__0 )
            {
             before(grammarAccess.getFontAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:664:1: ( rule__Font__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:664:2: rule__Font__Group__0
            {
            pushFollow(FOLLOW_rule__Font__Group__0_in_ruleFont1353);
            rule__Font__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFontAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFont"


    // $ANTLR start "ruleFontType"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:677:1: ruleFontType : ( ( rule__FontType__Alternatives ) ) ;
    public final void ruleFontType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:681:1: ( ( ( rule__FontType__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:682:1: ( ( rule__FontType__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:682:1: ( ( rule__FontType__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:683:1: ( rule__FontType__Alternatives )
            {
             before(grammarAccess.getFontTypeAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:684:1: ( rule__FontType__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:684:2: rule__FontType__Alternatives
            {
            pushFollow(FOLLOW_rule__FontType__Alternatives_in_ruleFontType1390);
            rule__FontType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFontTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFontType"


    // $ANTLR start "rule__Partitioner__Alternatives"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:695:1: rule__Partitioner__Alternatives : ( ( ruleRulePartitioner ) | ( ruleJSParitioner ) );
    public final void rule__Partitioner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:699:1: ( ( ruleRulePartitioner ) | ( ruleJSParitioner ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==18) ) {
                alt1=1;
            }
            else if ( (LA1_0==19) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:700:1: ( ruleRulePartitioner )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:700:1: ( ruleRulePartitioner )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:701:1: ruleRulePartitioner
                    {
                     before(grammarAccess.getPartitionerAccess().getRulePartitionerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRulePartitioner_in_rule__Partitioner__Alternatives1425);
                    ruleRulePartitioner();

                    state._fsp--;

                     after(grammarAccess.getPartitionerAccess().getRulePartitionerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:706:6: ( ruleJSParitioner )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:706:6: ( ruleJSParitioner )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:707:1: ruleJSParitioner
                    {
                     before(grammarAccess.getPartitionerAccess().getJSParitionerParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleJSParitioner_in_rule__Partitioner__Alternatives1442);
                    ruleJSParitioner();

                    state._fsp--;

                     after(grammarAccess.getPartitionerAccess().getJSParitionerParserRuleCall_1()); 

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


    // $ANTLR start "rule__ScannerRule__Alternatives"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:717:1: rule__ScannerRule__Alternatives : ( ( ruleScannerSingleLineRule ) | ( ruleScannerMultiLineRule ) | ( ruleScannerCharacterRule ) | ( ruleScannerJSRule ) | ( ruleScannerWhitespaceRule ) );
    public final void rule__ScannerRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:721:1: ( ( ruleScannerSingleLineRule ) | ( ruleScannerMultiLineRule ) | ( ruleScannerCharacterRule ) | ( ruleScannerJSRule ) | ( ruleScannerWhitespaceRule ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt2=1;
                }
                break;
            case 35:
                {
                alt2=2;
                }
                break;
            case 36:
                {
                alt2=3;
                }
                break;
            case 37:
                {
                alt2=4;
                }
                break;
            case 38:
            case 39:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:722:1: ( ruleScannerSingleLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:722:1: ( ruleScannerSingleLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:723:1: ruleScannerSingleLineRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleScannerSingleLineRule_in_rule__ScannerRule__Alternatives1474);
                    ruleScannerSingleLineRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:728:6: ( ruleScannerMultiLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:728:6: ( ruleScannerMultiLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:729:1: ruleScannerMultiLineRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleScannerMultiLineRule_in_rule__ScannerRule__Alternatives1491);
                    ruleScannerMultiLineRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:734:6: ( ruleScannerCharacterRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:734:6: ( ruleScannerCharacterRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:735:1: ruleScannerCharacterRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleScannerCharacterRule_in_rule__ScannerRule__Alternatives1508);
                    ruleScannerCharacterRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:740:6: ( ruleScannerJSRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:740:6: ( ruleScannerJSRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:741:1: ruleScannerJSRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleScannerJSRule_in_rule__ScannerRule__Alternatives1525);
                    ruleScannerJSRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:746:6: ( ruleScannerWhitespaceRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:746:6: ( ruleScannerWhitespaceRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:747:1: ruleScannerWhitespaceRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerWhitespaceRuleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_rule__ScannerRule__Alternatives1542);
                    ruleScannerWhitespaceRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerWhitespaceRuleParserRuleCall_4()); 

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
    // $ANTLR end "rule__ScannerRule__Alternatives"


    // $ANTLR start "rule__ParitionRule__Alternatives"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:757:1: rule__ParitionRule__Alternatives : ( ( rulePartitionSingleLineRule ) | ( rulePartitionMultiLineRule ) | ( rulePartitionJSRule ) );
    public final void rule__ParitionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:761:1: ( ( rulePartitionSingleLineRule ) | ( rulePartitionMultiLineRule ) | ( rulePartitionJSRule ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt3=1;
                }
                break;
            case 35:
                {
                alt3=2;
                }
                break;
            case 37:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:762:1: ( rulePartitionSingleLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:762:1: ( rulePartitionSingleLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:763:1: rulePartitionSingleLineRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePartitionSingleLineRule_in_rule__ParitionRule__Alternatives1574);
                    rulePartitionSingleLineRule();

                    state._fsp--;

                     after(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:768:6: ( rulePartitionMultiLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:768:6: ( rulePartitionMultiLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:769:1: rulePartitionMultiLineRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_rulePartitionMultiLineRule_in_rule__ParitionRule__Alternatives1591);
                    rulePartitionMultiLineRule();

                    state._fsp--;

                     after(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:774:6: ( rulePartitionJSRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:774:6: ( rulePartitionJSRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:775:1: rulePartitionJSRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionJSRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_rulePartitionJSRule_in_rule__ParitionRule__Alternatives1608);
                    rulePartitionJSRule();

                    state._fsp--;

                     after(grammarAccess.getParitionRuleAccess().getPartitionJSRuleParserRuleCall_2()); 

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
    // $ANTLR end "rule__ParitionRule__Alternatives"


    // $ANTLR start "rule__ScannerWhitespaceRule__Alternatives"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:785:1: rule__ScannerWhitespaceRule__Alternatives : ( ( ( rule__ScannerWhitespaceRule__Group_0__0 ) ) | ( ( rule__ScannerWhitespaceRule__Group_1__0 ) ) );
    public final void rule__ScannerWhitespaceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:789:1: ( ( ( rule__ScannerWhitespaceRule__Group_0__0 ) ) | ( ( rule__ScannerWhitespaceRule__Group_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==38) ) {
                alt4=1;
            }
            else if ( (LA4_0==39) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:790:1: ( ( rule__ScannerWhitespaceRule__Group_0__0 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:790:1: ( ( rule__ScannerWhitespaceRule__Group_0__0 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:791:1: ( rule__ScannerWhitespaceRule__Group_0__0 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_0()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:792:1: ( rule__ScannerWhitespaceRule__Group_0__0 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:792:2: rule__ScannerWhitespaceRule__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__0_in_rule__ScannerWhitespaceRule__Alternatives1640);
                    rule__ScannerWhitespaceRule__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:796:6: ( ( rule__ScannerWhitespaceRule__Group_1__0 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:796:6: ( ( rule__ScannerWhitespaceRule__Group_1__0 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:797:1: ( rule__ScannerWhitespaceRule__Group_1__0 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_1()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:798:1: ( rule__ScannerWhitespaceRule__Group_1__0 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:798:2: rule__ScannerWhitespaceRule__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__0_in_rule__ScannerWhitespaceRule__Alternatives1658);
                    rule__ScannerWhitespaceRule__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_1()); 

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
    // $ANTLR end "rule__ScannerWhitespaceRule__Alternatives"


    // $ANTLR start "rule__FontType__Alternatives"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:807:1: rule__FontType__Alternatives : ( ( ( 'bold' ) ) | ( ( 'italic' ) ) | ( ( 'underline' ) ) | ( ( 'strike-through' ) ) );
    public final void rule__FontType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:811:1: ( ( ( 'bold' ) ) | ( ( 'italic' ) ) | ( ( 'underline' ) ) | ( ( 'strike-through' ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt5=1;
                }
                break;
            case 12:
                {
                alt5=2;
                }
                break;
            case 13:
                {
                alt5=3;
                }
                break;
            case 14:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:812:1: ( ( 'bold' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:812:1: ( ( 'bold' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:813:1: ( 'bold' )
                    {
                     before(grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:814:1: ( 'bold' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:814:3: 'bold'
                    {
                    match(input,11,FOLLOW_11_in_rule__FontType__Alternatives1692); 

                    }

                     after(grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:819:6: ( ( 'italic' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:819:6: ( ( 'italic' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:820:1: ( 'italic' )
                    {
                     before(grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:821:1: ( 'italic' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:821:3: 'italic'
                    {
                    match(input,12,FOLLOW_12_in_rule__FontType__Alternatives1713); 

                    }

                     after(grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:826:6: ( ( 'underline' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:826:6: ( ( 'underline' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:827:1: ( 'underline' )
                    {
                     before(grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:828:1: ( 'underline' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:828:3: 'underline'
                    {
                    match(input,13,FOLLOW_13_in_rule__FontType__Alternatives1734); 

                    }

                     after(grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:833:6: ( ( 'strike-through' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:833:6: ( ( 'strike-through' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:834:1: ( 'strike-through' )
                    {
                     before(grammarAccess.getFontTypeAccess().getStrike_throughEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:835:1: ( 'strike-through' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:835:3: 'strike-through'
                    {
                    match(input,14,FOLLOW_14_in_rule__FontType__Alternatives1755); 

                    }

                     after(grammarAccess.getFontTypeAccess().getStrike_throughEnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__FontType__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:847:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:851:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:852:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01788);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01791);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:859:1: rule__Model__Group__0__Impl : ( ( rule__Model__NameAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:863:1: ( ( ( rule__Model__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:864:1: ( ( rule__Model__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:864:1: ( ( rule__Model__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:865:1: ( rule__Model__NameAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:866:1: ( rule__Model__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:866:2: rule__Model__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__NameAssignment_0_in_rule__Model__Group__0__Impl1818);
            rule__Model__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:876:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:880:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:881:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11848);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__11851);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:888:1: rule__Model__Group__1__Impl : ( '{' ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:892:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:893:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:893:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:894:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__Model__Group__1__Impl1879); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:907:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:911:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:912:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__21910);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__21913);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:919:1: rule__Model__Group__2__Impl : ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:923:1: ( ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:924:1: ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:924:1: ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:925:1: ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:925:1: ( ( rule__Model__PartitionsAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:926:1: ( rule__Model__PartitionsAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:927:1: ( rule__Model__PartitionsAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:927:2: rule__Model__PartitionsAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl1942);
            rule__Model__PartitionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:930:1: ( ( rule__Model__PartitionsAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:931:1: ( rule__Model__PartitionsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:932:1: ( rule__Model__PartitionsAssignment_2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:932:2: rule__Model__PartitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl1954);
            	    rule__Model__PartitionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:943:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:947:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:948:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__31987);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__4_in_rule__Model__Group__31990);
            rule__Model__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:955:1: rule__Model__Group__3__Impl : ( ( ( rule__Model__ScannerAssignment_3 ) ) ( ( rule__Model__ScannerAssignment_3 )* ) ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:959:1: ( ( ( ( rule__Model__ScannerAssignment_3 ) ) ( ( rule__Model__ScannerAssignment_3 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:960:1: ( ( ( rule__Model__ScannerAssignment_3 ) ) ( ( rule__Model__ScannerAssignment_3 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:960:1: ( ( ( rule__Model__ScannerAssignment_3 ) ) ( ( rule__Model__ScannerAssignment_3 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:961:1: ( ( rule__Model__ScannerAssignment_3 ) ) ( ( rule__Model__ScannerAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:961:1: ( ( rule__Model__ScannerAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:962:1: ( rule__Model__ScannerAssignment_3 )
            {
             before(grammarAccess.getModelAccess().getScannerAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:963:1: ( rule__Model__ScannerAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:963:2: rule__Model__ScannerAssignment_3
            {
            pushFollow(FOLLOW_rule__Model__ScannerAssignment_3_in_rule__Model__Group__3__Impl2019);
            rule__Model__ScannerAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getScannerAssignment_3()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:966:1: ( ( rule__Model__ScannerAssignment_3 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:967:1: ( rule__Model__ScannerAssignment_3 )*
            {
             before(grammarAccess.getModelAccess().getScannerAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:968:1: ( rule__Model__ScannerAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:968:2: rule__Model__ScannerAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Model__ScannerAssignment_3_in_rule__Model__Group__3__Impl2031);
            	    rule__Model__ScannerAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getScannerAssignment_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:979:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:983:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:984:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__42064);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__5_in_rule__Model__Group__42067);
            rule__Model__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:991:1: rule__Model__Group__4__Impl : ( ( rule__Model__PartitionerAssignment_4 ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:995:1: ( ( ( rule__Model__PartitionerAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:996:1: ( ( rule__Model__PartitionerAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:996:1: ( ( rule__Model__PartitionerAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:997:1: ( rule__Model__PartitionerAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getPartitionerAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:998:1: ( rule__Model__PartitionerAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:998:2: rule__Model__PartitionerAssignment_4
            {
            pushFollow(FOLLOW_rule__Model__PartitionerAssignment_4_in_rule__Model__Group__4__Impl2094);
            rule__Model__PartitionerAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPartitionerAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__Model__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1008:1: rule__Model__Group__5 : rule__Model__Group__5__Impl ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1012:1: ( rule__Model__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1013:2: rule__Model__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__52124);
            rule__Model__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5"


    // $ANTLR start "rule__Model__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1019:1: rule__Model__Group__5__Impl : ( '}' ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1023:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1024:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1024:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1025:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,16,FOLLOW_16_in_rule__Model__Group__5__Impl2152); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5__Impl"


    // $ANTLR start "rule__Partition__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1050:1: rule__Partition__Group__0 : rule__Partition__Group__0__Impl rule__Partition__Group__1 ;
    public final void rule__Partition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1054:1: ( rule__Partition__Group__0__Impl rule__Partition__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1055:2: rule__Partition__Group__0__Impl rule__Partition__Group__1
            {
            pushFollow(FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__02195);
            rule__Partition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__02198);
            rule__Partition__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1062:1: rule__Partition__Group__0__Impl : ( 'partition' ) ;
    public final void rule__Partition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1066:1: ( ( 'partition' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1067:1: ( 'partition' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1067:1: ( 'partition' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1068:1: 'partition'
            {
             before(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Partition__Group__0__Impl2226); 
             after(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1081:1: rule__Partition__Group__1 : rule__Partition__Group__1__Impl ;
    public final void rule__Partition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1085:1: ( rule__Partition__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1086:2: rule__Partition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__12257);
            rule__Partition__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1092:1: rule__Partition__Group__1__Impl : ( ( rule__Partition__NameAssignment_1 ) ) ;
    public final void rule__Partition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1096:1: ( ( ( rule__Partition__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1097:1: ( ( rule__Partition__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1097:1: ( ( rule__Partition__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1098:1: ( rule__Partition__NameAssignment_1 )
            {
             before(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1099:1: ( rule__Partition__NameAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1099:2: rule__Partition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl2284);
            rule__Partition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPartitionAccess().getNameAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__RulePartitioner__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1113:1: rule__RulePartitioner__Group__0 : rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1 ;
    public final void rule__RulePartitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1117:1: ( rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1118:2: rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__0__Impl_in_rule__RulePartitioner__Group__02318);
            rule__RulePartitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__1_in_rule__RulePartitioner__Group__02321);
            rule__RulePartitioner__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RulePartitioner__Group__0"


    // $ANTLR start "rule__RulePartitioner__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1125:1: rule__RulePartitioner__Group__0__Impl : ( 'rule-partitioner' ) ;
    public final void rule__RulePartitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1129:1: ( ( 'rule-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1130:1: ( 'rule-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1130:1: ( 'rule-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1131:1: 'rule-partitioner'
            {
             before(grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__RulePartitioner__Group__0__Impl2349); 
             after(grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RulePartitioner__Group__0__Impl"


    // $ANTLR start "rule__RulePartitioner__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1144:1: rule__RulePartitioner__Group__1 : rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2 ;
    public final void rule__RulePartitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1148:1: ( rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1149:2: rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__1__Impl_in_rule__RulePartitioner__Group__12380);
            rule__RulePartitioner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__2_in_rule__RulePartitioner__Group__12383);
            rule__RulePartitioner__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RulePartitioner__Group__1"


    // $ANTLR start "rule__RulePartitioner__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1156:1: rule__RulePartitioner__Group__1__Impl : ( '{' ) ;
    public final void rule__RulePartitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1160:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1161:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1161:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1162:1: '{'
            {
             before(grammarAccess.getRulePartitionerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__RulePartitioner__Group__1__Impl2411); 
             after(grammarAccess.getRulePartitionerAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RulePartitioner__Group__1__Impl"


    // $ANTLR start "rule__RulePartitioner__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1175:1: rule__RulePartitioner__Group__2 : rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3 ;
    public final void rule__RulePartitioner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1179:1: ( rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1180:2: rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__2__Impl_in_rule__RulePartitioner__Group__22442);
            rule__RulePartitioner__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__3_in_rule__RulePartitioner__Group__22445);
            rule__RulePartitioner__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RulePartitioner__Group__2"


    // $ANTLR start "rule__RulePartitioner__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1187:1: rule__RulePartitioner__Group__2__Impl : ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) ) ;
    public final void rule__RulePartitioner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1191:1: ( ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1192:1: ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1192:1: ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1193:1: ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1193:1: ( ( rule__RulePartitioner__RulesAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1194:1: ( rule__RulePartitioner__RulesAssignment_2 )
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1195:1: ( rule__RulePartitioner__RulesAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1195:2: rule__RulePartitioner__RulesAssignment_2
            {
            pushFollow(FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl2474);
            rule__RulePartitioner__RulesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1198:1: ( ( rule__RulePartitioner__RulesAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1199:1: ( rule__RulePartitioner__RulesAssignment_2 )*
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1200:1: ( rule__RulePartitioner__RulesAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==31||LA8_0==35||LA8_0==37) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1200:2: rule__RulePartitioner__RulesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl2486);
            	    rule__RulePartitioner__RulesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RulePartitioner__Group__2__Impl"


    // $ANTLR start "rule__RulePartitioner__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1211:1: rule__RulePartitioner__Group__3 : rule__RulePartitioner__Group__3__Impl ;
    public final void rule__RulePartitioner__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1215:1: ( rule__RulePartitioner__Group__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1216:2: rule__RulePartitioner__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__3__Impl_in_rule__RulePartitioner__Group__32519);
            rule__RulePartitioner__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RulePartitioner__Group__3"


    // $ANTLR start "rule__RulePartitioner__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1222:1: rule__RulePartitioner__Group__3__Impl : ( '}' ) ;
    public final void rule__RulePartitioner__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1226:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1227:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1227:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1228:1: '}'
            {
             before(grammarAccess.getRulePartitionerAccess().getRightCurlyBracketKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__RulePartitioner__Group__3__Impl2547); 
             after(grammarAccess.getRulePartitionerAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RulePartitioner__Group__3__Impl"


    // $ANTLR start "rule__JSParitioner__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1249:1: rule__JSParitioner__Group__0 : rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1 ;
    public final void rule__JSParitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1253:1: ( rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1254:2: rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__0__Impl_in_rule__JSParitioner__Group__02586);
            rule__JSParitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSParitioner__Group__1_in_rule__JSParitioner__Group__02589);
            rule__JSParitioner__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSParitioner__Group__0"


    // $ANTLR start "rule__JSParitioner__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1261:1: rule__JSParitioner__Group__0__Impl : ( 'js-partitioner' ) ;
    public final void rule__JSParitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1265:1: ( ( 'js-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1266:1: ( 'js-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1266:1: ( 'js-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1267:1: 'js-partitioner'
            {
             before(grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__JSParitioner__Group__0__Impl2617); 
             after(grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSParitioner__Group__0__Impl"


    // $ANTLR start "rule__JSParitioner__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1280:1: rule__JSParitioner__Group__1 : rule__JSParitioner__Group__1__Impl ;
    public final void rule__JSParitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1284:1: ( rule__JSParitioner__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1285:2: rule__JSParitioner__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__1__Impl_in_rule__JSParitioner__Group__12648);
            rule__JSParitioner__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSParitioner__Group__1"


    // $ANTLR start "rule__JSParitioner__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1291:1: rule__JSParitioner__Group__1__Impl : ( ( rule__JSParitioner__FileURIAssignment_1 ) ) ;
    public final void rule__JSParitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1295:1: ( ( ( rule__JSParitioner__FileURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1296:1: ( ( rule__JSParitioner__FileURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1296:1: ( ( rule__JSParitioner__FileURIAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1297:1: ( rule__JSParitioner__FileURIAssignment_1 )
            {
             before(grammarAccess.getJSParitionerAccess().getFileURIAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1298:1: ( rule__JSParitioner__FileURIAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1298:2: rule__JSParitioner__FileURIAssignment_1
            {
            pushFollow(FOLLOW_rule__JSParitioner__FileURIAssignment_1_in_rule__JSParitioner__Group__1__Impl2675);
            rule__JSParitioner__FileURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJSParitionerAccess().getFileURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSParitioner__Group__1__Impl"


    // $ANTLR start "rule__Scanner__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1312:1: rule__Scanner__Group__0 : rule__Scanner__Group__0__Impl rule__Scanner__Group__1 ;
    public final void rule__Scanner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1316:1: ( rule__Scanner__Group__0__Impl rule__Scanner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1317:2: rule__Scanner__Group__0__Impl rule__Scanner__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner__Group__0__Impl_in_rule__Scanner__Group__02709);
            rule__Scanner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner__Group__1_in_rule__Scanner__Group__02712);
            rule__Scanner__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__0"


    // $ANTLR start "rule__Scanner__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1324:1: rule__Scanner__Group__0__Impl : ( 'scanner' ) ;
    public final void rule__Scanner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1328:1: ( ( 'scanner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1329:1: ( 'scanner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1329:1: ( 'scanner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1330:1: 'scanner'
            {
             before(grammarAccess.getScannerAccess().getScannerKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__Scanner__Group__0__Impl2740); 
             after(grammarAccess.getScannerAccess().getScannerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__0__Impl"


    // $ANTLR start "rule__Scanner__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1343:1: rule__Scanner__Group__1 : rule__Scanner__Group__1__Impl rule__Scanner__Group__2 ;
    public final void rule__Scanner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1347:1: ( rule__Scanner__Group__1__Impl rule__Scanner__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1348:2: rule__Scanner__Group__1__Impl rule__Scanner__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner__Group__1__Impl_in_rule__Scanner__Group__12771);
            rule__Scanner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner__Group__2_in_rule__Scanner__Group__12774);
            rule__Scanner__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__1"


    // $ANTLR start "rule__Scanner__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1355:1: rule__Scanner__Group__1__Impl : ( ( rule__Scanner__PartitionAssignment_1 ) ) ;
    public final void rule__Scanner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1359:1: ( ( ( rule__Scanner__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1360:1: ( ( rule__Scanner__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1360:1: ( ( rule__Scanner__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1361:1: ( rule__Scanner__PartitionAssignment_1 )
            {
             before(grammarAccess.getScannerAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1362:1: ( rule__Scanner__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1362:2: rule__Scanner__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner__PartitionAssignment_1_in_rule__Scanner__Group__1__Impl2801);
            rule__Scanner__PartitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerAccess().getPartitionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__1__Impl"


    // $ANTLR start "rule__Scanner__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1372:1: rule__Scanner__Group__2 : rule__Scanner__Group__2__Impl rule__Scanner__Group__3 ;
    public final void rule__Scanner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1376:1: ( rule__Scanner__Group__2__Impl rule__Scanner__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1377:2: rule__Scanner__Group__2__Impl rule__Scanner__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner__Group__2__Impl_in_rule__Scanner__Group__22831);
            rule__Scanner__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner__Group__3_in_rule__Scanner__Group__22834);
            rule__Scanner__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__2"


    // $ANTLR start "rule__Scanner__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1384:1: rule__Scanner__Group__2__Impl : ( '{' ) ;
    public final void rule__Scanner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1388:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1389:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1389:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1390:1: '{'
            {
             before(grammarAccess.getScannerAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,15,FOLLOW_15_in_rule__Scanner__Group__2__Impl2862); 
             after(grammarAccess.getScannerAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__2__Impl"


    // $ANTLR start "rule__Scanner__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1403:1: rule__Scanner__Group__3 : rule__Scanner__Group__3__Impl rule__Scanner__Group__4 ;
    public final void rule__Scanner__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1407:1: ( rule__Scanner__Group__3__Impl rule__Scanner__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1408:2: rule__Scanner__Group__3__Impl rule__Scanner__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner__Group__3__Impl_in_rule__Scanner__Group__32893);
            rule__Scanner__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner__Group__4_in_rule__Scanner__Group__32896);
            rule__Scanner__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__3"


    // $ANTLR start "rule__Scanner__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1415:1: rule__Scanner__Group__3__Impl : ( ( rule__Scanner__TokensAssignment_3 )* ) ;
    public final void rule__Scanner__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1419:1: ( ( ( rule__Scanner__TokensAssignment_3 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1420:1: ( ( rule__Scanner__TokensAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1420:1: ( ( rule__Scanner__TokensAssignment_3 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1421:1: ( rule__Scanner__TokensAssignment_3 )*
            {
             before(grammarAccess.getScannerAccess().getTokensAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1422:1: ( rule__Scanner__TokensAssignment_3 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21||LA9_0==44) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1422:2: rule__Scanner__TokensAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Scanner__TokensAssignment_3_in_rule__Scanner__Group__3__Impl2923);
            	    rule__Scanner__TokensAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getScannerAccess().getTokensAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__3__Impl"


    // $ANTLR start "rule__Scanner__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1432:1: rule__Scanner__Group__4 : rule__Scanner__Group__4__Impl rule__Scanner__Group__5 ;
    public final void rule__Scanner__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1436:1: ( rule__Scanner__Group__4__Impl rule__Scanner__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1437:2: rule__Scanner__Group__4__Impl rule__Scanner__Group__5
            {
            pushFollow(FOLLOW_rule__Scanner__Group__4__Impl_in_rule__Scanner__Group__42954);
            rule__Scanner__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner__Group__5_in_rule__Scanner__Group__42957);
            rule__Scanner__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__4"


    // $ANTLR start "rule__Scanner__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1444:1: rule__Scanner__Group__4__Impl : ( ( rule__Scanner__KeywordGroupsAssignment_4 )* ) ;
    public final void rule__Scanner__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1448:1: ( ( ( rule__Scanner__KeywordGroupsAssignment_4 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1449:1: ( ( rule__Scanner__KeywordGroupsAssignment_4 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1449:1: ( ( rule__Scanner__KeywordGroupsAssignment_4 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1450:1: ( rule__Scanner__KeywordGroupsAssignment_4 )*
            {
             before(grammarAccess.getScannerAccess().getKeywordGroupsAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1451:1: ( rule__Scanner__KeywordGroupsAssignment_4 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1451:2: rule__Scanner__KeywordGroupsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Scanner__KeywordGroupsAssignment_4_in_rule__Scanner__Group__4__Impl2984);
            	    rule__Scanner__KeywordGroupsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getScannerAccess().getKeywordGroupsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__4__Impl"


    // $ANTLR start "rule__Scanner__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1461:1: rule__Scanner__Group__5 : rule__Scanner__Group__5__Impl rule__Scanner__Group__6 ;
    public final void rule__Scanner__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1465:1: ( rule__Scanner__Group__5__Impl rule__Scanner__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1466:2: rule__Scanner__Group__5__Impl rule__Scanner__Group__6
            {
            pushFollow(FOLLOW_rule__Scanner__Group__5__Impl_in_rule__Scanner__Group__53015);
            rule__Scanner__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner__Group__6_in_rule__Scanner__Group__53018);
            rule__Scanner__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__5"


    // $ANTLR start "rule__Scanner__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1473:1: rule__Scanner__Group__5__Impl : ( ( ( rule__Scanner__RulesAssignment_5 ) ) ( ( rule__Scanner__RulesAssignment_5 )* ) ) ;
    public final void rule__Scanner__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1477:1: ( ( ( ( rule__Scanner__RulesAssignment_5 ) ) ( ( rule__Scanner__RulesAssignment_5 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1478:1: ( ( ( rule__Scanner__RulesAssignment_5 ) ) ( ( rule__Scanner__RulesAssignment_5 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1478:1: ( ( ( rule__Scanner__RulesAssignment_5 ) ) ( ( rule__Scanner__RulesAssignment_5 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1479:1: ( ( rule__Scanner__RulesAssignment_5 ) ) ( ( rule__Scanner__RulesAssignment_5 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1479:1: ( ( rule__Scanner__RulesAssignment_5 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1480:1: ( rule__Scanner__RulesAssignment_5 )
            {
             before(grammarAccess.getScannerAccess().getRulesAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1481:1: ( rule__Scanner__RulesAssignment_5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1481:2: rule__Scanner__RulesAssignment_5
            {
            pushFollow(FOLLOW_rule__Scanner__RulesAssignment_5_in_rule__Scanner__Group__5__Impl3047);
            rule__Scanner__RulesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getScannerAccess().getRulesAssignment_5()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1484:1: ( ( rule__Scanner__RulesAssignment_5 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1485:1: ( rule__Scanner__RulesAssignment_5 )*
            {
             before(grammarAccess.getScannerAccess().getRulesAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1486:1: ( rule__Scanner__RulesAssignment_5 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==31||(LA11_0>=35 && LA11_0<=39)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1486:2: rule__Scanner__RulesAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Scanner__RulesAssignment_5_in_rule__Scanner__Group__5__Impl3059);
            	    rule__Scanner__RulesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getScannerAccess().getRulesAssignment_5()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__5__Impl"


    // $ANTLR start "rule__Scanner__Group__6"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1497:1: rule__Scanner__Group__6 : rule__Scanner__Group__6__Impl ;
    public final void rule__Scanner__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1501:1: ( rule__Scanner__Group__6__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1502:2: rule__Scanner__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Scanner__Group__6__Impl_in_rule__Scanner__Group__63092);
            rule__Scanner__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__6"


    // $ANTLR start "rule__Scanner__Group__6__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1508:1: rule__Scanner__Group__6__Impl : ( '}' ) ;
    public final void rule__Scanner__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1512:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1513:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1513:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1514:1: '}'
            {
             before(grammarAccess.getScannerAccess().getRightCurlyBracketKeyword_6()); 
            match(input,16,FOLLOW_16_in_rule__Scanner__Group__6__Impl3120); 
             after(grammarAccess.getScannerAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__Group__6__Impl"


    // $ANTLR start "rule__ScannerToken__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1541:1: rule__ScannerToken__Group__0 : rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1 ;
    public final void rule__ScannerToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1545:1: ( rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1546:2: rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__0__Impl_in_rule__ScannerToken__Group__03165);
            rule__ScannerToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__1_in_rule__ScannerToken__Group__03168);
            rule__ScannerToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group__0"


    // $ANTLR start "rule__ScannerToken__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1553:1: rule__ScannerToken__Group__0__Impl : ( ( rule__ScannerToken__DefaultAssignment_0 )? ) ;
    public final void rule__ScannerToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1557:1: ( ( ( rule__ScannerToken__DefaultAssignment_0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1558:1: ( ( rule__ScannerToken__DefaultAssignment_0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1558:1: ( ( rule__ScannerToken__DefaultAssignment_0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1559:1: ( rule__ScannerToken__DefaultAssignment_0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1560:1: ( rule__ScannerToken__DefaultAssignment_0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==44) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1560:2: rule__ScannerToken__DefaultAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__DefaultAssignment_0_in_rule__ScannerToken__Group__0__Impl3195);
                    rule__ScannerToken__DefaultAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScannerTokenAccess().getDefaultAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group__0__Impl"


    // $ANTLR start "rule__ScannerToken__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1570:1: rule__ScannerToken__Group__1 : rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2 ;
    public final void rule__ScannerToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1574:1: ( rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1575:2: rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__1__Impl_in_rule__ScannerToken__Group__13226);
            rule__ScannerToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__2_in_rule__ScannerToken__Group__13229);
            rule__ScannerToken__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group__1"


    // $ANTLR start "rule__ScannerToken__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1582:1: rule__ScannerToken__Group__1__Impl : ( 'token' ) ;
    public final void rule__ScannerToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1586:1: ( ( 'token' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1587:1: ( 'token' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1587:1: ( 'token' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1588:1: 'token'
            {
             before(grammarAccess.getScannerTokenAccess().getTokenKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__ScannerToken__Group__1__Impl3257); 
             after(grammarAccess.getScannerTokenAccess().getTokenKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group__1__Impl"


    // $ANTLR start "rule__ScannerToken__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1601:1: rule__ScannerToken__Group__2 : rule__ScannerToken__Group__2__Impl rule__ScannerToken__Group__3 ;
    public final void rule__ScannerToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1605:1: ( rule__ScannerToken__Group__2__Impl rule__ScannerToken__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1606:2: rule__ScannerToken__Group__2__Impl rule__ScannerToken__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__2__Impl_in_rule__ScannerToken__Group__23288);
            rule__ScannerToken__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__3_in_rule__ScannerToken__Group__23291);
            rule__ScannerToken__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group__2"


    // $ANTLR start "rule__ScannerToken__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1613:1: rule__ScannerToken__Group__2__Impl : ( ( rule__ScannerToken__NameAssignment_2 ) ) ;
    public final void rule__ScannerToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1617:1: ( ( ( rule__ScannerToken__NameAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1618:1: ( ( rule__ScannerToken__NameAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1618:1: ( ( rule__ScannerToken__NameAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1619:1: ( rule__ScannerToken__NameAssignment_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getNameAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1620:1: ( rule__ScannerToken__NameAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1620:2: rule__ScannerToken__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__NameAssignment_2_in_rule__ScannerToken__Group__2__Impl3318);
            rule__ScannerToken__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getScannerTokenAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group__2__Impl"


    // $ANTLR start "rule__ScannerToken__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1630:1: rule__ScannerToken__Group__3 : rule__ScannerToken__Group__3__Impl ;
    public final void rule__ScannerToken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1634:1: ( rule__ScannerToken__Group__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1635:2: rule__ScannerToken__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__3__Impl_in_rule__ScannerToken__Group__33348);
            rule__ScannerToken__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group__3"


    // $ANTLR start "rule__ScannerToken__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1641:1: rule__ScannerToken__Group__3__Impl : ( ( rule__ScannerToken__Group_3__0 )? ) ;
    public final void rule__ScannerToken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1645:1: ( ( ( rule__ScannerToken__Group_3__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1646:1: ( ( rule__ScannerToken__Group_3__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1646:1: ( ( rule__ScannerToken__Group_3__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1647:1: ( rule__ScannerToken__Group_3__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1648:1: ( rule__ScannerToken__Group_3__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==15) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1648:2: rule__ScannerToken__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3__0_in_rule__ScannerToken__Group__3__Impl3375);
                    rule__ScannerToken__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScannerTokenAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group__3__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1666:1: rule__ScannerToken__Group_3__0 : rule__ScannerToken__Group_3__0__Impl rule__ScannerToken__Group_3__1 ;
    public final void rule__ScannerToken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1670:1: ( rule__ScannerToken__Group_3__0__Impl rule__ScannerToken__Group_3__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1671:2: rule__ScannerToken__Group_3__0__Impl rule__ScannerToken__Group_3__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__0__Impl_in_rule__ScannerToken__Group_3__03414);
            rule__ScannerToken__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__1_in_rule__ScannerToken__Group_3__03417);
            rule__ScannerToken__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3__0"


    // $ANTLR start "rule__ScannerToken__Group_3__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1678:1: rule__ScannerToken__Group_3__0__Impl : ( '{' ) ;
    public final void rule__ScannerToken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1682:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1683:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1683:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1684:1: '{'
            {
             before(grammarAccess.getScannerTokenAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,15,FOLLOW_15_in_rule__ScannerToken__Group_3__0__Impl3445); 
             after(grammarAccess.getScannerTokenAccess().getLeftCurlyBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3__0__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1697:1: rule__ScannerToken__Group_3__1 : rule__ScannerToken__Group_3__1__Impl rule__ScannerToken__Group_3__2 ;
    public final void rule__ScannerToken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1701:1: ( rule__ScannerToken__Group_3__1__Impl rule__ScannerToken__Group_3__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1702:2: rule__ScannerToken__Group_3__1__Impl rule__ScannerToken__Group_3__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__1__Impl_in_rule__ScannerToken__Group_3__13476);
            rule__ScannerToken__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__2_in_rule__ScannerToken__Group_3__13479);
            rule__ScannerToken__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3__1"


    // $ANTLR start "rule__ScannerToken__Group_3__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1709:1: rule__ScannerToken__Group_3__1__Impl : ( ( rule__ScannerToken__Group_3_1__0 )? ) ;
    public final void rule__ScannerToken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1713:1: ( ( ( rule__ScannerToken__Group_3_1__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1714:1: ( ( rule__ScannerToken__Group_3_1__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1714:1: ( ( rule__ScannerToken__Group_3_1__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1715:1: ( rule__ScannerToken__Group_3_1__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1716:1: ( rule__ScannerToken__Group_3_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1716:2: rule__ScannerToken__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__0_in_rule__ScannerToken__Group_3__1__Impl3506);
                    rule__ScannerToken__Group_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScannerTokenAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3__1__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1726:1: rule__ScannerToken__Group_3__2 : rule__ScannerToken__Group_3__2__Impl rule__ScannerToken__Group_3__3 ;
    public final void rule__ScannerToken__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1730:1: ( rule__ScannerToken__Group_3__2__Impl rule__ScannerToken__Group_3__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1731:2: rule__ScannerToken__Group_3__2__Impl rule__ScannerToken__Group_3__3
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__2__Impl_in_rule__ScannerToken__Group_3__23537);
            rule__ScannerToken__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__3_in_rule__ScannerToken__Group_3__23540);
            rule__ScannerToken__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3__2"


    // $ANTLR start "rule__ScannerToken__Group_3__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1738:1: rule__ScannerToken__Group_3__2__Impl : ( ( rule__ScannerToken__Group_3_2__0 )? ) ;
    public final void rule__ScannerToken__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1742:1: ( ( ( rule__ScannerToken__Group_3_2__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1743:1: ( ( rule__ScannerToken__Group_3_2__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1743:1: ( ( rule__ScannerToken__Group_3_2__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1744:1: ( rule__ScannerToken__Group_3_2__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1745:1: ( rule__ScannerToken__Group_3_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1745:2: rule__ScannerToken__Group_3_2__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__0_in_rule__ScannerToken__Group_3__2__Impl3567);
                    rule__ScannerToken__Group_3_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScannerTokenAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3__2__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1755:1: rule__ScannerToken__Group_3__3 : rule__ScannerToken__Group_3__3__Impl rule__ScannerToken__Group_3__4 ;
    public final void rule__ScannerToken__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1759:1: ( rule__ScannerToken__Group_3__3__Impl rule__ScannerToken__Group_3__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1760:2: rule__ScannerToken__Group_3__3__Impl rule__ScannerToken__Group_3__4
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__3__Impl_in_rule__ScannerToken__Group_3__33598);
            rule__ScannerToken__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__4_in_rule__ScannerToken__Group_3__33601);
            rule__ScannerToken__Group_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3__3"


    // $ANTLR start "rule__ScannerToken__Group_3__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1767:1: rule__ScannerToken__Group_3__3__Impl : ( ( rule__ScannerToken__Group_3_3__0 )? ) ;
    public final void rule__ScannerToken__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1771:1: ( ( ( rule__ScannerToken__Group_3_3__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1772:1: ( ( rule__ScannerToken__Group_3_3__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1772:1: ( ( rule__ScannerToken__Group_3_3__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1773:1: ( rule__ScannerToken__Group_3_3__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1774:1: ( rule__ScannerToken__Group_3_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1774:2: rule__ScannerToken__Group_3_3__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__0_in_rule__ScannerToken__Group_3__3__Impl3628);
                    rule__ScannerToken__Group_3_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScannerTokenAccess().getGroup_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3__3__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1784:1: rule__ScannerToken__Group_3__4 : rule__ScannerToken__Group_3__4__Impl ;
    public final void rule__ScannerToken__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1788:1: ( rule__ScannerToken__Group_3__4__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1789:2: rule__ScannerToken__Group_3__4__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__4__Impl_in_rule__ScannerToken__Group_3__43659);
            rule__ScannerToken__Group_3__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3__4"


    // $ANTLR start "rule__ScannerToken__Group_3__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1795:1: rule__ScannerToken__Group_3__4__Impl : ( '}' ) ;
    public final void rule__ScannerToken__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1799:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1800:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1800:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1801:1: '}'
            {
             before(grammarAccess.getScannerTokenAccess().getRightCurlyBracketKeyword_3_4()); 
            match(input,16,FOLLOW_16_in_rule__ScannerToken__Group_3__4__Impl3687); 
             after(grammarAccess.getScannerTokenAccess().getRightCurlyBracketKeyword_3_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3__4__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3_1__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1824:1: rule__ScannerToken__Group_3_1__0 : rule__ScannerToken__Group_3_1__0__Impl rule__ScannerToken__Group_3_1__1 ;
    public final void rule__ScannerToken__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1828:1: ( rule__ScannerToken__Group_3_1__0__Impl rule__ScannerToken__Group_3_1__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1829:2: rule__ScannerToken__Group_3_1__0__Impl rule__ScannerToken__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__0__Impl_in_rule__ScannerToken__Group_3_1__03728);
            rule__ScannerToken__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__1_in_rule__ScannerToken__Group_3_1__03731);
            rule__ScannerToken__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_1__0"


    // $ANTLR start "rule__ScannerToken__Group_3_1__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1836:1: rule__ScannerToken__Group_3_1__0__Impl : ( 'fgcolor' ) ;
    public final void rule__ScannerToken__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1840:1: ( ( 'fgcolor' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1841:1: ( 'fgcolor' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1841:1: ( 'fgcolor' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1842:1: 'fgcolor'
            {
             before(grammarAccess.getScannerTokenAccess().getFgcolorKeyword_3_1_0()); 
            match(input,22,FOLLOW_22_in_rule__ScannerToken__Group_3_1__0__Impl3759); 
             after(grammarAccess.getScannerTokenAccess().getFgcolorKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_1__0__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3_1__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1855:1: rule__ScannerToken__Group_3_1__1 : rule__ScannerToken__Group_3_1__1__Impl rule__ScannerToken__Group_3_1__2 ;
    public final void rule__ScannerToken__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1859:1: ( rule__ScannerToken__Group_3_1__1__Impl rule__ScannerToken__Group_3_1__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1860:2: rule__ScannerToken__Group_3_1__1__Impl rule__ScannerToken__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__1__Impl_in_rule__ScannerToken__Group_3_1__13790);
            rule__ScannerToken__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__2_in_rule__ScannerToken__Group_3_1__13793);
            rule__ScannerToken__Group_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_1__1"


    // $ANTLR start "rule__ScannerToken__Group_3_1__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1867:1: rule__ScannerToken__Group_3_1__1__Impl : ( ':' ) ;
    public final void rule__ScannerToken__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1871:1: ( ( ':' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1872:1: ( ':' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1872:1: ( ':' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1873:1: ':'
            {
             before(grammarAccess.getScannerTokenAccess().getColonKeyword_3_1_1()); 
            match(input,23,FOLLOW_23_in_rule__ScannerToken__Group_3_1__1__Impl3821); 
             after(grammarAccess.getScannerTokenAccess().getColonKeyword_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_1__1__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3_1__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1886:1: rule__ScannerToken__Group_3_1__2 : rule__ScannerToken__Group_3_1__2__Impl ;
    public final void rule__ScannerToken__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1890:1: ( rule__ScannerToken__Group_3_1__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1891:2: rule__ScannerToken__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__2__Impl_in_rule__ScannerToken__Group_3_1__23852);
            rule__ScannerToken__Group_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_1__2"


    // $ANTLR start "rule__ScannerToken__Group_3_1__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1897:1: rule__ScannerToken__Group_3_1__2__Impl : ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) ) ;
    public final void rule__ScannerToken__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1901:1: ( ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1902:1: ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1902:1: ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1903:1: ( rule__ScannerToken__FgColorAssignment_3_1_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getFgColorAssignment_3_1_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1904:1: ( rule__ScannerToken__FgColorAssignment_3_1_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1904:2: rule__ScannerToken__FgColorAssignment_3_1_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__FgColorAssignment_3_1_2_in_rule__ScannerToken__Group_3_1__2__Impl3879);
            rule__ScannerToken__FgColorAssignment_3_1_2();

            state._fsp--;


            }

             after(grammarAccess.getScannerTokenAccess().getFgColorAssignment_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_1__2__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3_2__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1920:1: rule__ScannerToken__Group_3_2__0 : rule__ScannerToken__Group_3_2__0__Impl rule__ScannerToken__Group_3_2__1 ;
    public final void rule__ScannerToken__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1924:1: ( rule__ScannerToken__Group_3_2__0__Impl rule__ScannerToken__Group_3_2__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1925:2: rule__ScannerToken__Group_3_2__0__Impl rule__ScannerToken__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__0__Impl_in_rule__ScannerToken__Group_3_2__03915);
            rule__ScannerToken__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__1_in_rule__ScannerToken__Group_3_2__03918);
            rule__ScannerToken__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_2__0"


    // $ANTLR start "rule__ScannerToken__Group_3_2__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1932:1: rule__ScannerToken__Group_3_2__0__Impl : ( 'bgcolor' ) ;
    public final void rule__ScannerToken__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1936:1: ( ( 'bgcolor' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1937:1: ( 'bgcolor' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1937:1: ( 'bgcolor' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1938:1: 'bgcolor'
            {
             before(grammarAccess.getScannerTokenAccess().getBgcolorKeyword_3_2_0()); 
            match(input,24,FOLLOW_24_in_rule__ScannerToken__Group_3_2__0__Impl3946); 
             after(grammarAccess.getScannerTokenAccess().getBgcolorKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_2__0__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3_2__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1951:1: rule__ScannerToken__Group_3_2__1 : rule__ScannerToken__Group_3_2__1__Impl rule__ScannerToken__Group_3_2__2 ;
    public final void rule__ScannerToken__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1955:1: ( rule__ScannerToken__Group_3_2__1__Impl rule__ScannerToken__Group_3_2__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1956:2: rule__ScannerToken__Group_3_2__1__Impl rule__ScannerToken__Group_3_2__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__1__Impl_in_rule__ScannerToken__Group_3_2__13977);
            rule__ScannerToken__Group_3_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__2_in_rule__ScannerToken__Group_3_2__13980);
            rule__ScannerToken__Group_3_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_2__1"


    // $ANTLR start "rule__ScannerToken__Group_3_2__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1963:1: rule__ScannerToken__Group_3_2__1__Impl : ( ':' ) ;
    public final void rule__ScannerToken__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1967:1: ( ( ':' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1968:1: ( ':' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1968:1: ( ':' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1969:1: ':'
            {
             before(grammarAccess.getScannerTokenAccess().getColonKeyword_3_2_1()); 
            match(input,23,FOLLOW_23_in_rule__ScannerToken__Group_3_2__1__Impl4008); 
             after(grammarAccess.getScannerTokenAccess().getColonKeyword_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_2__1__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3_2__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1982:1: rule__ScannerToken__Group_3_2__2 : rule__ScannerToken__Group_3_2__2__Impl ;
    public final void rule__ScannerToken__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1986:1: ( rule__ScannerToken__Group_3_2__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1987:2: rule__ScannerToken__Group_3_2__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__2__Impl_in_rule__ScannerToken__Group_3_2__24039);
            rule__ScannerToken__Group_3_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_2__2"


    // $ANTLR start "rule__ScannerToken__Group_3_2__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1993:1: rule__ScannerToken__Group_3_2__2__Impl : ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) ) ;
    public final void rule__ScannerToken__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1997:1: ( ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1998:1: ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1998:1: ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1999:1: ( rule__ScannerToken__BgColorAssignment_3_2_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getBgColorAssignment_3_2_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2000:1: ( rule__ScannerToken__BgColorAssignment_3_2_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2000:2: rule__ScannerToken__BgColorAssignment_3_2_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__BgColorAssignment_3_2_2_in_rule__ScannerToken__Group_3_2__2__Impl4066);
            rule__ScannerToken__BgColorAssignment_3_2_2();

            state._fsp--;


            }

             after(grammarAccess.getScannerTokenAccess().getBgColorAssignment_3_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_2__2__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3_3__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2016:1: rule__ScannerToken__Group_3_3__0 : rule__ScannerToken__Group_3_3__0__Impl rule__ScannerToken__Group_3_3__1 ;
    public final void rule__ScannerToken__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2020:1: ( rule__ScannerToken__Group_3_3__0__Impl rule__ScannerToken__Group_3_3__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2021:2: rule__ScannerToken__Group_3_3__0__Impl rule__ScannerToken__Group_3_3__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__0__Impl_in_rule__ScannerToken__Group_3_3__04102);
            rule__ScannerToken__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__1_in_rule__ScannerToken__Group_3_3__04105);
            rule__ScannerToken__Group_3_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_3__0"


    // $ANTLR start "rule__ScannerToken__Group_3_3__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2028:1: rule__ScannerToken__Group_3_3__0__Impl : ( 'font' ) ;
    public final void rule__ScannerToken__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2032:1: ( ( 'font' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2033:1: ( 'font' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2033:1: ( 'font' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2034:1: 'font'
            {
             before(grammarAccess.getScannerTokenAccess().getFontKeyword_3_3_0()); 
            match(input,25,FOLLOW_25_in_rule__ScannerToken__Group_3_3__0__Impl4133); 
             after(grammarAccess.getScannerTokenAccess().getFontKeyword_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_3__0__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3_3__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2047:1: rule__ScannerToken__Group_3_3__1 : rule__ScannerToken__Group_3_3__1__Impl rule__ScannerToken__Group_3_3__2 ;
    public final void rule__ScannerToken__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2051:1: ( rule__ScannerToken__Group_3_3__1__Impl rule__ScannerToken__Group_3_3__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2052:2: rule__ScannerToken__Group_3_3__1__Impl rule__ScannerToken__Group_3_3__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__1__Impl_in_rule__ScannerToken__Group_3_3__14164);
            rule__ScannerToken__Group_3_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__2_in_rule__ScannerToken__Group_3_3__14167);
            rule__ScannerToken__Group_3_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_3__1"


    // $ANTLR start "rule__ScannerToken__Group_3_3__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2059:1: rule__ScannerToken__Group_3_3__1__Impl : ( ':' ) ;
    public final void rule__ScannerToken__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2063:1: ( ( ':' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2064:1: ( ':' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2064:1: ( ':' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2065:1: ':'
            {
             before(grammarAccess.getScannerTokenAccess().getColonKeyword_3_3_1()); 
            match(input,23,FOLLOW_23_in_rule__ScannerToken__Group_3_3__1__Impl4195); 
             after(grammarAccess.getScannerTokenAccess().getColonKeyword_3_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_3__1__Impl"


    // $ANTLR start "rule__ScannerToken__Group_3_3__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2078:1: rule__ScannerToken__Group_3_3__2 : rule__ScannerToken__Group_3_3__2__Impl ;
    public final void rule__ScannerToken__Group_3_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2082:1: ( rule__ScannerToken__Group_3_3__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2083:2: rule__ScannerToken__Group_3_3__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__2__Impl_in_rule__ScannerToken__Group_3_3__24226);
            rule__ScannerToken__Group_3_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_3__2"


    // $ANTLR start "rule__ScannerToken__Group_3_3__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2089:1: rule__ScannerToken__Group_3_3__2__Impl : ( ( rule__ScannerToken__FontAssignment_3_3_2 ) ) ;
    public final void rule__ScannerToken__Group_3_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2093:1: ( ( ( rule__ScannerToken__FontAssignment_3_3_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2094:1: ( ( rule__ScannerToken__FontAssignment_3_3_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2094:1: ( ( rule__ScannerToken__FontAssignment_3_3_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2095:1: ( rule__ScannerToken__FontAssignment_3_3_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getFontAssignment_3_3_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2096:1: ( rule__ScannerToken__FontAssignment_3_3_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2096:2: rule__ScannerToken__FontAssignment_3_3_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__FontAssignment_3_3_2_in_rule__ScannerToken__Group_3_3__2__Impl4253);
            rule__ScannerToken__FontAssignment_3_3_2();

            state._fsp--;


            }

             after(grammarAccess.getScannerTokenAccess().getFontAssignment_3_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__Group_3_3__2__Impl"


    // $ANTLR start "rule__KeywordGroup__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2112:1: rule__KeywordGroup__Group__0 : rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1 ;
    public final void rule__KeywordGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2116:1: ( rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2117:2: rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__0__Impl_in_rule__KeywordGroup__Group__04289);
            rule__KeywordGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__1_in_rule__KeywordGroup__Group__04292);
            rule__KeywordGroup__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__0"


    // $ANTLR start "rule__KeywordGroup__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2124:1: rule__KeywordGroup__Group__0__Impl : ( 'keywords' ) ;
    public final void rule__KeywordGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2128:1: ( ( 'keywords' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2129:1: ( 'keywords' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2129:1: ( 'keywords' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2130:1: 'keywords'
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__KeywordGroup__Group__0__Impl4320); 
             after(grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__0__Impl"


    // $ANTLR start "rule__KeywordGroup__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2143:1: rule__KeywordGroup__Group__1 : rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2 ;
    public final void rule__KeywordGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2147:1: ( rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2148:2: rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__1__Impl_in_rule__KeywordGroup__Group__14351);
            rule__KeywordGroup__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__2_in_rule__KeywordGroup__Group__14354);
            rule__KeywordGroup__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__1"


    // $ANTLR start "rule__KeywordGroup__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2155:1: rule__KeywordGroup__Group__1__Impl : ( ( rule__KeywordGroup__TokenAssignment_1 ) ) ;
    public final void rule__KeywordGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2159:1: ( ( ( rule__KeywordGroup__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2160:1: ( ( rule__KeywordGroup__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2160:1: ( ( rule__KeywordGroup__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2161:1: ( rule__KeywordGroup__TokenAssignment_1 )
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2162:1: ( rule__KeywordGroup__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2162:2: rule__KeywordGroup__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__TokenAssignment_1_in_rule__KeywordGroup__Group__1__Impl4381);
            rule__KeywordGroup__TokenAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getKeywordGroupAccess().getTokenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__1__Impl"


    // $ANTLR start "rule__KeywordGroup__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2172:1: rule__KeywordGroup__Group__2 : rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3 ;
    public final void rule__KeywordGroup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2176:1: ( rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2177:2: rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__2__Impl_in_rule__KeywordGroup__Group__24411);
            rule__KeywordGroup__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__3_in_rule__KeywordGroup__Group__24414);
            rule__KeywordGroup__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__2"


    // $ANTLR start "rule__KeywordGroup__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2184:1: rule__KeywordGroup__Group__2__Impl : ( '[' ) ;
    public final void rule__KeywordGroup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2188:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2189:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2189:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2190:1: '['
            {
             before(grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2()); 
            match(input,27,FOLLOW_27_in_rule__KeywordGroup__Group__2__Impl4442); 
             after(grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__2__Impl"


    // $ANTLR start "rule__KeywordGroup__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2203:1: rule__KeywordGroup__Group__3 : rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4 ;
    public final void rule__KeywordGroup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2207:1: ( rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2208:2: rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__3__Impl_in_rule__KeywordGroup__Group__34473);
            rule__KeywordGroup__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__4_in_rule__KeywordGroup__Group__34476);
            rule__KeywordGroup__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__3"


    // $ANTLR start "rule__KeywordGroup__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2215:1: rule__KeywordGroup__Group__3__Impl : ( ( rule__KeywordGroup__KeywordsAssignment_3 ) ) ;
    public final void rule__KeywordGroup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2219:1: ( ( ( rule__KeywordGroup__KeywordsAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2220:1: ( ( rule__KeywordGroup__KeywordsAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2220:1: ( ( rule__KeywordGroup__KeywordsAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2221:1: ( rule__KeywordGroup__KeywordsAssignment_3 )
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2222:1: ( rule__KeywordGroup__KeywordsAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2222:2: rule__KeywordGroup__KeywordsAssignment_3
            {
            pushFollow(FOLLOW_rule__KeywordGroup__KeywordsAssignment_3_in_rule__KeywordGroup__Group__3__Impl4503);
            rule__KeywordGroup__KeywordsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__3__Impl"


    // $ANTLR start "rule__KeywordGroup__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2232:1: rule__KeywordGroup__Group__4 : rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5 ;
    public final void rule__KeywordGroup__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2236:1: ( rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2237:2: rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__4__Impl_in_rule__KeywordGroup__Group__44533);
            rule__KeywordGroup__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__5_in_rule__KeywordGroup__Group__44536);
            rule__KeywordGroup__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__4"


    // $ANTLR start "rule__KeywordGroup__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2244:1: rule__KeywordGroup__Group__4__Impl : ( ( rule__KeywordGroup__Group_4__0 )* ) ;
    public final void rule__KeywordGroup__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2248:1: ( ( ( rule__KeywordGroup__Group_4__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2249:1: ( ( rule__KeywordGroup__Group_4__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2249:1: ( ( rule__KeywordGroup__Group_4__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2250:1: ( rule__KeywordGroup__Group_4__0 )*
            {
             before(grammarAccess.getKeywordGroupAccess().getGroup_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2251:1: ( rule__KeywordGroup__Group_4__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==29) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2251:2: rule__KeywordGroup__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__KeywordGroup__Group_4__0_in_rule__KeywordGroup__Group__4__Impl4563);
            	    rule__KeywordGroup__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getKeywordGroupAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__4__Impl"


    // $ANTLR start "rule__KeywordGroup__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2261:1: rule__KeywordGroup__Group__5 : rule__KeywordGroup__Group__5__Impl ;
    public final void rule__KeywordGroup__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2265:1: ( rule__KeywordGroup__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2266:2: rule__KeywordGroup__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__5__Impl_in_rule__KeywordGroup__Group__54594);
            rule__KeywordGroup__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__5"


    // $ANTLR start "rule__KeywordGroup__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2272:1: rule__KeywordGroup__Group__5__Impl : ( ']' ) ;
    public final void rule__KeywordGroup__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2276:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2277:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2277:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2278:1: ']'
            {
             before(grammarAccess.getKeywordGroupAccess().getRightSquareBracketKeyword_5()); 
            match(input,28,FOLLOW_28_in_rule__KeywordGroup__Group__5__Impl4622); 
             after(grammarAccess.getKeywordGroupAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group__5__Impl"


    // $ANTLR start "rule__KeywordGroup__Group_4__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2303:1: rule__KeywordGroup__Group_4__0 : rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1 ;
    public final void rule__KeywordGroup__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2307:1: ( rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2308:2: rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__0__Impl_in_rule__KeywordGroup__Group_4__04665);
            rule__KeywordGroup__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__1_in_rule__KeywordGroup__Group_4__04668);
            rule__KeywordGroup__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group_4__0"


    // $ANTLR start "rule__KeywordGroup__Group_4__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2315:1: rule__KeywordGroup__Group_4__0__Impl : ( ',' ) ;
    public final void rule__KeywordGroup__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2319:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2320:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2320:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2321:1: ','
            {
             before(grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0()); 
            match(input,29,FOLLOW_29_in_rule__KeywordGroup__Group_4__0__Impl4696); 
             after(grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group_4__0__Impl"


    // $ANTLR start "rule__KeywordGroup__Group_4__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2334:1: rule__KeywordGroup__Group_4__1 : rule__KeywordGroup__Group_4__1__Impl ;
    public final void rule__KeywordGroup__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2338:1: ( rule__KeywordGroup__Group_4__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2339:2: rule__KeywordGroup__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__1__Impl_in_rule__KeywordGroup__Group_4__14727);
            rule__KeywordGroup__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group_4__1"


    // $ANTLR start "rule__KeywordGroup__Group_4__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2345:1: rule__KeywordGroup__Group_4__1__Impl : ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) ) ;
    public final void rule__KeywordGroup__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2349:1: ( ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2350:1: ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2350:1: ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2351:1: ( rule__KeywordGroup__KeywordsAssignment_4_1 )
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_4_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2352:1: ( rule__KeywordGroup__KeywordsAssignment_4_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2352:2: rule__KeywordGroup__KeywordsAssignment_4_1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__KeywordsAssignment_4_1_in_rule__KeywordGroup__Group_4__1__Impl4754);
            rule__KeywordGroup__KeywordsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__Group_4__1__Impl"


    // $ANTLR start "rule__Keyword__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2366:1: rule__Keyword__Group__0 : rule__Keyword__Group__0__Impl rule__Keyword__Group__1 ;
    public final void rule__Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2370:1: ( rule__Keyword__Group__0__Impl rule__Keyword__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2371:2: rule__Keyword__Group__0__Impl rule__Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__04788);
            rule__Keyword__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__04791);
            rule__Keyword__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2378:1: rule__Keyword__Group__0__Impl : ( ( rule__Keyword__NameAssignment_0 ) ) ;
    public final void rule__Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2382:1: ( ( ( rule__Keyword__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2383:1: ( ( rule__Keyword__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2383:1: ( ( rule__Keyword__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2384:1: ( rule__Keyword__NameAssignment_0 )
            {
             before(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2385:1: ( rule__Keyword__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2385:2: rule__Keyword__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl4818);
            rule__Keyword__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getKeywordAccess().getNameAssignment_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2395:1: rule__Keyword__Group__1 : rule__Keyword__Group__1__Impl ;
    public final void rule__Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2399:1: ( rule__Keyword__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2400:2: rule__Keyword__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__14848);
            rule__Keyword__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2406:1: rule__Keyword__Group__1__Impl : ( ( rule__Keyword__Group_1__0 )? ) ;
    public final void rule__Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2410:1: ( ( ( rule__Keyword__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2411:1: ( ( rule__Keyword__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2411:1: ( ( rule__Keyword__Group_1__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2412:1: ( rule__Keyword__Group_1__0 )?
            {
             before(grammarAccess.getKeywordAccess().getGroup_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2413:1: ( rule__Keyword__Group_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2413:2: rule__Keyword__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl4875);
                    rule__Keyword__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getKeywordAccess().getGroup_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2427:1: rule__Keyword__Group_1__0 : rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 ;
    public final void rule__Keyword__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2431:1: ( rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2432:2: rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__04910);
            rule__Keyword__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__04913);
            rule__Keyword__Group_1__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2439:1: rule__Keyword__Group_1__0__Impl : ( 'since' ) ;
    public final void rule__Keyword__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2443:1: ( ( 'since' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2444:1: ( 'since' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2444:1: ( 'since' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2445:1: 'since'
            {
             before(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            match(input,30,FOLLOW_30_in_rule__Keyword__Group_1__0__Impl4941); 
             after(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2458:1: rule__Keyword__Group_1__1 : rule__Keyword__Group_1__1__Impl ;
    public final void rule__Keyword__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2462:1: ( rule__Keyword__Group_1__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2463:2: rule__Keyword__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__14972);
            rule__Keyword__Group_1__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2469:1: rule__Keyword__Group_1__1__Impl : ( ( rule__Keyword__VersionAssignment_1_1 ) ) ;
    public final void rule__Keyword__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2473:1: ( ( ( rule__Keyword__VersionAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2474:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2474:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2475:1: ( rule__Keyword__VersionAssignment_1_1 )
            {
             before(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2476:1: ( rule__Keyword__VersionAssignment_1_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2476:2: rule__Keyword__VersionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl4999);
            rule__Keyword__VersionAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__ScannerSingleLineRule__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2490:1: rule__ScannerSingleLineRule__Group__0 : rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1 ;
    public final void rule__ScannerSingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2494:1: ( rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2495:2: rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__0__Impl_in_rule__ScannerSingleLineRule__Group__05033);
            rule__ScannerSingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__1_in_rule__ScannerSingleLineRule__Group__05036);
            rule__ScannerSingleLineRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__0"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2502:1: rule__ScannerSingleLineRule__Group__0__Impl : ( 'single-line' ) ;
    public final void rule__ScannerSingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2506:1: ( ( 'single-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2507:1: ( 'single-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2507:1: ( 'single-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2508:1: 'single-line'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__ScannerSingleLineRule__Group__0__Impl5064); 
             after(grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__0__Impl"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2521:1: rule__ScannerSingleLineRule__Group__1 : rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2 ;
    public final void rule__ScannerSingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2525:1: ( rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2526:2: rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__1__Impl_in_rule__ScannerSingleLineRule__Group__15095);
            rule__ScannerSingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__2_in_rule__ScannerSingleLineRule__Group__15098);
            rule__ScannerSingleLineRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__1"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2533:1: rule__ScannerSingleLineRule__Group__1__Impl : ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2537:1: ( ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2538:1: ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2538:1: ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2539:1: ( rule__ScannerSingleLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2540:1: ( rule__ScannerSingleLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2540:2: rule__ScannerSingleLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__TokenAssignment_1_in_rule__ScannerSingleLineRule__Group__1__Impl5125);
            rule__ScannerSingleLineRule__TokenAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerSingleLineRuleAccess().getTokenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__1__Impl"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2550:1: rule__ScannerSingleLineRule__Group__2 : rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3 ;
    public final void rule__ScannerSingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2554:1: ( rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2555:2: rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__2__Impl_in_rule__ScannerSingleLineRule__Group__25155);
            rule__ScannerSingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__3_in_rule__ScannerSingleLineRule__Group__25158);
            rule__ScannerSingleLineRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__2"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2562:1: rule__ScannerSingleLineRule__Group__2__Impl : ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2566:1: ( ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2567:1: ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2567:1: ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2568:1: ( rule__ScannerSingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2569:1: ( rule__ScannerSingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2569:2: rule__ScannerSingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__StartSeqAssignment_2_in_rule__ScannerSingleLineRule__Group__2__Impl5185);
            rule__ScannerSingleLineRule__StartSeqAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__2__Impl"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2579:1: rule__ScannerSingleLineRule__Group__3 : rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4 ;
    public final void rule__ScannerSingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2583:1: ( rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2584:2: rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__3__Impl_in_rule__ScannerSingleLineRule__Group__35215);
            rule__ScannerSingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__4_in_rule__ScannerSingleLineRule__Group__35218);
            rule__ScannerSingleLineRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__3"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2591:1: rule__ScannerSingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__ScannerSingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2595:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2596:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2596:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2597:1: '=>'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__ScannerSingleLineRule__Group__3__Impl5246); 
             after(grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__3__Impl"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2610:1: rule__ScannerSingleLineRule__Group__4 : rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5 ;
    public final void rule__ScannerSingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2614:1: ( rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2615:2: rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__4__Impl_in_rule__ScannerSingleLineRule__Group__45277);
            rule__ScannerSingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__5_in_rule__ScannerSingleLineRule__Group__45280);
            rule__ScannerSingleLineRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__4"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2622:1: rule__ScannerSingleLineRule__Group__4__Impl : ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2626:1: ( ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2627:1: ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2627:1: ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2628:1: ( rule__ScannerSingleLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2629:1: ( rule__ScannerSingleLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2629:2: rule__ScannerSingleLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__EndSeqAssignment_4_in_rule__ScannerSingleLineRule__Group__4__Impl5307);
            rule__ScannerSingleLineRule__EndSeqAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__4__Impl"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2639:1: rule__ScannerSingleLineRule__Group__5 : rule__ScannerSingleLineRule__Group__5__Impl ;
    public final void rule__ScannerSingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2643:1: ( rule__ScannerSingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2644:2: rule__ScannerSingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__5__Impl_in_rule__ScannerSingleLineRule__Group__55337);
            rule__ScannerSingleLineRule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__5"


    // $ANTLR start "rule__ScannerSingleLineRule__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2650:1: rule__ScannerSingleLineRule__Group__5__Impl : ( ( rule__ScannerSingleLineRule__Group_5__0 )? ) ;
    public final void rule__ScannerSingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2654:1: ( ( ( rule__ScannerSingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2655:1: ( ( rule__ScannerSingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2655:1: ( ( rule__ScannerSingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2656:1: ( rule__ScannerSingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2657:1: ( rule__ScannerSingleLineRule__Group_5__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==33) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2657:2: rule__ScannerSingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__0_in_rule__ScannerSingleLineRule__Group__5__Impl5364);
                    rule__ScannerSingleLineRule__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScannerSingleLineRuleAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group__5__Impl"


    // $ANTLR start "rule__ScannerSingleLineRule__Group_5__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2679:1: rule__ScannerSingleLineRule__Group_5__0 : rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1 ;
    public final void rule__ScannerSingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2683:1: ( rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2684:2: rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__0__Impl_in_rule__ScannerSingleLineRule__Group_5__05407);
            rule__ScannerSingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__1_in_rule__ScannerSingleLineRule__Group_5__05410);
            rule__ScannerSingleLineRule__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group_5__0"


    // $ANTLR start "rule__ScannerSingleLineRule__Group_5__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2691:1: rule__ScannerSingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__ScannerSingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2695:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2696:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2696:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2697:1: 'escaped'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,33,FOLLOW_33_in_rule__ScannerSingleLineRule__Group_5__0__Impl5438); 
             after(grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group_5__0__Impl"


    // $ANTLR start "rule__ScannerSingleLineRule__Group_5__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2710:1: rule__ScannerSingleLineRule__Group_5__1 : rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2 ;
    public final void rule__ScannerSingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2714:1: ( rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2715:2: rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__1__Impl_in_rule__ScannerSingleLineRule__Group_5__15469);
            rule__ScannerSingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__2_in_rule__ScannerSingleLineRule__Group_5__15472);
            rule__ScannerSingleLineRule__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group_5__1"


    // $ANTLR start "rule__ScannerSingleLineRule__Group_5__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2722:1: rule__ScannerSingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__ScannerSingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2726:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2727:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2727:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2728:1: 'by'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,34,FOLLOW_34_in_rule__ScannerSingleLineRule__Group_5__1__Impl5500); 
             after(grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group_5__1__Impl"


    // $ANTLR start "rule__ScannerSingleLineRule__Group_5__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2741:1: rule__ScannerSingleLineRule__Group_5__2 : rule__ScannerSingleLineRule__Group_5__2__Impl ;
    public final void rule__ScannerSingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2745:1: ( rule__ScannerSingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2746:2: rule__ScannerSingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__2__Impl_in_rule__ScannerSingleLineRule__Group_5__25531);
            rule__ScannerSingleLineRule__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group_5__2"


    // $ANTLR start "rule__ScannerSingleLineRule__Group_5__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2752:1: rule__ScannerSingleLineRule__Group_5__2__Impl : ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__ScannerSingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2756:1: ( ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2757:1: ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2757:1: ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2758:1: ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2759:1: ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2759:2: rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerSingleLineRule__Group_5__2__Impl5558);
            rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__Group_5__2__Impl"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2775:1: rule__PartitionSingleLineRule__Group__0 : rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1 ;
    public final void rule__PartitionSingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2779:1: ( rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2780:2: rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__0__Impl_in_rule__PartitionSingleLineRule__Group__05594);
            rule__PartitionSingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__1_in_rule__PartitionSingleLineRule__Group__05597);
            rule__PartitionSingleLineRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__0"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2787:1: rule__PartitionSingleLineRule__Group__0__Impl : ( 'single-line' ) ;
    public final void rule__PartitionSingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2791:1: ( ( 'single-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2792:1: ( 'single-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2792:1: ( 'single-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2793:1: 'single-line'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__PartitionSingleLineRule__Group__0__Impl5625); 
             after(grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__0__Impl"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2806:1: rule__PartitionSingleLineRule__Group__1 : rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2 ;
    public final void rule__PartitionSingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2810:1: ( rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2811:2: rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__1__Impl_in_rule__PartitionSingleLineRule__Group__15656);
            rule__PartitionSingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__2_in_rule__PartitionSingleLineRule__Group__15659);
            rule__PartitionSingleLineRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__1"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2818:1: rule__PartitionSingleLineRule__Group__1__Impl : ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2822:1: ( ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2823:1: ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2823:1: ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2824:1: ( rule__PartitionSingleLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2825:1: ( rule__PartitionSingleLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2825:2: rule__PartitionSingleLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__ParitionAssignment_1_in_rule__PartitionSingleLineRule__Group__1__Impl5686);
            rule__PartitionSingleLineRule__ParitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPartitionSingleLineRuleAccess().getParitionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__1__Impl"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2835:1: rule__PartitionSingleLineRule__Group__2 : rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3 ;
    public final void rule__PartitionSingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2839:1: ( rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2840:2: rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__2__Impl_in_rule__PartitionSingleLineRule__Group__25716);
            rule__PartitionSingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__3_in_rule__PartitionSingleLineRule__Group__25719);
            rule__PartitionSingleLineRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__2"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2847:1: rule__PartitionSingleLineRule__Group__2__Impl : ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2851:1: ( ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2852:1: ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2852:1: ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2853:1: ( rule__PartitionSingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2854:1: ( rule__PartitionSingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2854:2: rule__PartitionSingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__StartSeqAssignment_2_in_rule__PartitionSingleLineRule__Group__2__Impl5746);
            rule__PartitionSingleLineRule__StartSeqAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__2__Impl"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2864:1: rule__PartitionSingleLineRule__Group__3 : rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4 ;
    public final void rule__PartitionSingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2868:1: ( rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2869:2: rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__3__Impl_in_rule__PartitionSingleLineRule__Group__35776);
            rule__PartitionSingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__4_in_rule__PartitionSingleLineRule__Group__35779);
            rule__PartitionSingleLineRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__3"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2876:1: rule__PartitionSingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__PartitionSingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2880:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2881:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2881:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2882:1: '=>'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__PartitionSingleLineRule__Group__3__Impl5807); 
             after(grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__3__Impl"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2895:1: rule__PartitionSingleLineRule__Group__4 : rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5 ;
    public final void rule__PartitionSingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2899:1: ( rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2900:2: rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__4__Impl_in_rule__PartitionSingleLineRule__Group__45838);
            rule__PartitionSingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__5_in_rule__PartitionSingleLineRule__Group__45841);
            rule__PartitionSingleLineRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__4"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2907:1: rule__PartitionSingleLineRule__Group__4__Impl : ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2911:1: ( ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2912:1: ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2912:1: ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2913:1: ( rule__PartitionSingleLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2914:1: ( rule__PartitionSingleLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2914:2: rule__PartitionSingleLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__EndSeqAssignment_4_in_rule__PartitionSingleLineRule__Group__4__Impl5868);
            rule__PartitionSingleLineRule__EndSeqAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__4__Impl"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2924:1: rule__PartitionSingleLineRule__Group__5 : rule__PartitionSingleLineRule__Group__5__Impl ;
    public final void rule__PartitionSingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2928:1: ( rule__PartitionSingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2929:2: rule__PartitionSingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__5__Impl_in_rule__PartitionSingleLineRule__Group__55898);
            rule__PartitionSingleLineRule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__5"


    // $ANTLR start "rule__PartitionSingleLineRule__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2935:1: rule__PartitionSingleLineRule__Group__5__Impl : ( ( rule__PartitionSingleLineRule__Group_5__0 )? ) ;
    public final void rule__PartitionSingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2939:1: ( ( ( rule__PartitionSingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2940:1: ( ( rule__PartitionSingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2940:1: ( ( rule__PartitionSingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2941:1: ( rule__PartitionSingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2942:1: ( rule__PartitionSingleLineRule__Group_5__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==33) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2942:2: rule__PartitionSingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__0_in_rule__PartitionSingleLineRule__Group__5__Impl5925);
                    rule__PartitionSingleLineRule__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPartitionSingleLineRuleAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group__5__Impl"


    // $ANTLR start "rule__PartitionSingleLineRule__Group_5__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2964:1: rule__PartitionSingleLineRule__Group_5__0 : rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1 ;
    public final void rule__PartitionSingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2968:1: ( rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2969:2: rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__0__Impl_in_rule__PartitionSingleLineRule__Group_5__05968);
            rule__PartitionSingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__1_in_rule__PartitionSingleLineRule__Group_5__05971);
            rule__PartitionSingleLineRule__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group_5__0"


    // $ANTLR start "rule__PartitionSingleLineRule__Group_5__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2976:1: rule__PartitionSingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__PartitionSingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2980:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2981:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2981:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2982:1: 'escaped'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,33,FOLLOW_33_in_rule__PartitionSingleLineRule__Group_5__0__Impl5999); 
             after(grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group_5__0__Impl"


    // $ANTLR start "rule__PartitionSingleLineRule__Group_5__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2995:1: rule__PartitionSingleLineRule__Group_5__1 : rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2 ;
    public final void rule__PartitionSingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2999:1: ( rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3000:2: rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__1__Impl_in_rule__PartitionSingleLineRule__Group_5__16030);
            rule__PartitionSingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__2_in_rule__PartitionSingleLineRule__Group_5__16033);
            rule__PartitionSingleLineRule__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group_5__1"


    // $ANTLR start "rule__PartitionSingleLineRule__Group_5__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3007:1: rule__PartitionSingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__PartitionSingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3011:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3012:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3012:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3013:1: 'by'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,34,FOLLOW_34_in_rule__PartitionSingleLineRule__Group_5__1__Impl6061); 
             after(grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group_5__1__Impl"


    // $ANTLR start "rule__PartitionSingleLineRule__Group_5__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3026:1: rule__PartitionSingleLineRule__Group_5__2 : rule__PartitionSingleLineRule__Group_5__2__Impl ;
    public final void rule__PartitionSingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3030:1: ( rule__PartitionSingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3031:2: rule__PartitionSingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__2__Impl_in_rule__PartitionSingleLineRule__Group_5__26092);
            rule__PartitionSingleLineRule__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group_5__2"


    // $ANTLR start "rule__PartitionSingleLineRule__Group_5__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3037:1: rule__PartitionSingleLineRule__Group_5__2__Impl : ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__PartitionSingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3041:1: ( ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3042:1: ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3042:1: ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3043:1: ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3044:1: ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3044:2: rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionSingleLineRule__Group_5__2__Impl6119);
            rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__Group_5__2__Impl"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3060:1: rule__ScannerMultiLineRule__Group__0 : rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1 ;
    public final void rule__ScannerMultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3064:1: ( rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3065:2: rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__0__Impl_in_rule__ScannerMultiLineRule__Group__06155);
            rule__ScannerMultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__1_in_rule__ScannerMultiLineRule__Group__06158);
            rule__ScannerMultiLineRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__0"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3072:1: rule__ScannerMultiLineRule__Group__0__Impl : ( 'multi-line' ) ;
    public final void rule__ScannerMultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3076:1: ( ( 'multi-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3077:1: ( 'multi-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3077:1: ( 'multi-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3078:1: 'multi-line'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__ScannerMultiLineRule__Group__0__Impl6186); 
             after(grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__0__Impl"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3091:1: rule__ScannerMultiLineRule__Group__1 : rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2 ;
    public final void rule__ScannerMultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3095:1: ( rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3096:2: rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__1__Impl_in_rule__ScannerMultiLineRule__Group__16217);
            rule__ScannerMultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__2_in_rule__ScannerMultiLineRule__Group__16220);
            rule__ScannerMultiLineRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__1"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3103:1: rule__ScannerMultiLineRule__Group__1__Impl : ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3107:1: ( ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3108:1: ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3108:1: ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3109:1: ( rule__ScannerMultiLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3110:1: ( rule__ScannerMultiLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3110:2: rule__ScannerMultiLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__TokenAssignment_1_in_rule__ScannerMultiLineRule__Group__1__Impl6247);
            rule__ScannerMultiLineRule__TokenAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerMultiLineRuleAccess().getTokenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__1__Impl"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3120:1: rule__ScannerMultiLineRule__Group__2 : rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3 ;
    public final void rule__ScannerMultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3124:1: ( rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3125:2: rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__2__Impl_in_rule__ScannerMultiLineRule__Group__26277);
            rule__ScannerMultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__3_in_rule__ScannerMultiLineRule__Group__26280);
            rule__ScannerMultiLineRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__2"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3132:1: rule__ScannerMultiLineRule__Group__2__Impl : ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3136:1: ( ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3137:1: ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3137:1: ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3138:1: ( rule__ScannerMultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3139:1: ( rule__ScannerMultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3139:2: rule__ScannerMultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__StartSeqAssignment_2_in_rule__ScannerMultiLineRule__Group__2__Impl6307);
            rule__ScannerMultiLineRule__StartSeqAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__2__Impl"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3149:1: rule__ScannerMultiLineRule__Group__3 : rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4 ;
    public final void rule__ScannerMultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3153:1: ( rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3154:2: rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__3__Impl_in_rule__ScannerMultiLineRule__Group__36337);
            rule__ScannerMultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__4_in_rule__ScannerMultiLineRule__Group__36340);
            rule__ScannerMultiLineRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__3"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3161:1: rule__ScannerMultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__ScannerMultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3165:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3166:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3166:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3167:1: '=>'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__ScannerMultiLineRule__Group__3__Impl6368); 
             after(grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__3__Impl"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3180:1: rule__ScannerMultiLineRule__Group__4 : rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5 ;
    public final void rule__ScannerMultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3184:1: ( rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3185:2: rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__4__Impl_in_rule__ScannerMultiLineRule__Group__46399);
            rule__ScannerMultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__5_in_rule__ScannerMultiLineRule__Group__46402);
            rule__ScannerMultiLineRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__4"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3192:1: rule__ScannerMultiLineRule__Group__4__Impl : ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3196:1: ( ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3197:1: ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3197:1: ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3198:1: ( rule__ScannerMultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3199:1: ( rule__ScannerMultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3199:2: rule__ScannerMultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__EndSeqAssignment_4_in_rule__ScannerMultiLineRule__Group__4__Impl6429);
            rule__ScannerMultiLineRule__EndSeqAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__4__Impl"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3209:1: rule__ScannerMultiLineRule__Group__5 : rule__ScannerMultiLineRule__Group__5__Impl ;
    public final void rule__ScannerMultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3213:1: ( rule__ScannerMultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3214:2: rule__ScannerMultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__5__Impl_in_rule__ScannerMultiLineRule__Group__56459);
            rule__ScannerMultiLineRule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__5"


    // $ANTLR start "rule__ScannerMultiLineRule__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3220:1: rule__ScannerMultiLineRule__Group__5__Impl : ( ( rule__ScannerMultiLineRule__Group_5__0 )? ) ;
    public final void rule__ScannerMultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3224:1: ( ( ( rule__ScannerMultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3225:1: ( ( rule__ScannerMultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3225:1: ( ( rule__ScannerMultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3226:1: ( rule__ScannerMultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3227:1: ( rule__ScannerMultiLineRule__Group_5__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==33) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3227:2: rule__ScannerMultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__0_in_rule__ScannerMultiLineRule__Group__5__Impl6486);
                    rule__ScannerMultiLineRule__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScannerMultiLineRuleAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group__5__Impl"


    // $ANTLR start "rule__ScannerMultiLineRule__Group_5__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3249:1: rule__ScannerMultiLineRule__Group_5__0 : rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1 ;
    public final void rule__ScannerMultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3253:1: ( rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3254:2: rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__0__Impl_in_rule__ScannerMultiLineRule__Group_5__06529);
            rule__ScannerMultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__1_in_rule__ScannerMultiLineRule__Group_5__06532);
            rule__ScannerMultiLineRule__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group_5__0"


    // $ANTLR start "rule__ScannerMultiLineRule__Group_5__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3261:1: rule__ScannerMultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__ScannerMultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3265:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3266:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3266:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3267:1: 'escaped'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,33,FOLLOW_33_in_rule__ScannerMultiLineRule__Group_5__0__Impl6560); 
             after(grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group_5__0__Impl"


    // $ANTLR start "rule__ScannerMultiLineRule__Group_5__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3280:1: rule__ScannerMultiLineRule__Group_5__1 : rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2 ;
    public final void rule__ScannerMultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3284:1: ( rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3285:2: rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__1__Impl_in_rule__ScannerMultiLineRule__Group_5__16591);
            rule__ScannerMultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__2_in_rule__ScannerMultiLineRule__Group_5__16594);
            rule__ScannerMultiLineRule__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group_5__1"


    // $ANTLR start "rule__ScannerMultiLineRule__Group_5__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3292:1: rule__ScannerMultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__ScannerMultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3296:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3297:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3297:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3298:1: 'by'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,34,FOLLOW_34_in_rule__ScannerMultiLineRule__Group_5__1__Impl6622); 
             after(grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group_5__1__Impl"


    // $ANTLR start "rule__ScannerMultiLineRule__Group_5__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3311:1: rule__ScannerMultiLineRule__Group_5__2 : rule__ScannerMultiLineRule__Group_5__2__Impl ;
    public final void rule__ScannerMultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3315:1: ( rule__ScannerMultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3316:2: rule__ScannerMultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__2__Impl_in_rule__ScannerMultiLineRule__Group_5__26653);
            rule__ScannerMultiLineRule__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group_5__2"


    // $ANTLR start "rule__ScannerMultiLineRule__Group_5__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3322:1: rule__ScannerMultiLineRule__Group_5__2__Impl : ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__ScannerMultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3326:1: ( ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3327:1: ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3327:1: ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3328:1: ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3329:1: ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3329:2: rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerMultiLineRule__Group_5__2__Impl6680);
            rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__Group_5__2__Impl"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3345:1: rule__PartitionMultiLineRule__Group__0 : rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1 ;
    public final void rule__PartitionMultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3349:1: ( rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3350:2: rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__0__Impl_in_rule__PartitionMultiLineRule__Group__06716);
            rule__PartitionMultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__1_in_rule__PartitionMultiLineRule__Group__06719);
            rule__PartitionMultiLineRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__0"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3357:1: rule__PartitionMultiLineRule__Group__0__Impl : ( 'multi-line' ) ;
    public final void rule__PartitionMultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3361:1: ( ( 'multi-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3362:1: ( 'multi-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3362:1: ( 'multi-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3363:1: 'multi-line'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__PartitionMultiLineRule__Group__0__Impl6747); 
             after(grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__0__Impl"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3376:1: rule__PartitionMultiLineRule__Group__1 : rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2 ;
    public final void rule__PartitionMultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3380:1: ( rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3381:2: rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__1__Impl_in_rule__PartitionMultiLineRule__Group__16778);
            rule__PartitionMultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__2_in_rule__PartitionMultiLineRule__Group__16781);
            rule__PartitionMultiLineRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__1"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3388:1: rule__PartitionMultiLineRule__Group__1__Impl : ( ( rule__PartitionMultiLineRule__TokenAssignment_1 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3392:1: ( ( ( rule__PartitionMultiLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3393:1: ( ( rule__PartitionMultiLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3393:1: ( ( rule__PartitionMultiLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3394:1: ( rule__PartitionMultiLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3395:1: ( rule__PartitionMultiLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3395:2: rule__PartitionMultiLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__TokenAssignment_1_in_rule__PartitionMultiLineRule__Group__1__Impl6808);
            rule__PartitionMultiLineRule__TokenAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPartitionMultiLineRuleAccess().getTokenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__1__Impl"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3405:1: rule__PartitionMultiLineRule__Group__2 : rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3 ;
    public final void rule__PartitionMultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3409:1: ( rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3410:2: rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__2__Impl_in_rule__PartitionMultiLineRule__Group__26838);
            rule__PartitionMultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__3_in_rule__PartitionMultiLineRule__Group__26841);
            rule__PartitionMultiLineRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__2"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3417:1: rule__PartitionMultiLineRule__Group__2__Impl : ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3421:1: ( ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3422:1: ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3422:1: ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3423:1: ( rule__PartitionMultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3424:1: ( rule__PartitionMultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3424:2: rule__PartitionMultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__StartSeqAssignment_2_in_rule__PartitionMultiLineRule__Group__2__Impl6868);
            rule__PartitionMultiLineRule__StartSeqAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__2__Impl"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3434:1: rule__PartitionMultiLineRule__Group__3 : rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4 ;
    public final void rule__PartitionMultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3438:1: ( rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3439:2: rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__3__Impl_in_rule__PartitionMultiLineRule__Group__36898);
            rule__PartitionMultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__4_in_rule__PartitionMultiLineRule__Group__36901);
            rule__PartitionMultiLineRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__3"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3446:1: rule__PartitionMultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__PartitionMultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3450:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3451:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3451:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3452:1: '=>'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__PartitionMultiLineRule__Group__3__Impl6929); 
             after(grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__3__Impl"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3465:1: rule__PartitionMultiLineRule__Group__4 : rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5 ;
    public final void rule__PartitionMultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3469:1: ( rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3470:2: rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__4__Impl_in_rule__PartitionMultiLineRule__Group__46960);
            rule__PartitionMultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__5_in_rule__PartitionMultiLineRule__Group__46963);
            rule__PartitionMultiLineRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__4"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3477:1: rule__PartitionMultiLineRule__Group__4__Impl : ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3481:1: ( ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3482:1: ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3482:1: ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3483:1: ( rule__PartitionMultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3484:1: ( rule__PartitionMultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3484:2: rule__PartitionMultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__EndSeqAssignment_4_in_rule__PartitionMultiLineRule__Group__4__Impl6990);
            rule__PartitionMultiLineRule__EndSeqAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__4__Impl"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3494:1: rule__PartitionMultiLineRule__Group__5 : rule__PartitionMultiLineRule__Group__5__Impl ;
    public final void rule__PartitionMultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3498:1: ( rule__PartitionMultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3499:2: rule__PartitionMultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__5__Impl_in_rule__PartitionMultiLineRule__Group__57020);
            rule__PartitionMultiLineRule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__5"


    // $ANTLR start "rule__PartitionMultiLineRule__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3505:1: rule__PartitionMultiLineRule__Group__5__Impl : ( ( rule__PartitionMultiLineRule__Group_5__0 )? ) ;
    public final void rule__PartitionMultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3509:1: ( ( ( rule__PartitionMultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3510:1: ( ( rule__PartitionMultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3510:1: ( ( rule__PartitionMultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3511:1: ( rule__PartitionMultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3512:1: ( rule__PartitionMultiLineRule__Group_5__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3512:2: rule__PartitionMultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__0_in_rule__PartitionMultiLineRule__Group__5__Impl7047);
                    rule__PartitionMultiLineRule__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPartitionMultiLineRuleAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group__5__Impl"


    // $ANTLR start "rule__PartitionMultiLineRule__Group_5__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3534:1: rule__PartitionMultiLineRule__Group_5__0 : rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1 ;
    public final void rule__PartitionMultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3538:1: ( rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3539:2: rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__0__Impl_in_rule__PartitionMultiLineRule__Group_5__07090);
            rule__PartitionMultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__1_in_rule__PartitionMultiLineRule__Group_5__07093);
            rule__PartitionMultiLineRule__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group_5__0"


    // $ANTLR start "rule__PartitionMultiLineRule__Group_5__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3546:1: rule__PartitionMultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__PartitionMultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3550:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3551:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3551:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3552:1: 'escaped'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,33,FOLLOW_33_in_rule__PartitionMultiLineRule__Group_5__0__Impl7121); 
             after(grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group_5__0__Impl"


    // $ANTLR start "rule__PartitionMultiLineRule__Group_5__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3565:1: rule__PartitionMultiLineRule__Group_5__1 : rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2 ;
    public final void rule__PartitionMultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3569:1: ( rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3570:2: rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__1__Impl_in_rule__PartitionMultiLineRule__Group_5__17152);
            rule__PartitionMultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__2_in_rule__PartitionMultiLineRule__Group_5__17155);
            rule__PartitionMultiLineRule__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group_5__1"


    // $ANTLR start "rule__PartitionMultiLineRule__Group_5__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3577:1: rule__PartitionMultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__PartitionMultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3581:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3582:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3582:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3583:1: 'by'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,34,FOLLOW_34_in_rule__PartitionMultiLineRule__Group_5__1__Impl7183); 
             after(grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group_5__1__Impl"


    // $ANTLR start "rule__PartitionMultiLineRule__Group_5__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3596:1: rule__PartitionMultiLineRule__Group_5__2 : rule__PartitionMultiLineRule__Group_5__2__Impl ;
    public final void rule__PartitionMultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3600:1: ( rule__PartitionMultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3601:2: rule__PartitionMultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__2__Impl_in_rule__PartitionMultiLineRule__Group_5__27214);
            rule__PartitionMultiLineRule__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group_5__2"


    // $ANTLR start "rule__PartitionMultiLineRule__Group_5__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3607:1: rule__PartitionMultiLineRule__Group_5__2__Impl : ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__PartitionMultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3611:1: ( ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3612:1: ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3612:1: ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3613:1: ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3614:1: ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3614:2: rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionMultiLineRule__Group_5__2__Impl7241);
            rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__Group_5__2__Impl"


    // $ANTLR start "rule__ScannerCharacterRule__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3630:1: rule__ScannerCharacterRule__Group__0 : rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1 ;
    public final void rule__ScannerCharacterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3634:1: ( rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3635:2: rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__0__Impl_in_rule__ScannerCharacterRule__Group__07277);
            rule__ScannerCharacterRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__1_in_rule__ScannerCharacterRule__Group__07280);
            rule__ScannerCharacterRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__0"


    // $ANTLR start "rule__ScannerCharacterRule__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3642:1: rule__ScannerCharacterRule__Group__0__Impl : ( 'character-rule' ) ;
    public final void rule__ScannerCharacterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3646:1: ( ( 'character-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3647:1: ( 'character-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3647:1: ( 'character-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3648:1: 'character-rule'
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__ScannerCharacterRule__Group__0__Impl7308); 
             after(grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__0__Impl"


    // $ANTLR start "rule__ScannerCharacterRule__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3661:1: rule__ScannerCharacterRule__Group__1 : rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2 ;
    public final void rule__ScannerCharacterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3665:1: ( rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3666:2: rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__1__Impl_in_rule__ScannerCharacterRule__Group__17339);
            rule__ScannerCharacterRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__2_in_rule__ScannerCharacterRule__Group__17342);
            rule__ScannerCharacterRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__1"


    // $ANTLR start "rule__ScannerCharacterRule__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3673:1: rule__ScannerCharacterRule__Group__1__Impl : ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerCharacterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3677:1: ( ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3678:1: ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3678:1: ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3679:1: ( rule__ScannerCharacterRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3680:1: ( rule__ScannerCharacterRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3680:2: rule__ScannerCharacterRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__TokenAssignment_1_in_rule__ScannerCharacterRule__Group__1__Impl7369);
            rule__ScannerCharacterRule__TokenAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerCharacterRuleAccess().getTokenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__1__Impl"


    // $ANTLR start "rule__ScannerCharacterRule__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3690:1: rule__ScannerCharacterRule__Group__2 : rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3 ;
    public final void rule__ScannerCharacterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3694:1: ( rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3695:2: rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__2__Impl_in_rule__ScannerCharacterRule__Group__27399);
            rule__ScannerCharacterRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__3_in_rule__ScannerCharacterRule__Group__27402);
            rule__ScannerCharacterRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__2"


    // $ANTLR start "rule__ScannerCharacterRule__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3702:1: rule__ScannerCharacterRule__Group__2__Impl : ( '[' ) ;
    public final void rule__ScannerCharacterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3706:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3707:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3707:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3708:1: '['
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2()); 
            match(input,27,FOLLOW_27_in_rule__ScannerCharacterRule__Group__2__Impl7430); 
             after(grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__2__Impl"


    // $ANTLR start "rule__ScannerCharacterRule__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3721:1: rule__ScannerCharacterRule__Group__3 : rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4 ;
    public final void rule__ScannerCharacterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3725:1: ( rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3726:2: rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__3__Impl_in_rule__ScannerCharacterRule__Group__37461);
            rule__ScannerCharacterRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__4_in_rule__ScannerCharacterRule__Group__37464);
            rule__ScannerCharacterRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__3"


    // $ANTLR start "rule__ScannerCharacterRule__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3733:1: rule__ScannerCharacterRule__Group__3__Impl : ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) ) ;
    public final void rule__ScannerCharacterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3737:1: ( ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3738:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3738:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3739:1: ( rule__ScannerCharacterRule__CharactersAssignment_3 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3740:1: ( rule__ScannerCharacterRule__CharactersAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3740:2: rule__ScannerCharacterRule__CharactersAssignment_3
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_3_in_rule__ScannerCharacterRule__Group__3__Impl7491);
            rule__ScannerCharacterRule__CharactersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__3__Impl"


    // $ANTLR start "rule__ScannerCharacterRule__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3750:1: rule__ScannerCharacterRule__Group__4 : rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5 ;
    public final void rule__ScannerCharacterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3754:1: ( rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3755:2: rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__4__Impl_in_rule__ScannerCharacterRule__Group__47521);
            rule__ScannerCharacterRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__5_in_rule__ScannerCharacterRule__Group__47524);
            rule__ScannerCharacterRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__4"


    // $ANTLR start "rule__ScannerCharacterRule__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3762:1: rule__ScannerCharacterRule__Group__4__Impl : ( ',' ) ;
    public final void rule__ScannerCharacterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3766:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3767:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3767:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3768:1: ','
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__ScannerCharacterRule__Group__4__Impl7552); 
             after(grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__4__Impl"


    // $ANTLR start "rule__ScannerCharacterRule__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3781:1: rule__ScannerCharacterRule__Group__5 : rule__ScannerCharacterRule__Group__5__Impl rule__ScannerCharacterRule__Group__6 ;
    public final void rule__ScannerCharacterRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3785:1: ( rule__ScannerCharacterRule__Group__5__Impl rule__ScannerCharacterRule__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3786:2: rule__ScannerCharacterRule__Group__5__Impl rule__ScannerCharacterRule__Group__6
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__5__Impl_in_rule__ScannerCharacterRule__Group__57583);
            rule__ScannerCharacterRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__6_in_rule__ScannerCharacterRule__Group__57586);
            rule__ScannerCharacterRule__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__5"


    // $ANTLR start "rule__ScannerCharacterRule__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3793:1: rule__ScannerCharacterRule__Group__5__Impl : ( ( rule__ScannerCharacterRule__CharactersAssignment_5 ) ) ;
    public final void rule__ScannerCharacterRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3797:1: ( ( ( rule__ScannerCharacterRule__CharactersAssignment_5 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3798:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_5 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3798:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_5 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3799:1: ( rule__ScannerCharacterRule__CharactersAssignment_5 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3800:1: ( rule__ScannerCharacterRule__CharactersAssignment_5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3800:2: rule__ScannerCharacterRule__CharactersAssignment_5
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_5_in_rule__ScannerCharacterRule__Group__5__Impl7613);
            rule__ScannerCharacterRule__CharactersAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__5__Impl"


    // $ANTLR start "rule__ScannerCharacterRule__Group__6"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3810:1: rule__ScannerCharacterRule__Group__6 : rule__ScannerCharacterRule__Group__6__Impl ;
    public final void rule__ScannerCharacterRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3814:1: ( rule__ScannerCharacterRule__Group__6__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3815:2: rule__ScannerCharacterRule__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__6__Impl_in_rule__ScannerCharacterRule__Group__67643);
            rule__ScannerCharacterRule__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__6"


    // $ANTLR start "rule__ScannerCharacterRule__Group__6__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3821:1: rule__ScannerCharacterRule__Group__6__Impl : ( ']' ) ;
    public final void rule__ScannerCharacterRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3825:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3826:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3826:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3827:1: ']'
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getRightSquareBracketKeyword_6()); 
            match(input,28,FOLLOW_28_in_rule__ScannerCharacterRule__Group__6__Impl7671); 
             after(grammarAccess.getScannerCharacterRuleAccess().getRightSquareBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group__6__Impl"


    // $ANTLR start "rule__ScannerJSRule__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3854:1: rule__ScannerJSRule__Group__0 : rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1 ;
    public final void rule__ScannerJSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3858:1: ( rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3859:2: rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__0__Impl_in_rule__ScannerJSRule__Group__07716);
            rule__ScannerJSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerJSRule__Group__1_in_rule__ScannerJSRule__Group__07719);
            rule__ScannerJSRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerJSRule__Group__0"


    // $ANTLR start "rule__ScannerJSRule__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3866:1: rule__ScannerJSRule__Group__0__Impl : ( 'javascript-rule' ) ;
    public final void rule__ScannerJSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3870:1: ( ( 'javascript-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3871:1: ( 'javascript-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3871:1: ( 'javascript-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3872:1: 'javascript-rule'
            {
             before(grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__ScannerJSRule__Group__0__Impl7747); 
             after(grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerJSRule__Group__0__Impl"


    // $ANTLR start "rule__ScannerJSRule__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3885:1: rule__ScannerJSRule__Group__1 : rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2 ;
    public final void rule__ScannerJSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3889:1: ( rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3890:2: rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__1__Impl_in_rule__ScannerJSRule__Group__17778);
            rule__ScannerJSRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerJSRule__Group__2_in_rule__ScannerJSRule__Group__17781);
            rule__ScannerJSRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerJSRule__Group__1"


    // $ANTLR start "rule__ScannerJSRule__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3897:1: rule__ScannerJSRule__Group__1__Impl : ( ( rule__ScannerJSRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerJSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3901:1: ( ( ( rule__ScannerJSRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3902:1: ( ( rule__ScannerJSRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3902:1: ( ( rule__ScannerJSRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3903:1: ( rule__ScannerJSRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3904:1: ( rule__ScannerJSRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3904:2: rule__ScannerJSRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__TokenAssignment_1_in_rule__ScannerJSRule__Group__1__Impl7808);
            rule__ScannerJSRule__TokenAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerJSRuleAccess().getTokenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerJSRule__Group__1__Impl"


    // $ANTLR start "rule__ScannerJSRule__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3914:1: rule__ScannerJSRule__Group__2 : rule__ScannerJSRule__Group__2__Impl ;
    public final void rule__ScannerJSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3918:1: ( rule__ScannerJSRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3919:2: rule__ScannerJSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__2__Impl_in_rule__ScannerJSRule__Group__27838);
            rule__ScannerJSRule__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerJSRule__Group__2"


    // $ANTLR start "rule__ScannerJSRule__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3925:1: rule__ScannerJSRule__Group__2__Impl : ( ( rule__ScannerJSRule__FileURIAssignment_2 ) ) ;
    public final void rule__ScannerJSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3929:1: ( ( ( rule__ScannerJSRule__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3930:1: ( ( rule__ScannerJSRule__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3930:1: ( ( rule__ScannerJSRule__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3931:1: ( rule__ScannerJSRule__FileURIAssignment_2 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3932:1: ( rule__ScannerJSRule__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3932:2: rule__ScannerJSRule__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__FileURIAssignment_2_in_rule__ScannerJSRule__Group__2__Impl7865);
            rule__ScannerJSRule__FileURIAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getScannerJSRuleAccess().getFileURIAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerJSRule__Group__2__Impl"


    // $ANTLR start "rule__PartitionJSRule__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3948:1: rule__PartitionJSRule__Group__0 : rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1 ;
    public final void rule__PartitionJSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3952:1: ( rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3953:2: rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__0__Impl_in_rule__PartitionJSRule__Group__07901);
            rule__PartitionJSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionJSRule__Group__1_in_rule__PartitionJSRule__Group__07904);
            rule__PartitionJSRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionJSRule__Group__0"


    // $ANTLR start "rule__PartitionJSRule__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3960:1: rule__PartitionJSRule__Group__0__Impl : ( 'javascript-rule' ) ;
    public final void rule__PartitionJSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3964:1: ( ( 'javascript-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3965:1: ( 'javascript-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3965:1: ( 'javascript-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3966:1: 'javascript-rule'
            {
             before(grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__PartitionJSRule__Group__0__Impl7932); 
             after(grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionJSRule__Group__0__Impl"


    // $ANTLR start "rule__PartitionJSRule__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3979:1: rule__PartitionJSRule__Group__1 : rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2 ;
    public final void rule__PartitionJSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3983:1: ( rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3984:2: rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__1__Impl_in_rule__PartitionJSRule__Group__17963);
            rule__PartitionJSRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionJSRule__Group__2_in_rule__PartitionJSRule__Group__17966);
            rule__PartitionJSRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionJSRule__Group__1"


    // $ANTLR start "rule__PartitionJSRule__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3991:1: rule__PartitionJSRule__Group__1__Impl : ( ( rule__PartitionJSRule__TokenAssignment_1 ) ) ;
    public final void rule__PartitionJSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3995:1: ( ( ( rule__PartitionJSRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3996:1: ( ( rule__PartitionJSRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3996:1: ( ( rule__PartitionJSRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3997:1: ( rule__PartitionJSRule__TokenAssignment_1 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3998:1: ( rule__PartitionJSRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3998:2: rule__PartitionJSRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__TokenAssignment_1_in_rule__PartitionJSRule__Group__1__Impl7993);
            rule__PartitionJSRule__TokenAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPartitionJSRuleAccess().getTokenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionJSRule__Group__1__Impl"


    // $ANTLR start "rule__PartitionJSRule__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4008:1: rule__PartitionJSRule__Group__2 : rule__PartitionJSRule__Group__2__Impl ;
    public final void rule__PartitionJSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4012:1: ( rule__PartitionJSRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4013:2: rule__PartitionJSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__2__Impl_in_rule__PartitionJSRule__Group__28023);
            rule__PartitionJSRule__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionJSRule__Group__2"


    // $ANTLR start "rule__PartitionJSRule__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4019:1: rule__PartitionJSRule__Group__2__Impl : ( ( rule__PartitionJSRule__FileURIAssignment_2 ) ) ;
    public final void rule__PartitionJSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4023:1: ( ( ( rule__PartitionJSRule__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4024:1: ( ( rule__PartitionJSRule__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4024:1: ( ( rule__PartitionJSRule__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4025:1: ( rule__PartitionJSRule__FileURIAssignment_2 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4026:1: ( rule__PartitionJSRule__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4026:2: rule__PartitionJSRule__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__FileURIAssignment_2_in_rule__PartitionJSRule__Group__2__Impl8050);
            rule__PartitionJSRule__FileURIAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPartitionJSRuleAccess().getFileURIAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionJSRule__Group__2__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4042:1: rule__ScannerWhitespaceRule__Group_0__0 : rule__ScannerWhitespaceRule__Group_0__0__Impl rule__ScannerWhitespaceRule__Group_0__1 ;
    public final void rule__ScannerWhitespaceRule__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4046:1: ( rule__ScannerWhitespaceRule__Group_0__0__Impl rule__ScannerWhitespaceRule__Group_0__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4047:2: rule__ScannerWhitespaceRule__Group_0__0__Impl rule__ScannerWhitespaceRule__Group_0__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__0__Impl_in_rule__ScannerWhitespaceRule__Group_0__08086);
            rule__ScannerWhitespaceRule__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__1_in_rule__ScannerWhitespaceRule__Group_0__08089);
            rule__ScannerWhitespaceRule__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0__0"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4054:1: rule__ScannerWhitespaceRule__Group_0__0__Impl : ( 'whitespace-rule' ) ;
    public final void rule__ScannerWhitespaceRule__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4058:1: ( ( 'whitespace-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4059:1: ( 'whitespace-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4059:1: ( 'whitespace-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4060:1: 'whitespace-rule'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0_0()); 
            match(input,38,FOLLOW_38_in_rule__ScannerWhitespaceRule__Group_0__0__Impl8117); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0__0__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4073:1: rule__ScannerWhitespaceRule__Group_0__1 : rule__ScannerWhitespaceRule__Group_0__1__Impl rule__ScannerWhitespaceRule__Group_0__2 ;
    public final void rule__ScannerWhitespaceRule__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4077:1: ( rule__ScannerWhitespaceRule__Group_0__1__Impl rule__ScannerWhitespaceRule__Group_0__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4078:2: rule__ScannerWhitespaceRule__Group_0__1__Impl rule__ScannerWhitespaceRule__Group_0__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__1__Impl_in_rule__ScannerWhitespaceRule__Group_0__18148);
            rule__ScannerWhitespaceRule__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__2_in_rule__ScannerWhitespaceRule__Group_0__18151);
            rule__ScannerWhitespaceRule__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0__1"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4085:1: rule__ScannerWhitespaceRule__Group_0__1__Impl : ( ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )? ) ;
    public final void rule__ScannerWhitespaceRule__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4089:1: ( ( ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4090:1: ( ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4090:1: ( ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4091:1: ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )?
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenAssignment_0_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4092:1: ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4092:2: rule__ScannerWhitespaceRule__TokenAssignment_0_1
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__TokenAssignment_0_1_in_rule__ScannerWhitespaceRule__Group_0__1__Impl8178);
                    rule__ScannerWhitespaceRule__TokenAssignment_0_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getTokenAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0__1__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4102:1: rule__ScannerWhitespaceRule__Group_0__2 : rule__ScannerWhitespaceRule__Group_0__2__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4106:1: ( rule__ScannerWhitespaceRule__Group_0__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4107:2: rule__ScannerWhitespaceRule__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__2__Impl_in_rule__ScannerWhitespaceRule__Group_0__28209);
            rule__ScannerWhitespaceRule__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0__2"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4113:1: rule__ScannerWhitespaceRule__Group_0__2__Impl : ( ( rule__ScannerWhitespaceRule__Group_0_2__0 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4117:1: ( ( ( rule__ScannerWhitespaceRule__Group_0_2__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4118:1: ( ( rule__ScannerWhitespaceRule__Group_0_2__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4118:1: ( ( rule__ScannerWhitespaceRule__Group_0_2__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4119:1: ( rule__ScannerWhitespaceRule__Group_0_2__0 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_0_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4120:1: ( rule__ScannerWhitespaceRule__Group_0_2__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4120:2: rule__ScannerWhitespaceRule__Group_0_2__0
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__0_in_rule__ScannerWhitespaceRule__Group_0__2__Impl8236);
            rule__ScannerWhitespaceRule__Group_0_2__0();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0__2__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4136:1: rule__ScannerWhitespaceRule__Group_0_2__0 : rule__ScannerWhitespaceRule__Group_0_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2__1 ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4140:1: ( rule__ScannerWhitespaceRule__Group_0_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4141:2: rule__ScannerWhitespaceRule__Group_0_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__08272);
            rule__ScannerWhitespaceRule__Group_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__1_in_rule__ScannerWhitespaceRule__Group_0_2__08275);
            rule__ScannerWhitespaceRule__Group_0_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2__0"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4148:1: rule__ScannerWhitespaceRule__Group_0_2__0__Impl : ( '[' ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4152:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4153:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4153:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4154:1: '['
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_0_2_0()); 
            match(input,27,FOLLOW_27_in_rule__ScannerWhitespaceRule__Group_0_2__0__Impl8303); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2__0__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4167:1: rule__ScannerWhitespaceRule__Group_0_2__1 : rule__ScannerWhitespaceRule__Group_0_2__1__Impl rule__ScannerWhitespaceRule__Group_0_2__2 ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4171:1: ( rule__ScannerWhitespaceRule__Group_0_2__1__Impl rule__ScannerWhitespaceRule__Group_0_2__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4172:2: rule__ScannerWhitespaceRule__Group_0_2__1__Impl rule__ScannerWhitespaceRule__Group_0_2__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__18334);
            rule__ScannerWhitespaceRule__Group_0_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__2_in_rule__ScannerWhitespaceRule__Group_0_2__18337);
            rule__ScannerWhitespaceRule__Group_0_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2__1"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4179:1: rule__ScannerWhitespaceRule__Group_0_2__1__Impl : ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4183:1: ( ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4184:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4184:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4185:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_0_2_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4186:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4186:2: rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1_in_rule__ScannerWhitespaceRule__Group_0_2__1__Impl8364);
            rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2__1__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4196:1: rule__ScannerWhitespaceRule__Group_0_2__2 : rule__ScannerWhitespaceRule__Group_0_2__2__Impl rule__ScannerWhitespaceRule__Group_0_2__3 ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4200:1: ( rule__ScannerWhitespaceRule__Group_0_2__2__Impl rule__ScannerWhitespaceRule__Group_0_2__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4201:2: rule__ScannerWhitespaceRule__Group_0_2__2__Impl rule__ScannerWhitespaceRule__Group_0_2__3
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__2__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__28394);
            rule__ScannerWhitespaceRule__Group_0_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__3_in_rule__ScannerWhitespaceRule__Group_0_2__28397);
            rule__ScannerWhitespaceRule__Group_0_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2__2"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4208:1: rule__ScannerWhitespaceRule__Group_0_2__2__Impl : ( ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )* ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4212:1: ( ( ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4213:1: ( ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4213:1: ( ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4214:1: ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )*
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_0_2_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4215:1: ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==29) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4215:2: rule__ScannerWhitespaceRule__Group_0_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__0_in_rule__ScannerWhitespaceRule__Group_0_2__2__Impl8424);
            	    rule__ScannerWhitespaceRule__Group_0_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_0_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2__2__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4225:1: rule__ScannerWhitespaceRule__Group_0_2__3 : rule__ScannerWhitespaceRule__Group_0_2__3__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4229:1: ( rule__ScannerWhitespaceRule__Group_0_2__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4230:2: rule__ScannerWhitespaceRule__Group_0_2__3__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__3__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__38455);
            rule__ScannerWhitespaceRule__Group_0_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2__3"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4236:1: rule__ScannerWhitespaceRule__Group_0_2__3__Impl : ( ']' ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4240:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4241:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4241:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4242:1: ']'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_0_2_3()); 
            match(input,28,FOLLOW_28_in_rule__ScannerWhitespaceRule__Group_0_2__3__Impl8483); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_0_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2__3__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2_2__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4263:1: rule__ScannerWhitespaceRule__Group_0_2_2__0 : rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2_2__1 ;
    public final void rule__ScannerWhitespaceRule__Group_0_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4267:1: ( rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2_2__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4268:2: rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2_2__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_0_2_2__08522);
            rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__1_in_rule__ScannerWhitespaceRule__Group_0_2_2__08525);
            rule__ScannerWhitespaceRule__Group_0_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2_2__0"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4275:1: rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl : ( ',' ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4279:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4280:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4280:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4281:1: ','
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_0_2_2_0()); 
            match(input,29,FOLLOW_29_in_rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl8553); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_0_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2_2__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4294:1: rule__ScannerWhitespaceRule__Group_0_2_2__1 : rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_0_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4298:1: ( rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4299:2: rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_0_2_2__18584);
            rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2_2__1"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4305:1: rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl : ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4309:1: ( ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4310:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4310:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4311:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_0_2_2_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4312:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4312:2: rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1_in_rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl8611);
            rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_0_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_1__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4326:1: rule__ScannerWhitespaceRule__Group_1__0 : rule__ScannerWhitespaceRule__Group_1__0__Impl rule__ScannerWhitespaceRule__Group_1__1 ;
    public final void rule__ScannerWhitespaceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4330:1: ( rule__ScannerWhitespaceRule__Group_1__0__Impl rule__ScannerWhitespaceRule__Group_1__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4331:2: rule__ScannerWhitespaceRule__Group_1__0__Impl rule__ScannerWhitespaceRule__Group_1__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__0__Impl_in_rule__ScannerWhitespaceRule__Group_1__08645);
            rule__ScannerWhitespaceRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__1_in_rule__ScannerWhitespaceRule__Group_1__08648);
            rule__ScannerWhitespaceRule__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_1__0"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_1__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4338:1: rule__ScannerWhitespaceRule__Group_1__0__Impl : ( '#{' ) ;
    public final void rule__ScannerWhitespaceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4342:1: ( ( '#{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4343:1: ( '#{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4343:1: ( '#{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4344:1: '#{'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getNumberSignLeftCurlyBracketKeyword_1_0()); 
            match(input,39,FOLLOW_39_in_rule__ScannerWhitespaceRule__Group_1__0__Impl8676); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getNumberSignLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_1__0__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_1__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4357:1: rule__ScannerWhitespaceRule__Group_1__1 : rule__ScannerWhitespaceRule__Group_1__1__Impl rule__ScannerWhitespaceRule__Group_1__2 ;
    public final void rule__ScannerWhitespaceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4361:1: ( rule__ScannerWhitespaceRule__Group_1__1__Impl rule__ScannerWhitespaceRule__Group_1__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4362:2: rule__ScannerWhitespaceRule__Group_1__1__Impl rule__ScannerWhitespaceRule__Group_1__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__1__Impl_in_rule__ScannerWhitespaceRule__Group_1__18707);
            rule__ScannerWhitespaceRule__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__2_in_rule__ScannerWhitespaceRule__Group_1__18710);
            rule__ScannerWhitespaceRule__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_1__1"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_1__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4369:1: rule__ScannerWhitespaceRule__Group_1__1__Impl : ( ( rule__ScannerWhitespaceRule__JsMethodAssignment_1_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4373:1: ( ( ( rule__ScannerWhitespaceRule__JsMethodAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4374:1: ( ( rule__ScannerWhitespaceRule__JsMethodAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4374:1: ( ( rule__ScannerWhitespaceRule__JsMethodAssignment_1_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4375:1: ( rule__ScannerWhitespaceRule__JsMethodAssignment_1_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getJsMethodAssignment_1_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4376:1: ( rule__ScannerWhitespaceRule__JsMethodAssignment_1_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4376:2: rule__ScannerWhitespaceRule__JsMethodAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__JsMethodAssignment_1_1_in_rule__ScannerWhitespaceRule__Group_1__1__Impl8737);
            rule__ScannerWhitespaceRule__JsMethodAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getJsMethodAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_1__1__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_1__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4386:1: rule__ScannerWhitespaceRule__Group_1__2 : rule__ScannerWhitespaceRule__Group_1__2__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4390:1: ( rule__ScannerWhitespaceRule__Group_1__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4391:2: rule__ScannerWhitespaceRule__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__2__Impl_in_rule__ScannerWhitespaceRule__Group_1__28767);
            rule__ScannerWhitespaceRule__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_1__2"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_1__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4397:1: rule__ScannerWhitespaceRule__Group_1__2__Impl : ( '}#' ) ;
    public final void rule__ScannerWhitespaceRule__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4401:1: ( ( '}#' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4402:1: ( '}#' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4402:1: ( '}#' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4403:1: '}#'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getRightCurlyBracketNumberSignKeyword_1_2()); 
            match(input,40,FOLLOW_40_in_rule__ScannerWhitespaceRule__Group_1__2__Impl8795); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getRightCurlyBracketNumberSignKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_1__2__Impl"


    // $ANTLR start "rule__RGBColor__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4422:1: rule__RGBColor__Group__0 : rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1 ;
    public final void rule__RGBColor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4426:1: ( rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4427:2: rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__0__Impl_in_rule__RGBColor__Group__08832);
            rule__RGBColor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__1_in_rule__RGBColor__Group__08835);
            rule__RGBColor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__0"


    // $ANTLR start "rule__RGBColor__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4434:1: rule__RGBColor__Group__0__Impl : ( 'rgb' ) ;
    public final void rule__RGBColor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4438:1: ( ( 'rgb' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4439:1: ( 'rgb' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4439:1: ( 'rgb' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4440:1: 'rgb'
            {
             before(grammarAccess.getRGBColorAccess().getRgbKeyword_0()); 
            match(input,41,FOLLOW_41_in_rule__RGBColor__Group__0__Impl8863); 
             after(grammarAccess.getRGBColorAccess().getRgbKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__0__Impl"


    // $ANTLR start "rule__RGBColor__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4453:1: rule__RGBColor__Group__1 : rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2 ;
    public final void rule__RGBColor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4457:1: ( rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4458:2: rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__1__Impl_in_rule__RGBColor__Group__18894);
            rule__RGBColor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__2_in_rule__RGBColor__Group__18897);
            rule__RGBColor__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__1"


    // $ANTLR start "rule__RGBColor__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4465:1: rule__RGBColor__Group__1__Impl : ( '(' ) ;
    public final void rule__RGBColor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4469:1: ( ( '(' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4470:1: ( '(' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4470:1: ( '(' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4471:1: '('
            {
             before(grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1()); 
            match(input,42,FOLLOW_42_in_rule__RGBColor__Group__1__Impl8925); 
             after(grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__1__Impl"


    // $ANTLR start "rule__RGBColor__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4484:1: rule__RGBColor__Group__2 : rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3 ;
    public final void rule__RGBColor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4488:1: ( rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4489:2: rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__2__Impl_in_rule__RGBColor__Group__28956);
            rule__RGBColor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__3_in_rule__RGBColor__Group__28959);
            rule__RGBColor__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__2"


    // $ANTLR start "rule__RGBColor__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4496:1: rule__RGBColor__Group__2__Impl : ( ( rule__RGBColor__RAssignment_2 ) ) ;
    public final void rule__RGBColor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4500:1: ( ( ( rule__RGBColor__RAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4501:1: ( ( rule__RGBColor__RAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4501:1: ( ( rule__RGBColor__RAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4502:1: ( rule__RGBColor__RAssignment_2 )
            {
             before(grammarAccess.getRGBColorAccess().getRAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4503:1: ( rule__RGBColor__RAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4503:2: rule__RGBColor__RAssignment_2
            {
            pushFollow(FOLLOW_rule__RGBColor__RAssignment_2_in_rule__RGBColor__Group__2__Impl8986);
            rule__RGBColor__RAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getRAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__2__Impl"


    // $ANTLR start "rule__RGBColor__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4513:1: rule__RGBColor__Group__3 : rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4 ;
    public final void rule__RGBColor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4517:1: ( rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4518:2: rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__3__Impl_in_rule__RGBColor__Group__39016);
            rule__RGBColor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__4_in_rule__RGBColor__Group__39019);
            rule__RGBColor__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__3"


    // $ANTLR start "rule__RGBColor__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4525:1: rule__RGBColor__Group__3__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4529:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4530:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4530:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4531:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_29_in_rule__RGBColor__Group__3__Impl9047); 
             after(grammarAccess.getRGBColorAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__3__Impl"


    // $ANTLR start "rule__RGBColor__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4544:1: rule__RGBColor__Group__4 : rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5 ;
    public final void rule__RGBColor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4548:1: ( rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4549:2: rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__4__Impl_in_rule__RGBColor__Group__49078);
            rule__RGBColor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__5_in_rule__RGBColor__Group__49081);
            rule__RGBColor__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__4"


    // $ANTLR start "rule__RGBColor__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4556:1: rule__RGBColor__Group__4__Impl : ( ( rule__RGBColor__GAssignment_4 ) ) ;
    public final void rule__RGBColor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4560:1: ( ( ( rule__RGBColor__GAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4561:1: ( ( rule__RGBColor__GAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4561:1: ( ( rule__RGBColor__GAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4562:1: ( rule__RGBColor__GAssignment_4 )
            {
             before(grammarAccess.getRGBColorAccess().getGAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4563:1: ( rule__RGBColor__GAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4563:2: rule__RGBColor__GAssignment_4
            {
            pushFollow(FOLLOW_rule__RGBColor__GAssignment_4_in_rule__RGBColor__Group__4__Impl9108);
            rule__RGBColor__GAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getGAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__4__Impl"


    // $ANTLR start "rule__RGBColor__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4573:1: rule__RGBColor__Group__5 : rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6 ;
    public final void rule__RGBColor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4577:1: ( rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4578:2: rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__5__Impl_in_rule__RGBColor__Group__59138);
            rule__RGBColor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__6_in_rule__RGBColor__Group__59141);
            rule__RGBColor__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__5"


    // $ANTLR start "rule__RGBColor__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4585:1: rule__RGBColor__Group__5__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4589:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4590:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4590:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4591:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_5()); 
            match(input,29,FOLLOW_29_in_rule__RGBColor__Group__5__Impl9169); 
             after(grammarAccess.getRGBColorAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__5__Impl"


    // $ANTLR start "rule__RGBColor__Group__6"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4604:1: rule__RGBColor__Group__6 : rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7 ;
    public final void rule__RGBColor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4608:1: ( rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4609:2: rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__6__Impl_in_rule__RGBColor__Group__69200);
            rule__RGBColor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__7_in_rule__RGBColor__Group__69203);
            rule__RGBColor__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__6"


    // $ANTLR start "rule__RGBColor__Group__6__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4616:1: rule__RGBColor__Group__6__Impl : ( ( rule__RGBColor__BAssignment_6 ) ) ;
    public final void rule__RGBColor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4620:1: ( ( ( rule__RGBColor__BAssignment_6 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4621:1: ( ( rule__RGBColor__BAssignment_6 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4621:1: ( ( rule__RGBColor__BAssignment_6 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4622:1: ( rule__RGBColor__BAssignment_6 )
            {
             before(grammarAccess.getRGBColorAccess().getBAssignment_6()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4623:1: ( rule__RGBColor__BAssignment_6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4623:2: rule__RGBColor__BAssignment_6
            {
            pushFollow(FOLLOW_rule__RGBColor__BAssignment_6_in_rule__RGBColor__Group__6__Impl9230);
            rule__RGBColor__BAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getBAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__6__Impl"


    // $ANTLR start "rule__RGBColor__Group__7"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4633:1: rule__RGBColor__Group__7 : rule__RGBColor__Group__7__Impl ;
    public final void rule__RGBColor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4637:1: ( rule__RGBColor__Group__7__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4638:2: rule__RGBColor__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__7__Impl_in_rule__RGBColor__Group__79260);
            rule__RGBColor__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__7"


    // $ANTLR start "rule__RGBColor__Group__7__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4644:1: rule__RGBColor__Group__7__Impl : ( ')' ) ;
    public final void rule__RGBColor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4648:1: ( ( ')' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4649:1: ( ')' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4649:1: ( ')' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4650:1: ')'
            {
             before(grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_7()); 
            match(input,43,FOLLOW_43_in_rule__RGBColor__Group__7__Impl9288); 
             after(grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group__7__Impl"


    // $ANTLR start "rule__Font__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4679:1: rule__Font__Group__0 : rule__Font__Group__0__Impl rule__Font__Group__1 ;
    public final void rule__Font__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4683:1: ( rule__Font__Group__0__Impl rule__Font__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4684:2: rule__Font__Group__0__Impl rule__Font__Group__1
            {
            pushFollow(FOLLOW_rule__Font__Group__0__Impl_in_rule__Font__Group__09335);
            rule__Font__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Font__Group__1_in_rule__Font__Group__09338);
            rule__Font__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Font__Group__0"


    // $ANTLR start "rule__Font__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4691:1: rule__Font__Group__0__Impl : ( ( rule__Font__NameAssignment_0 ) ) ;
    public final void rule__Font__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4695:1: ( ( ( rule__Font__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4696:1: ( ( rule__Font__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4696:1: ( ( rule__Font__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4697:1: ( rule__Font__NameAssignment_0 )
            {
             before(grammarAccess.getFontAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4698:1: ( rule__Font__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4698:2: rule__Font__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Font__NameAssignment_0_in_rule__Font__Group__0__Impl9365);
            rule__Font__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFontAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Font__Group__0__Impl"


    // $ANTLR start "rule__Font__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4708:1: rule__Font__Group__1 : rule__Font__Group__1__Impl rule__Font__Group__2 ;
    public final void rule__Font__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4712:1: ( rule__Font__Group__1__Impl rule__Font__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4713:2: rule__Font__Group__1__Impl rule__Font__Group__2
            {
            pushFollow(FOLLOW_rule__Font__Group__1__Impl_in_rule__Font__Group__19395);
            rule__Font__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Font__Group__2_in_rule__Font__Group__19398);
            rule__Font__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Font__Group__1"


    // $ANTLR start "rule__Font__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4720:1: rule__Font__Group__1__Impl : ( ( rule__Font__SizeAssignment_1 ) ) ;
    public final void rule__Font__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4724:1: ( ( ( rule__Font__SizeAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4725:1: ( ( rule__Font__SizeAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4725:1: ( ( rule__Font__SizeAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4726:1: ( rule__Font__SizeAssignment_1 )
            {
             before(grammarAccess.getFontAccess().getSizeAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4727:1: ( rule__Font__SizeAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4727:2: rule__Font__SizeAssignment_1
            {
            pushFollow(FOLLOW_rule__Font__SizeAssignment_1_in_rule__Font__Group__1__Impl9425);
            rule__Font__SizeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFontAccess().getSizeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Font__Group__1__Impl"


    // $ANTLR start "rule__Font__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4737:1: rule__Font__Group__2 : rule__Font__Group__2__Impl ;
    public final void rule__Font__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4741:1: ( rule__Font__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4742:2: rule__Font__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Font__Group__2__Impl_in_rule__Font__Group__29455);
            rule__Font__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Font__Group__2"


    // $ANTLR start "rule__Font__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4748:1: rule__Font__Group__2__Impl : ( ( rule__Font__AttributesAssignment_2 )* ) ;
    public final void rule__Font__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4752:1: ( ( ( rule__Font__AttributesAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4753:1: ( ( rule__Font__AttributesAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4753:1: ( ( rule__Font__AttributesAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4754:1: ( rule__Font__AttributesAssignment_2 )*
            {
             before(grammarAccess.getFontAccess().getAttributesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4755:1: ( rule__Font__AttributesAssignment_2 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=11 && LA25_0<=14)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4755:2: rule__Font__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Font__AttributesAssignment_2_in_rule__Font__Group__2__Impl9482);
            	    rule__Font__AttributesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getFontAccess().getAttributesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Font__Group__2__Impl"


    // $ANTLR start "rule__Model__NameAssignment_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4772:1: rule__Model__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4776:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4777:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4777:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4778:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Model__NameAssignment_09524); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_0"


    // $ANTLR start "rule__Model__PartitionsAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4787:1: rule__Model__PartitionsAssignment_2 : ( rulePartition ) ;
    public final void rule__Model__PartitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4791:1: ( ( rulePartition ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4792:1: ( rulePartition )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4792:1: ( rulePartition )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4793:1: rulePartition
            {
             before(grammarAccess.getModelAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_rulePartition_in_rule__Model__PartitionsAssignment_29555);
            rulePartition();

            state._fsp--;

             after(grammarAccess.getModelAccess().getPartitionsPartitionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PartitionsAssignment_2"


    // $ANTLR start "rule__Model__ScannerAssignment_3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4802:1: rule__Model__ScannerAssignment_3 : ( ruleScanner ) ;
    public final void rule__Model__ScannerAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4806:1: ( ( ruleScanner ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4807:1: ( ruleScanner )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4807:1: ( ruleScanner )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4808:1: ruleScanner
            {
             before(grammarAccess.getModelAccess().getScannerScannerParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleScanner_in_rule__Model__ScannerAssignment_39586);
            ruleScanner();

            state._fsp--;

             after(grammarAccess.getModelAccess().getScannerScannerParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ScannerAssignment_3"


    // $ANTLR start "rule__Model__PartitionerAssignment_4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4817:1: rule__Model__PartitionerAssignment_4 : ( rulePartitioner ) ;
    public final void rule__Model__PartitionerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4821:1: ( ( rulePartitioner ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4822:1: ( rulePartitioner )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4822:1: ( rulePartitioner )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4823:1: rulePartitioner
            {
             before(grammarAccess.getModelAccess().getPartitionerPartitionerParserRuleCall_4_0()); 
            pushFollow(FOLLOW_rulePartitioner_in_rule__Model__PartitionerAssignment_49617);
            rulePartitioner();

            state._fsp--;

             after(grammarAccess.getModelAccess().getPartitionerPartitionerParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PartitionerAssignment_4"


    // $ANTLR start "rule__Partition__NameAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4832:1: rule__Partition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Partition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4836:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4837:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4837:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4838:1: RULE_ID
            {
             before(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_19648); 
             after(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__RulePartitioner__RulesAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4847:1: rule__RulePartitioner__RulesAssignment_2 : ( ruleParitionRule ) ;
    public final void rule__RulePartitioner__RulesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4851:1: ( ( ruleParitionRule ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4852:1: ( ruleParitionRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4852:1: ( ruleParitionRule )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4853:1: ruleParitionRule
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesParitionRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParitionRule_in_rule__RulePartitioner__RulesAssignment_29679);
            ruleParitionRule();

            state._fsp--;

             after(grammarAccess.getRulePartitionerAccess().getRulesParitionRuleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RulePartitioner__RulesAssignment_2"


    // $ANTLR start "rule__JSParitioner__FileURIAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4862:1: rule__JSParitioner__FileURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JSParitioner__FileURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4866:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4867:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4867:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4868:1: RULE_STRING
            {
             before(grammarAccess.getJSParitionerAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JSParitioner__FileURIAssignment_19710); 
             after(grammarAccess.getJSParitionerAccess().getFileURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSParitioner__FileURIAssignment_1"


    // $ANTLR start "rule__Scanner__PartitionAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4877:1: rule__Scanner__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Scanner__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4881:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4882:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4882:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4883:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4884:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4885:1: RULE_ID
            {
             before(grammarAccess.getScannerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Scanner__PartitionAssignment_19745); 
             after(grammarAccess.getScannerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getScannerAccess().getPartitionPartitionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__PartitionAssignment_1"


    // $ANTLR start "rule__Scanner__TokensAssignment_3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4896:1: rule__Scanner__TokensAssignment_3 : ( ruleScannerToken ) ;
    public final void rule__Scanner__TokensAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4900:1: ( ( ruleScannerToken ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4901:1: ( ruleScannerToken )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4901:1: ( ruleScannerToken )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4902:1: ruleScannerToken
            {
             before(grammarAccess.getScannerAccess().getTokensScannerTokenParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleScannerToken_in_rule__Scanner__TokensAssignment_39780);
            ruleScannerToken();

            state._fsp--;

             after(grammarAccess.getScannerAccess().getTokensScannerTokenParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__TokensAssignment_3"


    // $ANTLR start "rule__Scanner__KeywordGroupsAssignment_4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4911:1: rule__Scanner__KeywordGroupsAssignment_4 : ( ruleKeywordGroup ) ;
    public final void rule__Scanner__KeywordGroupsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4915:1: ( ( ruleKeywordGroup ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4916:1: ( ruleKeywordGroup )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4916:1: ( ruleKeywordGroup )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4917:1: ruleKeywordGroup
            {
             before(grammarAccess.getScannerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_rule__Scanner__KeywordGroupsAssignment_49811);
            ruleKeywordGroup();

            state._fsp--;

             after(grammarAccess.getScannerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__KeywordGroupsAssignment_4"


    // $ANTLR start "rule__Scanner__RulesAssignment_5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4926:1: rule__Scanner__RulesAssignment_5 : ( ruleScannerRule ) ;
    public final void rule__Scanner__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4930:1: ( ( ruleScannerRule ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4931:1: ( ruleScannerRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4931:1: ( ruleScannerRule )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4932:1: ruleScannerRule
            {
             before(grammarAccess.getScannerAccess().getRulesScannerRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleScannerRule_in_rule__Scanner__RulesAssignment_59842);
            ruleScannerRule();

            state._fsp--;

             after(grammarAccess.getScannerAccess().getRulesScannerRuleParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner__RulesAssignment_5"


    // $ANTLR start "rule__ScannerToken__DefaultAssignment_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4941:1: rule__ScannerToken__DefaultAssignment_0 : ( ( 'default' ) ) ;
    public final void rule__ScannerToken__DefaultAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4945:1: ( ( ( 'default' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4946:1: ( ( 'default' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4946:1: ( ( 'default' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4947:1: ( 'default' )
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4948:1: ( 'default' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4949:1: 'default'
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 
            match(input,44,FOLLOW_44_in_rule__ScannerToken__DefaultAssignment_09878); 
             after(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 

            }

             after(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__DefaultAssignment_0"


    // $ANTLR start "rule__ScannerToken__NameAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4964:1: rule__ScannerToken__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ScannerToken__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4968:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4969:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4969:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4970:1: RULE_ID
            {
             before(grammarAccess.getScannerTokenAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerToken__NameAssignment_29917); 
             after(grammarAccess.getScannerTokenAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__NameAssignment_2"


    // $ANTLR start "rule__ScannerToken__FgColorAssignment_3_1_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4979:1: rule__ScannerToken__FgColorAssignment_3_1_2 : ( ruleColor ) ;
    public final void rule__ScannerToken__FgColorAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4983:1: ( ( ruleColor ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4984:1: ( ruleColor )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4984:1: ( ruleColor )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4985:1: ruleColor
            {
             before(grammarAccess.getScannerTokenAccess().getFgColorColorParserRuleCall_3_1_2_0()); 
            pushFollow(FOLLOW_ruleColor_in_rule__ScannerToken__FgColorAssignment_3_1_29948);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getScannerTokenAccess().getFgColorColorParserRuleCall_3_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__FgColorAssignment_3_1_2"


    // $ANTLR start "rule__ScannerToken__BgColorAssignment_3_2_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4994:1: rule__ScannerToken__BgColorAssignment_3_2_2 : ( ruleColor ) ;
    public final void rule__ScannerToken__BgColorAssignment_3_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4998:1: ( ( ruleColor ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4999:1: ( ruleColor )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4999:1: ( ruleColor )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5000:1: ruleColor
            {
             before(grammarAccess.getScannerTokenAccess().getBgColorColorParserRuleCall_3_2_2_0()); 
            pushFollow(FOLLOW_ruleColor_in_rule__ScannerToken__BgColorAssignment_3_2_29979);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getScannerTokenAccess().getBgColorColorParserRuleCall_3_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__BgColorAssignment_3_2_2"


    // $ANTLR start "rule__ScannerToken__FontAssignment_3_3_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5009:1: rule__ScannerToken__FontAssignment_3_3_2 : ( ruleFont ) ;
    public final void rule__ScannerToken__FontAssignment_3_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5013:1: ( ( ruleFont ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5014:1: ( ruleFont )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5014:1: ( ruleFont )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5015:1: ruleFont
            {
             before(grammarAccess.getScannerTokenAccess().getFontFontParserRuleCall_3_3_2_0()); 
            pushFollow(FOLLOW_ruleFont_in_rule__ScannerToken__FontAssignment_3_3_210010);
            ruleFont();

            state._fsp--;

             after(grammarAccess.getScannerTokenAccess().getFontFontParserRuleCall_3_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerToken__FontAssignment_3_3_2"


    // $ANTLR start "rule__KeywordGroup__TokenAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5024:1: rule__KeywordGroup__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__KeywordGroup__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5028:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5029:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5029:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5030:1: ( RULE_ID )
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5031:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5032:1: RULE_ID
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeywordGroup__TokenAssignment_110045); 
             after(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__TokenAssignment_1"


    // $ANTLR start "rule__KeywordGroup__KeywordsAssignment_3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5043:1: rule__KeywordGroup__KeywordsAssignment_3 : ( ruleKeyword ) ;
    public final void rule__KeywordGroup__KeywordsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5047:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5048:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5048:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5049:1: ruleKeyword
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_310080);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__KeywordsAssignment_3"


    // $ANTLR start "rule__KeywordGroup__KeywordsAssignment_4_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5058:1: rule__KeywordGroup__KeywordsAssignment_4_1 : ( ruleKeyword ) ;
    public final void rule__KeywordGroup__KeywordsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5062:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5063:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5063:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5064:1: ruleKeyword
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_4_110111);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeywordGroup__KeywordsAssignment_4_1"


    // $ANTLR start "rule__Keyword__NameAssignment_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5073:1: rule__Keyword__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Keyword__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5077:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5078:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5078:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5079:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_010142); 
             after(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5088:1: rule__Keyword__VersionAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Keyword__VersionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5092:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5093:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5093:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5094:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_110173); 
             after(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__ScannerSingleLineRule__TokenAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5103:1: rule__ScannerSingleLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerSingleLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5107:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5108:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5108:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5109:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5110:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5111:1: RULE_ID
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerSingleLineRule__TokenAssignment_110208); 
             after(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__TokenAssignment_1"


    // $ANTLR start "rule__ScannerSingleLineRule__StartSeqAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5122:1: rule__ScannerSingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5126:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5127:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5127:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5128:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__StartSeqAssignment_210243); 
             after(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__StartSeqAssignment_2"


    // $ANTLR start "rule__ScannerSingleLineRule__EndSeqAssignment_4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5137:1: rule__ScannerSingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5141:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5142:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5142:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5143:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EndSeqAssignment_410274); 
             after(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__EndSeqAssignment_4"


    // $ANTLR start "rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5152:1: rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5156:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5157:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5157:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5158:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_210305); 
             after(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2"


    // $ANTLR start "rule__PartitionSingleLineRule__ParitionAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5167:1: rule__PartitionSingleLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionSingleLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5171:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5172:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5172:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5173:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5174:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5175:1: RULE_ID
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionSingleLineRule__ParitionAssignment_110340); 
             after(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__ParitionAssignment_1"


    // $ANTLR start "rule__PartitionSingleLineRule__StartSeqAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5186:1: rule__PartitionSingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5190:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5191:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5191:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5192:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__StartSeqAssignment_210375); 
             after(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__StartSeqAssignment_2"


    // $ANTLR start "rule__PartitionSingleLineRule__EndSeqAssignment_4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5201:1: rule__PartitionSingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5205:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5206:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5206:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5207:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EndSeqAssignment_410406); 
             after(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__EndSeqAssignment_4"


    // $ANTLR start "rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5216:1: rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5220:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5221:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5221:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5222:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_210437); 
             after(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2"


    // $ANTLR start "rule__ScannerMultiLineRule__TokenAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5231:1: rule__ScannerMultiLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerMultiLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5235:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5236:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5236:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5237:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5238:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5239:1: RULE_ID
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerMultiLineRule__TokenAssignment_110472); 
             after(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__TokenAssignment_1"


    // $ANTLR start "rule__ScannerMultiLineRule__StartSeqAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5250:1: rule__ScannerMultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5254:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5255:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5255:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5256:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__StartSeqAssignment_210507); 
             after(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__StartSeqAssignment_2"


    // $ANTLR start "rule__ScannerMultiLineRule__EndSeqAssignment_4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5265:1: rule__ScannerMultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5269:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5270:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5270:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5271:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EndSeqAssignment_410538); 
             after(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__EndSeqAssignment_4"


    // $ANTLR start "rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5280:1: rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5284:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5285:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5285:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5286:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_210569); 
             after(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2"


    // $ANTLR start "rule__PartitionMultiLineRule__TokenAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5295:1: rule__PartitionMultiLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionMultiLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5299:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5300:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5300:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5301:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getTokenPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5302:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5303:1: RULE_ID
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getTokenPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionMultiLineRule__TokenAssignment_110604); 
             after(grammarAccess.getPartitionMultiLineRuleAccess().getTokenPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPartitionMultiLineRuleAccess().getTokenPartitionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__TokenAssignment_1"


    // $ANTLR start "rule__PartitionMultiLineRule__StartSeqAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5314:1: rule__PartitionMultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5318:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5319:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5319:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5320:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__StartSeqAssignment_210639); 
             after(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__StartSeqAssignment_2"


    // $ANTLR start "rule__PartitionMultiLineRule__EndSeqAssignment_4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5329:1: rule__PartitionMultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5333:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5334:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5334:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5335:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EndSeqAssignment_410670); 
             after(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__EndSeqAssignment_4"


    // $ANTLR start "rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5344:1: rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5348:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5349:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5349:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5350:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_210701); 
             after(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2"


    // $ANTLR start "rule__ScannerCharacterRule__TokenAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5359:1: rule__ScannerCharacterRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerCharacterRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5363:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5364:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5364:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5365:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5366:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5367:1: RULE_ID
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerCharacterRule__TokenAssignment_110736); 
             after(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__TokenAssignment_1"


    // $ANTLR start "rule__ScannerCharacterRule__CharactersAssignment_3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5378:1: rule__ScannerCharacterRule__CharactersAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ScannerCharacterRule__CharactersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5382:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5383:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5383:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5384:1: RULE_STRING
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_310771); 
             after(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__CharactersAssignment_3"


    // $ANTLR start "rule__ScannerCharacterRule__CharactersAssignment_5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5393:1: rule__ScannerCharacterRule__CharactersAssignment_5 : ( RULE_STRING ) ;
    public final void rule__ScannerCharacterRule__CharactersAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5397:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5398:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5398:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5399:1: RULE_STRING
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_510802); 
             after(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__CharactersAssignment_5"


    // $ANTLR start "rule__ScannerJSRule__TokenAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5408:1: rule__ScannerJSRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerJSRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5412:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5413:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5413:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5414:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5415:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5416:1: RULE_ID
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerJSRule__TokenAssignment_110837); 
             after(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerJSRule__TokenAssignment_1"


    // $ANTLR start "rule__ScannerJSRule__FileURIAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5427:1: rule__ScannerJSRule__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerJSRule__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5431:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5432:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5432:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5433:1: RULE_STRING
            {
             before(grammarAccess.getScannerJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerJSRule__FileURIAssignment_210872); 
             after(grammarAccess.getScannerJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerJSRule__FileURIAssignment_2"


    // $ANTLR start "rule__PartitionJSRule__TokenAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5442:1: rule__PartitionJSRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionJSRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5446:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5447:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5447:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5448:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5449:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5450:1: RULE_ID
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionJSRule__TokenAssignment_110907); 
             after(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionJSRule__TokenAssignment_1"


    // $ANTLR start "rule__PartitionJSRule__FileURIAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5461:1: rule__PartitionJSRule__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionJSRule__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5465:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5466:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5466:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5467:1: RULE_STRING
            {
             before(grammarAccess.getPartitionJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionJSRule__FileURIAssignment_210942); 
             after(grammarAccess.getPartitionJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionJSRule__FileURIAssignment_2"


    // $ANTLR start "rule__ScannerWhitespaceRule__TokenAssignment_0_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5476:1: rule__ScannerWhitespaceRule__TokenAssignment_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerWhitespaceRule__TokenAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5480:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5481:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5481:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5482:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_0_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5483:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5484:1: RULE_ID
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenIDTerminalRuleCall_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerWhitespaceRule__TokenAssignment_0_110977); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenIDTerminalRuleCall_0_1_0_1()); 

            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__TokenAssignment_0_1"


    // $ANTLR start "rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5495:1: rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5499:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5500:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5500:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5501:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_0_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_111012); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1"


    // $ANTLR start "rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5510:1: rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5514:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5515:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5515:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5516:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_0_2_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_111043); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_0_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1"


    // $ANTLR start "rule__ScannerWhitespaceRule__JsMethodAssignment_1_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5525:1: rule__ScannerWhitespaceRule__JsMethodAssignment_1_1 : ( RULE_ANY_OTHER ) ;
    public final void rule__ScannerWhitespaceRule__JsMethodAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5529:1: ( ( RULE_ANY_OTHER ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5530:1: ( RULE_ANY_OTHER )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5530:1: ( RULE_ANY_OTHER )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5531:1: RULE_ANY_OTHER
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getJsMethodANY_OTHERTerminalRuleCall_1_1_0()); 
            match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_rule__ScannerWhitespaceRule__JsMethodAssignment_1_111074); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getJsMethodANY_OTHERTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__JsMethodAssignment_1_1"


    // $ANTLR start "rule__RGBColor__RAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5540:1: rule__RGBColor__RAssignment_2 : ( RULE_INT ) ;
    public final void rule__RGBColor__RAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5544:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5545:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5545:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5546:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getRINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__RAssignment_211105); 
             after(grammarAccess.getRGBColorAccess().getRINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__RAssignment_2"


    // $ANTLR start "rule__RGBColor__GAssignment_4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5555:1: rule__RGBColor__GAssignment_4 : ( RULE_INT ) ;
    public final void rule__RGBColor__GAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5559:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5560:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5560:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5561:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getGINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__GAssignment_411136); 
             after(grammarAccess.getRGBColorAccess().getGINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__GAssignment_4"


    // $ANTLR start "rule__RGBColor__BAssignment_6"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5570:1: rule__RGBColor__BAssignment_6 : ( RULE_INT ) ;
    public final void rule__RGBColor__BAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5574:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5575:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5575:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5576:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getBINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__BAssignment_611167); 
             after(grammarAccess.getRGBColorAccess().getBINTTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__BAssignment_6"


    // $ANTLR start "rule__Font__NameAssignment_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5585:1: rule__Font__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Font__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5589:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5590:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5590:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5591:1: RULE_ID
            {
             before(grammarAccess.getFontAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Font__NameAssignment_011198); 
             after(grammarAccess.getFontAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Font__NameAssignment_0"


    // $ANTLR start "rule__Font__SizeAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5600:1: rule__Font__SizeAssignment_1 : ( RULE_INT ) ;
    public final void rule__Font__SizeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5604:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5605:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5605:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5606:1: RULE_INT
            {
             before(grammarAccess.getFontAccess().getSizeINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Font__SizeAssignment_111229); 
             after(grammarAccess.getFontAccess().getSizeINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Font__SizeAssignment_1"


    // $ANTLR start "rule__Font__AttributesAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5615:1: rule__Font__AttributesAssignment_2 : ( ruleFontType ) ;
    public final void rule__Font__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5619:1: ( ( ruleFontType ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5620:1: ( ruleFontType )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5620:1: ( ruleFontType )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5621:1: ruleFontType
            {
             before(grammarAccess.getFontAccess().getAttributesFontTypeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleFontType_in_rule__Font__AttributesAssignment_211260);
            ruleFontType();

            state._fsp--;

             after(grammarAccess.getFontAccess().getAttributesFontTypeEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Font__AttributesAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_entryRulePartition121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__0_in_rulePartition154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_entryRulePartitioner181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner__Alternatives_in_rulePartitioner214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRulePartitioner248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__0_in_ruleRulePartitioner274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSParitioner308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__0_in_ruleJSParitioner334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_entryRuleScanner361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__Group__0_in_ruleScanner394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_entryRuleScannerToken421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerToken428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__0_in_ruleScannerToken454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordGroup488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__0_in_ruleKeywordGroup514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0_in_ruleKeyword574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_entryRuleScannerRule601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerRule608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerRule__Alternatives_in_ruleScannerRule634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_entryRuleParitionRule661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitionRule668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParitionRule__Alternatives_in_ruleParitionRule694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerSingleLineRule728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__0_in_ruleScannerSingleLineRule754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionSingleLineRule788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__0_in_rulePartitionSingleLineRule814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerMultiLineRule848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__0_in_ruleScannerMultiLineRule874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionMultiLineRule908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__0_in_rulePartitionMultiLineRule934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerCharacterRule968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__0_in_ruleScannerCharacterRule994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerJSRule1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__0_in_ruleScannerJSRule1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionJSRule1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__0_in_rulePartitionJSRule1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule1141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerWhitespaceRule1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Alternatives_in_ruleScannerWhitespaceRule1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor1201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_ruleColor1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_entryRuleRGBColor1260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGBColor1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__0_in_ruleRGBColor1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFont_in_entryRuleFont1320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFont1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__0_in_ruleFont1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FontType__Alternatives_in_ruleFontType1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_rule__Partitioner__Alternatives1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_rule__Partitioner__Alternatives1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_rule__ScannerRule__Alternatives1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_rule__ScannerRule__Alternatives1491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_rule__ScannerRule__Alternatives1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_rule__ScannerRule__Alternatives1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_rule__ScannerRule__Alternatives1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_rule__ParitionRule__Alternatives1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_rule__ParitionRule__Alternatives1591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_rule__ParitionRule__Alternatives1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__0_in_rule__ScannerWhitespaceRule__Alternatives1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__0_in_rule__ScannerWhitespaceRule__Alternatives1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__FontType__Alternatives1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__FontType__Alternatives1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__FontType__Alternatives1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__FontType__Alternatives1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01788 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NameAssignment_0_in_rule__Model__Group__0__Impl1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11848 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__11851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Model__Group__1__Impl1879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__21910 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__21913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl1942 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl1954 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__31987 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__31990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ScannerAssignment_3_in_rule__Model__Group__3__Impl2019 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Model__ScannerAssignment_3_in_rule__Model__Group__3__Impl2031 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__42064 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Model__Group__5_in_rule__Model__Group__42067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionerAssignment_4_in_rule__Model__Group__4__Impl2094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__52124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Model__Group__5__Impl2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__02195 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__02198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Partition__Group__0__Impl2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__12257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__0__Impl_in_rule__RulePartitioner__Group__02318 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__1_in_rule__RulePartitioner__Group__02321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__RulePartitioner__Group__0__Impl2349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__1__Impl_in_rule__RulePartitioner__Group__12380 = new BitSet(new long[]{0x0000002880000000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__2_in_rule__RulePartitioner__Group__12383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__RulePartitioner__Group__1__Impl2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__2__Impl_in_rule__RulePartitioner__Group__22442 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__3_in_rule__RulePartitioner__Group__22445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl2474 = new BitSet(new long[]{0x0000002880000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl2486 = new BitSet(new long[]{0x0000002880000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__3__Impl_in_rule__RulePartitioner__Group__32519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__RulePartitioner__Group__3__Impl2547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__0__Impl_in_rule__JSParitioner__Group__02586 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__1_in_rule__JSParitioner__Group__02589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__JSParitioner__Group__0__Impl2617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__1__Impl_in_rule__JSParitioner__Group__12648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__FileURIAssignment_1_in_rule__JSParitioner__Group__1__Impl2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__Group__0__Impl_in_rule__Scanner__Group__02709 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Scanner__Group__1_in_rule__Scanner__Group__02712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Scanner__Group__0__Impl2740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__Group__1__Impl_in_rule__Scanner__Group__12771 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Scanner__Group__2_in_rule__Scanner__Group__12774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__PartitionAssignment_1_in_rule__Scanner__Group__1__Impl2801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__Group__2__Impl_in_rule__Scanner__Group__22831 = new BitSet(new long[]{0x000010F884200000L});
    public static final BitSet FOLLOW_rule__Scanner__Group__3_in_rule__Scanner__Group__22834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Scanner__Group__2__Impl2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__Group__3__Impl_in_rule__Scanner__Group__32893 = new BitSet(new long[]{0x000010F884200000L});
    public static final BitSet FOLLOW_rule__Scanner__Group__4_in_rule__Scanner__Group__32896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__TokensAssignment_3_in_rule__Scanner__Group__3__Impl2923 = new BitSet(new long[]{0x0000100000200002L});
    public static final BitSet FOLLOW_rule__Scanner__Group__4__Impl_in_rule__Scanner__Group__42954 = new BitSet(new long[]{0x000010F884200000L});
    public static final BitSet FOLLOW_rule__Scanner__Group__5_in_rule__Scanner__Group__42957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__KeywordGroupsAssignment_4_in_rule__Scanner__Group__4__Impl2984 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__Scanner__Group__5__Impl_in_rule__Scanner__Group__53015 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Scanner__Group__6_in_rule__Scanner__Group__53018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__RulesAssignment_5_in_rule__Scanner__Group__5__Impl3047 = new BitSet(new long[]{0x000010F884200002L});
    public static final BitSet FOLLOW_rule__Scanner__RulesAssignment_5_in_rule__Scanner__Group__5__Impl3059 = new BitSet(new long[]{0x000010F884200002L});
    public static final BitSet FOLLOW_rule__Scanner__Group__6__Impl_in_rule__Scanner__Group__63092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Scanner__Group__6__Impl3120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__0__Impl_in_rule__ScannerToken__Group__03165 = new BitSet(new long[]{0x0000100000200000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__1_in_rule__ScannerToken__Group__03168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__DefaultAssignment_0_in_rule__ScannerToken__Group__0__Impl3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__1__Impl_in_rule__ScannerToken__Group__13226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__2_in_rule__ScannerToken__Group__13229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ScannerToken__Group__1__Impl3257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__2__Impl_in_rule__ScannerToken__Group__23288 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__3_in_rule__ScannerToken__Group__23291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__NameAssignment_2_in_rule__ScannerToken__Group__2__Impl3318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__3__Impl_in_rule__ScannerToken__Group__33348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__0_in_rule__ScannerToken__Group__3__Impl3375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__0__Impl_in_rule__ScannerToken__Group_3__03414 = new BitSet(new long[]{0x0000000003410000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__1_in_rule__ScannerToken__Group_3__03417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ScannerToken__Group_3__0__Impl3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__1__Impl_in_rule__ScannerToken__Group_3__13476 = new BitSet(new long[]{0x0000000003410000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__2_in_rule__ScannerToken__Group_3__13479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__0_in_rule__ScannerToken__Group_3__1__Impl3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__2__Impl_in_rule__ScannerToken__Group_3__23537 = new BitSet(new long[]{0x0000000003410000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__3_in_rule__ScannerToken__Group_3__23540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__0_in_rule__ScannerToken__Group_3__2__Impl3567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__3__Impl_in_rule__ScannerToken__Group_3__33598 = new BitSet(new long[]{0x0000000003410000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__4_in_rule__ScannerToken__Group_3__33601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__0_in_rule__ScannerToken__Group_3__3__Impl3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__4__Impl_in_rule__ScannerToken__Group_3__43659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ScannerToken__Group_3__4__Impl3687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__0__Impl_in_rule__ScannerToken__Group_3_1__03728 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__1_in_rule__ScannerToken__Group_3_1__03731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ScannerToken__Group_3_1__0__Impl3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__1__Impl_in_rule__ScannerToken__Group_3_1__13790 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__2_in_rule__ScannerToken__Group_3_1__13793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ScannerToken__Group_3_1__1__Impl3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__2__Impl_in_rule__ScannerToken__Group_3_1__23852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__FgColorAssignment_3_1_2_in_rule__ScannerToken__Group_3_1__2__Impl3879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__0__Impl_in_rule__ScannerToken__Group_3_2__03915 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__1_in_rule__ScannerToken__Group_3_2__03918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ScannerToken__Group_3_2__0__Impl3946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__1__Impl_in_rule__ScannerToken__Group_3_2__13977 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__2_in_rule__ScannerToken__Group_3_2__13980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ScannerToken__Group_3_2__1__Impl4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__2__Impl_in_rule__ScannerToken__Group_3_2__24039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__BgColorAssignment_3_2_2_in_rule__ScannerToken__Group_3_2__2__Impl4066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__0__Impl_in_rule__ScannerToken__Group_3_3__04102 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__1_in_rule__ScannerToken__Group_3_3__04105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ScannerToken__Group_3_3__0__Impl4133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__1__Impl_in_rule__ScannerToken__Group_3_3__14164 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__2_in_rule__ScannerToken__Group_3_3__14167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ScannerToken__Group_3_3__1__Impl4195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__2__Impl_in_rule__ScannerToken__Group_3_3__24226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__FontAssignment_3_3_2_in_rule__ScannerToken__Group_3_3__2__Impl4253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__0__Impl_in_rule__KeywordGroup__Group__04289 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__1_in_rule__KeywordGroup__Group__04292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__KeywordGroup__Group__0__Impl4320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__1__Impl_in_rule__KeywordGroup__Group__14351 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__2_in_rule__KeywordGroup__Group__14354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__TokenAssignment_1_in_rule__KeywordGroup__Group__1__Impl4381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__2__Impl_in_rule__KeywordGroup__Group__24411 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__3_in_rule__KeywordGroup__Group__24414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__KeywordGroup__Group__2__Impl4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__3__Impl_in_rule__KeywordGroup__Group__34473 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__4_in_rule__KeywordGroup__Group__34476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__KeywordsAssignment_3_in_rule__KeywordGroup__Group__3__Impl4503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__4__Impl_in_rule__KeywordGroup__Group__44533 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__5_in_rule__KeywordGroup__Group__44536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__0_in_rule__KeywordGroup__Group__4__Impl4563 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__5__Impl_in_rule__KeywordGroup__Group__54594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__KeywordGroup__Group__5__Impl4622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__0__Impl_in_rule__KeywordGroup__Group_4__04665 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__1_in_rule__KeywordGroup__Group_4__04668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__KeywordGroup__Group_4__0__Impl4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__1__Impl_in_rule__KeywordGroup__Group_4__14727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__KeywordsAssignment_4_1_in_rule__KeywordGroup__Group_4__1__Impl4754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__04788 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__04791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl4818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__14848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__04910 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__04913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Keyword__Group_1__0__Impl4941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__14972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__0__Impl_in_rule__ScannerSingleLineRule__Group__05033 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__1_in_rule__ScannerSingleLineRule__Group__05036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ScannerSingleLineRule__Group__0__Impl5064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__1__Impl_in_rule__ScannerSingleLineRule__Group__15095 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__2_in_rule__ScannerSingleLineRule__Group__15098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__TokenAssignment_1_in_rule__ScannerSingleLineRule__Group__1__Impl5125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__2__Impl_in_rule__ScannerSingleLineRule__Group__25155 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__3_in_rule__ScannerSingleLineRule__Group__25158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__StartSeqAssignment_2_in_rule__ScannerSingleLineRule__Group__2__Impl5185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__3__Impl_in_rule__ScannerSingleLineRule__Group__35215 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__4_in_rule__ScannerSingleLineRule__Group__35218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ScannerSingleLineRule__Group__3__Impl5246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__4__Impl_in_rule__ScannerSingleLineRule__Group__45277 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__5_in_rule__ScannerSingleLineRule__Group__45280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__EndSeqAssignment_4_in_rule__ScannerSingleLineRule__Group__4__Impl5307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__5__Impl_in_rule__ScannerSingleLineRule__Group__55337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__0_in_rule__ScannerSingleLineRule__Group__5__Impl5364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__0__Impl_in_rule__ScannerSingleLineRule__Group_5__05407 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__1_in_rule__ScannerSingleLineRule__Group_5__05410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ScannerSingleLineRule__Group_5__0__Impl5438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__1__Impl_in_rule__ScannerSingleLineRule__Group_5__15469 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__2_in_rule__ScannerSingleLineRule__Group_5__15472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ScannerSingleLineRule__Group_5__1__Impl5500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__2__Impl_in_rule__ScannerSingleLineRule__Group_5__25531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerSingleLineRule__Group_5__2__Impl5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__0__Impl_in_rule__PartitionSingleLineRule__Group__05594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__1_in_rule__PartitionSingleLineRule__Group__05597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__PartitionSingleLineRule__Group__0__Impl5625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__1__Impl_in_rule__PartitionSingleLineRule__Group__15656 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__2_in_rule__PartitionSingleLineRule__Group__15659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__ParitionAssignment_1_in_rule__PartitionSingleLineRule__Group__1__Impl5686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__2__Impl_in_rule__PartitionSingleLineRule__Group__25716 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__3_in_rule__PartitionSingleLineRule__Group__25719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__StartSeqAssignment_2_in_rule__PartitionSingleLineRule__Group__2__Impl5746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__3__Impl_in_rule__PartitionSingleLineRule__Group__35776 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__4_in_rule__PartitionSingleLineRule__Group__35779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__PartitionSingleLineRule__Group__3__Impl5807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__4__Impl_in_rule__PartitionSingleLineRule__Group__45838 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__5_in_rule__PartitionSingleLineRule__Group__45841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__EndSeqAssignment_4_in_rule__PartitionSingleLineRule__Group__4__Impl5868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__5__Impl_in_rule__PartitionSingleLineRule__Group__55898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__0_in_rule__PartitionSingleLineRule__Group__5__Impl5925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__0__Impl_in_rule__PartitionSingleLineRule__Group_5__05968 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__1_in_rule__PartitionSingleLineRule__Group_5__05971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__PartitionSingleLineRule__Group_5__0__Impl5999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__1__Impl_in_rule__PartitionSingleLineRule__Group_5__16030 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__2_in_rule__PartitionSingleLineRule__Group_5__16033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__PartitionSingleLineRule__Group_5__1__Impl6061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__2__Impl_in_rule__PartitionSingleLineRule__Group_5__26092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionSingleLineRule__Group_5__2__Impl6119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__0__Impl_in_rule__ScannerMultiLineRule__Group__06155 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__1_in_rule__ScannerMultiLineRule__Group__06158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ScannerMultiLineRule__Group__0__Impl6186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__1__Impl_in_rule__ScannerMultiLineRule__Group__16217 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__2_in_rule__ScannerMultiLineRule__Group__16220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__TokenAssignment_1_in_rule__ScannerMultiLineRule__Group__1__Impl6247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__2__Impl_in_rule__ScannerMultiLineRule__Group__26277 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__3_in_rule__ScannerMultiLineRule__Group__26280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__StartSeqAssignment_2_in_rule__ScannerMultiLineRule__Group__2__Impl6307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__3__Impl_in_rule__ScannerMultiLineRule__Group__36337 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__4_in_rule__ScannerMultiLineRule__Group__36340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ScannerMultiLineRule__Group__3__Impl6368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__4__Impl_in_rule__ScannerMultiLineRule__Group__46399 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__5_in_rule__ScannerMultiLineRule__Group__46402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__EndSeqAssignment_4_in_rule__ScannerMultiLineRule__Group__4__Impl6429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__5__Impl_in_rule__ScannerMultiLineRule__Group__56459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__0_in_rule__ScannerMultiLineRule__Group__5__Impl6486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__0__Impl_in_rule__ScannerMultiLineRule__Group_5__06529 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__1_in_rule__ScannerMultiLineRule__Group_5__06532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ScannerMultiLineRule__Group_5__0__Impl6560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__1__Impl_in_rule__ScannerMultiLineRule__Group_5__16591 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__2_in_rule__ScannerMultiLineRule__Group_5__16594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ScannerMultiLineRule__Group_5__1__Impl6622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__2__Impl_in_rule__ScannerMultiLineRule__Group_5__26653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerMultiLineRule__Group_5__2__Impl6680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__0__Impl_in_rule__PartitionMultiLineRule__Group__06716 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__1_in_rule__PartitionMultiLineRule__Group__06719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__PartitionMultiLineRule__Group__0__Impl6747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__1__Impl_in_rule__PartitionMultiLineRule__Group__16778 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__2_in_rule__PartitionMultiLineRule__Group__16781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__TokenAssignment_1_in_rule__PartitionMultiLineRule__Group__1__Impl6808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__2__Impl_in_rule__PartitionMultiLineRule__Group__26838 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__3_in_rule__PartitionMultiLineRule__Group__26841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__StartSeqAssignment_2_in_rule__PartitionMultiLineRule__Group__2__Impl6868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__3__Impl_in_rule__PartitionMultiLineRule__Group__36898 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__4_in_rule__PartitionMultiLineRule__Group__36901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__PartitionMultiLineRule__Group__3__Impl6929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__4__Impl_in_rule__PartitionMultiLineRule__Group__46960 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__5_in_rule__PartitionMultiLineRule__Group__46963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__EndSeqAssignment_4_in_rule__PartitionMultiLineRule__Group__4__Impl6990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__5__Impl_in_rule__PartitionMultiLineRule__Group__57020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__0_in_rule__PartitionMultiLineRule__Group__5__Impl7047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__0__Impl_in_rule__PartitionMultiLineRule__Group_5__07090 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__1_in_rule__PartitionMultiLineRule__Group_5__07093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__PartitionMultiLineRule__Group_5__0__Impl7121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__1__Impl_in_rule__PartitionMultiLineRule__Group_5__17152 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__2_in_rule__PartitionMultiLineRule__Group_5__17155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__PartitionMultiLineRule__Group_5__1__Impl7183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__2__Impl_in_rule__PartitionMultiLineRule__Group_5__27214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionMultiLineRule__Group_5__2__Impl7241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__0__Impl_in_rule__ScannerCharacterRule__Group__07277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__1_in_rule__ScannerCharacterRule__Group__07280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ScannerCharacterRule__Group__0__Impl7308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__1__Impl_in_rule__ScannerCharacterRule__Group__17339 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__2_in_rule__ScannerCharacterRule__Group__17342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__TokenAssignment_1_in_rule__ScannerCharacterRule__Group__1__Impl7369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__2__Impl_in_rule__ScannerCharacterRule__Group__27399 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__3_in_rule__ScannerCharacterRule__Group__27402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ScannerCharacterRule__Group__2__Impl7430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__3__Impl_in_rule__ScannerCharacterRule__Group__37461 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__4_in_rule__ScannerCharacterRule__Group__37464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_3_in_rule__ScannerCharacterRule__Group__3__Impl7491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__4__Impl_in_rule__ScannerCharacterRule__Group__47521 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__5_in_rule__ScannerCharacterRule__Group__47524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ScannerCharacterRule__Group__4__Impl7552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__5__Impl_in_rule__ScannerCharacterRule__Group__57583 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__6_in_rule__ScannerCharacterRule__Group__57586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_5_in_rule__ScannerCharacterRule__Group__5__Impl7613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__6__Impl_in_rule__ScannerCharacterRule__Group__67643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ScannerCharacterRule__Group__6__Impl7671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__0__Impl_in_rule__ScannerJSRule__Group__07716 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__1_in_rule__ScannerJSRule__Group__07719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ScannerJSRule__Group__0__Impl7747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__1__Impl_in_rule__ScannerJSRule__Group__17778 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__2_in_rule__ScannerJSRule__Group__17781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__TokenAssignment_1_in_rule__ScannerJSRule__Group__1__Impl7808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__2__Impl_in_rule__ScannerJSRule__Group__27838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__FileURIAssignment_2_in_rule__ScannerJSRule__Group__2__Impl7865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__0__Impl_in_rule__PartitionJSRule__Group__07901 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__1_in_rule__PartitionJSRule__Group__07904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__PartitionJSRule__Group__0__Impl7932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__1__Impl_in_rule__PartitionJSRule__Group__17963 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__2_in_rule__PartitionJSRule__Group__17966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__TokenAssignment_1_in_rule__PartitionJSRule__Group__1__Impl7993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__2__Impl_in_rule__PartitionJSRule__Group__28023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__FileURIAssignment_2_in_rule__PartitionJSRule__Group__2__Impl8050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__0__Impl_in_rule__ScannerWhitespaceRule__Group_0__08086 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__1_in_rule__ScannerWhitespaceRule__Group_0__08089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ScannerWhitespaceRule__Group_0__0__Impl8117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__1__Impl_in_rule__ScannerWhitespaceRule__Group_0__18148 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__2_in_rule__ScannerWhitespaceRule__Group_0__18151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__TokenAssignment_0_1_in_rule__ScannerWhitespaceRule__Group_0__1__Impl8178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__2__Impl_in_rule__ScannerWhitespaceRule__Group_0__28209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__0_in_rule__ScannerWhitespaceRule__Group_0__2__Impl8236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__08272 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__1_in_rule__ScannerWhitespaceRule__Group_0_2__08275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ScannerWhitespaceRule__Group_0_2__0__Impl8303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__18334 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__2_in_rule__ScannerWhitespaceRule__Group_0_2__18337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1_in_rule__ScannerWhitespaceRule__Group_0_2__1__Impl8364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__2__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__28394 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__3_in_rule__ScannerWhitespaceRule__Group_0_2__28397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__0_in_rule__ScannerWhitespaceRule__Group_0_2__2__Impl8424 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__3__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__38455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ScannerWhitespaceRule__Group_0_2__3__Impl8483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_0_2_2__08522 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__1_in_rule__ScannerWhitespaceRule__Group_0_2_2__08525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl8553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_0_2_2__18584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1_in_rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl8611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__0__Impl_in_rule__ScannerWhitespaceRule__Group_1__08645 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__1_in_rule__ScannerWhitespaceRule__Group_1__08648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ScannerWhitespaceRule__Group_1__0__Impl8676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__1__Impl_in_rule__ScannerWhitespaceRule__Group_1__18707 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__2_in_rule__ScannerWhitespaceRule__Group_1__18710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__JsMethodAssignment_1_1_in_rule__ScannerWhitespaceRule__Group_1__1__Impl8737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__2__Impl_in_rule__ScannerWhitespaceRule__Group_1__28767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ScannerWhitespaceRule__Group_1__2__Impl8795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__0__Impl_in_rule__RGBColor__Group__08832 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__1_in_rule__RGBColor__Group__08835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__RGBColor__Group__0__Impl8863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__1__Impl_in_rule__RGBColor__Group__18894 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__2_in_rule__RGBColor__Group__18897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__RGBColor__Group__1__Impl8925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__2__Impl_in_rule__RGBColor__Group__28956 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__3_in_rule__RGBColor__Group__28959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__RAssignment_2_in_rule__RGBColor__Group__2__Impl8986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__3__Impl_in_rule__RGBColor__Group__39016 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__4_in_rule__RGBColor__Group__39019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__RGBColor__Group__3__Impl9047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__4__Impl_in_rule__RGBColor__Group__49078 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__5_in_rule__RGBColor__Group__49081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__GAssignment_4_in_rule__RGBColor__Group__4__Impl9108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__5__Impl_in_rule__RGBColor__Group__59138 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__6_in_rule__RGBColor__Group__59141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__RGBColor__Group__5__Impl9169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__6__Impl_in_rule__RGBColor__Group__69200 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__7_in_rule__RGBColor__Group__69203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__BAssignment_6_in_rule__RGBColor__Group__6__Impl9230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__7__Impl_in_rule__RGBColor__Group__79260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__RGBColor__Group__7__Impl9288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__0__Impl_in_rule__Font__Group__09335 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Font__Group__1_in_rule__Font__Group__09338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__NameAssignment_0_in_rule__Font__Group__0__Impl9365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__1__Impl_in_rule__Font__Group__19395 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__Font__Group__2_in_rule__Font__Group__19398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__SizeAssignment_1_in_rule__Font__Group__1__Impl9425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__2__Impl_in_rule__Font__Group__29455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__AttributesAssignment_2_in_rule__Font__Group__2__Impl9482 = new BitSet(new long[]{0x0000000000007802L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_09524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_rule__Model__PartitionsAssignment_29555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_rule__Model__ScannerAssignment_39586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_rule__Model__PartitionerAssignment_49617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_19648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_rule__RulePartitioner__RulesAssignment_29679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JSParitioner__FileURIAssignment_19710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Scanner__PartitionAssignment_19745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_rule__Scanner__TokensAssignment_39780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_rule__Scanner__KeywordGroupsAssignment_49811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_rule__Scanner__RulesAssignment_59842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ScannerToken__DefaultAssignment_09878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerToken__NameAssignment_29917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__ScannerToken__FgColorAssignment_3_1_29948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__ScannerToken__BgColorAssignment_3_2_29979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFont_in_rule__ScannerToken__FontAssignment_3_3_210010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeywordGroup__TokenAssignment_110045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_310080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_4_110111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_010142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_110173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerSingleLineRule__TokenAssignment_110208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__StartSeqAssignment_210243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EndSeqAssignment_410274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_210305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionSingleLineRule__ParitionAssignment_110340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__StartSeqAssignment_210375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EndSeqAssignment_410406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_210437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerMultiLineRule__TokenAssignment_110472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__StartSeqAssignment_210507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EndSeqAssignment_410538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_210569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionMultiLineRule__TokenAssignment_110604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__StartSeqAssignment_210639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EndSeqAssignment_410670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_210701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerCharacterRule__TokenAssignment_110736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_310771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_510802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerJSRule__TokenAssignment_110837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerJSRule__FileURIAssignment_210872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionJSRule__TokenAssignment_110907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionJSRule__FileURIAssignment_210942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerWhitespaceRule__TokenAssignment_0_110977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_111012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_111043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_rule__ScannerWhitespaceRule__JsMethodAssignment_1_111074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__RAssignment_211105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__GAssignment_411136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__BAssignment_611167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Font__NameAssignment_011198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Font__SizeAssignment_111229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFontType_in_rule__Font__AttributesAssignment_211260 = new BitSet(new long[]{0x0000000000000002L});

}