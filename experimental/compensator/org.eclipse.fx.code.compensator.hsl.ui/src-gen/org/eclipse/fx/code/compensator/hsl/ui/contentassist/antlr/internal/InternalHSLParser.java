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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'bold'", "'italic'", "'underline'", "'strike-through'", "'{'", "'}'", "'for'", "'partition'", "'java-like-partitioner'", "'rule-partitioner'", "'js-partitioner'", "'js-damager'", "'rule-damager'", "'token'", "'fgcolor'", "':'", "'bgcolor'", "'font'", "'keywords'", "'['", "']'", "','", "'since'", "'single-line'", "'=>'", "'escaped'", "'by'", "'multi-line'", "'character-rule'", "'javascript-rule'", "'whitespace-rule'", "'#{'", "'}#'", "'rgb'", "'('", "')'", "'default'"
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
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
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


    // $ANTLR start "entryRuleJavaLikeParitioner"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:144:1: entryRuleJavaLikeParitioner : ruleJavaLikeParitioner EOF ;
    public final void entryRuleJavaLikeParitioner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:145:1: ( ruleJavaLikeParitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:146:1: ruleJavaLikeParitioner EOF
            {
             before(grammarAccess.getJavaLikeParitionerRule()); 
            pushFollow(FOLLOW_ruleJavaLikeParitioner_in_entryRuleJavaLikeParitioner241);
            ruleJavaLikeParitioner();

            state._fsp--;

             after(grammarAccess.getJavaLikeParitionerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaLikeParitioner248); 

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
    // $ANTLR end "entryRuleJavaLikeParitioner"


    // $ANTLR start "ruleJavaLikeParitioner"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:153:1: ruleJavaLikeParitioner : ( ( rule__JavaLikeParitioner__Group__0 ) ) ;
    public final void ruleJavaLikeParitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:157:2: ( ( ( rule__JavaLikeParitioner__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:158:1: ( ( rule__JavaLikeParitioner__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:158:1: ( ( rule__JavaLikeParitioner__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:159:1: ( rule__JavaLikeParitioner__Group__0 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:160:1: ( rule__JavaLikeParitioner__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:160:2: rule__JavaLikeParitioner__Group__0
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__0_in_ruleJavaLikeParitioner274);
            rule__JavaLikeParitioner__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJavaLikeParitioner"


    // $ANTLR start "entryRuleRulePartitioner"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:172:1: entryRuleRulePartitioner : ruleRulePartitioner EOF ;
    public final void entryRuleRulePartitioner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:173:1: ( ruleRulePartitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:174:1: ruleRulePartitioner EOF
            {
             before(grammarAccess.getRulePartitionerRule()); 
            pushFollow(FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner301);
            ruleRulePartitioner();

            state._fsp--;

             after(grammarAccess.getRulePartitionerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRulePartitioner308); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:181:1: ruleRulePartitioner : ( ( rule__RulePartitioner__Group__0 ) ) ;
    public final void ruleRulePartitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:185:2: ( ( ( rule__RulePartitioner__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:186:1: ( ( rule__RulePartitioner__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:186:1: ( ( rule__RulePartitioner__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:187:1: ( rule__RulePartitioner__Group__0 )
            {
             before(grammarAccess.getRulePartitionerAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:188:1: ( rule__RulePartitioner__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:188:2: rule__RulePartitioner__Group__0
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__0_in_ruleRulePartitioner334);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:200:1: entryRuleJSParitioner : ruleJSParitioner EOF ;
    public final void entryRuleJSParitioner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:201:1: ( ruleJSParitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:202:1: ruleJSParitioner EOF
            {
             before(grammarAccess.getJSParitionerRule()); 
            pushFollow(FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner361);
            ruleJSParitioner();

            state._fsp--;

             after(grammarAccess.getJSParitionerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSParitioner368); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:209:1: ruleJSParitioner : ( ( rule__JSParitioner__Group__0 ) ) ;
    public final void ruleJSParitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:213:2: ( ( ( rule__JSParitioner__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:214:1: ( ( rule__JSParitioner__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:214:1: ( ( rule__JSParitioner__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:215:1: ( rule__JSParitioner__Group__0 )
            {
             before(grammarAccess.getJSParitionerAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:216:1: ( rule__JSParitioner__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:216:2: rule__JSParitioner__Group__0
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__0_in_ruleJSParitioner394);
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


    // $ANTLR start "entryRuleDamager"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:228:1: entryRuleDamager : ruleDamager EOF ;
    public final void entryRuleDamager() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:229:1: ( ruleDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:230:1: ruleDamager EOF
            {
             before(grammarAccess.getDamagerRule()); 
            pushFollow(FOLLOW_ruleDamager_in_entryRuleDamager421);
            ruleDamager();

            state._fsp--;

             after(grammarAccess.getDamagerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDamager428); 

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
    // $ANTLR end "entryRuleDamager"


    // $ANTLR start "ruleDamager"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:237:1: ruleDamager : ( ( rule__Damager__Alternatives ) ) ;
    public final void ruleDamager() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:241:2: ( ( ( rule__Damager__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:242:1: ( ( rule__Damager__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:242:1: ( ( rule__Damager__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:243:1: ( rule__Damager__Alternatives )
            {
             before(grammarAccess.getDamagerAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:244:1: ( rule__Damager__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:244:2: rule__Damager__Alternatives
            {
            pushFollow(FOLLOW_rule__Damager__Alternatives_in_ruleDamager454);
            rule__Damager__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDamagerAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDamager"


    // $ANTLR start "entryRuleJSDamager"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:256:1: entryRuleJSDamager : ruleJSDamager EOF ;
    public final void entryRuleJSDamager() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:257:1: ( ruleJSDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:258:1: ruleJSDamager EOF
            {
             before(grammarAccess.getJSDamagerRule()); 
            pushFollow(FOLLOW_ruleJSDamager_in_entryRuleJSDamager481);
            ruleJSDamager();

            state._fsp--;

             after(grammarAccess.getJSDamagerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSDamager488); 

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
    // $ANTLR end "entryRuleJSDamager"


    // $ANTLR start "ruleJSDamager"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:265:1: ruleJSDamager : ( ( rule__JSDamager__Group__0 ) ) ;
    public final void ruleJSDamager() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:269:2: ( ( ( rule__JSDamager__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:270:1: ( ( rule__JSDamager__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:270:1: ( ( rule__JSDamager__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:271:1: ( rule__JSDamager__Group__0 )
            {
             before(grammarAccess.getJSDamagerAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:272:1: ( rule__JSDamager__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:272:2: rule__JSDamager__Group__0
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__0_in_ruleJSDamager514);
            rule__JSDamager__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJSDamagerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJSDamager"


    // $ANTLR start "entryRuleRuleDamager"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:284:1: entryRuleRuleDamager : ruleRuleDamager EOF ;
    public final void entryRuleRuleDamager() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:285:1: ( ruleRuleDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:286:1: ruleRuleDamager EOF
            {
             before(grammarAccess.getRuleDamagerRule()); 
            pushFollow(FOLLOW_ruleRuleDamager_in_entryRuleRuleDamager541);
            ruleRuleDamager();

            state._fsp--;

             after(grammarAccess.getRuleDamagerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDamager548); 

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
    // $ANTLR end "entryRuleRuleDamager"


    // $ANTLR start "ruleRuleDamager"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:293:1: ruleRuleDamager : ( ( rule__RuleDamager__Group__0 ) ) ;
    public final void ruleRuleDamager() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:297:2: ( ( ( rule__RuleDamager__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:298:1: ( ( rule__RuleDamager__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:298:1: ( ( rule__RuleDamager__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:299:1: ( rule__RuleDamager__Group__0 )
            {
             before(grammarAccess.getRuleDamagerAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:300:1: ( rule__RuleDamager__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:300:2: rule__RuleDamager__Group__0
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__0_in_ruleRuleDamager574);
            rule__RuleDamager__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleDamagerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleDamager"


    // $ANTLR start "entryRuleScannerToken"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:312:1: entryRuleScannerToken : ruleScannerToken EOF ;
    public final void entryRuleScannerToken() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:313:1: ( ruleScannerToken EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:314:1: ruleScannerToken EOF
            {
             before(grammarAccess.getScannerTokenRule()); 
            pushFollow(FOLLOW_ruleScannerToken_in_entryRuleScannerToken601);
            ruleScannerToken();

            state._fsp--;

             after(grammarAccess.getScannerTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerToken608); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:321:1: ruleScannerToken : ( ( rule__ScannerToken__Group__0 ) ) ;
    public final void ruleScannerToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:325:2: ( ( ( rule__ScannerToken__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:326:1: ( ( rule__ScannerToken__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:326:1: ( ( rule__ScannerToken__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:327:1: ( rule__ScannerToken__Group__0 )
            {
             before(grammarAccess.getScannerTokenAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:328:1: ( rule__ScannerToken__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:328:2: rule__ScannerToken__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__0_in_ruleScannerToken634);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:340:1: entryRuleKeywordGroup : ruleKeywordGroup EOF ;
    public final void entryRuleKeywordGroup() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:341:1: ( ruleKeywordGroup EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:342:1: ruleKeywordGroup EOF
            {
             before(grammarAccess.getKeywordGroupRule()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup661);
            ruleKeywordGroup();

            state._fsp--;

             after(grammarAccess.getKeywordGroupRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordGroup668); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:349:1: ruleKeywordGroup : ( ( rule__KeywordGroup__Group__0 ) ) ;
    public final void ruleKeywordGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:353:2: ( ( ( rule__KeywordGroup__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:354:1: ( ( rule__KeywordGroup__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:354:1: ( ( rule__KeywordGroup__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:355:1: ( rule__KeywordGroup__Group__0 )
            {
             before(grammarAccess.getKeywordGroupAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:356:1: ( rule__KeywordGroup__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:356:2: rule__KeywordGroup__Group__0
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__0_in_ruleKeywordGroup694);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:368:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:369:1: ( ruleKeyword EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:370:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword721);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword728); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:377:1: ruleKeyword : ( ( rule__Keyword__Group__0 ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:381:2: ( ( ( rule__Keyword__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:382:1: ( ( rule__Keyword__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:382:1: ( ( rule__Keyword__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:383:1: ( rule__Keyword__Group__0 )
            {
             before(grammarAccess.getKeywordAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:384:1: ( rule__Keyword__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:384:2: rule__Keyword__Group__0
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0_in_ruleKeyword754);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:396:1: entryRuleScannerRule : ruleScannerRule EOF ;
    public final void entryRuleScannerRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:397:1: ( ruleScannerRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:398:1: ruleScannerRule EOF
            {
             before(grammarAccess.getScannerRuleRule()); 
            pushFollow(FOLLOW_ruleScannerRule_in_entryRuleScannerRule781);
            ruleScannerRule();

            state._fsp--;

             after(grammarAccess.getScannerRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerRule788); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:405:1: ruleScannerRule : ( ( rule__ScannerRule__Alternatives ) ) ;
    public final void ruleScannerRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:409:2: ( ( ( rule__ScannerRule__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:410:1: ( ( rule__ScannerRule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:410:1: ( ( rule__ScannerRule__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:411:1: ( rule__ScannerRule__Alternatives )
            {
             before(grammarAccess.getScannerRuleAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:412:1: ( rule__ScannerRule__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:412:2: rule__ScannerRule__Alternatives
            {
            pushFollow(FOLLOW_rule__ScannerRule__Alternatives_in_ruleScannerRule814);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:424:1: entryRuleParitionRule : ruleParitionRule EOF ;
    public final void entryRuleParitionRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:425:1: ( ruleParitionRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:426:1: ruleParitionRule EOF
            {
             before(grammarAccess.getParitionRuleRule()); 
            pushFollow(FOLLOW_ruleParitionRule_in_entryRuleParitionRule841);
            ruleParitionRule();

            state._fsp--;

             after(grammarAccess.getParitionRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitionRule848); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:433:1: ruleParitionRule : ( ( rule__ParitionRule__Alternatives ) ) ;
    public final void ruleParitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:437:2: ( ( ( rule__ParitionRule__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:438:1: ( ( rule__ParitionRule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:438:1: ( ( rule__ParitionRule__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:439:1: ( rule__ParitionRule__Alternatives )
            {
             before(grammarAccess.getParitionRuleAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:440:1: ( rule__ParitionRule__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:440:2: rule__ParitionRule__Alternatives
            {
            pushFollow(FOLLOW_rule__ParitionRule__Alternatives_in_ruleParitionRule874);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:452:1: entryRuleScannerSingleLineRule : ruleScannerSingleLineRule EOF ;
    public final void entryRuleScannerSingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:453:1: ( ruleScannerSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:454:1: ruleScannerSingleLineRule EOF
            {
             before(grammarAccess.getScannerSingleLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule901);
            ruleScannerSingleLineRule();

            state._fsp--;

             after(grammarAccess.getScannerSingleLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerSingleLineRule908); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:461:1: ruleScannerSingleLineRule : ( ( rule__ScannerSingleLineRule__Group__0 ) ) ;
    public final void ruleScannerSingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:465:2: ( ( ( rule__ScannerSingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:466:1: ( ( rule__ScannerSingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:466:1: ( ( rule__ScannerSingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:467:1: ( rule__ScannerSingleLineRule__Group__0 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:468:1: ( rule__ScannerSingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:468:2: rule__ScannerSingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__0_in_ruleScannerSingleLineRule934);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:480:1: entryRulePartitionSingleLineRule : rulePartitionSingleLineRule EOF ;
    public final void entryRulePartitionSingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:481:1: ( rulePartitionSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:482:1: rulePartitionSingleLineRule EOF
            {
             before(grammarAccess.getPartitionSingleLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule961);
            rulePartitionSingleLineRule();

            state._fsp--;

             after(grammarAccess.getPartitionSingleLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionSingleLineRule968); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:489:1: rulePartitionSingleLineRule : ( ( rule__PartitionSingleLineRule__Group__0 ) ) ;
    public final void rulePartitionSingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:493:2: ( ( ( rule__PartitionSingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:494:1: ( ( rule__PartitionSingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:494:1: ( ( rule__PartitionSingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:495:1: ( rule__PartitionSingleLineRule__Group__0 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:496:1: ( rule__PartitionSingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:496:2: rule__PartitionSingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__0_in_rulePartitionSingleLineRule994);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:508:1: entryRuleScannerMultiLineRule : ruleScannerMultiLineRule EOF ;
    public final void entryRuleScannerMultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:509:1: ( ruleScannerMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:510:1: ruleScannerMultiLineRule EOF
            {
             before(grammarAccess.getScannerMultiLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule1021);
            ruleScannerMultiLineRule();

            state._fsp--;

             after(grammarAccess.getScannerMultiLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerMultiLineRule1028); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:517:1: ruleScannerMultiLineRule : ( ( rule__ScannerMultiLineRule__Group__0 ) ) ;
    public final void ruleScannerMultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:521:2: ( ( ( rule__ScannerMultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:522:1: ( ( rule__ScannerMultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:522:1: ( ( rule__ScannerMultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:523:1: ( rule__ScannerMultiLineRule__Group__0 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:524:1: ( rule__ScannerMultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:524:2: rule__ScannerMultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__0_in_ruleScannerMultiLineRule1054);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:536:1: entryRulePartitionMultiLineRule : rulePartitionMultiLineRule EOF ;
    public final void entryRulePartitionMultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:537:1: ( rulePartitionMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:538:1: rulePartitionMultiLineRule EOF
            {
             before(grammarAccess.getPartitionMultiLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule1081);
            rulePartitionMultiLineRule();

            state._fsp--;

             after(grammarAccess.getPartitionMultiLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionMultiLineRule1088); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:545:1: rulePartitionMultiLineRule : ( ( rule__PartitionMultiLineRule__Group__0 ) ) ;
    public final void rulePartitionMultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:549:2: ( ( ( rule__PartitionMultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:550:1: ( ( rule__PartitionMultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:550:1: ( ( rule__PartitionMultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:551:1: ( rule__PartitionMultiLineRule__Group__0 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:552:1: ( rule__PartitionMultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:552:2: rule__PartitionMultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__0_in_rulePartitionMultiLineRule1114);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:564:1: entryRuleScannerCharacterRule : ruleScannerCharacterRule EOF ;
    public final void entryRuleScannerCharacterRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:565:1: ( ruleScannerCharacterRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:566:1: ruleScannerCharacterRule EOF
            {
             before(grammarAccess.getScannerCharacterRuleRule()); 
            pushFollow(FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule1141);
            ruleScannerCharacterRule();

            state._fsp--;

             after(grammarAccess.getScannerCharacterRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerCharacterRule1148); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:573:1: ruleScannerCharacterRule : ( ( rule__ScannerCharacterRule__Group__0 ) ) ;
    public final void ruleScannerCharacterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:577:2: ( ( ( rule__ScannerCharacterRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:578:1: ( ( rule__ScannerCharacterRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:578:1: ( ( rule__ScannerCharacterRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:579:1: ( rule__ScannerCharacterRule__Group__0 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:580:1: ( rule__ScannerCharacterRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:580:2: rule__ScannerCharacterRule__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__0_in_ruleScannerCharacterRule1174);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:592:1: entryRuleScannerJSRule : ruleScannerJSRule EOF ;
    public final void entryRuleScannerJSRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:593:1: ( ruleScannerJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:594:1: ruleScannerJSRule EOF
            {
             before(grammarAccess.getScannerJSRuleRule()); 
            pushFollow(FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule1201);
            ruleScannerJSRule();

            state._fsp--;

             after(grammarAccess.getScannerJSRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerJSRule1208); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:601:1: ruleScannerJSRule : ( ( rule__ScannerJSRule__Group__0 ) ) ;
    public final void ruleScannerJSRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:605:2: ( ( ( rule__ScannerJSRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:606:1: ( ( rule__ScannerJSRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:606:1: ( ( rule__ScannerJSRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:607:1: ( rule__ScannerJSRule__Group__0 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:608:1: ( rule__ScannerJSRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:608:2: rule__ScannerJSRule__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__0_in_ruleScannerJSRule1234);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:620:1: entryRulePartitionJSRule : rulePartitionJSRule EOF ;
    public final void entryRulePartitionJSRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:621:1: ( rulePartitionJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:622:1: rulePartitionJSRule EOF
            {
             before(grammarAccess.getPartitionJSRuleRule()); 
            pushFollow(FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule1261);
            rulePartitionJSRule();

            state._fsp--;

             after(grammarAccess.getPartitionJSRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionJSRule1268); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:629:1: rulePartitionJSRule : ( ( rule__PartitionJSRule__Group__0 ) ) ;
    public final void rulePartitionJSRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:633:2: ( ( ( rule__PartitionJSRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:634:1: ( ( rule__PartitionJSRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:634:1: ( ( rule__PartitionJSRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:635:1: ( rule__PartitionJSRule__Group__0 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:636:1: ( rule__PartitionJSRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:636:2: rule__PartitionJSRule__Group__0
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__0_in_rulePartitionJSRule1294);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:648:1: entryRuleScannerWhitespaceRule : ruleScannerWhitespaceRule EOF ;
    public final void entryRuleScannerWhitespaceRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:649:1: ( ruleScannerWhitespaceRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:650:1: ruleScannerWhitespaceRule EOF
            {
             before(grammarAccess.getScannerWhitespaceRuleRule()); 
            pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule1321);
            ruleScannerWhitespaceRule();

            state._fsp--;

             after(grammarAccess.getScannerWhitespaceRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerWhitespaceRule1328); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:657:1: ruleScannerWhitespaceRule : ( ( rule__ScannerWhitespaceRule__Alternatives ) ) ;
    public final void ruleScannerWhitespaceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:661:2: ( ( ( rule__ScannerWhitespaceRule__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:662:1: ( ( rule__ScannerWhitespaceRule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:662:1: ( ( rule__ScannerWhitespaceRule__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:663:1: ( rule__ScannerWhitespaceRule__Alternatives )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:664:1: ( rule__ScannerWhitespaceRule__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:664:2: rule__ScannerWhitespaceRule__Alternatives
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Alternatives_in_ruleScannerWhitespaceRule1354);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:676:1: entryRuleColor : ruleColor EOF ;
    public final void entryRuleColor() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:677:1: ( ruleColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:678:1: ruleColor EOF
            {
             before(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor1381);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getColorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor1388); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:685:1: ruleColor : ( ruleRGBColor ) ;
    public final void ruleColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:689:2: ( ( ruleRGBColor ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:690:1: ( ruleRGBColor )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:690:1: ( ruleRGBColor )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:691:1: ruleRGBColor
            {
             before(grammarAccess.getColorAccess().getRGBColorParserRuleCall()); 
            pushFollow(FOLLOW_ruleRGBColor_in_ruleColor1414);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:704:1: entryRuleRGBColor : ruleRGBColor EOF ;
    public final void entryRuleRGBColor() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:705:1: ( ruleRGBColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:706:1: ruleRGBColor EOF
            {
             before(grammarAccess.getRGBColorRule()); 
            pushFollow(FOLLOW_ruleRGBColor_in_entryRuleRGBColor1440);
            ruleRGBColor();

            state._fsp--;

             after(grammarAccess.getRGBColorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGBColor1447); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:713:1: ruleRGBColor : ( ( rule__RGBColor__Group__0 ) ) ;
    public final void ruleRGBColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:717:2: ( ( ( rule__RGBColor__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:718:1: ( ( rule__RGBColor__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:718:1: ( ( rule__RGBColor__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:719:1: ( rule__RGBColor__Group__0 )
            {
             before(grammarAccess.getRGBColorAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:720:1: ( rule__RGBColor__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:720:2: rule__RGBColor__Group__0
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__0_in_ruleRGBColor1473);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:732:1: entryRuleFont : ruleFont EOF ;
    public final void entryRuleFont() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:733:1: ( ruleFont EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:734:1: ruleFont EOF
            {
             before(grammarAccess.getFontRule()); 
            pushFollow(FOLLOW_ruleFont_in_entryRuleFont1500);
            ruleFont();

            state._fsp--;

             after(grammarAccess.getFontRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFont1507); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:741:1: ruleFont : ( ( rule__Font__Group__0 ) ) ;
    public final void ruleFont() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:745:2: ( ( ( rule__Font__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:746:1: ( ( rule__Font__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:746:1: ( ( rule__Font__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:747:1: ( rule__Font__Group__0 )
            {
             before(grammarAccess.getFontAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:748:1: ( rule__Font__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:748:2: rule__Font__Group__0
            {
            pushFollow(FOLLOW_rule__Font__Group__0_in_ruleFont1533);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:761:1: ruleFontType : ( ( rule__FontType__Alternatives ) ) ;
    public final void ruleFontType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:765:1: ( ( ( rule__FontType__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:766:1: ( ( rule__FontType__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:766:1: ( ( rule__FontType__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:767:1: ( rule__FontType__Alternatives )
            {
             before(grammarAccess.getFontTypeAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:768:1: ( rule__FontType__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:768:2: rule__FontType__Alternatives
            {
            pushFollow(FOLLOW_rule__FontType__Alternatives_in_ruleFontType1570);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:779:1: rule__Partitioner__Alternatives : ( ( ruleRulePartitioner ) | ( ruleJavaLikeParitioner ) | ( ruleJSParitioner ) );
    public final void rule__Partitioner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:783:1: ( ( ruleRulePartitioner ) | ( ruleJavaLikeParitioner ) | ( ruleJSParitioner ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt1=1;
                }
                break;
            case 19:
                {
                alt1=2;
                }
                break;
            case 21:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:784:1: ( ruleRulePartitioner )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:784:1: ( ruleRulePartitioner )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:785:1: ruleRulePartitioner
                    {
                     before(grammarAccess.getPartitionerAccess().getRulePartitionerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRulePartitioner_in_rule__Partitioner__Alternatives1605);
                    ruleRulePartitioner();

                    state._fsp--;

                     after(grammarAccess.getPartitionerAccess().getRulePartitionerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:790:6: ( ruleJavaLikeParitioner )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:790:6: ( ruleJavaLikeParitioner )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:791:1: ruleJavaLikeParitioner
                    {
                     before(grammarAccess.getPartitionerAccess().getJavaLikeParitionerParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleJavaLikeParitioner_in_rule__Partitioner__Alternatives1622);
                    ruleJavaLikeParitioner();

                    state._fsp--;

                     after(grammarAccess.getPartitionerAccess().getJavaLikeParitionerParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:796:6: ( ruleJSParitioner )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:796:6: ( ruleJSParitioner )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:797:1: ruleJSParitioner
                    {
                     before(grammarAccess.getPartitionerAccess().getJSParitionerParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleJSParitioner_in_rule__Partitioner__Alternatives1639);
                    ruleJSParitioner();

                    state._fsp--;

                     after(grammarAccess.getPartitionerAccess().getJSParitionerParserRuleCall_2()); 

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


    // $ANTLR start "rule__Damager__Alternatives"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:807:1: rule__Damager__Alternatives : ( ( ruleRuleDamager ) | ( ruleJSDamager ) );
    public final void rule__Damager__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:811:1: ( ( ruleRuleDamager ) | ( ruleJSDamager ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==23) ) {
                alt2=1;
            }
            else if ( (LA2_0==22) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:812:1: ( ruleRuleDamager )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:812:1: ( ruleRuleDamager )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:813:1: ruleRuleDamager
                    {
                     before(grammarAccess.getDamagerAccess().getRuleDamagerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRuleDamager_in_rule__Damager__Alternatives1671);
                    ruleRuleDamager();

                    state._fsp--;

                     after(grammarAccess.getDamagerAccess().getRuleDamagerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:818:6: ( ruleJSDamager )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:818:6: ( ruleJSDamager )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:819:1: ruleJSDamager
                    {
                     before(grammarAccess.getDamagerAccess().getJSDamagerParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleJSDamager_in_rule__Damager__Alternatives1688);
                    ruleJSDamager();

                    state._fsp--;

                     after(grammarAccess.getDamagerAccess().getJSDamagerParserRuleCall_1()); 

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
    // $ANTLR end "rule__Damager__Alternatives"


    // $ANTLR start "rule__ScannerRule__Alternatives"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:829:1: rule__ScannerRule__Alternatives : ( ( ruleScannerSingleLineRule ) | ( ruleScannerMultiLineRule ) | ( ruleScannerCharacterRule ) | ( ruleScannerJSRule ) | ( ruleScannerWhitespaceRule ) );
    public final void rule__ScannerRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:833:1: ( ( ruleScannerSingleLineRule ) | ( ruleScannerMultiLineRule ) | ( ruleScannerCharacterRule ) | ( ruleScannerJSRule ) | ( ruleScannerWhitespaceRule ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt3=1;
                }
                break;
            case 38:
                {
                alt3=2;
                }
                break;
            case 39:
                {
                alt3=3;
                }
                break;
            case 40:
                {
                alt3=4;
                }
                break;
            case 41:
            case 42:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:834:1: ( ruleScannerSingleLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:834:1: ( ruleScannerSingleLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:835:1: ruleScannerSingleLineRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleScannerSingleLineRule_in_rule__ScannerRule__Alternatives1720);
                    ruleScannerSingleLineRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:840:6: ( ruleScannerMultiLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:840:6: ( ruleScannerMultiLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:841:1: ruleScannerMultiLineRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleScannerMultiLineRule_in_rule__ScannerRule__Alternatives1737);
                    ruleScannerMultiLineRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:846:6: ( ruleScannerCharacterRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:846:6: ( ruleScannerCharacterRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:847:1: ruleScannerCharacterRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleScannerCharacterRule_in_rule__ScannerRule__Alternatives1754);
                    ruleScannerCharacterRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:852:6: ( ruleScannerJSRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:852:6: ( ruleScannerJSRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:853:1: ruleScannerJSRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleScannerJSRule_in_rule__ScannerRule__Alternatives1771);
                    ruleScannerJSRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:858:6: ( ruleScannerWhitespaceRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:858:6: ( ruleScannerWhitespaceRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:859:1: ruleScannerWhitespaceRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerWhitespaceRuleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_rule__ScannerRule__Alternatives1788);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:869:1: rule__ParitionRule__Alternatives : ( ( rulePartitionSingleLineRule ) | ( rulePartitionMultiLineRule ) | ( rulePartitionJSRule ) );
    public final void rule__ParitionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:873:1: ( ( rulePartitionSingleLineRule ) | ( rulePartitionMultiLineRule ) | ( rulePartitionJSRule ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt4=1;
                }
                break;
            case 38:
                {
                alt4=2;
                }
                break;
            case 40:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:874:1: ( rulePartitionSingleLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:874:1: ( rulePartitionSingleLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:875:1: rulePartitionSingleLineRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePartitionSingleLineRule_in_rule__ParitionRule__Alternatives1820);
                    rulePartitionSingleLineRule();

                    state._fsp--;

                     after(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:880:6: ( rulePartitionMultiLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:880:6: ( rulePartitionMultiLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:881:1: rulePartitionMultiLineRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_rulePartitionMultiLineRule_in_rule__ParitionRule__Alternatives1837);
                    rulePartitionMultiLineRule();

                    state._fsp--;

                     after(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:886:6: ( rulePartitionJSRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:886:6: ( rulePartitionJSRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:887:1: rulePartitionJSRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionJSRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_rulePartitionJSRule_in_rule__ParitionRule__Alternatives1854);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:897:1: rule__ScannerWhitespaceRule__Alternatives : ( ( ( rule__ScannerWhitespaceRule__Group_0__0 ) ) | ( ( rule__ScannerWhitespaceRule__Group_1__0 ) ) );
    public final void rule__ScannerWhitespaceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:901:1: ( ( ( rule__ScannerWhitespaceRule__Group_0__0 ) ) | ( ( rule__ScannerWhitespaceRule__Group_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==41) ) {
                alt5=1;
            }
            else if ( (LA5_0==42) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:902:1: ( ( rule__ScannerWhitespaceRule__Group_0__0 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:902:1: ( ( rule__ScannerWhitespaceRule__Group_0__0 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:903:1: ( rule__ScannerWhitespaceRule__Group_0__0 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_0()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:904:1: ( rule__ScannerWhitespaceRule__Group_0__0 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:904:2: rule__ScannerWhitespaceRule__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__0_in_rule__ScannerWhitespaceRule__Alternatives1886);
                    rule__ScannerWhitespaceRule__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:908:6: ( ( rule__ScannerWhitespaceRule__Group_1__0 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:908:6: ( ( rule__ScannerWhitespaceRule__Group_1__0 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:909:1: ( rule__ScannerWhitespaceRule__Group_1__0 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_1()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:910:1: ( rule__ScannerWhitespaceRule__Group_1__0 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:910:2: rule__ScannerWhitespaceRule__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__0_in_rule__ScannerWhitespaceRule__Alternatives1904);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:919:1: rule__FontType__Alternatives : ( ( ( 'bold' ) ) | ( ( 'italic' ) ) | ( ( 'underline' ) ) | ( ( 'strike-through' ) ) );
    public final void rule__FontType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:923:1: ( ( ( 'bold' ) ) | ( ( 'italic' ) ) | ( ( 'underline' ) ) | ( ( 'strike-through' ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt6=1;
                }
                break;
            case 12:
                {
                alt6=2;
                }
                break;
            case 13:
                {
                alt6=3;
                }
                break;
            case 14:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:924:1: ( ( 'bold' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:924:1: ( ( 'bold' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:925:1: ( 'bold' )
                    {
                     before(grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:926:1: ( 'bold' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:926:3: 'bold'
                    {
                    match(input,11,FOLLOW_11_in_rule__FontType__Alternatives1938); 

                    }

                     after(grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:931:6: ( ( 'italic' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:931:6: ( ( 'italic' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:932:1: ( 'italic' )
                    {
                     before(grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:933:1: ( 'italic' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:933:3: 'italic'
                    {
                    match(input,12,FOLLOW_12_in_rule__FontType__Alternatives1959); 

                    }

                     after(grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:938:6: ( ( 'underline' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:938:6: ( ( 'underline' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:939:1: ( 'underline' )
                    {
                     before(grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:940:1: ( 'underline' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:940:3: 'underline'
                    {
                    match(input,13,FOLLOW_13_in_rule__FontType__Alternatives1980); 

                    }

                     after(grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:945:6: ( ( 'strike-through' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:945:6: ( ( 'strike-through' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:946:1: ( 'strike-through' )
                    {
                     before(grammarAccess.getFontTypeAccess().getStrike_throughEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:947:1: ( 'strike-through' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:947:3: 'strike-through'
                    {
                    match(input,14,FOLLOW_14_in_rule__FontType__Alternatives2001); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:959:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:963:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:964:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02034);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02037);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:971:1: rule__Model__Group__0__Impl : ( ( rule__Model__NameAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:975:1: ( ( ( rule__Model__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:976:1: ( ( rule__Model__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:976:1: ( ( rule__Model__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:977:1: ( rule__Model__NameAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:978:1: ( rule__Model__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:978:2: rule__Model__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__NameAssignment_0_in_rule__Model__Group__0__Impl2064);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:988:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:992:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:993:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12094);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12097);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1000:1: rule__Model__Group__1__Impl : ( '{' ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1004:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1005:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1005:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1006:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__Model__Group__1__Impl2125); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1019:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1023:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1024:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22156);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__22159);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1031:1: rule__Model__Group__2__Impl : ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1035:1: ( ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1036:1: ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1036:1: ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1037:1: ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1037:1: ( ( rule__Model__PartitionsAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1038:1: ( rule__Model__PartitionsAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1039:1: ( rule__Model__PartitionsAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1039:2: rule__Model__PartitionsAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2188);
            rule__Model__PartitionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1042:1: ( ( rule__Model__PartitionsAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1043:1: ( rule__Model__PartitionsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1044:1: ( rule__Model__PartitionsAssignment_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1044:2: rule__Model__PartitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2200);
            	    rule__Model__PartitionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1055:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1059:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1060:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__32233);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__4_in_rule__Model__Group__32236);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1067:1: rule__Model__Group__3__Impl : ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1071:1: ( ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1072:1: ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1072:1: ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1073:1: ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1073:1: ( ( rule__Model__DamagersAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1074:1: ( rule__Model__DamagersAssignment_3 )
            {
             before(grammarAccess.getModelAccess().getDamagersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1075:1: ( rule__Model__DamagersAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1075:2: rule__Model__DamagersAssignment_3
            {
            pushFollow(FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2265);
            rule__Model__DamagersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDamagersAssignment_3()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1078:1: ( ( rule__Model__DamagersAssignment_3 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1079:1: ( rule__Model__DamagersAssignment_3 )*
            {
             before(grammarAccess.getModelAccess().getDamagersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1080:1: ( rule__Model__DamagersAssignment_3 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=22 && LA8_0<=23)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1080:2: rule__Model__DamagersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2277);
            	    rule__Model__DamagersAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getDamagersAssignment_3()); 

            }


            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1091:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1095:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1096:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__42310);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__5_in_rule__Model__Group__42313);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1103:1: rule__Model__Group__4__Impl : ( ( rule__Model__PartitionerAssignment_4 ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1107:1: ( ( ( rule__Model__PartitionerAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1108:1: ( ( rule__Model__PartitionerAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1108:1: ( ( rule__Model__PartitionerAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1109:1: ( rule__Model__PartitionerAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getPartitionerAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1110:1: ( rule__Model__PartitionerAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1110:2: rule__Model__PartitionerAssignment_4
            {
            pushFollow(FOLLOW_rule__Model__PartitionerAssignment_4_in_rule__Model__Group__4__Impl2340);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1120:1: rule__Model__Group__5 : rule__Model__Group__5__Impl rule__Model__Group__6 ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1124:1: ( rule__Model__Group__5__Impl rule__Model__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1125:2: rule__Model__Group__5__Impl rule__Model__Group__6
            {
            pushFollow(FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__52370);
            rule__Model__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__6_in_rule__Model__Group__52373);
            rule__Model__Group__6();

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1132:1: rule__Model__Group__5__Impl : ( '}' ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1136:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1137:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1137:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1138:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,16,FOLLOW_16_in_rule__Model__Group__5__Impl2401); 
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


    // $ANTLR start "rule__Model__Group__6"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1151:1: rule__Model__Group__6 : rule__Model__Group__6__Impl rule__Model__Group__7 ;
    public final void rule__Model__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1155:1: ( rule__Model__Group__6__Impl rule__Model__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1156:2: rule__Model__Group__6__Impl rule__Model__Group__7
            {
            pushFollow(FOLLOW_rule__Model__Group__6__Impl_in_rule__Model__Group__62432);
            rule__Model__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__7_in_rule__Model__Group__62435);
            rule__Model__Group__7();

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
    // $ANTLR end "rule__Model__Group__6"


    // $ANTLR start "rule__Model__Group__6__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1163:1: rule__Model__Group__6__Impl : ( 'for' ) ;
    public final void rule__Model__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1167:1: ( ( 'for' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1168:1: ( 'for' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1168:1: ( 'for' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1169:1: 'for'
            {
             before(grammarAccess.getModelAccess().getForKeyword_6()); 
            match(input,17,FOLLOW_17_in_rule__Model__Group__6__Impl2463); 
             after(grammarAccess.getModelAccess().getForKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__6__Impl"


    // $ANTLR start "rule__Model__Group__7"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1182:1: rule__Model__Group__7 : rule__Model__Group__7__Impl ;
    public final void rule__Model__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1186:1: ( rule__Model__Group__7__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1187:2: rule__Model__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__7__Impl_in_rule__Model__Group__72494);
            rule__Model__Group__7__Impl();

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
    // $ANTLR end "rule__Model__Group__7"


    // $ANTLR start "rule__Model__Group__7__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1193:1: rule__Model__Group__7__Impl : ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) ) ;
    public final void rule__Model__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1197:1: ( ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1198:1: ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1198:1: ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1199:1: ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1199:1: ( ( rule__Model__ContentTypesAssignment_7 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1200:1: ( rule__Model__ContentTypesAssignment_7 )
            {
             before(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1201:1: ( rule__Model__ContentTypesAssignment_7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1201:2: rule__Model__ContentTypesAssignment_7
            {
            pushFollow(FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2523);
            rule__Model__ContentTypesAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1204:1: ( ( rule__Model__ContentTypesAssignment_7 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1205:1: ( rule__Model__ContentTypesAssignment_7 )*
            {
             before(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1206:1: ( rule__Model__ContentTypesAssignment_7 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_STRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1206:2: rule__Model__ContentTypesAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2535);
            	    rule__Model__ContentTypesAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__7__Impl"


    // $ANTLR start "rule__Partition__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1233:1: rule__Partition__Group__0 : rule__Partition__Group__0__Impl rule__Partition__Group__1 ;
    public final void rule__Partition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1237:1: ( rule__Partition__Group__0__Impl rule__Partition__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1238:2: rule__Partition__Group__0__Impl rule__Partition__Group__1
            {
            pushFollow(FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__02584);
            rule__Partition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__02587);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1245:1: rule__Partition__Group__0__Impl : ( 'partition' ) ;
    public final void rule__Partition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1249:1: ( ( 'partition' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1250:1: ( 'partition' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1250:1: ( 'partition' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1251:1: 'partition'
            {
             before(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__Partition__Group__0__Impl2615); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1264:1: rule__Partition__Group__1 : rule__Partition__Group__1__Impl ;
    public final void rule__Partition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1268:1: ( rule__Partition__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1269:2: rule__Partition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__12646);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1275:1: rule__Partition__Group__1__Impl : ( ( rule__Partition__NameAssignment_1 ) ) ;
    public final void rule__Partition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1279:1: ( ( ( rule__Partition__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1280:1: ( ( rule__Partition__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1280:1: ( ( rule__Partition__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1281:1: ( rule__Partition__NameAssignment_1 )
            {
             before(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1282:1: ( rule__Partition__NameAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1282:2: rule__Partition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl2673);
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


    // $ANTLR start "rule__JavaLikeParitioner__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1296:1: rule__JavaLikeParitioner__Group__0 : rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1 ;
    public final void rule__JavaLikeParitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1300:1: ( rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1301:2: rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__0__Impl_in_rule__JavaLikeParitioner__Group__02707);
            rule__JavaLikeParitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__1_in_rule__JavaLikeParitioner__Group__02710);
            rule__JavaLikeParitioner__Group__1();

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
    // $ANTLR end "rule__JavaLikeParitioner__Group__0"


    // $ANTLR start "rule__JavaLikeParitioner__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1308:1: rule__JavaLikeParitioner__Group__0__Impl : ( 'java-like-partitioner' ) ;
    public final void rule__JavaLikeParitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1312:1: ( ( 'java-like-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1313:1: ( 'java-like-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1313:1: ( 'java-like-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1314:1: 'java-like-partitioner'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaLikePartitionerKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__JavaLikeParitioner__Group__0__Impl2738); 
             after(grammarAccess.getJavaLikeParitionerAccess().getJavaLikePartitionerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__0__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1327:1: rule__JavaLikeParitioner__Group__1 : rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2 ;
    public final void rule__JavaLikeParitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1331:1: ( rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1332:2: rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__1__Impl_in_rule__JavaLikeParitioner__Group__12769);
            rule__JavaLikeParitioner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__2_in_rule__JavaLikeParitioner__Group__12772);
            rule__JavaLikeParitioner__Group__2();

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
    // $ANTLR end "rule__JavaLikeParitioner__Group__1"


    // $ANTLR start "rule__JavaLikeParitioner__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1339:1: rule__JavaLikeParitioner__Group__1__Impl : ( '{' ) ;
    public final void rule__JavaLikeParitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1343:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1344:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1344:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1345:1: '{'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__JavaLikeParitioner__Group__1__Impl2800); 
             after(grammarAccess.getJavaLikeParitionerAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__1__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1358:1: rule__JavaLikeParitioner__Group__2 : rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3 ;
    public final void rule__JavaLikeParitioner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1362:1: ( rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1363:2: rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__2__Impl_in_rule__JavaLikeParitioner__Group__22831);
            rule__JavaLikeParitioner__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__3_in_rule__JavaLikeParitioner__Group__22834);
            rule__JavaLikeParitioner__Group__3();

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
    // $ANTLR end "rule__JavaLikeParitioner__Group__2"


    // $ANTLR start "rule__JavaLikeParitioner__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1370:1: rule__JavaLikeParitioner__Group__2__Impl : ( ( rule__JavaLikeParitioner__SingleLineParitionAssignment_2 ) ) ;
    public final void rule__JavaLikeParitioner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1374:1: ( ( ( rule__JavaLikeParitioner__SingleLineParitionAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1375:1: ( ( rule__JavaLikeParitioner__SingleLineParitionAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1375:1: ( ( rule__JavaLikeParitioner__SingleLineParitionAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1376:1: ( rule__JavaLikeParitioner__SingleLineParitionAssignment_2 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineParitionAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1377:1: ( rule__JavaLikeParitioner__SingleLineParitionAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1377:2: rule__JavaLikeParitioner__SingleLineParitionAssignment_2
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__SingleLineParitionAssignment_2_in_rule__JavaLikeParitioner__Group__2__Impl2861);
            rule__JavaLikeParitioner__SingleLineParitionAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getSingleLineParitionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__2__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1387:1: rule__JavaLikeParitioner__Group__3 : rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4 ;
    public final void rule__JavaLikeParitioner__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1391:1: ( rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1392:2: rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__3__Impl_in_rule__JavaLikeParitioner__Group__32891);
            rule__JavaLikeParitioner__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__4_in_rule__JavaLikeParitioner__Group__32894);
            rule__JavaLikeParitioner__Group__4();

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
    // $ANTLR end "rule__JavaLikeParitioner__Group__3"


    // $ANTLR start "rule__JavaLikeParitioner__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1399:1: rule__JavaLikeParitioner__Group__3__Impl : ( ( rule__JavaLikeParitioner__MultiLineParitionAssignment_3 ) ) ;
    public final void rule__JavaLikeParitioner__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1403:1: ( ( ( rule__JavaLikeParitioner__MultiLineParitionAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1404:1: ( ( rule__JavaLikeParitioner__MultiLineParitionAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1404:1: ( ( rule__JavaLikeParitioner__MultiLineParitionAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1405:1: ( rule__JavaLikeParitioner__MultiLineParitionAssignment_3 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineParitionAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1406:1: ( rule__JavaLikeParitioner__MultiLineParitionAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1406:2: rule__JavaLikeParitioner__MultiLineParitionAssignment_3
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__MultiLineParitionAssignment_3_in_rule__JavaLikeParitioner__Group__3__Impl2921);
            rule__JavaLikeParitioner__MultiLineParitionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getMultiLineParitionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__3__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1416:1: rule__JavaLikeParitioner__Group__4 : rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5 ;
    public final void rule__JavaLikeParitioner__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1420:1: ( rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1421:2: rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__4__Impl_in_rule__JavaLikeParitioner__Group__42951);
            rule__JavaLikeParitioner__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__5_in_rule__JavaLikeParitioner__Group__42954);
            rule__JavaLikeParitioner__Group__5();

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
    // $ANTLR end "rule__JavaLikeParitioner__Group__4"


    // $ANTLR start "rule__JavaLikeParitioner__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1428:1: rule__JavaLikeParitioner__Group__4__Impl : ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_4 ) ) ;
    public final void rule__JavaLikeParitioner__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1432:1: ( ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1433:1: ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1433:1: ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1434:1: ( rule__JavaLikeParitioner__JavaDocParitionAssignment_4 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1435:1: ( rule__JavaLikeParitioner__JavaDocParitionAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1435:2: rule__JavaLikeParitioner__JavaDocParitionAssignment_4
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__JavaDocParitionAssignment_4_in_rule__JavaLikeParitioner__Group__4__Impl2981);
            rule__JavaLikeParitioner__JavaDocParitionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__4__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1445:1: rule__JavaLikeParitioner__Group__5 : rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6 ;
    public final void rule__JavaLikeParitioner__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1449:1: ( rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1450:2: rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__5__Impl_in_rule__JavaLikeParitioner__Group__53011);
            rule__JavaLikeParitioner__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__6_in_rule__JavaLikeParitioner__Group__53014);
            rule__JavaLikeParitioner__Group__6();

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
    // $ANTLR end "rule__JavaLikeParitioner__Group__5"


    // $ANTLR start "rule__JavaLikeParitioner__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1457:1: rule__JavaLikeParitioner__Group__5__Impl : ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_5 ) ) ;
    public final void rule__JavaLikeParitioner__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1461:1: ( ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_5 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1462:1: ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_5 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1462:1: ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_5 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1463:1: ( rule__JavaLikeParitioner__CharacterParitionAssignment_5 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1464:1: ( rule__JavaLikeParitioner__CharacterParitionAssignment_5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1464:2: rule__JavaLikeParitioner__CharacterParitionAssignment_5
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__CharacterParitionAssignment_5_in_rule__JavaLikeParitioner__Group__5__Impl3041);
            rule__JavaLikeParitioner__CharacterParitionAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__5__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__6"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1474:1: rule__JavaLikeParitioner__Group__6 : rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7 ;
    public final void rule__JavaLikeParitioner__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1478:1: ( rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1479:2: rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__6__Impl_in_rule__JavaLikeParitioner__Group__63071);
            rule__JavaLikeParitioner__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__7_in_rule__JavaLikeParitioner__Group__63074);
            rule__JavaLikeParitioner__Group__7();

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
    // $ANTLR end "rule__JavaLikeParitioner__Group__6"


    // $ANTLR start "rule__JavaLikeParitioner__Group__6__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1486:1: rule__JavaLikeParitioner__Group__6__Impl : ( ( rule__JavaLikeParitioner__StringParitionAssignment_6 ) ) ;
    public final void rule__JavaLikeParitioner__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1490:1: ( ( ( rule__JavaLikeParitioner__StringParitionAssignment_6 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1491:1: ( ( rule__JavaLikeParitioner__StringParitionAssignment_6 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1491:1: ( ( rule__JavaLikeParitioner__StringParitionAssignment_6 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1492:1: ( rule__JavaLikeParitioner__StringParitionAssignment_6 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionAssignment_6()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1493:1: ( rule__JavaLikeParitioner__StringParitionAssignment_6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1493:2: rule__JavaLikeParitioner__StringParitionAssignment_6
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__StringParitionAssignment_6_in_rule__JavaLikeParitioner__Group__6__Impl3101);
            rule__JavaLikeParitioner__StringParitionAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getStringParitionAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__6__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__7"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1503:1: rule__JavaLikeParitioner__Group__7 : rule__JavaLikeParitioner__Group__7__Impl ;
    public final void rule__JavaLikeParitioner__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1507:1: ( rule__JavaLikeParitioner__Group__7__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1508:2: rule__JavaLikeParitioner__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__7__Impl_in_rule__JavaLikeParitioner__Group__73131);
            rule__JavaLikeParitioner__Group__7__Impl();

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
    // $ANTLR end "rule__JavaLikeParitioner__Group__7"


    // $ANTLR start "rule__JavaLikeParitioner__Group__7__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1514:1: rule__JavaLikeParitioner__Group__7__Impl : ( '}' ) ;
    public final void rule__JavaLikeParitioner__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1518:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1519:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1519:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1520:1: '}'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getRightCurlyBracketKeyword_7()); 
            match(input,16,FOLLOW_16_in_rule__JavaLikeParitioner__Group__7__Impl3159); 
             after(grammarAccess.getJavaLikeParitionerAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__7__Impl"


    // $ANTLR start "rule__RulePartitioner__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1549:1: rule__RulePartitioner__Group__0 : rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1 ;
    public final void rule__RulePartitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1553:1: ( rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1554:2: rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__0__Impl_in_rule__RulePartitioner__Group__03206);
            rule__RulePartitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__1_in_rule__RulePartitioner__Group__03209);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1561:1: rule__RulePartitioner__Group__0__Impl : ( 'rule-partitioner' ) ;
    public final void rule__RulePartitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1565:1: ( ( 'rule-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1566:1: ( 'rule-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1566:1: ( 'rule-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1567:1: 'rule-partitioner'
            {
             before(grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__RulePartitioner__Group__0__Impl3237); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1580:1: rule__RulePartitioner__Group__1 : rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2 ;
    public final void rule__RulePartitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1584:1: ( rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1585:2: rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__1__Impl_in_rule__RulePartitioner__Group__13268);
            rule__RulePartitioner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__2_in_rule__RulePartitioner__Group__13271);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1592:1: rule__RulePartitioner__Group__1__Impl : ( '{' ) ;
    public final void rule__RulePartitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1596:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1597:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1597:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1598:1: '{'
            {
             before(grammarAccess.getRulePartitionerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__RulePartitioner__Group__1__Impl3299); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1611:1: rule__RulePartitioner__Group__2 : rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3 ;
    public final void rule__RulePartitioner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1615:1: ( rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1616:2: rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__2__Impl_in_rule__RulePartitioner__Group__23330);
            rule__RulePartitioner__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__3_in_rule__RulePartitioner__Group__23333);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1623:1: rule__RulePartitioner__Group__2__Impl : ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) ) ;
    public final void rule__RulePartitioner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1627:1: ( ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1628:1: ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1628:1: ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1629:1: ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1629:1: ( ( rule__RulePartitioner__RulesAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1630:1: ( rule__RulePartitioner__RulesAssignment_2 )
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1631:1: ( rule__RulePartitioner__RulesAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1631:2: rule__RulePartitioner__RulesAssignment_2
            {
            pushFollow(FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3362);
            rule__RulePartitioner__RulesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1634:1: ( ( rule__RulePartitioner__RulesAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1635:1: ( rule__RulePartitioner__RulesAssignment_2 )*
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1636:1: ( rule__RulePartitioner__RulesAssignment_2 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==34||LA10_0==38||LA10_0==40) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1636:2: rule__RulePartitioner__RulesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3374);
            	    rule__RulePartitioner__RulesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1647:1: rule__RulePartitioner__Group__3 : rule__RulePartitioner__Group__3__Impl ;
    public final void rule__RulePartitioner__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1651:1: ( rule__RulePartitioner__Group__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1652:2: rule__RulePartitioner__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__3__Impl_in_rule__RulePartitioner__Group__33407);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1658:1: rule__RulePartitioner__Group__3__Impl : ( '}' ) ;
    public final void rule__RulePartitioner__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1662:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1663:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1663:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1664:1: '}'
            {
             before(grammarAccess.getRulePartitionerAccess().getRightCurlyBracketKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__RulePartitioner__Group__3__Impl3435); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1685:1: rule__JSParitioner__Group__0 : rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1 ;
    public final void rule__JSParitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1689:1: ( rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1690:2: rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__0__Impl_in_rule__JSParitioner__Group__03474);
            rule__JSParitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSParitioner__Group__1_in_rule__JSParitioner__Group__03477);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1697:1: rule__JSParitioner__Group__0__Impl : ( 'js-partitioner' ) ;
    public final void rule__JSParitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1701:1: ( ( 'js-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1702:1: ( 'js-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1702:1: ( 'js-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1703:1: 'js-partitioner'
            {
             before(grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__JSParitioner__Group__0__Impl3505); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1716:1: rule__JSParitioner__Group__1 : rule__JSParitioner__Group__1__Impl ;
    public final void rule__JSParitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1720:1: ( rule__JSParitioner__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1721:2: rule__JSParitioner__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__1__Impl_in_rule__JSParitioner__Group__13536);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1727:1: rule__JSParitioner__Group__1__Impl : ( ( rule__JSParitioner__FileURIAssignment_1 ) ) ;
    public final void rule__JSParitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1731:1: ( ( ( rule__JSParitioner__FileURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1732:1: ( ( rule__JSParitioner__FileURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1732:1: ( ( rule__JSParitioner__FileURIAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1733:1: ( rule__JSParitioner__FileURIAssignment_1 )
            {
             before(grammarAccess.getJSParitionerAccess().getFileURIAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1734:1: ( rule__JSParitioner__FileURIAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1734:2: rule__JSParitioner__FileURIAssignment_1
            {
            pushFollow(FOLLOW_rule__JSParitioner__FileURIAssignment_1_in_rule__JSParitioner__Group__1__Impl3563);
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


    // $ANTLR start "rule__JSDamager__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1748:1: rule__JSDamager__Group__0 : rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1 ;
    public final void rule__JSDamager__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1752:1: ( rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1753:2: rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__0__Impl_in_rule__JSDamager__Group__03597);
            rule__JSDamager__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSDamager__Group__1_in_rule__JSDamager__Group__03600);
            rule__JSDamager__Group__1();

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
    // $ANTLR end "rule__JSDamager__Group__0"


    // $ANTLR start "rule__JSDamager__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1760:1: rule__JSDamager__Group__0__Impl : ( 'js-damager' ) ;
    public final void rule__JSDamager__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1764:1: ( ( 'js-damager' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1765:1: ( 'js-damager' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1765:1: ( 'js-damager' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1766:1: 'js-damager'
            {
             before(grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__JSDamager__Group__0__Impl3628); 
             after(grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSDamager__Group__0__Impl"


    // $ANTLR start "rule__JSDamager__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1779:1: rule__JSDamager__Group__1 : rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2 ;
    public final void rule__JSDamager__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1783:1: ( rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1784:2: rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__1__Impl_in_rule__JSDamager__Group__13659);
            rule__JSDamager__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSDamager__Group__2_in_rule__JSDamager__Group__13662);
            rule__JSDamager__Group__2();

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
    // $ANTLR end "rule__JSDamager__Group__1"


    // $ANTLR start "rule__JSDamager__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1791:1: rule__JSDamager__Group__1__Impl : ( ( rule__JSDamager__PartitionAssignment_1 ) ) ;
    public final void rule__JSDamager__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1795:1: ( ( ( rule__JSDamager__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1796:1: ( ( rule__JSDamager__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1796:1: ( ( rule__JSDamager__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1797:1: ( rule__JSDamager__PartitionAssignment_1 )
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1798:1: ( rule__JSDamager__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1798:2: rule__JSDamager__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__JSDamager__PartitionAssignment_1_in_rule__JSDamager__Group__1__Impl3689);
            rule__JSDamager__PartitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJSDamagerAccess().getPartitionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSDamager__Group__1__Impl"


    // $ANTLR start "rule__JSDamager__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1808:1: rule__JSDamager__Group__2 : rule__JSDamager__Group__2__Impl ;
    public final void rule__JSDamager__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1812:1: ( rule__JSDamager__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1813:2: rule__JSDamager__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__2__Impl_in_rule__JSDamager__Group__23719);
            rule__JSDamager__Group__2__Impl();

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
    // $ANTLR end "rule__JSDamager__Group__2"


    // $ANTLR start "rule__JSDamager__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1819:1: rule__JSDamager__Group__2__Impl : ( ( rule__JSDamager__FileURIAssignment_2 ) ) ;
    public final void rule__JSDamager__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1823:1: ( ( ( rule__JSDamager__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1824:1: ( ( rule__JSDamager__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1824:1: ( ( rule__JSDamager__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1825:1: ( rule__JSDamager__FileURIAssignment_2 )
            {
             before(grammarAccess.getJSDamagerAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1826:1: ( rule__JSDamager__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1826:2: rule__JSDamager__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__JSDamager__FileURIAssignment_2_in_rule__JSDamager__Group__2__Impl3746);
            rule__JSDamager__FileURIAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJSDamagerAccess().getFileURIAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSDamager__Group__2__Impl"


    // $ANTLR start "rule__RuleDamager__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1842:1: rule__RuleDamager__Group__0 : rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1 ;
    public final void rule__RuleDamager__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1846:1: ( rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1847:2: rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__0__Impl_in_rule__RuleDamager__Group__03782);
            rule__RuleDamager__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__1_in_rule__RuleDamager__Group__03785);
            rule__RuleDamager__Group__1();

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
    // $ANTLR end "rule__RuleDamager__Group__0"


    // $ANTLR start "rule__RuleDamager__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1854:1: rule__RuleDamager__Group__0__Impl : ( 'rule-damager' ) ;
    public final void rule__RuleDamager__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1858:1: ( ( 'rule-damager' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1859:1: ( 'rule-damager' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1859:1: ( 'rule-damager' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1860:1: 'rule-damager'
            {
             before(grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__RuleDamager__Group__0__Impl3813); 
             after(grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__Group__0__Impl"


    // $ANTLR start "rule__RuleDamager__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1873:1: rule__RuleDamager__Group__1 : rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2 ;
    public final void rule__RuleDamager__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1877:1: ( rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1878:2: rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__1__Impl_in_rule__RuleDamager__Group__13844);
            rule__RuleDamager__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__2_in_rule__RuleDamager__Group__13847);
            rule__RuleDamager__Group__2();

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
    // $ANTLR end "rule__RuleDamager__Group__1"


    // $ANTLR start "rule__RuleDamager__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1885:1: rule__RuleDamager__Group__1__Impl : ( ( rule__RuleDamager__PartitionAssignment_1 ) ) ;
    public final void rule__RuleDamager__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1889:1: ( ( ( rule__RuleDamager__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1890:1: ( ( rule__RuleDamager__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1890:1: ( ( rule__RuleDamager__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1891:1: ( rule__RuleDamager__PartitionAssignment_1 )
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1892:1: ( rule__RuleDamager__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1892:2: rule__RuleDamager__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__RuleDamager__PartitionAssignment_1_in_rule__RuleDamager__Group__1__Impl3874);
            rule__RuleDamager__PartitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleDamagerAccess().getPartitionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__Group__1__Impl"


    // $ANTLR start "rule__RuleDamager__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1902:1: rule__RuleDamager__Group__2 : rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3 ;
    public final void rule__RuleDamager__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1906:1: ( rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1907:2: rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__2__Impl_in_rule__RuleDamager__Group__23904);
            rule__RuleDamager__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__3_in_rule__RuleDamager__Group__23907);
            rule__RuleDamager__Group__3();

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
    // $ANTLR end "rule__RuleDamager__Group__2"


    // $ANTLR start "rule__RuleDamager__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1914:1: rule__RuleDamager__Group__2__Impl : ( '{' ) ;
    public final void rule__RuleDamager__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1918:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1919:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1919:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1920:1: '{'
            {
             before(grammarAccess.getRuleDamagerAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,15,FOLLOW_15_in_rule__RuleDamager__Group__2__Impl3935); 
             after(grammarAccess.getRuleDamagerAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__Group__2__Impl"


    // $ANTLR start "rule__RuleDamager__Group__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1933:1: rule__RuleDamager__Group__3 : rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4 ;
    public final void rule__RuleDamager__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1937:1: ( rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1938:2: rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__3__Impl_in_rule__RuleDamager__Group__33966);
            rule__RuleDamager__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__4_in_rule__RuleDamager__Group__33969);
            rule__RuleDamager__Group__4();

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
    // $ANTLR end "rule__RuleDamager__Group__3"


    // $ANTLR start "rule__RuleDamager__Group__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1945:1: rule__RuleDamager__Group__3__Impl : ( ( rule__RuleDamager__TokensAssignment_3 )* ) ;
    public final void rule__RuleDamager__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1949:1: ( ( ( rule__RuleDamager__TokensAssignment_3 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1950:1: ( ( rule__RuleDamager__TokensAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1950:1: ( ( rule__RuleDamager__TokensAssignment_3 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1951:1: ( rule__RuleDamager__TokensAssignment_3 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getTokensAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1952:1: ( rule__RuleDamager__TokensAssignment_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==24||LA11_0==47) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1952:2: rule__RuleDamager__TokensAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__TokensAssignment_3_in_rule__RuleDamager__Group__3__Impl3996);
            	    rule__RuleDamager__TokensAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getRuleDamagerAccess().getTokensAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__Group__3__Impl"


    // $ANTLR start "rule__RuleDamager__Group__4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1962:1: rule__RuleDamager__Group__4 : rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5 ;
    public final void rule__RuleDamager__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1966:1: ( rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1967:2: rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__4__Impl_in_rule__RuleDamager__Group__44027);
            rule__RuleDamager__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__5_in_rule__RuleDamager__Group__44030);
            rule__RuleDamager__Group__5();

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
    // $ANTLR end "rule__RuleDamager__Group__4"


    // $ANTLR start "rule__RuleDamager__Group__4__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1974:1: rule__RuleDamager__Group__4__Impl : ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* ) ;
    public final void rule__RuleDamager__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1978:1: ( ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1979:1: ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1979:1: ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1980:1: ( rule__RuleDamager__KeywordGroupsAssignment_4 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getKeywordGroupsAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1981:1: ( rule__RuleDamager__KeywordGroupsAssignment_4 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==29) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1981:2: rule__RuleDamager__KeywordGroupsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__KeywordGroupsAssignment_4_in_rule__RuleDamager__Group__4__Impl4057);
            	    rule__RuleDamager__KeywordGroupsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getRuleDamagerAccess().getKeywordGroupsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__Group__4__Impl"


    // $ANTLR start "rule__RuleDamager__Group__5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1991:1: rule__RuleDamager__Group__5 : rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6 ;
    public final void rule__RuleDamager__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1995:1: ( rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1996:2: rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__5__Impl_in_rule__RuleDamager__Group__54088);
            rule__RuleDamager__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__6_in_rule__RuleDamager__Group__54091);
            rule__RuleDamager__Group__6();

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
    // $ANTLR end "rule__RuleDamager__Group__5"


    // $ANTLR start "rule__RuleDamager__Group__5__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2003:1: rule__RuleDamager__Group__5__Impl : ( ( ( rule__RuleDamager__RulesAssignment_5 ) ) ( ( rule__RuleDamager__RulesAssignment_5 )* ) ) ;
    public final void rule__RuleDamager__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2007:1: ( ( ( ( rule__RuleDamager__RulesAssignment_5 ) ) ( ( rule__RuleDamager__RulesAssignment_5 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2008:1: ( ( ( rule__RuleDamager__RulesAssignment_5 ) ) ( ( rule__RuleDamager__RulesAssignment_5 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2008:1: ( ( ( rule__RuleDamager__RulesAssignment_5 ) ) ( ( rule__RuleDamager__RulesAssignment_5 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2009:1: ( ( rule__RuleDamager__RulesAssignment_5 ) ) ( ( rule__RuleDamager__RulesAssignment_5 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2009:1: ( ( rule__RuleDamager__RulesAssignment_5 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2010:1: ( rule__RuleDamager__RulesAssignment_5 )
            {
             before(grammarAccess.getRuleDamagerAccess().getRulesAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2011:1: ( rule__RuleDamager__RulesAssignment_5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2011:2: rule__RuleDamager__RulesAssignment_5
            {
            pushFollow(FOLLOW_rule__RuleDamager__RulesAssignment_5_in_rule__RuleDamager__Group__5__Impl4120);
            rule__RuleDamager__RulesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getRuleDamagerAccess().getRulesAssignment_5()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2014:1: ( ( rule__RuleDamager__RulesAssignment_5 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2015:1: ( rule__RuleDamager__RulesAssignment_5 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getRulesAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2016:1: ( rule__RuleDamager__RulesAssignment_5 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==34||(LA13_0>=38 && LA13_0<=42)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2016:2: rule__RuleDamager__RulesAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__RulesAssignment_5_in_rule__RuleDamager__Group__5__Impl4132);
            	    rule__RuleDamager__RulesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getRuleDamagerAccess().getRulesAssignment_5()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__Group__5__Impl"


    // $ANTLR start "rule__RuleDamager__Group__6"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2027:1: rule__RuleDamager__Group__6 : rule__RuleDamager__Group__6__Impl ;
    public final void rule__RuleDamager__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2031:1: ( rule__RuleDamager__Group__6__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2032:2: rule__RuleDamager__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__6__Impl_in_rule__RuleDamager__Group__64165);
            rule__RuleDamager__Group__6__Impl();

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
    // $ANTLR end "rule__RuleDamager__Group__6"


    // $ANTLR start "rule__RuleDamager__Group__6__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2038:1: rule__RuleDamager__Group__6__Impl : ( '}' ) ;
    public final void rule__RuleDamager__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2042:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2043:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2043:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2044:1: '}'
            {
             before(grammarAccess.getRuleDamagerAccess().getRightCurlyBracketKeyword_6()); 
            match(input,16,FOLLOW_16_in_rule__RuleDamager__Group__6__Impl4193); 
             after(grammarAccess.getRuleDamagerAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__Group__6__Impl"


    // $ANTLR start "rule__ScannerToken__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2071:1: rule__ScannerToken__Group__0 : rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1 ;
    public final void rule__ScannerToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2075:1: ( rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2076:2: rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__0__Impl_in_rule__ScannerToken__Group__04238);
            rule__ScannerToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__1_in_rule__ScannerToken__Group__04241);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2083:1: rule__ScannerToken__Group__0__Impl : ( ( rule__ScannerToken__DefaultAssignment_0 )? ) ;
    public final void rule__ScannerToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2087:1: ( ( ( rule__ScannerToken__DefaultAssignment_0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2088:1: ( ( rule__ScannerToken__DefaultAssignment_0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2088:1: ( ( rule__ScannerToken__DefaultAssignment_0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2089:1: ( rule__ScannerToken__DefaultAssignment_0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2090:1: ( rule__ScannerToken__DefaultAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==47) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2090:2: rule__ScannerToken__DefaultAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__DefaultAssignment_0_in_rule__ScannerToken__Group__0__Impl4268);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2100:1: rule__ScannerToken__Group__1 : rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2 ;
    public final void rule__ScannerToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2104:1: ( rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2105:2: rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__1__Impl_in_rule__ScannerToken__Group__14299);
            rule__ScannerToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__2_in_rule__ScannerToken__Group__14302);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2112:1: rule__ScannerToken__Group__1__Impl : ( 'token' ) ;
    public final void rule__ScannerToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2116:1: ( ( 'token' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2117:1: ( 'token' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2117:1: ( 'token' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2118:1: 'token'
            {
             before(grammarAccess.getScannerTokenAccess().getTokenKeyword_1()); 
            match(input,24,FOLLOW_24_in_rule__ScannerToken__Group__1__Impl4330); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2131:1: rule__ScannerToken__Group__2 : rule__ScannerToken__Group__2__Impl rule__ScannerToken__Group__3 ;
    public final void rule__ScannerToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2135:1: ( rule__ScannerToken__Group__2__Impl rule__ScannerToken__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2136:2: rule__ScannerToken__Group__2__Impl rule__ScannerToken__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__2__Impl_in_rule__ScannerToken__Group__24361);
            rule__ScannerToken__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__3_in_rule__ScannerToken__Group__24364);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2143:1: rule__ScannerToken__Group__2__Impl : ( ( rule__ScannerToken__NameAssignment_2 ) ) ;
    public final void rule__ScannerToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2147:1: ( ( ( rule__ScannerToken__NameAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2148:1: ( ( rule__ScannerToken__NameAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2148:1: ( ( rule__ScannerToken__NameAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2149:1: ( rule__ScannerToken__NameAssignment_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getNameAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2150:1: ( rule__ScannerToken__NameAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2150:2: rule__ScannerToken__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__NameAssignment_2_in_rule__ScannerToken__Group__2__Impl4391);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2160:1: rule__ScannerToken__Group__3 : rule__ScannerToken__Group__3__Impl ;
    public final void rule__ScannerToken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2164:1: ( rule__ScannerToken__Group__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2165:2: rule__ScannerToken__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__3__Impl_in_rule__ScannerToken__Group__34421);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2171:1: rule__ScannerToken__Group__3__Impl : ( ( rule__ScannerToken__Group_3__0 )? ) ;
    public final void rule__ScannerToken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2175:1: ( ( ( rule__ScannerToken__Group_3__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2176:1: ( ( rule__ScannerToken__Group_3__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2176:1: ( ( rule__ScannerToken__Group_3__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2177:1: ( rule__ScannerToken__Group_3__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2178:1: ( rule__ScannerToken__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2178:2: rule__ScannerToken__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3__0_in_rule__ScannerToken__Group__3__Impl4448);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2196:1: rule__ScannerToken__Group_3__0 : rule__ScannerToken__Group_3__0__Impl rule__ScannerToken__Group_3__1 ;
    public final void rule__ScannerToken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2200:1: ( rule__ScannerToken__Group_3__0__Impl rule__ScannerToken__Group_3__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2201:2: rule__ScannerToken__Group_3__0__Impl rule__ScannerToken__Group_3__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__0__Impl_in_rule__ScannerToken__Group_3__04487);
            rule__ScannerToken__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__1_in_rule__ScannerToken__Group_3__04490);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2208:1: rule__ScannerToken__Group_3__0__Impl : ( '{' ) ;
    public final void rule__ScannerToken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2212:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2213:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2213:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2214:1: '{'
            {
             before(grammarAccess.getScannerTokenAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,15,FOLLOW_15_in_rule__ScannerToken__Group_3__0__Impl4518); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2227:1: rule__ScannerToken__Group_3__1 : rule__ScannerToken__Group_3__1__Impl rule__ScannerToken__Group_3__2 ;
    public final void rule__ScannerToken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2231:1: ( rule__ScannerToken__Group_3__1__Impl rule__ScannerToken__Group_3__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2232:2: rule__ScannerToken__Group_3__1__Impl rule__ScannerToken__Group_3__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__1__Impl_in_rule__ScannerToken__Group_3__14549);
            rule__ScannerToken__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__2_in_rule__ScannerToken__Group_3__14552);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2239:1: rule__ScannerToken__Group_3__1__Impl : ( ( rule__ScannerToken__Group_3_1__0 )? ) ;
    public final void rule__ScannerToken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2243:1: ( ( ( rule__ScannerToken__Group_3_1__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2244:1: ( ( rule__ScannerToken__Group_3_1__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2244:1: ( ( rule__ScannerToken__Group_3_1__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2245:1: ( rule__ScannerToken__Group_3_1__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2246:1: ( rule__ScannerToken__Group_3_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2246:2: rule__ScannerToken__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__0_in_rule__ScannerToken__Group_3__1__Impl4579);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2256:1: rule__ScannerToken__Group_3__2 : rule__ScannerToken__Group_3__2__Impl rule__ScannerToken__Group_3__3 ;
    public final void rule__ScannerToken__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2260:1: ( rule__ScannerToken__Group_3__2__Impl rule__ScannerToken__Group_3__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2261:2: rule__ScannerToken__Group_3__2__Impl rule__ScannerToken__Group_3__3
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__2__Impl_in_rule__ScannerToken__Group_3__24610);
            rule__ScannerToken__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__3_in_rule__ScannerToken__Group_3__24613);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2268:1: rule__ScannerToken__Group_3__2__Impl : ( ( rule__ScannerToken__Group_3_2__0 )? ) ;
    public final void rule__ScannerToken__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2272:1: ( ( ( rule__ScannerToken__Group_3_2__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2273:1: ( ( rule__ScannerToken__Group_3_2__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2273:1: ( ( rule__ScannerToken__Group_3_2__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2274:1: ( rule__ScannerToken__Group_3_2__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2275:1: ( rule__ScannerToken__Group_3_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2275:2: rule__ScannerToken__Group_3_2__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__0_in_rule__ScannerToken__Group_3__2__Impl4640);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2285:1: rule__ScannerToken__Group_3__3 : rule__ScannerToken__Group_3__3__Impl rule__ScannerToken__Group_3__4 ;
    public final void rule__ScannerToken__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2289:1: ( rule__ScannerToken__Group_3__3__Impl rule__ScannerToken__Group_3__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2290:2: rule__ScannerToken__Group_3__3__Impl rule__ScannerToken__Group_3__4
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__3__Impl_in_rule__ScannerToken__Group_3__34671);
            rule__ScannerToken__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__4_in_rule__ScannerToken__Group_3__34674);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2297:1: rule__ScannerToken__Group_3__3__Impl : ( ( rule__ScannerToken__Group_3_3__0 )? ) ;
    public final void rule__ScannerToken__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2301:1: ( ( ( rule__ScannerToken__Group_3_3__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2302:1: ( ( rule__ScannerToken__Group_3_3__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2302:1: ( ( rule__ScannerToken__Group_3_3__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2303:1: ( rule__ScannerToken__Group_3_3__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2304:1: ( rule__ScannerToken__Group_3_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2304:2: rule__ScannerToken__Group_3_3__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__0_in_rule__ScannerToken__Group_3__3__Impl4701);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2314:1: rule__ScannerToken__Group_3__4 : rule__ScannerToken__Group_3__4__Impl ;
    public final void rule__ScannerToken__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2318:1: ( rule__ScannerToken__Group_3__4__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2319:2: rule__ScannerToken__Group_3__4__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__4__Impl_in_rule__ScannerToken__Group_3__44732);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2325:1: rule__ScannerToken__Group_3__4__Impl : ( '}' ) ;
    public final void rule__ScannerToken__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2329:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2330:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2330:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2331:1: '}'
            {
             before(grammarAccess.getScannerTokenAccess().getRightCurlyBracketKeyword_3_4()); 
            match(input,16,FOLLOW_16_in_rule__ScannerToken__Group_3__4__Impl4760); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2354:1: rule__ScannerToken__Group_3_1__0 : rule__ScannerToken__Group_3_1__0__Impl rule__ScannerToken__Group_3_1__1 ;
    public final void rule__ScannerToken__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2358:1: ( rule__ScannerToken__Group_3_1__0__Impl rule__ScannerToken__Group_3_1__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2359:2: rule__ScannerToken__Group_3_1__0__Impl rule__ScannerToken__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__0__Impl_in_rule__ScannerToken__Group_3_1__04801);
            rule__ScannerToken__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__1_in_rule__ScannerToken__Group_3_1__04804);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2366:1: rule__ScannerToken__Group_3_1__0__Impl : ( 'fgcolor' ) ;
    public final void rule__ScannerToken__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2370:1: ( ( 'fgcolor' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2371:1: ( 'fgcolor' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2371:1: ( 'fgcolor' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2372:1: 'fgcolor'
            {
             before(grammarAccess.getScannerTokenAccess().getFgcolorKeyword_3_1_0()); 
            match(input,25,FOLLOW_25_in_rule__ScannerToken__Group_3_1__0__Impl4832); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2385:1: rule__ScannerToken__Group_3_1__1 : rule__ScannerToken__Group_3_1__1__Impl rule__ScannerToken__Group_3_1__2 ;
    public final void rule__ScannerToken__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2389:1: ( rule__ScannerToken__Group_3_1__1__Impl rule__ScannerToken__Group_3_1__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2390:2: rule__ScannerToken__Group_3_1__1__Impl rule__ScannerToken__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__1__Impl_in_rule__ScannerToken__Group_3_1__14863);
            rule__ScannerToken__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__2_in_rule__ScannerToken__Group_3_1__14866);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2397:1: rule__ScannerToken__Group_3_1__1__Impl : ( ':' ) ;
    public final void rule__ScannerToken__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2401:1: ( ( ':' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2402:1: ( ':' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2402:1: ( ':' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2403:1: ':'
            {
             before(grammarAccess.getScannerTokenAccess().getColonKeyword_3_1_1()); 
            match(input,26,FOLLOW_26_in_rule__ScannerToken__Group_3_1__1__Impl4894); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2416:1: rule__ScannerToken__Group_3_1__2 : rule__ScannerToken__Group_3_1__2__Impl ;
    public final void rule__ScannerToken__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2420:1: ( rule__ScannerToken__Group_3_1__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2421:2: rule__ScannerToken__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__2__Impl_in_rule__ScannerToken__Group_3_1__24925);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2427:1: rule__ScannerToken__Group_3_1__2__Impl : ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) ) ;
    public final void rule__ScannerToken__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2431:1: ( ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2432:1: ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2432:1: ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2433:1: ( rule__ScannerToken__FgColorAssignment_3_1_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getFgColorAssignment_3_1_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2434:1: ( rule__ScannerToken__FgColorAssignment_3_1_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2434:2: rule__ScannerToken__FgColorAssignment_3_1_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__FgColorAssignment_3_1_2_in_rule__ScannerToken__Group_3_1__2__Impl4952);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2450:1: rule__ScannerToken__Group_3_2__0 : rule__ScannerToken__Group_3_2__0__Impl rule__ScannerToken__Group_3_2__1 ;
    public final void rule__ScannerToken__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2454:1: ( rule__ScannerToken__Group_3_2__0__Impl rule__ScannerToken__Group_3_2__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2455:2: rule__ScannerToken__Group_3_2__0__Impl rule__ScannerToken__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__0__Impl_in_rule__ScannerToken__Group_3_2__04988);
            rule__ScannerToken__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__1_in_rule__ScannerToken__Group_3_2__04991);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2462:1: rule__ScannerToken__Group_3_2__0__Impl : ( 'bgcolor' ) ;
    public final void rule__ScannerToken__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2466:1: ( ( 'bgcolor' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2467:1: ( 'bgcolor' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2467:1: ( 'bgcolor' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2468:1: 'bgcolor'
            {
             before(grammarAccess.getScannerTokenAccess().getBgcolorKeyword_3_2_0()); 
            match(input,27,FOLLOW_27_in_rule__ScannerToken__Group_3_2__0__Impl5019); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2481:1: rule__ScannerToken__Group_3_2__1 : rule__ScannerToken__Group_3_2__1__Impl rule__ScannerToken__Group_3_2__2 ;
    public final void rule__ScannerToken__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2485:1: ( rule__ScannerToken__Group_3_2__1__Impl rule__ScannerToken__Group_3_2__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2486:2: rule__ScannerToken__Group_3_2__1__Impl rule__ScannerToken__Group_3_2__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__1__Impl_in_rule__ScannerToken__Group_3_2__15050);
            rule__ScannerToken__Group_3_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__2_in_rule__ScannerToken__Group_3_2__15053);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2493:1: rule__ScannerToken__Group_3_2__1__Impl : ( ':' ) ;
    public final void rule__ScannerToken__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2497:1: ( ( ':' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2498:1: ( ':' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2498:1: ( ':' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2499:1: ':'
            {
             before(grammarAccess.getScannerTokenAccess().getColonKeyword_3_2_1()); 
            match(input,26,FOLLOW_26_in_rule__ScannerToken__Group_3_2__1__Impl5081); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2512:1: rule__ScannerToken__Group_3_2__2 : rule__ScannerToken__Group_3_2__2__Impl ;
    public final void rule__ScannerToken__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2516:1: ( rule__ScannerToken__Group_3_2__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2517:2: rule__ScannerToken__Group_3_2__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__2__Impl_in_rule__ScannerToken__Group_3_2__25112);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2523:1: rule__ScannerToken__Group_3_2__2__Impl : ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) ) ;
    public final void rule__ScannerToken__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2527:1: ( ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2528:1: ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2528:1: ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2529:1: ( rule__ScannerToken__BgColorAssignment_3_2_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getBgColorAssignment_3_2_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2530:1: ( rule__ScannerToken__BgColorAssignment_3_2_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2530:2: rule__ScannerToken__BgColorAssignment_3_2_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__BgColorAssignment_3_2_2_in_rule__ScannerToken__Group_3_2__2__Impl5139);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2546:1: rule__ScannerToken__Group_3_3__0 : rule__ScannerToken__Group_3_3__0__Impl rule__ScannerToken__Group_3_3__1 ;
    public final void rule__ScannerToken__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2550:1: ( rule__ScannerToken__Group_3_3__0__Impl rule__ScannerToken__Group_3_3__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2551:2: rule__ScannerToken__Group_3_3__0__Impl rule__ScannerToken__Group_3_3__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__0__Impl_in_rule__ScannerToken__Group_3_3__05175);
            rule__ScannerToken__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__1_in_rule__ScannerToken__Group_3_3__05178);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2558:1: rule__ScannerToken__Group_3_3__0__Impl : ( 'font' ) ;
    public final void rule__ScannerToken__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2562:1: ( ( 'font' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2563:1: ( 'font' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2563:1: ( 'font' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2564:1: 'font'
            {
             before(grammarAccess.getScannerTokenAccess().getFontKeyword_3_3_0()); 
            match(input,28,FOLLOW_28_in_rule__ScannerToken__Group_3_3__0__Impl5206); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2577:1: rule__ScannerToken__Group_3_3__1 : rule__ScannerToken__Group_3_3__1__Impl rule__ScannerToken__Group_3_3__2 ;
    public final void rule__ScannerToken__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2581:1: ( rule__ScannerToken__Group_3_3__1__Impl rule__ScannerToken__Group_3_3__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2582:2: rule__ScannerToken__Group_3_3__1__Impl rule__ScannerToken__Group_3_3__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__1__Impl_in_rule__ScannerToken__Group_3_3__15237);
            rule__ScannerToken__Group_3_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__2_in_rule__ScannerToken__Group_3_3__15240);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2589:1: rule__ScannerToken__Group_3_3__1__Impl : ( ':' ) ;
    public final void rule__ScannerToken__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2593:1: ( ( ':' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2594:1: ( ':' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2594:1: ( ':' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2595:1: ':'
            {
             before(grammarAccess.getScannerTokenAccess().getColonKeyword_3_3_1()); 
            match(input,26,FOLLOW_26_in_rule__ScannerToken__Group_3_3__1__Impl5268); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2608:1: rule__ScannerToken__Group_3_3__2 : rule__ScannerToken__Group_3_3__2__Impl ;
    public final void rule__ScannerToken__Group_3_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2612:1: ( rule__ScannerToken__Group_3_3__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2613:2: rule__ScannerToken__Group_3_3__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__2__Impl_in_rule__ScannerToken__Group_3_3__25299);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2619:1: rule__ScannerToken__Group_3_3__2__Impl : ( ( rule__ScannerToken__FontAssignment_3_3_2 ) ) ;
    public final void rule__ScannerToken__Group_3_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2623:1: ( ( ( rule__ScannerToken__FontAssignment_3_3_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2624:1: ( ( rule__ScannerToken__FontAssignment_3_3_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2624:1: ( ( rule__ScannerToken__FontAssignment_3_3_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2625:1: ( rule__ScannerToken__FontAssignment_3_3_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getFontAssignment_3_3_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2626:1: ( rule__ScannerToken__FontAssignment_3_3_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2626:2: rule__ScannerToken__FontAssignment_3_3_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__FontAssignment_3_3_2_in_rule__ScannerToken__Group_3_3__2__Impl5326);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2642:1: rule__KeywordGroup__Group__0 : rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1 ;
    public final void rule__KeywordGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2646:1: ( rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2647:2: rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__0__Impl_in_rule__KeywordGroup__Group__05362);
            rule__KeywordGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__1_in_rule__KeywordGroup__Group__05365);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2654:1: rule__KeywordGroup__Group__0__Impl : ( 'keywords' ) ;
    public final void rule__KeywordGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2658:1: ( ( 'keywords' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2659:1: ( 'keywords' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2659:1: ( 'keywords' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2660:1: 'keywords'
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__KeywordGroup__Group__0__Impl5393); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2673:1: rule__KeywordGroup__Group__1 : rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2 ;
    public final void rule__KeywordGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2677:1: ( rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2678:2: rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__1__Impl_in_rule__KeywordGroup__Group__15424);
            rule__KeywordGroup__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__2_in_rule__KeywordGroup__Group__15427);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2685:1: rule__KeywordGroup__Group__1__Impl : ( ( rule__KeywordGroup__TokenAssignment_1 ) ) ;
    public final void rule__KeywordGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2689:1: ( ( ( rule__KeywordGroup__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2690:1: ( ( rule__KeywordGroup__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2690:1: ( ( rule__KeywordGroup__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2691:1: ( rule__KeywordGroup__TokenAssignment_1 )
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2692:1: ( rule__KeywordGroup__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2692:2: rule__KeywordGroup__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__TokenAssignment_1_in_rule__KeywordGroup__Group__1__Impl5454);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2702:1: rule__KeywordGroup__Group__2 : rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3 ;
    public final void rule__KeywordGroup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2706:1: ( rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2707:2: rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__2__Impl_in_rule__KeywordGroup__Group__25484);
            rule__KeywordGroup__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__3_in_rule__KeywordGroup__Group__25487);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2714:1: rule__KeywordGroup__Group__2__Impl : ( '[' ) ;
    public final void rule__KeywordGroup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2718:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2719:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2719:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2720:1: '['
            {
             before(grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2()); 
            match(input,30,FOLLOW_30_in_rule__KeywordGroup__Group__2__Impl5515); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2733:1: rule__KeywordGroup__Group__3 : rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4 ;
    public final void rule__KeywordGroup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2737:1: ( rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2738:2: rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__3__Impl_in_rule__KeywordGroup__Group__35546);
            rule__KeywordGroup__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__4_in_rule__KeywordGroup__Group__35549);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2745:1: rule__KeywordGroup__Group__3__Impl : ( ( rule__KeywordGroup__KeywordsAssignment_3 ) ) ;
    public final void rule__KeywordGroup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2749:1: ( ( ( rule__KeywordGroup__KeywordsAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2750:1: ( ( rule__KeywordGroup__KeywordsAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2750:1: ( ( rule__KeywordGroup__KeywordsAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2751:1: ( rule__KeywordGroup__KeywordsAssignment_3 )
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2752:1: ( rule__KeywordGroup__KeywordsAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2752:2: rule__KeywordGroup__KeywordsAssignment_3
            {
            pushFollow(FOLLOW_rule__KeywordGroup__KeywordsAssignment_3_in_rule__KeywordGroup__Group__3__Impl5576);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2762:1: rule__KeywordGroup__Group__4 : rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5 ;
    public final void rule__KeywordGroup__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2766:1: ( rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2767:2: rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__4__Impl_in_rule__KeywordGroup__Group__45606);
            rule__KeywordGroup__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__5_in_rule__KeywordGroup__Group__45609);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2774:1: rule__KeywordGroup__Group__4__Impl : ( ( rule__KeywordGroup__Group_4__0 )* ) ;
    public final void rule__KeywordGroup__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2778:1: ( ( ( rule__KeywordGroup__Group_4__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2779:1: ( ( rule__KeywordGroup__Group_4__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2779:1: ( ( rule__KeywordGroup__Group_4__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2780:1: ( rule__KeywordGroup__Group_4__0 )*
            {
             before(grammarAccess.getKeywordGroupAccess().getGroup_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2781:1: ( rule__KeywordGroup__Group_4__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==32) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2781:2: rule__KeywordGroup__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__KeywordGroup__Group_4__0_in_rule__KeywordGroup__Group__4__Impl5636);
            	    rule__KeywordGroup__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2791:1: rule__KeywordGroup__Group__5 : rule__KeywordGroup__Group__5__Impl ;
    public final void rule__KeywordGroup__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2795:1: ( rule__KeywordGroup__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2796:2: rule__KeywordGroup__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__5__Impl_in_rule__KeywordGroup__Group__55667);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2802:1: rule__KeywordGroup__Group__5__Impl : ( ']' ) ;
    public final void rule__KeywordGroup__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2806:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2807:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2807:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2808:1: ']'
            {
             before(grammarAccess.getKeywordGroupAccess().getRightSquareBracketKeyword_5()); 
            match(input,31,FOLLOW_31_in_rule__KeywordGroup__Group__5__Impl5695); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2833:1: rule__KeywordGroup__Group_4__0 : rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1 ;
    public final void rule__KeywordGroup__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2837:1: ( rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2838:2: rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__0__Impl_in_rule__KeywordGroup__Group_4__05738);
            rule__KeywordGroup__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__1_in_rule__KeywordGroup__Group_4__05741);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2845:1: rule__KeywordGroup__Group_4__0__Impl : ( ',' ) ;
    public final void rule__KeywordGroup__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2849:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2850:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2850:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2851:1: ','
            {
             before(grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0()); 
            match(input,32,FOLLOW_32_in_rule__KeywordGroup__Group_4__0__Impl5769); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2864:1: rule__KeywordGroup__Group_4__1 : rule__KeywordGroup__Group_4__1__Impl ;
    public final void rule__KeywordGroup__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2868:1: ( rule__KeywordGroup__Group_4__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2869:2: rule__KeywordGroup__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__1__Impl_in_rule__KeywordGroup__Group_4__15800);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2875:1: rule__KeywordGroup__Group_4__1__Impl : ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) ) ;
    public final void rule__KeywordGroup__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2879:1: ( ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2880:1: ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2880:1: ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2881:1: ( rule__KeywordGroup__KeywordsAssignment_4_1 )
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_4_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2882:1: ( rule__KeywordGroup__KeywordsAssignment_4_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2882:2: rule__KeywordGroup__KeywordsAssignment_4_1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__KeywordsAssignment_4_1_in_rule__KeywordGroup__Group_4__1__Impl5827);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2896:1: rule__Keyword__Group__0 : rule__Keyword__Group__0__Impl rule__Keyword__Group__1 ;
    public final void rule__Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2900:1: ( rule__Keyword__Group__0__Impl rule__Keyword__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2901:2: rule__Keyword__Group__0__Impl rule__Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__05861);
            rule__Keyword__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__05864);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2908:1: rule__Keyword__Group__0__Impl : ( ( rule__Keyword__NameAssignment_0 ) ) ;
    public final void rule__Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2912:1: ( ( ( rule__Keyword__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2913:1: ( ( rule__Keyword__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2913:1: ( ( rule__Keyword__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2914:1: ( rule__Keyword__NameAssignment_0 )
            {
             before(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2915:1: ( rule__Keyword__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2915:2: rule__Keyword__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl5891);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2925:1: rule__Keyword__Group__1 : rule__Keyword__Group__1__Impl ;
    public final void rule__Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2929:1: ( rule__Keyword__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2930:2: rule__Keyword__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__15921);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2936:1: rule__Keyword__Group__1__Impl : ( ( rule__Keyword__Group_1__0 )? ) ;
    public final void rule__Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2940:1: ( ( ( rule__Keyword__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2941:1: ( ( rule__Keyword__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2941:1: ( ( rule__Keyword__Group_1__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2942:1: ( rule__Keyword__Group_1__0 )?
            {
             before(grammarAccess.getKeywordAccess().getGroup_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2943:1: ( rule__Keyword__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==33) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2943:2: rule__Keyword__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl5948);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2957:1: rule__Keyword__Group_1__0 : rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 ;
    public final void rule__Keyword__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2961:1: ( rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2962:2: rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__05983);
            rule__Keyword__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__05986);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2969:1: rule__Keyword__Group_1__0__Impl : ( 'since' ) ;
    public final void rule__Keyword__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2973:1: ( ( 'since' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2974:1: ( 'since' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2974:1: ( 'since' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2975:1: 'since'
            {
             before(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            match(input,33,FOLLOW_33_in_rule__Keyword__Group_1__0__Impl6014); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2988:1: rule__Keyword__Group_1__1 : rule__Keyword__Group_1__1__Impl ;
    public final void rule__Keyword__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2992:1: ( rule__Keyword__Group_1__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2993:2: rule__Keyword__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__16045);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2999:1: rule__Keyword__Group_1__1__Impl : ( ( rule__Keyword__VersionAssignment_1_1 ) ) ;
    public final void rule__Keyword__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3003:1: ( ( ( rule__Keyword__VersionAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3004:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3004:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3005:1: ( rule__Keyword__VersionAssignment_1_1 )
            {
             before(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3006:1: ( rule__Keyword__VersionAssignment_1_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3006:2: rule__Keyword__VersionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl6072);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3020:1: rule__ScannerSingleLineRule__Group__0 : rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1 ;
    public final void rule__ScannerSingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3024:1: ( rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3025:2: rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__0__Impl_in_rule__ScannerSingleLineRule__Group__06106);
            rule__ScannerSingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__1_in_rule__ScannerSingleLineRule__Group__06109);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3032:1: rule__ScannerSingleLineRule__Group__0__Impl : ( 'single-line' ) ;
    public final void rule__ScannerSingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3036:1: ( ( 'single-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3037:1: ( 'single-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3037:1: ( 'single-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3038:1: 'single-line'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__ScannerSingleLineRule__Group__0__Impl6137); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3051:1: rule__ScannerSingleLineRule__Group__1 : rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2 ;
    public final void rule__ScannerSingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3055:1: ( rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3056:2: rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__1__Impl_in_rule__ScannerSingleLineRule__Group__16168);
            rule__ScannerSingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__2_in_rule__ScannerSingleLineRule__Group__16171);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3063:1: rule__ScannerSingleLineRule__Group__1__Impl : ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3067:1: ( ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3068:1: ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3068:1: ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3069:1: ( rule__ScannerSingleLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3070:1: ( rule__ScannerSingleLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3070:2: rule__ScannerSingleLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__TokenAssignment_1_in_rule__ScannerSingleLineRule__Group__1__Impl6198);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3080:1: rule__ScannerSingleLineRule__Group__2 : rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3 ;
    public final void rule__ScannerSingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3084:1: ( rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3085:2: rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__2__Impl_in_rule__ScannerSingleLineRule__Group__26228);
            rule__ScannerSingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__3_in_rule__ScannerSingleLineRule__Group__26231);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3092:1: rule__ScannerSingleLineRule__Group__2__Impl : ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3096:1: ( ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3097:1: ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3097:1: ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3098:1: ( rule__ScannerSingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3099:1: ( rule__ScannerSingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3099:2: rule__ScannerSingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__StartSeqAssignment_2_in_rule__ScannerSingleLineRule__Group__2__Impl6258);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3109:1: rule__ScannerSingleLineRule__Group__3 : rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4 ;
    public final void rule__ScannerSingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3113:1: ( rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3114:2: rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__3__Impl_in_rule__ScannerSingleLineRule__Group__36288);
            rule__ScannerSingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__4_in_rule__ScannerSingleLineRule__Group__36291);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3121:1: rule__ScannerSingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__ScannerSingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3125:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3126:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3126:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3127:1: '=>'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__ScannerSingleLineRule__Group__3__Impl6319); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3140:1: rule__ScannerSingleLineRule__Group__4 : rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5 ;
    public final void rule__ScannerSingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3144:1: ( rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3145:2: rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__4__Impl_in_rule__ScannerSingleLineRule__Group__46350);
            rule__ScannerSingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__5_in_rule__ScannerSingleLineRule__Group__46353);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3152:1: rule__ScannerSingleLineRule__Group__4__Impl : ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3156:1: ( ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3157:1: ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3157:1: ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3158:1: ( rule__ScannerSingleLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3159:1: ( rule__ScannerSingleLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3159:2: rule__ScannerSingleLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__EndSeqAssignment_4_in_rule__ScannerSingleLineRule__Group__4__Impl6380);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3169:1: rule__ScannerSingleLineRule__Group__5 : rule__ScannerSingleLineRule__Group__5__Impl ;
    public final void rule__ScannerSingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3173:1: ( rule__ScannerSingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3174:2: rule__ScannerSingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__5__Impl_in_rule__ScannerSingleLineRule__Group__56410);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3180:1: rule__ScannerSingleLineRule__Group__5__Impl : ( ( rule__ScannerSingleLineRule__Group_5__0 )? ) ;
    public final void rule__ScannerSingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3184:1: ( ( ( rule__ScannerSingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3185:1: ( ( rule__ScannerSingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3185:1: ( ( rule__ScannerSingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3186:1: ( rule__ScannerSingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3187:1: ( rule__ScannerSingleLineRule__Group_5__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==36) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3187:2: rule__ScannerSingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__0_in_rule__ScannerSingleLineRule__Group__5__Impl6437);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3209:1: rule__ScannerSingleLineRule__Group_5__0 : rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1 ;
    public final void rule__ScannerSingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3213:1: ( rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3214:2: rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__0__Impl_in_rule__ScannerSingleLineRule__Group_5__06480);
            rule__ScannerSingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__1_in_rule__ScannerSingleLineRule__Group_5__06483);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3221:1: rule__ScannerSingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__ScannerSingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3225:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3226:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3226:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3227:1: 'escaped'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,36,FOLLOW_36_in_rule__ScannerSingleLineRule__Group_5__0__Impl6511); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3240:1: rule__ScannerSingleLineRule__Group_5__1 : rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2 ;
    public final void rule__ScannerSingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3244:1: ( rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3245:2: rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__1__Impl_in_rule__ScannerSingleLineRule__Group_5__16542);
            rule__ScannerSingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__2_in_rule__ScannerSingleLineRule__Group_5__16545);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3252:1: rule__ScannerSingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__ScannerSingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3256:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3257:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3257:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3258:1: 'by'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,37,FOLLOW_37_in_rule__ScannerSingleLineRule__Group_5__1__Impl6573); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3271:1: rule__ScannerSingleLineRule__Group_5__2 : rule__ScannerSingleLineRule__Group_5__2__Impl ;
    public final void rule__ScannerSingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3275:1: ( rule__ScannerSingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3276:2: rule__ScannerSingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__2__Impl_in_rule__ScannerSingleLineRule__Group_5__26604);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3282:1: rule__ScannerSingleLineRule__Group_5__2__Impl : ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__ScannerSingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3286:1: ( ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3287:1: ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3287:1: ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3288:1: ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3289:1: ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3289:2: rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerSingleLineRule__Group_5__2__Impl6631);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3305:1: rule__PartitionSingleLineRule__Group__0 : rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1 ;
    public final void rule__PartitionSingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3309:1: ( rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3310:2: rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__0__Impl_in_rule__PartitionSingleLineRule__Group__06667);
            rule__PartitionSingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__1_in_rule__PartitionSingleLineRule__Group__06670);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3317:1: rule__PartitionSingleLineRule__Group__0__Impl : ( 'single-line' ) ;
    public final void rule__PartitionSingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3321:1: ( ( 'single-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3322:1: ( 'single-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3322:1: ( 'single-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3323:1: 'single-line'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__PartitionSingleLineRule__Group__0__Impl6698); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3336:1: rule__PartitionSingleLineRule__Group__1 : rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2 ;
    public final void rule__PartitionSingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3340:1: ( rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3341:2: rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__1__Impl_in_rule__PartitionSingleLineRule__Group__16729);
            rule__PartitionSingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__2_in_rule__PartitionSingleLineRule__Group__16732);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3348:1: rule__PartitionSingleLineRule__Group__1__Impl : ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3352:1: ( ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3353:1: ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3353:1: ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3354:1: ( rule__PartitionSingleLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3355:1: ( rule__PartitionSingleLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3355:2: rule__PartitionSingleLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__ParitionAssignment_1_in_rule__PartitionSingleLineRule__Group__1__Impl6759);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3365:1: rule__PartitionSingleLineRule__Group__2 : rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3 ;
    public final void rule__PartitionSingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3369:1: ( rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3370:2: rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__2__Impl_in_rule__PartitionSingleLineRule__Group__26789);
            rule__PartitionSingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__3_in_rule__PartitionSingleLineRule__Group__26792);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3377:1: rule__PartitionSingleLineRule__Group__2__Impl : ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3381:1: ( ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3382:1: ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3382:1: ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3383:1: ( rule__PartitionSingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3384:1: ( rule__PartitionSingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3384:2: rule__PartitionSingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__StartSeqAssignment_2_in_rule__PartitionSingleLineRule__Group__2__Impl6819);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3394:1: rule__PartitionSingleLineRule__Group__3 : rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4 ;
    public final void rule__PartitionSingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3398:1: ( rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3399:2: rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__3__Impl_in_rule__PartitionSingleLineRule__Group__36849);
            rule__PartitionSingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__4_in_rule__PartitionSingleLineRule__Group__36852);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3406:1: rule__PartitionSingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__PartitionSingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3410:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3411:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3411:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3412:1: '=>'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__PartitionSingleLineRule__Group__3__Impl6880); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3425:1: rule__PartitionSingleLineRule__Group__4 : rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5 ;
    public final void rule__PartitionSingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3429:1: ( rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3430:2: rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__4__Impl_in_rule__PartitionSingleLineRule__Group__46911);
            rule__PartitionSingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__5_in_rule__PartitionSingleLineRule__Group__46914);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3437:1: rule__PartitionSingleLineRule__Group__4__Impl : ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3441:1: ( ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3442:1: ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3442:1: ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3443:1: ( rule__PartitionSingleLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3444:1: ( rule__PartitionSingleLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3444:2: rule__PartitionSingleLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__EndSeqAssignment_4_in_rule__PartitionSingleLineRule__Group__4__Impl6941);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3454:1: rule__PartitionSingleLineRule__Group__5 : rule__PartitionSingleLineRule__Group__5__Impl ;
    public final void rule__PartitionSingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3458:1: ( rule__PartitionSingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3459:2: rule__PartitionSingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__5__Impl_in_rule__PartitionSingleLineRule__Group__56971);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3465:1: rule__PartitionSingleLineRule__Group__5__Impl : ( ( rule__PartitionSingleLineRule__Group_5__0 )? ) ;
    public final void rule__PartitionSingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3469:1: ( ( ( rule__PartitionSingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3470:1: ( ( rule__PartitionSingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3470:1: ( ( rule__PartitionSingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3471:1: ( rule__PartitionSingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3472:1: ( rule__PartitionSingleLineRule__Group_5__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==36) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3472:2: rule__PartitionSingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__0_in_rule__PartitionSingleLineRule__Group__5__Impl6998);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3494:1: rule__PartitionSingleLineRule__Group_5__0 : rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1 ;
    public final void rule__PartitionSingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3498:1: ( rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3499:2: rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__0__Impl_in_rule__PartitionSingleLineRule__Group_5__07041);
            rule__PartitionSingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__1_in_rule__PartitionSingleLineRule__Group_5__07044);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3506:1: rule__PartitionSingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__PartitionSingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3510:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3511:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3511:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3512:1: 'escaped'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,36,FOLLOW_36_in_rule__PartitionSingleLineRule__Group_5__0__Impl7072); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3525:1: rule__PartitionSingleLineRule__Group_5__1 : rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2 ;
    public final void rule__PartitionSingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3529:1: ( rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3530:2: rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__1__Impl_in_rule__PartitionSingleLineRule__Group_5__17103);
            rule__PartitionSingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__2_in_rule__PartitionSingleLineRule__Group_5__17106);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3537:1: rule__PartitionSingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__PartitionSingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3541:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3542:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3542:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3543:1: 'by'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,37,FOLLOW_37_in_rule__PartitionSingleLineRule__Group_5__1__Impl7134); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3556:1: rule__PartitionSingleLineRule__Group_5__2 : rule__PartitionSingleLineRule__Group_5__2__Impl ;
    public final void rule__PartitionSingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3560:1: ( rule__PartitionSingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3561:2: rule__PartitionSingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__2__Impl_in_rule__PartitionSingleLineRule__Group_5__27165);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3567:1: rule__PartitionSingleLineRule__Group_5__2__Impl : ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__PartitionSingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3571:1: ( ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3572:1: ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3572:1: ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3573:1: ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3574:1: ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3574:2: rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionSingleLineRule__Group_5__2__Impl7192);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3590:1: rule__ScannerMultiLineRule__Group__0 : rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1 ;
    public final void rule__ScannerMultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3594:1: ( rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3595:2: rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__0__Impl_in_rule__ScannerMultiLineRule__Group__07228);
            rule__ScannerMultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__1_in_rule__ScannerMultiLineRule__Group__07231);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3602:1: rule__ScannerMultiLineRule__Group__0__Impl : ( 'multi-line' ) ;
    public final void rule__ScannerMultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3606:1: ( ( 'multi-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3607:1: ( 'multi-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3607:1: ( 'multi-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3608:1: 'multi-line'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__ScannerMultiLineRule__Group__0__Impl7259); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3621:1: rule__ScannerMultiLineRule__Group__1 : rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2 ;
    public final void rule__ScannerMultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3625:1: ( rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3626:2: rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__1__Impl_in_rule__ScannerMultiLineRule__Group__17290);
            rule__ScannerMultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__2_in_rule__ScannerMultiLineRule__Group__17293);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3633:1: rule__ScannerMultiLineRule__Group__1__Impl : ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3637:1: ( ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3638:1: ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3638:1: ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3639:1: ( rule__ScannerMultiLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3640:1: ( rule__ScannerMultiLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3640:2: rule__ScannerMultiLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__TokenAssignment_1_in_rule__ScannerMultiLineRule__Group__1__Impl7320);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3650:1: rule__ScannerMultiLineRule__Group__2 : rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3 ;
    public final void rule__ScannerMultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3654:1: ( rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3655:2: rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__2__Impl_in_rule__ScannerMultiLineRule__Group__27350);
            rule__ScannerMultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__3_in_rule__ScannerMultiLineRule__Group__27353);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3662:1: rule__ScannerMultiLineRule__Group__2__Impl : ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3666:1: ( ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3667:1: ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3667:1: ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3668:1: ( rule__ScannerMultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3669:1: ( rule__ScannerMultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3669:2: rule__ScannerMultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__StartSeqAssignment_2_in_rule__ScannerMultiLineRule__Group__2__Impl7380);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3679:1: rule__ScannerMultiLineRule__Group__3 : rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4 ;
    public final void rule__ScannerMultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3683:1: ( rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3684:2: rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__3__Impl_in_rule__ScannerMultiLineRule__Group__37410);
            rule__ScannerMultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__4_in_rule__ScannerMultiLineRule__Group__37413);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3691:1: rule__ScannerMultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__ScannerMultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3695:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3696:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3696:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3697:1: '=>'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__ScannerMultiLineRule__Group__3__Impl7441); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3710:1: rule__ScannerMultiLineRule__Group__4 : rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5 ;
    public final void rule__ScannerMultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3714:1: ( rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3715:2: rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__4__Impl_in_rule__ScannerMultiLineRule__Group__47472);
            rule__ScannerMultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__5_in_rule__ScannerMultiLineRule__Group__47475);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3722:1: rule__ScannerMultiLineRule__Group__4__Impl : ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3726:1: ( ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3727:1: ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3727:1: ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3728:1: ( rule__ScannerMultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3729:1: ( rule__ScannerMultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3729:2: rule__ScannerMultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__EndSeqAssignment_4_in_rule__ScannerMultiLineRule__Group__4__Impl7502);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3739:1: rule__ScannerMultiLineRule__Group__5 : rule__ScannerMultiLineRule__Group__5__Impl ;
    public final void rule__ScannerMultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3743:1: ( rule__ScannerMultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3744:2: rule__ScannerMultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__5__Impl_in_rule__ScannerMultiLineRule__Group__57532);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3750:1: rule__ScannerMultiLineRule__Group__5__Impl : ( ( rule__ScannerMultiLineRule__Group_5__0 )? ) ;
    public final void rule__ScannerMultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3754:1: ( ( ( rule__ScannerMultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3755:1: ( ( rule__ScannerMultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3755:1: ( ( rule__ScannerMultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3756:1: ( rule__ScannerMultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3757:1: ( rule__ScannerMultiLineRule__Group_5__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==36) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3757:2: rule__ScannerMultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__0_in_rule__ScannerMultiLineRule__Group__5__Impl7559);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3779:1: rule__ScannerMultiLineRule__Group_5__0 : rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1 ;
    public final void rule__ScannerMultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3783:1: ( rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3784:2: rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__0__Impl_in_rule__ScannerMultiLineRule__Group_5__07602);
            rule__ScannerMultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__1_in_rule__ScannerMultiLineRule__Group_5__07605);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3791:1: rule__ScannerMultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__ScannerMultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3795:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3796:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3796:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3797:1: 'escaped'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,36,FOLLOW_36_in_rule__ScannerMultiLineRule__Group_5__0__Impl7633); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3810:1: rule__ScannerMultiLineRule__Group_5__1 : rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2 ;
    public final void rule__ScannerMultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3814:1: ( rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3815:2: rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__1__Impl_in_rule__ScannerMultiLineRule__Group_5__17664);
            rule__ScannerMultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__2_in_rule__ScannerMultiLineRule__Group_5__17667);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3822:1: rule__ScannerMultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__ScannerMultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3826:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3827:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3827:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3828:1: 'by'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,37,FOLLOW_37_in_rule__ScannerMultiLineRule__Group_5__1__Impl7695); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3841:1: rule__ScannerMultiLineRule__Group_5__2 : rule__ScannerMultiLineRule__Group_5__2__Impl ;
    public final void rule__ScannerMultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3845:1: ( rule__ScannerMultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3846:2: rule__ScannerMultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__2__Impl_in_rule__ScannerMultiLineRule__Group_5__27726);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3852:1: rule__ScannerMultiLineRule__Group_5__2__Impl : ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__ScannerMultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3856:1: ( ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3857:1: ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3857:1: ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3858:1: ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3859:1: ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3859:2: rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerMultiLineRule__Group_5__2__Impl7753);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3875:1: rule__PartitionMultiLineRule__Group__0 : rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1 ;
    public final void rule__PartitionMultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3879:1: ( rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3880:2: rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__0__Impl_in_rule__PartitionMultiLineRule__Group__07789);
            rule__PartitionMultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__1_in_rule__PartitionMultiLineRule__Group__07792);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3887:1: rule__PartitionMultiLineRule__Group__0__Impl : ( 'multi-line' ) ;
    public final void rule__PartitionMultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3891:1: ( ( 'multi-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3892:1: ( 'multi-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3892:1: ( 'multi-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3893:1: 'multi-line'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__PartitionMultiLineRule__Group__0__Impl7820); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3906:1: rule__PartitionMultiLineRule__Group__1 : rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2 ;
    public final void rule__PartitionMultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3910:1: ( rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3911:2: rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__1__Impl_in_rule__PartitionMultiLineRule__Group__17851);
            rule__PartitionMultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__2_in_rule__PartitionMultiLineRule__Group__17854);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3918:1: rule__PartitionMultiLineRule__Group__1__Impl : ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3922:1: ( ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3923:1: ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3923:1: ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3924:1: ( rule__PartitionMultiLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3925:1: ( rule__PartitionMultiLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3925:2: rule__PartitionMultiLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__ParitionAssignment_1_in_rule__PartitionMultiLineRule__Group__1__Impl7881);
            rule__PartitionMultiLineRule__ParitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPartitionMultiLineRuleAccess().getParitionAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3935:1: rule__PartitionMultiLineRule__Group__2 : rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3 ;
    public final void rule__PartitionMultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3939:1: ( rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3940:2: rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__2__Impl_in_rule__PartitionMultiLineRule__Group__27911);
            rule__PartitionMultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__3_in_rule__PartitionMultiLineRule__Group__27914);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3947:1: rule__PartitionMultiLineRule__Group__2__Impl : ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3951:1: ( ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3952:1: ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3952:1: ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3953:1: ( rule__PartitionMultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3954:1: ( rule__PartitionMultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3954:2: rule__PartitionMultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__StartSeqAssignment_2_in_rule__PartitionMultiLineRule__Group__2__Impl7941);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3964:1: rule__PartitionMultiLineRule__Group__3 : rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4 ;
    public final void rule__PartitionMultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3968:1: ( rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3969:2: rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__3__Impl_in_rule__PartitionMultiLineRule__Group__37971);
            rule__PartitionMultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__4_in_rule__PartitionMultiLineRule__Group__37974);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3976:1: rule__PartitionMultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__PartitionMultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3980:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3981:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3981:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3982:1: '=>'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__PartitionMultiLineRule__Group__3__Impl8002); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3995:1: rule__PartitionMultiLineRule__Group__4 : rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5 ;
    public final void rule__PartitionMultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3999:1: ( rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4000:2: rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__4__Impl_in_rule__PartitionMultiLineRule__Group__48033);
            rule__PartitionMultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__5_in_rule__PartitionMultiLineRule__Group__48036);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4007:1: rule__PartitionMultiLineRule__Group__4__Impl : ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4011:1: ( ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4012:1: ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4012:1: ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4013:1: ( rule__PartitionMultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4014:1: ( rule__PartitionMultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4014:2: rule__PartitionMultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__EndSeqAssignment_4_in_rule__PartitionMultiLineRule__Group__4__Impl8063);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4024:1: rule__PartitionMultiLineRule__Group__5 : rule__PartitionMultiLineRule__Group__5__Impl ;
    public final void rule__PartitionMultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4028:1: ( rule__PartitionMultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4029:2: rule__PartitionMultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__5__Impl_in_rule__PartitionMultiLineRule__Group__58093);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4035:1: rule__PartitionMultiLineRule__Group__5__Impl : ( ( rule__PartitionMultiLineRule__Group_5__0 )? ) ;
    public final void rule__PartitionMultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4039:1: ( ( ( rule__PartitionMultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4040:1: ( ( rule__PartitionMultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4040:1: ( ( rule__PartitionMultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4041:1: ( rule__PartitionMultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4042:1: ( rule__PartitionMultiLineRule__Group_5__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4042:2: rule__PartitionMultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__0_in_rule__PartitionMultiLineRule__Group__5__Impl8120);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4064:1: rule__PartitionMultiLineRule__Group_5__0 : rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1 ;
    public final void rule__PartitionMultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4068:1: ( rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4069:2: rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__0__Impl_in_rule__PartitionMultiLineRule__Group_5__08163);
            rule__PartitionMultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__1_in_rule__PartitionMultiLineRule__Group_5__08166);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4076:1: rule__PartitionMultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__PartitionMultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4080:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4081:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4081:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4082:1: 'escaped'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,36,FOLLOW_36_in_rule__PartitionMultiLineRule__Group_5__0__Impl8194); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4095:1: rule__PartitionMultiLineRule__Group_5__1 : rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2 ;
    public final void rule__PartitionMultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4099:1: ( rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4100:2: rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__1__Impl_in_rule__PartitionMultiLineRule__Group_5__18225);
            rule__PartitionMultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__2_in_rule__PartitionMultiLineRule__Group_5__18228);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4107:1: rule__PartitionMultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__PartitionMultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4111:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4112:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4112:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4113:1: 'by'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,37,FOLLOW_37_in_rule__PartitionMultiLineRule__Group_5__1__Impl8256); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4126:1: rule__PartitionMultiLineRule__Group_5__2 : rule__PartitionMultiLineRule__Group_5__2__Impl ;
    public final void rule__PartitionMultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4130:1: ( rule__PartitionMultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4131:2: rule__PartitionMultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__2__Impl_in_rule__PartitionMultiLineRule__Group_5__28287);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4137:1: rule__PartitionMultiLineRule__Group_5__2__Impl : ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__PartitionMultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4141:1: ( ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4142:1: ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4142:1: ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4143:1: ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4144:1: ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4144:2: rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionMultiLineRule__Group_5__2__Impl8314);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4160:1: rule__ScannerCharacterRule__Group__0 : rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1 ;
    public final void rule__ScannerCharacterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4164:1: ( rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4165:2: rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__0__Impl_in_rule__ScannerCharacterRule__Group__08350);
            rule__ScannerCharacterRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__1_in_rule__ScannerCharacterRule__Group__08353);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4172:1: rule__ScannerCharacterRule__Group__0__Impl : ( 'character-rule' ) ;
    public final void rule__ScannerCharacterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4176:1: ( ( 'character-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4177:1: ( 'character-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4177:1: ( 'character-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4178:1: 'character-rule'
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__ScannerCharacterRule__Group__0__Impl8381); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4191:1: rule__ScannerCharacterRule__Group__1 : rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2 ;
    public final void rule__ScannerCharacterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4195:1: ( rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4196:2: rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__1__Impl_in_rule__ScannerCharacterRule__Group__18412);
            rule__ScannerCharacterRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__2_in_rule__ScannerCharacterRule__Group__18415);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4203:1: rule__ScannerCharacterRule__Group__1__Impl : ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerCharacterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4207:1: ( ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4208:1: ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4208:1: ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4209:1: ( rule__ScannerCharacterRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4210:1: ( rule__ScannerCharacterRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4210:2: rule__ScannerCharacterRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__TokenAssignment_1_in_rule__ScannerCharacterRule__Group__1__Impl8442);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4220:1: rule__ScannerCharacterRule__Group__2 : rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3 ;
    public final void rule__ScannerCharacterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4224:1: ( rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4225:2: rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__2__Impl_in_rule__ScannerCharacterRule__Group__28472);
            rule__ScannerCharacterRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__3_in_rule__ScannerCharacterRule__Group__28475);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4232:1: rule__ScannerCharacterRule__Group__2__Impl : ( '[' ) ;
    public final void rule__ScannerCharacterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4236:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4237:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4237:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4238:1: '['
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2()); 
            match(input,30,FOLLOW_30_in_rule__ScannerCharacterRule__Group__2__Impl8503); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4251:1: rule__ScannerCharacterRule__Group__3 : rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4 ;
    public final void rule__ScannerCharacterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4255:1: ( rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4256:2: rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__3__Impl_in_rule__ScannerCharacterRule__Group__38534);
            rule__ScannerCharacterRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__4_in_rule__ScannerCharacterRule__Group__38537);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4263:1: rule__ScannerCharacterRule__Group__3__Impl : ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) ) ;
    public final void rule__ScannerCharacterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4267:1: ( ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4268:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4268:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4269:1: ( rule__ScannerCharacterRule__CharactersAssignment_3 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4270:1: ( rule__ScannerCharacterRule__CharactersAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4270:2: rule__ScannerCharacterRule__CharactersAssignment_3
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_3_in_rule__ScannerCharacterRule__Group__3__Impl8564);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4280:1: rule__ScannerCharacterRule__Group__4 : rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5 ;
    public final void rule__ScannerCharacterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4284:1: ( rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4285:2: rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__4__Impl_in_rule__ScannerCharacterRule__Group__48594);
            rule__ScannerCharacterRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__5_in_rule__ScannerCharacterRule__Group__48597);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4292:1: rule__ScannerCharacterRule__Group__4__Impl : ( ',' ) ;
    public final void rule__ScannerCharacterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4296:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4297:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4297:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4298:1: ','
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4()); 
            match(input,32,FOLLOW_32_in_rule__ScannerCharacterRule__Group__4__Impl8625); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4311:1: rule__ScannerCharacterRule__Group__5 : rule__ScannerCharacterRule__Group__5__Impl rule__ScannerCharacterRule__Group__6 ;
    public final void rule__ScannerCharacterRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4315:1: ( rule__ScannerCharacterRule__Group__5__Impl rule__ScannerCharacterRule__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4316:2: rule__ScannerCharacterRule__Group__5__Impl rule__ScannerCharacterRule__Group__6
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__5__Impl_in_rule__ScannerCharacterRule__Group__58656);
            rule__ScannerCharacterRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__6_in_rule__ScannerCharacterRule__Group__58659);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4323:1: rule__ScannerCharacterRule__Group__5__Impl : ( ( rule__ScannerCharacterRule__CharactersAssignment_5 ) ) ;
    public final void rule__ScannerCharacterRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4327:1: ( ( ( rule__ScannerCharacterRule__CharactersAssignment_5 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4328:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_5 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4328:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_5 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4329:1: ( rule__ScannerCharacterRule__CharactersAssignment_5 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4330:1: ( rule__ScannerCharacterRule__CharactersAssignment_5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4330:2: rule__ScannerCharacterRule__CharactersAssignment_5
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_5_in_rule__ScannerCharacterRule__Group__5__Impl8686);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4340:1: rule__ScannerCharacterRule__Group__6 : rule__ScannerCharacterRule__Group__6__Impl ;
    public final void rule__ScannerCharacterRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4344:1: ( rule__ScannerCharacterRule__Group__6__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4345:2: rule__ScannerCharacterRule__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__6__Impl_in_rule__ScannerCharacterRule__Group__68716);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4351:1: rule__ScannerCharacterRule__Group__6__Impl : ( ']' ) ;
    public final void rule__ScannerCharacterRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4355:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4356:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4356:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4357:1: ']'
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getRightSquareBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ScannerCharacterRule__Group__6__Impl8744); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4384:1: rule__ScannerJSRule__Group__0 : rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1 ;
    public final void rule__ScannerJSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4388:1: ( rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4389:2: rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__0__Impl_in_rule__ScannerJSRule__Group__08789);
            rule__ScannerJSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerJSRule__Group__1_in_rule__ScannerJSRule__Group__08792);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4396:1: rule__ScannerJSRule__Group__0__Impl : ( 'javascript-rule' ) ;
    public final void rule__ScannerJSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4400:1: ( ( 'javascript-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4401:1: ( 'javascript-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4401:1: ( 'javascript-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4402:1: 'javascript-rule'
            {
             before(grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__ScannerJSRule__Group__0__Impl8820); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4415:1: rule__ScannerJSRule__Group__1 : rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2 ;
    public final void rule__ScannerJSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4419:1: ( rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4420:2: rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__1__Impl_in_rule__ScannerJSRule__Group__18851);
            rule__ScannerJSRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerJSRule__Group__2_in_rule__ScannerJSRule__Group__18854);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4427:1: rule__ScannerJSRule__Group__1__Impl : ( ( rule__ScannerJSRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerJSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4431:1: ( ( ( rule__ScannerJSRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4432:1: ( ( rule__ScannerJSRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4432:1: ( ( rule__ScannerJSRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4433:1: ( rule__ScannerJSRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4434:1: ( rule__ScannerJSRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4434:2: rule__ScannerJSRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__TokenAssignment_1_in_rule__ScannerJSRule__Group__1__Impl8881);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4444:1: rule__ScannerJSRule__Group__2 : rule__ScannerJSRule__Group__2__Impl ;
    public final void rule__ScannerJSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4448:1: ( rule__ScannerJSRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4449:2: rule__ScannerJSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__2__Impl_in_rule__ScannerJSRule__Group__28911);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4455:1: rule__ScannerJSRule__Group__2__Impl : ( ( rule__ScannerJSRule__FileURIAssignment_2 ) ) ;
    public final void rule__ScannerJSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4459:1: ( ( ( rule__ScannerJSRule__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4460:1: ( ( rule__ScannerJSRule__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4460:1: ( ( rule__ScannerJSRule__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4461:1: ( rule__ScannerJSRule__FileURIAssignment_2 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4462:1: ( rule__ScannerJSRule__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4462:2: rule__ScannerJSRule__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__FileURIAssignment_2_in_rule__ScannerJSRule__Group__2__Impl8938);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4478:1: rule__PartitionJSRule__Group__0 : rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1 ;
    public final void rule__PartitionJSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4482:1: ( rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4483:2: rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__0__Impl_in_rule__PartitionJSRule__Group__08974);
            rule__PartitionJSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionJSRule__Group__1_in_rule__PartitionJSRule__Group__08977);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4490:1: rule__PartitionJSRule__Group__0__Impl : ( 'javascript-rule' ) ;
    public final void rule__PartitionJSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4494:1: ( ( 'javascript-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4495:1: ( 'javascript-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4495:1: ( 'javascript-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4496:1: 'javascript-rule'
            {
             before(grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__PartitionJSRule__Group__0__Impl9005); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4509:1: rule__PartitionJSRule__Group__1 : rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2 ;
    public final void rule__PartitionJSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4513:1: ( rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4514:2: rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__1__Impl_in_rule__PartitionJSRule__Group__19036);
            rule__PartitionJSRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionJSRule__Group__2_in_rule__PartitionJSRule__Group__19039);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4521:1: rule__PartitionJSRule__Group__1__Impl : ( ( rule__PartitionJSRule__TokenAssignment_1 ) ) ;
    public final void rule__PartitionJSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4525:1: ( ( ( rule__PartitionJSRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4526:1: ( ( rule__PartitionJSRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4526:1: ( ( rule__PartitionJSRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4527:1: ( rule__PartitionJSRule__TokenAssignment_1 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4528:1: ( rule__PartitionJSRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4528:2: rule__PartitionJSRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__TokenAssignment_1_in_rule__PartitionJSRule__Group__1__Impl9066);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4538:1: rule__PartitionJSRule__Group__2 : rule__PartitionJSRule__Group__2__Impl ;
    public final void rule__PartitionJSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4542:1: ( rule__PartitionJSRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4543:2: rule__PartitionJSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__2__Impl_in_rule__PartitionJSRule__Group__29096);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4549:1: rule__PartitionJSRule__Group__2__Impl : ( ( rule__PartitionJSRule__FileURIAssignment_2 ) ) ;
    public final void rule__PartitionJSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4553:1: ( ( ( rule__PartitionJSRule__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4554:1: ( ( rule__PartitionJSRule__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4554:1: ( ( rule__PartitionJSRule__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4555:1: ( rule__PartitionJSRule__FileURIAssignment_2 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4556:1: ( rule__PartitionJSRule__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4556:2: rule__PartitionJSRule__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__FileURIAssignment_2_in_rule__PartitionJSRule__Group__2__Impl9123);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4572:1: rule__ScannerWhitespaceRule__Group_0__0 : rule__ScannerWhitespaceRule__Group_0__0__Impl rule__ScannerWhitespaceRule__Group_0__1 ;
    public final void rule__ScannerWhitespaceRule__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4576:1: ( rule__ScannerWhitespaceRule__Group_0__0__Impl rule__ScannerWhitespaceRule__Group_0__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4577:2: rule__ScannerWhitespaceRule__Group_0__0__Impl rule__ScannerWhitespaceRule__Group_0__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__0__Impl_in_rule__ScannerWhitespaceRule__Group_0__09159);
            rule__ScannerWhitespaceRule__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__1_in_rule__ScannerWhitespaceRule__Group_0__09162);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4584:1: rule__ScannerWhitespaceRule__Group_0__0__Impl : ( 'whitespace-rule' ) ;
    public final void rule__ScannerWhitespaceRule__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4588:1: ( ( 'whitespace-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4589:1: ( 'whitespace-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4589:1: ( 'whitespace-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4590:1: 'whitespace-rule'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0_0()); 
            match(input,41,FOLLOW_41_in_rule__ScannerWhitespaceRule__Group_0__0__Impl9190); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4603:1: rule__ScannerWhitespaceRule__Group_0__1 : rule__ScannerWhitespaceRule__Group_0__1__Impl rule__ScannerWhitespaceRule__Group_0__2 ;
    public final void rule__ScannerWhitespaceRule__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4607:1: ( rule__ScannerWhitespaceRule__Group_0__1__Impl rule__ScannerWhitespaceRule__Group_0__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4608:2: rule__ScannerWhitespaceRule__Group_0__1__Impl rule__ScannerWhitespaceRule__Group_0__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__1__Impl_in_rule__ScannerWhitespaceRule__Group_0__19221);
            rule__ScannerWhitespaceRule__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__2_in_rule__ScannerWhitespaceRule__Group_0__19224);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4615:1: rule__ScannerWhitespaceRule__Group_0__1__Impl : ( ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )? ) ;
    public final void rule__ScannerWhitespaceRule__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4619:1: ( ( ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4620:1: ( ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4620:1: ( ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4621:1: ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )?
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenAssignment_0_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4622:1: ( rule__ScannerWhitespaceRule__TokenAssignment_0_1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4622:2: rule__ScannerWhitespaceRule__TokenAssignment_0_1
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__TokenAssignment_0_1_in_rule__ScannerWhitespaceRule__Group_0__1__Impl9251);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4632:1: rule__ScannerWhitespaceRule__Group_0__2 : rule__ScannerWhitespaceRule__Group_0__2__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4636:1: ( rule__ScannerWhitespaceRule__Group_0__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4637:2: rule__ScannerWhitespaceRule__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0__2__Impl_in_rule__ScannerWhitespaceRule__Group_0__29282);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4643:1: rule__ScannerWhitespaceRule__Group_0__2__Impl : ( ( rule__ScannerWhitespaceRule__Group_0_2__0 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4647:1: ( ( ( rule__ScannerWhitespaceRule__Group_0_2__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4648:1: ( ( rule__ScannerWhitespaceRule__Group_0_2__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4648:1: ( ( rule__ScannerWhitespaceRule__Group_0_2__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4649:1: ( rule__ScannerWhitespaceRule__Group_0_2__0 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_0_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4650:1: ( rule__ScannerWhitespaceRule__Group_0_2__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4650:2: rule__ScannerWhitespaceRule__Group_0_2__0
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__0_in_rule__ScannerWhitespaceRule__Group_0__2__Impl9309);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4666:1: rule__ScannerWhitespaceRule__Group_0_2__0 : rule__ScannerWhitespaceRule__Group_0_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2__1 ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4670:1: ( rule__ScannerWhitespaceRule__Group_0_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4671:2: rule__ScannerWhitespaceRule__Group_0_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__09345);
            rule__ScannerWhitespaceRule__Group_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__1_in_rule__ScannerWhitespaceRule__Group_0_2__09348);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4678:1: rule__ScannerWhitespaceRule__Group_0_2__0__Impl : ( '[' ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4682:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4683:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4683:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4684:1: '['
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_0_2_0()); 
            match(input,30,FOLLOW_30_in_rule__ScannerWhitespaceRule__Group_0_2__0__Impl9376); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4697:1: rule__ScannerWhitespaceRule__Group_0_2__1 : rule__ScannerWhitespaceRule__Group_0_2__1__Impl rule__ScannerWhitespaceRule__Group_0_2__2 ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4701:1: ( rule__ScannerWhitespaceRule__Group_0_2__1__Impl rule__ScannerWhitespaceRule__Group_0_2__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4702:2: rule__ScannerWhitespaceRule__Group_0_2__1__Impl rule__ScannerWhitespaceRule__Group_0_2__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__19407);
            rule__ScannerWhitespaceRule__Group_0_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__2_in_rule__ScannerWhitespaceRule__Group_0_2__19410);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4709:1: rule__ScannerWhitespaceRule__Group_0_2__1__Impl : ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4713:1: ( ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4714:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4714:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4715:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_0_2_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4716:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4716:2: rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1_in_rule__ScannerWhitespaceRule__Group_0_2__1__Impl9437);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4726:1: rule__ScannerWhitespaceRule__Group_0_2__2 : rule__ScannerWhitespaceRule__Group_0_2__2__Impl rule__ScannerWhitespaceRule__Group_0_2__3 ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4730:1: ( rule__ScannerWhitespaceRule__Group_0_2__2__Impl rule__ScannerWhitespaceRule__Group_0_2__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4731:2: rule__ScannerWhitespaceRule__Group_0_2__2__Impl rule__ScannerWhitespaceRule__Group_0_2__3
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__2__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__29467);
            rule__ScannerWhitespaceRule__Group_0_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__3_in_rule__ScannerWhitespaceRule__Group_0_2__29470);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4738:1: rule__ScannerWhitespaceRule__Group_0_2__2__Impl : ( ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )* ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4742:1: ( ( ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4743:1: ( ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4743:1: ( ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4744:1: ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )*
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_0_2_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4745:1: ( rule__ScannerWhitespaceRule__Group_0_2_2__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==32) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4745:2: rule__ScannerWhitespaceRule__Group_0_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__0_in_rule__ScannerWhitespaceRule__Group_0_2__2__Impl9497);
            	    rule__ScannerWhitespaceRule__Group_0_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4755:1: rule__ScannerWhitespaceRule__Group_0_2__3 : rule__ScannerWhitespaceRule__Group_0_2__3__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4759:1: ( rule__ScannerWhitespaceRule__Group_0_2__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4760:2: rule__ScannerWhitespaceRule__Group_0_2__3__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__3__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__39528);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4766:1: rule__ScannerWhitespaceRule__Group_0_2__3__Impl : ( ']' ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4770:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4771:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4771:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4772:1: ']'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_0_2_3()); 
            match(input,31,FOLLOW_31_in_rule__ScannerWhitespaceRule__Group_0_2__3__Impl9556); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4793:1: rule__ScannerWhitespaceRule__Group_0_2_2__0 : rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2_2__1 ;
    public final void rule__ScannerWhitespaceRule__Group_0_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4797:1: ( rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2_2__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4798:2: rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl rule__ScannerWhitespaceRule__Group_0_2_2__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_0_2_2__09595);
            rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__1_in_rule__ScannerWhitespaceRule__Group_0_2_2__09598);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4805:1: rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl : ( ',' ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4809:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4810:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4810:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4811:1: ','
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_0_2_2_0()); 
            match(input,32,FOLLOW_32_in_rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl9626); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4824:1: rule__ScannerWhitespaceRule__Group_0_2_2__1 : rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_0_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4828:1: ( rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4829:2: rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_0_2_2__19657);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4835:1: rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl : ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4839:1: ( ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4840:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4840:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4841:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_0_2_2_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4842:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4842:2: rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1_in_rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl9684);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4856:1: rule__ScannerWhitespaceRule__Group_1__0 : rule__ScannerWhitespaceRule__Group_1__0__Impl rule__ScannerWhitespaceRule__Group_1__1 ;
    public final void rule__ScannerWhitespaceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4860:1: ( rule__ScannerWhitespaceRule__Group_1__0__Impl rule__ScannerWhitespaceRule__Group_1__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4861:2: rule__ScannerWhitespaceRule__Group_1__0__Impl rule__ScannerWhitespaceRule__Group_1__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__0__Impl_in_rule__ScannerWhitespaceRule__Group_1__09718);
            rule__ScannerWhitespaceRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__1_in_rule__ScannerWhitespaceRule__Group_1__09721);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4868:1: rule__ScannerWhitespaceRule__Group_1__0__Impl : ( '#{' ) ;
    public final void rule__ScannerWhitespaceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4872:1: ( ( '#{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4873:1: ( '#{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4873:1: ( '#{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4874:1: '#{'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getNumberSignLeftCurlyBracketKeyword_1_0()); 
            match(input,42,FOLLOW_42_in_rule__ScannerWhitespaceRule__Group_1__0__Impl9749); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4887:1: rule__ScannerWhitespaceRule__Group_1__1 : rule__ScannerWhitespaceRule__Group_1__1__Impl rule__ScannerWhitespaceRule__Group_1__2 ;
    public final void rule__ScannerWhitespaceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4891:1: ( rule__ScannerWhitespaceRule__Group_1__1__Impl rule__ScannerWhitespaceRule__Group_1__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4892:2: rule__ScannerWhitespaceRule__Group_1__1__Impl rule__ScannerWhitespaceRule__Group_1__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__1__Impl_in_rule__ScannerWhitespaceRule__Group_1__19780);
            rule__ScannerWhitespaceRule__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__2_in_rule__ScannerWhitespaceRule__Group_1__19783);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4899:1: rule__ScannerWhitespaceRule__Group_1__1__Impl : ( ( rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4903:1: ( ( ( rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4904:1: ( ( rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4904:1: ( ( rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4905:1: ( rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getJsDetectorAssignment_1_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4906:1: ( rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4906:2: rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1_in_rule__ScannerWhitespaceRule__Group_1__1__Impl9810);
            rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getJsDetectorAssignment_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4916:1: rule__ScannerWhitespaceRule__Group_1__2 : rule__ScannerWhitespaceRule__Group_1__2__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4920:1: ( rule__ScannerWhitespaceRule__Group_1__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4921:2: rule__ScannerWhitespaceRule__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_1__2__Impl_in_rule__ScannerWhitespaceRule__Group_1__29840);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4927:1: rule__ScannerWhitespaceRule__Group_1__2__Impl : ( '}#' ) ;
    public final void rule__ScannerWhitespaceRule__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4931:1: ( ( '}#' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4932:1: ( '}#' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4932:1: ( '}#' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4933:1: '}#'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getRightCurlyBracketNumberSignKeyword_1_2()); 
            match(input,43,FOLLOW_43_in_rule__ScannerWhitespaceRule__Group_1__2__Impl9868); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4952:1: rule__RGBColor__Group__0 : rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1 ;
    public final void rule__RGBColor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4956:1: ( rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4957:2: rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__0__Impl_in_rule__RGBColor__Group__09905);
            rule__RGBColor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__1_in_rule__RGBColor__Group__09908);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4964:1: rule__RGBColor__Group__0__Impl : ( 'rgb' ) ;
    public final void rule__RGBColor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4968:1: ( ( 'rgb' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4969:1: ( 'rgb' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4969:1: ( 'rgb' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4970:1: 'rgb'
            {
             before(grammarAccess.getRGBColorAccess().getRgbKeyword_0()); 
            match(input,44,FOLLOW_44_in_rule__RGBColor__Group__0__Impl9936); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4983:1: rule__RGBColor__Group__1 : rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2 ;
    public final void rule__RGBColor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4987:1: ( rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4988:2: rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__1__Impl_in_rule__RGBColor__Group__19967);
            rule__RGBColor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__2_in_rule__RGBColor__Group__19970);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4995:1: rule__RGBColor__Group__1__Impl : ( '(' ) ;
    public final void rule__RGBColor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4999:1: ( ( '(' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5000:1: ( '(' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5000:1: ( '(' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5001:1: '('
            {
             before(grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1()); 
            match(input,45,FOLLOW_45_in_rule__RGBColor__Group__1__Impl9998); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5014:1: rule__RGBColor__Group__2 : rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3 ;
    public final void rule__RGBColor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5018:1: ( rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5019:2: rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__2__Impl_in_rule__RGBColor__Group__210029);
            rule__RGBColor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__3_in_rule__RGBColor__Group__210032);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5026:1: rule__RGBColor__Group__2__Impl : ( ( rule__RGBColor__RAssignment_2 ) ) ;
    public final void rule__RGBColor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5030:1: ( ( ( rule__RGBColor__RAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5031:1: ( ( rule__RGBColor__RAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5031:1: ( ( rule__RGBColor__RAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5032:1: ( rule__RGBColor__RAssignment_2 )
            {
             before(grammarAccess.getRGBColorAccess().getRAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5033:1: ( rule__RGBColor__RAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5033:2: rule__RGBColor__RAssignment_2
            {
            pushFollow(FOLLOW_rule__RGBColor__RAssignment_2_in_rule__RGBColor__Group__2__Impl10059);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5043:1: rule__RGBColor__Group__3 : rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4 ;
    public final void rule__RGBColor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5047:1: ( rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5048:2: rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__3__Impl_in_rule__RGBColor__Group__310089);
            rule__RGBColor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__4_in_rule__RGBColor__Group__310092);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5055:1: rule__RGBColor__Group__3__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5059:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5060:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5060:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5061:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__RGBColor__Group__3__Impl10120); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5074:1: rule__RGBColor__Group__4 : rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5 ;
    public final void rule__RGBColor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5078:1: ( rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5079:2: rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__4__Impl_in_rule__RGBColor__Group__410151);
            rule__RGBColor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__5_in_rule__RGBColor__Group__410154);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5086:1: rule__RGBColor__Group__4__Impl : ( ( rule__RGBColor__GAssignment_4 ) ) ;
    public final void rule__RGBColor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5090:1: ( ( ( rule__RGBColor__GAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5091:1: ( ( rule__RGBColor__GAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5091:1: ( ( rule__RGBColor__GAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5092:1: ( rule__RGBColor__GAssignment_4 )
            {
             before(grammarAccess.getRGBColorAccess().getGAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5093:1: ( rule__RGBColor__GAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5093:2: rule__RGBColor__GAssignment_4
            {
            pushFollow(FOLLOW_rule__RGBColor__GAssignment_4_in_rule__RGBColor__Group__4__Impl10181);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5103:1: rule__RGBColor__Group__5 : rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6 ;
    public final void rule__RGBColor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5107:1: ( rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5108:2: rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__5__Impl_in_rule__RGBColor__Group__510211);
            rule__RGBColor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__6_in_rule__RGBColor__Group__510214);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5115:1: rule__RGBColor__Group__5__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5119:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5120:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5120:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5121:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_5()); 
            match(input,32,FOLLOW_32_in_rule__RGBColor__Group__5__Impl10242); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5134:1: rule__RGBColor__Group__6 : rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7 ;
    public final void rule__RGBColor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5138:1: ( rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5139:2: rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__6__Impl_in_rule__RGBColor__Group__610273);
            rule__RGBColor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__7_in_rule__RGBColor__Group__610276);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5146:1: rule__RGBColor__Group__6__Impl : ( ( rule__RGBColor__BAssignment_6 ) ) ;
    public final void rule__RGBColor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5150:1: ( ( ( rule__RGBColor__BAssignment_6 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5151:1: ( ( rule__RGBColor__BAssignment_6 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5151:1: ( ( rule__RGBColor__BAssignment_6 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5152:1: ( rule__RGBColor__BAssignment_6 )
            {
             before(grammarAccess.getRGBColorAccess().getBAssignment_6()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5153:1: ( rule__RGBColor__BAssignment_6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5153:2: rule__RGBColor__BAssignment_6
            {
            pushFollow(FOLLOW_rule__RGBColor__BAssignment_6_in_rule__RGBColor__Group__6__Impl10303);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5163:1: rule__RGBColor__Group__7 : rule__RGBColor__Group__7__Impl ;
    public final void rule__RGBColor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5167:1: ( rule__RGBColor__Group__7__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5168:2: rule__RGBColor__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__7__Impl_in_rule__RGBColor__Group__710333);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5174:1: rule__RGBColor__Group__7__Impl : ( ')' ) ;
    public final void rule__RGBColor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5178:1: ( ( ')' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5179:1: ( ')' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5179:1: ( ')' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5180:1: ')'
            {
             before(grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_7()); 
            match(input,46,FOLLOW_46_in_rule__RGBColor__Group__7__Impl10361); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5209:1: rule__Font__Group__0 : rule__Font__Group__0__Impl rule__Font__Group__1 ;
    public final void rule__Font__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5213:1: ( rule__Font__Group__0__Impl rule__Font__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5214:2: rule__Font__Group__0__Impl rule__Font__Group__1
            {
            pushFollow(FOLLOW_rule__Font__Group__0__Impl_in_rule__Font__Group__010408);
            rule__Font__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Font__Group__1_in_rule__Font__Group__010411);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5221:1: rule__Font__Group__0__Impl : ( ( rule__Font__NameAssignment_0 ) ) ;
    public final void rule__Font__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5225:1: ( ( ( rule__Font__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5226:1: ( ( rule__Font__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5226:1: ( ( rule__Font__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5227:1: ( rule__Font__NameAssignment_0 )
            {
             before(grammarAccess.getFontAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5228:1: ( rule__Font__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5228:2: rule__Font__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Font__NameAssignment_0_in_rule__Font__Group__0__Impl10438);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5238:1: rule__Font__Group__1 : rule__Font__Group__1__Impl rule__Font__Group__2 ;
    public final void rule__Font__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5242:1: ( rule__Font__Group__1__Impl rule__Font__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5243:2: rule__Font__Group__1__Impl rule__Font__Group__2
            {
            pushFollow(FOLLOW_rule__Font__Group__1__Impl_in_rule__Font__Group__110468);
            rule__Font__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Font__Group__2_in_rule__Font__Group__110471);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5250:1: rule__Font__Group__1__Impl : ( ( rule__Font__SizeAssignment_1 ) ) ;
    public final void rule__Font__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5254:1: ( ( ( rule__Font__SizeAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5255:1: ( ( rule__Font__SizeAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5255:1: ( ( rule__Font__SizeAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5256:1: ( rule__Font__SizeAssignment_1 )
            {
             before(grammarAccess.getFontAccess().getSizeAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5257:1: ( rule__Font__SizeAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5257:2: rule__Font__SizeAssignment_1
            {
            pushFollow(FOLLOW_rule__Font__SizeAssignment_1_in_rule__Font__Group__1__Impl10498);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5267:1: rule__Font__Group__2 : rule__Font__Group__2__Impl ;
    public final void rule__Font__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5271:1: ( rule__Font__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5272:2: rule__Font__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Font__Group__2__Impl_in_rule__Font__Group__210528);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5278:1: rule__Font__Group__2__Impl : ( ( rule__Font__AttributesAssignment_2 )* ) ;
    public final void rule__Font__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5282:1: ( ( ( rule__Font__AttributesAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5283:1: ( ( rule__Font__AttributesAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5283:1: ( ( rule__Font__AttributesAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5284:1: ( rule__Font__AttributesAssignment_2 )*
            {
             before(grammarAccess.getFontAccess().getAttributesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5285:1: ( rule__Font__AttributesAssignment_2 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=11 && LA27_0<=14)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5285:2: rule__Font__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Font__AttributesAssignment_2_in_rule__Font__Group__2__Impl10555);
            	    rule__Font__AttributesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5302:1: rule__Model__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5306:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5307:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5307:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5308:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Model__NameAssignment_010597); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5317:1: rule__Model__PartitionsAssignment_2 : ( rulePartition ) ;
    public final void rule__Model__PartitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5321:1: ( ( rulePartition ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5322:1: ( rulePartition )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5322:1: ( rulePartition )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5323:1: rulePartition
            {
             before(grammarAccess.getModelAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_rulePartition_in_rule__Model__PartitionsAssignment_210628);
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


    // $ANTLR start "rule__Model__DamagersAssignment_3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5332:1: rule__Model__DamagersAssignment_3 : ( ruleDamager ) ;
    public final void rule__Model__DamagersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5336:1: ( ( ruleDamager ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5337:1: ( ruleDamager )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5337:1: ( ruleDamager )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5338:1: ruleDamager
            {
             before(grammarAccess.getModelAccess().getDamagersDamagerParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDamager_in_rule__Model__DamagersAssignment_310659);
            ruleDamager();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDamagersDamagerParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DamagersAssignment_3"


    // $ANTLR start "rule__Model__PartitionerAssignment_4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5347:1: rule__Model__PartitionerAssignment_4 : ( rulePartitioner ) ;
    public final void rule__Model__PartitionerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5351:1: ( ( rulePartitioner ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5352:1: ( rulePartitioner )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5352:1: ( rulePartitioner )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5353:1: rulePartitioner
            {
             before(grammarAccess.getModelAccess().getPartitionerPartitionerParserRuleCall_4_0()); 
            pushFollow(FOLLOW_rulePartitioner_in_rule__Model__PartitionerAssignment_410690);
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


    // $ANTLR start "rule__Model__ContentTypesAssignment_7"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5362:1: rule__Model__ContentTypesAssignment_7 : ( RULE_STRING ) ;
    public final void rule__Model__ContentTypesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5366:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5367:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5367:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5368:1: RULE_STRING
            {
             before(grammarAccess.getModelAccess().getContentTypesSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Model__ContentTypesAssignment_710721); 
             after(grammarAccess.getModelAccess().getContentTypesSTRINGTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ContentTypesAssignment_7"


    // $ANTLR start "rule__Partition__NameAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5377:1: rule__Partition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Partition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5381:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5382:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5382:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5383:1: RULE_ID
            {
             before(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_110752); 
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


    // $ANTLR start "rule__JavaLikeParitioner__SingleLineParitionAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5392:1: rule__JavaLikeParitioner__SingleLineParitionAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__SingleLineParitionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5396:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5397:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5397:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5398:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineParitionPartitionCrossReference_2_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5399:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5400:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineParitionPartitionIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__SingleLineParitionAssignment_210787); 
             after(grammarAccess.getJavaLikeParitionerAccess().getSingleLineParitionPartitionIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getJavaLikeParitionerAccess().getSingleLineParitionPartitionCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__SingleLineParitionAssignment_2"


    // $ANTLR start "rule__JavaLikeParitioner__MultiLineParitionAssignment_3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5411:1: rule__JavaLikeParitioner__MultiLineParitionAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__MultiLineParitionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5415:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5416:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5416:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5417:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineParitionPartitionCrossReference_3_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5418:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5419:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineParitionPartitionIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__MultiLineParitionAssignment_310826); 
             after(grammarAccess.getJavaLikeParitionerAccess().getMultiLineParitionPartitionIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getJavaLikeParitionerAccess().getMultiLineParitionPartitionCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__MultiLineParitionAssignment_3"


    // $ANTLR start "rule__JavaLikeParitioner__JavaDocParitionAssignment_4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5430:1: rule__JavaLikeParitioner__JavaDocParitionAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__JavaDocParitionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5434:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5435:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5435:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5436:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionCrossReference_4_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5437:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5438:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__JavaDocParitionAssignment_410865); 
             after(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__JavaDocParitionAssignment_4"


    // $ANTLR start "rule__JavaLikeParitioner__CharacterParitionAssignment_5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5449:1: rule__JavaLikeParitioner__CharacterParitionAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__CharacterParitionAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5453:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5454:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5454:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5455:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionCrossReference_5_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5456:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5457:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__CharacterParitionAssignment_510904); 
             after(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__CharacterParitionAssignment_5"


    // $ANTLR start "rule__JavaLikeParitioner__StringParitionAssignment_6"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5468:1: rule__JavaLikeParitioner__StringParitionAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__StringParitionAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5472:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5473:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5473:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5474:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionCrossReference_6_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5475:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5476:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__StringParitionAssignment_610943); 
             after(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionIDTerminalRuleCall_6_0_1()); 

            }

             after(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__StringParitionAssignment_6"


    // $ANTLR start "rule__RulePartitioner__RulesAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5487:1: rule__RulePartitioner__RulesAssignment_2 : ( ruleParitionRule ) ;
    public final void rule__RulePartitioner__RulesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5491:1: ( ( ruleParitionRule ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5492:1: ( ruleParitionRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5492:1: ( ruleParitionRule )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5493:1: ruleParitionRule
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesParitionRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParitionRule_in_rule__RulePartitioner__RulesAssignment_210978);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5502:1: rule__JSParitioner__FileURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JSParitioner__FileURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5506:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5507:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5507:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5508:1: RULE_STRING
            {
             before(grammarAccess.getJSParitionerAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JSParitioner__FileURIAssignment_111009); 
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


    // $ANTLR start "rule__JSDamager__PartitionAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5517:1: rule__JSDamager__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__JSDamager__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5521:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5522:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5522:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5523:1: ( RULE_ID )
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5524:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5525:1: RULE_ID
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JSDamager__PartitionAssignment_111044); 
             after(grammarAccess.getJSDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getJSDamagerAccess().getPartitionPartitionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSDamager__PartitionAssignment_1"


    // $ANTLR start "rule__JSDamager__FileURIAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5536:1: rule__JSDamager__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__JSDamager__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5540:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5541:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5541:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5542:1: RULE_STRING
            {
             before(grammarAccess.getJSDamagerAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JSDamager__FileURIAssignment_211079); 
             after(grammarAccess.getJSDamagerAccess().getFileURISTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSDamager__FileURIAssignment_2"


    // $ANTLR start "rule__RuleDamager__PartitionAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5551:1: rule__RuleDamager__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__RuleDamager__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5555:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5556:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5556:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5557:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5558:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5559:1: RULE_ID
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RuleDamager__PartitionAssignment_111114); 
             after(grammarAccess.getRuleDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getRuleDamagerAccess().getPartitionPartitionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__PartitionAssignment_1"


    // $ANTLR start "rule__RuleDamager__TokensAssignment_3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5570:1: rule__RuleDamager__TokensAssignment_3 : ( ruleScannerToken ) ;
    public final void rule__RuleDamager__TokensAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5574:1: ( ( ruleScannerToken ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5575:1: ( ruleScannerToken )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5575:1: ( ruleScannerToken )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5576:1: ruleScannerToken
            {
             before(grammarAccess.getRuleDamagerAccess().getTokensScannerTokenParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleScannerToken_in_rule__RuleDamager__TokensAssignment_311149);
            ruleScannerToken();

            state._fsp--;

             after(grammarAccess.getRuleDamagerAccess().getTokensScannerTokenParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__TokensAssignment_3"


    // $ANTLR start "rule__RuleDamager__KeywordGroupsAssignment_4"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5585:1: rule__RuleDamager__KeywordGroupsAssignment_4 : ( ruleKeywordGroup ) ;
    public final void rule__RuleDamager__KeywordGroupsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5589:1: ( ( ruleKeywordGroup ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5590:1: ( ruleKeywordGroup )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5590:1: ( ruleKeywordGroup )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5591:1: ruleKeywordGroup
            {
             before(grammarAccess.getRuleDamagerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_rule__RuleDamager__KeywordGroupsAssignment_411180);
            ruleKeywordGroup();

            state._fsp--;

             after(grammarAccess.getRuleDamagerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__KeywordGroupsAssignment_4"


    // $ANTLR start "rule__RuleDamager__RulesAssignment_5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5600:1: rule__RuleDamager__RulesAssignment_5 : ( ruleScannerRule ) ;
    public final void rule__RuleDamager__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5604:1: ( ( ruleScannerRule ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5605:1: ( ruleScannerRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5605:1: ( ruleScannerRule )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5606:1: ruleScannerRule
            {
             before(grammarAccess.getRuleDamagerAccess().getRulesScannerRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleScannerRule_in_rule__RuleDamager__RulesAssignment_511211);
            ruleScannerRule();

            state._fsp--;

             after(grammarAccess.getRuleDamagerAccess().getRulesScannerRuleParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDamager__RulesAssignment_5"


    // $ANTLR start "rule__ScannerToken__DefaultAssignment_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5615:1: rule__ScannerToken__DefaultAssignment_0 : ( ( 'default' ) ) ;
    public final void rule__ScannerToken__DefaultAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5619:1: ( ( ( 'default' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5620:1: ( ( 'default' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5620:1: ( ( 'default' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5621:1: ( 'default' )
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5622:1: ( 'default' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5623:1: 'default'
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 
            match(input,47,FOLLOW_47_in_rule__ScannerToken__DefaultAssignment_011247); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5638:1: rule__ScannerToken__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ScannerToken__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5642:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5643:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5643:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5644:1: RULE_ID
            {
             before(grammarAccess.getScannerTokenAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerToken__NameAssignment_211286); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5653:1: rule__ScannerToken__FgColorAssignment_3_1_2 : ( ruleColor ) ;
    public final void rule__ScannerToken__FgColorAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5657:1: ( ( ruleColor ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5658:1: ( ruleColor )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5658:1: ( ruleColor )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5659:1: ruleColor
            {
             before(grammarAccess.getScannerTokenAccess().getFgColorColorParserRuleCall_3_1_2_0()); 
            pushFollow(FOLLOW_ruleColor_in_rule__ScannerToken__FgColorAssignment_3_1_211317);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5668:1: rule__ScannerToken__BgColorAssignment_3_2_2 : ( ruleColor ) ;
    public final void rule__ScannerToken__BgColorAssignment_3_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5672:1: ( ( ruleColor ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5673:1: ( ruleColor )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5673:1: ( ruleColor )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5674:1: ruleColor
            {
             before(grammarAccess.getScannerTokenAccess().getBgColorColorParserRuleCall_3_2_2_0()); 
            pushFollow(FOLLOW_ruleColor_in_rule__ScannerToken__BgColorAssignment_3_2_211348);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5683:1: rule__ScannerToken__FontAssignment_3_3_2 : ( ruleFont ) ;
    public final void rule__ScannerToken__FontAssignment_3_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5687:1: ( ( ruleFont ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5688:1: ( ruleFont )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5688:1: ( ruleFont )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5689:1: ruleFont
            {
             before(grammarAccess.getScannerTokenAccess().getFontFontParserRuleCall_3_3_2_0()); 
            pushFollow(FOLLOW_ruleFont_in_rule__ScannerToken__FontAssignment_3_3_211379);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5698:1: rule__KeywordGroup__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__KeywordGroup__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5702:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5703:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5703:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5704:1: ( RULE_ID )
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5705:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5706:1: RULE_ID
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeywordGroup__TokenAssignment_111414); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5717:1: rule__KeywordGroup__KeywordsAssignment_3 : ( ruleKeyword ) ;
    public final void rule__KeywordGroup__KeywordsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5721:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5722:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5722:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5723:1: ruleKeyword
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_311449);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5732:1: rule__KeywordGroup__KeywordsAssignment_4_1 : ( ruleKeyword ) ;
    public final void rule__KeywordGroup__KeywordsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5736:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5737:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5737:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5738:1: ruleKeyword
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_4_111480);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5747:1: rule__Keyword__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Keyword__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5751:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5752:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5752:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5753:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_011511); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5762:1: rule__Keyword__VersionAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Keyword__VersionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5766:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5767:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5767:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5768:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_111542); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5777:1: rule__ScannerSingleLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerSingleLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5781:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5782:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5782:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5783:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5784:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5785:1: RULE_ID
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerSingleLineRule__TokenAssignment_111577); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5796:1: rule__ScannerSingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5800:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5801:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5801:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5802:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__StartSeqAssignment_211612); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5811:1: rule__ScannerSingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5815:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5816:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5816:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5817:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EndSeqAssignment_411643); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5826:1: rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5830:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5831:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5831:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5832:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_211674); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5841:1: rule__PartitionSingleLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionSingleLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5845:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5846:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5846:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5847:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5848:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5849:1: RULE_ID
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionSingleLineRule__ParitionAssignment_111709); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5860:1: rule__PartitionSingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5864:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5865:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5865:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5866:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__StartSeqAssignment_211744); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5875:1: rule__PartitionSingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5879:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5880:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5880:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5881:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EndSeqAssignment_411775); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5890:1: rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5894:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5895:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5895:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5896:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_211806); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5905:1: rule__ScannerMultiLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerMultiLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5909:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5910:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5910:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5911:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5912:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5913:1: RULE_ID
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerMultiLineRule__TokenAssignment_111841); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5924:1: rule__ScannerMultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5928:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5929:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5929:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5930:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__StartSeqAssignment_211876); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5939:1: rule__ScannerMultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5943:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5944:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5944:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5945:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EndSeqAssignment_411907); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5954:1: rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5958:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5959:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5959:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5960:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_211938); 
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


    // $ANTLR start "rule__PartitionMultiLineRule__ParitionAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5969:1: rule__PartitionMultiLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionMultiLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5973:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5974:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5974:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5975:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5976:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5977:1: RULE_ID
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionMultiLineRule__ParitionAssignment_111973); 
             after(grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartitionMultiLineRule__ParitionAssignment_1"


    // $ANTLR start "rule__PartitionMultiLineRule__StartSeqAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5988:1: rule__PartitionMultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5992:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5993:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5993:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5994:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__StartSeqAssignment_212008); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6003:1: rule__PartitionMultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6007:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6008:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6008:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6009:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EndSeqAssignment_412039); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6018:1: rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6022:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6023:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6023:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6024:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_212070); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6033:1: rule__ScannerCharacterRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerCharacterRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6037:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6038:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6038:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6039:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6040:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6041:1: RULE_ID
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerCharacterRule__TokenAssignment_112105); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6052:1: rule__ScannerCharacterRule__CharactersAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ScannerCharacterRule__CharactersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6056:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6057:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6057:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6058:1: RULE_STRING
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_312140); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6067:1: rule__ScannerCharacterRule__CharactersAssignment_5 : ( RULE_STRING ) ;
    public final void rule__ScannerCharacterRule__CharactersAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6071:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6072:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6072:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6073:1: RULE_STRING
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_512171); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6082:1: rule__ScannerJSRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerJSRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6086:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6087:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6087:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6088:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6089:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6090:1: RULE_ID
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerJSRule__TokenAssignment_112206); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6101:1: rule__ScannerJSRule__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerJSRule__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6105:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6106:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6106:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6107:1: RULE_STRING
            {
             before(grammarAccess.getScannerJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerJSRule__FileURIAssignment_212241); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6116:1: rule__PartitionJSRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionJSRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6120:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6121:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6121:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6122:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6123:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6124:1: RULE_ID
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionJSRule__TokenAssignment_112276); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6135:1: rule__PartitionJSRule__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionJSRule__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6139:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6140:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6140:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6141:1: RULE_STRING
            {
             before(grammarAccess.getPartitionJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionJSRule__FileURIAssignment_212311); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6150:1: rule__ScannerWhitespaceRule__TokenAssignment_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerWhitespaceRule__TokenAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6154:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6155:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6155:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6156:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_0_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6157:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6158:1: RULE_ID
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenIDTerminalRuleCall_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerWhitespaceRule__TokenAssignment_0_112346); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6169:1: rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6173:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6174:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6174:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6175:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_0_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_112381); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6184:1: rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6188:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6189:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6189:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6190:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_0_2_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_112412); 
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


    // $ANTLR start "rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6199:1: rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1 : ( RULE_ANY_OTHER ) ;
    public final void rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6203:1: ( ( RULE_ANY_OTHER ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6204:1: ( RULE_ANY_OTHER )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6204:1: ( RULE_ANY_OTHER )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6205:1: RULE_ANY_OTHER
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getJsDetectorANY_OTHERTerminalRuleCall_1_1_0()); 
            match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_rule__ScannerWhitespaceRule__JsDetectorAssignment_1_112443); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getJsDetectorANY_OTHERTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1"


    // $ANTLR start "rule__RGBColor__RAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6214:1: rule__RGBColor__RAssignment_2 : ( RULE_INT ) ;
    public final void rule__RGBColor__RAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6218:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6219:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6219:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6220:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getRINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__RAssignment_212474); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6229:1: rule__RGBColor__GAssignment_4 : ( RULE_INT ) ;
    public final void rule__RGBColor__GAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6233:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6234:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6234:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6235:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getGINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__GAssignment_412505); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6244:1: rule__RGBColor__BAssignment_6 : ( RULE_INT ) ;
    public final void rule__RGBColor__BAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6248:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6249:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6249:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6250:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getBINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__BAssignment_612536); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6259:1: rule__Font__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Font__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6263:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6264:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6264:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6265:1: RULE_ID
            {
             before(grammarAccess.getFontAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Font__NameAssignment_012567); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6274:1: rule__Font__SizeAssignment_1 : ( RULE_INT ) ;
    public final void rule__Font__SizeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6278:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6279:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6279:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6280:1: RULE_INT
            {
             before(grammarAccess.getFontAccess().getSizeINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Font__SizeAssignment_112598); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6289:1: rule__Font__AttributesAssignment_2 : ( ruleFontType ) ;
    public final void rule__Font__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6293:1: ( ( ruleFontType ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6294:1: ( ruleFontType )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6294:1: ( ruleFontType )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6295:1: ruleFontType
            {
             before(grammarAccess.getFontAccess().getAttributesFontTypeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleFontType_in_rule__Font__AttributesAssignment_212629);
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
    public static final BitSet FOLLOW_ruleJavaLikeParitioner_in_entryRuleJavaLikeParitioner241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaLikeParitioner248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__0_in_ruleJavaLikeParitioner274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRulePartitioner308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__0_in_ruleRulePartitioner334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSParitioner368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__0_in_ruleJSParitioner394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDamager_in_entryRuleDamager421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDamager428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Damager__Alternatives_in_ruleDamager454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_entryRuleJSDamager481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSDamager488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__0_in_ruleJSDamager514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_entryRuleRuleDamager541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDamager548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__0_in_ruleRuleDamager574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_entryRuleScannerToken601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerToken608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__0_in_ruleScannerToken634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordGroup668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__0_in_ruleKeywordGroup694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0_in_ruleKeyword754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_entryRuleScannerRule781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerRule788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerRule__Alternatives_in_ruleScannerRule814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_entryRuleParitionRule841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitionRule848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParitionRule__Alternatives_in_ruleParitionRule874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerSingleLineRule908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__0_in_ruleScannerSingleLineRule934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionSingleLineRule968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__0_in_rulePartitionSingleLineRule994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerMultiLineRule1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__0_in_ruleScannerMultiLineRule1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionMultiLineRule1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__0_in_rulePartitionMultiLineRule1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule1141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerCharacterRule1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__0_in_ruleScannerCharacterRule1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule1201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerJSRule1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__0_in_ruleScannerJSRule1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule1261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionJSRule1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__0_in_rulePartitionJSRule1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerWhitespaceRule1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Alternatives_in_ruleScannerWhitespaceRule1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor1381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_ruleColor1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_entryRuleRGBColor1440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGBColor1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__0_in_ruleRGBColor1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFont_in_entryRuleFont1500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFont1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__0_in_ruleFont1533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FontType__Alternatives_in_ruleFontType1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_rule__Partitioner__Alternatives1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaLikeParitioner_in_rule__Partitioner__Alternatives1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_rule__Partitioner__Alternatives1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_rule__Damager__Alternatives1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_rule__Damager__Alternatives1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_rule__ScannerRule__Alternatives1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_rule__ScannerRule__Alternatives1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_rule__ScannerRule__Alternatives1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_rule__ScannerRule__Alternatives1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_rule__ScannerRule__Alternatives1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_rule__ParitionRule__Alternatives1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_rule__ParitionRule__Alternatives1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_rule__ParitionRule__Alternatives1854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__0_in_rule__ScannerWhitespaceRule__Alternatives1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__0_in_rule__ScannerWhitespaceRule__Alternatives1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__FontType__Alternatives1938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__FontType__Alternatives1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__FontType__Alternatives1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__FontType__Alternatives2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02034 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NameAssignment_0_in_rule__Model__Group__0__Impl2064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12094 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Model__Group__1__Impl2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22156 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__22159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2188 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2200 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__32233 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__32236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2265 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2277 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__42310 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Model__Group__5_in_rule__Model__Group__42313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionerAssignment_4_in_rule__Model__Group__4__Impl2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__52370 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Model__Group__6_in_rule__Model__Group__52373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Model__Group__5__Impl2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__6__Impl_in_rule__Model__Group__62432 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Model__Group__7_in_rule__Model__Group__62435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Model__Group__6__Impl2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__7__Impl_in_rule__Model__Group__72494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2523 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2535 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__02584 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__02587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Partition__Group__0__Impl2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__12646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl2673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__0__Impl_in_rule__JavaLikeParitioner__Group__02707 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__1_in_rule__JavaLikeParitioner__Group__02710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__JavaLikeParitioner__Group__0__Impl2738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__1__Impl_in_rule__JavaLikeParitioner__Group__12769 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__2_in_rule__JavaLikeParitioner__Group__12772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JavaLikeParitioner__Group__1__Impl2800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__2__Impl_in_rule__JavaLikeParitioner__Group__22831 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__3_in_rule__JavaLikeParitioner__Group__22834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__SingleLineParitionAssignment_2_in_rule__JavaLikeParitioner__Group__2__Impl2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__3__Impl_in_rule__JavaLikeParitioner__Group__32891 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__4_in_rule__JavaLikeParitioner__Group__32894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__MultiLineParitionAssignment_3_in_rule__JavaLikeParitioner__Group__3__Impl2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__4__Impl_in_rule__JavaLikeParitioner__Group__42951 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__5_in_rule__JavaLikeParitioner__Group__42954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__JavaDocParitionAssignment_4_in_rule__JavaLikeParitioner__Group__4__Impl2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__5__Impl_in_rule__JavaLikeParitioner__Group__53011 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__6_in_rule__JavaLikeParitioner__Group__53014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__CharacterParitionAssignment_5_in_rule__JavaLikeParitioner__Group__5__Impl3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__6__Impl_in_rule__JavaLikeParitioner__Group__63071 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__7_in_rule__JavaLikeParitioner__Group__63074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__StringParitionAssignment_6_in_rule__JavaLikeParitioner__Group__6__Impl3101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__7__Impl_in_rule__JavaLikeParitioner__Group__73131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JavaLikeParitioner__Group__7__Impl3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__0__Impl_in_rule__RulePartitioner__Group__03206 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__1_in_rule__RulePartitioner__Group__03209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__RulePartitioner__Group__0__Impl3237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__1__Impl_in_rule__RulePartitioner__Group__13268 = new BitSet(new long[]{0x0000014400000000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__2_in_rule__RulePartitioner__Group__13271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__RulePartitioner__Group__1__Impl3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__2__Impl_in_rule__RulePartitioner__Group__23330 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__3_in_rule__RulePartitioner__Group__23333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3362 = new BitSet(new long[]{0x0000014400000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3374 = new BitSet(new long[]{0x0000014400000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__3__Impl_in_rule__RulePartitioner__Group__33407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__RulePartitioner__Group__3__Impl3435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__0__Impl_in_rule__JSParitioner__Group__03474 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__1_in_rule__JSParitioner__Group__03477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__JSParitioner__Group__0__Impl3505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__1__Impl_in_rule__JSParitioner__Group__13536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__FileURIAssignment_1_in_rule__JSParitioner__Group__1__Impl3563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__0__Impl_in_rule__JSDamager__Group__03597 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__1_in_rule__JSDamager__Group__03600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__JSDamager__Group__0__Impl3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__1__Impl_in_rule__JSDamager__Group__13659 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__2_in_rule__JSDamager__Group__13662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__PartitionAssignment_1_in_rule__JSDamager__Group__1__Impl3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__2__Impl_in_rule__JSDamager__Group__23719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__FileURIAssignment_2_in_rule__JSDamager__Group__2__Impl3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__0__Impl_in_rule__RuleDamager__Group__03782 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__1_in_rule__RuleDamager__Group__03785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__RuleDamager__Group__0__Impl3813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__1__Impl_in_rule__RuleDamager__Group__13844 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__2_in_rule__RuleDamager__Group__13847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__PartitionAssignment_1_in_rule__RuleDamager__Group__1__Impl3874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__2__Impl_in_rule__RuleDamager__Group__23904 = new BitSet(new long[]{0x000087C421000000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__3_in_rule__RuleDamager__Group__23907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__RuleDamager__Group__2__Impl3935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__3__Impl_in_rule__RuleDamager__Group__33966 = new BitSet(new long[]{0x000087C421000000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__4_in_rule__RuleDamager__Group__33969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__TokensAssignment_3_in_rule__RuleDamager__Group__3__Impl3996 = new BitSet(new long[]{0x0000800001000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__4__Impl_in_rule__RuleDamager__Group__44027 = new BitSet(new long[]{0x000087C421000000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__5_in_rule__RuleDamager__Group__44030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__KeywordGroupsAssignment_4_in_rule__RuleDamager__Group__4__Impl4057 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__5__Impl_in_rule__RuleDamager__Group__54088 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__6_in_rule__RuleDamager__Group__54091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__RulesAssignment_5_in_rule__RuleDamager__Group__5__Impl4120 = new BitSet(new long[]{0x000087C421000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__RulesAssignment_5_in_rule__RuleDamager__Group__5__Impl4132 = new BitSet(new long[]{0x000087C421000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__6__Impl_in_rule__RuleDamager__Group__64165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__RuleDamager__Group__6__Impl4193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__0__Impl_in_rule__ScannerToken__Group__04238 = new BitSet(new long[]{0x0000800001000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__1_in_rule__ScannerToken__Group__04241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__DefaultAssignment_0_in_rule__ScannerToken__Group__0__Impl4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__1__Impl_in_rule__ScannerToken__Group__14299 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__2_in_rule__ScannerToken__Group__14302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ScannerToken__Group__1__Impl4330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__2__Impl_in_rule__ScannerToken__Group__24361 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__3_in_rule__ScannerToken__Group__24364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__NameAssignment_2_in_rule__ScannerToken__Group__2__Impl4391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__3__Impl_in_rule__ScannerToken__Group__34421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__0_in_rule__ScannerToken__Group__3__Impl4448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__0__Impl_in_rule__ScannerToken__Group_3__04487 = new BitSet(new long[]{0x000000001A010000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__1_in_rule__ScannerToken__Group_3__04490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ScannerToken__Group_3__0__Impl4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__1__Impl_in_rule__ScannerToken__Group_3__14549 = new BitSet(new long[]{0x000000001A010000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__2_in_rule__ScannerToken__Group_3__14552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__0_in_rule__ScannerToken__Group_3__1__Impl4579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__2__Impl_in_rule__ScannerToken__Group_3__24610 = new BitSet(new long[]{0x000000001A010000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__3_in_rule__ScannerToken__Group_3__24613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__0_in_rule__ScannerToken__Group_3__2__Impl4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__3__Impl_in_rule__ScannerToken__Group_3__34671 = new BitSet(new long[]{0x000000001A010000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__4_in_rule__ScannerToken__Group_3__34674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__0_in_rule__ScannerToken__Group_3__3__Impl4701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__4__Impl_in_rule__ScannerToken__Group_3__44732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ScannerToken__Group_3__4__Impl4760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__0__Impl_in_rule__ScannerToken__Group_3_1__04801 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__1_in_rule__ScannerToken__Group_3_1__04804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ScannerToken__Group_3_1__0__Impl4832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__1__Impl_in_rule__ScannerToken__Group_3_1__14863 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__2_in_rule__ScannerToken__Group_3_1__14866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ScannerToken__Group_3_1__1__Impl4894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__2__Impl_in_rule__ScannerToken__Group_3_1__24925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__FgColorAssignment_3_1_2_in_rule__ScannerToken__Group_3_1__2__Impl4952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__0__Impl_in_rule__ScannerToken__Group_3_2__04988 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__1_in_rule__ScannerToken__Group_3_2__04991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ScannerToken__Group_3_2__0__Impl5019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__1__Impl_in_rule__ScannerToken__Group_3_2__15050 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__2_in_rule__ScannerToken__Group_3_2__15053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ScannerToken__Group_3_2__1__Impl5081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__2__Impl_in_rule__ScannerToken__Group_3_2__25112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__BgColorAssignment_3_2_2_in_rule__ScannerToken__Group_3_2__2__Impl5139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__0__Impl_in_rule__ScannerToken__Group_3_3__05175 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__1_in_rule__ScannerToken__Group_3_3__05178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ScannerToken__Group_3_3__0__Impl5206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__1__Impl_in_rule__ScannerToken__Group_3_3__15237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__2_in_rule__ScannerToken__Group_3_3__15240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ScannerToken__Group_3_3__1__Impl5268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__2__Impl_in_rule__ScannerToken__Group_3_3__25299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__FontAssignment_3_3_2_in_rule__ScannerToken__Group_3_3__2__Impl5326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__0__Impl_in_rule__KeywordGroup__Group__05362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__1_in_rule__KeywordGroup__Group__05365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__KeywordGroup__Group__0__Impl5393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__1__Impl_in_rule__KeywordGroup__Group__15424 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__2_in_rule__KeywordGroup__Group__15427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__TokenAssignment_1_in_rule__KeywordGroup__Group__1__Impl5454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__2__Impl_in_rule__KeywordGroup__Group__25484 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__3_in_rule__KeywordGroup__Group__25487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__KeywordGroup__Group__2__Impl5515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__3__Impl_in_rule__KeywordGroup__Group__35546 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__4_in_rule__KeywordGroup__Group__35549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__KeywordsAssignment_3_in_rule__KeywordGroup__Group__3__Impl5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__4__Impl_in_rule__KeywordGroup__Group__45606 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__5_in_rule__KeywordGroup__Group__45609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__0_in_rule__KeywordGroup__Group__4__Impl5636 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__5__Impl_in_rule__KeywordGroup__Group__55667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__KeywordGroup__Group__5__Impl5695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__0__Impl_in_rule__KeywordGroup__Group_4__05738 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__1_in_rule__KeywordGroup__Group_4__05741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__KeywordGroup__Group_4__0__Impl5769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__1__Impl_in_rule__KeywordGroup__Group_4__15800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__KeywordsAssignment_4_1_in_rule__KeywordGroup__Group_4__1__Impl5827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__05861 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__05864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl5891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__15921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl5948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__05983 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__05986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Keyword__Group_1__0__Impl6014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__16045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl6072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__0__Impl_in_rule__ScannerSingleLineRule__Group__06106 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__1_in_rule__ScannerSingleLineRule__Group__06109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ScannerSingleLineRule__Group__0__Impl6137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__1__Impl_in_rule__ScannerSingleLineRule__Group__16168 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__2_in_rule__ScannerSingleLineRule__Group__16171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__TokenAssignment_1_in_rule__ScannerSingleLineRule__Group__1__Impl6198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__2__Impl_in_rule__ScannerSingleLineRule__Group__26228 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__3_in_rule__ScannerSingleLineRule__Group__26231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__StartSeqAssignment_2_in_rule__ScannerSingleLineRule__Group__2__Impl6258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__3__Impl_in_rule__ScannerSingleLineRule__Group__36288 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__4_in_rule__ScannerSingleLineRule__Group__36291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ScannerSingleLineRule__Group__3__Impl6319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__4__Impl_in_rule__ScannerSingleLineRule__Group__46350 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__5_in_rule__ScannerSingleLineRule__Group__46353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__EndSeqAssignment_4_in_rule__ScannerSingleLineRule__Group__4__Impl6380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__5__Impl_in_rule__ScannerSingleLineRule__Group__56410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__0_in_rule__ScannerSingleLineRule__Group__5__Impl6437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__0__Impl_in_rule__ScannerSingleLineRule__Group_5__06480 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__1_in_rule__ScannerSingleLineRule__Group_5__06483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ScannerSingleLineRule__Group_5__0__Impl6511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__1__Impl_in_rule__ScannerSingleLineRule__Group_5__16542 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__2_in_rule__ScannerSingleLineRule__Group_5__16545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ScannerSingleLineRule__Group_5__1__Impl6573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__2__Impl_in_rule__ScannerSingleLineRule__Group_5__26604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerSingleLineRule__Group_5__2__Impl6631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__0__Impl_in_rule__PartitionSingleLineRule__Group__06667 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__1_in_rule__PartitionSingleLineRule__Group__06670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__PartitionSingleLineRule__Group__0__Impl6698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__1__Impl_in_rule__PartitionSingleLineRule__Group__16729 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__2_in_rule__PartitionSingleLineRule__Group__16732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__ParitionAssignment_1_in_rule__PartitionSingleLineRule__Group__1__Impl6759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__2__Impl_in_rule__PartitionSingleLineRule__Group__26789 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__3_in_rule__PartitionSingleLineRule__Group__26792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__StartSeqAssignment_2_in_rule__PartitionSingleLineRule__Group__2__Impl6819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__3__Impl_in_rule__PartitionSingleLineRule__Group__36849 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__4_in_rule__PartitionSingleLineRule__Group__36852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__PartitionSingleLineRule__Group__3__Impl6880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__4__Impl_in_rule__PartitionSingleLineRule__Group__46911 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__5_in_rule__PartitionSingleLineRule__Group__46914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__EndSeqAssignment_4_in_rule__PartitionSingleLineRule__Group__4__Impl6941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__5__Impl_in_rule__PartitionSingleLineRule__Group__56971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__0_in_rule__PartitionSingleLineRule__Group__5__Impl6998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__0__Impl_in_rule__PartitionSingleLineRule__Group_5__07041 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__1_in_rule__PartitionSingleLineRule__Group_5__07044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PartitionSingleLineRule__Group_5__0__Impl7072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__1__Impl_in_rule__PartitionSingleLineRule__Group_5__17103 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__2_in_rule__PartitionSingleLineRule__Group_5__17106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__PartitionSingleLineRule__Group_5__1__Impl7134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__2__Impl_in_rule__PartitionSingleLineRule__Group_5__27165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionSingleLineRule__Group_5__2__Impl7192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__0__Impl_in_rule__ScannerMultiLineRule__Group__07228 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__1_in_rule__ScannerMultiLineRule__Group__07231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ScannerMultiLineRule__Group__0__Impl7259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__1__Impl_in_rule__ScannerMultiLineRule__Group__17290 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__2_in_rule__ScannerMultiLineRule__Group__17293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__TokenAssignment_1_in_rule__ScannerMultiLineRule__Group__1__Impl7320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__2__Impl_in_rule__ScannerMultiLineRule__Group__27350 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__3_in_rule__ScannerMultiLineRule__Group__27353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__StartSeqAssignment_2_in_rule__ScannerMultiLineRule__Group__2__Impl7380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__3__Impl_in_rule__ScannerMultiLineRule__Group__37410 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__4_in_rule__ScannerMultiLineRule__Group__37413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ScannerMultiLineRule__Group__3__Impl7441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__4__Impl_in_rule__ScannerMultiLineRule__Group__47472 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__5_in_rule__ScannerMultiLineRule__Group__47475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__EndSeqAssignment_4_in_rule__ScannerMultiLineRule__Group__4__Impl7502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__5__Impl_in_rule__ScannerMultiLineRule__Group__57532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__0_in_rule__ScannerMultiLineRule__Group__5__Impl7559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__0__Impl_in_rule__ScannerMultiLineRule__Group_5__07602 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__1_in_rule__ScannerMultiLineRule__Group_5__07605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ScannerMultiLineRule__Group_5__0__Impl7633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__1__Impl_in_rule__ScannerMultiLineRule__Group_5__17664 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__2_in_rule__ScannerMultiLineRule__Group_5__17667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ScannerMultiLineRule__Group_5__1__Impl7695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__2__Impl_in_rule__ScannerMultiLineRule__Group_5__27726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerMultiLineRule__Group_5__2__Impl7753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__0__Impl_in_rule__PartitionMultiLineRule__Group__07789 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__1_in_rule__PartitionMultiLineRule__Group__07792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__PartitionMultiLineRule__Group__0__Impl7820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__1__Impl_in_rule__PartitionMultiLineRule__Group__17851 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__2_in_rule__PartitionMultiLineRule__Group__17854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__ParitionAssignment_1_in_rule__PartitionMultiLineRule__Group__1__Impl7881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__2__Impl_in_rule__PartitionMultiLineRule__Group__27911 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__3_in_rule__PartitionMultiLineRule__Group__27914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__StartSeqAssignment_2_in_rule__PartitionMultiLineRule__Group__2__Impl7941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__3__Impl_in_rule__PartitionMultiLineRule__Group__37971 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__4_in_rule__PartitionMultiLineRule__Group__37974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__PartitionMultiLineRule__Group__3__Impl8002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__4__Impl_in_rule__PartitionMultiLineRule__Group__48033 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__5_in_rule__PartitionMultiLineRule__Group__48036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__EndSeqAssignment_4_in_rule__PartitionMultiLineRule__Group__4__Impl8063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__5__Impl_in_rule__PartitionMultiLineRule__Group__58093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__0_in_rule__PartitionMultiLineRule__Group__5__Impl8120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__0__Impl_in_rule__PartitionMultiLineRule__Group_5__08163 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__1_in_rule__PartitionMultiLineRule__Group_5__08166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PartitionMultiLineRule__Group_5__0__Impl8194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__1__Impl_in_rule__PartitionMultiLineRule__Group_5__18225 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__2_in_rule__PartitionMultiLineRule__Group_5__18228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__PartitionMultiLineRule__Group_5__1__Impl8256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__2__Impl_in_rule__PartitionMultiLineRule__Group_5__28287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionMultiLineRule__Group_5__2__Impl8314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__0__Impl_in_rule__ScannerCharacterRule__Group__08350 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__1_in_rule__ScannerCharacterRule__Group__08353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ScannerCharacterRule__Group__0__Impl8381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__1__Impl_in_rule__ScannerCharacterRule__Group__18412 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__2_in_rule__ScannerCharacterRule__Group__18415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__TokenAssignment_1_in_rule__ScannerCharacterRule__Group__1__Impl8442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__2__Impl_in_rule__ScannerCharacterRule__Group__28472 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__3_in_rule__ScannerCharacterRule__Group__28475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ScannerCharacterRule__Group__2__Impl8503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__3__Impl_in_rule__ScannerCharacterRule__Group__38534 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__4_in_rule__ScannerCharacterRule__Group__38537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_3_in_rule__ScannerCharacterRule__Group__3__Impl8564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__4__Impl_in_rule__ScannerCharacterRule__Group__48594 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__5_in_rule__ScannerCharacterRule__Group__48597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ScannerCharacterRule__Group__4__Impl8625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__5__Impl_in_rule__ScannerCharacterRule__Group__58656 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__6_in_rule__ScannerCharacterRule__Group__58659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_5_in_rule__ScannerCharacterRule__Group__5__Impl8686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__6__Impl_in_rule__ScannerCharacterRule__Group__68716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ScannerCharacterRule__Group__6__Impl8744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__0__Impl_in_rule__ScannerJSRule__Group__08789 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__1_in_rule__ScannerJSRule__Group__08792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ScannerJSRule__Group__0__Impl8820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__1__Impl_in_rule__ScannerJSRule__Group__18851 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__2_in_rule__ScannerJSRule__Group__18854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__TokenAssignment_1_in_rule__ScannerJSRule__Group__1__Impl8881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__2__Impl_in_rule__ScannerJSRule__Group__28911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__FileURIAssignment_2_in_rule__ScannerJSRule__Group__2__Impl8938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__0__Impl_in_rule__PartitionJSRule__Group__08974 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__1_in_rule__PartitionJSRule__Group__08977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__PartitionJSRule__Group__0__Impl9005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__1__Impl_in_rule__PartitionJSRule__Group__19036 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__2_in_rule__PartitionJSRule__Group__19039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__TokenAssignment_1_in_rule__PartitionJSRule__Group__1__Impl9066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__2__Impl_in_rule__PartitionJSRule__Group__29096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__FileURIAssignment_2_in_rule__PartitionJSRule__Group__2__Impl9123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__0__Impl_in_rule__ScannerWhitespaceRule__Group_0__09159 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__1_in_rule__ScannerWhitespaceRule__Group_0__09162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ScannerWhitespaceRule__Group_0__0__Impl9190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__1__Impl_in_rule__ScannerWhitespaceRule__Group_0__19221 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__2_in_rule__ScannerWhitespaceRule__Group_0__19224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__TokenAssignment_0_1_in_rule__ScannerWhitespaceRule__Group_0__1__Impl9251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0__2__Impl_in_rule__ScannerWhitespaceRule__Group_0__29282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__0_in_rule__ScannerWhitespaceRule__Group_0__2__Impl9309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__09345 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__1_in_rule__ScannerWhitespaceRule__Group_0_2__09348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ScannerWhitespaceRule__Group_0_2__0__Impl9376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__19407 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__2_in_rule__ScannerWhitespaceRule__Group_0_2__19410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_1_in_rule__ScannerWhitespaceRule__Group_0_2__1__Impl9437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__2__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__29467 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__3_in_rule__ScannerWhitespaceRule__Group_0_2__29470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__0_in_rule__ScannerWhitespaceRule__Group_0_2__2__Impl9497 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2__3__Impl_in_rule__ScannerWhitespaceRule__Group_0_2__39528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ScannerWhitespaceRule__Group_0_2__3__Impl9556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_0_2_2__09595 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__1_in_rule__ScannerWhitespaceRule__Group_0_2_2__09598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ScannerWhitespaceRule__Group_0_2_2__0__Impl9626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_0_2_2__19657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_1_in_rule__ScannerWhitespaceRule__Group_0_2_2__1__Impl9684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__0__Impl_in_rule__ScannerWhitespaceRule__Group_1__09718 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__1_in_rule__ScannerWhitespaceRule__Group_1__09721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ScannerWhitespaceRule__Group_1__0__Impl9749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__1__Impl_in_rule__ScannerWhitespaceRule__Group_1__19780 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__2_in_rule__ScannerWhitespaceRule__Group_1__19783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__JsDetectorAssignment_1_1_in_rule__ScannerWhitespaceRule__Group_1__1__Impl9810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_1__2__Impl_in_rule__ScannerWhitespaceRule__Group_1__29840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ScannerWhitespaceRule__Group_1__2__Impl9868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__0__Impl_in_rule__RGBColor__Group__09905 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__1_in_rule__RGBColor__Group__09908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__RGBColor__Group__0__Impl9936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__1__Impl_in_rule__RGBColor__Group__19967 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__2_in_rule__RGBColor__Group__19970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__RGBColor__Group__1__Impl9998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__2__Impl_in_rule__RGBColor__Group__210029 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__3_in_rule__RGBColor__Group__210032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__RAssignment_2_in_rule__RGBColor__Group__2__Impl10059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__3__Impl_in_rule__RGBColor__Group__310089 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__4_in_rule__RGBColor__Group__310092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__RGBColor__Group__3__Impl10120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__4__Impl_in_rule__RGBColor__Group__410151 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__5_in_rule__RGBColor__Group__410154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__GAssignment_4_in_rule__RGBColor__Group__4__Impl10181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__5__Impl_in_rule__RGBColor__Group__510211 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__6_in_rule__RGBColor__Group__510214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__RGBColor__Group__5__Impl10242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__6__Impl_in_rule__RGBColor__Group__610273 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__7_in_rule__RGBColor__Group__610276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__BAssignment_6_in_rule__RGBColor__Group__6__Impl10303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__7__Impl_in_rule__RGBColor__Group__710333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__RGBColor__Group__7__Impl10361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__0__Impl_in_rule__Font__Group__010408 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Font__Group__1_in_rule__Font__Group__010411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__NameAssignment_0_in_rule__Font__Group__0__Impl10438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__1__Impl_in_rule__Font__Group__110468 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__Font__Group__2_in_rule__Font__Group__110471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__SizeAssignment_1_in_rule__Font__Group__1__Impl10498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__2__Impl_in_rule__Font__Group__210528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__AttributesAssignment_2_in_rule__Font__Group__2__Impl10555 = new BitSet(new long[]{0x0000000000007802L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_010597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_rule__Model__PartitionsAssignment_210628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDamager_in_rule__Model__DamagersAssignment_310659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_rule__Model__PartitionerAssignment_410690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Model__ContentTypesAssignment_710721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_110752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__SingleLineParitionAssignment_210787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__MultiLineParitionAssignment_310826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__JavaDocParitionAssignment_410865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__CharacterParitionAssignment_510904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__StringParitionAssignment_610943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_rule__RulePartitioner__RulesAssignment_210978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JSParitioner__FileURIAssignment_111009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JSDamager__PartitionAssignment_111044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JSDamager__FileURIAssignment_211079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RuleDamager__PartitionAssignment_111114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_rule__RuleDamager__TokensAssignment_311149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_rule__RuleDamager__KeywordGroupsAssignment_411180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_rule__RuleDamager__RulesAssignment_511211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ScannerToken__DefaultAssignment_011247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerToken__NameAssignment_211286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__ScannerToken__FgColorAssignment_3_1_211317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__ScannerToken__BgColorAssignment_3_2_211348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFont_in_rule__ScannerToken__FontAssignment_3_3_211379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeywordGroup__TokenAssignment_111414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_311449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_4_111480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_011511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_111542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerSingleLineRule__TokenAssignment_111577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__StartSeqAssignment_211612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EndSeqAssignment_411643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_211674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionSingleLineRule__ParitionAssignment_111709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__StartSeqAssignment_211744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EndSeqAssignment_411775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_211806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerMultiLineRule__TokenAssignment_111841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__StartSeqAssignment_211876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EndSeqAssignment_411907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_211938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionMultiLineRule__ParitionAssignment_111973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__StartSeqAssignment_212008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EndSeqAssignment_412039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_212070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerCharacterRule__TokenAssignment_112105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_312140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_512171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerJSRule__TokenAssignment_112206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerJSRule__FileURIAssignment_212241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionJSRule__TokenAssignment_112276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionJSRule__FileURIAssignment_212311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerWhitespaceRule__TokenAssignment_0_112346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_112381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_0_2_2_112412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_rule__ScannerWhitespaceRule__JsDetectorAssignment_1_112443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__RAssignment_212474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__GAssignment_412505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__BAssignment_612536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Font__NameAssignment_012567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Font__SizeAssignment_112598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFontType_in_rule__Font__AttributesAssignment_212629 = new BitSet(new long[]{0x0000000000000002L});

}