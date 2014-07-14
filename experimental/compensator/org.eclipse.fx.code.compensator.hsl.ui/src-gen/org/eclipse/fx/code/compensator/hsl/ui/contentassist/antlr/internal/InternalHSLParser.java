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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'bold'", "'italic'", "'underline'", "'strike-through'", "'{'", "'}'", "'for'", "'partition'", "'java-like-partitioner'", "'singlelinedoc'", "'multilinedoc'", "'javadoc'", "'char'", "'string'", "'rule-partitioner'", "'js-partitioner'", "'js-damager'", "'rule-damager'", "'token'", "'keywords'", "'['", "']'", "','", "'since'", "'single-line'", "'=>'", "'escaped'", "'by'", "'multi-line'", "'character-rule'", "'javascript-rule'", "'whitespace-rule'", "'rgb'", "'('", "')'", "'default'", "'javawhitespace'"
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


    // $ANTLR start "entryRuleRGBColor"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:678:1: entryRuleRGBColor : ruleRGBColor EOF ;
    public final void entryRuleRGBColor() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:679:1: ( ruleRGBColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:680:1: ruleRGBColor EOF
            {
             before(grammarAccess.getRGBColorRule()); 
            pushFollow(FOLLOW_ruleRGBColor_in_entryRuleRGBColor1383);
            ruleRGBColor();

            state._fsp--;

             after(grammarAccess.getRGBColorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGBColor1390); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:687:1: ruleRGBColor : ( ( rule__RGBColor__Group__0 ) ) ;
    public final void ruleRGBColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:691:2: ( ( ( rule__RGBColor__Group__0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:692:1: ( ( rule__RGBColor__Group__0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:692:1: ( ( rule__RGBColor__Group__0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:693:1: ( rule__RGBColor__Group__0 )
            {
             before(grammarAccess.getRGBColorAccess().getGroup()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:694:1: ( rule__RGBColor__Group__0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:694:2: rule__RGBColor__Group__0
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__0_in_ruleRGBColor1416);
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


    // $ANTLR start "ruleFontType"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:709:1: ruleFontType : ( ( rule__FontType__Alternatives ) ) ;
    public final void ruleFontType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:713:1: ( ( ( rule__FontType__Alternatives ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:714:1: ( ( rule__FontType__Alternatives ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:714:1: ( ( rule__FontType__Alternatives ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:715:1: ( rule__FontType__Alternatives )
            {
             before(grammarAccess.getFontTypeAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:716:1: ( rule__FontType__Alternatives )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:716:2: rule__FontType__Alternatives
            {
            pushFollow(FOLLOW_rule__FontType__Alternatives_in_ruleFontType1455);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:727:1: rule__Partitioner__Alternatives : ( ( ruleRulePartitioner ) | ( ruleJavaLikeParitioner ) | ( ruleJSParitioner ) );
    public final void rule__Partitioner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:731:1: ( ( ruleRulePartitioner ) | ( ruleJavaLikeParitioner ) | ( ruleJSParitioner ) )
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
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:732:1: ( ruleRulePartitioner )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:732:1: ( ruleRulePartitioner )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:733:1: ruleRulePartitioner
                    {
                     before(grammarAccess.getPartitionerAccess().getRulePartitionerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRulePartitioner_in_rule__Partitioner__Alternatives1490);
                    ruleRulePartitioner();

                    state._fsp--;

                     after(grammarAccess.getPartitionerAccess().getRulePartitionerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:738:6: ( ruleJavaLikeParitioner )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:738:6: ( ruleJavaLikeParitioner )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:739:1: ruleJavaLikeParitioner
                    {
                     before(grammarAccess.getPartitionerAccess().getJavaLikeParitionerParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleJavaLikeParitioner_in_rule__Partitioner__Alternatives1507);
                    ruleJavaLikeParitioner();

                    state._fsp--;

                     after(grammarAccess.getPartitionerAccess().getJavaLikeParitionerParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:744:6: ( ruleJSParitioner )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:744:6: ( ruleJSParitioner )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:745:1: ruleJSParitioner
                    {
                     before(grammarAccess.getPartitionerAccess().getJSParitionerParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleJSParitioner_in_rule__Partitioner__Alternatives1524);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:755:1: rule__Damager__Alternatives : ( ( ruleRuleDamager ) | ( ruleJSDamager ) );
    public final void rule__Damager__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:759:1: ( ( ruleRuleDamager ) | ( ruleJSDamager ) )
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
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:760:1: ( ruleRuleDamager )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:760:1: ( ruleRuleDamager )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:761:1: ruleRuleDamager
                    {
                     before(grammarAccess.getDamagerAccess().getRuleDamagerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRuleDamager_in_rule__Damager__Alternatives1556);
                    ruleRuleDamager();

                    state._fsp--;

                     after(grammarAccess.getDamagerAccess().getRuleDamagerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:766:6: ( ruleJSDamager )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:766:6: ( ruleJSDamager )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:767:1: ruleJSDamager
                    {
                     before(grammarAccess.getDamagerAccess().getJSDamagerParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleJSDamager_in_rule__Damager__Alternatives1573);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:777:1: rule__ScannerRule__Alternatives : ( ( ruleScannerSingleLineRule ) | ( ruleScannerMultiLineRule ) | ( ruleScannerCharacterRule ) | ( ruleScannerJSRule ) | ( ruleScannerWhitespaceRule ) );
    public final void rule__ScannerRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:781:1: ( ( ruleScannerSingleLineRule ) | ( ruleScannerMultiLineRule ) | ( ruleScannerCharacterRule ) | ( ruleScannerJSRule ) | ( ruleScannerWhitespaceRule ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt3=1;
                }
                break;
            case 39:
                {
                alt3=2;
                }
                break;
            case 40:
                {
                alt3=3;
                }
                break;
            case 41:
                {
                alt3=4;
                }
                break;
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
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:782:1: ( ruleScannerSingleLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:782:1: ( ruleScannerSingleLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:783:1: ruleScannerSingleLineRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleScannerSingleLineRule_in_rule__ScannerRule__Alternatives1605);
                    ruleScannerSingleLineRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:788:6: ( ruleScannerMultiLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:788:6: ( ruleScannerMultiLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:789:1: ruleScannerMultiLineRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleScannerMultiLineRule_in_rule__ScannerRule__Alternatives1622);
                    ruleScannerMultiLineRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:794:6: ( ruleScannerCharacterRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:794:6: ( ruleScannerCharacterRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:795:1: ruleScannerCharacterRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleScannerCharacterRule_in_rule__ScannerRule__Alternatives1639);
                    ruleScannerCharacterRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:800:6: ( ruleScannerJSRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:800:6: ( ruleScannerJSRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:801:1: ruleScannerJSRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleScannerJSRule_in_rule__ScannerRule__Alternatives1656);
                    ruleScannerJSRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:806:6: ( ruleScannerWhitespaceRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:806:6: ( ruleScannerWhitespaceRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:807:1: ruleScannerWhitespaceRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerWhitespaceRuleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_rule__ScannerRule__Alternatives1673);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:817:1: rule__ParitionRule__Alternatives : ( ( rulePartitionSingleLineRule ) | ( rulePartitionMultiLineRule ) | ( rulePartitionJSRule ) );
    public final void rule__ParitionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:821:1: ( ( rulePartitionSingleLineRule ) | ( rulePartitionMultiLineRule ) | ( rulePartitionJSRule ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt4=1;
                }
                break;
            case 39:
                {
                alt4=2;
                }
                break;
            case 41:
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
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:822:1: ( rulePartitionSingleLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:822:1: ( rulePartitionSingleLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:823:1: rulePartitionSingleLineRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePartitionSingleLineRule_in_rule__ParitionRule__Alternatives1705);
                    rulePartitionSingleLineRule();

                    state._fsp--;

                     after(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:828:6: ( rulePartitionMultiLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:828:6: ( rulePartitionMultiLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:829:1: rulePartitionMultiLineRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_rulePartitionMultiLineRule_in_rule__ParitionRule__Alternatives1722);
                    rulePartitionMultiLineRule();

                    state._fsp--;

                     after(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:834:6: ( rulePartitionJSRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:834:6: ( rulePartitionJSRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:835:1: rulePartitionJSRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionJSRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_rulePartitionJSRule_in_rule__ParitionRule__Alternatives1739);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:845:1: rule__ScannerWhitespaceRule__Alternatives_2 : ( ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) ) | ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) ) | ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) ) );
    public final void rule__ScannerWhitespaceRule__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:849:1: ( ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) ) | ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) ) | ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt5=1;
                }
                break;
            case 47:
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
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:850:1: ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:850:1: ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:851:1: ( rule__ScannerWhitespaceRule__Group_2_0__0 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_2_0()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:852:1: ( rule__ScannerWhitespaceRule__Group_2_0__0 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:852:2: rule__ScannerWhitespaceRule__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0_in_rule__ScannerWhitespaceRule__Alternatives_21771);
                    rule__ScannerWhitespaceRule__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:856:6: ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:856:6: ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:857:1: ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceAssignment_2_1()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:858:1: ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:858:2: rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1_in_rule__ScannerWhitespaceRule__Alternatives_21789);
                    rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:862:6: ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:862:6: ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:863:1: ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getFileURIAssignment_2_2()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:864:1: ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:864:2: rule__ScannerWhitespaceRule__FileURIAssignment_2_2
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__FileURIAssignment_2_2_in_rule__ScannerWhitespaceRule__Alternatives_21807);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:873:1: rule__FontType__Alternatives : ( ( ( 'bold' ) ) | ( ( 'italic' ) ) | ( ( 'underline' ) ) | ( ( 'strike-through' ) ) );
    public final void rule__FontType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:877:1: ( ( ( 'bold' ) ) | ( ( 'italic' ) ) | ( ( 'underline' ) ) | ( ( 'strike-through' ) ) )
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
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:878:1: ( ( 'bold' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:878:1: ( ( 'bold' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:879:1: ( 'bold' )
                    {
                     before(grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:880:1: ( 'bold' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:880:3: 'bold'
                    {
                    match(input,11,FOLLOW_11_in_rule__FontType__Alternatives1841); 

                    }

                     after(grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:885:6: ( ( 'italic' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:885:6: ( ( 'italic' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:886:1: ( 'italic' )
                    {
                     before(grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:887:1: ( 'italic' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:887:3: 'italic'
                    {
                    match(input,12,FOLLOW_12_in_rule__FontType__Alternatives1862); 

                    }

                     after(grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:892:6: ( ( 'underline' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:892:6: ( ( 'underline' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:893:1: ( 'underline' )
                    {
                     before(grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:894:1: ( 'underline' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:894:3: 'underline'
                    {
                    match(input,13,FOLLOW_13_in_rule__FontType__Alternatives1883); 

                    }

                     after(grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:899:6: ( ( 'strike-through' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:899:6: ( ( 'strike-through' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:900:1: ( 'strike-through' )
                    {
                     before(grammarAccess.getFontTypeAccess().getStrike_throughEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:901:1: ( 'strike-through' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:901:3: 'strike-through'
                    {
                    match(input,14,FOLLOW_14_in_rule__FontType__Alternatives1904); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:913:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:917:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:918:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01937);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01940);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:925:1: rule__Model__Group__0__Impl : ( ( rule__Model__NameAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:929:1: ( ( ( rule__Model__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:930:1: ( ( rule__Model__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:930:1: ( ( rule__Model__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:931:1: ( rule__Model__NameAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:932:1: ( rule__Model__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:932:2: rule__Model__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__NameAssignment_0_in_rule__Model__Group__0__Impl1967);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:942:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:946:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:947:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11997);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12000);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:954:1: rule__Model__Group__1__Impl : ( '{' ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:958:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:959:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:959:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:960:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__Model__Group__1__Impl2028); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:973:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:977:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:978:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22059);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__22062);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:985:1: rule__Model__Group__2__Impl : ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:989:1: ( ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:990:1: ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:990:1: ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:991:1: ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:991:1: ( ( rule__Model__PartitionsAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:992:1: ( rule__Model__PartitionsAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:993:1: ( rule__Model__PartitionsAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:993:2: rule__Model__PartitionsAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2091);
            rule__Model__PartitionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:996:1: ( ( rule__Model__PartitionsAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:997:1: ( rule__Model__PartitionsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:998:1: ( rule__Model__PartitionsAssignment_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:998:2: rule__Model__PartitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2103);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1009:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1013:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1014:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__32136);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__4_in_rule__Model__Group__32139);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1021:1: rule__Model__Group__3__Impl : ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1025:1: ( ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1026:1: ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1026:1: ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1027:1: ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1027:1: ( ( rule__Model__DamagersAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1028:1: ( rule__Model__DamagersAssignment_3 )
            {
             before(grammarAccess.getModelAccess().getDamagersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1029:1: ( rule__Model__DamagersAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1029:2: rule__Model__DamagersAssignment_3
            {
            pushFollow(FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2168);
            rule__Model__DamagersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDamagersAssignment_3()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1032:1: ( ( rule__Model__DamagersAssignment_3 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1033:1: ( rule__Model__DamagersAssignment_3 )*
            {
             before(grammarAccess.getModelAccess().getDamagersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1034:1: ( rule__Model__DamagersAssignment_3 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=27 && LA8_0<=28)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1034:2: rule__Model__DamagersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2180);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1045:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1049:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1050:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__42213);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__5_in_rule__Model__Group__42216);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1057:1: rule__Model__Group__4__Impl : ( ( rule__Model__PartitionerAssignment_4 ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1061:1: ( ( ( rule__Model__PartitionerAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1062:1: ( ( rule__Model__PartitionerAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1062:1: ( ( rule__Model__PartitionerAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1063:1: ( rule__Model__PartitionerAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getPartitionerAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1064:1: ( rule__Model__PartitionerAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1064:2: rule__Model__PartitionerAssignment_4
            {
            pushFollow(FOLLOW_rule__Model__PartitionerAssignment_4_in_rule__Model__Group__4__Impl2243);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1074:1: rule__Model__Group__5 : rule__Model__Group__5__Impl rule__Model__Group__6 ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1078:1: ( rule__Model__Group__5__Impl rule__Model__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1079:2: rule__Model__Group__5__Impl rule__Model__Group__6
            {
            pushFollow(FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__52273);
            rule__Model__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__6_in_rule__Model__Group__52276);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1086:1: rule__Model__Group__5__Impl : ( '}' ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1090:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1091:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1091:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1092:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,16,FOLLOW_16_in_rule__Model__Group__5__Impl2304); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1105:1: rule__Model__Group__6 : rule__Model__Group__6__Impl rule__Model__Group__7 ;
    public final void rule__Model__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1109:1: ( rule__Model__Group__6__Impl rule__Model__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1110:2: rule__Model__Group__6__Impl rule__Model__Group__7
            {
            pushFollow(FOLLOW_rule__Model__Group__6__Impl_in_rule__Model__Group__62335);
            rule__Model__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__7_in_rule__Model__Group__62338);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1117:1: rule__Model__Group__6__Impl : ( 'for' ) ;
    public final void rule__Model__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1121:1: ( ( 'for' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1122:1: ( 'for' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1122:1: ( 'for' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1123:1: 'for'
            {
             before(grammarAccess.getModelAccess().getForKeyword_6()); 
            match(input,17,FOLLOW_17_in_rule__Model__Group__6__Impl2366); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1136:1: rule__Model__Group__7 : rule__Model__Group__7__Impl ;
    public final void rule__Model__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1140:1: ( rule__Model__Group__7__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1141:2: rule__Model__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__7__Impl_in_rule__Model__Group__72397);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1147:1: rule__Model__Group__7__Impl : ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) ) ;
    public final void rule__Model__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1151:1: ( ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1152:1: ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1152:1: ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1153:1: ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1153:1: ( ( rule__Model__ContentTypesAssignment_7 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1154:1: ( rule__Model__ContentTypesAssignment_7 )
            {
             before(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1155:1: ( rule__Model__ContentTypesAssignment_7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1155:2: rule__Model__ContentTypesAssignment_7
            {
            pushFollow(FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2426);
            rule__Model__ContentTypesAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1158:1: ( ( rule__Model__ContentTypesAssignment_7 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1159:1: ( rule__Model__ContentTypesAssignment_7 )*
            {
             before(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1160:1: ( rule__Model__ContentTypesAssignment_7 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_STRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1160:2: rule__Model__ContentTypesAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2438);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1187:1: rule__Partition__Group__0 : rule__Partition__Group__0__Impl rule__Partition__Group__1 ;
    public final void rule__Partition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1191:1: ( rule__Partition__Group__0__Impl rule__Partition__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1192:2: rule__Partition__Group__0__Impl rule__Partition__Group__1
            {
            pushFollow(FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__02487);
            rule__Partition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__02490);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1199:1: rule__Partition__Group__0__Impl : ( 'partition' ) ;
    public final void rule__Partition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1203:1: ( ( 'partition' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1204:1: ( 'partition' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1204:1: ( 'partition' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1205:1: 'partition'
            {
             before(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__Partition__Group__0__Impl2518); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1218:1: rule__Partition__Group__1 : rule__Partition__Group__1__Impl ;
    public final void rule__Partition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1222:1: ( rule__Partition__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1223:2: rule__Partition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__12549);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1229:1: rule__Partition__Group__1__Impl : ( ( rule__Partition__NameAssignment_1 ) ) ;
    public final void rule__Partition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1233:1: ( ( ( rule__Partition__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1234:1: ( ( rule__Partition__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1234:1: ( ( rule__Partition__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1235:1: ( rule__Partition__NameAssignment_1 )
            {
             before(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1236:1: ( rule__Partition__NameAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1236:2: rule__Partition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl2576);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1250:1: rule__JavaLikeParitioner__Group__0 : rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1 ;
    public final void rule__JavaLikeParitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1254:1: ( rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1255:2: rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__0__Impl_in_rule__JavaLikeParitioner__Group__02610);
            rule__JavaLikeParitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__1_in_rule__JavaLikeParitioner__Group__02613);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1262:1: rule__JavaLikeParitioner__Group__0__Impl : ( 'java-like-partitioner' ) ;
    public final void rule__JavaLikeParitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1266:1: ( ( 'java-like-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1267:1: ( 'java-like-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1267:1: ( 'java-like-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1268:1: 'java-like-partitioner'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaLikePartitionerKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__JavaLikeParitioner__Group__0__Impl2641); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1281:1: rule__JavaLikeParitioner__Group__1 : rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2 ;
    public final void rule__JavaLikeParitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1285:1: ( rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1286:2: rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__1__Impl_in_rule__JavaLikeParitioner__Group__12672);
            rule__JavaLikeParitioner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__2_in_rule__JavaLikeParitioner__Group__12675);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1293:1: rule__JavaLikeParitioner__Group__1__Impl : ( '{' ) ;
    public final void rule__JavaLikeParitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1297:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1298:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1298:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1299:1: '{'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__JavaLikeParitioner__Group__1__Impl2703); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1312:1: rule__JavaLikeParitioner__Group__2 : rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3 ;
    public final void rule__JavaLikeParitioner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1316:1: ( rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1317:2: rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__2__Impl_in_rule__JavaLikeParitioner__Group__22734);
            rule__JavaLikeParitioner__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__3_in_rule__JavaLikeParitioner__Group__22737);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1324:1: rule__JavaLikeParitioner__Group__2__Impl : ( 'singlelinedoc' ) ;
    public final void rule__JavaLikeParitioner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1328:1: ( ( 'singlelinedoc' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1329:1: ( 'singlelinedoc' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1329:1: ( 'singlelinedoc' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1330:1: 'singlelinedoc'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSinglelinedocKeyword_2()); 
            match(input,20,FOLLOW_20_in_rule__JavaLikeParitioner__Group__2__Impl2765); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1343:1: rule__JavaLikeParitioner__Group__3 : rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4 ;
    public final void rule__JavaLikeParitioner__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1347:1: ( rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1348:2: rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__3__Impl_in_rule__JavaLikeParitioner__Group__32796);
            rule__JavaLikeParitioner__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__4_in_rule__JavaLikeParitioner__Group__32799);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1355:1: rule__JavaLikeParitioner__Group__3__Impl : ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) ) ;
    public final void rule__JavaLikeParitioner__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1359:1: ( ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1360:1: ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1360:1: ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1361:1: ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1362:1: ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1362:2: rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3_in_rule__JavaLikeParitioner__Group__3__Impl2826);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1372:1: rule__JavaLikeParitioner__Group__4 : rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5 ;
    public final void rule__JavaLikeParitioner__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1376:1: ( rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1377:2: rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__4__Impl_in_rule__JavaLikeParitioner__Group__42856);
            rule__JavaLikeParitioner__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__5_in_rule__JavaLikeParitioner__Group__42859);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1384:1: rule__JavaLikeParitioner__Group__4__Impl : ( 'multilinedoc' ) ;
    public final void rule__JavaLikeParitioner__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1388:1: ( ( 'multilinedoc' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1389:1: ( 'multilinedoc' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1389:1: ( 'multilinedoc' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1390:1: 'multilinedoc'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultilinedocKeyword_4()); 
            match(input,21,FOLLOW_21_in_rule__JavaLikeParitioner__Group__4__Impl2887); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1403:1: rule__JavaLikeParitioner__Group__5 : rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6 ;
    public final void rule__JavaLikeParitioner__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1407:1: ( rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1408:2: rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__5__Impl_in_rule__JavaLikeParitioner__Group__52918);
            rule__JavaLikeParitioner__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__6_in_rule__JavaLikeParitioner__Group__52921);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1415:1: rule__JavaLikeParitioner__Group__5__Impl : ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) ) ;
    public final void rule__JavaLikeParitioner__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1419:1: ( ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1420:1: ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1420:1: ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1421:1: ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1422:1: ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1422:2: rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5_in_rule__JavaLikeParitioner__Group__5__Impl2948);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1432:1: rule__JavaLikeParitioner__Group__6 : rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7 ;
    public final void rule__JavaLikeParitioner__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1436:1: ( rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1437:2: rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__6__Impl_in_rule__JavaLikeParitioner__Group__62978);
            rule__JavaLikeParitioner__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__7_in_rule__JavaLikeParitioner__Group__62981);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1444:1: rule__JavaLikeParitioner__Group__6__Impl : ( 'javadoc' ) ;
    public final void rule__JavaLikeParitioner__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1448:1: ( ( 'javadoc' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1449:1: ( 'javadoc' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1449:1: ( 'javadoc' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1450:1: 'javadoc'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavadocKeyword_6()); 
            match(input,22,FOLLOW_22_in_rule__JavaLikeParitioner__Group__6__Impl3009); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1463:1: rule__JavaLikeParitioner__Group__7 : rule__JavaLikeParitioner__Group__7__Impl rule__JavaLikeParitioner__Group__8 ;
    public final void rule__JavaLikeParitioner__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1467:1: ( rule__JavaLikeParitioner__Group__7__Impl rule__JavaLikeParitioner__Group__8 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1468:2: rule__JavaLikeParitioner__Group__7__Impl rule__JavaLikeParitioner__Group__8
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__7__Impl_in_rule__JavaLikeParitioner__Group__73040);
            rule__JavaLikeParitioner__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__8_in_rule__JavaLikeParitioner__Group__73043);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1475:1: rule__JavaLikeParitioner__Group__7__Impl : ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) ) ;
    public final void rule__JavaLikeParitioner__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1479:1: ( ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1480:1: ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1480:1: ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1481:1: ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1482:1: ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1482:2: rule__JavaLikeParitioner__JavaDocParitionAssignment_7
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__JavaDocParitionAssignment_7_in_rule__JavaLikeParitioner__Group__7__Impl3070);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1492:1: rule__JavaLikeParitioner__Group__8 : rule__JavaLikeParitioner__Group__8__Impl rule__JavaLikeParitioner__Group__9 ;
    public final void rule__JavaLikeParitioner__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1496:1: ( rule__JavaLikeParitioner__Group__8__Impl rule__JavaLikeParitioner__Group__9 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1497:2: rule__JavaLikeParitioner__Group__8__Impl rule__JavaLikeParitioner__Group__9
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__8__Impl_in_rule__JavaLikeParitioner__Group__83100);
            rule__JavaLikeParitioner__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__9_in_rule__JavaLikeParitioner__Group__83103);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1504:1: rule__JavaLikeParitioner__Group__8__Impl : ( 'char' ) ;
    public final void rule__JavaLikeParitioner__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1508:1: ( ( 'char' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1509:1: ( 'char' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1509:1: ( 'char' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1510:1: 'char'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharKeyword_8()); 
            match(input,23,FOLLOW_23_in_rule__JavaLikeParitioner__Group__8__Impl3131); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1523:1: rule__JavaLikeParitioner__Group__9 : rule__JavaLikeParitioner__Group__9__Impl rule__JavaLikeParitioner__Group__10 ;
    public final void rule__JavaLikeParitioner__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1527:1: ( rule__JavaLikeParitioner__Group__9__Impl rule__JavaLikeParitioner__Group__10 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1528:2: rule__JavaLikeParitioner__Group__9__Impl rule__JavaLikeParitioner__Group__10
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__9__Impl_in_rule__JavaLikeParitioner__Group__93162);
            rule__JavaLikeParitioner__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__10_in_rule__JavaLikeParitioner__Group__93165);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1535:1: rule__JavaLikeParitioner__Group__9__Impl : ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) ) ;
    public final void rule__JavaLikeParitioner__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1539:1: ( ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1540:1: ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1540:1: ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1541:1: ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionAssignment_9()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1542:1: ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1542:2: rule__JavaLikeParitioner__CharacterParitionAssignment_9
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__CharacterParitionAssignment_9_in_rule__JavaLikeParitioner__Group__9__Impl3192);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1552:1: rule__JavaLikeParitioner__Group__10 : rule__JavaLikeParitioner__Group__10__Impl rule__JavaLikeParitioner__Group__11 ;
    public final void rule__JavaLikeParitioner__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1556:1: ( rule__JavaLikeParitioner__Group__10__Impl rule__JavaLikeParitioner__Group__11 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1557:2: rule__JavaLikeParitioner__Group__10__Impl rule__JavaLikeParitioner__Group__11
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__10__Impl_in_rule__JavaLikeParitioner__Group__103222);
            rule__JavaLikeParitioner__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__11_in_rule__JavaLikeParitioner__Group__103225);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1564:1: rule__JavaLikeParitioner__Group__10__Impl : ( 'string' ) ;
    public final void rule__JavaLikeParitioner__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1568:1: ( ( 'string' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1569:1: ( 'string' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1569:1: ( 'string' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1570:1: 'string'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringKeyword_10()); 
            match(input,24,FOLLOW_24_in_rule__JavaLikeParitioner__Group__10__Impl3253); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1583:1: rule__JavaLikeParitioner__Group__11 : rule__JavaLikeParitioner__Group__11__Impl rule__JavaLikeParitioner__Group__12 ;
    public final void rule__JavaLikeParitioner__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1587:1: ( rule__JavaLikeParitioner__Group__11__Impl rule__JavaLikeParitioner__Group__12 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1588:2: rule__JavaLikeParitioner__Group__11__Impl rule__JavaLikeParitioner__Group__12
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__11__Impl_in_rule__JavaLikeParitioner__Group__113284);
            rule__JavaLikeParitioner__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__12_in_rule__JavaLikeParitioner__Group__113287);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1595:1: rule__JavaLikeParitioner__Group__11__Impl : ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) ) ;
    public final void rule__JavaLikeParitioner__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1599:1: ( ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1600:1: ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1600:1: ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1601:1: ( rule__JavaLikeParitioner__StringParitionAssignment_11 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionAssignment_11()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1602:1: ( rule__JavaLikeParitioner__StringParitionAssignment_11 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1602:2: rule__JavaLikeParitioner__StringParitionAssignment_11
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__StringParitionAssignment_11_in_rule__JavaLikeParitioner__Group__11__Impl3314);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1612:1: rule__JavaLikeParitioner__Group__12 : rule__JavaLikeParitioner__Group__12__Impl ;
    public final void rule__JavaLikeParitioner__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1616:1: ( rule__JavaLikeParitioner__Group__12__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1617:2: rule__JavaLikeParitioner__Group__12__Impl
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__12__Impl_in_rule__JavaLikeParitioner__Group__123344);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1623:1: rule__JavaLikeParitioner__Group__12__Impl : ( '}' ) ;
    public final void rule__JavaLikeParitioner__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1627:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1628:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1628:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1629:1: '}'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getRightCurlyBracketKeyword_12()); 
            match(input,16,FOLLOW_16_in_rule__JavaLikeParitioner__Group__12__Impl3372); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1668:1: rule__RulePartitioner__Group__0 : rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1 ;
    public final void rule__RulePartitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1672:1: ( rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1673:2: rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__0__Impl_in_rule__RulePartitioner__Group__03429);
            rule__RulePartitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__1_in_rule__RulePartitioner__Group__03432);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1680:1: rule__RulePartitioner__Group__0__Impl : ( 'rule-partitioner' ) ;
    public final void rule__RulePartitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1684:1: ( ( 'rule-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1685:1: ( 'rule-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1685:1: ( 'rule-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1686:1: 'rule-partitioner'
            {
             before(grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__RulePartitioner__Group__0__Impl3460); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1699:1: rule__RulePartitioner__Group__1 : rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2 ;
    public final void rule__RulePartitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1703:1: ( rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1704:2: rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__1__Impl_in_rule__RulePartitioner__Group__13491);
            rule__RulePartitioner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__2_in_rule__RulePartitioner__Group__13494);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1711:1: rule__RulePartitioner__Group__1__Impl : ( '{' ) ;
    public final void rule__RulePartitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1715:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1716:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1716:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1717:1: '{'
            {
             before(grammarAccess.getRulePartitionerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__RulePartitioner__Group__1__Impl3522); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1730:1: rule__RulePartitioner__Group__2 : rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3 ;
    public final void rule__RulePartitioner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1734:1: ( rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1735:2: rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__2__Impl_in_rule__RulePartitioner__Group__23553);
            rule__RulePartitioner__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__3_in_rule__RulePartitioner__Group__23556);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1742:1: rule__RulePartitioner__Group__2__Impl : ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) ) ;
    public final void rule__RulePartitioner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1746:1: ( ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1747:1: ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1747:1: ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1748:1: ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1748:1: ( ( rule__RulePartitioner__RulesAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1749:1: ( rule__RulePartitioner__RulesAssignment_2 )
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1750:1: ( rule__RulePartitioner__RulesAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1750:2: rule__RulePartitioner__RulesAssignment_2
            {
            pushFollow(FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3585);
            rule__RulePartitioner__RulesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1753:1: ( ( rule__RulePartitioner__RulesAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1754:1: ( rule__RulePartitioner__RulesAssignment_2 )*
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1755:1: ( rule__RulePartitioner__RulesAssignment_2 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==35||LA10_0==39||LA10_0==41) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1755:2: rule__RulePartitioner__RulesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3597);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1766:1: rule__RulePartitioner__Group__3 : rule__RulePartitioner__Group__3__Impl ;
    public final void rule__RulePartitioner__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1770:1: ( rule__RulePartitioner__Group__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1771:2: rule__RulePartitioner__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__3__Impl_in_rule__RulePartitioner__Group__33630);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1777:1: rule__RulePartitioner__Group__3__Impl : ( '}' ) ;
    public final void rule__RulePartitioner__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1781:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1782:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1782:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1783:1: '}'
            {
             before(grammarAccess.getRulePartitionerAccess().getRightCurlyBracketKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__RulePartitioner__Group__3__Impl3658); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1804:1: rule__JSParitioner__Group__0 : rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1 ;
    public final void rule__JSParitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1808:1: ( rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1809:2: rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__0__Impl_in_rule__JSParitioner__Group__03697);
            rule__JSParitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSParitioner__Group__1_in_rule__JSParitioner__Group__03700);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1816:1: rule__JSParitioner__Group__0__Impl : ( 'js-partitioner' ) ;
    public final void rule__JSParitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1820:1: ( ( 'js-partitioner' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1821:1: ( 'js-partitioner' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1821:1: ( 'js-partitioner' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1822:1: 'js-partitioner'
            {
             before(grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__JSParitioner__Group__0__Impl3728); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1835:1: rule__JSParitioner__Group__1 : rule__JSParitioner__Group__1__Impl ;
    public final void rule__JSParitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1839:1: ( rule__JSParitioner__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1840:2: rule__JSParitioner__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__1__Impl_in_rule__JSParitioner__Group__13759);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1846:1: rule__JSParitioner__Group__1__Impl : ( ( rule__JSParitioner__FileURIAssignment_1 ) ) ;
    public final void rule__JSParitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1850:1: ( ( ( rule__JSParitioner__FileURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1851:1: ( ( rule__JSParitioner__FileURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1851:1: ( ( rule__JSParitioner__FileURIAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1852:1: ( rule__JSParitioner__FileURIAssignment_1 )
            {
             before(grammarAccess.getJSParitionerAccess().getFileURIAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1853:1: ( rule__JSParitioner__FileURIAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1853:2: rule__JSParitioner__FileURIAssignment_1
            {
            pushFollow(FOLLOW_rule__JSParitioner__FileURIAssignment_1_in_rule__JSParitioner__Group__1__Impl3786);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1867:1: rule__JSDamager__Group__0 : rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1 ;
    public final void rule__JSDamager__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1871:1: ( rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1872:2: rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__0__Impl_in_rule__JSDamager__Group__03820);
            rule__JSDamager__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSDamager__Group__1_in_rule__JSDamager__Group__03823);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1879:1: rule__JSDamager__Group__0__Impl : ( 'js-damager' ) ;
    public final void rule__JSDamager__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1883:1: ( ( 'js-damager' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1884:1: ( 'js-damager' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1884:1: ( 'js-damager' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1885:1: 'js-damager'
            {
             before(grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__JSDamager__Group__0__Impl3851); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1898:1: rule__JSDamager__Group__1 : rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2 ;
    public final void rule__JSDamager__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1902:1: ( rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1903:2: rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__1__Impl_in_rule__JSDamager__Group__13882);
            rule__JSDamager__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSDamager__Group__2_in_rule__JSDamager__Group__13885);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1910:1: rule__JSDamager__Group__1__Impl : ( ( rule__JSDamager__PartitionAssignment_1 ) ) ;
    public final void rule__JSDamager__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1914:1: ( ( ( rule__JSDamager__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1915:1: ( ( rule__JSDamager__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1915:1: ( ( rule__JSDamager__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1916:1: ( rule__JSDamager__PartitionAssignment_1 )
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1917:1: ( rule__JSDamager__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1917:2: rule__JSDamager__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__JSDamager__PartitionAssignment_1_in_rule__JSDamager__Group__1__Impl3912);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1927:1: rule__JSDamager__Group__2 : rule__JSDamager__Group__2__Impl ;
    public final void rule__JSDamager__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1931:1: ( rule__JSDamager__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1932:2: rule__JSDamager__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__2__Impl_in_rule__JSDamager__Group__23942);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1938:1: rule__JSDamager__Group__2__Impl : ( ( rule__JSDamager__FileURIAssignment_2 ) ) ;
    public final void rule__JSDamager__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1942:1: ( ( ( rule__JSDamager__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1943:1: ( ( rule__JSDamager__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1943:1: ( ( rule__JSDamager__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1944:1: ( rule__JSDamager__FileURIAssignment_2 )
            {
             before(grammarAccess.getJSDamagerAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1945:1: ( rule__JSDamager__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1945:2: rule__JSDamager__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__JSDamager__FileURIAssignment_2_in_rule__JSDamager__Group__2__Impl3969);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1961:1: rule__RuleDamager__Group__0 : rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1 ;
    public final void rule__RuleDamager__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1965:1: ( rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1966:2: rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__0__Impl_in_rule__RuleDamager__Group__04005);
            rule__RuleDamager__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__1_in_rule__RuleDamager__Group__04008);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1973:1: rule__RuleDamager__Group__0__Impl : ( 'rule-damager' ) ;
    public final void rule__RuleDamager__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1977:1: ( ( 'rule-damager' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1978:1: ( 'rule-damager' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1978:1: ( 'rule-damager' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1979:1: 'rule-damager'
            {
             before(grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__RuleDamager__Group__0__Impl4036); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1992:1: rule__RuleDamager__Group__1 : rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2 ;
    public final void rule__RuleDamager__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1996:1: ( rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1997:2: rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__1__Impl_in_rule__RuleDamager__Group__14067);
            rule__RuleDamager__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__2_in_rule__RuleDamager__Group__14070);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2004:1: rule__RuleDamager__Group__1__Impl : ( ( rule__RuleDamager__PartitionAssignment_1 ) ) ;
    public final void rule__RuleDamager__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2008:1: ( ( ( rule__RuleDamager__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2009:1: ( ( rule__RuleDamager__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2009:1: ( ( rule__RuleDamager__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2010:1: ( rule__RuleDamager__PartitionAssignment_1 )
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2011:1: ( rule__RuleDamager__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2011:2: rule__RuleDamager__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__RuleDamager__PartitionAssignment_1_in_rule__RuleDamager__Group__1__Impl4097);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2021:1: rule__RuleDamager__Group__2 : rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3 ;
    public final void rule__RuleDamager__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2025:1: ( rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2026:2: rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__2__Impl_in_rule__RuleDamager__Group__24127);
            rule__RuleDamager__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__3_in_rule__RuleDamager__Group__24130);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2033:1: rule__RuleDamager__Group__2__Impl : ( '{' ) ;
    public final void rule__RuleDamager__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2037:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2038:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2038:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2039:1: '{'
            {
             before(grammarAccess.getRuleDamagerAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,15,FOLLOW_15_in_rule__RuleDamager__Group__2__Impl4158); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2052:1: rule__RuleDamager__Group__3 : rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4 ;
    public final void rule__RuleDamager__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2056:1: ( rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2057:2: rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__3__Impl_in_rule__RuleDamager__Group__34189);
            rule__RuleDamager__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__4_in_rule__RuleDamager__Group__34192);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2064:1: rule__RuleDamager__Group__3__Impl : ( ( rule__RuleDamager__TokensAssignment_3 )* ) ;
    public final void rule__RuleDamager__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2068:1: ( ( ( rule__RuleDamager__TokensAssignment_3 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2069:1: ( ( rule__RuleDamager__TokensAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2069:1: ( ( rule__RuleDamager__TokensAssignment_3 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2070:1: ( rule__RuleDamager__TokensAssignment_3 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getTokensAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2071:1: ( rule__RuleDamager__TokensAssignment_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29||LA11_0==46) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2071:2: rule__RuleDamager__TokensAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__TokensAssignment_3_in_rule__RuleDamager__Group__3__Impl4219);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2081:1: rule__RuleDamager__Group__4 : rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5 ;
    public final void rule__RuleDamager__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2085:1: ( rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2086:2: rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__4__Impl_in_rule__RuleDamager__Group__44250);
            rule__RuleDamager__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__5_in_rule__RuleDamager__Group__44253);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2093:1: rule__RuleDamager__Group__4__Impl : ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* ) ;
    public final void rule__RuleDamager__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2097:1: ( ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2098:1: ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2098:1: ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2099:1: ( rule__RuleDamager__KeywordGroupsAssignment_4 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getKeywordGroupsAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2100:1: ( rule__RuleDamager__KeywordGroupsAssignment_4 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==30) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2100:2: rule__RuleDamager__KeywordGroupsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__KeywordGroupsAssignment_4_in_rule__RuleDamager__Group__4__Impl4280);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2110:1: rule__RuleDamager__Group__5 : rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6 ;
    public final void rule__RuleDamager__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2114:1: ( rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2115:2: rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__5__Impl_in_rule__RuleDamager__Group__54311);
            rule__RuleDamager__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__6_in_rule__RuleDamager__Group__54314);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2122:1: rule__RuleDamager__Group__5__Impl : ( ( rule__RuleDamager__RulesAssignment_5 )* ) ;
    public final void rule__RuleDamager__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2126:1: ( ( ( rule__RuleDamager__RulesAssignment_5 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2127:1: ( ( rule__RuleDamager__RulesAssignment_5 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2127:1: ( ( rule__RuleDamager__RulesAssignment_5 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2128:1: ( rule__RuleDamager__RulesAssignment_5 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getRulesAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2129:1: ( rule__RuleDamager__RulesAssignment_5 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==35||(LA13_0>=39 && LA13_0<=42)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2129:2: rule__RuleDamager__RulesAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__RulesAssignment_5_in_rule__RuleDamager__Group__5__Impl4341);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2139:1: rule__RuleDamager__Group__6 : rule__RuleDamager__Group__6__Impl ;
    public final void rule__RuleDamager__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2143:1: ( rule__RuleDamager__Group__6__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2144:2: rule__RuleDamager__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__6__Impl_in_rule__RuleDamager__Group__64372);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2150:1: rule__RuleDamager__Group__6__Impl : ( '}' ) ;
    public final void rule__RuleDamager__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2154:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2155:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2155:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2156:1: '}'
            {
             before(grammarAccess.getRuleDamagerAccess().getRightCurlyBracketKeyword_6()); 
            match(input,16,FOLLOW_16_in_rule__RuleDamager__Group__6__Impl4400); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2183:1: rule__ScannerToken__Group__0 : rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1 ;
    public final void rule__ScannerToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2187:1: ( rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2188:2: rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__0__Impl_in_rule__ScannerToken__Group__04445);
            rule__ScannerToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__1_in_rule__ScannerToken__Group__04448);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2195:1: rule__ScannerToken__Group__0__Impl : ( ( rule__ScannerToken__DefaultAssignment_0 )? ) ;
    public final void rule__ScannerToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2199:1: ( ( ( rule__ScannerToken__DefaultAssignment_0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2200:1: ( ( rule__ScannerToken__DefaultAssignment_0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2200:1: ( ( rule__ScannerToken__DefaultAssignment_0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2201:1: ( rule__ScannerToken__DefaultAssignment_0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2202:1: ( rule__ScannerToken__DefaultAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==46) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2202:2: rule__ScannerToken__DefaultAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__DefaultAssignment_0_in_rule__ScannerToken__Group__0__Impl4475);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2212:1: rule__ScannerToken__Group__1 : rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2 ;
    public final void rule__ScannerToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2216:1: ( rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2217:2: rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__1__Impl_in_rule__ScannerToken__Group__14506);
            rule__ScannerToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__2_in_rule__ScannerToken__Group__14509);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2224:1: rule__ScannerToken__Group__1__Impl : ( 'token' ) ;
    public final void rule__ScannerToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2228:1: ( ( 'token' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2229:1: ( 'token' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2229:1: ( 'token' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2230:1: 'token'
            {
             before(grammarAccess.getScannerTokenAccess().getTokenKeyword_1()); 
            match(input,29,FOLLOW_29_in_rule__ScannerToken__Group__1__Impl4537); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2243:1: rule__ScannerToken__Group__2 : rule__ScannerToken__Group__2__Impl ;
    public final void rule__ScannerToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2247:1: ( rule__ScannerToken__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2248:2: rule__ScannerToken__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__2__Impl_in_rule__ScannerToken__Group__24568);
            rule__ScannerToken__Group__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2254:1: rule__ScannerToken__Group__2__Impl : ( ( rule__ScannerToken__NameAssignment_2 ) ) ;
    public final void rule__ScannerToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2258:1: ( ( ( rule__ScannerToken__NameAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2259:1: ( ( rule__ScannerToken__NameAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2259:1: ( ( rule__ScannerToken__NameAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2260:1: ( rule__ScannerToken__NameAssignment_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getNameAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2261:1: ( rule__ScannerToken__NameAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2261:2: rule__ScannerToken__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__NameAssignment_2_in_rule__ScannerToken__Group__2__Impl4595);
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


    // $ANTLR start "rule__KeywordGroup__Group__0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2277:1: rule__KeywordGroup__Group__0 : rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1 ;
    public final void rule__KeywordGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2281:1: ( rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2282:2: rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__0__Impl_in_rule__KeywordGroup__Group__04631);
            rule__KeywordGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__1_in_rule__KeywordGroup__Group__04634);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2289:1: rule__KeywordGroup__Group__0__Impl : ( 'keywords' ) ;
    public final void rule__KeywordGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2293:1: ( ( 'keywords' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2294:1: ( 'keywords' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2294:1: ( 'keywords' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2295:1: 'keywords'
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__KeywordGroup__Group__0__Impl4662); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2308:1: rule__KeywordGroup__Group__1 : rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2 ;
    public final void rule__KeywordGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2312:1: ( rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2313:2: rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__1__Impl_in_rule__KeywordGroup__Group__14693);
            rule__KeywordGroup__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__2_in_rule__KeywordGroup__Group__14696);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2320:1: rule__KeywordGroup__Group__1__Impl : ( ( rule__KeywordGroup__TokenAssignment_1 ) ) ;
    public final void rule__KeywordGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2324:1: ( ( ( rule__KeywordGroup__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2325:1: ( ( rule__KeywordGroup__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2325:1: ( ( rule__KeywordGroup__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2326:1: ( rule__KeywordGroup__TokenAssignment_1 )
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2327:1: ( rule__KeywordGroup__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2327:2: rule__KeywordGroup__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__TokenAssignment_1_in_rule__KeywordGroup__Group__1__Impl4723);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2337:1: rule__KeywordGroup__Group__2 : rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3 ;
    public final void rule__KeywordGroup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2341:1: ( rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2342:2: rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__2__Impl_in_rule__KeywordGroup__Group__24753);
            rule__KeywordGroup__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__3_in_rule__KeywordGroup__Group__24756);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2349:1: rule__KeywordGroup__Group__2__Impl : ( '[' ) ;
    public final void rule__KeywordGroup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2353:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2354:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2354:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2355:1: '['
            {
             before(grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2()); 
            match(input,31,FOLLOW_31_in_rule__KeywordGroup__Group__2__Impl4784); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2368:1: rule__KeywordGroup__Group__3 : rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4 ;
    public final void rule__KeywordGroup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2372:1: ( rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2373:2: rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__3__Impl_in_rule__KeywordGroup__Group__34815);
            rule__KeywordGroup__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__4_in_rule__KeywordGroup__Group__34818);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2380:1: rule__KeywordGroup__Group__3__Impl : ( ( rule__KeywordGroup__KeywordsAssignment_3 ) ) ;
    public final void rule__KeywordGroup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2384:1: ( ( ( rule__KeywordGroup__KeywordsAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2385:1: ( ( rule__KeywordGroup__KeywordsAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2385:1: ( ( rule__KeywordGroup__KeywordsAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2386:1: ( rule__KeywordGroup__KeywordsAssignment_3 )
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2387:1: ( rule__KeywordGroup__KeywordsAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2387:2: rule__KeywordGroup__KeywordsAssignment_3
            {
            pushFollow(FOLLOW_rule__KeywordGroup__KeywordsAssignment_3_in_rule__KeywordGroup__Group__3__Impl4845);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2397:1: rule__KeywordGroup__Group__4 : rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5 ;
    public final void rule__KeywordGroup__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2401:1: ( rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2402:2: rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__4__Impl_in_rule__KeywordGroup__Group__44875);
            rule__KeywordGroup__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__5_in_rule__KeywordGroup__Group__44878);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2409:1: rule__KeywordGroup__Group__4__Impl : ( ( rule__KeywordGroup__Group_4__0 )* ) ;
    public final void rule__KeywordGroup__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2413:1: ( ( ( rule__KeywordGroup__Group_4__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2414:1: ( ( rule__KeywordGroup__Group_4__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2414:1: ( ( rule__KeywordGroup__Group_4__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2415:1: ( rule__KeywordGroup__Group_4__0 )*
            {
             before(grammarAccess.getKeywordGroupAccess().getGroup_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2416:1: ( rule__KeywordGroup__Group_4__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==33) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2416:2: rule__KeywordGroup__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__KeywordGroup__Group_4__0_in_rule__KeywordGroup__Group__4__Impl4905);
            	    rule__KeywordGroup__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2426:1: rule__KeywordGroup__Group__5 : rule__KeywordGroup__Group__5__Impl ;
    public final void rule__KeywordGroup__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2430:1: ( rule__KeywordGroup__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2431:2: rule__KeywordGroup__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__5__Impl_in_rule__KeywordGroup__Group__54936);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2437:1: rule__KeywordGroup__Group__5__Impl : ( ']' ) ;
    public final void rule__KeywordGroup__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2441:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2442:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2442:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2443:1: ']'
            {
             before(grammarAccess.getKeywordGroupAccess().getRightSquareBracketKeyword_5()); 
            match(input,32,FOLLOW_32_in_rule__KeywordGroup__Group__5__Impl4964); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2468:1: rule__KeywordGroup__Group_4__0 : rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1 ;
    public final void rule__KeywordGroup__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2472:1: ( rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2473:2: rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__0__Impl_in_rule__KeywordGroup__Group_4__05007);
            rule__KeywordGroup__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__1_in_rule__KeywordGroup__Group_4__05010);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2480:1: rule__KeywordGroup__Group_4__0__Impl : ( ',' ) ;
    public final void rule__KeywordGroup__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2484:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2485:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2485:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2486:1: ','
            {
             before(grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0()); 
            match(input,33,FOLLOW_33_in_rule__KeywordGroup__Group_4__0__Impl5038); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2499:1: rule__KeywordGroup__Group_4__1 : rule__KeywordGroup__Group_4__1__Impl ;
    public final void rule__KeywordGroup__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2503:1: ( rule__KeywordGroup__Group_4__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2504:2: rule__KeywordGroup__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__1__Impl_in_rule__KeywordGroup__Group_4__15069);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2510:1: rule__KeywordGroup__Group_4__1__Impl : ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) ) ;
    public final void rule__KeywordGroup__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2514:1: ( ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2515:1: ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2515:1: ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2516:1: ( rule__KeywordGroup__KeywordsAssignment_4_1 )
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_4_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2517:1: ( rule__KeywordGroup__KeywordsAssignment_4_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2517:2: rule__KeywordGroup__KeywordsAssignment_4_1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__KeywordsAssignment_4_1_in_rule__KeywordGroup__Group_4__1__Impl5096);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2531:1: rule__Keyword__Group__0 : rule__Keyword__Group__0__Impl rule__Keyword__Group__1 ;
    public final void rule__Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2535:1: ( rule__Keyword__Group__0__Impl rule__Keyword__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2536:2: rule__Keyword__Group__0__Impl rule__Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__05130);
            rule__Keyword__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__05133);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2543:1: rule__Keyword__Group__0__Impl : ( ( rule__Keyword__NameAssignment_0 ) ) ;
    public final void rule__Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2547:1: ( ( ( rule__Keyword__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2548:1: ( ( rule__Keyword__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2548:1: ( ( rule__Keyword__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2549:1: ( rule__Keyword__NameAssignment_0 )
            {
             before(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2550:1: ( rule__Keyword__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2550:2: rule__Keyword__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl5160);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2560:1: rule__Keyword__Group__1 : rule__Keyword__Group__1__Impl ;
    public final void rule__Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2564:1: ( rule__Keyword__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2565:2: rule__Keyword__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__15190);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2571:1: rule__Keyword__Group__1__Impl : ( ( rule__Keyword__Group_1__0 )? ) ;
    public final void rule__Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2575:1: ( ( ( rule__Keyword__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2576:1: ( ( rule__Keyword__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2576:1: ( ( rule__Keyword__Group_1__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2577:1: ( rule__Keyword__Group_1__0 )?
            {
             before(grammarAccess.getKeywordAccess().getGroup_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2578:1: ( rule__Keyword__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==34) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2578:2: rule__Keyword__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl5217);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2592:1: rule__Keyword__Group_1__0 : rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 ;
    public final void rule__Keyword__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2596:1: ( rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2597:2: rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__05252);
            rule__Keyword__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__05255);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2604:1: rule__Keyword__Group_1__0__Impl : ( 'since' ) ;
    public final void rule__Keyword__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2608:1: ( ( 'since' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2609:1: ( 'since' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2609:1: ( 'since' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2610:1: 'since'
            {
             before(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            match(input,34,FOLLOW_34_in_rule__Keyword__Group_1__0__Impl5283); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2623:1: rule__Keyword__Group_1__1 : rule__Keyword__Group_1__1__Impl ;
    public final void rule__Keyword__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2627:1: ( rule__Keyword__Group_1__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2628:2: rule__Keyword__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__15314);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2634:1: rule__Keyword__Group_1__1__Impl : ( ( rule__Keyword__VersionAssignment_1_1 ) ) ;
    public final void rule__Keyword__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2638:1: ( ( ( rule__Keyword__VersionAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2639:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2639:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2640:1: ( rule__Keyword__VersionAssignment_1_1 )
            {
             before(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2641:1: ( rule__Keyword__VersionAssignment_1_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2641:2: rule__Keyword__VersionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl5341);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2655:1: rule__ScannerSingleLineRule__Group__0 : rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1 ;
    public final void rule__ScannerSingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2659:1: ( rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2660:2: rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__0__Impl_in_rule__ScannerSingleLineRule__Group__05375);
            rule__ScannerSingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__1_in_rule__ScannerSingleLineRule__Group__05378);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2667:1: rule__ScannerSingleLineRule__Group__0__Impl : ( 'single-line' ) ;
    public final void rule__ScannerSingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2671:1: ( ( 'single-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2672:1: ( 'single-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2672:1: ( 'single-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2673:1: 'single-line'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__ScannerSingleLineRule__Group__0__Impl5406); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2686:1: rule__ScannerSingleLineRule__Group__1 : rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2 ;
    public final void rule__ScannerSingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2690:1: ( rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2691:2: rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__1__Impl_in_rule__ScannerSingleLineRule__Group__15437);
            rule__ScannerSingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__2_in_rule__ScannerSingleLineRule__Group__15440);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2698:1: rule__ScannerSingleLineRule__Group__1__Impl : ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2702:1: ( ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2703:1: ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2703:1: ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2704:1: ( rule__ScannerSingleLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2705:1: ( rule__ScannerSingleLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2705:2: rule__ScannerSingleLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__TokenAssignment_1_in_rule__ScannerSingleLineRule__Group__1__Impl5467);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2715:1: rule__ScannerSingleLineRule__Group__2 : rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3 ;
    public final void rule__ScannerSingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2719:1: ( rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2720:2: rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__2__Impl_in_rule__ScannerSingleLineRule__Group__25497);
            rule__ScannerSingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__3_in_rule__ScannerSingleLineRule__Group__25500);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2727:1: rule__ScannerSingleLineRule__Group__2__Impl : ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2731:1: ( ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2732:1: ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2732:1: ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2733:1: ( rule__ScannerSingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2734:1: ( rule__ScannerSingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2734:2: rule__ScannerSingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__StartSeqAssignment_2_in_rule__ScannerSingleLineRule__Group__2__Impl5527);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2744:1: rule__ScannerSingleLineRule__Group__3 : rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4 ;
    public final void rule__ScannerSingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2748:1: ( rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2749:2: rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__3__Impl_in_rule__ScannerSingleLineRule__Group__35557);
            rule__ScannerSingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__4_in_rule__ScannerSingleLineRule__Group__35560);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2756:1: rule__ScannerSingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__ScannerSingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2760:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2761:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2761:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2762:1: '=>'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,36,FOLLOW_36_in_rule__ScannerSingleLineRule__Group__3__Impl5588); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2775:1: rule__ScannerSingleLineRule__Group__4 : rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5 ;
    public final void rule__ScannerSingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2779:1: ( rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2780:2: rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__4__Impl_in_rule__ScannerSingleLineRule__Group__45619);
            rule__ScannerSingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__5_in_rule__ScannerSingleLineRule__Group__45622);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2787:1: rule__ScannerSingleLineRule__Group__4__Impl : ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2791:1: ( ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2792:1: ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2792:1: ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2793:1: ( rule__ScannerSingleLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2794:1: ( rule__ScannerSingleLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2794:2: rule__ScannerSingleLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__EndSeqAssignment_4_in_rule__ScannerSingleLineRule__Group__4__Impl5649);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2804:1: rule__ScannerSingleLineRule__Group__5 : rule__ScannerSingleLineRule__Group__5__Impl ;
    public final void rule__ScannerSingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2808:1: ( rule__ScannerSingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2809:2: rule__ScannerSingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__5__Impl_in_rule__ScannerSingleLineRule__Group__55679);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2815:1: rule__ScannerSingleLineRule__Group__5__Impl : ( ( rule__ScannerSingleLineRule__Group_5__0 )? ) ;
    public final void rule__ScannerSingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2819:1: ( ( ( rule__ScannerSingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2820:1: ( ( rule__ScannerSingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2820:1: ( ( rule__ScannerSingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2821:1: ( rule__ScannerSingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2822:1: ( rule__ScannerSingleLineRule__Group_5__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==37) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2822:2: rule__ScannerSingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__0_in_rule__ScannerSingleLineRule__Group__5__Impl5706);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2844:1: rule__ScannerSingleLineRule__Group_5__0 : rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1 ;
    public final void rule__ScannerSingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2848:1: ( rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2849:2: rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__0__Impl_in_rule__ScannerSingleLineRule__Group_5__05749);
            rule__ScannerSingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__1_in_rule__ScannerSingleLineRule__Group_5__05752);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2856:1: rule__ScannerSingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__ScannerSingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2860:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2861:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2861:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2862:1: 'escaped'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,37,FOLLOW_37_in_rule__ScannerSingleLineRule__Group_5__0__Impl5780); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2875:1: rule__ScannerSingleLineRule__Group_5__1 : rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2 ;
    public final void rule__ScannerSingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2879:1: ( rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2880:2: rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__1__Impl_in_rule__ScannerSingleLineRule__Group_5__15811);
            rule__ScannerSingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__2_in_rule__ScannerSingleLineRule__Group_5__15814);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2887:1: rule__ScannerSingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__ScannerSingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2891:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2892:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2892:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2893:1: 'by'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,38,FOLLOW_38_in_rule__ScannerSingleLineRule__Group_5__1__Impl5842); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2906:1: rule__ScannerSingleLineRule__Group_5__2 : rule__ScannerSingleLineRule__Group_5__2__Impl ;
    public final void rule__ScannerSingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2910:1: ( rule__ScannerSingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2911:2: rule__ScannerSingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__2__Impl_in_rule__ScannerSingleLineRule__Group_5__25873);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2917:1: rule__ScannerSingleLineRule__Group_5__2__Impl : ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__ScannerSingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2921:1: ( ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2922:1: ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2922:1: ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2923:1: ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2924:1: ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2924:2: rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerSingleLineRule__Group_5__2__Impl5900);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2940:1: rule__PartitionSingleLineRule__Group__0 : rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1 ;
    public final void rule__PartitionSingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2944:1: ( rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2945:2: rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__0__Impl_in_rule__PartitionSingleLineRule__Group__05936);
            rule__PartitionSingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__1_in_rule__PartitionSingleLineRule__Group__05939);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2952:1: rule__PartitionSingleLineRule__Group__0__Impl : ( 'single-line' ) ;
    public final void rule__PartitionSingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2956:1: ( ( 'single-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2957:1: ( 'single-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2957:1: ( 'single-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2958:1: 'single-line'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__PartitionSingleLineRule__Group__0__Impl5967); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2971:1: rule__PartitionSingleLineRule__Group__1 : rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2 ;
    public final void rule__PartitionSingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2975:1: ( rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2976:2: rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__1__Impl_in_rule__PartitionSingleLineRule__Group__15998);
            rule__PartitionSingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__2_in_rule__PartitionSingleLineRule__Group__16001);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2983:1: rule__PartitionSingleLineRule__Group__1__Impl : ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2987:1: ( ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2988:1: ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2988:1: ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2989:1: ( rule__PartitionSingleLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2990:1: ( rule__PartitionSingleLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2990:2: rule__PartitionSingleLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__ParitionAssignment_1_in_rule__PartitionSingleLineRule__Group__1__Impl6028);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3000:1: rule__PartitionSingleLineRule__Group__2 : rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3 ;
    public final void rule__PartitionSingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3004:1: ( rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3005:2: rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__2__Impl_in_rule__PartitionSingleLineRule__Group__26058);
            rule__PartitionSingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__3_in_rule__PartitionSingleLineRule__Group__26061);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3012:1: rule__PartitionSingleLineRule__Group__2__Impl : ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3016:1: ( ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3017:1: ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3017:1: ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3018:1: ( rule__PartitionSingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3019:1: ( rule__PartitionSingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3019:2: rule__PartitionSingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__StartSeqAssignment_2_in_rule__PartitionSingleLineRule__Group__2__Impl6088);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3029:1: rule__PartitionSingleLineRule__Group__3 : rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4 ;
    public final void rule__PartitionSingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3033:1: ( rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3034:2: rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__3__Impl_in_rule__PartitionSingleLineRule__Group__36118);
            rule__PartitionSingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__4_in_rule__PartitionSingleLineRule__Group__36121);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3041:1: rule__PartitionSingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__PartitionSingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3045:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3046:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3046:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3047:1: '=>'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,36,FOLLOW_36_in_rule__PartitionSingleLineRule__Group__3__Impl6149); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3060:1: rule__PartitionSingleLineRule__Group__4 : rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5 ;
    public final void rule__PartitionSingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3064:1: ( rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3065:2: rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__4__Impl_in_rule__PartitionSingleLineRule__Group__46180);
            rule__PartitionSingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__5_in_rule__PartitionSingleLineRule__Group__46183);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3072:1: rule__PartitionSingleLineRule__Group__4__Impl : ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3076:1: ( ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3077:1: ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3077:1: ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3078:1: ( rule__PartitionSingleLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3079:1: ( rule__PartitionSingleLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3079:2: rule__PartitionSingleLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__EndSeqAssignment_4_in_rule__PartitionSingleLineRule__Group__4__Impl6210);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3089:1: rule__PartitionSingleLineRule__Group__5 : rule__PartitionSingleLineRule__Group__5__Impl ;
    public final void rule__PartitionSingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3093:1: ( rule__PartitionSingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3094:2: rule__PartitionSingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__5__Impl_in_rule__PartitionSingleLineRule__Group__56240);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3100:1: rule__PartitionSingleLineRule__Group__5__Impl : ( ( rule__PartitionSingleLineRule__Group_5__0 )? ) ;
    public final void rule__PartitionSingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3104:1: ( ( ( rule__PartitionSingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3105:1: ( ( rule__PartitionSingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3105:1: ( ( rule__PartitionSingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3106:1: ( rule__PartitionSingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3107:1: ( rule__PartitionSingleLineRule__Group_5__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==37) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3107:2: rule__PartitionSingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__0_in_rule__PartitionSingleLineRule__Group__5__Impl6267);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3129:1: rule__PartitionSingleLineRule__Group_5__0 : rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1 ;
    public final void rule__PartitionSingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3133:1: ( rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3134:2: rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__0__Impl_in_rule__PartitionSingleLineRule__Group_5__06310);
            rule__PartitionSingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__1_in_rule__PartitionSingleLineRule__Group_5__06313);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3141:1: rule__PartitionSingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__PartitionSingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3145:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3146:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3146:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3147:1: 'escaped'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,37,FOLLOW_37_in_rule__PartitionSingleLineRule__Group_5__0__Impl6341); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3160:1: rule__PartitionSingleLineRule__Group_5__1 : rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2 ;
    public final void rule__PartitionSingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3164:1: ( rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3165:2: rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__1__Impl_in_rule__PartitionSingleLineRule__Group_5__16372);
            rule__PartitionSingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__2_in_rule__PartitionSingleLineRule__Group_5__16375);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3172:1: rule__PartitionSingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__PartitionSingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3176:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3177:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3177:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3178:1: 'by'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,38,FOLLOW_38_in_rule__PartitionSingleLineRule__Group_5__1__Impl6403); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3191:1: rule__PartitionSingleLineRule__Group_5__2 : rule__PartitionSingleLineRule__Group_5__2__Impl ;
    public final void rule__PartitionSingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3195:1: ( rule__PartitionSingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3196:2: rule__PartitionSingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__2__Impl_in_rule__PartitionSingleLineRule__Group_5__26434);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3202:1: rule__PartitionSingleLineRule__Group_5__2__Impl : ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__PartitionSingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3206:1: ( ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3207:1: ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3207:1: ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3208:1: ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3209:1: ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3209:2: rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionSingleLineRule__Group_5__2__Impl6461);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3225:1: rule__ScannerMultiLineRule__Group__0 : rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1 ;
    public final void rule__ScannerMultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3229:1: ( rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3230:2: rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__0__Impl_in_rule__ScannerMultiLineRule__Group__06497);
            rule__ScannerMultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__1_in_rule__ScannerMultiLineRule__Group__06500);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3237:1: rule__ScannerMultiLineRule__Group__0__Impl : ( 'multi-line' ) ;
    public final void rule__ScannerMultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3241:1: ( ( 'multi-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3242:1: ( 'multi-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3242:1: ( 'multi-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3243:1: 'multi-line'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__ScannerMultiLineRule__Group__0__Impl6528); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3256:1: rule__ScannerMultiLineRule__Group__1 : rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2 ;
    public final void rule__ScannerMultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3260:1: ( rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3261:2: rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__1__Impl_in_rule__ScannerMultiLineRule__Group__16559);
            rule__ScannerMultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__2_in_rule__ScannerMultiLineRule__Group__16562);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3268:1: rule__ScannerMultiLineRule__Group__1__Impl : ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3272:1: ( ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3273:1: ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3273:1: ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3274:1: ( rule__ScannerMultiLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3275:1: ( rule__ScannerMultiLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3275:2: rule__ScannerMultiLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__TokenAssignment_1_in_rule__ScannerMultiLineRule__Group__1__Impl6589);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3285:1: rule__ScannerMultiLineRule__Group__2 : rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3 ;
    public final void rule__ScannerMultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3289:1: ( rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3290:2: rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__2__Impl_in_rule__ScannerMultiLineRule__Group__26619);
            rule__ScannerMultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__3_in_rule__ScannerMultiLineRule__Group__26622);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3297:1: rule__ScannerMultiLineRule__Group__2__Impl : ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3301:1: ( ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3302:1: ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3302:1: ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3303:1: ( rule__ScannerMultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3304:1: ( rule__ScannerMultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3304:2: rule__ScannerMultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__StartSeqAssignment_2_in_rule__ScannerMultiLineRule__Group__2__Impl6649);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3314:1: rule__ScannerMultiLineRule__Group__3 : rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4 ;
    public final void rule__ScannerMultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3318:1: ( rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3319:2: rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__3__Impl_in_rule__ScannerMultiLineRule__Group__36679);
            rule__ScannerMultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__4_in_rule__ScannerMultiLineRule__Group__36682);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3326:1: rule__ScannerMultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__ScannerMultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3330:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3331:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3331:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3332:1: '=>'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,36,FOLLOW_36_in_rule__ScannerMultiLineRule__Group__3__Impl6710); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3345:1: rule__ScannerMultiLineRule__Group__4 : rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5 ;
    public final void rule__ScannerMultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3349:1: ( rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3350:2: rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__4__Impl_in_rule__ScannerMultiLineRule__Group__46741);
            rule__ScannerMultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__5_in_rule__ScannerMultiLineRule__Group__46744);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3357:1: rule__ScannerMultiLineRule__Group__4__Impl : ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3361:1: ( ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3362:1: ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3362:1: ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3363:1: ( rule__ScannerMultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3364:1: ( rule__ScannerMultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3364:2: rule__ScannerMultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__EndSeqAssignment_4_in_rule__ScannerMultiLineRule__Group__4__Impl6771);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3374:1: rule__ScannerMultiLineRule__Group__5 : rule__ScannerMultiLineRule__Group__5__Impl ;
    public final void rule__ScannerMultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3378:1: ( rule__ScannerMultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3379:2: rule__ScannerMultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__5__Impl_in_rule__ScannerMultiLineRule__Group__56801);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3385:1: rule__ScannerMultiLineRule__Group__5__Impl : ( ( rule__ScannerMultiLineRule__Group_5__0 )? ) ;
    public final void rule__ScannerMultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3389:1: ( ( ( rule__ScannerMultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3390:1: ( ( rule__ScannerMultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3390:1: ( ( rule__ScannerMultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3391:1: ( rule__ScannerMultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3392:1: ( rule__ScannerMultiLineRule__Group_5__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==37) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3392:2: rule__ScannerMultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__0_in_rule__ScannerMultiLineRule__Group__5__Impl6828);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3414:1: rule__ScannerMultiLineRule__Group_5__0 : rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1 ;
    public final void rule__ScannerMultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3418:1: ( rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3419:2: rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__0__Impl_in_rule__ScannerMultiLineRule__Group_5__06871);
            rule__ScannerMultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__1_in_rule__ScannerMultiLineRule__Group_5__06874);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3426:1: rule__ScannerMultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__ScannerMultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3430:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3431:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3431:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3432:1: 'escaped'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,37,FOLLOW_37_in_rule__ScannerMultiLineRule__Group_5__0__Impl6902); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3445:1: rule__ScannerMultiLineRule__Group_5__1 : rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2 ;
    public final void rule__ScannerMultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3449:1: ( rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3450:2: rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__1__Impl_in_rule__ScannerMultiLineRule__Group_5__16933);
            rule__ScannerMultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__2_in_rule__ScannerMultiLineRule__Group_5__16936);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3457:1: rule__ScannerMultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__ScannerMultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3461:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3462:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3462:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3463:1: 'by'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,38,FOLLOW_38_in_rule__ScannerMultiLineRule__Group_5__1__Impl6964); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3476:1: rule__ScannerMultiLineRule__Group_5__2 : rule__ScannerMultiLineRule__Group_5__2__Impl ;
    public final void rule__ScannerMultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3480:1: ( rule__ScannerMultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3481:2: rule__ScannerMultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__2__Impl_in_rule__ScannerMultiLineRule__Group_5__26995);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3487:1: rule__ScannerMultiLineRule__Group_5__2__Impl : ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__ScannerMultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3491:1: ( ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3492:1: ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3492:1: ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3493:1: ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3494:1: ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3494:2: rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerMultiLineRule__Group_5__2__Impl7022);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3510:1: rule__PartitionMultiLineRule__Group__0 : rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1 ;
    public final void rule__PartitionMultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3514:1: ( rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3515:2: rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__0__Impl_in_rule__PartitionMultiLineRule__Group__07058);
            rule__PartitionMultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__1_in_rule__PartitionMultiLineRule__Group__07061);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3522:1: rule__PartitionMultiLineRule__Group__0__Impl : ( 'multi-line' ) ;
    public final void rule__PartitionMultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3526:1: ( ( 'multi-line' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3527:1: ( 'multi-line' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3527:1: ( 'multi-line' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3528:1: 'multi-line'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__PartitionMultiLineRule__Group__0__Impl7089); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3541:1: rule__PartitionMultiLineRule__Group__1 : rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2 ;
    public final void rule__PartitionMultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3545:1: ( rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3546:2: rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__1__Impl_in_rule__PartitionMultiLineRule__Group__17120);
            rule__PartitionMultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__2_in_rule__PartitionMultiLineRule__Group__17123);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3553:1: rule__PartitionMultiLineRule__Group__1__Impl : ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3557:1: ( ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3558:1: ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3558:1: ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3559:1: ( rule__PartitionMultiLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3560:1: ( rule__PartitionMultiLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3560:2: rule__PartitionMultiLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__ParitionAssignment_1_in_rule__PartitionMultiLineRule__Group__1__Impl7150);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3570:1: rule__PartitionMultiLineRule__Group__2 : rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3 ;
    public final void rule__PartitionMultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3574:1: ( rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3575:2: rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__2__Impl_in_rule__PartitionMultiLineRule__Group__27180);
            rule__PartitionMultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__3_in_rule__PartitionMultiLineRule__Group__27183);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3582:1: rule__PartitionMultiLineRule__Group__2__Impl : ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3586:1: ( ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3587:1: ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3587:1: ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3588:1: ( rule__PartitionMultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3589:1: ( rule__PartitionMultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3589:2: rule__PartitionMultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__StartSeqAssignment_2_in_rule__PartitionMultiLineRule__Group__2__Impl7210);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3599:1: rule__PartitionMultiLineRule__Group__3 : rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4 ;
    public final void rule__PartitionMultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3603:1: ( rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3604:2: rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__3__Impl_in_rule__PartitionMultiLineRule__Group__37240);
            rule__PartitionMultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__4_in_rule__PartitionMultiLineRule__Group__37243);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3611:1: rule__PartitionMultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__PartitionMultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3615:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3616:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3616:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3617:1: '=>'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,36,FOLLOW_36_in_rule__PartitionMultiLineRule__Group__3__Impl7271); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3630:1: rule__PartitionMultiLineRule__Group__4 : rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5 ;
    public final void rule__PartitionMultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3634:1: ( rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3635:2: rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__4__Impl_in_rule__PartitionMultiLineRule__Group__47302);
            rule__PartitionMultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__5_in_rule__PartitionMultiLineRule__Group__47305);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3642:1: rule__PartitionMultiLineRule__Group__4__Impl : ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3646:1: ( ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3647:1: ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3647:1: ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3648:1: ( rule__PartitionMultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3649:1: ( rule__PartitionMultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3649:2: rule__PartitionMultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__EndSeqAssignment_4_in_rule__PartitionMultiLineRule__Group__4__Impl7332);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3659:1: rule__PartitionMultiLineRule__Group__5 : rule__PartitionMultiLineRule__Group__5__Impl ;
    public final void rule__PartitionMultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3663:1: ( rule__PartitionMultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3664:2: rule__PartitionMultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__5__Impl_in_rule__PartitionMultiLineRule__Group__57362);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3670:1: rule__PartitionMultiLineRule__Group__5__Impl : ( ( rule__PartitionMultiLineRule__Group_5__0 )? ) ;
    public final void rule__PartitionMultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3674:1: ( ( ( rule__PartitionMultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3675:1: ( ( rule__PartitionMultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3675:1: ( ( rule__PartitionMultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3676:1: ( rule__PartitionMultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3677:1: ( rule__PartitionMultiLineRule__Group_5__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==37) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3677:2: rule__PartitionMultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__0_in_rule__PartitionMultiLineRule__Group__5__Impl7389);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3699:1: rule__PartitionMultiLineRule__Group_5__0 : rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1 ;
    public final void rule__PartitionMultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3703:1: ( rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3704:2: rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__0__Impl_in_rule__PartitionMultiLineRule__Group_5__07432);
            rule__PartitionMultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__1_in_rule__PartitionMultiLineRule__Group_5__07435);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3711:1: rule__PartitionMultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__PartitionMultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3715:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3716:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3716:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3717:1: 'escaped'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,37,FOLLOW_37_in_rule__PartitionMultiLineRule__Group_5__0__Impl7463); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3730:1: rule__PartitionMultiLineRule__Group_5__1 : rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2 ;
    public final void rule__PartitionMultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3734:1: ( rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3735:2: rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__1__Impl_in_rule__PartitionMultiLineRule__Group_5__17494);
            rule__PartitionMultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__2_in_rule__PartitionMultiLineRule__Group_5__17497);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3742:1: rule__PartitionMultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__PartitionMultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3746:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3747:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3747:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3748:1: 'by'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,38,FOLLOW_38_in_rule__PartitionMultiLineRule__Group_5__1__Impl7525); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3761:1: rule__PartitionMultiLineRule__Group_5__2 : rule__PartitionMultiLineRule__Group_5__2__Impl ;
    public final void rule__PartitionMultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3765:1: ( rule__PartitionMultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3766:2: rule__PartitionMultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__2__Impl_in_rule__PartitionMultiLineRule__Group_5__27556);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3772:1: rule__PartitionMultiLineRule__Group_5__2__Impl : ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__PartitionMultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3776:1: ( ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3777:1: ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3777:1: ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3778:1: ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3779:1: ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3779:2: rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionMultiLineRule__Group_5__2__Impl7583);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3795:1: rule__ScannerCharacterRule__Group__0 : rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1 ;
    public final void rule__ScannerCharacterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3799:1: ( rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3800:2: rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__0__Impl_in_rule__ScannerCharacterRule__Group__07619);
            rule__ScannerCharacterRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__1_in_rule__ScannerCharacterRule__Group__07622);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3807:1: rule__ScannerCharacterRule__Group__0__Impl : ( 'character-rule' ) ;
    public final void rule__ScannerCharacterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3811:1: ( ( 'character-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3812:1: ( 'character-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3812:1: ( 'character-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3813:1: 'character-rule'
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__ScannerCharacterRule__Group__0__Impl7650); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3826:1: rule__ScannerCharacterRule__Group__1 : rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2 ;
    public final void rule__ScannerCharacterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3830:1: ( rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3831:2: rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__1__Impl_in_rule__ScannerCharacterRule__Group__17681);
            rule__ScannerCharacterRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__2_in_rule__ScannerCharacterRule__Group__17684);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3838:1: rule__ScannerCharacterRule__Group__1__Impl : ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerCharacterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3842:1: ( ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3843:1: ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3843:1: ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3844:1: ( rule__ScannerCharacterRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3845:1: ( rule__ScannerCharacterRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3845:2: rule__ScannerCharacterRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__TokenAssignment_1_in_rule__ScannerCharacterRule__Group__1__Impl7711);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3855:1: rule__ScannerCharacterRule__Group__2 : rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3 ;
    public final void rule__ScannerCharacterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3859:1: ( rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3860:2: rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__2__Impl_in_rule__ScannerCharacterRule__Group__27741);
            rule__ScannerCharacterRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__3_in_rule__ScannerCharacterRule__Group__27744);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3867:1: rule__ScannerCharacterRule__Group__2__Impl : ( '[' ) ;
    public final void rule__ScannerCharacterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3871:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3872:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3872:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3873:1: '['
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2()); 
            match(input,31,FOLLOW_31_in_rule__ScannerCharacterRule__Group__2__Impl7772); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3886:1: rule__ScannerCharacterRule__Group__3 : rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4 ;
    public final void rule__ScannerCharacterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3890:1: ( rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3891:2: rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__3__Impl_in_rule__ScannerCharacterRule__Group__37803);
            rule__ScannerCharacterRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__4_in_rule__ScannerCharacterRule__Group__37806);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3898:1: rule__ScannerCharacterRule__Group__3__Impl : ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) ) ;
    public final void rule__ScannerCharacterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3902:1: ( ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3903:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3903:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3904:1: ( rule__ScannerCharacterRule__CharactersAssignment_3 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3905:1: ( rule__ScannerCharacterRule__CharactersAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3905:2: rule__ScannerCharacterRule__CharactersAssignment_3
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_3_in_rule__ScannerCharacterRule__Group__3__Impl7833);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3915:1: rule__ScannerCharacterRule__Group__4 : rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5 ;
    public final void rule__ScannerCharacterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3919:1: ( rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3920:2: rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__4__Impl_in_rule__ScannerCharacterRule__Group__47863);
            rule__ScannerCharacterRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__5_in_rule__ScannerCharacterRule__Group__47866);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3927:1: rule__ScannerCharacterRule__Group__4__Impl : ( ( rule__ScannerCharacterRule__Group_4__0 )* ) ;
    public final void rule__ScannerCharacterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3931:1: ( ( ( rule__ScannerCharacterRule__Group_4__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3932:1: ( ( rule__ScannerCharacterRule__Group_4__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3932:1: ( ( rule__ScannerCharacterRule__Group_4__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3933:1: ( rule__ScannerCharacterRule__Group_4__0 )*
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getGroup_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3934:1: ( rule__ScannerCharacterRule__Group_4__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==33) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3934:2: rule__ScannerCharacterRule__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__0_in_rule__ScannerCharacterRule__Group__4__Impl7893);
            	    rule__ScannerCharacterRule__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3944:1: rule__ScannerCharacterRule__Group__5 : rule__ScannerCharacterRule__Group__5__Impl ;
    public final void rule__ScannerCharacterRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3948:1: ( rule__ScannerCharacterRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3949:2: rule__ScannerCharacterRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__5__Impl_in_rule__ScannerCharacterRule__Group__57924);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3955:1: rule__ScannerCharacterRule__Group__5__Impl : ( ']' ) ;
    public final void rule__ScannerCharacterRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3959:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3960:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3960:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3961:1: ']'
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getRightSquareBracketKeyword_5()); 
            match(input,32,FOLLOW_32_in_rule__ScannerCharacterRule__Group__5__Impl7952); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3986:1: rule__ScannerCharacterRule__Group_4__0 : rule__ScannerCharacterRule__Group_4__0__Impl rule__ScannerCharacterRule__Group_4__1 ;
    public final void rule__ScannerCharacterRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3990:1: ( rule__ScannerCharacterRule__Group_4__0__Impl rule__ScannerCharacterRule__Group_4__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3991:2: rule__ScannerCharacterRule__Group_4__0__Impl rule__ScannerCharacterRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__0__Impl_in_rule__ScannerCharacterRule__Group_4__07995);
            rule__ScannerCharacterRule__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__1_in_rule__ScannerCharacterRule__Group_4__07998);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3998:1: rule__ScannerCharacterRule__Group_4__0__Impl : ( ',' ) ;
    public final void rule__ScannerCharacterRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4002:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4003:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4003:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4004:1: ','
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4_0()); 
            match(input,33,FOLLOW_33_in_rule__ScannerCharacterRule__Group_4__0__Impl8026); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4017:1: rule__ScannerCharacterRule__Group_4__1 : rule__ScannerCharacterRule__Group_4__1__Impl ;
    public final void rule__ScannerCharacterRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4021:1: ( rule__ScannerCharacterRule__Group_4__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4022:2: rule__ScannerCharacterRule__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__1__Impl_in_rule__ScannerCharacterRule__Group_4__18057);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4028:1: rule__ScannerCharacterRule__Group_4__1__Impl : ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) ) ;
    public final void rule__ScannerCharacterRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4032:1: ( ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4033:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4033:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4034:1: ( rule__ScannerCharacterRule__CharactersAssignment_4_1 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_4_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4035:1: ( rule__ScannerCharacterRule__CharactersAssignment_4_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4035:2: rule__ScannerCharacterRule__CharactersAssignment_4_1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_4_1_in_rule__ScannerCharacterRule__Group_4__1__Impl8084);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4049:1: rule__ScannerJSRule__Group__0 : rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1 ;
    public final void rule__ScannerJSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4053:1: ( rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4054:2: rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__0__Impl_in_rule__ScannerJSRule__Group__08118);
            rule__ScannerJSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerJSRule__Group__1_in_rule__ScannerJSRule__Group__08121);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4061:1: rule__ScannerJSRule__Group__0__Impl : ( 'javascript-rule' ) ;
    public final void rule__ScannerJSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4065:1: ( ( 'javascript-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4066:1: ( 'javascript-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4066:1: ( 'javascript-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4067:1: 'javascript-rule'
            {
             before(grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0()); 
            match(input,41,FOLLOW_41_in_rule__ScannerJSRule__Group__0__Impl8149); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4080:1: rule__ScannerJSRule__Group__1 : rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2 ;
    public final void rule__ScannerJSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4084:1: ( rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4085:2: rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__1__Impl_in_rule__ScannerJSRule__Group__18180);
            rule__ScannerJSRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerJSRule__Group__2_in_rule__ScannerJSRule__Group__18183);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4092:1: rule__ScannerJSRule__Group__1__Impl : ( ( rule__ScannerJSRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerJSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4096:1: ( ( ( rule__ScannerJSRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4097:1: ( ( rule__ScannerJSRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4097:1: ( ( rule__ScannerJSRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4098:1: ( rule__ScannerJSRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4099:1: ( rule__ScannerJSRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4099:2: rule__ScannerJSRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__TokenAssignment_1_in_rule__ScannerJSRule__Group__1__Impl8210);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4109:1: rule__ScannerJSRule__Group__2 : rule__ScannerJSRule__Group__2__Impl ;
    public final void rule__ScannerJSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4113:1: ( rule__ScannerJSRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4114:2: rule__ScannerJSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__2__Impl_in_rule__ScannerJSRule__Group__28240);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4120:1: rule__ScannerJSRule__Group__2__Impl : ( ( rule__ScannerJSRule__FileURIAssignment_2 ) ) ;
    public final void rule__ScannerJSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4124:1: ( ( ( rule__ScannerJSRule__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4125:1: ( ( rule__ScannerJSRule__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4125:1: ( ( rule__ScannerJSRule__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4126:1: ( rule__ScannerJSRule__FileURIAssignment_2 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4127:1: ( rule__ScannerJSRule__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4127:2: rule__ScannerJSRule__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__FileURIAssignment_2_in_rule__ScannerJSRule__Group__2__Impl8267);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4143:1: rule__PartitionJSRule__Group__0 : rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1 ;
    public final void rule__PartitionJSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4147:1: ( rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4148:2: rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__0__Impl_in_rule__PartitionJSRule__Group__08303);
            rule__PartitionJSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionJSRule__Group__1_in_rule__PartitionJSRule__Group__08306);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4155:1: rule__PartitionJSRule__Group__0__Impl : ( 'javascript-rule' ) ;
    public final void rule__PartitionJSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4159:1: ( ( 'javascript-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4160:1: ( 'javascript-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4160:1: ( 'javascript-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4161:1: 'javascript-rule'
            {
             before(grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0()); 
            match(input,41,FOLLOW_41_in_rule__PartitionJSRule__Group__0__Impl8334); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4174:1: rule__PartitionJSRule__Group__1 : rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2 ;
    public final void rule__PartitionJSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4178:1: ( rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4179:2: rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__1__Impl_in_rule__PartitionJSRule__Group__18365);
            rule__PartitionJSRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionJSRule__Group__2_in_rule__PartitionJSRule__Group__18368);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4186:1: rule__PartitionJSRule__Group__1__Impl : ( ( rule__PartitionJSRule__TokenAssignment_1 ) ) ;
    public final void rule__PartitionJSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4190:1: ( ( ( rule__PartitionJSRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4191:1: ( ( rule__PartitionJSRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4191:1: ( ( rule__PartitionJSRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4192:1: ( rule__PartitionJSRule__TokenAssignment_1 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4193:1: ( rule__PartitionJSRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4193:2: rule__PartitionJSRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__TokenAssignment_1_in_rule__PartitionJSRule__Group__1__Impl8395);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4203:1: rule__PartitionJSRule__Group__2 : rule__PartitionJSRule__Group__2__Impl ;
    public final void rule__PartitionJSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4207:1: ( rule__PartitionJSRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4208:2: rule__PartitionJSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__2__Impl_in_rule__PartitionJSRule__Group__28425);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4214:1: rule__PartitionJSRule__Group__2__Impl : ( ( rule__PartitionJSRule__FileURIAssignment_2 ) ) ;
    public final void rule__PartitionJSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4218:1: ( ( ( rule__PartitionJSRule__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4219:1: ( ( rule__PartitionJSRule__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4219:1: ( ( rule__PartitionJSRule__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4220:1: ( rule__PartitionJSRule__FileURIAssignment_2 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4221:1: ( rule__PartitionJSRule__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4221:2: rule__PartitionJSRule__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__FileURIAssignment_2_in_rule__PartitionJSRule__Group__2__Impl8452);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4237:1: rule__ScannerWhitespaceRule__Group__0 : rule__ScannerWhitespaceRule__Group__0__Impl rule__ScannerWhitespaceRule__Group__1 ;
    public final void rule__ScannerWhitespaceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4241:1: ( rule__ScannerWhitespaceRule__Group__0__Impl rule__ScannerWhitespaceRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4242:2: rule__ScannerWhitespaceRule__Group__0__Impl rule__ScannerWhitespaceRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__0__Impl_in_rule__ScannerWhitespaceRule__Group__08488);
            rule__ScannerWhitespaceRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__1_in_rule__ScannerWhitespaceRule__Group__08491);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4249:1: rule__ScannerWhitespaceRule__Group__0__Impl : ( 'whitespace-rule' ) ;
    public final void rule__ScannerWhitespaceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4253:1: ( ( 'whitespace-rule' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4254:1: ( 'whitespace-rule' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4254:1: ( 'whitespace-rule' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4255:1: 'whitespace-rule'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0()); 
            match(input,42,FOLLOW_42_in_rule__ScannerWhitespaceRule__Group__0__Impl8519); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4268:1: rule__ScannerWhitespaceRule__Group__1 : rule__ScannerWhitespaceRule__Group__1__Impl rule__ScannerWhitespaceRule__Group__2 ;
    public final void rule__ScannerWhitespaceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4272:1: ( rule__ScannerWhitespaceRule__Group__1__Impl rule__ScannerWhitespaceRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4273:2: rule__ScannerWhitespaceRule__Group__1__Impl rule__ScannerWhitespaceRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__1__Impl_in_rule__ScannerWhitespaceRule__Group__18550);
            rule__ScannerWhitespaceRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__2_in_rule__ScannerWhitespaceRule__Group__18553);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4280:1: rule__ScannerWhitespaceRule__Group__1__Impl : ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? ) ;
    public final void rule__ScannerWhitespaceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4284:1: ( ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4285:1: ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4285:1: ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4286:1: ( rule__ScannerWhitespaceRule__TokenAssignment_1 )?
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4287:1: ( rule__ScannerWhitespaceRule__TokenAssignment_1 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4287:2: rule__ScannerWhitespaceRule__TokenAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__TokenAssignment_1_in_rule__ScannerWhitespaceRule__Group__1__Impl8580);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4297:1: rule__ScannerWhitespaceRule__Group__2 : rule__ScannerWhitespaceRule__Group__2__Impl ;
    public final void rule__ScannerWhitespaceRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4301:1: ( rule__ScannerWhitespaceRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4302:2: rule__ScannerWhitespaceRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__2__Impl_in_rule__ScannerWhitespaceRule__Group__28611);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4308:1: rule__ScannerWhitespaceRule__Group__2__Impl : ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4312:1: ( ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4313:1: ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4313:1: ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4314:1: ( rule__ScannerWhitespaceRule__Alternatives_2 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getAlternatives_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4315:1: ( rule__ScannerWhitespaceRule__Alternatives_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4315:2: rule__ScannerWhitespaceRule__Alternatives_2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Alternatives_2_in_rule__ScannerWhitespaceRule__Group__2__Impl8638);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4331:1: rule__ScannerWhitespaceRule__Group_2_0__0 : rule__ScannerWhitespaceRule__Group_2_0__0__Impl rule__ScannerWhitespaceRule__Group_2_0__1 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4335:1: ( rule__ScannerWhitespaceRule__Group_2_0__0__Impl rule__ScannerWhitespaceRule__Group_2_0__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4336:2: rule__ScannerWhitespaceRule__Group_2_0__0__Impl rule__ScannerWhitespaceRule__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__08674);
            rule__ScannerWhitespaceRule__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1_in_rule__ScannerWhitespaceRule__Group_2_0__08677);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4343:1: rule__ScannerWhitespaceRule__Group_2_0__0__Impl : ( '[' ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4347:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4348:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4348:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4349:1: '['
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_2_0_0()); 
            match(input,31,FOLLOW_31_in_rule__ScannerWhitespaceRule__Group_2_0__0__Impl8705); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4362:1: rule__ScannerWhitespaceRule__Group_2_0__1 : rule__ScannerWhitespaceRule__Group_2_0__1__Impl rule__ScannerWhitespaceRule__Group_2_0__2 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4366:1: ( rule__ScannerWhitespaceRule__Group_2_0__1__Impl rule__ScannerWhitespaceRule__Group_2_0__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4367:2: rule__ScannerWhitespaceRule__Group_2_0__1__Impl rule__ScannerWhitespaceRule__Group_2_0__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__18736);
            rule__ScannerWhitespaceRule__Group_2_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2_in_rule__ScannerWhitespaceRule__Group_2_0__18739);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4374:1: rule__ScannerWhitespaceRule__Group_2_0__1__Impl : ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4378:1: ( ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4379:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4379:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4380:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_2_0_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4381:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4381:2: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1_in_rule__ScannerWhitespaceRule__Group_2_0__1__Impl8766);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4391:1: rule__ScannerWhitespaceRule__Group_2_0__2 : rule__ScannerWhitespaceRule__Group_2_0__2__Impl rule__ScannerWhitespaceRule__Group_2_0__3 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4395:1: ( rule__ScannerWhitespaceRule__Group_2_0__2__Impl rule__ScannerWhitespaceRule__Group_2_0__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4396:2: rule__ScannerWhitespaceRule__Group_2_0__2__Impl rule__ScannerWhitespaceRule__Group_2_0__3
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__28796);
            rule__ScannerWhitespaceRule__Group_2_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3_in_rule__ScannerWhitespaceRule__Group_2_0__28799);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4403:1: rule__ScannerWhitespaceRule__Group_2_0__2__Impl : ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4407:1: ( ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4408:1: ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4408:1: ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4409:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )*
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_2_0_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4410:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==33) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4410:2: rule__ScannerWhitespaceRule__Group_2_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0_in_rule__ScannerWhitespaceRule__Group_2_0__2__Impl8826);
            	    rule__ScannerWhitespaceRule__Group_2_0_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4420:1: rule__ScannerWhitespaceRule__Group_2_0__3 : rule__ScannerWhitespaceRule__Group_2_0__3__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4424:1: ( rule__ScannerWhitespaceRule__Group_2_0__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4425:2: rule__ScannerWhitespaceRule__Group_2_0__3__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__38857);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4431:1: rule__ScannerWhitespaceRule__Group_2_0__3__Impl : ( ']' ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4435:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4436:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4436:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4437:1: ']'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_2_0_3()); 
            match(input,32,FOLLOW_32_in_rule__ScannerWhitespaceRule__Group_2_0__3__Impl8885); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4458:1: rule__ScannerWhitespaceRule__Group_2_0_2__0 : rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl rule__ScannerWhitespaceRule__Group_2_0_2__1 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4462:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl rule__ScannerWhitespaceRule__Group_2_0_2__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4463:2: rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl rule__ScannerWhitespaceRule__Group_2_0_2__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__08924);
            rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1_in_rule__ScannerWhitespaceRule__Group_2_0_2__08927);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4470:1: rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl : ( ',' ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4474:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4475:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4475:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4476:1: ','
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_2_0_2_0()); 
            match(input,33,FOLLOW_33_in_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl8955); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4489:1: rule__ScannerWhitespaceRule__Group_2_0_2__1 : rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4493:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4494:2: rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__18986);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4500:1: rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl : ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4504:1: ( ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4505:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4505:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4506:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_2_0_2_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4507:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4507:2: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1_in_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl9013);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4521:1: rule__RGBColor__Group__0 : rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1 ;
    public final void rule__RGBColor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4525:1: ( rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4526:2: rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__0__Impl_in_rule__RGBColor__Group__09047);
            rule__RGBColor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__1_in_rule__RGBColor__Group__09050);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4533:1: rule__RGBColor__Group__0__Impl : ( 'rgb' ) ;
    public final void rule__RGBColor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4537:1: ( ( 'rgb' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4538:1: ( 'rgb' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4538:1: ( 'rgb' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4539:1: 'rgb'
            {
             before(grammarAccess.getRGBColorAccess().getRgbKeyword_0()); 
            match(input,43,FOLLOW_43_in_rule__RGBColor__Group__0__Impl9078); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4552:1: rule__RGBColor__Group__1 : rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2 ;
    public final void rule__RGBColor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4556:1: ( rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4557:2: rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__1__Impl_in_rule__RGBColor__Group__19109);
            rule__RGBColor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__2_in_rule__RGBColor__Group__19112);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4564:1: rule__RGBColor__Group__1__Impl : ( '(' ) ;
    public final void rule__RGBColor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4568:1: ( ( '(' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4569:1: ( '(' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4569:1: ( '(' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4570:1: '('
            {
             before(grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__RGBColor__Group__1__Impl9140); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4583:1: rule__RGBColor__Group__2 : rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3 ;
    public final void rule__RGBColor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4587:1: ( rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4588:2: rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__2__Impl_in_rule__RGBColor__Group__29171);
            rule__RGBColor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__3_in_rule__RGBColor__Group__29174);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4595:1: rule__RGBColor__Group__2__Impl : ( ( rule__RGBColor__RAssignment_2 ) ) ;
    public final void rule__RGBColor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4599:1: ( ( ( rule__RGBColor__RAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4600:1: ( ( rule__RGBColor__RAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4600:1: ( ( rule__RGBColor__RAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4601:1: ( rule__RGBColor__RAssignment_2 )
            {
             before(grammarAccess.getRGBColorAccess().getRAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4602:1: ( rule__RGBColor__RAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4602:2: rule__RGBColor__RAssignment_2
            {
            pushFollow(FOLLOW_rule__RGBColor__RAssignment_2_in_rule__RGBColor__Group__2__Impl9201);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4612:1: rule__RGBColor__Group__3 : rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4 ;
    public final void rule__RGBColor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4616:1: ( rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4617:2: rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__3__Impl_in_rule__RGBColor__Group__39231);
            rule__RGBColor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__4_in_rule__RGBColor__Group__39234);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4624:1: rule__RGBColor__Group__3__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4628:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4629:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4629:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4630:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_3()); 
            match(input,33,FOLLOW_33_in_rule__RGBColor__Group__3__Impl9262); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4643:1: rule__RGBColor__Group__4 : rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5 ;
    public final void rule__RGBColor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4647:1: ( rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4648:2: rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__4__Impl_in_rule__RGBColor__Group__49293);
            rule__RGBColor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__5_in_rule__RGBColor__Group__49296);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4655:1: rule__RGBColor__Group__4__Impl : ( ( rule__RGBColor__GAssignment_4 ) ) ;
    public final void rule__RGBColor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4659:1: ( ( ( rule__RGBColor__GAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4660:1: ( ( rule__RGBColor__GAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4660:1: ( ( rule__RGBColor__GAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4661:1: ( rule__RGBColor__GAssignment_4 )
            {
             before(grammarAccess.getRGBColorAccess().getGAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4662:1: ( rule__RGBColor__GAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4662:2: rule__RGBColor__GAssignment_4
            {
            pushFollow(FOLLOW_rule__RGBColor__GAssignment_4_in_rule__RGBColor__Group__4__Impl9323);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4672:1: rule__RGBColor__Group__5 : rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6 ;
    public final void rule__RGBColor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4676:1: ( rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4677:2: rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__5__Impl_in_rule__RGBColor__Group__59353);
            rule__RGBColor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__6_in_rule__RGBColor__Group__59356);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4684:1: rule__RGBColor__Group__5__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4688:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4689:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4689:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4690:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_5()); 
            match(input,33,FOLLOW_33_in_rule__RGBColor__Group__5__Impl9384); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4703:1: rule__RGBColor__Group__6 : rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7 ;
    public final void rule__RGBColor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4707:1: ( rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4708:2: rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__6__Impl_in_rule__RGBColor__Group__69415);
            rule__RGBColor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__7_in_rule__RGBColor__Group__69418);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4715:1: rule__RGBColor__Group__6__Impl : ( ( rule__RGBColor__BAssignment_6 ) ) ;
    public final void rule__RGBColor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4719:1: ( ( ( rule__RGBColor__BAssignment_6 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4720:1: ( ( rule__RGBColor__BAssignment_6 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4720:1: ( ( rule__RGBColor__BAssignment_6 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4721:1: ( rule__RGBColor__BAssignment_6 )
            {
             before(grammarAccess.getRGBColorAccess().getBAssignment_6()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4722:1: ( rule__RGBColor__BAssignment_6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4722:2: rule__RGBColor__BAssignment_6
            {
            pushFollow(FOLLOW_rule__RGBColor__BAssignment_6_in_rule__RGBColor__Group__6__Impl9445);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4732:1: rule__RGBColor__Group__7 : rule__RGBColor__Group__7__Impl ;
    public final void rule__RGBColor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4736:1: ( rule__RGBColor__Group__7__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4737:2: rule__RGBColor__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__7__Impl_in_rule__RGBColor__Group__79475);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4743:1: rule__RGBColor__Group__7__Impl : ( ')' ) ;
    public final void rule__RGBColor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4747:1: ( ( ')' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4748:1: ( ')' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4748:1: ( ')' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4749:1: ')'
            {
             before(grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_7()); 
            match(input,45,FOLLOW_45_in_rule__RGBColor__Group__7__Impl9503); 
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


    // $ANTLR start "rule__Model__NameAssignment_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4780:1: rule__Model__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4784:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4785:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4785:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4786:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Model__NameAssignment_09556); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4795:1: rule__Model__PartitionsAssignment_2 : ( rulePartition ) ;
    public final void rule__Model__PartitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4799:1: ( ( rulePartition ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4800:1: ( rulePartition )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4800:1: ( rulePartition )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4801:1: rulePartition
            {
             before(grammarAccess.getModelAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_rulePartition_in_rule__Model__PartitionsAssignment_29587);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4810:1: rule__Model__DamagersAssignment_3 : ( ruleDamager ) ;
    public final void rule__Model__DamagersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4814:1: ( ( ruleDamager ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4815:1: ( ruleDamager )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4815:1: ( ruleDamager )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4816:1: ruleDamager
            {
             before(grammarAccess.getModelAccess().getDamagersDamagerParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDamager_in_rule__Model__DamagersAssignment_39618);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4825:1: rule__Model__PartitionerAssignment_4 : ( rulePartitioner ) ;
    public final void rule__Model__PartitionerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4829:1: ( ( rulePartitioner ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4830:1: ( rulePartitioner )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4830:1: ( rulePartitioner )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4831:1: rulePartitioner
            {
             before(grammarAccess.getModelAccess().getPartitionerPartitionerParserRuleCall_4_0()); 
            pushFollow(FOLLOW_rulePartitioner_in_rule__Model__PartitionerAssignment_49649);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4840:1: rule__Model__ContentTypesAssignment_7 : ( RULE_STRING ) ;
    public final void rule__Model__ContentTypesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4844:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4845:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4845:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4846:1: RULE_STRING
            {
             before(grammarAccess.getModelAccess().getContentTypesSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Model__ContentTypesAssignment_79680); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4855:1: rule__Partition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Partition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4859:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4860:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4860:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4861:1: RULE_ID
            {
             before(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_19711); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4870:1: rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4874:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4875:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4875:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4876:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionPartitionCrossReference_3_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4877:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4878:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionPartitionIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_39746); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4889:1: rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4893:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4894:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4894:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4895:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionPartitionCrossReference_5_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4896:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4897:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionPartitionIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_59785); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4908:1: rule__JavaLikeParitioner__JavaDocParitionAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__JavaDocParitionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4912:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4913:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4913:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4914:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionCrossReference_7_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4915:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4916:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__JavaDocParitionAssignment_79824); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4927:1: rule__JavaLikeParitioner__CharacterParitionAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__CharacterParitionAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4931:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4932:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4932:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4933:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionCrossReference_9_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4934:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4935:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__CharacterParitionAssignment_99863); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4946:1: rule__JavaLikeParitioner__StringParitionAssignment_11 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__StringParitionAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4950:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4951:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4951:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4952:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionCrossReference_11_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4953:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4954:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionIDTerminalRuleCall_11_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__StringParitionAssignment_119902); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4965:1: rule__RulePartitioner__RulesAssignment_2 : ( ruleParitionRule ) ;
    public final void rule__RulePartitioner__RulesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4969:1: ( ( ruleParitionRule ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4970:1: ( ruleParitionRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4970:1: ( ruleParitionRule )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4971:1: ruleParitionRule
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesParitionRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParitionRule_in_rule__RulePartitioner__RulesAssignment_29937);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4980:1: rule__JSParitioner__FileURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JSParitioner__FileURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4984:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4985:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4985:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4986:1: RULE_STRING
            {
             before(grammarAccess.getJSParitionerAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JSParitioner__FileURIAssignment_19968); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4995:1: rule__JSDamager__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__JSDamager__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4999:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5000:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5000:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5001:1: ( RULE_ID )
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5002:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5003:1: RULE_ID
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JSDamager__PartitionAssignment_110003); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5014:1: rule__JSDamager__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__JSDamager__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5018:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5019:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5019:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5020:1: RULE_STRING
            {
             before(grammarAccess.getJSDamagerAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JSDamager__FileURIAssignment_210038); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5029:1: rule__RuleDamager__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__RuleDamager__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5033:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5034:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5034:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5035:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5036:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5037:1: RULE_ID
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RuleDamager__PartitionAssignment_110073); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5048:1: rule__RuleDamager__TokensAssignment_3 : ( ruleScannerToken ) ;
    public final void rule__RuleDamager__TokensAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5052:1: ( ( ruleScannerToken ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5053:1: ( ruleScannerToken )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5053:1: ( ruleScannerToken )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5054:1: ruleScannerToken
            {
             before(grammarAccess.getRuleDamagerAccess().getTokensScannerTokenParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleScannerToken_in_rule__RuleDamager__TokensAssignment_310108);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5063:1: rule__RuleDamager__KeywordGroupsAssignment_4 : ( ruleKeywordGroup ) ;
    public final void rule__RuleDamager__KeywordGroupsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5067:1: ( ( ruleKeywordGroup ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5068:1: ( ruleKeywordGroup )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5068:1: ( ruleKeywordGroup )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5069:1: ruleKeywordGroup
            {
             before(grammarAccess.getRuleDamagerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_rule__RuleDamager__KeywordGroupsAssignment_410139);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5078:1: rule__RuleDamager__RulesAssignment_5 : ( ruleScannerRule ) ;
    public final void rule__RuleDamager__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5082:1: ( ( ruleScannerRule ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5083:1: ( ruleScannerRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5083:1: ( ruleScannerRule )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5084:1: ruleScannerRule
            {
             before(grammarAccess.getRuleDamagerAccess().getRulesScannerRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleScannerRule_in_rule__RuleDamager__RulesAssignment_510170);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5093:1: rule__ScannerToken__DefaultAssignment_0 : ( ( 'default' ) ) ;
    public final void rule__ScannerToken__DefaultAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5097:1: ( ( ( 'default' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5098:1: ( ( 'default' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5098:1: ( ( 'default' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5099:1: ( 'default' )
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5100:1: ( 'default' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5101:1: 'default'
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 
            match(input,46,FOLLOW_46_in_rule__ScannerToken__DefaultAssignment_010206); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5116:1: rule__ScannerToken__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ScannerToken__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5120:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5121:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5121:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5122:1: RULE_ID
            {
             before(grammarAccess.getScannerTokenAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerToken__NameAssignment_210245); 
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


    // $ANTLR start "rule__KeywordGroup__TokenAssignment_1"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5131:1: rule__KeywordGroup__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__KeywordGroup__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5135:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5136:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5136:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5137:1: ( RULE_ID )
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5138:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5139:1: RULE_ID
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeywordGroup__TokenAssignment_110280); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5150:1: rule__KeywordGroup__KeywordsAssignment_3 : ( ruleKeyword ) ;
    public final void rule__KeywordGroup__KeywordsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5154:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5155:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5155:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5156:1: ruleKeyword
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_310315);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5165:1: rule__KeywordGroup__KeywordsAssignment_4_1 : ( ruleKeyword ) ;
    public final void rule__KeywordGroup__KeywordsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5169:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5170:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5170:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5171:1: ruleKeyword
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_4_110346);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5180:1: rule__Keyword__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Keyword__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5184:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5185:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5185:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5186:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_010377); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5195:1: rule__Keyword__VersionAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Keyword__VersionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5199:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5200:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5200:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5201:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_110408); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5210:1: rule__ScannerSingleLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerSingleLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5214:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5215:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5215:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5216:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5217:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5218:1: RULE_ID
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerSingleLineRule__TokenAssignment_110443); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5229:1: rule__ScannerSingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5233:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5234:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5234:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5235:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__StartSeqAssignment_210478); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5244:1: rule__ScannerSingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5248:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5249:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5249:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5250:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EndSeqAssignment_410509); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5259:1: rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5263:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5264:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5264:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5265:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_210540); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5274:1: rule__PartitionSingleLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionSingleLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5278:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5279:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5279:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5280:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5281:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5282:1: RULE_ID
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionSingleLineRule__ParitionAssignment_110575); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5293:1: rule__PartitionSingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5297:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5298:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5298:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5299:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__StartSeqAssignment_210610); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5308:1: rule__PartitionSingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5312:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5313:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5313:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5314:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EndSeqAssignment_410641); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5323:1: rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5327:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5328:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5328:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5329:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_210672); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5338:1: rule__ScannerMultiLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerMultiLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5342:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5343:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5343:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5344:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5345:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5346:1: RULE_ID
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerMultiLineRule__TokenAssignment_110707); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5357:1: rule__ScannerMultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5361:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5362:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5362:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5363:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__StartSeqAssignment_210742); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5372:1: rule__ScannerMultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5376:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5377:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5377:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5378:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EndSeqAssignment_410773); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5387:1: rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5391:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5392:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5392:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5393:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_210804); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5402:1: rule__PartitionMultiLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionMultiLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5406:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5407:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5407:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5408:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5409:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5410:1: RULE_ID
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionMultiLineRule__ParitionAssignment_110839); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5421:1: rule__PartitionMultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5425:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5426:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5426:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5427:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__StartSeqAssignment_210874); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5436:1: rule__PartitionMultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5440:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5441:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5441:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5442:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EndSeqAssignment_410905); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5451:1: rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5455:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5456:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5456:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5457:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_210936); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5466:1: rule__ScannerCharacterRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerCharacterRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5470:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5471:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5471:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5472:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5473:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5474:1: RULE_ID
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerCharacterRule__TokenAssignment_110971); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5485:1: rule__ScannerCharacterRule__CharactersAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ScannerCharacterRule__CharactersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5489:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5490:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5490:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5491:1: RULE_STRING
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_311006); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5500:1: rule__ScannerCharacterRule__CharactersAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__ScannerCharacterRule__CharactersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5504:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5505:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5505:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5506:1: RULE_STRING
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_4_111037); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5515:1: rule__ScannerJSRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerJSRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5519:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5520:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5520:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5521:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5522:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5523:1: RULE_ID
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerJSRule__TokenAssignment_111072); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5534:1: rule__ScannerJSRule__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerJSRule__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5538:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5539:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5539:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5540:1: RULE_STRING
            {
             before(grammarAccess.getScannerJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerJSRule__FileURIAssignment_211107); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5549:1: rule__PartitionJSRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionJSRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5553:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5554:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5554:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5555:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5556:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5557:1: RULE_ID
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionJSRule__TokenAssignment_111142); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5568:1: rule__PartitionJSRule__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionJSRule__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5572:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5573:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5573:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5574:1: RULE_STRING
            {
             before(grammarAccess.getPartitionJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionJSRule__FileURIAssignment_211177); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5583:1: rule__ScannerWhitespaceRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerWhitespaceRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5587:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5588:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5588:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5589:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5590:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5591:1: RULE_ID
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerWhitespaceRule__TokenAssignment_111212); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5602:1: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5606:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5607:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5607:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5608:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_111247); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5617:1: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5621:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5622:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5622:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5623:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_111278); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5632:1: rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 : ( ( 'javawhitespace' ) ) ;
    public final void rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5636:1: ( ( ( 'javawhitespace' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5637:1: ( ( 'javawhitespace' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5637:1: ( ( 'javawhitespace' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5638:1: ( 'javawhitespace' )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_2_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5639:1: ( 'javawhitespace' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5640:1: 'javawhitespace'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_2_1_0()); 
            match(input,47,FOLLOW_47_in_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_111314); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5655:1: rule__ScannerWhitespaceRule__FileURIAssignment_2_2 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__FileURIAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5659:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5660:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5660:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5661:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_2_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__FileURIAssignment_2_211353); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5670:1: rule__RGBColor__RAssignment_2 : ( RULE_INT ) ;
    public final void rule__RGBColor__RAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5674:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5675:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5675:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5676:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getRINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__RAssignment_211384); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5685:1: rule__RGBColor__GAssignment_4 : ( RULE_INT ) ;
    public final void rule__RGBColor__GAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5689:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5690:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5690:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5691:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getGINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__GAssignment_411415); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5700:1: rule__RGBColor__BAssignment_6 : ( RULE_INT ) ;
    public final void rule__RGBColor__BAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5704:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5705:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5705:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5706:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getBINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__BAssignment_611446); 
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
    public static final BitSet FOLLOW_ruleRGBColor_in_entryRuleRGBColor1383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGBColor1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__0_in_ruleRGBColor1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FontType__Alternatives_in_ruleFontType1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_rule__Partitioner__Alternatives1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaLikeParitioner_in_rule__Partitioner__Alternatives1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_rule__Partitioner__Alternatives1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_rule__Damager__Alternatives1556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_rule__Damager__Alternatives1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_rule__ScannerRule__Alternatives1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_rule__ScannerRule__Alternatives1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_rule__ScannerRule__Alternatives1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_rule__ScannerRule__Alternatives1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_rule__ScannerRule__Alternatives1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_rule__ParitionRule__Alternatives1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_rule__ParitionRule__Alternatives1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_rule__ParitionRule__Alternatives1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0_in_rule__ScannerWhitespaceRule__Alternatives_21771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1_in_rule__ScannerWhitespaceRule__Alternatives_21789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__FileURIAssignment_2_2_in_rule__ScannerWhitespaceRule__Alternatives_21807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__FontType__Alternatives1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__FontType__Alternatives1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__FontType__Alternatives1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__FontType__Alternatives1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01937 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NameAssignment_0_in_rule__Model__Group__0__Impl1967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11997 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Model__Group__1__Impl2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22059 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__22062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2091 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2103 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__32136 = new BitSet(new long[]{0x0000000006080000L});
    public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__32139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2168 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2180 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__42213 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Model__Group__5_in_rule__Model__Group__42216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionerAssignment_4_in_rule__Model__Group__4__Impl2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__52273 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Model__Group__6_in_rule__Model__Group__52276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Model__Group__5__Impl2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__6__Impl_in_rule__Model__Group__62335 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Model__Group__7_in_rule__Model__Group__62338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Model__Group__6__Impl2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__7__Impl_in_rule__Model__Group__72397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2426 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl2438 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__02487 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__02490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Partition__Group__0__Impl2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__12549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl2576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__0__Impl_in_rule__JavaLikeParitioner__Group__02610 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__1_in_rule__JavaLikeParitioner__Group__02613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__JavaLikeParitioner__Group__0__Impl2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__1__Impl_in_rule__JavaLikeParitioner__Group__12672 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__2_in_rule__JavaLikeParitioner__Group__12675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JavaLikeParitioner__Group__1__Impl2703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__2__Impl_in_rule__JavaLikeParitioner__Group__22734 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__3_in_rule__JavaLikeParitioner__Group__22737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__JavaLikeParitioner__Group__2__Impl2765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__3__Impl_in_rule__JavaLikeParitioner__Group__32796 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__4_in_rule__JavaLikeParitioner__Group__32799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3_in_rule__JavaLikeParitioner__Group__3__Impl2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__4__Impl_in_rule__JavaLikeParitioner__Group__42856 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__5_in_rule__JavaLikeParitioner__Group__42859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__JavaLikeParitioner__Group__4__Impl2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__5__Impl_in_rule__JavaLikeParitioner__Group__52918 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__6_in_rule__JavaLikeParitioner__Group__52921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5_in_rule__JavaLikeParitioner__Group__5__Impl2948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__6__Impl_in_rule__JavaLikeParitioner__Group__62978 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__7_in_rule__JavaLikeParitioner__Group__62981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__JavaLikeParitioner__Group__6__Impl3009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__7__Impl_in_rule__JavaLikeParitioner__Group__73040 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__8_in_rule__JavaLikeParitioner__Group__73043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__JavaDocParitionAssignment_7_in_rule__JavaLikeParitioner__Group__7__Impl3070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__8__Impl_in_rule__JavaLikeParitioner__Group__83100 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__9_in_rule__JavaLikeParitioner__Group__83103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__JavaLikeParitioner__Group__8__Impl3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__9__Impl_in_rule__JavaLikeParitioner__Group__93162 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__10_in_rule__JavaLikeParitioner__Group__93165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__CharacterParitionAssignment_9_in_rule__JavaLikeParitioner__Group__9__Impl3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__10__Impl_in_rule__JavaLikeParitioner__Group__103222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__11_in_rule__JavaLikeParitioner__Group__103225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__JavaLikeParitioner__Group__10__Impl3253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__11__Impl_in_rule__JavaLikeParitioner__Group__113284 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__12_in_rule__JavaLikeParitioner__Group__113287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__StringParitionAssignment_11_in_rule__JavaLikeParitioner__Group__11__Impl3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__12__Impl_in_rule__JavaLikeParitioner__Group__123344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JavaLikeParitioner__Group__12__Impl3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__0__Impl_in_rule__RulePartitioner__Group__03429 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__1_in_rule__RulePartitioner__Group__03432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__RulePartitioner__Group__0__Impl3460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__1__Impl_in_rule__RulePartitioner__Group__13491 = new BitSet(new long[]{0x0000028800000000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__2_in_rule__RulePartitioner__Group__13494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__RulePartitioner__Group__1__Impl3522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__2__Impl_in_rule__RulePartitioner__Group__23553 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__3_in_rule__RulePartitioner__Group__23556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3585 = new BitSet(new long[]{0x0000028800000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl3597 = new BitSet(new long[]{0x0000028800000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__3__Impl_in_rule__RulePartitioner__Group__33630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__RulePartitioner__Group__3__Impl3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__0__Impl_in_rule__JSParitioner__Group__03697 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__1_in_rule__JSParitioner__Group__03700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__JSParitioner__Group__0__Impl3728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__1__Impl_in_rule__JSParitioner__Group__13759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__FileURIAssignment_1_in_rule__JSParitioner__Group__1__Impl3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__0__Impl_in_rule__JSDamager__Group__03820 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__1_in_rule__JSDamager__Group__03823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__JSDamager__Group__0__Impl3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__1__Impl_in_rule__JSDamager__Group__13882 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__2_in_rule__JSDamager__Group__13885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__PartitionAssignment_1_in_rule__JSDamager__Group__1__Impl3912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__2__Impl_in_rule__JSDamager__Group__23942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__FileURIAssignment_2_in_rule__JSDamager__Group__2__Impl3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__0__Impl_in_rule__RuleDamager__Group__04005 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__1_in_rule__RuleDamager__Group__04008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__RuleDamager__Group__0__Impl4036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__1__Impl_in_rule__RuleDamager__Group__14067 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__2_in_rule__RuleDamager__Group__14070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__PartitionAssignment_1_in_rule__RuleDamager__Group__1__Impl4097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__2__Impl_in_rule__RuleDamager__Group__24127 = new BitSet(new long[]{0x0000478860010000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__3_in_rule__RuleDamager__Group__24130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__RuleDamager__Group__2__Impl4158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__3__Impl_in_rule__RuleDamager__Group__34189 = new BitSet(new long[]{0x0000478860010000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__4_in_rule__RuleDamager__Group__34192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__TokensAssignment_3_in_rule__RuleDamager__Group__3__Impl4219 = new BitSet(new long[]{0x0000400020000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__4__Impl_in_rule__RuleDamager__Group__44250 = new BitSet(new long[]{0x0000478860010000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__5_in_rule__RuleDamager__Group__44253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__KeywordGroupsAssignment_4_in_rule__RuleDamager__Group__4__Impl4280 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__5__Impl_in_rule__RuleDamager__Group__54311 = new BitSet(new long[]{0x0000478860010000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__6_in_rule__RuleDamager__Group__54314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__RulesAssignment_5_in_rule__RuleDamager__Group__5__Impl4341 = new BitSet(new long[]{0x0000078800000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__6__Impl_in_rule__RuleDamager__Group__64372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__RuleDamager__Group__6__Impl4400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__0__Impl_in_rule__ScannerToken__Group__04445 = new BitSet(new long[]{0x0000400020000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__1_in_rule__ScannerToken__Group__04448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__DefaultAssignment_0_in_rule__ScannerToken__Group__0__Impl4475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__1__Impl_in_rule__ScannerToken__Group__14506 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__2_in_rule__ScannerToken__Group__14509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ScannerToken__Group__1__Impl4537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__2__Impl_in_rule__ScannerToken__Group__24568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__NameAssignment_2_in_rule__ScannerToken__Group__2__Impl4595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__0__Impl_in_rule__KeywordGroup__Group__04631 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__1_in_rule__KeywordGroup__Group__04634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__KeywordGroup__Group__0__Impl4662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__1__Impl_in_rule__KeywordGroup__Group__14693 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__2_in_rule__KeywordGroup__Group__14696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__TokenAssignment_1_in_rule__KeywordGroup__Group__1__Impl4723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__2__Impl_in_rule__KeywordGroup__Group__24753 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__3_in_rule__KeywordGroup__Group__24756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__KeywordGroup__Group__2__Impl4784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__3__Impl_in_rule__KeywordGroup__Group__34815 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__4_in_rule__KeywordGroup__Group__34818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__KeywordsAssignment_3_in_rule__KeywordGroup__Group__3__Impl4845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__4__Impl_in_rule__KeywordGroup__Group__44875 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__5_in_rule__KeywordGroup__Group__44878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__0_in_rule__KeywordGroup__Group__4__Impl4905 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__5__Impl_in_rule__KeywordGroup__Group__54936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__KeywordGroup__Group__5__Impl4964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__0__Impl_in_rule__KeywordGroup__Group_4__05007 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__1_in_rule__KeywordGroup__Group_4__05010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__KeywordGroup__Group_4__0__Impl5038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__1__Impl_in_rule__KeywordGroup__Group_4__15069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__KeywordsAssignment_4_1_in_rule__KeywordGroup__Group_4__1__Impl5096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__05130 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__05133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl5160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__15190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl5217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__05252 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__05255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Keyword__Group_1__0__Impl5283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__15314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl5341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__0__Impl_in_rule__ScannerSingleLineRule__Group__05375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__1_in_rule__ScannerSingleLineRule__Group__05378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ScannerSingleLineRule__Group__0__Impl5406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__1__Impl_in_rule__ScannerSingleLineRule__Group__15437 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__2_in_rule__ScannerSingleLineRule__Group__15440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__TokenAssignment_1_in_rule__ScannerSingleLineRule__Group__1__Impl5467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__2__Impl_in_rule__ScannerSingleLineRule__Group__25497 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__3_in_rule__ScannerSingleLineRule__Group__25500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__StartSeqAssignment_2_in_rule__ScannerSingleLineRule__Group__2__Impl5527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__3__Impl_in_rule__ScannerSingleLineRule__Group__35557 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__4_in_rule__ScannerSingleLineRule__Group__35560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ScannerSingleLineRule__Group__3__Impl5588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__4__Impl_in_rule__ScannerSingleLineRule__Group__45619 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__5_in_rule__ScannerSingleLineRule__Group__45622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__EndSeqAssignment_4_in_rule__ScannerSingleLineRule__Group__4__Impl5649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__5__Impl_in_rule__ScannerSingleLineRule__Group__55679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__0_in_rule__ScannerSingleLineRule__Group__5__Impl5706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__0__Impl_in_rule__ScannerSingleLineRule__Group_5__05749 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__1_in_rule__ScannerSingleLineRule__Group_5__05752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ScannerSingleLineRule__Group_5__0__Impl5780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__1__Impl_in_rule__ScannerSingleLineRule__Group_5__15811 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__2_in_rule__ScannerSingleLineRule__Group_5__15814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ScannerSingleLineRule__Group_5__1__Impl5842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__2__Impl_in_rule__ScannerSingleLineRule__Group_5__25873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerSingleLineRule__Group_5__2__Impl5900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__0__Impl_in_rule__PartitionSingleLineRule__Group__05936 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__1_in_rule__PartitionSingleLineRule__Group__05939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__PartitionSingleLineRule__Group__0__Impl5967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__1__Impl_in_rule__PartitionSingleLineRule__Group__15998 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__2_in_rule__PartitionSingleLineRule__Group__16001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__ParitionAssignment_1_in_rule__PartitionSingleLineRule__Group__1__Impl6028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__2__Impl_in_rule__PartitionSingleLineRule__Group__26058 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__3_in_rule__PartitionSingleLineRule__Group__26061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__StartSeqAssignment_2_in_rule__PartitionSingleLineRule__Group__2__Impl6088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__3__Impl_in_rule__PartitionSingleLineRule__Group__36118 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__4_in_rule__PartitionSingleLineRule__Group__36121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PartitionSingleLineRule__Group__3__Impl6149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__4__Impl_in_rule__PartitionSingleLineRule__Group__46180 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__5_in_rule__PartitionSingleLineRule__Group__46183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__EndSeqAssignment_4_in_rule__PartitionSingleLineRule__Group__4__Impl6210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__5__Impl_in_rule__PartitionSingleLineRule__Group__56240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__0_in_rule__PartitionSingleLineRule__Group__5__Impl6267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__0__Impl_in_rule__PartitionSingleLineRule__Group_5__06310 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__1_in_rule__PartitionSingleLineRule__Group_5__06313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__PartitionSingleLineRule__Group_5__0__Impl6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__1__Impl_in_rule__PartitionSingleLineRule__Group_5__16372 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__2_in_rule__PartitionSingleLineRule__Group_5__16375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__PartitionSingleLineRule__Group_5__1__Impl6403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__2__Impl_in_rule__PartitionSingleLineRule__Group_5__26434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionSingleLineRule__Group_5__2__Impl6461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__0__Impl_in_rule__ScannerMultiLineRule__Group__06497 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__1_in_rule__ScannerMultiLineRule__Group__06500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ScannerMultiLineRule__Group__0__Impl6528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__1__Impl_in_rule__ScannerMultiLineRule__Group__16559 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__2_in_rule__ScannerMultiLineRule__Group__16562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__TokenAssignment_1_in_rule__ScannerMultiLineRule__Group__1__Impl6589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__2__Impl_in_rule__ScannerMultiLineRule__Group__26619 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__3_in_rule__ScannerMultiLineRule__Group__26622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__StartSeqAssignment_2_in_rule__ScannerMultiLineRule__Group__2__Impl6649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__3__Impl_in_rule__ScannerMultiLineRule__Group__36679 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__4_in_rule__ScannerMultiLineRule__Group__36682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ScannerMultiLineRule__Group__3__Impl6710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__4__Impl_in_rule__ScannerMultiLineRule__Group__46741 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__5_in_rule__ScannerMultiLineRule__Group__46744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__EndSeqAssignment_4_in_rule__ScannerMultiLineRule__Group__4__Impl6771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__5__Impl_in_rule__ScannerMultiLineRule__Group__56801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__0_in_rule__ScannerMultiLineRule__Group__5__Impl6828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__0__Impl_in_rule__ScannerMultiLineRule__Group_5__06871 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__1_in_rule__ScannerMultiLineRule__Group_5__06874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ScannerMultiLineRule__Group_5__0__Impl6902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__1__Impl_in_rule__ScannerMultiLineRule__Group_5__16933 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__2_in_rule__ScannerMultiLineRule__Group_5__16936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ScannerMultiLineRule__Group_5__1__Impl6964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__2__Impl_in_rule__ScannerMultiLineRule__Group_5__26995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerMultiLineRule__Group_5__2__Impl7022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__0__Impl_in_rule__PartitionMultiLineRule__Group__07058 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__1_in_rule__PartitionMultiLineRule__Group__07061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__PartitionMultiLineRule__Group__0__Impl7089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__1__Impl_in_rule__PartitionMultiLineRule__Group__17120 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__2_in_rule__PartitionMultiLineRule__Group__17123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__ParitionAssignment_1_in_rule__PartitionMultiLineRule__Group__1__Impl7150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__2__Impl_in_rule__PartitionMultiLineRule__Group__27180 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__3_in_rule__PartitionMultiLineRule__Group__27183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__StartSeqAssignment_2_in_rule__PartitionMultiLineRule__Group__2__Impl7210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__3__Impl_in_rule__PartitionMultiLineRule__Group__37240 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__4_in_rule__PartitionMultiLineRule__Group__37243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PartitionMultiLineRule__Group__3__Impl7271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__4__Impl_in_rule__PartitionMultiLineRule__Group__47302 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__5_in_rule__PartitionMultiLineRule__Group__47305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__EndSeqAssignment_4_in_rule__PartitionMultiLineRule__Group__4__Impl7332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__5__Impl_in_rule__PartitionMultiLineRule__Group__57362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__0_in_rule__PartitionMultiLineRule__Group__5__Impl7389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__0__Impl_in_rule__PartitionMultiLineRule__Group_5__07432 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__1_in_rule__PartitionMultiLineRule__Group_5__07435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__PartitionMultiLineRule__Group_5__0__Impl7463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__1__Impl_in_rule__PartitionMultiLineRule__Group_5__17494 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__2_in_rule__PartitionMultiLineRule__Group_5__17497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__PartitionMultiLineRule__Group_5__1__Impl7525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__2__Impl_in_rule__PartitionMultiLineRule__Group_5__27556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionMultiLineRule__Group_5__2__Impl7583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__0__Impl_in_rule__ScannerCharacterRule__Group__07619 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__1_in_rule__ScannerCharacterRule__Group__07622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ScannerCharacterRule__Group__0__Impl7650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__1__Impl_in_rule__ScannerCharacterRule__Group__17681 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__2_in_rule__ScannerCharacterRule__Group__17684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__TokenAssignment_1_in_rule__ScannerCharacterRule__Group__1__Impl7711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__2__Impl_in_rule__ScannerCharacterRule__Group__27741 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__3_in_rule__ScannerCharacterRule__Group__27744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ScannerCharacterRule__Group__2__Impl7772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__3__Impl_in_rule__ScannerCharacterRule__Group__37803 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__4_in_rule__ScannerCharacterRule__Group__37806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_3_in_rule__ScannerCharacterRule__Group__3__Impl7833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__4__Impl_in_rule__ScannerCharacterRule__Group__47863 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__5_in_rule__ScannerCharacterRule__Group__47866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__0_in_rule__ScannerCharacterRule__Group__4__Impl7893 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__5__Impl_in_rule__ScannerCharacterRule__Group__57924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ScannerCharacterRule__Group__5__Impl7952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__0__Impl_in_rule__ScannerCharacterRule__Group_4__07995 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__1_in_rule__ScannerCharacterRule__Group_4__07998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ScannerCharacterRule__Group_4__0__Impl8026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__1__Impl_in_rule__ScannerCharacterRule__Group_4__18057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_4_1_in_rule__ScannerCharacterRule__Group_4__1__Impl8084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__0__Impl_in_rule__ScannerJSRule__Group__08118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__1_in_rule__ScannerJSRule__Group__08121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ScannerJSRule__Group__0__Impl8149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__1__Impl_in_rule__ScannerJSRule__Group__18180 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__2_in_rule__ScannerJSRule__Group__18183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__TokenAssignment_1_in_rule__ScannerJSRule__Group__1__Impl8210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__2__Impl_in_rule__ScannerJSRule__Group__28240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__FileURIAssignment_2_in_rule__ScannerJSRule__Group__2__Impl8267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__0__Impl_in_rule__PartitionJSRule__Group__08303 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__1_in_rule__PartitionJSRule__Group__08306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__PartitionJSRule__Group__0__Impl8334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__1__Impl_in_rule__PartitionJSRule__Group__18365 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__2_in_rule__PartitionJSRule__Group__18368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__TokenAssignment_1_in_rule__PartitionJSRule__Group__1__Impl8395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__2__Impl_in_rule__PartitionJSRule__Group__28425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__FileURIAssignment_2_in_rule__PartitionJSRule__Group__2__Impl8452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__0__Impl_in_rule__ScannerWhitespaceRule__Group__08488 = new BitSet(new long[]{0x0000800080000030L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__1_in_rule__ScannerWhitespaceRule__Group__08491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ScannerWhitespaceRule__Group__0__Impl8519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__1__Impl_in_rule__ScannerWhitespaceRule__Group__18550 = new BitSet(new long[]{0x0000800080000030L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__2_in_rule__ScannerWhitespaceRule__Group__18553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__TokenAssignment_1_in_rule__ScannerWhitespaceRule__Group__1__Impl8580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__2__Impl_in_rule__ScannerWhitespaceRule__Group__28611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Alternatives_2_in_rule__ScannerWhitespaceRule__Group__2__Impl8638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__08674 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1_in_rule__ScannerWhitespaceRule__Group_2_0__08677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ScannerWhitespaceRule__Group_2_0__0__Impl8705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__18736 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2_in_rule__ScannerWhitespaceRule__Group_2_0__18739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1_in_rule__ScannerWhitespaceRule__Group_2_0__1__Impl8766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__28796 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3_in_rule__ScannerWhitespaceRule__Group_2_0__28799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0_in_rule__ScannerWhitespaceRule__Group_2_0__2__Impl8826 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__38857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ScannerWhitespaceRule__Group_2_0__3__Impl8885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__08924 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1_in_rule__ScannerWhitespaceRule__Group_2_0_2__08927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl8955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__18986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1_in_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl9013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__0__Impl_in_rule__RGBColor__Group__09047 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__1_in_rule__RGBColor__Group__09050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__RGBColor__Group__0__Impl9078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__1__Impl_in_rule__RGBColor__Group__19109 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__2_in_rule__RGBColor__Group__19112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__RGBColor__Group__1__Impl9140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__2__Impl_in_rule__RGBColor__Group__29171 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__3_in_rule__RGBColor__Group__29174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__RAssignment_2_in_rule__RGBColor__Group__2__Impl9201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__3__Impl_in_rule__RGBColor__Group__39231 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__4_in_rule__RGBColor__Group__39234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__RGBColor__Group__3__Impl9262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__4__Impl_in_rule__RGBColor__Group__49293 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__5_in_rule__RGBColor__Group__49296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__GAssignment_4_in_rule__RGBColor__Group__4__Impl9323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__5__Impl_in_rule__RGBColor__Group__59353 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__6_in_rule__RGBColor__Group__59356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__RGBColor__Group__5__Impl9384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__6__Impl_in_rule__RGBColor__Group__69415 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__7_in_rule__RGBColor__Group__69418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__BAssignment_6_in_rule__RGBColor__Group__6__Impl9445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__7__Impl_in_rule__RGBColor__Group__79475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__RGBColor__Group__7__Impl9503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_09556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_rule__Model__PartitionsAssignment_29587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDamager_in_rule__Model__DamagersAssignment_39618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_rule__Model__PartitionerAssignment_49649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Model__ContentTypesAssignment_79680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_19711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_39746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_59785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__JavaDocParitionAssignment_79824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__CharacterParitionAssignment_99863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__StringParitionAssignment_119902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_rule__RulePartitioner__RulesAssignment_29937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JSParitioner__FileURIAssignment_19968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JSDamager__PartitionAssignment_110003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JSDamager__FileURIAssignment_210038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RuleDamager__PartitionAssignment_110073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_rule__RuleDamager__TokensAssignment_310108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_rule__RuleDamager__KeywordGroupsAssignment_410139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_rule__RuleDamager__RulesAssignment_510170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ScannerToken__DefaultAssignment_010206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerToken__NameAssignment_210245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeywordGroup__TokenAssignment_110280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_310315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_4_110346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_010377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_110408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerSingleLineRule__TokenAssignment_110443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__StartSeqAssignment_210478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EndSeqAssignment_410509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_210540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionSingleLineRule__ParitionAssignment_110575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__StartSeqAssignment_210610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EndSeqAssignment_410641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_210672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerMultiLineRule__TokenAssignment_110707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__StartSeqAssignment_210742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EndSeqAssignment_410773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_210804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionMultiLineRule__ParitionAssignment_110839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__StartSeqAssignment_210874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EndSeqAssignment_410905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_210936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerCharacterRule__TokenAssignment_110971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_311006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_4_111037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerJSRule__TokenAssignment_111072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerJSRule__FileURIAssignment_211107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionJSRule__TokenAssignment_111142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionJSRule__FileURIAssignment_211177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerWhitespaceRule__TokenAssignment_111212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_111247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_111278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_111314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__FileURIAssignment_2_211353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__RAssignment_211384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__GAssignment_411415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__BAssignment_611446 = new BitSet(new long[]{0x0000000000000002L});

}