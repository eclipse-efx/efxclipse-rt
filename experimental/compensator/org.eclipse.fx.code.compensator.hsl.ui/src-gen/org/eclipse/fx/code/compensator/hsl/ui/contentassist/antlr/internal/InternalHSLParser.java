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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'bold'", "'italic'", "'underline'", "'strike-through'", "'{'", "'}'", "'for'", "'partition'", "'java-like-partitioner'", "'singlelinedoc'", "'multilinedoc'", "'javadoc'", "'char'", "'string'", "'rule-partitioner'", "'js-partitioner'", "'js-damager'", "'rule-damager'", "'token'", "'fgcolor'", "':'", "'bgcolor'", "'font'", "'keywords'", "'['", "']'", "','", "'since'", "'single-line'", "'=>'", "'escaped'", "'by'", "'multi-line'", "'character-rule'", "'javascript-rule'", "'whitespace-rule'", "'rgb'", "'('", "')'", "'default'", "'javawhitespace'"
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:657:1: ruleScannerWhitespaceRule : ( ( rule__ScannerWhitespaceRule__Group__0 ) ) ;
    public final void ruleScannerWhitespaceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:661:2: ( ( ( rule__ScannerWhitespaceRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:662:1: ( ( rule__ScannerWhitespaceRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:662:1: ( ( rule__ScannerWhitespaceRule__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:663:1: ( rule__ScannerWhitespaceRule__Group__0 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:664:1: ( rule__ScannerWhitespaceRule__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:664:2: rule__ScannerWhitespaceRule__Group__0
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__0_in_ruleScannerWhitespaceRule1354);
            rule__ScannerWhitespaceRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getGroup()); 

            }


            }

        }
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
            case 25:
                {
                alt1=1;
                }
                break;
            case 19:
                {
                alt1=2;
                }
                break;
            case 26:
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

            if ( (LA2_0==28) ) {
                alt2=1;
            }
            else if ( (LA2_0==27) ) {
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
            case 39:
                {
                alt3=1;
                }
                break;
            case 43:
                {
                alt3=2;
                }
                break;
            case 44:
                {
                alt3=3;
                }
                break;
            case 45:
                {
                alt3=4;
                }
                break;
            case 46:
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
            case 39:
                {
                alt4=1;
                }
                break;
            case 43:
                {
                alt4=2;
                }
                break;
            case 45:
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


    // $ANTLR start "rule__ScannerWhitespaceRule__Alternatives_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:897:1: rule__ScannerWhitespaceRule__Alternatives_2 : ( ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) ) | ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) ) | ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) ) );
    public final void rule__ScannerWhitespaceRule__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:901:1: ( ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) ) | ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) ) | ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt5=1;
                }
                break;
            case 51:
                {
                alt5=2;
                }
                break;
            case RULE_STRING:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:902:1: ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:902:1: ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:903:1: ( rule__ScannerWhitespaceRule__Group_2_0__0 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_2_0()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:904:1: ( rule__ScannerWhitespaceRule__Group_2_0__0 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:904:2: rule__ScannerWhitespaceRule__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0_in_rule__ScannerWhitespaceRule__Alternatives_21886);
                    rule__ScannerWhitespaceRule__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:908:6: ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:908:6: ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:909:1: ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceAssignment_2_1()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:910:1: ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:910:2: rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1_in_rule__ScannerWhitespaceRule__Alternatives_21904);
                    rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:914:6: ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:914:6: ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:915:1: ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getFileURIAssignment_2_2()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:916:1: ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:916:2: rule__ScannerWhitespaceRule__FileURIAssignment_2_2
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__FileURIAssignment_2_2_in_rule__ScannerWhitespaceRule__Alternatives_21922);
                    rule__ScannerWhitespaceRule__FileURIAssignment_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScannerWhitespaceRuleAccess().getFileURIAssignment_2_2()); 

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
    // $ANTLR end "rule__ScannerWhitespaceRule__Alternatives_2"


    // $ANTLR start "rule__FontType__Alternatives"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:925:1: rule__FontType__Alternatives : ( ( ( 'bold' ) ) | ( ( 'italic' ) ) | ( ( 'underline' ) ) | ( ( 'strike-through' ) ) );
    public final void rule__FontType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:929:1: ( ( ( 'bold' ) ) | ( ( 'italic' ) ) | ( ( 'underline' ) ) | ( ( 'strike-through' ) ) )
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
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:930:1: ( ( 'bold' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:930:1: ( ( 'bold' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:931:1: ( 'bold' )
                    {
                     before(grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:932:1: ( 'bold' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:932:3: 'bold'
                    {
                    match(input,11,FOLLOW_11_in_rule__FontType__Alternatives1956); 

                    }

                     after(grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:937:6: ( ( 'italic' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:937:6: ( ( 'italic' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:938:1: ( 'italic' )
                    {
                     before(grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:939:1: ( 'italic' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:939:3: 'italic'
                    {
                    match(input,12,FOLLOW_12_in_rule__FontType__Alternatives1977); 

                    }

                     after(grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:944:6: ( ( 'underline' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:944:6: ( ( 'underline' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:945:1: ( 'underline' )
                    {
                     before(grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:946:1: ( 'underline' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:946:3: 'underline'
                    {
                    match(input,13,FOLLOW_13_in_rule__FontType__Alternatives1998); 

                    }

                     after(grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:951:6: ( ( 'strike-through' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:951:6: ( ( 'strike-through' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:952:1: ( 'strike-through' )
                    {
                     before(grammarAccess.getFontTypeAccess().getStrike_throughEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:953:1: ( 'strike-through' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:953:3: 'strike-through'
                    {
                    match(input,14,FOLLOW_14_in_rule__FontType__Alternatives2019); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:965:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:969:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:970:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02052);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02055);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:977:1: rule__Model__Group__0__Impl : ( ( rule__Model__NameAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:981:1: ( ( ( rule__Model__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:982:1: ( ( rule__Model__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:982:1: ( ( rule__Model__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:983:1: ( rule__Model__NameAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:984:1: ( rule__Model__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:984:2: rule__Model__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__NameAssignment_0_in_rule__Model__Group__0__Impl2082);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:994:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:998:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:999:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12112);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12115);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1006:1: rule__Model__Group__1__Impl : ( '{' ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1010:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1011:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1011:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1012:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__Model__Group__1__Impl2143); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1025:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1029:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1030:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22174);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__22177);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1037:1: rule__Model__Group__2__Impl : ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1041:1: ( ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1042:1: ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1042:1: ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1043:1: ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1043:1: ( ( rule__Model__PartitionsAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1044:1: ( rule__Model__PartitionsAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1045:1: ( rule__Model__PartitionsAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1045:2: rule__Model__PartitionsAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2206);
            rule__Model__PartitionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1048:1: ( ( rule__Model__PartitionsAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1049:1: ( rule__Model__PartitionsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1050:1: ( rule__Model__PartitionsAssignment_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1050:2: rule__Model__PartitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2218);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1061:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1065:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1066:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__32251);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__4_in_rule__Model__Group__32254);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1073:1: rule__Model__Group__3__Impl : ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1077:1: ( ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1078:1: ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1078:1: ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1079:1: ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1079:1: ( ( rule__Model__DamagersAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1080:1: ( rule__Model__DamagersAssignment_3 )
            {
             before(grammarAccess.getModelAccess().getDamagersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1081:1: ( rule__Model__DamagersAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1081:2: rule__Model__DamagersAssignment_3
            {
            pushFollow(FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2283);
            rule__Model__DamagersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDamagersAssignment_3()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1084:1: ( ( rule__Model__DamagersAssignment_3 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1085:1: ( rule__Model__DamagersAssignment_3 )*
            {
             before(grammarAccess.getModelAccess().getDamagersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1086:1: ( rule__Model__DamagersAssignment_3 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=27 && LA8_0<=28)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1086:2: rule__Model__DamagersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2295);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1097:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1101:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1102:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__42328);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__5_in_rule__Model__Group__42331);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1109:1: rule__Model__Group__4__Impl : ( ( rule__Model__PartitionerAssignment_4 ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1113:1: ( ( ( rule__Model__PartitionerAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1114:1: ( ( rule__Model__PartitionerAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1114:1: ( ( rule__Model__PartitionerAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1115:1: ( rule__Model__PartitionerAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getPartitionerAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1116:1: ( rule__Model__PartitionerAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1116:2: rule__Model__PartitionerAssignment_4
            {
            pushFollow(FOLLOW_rule__Model__PartitionerAssignment_4_in_rule__Model__Group__4__Impl2358);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1126:1: rule__Model__Group__5 : rule__Model__Group__5__Impl rule__Model__Group__6 ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1130:1: ( rule__Model__Group__5__Impl rule__Model__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1131:2: rule__Model__Group__5__Impl rule__Model__Group__6
            {
            pushFollow(FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__52388);
            rule__Model__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__6_in_rule__Model__Group__52391);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1138:1: rule__Model__Group__5__Impl : ( '}' ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1142:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1143:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1143:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1144:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,16,FOLLOW_16_in_rule__Model__Group__5__Impl2419); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1157:1: rule__Model__Group__6 : rule__Model__Group__6__Impl rule__Model__Group__7 ;
    public final void rule__Model__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1161:1: ( rule__Model__Group__6__Impl rule__Model__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1162:2: rule__Model__Group__6__Impl rule__Model__Group__7
            {
            pushFollow(FOLLOW_rule__Model__Group__6__Impl_in_rule__Model__Group__62450);
            rule__Model__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__7_in_rule__Model__Group__62453);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1169:1: rule__Model__Group__6__Impl : ( 'for' ) ;
    public final void rule__Model__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1173:1: ( ( 'for' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1174:1: ( 'for' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1174:1: ( 'for' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1175:1: 'for'
            {
             before(grammarAccess.getModelAccess().getForKeyword_6()); 
            match(input,17,FOLLOW_17_in_rule__Model__Group__6__Impl2481); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1188:1: rule__Model__Group__7 : rule__Model__Group__7__Impl ;
    public final void rule__Model__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1192:1: ( rule__Model__Group__7__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1193:2: rule__Model__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__7__Impl_in_rule__Model__Group__72512);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1199:1: rule__Model__Group__7__Impl : ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) ) ;
    public final void rule__Model__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1203:1: ( ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1204:1: ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1204:1: ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1205:1: ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1205:1: ( ( rule__Model__ContentTypesAssignment_7 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1206:1: ( rule__Model__ContentTypesAssignment_7 )
            {
             before(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1207:1: ( rule__Model__ContentTypesAssignment_7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1207:2: rule__Model__ContentTypesAssignment_7
            {
            pushFollow(FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2541);
            rule__Model__ContentTypesAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1210:1: ( ( rule__Model__ContentTypesAssignment_7 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1211:1: ( rule__Model__ContentTypesAssignment_7 )*
            {
             before(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1212:1: ( rule__Model__ContentTypesAssignment_7 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_STRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1212:2: rule__Model__ContentTypesAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2553);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1239:1: rule__Partition__Group__0 : rule__Partition__Group__0__Impl rule__Partition__Group__1 ;
    public final void rule__Partition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1243:1: ( rule__Partition__Group__0__Impl rule__Partition__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1244:2: rule__Partition__Group__0__Impl rule__Partition__Group__1
            {
            pushFollow(FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__02602);
            rule__Partition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__02605);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1251:1: rule__Partition__Group__0__Impl : ( 'partition' ) ;
    public final void rule__Partition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1255:1: ( ( 'partition' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1256:1: ( 'partition' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1256:1: ( 'partition' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1257:1: 'partition'
            {
             before(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__Partition__Group__0__Impl2633); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1270:1: rule__Partition__Group__1 : rule__Partition__Group__1__Impl ;
    public final void rule__Partition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1274:1: ( rule__Partition__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1275:2: rule__Partition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__12664);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1281:1: rule__Partition__Group__1__Impl : ( ( rule__Partition__NameAssignment_1 ) ) ;
    public final void rule__Partition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1285:1: ( ( ( rule__Partition__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1286:1: ( ( rule__Partition__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1286:1: ( ( rule__Partition__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1287:1: ( rule__Partition__NameAssignment_1 )
            {
             before(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1288:1: ( rule__Partition__NameAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1288:2: rule__Partition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl2691);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1302:1: rule__JavaLikeParitioner__Group__0 : rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1 ;
    public final void rule__JavaLikeParitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1306:1: ( rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1307:2: rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__0__Impl_in_rule__JavaLikeParitioner__Group__02725);
            rule__JavaLikeParitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__1_in_rule__JavaLikeParitioner__Group__02728);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1314:1: rule__JavaLikeParitioner__Group__0__Impl : ( 'java-like-partitioner' ) ;
    public final void rule__JavaLikeParitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1318:1: ( ( 'java-like-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1319:1: ( 'java-like-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1319:1: ( 'java-like-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1320:1: 'java-like-partitioner'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaLikePartitionerKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__JavaLikeParitioner__Group__0__Impl2756); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1333:1: rule__JavaLikeParitioner__Group__1 : rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2 ;
    public final void rule__JavaLikeParitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1337:1: ( rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1338:2: rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__1__Impl_in_rule__JavaLikeParitioner__Group__12787);
            rule__JavaLikeParitioner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__2_in_rule__JavaLikeParitioner__Group__12790);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1345:1: rule__JavaLikeParitioner__Group__1__Impl : ( '{' ) ;
    public final void rule__JavaLikeParitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1349:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1350:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1350:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1351:1: '{'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__JavaLikeParitioner__Group__1__Impl2818); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1364:1: rule__JavaLikeParitioner__Group__2 : rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3 ;
    public final void rule__JavaLikeParitioner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1368:1: ( rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1369:2: rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__2__Impl_in_rule__JavaLikeParitioner__Group__22849);
            rule__JavaLikeParitioner__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__3_in_rule__JavaLikeParitioner__Group__22852);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1376:1: rule__JavaLikeParitioner__Group__2__Impl : ( 'singlelinedoc' ) ;
    public final void rule__JavaLikeParitioner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1380:1: ( ( 'singlelinedoc' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1381:1: ( 'singlelinedoc' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1381:1: ( 'singlelinedoc' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1382:1: 'singlelinedoc'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSinglelinedocKeyword_2()); 
            match(input,20,FOLLOW_20_in_rule__JavaLikeParitioner__Group__2__Impl2880); 
             after(grammarAccess.getJavaLikeParitionerAccess().getSinglelinedocKeyword_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1395:1: rule__JavaLikeParitioner__Group__3 : rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4 ;
    public final void rule__JavaLikeParitioner__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1399:1: ( rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1400:2: rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__3__Impl_in_rule__JavaLikeParitioner__Group__32911);
            rule__JavaLikeParitioner__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__4_in_rule__JavaLikeParitioner__Group__32914);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1407:1: rule__JavaLikeParitioner__Group__3__Impl : ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) ) ;
    public final void rule__JavaLikeParitioner__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1411:1: ( ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1412:1: ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1412:1: ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1413:1: ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1414:1: ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1414:2: rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3_in_rule__JavaLikeParitioner__Group__3__Impl2941);
            rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionAssignment_3()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1424:1: rule__JavaLikeParitioner__Group__4 : rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5 ;
    public final void rule__JavaLikeParitioner__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1428:1: ( rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1429:2: rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__4__Impl_in_rule__JavaLikeParitioner__Group__42971);
            rule__JavaLikeParitioner__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__5_in_rule__JavaLikeParitioner__Group__42974);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1436:1: rule__JavaLikeParitioner__Group__4__Impl : ( 'multilinedoc' ) ;
    public final void rule__JavaLikeParitioner__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1440:1: ( ( 'multilinedoc' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1441:1: ( 'multilinedoc' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1441:1: ( 'multilinedoc' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1442:1: 'multilinedoc'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultilinedocKeyword_4()); 
            match(input,21,FOLLOW_21_in_rule__JavaLikeParitioner__Group__4__Impl3002); 
             after(grammarAccess.getJavaLikeParitionerAccess().getMultilinedocKeyword_4()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1455:1: rule__JavaLikeParitioner__Group__5 : rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6 ;
    public final void rule__JavaLikeParitioner__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1459:1: ( rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1460:2: rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__5__Impl_in_rule__JavaLikeParitioner__Group__53033);
            rule__JavaLikeParitioner__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__6_in_rule__JavaLikeParitioner__Group__53036);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1467:1: rule__JavaLikeParitioner__Group__5__Impl : ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) ) ;
    public final void rule__JavaLikeParitioner__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1471:1: ( ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1472:1: ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1472:1: ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1473:1: ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1474:1: ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1474:2: rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5_in_rule__JavaLikeParitioner__Group__5__Impl3063);
            rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionAssignment_5()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1484:1: rule__JavaLikeParitioner__Group__6 : rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7 ;
    public final void rule__JavaLikeParitioner__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1488:1: ( rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1489:2: rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__6__Impl_in_rule__JavaLikeParitioner__Group__63093);
            rule__JavaLikeParitioner__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__7_in_rule__JavaLikeParitioner__Group__63096);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1496:1: rule__JavaLikeParitioner__Group__6__Impl : ( 'javadoc' ) ;
    public final void rule__JavaLikeParitioner__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1500:1: ( ( 'javadoc' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1501:1: ( 'javadoc' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1501:1: ( 'javadoc' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1502:1: 'javadoc'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavadocKeyword_6()); 
            match(input,22,FOLLOW_22_in_rule__JavaLikeParitioner__Group__6__Impl3124); 
             after(grammarAccess.getJavaLikeParitionerAccess().getJavadocKeyword_6()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1515:1: rule__JavaLikeParitioner__Group__7 : rule__JavaLikeParitioner__Group__7__Impl rule__JavaLikeParitioner__Group__8 ;
    public final void rule__JavaLikeParitioner__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1519:1: ( rule__JavaLikeParitioner__Group__7__Impl rule__JavaLikeParitioner__Group__8 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1520:2: rule__JavaLikeParitioner__Group__7__Impl rule__JavaLikeParitioner__Group__8
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__7__Impl_in_rule__JavaLikeParitioner__Group__73155);
            rule__JavaLikeParitioner__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__8_in_rule__JavaLikeParitioner__Group__73158);
            rule__JavaLikeParitioner__Group__8();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1527:1: rule__JavaLikeParitioner__Group__7__Impl : ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) ) ;
    public final void rule__JavaLikeParitioner__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1531:1: ( ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1532:1: ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1532:1: ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1533:1: ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1534:1: ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1534:2: rule__JavaLikeParitioner__JavaDocParitionAssignment_7
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__JavaDocParitionAssignment_7_in_rule__JavaLikeParitioner__Group__7__Impl3185);
            rule__JavaLikeParitioner__JavaDocParitionAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionAssignment_7()); 

            }


            }

        }
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


    // $ANTLR start "rule__JavaLikeParitioner__Group__8"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1544:1: rule__JavaLikeParitioner__Group__8 : rule__JavaLikeParitioner__Group__8__Impl rule__JavaLikeParitioner__Group__9 ;
    public final void rule__JavaLikeParitioner__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1548:1: ( rule__JavaLikeParitioner__Group__8__Impl rule__JavaLikeParitioner__Group__9 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1549:2: rule__JavaLikeParitioner__Group__8__Impl rule__JavaLikeParitioner__Group__9
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__8__Impl_in_rule__JavaLikeParitioner__Group__83215);
            rule__JavaLikeParitioner__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__9_in_rule__JavaLikeParitioner__Group__83218);
            rule__JavaLikeParitioner__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__8"


    // $ANTLR start "rule__JavaLikeParitioner__Group__8__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1556:1: rule__JavaLikeParitioner__Group__8__Impl : ( 'char' ) ;
    public final void rule__JavaLikeParitioner__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1560:1: ( ( 'char' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1561:1: ( 'char' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1561:1: ( 'char' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1562:1: 'char'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharKeyword_8()); 
            match(input,23,FOLLOW_23_in_rule__JavaLikeParitioner__Group__8__Impl3246); 
             after(grammarAccess.getJavaLikeParitionerAccess().getCharKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__8__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__9"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1575:1: rule__JavaLikeParitioner__Group__9 : rule__JavaLikeParitioner__Group__9__Impl rule__JavaLikeParitioner__Group__10 ;
    public final void rule__JavaLikeParitioner__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1579:1: ( rule__JavaLikeParitioner__Group__9__Impl rule__JavaLikeParitioner__Group__10 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1580:2: rule__JavaLikeParitioner__Group__9__Impl rule__JavaLikeParitioner__Group__10
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__9__Impl_in_rule__JavaLikeParitioner__Group__93277);
            rule__JavaLikeParitioner__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__10_in_rule__JavaLikeParitioner__Group__93280);
            rule__JavaLikeParitioner__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__9"


    // $ANTLR start "rule__JavaLikeParitioner__Group__9__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1587:1: rule__JavaLikeParitioner__Group__9__Impl : ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) ) ;
    public final void rule__JavaLikeParitioner__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1591:1: ( ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1592:1: ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1592:1: ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1593:1: ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionAssignment_9()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1594:1: ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1594:2: rule__JavaLikeParitioner__CharacterParitionAssignment_9
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__CharacterParitionAssignment_9_in_rule__JavaLikeParitioner__Group__9__Impl3307);
            rule__JavaLikeParitioner__CharacterParitionAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__9__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__10"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1604:1: rule__JavaLikeParitioner__Group__10 : rule__JavaLikeParitioner__Group__10__Impl rule__JavaLikeParitioner__Group__11 ;
    public final void rule__JavaLikeParitioner__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1608:1: ( rule__JavaLikeParitioner__Group__10__Impl rule__JavaLikeParitioner__Group__11 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1609:2: rule__JavaLikeParitioner__Group__10__Impl rule__JavaLikeParitioner__Group__11
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__10__Impl_in_rule__JavaLikeParitioner__Group__103337);
            rule__JavaLikeParitioner__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__11_in_rule__JavaLikeParitioner__Group__103340);
            rule__JavaLikeParitioner__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__10"


    // $ANTLR start "rule__JavaLikeParitioner__Group__10__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1616:1: rule__JavaLikeParitioner__Group__10__Impl : ( 'string' ) ;
    public final void rule__JavaLikeParitioner__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1620:1: ( ( 'string' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1621:1: ( 'string' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1621:1: ( 'string' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1622:1: 'string'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringKeyword_10()); 
            match(input,24,FOLLOW_24_in_rule__JavaLikeParitioner__Group__10__Impl3368); 
             after(grammarAccess.getJavaLikeParitionerAccess().getStringKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__10__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__11"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1635:1: rule__JavaLikeParitioner__Group__11 : rule__JavaLikeParitioner__Group__11__Impl rule__JavaLikeParitioner__Group__12 ;
    public final void rule__JavaLikeParitioner__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1639:1: ( rule__JavaLikeParitioner__Group__11__Impl rule__JavaLikeParitioner__Group__12 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1640:2: rule__JavaLikeParitioner__Group__11__Impl rule__JavaLikeParitioner__Group__12
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__11__Impl_in_rule__JavaLikeParitioner__Group__113399);
            rule__JavaLikeParitioner__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__12_in_rule__JavaLikeParitioner__Group__113402);
            rule__JavaLikeParitioner__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__11"


    // $ANTLR start "rule__JavaLikeParitioner__Group__11__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1647:1: rule__JavaLikeParitioner__Group__11__Impl : ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) ) ;
    public final void rule__JavaLikeParitioner__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1651:1: ( ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1652:1: ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1652:1: ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1653:1: ( rule__JavaLikeParitioner__StringParitionAssignment_11 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionAssignment_11()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1654:1: ( rule__JavaLikeParitioner__StringParitionAssignment_11 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1654:2: rule__JavaLikeParitioner__StringParitionAssignment_11
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__StringParitionAssignment_11_in_rule__JavaLikeParitioner__Group__11__Impl3429);
            rule__JavaLikeParitioner__StringParitionAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getStringParitionAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__11__Impl"


    // $ANTLR start "rule__JavaLikeParitioner__Group__12"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1664:1: rule__JavaLikeParitioner__Group__12 : rule__JavaLikeParitioner__Group__12__Impl ;
    public final void rule__JavaLikeParitioner__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1668:1: ( rule__JavaLikeParitioner__Group__12__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1669:2: rule__JavaLikeParitioner__Group__12__Impl
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__12__Impl_in_rule__JavaLikeParitioner__Group__123459);
            rule__JavaLikeParitioner__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__12"


    // $ANTLR start "rule__JavaLikeParitioner__Group__12__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1675:1: rule__JavaLikeParitioner__Group__12__Impl : ( '}' ) ;
    public final void rule__JavaLikeParitioner__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1679:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1680:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1680:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1681:1: '}'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getRightCurlyBracketKeyword_12()); 
            match(input,16,FOLLOW_16_in_rule__JavaLikeParitioner__Group__12__Impl3487); 
             after(grammarAccess.getJavaLikeParitionerAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__Group__12__Impl"


    // $ANTLR start "rule__RulePartitioner__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1720:1: rule__RulePartitioner__Group__0 : rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1 ;
    public final void rule__RulePartitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1724:1: ( rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1725:2: rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__0__Impl_in_rule__RulePartitioner__Group__03544);
            rule__RulePartitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__1_in_rule__RulePartitioner__Group__03547);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1732:1: rule__RulePartitioner__Group__0__Impl : ( 'rule-partitioner' ) ;
    public final void rule__RulePartitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1736:1: ( ( 'rule-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1737:1: ( 'rule-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1737:1: ( 'rule-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1738:1: 'rule-partitioner'
            {
             before(grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__RulePartitioner__Group__0__Impl3575); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1751:1: rule__RulePartitioner__Group__1 : rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2 ;
    public final void rule__RulePartitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1755:1: ( rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1756:2: rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__1__Impl_in_rule__RulePartitioner__Group__13606);
            rule__RulePartitioner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__2_in_rule__RulePartitioner__Group__13609);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1763:1: rule__RulePartitioner__Group__1__Impl : ( '{' ) ;
    public final void rule__RulePartitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1767:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1768:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1768:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1769:1: '{'
            {
             before(grammarAccess.getRulePartitionerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__RulePartitioner__Group__1__Impl3637); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1782:1: rule__RulePartitioner__Group__2 : rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3 ;
    public final void rule__RulePartitioner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1786:1: ( rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1787:2: rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__2__Impl_in_rule__RulePartitioner__Group__23668);
            rule__RulePartitioner__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__3_in_rule__RulePartitioner__Group__23671);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1794:1: rule__RulePartitioner__Group__2__Impl : ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) ) ;
    public final void rule__RulePartitioner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1798:1: ( ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1799:1: ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1799:1: ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1800:1: ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1800:1: ( ( rule__RulePartitioner__RulesAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1801:1: ( rule__RulePartitioner__RulesAssignment_2 )
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1802:1: ( rule__RulePartitioner__RulesAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1802:2: rule__RulePartitioner__RulesAssignment_2
            {
            pushFollow(FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3700);
            rule__RulePartitioner__RulesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1805:1: ( ( rule__RulePartitioner__RulesAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1806:1: ( rule__RulePartitioner__RulesAssignment_2 )*
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1807:1: ( rule__RulePartitioner__RulesAssignment_2 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==39||LA10_0==43||LA10_0==45) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1807:2: rule__RulePartitioner__RulesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3712);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1818:1: rule__RulePartitioner__Group__3 : rule__RulePartitioner__Group__3__Impl ;
    public final void rule__RulePartitioner__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1822:1: ( rule__RulePartitioner__Group__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1823:2: rule__RulePartitioner__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__3__Impl_in_rule__RulePartitioner__Group__33745);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1829:1: rule__RulePartitioner__Group__3__Impl : ( '}' ) ;
    public final void rule__RulePartitioner__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1833:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1834:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1834:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1835:1: '}'
            {
             before(grammarAccess.getRulePartitionerAccess().getRightCurlyBracketKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__RulePartitioner__Group__3__Impl3773); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1856:1: rule__JSParitioner__Group__0 : rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1 ;
    public final void rule__JSParitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1860:1: ( rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1861:2: rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__0__Impl_in_rule__JSParitioner__Group__03812);
            rule__JSParitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSParitioner__Group__1_in_rule__JSParitioner__Group__03815);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1868:1: rule__JSParitioner__Group__0__Impl : ( 'js-partitioner' ) ;
    public final void rule__JSParitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1872:1: ( ( 'js-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1873:1: ( 'js-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1873:1: ( 'js-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1874:1: 'js-partitioner'
            {
             before(grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__JSParitioner__Group__0__Impl3843); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1887:1: rule__JSParitioner__Group__1 : rule__JSParitioner__Group__1__Impl ;
    public final void rule__JSParitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1891:1: ( rule__JSParitioner__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1892:2: rule__JSParitioner__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__1__Impl_in_rule__JSParitioner__Group__13874);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1898:1: rule__JSParitioner__Group__1__Impl : ( ( rule__JSParitioner__FileURIAssignment_1 ) ) ;
    public final void rule__JSParitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1902:1: ( ( ( rule__JSParitioner__FileURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1903:1: ( ( rule__JSParitioner__FileURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1903:1: ( ( rule__JSParitioner__FileURIAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1904:1: ( rule__JSParitioner__FileURIAssignment_1 )
            {
             before(grammarAccess.getJSParitionerAccess().getFileURIAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1905:1: ( rule__JSParitioner__FileURIAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1905:2: rule__JSParitioner__FileURIAssignment_1
            {
            pushFollow(FOLLOW_rule__JSParitioner__FileURIAssignment_1_in_rule__JSParitioner__Group__1__Impl3901);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1919:1: rule__JSDamager__Group__0 : rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1 ;
    public final void rule__JSDamager__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1923:1: ( rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1924:2: rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__0__Impl_in_rule__JSDamager__Group__03935);
            rule__JSDamager__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSDamager__Group__1_in_rule__JSDamager__Group__03938);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1931:1: rule__JSDamager__Group__0__Impl : ( 'js-damager' ) ;
    public final void rule__JSDamager__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1935:1: ( ( 'js-damager' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1936:1: ( 'js-damager' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1936:1: ( 'js-damager' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1937:1: 'js-damager'
            {
             before(grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__JSDamager__Group__0__Impl3966); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1950:1: rule__JSDamager__Group__1 : rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2 ;
    public final void rule__JSDamager__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1954:1: ( rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1955:2: rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__1__Impl_in_rule__JSDamager__Group__13997);
            rule__JSDamager__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSDamager__Group__2_in_rule__JSDamager__Group__14000);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1962:1: rule__JSDamager__Group__1__Impl : ( ( rule__JSDamager__PartitionAssignment_1 ) ) ;
    public final void rule__JSDamager__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1966:1: ( ( ( rule__JSDamager__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1967:1: ( ( rule__JSDamager__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1967:1: ( ( rule__JSDamager__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1968:1: ( rule__JSDamager__PartitionAssignment_1 )
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1969:1: ( rule__JSDamager__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1969:2: rule__JSDamager__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__JSDamager__PartitionAssignment_1_in_rule__JSDamager__Group__1__Impl4027);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1979:1: rule__JSDamager__Group__2 : rule__JSDamager__Group__2__Impl ;
    public final void rule__JSDamager__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1983:1: ( rule__JSDamager__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1984:2: rule__JSDamager__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__2__Impl_in_rule__JSDamager__Group__24057);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1990:1: rule__JSDamager__Group__2__Impl : ( ( rule__JSDamager__FileURIAssignment_2 ) ) ;
    public final void rule__JSDamager__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1994:1: ( ( ( rule__JSDamager__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1995:1: ( ( rule__JSDamager__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1995:1: ( ( rule__JSDamager__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1996:1: ( rule__JSDamager__FileURIAssignment_2 )
            {
             before(grammarAccess.getJSDamagerAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1997:1: ( rule__JSDamager__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1997:2: rule__JSDamager__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__JSDamager__FileURIAssignment_2_in_rule__JSDamager__Group__2__Impl4084);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2013:1: rule__RuleDamager__Group__0 : rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1 ;
    public final void rule__RuleDamager__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2017:1: ( rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2018:2: rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__0__Impl_in_rule__RuleDamager__Group__04120);
            rule__RuleDamager__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__1_in_rule__RuleDamager__Group__04123);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2025:1: rule__RuleDamager__Group__0__Impl : ( 'rule-damager' ) ;
    public final void rule__RuleDamager__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2029:1: ( ( 'rule-damager' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2030:1: ( 'rule-damager' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2030:1: ( 'rule-damager' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2031:1: 'rule-damager'
            {
             before(grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__RuleDamager__Group__0__Impl4151); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2044:1: rule__RuleDamager__Group__1 : rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2 ;
    public final void rule__RuleDamager__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2048:1: ( rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2049:2: rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__1__Impl_in_rule__RuleDamager__Group__14182);
            rule__RuleDamager__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__2_in_rule__RuleDamager__Group__14185);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2056:1: rule__RuleDamager__Group__1__Impl : ( ( rule__RuleDamager__PartitionAssignment_1 ) ) ;
    public final void rule__RuleDamager__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2060:1: ( ( ( rule__RuleDamager__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2061:1: ( ( rule__RuleDamager__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2061:1: ( ( rule__RuleDamager__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2062:1: ( rule__RuleDamager__PartitionAssignment_1 )
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2063:1: ( rule__RuleDamager__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2063:2: rule__RuleDamager__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__RuleDamager__PartitionAssignment_1_in_rule__RuleDamager__Group__1__Impl4212);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2073:1: rule__RuleDamager__Group__2 : rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3 ;
    public final void rule__RuleDamager__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2077:1: ( rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2078:2: rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__2__Impl_in_rule__RuleDamager__Group__24242);
            rule__RuleDamager__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__3_in_rule__RuleDamager__Group__24245);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2085:1: rule__RuleDamager__Group__2__Impl : ( '{' ) ;
    public final void rule__RuleDamager__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2089:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2090:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2090:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2091:1: '{'
            {
             before(grammarAccess.getRuleDamagerAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,15,FOLLOW_15_in_rule__RuleDamager__Group__2__Impl4273); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2104:1: rule__RuleDamager__Group__3 : rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4 ;
    public final void rule__RuleDamager__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2108:1: ( rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2109:2: rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__3__Impl_in_rule__RuleDamager__Group__34304);
            rule__RuleDamager__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__4_in_rule__RuleDamager__Group__34307);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2116:1: rule__RuleDamager__Group__3__Impl : ( ( rule__RuleDamager__TokensAssignment_3 )* ) ;
    public final void rule__RuleDamager__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2120:1: ( ( ( rule__RuleDamager__TokensAssignment_3 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2121:1: ( ( rule__RuleDamager__TokensAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2121:1: ( ( rule__RuleDamager__TokensAssignment_3 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2122:1: ( rule__RuleDamager__TokensAssignment_3 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getTokensAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2123:1: ( rule__RuleDamager__TokensAssignment_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29||LA11_0==50) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2123:2: rule__RuleDamager__TokensAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__TokensAssignment_3_in_rule__RuleDamager__Group__3__Impl4334);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2133:1: rule__RuleDamager__Group__4 : rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5 ;
    public final void rule__RuleDamager__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2137:1: ( rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2138:2: rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__4__Impl_in_rule__RuleDamager__Group__44365);
            rule__RuleDamager__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__5_in_rule__RuleDamager__Group__44368);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2145:1: rule__RuleDamager__Group__4__Impl : ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* ) ;
    public final void rule__RuleDamager__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2149:1: ( ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2150:1: ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2150:1: ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2151:1: ( rule__RuleDamager__KeywordGroupsAssignment_4 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getKeywordGroupsAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2152:1: ( rule__RuleDamager__KeywordGroupsAssignment_4 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==34) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2152:2: rule__RuleDamager__KeywordGroupsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__KeywordGroupsAssignment_4_in_rule__RuleDamager__Group__4__Impl4395);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2162:1: rule__RuleDamager__Group__5 : rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6 ;
    public final void rule__RuleDamager__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2166:1: ( rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2167:2: rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__5__Impl_in_rule__RuleDamager__Group__54426);
            rule__RuleDamager__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__6_in_rule__RuleDamager__Group__54429);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2174:1: rule__RuleDamager__Group__5__Impl : ( ( rule__RuleDamager__RulesAssignment_5 )* ) ;
    public final void rule__RuleDamager__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2178:1: ( ( ( rule__RuleDamager__RulesAssignment_5 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2179:1: ( ( rule__RuleDamager__RulesAssignment_5 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2179:1: ( ( rule__RuleDamager__RulesAssignment_5 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2180:1: ( rule__RuleDamager__RulesAssignment_5 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getRulesAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2181:1: ( rule__RuleDamager__RulesAssignment_5 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==39||(LA13_0>=43 && LA13_0<=46)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2181:2: rule__RuleDamager__RulesAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__RulesAssignment_5_in_rule__RuleDamager__Group__5__Impl4456);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2191:1: rule__RuleDamager__Group__6 : rule__RuleDamager__Group__6__Impl ;
    public final void rule__RuleDamager__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2195:1: ( rule__RuleDamager__Group__6__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2196:2: rule__RuleDamager__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__6__Impl_in_rule__RuleDamager__Group__64487);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2202:1: rule__RuleDamager__Group__6__Impl : ( '}' ) ;
    public final void rule__RuleDamager__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2206:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2207:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2207:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2208:1: '}'
            {
             before(grammarAccess.getRuleDamagerAccess().getRightCurlyBracketKeyword_6()); 
            match(input,16,FOLLOW_16_in_rule__RuleDamager__Group__6__Impl4515); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2235:1: rule__ScannerToken__Group__0 : rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1 ;
    public final void rule__ScannerToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2239:1: ( rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2240:2: rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__0__Impl_in_rule__ScannerToken__Group__04560);
            rule__ScannerToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__1_in_rule__ScannerToken__Group__04563);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2247:1: rule__ScannerToken__Group__0__Impl : ( ( rule__ScannerToken__DefaultAssignment_0 )? ) ;
    public final void rule__ScannerToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2251:1: ( ( ( rule__ScannerToken__DefaultAssignment_0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2252:1: ( ( rule__ScannerToken__DefaultAssignment_0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2252:1: ( ( rule__ScannerToken__DefaultAssignment_0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2253:1: ( rule__ScannerToken__DefaultAssignment_0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2254:1: ( rule__ScannerToken__DefaultAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==50) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2254:2: rule__ScannerToken__DefaultAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__DefaultAssignment_0_in_rule__ScannerToken__Group__0__Impl4590);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2264:1: rule__ScannerToken__Group__1 : rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2 ;
    public final void rule__ScannerToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2268:1: ( rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2269:2: rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__1__Impl_in_rule__ScannerToken__Group__14621);
            rule__ScannerToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__2_in_rule__ScannerToken__Group__14624);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2276:1: rule__ScannerToken__Group__1__Impl : ( 'token' ) ;
    public final void rule__ScannerToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2280:1: ( ( 'token' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2281:1: ( 'token' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2281:1: ( 'token' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2282:1: 'token'
            {
             before(grammarAccess.getScannerTokenAccess().getTokenKeyword_1()); 
            match(input,29,FOLLOW_29_in_rule__ScannerToken__Group__1__Impl4652); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2295:1: rule__ScannerToken__Group__2 : rule__ScannerToken__Group__2__Impl rule__ScannerToken__Group__3 ;
    public final void rule__ScannerToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2299:1: ( rule__ScannerToken__Group__2__Impl rule__ScannerToken__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2300:2: rule__ScannerToken__Group__2__Impl rule__ScannerToken__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__2__Impl_in_rule__ScannerToken__Group__24683);
            rule__ScannerToken__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__3_in_rule__ScannerToken__Group__24686);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2307:1: rule__ScannerToken__Group__2__Impl : ( ( rule__ScannerToken__NameAssignment_2 ) ) ;
    public final void rule__ScannerToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2311:1: ( ( ( rule__ScannerToken__NameAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2312:1: ( ( rule__ScannerToken__NameAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2312:1: ( ( rule__ScannerToken__NameAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2313:1: ( rule__ScannerToken__NameAssignment_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getNameAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2314:1: ( rule__ScannerToken__NameAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2314:2: rule__ScannerToken__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__NameAssignment_2_in_rule__ScannerToken__Group__2__Impl4713);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2324:1: rule__ScannerToken__Group__3 : rule__ScannerToken__Group__3__Impl ;
    public final void rule__ScannerToken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2328:1: ( rule__ScannerToken__Group__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2329:2: rule__ScannerToken__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__3__Impl_in_rule__ScannerToken__Group__34743);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2335:1: rule__ScannerToken__Group__3__Impl : ( ( rule__ScannerToken__Group_3__0 )? ) ;
    public final void rule__ScannerToken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2339:1: ( ( ( rule__ScannerToken__Group_3__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2340:1: ( ( rule__ScannerToken__Group_3__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2340:1: ( ( rule__ScannerToken__Group_3__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2341:1: ( rule__ScannerToken__Group_3__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2342:1: ( rule__ScannerToken__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2342:2: rule__ScannerToken__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3__0_in_rule__ScannerToken__Group__3__Impl4770);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2360:1: rule__ScannerToken__Group_3__0 : rule__ScannerToken__Group_3__0__Impl rule__ScannerToken__Group_3__1 ;
    public final void rule__ScannerToken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2364:1: ( rule__ScannerToken__Group_3__0__Impl rule__ScannerToken__Group_3__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2365:2: rule__ScannerToken__Group_3__0__Impl rule__ScannerToken__Group_3__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__0__Impl_in_rule__ScannerToken__Group_3__04809);
            rule__ScannerToken__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__1_in_rule__ScannerToken__Group_3__04812);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2372:1: rule__ScannerToken__Group_3__0__Impl : ( '{' ) ;
    public final void rule__ScannerToken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2376:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2377:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2377:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2378:1: '{'
            {
             before(grammarAccess.getScannerTokenAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,15,FOLLOW_15_in_rule__ScannerToken__Group_3__0__Impl4840); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2391:1: rule__ScannerToken__Group_3__1 : rule__ScannerToken__Group_3__1__Impl rule__ScannerToken__Group_3__2 ;
    public final void rule__ScannerToken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2395:1: ( rule__ScannerToken__Group_3__1__Impl rule__ScannerToken__Group_3__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2396:2: rule__ScannerToken__Group_3__1__Impl rule__ScannerToken__Group_3__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__1__Impl_in_rule__ScannerToken__Group_3__14871);
            rule__ScannerToken__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__2_in_rule__ScannerToken__Group_3__14874);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2403:1: rule__ScannerToken__Group_3__1__Impl : ( ( rule__ScannerToken__Group_3_1__0 )? ) ;
    public final void rule__ScannerToken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2407:1: ( ( ( rule__ScannerToken__Group_3_1__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2408:1: ( ( rule__ScannerToken__Group_3_1__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2408:1: ( ( rule__ScannerToken__Group_3_1__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2409:1: ( rule__ScannerToken__Group_3_1__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2410:1: ( rule__ScannerToken__Group_3_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==30) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2410:2: rule__ScannerToken__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__0_in_rule__ScannerToken__Group_3__1__Impl4901);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2420:1: rule__ScannerToken__Group_3__2 : rule__ScannerToken__Group_3__2__Impl rule__ScannerToken__Group_3__3 ;
    public final void rule__ScannerToken__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2424:1: ( rule__ScannerToken__Group_3__2__Impl rule__ScannerToken__Group_3__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2425:2: rule__ScannerToken__Group_3__2__Impl rule__ScannerToken__Group_3__3
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__2__Impl_in_rule__ScannerToken__Group_3__24932);
            rule__ScannerToken__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__3_in_rule__ScannerToken__Group_3__24935);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2432:1: rule__ScannerToken__Group_3__2__Impl : ( ( rule__ScannerToken__Group_3_2__0 )? ) ;
    public final void rule__ScannerToken__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2436:1: ( ( ( rule__ScannerToken__Group_3_2__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2437:1: ( ( rule__ScannerToken__Group_3_2__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2437:1: ( ( rule__ScannerToken__Group_3_2__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2438:1: ( rule__ScannerToken__Group_3_2__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2439:1: ( rule__ScannerToken__Group_3_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2439:2: rule__ScannerToken__Group_3_2__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__0_in_rule__ScannerToken__Group_3__2__Impl4962);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2449:1: rule__ScannerToken__Group_3__3 : rule__ScannerToken__Group_3__3__Impl rule__ScannerToken__Group_3__4 ;
    public final void rule__ScannerToken__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2453:1: ( rule__ScannerToken__Group_3__3__Impl rule__ScannerToken__Group_3__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2454:2: rule__ScannerToken__Group_3__3__Impl rule__ScannerToken__Group_3__4
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__3__Impl_in_rule__ScannerToken__Group_3__34993);
            rule__ScannerToken__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3__4_in_rule__ScannerToken__Group_3__34996);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2461:1: rule__ScannerToken__Group_3__3__Impl : ( ( rule__ScannerToken__Group_3_3__0 )? ) ;
    public final void rule__ScannerToken__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2465:1: ( ( ( rule__ScannerToken__Group_3_3__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2466:1: ( ( rule__ScannerToken__Group_3_3__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2466:1: ( ( rule__ScannerToken__Group_3_3__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2467:1: ( rule__ScannerToken__Group_3_3__0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getGroup_3_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2468:1: ( rule__ScannerToken__Group_3_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==33) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2468:2: rule__ScannerToken__Group_3_3__0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__0_in_rule__ScannerToken__Group_3__3__Impl5023);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2478:1: rule__ScannerToken__Group_3__4 : rule__ScannerToken__Group_3__4__Impl ;
    public final void rule__ScannerToken__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2482:1: ( rule__ScannerToken__Group_3__4__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2483:2: rule__ScannerToken__Group_3__4__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3__4__Impl_in_rule__ScannerToken__Group_3__45054);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2489:1: rule__ScannerToken__Group_3__4__Impl : ( '}' ) ;
    public final void rule__ScannerToken__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2493:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2494:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2494:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2495:1: '}'
            {
             before(grammarAccess.getScannerTokenAccess().getRightCurlyBracketKeyword_3_4()); 
            match(input,16,FOLLOW_16_in_rule__ScannerToken__Group_3__4__Impl5082); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2518:1: rule__ScannerToken__Group_3_1__0 : rule__ScannerToken__Group_3_1__0__Impl rule__ScannerToken__Group_3_1__1 ;
    public final void rule__ScannerToken__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2522:1: ( rule__ScannerToken__Group_3_1__0__Impl rule__ScannerToken__Group_3_1__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2523:2: rule__ScannerToken__Group_3_1__0__Impl rule__ScannerToken__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__0__Impl_in_rule__ScannerToken__Group_3_1__05123);
            rule__ScannerToken__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__1_in_rule__ScannerToken__Group_3_1__05126);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2530:1: rule__ScannerToken__Group_3_1__0__Impl : ( 'fgcolor' ) ;
    public final void rule__ScannerToken__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2534:1: ( ( 'fgcolor' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2535:1: ( 'fgcolor' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2535:1: ( 'fgcolor' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2536:1: 'fgcolor'
            {
             before(grammarAccess.getScannerTokenAccess().getFgcolorKeyword_3_1_0()); 
            match(input,30,FOLLOW_30_in_rule__ScannerToken__Group_3_1__0__Impl5154); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2549:1: rule__ScannerToken__Group_3_1__1 : rule__ScannerToken__Group_3_1__1__Impl rule__ScannerToken__Group_3_1__2 ;
    public final void rule__ScannerToken__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2553:1: ( rule__ScannerToken__Group_3_1__1__Impl rule__ScannerToken__Group_3_1__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2554:2: rule__ScannerToken__Group_3_1__1__Impl rule__ScannerToken__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__1__Impl_in_rule__ScannerToken__Group_3_1__15185);
            rule__ScannerToken__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__2_in_rule__ScannerToken__Group_3_1__15188);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2561:1: rule__ScannerToken__Group_3_1__1__Impl : ( ':' ) ;
    public final void rule__ScannerToken__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2565:1: ( ( ':' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2566:1: ( ':' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2566:1: ( ':' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2567:1: ':'
            {
             before(grammarAccess.getScannerTokenAccess().getColonKeyword_3_1_1()); 
            match(input,31,FOLLOW_31_in_rule__ScannerToken__Group_3_1__1__Impl5216); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2580:1: rule__ScannerToken__Group_3_1__2 : rule__ScannerToken__Group_3_1__2__Impl ;
    public final void rule__ScannerToken__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2584:1: ( rule__ScannerToken__Group_3_1__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2585:2: rule__ScannerToken__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_1__2__Impl_in_rule__ScannerToken__Group_3_1__25247);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2591:1: rule__ScannerToken__Group_3_1__2__Impl : ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) ) ;
    public final void rule__ScannerToken__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2595:1: ( ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2596:1: ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2596:1: ( ( rule__ScannerToken__FgColorAssignment_3_1_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2597:1: ( rule__ScannerToken__FgColorAssignment_3_1_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getFgColorAssignment_3_1_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2598:1: ( rule__ScannerToken__FgColorAssignment_3_1_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2598:2: rule__ScannerToken__FgColorAssignment_3_1_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__FgColorAssignment_3_1_2_in_rule__ScannerToken__Group_3_1__2__Impl5274);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2614:1: rule__ScannerToken__Group_3_2__0 : rule__ScannerToken__Group_3_2__0__Impl rule__ScannerToken__Group_3_2__1 ;
    public final void rule__ScannerToken__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2618:1: ( rule__ScannerToken__Group_3_2__0__Impl rule__ScannerToken__Group_3_2__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2619:2: rule__ScannerToken__Group_3_2__0__Impl rule__ScannerToken__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__0__Impl_in_rule__ScannerToken__Group_3_2__05310);
            rule__ScannerToken__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__1_in_rule__ScannerToken__Group_3_2__05313);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2626:1: rule__ScannerToken__Group_3_2__0__Impl : ( 'bgcolor' ) ;
    public final void rule__ScannerToken__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2630:1: ( ( 'bgcolor' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2631:1: ( 'bgcolor' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2631:1: ( 'bgcolor' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2632:1: 'bgcolor'
            {
             before(grammarAccess.getScannerTokenAccess().getBgcolorKeyword_3_2_0()); 
            match(input,32,FOLLOW_32_in_rule__ScannerToken__Group_3_2__0__Impl5341); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2645:1: rule__ScannerToken__Group_3_2__1 : rule__ScannerToken__Group_3_2__1__Impl rule__ScannerToken__Group_3_2__2 ;
    public final void rule__ScannerToken__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2649:1: ( rule__ScannerToken__Group_3_2__1__Impl rule__ScannerToken__Group_3_2__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2650:2: rule__ScannerToken__Group_3_2__1__Impl rule__ScannerToken__Group_3_2__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__1__Impl_in_rule__ScannerToken__Group_3_2__15372);
            rule__ScannerToken__Group_3_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__2_in_rule__ScannerToken__Group_3_2__15375);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2657:1: rule__ScannerToken__Group_3_2__1__Impl : ( ':' ) ;
    public final void rule__ScannerToken__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2661:1: ( ( ':' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2662:1: ( ':' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2662:1: ( ':' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2663:1: ':'
            {
             before(grammarAccess.getScannerTokenAccess().getColonKeyword_3_2_1()); 
            match(input,31,FOLLOW_31_in_rule__ScannerToken__Group_3_2__1__Impl5403); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2676:1: rule__ScannerToken__Group_3_2__2 : rule__ScannerToken__Group_3_2__2__Impl ;
    public final void rule__ScannerToken__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2680:1: ( rule__ScannerToken__Group_3_2__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2681:2: rule__ScannerToken__Group_3_2__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_2__2__Impl_in_rule__ScannerToken__Group_3_2__25434);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2687:1: rule__ScannerToken__Group_3_2__2__Impl : ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) ) ;
    public final void rule__ScannerToken__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2691:1: ( ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2692:1: ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2692:1: ( ( rule__ScannerToken__BgColorAssignment_3_2_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2693:1: ( rule__ScannerToken__BgColorAssignment_3_2_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getBgColorAssignment_3_2_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2694:1: ( rule__ScannerToken__BgColorAssignment_3_2_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2694:2: rule__ScannerToken__BgColorAssignment_3_2_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__BgColorAssignment_3_2_2_in_rule__ScannerToken__Group_3_2__2__Impl5461);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2710:1: rule__ScannerToken__Group_3_3__0 : rule__ScannerToken__Group_3_3__0__Impl rule__ScannerToken__Group_3_3__1 ;
    public final void rule__ScannerToken__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2714:1: ( rule__ScannerToken__Group_3_3__0__Impl rule__ScannerToken__Group_3_3__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2715:2: rule__ScannerToken__Group_3_3__0__Impl rule__ScannerToken__Group_3_3__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__0__Impl_in_rule__ScannerToken__Group_3_3__05497);
            rule__ScannerToken__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__1_in_rule__ScannerToken__Group_3_3__05500);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2722:1: rule__ScannerToken__Group_3_3__0__Impl : ( 'font' ) ;
    public final void rule__ScannerToken__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2726:1: ( ( 'font' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2727:1: ( 'font' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2727:1: ( 'font' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2728:1: 'font'
            {
             before(grammarAccess.getScannerTokenAccess().getFontKeyword_3_3_0()); 
            match(input,33,FOLLOW_33_in_rule__ScannerToken__Group_3_3__0__Impl5528); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2741:1: rule__ScannerToken__Group_3_3__1 : rule__ScannerToken__Group_3_3__1__Impl rule__ScannerToken__Group_3_3__2 ;
    public final void rule__ScannerToken__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2745:1: ( rule__ScannerToken__Group_3_3__1__Impl rule__ScannerToken__Group_3_3__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2746:2: rule__ScannerToken__Group_3_3__1__Impl rule__ScannerToken__Group_3_3__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__1__Impl_in_rule__ScannerToken__Group_3_3__15559);
            rule__ScannerToken__Group_3_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__2_in_rule__ScannerToken__Group_3_3__15562);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2753:1: rule__ScannerToken__Group_3_3__1__Impl : ( ':' ) ;
    public final void rule__ScannerToken__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2757:1: ( ( ':' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2758:1: ( ':' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2758:1: ( ':' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2759:1: ':'
            {
             before(grammarAccess.getScannerTokenAccess().getColonKeyword_3_3_1()); 
            match(input,31,FOLLOW_31_in_rule__ScannerToken__Group_3_3__1__Impl5590); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2772:1: rule__ScannerToken__Group_3_3__2 : rule__ScannerToken__Group_3_3__2__Impl ;
    public final void rule__ScannerToken__Group_3_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2776:1: ( rule__ScannerToken__Group_3_3__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2777:2: rule__ScannerToken__Group_3_3__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group_3_3__2__Impl_in_rule__ScannerToken__Group_3_3__25621);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2783:1: rule__ScannerToken__Group_3_3__2__Impl : ( ( rule__ScannerToken__FontAssignment_3_3_2 ) ) ;
    public final void rule__ScannerToken__Group_3_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2787:1: ( ( ( rule__ScannerToken__FontAssignment_3_3_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2788:1: ( ( rule__ScannerToken__FontAssignment_3_3_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2788:1: ( ( rule__ScannerToken__FontAssignment_3_3_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2789:1: ( rule__ScannerToken__FontAssignment_3_3_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getFontAssignment_3_3_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2790:1: ( rule__ScannerToken__FontAssignment_3_3_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2790:2: rule__ScannerToken__FontAssignment_3_3_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__FontAssignment_3_3_2_in_rule__ScannerToken__Group_3_3__2__Impl5648);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2806:1: rule__KeywordGroup__Group__0 : rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1 ;
    public final void rule__KeywordGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2810:1: ( rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2811:2: rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__0__Impl_in_rule__KeywordGroup__Group__05684);
            rule__KeywordGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__1_in_rule__KeywordGroup__Group__05687);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2818:1: rule__KeywordGroup__Group__0__Impl : ( 'keywords' ) ;
    public final void rule__KeywordGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2822:1: ( ( 'keywords' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2823:1: ( 'keywords' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2823:1: ( 'keywords' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2824:1: 'keywords'
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__KeywordGroup__Group__0__Impl5715); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2837:1: rule__KeywordGroup__Group__1 : rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2 ;
    public final void rule__KeywordGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2841:1: ( rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2842:2: rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__1__Impl_in_rule__KeywordGroup__Group__15746);
            rule__KeywordGroup__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__2_in_rule__KeywordGroup__Group__15749);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2849:1: rule__KeywordGroup__Group__1__Impl : ( ( rule__KeywordGroup__TokenAssignment_1 ) ) ;
    public final void rule__KeywordGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2853:1: ( ( ( rule__KeywordGroup__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2854:1: ( ( rule__KeywordGroup__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2854:1: ( ( rule__KeywordGroup__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2855:1: ( rule__KeywordGroup__TokenAssignment_1 )
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2856:1: ( rule__KeywordGroup__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2856:2: rule__KeywordGroup__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__TokenAssignment_1_in_rule__KeywordGroup__Group__1__Impl5776);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2866:1: rule__KeywordGroup__Group__2 : rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3 ;
    public final void rule__KeywordGroup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2870:1: ( rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2871:2: rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__2__Impl_in_rule__KeywordGroup__Group__25806);
            rule__KeywordGroup__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__3_in_rule__KeywordGroup__Group__25809);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2878:1: rule__KeywordGroup__Group__2__Impl : ( '[' ) ;
    public final void rule__KeywordGroup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2882:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2883:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2883:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2884:1: '['
            {
             before(grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__KeywordGroup__Group__2__Impl5837); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2897:1: rule__KeywordGroup__Group__3 : rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4 ;
    public final void rule__KeywordGroup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2901:1: ( rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2902:2: rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__3__Impl_in_rule__KeywordGroup__Group__35868);
            rule__KeywordGroup__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__4_in_rule__KeywordGroup__Group__35871);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2909:1: rule__KeywordGroup__Group__3__Impl : ( ( rule__KeywordGroup__KeywordsAssignment_3 ) ) ;
    public final void rule__KeywordGroup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2913:1: ( ( ( rule__KeywordGroup__KeywordsAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2914:1: ( ( rule__KeywordGroup__KeywordsAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2914:1: ( ( rule__KeywordGroup__KeywordsAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2915:1: ( rule__KeywordGroup__KeywordsAssignment_3 )
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2916:1: ( rule__KeywordGroup__KeywordsAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2916:2: rule__KeywordGroup__KeywordsAssignment_3
            {
            pushFollow(FOLLOW_rule__KeywordGroup__KeywordsAssignment_3_in_rule__KeywordGroup__Group__3__Impl5898);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2926:1: rule__KeywordGroup__Group__4 : rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5 ;
    public final void rule__KeywordGroup__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2930:1: ( rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2931:2: rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__4__Impl_in_rule__KeywordGroup__Group__45928);
            rule__KeywordGroup__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__5_in_rule__KeywordGroup__Group__45931);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2938:1: rule__KeywordGroup__Group__4__Impl : ( ( rule__KeywordGroup__Group_4__0 )* ) ;
    public final void rule__KeywordGroup__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2942:1: ( ( ( rule__KeywordGroup__Group_4__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2943:1: ( ( rule__KeywordGroup__Group_4__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2943:1: ( ( rule__KeywordGroup__Group_4__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2944:1: ( rule__KeywordGroup__Group_4__0 )*
            {
             before(grammarAccess.getKeywordGroupAccess().getGroup_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2945:1: ( rule__KeywordGroup__Group_4__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==37) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2945:2: rule__KeywordGroup__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__KeywordGroup__Group_4__0_in_rule__KeywordGroup__Group__4__Impl5958);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2955:1: rule__KeywordGroup__Group__5 : rule__KeywordGroup__Group__5__Impl ;
    public final void rule__KeywordGroup__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2959:1: ( rule__KeywordGroup__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2960:2: rule__KeywordGroup__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__5__Impl_in_rule__KeywordGroup__Group__55989);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2966:1: rule__KeywordGroup__Group__5__Impl : ( ']' ) ;
    public final void rule__KeywordGroup__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2970:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2971:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2971:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2972:1: ']'
            {
             before(grammarAccess.getKeywordGroupAccess().getRightSquareBracketKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__KeywordGroup__Group__5__Impl6017); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2997:1: rule__KeywordGroup__Group_4__0 : rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1 ;
    public final void rule__KeywordGroup__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3001:1: ( rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3002:2: rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__0__Impl_in_rule__KeywordGroup__Group_4__06060);
            rule__KeywordGroup__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__1_in_rule__KeywordGroup__Group_4__06063);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3009:1: rule__KeywordGroup__Group_4__0__Impl : ( ',' ) ;
    public final void rule__KeywordGroup__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3013:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3014:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3014:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3015:1: ','
            {
             before(grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0()); 
            match(input,37,FOLLOW_37_in_rule__KeywordGroup__Group_4__0__Impl6091); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3028:1: rule__KeywordGroup__Group_4__1 : rule__KeywordGroup__Group_4__1__Impl ;
    public final void rule__KeywordGroup__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3032:1: ( rule__KeywordGroup__Group_4__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3033:2: rule__KeywordGroup__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__1__Impl_in_rule__KeywordGroup__Group_4__16122);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3039:1: rule__KeywordGroup__Group_4__1__Impl : ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) ) ;
    public final void rule__KeywordGroup__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3043:1: ( ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3044:1: ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3044:1: ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3045:1: ( rule__KeywordGroup__KeywordsAssignment_4_1 )
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_4_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3046:1: ( rule__KeywordGroup__KeywordsAssignment_4_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3046:2: rule__KeywordGroup__KeywordsAssignment_4_1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__KeywordsAssignment_4_1_in_rule__KeywordGroup__Group_4__1__Impl6149);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3060:1: rule__Keyword__Group__0 : rule__Keyword__Group__0__Impl rule__Keyword__Group__1 ;
    public final void rule__Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3064:1: ( rule__Keyword__Group__0__Impl rule__Keyword__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3065:2: rule__Keyword__Group__0__Impl rule__Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__06183);
            rule__Keyword__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__06186);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3072:1: rule__Keyword__Group__0__Impl : ( ( rule__Keyword__NameAssignment_0 ) ) ;
    public final void rule__Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3076:1: ( ( ( rule__Keyword__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3077:1: ( ( rule__Keyword__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3077:1: ( ( rule__Keyword__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3078:1: ( rule__Keyword__NameAssignment_0 )
            {
             before(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3079:1: ( rule__Keyword__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3079:2: rule__Keyword__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl6213);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3089:1: rule__Keyword__Group__1 : rule__Keyword__Group__1__Impl ;
    public final void rule__Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3093:1: ( rule__Keyword__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3094:2: rule__Keyword__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__16243);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3100:1: rule__Keyword__Group__1__Impl : ( ( rule__Keyword__Group_1__0 )? ) ;
    public final void rule__Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3104:1: ( ( ( rule__Keyword__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3105:1: ( ( rule__Keyword__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3105:1: ( ( rule__Keyword__Group_1__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3106:1: ( rule__Keyword__Group_1__0 )?
            {
             before(grammarAccess.getKeywordAccess().getGroup_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3107:1: ( rule__Keyword__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==38) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3107:2: rule__Keyword__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl6270);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3121:1: rule__Keyword__Group_1__0 : rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 ;
    public final void rule__Keyword__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3125:1: ( rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3126:2: rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__06305);
            rule__Keyword__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__06308);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3133:1: rule__Keyword__Group_1__0__Impl : ( 'since' ) ;
    public final void rule__Keyword__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3137:1: ( ( 'since' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3138:1: ( 'since' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3138:1: ( 'since' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3139:1: 'since'
            {
             before(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            match(input,38,FOLLOW_38_in_rule__Keyword__Group_1__0__Impl6336); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3152:1: rule__Keyword__Group_1__1 : rule__Keyword__Group_1__1__Impl ;
    public final void rule__Keyword__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3156:1: ( rule__Keyword__Group_1__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3157:2: rule__Keyword__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__16367);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3163:1: rule__Keyword__Group_1__1__Impl : ( ( rule__Keyword__VersionAssignment_1_1 ) ) ;
    public final void rule__Keyword__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3167:1: ( ( ( rule__Keyword__VersionAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3168:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3168:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3169:1: ( rule__Keyword__VersionAssignment_1_1 )
            {
             before(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3170:1: ( rule__Keyword__VersionAssignment_1_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3170:2: rule__Keyword__VersionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl6394);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3184:1: rule__ScannerSingleLineRule__Group__0 : rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1 ;
    public final void rule__ScannerSingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3188:1: ( rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3189:2: rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__0__Impl_in_rule__ScannerSingleLineRule__Group__06428);
            rule__ScannerSingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__1_in_rule__ScannerSingleLineRule__Group__06431);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3196:1: rule__ScannerSingleLineRule__Group__0__Impl : ( 'single-line' ) ;
    public final void rule__ScannerSingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3200:1: ( ( 'single-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3201:1: ( 'single-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3201:1: ( 'single-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3202:1: 'single-line'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__ScannerSingleLineRule__Group__0__Impl6459); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3215:1: rule__ScannerSingleLineRule__Group__1 : rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2 ;
    public final void rule__ScannerSingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3219:1: ( rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3220:2: rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__1__Impl_in_rule__ScannerSingleLineRule__Group__16490);
            rule__ScannerSingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__2_in_rule__ScannerSingleLineRule__Group__16493);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3227:1: rule__ScannerSingleLineRule__Group__1__Impl : ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3231:1: ( ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3232:1: ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3232:1: ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3233:1: ( rule__ScannerSingleLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3234:1: ( rule__ScannerSingleLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3234:2: rule__ScannerSingleLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__TokenAssignment_1_in_rule__ScannerSingleLineRule__Group__1__Impl6520);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3244:1: rule__ScannerSingleLineRule__Group__2 : rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3 ;
    public final void rule__ScannerSingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3248:1: ( rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3249:2: rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__2__Impl_in_rule__ScannerSingleLineRule__Group__26550);
            rule__ScannerSingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__3_in_rule__ScannerSingleLineRule__Group__26553);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3256:1: rule__ScannerSingleLineRule__Group__2__Impl : ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3260:1: ( ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3261:1: ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3261:1: ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3262:1: ( rule__ScannerSingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3263:1: ( rule__ScannerSingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3263:2: rule__ScannerSingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__StartSeqAssignment_2_in_rule__ScannerSingleLineRule__Group__2__Impl6580);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3273:1: rule__ScannerSingleLineRule__Group__3 : rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4 ;
    public final void rule__ScannerSingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3277:1: ( rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3278:2: rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__3__Impl_in_rule__ScannerSingleLineRule__Group__36610);
            rule__ScannerSingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__4_in_rule__ScannerSingleLineRule__Group__36613);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3285:1: rule__ScannerSingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__ScannerSingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3289:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3290:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3290:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3291:1: '=>'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,40,FOLLOW_40_in_rule__ScannerSingleLineRule__Group__3__Impl6641); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3304:1: rule__ScannerSingleLineRule__Group__4 : rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5 ;
    public final void rule__ScannerSingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3308:1: ( rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3309:2: rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__4__Impl_in_rule__ScannerSingleLineRule__Group__46672);
            rule__ScannerSingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__5_in_rule__ScannerSingleLineRule__Group__46675);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3316:1: rule__ScannerSingleLineRule__Group__4__Impl : ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3320:1: ( ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3321:1: ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3321:1: ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3322:1: ( rule__ScannerSingleLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3323:1: ( rule__ScannerSingleLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3323:2: rule__ScannerSingleLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__EndSeqAssignment_4_in_rule__ScannerSingleLineRule__Group__4__Impl6702);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3333:1: rule__ScannerSingleLineRule__Group__5 : rule__ScannerSingleLineRule__Group__5__Impl ;
    public final void rule__ScannerSingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3337:1: ( rule__ScannerSingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3338:2: rule__ScannerSingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__5__Impl_in_rule__ScannerSingleLineRule__Group__56732);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3344:1: rule__ScannerSingleLineRule__Group__5__Impl : ( ( rule__ScannerSingleLineRule__Group_5__0 )? ) ;
    public final void rule__ScannerSingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3348:1: ( ( ( rule__ScannerSingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3349:1: ( ( rule__ScannerSingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3349:1: ( ( rule__ScannerSingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3350:1: ( rule__ScannerSingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3351:1: ( rule__ScannerSingleLineRule__Group_5__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==41) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3351:2: rule__ScannerSingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__0_in_rule__ScannerSingleLineRule__Group__5__Impl6759);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3373:1: rule__ScannerSingleLineRule__Group_5__0 : rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1 ;
    public final void rule__ScannerSingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3377:1: ( rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3378:2: rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__0__Impl_in_rule__ScannerSingleLineRule__Group_5__06802);
            rule__ScannerSingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__1_in_rule__ScannerSingleLineRule__Group_5__06805);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3385:1: rule__ScannerSingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__ScannerSingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3389:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3390:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3390:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3391:1: 'escaped'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,41,FOLLOW_41_in_rule__ScannerSingleLineRule__Group_5__0__Impl6833); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3404:1: rule__ScannerSingleLineRule__Group_5__1 : rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2 ;
    public final void rule__ScannerSingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3408:1: ( rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3409:2: rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__1__Impl_in_rule__ScannerSingleLineRule__Group_5__16864);
            rule__ScannerSingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__2_in_rule__ScannerSingleLineRule__Group_5__16867);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3416:1: rule__ScannerSingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__ScannerSingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3420:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3421:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3421:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3422:1: 'by'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,42,FOLLOW_42_in_rule__ScannerSingleLineRule__Group_5__1__Impl6895); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3435:1: rule__ScannerSingleLineRule__Group_5__2 : rule__ScannerSingleLineRule__Group_5__2__Impl ;
    public final void rule__ScannerSingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3439:1: ( rule__ScannerSingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3440:2: rule__ScannerSingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__2__Impl_in_rule__ScannerSingleLineRule__Group_5__26926);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3446:1: rule__ScannerSingleLineRule__Group_5__2__Impl : ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__ScannerSingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3450:1: ( ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3451:1: ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3451:1: ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3452:1: ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3453:1: ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3453:2: rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerSingleLineRule__Group_5__2__Impl6953);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3469:1: rule__PartitionSingleLineRule__Group__0 : rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1 ;
    public final void rule__PartitionSingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3473:1: ( rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3474:2: rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__0__Impl_in_rule__PartitionSingleLineRule__Group__06989);
            rule__PartitionSingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__1_in_rule__PartitionSingleLineRule__Group__06992);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3481:1: rule__PartitionSingleLineRule__Group__0__Impl : ( 'single-line' ) ;
    public final void rule__PartitionSingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3485:1: ( ( 'single-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3486:1: ( 'single-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3486:1: ( 'single-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3487:1: 'single-line'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__PartitionSingleLineRule__Group__0__Impl7020); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3500:1: rule__PartitionSingleLineRule__Group__1 : rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2 ;
    public final void rule__PartitionSingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3504:1: ( rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3505:2: rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__1__Impl_in_rule__PartitionSingleLineRule__Group__17051);
            rule__PartitionSingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__2_in_rule__PartitionSingleLineRule__Group__17054);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3512:1: rule__PartitionSingleLineRule__Group__1__Impl : ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3516:1: ( ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3517:1: ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3517:1: ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3518:1: ( rule__PartitionSingleLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3519:1: ( rule__PartitionSingleLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3519:2: rule__PartitionSingleLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__ParitionAssignment_1_in_rule__PartitionSingleLineRule__Group__1__Impl7081);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3529:1: rule__PartitionSingleLineRule__Group__2 : rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3 ;
    public final void rule__PartitionSingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3533:1: ( rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3534:2: rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__2__Impl_in_rule__PartitionSingleLineRule__Group__27111);
            rule__PartitionSingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__3_in_rule__PartitionSingleLineRule__Group__27114);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3541:1: rule__PartitionSingleLineRule__Group__2__Impl : ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3545:1: ( ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3546:1: ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3546:1: ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3547:1: ( rule__PartitionSingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3548:1: ( rule__PartitionSingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3548:2: rule__PartitionSingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__StartSeqAssignment_2_in_rule__PartitionSingleLineRule__Group__2__Impl7141);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3558:1: rule__PartitionSingleLineRule__Group__3 : rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4 ;
    public final void rule__PartitionSingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3562:1: ( rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3563:2: rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__3__Impl_in_rule__PartitionSingleLineRule__Group__37171);
            rule__PartitionSingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__4_in_rule__PartitionSingleLineRule__Group__37174);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3570:1: rule__PartitionSingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__PartitionSingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3574:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3575:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3575:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3576:1: '=>'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,40,FOLLOW_40_in_rule__PartitionSingleLineRule__Group__3__Impl7202); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3589:1: rule__PartitionSingleLineRule__Group__4 : rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5 ;
    public final void rule__PartitionSingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3593:1: ( rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3594:2: rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__4__Impl_in_rule__PartitionSingleLineRule__Group__47233);
            rule__PartitionSingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__5_in_rule__PartitionSingleLineRule__Group__47236);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3601:1: rule__PartitionSingleLineRule__Group__4__Impl : ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3605:1: ( ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3606:1: ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3606:1: ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3607:1: ( rule__PartitionSingleLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3608:1: ( rule__PartitionSingleLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3608:2: rule__PartitionSingleLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__EndSeqAssignment_4_in_rule__PartitionSingleLineRule__Group__4__Impl7263);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3618:1: rule__PartitionSingleLineRule__Group__5 : rule__PartitionSingleLineRule__Group__5__Impl ;
    public final void rule__PartitionSingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3622:1: ( rule__PartitionSingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3623:2: rule__PartitionSingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__5__Impl_in_rule__PartitionSingleLineRule__Group__57293);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3629:1: rule__PartitionSingleLineRule__Group__5__Impl : ( ( rule__PartitionSingleLineRule__Group_5__0 )? ) ;
    public final void rule__PartitionSingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3633:1: ( ( ( rule__PartitionSingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3634:1: ( ( rule__PartitionSingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3634:1: ( ( rule__PartitionSingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3635:1: ( rule__PartitionSingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3636:1: ( rule__PartitionSingleLineRule__Group_5__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==41) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3636:2: rule__PartitionSingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__0_in_rule__PartitionSingleLineRule__Group__5__Impl7320);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3658:1: rule__PartitionSingleLineRule__Group_5__0 : rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1 ;
    public final void rule__PartitionSingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3662:1: ( rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3663:2: rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__0__Impl_in_rule__PartitionSingleLineRule__Group_5__07363);
            rule__PartitionSingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__1_in_rule__PartitionSingleLineRule__Group_5__07366);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3670:1: rule__PartitionSingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__PartitionSingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3674:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3675:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3675:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3676:1: 'escaped'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,41,FOLLOW_41_in_rule__PartitionSingleLineRule__Group_5__0__Impl7394); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3689:1: rule__PartitionSingleLineRule__Group_5__1 : rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2 ;
    public final void rule__PartitionSingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3693:1: ( rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3694:2: rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__1__Impl_in_rule__PartitionSingleLineRule__Group_5__17425);
            rule__PartitionSingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__2_in_rule__PartitionSingleLineRule__Group_5__17428);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3701:1: rule__PartitionSingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__PartitionSingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3705:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3706:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3706:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3707:1: 'by'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,42,FOLLOW_42_in_rule__PartitionSingleLineRule__Group_5__1__Impl7456); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3720:1: rule__PartitionSingleLineRule__Group_5__2 : rule__PartitionSingleLineRule__Group_5__2__Impl ;
    public final void rule__PartitionSingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3724:1: ( rule__PartitionSingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3725:2: rule__PartitionSingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__2__Impl_in_rule__PartitionSingleLineRule__Group_5__27487);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3731:1: rule__PartitionSingleLineRule__Group_5__2__Impl : ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__PartitionSingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3735:1: ( ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3736:1: ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3736:1: ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3737:1: ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3738:1: ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3738:2: rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionSingleLineRule__Group_5__2__Impl7514);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3754:1: rule__ScannerMultiLineRule__Group__0 : rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1 ;
    public final void rule__ScannerMultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3758:1: ( rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3759:2: rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__0__Impl_in_rule__ScannerMultiLineRule__Group__07550);
            rule__ScannerMultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__1_in_rule__ScannerMultiLineRule__Group__07553);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3766:1: rule__ScannerMultiLineRule__Group__0__Impl : ( 'multi-line' ) ;
    public final void rule__ScannerMultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3770:1: ( ( 'multi-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3771:1: ( 'multi-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3771:1: ( 'multi-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3772:1: 'multi-line'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0()); 
            match(input,43,FOLLOW_43_in_rule__ScannerMultiLineRule__Group__0__Impl7581); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3785:1: rule__ScannerMultiLineRule__Group__1 : rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2 ;
    public final void rule__ScannerMultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3789:1: ( rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3790:2: rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__1__Impl_in_rule__ScannerMultiLineRule__Group__17612);
            rule__ScannerMultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__2_in_rule__ScannerMultiLineRule__Group__17615);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3797:1: rule__ScannerMultiLineRule__Group__1__Impl : ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3801:1: ( ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3802:1: ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3802:1: ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3803:1: ( rule__ScannerMultiLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3804:1: ( rule__ScannerMultiLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3804:2: rule__ScannerMultiLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__TokenAssignment_1_in_rule__ScannerMultiLineRule__Group__1__Impl7642);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3814:1: rule__ScannerMultiLineRule__Group__2 : rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3 ;
    public final void rule__ScannerMultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3818:1: ( rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3819:2: rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__2__Impl_in_rule__ScannerMultiLineRule__Group__27672);
            rule__ScannerMultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__3_in_rule__ScannerMultiLineRule__Group__27675);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3826:1: rule__ScannerMultiLineRule__Group__2__Impl : ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3830:1: ( ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3831:1: ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3831:1: ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3832:1: ( rule__ScannerMultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3833:1: ( rule__ScannerMultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3833:2: rule__ScannerMultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__StartSeqAssignment_2_in_rule__ScannerMultiLineRule__Group__2__Impl7702);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3843:1: rule__ScannerMultiLineRule__Group__3 : rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4 ;
    public final void rule__ScannerMultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3847:1: ( rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3848:2: rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__3__Impl_in_rule__ScannerMultiLineRule__Group__37732);
            rule__ScannerMultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__4_in_rule__ScannerMultiLineRule__Group__37735);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3855:1: rule__ScannerMultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__ScannerMultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3859:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3860:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3860:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3861:1: '=>'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,40,FOLLOW_40_in_rule__ScannerMultiLineRule__Group__3__Impl7763); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3874:1: rule__ScannerMultiLineRule__Group__4 : rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5 ;
    public final void rule__ScannerMultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3878:1: ( rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3879:2: rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__4__Impl_in_rule__ScannerMultiLineRule__Group__47794);
            rule__ScannerMultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__5_in_rule__ScannerMultiLineRule__Group__47797);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3886:1: rule__ScannerMultiLineRule__Group__4__Impl : ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3890:1: ( ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3891:1: ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3891:1: ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3892:1: ( rule__ScannerMultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3893:1: ( rule__ScannerMultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3893:2: rule__ScannerMultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__EndSeqAssignment_4_in_rule__ScannerMultiLineRule__Group__4__Impl7824);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3903:1: rule__ScannerMultiLineRule__Group__5 : rule__ScannerMultiLineRule__Group__5__Impl ;
    public final void rule__ScannerMultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3907:1: ( rule__ScannerMultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3908:2: rule__ScannerMultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__5__Impl_in_rule__ScannerMultiLineRule__Group__57854);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3914:1: rule__ScannerMultiLineRule__Group__5__Impl : ( ( rule__ScannerMultiLineRule__Group_5__0 )? ) ;
    public final void rule__ScannerMultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3918:1: ( ( ( rule__ScannerMultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3919:1: ( ( rule__ScannerMultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3919:1: ( ( rule__ScannerMultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3920:1: ( rule__ScannerMultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3921:1: ( rule__ScannerMultiLineRule__Group_5__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==41) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3921:2: rule__ScannerMultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__0_in_rule__ScannerMultiLineRule__Group__5__Impl7881);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3943:1: rule__ScannerMultiLineRule__Group_5__0 : rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1 ;
    public final void rule__ScannerMultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3947:1: ( rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3948:2: rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__0__Impl_in_rule__ScannerMultiLineRule__Group_5__07924);
            rule__ScannerMultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__1_in_rule__ScannerMultiLineRule__Group_5__07927);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3955:1: rule__ScannerMultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__ScannerMultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3959:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3960:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3960:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3961:1: 'escaped'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,41,FOLLOW_41_in_rule__ScannerMultiLineRule__Group_5__0__Impl7955); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3974:1: rule__ScannerMultiLineRule__Group_5__1 : rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2 ;
    public final void rule__ScannerMultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3978:1: ( rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3979:2: rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__1__Impl_in_rule__ScannerMultiLineRule__Group_5__17986);
            rule__ScannerMultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__2_in_rule__ScannerMultiLineRule__Group_5__17989);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3986:1: rule__ScannerMultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__ScannerMultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3990:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3991:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3991:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3992:1: 'by'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,42,FOLLOW_42_in_rule__ScannerMultiLineRule__Group_5__1__Impl8017); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4005:1: rule__ScannerMultiLineRule__Group_5__2 : rule__ScannerMultiLineRule__Group_5__2__Impl ;
    public final void rule__ScannerMultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4009:1: ( rule__ScannerMultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4010:2: rule__ScannerMultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__2__Impl_in_rule__ScannerMultiLineRule__Group_5__28048);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4016:1: rule__ScannerMultiLineRule__Group_5__2__Impl : ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__ScannerMultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4020:1: ( ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4021:1: ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4021:1: ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4022:1: ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4023:1: ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4023:2: rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerMultiLineRule__Group_5__2__Impl8075);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4039:1: rule__PartitionMultiLineRule__Group__0 : rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1 ;
    public final void rule__PartitionMultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4043:1: ( rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4044:2: rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__0__Impl_in_rule__PartitionMultiLineRule__Group__08111);
            rule__PartitionMultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__1_in_rule__PartitionMultiLineRule__Group__08114);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4051:1: rule__PartitionMultiLineRule__Group__0__Impl : ( 'multi-line' ) ;
    public final void rule__PartitionMultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4055:1: ( ( 'multi-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4056:1: ( 'multi-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4056:1: ( 'multi-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4057:1: 'multi-line'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0()); 
            match(input,43,FOLLOW_43_in_rule__PartitionMultiLineRule__Group__0__Impl8142); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4070:1: rule__PartitionMultiLineRule__Group__1 : rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2 ;
    public final void rule__PartitionMultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4074:1: ( rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4075:2: rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__1__Impl_in_rule__PartitionMultiLineRule__Group__18173);
            rule__PartitionMultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__2_in_rule__PartitionMultiLineRule__Group__18176);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4082:1: rule__PartitionMultiLineRule__Group__1__Impl : ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4086:1: ( ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4087:1: ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4087:1: ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4088:1: ( rule__PartitionMultiLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4089:1: ( rule__PartitionMultiLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4089:2: rule__PartitionMultiLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__ParitionAssignment_1_in_rule__PartitionMultiLineRule__Group__1__Impl8203);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4099:1: rule__PartitionMultiLineRule__Group__2 : rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3 ;
    public final void rule__PartitionMultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4103:1: ( rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4104:2: rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__2__Impl_in_rule__PartitionMultiLineRule__Group__28233);
            rule__PartitionMultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__3_in_rule__PartitionMultiLineRule__Group__28236);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4111:1: rule__PartitionMultiLineRule__Group__2__Impl : ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4115:1: ( ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4116:1: ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4116:1: ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4117:1: ( rule__PartitionMultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4118:1: ( rule__PartitionMultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4118:2: rule__PartitionMultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__StartSeqAssignment_2_in_rule__PartitionMultiLineRule__Group__2__Impl8263);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4128:1: rule__PartitionMultiLineRule__Group__3 : rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4 ;
    public final void rule__PartitionMultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4132:1: ( rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4133:2: rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__3__Impl_in_rule__PartitionMultiLineRule__Group__38293);
            rule__PartitionMultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__4_in_rule__PartitionMultiLineRule__Group__38296);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4140:1: rule__PartitionMultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__PartitionMultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4144:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4145:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4145:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4146:1: '=>'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,40,FOLLOW_40_in_rule__PartitionMultiLineRule__Group__3__Impl8324); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4159:1: rule__PartitionMultiLineRule__Group__4 : rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5 ;
    public final void rule__PartitionMultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4163:1: ( rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4164:2: rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__4__Impl_in_rule__PartitionMultiLineRule__Group__48355);
            rule__PartitionMultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__5_in_rule__PartitionMultiLineRule__Group__48358);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4171:1: rule__PartitionMultiLineRule__Group__4__Impl : ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4175:1: ( ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4176:1: ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4176:1: ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4177:1: ( rule__PartitionMultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4178:1: ( rule__PartitionMultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4178:2: rule__PartitionMultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__EndSeqAssignment_4_in_rule__PartitionMultiLineRule__Group__4__Impl8385);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4188:1: rule__PartitionMultiLineRule__Group__5 : rule__PartitionMultiLineRule__Group__5__Impl ;
    public final void rule__PartitionMultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4192:1: ( rule__PartitionMultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4193:2: rule__PartitionMultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__5__Impl_in_rule__PartitionMultiLineRule__Group__58415);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4199:1: rule__PartitionMultiLineRule__Group__5__Impl : ( ( rule__PartitionMultiLineRule__Group_5__0 )? ) ;
    public final void rule__PartitionMultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4203:1: ( ( ( rule__PartitionMultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4204:1: ( ( rule__PartitionMultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4204:1: ( ( rule__PartitionMultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4205:1: ( rule__PartitionMultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4206:1: ( rule__PartitionMultiLineRule__Group_5__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==41) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4206:2: rule__PartitionMultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__0_in_rule__PartitionMultiLineRule__Group__5__Impl8442);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4228:1: rule__PartitionMultiLineRule__Group_5__0 : rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1 ;
    public final void rule__PartitionMultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4232:1: ( rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4233:2: rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__0__Impl_in_rule__PartitionMultiLineRule__Group_5__08485);
            rule__PartitionMultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__1_in_rule__PartitionMultiLineRule__Group_5__08488);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4240:1: rule__PartitionMultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__PartitionMultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4244:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4245:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4245:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4246:1: 'escaped'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,41,FOLLOW_41_in_rule__PartitionMultiLineRule__Group_5__0__Impl8516); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4259:1: rule__PartitionMultiLineRule__Group_5__1 : rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2 ;
    public final void rule__PartitionMultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4263:1: ( rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4264:2: rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__1__Impl_in_rule__PartitionMultiLineRule__Group_5__18547);
            rule__PartitionMultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__2_in_rule__PartitionMultiLineRule__Group_5__18550);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4271:1: rule__PartitionMultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__PartitionMultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4275:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4276:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4276:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4277:1: 'by'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,42,FOLLOW_42_in_rule__PartitionMultiLineRule__Group_5__1__Impl8578); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4290:1: rule__PartitionMultiLineRule__Group_5__2 : rule__PartitionMultiLineRule__Group_5__2__Impl ;
    public final void rule__PartitionMultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4294:1: ( rule__PartitionMultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4295:2: rule__PartitionMultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__2__Impl_in_rule__PartitionMultiLineRule__Group_5__28609);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4301:1: rule__PartitionMultiLineRule__Group_5__2__Impl : ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__PartitionMultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4305:1: ( ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4306:1: ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4306:1: ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4307:1: ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4308:1: ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4308:2: rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionMultiLineRule__Group_5__2__Impl8636);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4324:1: rule__ScannerCharacterRule__Group__0 : rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1 ;
    public final void rule__ScannerCharacterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4328:1: ( rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4329:2: rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__0__Impl_in_rule__ScannerCharacterRule__Group__08672);
            rule__ScannerCharacterRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__1_in_rule__ScannerCharacterRule__Group__08675);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4336:1: rule__ScannerCharacterRule__Group__0__Impl : ( 'character-rule' ) ;
    public final void rule__ScannerCharacterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4340:1: ( ( 'character-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4341:1: ( 'character-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4341:1: ( 'character-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4342:1: 'character-rule'
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0()); 
            match(input,44,FOLLOW_44_in_rule__ScannerCharacterRule__Group__0__Impl8703); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4355:1: rule__ScannerCharacterRule__Group__1 : rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2 ;
    public final void rule__ScannerCharacterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4359:1: ( rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4360:2: rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__1__Impl_in_rule__ScannerCharacterRule__Group__18734);
            rule__ScannerCharacterRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__2_in_rule__ScannerCharacterRule__Group__18737);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4367:1: rule__ScannerCharacterRule__Group__1__Impl : ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerCharacterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4371:1: ( ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4372:1: ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4372:1: ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4373:1: ( rule__ScannerCharacterRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4374:1: ( rule__ScannerCharacterRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4374:2: rule__ScannerCharacterRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__TokenAssignment_1_in_rule__ScannerCharacterRule__Group__1__Impl8764);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4384:1: rule__ScannerCharacterRule__Group__2 : rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3 ;
    public final void rule__ScannerCharacterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4388:1: ( rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4389:2: rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__2__Impl_in_rule__ScannerCharacterRule__Group__28794);
            rule__ScannerCharacterRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__3_in_rule__ScannerCharacterRule__Group__28797);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4396:1: rule__ScannerCharacterRule__Group__2__Impl : ( '[' ) ;
    public final void rule__ScannerCharacterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4400:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4401:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4401:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4402:1: '['
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__ScannerCharacterRule__Group__2__Impl8825); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4415:1: rule__ScannerCharacterRule__Group__3 : rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4 ;
    public final void rule__ScannerCharacterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4419:1: ( rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4420:2: rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__3__Impl_in_rule__ScannerCharacterRule__Group__38856);
            rule__ScannerCharacterRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__4_in_rule__ScannerCharacterRule__Group__38859);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4427:1: rule__ScannerCharacterRule__Group__3__Impl : ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) ) ;
    public final void rule__ScannerCharacterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4431:1: ( ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4432:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4432:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4433:1: ( rule__ScannerCharacterRule__CharactersAssignment_3 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4434:1: ( rule__ScannerCharacterRule__CharactersAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4434:2: rule__ScannerCharacterRule__CharactersAssignment_3
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_3_in_rule__ScannerCharacterRule__Group__3__Impl8886);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4444:1: rule__ScannerCharacterRule__Group__4 : rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5 ;
    public final void rule__ScannerCharacterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4448:1: ( rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4449:2: rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__4__Impl_in_rule__ScannerCharacterRule__Group__48916);
            rule__ScannerCharacterRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__5_in_rule__ScannerCharacterRule__Group__48919);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4456:1: rule__ScannerCharacterRule__Group__4__Impl : ( ( rule__ScannerCharacterRule__Group_4__0 )* ) ;
    public final void rule__ScannerCharacterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4460:1: ( ( ( rule__ScannerCharacterRule__Group_4__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4461:1: ( ( rule__ScannerCharacterRule__Group_4__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4461:1: ( ( rule__ScannerCharacterRule__Group_4__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4462:1: ( rule__ScannerCharacterRule__Group_4__0 )*
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getGroup_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4463:1: ( rule__ScannerCharacterRule__Group_4__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==37) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4463:2: rule__ScannerCharacterRule__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__0_in_rule__ScannerCharacterRule__Group__4__Impl8946);
            	    rule__ScannerCharacterRule__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getScannerCharacterRuleAccess().getGroup_4()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4473:1: rule__ScannerCharacterRule__Group__5 : rule__ScannerCharacterRule__Group__5__Impl ;
    public final void rule__ScannerCharacterRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4477:1: ( rule__ScannerCharacterRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4478:2: rule__ScannerCharacterRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__5__Impl_in_rule__ScannerCharacterRule__Group__58977);
            rule__ScannerCharacterRule__Group__5__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4484:1: rule__ScannerCharacterRule__Group__5__Impl : ( ']' ) ;
    public final void rule__ScannerCharacterRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4488:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4489:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4489:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4490:1: ']'
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getRightSquareBracketKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__ScannerCharacterRule__Group__5__Impl9005); 
             after(grammarAccess.getScannerCharacterRuleAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__ScannerCharacterRule__Group_4__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4515:1: rule__ScannerCharacterRule__Group_4__0 : rule__ScannerCharacterRule__Group_4__0__Impl rule__ScannerCharacterRule__Group_4__1 ;
    public final void rule__ScannerCharacterRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4519:1: ( rule__ScannerCharacterRule__Group_4__0__Impl rule__ScannerCharacterRule__Group_4__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4520:2: rule__ScannerCharacterRule__Group_4__0__Impl rule__ScannerCharacterRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__0__Impl_in_rule__ScannerCharacterRule__Group_4__09048);
            rule__ScannerCharacterRule__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__1_in_rule__ScannerCharacterRule__Group_4__09051);
            rule__ScannerCharacterRule__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group_4__0"


    // $ANTLR start "rule__ScannerCharacterRule__Group_4__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4527:1: rule__ScannerCharacterRule__Group_4__0__Impl : ( ',' ) ;
    public final void rule__ScannerCharacterRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4531:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4532:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4532:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4533:1: ','
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4_0()); 
            match(input,37,FOLLOW_37_in_rule__ScannerCharacterRule__Group_4__0__Impl9079); 
             after(grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group_4__0__Impl"


    // $ANTLR start "rule__ScannerCharacterRule__Group_4__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4546:1: rule__ScannerCharacterRule__Group_4__1 : rule__ScannerCharacterRule__Group_4__1__Impl ;
    public final void rule__ScannerCharacterRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4550:1: ( rule__ScannerCharacterRule__Group_4__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4551:2: rule__ScannerCharacterRule__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__1__Impl_in_rule__ScannerCharacterRule__Group_4__19110);
            rule__ScannerCharacterRule__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group_4__1"


    // $ANTLR start "rule__ScannerCharacterRule__Group_4__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4557:1: rule__ScannerCharacterRule__Group_4__1__Impl : ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) ) ;
    public final void rule__ScannerCharacterRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4561:1: ( ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4562:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4562:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4563:1: ( rule__ScannerCharacterRule__CharactersAssignment_4_1 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_4_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4564:1: ( rule__ScannerCharacterRule__CharactersAssignment_4_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4564:2: rule__ScannerCharacterRule__CharactersAssignment_4_1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_4_1_in_rule__ScannerCharacterRule__Group_4__1__Impl9137);
            rule__ScannerCharacterRule__CharactersAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__Group_4__1__Impl"


    // $ANTLR start "rule__ScannerJSRule__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4578:1: rule__ScannerJSRule__Group__0 : rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1 ;
    public final void rule__ScannerJSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4582:1: ( rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4583:2: rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__0__Impl_in_rule__ScannerJSRule__Group__09171);
            rule__ScannerJSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerJSRule__Group__1_in_rule__ScannerJSRule__Group__09174);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4590:1: rule__ScannerJSRule__Group__0__Impl : ( 'javascript-rule' ) ;
    public final void rule__ScannerJSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4594:1: ( ( 'javascript-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4595:1: ( 'javascript-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4595:1: ( 'javascript-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4596:1: 'javascript-rule'
            {
             before(grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0()); 
            match(input,45,FOLLOW_45_in_rule__ScannerJSRule__Group__0__Impl9202); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4609:1: rule__ScannerJSRule__Group__1 : rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2 ;
    public final void rule__ScannerJSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4613:1: ( rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4614:2: rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__1__Impl_in_rule__ScannerJSRule__Group__19233);
            rule__ScannerJSRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerJSRule__Group__2_in_rule__ScannerJSRule__Group__19236);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4621:1: rule__ScannerJSRule__Group__1__Impl : ( ( rule__ScannerJSRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerJSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4625:1: ( ( ( rule__ScannerJSRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4626:1: ( ( rule__ScannerJSRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4626:1: ( ( rule__ScannerJSRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4627:1: ( rule__ScannerJSRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4628:1: ( rule__ScannerJSRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4628:2: rule__ScannerJSRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__TokenAssignment_1_in_rule__ScannerJSRule__Group__1__Impl9263);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4638:1: rule__ScannerJSRule__Group__2 : rule__ScannerJSRule__Group__2__Impl ;
    public final void rule__ScannerJSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4642:1: ( rule__ScannerJSRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4643:2: rule__ScannerJSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__2__Impl_in_rule__ScannerJSRule__Group__29293);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4649:1: rule__ScannerJSRule__Group__2__Impl : ( ( rule__ScannerJSRule__FileURIAssignment_2 ) ) ;
    public final void rule__ScannerJSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4653:1: ( ( ( rule__ScannerJSRule__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4654:1: ( ( rule__ScannerJSRule__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4654:1: ( ( rule__ScannerJSRule__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4655:1: ( rule__ScannerJSRule__FileURIAssignment_2 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4656:1: ( rule__ScannerJSRule__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4656:2: rule__ScannerJSRule__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__FileURIAssignment_2_in_rule__ScannerJSRule__Group__2__Impl9320);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4672:1: rule__PartitionJSRule__Group__0 : rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1 ;
    public final void rule__PartitionJSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4676:1: ( rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4677:2: rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__0__Impl_in_rule__PartitionJSRule__Group__09356);
            rule__PartitionJSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionJSRule__Group__1_in_rule__PartitionJSRule__Group__09359);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4684:1: rule__PartitionJSRule__Group__0__Impl : ( 'javascript-rule' ) ;
    public final void rule__PartitionJSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4688:1: ( ( 'javascript-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4689:1: ( 'javascript-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4689:1: ( 'javascript-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4690:1: 'javascript-rule'
            {
             before(grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0()); 
            match(input,45,FOLLOW_45_in_rule__PartitionJSRule__Group__0__Impl9387); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4703:1: rule__PartitionJSRule__Group__1 : rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2 ;
    public final void rule__PartitionJSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4707:1: ( rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4708:2: rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__1__Impl_in_rule__PartitionJSRule__Group__19418);
            rule__PartitionJSRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionJSRule__Group__2_in_rule__PartitionJSRule__Group__19421);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4715:1: rule__PartitionJSRule__Group__1__Impl : ( ( rule__PartitionJSRule__TokenAssignment_1 ) ) ;
    public final void rule__PartitionJSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4719:1: ( ( ( rule__PartitionJSRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4720:1: ( ( rule__PartitionJSRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4720:1: ( ( rule__PartitionJSRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4721:1: ( rule__PartitionJSRule__TokenAssignment_1 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4722:1: ( rule__PartitionJSRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4722:2: rule__PartitionJSRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__TokenAssignment_1_in_rule__PartitionJSRule__Group__1__Impl9448);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4732:1: rule__PartitionJSRule__Group__2 : rule__PartitionJSRule__Group__2__Impl ;
    public final void rule__PartitionJSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4736:1: ( rule__PartitionJSRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4737:2: rule__PartitionJSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__2__Impl_in_rule__PartitionJSRule__Group__29478);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4743:1: rule__PartitionJSRule__Group__2__Impl : ( ( rule__PartitionJSRule__FileURIAssignment_2 ) ) ;
    public final void rule__PartitionJSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4747:1: ( ( ( rule__PartitionJSRule__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4748:1: ( ( rule__PartitionJSRule__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4748:1: ( ( rule__PartitionJSRule__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4749:1: ( rule__PartitionJSRule__FileURIAssignment_2 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4750:1: ( rule__PartitionJSRule__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4750:2: rule__PartitionJSRule__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__FileURIAssignment_2_in_rule__PartitionJSRule__Group__2__Impl9505);
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


    // $ANTLR start "rule__ScannerWhitespaceRule__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4766:1: rule__ScannerWhitespaceRule__Group__0 : rule__ScannerWhitespaceRule__Group__0__Impl rule__ScannerWhitespaceRule__Group__1 ;
    public final void rule__ScannerWhitespaceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4770:1: ( rule__ScannerWhitespaceRule__Group__0__Impl rule__ScannerWhitespaceRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4771:2: rule__ScannerWhitespaceRule__Group__0__Impl rule__ScannerWhitespaceRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__0__Impl_in_rule__ScannerWhitespaceRule__Group__09541);
            rule__ScannerWhitespaceRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__1_in_rule__ScannerWhitespaceRule__Group__09544);
            rule__ScannerWhitespaceRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group__0"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4778:1: rule__ScannerWhitespaceRule__Group__0__Impl : ( 'whitespace-rule' ) ;
    public final void rule__ScannerWhitespaceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4782:1: ( ( 'whitespace-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4783:1: ( 'whitespace-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4783:1: ( 'whitespace-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4784:1: 'whitespace-rule'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0()); 
            match(input,46,FOLLOW_46_in_rule__ScannerWhitespaceRule__Group__0__Impl9572); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group__0__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4797:1: rule__ScannerWhitespaceRule__Group__1 : rule__ScannerWhitespaceRule__Group__1__Impl rule__ScannerWhitespaceRule__Group__2 ;
    public final void rule__ScannerWhitespaceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4801:1: ( rule__ScannerWhitespaceRule__Group__1__Impl rule__ScannerWhitespaceRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4802:2: rule__ScannerWhitespaceRule__Group__1__Impl rule__ScannerWhitespaceRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__1__Impl_in_rule__ScannerWhitespaceRule__Group__19603);
            rule__ScannerWhitespaceRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__2_in_rule__ScannerWhitespaceRule__Group__19606);
            rule__ScannerWhitespaceRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group__1"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4809:1: rule__ScannerWhitespaceRule__Group__1__Impl : ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? ) ;
    public final void rule__ScannerWhitespaceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4813:1: ( ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4814:1: ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4814:1: ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4815:1: ( rule__ScannerWhitespaceRule__TokenAssignment_1 )?
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4816:1: ( rule__ScannerWhitespaceRule__TokenAssignment_1 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4816:2: rule__ScannerWhitespaceRule__TokenAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__TokenAssignment_1_in_rule__ScannerWhitespaceRule__Group__1__Impl9633);
                    rule__ScannerWhitespaceRule__TokenAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getTokenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group__1__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4826:1: rule__ScannerWhitespaceRule__Group__2 : rule__ScannerWhitespaceRule__Group__2__Impl ;
    public final void rule__ScannerWhitespaceRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4830:1: ( rule__ScannerWhitespaceRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4831:2: rule__ScannerWhitespaceRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__2__Impl_in_rule__ScannerWhitespaceRule__Group__29664);
            rule__ScannerWhitespaceRule__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group__2"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4837:1: rule__ScannerWhitespaceRule__Group__2__Impl : ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4841:1: ( ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4842:1: ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4842:1: ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4843:1: ( rule__ScannerWhitespaceRule__Alternatives_2 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getAlternatives_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4844:1: ( rule__ScannerWhitespaceRule__Alternatives_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4844:2: rule__ScannerWhitespaceRule__Alternatives_2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Alternatives_2_in_rule__ScannerWhitespaceRule__Group__2__Impl9691);
            rule__ScannerWhitespaceRule__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group__2__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4860:1: rule__ScannerWhitespaceRule__Group_2_0__0 : rule__ScannerWhitespaceRule__Group_2_0__0__Impl rule__ScannerWhitespaceRule__Group_2_0__1 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4864:1: ( rule__ScannerWhitespaceRule__Group_2_0__0__Impl rule__ScannerWhitespaceRule__Group_2_0__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4865:2: rule__ScannerWhitespaceRule__Group_2_0__0__Impl rule__ScannerWhitespaceRule__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__09727);
            rule__ScannerWhitespaceRule__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1_in_rule__ScannerWhitespaceRule__Group_2_0__09730);
            rule__ScannerWhitespaceRule__Group_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0__0"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4872:1: rule__ScannerWhitespaceRule__Group_2_0__0__Impl : ( '[' ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4876:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4877:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4877:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4878:1: '['
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_2_0_0()); 
            match(input,35,FOLLOW_35_in_rule__ScannerWhitespaceRule__Group_2_0__0__Impl9758); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0__0__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4891:1: rule__ScannerWhitespaceRule__Group_2_0__1 : rule__ScannerWhitespaceRule__Group_2_0__1__Impl rule__ScannerWhitespaceRule__Group_2_0__2 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4895:1: ( rule__ScannerWhitespaceRule__Group_2_0__1__Impl rule__ScannerWhitespaceRule__Group_2_0__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4896:2: rule__ScannerWhitespaceRule__Group_2_0__1__Impl rule__ScannerWhitespaceRule__Group_2_0__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__19789);
            rule__ScannerWhitespaceRule__Group_2_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2_in_rule__ScannerWhitespaceRule__Group_2_0__19792);
            rule__ScannerWhitespaceRule__Group_2_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0__1"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4903:1: rule__ScannerWhitespaceRule__Group_2_0__1__Impl : ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4907:1: ( ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4908:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4908:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4909:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_2_0_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4910:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4910:2: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1_in_rule__ScannerWhitespaceRule__Group_2_0__1__Impl9819);
            rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0__1__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0__2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4920:1: rule__ScannerWhitespaceRule__Group_2_0__2 : rule__ScannerWhitespaceRule__Group_2_0__2__Impl rule__ScannerWhitespaceRule__Group_2_0__3 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4924:1: ( rule__ScannerWhitespaceRule__Group_2_0__2__Impl rule__ScannerWhitespaceRule__Group_2_0__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4925:2: rule__ScannerWhitespaceRule__Group_2_0__2__Impl rule__ScannerWhitespaceRule__Group_2_0__3
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__29849);
            rule__ScannerWhitespaceRule__Group_2_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3_in_rule__ScannerWhitespaceRule__Group_2_0__29852);
            rule__ScannerWhitespaceRule__Group_2_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0__2"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0__2__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4932:1: rule__ScannerWhitespaceRule__Group_2_0__2__Impl : ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4936:1: ( ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4937:1: ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4937:1: ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4938:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )*
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_2_0_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4939:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==37) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4939:2: rule__ScannerWhitespaceRule__Group_2_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0_in_rule__ScannerWhitespaceRule__Group_2_0__2__Impl9879);
            	    rule__ScannerWhitespaceRule__Group_2_0_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_2_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0__2__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0__3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4949:1: rule__ScannerWhitespaceRule__Group_2_0__3 : rule__ScannerWhitespaceRule__Group_2_0__3__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4953:1: ( rule__ScannerWhitespaceRule__Group_2_0__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4954:2: rule__ScannerWhitespaceRule__Group_2_0__3__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__39910);
            rule__ScannerWhitespaceRule__Group_2_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0__3"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0__3__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4960:1: rule__ScannerWhitespaceRule__Group_2_0__3__Impl : ( ']' ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4964:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4965:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4965:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4966:1: ']'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_2_0_3()); 
            match(input,36,FOLLOW_36_in_rule__ScannerWhitespaceRule__Group_2_0__3__Impl9938); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_2_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0__3__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0_2__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4987:1: rule__ScannerWhitespaceRule__Group_2_0_2__0 : rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl rule__ScannerWhitespaceRule__Group_2_0_2__1 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4991:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl rule__ScannerWhitespaceRule__Group_2_0_2__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4992:2: rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl rule__ScannerWhitespaceRule__Group_2_0_2__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__09977);
            rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1_in_rule__ScannerWhitespaceRule__Group_2_0_2__09980);
            rule__ScannerWhitespaceRule__Group_2_0_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0_2__0"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4999:1: rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl : ( ',' ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5003:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5004:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5004:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5005:1: ','
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_2_0_2_0()); 
            match(input,37,FOLLOW_37_in_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl10008); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_2_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0_2__1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5018:1: rule__ScannerWhitespaceRule__Group_2_0_2__1 : rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5022:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5023:2: rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__110039);
            rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0_2__1"


    // $ANTLR start "rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5029:1: rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl : ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5033:1: ( ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5034:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5034:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5035:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_2_0_2_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5036:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5036:2: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1_in_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl10066);
            rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_2_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl"


    // $ANTLR start "rule__RGBColor__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5050:1: rule__RGBColor__Group__0 : rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1 ;
    public final void rule__RGBColor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5054:1: ( rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5055:2: rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__0__Impl_in_rule__RGBColor__Group__010100);
            rule__RGBColor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__1_in_rule__RGBColor__Group__010103);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5062:1: rule__RGBColor__Group__0__Impl : ( 'rgb' ) ;
    public final void rule__RGBColor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5066:1: ( ( 'rgb' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5067:1: ( 'rgb' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5067:1: ( 'rgb' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5068:1: 'rgb'
            {
             before(grammarAccess.getRGBColorAccess().getRgbKeyword_0()); 
            match(input,47,FOLLOW_47_in_rule__RGBColor__Group__0__Impl10131); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5081:1: rule__RGBColor__Group__1 : rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2 ;
    public final void rule__RGBColor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5085:1: ( rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5086:2: rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__1__Impl_in_rule__RGBColor__Group__110162);
            rule__RGBColor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__2_in_rule__RGBColor__Group__110165);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5093:1: rule__RGBColor__Group__1__Impl : ( '(' ) ;
    public final void rule__RGBColor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5097:1: ( ( '(' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5098:1: ( '(' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5098:1: ( '(' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5099:1: '('
            {
             before(grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1()); 
            match(input,48,FOLLOW_48_in_rule__RGBColor__Group__1__Impl10193); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5112:1: rule__RGBColor__Group__2 : rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3 ;
    public final void rule__RGBColor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5116:1: ( rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5117:2: rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__2__Impl_in_rule__RGBColor__Group__210224);
            rule__RGBColor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__3_in_rule__RGBColor__Group__210227);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5124:1: rule__RGBColor__Group__2__Impl : ( ( rule__RGBColor__RAssignment_2 ) ) ;
    public final void rule__RGBColor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5128:1: ( ( ( rule__RGBColor__RAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5129:1: ( ( rule__RGBColor__RAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5129:1: ( ( rule__RGBColor__RAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5130:1: ( rule__RGBColor__RAssignment_2 )
            {
             before(grammarAccess.getRGBColorAccess().getRAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5131:1: ( rule__RGBColor__RAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5131:2: rule__RGBColor__RAssignment_2
            {
            pushFollow(FOLLOW_rule__RGBColor__RAssignment_2_in_rule__RGBColor__Group__2__Impl10254);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5141:1: rule__RGBColor__Group__3 : rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4 ;
    public final void rule__RGBColor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5145:1: ( rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5146:2: rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__3__Impl_in_rule__RGBColor__Group__310284);
            rule__RGBColor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__4_in_rule__RGBColor__Group__310287);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5153:1: rule__RGBColor__Group__3__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5157:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5158:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5158:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5159:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_3()); 
            match(input,37,FOLLOW_37_in_rule__RGBColor__Group__3__Impl10315); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5172:1: rule__RGBColor__Group__4 : rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5 ;
    public final void rule__RGBColor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5176:1: ( rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5177:2: rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__4__Impl_in_rule__RGBColor__Group__410346);
            rule__RGBColor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__5_in_rule__RGBColor__Group__410349);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5184:1: rule__RGBColor__Group__4__Impl : ( ( rule__RGBColor__GAssignment_4 ) ) ;
    public final void rule__RGBColor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5188:1: ( ( ( rule__RGBColor__GAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5189:1: ( ( rule__RGBColor__GAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5189:1: ( ( rule__RGBColor__GAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5190:1: ( rule__RGBColor__GAssignment_4 )
            {
             before(grammarAccess.getRGBColorAccess().getGAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5191:1: ( rule__RGBColor__GAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5191:2: rule__RGBColor__GAssignment_4
            {
            pushFollow(FOLLOW_rule__RGBColor__GAssignment_4_in_rule__RGBColor__Group__4__Impl10376);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5201:1: rule__RGBColor__Group__5 : rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6 ;
    public final void rule__RGBColor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5205:1: ( rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5206:2: rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__5__Impl_in_rule__RGBColor__Group__510406);
            rule__RGBColor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__6_in_rule__RGBColor__Group__510409);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5213:1: rule__RGBColor__Group__5__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5217:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5218:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5218:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5219:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_5()); 
            match(input,37,FOLLOW_37_in_rule__RGBColor__Group__5__Impl10437); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5232:1: rule__RGBColor__Group__6 : rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7 ;
    public final void rule__RGBColor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5236:1: ( rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5237:2: rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__6__Impl_in_rule__RGBColor__Group__610468);
            rule__RGBColor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__7_in_rule__RGBColor__Group__610471);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5244:1: rule__RGBColor__Group__6__Impl : ( ( rule__RGBColor__BAssignment_6 ) ) ;
    public final void rule__RGBColor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5248:1: ( ( ( rule__RGBColor__BAssignment_6 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5249:1: ( ( rule__RGBColor__BAssignment_6 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5249:1: ( ( rule__RGBColor__BAssignment_6 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5250:1: ( rule__RGBColor__BAssignment_6 )
            {
             before(grammarAccess.getRGBColorAccess().getBAssignment_6()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5251:1: ( rule__RGBColor__BAssignment_6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5251:2: rule__RGBColor__BAssignment_6
            {
            pushFollow(FOLLOW_rule__RGBColor__BAssignment_6_in_rule__RGBColor__Group__6__Impl10498);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5261:1: rule__RGBColor__Group__7 : rule__RGBColor__Group__7__Impl ;
    public final void rule__RGBColor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5265:1: ( rule__RGBColor__Group__7__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5266:2: rule__RGBColor__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__7__Impl_in_rule__RGBColor__Group__710528);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5272:1: rule__RGBColor__Group__7__Impl : ( ')' ) ;
    public final void rule__RGBColor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5276:1: ( ( ')' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5277:1: ( ')' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5277:1: ( ')' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5278:1: ')'
            {
             before(grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_7()); 
            match(input,49,FOLLOW_49_in_rule__RGBColor__Group__7__Impl10556); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5307:1: rule__Font__Group__0 : rule__Font__Group__0__Impl rule__Font__Group__1 ;
    public final void rule__Font__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5311:1: ( rule__Font__Group__0__Impl rule__Font__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5312:2: rule__Font__Group__0__Impl rule__Font__Group__1
            {
            pushFollow(FOLLOW_rule__Font__Group__0__Impl_in_rule__Font__Group__010603);
            rule__Font__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Font__Group__1_in_rule__Font__Group__010606);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5319:1: rule__Font__Group__0__Impl : ( ( rule__Font__NameAssignment_0 ) ) ;
    public final void rule__Font__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5323:1: ( ( ( rule__Font__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5324:1: ( ( rule__Font__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5324:1: ( ( rule__Font__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5325:1: ( rule__Font__NameAssignment_0 )
            {
             before(grammarAccess.getFontAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5326:1: ( rule__Font__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5326:2: rule__Font__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Font__NameAssignment_0_in_rule__Font__Group__0__Impl10633);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5336:1: rule__Font__Group__1 : rule__Font__Group__1__Impl rule__Font__Group__2 ;
    public final void rule__Font__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5340:1: ( rule__Font__Group__1__Impl rule__Font__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5341:2: rule__Font__Group__1__Impl rule__Font__Group__2
            {
            pushFollow(FOLLOW_rule__Font__Group__1__Impl_in_rule__Font__Group__110663);
            rule__Font__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Font__Group__2_in_rule__Font__Group__110666);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5348:1: rule__Font__Group__1__Impl : ( ( rule__Font__SizeAssignment_1 ) ) ;
    public final void rule__Font__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5352:1: ( ( ( rule__Font__SizeAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5353:1: ( ( rule__Font__SizeAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5353:1: ( ( rule__Font__SizeAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5354:1: ( rule__Font__SizeAssignment_1 )
            {
             before(grammarAccess.getFontAccess().getSizeAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5355:1: ( rule__Font__SizeAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5355:2: rule__Font__SizeAssignment_1
            {
            pushFollow(FOLLOW_rule__Font__SizeAssignment_1_in_rule__Font__Group__1__Impl10693);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5365:1: rule__Font__Group__2 : rule__Font__Group__2__Impl ;
    public final void rule__Font__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5369:1: ( rule__Font__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5370:2: rule__Font__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Font__Group__2__Impl_in_rule__Font__Group__210723);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5376:1: rule__Font__Group__2__Impl : ( ( rule__Font__AttributesAssignment_2 )* ) ;
    public final void rule__Font__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5380:1: ( ( ( rule__Font__AttributesAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5381:1: ( ( rule__Font__AttributesAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5381:1: ( ( rule__Font__AttributesAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5382:1: ( rule__Font__AttributesAssignment_2 )*
            {
             before(grammarAccess.getFontAccess().getAttributesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5383:1: ( rule__Font__AttributesAssignment_2 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=11 && LA28_0<=14)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5383:2: rule__Font__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Font__AttributesAssignment_2_in_rule__Font__Group__2__Impl10750);
            	    rule__Font__AttributesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5400:1: rule__Model__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5404:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5405:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5405:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5406:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Model__NameAssignment_010792); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5415:1: rule__Model__PartitionsAssignment_2 : ( rulePartition ) ;
    public final void rule__Model__PartitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5419:1: ( ( rulePartition ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5420:1: ( rulePartition )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5420:1: ( rulePartition )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5421:1: rulePartition
            {
             before(grammarAccess.getModelAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_rulePartition_in_rule__Model__PartitionsAssignment_210823);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5430:1: rule__Model__DamagersAssignment_3 : ( ruleDamager ) ;
    public final void rule__Model__DamagersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5434:1: ( ( ruleDamager ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5435:1: ( ruleDamager )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5435:1: ( ruleDamager )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5436:1: ruleDamager
            {
             before(grammarAccess.getModelAccess().getDamagersDamagerParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDamager_in_rule__Model__DamagersAssignment_310854);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5445:1: rule__Model__PartitionerAssignment_4 : ( rulePartitioner ) ;
    public final void rule__Model__PartitionerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5449:1: ( ( rulePartitioner ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5450:1: ( rulePartitioner )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5450:1: ( rulePartitioner )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5451:1: rulePartitioner
            {
             before(grammarAccess.getModelAccess().getPartitionerPartitionerParserRuleCall_4_0()); 
            pushFollow(FOLLOW_rulePartitioner_in_rule__Model__PartitionerAssignment_410885);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5460:1: rule__Model__ContentTypesAssignment_7 : ( RULE_STRING ) ;
    public final void rule__Model__ContentTypesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5464:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5465:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5465:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5466:1: RULE_STRING
            {
             before(grammarAccess.getModelAccess().getContentTypesSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Model__ContentTypesAssignment_710916); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5475:1: rule__Partition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Partition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5479:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5480:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5480:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5481:1: RULE_ID
            {
             before(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_110947); 
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


    // $ANTLR start "rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5490:1: rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5494:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5495:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5495:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5496:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionPartitionCrossReference_3_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5497:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5498:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionPartitionIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_310982); 
             after(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionPartitionIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionPartitionCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3"


    // $ANTLR start "rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5509:1: rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5513:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5514:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5514:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5515:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionPartitionCrossReference_5_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5516:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5517:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionPartitionIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_511021); 
             after(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionPartitionIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionPartitionCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5"


    // $ANTLR start "rule__JavaLikeParitioner__JavaDocParitionAssignment_7"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5528:1: rule__JavaLikeParitioner__JavaDocParitionAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__JavaDocParitionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5532:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5533:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5533:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5534:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionCrossReference_7_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5535:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5536:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__JavaDocParitionAssignment_711060); 
             after(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionIDTerminalRuleCall_7_0_1()); 

            }

             after(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__JavaDocParitionAssignment_7"


    // $ANTLR start "rule__JavaLikeParitioner__CharacterParitionAssignment_9"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5547:1: rule__JavaLikeParitioner__CharacterParitionAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__CharacterParitionAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5551:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5552:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5552:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5553:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionCrossReference_9_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5554:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5555:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__CharacterParitionAssignment_911099); 
             after(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionIDTerminalRuleCall_9_0_1()); 

            }

             after(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__CharacterParitionAssignment_9"


    // $ANTLR start "rule__JavaLikeParitioner__StringParitionAssignment_11"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5566:1: rule__JavaLikeParitioner__StringParitionAssignment_11 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__StringParitionAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5570:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5571:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5571:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5572:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionCrossReference_11_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5573:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5574:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionIDTerminalRuleCall_11_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__StringParitionAssignment_1111138); 
             after(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionIDTerminalRuleCall_11_0_1()); 

            }

             after(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionCrossReference_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaLikeParitioner__StringParitionAssignment_11"


    // $ANTLR start "rule__RulePartitioner__RulesAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5585:1: rule__RulePartitioner__RulesAssignment_2 : ( ruleParitionRule ) ;
    public final void rule__RulePartitioner__RulesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5589:1: ( ( ruleParitionRule ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5590:1: ( ruleParitionRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5590:1: ( ruleParitionRule )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5591:1: ruleParitionRule
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesParitionRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParitionRule_in_rule__RulePartitioner__RulesAssignment_211173);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5600:1: rule__JSParitioner__FileURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JSParitioner__FileURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5604:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5605:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5605:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5606:1: RULE_STRING
            {
             before(grammarAccess.getJSParitionerAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JSParitioner__FileURIAssignment_111204); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5615:1: rule__JSDamager__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__JSDamager__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5619:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5620:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5620:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5621:1: ( RULE_ID )
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5622:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5623:1: RULE_ID
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JSDamager__PartitionAssignment_111239); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5634:1: rule__JSDamager__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__JSDamager__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5638:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5639:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5639:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5640:1: RULE_STRING
            {
             before(grammarAccess.getJSDamagerAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JSDamager__FileURIAssignment_211274); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5649:1: rule__RuleDamager__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__RuleDamager__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5653:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5654:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5654:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5655:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5656:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5657:1: RULE_ID
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RuleDamager__PartitionAssignment_111309); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5668:1: rule__RuleDamager__TokensAssignment_3 : ( ruleScannerToken ) ;
    public final void rule__RuleDamager__TokensAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5672:1: ( ( ruleScannerToken ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5673:1: ( ruleScannerToken )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5673:1: ( ruleScannerToken )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5674:1: ruleScannerToken
            {
             before(grammarAccess.getRuleDamagerAccess().getTokensScannerTokenParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleScannerToken_in_rule__RuleDamager__TokensAssignment_311344);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5683:1: rule__RuleDamager__KeywordGroupsAssignment_4 : ( ruleKeywordGroup ) ;
    public final void rule__RuleDamager__KeywordGroupsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5687:1: ( ( ruleKeywordGroup ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5688:1: ( ruleKeywordGroup )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5688:1: ( ruleKeywordGroup )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5689:1: ruleKeywordGroup
            {
             before(grammarAccess.getRuleDamagerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_rule__RuleDamager__KeywordGroupsAssignment_411375);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5698:1: rule__RuleDamager__RulesAssignment_5 : ( ruleScannerRule ) ;
    public final void rule__RuleDamager__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5702:1: ( ( ruleScannerRule ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5703:1: ( ruleScannerRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5703:1: ( ruleScannerRule )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5704:1: ruleScannerRule
            {
             before(grammarAccess.getRuleDamagerAccess().getRulesScannerRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleScannerRule_in_rule__RuleDamager__RulesAssignment_511406);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5713:1: rule__ScannerToken__DefaultAssignment_0 : ( ( 'default' ) ) ;
    public final void rule__ScannerToken__DefaultAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5717:1: ( ( ( 'default' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5718:1: ( ( 'default' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5718:1: ( ( 'default' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5719:1: ( 'default' )
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5720:1: ( 'default' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5721:1: 'default'
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 
            match(input,50,FOLLOW_50_in_rule__ScannerToken__DefaultAssignment_011442); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5736:1: rule__ScannerToken__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ScannerToken__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5740:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5741:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5741:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5742:1: RULE_ID
            {
             before(grammarAccess.getScannerTokenAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerToken__NameAssignment_211481); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5751:1: rule__ScannerToken__FgColorAssignment_3_1_2 : ( ruleColor ) ;
    public final void rule__ScannerToken__FgColorAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5755:1: ( ( ruleColor ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5756:1: ( ruleColor )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5756:1: ( ruleColor )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5757:1: ruleColor
            {
             before(grammarAccess.getScannerTokenAccess().getFgColorColorParserRuleCall_3_1_2_0()); 
            pushFollow(FOLLOW_ruleColor_in_rule__ScannerToken__FgColorAssignment_3_1_211512);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5766:1: rule__ScannerToken__BgColorAssignment_3_2_2 : ( ruleColor ) ;
    public final void rule__ScannerToken__BgColorAssignment_3_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5770:1: ( ( ruleColor ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5771:1: ( ruleColor )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5771:1: ( ruleColor )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5772:1: ruleColor
            {
             before(grammarAccess.getScannerTokenAccess().getBgColorColorParserRuleCall_3_2_2_0()); 
            pushFollow(FOLLOW_ruleColor_in_rule__ScannerToken__BgColorAssignment_3_2_211543);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5781:1: rule__ScannerToken__FontAssignment_3_3_2 : ( ruleFont ) ;
    public final void rule__ScannerToken__FontAssignment_3_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5785:1: ( ( ruleFont ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5786:1: ( ruleFont )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5786:1: ( ruleFont )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5787:1: ruleFont
            {
             before(grammarAccess.getScannerTokenAccess().getFontFontParserRuleCall_3_3_2_0()); 
            pushFollow(FOLLOW_ruleFont_in_rule__ScannerToken__FontAssignment_3_3_211574);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5796:1: rule__KeywordGroup__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__KeywordGroup__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5800:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5801:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5801:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5802:1: ( RULE_ID )
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5803:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5804:1: RULE_ID
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeywordGroup__TokenAssignment_111609); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5815:1: rule__KeywordGroup__KeywordsAssignment_3 : ( ruleKeyword ) ;
    public final void rule__KeywordGroup__KeywordsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5819:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5820:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5820:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5821:1: ruleKeyword
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_311644);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5830:1: rule__KeywordGroup__KeywordsAssignment_4_1 : ( ruleKeyword ) ;
    public final void rule__KeywordGroup__KeywordsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5834:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5835:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5835:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5836:1: ruleKeyword
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_4_111675);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5845:1: rule__Keyword__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Keyword__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5849:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5850:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5850:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5851:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_011706); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5860:1: rule__Keyword__VersionAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Keyword__VersionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5864:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5865:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5865:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5866:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_111737); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5875:1: rule__ScannerSingleLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerSingleLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5879:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5880:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5880:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5881:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5882:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5883:1: RULE_ID
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerSingleLineRule__TokenAssignment_111772); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5894:1: rule__ScannerSingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5898:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5899:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5899:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5900:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__StartSeqAssignment_211807); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5909:1: rule__ScannerSingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5913:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5914:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5914:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5915:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EndSeqAssignment_411838); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5924:1: rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5928:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5929:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5929:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5930:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_211869); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5939:1: rule__PartitionSingleLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionSingleLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5943:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5944:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5944:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5945:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5946:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5947:1: RULE_ID
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionSingleLineRule__ParitionAssignment_111904); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5958:1: rule__PartitionSingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5962:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5963:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5963:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5964:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__StartSeqAssignment_211939); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5973:1: rule__PartitionSingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5977:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5978:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5978:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5979:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EndSeqAssignment_411970); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5988:1: rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5992:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5993:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5993:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5994:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_212001); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6003:1: rule__ScannerMultiLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerMultiLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6007:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6008:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6008:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6009:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6010:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6011:1: RULE_ID
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerMultiLineRule__TokenAssignment_112036); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6022:1: rule__ScannerMultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6026:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6027:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6027:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6028:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__StartSeqAssignment_212071); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6037:1: rule__ScannerMultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6041:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6042:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6042:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6043:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EndSeqAssignment_412102); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6052:1: rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6056:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6057:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6057:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6058:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_212133); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6067:1: rule__PartitionMultiLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionMultiLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6071:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6072:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6072:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6073:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6074:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6075:1: RULE_ID
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionMultiLineRule__ParitionAssignment_112168); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6086:1: rule__PartitionMultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6090:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6091:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6091:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6092:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__StartSeqAssignment_212203); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6101:1: rule__PartitionMultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6105:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6106:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6106:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6107:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EndSeqAssignment_412234); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6116:1: rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6120:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6121:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6121:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6122:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_212265); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6131:1: rule__ScannerCharacterRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerCharacterRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6135:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6136:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6136:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6137:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6138:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6139:1: RULE_ID
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerCharacterRule__TokenAssignment_112300); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6150:1: rule__ScannerCharacterRule__CharactersAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ScannerCharacterRule__CharactersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6154:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6155:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6155:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6156:1: RULE_STRING
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_312335); 
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


    // $ANTLR start "rule__ScannerCharacterRule__CharactersAssignment_4_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6165:1: rule__ScannerCharacterRule__CharactersAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__ScannerCharacterRule__CharactersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6169:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6170:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6170:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6171:1: RULE_STRING
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_4_112366); 
             after(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerCharacterRule__CharactersAssignment_4_1"


    // $ANTLR start "rule__ScannerJSRule__TokenAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6180:1: rule__ScannerJSRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerJSRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6184:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6185:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6185:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6186:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6187:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6188:1: RULE_ID
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerJSRule__TokenAssignment_112401); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6199:1: rule__ScannerJSRule__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerJSRule__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6203:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6204:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6204:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6205:1: RULE_STRING
            {
             before(grammarAccess.getScannerJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerJSRule__FileURIAssignment_212436); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6214:1: rule__PartitionJSRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionJSRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6218:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6219:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6219:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6220:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6221:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6222:1: RULE_ID
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionJSRule__TokenAssignment_112471); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6233:1: rule__PartitionJSRule__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionJSRule__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6237:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6238:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6238:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6239:1: RULE_STRING
            {
             before(grammarAccess.getPartitionJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionJSRule__FileURIAssignment_212506); 
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


    // $ANTLR start "rule__ScannerWhitespaceRule__TokenAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6248:1: rule__ScannerWhitespaceRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerWhitespaceRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6252:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6253:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6253:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6254:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6255:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6256:1: RULE_ID
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerWhitespaceRule__TokenAssignment_112541); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__TokenAssignment_1"


    // $ANTLR start "rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6267:1: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6271:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6272:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6272:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6273:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_112576); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1"


    // $ANTLR start "rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6282:1: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6286:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6287:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6287:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6288:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_112607); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1"


    // $ANTLR start "rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6297:1: rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 : ( ( 'javawhitespace' ) ) ;
    public final void rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6301:1: ( ( ( 'javawhitespace' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6302:1: ( ( 'javawhitespace' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6302:1: ( ( 'javawhitespace' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6303:1: ( 'javawhitespace' )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_2_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6304:1: ( 'javawhitespace' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6305:1: 'javawhitespace'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_2_1_0()); 
            match(input,51,FOLLOW_51_in_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_112643); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_2_1_0()); 

            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1"


    // $ANTLR start "rule__ScannerWhitespaceRule__FileURIAssignment_2_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6320:1: rule__ScannerWhitespaceRule__FileURIAssignment_2_2 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__FileURIAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6324:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6325:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6325:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6326:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_2_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__FileURIAssignment_2_212682); 
             after(grammarAccess.getScannerWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ScannerWhitespaceRule__FileURIAssignment_2_2"


    // $ANTLR start "rule__RGBColor__RAssignment_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6335:1: rule__RGBColor__RAssignment_2 : ( RULE_INT ) ;
    public final void rule__RGBColor__RAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6339:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6340:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6340:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6341:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getRINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__RAssignment_212713); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6350:1: rule__RGBColor__GAssignment_4 : ( RULE_INT ) ;
    public final void rule__RGBColor__GAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6354:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6355:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6355:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6356:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getGINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__GAssignment_412744); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6365:1: rule__RGBColor__BAssignment_6 : ( RULE_INT ) ;
    public final void rule__RGBColor__BAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6369:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6370:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6370:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6371:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getBINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__BAssignment_612775); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6380:1: rule__Font__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Font__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6384:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6385:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6385:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6386:1: RULE_ID
            {
             before(grammarAccess.getFontAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Font__NameAssignment_012806); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6395:1: rule__Font__SizeAssignment_1 : ( RULE_INT ) ;
    public final void rule__Font__SizeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6399:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6400:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6400:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6401:1: RULE_INT
            {
             before(grammarAccess.getFontAccess().getSizeINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Font__SizeAssignment_112837); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6410:1: rule__Font__AttributesAssignment_2 : ( ruleFontType ) ;
    public final void rule__Font__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6414:1: ( ( ruleFontType ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6415:1: ( ruleFontType )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6415:1: ( ruleFontType )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6416:1: ruleFontType
            {
             before(grammarAccess.getFontAccess().getAttributesFontTypeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleFontType_in_rule__Font__AttributesAssignment_212868);
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
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__0_in_ruleScannerWhitespaceRule1354 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0_in_rule__ScannerWhitespaceRule__Alternatives_21886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1_in_rule__ScannerWhitespaceRule__Alternatives_21904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__FileURIAssignment_2_2_in_rule__ScannerWhitespaceRule__Alternatives_21922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__FontType__Alternatives1956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__FontType__Alternatives1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__FontType__Alternatives1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__FontType__Alternatives2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02052 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NameAssignment_0_in_rule__Model__Group__0__Impl2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12112 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Model__Group__1__Impl2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22174 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__22177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2206 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2218 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__32251 = new BitSet(new long[]{0x0000000006080000L});
    public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__32254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2283 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2295 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__42328 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Model__Group__5_in_rule__Model__Group__42331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionerAssignment_4_in_rule__Model__Group__4__Impl2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__52388 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Model__Group__6_in_rule__Model__Group__52391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Model__Group__5__Impl2419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__6__Impl_in_rule__Model__Group__62450 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Model__Group__7_in_rule__Model__Group__62453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Model__Group__6__Impl2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__7__Impl_in_rule__Model__Group__72512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2541 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2553 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__02602 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__02605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Partition__Group__0__Impl2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__12664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl2691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__0__Impl_in_rule__JavaLikeParitioner__Group__02725 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__1_in_rule__JavaLikeParitioner__Group__02728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__JavaLikeParitioner__Group__0__Impl2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__1__Impl_in_rule__JavaLikeParitioner__Group__12787 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__2_in_rule__JavaLikeParitioner__Group__12790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JavaLikeParitioner__Group__1__Impl2818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__2__Impl_in_rule__JavaLikeParitioner__Group__22849 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__3_in_rule__JavaLikeParitioner__Group__22852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__JavaLikeParitioner__Group__2__Impl2880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__3__Impl_in_rule__JavaLikeParitioner__Group__32911 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__4_in_rule__JavaLikeParitioner__Group__32914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3_in_rule__JavaLikeParitioner__Group__3__Impl2941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__4__Impl_in_rule__JavaLikeParitioner__Group__42971 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__5_in_rule__JavaLikeParitioner__Group__42974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__JavaLikeParitioner__Group__4__Impl3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__5__Impl_in_rule__JavaLikeParitioner__Group__53033 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__6_in_rule__JavaLikeParitioner__Group__53036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5_in_rule__JavaLikeParitioner__Group__5__Impl3063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__6__Impl_in_rule__JavaLikeParitioner__Group__63093 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__7_in_rule__JavaLikeParitioner__Group__63096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__JavaLikeParitioner__Group__6__Impl3124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__7__Impl_in_rule__JavaLikeParitioner__Group__73155 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__8_in_rule__JavaLikeParitioner__Group__73158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__JavaDocParitionAssignment_7_in_rule__JavaLikeParitioner__Group__7__Impl3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__8__Impl_in_rule__JavaLikeParitioner__Group__83215 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__9_in_rule__JavaLikeParitioner__Group__83218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__JavaLikeParitioner__Group__8__Impl3246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__9__Impl_in_rule__JavaLikeParitioner__Group__93277 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__10_in_rule__JavaLikeParitioner__Group__93280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__CharacterParitionAssignment_9_in_rule__JavaLikeParitioner__Group__9__Impl3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__10__Impl_in_rule__JavaLikeParitioner__Group__103337 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__11_in_rule__JavaLikeParitioner__Group__103340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__JavaLikeParitioner__Group__10__Impl3368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__11__Impl_in_rule__JavaLikeParitioner__Group__113399 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__12_in_rule__JavaLikeParitioner__Group__113402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__StringParitionAssignment_11_in_rule__JavaLikeParitioner__Group__11__Impl3429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__12__Impl_in_rule__JavaLikeParitioner__Group__123459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JavaLikeParitioner__Group__12__Impl3487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__0__Impl_in_rule__RulePartitioner__Group__03544 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__1_in_rule__RulePartitioner__Group__03547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__RulePartitioner__Group__0__Impl3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__1__Impl_in_rule__RulePartitioner__Group__13606 = new BitSet(new long[]{0x0000288000000000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__2_in_rule__RulePartitioner__Group__13609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__RulePartitioner__Group__1__Impl3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__2__Impl_in_rule__RulePartitioner__Group__23668 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__3_in_rule__RulePartitioner__Group__23671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3700 = new BitSet(new long[]{0x0000288000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3712 = new BitSet(new long[]{0x0000288000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__3__Impl_in_rule__RulePartitioner__Group__33745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__RulePartitioner__Group__3__Impl3773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__0__Impl_in_rule__JSParitioner__Group__03812 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__1_in_rule__JSParitioner__Group__03815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__JSParitioner__Group__0__Impl3843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__1__Impl_in_rule__JSParitioner__Group__13874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__FileURIAssignment_1_in_rule__JSParitioner__Group__1__Impl3901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__0__Impl_in_rule__JSDamager__Group__03935 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__1_in_rule__JSDamager__Group__03938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__JSDamager__Group__0__Impl3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__1__Impl_in_rule__JSDamager__Group__13997 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__2_in_rule__JSDamager__Group__14000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__PartitionAssignment_1_in_rule__JSDamager__Group__1__Impl4027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__2__Impl_in_rule__JSDamager__Group__24057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__FileURIAssignment_2_in_rule__JSDamager__Group__2__Impl4084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__0__Impl_in_rule__RuleDamager__Group__04120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__1_in_rule__RuleDamager__Group__04123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__RuleDamager__Group__0__Impl4151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__1__Impl_in_rule__RuleDamager__Group__14182 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__2_in_rule__RuleDamager__Group__14185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__PartitionAssignment_1_in_rule__RuleDamager__Group__1__Impl4212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__2__Impl_in_rule__RuleDamager__Group__24242 = new BitSet(new long[]{0x0004788420010000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__3_in_rule__RuleDamager__Group__24245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__RuleDamager__Group__2__Impl4273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__3__Impl_in_rule__RuleDamager__Group__34304 = new BitSet(new long[]{0x0004788420010000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__4_in_rule__RuleDamager__Group__34307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__TokensAssignment_3_in_rule__RuleDamager__Group__3__Impl4334 = new BitSet(new long[]{0x0004000020000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__4__Impl_in_rule__RuleDamager__Group__44365 = new BitSet(new long[]{0x0004788420010000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__5_in_rule__RuleDamager__Group__44368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__KeywordGroupsAssignment_4_in_rule__RuleDamager__Group__4__Impl4395 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__5__Impl_in_rule__RuleDamager__Group__54426 = new BitSet(new long[]{0x0004788420010000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__6_in_rule__RuleDamager__Group__54429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__RulesAssignment_5_in_rule__RuleDamager__Group__5__Impl4456 = new BitSet(new long[]{0x0000788000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__6__Impl_in_rule__RuleDamager__Group__64487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__RuleDamager__Group__6__Impl4515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__0__Impl_in_rule__ScannerToken__Group__04560 = new BitSet(new long[]{0x0004000020000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__1_in_rule__ScannerToken__Group__04563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__DefaultAssignment_0_in_rule__ScannerToken__Group__0__Impl4590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__1__Impl_in_rule__ScannerToken__Group__14621 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__2_in_rule__ScannerToken__Group__14624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ScannerToken__Group__1__Impl4652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__2__Impl_in_rule__ScannerToken__Group__24683 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__3_in_rule__ScannerToken__Group__24686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__NameAssignment_2_in_rule__ScannerToken__Group__2__Impl4713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__3__Impl_in_rule__ScannerToken__Group__34743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__0_in_rule__ScannerToken__Group__3__Impl4770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__0__Impl_in_rule__ScannerToken__Group_3__04809 = new BitSet(new long[]{0x0000000340010000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__1_in_rule__ScannerToken__Group_3__04812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ScannerToken__Group_3__0__Impl4840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__1__Impl_in_rule__ScannerToken__Group_3__14871 = new BitSet(new long[]{0x0000000340010000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__2_in_rule__ScannerToken__Group_3__14874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__0_in_rule__ScannerToken__Group_3__1__Impl4901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__2__Impl_in_rule__ScannerToken__Group_3__24932 = new BitSet(new long[]{0x0000000340010000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__3_in_rule__ScannerToken__Group_3__24935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__0_in_rule__ScannerToken__Group_3__2__Impl4962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__3__Impl_in_rule__ScannerToken__Group_3__34993 = new BitSet(new long[]{0x0000000340010000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__4_in_rule__ScannerToken__Group_3__34996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__0_in_rule__ScannerToken__Group_3__3__Impl5023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3__4__Impl_in_rule__ScannerToken__Group_3__45054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ScannerToken__Group_3__4__Impl5082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__0__Impl_in_rule__ScannerToken__Group_3_1__05123 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__1_in_rule__ScannerToken__Group_3_1__05126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ScannerToken__Group_3_1__0__Impl5154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__1__Impl_in_rule__ScannerToken__Group_3_1__15185 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__2_in_rule__ScannerToken__Group_3_1__15188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ScannerToken__Group_3_1__1__Impl5216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_1__2__Impl_in_rule__ScannerToken__Group_3_1__25247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__FgColorAssignment_3_1_2_in_rule__ScannerToken__Group_3_1__2__Impl5274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__0__Impl_in_rule__ScannerToken__Group_3_2__05310 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__1_in_rule__ScannerToken__Group_3_2__05313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ScannerToken__Group_3_2__0__Impl5341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__1__Impl_in_rule__ScannerToken__Group_3_2__15372 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__2_in_rule__ScannerToken__Group_3_2__15375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ScannerToken__Group_3_2__1__Impl5403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_2__2__Impl_in_rule__ScannerToken__Group_3_2__25434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__BgColorAssignment_3_2_2_in_rule__ScannerToken__Group_3_2__2__Impl5461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__0__Impl_in_rule__ScannerToken__Group_3_3__05497 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__1_in_rule__ScannerToken__Group_3_3__05500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ScannerToken__Group_3_3__0__Impl5528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__1__Impl_in_rule__ScannerToken__Group_3_3__15559 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__2_in_rule__ScannerToken__Group_3_3__15562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ScannerToken__Group_3_3__1__Impl5590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group_3_3__2__Impl_in_rule__ScannerToken__Group_3_3__25621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__FontAssignment_3_3_2_in_rule__ScannerToken__Group_3_3__2__Impl5648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__0__Impl_in_rule__KeywordGroup__Group__05684 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__1_in_rule__KeywordGroup__Group__05687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__KeywordGroup__Group__0__Impl5715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__1__Impl_in_rule__KeywordGroup__Group__15746 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__2_in_rule__KeywordGroup__Group__15749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__TokenAssignment_1_in_rule__KeywordGroup__Group__1__Impl5776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__2__Impl_in_rule__KeywordGroup__Group__25806 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__3_in_rule__KeywordGroup__Group__25809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__KeywordGroup__Group__2__Impl5837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__3__Impl_in_rule__KeywordGroup__Group__35868 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__4_in_rule__KeywordGroup__Group__35871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__KeywordsAssignment_3_in_rule__KeywordGroup__Group__3__Impl5898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__4__Impl_in_rule__KeywordGroup__Group__45928 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__5_in_rule__KeywordGroup__Group__45931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__0_in_rule__KeywordGroup__Group__4__Impl5958 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__5__Impl_in_rule__KeywordGroup__Group__55989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__KeywordGroup__Group__5__Impl6017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__0__Impl_in_rule__KeywordGroup__Group_4__06060 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__1_in_rule__KeywordGroup__Group_4__06063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__KeywordGroup__Group_4__0__Impl6091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__1__Impl_in_rule__KeywordGroup__Group_4__16122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__KeywordsAssignment_4_1_in_rule__KeywordGroup__Group_4__1__Impl6149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__06183 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__06186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl6213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__16243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl6270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__06305 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__06308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Keyword__Group_1__0__Impl6336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__16367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl6394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__0__Impl_in_rule__ScannerSingleLineRule__Group__06428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__1_in_rule__ScannerSingleLineRule__Group__06431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ScannerSingleLineRule__Group__0__Impl6459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__1__Impl_in_rule__ScannerSingleLineRule__Group__16490 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__2_in_rule__ScannerSingleLineRule__Group__16493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__TokenAssignment_1_in_rule__ScannerSingleLineRule__Group__1__Impl6520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__2__Impl_in_rule__ScannerSingleLineRule__Group__26550 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__3_in_rule__ScannerSingleLineRule__Group__26553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__StartSeqAssignment_2_in_rule__ScannerSingleLineRule__Group__2__Impl6580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__3__Impl_in_rule__ScannerSingleLineRule__Group__36610 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__4_in_rule__ScannerSingleLineRule__Group__36613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ScannerSingleLineRule__Group__3__Impl6641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__4__Impl_in_rule__ScannerSingleLineRule__Group__46672 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__5_in_rule__ScannerSingleLineRule__Group__46675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__EndSeqAssignment_4_in_rule__ScannerSingleLineRule__Group__4__Impl6702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__5__Impl_in_rule__ScannerSingleLineRule__Group__56732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__0_in_rule__ScannerSingleLineRule__Group__5__Impl6759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__0__Impl_in_rule__ScannerSingleLineRule__Group_5__06802 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__1_in_rule__ScannerSingleLineRule__Group_5__06805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ScannerSingleLineRule__Group_5__0__Impl6833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__1__Impl_in_rule__ScannerSingleLineRule__Group_5__16864 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__2_in_rule__ScannerSingleLineRule__Group_5__16867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ScannerSingleLineRule__Group_5__1__Impl6895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__2__Impl_in_rule__ScannerSingleLineRule__Group_5__26926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerSingleLineRule__Group_5__2__Impl6953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__0__Impl_in_rule__PartitionSingleLineRule__Group__06989 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__1_in_rule__PartitionSingleLineRule__Group__06992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__PartitionSingleLineRule__Group__0__Impl7020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__1__Impl_in_rule__PartitionSingleLineRule__Group__17051 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__2_in_rule__PartitionSingleLineRule__Group__17054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__ParitionAssignment_1_in_rule__PartitionSingleLineRule__Group__1__Impl7081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__2__Impl_in_rule__PartitionSingleLineRule__Group__27111 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__3_in_rule__PartitionSingleLineRule__Group__27114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__StartSeqAssignment_2_in_rule__PartitionSingleLineRule__Group__2__Impl7141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__3__Impl_in_rule__PartitionSingleLineRule__Group__37171 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__4_in_rule__PartitionSingleLineRule__Group__37174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__PartitionSingleLineRule__Group__3__Impl7202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__4__Impl_in_rule__PartitionSingleLineRule__Group__47233 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__5_in_rule__PartitionSingleLineRule__Group__47236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__EndSeqAssignment_4_in_rule__PartitionSingleLineRule__Group__4__Impl7263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__5__Impl_in_rule__PartitionSingleLineRule__Group__57293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__0_in_rule__PartitionSingleLineRule__Group__5__Impl7320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__0__Impl_in_rule__PartitionSingleLineRule__Group_5__07363 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__1_in_rule__PartitionSingleLineRule__Group_5__07366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__PartitionSingleLineRule__Group_5__0__Impl7394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__1__Impl_in_rule__PartitionSingleLineRule__Group_5__17425 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__2_in_rule__PartitionSingleLineRule__Group_5__17428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__PartitionSingleLineRule__Group_5__1__Impl7456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__2__Impl_in_rule__PartitionSingleLineRule__Group_5__27487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionSingleLineRule__Group_5__2__Impl7514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__0__Impl_in_rule__ScannerMultiLineRule__Group__07550 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__1_in_rule__ScannerMultiLineRule__Group__07553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ScannerMultiLineRule__Group__0__Impl7581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__1__Impl_in_rule__ScannerMultiLineRule__Group__17612 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__2_in_rule__ScannerMultiLineRule__Group__17615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__TokenAssignment_1_in_rule__ScannerMultiLineRule__Group__1__Impl7642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__2__Impl_in_rule__ScannerMultiLineRule__Group__27672 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__3_in_rule__ScannerMultiLineRule__Group__27675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__StartSeqAssignment_2_in_rule__ScannerMultiLineRule__Group__2__Impl7702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__3__Impl_in_rule__ScannerMultiLineRule__Group__37732 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__4_in_rule__ScannerMultiLineRule__Group__37735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ScannerMultiLineRule__Group__3__Impl7763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__4__Impl_in_rule__ScannerMultiLineRule__Group__47794 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__5_in_rule__ScannerMultiLineRule__Group__47797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__EndSeqAssignment_4_in_rule__ScannerMultiLineRule__Group__4__Impl7824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__5__Impl_in_rule__ScannerMultiLineRule__Group__57854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__0_in_rule__ScannerMultiLineRule__Group__5__Impl7881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__0__Impl_in_rule__ScannerMultiLineRule__Group_5__07924 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__1_in_rule__ScannerMultiLineRule__Group_5__07927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ScannerMultiLineRule__Group_5__0__Impl7955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__1__Impl_in_rule__ScannerMultiLineRule__Group_5__17986 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__2_in_rule__ScannerMultiLineRule__Group_5__17989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ScannerMultiLineRule__Group_5__1__Impl8017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__2__Impl_in_rule__ScannerMultiLineRule__Group_5__28048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerMultiLineRule__Group_5__2__Impl8075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__0__Impl_in_rule__PartitionMultiLineRule__Group__08111 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__1_in_rule__PartitionMultiLineRule__Group__08114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__PartitionMultiLineRule__Group__0__Impl8142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__1__Impl_in_rule__PartitionMultiLineRule__Group__18173 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__2_in_rule__PartitionMultiLineRule__Group__18176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__ParitionAssignment_1_in_rule__PartitionMultiLineRule__Group__1__Impl8203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__2__Impl_in_rule__PartitionMultiLineRule__Group__28233 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__3_in_rule__PartitionMultiLineRule__Group__28236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__StartSeqAssignment_2_in_rule__PartitionMultiLineRule__Group__2__Impl8263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__3__Impl_in_rule__PartitionMultiLineRule__Group__38293 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__4_in_rule__PartitionMultiLineRule__Group__38296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__PartitionMultiLineRule__Group__3__Impl8324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__4__Impl_in_rule__PartitionMultiLineRule__Group__48355 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__5_in_rule__PartitionMultiLineRule__Group__48358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__EndSeqAssignment_4_in_rule__PartitionMultiLineRule__Group__4__Impl8385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__5__Impl_in_rule__PartitionMultiLineRule__Group__58415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__0_in_rule__PartitionMultiLineRule__Group__5__Impl8442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__0__Impl_in_rule__PartitionMultiLineRule__Group_5__08485 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__1_in_rule__PartitionMultiLineRule__Group_5__08488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__PartitionMultiLineRule__Group_5__0__Impl8516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__1__Impl_in_rule__PartitionMultiLineRule__Group_5__18547 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__2_in_rule__PartitionMultiLineRule__Group_5__18550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__PartitionMultiLineRule__Group_5__1__Impl8578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__2__Impl_in_rule__PartitionMultiLineRule__Group_5__28609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionMultiLineRule__Group_5__2__Impl8636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__0__Impl_in_rule__ScannerCharacterRule__Group__08672 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__1_in_rule__ScannerCharacterRule__Group__08675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ScannerCharacterRule__Group__0__Impl8703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__1__Impl_in_rule__ScannerCharacterRule__Group__18734 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__2_in_rule__ScannerCharacterRule__Group__18737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__TokenAssignment_1_in_rule__ScannerCharacterRule__Group__1__Impl8764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__2__Impl_in_rule__ScannerCharacterRule__Group__28794 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__3_in_rule__ScannerCharacterRule__Group__28797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ScannerCharacterRule__Group__2__Impl8825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__3__Impl_in_rule__ScannerCharacterRule__Group__38856 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__4_in_rule__ScannerCharacterRule__Group__38859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_3_in_rule__ScannerCharacterRule__Group__3__Impl8886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__4__Impl_in_rule__ScannerCharacterRule__Group__48916 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__5_in_rule__ScannerCharacterRule__Group__48919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__0_in_rule__ScannerCharacterRule__Group__4__Impl8946 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__5__Impl_in_rule__ScannerCharacterRule__Group__58977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ScannerCharacterRule__Group__5__Impl9005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__0__Impl_in_rule__ScannerCharacterRule__Group_4__09048 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__1_in_rule__ScannerCharacterRule__Group_4__09051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ScannerCharacterRule__Group_4__0__Impl9079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__1__Impl_in_rule__ScannerCharacterRule__Group_4__19110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_4_1_in_rule__ScannerCharacterRule__Group_4__1__Impl9137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__0__Impl_in_rule__ScannerJSRule__Group__09171 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__1_in_rule__ScannerJSRule__Group__09174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ScannerJSRule__Group__0__Impl9202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__1__Impl_in_rule__ScannerJSRule__Group__19233 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__2_in_rule__ScannerJSRule__Group__19236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__TokenAssignment_1_in_rule__ScannerJSRule__Group__1__Impl9263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__2__Impl_in_rule__ScannerJSRule__Group__29293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__FileURIAssignment_2_in_rule__ScannerJSRule__Group__2__Impl9320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__0__Impl_in_rule__PartitionJSRule__Group__09356 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__1_in_rule__PartitionJSRule__Group__09359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__PartitionJSRule__Group__0__Impl9387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__1__Impl_in_rule__PartitionJSRule__Group__19418 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__2_in_rule__PartitionJSRule__Group__19421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__TokenAssignment_1_in_rule__PartitionJSRule__Group__1__Impl9448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__2__Impl_in_rule__PartitionJSRule__Group__29478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__FileURIAssignment_2_in_rule__PartitionJSRule__Group__2__Impl9505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__0__Impl_in_rule__ScannerWhitespaceRule__Group__09541 = new BitSet(new long[]{0x0008000800000030L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__1_in_rule__ScannerWhitespaceRule__Group__09544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ScannerWhitespaceRule__Group__0__Impl9572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__1__Impl_in_rule__ScannerWhitespaceRule__Group__19603 = new BitSet(new long[]{0x0008000800000030L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__2_in_rule__ScannerWhitespaceRule__Group__19606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__TokenAssignment_1_in_rule__ScannerWhitespaceRule__Group__1__Impl9633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__2__Impl_in_rule__ScannerWhitespaceRule__Group__29664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Alternatives_2_in_rule__ScannerWhitespaceRule__Group__2__Impl9691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__09727 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1_in_rule__ScannerWhitespaceRule__Group_2_0__09730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ScannerWhitespaceRule__Group_2_0__0__Impl9758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__19789 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2_in_rule__ScannerWhitespaceRule__Group_2_0__19792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1_in_rule__ScannerWhitespaceRule__Group_2_0__1__Impl9819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__29849 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3_in_rule__ScannerWhitespaceRule__Group_2_0__29852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0_in_rule__ScannerWhitespaceRule__Group_2_0__2__Impl9879 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__39910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ScannerWhitespaceRule__Group_2_0__3__Impl9938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__09977 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1_in_rule__ScannerWhitespaceRule__Group_2_0_2__09980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl10008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__110039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1_in_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl10066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__0__Impl_in_rule__RGBColor__Group__010100 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__1_in_rule__RGBColor__Group__010103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__RGBColor__Group__0__Impl10131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__1__Impl_in_rule__RGBColor__Group__110162 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__2_in_rule__RGBColor__Group__110165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__RGBColor__Group__1__Impl10193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__2__Impl_in_rule__RGBColor__Group__210224 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__3_in_rule__RGBColor__Group__210227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__RAssignment_2_in_rule__RGBColor__Group__2__Impl10254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__3__Impl_in_rule__RGBColor__Group__310284 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__4_in_rule__RGBColor__Group__310287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__RGBColor__Group__3__Impl10315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__4__Impl_in_rule__RGBColor__Group__410346 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__5_in_rule__RGBColor__Group__410349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__GAssignment_4_in_rule__RGBColor__Group__4__Impl10376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__5__Impl_in_rule__RGBColor__Group__510406 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__6_in_rule__RGBColor__Group__510409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__RGBColor__Group__5__Impl10437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__6__Impl_in_rule__RGBColor__Group__610468 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__7_in_rule__RGBColor__Group__610471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__BAssignment_6_in_rule__RGBColor__Group__6__Impl10498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__7__Impl_in_rule__RGBColor__Group__710528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__RGBColor__Group__7__Impl10556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__0__Impl_in_rule__Font__Group__010603 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Font__Group__1_in_rule__Font__Group__010606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__NameAssignment_0_in_rule__Font__Group__0__Impl10633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__1__Impl_in_rule__Font__Group__110663 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__Font__Group__2_in_rule__Font__Group__110666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__SizeAssignment_1_in_rule__Font__Group__1__Impl10693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__Group__2__Impl_in_rule__Font__Group__210723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Font__AttributesAssignment_2_in_rule__Font__Group__2__Impl10750 = new BitSet(new long[]{0x0000000000007802L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_010792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_rule__Model__PartitionsAssignment_210823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDamager_in_rule__Model__DamagersAssignment_310854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_rule__Model__PartitionerAssignment_410885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Model__ContentTypesAssignment_710916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_110947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_310982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_511021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__JavaDocParitionAssignment_711060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__CharacterParitionAssignment_911099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__StringParitionAssignment_1111138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_rule__RulePartitioner__RulesAssignment_211173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JSParitioner__FileURIAssignment_111204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JSDamager__PartitionAssignment_111239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JSDamager__FileURIAssignment_211274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RuleDamager__PartitionAssignment_111309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_rule__RuleDamager__TokensAssignment_311344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_rule__RuleDamager__KeywordGroupsAssignment_411375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_rule__RuleDamager__RulesAssignment_511406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ScannerToken__DefaultAssignment_011442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerToken__NameAssignment_211481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__ScannerToken__FgColorAssignment_3_1_211512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__ScannerToken__BgColorAssignment_3_2_211543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFont_in_rule__ScannerToken__FontAssignment_3_3_211574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeywordGroup__TokenAssignment_111609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_311644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_4_111675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_011706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_111737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerSingleLineRule__TokenAssignment_111772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__StartSeqAssignment_211807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EndSeqAssignment_411838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_211869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionSingleLineRule__ParitionAssignment_111904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__StartSeqAssignment_211939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EndSeqAssignment_411970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_212001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerMultiLineRule__TokenAssignment_112036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__StartSeqAssignment_212071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EndSeqAssignment_412102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_212133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionMultiLineRule__ParitionAssignment_112168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__StartSeqAssignment_212203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EndSeqAssignment_412234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_212265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerCharacterRule__TokenAssignment_112300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_312335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_4_112366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerJSRule__TokenAssignment_112401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerJSRule__FileURIAssignment_212436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionJSRule__TokenAssignment_112471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionJSRule__FileURIAssignment_212506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerWhitespaceRule__TokenAssignment_112541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_112576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_112607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_112643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__FileURIAssignment_2_212682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__RAssignment_212713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__GAssignment_412744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__BAssignment_612775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Font__NameAssignment_012806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Font__SizeAssignment_112837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFontType_in_rule__Font__AttributesAssignment_212868 = new BitSet(new long[]{0x0000000000000002L});

}