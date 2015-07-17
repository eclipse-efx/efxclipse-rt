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

@SuppressWarnings("all")
public class InternalLDefParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'partitioning'", "'partition'", "'script'", "'rule'", "'single_line'", "'=>'", "'escaped'", "'by'", "'multi_line'", "'lexical_highlighting'", "'keywords'", "'['", "']'", "','", "'since'", "'character'", "'whitespace'", "'default'", "'javawhitespace'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
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




    // $ANTLR start "entryRuleLDef"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:60:1: entryRuleLDef : ruleLDef EOF ;
    public final void entryRuleLDef() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:61:1: ( ruleLDef EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:62:1: ruleLDef EOF
            {
             before(grammarAccess.getLDefRule()); 
            pushFollow(FOLLOW_ruleLDef_in_entryRuleLDef61);
            ruleLDef();

            state._fsp--;

             after(grammarAccess.getLDefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLDef68); 

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
    // $ANTLR end "entryRuleLDef"


    // $ANTLR start "ruleLDef"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:69:1: ruleLDef : ( ( rule__LDef__Group__0 ) ) ;
    public final void ruleLDef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:73:2: ( ( ( rule__LDef__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:74:1: ( ( rule__LDef__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:74:1: ( ( rule__LDef__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:75:1: ( rule__LDef__Group__0 )
            {
             before(grammarAccess.getLDefAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:76:1: ( rule__LDef__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:76:2: rule__LDef__Group__0
            {
            pushFollow(FOLLOW_rule__LDef__Group__0_in_ruleLDef94);
            rule__LDef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLDefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLDef"


    // $ANTLR start "entryRuleParitioning"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:88:1: entryRuleParitioning : ruleParitioning EOF ;
    public final void entryRuleParitioning() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:89:1: ( ruleParitioning EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:90:1: ruleParitioning EOF
            {
             before(grammarAccess.getParitioningRule()); 
            pushFollow(FOLLOW_ruleParitioning_in_entryRuleParitioning121);
            ruleParitioning();

            state._fsp--;

             after(grammarAccess.getParitioningRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioning128); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:97:1: ruleParitioning : ( ( rule__Paritioning__Group__0 ) ) ;
    public final void ruleParitioning() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:101:2: ( ( ( rule__Paritioning__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:102:1: ( ( rule__Paritioning__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:102:1: ( ( rule__Paritioning__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:103:1: ( rule__Paritioning__Group__0 )
            {
             before(grammarAccess.getParitioningAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:104:1: ( rule__Paritioning__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:104:2: rule__Paritioning__Group__0
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__0_in_ruleParitioning154);
            rule__Paritioning__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParitioningAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:116:1: entryRulePartition : rulePartition EOF ;
    public final void entryRulePartition() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:117:1: ( rulePartition EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:118:1: rulePartition EOF
            {
             before(grammarAccess.getPartitionRule()); 
            pushFollow(FOLLOW_rulePartition_in_entryRulePartition181);
            rulePartition();

            state._fsp--;

             after(grammarAccess.getPartitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition188); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:125:1: rulePartition : ( ( rule__Partition__Group__0 ) ) ;
    public final void rulePartition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:129:2: ( ( ( rule__Partition__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:130:1: ( ( rule__Partition__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:130:1: ( ( rule__Partition__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:131:1: ( rule__Partition__Group__0 )
            {
             before(grammarAccess.getPartitionAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:132:1: ( rule__Partition__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:132:2: rule__Partition__Group__0
            {
            pushFollow(FOLLOW_rule__Partition__Group__0_in_rulePartition214);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:144:1: entryRulePartitioner : rulePartitioner EOF ;
    public final void entryRulePartitioner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:145:1: ( rulePartitioner EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:146:1: rulePartitioner EOF
            {
             before(grammarAccess.getPartitionerRule()); 
            pushFollow(FOLLOW_rulePartitioner_in_entryRulePartitioner241);
            rulePartitioner();

            state._fsp--;

             after(grammarAccess.getPartitionerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner248); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:153:1: rulePartitioner : ( ( rule__Partitioner__Alternatives ) ) ;
    public final void rulePartitioner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:157:2: ( ( ( rule__Partitioner__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:158:1: ( ( rule__Partitioner__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:158:1: ( ( rule__Partitioner__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:159:1: ( rule__Partitioner__Alternatives )
            {
             before(grammarAccess.getPartitionerAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:160:1: ( rule__Partitioner__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:160:2: rule__Partitioner__Alternatives
            {
            pushFollow(FOLLOW_rule__Partitioner__Alternatives_in_rulePartitioner274);
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


    // $ANTLR start "entryRuleParitioner_JS"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:172:1: entryRuleParitioner_JS : ruleParitioner_JS EOF ;
    public final void entryRuleParitioner_JS() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:173:1: ( ruleParitioner_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:174:1: ruleParitioner_JS EOF
            {
             before(grammarAccess.getParitioner_JSRule()); 
            pushFollow(FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS301);
            ruleParitioner_JS();

            state._fsp--;

             after(grammarAccess.getParitioner_JSRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioner_JS308); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:181:1: ruleParitioner_JS : ( ( rule__Paritioner_JS__Group__0 ) ) ;
    public final void ruleParitioner_JS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:185:2: ( ( ( rule__Paritioner_JS__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:186:1: ( ( rule__Paritioner_JS__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:186:1: ( ( rule__Paritioner_JS__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:187:1: ( rule__Paritioner_JS__Group__0 )
            {
             before(grammarAccess.getParitioner_JSAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:188:1: ( rule__Paritioner_JS__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:188:2: rule__Paritioner_JS__Group__0
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__0_in_ruleParitioner_JS334);
            rule__Paritioner_JS__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParitioner_JSAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:200:1: entryRulePartitioner_Rule : rulePartitioner_Rule EOF ;
    public final void entryRulePartitioner_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:201:1: ( rulePartitioner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:202:1: rulePartitioner_Rule EOF
            {
             before(grammarAccess.getPartitioner_RuleRule()); 
            pushFollow(FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule361);
            rulePartitioner_Rule();

            state._fsp--;

             after(grammarAccess.getPartitioner_RuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner_Rule368); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:209:1: rulePartitioner_Rule : ( ( rule__Partitioner_Rule__Group__0 ) ) ;
    public final void rulePartitioner_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:213:2: ( ( ( rule__Partitioner_Rule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:214:1: ( ( rule__Partitioner_Rule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:214:1: ( ( rule__Partitioner_Rule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:215:1: ( rule__Partitioner_Rule__Group__0 )
            {
             before(grammarAccess.getPartitioner_RuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:216:1: ( rule__Partitioner_Rule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:216:2: rule__Partitioner_Rule__Group__0
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__0_in_rulePartitioner_Rule394);
            rule__Partitioner_Rule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPartitioner_RuleAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:228:1: entryRulePartition_Rule : rulePartition_Rule EOF ;
    public final void entryRulePartition_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:229:1: ( rulePartition_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:230:1: rulePartition_Rule EOF
            {
             before(grammarAccess.getPartition_RuleRule()); 
            pushFollow(FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule421);
            rulePartition_Rule();

            state._fsp--;

             after(grammarAccess.getPartition_RuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_Rule428); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:237:1: rulePartition_Rule : ( ( rule__Partition_Rule__Alternatives ) ) ;
    public final void rulePartition_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:241:2: ( ( ( rule__Partition_Rule__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:242:1: ( ( rule__Partition_Rule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:242:1: ( ( rule__Partition_Rule__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:243:1: ( rule__Partition_Rule__Alternatives )
            {
             before(grammarAccess.getPartition_RuleAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:244:1: ( rule__Partition_Rule__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:244:2: rule__Partition_Rule__Alternatives
            {
            pushFollow(FOLLOW_rule__Partition_Rule__Alternatives_in_rulePartition_Rule454);
            rule__Partition_Rule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPartition_RuleAccess().getAlternatives()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:256:1: entryRulePartition_SingleLineRule : rulePartition_SingleLineRule EOF ;
    public final void entryRulePartition_SingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:257:1: ( rulePartition_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:258:1: rulePartition_SingleLineRule EOF
            {
             before(grammarAccess.getPartition_SingleLineRuleRule()); 
            pushFollow(FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule481);
            rulePartition_SingleLineRule();

            state._fsp--;

             after(grammarAccess.getPartition_SingleLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_SingleLineRule488); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:265:1: rulePartition_SingleLineRule : ( ( rule__Partition_SingleLineRule__Group__0 ) ) ;
    public final void rulePartition_SingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:269:2: ( ( ( rule__Partition_SingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:270:1: ( ( rule__Partition_SingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:270:1: ( ( rule__Partition_SingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:271:1: ( rule__Partition_SingleLineRule__Group__0 )
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:272:1: ( rule__Partition_SingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:272:2: rule__Partition_SingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__0_in_rulePartition_SingleLineRule514);
            rule__Partition_SingleLineRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPartition_SingleLineRuleAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:284:1: entryRulePartition_MultiLineRule : rulePartition_MultiLineRule EOF ;
    public final void entryRulePartition_MultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:285:1: ( rulePartition_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:286:1: rulePartition_MultiLineRule EOF
            {
             before(grammarAccess.getPartition_MultiLineRuleRule()); 
            pushFollow(FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule541);
            rulePartition_MultiLineRule();

            state._fsp--;

             after(grammarAccess.getPartition_MultiLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_MultiLineRule548); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:293:1: rulePartition_MultiLineRule : ( ( rule__Partition_MultiLineRule__Group__0 ) ) ;
    public final void rulePartition_MultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:297:2: ( ( ( rule__Partition_MultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:298:1: ( ( rule__Partition_MultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:298:1: ( ( rule__Partition_MultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:299:1: ( rule__Partition_MultiLineRule__Group__0 )
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:300:1: ( rule__Partition_MultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:300:2: rule__Partition_MultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__0_in_rulePartition_MultiLineRule574);
            rule__Partition_MultiLineRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPartition_MultiLineRuleAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:312:1: entryRuleLexicalHighlighting : ruleLexicalHighlighting EOF ;
    public final void entryRuleLexicalHighlighting() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:313:1: ( ruleLexicalHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:314:1: ruleLexicalHighlighting EOF
            {
             before(grammarAccess.getLexicalHighlightingRule()); 
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting601);
            ruleLexicalHighlighting();

            state._fsp--;

             after(grammarAccess.getLexicalHighlightingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalHighlighting608); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:321:1: ruleLexicalHighlighting : ( ( rule__LexicalHighlighting__Group__0 ) ) ;
    public final void ruleLexicalHighlighting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:325:2: ( ( ( rule__LexicalHighlighting__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:326:1: ( ( rule__LexicalHighlighting__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:326:1: ( ( rule__LexicalHighlighting__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:327:1: ( rule__LexicalHighlighting__Group__0 )
            {
             before(grammarAccess.getLexicalHighlightingAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:328:1: ( rule__LexicalHighlighting__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:328:2: rule__LexicalHighlighting__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__0_in_ruleLexicalHighlighting634);
            rule__LexicalHighlighting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLexicalHighlightingAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:340:1: entryRuleLexicalPartitionHighlighting : ruleLexicalPartitionHighlighting EOF ;
    public final void entryRuleLexicalPartitionHighlighting() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:341:1: ( ruleLexicalPartitionHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:342:1: ruleLexicalPartitionHighlighting EOF
            {
             before(grammarAccess.getLexicalPartitionHighlightingRule()); 
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting661);
            ruleLexicalPartitionHighlighting();

            state._fsp--;

             after(grammarAccess.getLexicalPartitionHighlightingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting668); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:349:1: ruleLexicalPartitionHighlighting : ( ( rule__LexicalPartitionHighlighting__Alternatives ) ) ;
    public final void ruleLexicalPartitionHighlighting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:353:2: ( ( ( rule__LexicalPartitionHighlighting__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:354:1: ( ( rule__LexicalPartitionHighlighting__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:354:1: ( ( rule__LexicalPartitionHighlighting__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:355:1: ( rule__LexicalPartitionHighlighting__Alternatives )
            {
             before(grammarAccess.getLexicalPartitionHighlightingAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:356:1: ( rule__LexicalPartitionHighlighting__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:356:2: rule__LexicalPartitionHighlighting__Alternatives
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting__Alternatives_in_ruleLexicalPartitionHighlighting694);
            rule__LexicalPartitionHighlighting__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLexicalPartitionHighlightingAccess().getAlternatives()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:368:1: entryRuleLexicalPartitionHighlighting_JS : ruleLexicalPartitionHighlighting_JS EOF ;
    public final void entryRuleLexicalPartitionHighlighting_JS() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:369:1: ( ruleLexicalPartitionHighlighting_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:370:1: ruleLexicalPartitionHighlighting_JS EOF
            {
             before(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS721);
            ruleLexicalPartitionHighlighting_JS();

            state._fsp--;

             after(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS728); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:377:1: ruleLexicalPartitionHighlighting_JS : ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) ) ;
    public final void ruleLexicalPartitionHighlighting_JS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:381:2: ( ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:382:1: ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:382:1: ( ( rule__LexicalPartitionHighlighting_JS__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:383:1: ( rule__LexicalPartitionHighlighting_JS__Group__0 )
            {
             before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:384:1: ( rule__LexicalPartitionHighlighting_JS__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:384:2: rule__LexicalPartitionHighlighting_JS__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0_in_ruleLexicalPartitionHighlighting_JS754);
            rule__LexicalPartitionHighlighting_JS__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:396:1: entryRuleLexicalPartitionHighlighting_Rule : ruleLexicalPartitionHighlighting_Rule EOF ;
    public final void entryRuleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:397:1: ( ruleLexicalPartitionHighlighting_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:398:1: ruleLexicalPartitionHighlighting_Rule EOF
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule781);
            ruleLexicalPartitionHighlighting_Rule();

            state._fsp--;

             after(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule788); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:405:1: ruleLexicalPartitionHighlighting_Rule : ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) ) ;
    public final void ruleLexicalPartitionHighlighting_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:409:2: ( ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:410:1: ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:410:1: ( ( rule__LexicalPartitionHighlighting_Rule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:411:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0 )
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:412:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:412:2: rule__LexicalPartitionHighlighting_Rule__Group__0
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0_in_ruleLexicalPartitionHighlighting_Rule814);
            rule__LexicalPartitionHighlighting_Rule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:424:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:425:1: ( ruleToken EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:426:1: ruleToken EOF
            {
             before(grammarAccess.getTokenRule()); 
            pushFollow(FOLLOW_ruleToken_in_entryRuleToken841);
            ruleToken();

            state._fsp--;

             after(grammarAccess.getTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleToken848); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:433:1: ruleToken : ( ( rule__Token__Group__0 ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:437:2: ( ( ( rule__Token__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:438:1: ( ( rule__Token__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:438:1: ( ( rule__Token__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:439:1: ( rule__Token__Group__0 )
            {
             before(grammarAccess.getTokenAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:440:1: ( rule__Token__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:440:2: rule__Token__Group__0
            {
            pushFollow(FOLLOW_rule__Token__Group__0_in_ruleToken874);
            rule__Token__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:452:1: entryRuleScanner : ruleScanner EOF ;
    public final void entryRuleScanner() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:453:1: ( ruleScanner EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:454:1: ruleScanner EOF
            {
             before(grammarAccess.getScannerRule()); 
            pushFollow(FOLLOW_ruleScanner_in_entryRuleScanner901);
            ruleScanner();

            state._fsp--;

             after(grammarAccess.getScannerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner908); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:461:1: ruleScanner : ( ( rule__Scanner__Alternatives ) ) ;
    public final void ruleScanner() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:465:2: ( ( ( rule__Scanner__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:466:1: ( ( rule__Scanner__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:466:1: ( ( rule__Scanner__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:467:1: ( rule__Scanner__Alternatives )
            {
             before(grammarAccess.getScannerAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:468:1: ( rule__Scanner__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:468:2: rule__Scanner__Alternatives
            {
            pushFollow(FOLLOW_rule__Scanner__Alternatives_in_ruleScanner934);
            rule__Scanner__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getScannerAccess().getAlternatives()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:480:1: entryRuleScanner_Keyword : ruleScanner_Keyword EOF ;
    public final void entryRuleScanner_Keyword() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:481:1: ( ruleScanner_Keyword EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:482:1: ruleScanner_Keyword EOF
            {
             before(grammarAccess.getScanner_KeywordRule()); 
            pushFollow(FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword961);
            ruleScanner_Keyword();

            state._fsp--;

             after(grammarAccess.getScanner_KeywordRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Keyword968); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:489:1: ruleScanner_Keyword : ( ( rule__Scanner_Keyword__Group__0 ) ) ;
    public final void ruleScanner_Keyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:493:2: ( ( ( rule__Scanner_Keyword__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:494:1: ( ( rule__Scanner_Keyword__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:494:1: ( ( rule__Scanner_Keyword__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:495:1: ( rule__Scanner_Keyword__Group__0 )
            {
             before(grammarAccess.getScanner_KeywordAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:496:1: ( rule__Scanner_Keyword__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:496:2: rule__Scanner_Keyword__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__0_in_ruleScanner_Keyword994);
            rule__Scanner_Keyword__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScanner_KeywordAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:508:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:509:1: ( ruleKeyword EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:510:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword1021);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword1028); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:517:1: ruleKeyword : ( ( rule__Keyword__Group__0 ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:521:2: ( ( ( rule__Keyword__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:522:1: ( ( rule__Keyword__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:522:1: ( ( rule__Keyword__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:523:1: ( rule__Keyword__Group__0 )
            {
             before(grammarAccess.getKeywordAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:524:1: ( rule__Keyword__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:524:2: rule__Keyword__Group__0
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0_in_ruleKeyword1054);
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


    // $ANTLR start "entryRuleScanner_Rule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:536:1: entryRuleScanner_Rule : ruleScanner_Rule EOF ;
    public final void entryRuleScanner_Rule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:537:1: ( ruleScanner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:538:1: ruleScanner_Rule EOF
            {
             before(grammarAccess.getScanner_RuleRule()); 
            pushFollow(FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule1081);
            ruleScanner_Rule();

            state._fsp--;

             after(grammarAccess.getScanner_RuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Rule1088); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:545:1: ruleScanner_Rule : ( ( rule__Scanner_Rule__Alternatives ) ) ;
    public final void ruleScanner_Rule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:549:2: ( ( ( rule__Scanner_Rule__Alternatives ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:550:1: ( ( rule__Scanner_Rule__Alternatives ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:550:1: ( ( rule__Scanner_Rule__Alternatives ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:551:1: ( rule__Scanner_Rule__Alternatives )
            {
             before(grammarAccess.getScanner_RuleAccess().getAlternatives()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:552:1: ( rule__Scanner_Rule__Alternatives )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:552:2: rule__Scanner_Rule__Alternatives
            {
            pushFollow(FOLLOW_rule__Scanner_Rule__Alternatives_in_ruleScanner_Rule1114);
            rule__Scanner_Rule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getScanner_RuleAccess().getAlternatives()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:564:1: entryRuleScanner_SingleLineRule : ruleScanner_SingleLineRule EOF ;
    public final void entryRuleScanner_SingleLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:565:1: ( ruleScanner_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:566:1: ruleScanner_SingleLineRule EOF
            {
             before(grammarAccess.getScanner_SingleLineRuleRule()); 
            pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule1141);
            ruleScanner_SingleLineRule();

            state._fsp--;

             after(grammarAccess.getScanner_SingleLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_SingleLineRule1148); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:573:1: ruleScanner_SingleLineRule : ( ( rule__Scanner_SingleLineRule__Group__0 ) ) ;
    public final void ruleScanner_SingleLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:577:2: ( ( ( rule__Scanner_SingleLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:578:1: ( ( rule__Scanner_SingleLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:578:1: ( ( rule__Scanner_SingleLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:579:1: ( rule__Scanner_SingleLineRule__Group__0 )
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:580:1: ( rule__Scanner_SingleLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:580:2: rule__Scanner_SingleLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__0_in_ruleScanner_SingleLineRule1174);
            rule__Scanner_SingleLineRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScanner_SingleLineRuleAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:592:1: entryRuleScanner_MultiLineRule : ruleScanner_MultiLineRule EOF ;
    public final void entryRuleScanner_MultiLineRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:593:1: ( ruleScanner_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:594:1: ruleScanner_MultiLineRule EOF
            {
             before(grammarAccess.getScanner_MultiLineRuleRule()); 
            pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule1201);
            ruleScanner_MultiLineRule();

            state._fsp--;

             after(grammarAccess.getScanner_MultiLineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_MultiLineRule1208); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:601:1: ruleScanner_MultiLineRule : ( ( rule__Scanner_MultiLineRule__Group__0 ) ) ;
    public final void ruleScanner_MultiLineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:605:2: ( ( ( rule__Scanner_MultiLineRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:606:1: ( ( rule__Scanner_MultiLineRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:606:1: ( ( rule__Scanner_MultiLineRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:607:1: ( rule__Scanner_MultiLineRule__Group__0 )
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:608:1: ( rule__Scanner_MultiLineRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:608:2: rule__Scanner_MultiLineRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__0_in_ruleScanner_MultiLineRule1234);
            rule__Scanner_MultiLineRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScanner_MultiLineRuleAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:620:1: entryRuleScanner_CharacterRule : ruleScanner_CharacterRule EOF ;
    public final void entryRuleScanner_CharacterRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:621:1: ( ruleScanner_CharacterRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:622:1: ruleScanner_CharacterRule EOF
            {
             before(grammarAccess.getScanner_CharacterRuleRule()); 
            pushFollow(FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule1261);
            ruleScanner_CharacterRule();

            state._fsp--;

             after(grammarAccess.getScanner_CharacterRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_CharacterRule1268); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:629:1: ruleScanner_CharacterRule : ( ( rule__Scanner_CharacterRule__Group__0 ) ) ;
    public final void ruleScanner_CharacterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:633:2: ( ( ( rule__Scanner_CharacterRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:634:1: ( ( rule__Scanner_CharacterRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:634:1: ( ( rule__Scanner_CharacterRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:635:1: ( rule__Scanner_CharacterRule__Group__0 )
            {
             before(grammarAccess.getScanner_CharacterRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:636:1: ( rule__Scanner_CharacterRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:636:2: rule__Scanner_CharacterRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__0_in_ruleScanner_CharacterRule1294);
            rule__Scanner_CharacterRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScanner_CharacterRuleAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:648:1: entryRuleScanner_JSRule : ruleScanner_JSRule EOF ;
    public final void entryRuleScanner_JSRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:649:1: ( ruleScanner_JSRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:650:1: ruleScanner_JSRule EOF
            {
             before(grammarAccess.getScanner_JSRuleRule()); 
            pushFollow(FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule1321);
            ruleScanner_JSRule();

            state._fsp--;

             after(grammarAccess.getScanner_JSRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_JSRule1328); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:657:1: ruleScanner_JSRule : ( ( rule__Scanner_JSRule__Group__0 ) ) ;
    public final void ruleScanner_JSRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:661:2: ( ( ( rule__Scanner_JSRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:662:1: ( ( rule__Scanner_JSRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:662:1: ( ( rule__Scanner_JSRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:663:1: ( rule__Scanner_JSRule__Group__0 )
            {
             before(grammarAccess.getScanner_JSRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:664:1: ( rule__Scanner_JSRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:664:2: rule__Scanner_JSRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__0_in_ruleScanner_JSRule1354);
            rule__Scanner_JSRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScanner_JSRuleAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleScanner_WhitespaceRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:676:1: entryRuleScanner_WhitespaceRule : ruleScanner_WhitespaceRule EOF ;
    public final void entryRuleScanner_WhitespaceRule() throws RecognitionException {
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:677:1: ( ruleScanner_WhitespaceRule EOF )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:678:1: ruleScanner_WhitespaceRule EOF
            {
             before(grammarAccess.getScanner_WhitespaceRuleRule()); 
            pushFollow(FOLLOW_ruleScanner_WhitespaceRule_in_entryRuleScanner_WhitespaceRule1381);
            ruleScanner_WhitespaceRule();

            state._fsp--;

             after(grammarAccess.getScanner_WhitespaceRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_WhitespaceRule1388); 

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
    // $ANTLR end "entryRuleScanner_WhitespaceRule"


    // $ANTLR start "ruleScanner_WhitespaceRule"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:685:1: ruleScanner_WhitespaceRule : ( ( rule__Scanner_WhitespaceRule__Group__0 ) ) ;
    public final void ruleScanner_WhitespaceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:689:2: ( ( ( rule__Scanner_WhitespaceRule__Group__0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:690:1: ( ( rule__Scanner_WhitespaceRule__Group__0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:690:1: ( ( rule__Scanner_WhitespaceRule__Group__0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:691:1: ( rule__Scanner_WhitespaceRule__Group__0 )
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getGroup()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:692:1: ( rule__Scanner_WhitespaceRule__Group__0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:692:2: rule__Scanner_WhitespaceRule__Group__0
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group__0_in_ruleScanner_WhitespaceRule1414);
            rule__Scanner_WhitespaceRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScanner_WhitespaceRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScanner_WhitespaceRule"


    // $ANTLR start "rule__Partitioner__Alternatives"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:704:1: rule__Partitioner__Alternatives : ( ( rulePartitioner_Rule ) | ( ruleParitioner_JS ) );
    public final void rule__Partitioner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:708:1: ( ( rulePartitioner_Rule ) | ( ruleParitioner_JS ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:709:1: ( rulePartitioner_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:709:1: ( rulePartitioner_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:710:1: rulePartitioner_Rule
                    {
                     before(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePartitioner_Rule_in_rule__Partitioner__Alternatives1450);
                    rulePartitioner_Rule();

                    state._fsp--;

                     after(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:715:6: ( ruleParitioner_JS )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:715:6: ( ruleParitioner_JS )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:716:1: ruleParitioner_JS
                    {
                     before(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleParitioner_JS_in_rule__Partitioner__Alternatives1467);
                    ruleParitioner_JS();

                    state._fsp--;

                     after(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:726:1: rule__Partition_Rule__Alternatives : ( ( rulePartition_SingleLineRule ) | ( rulePartition_MultiLineRule ) );
    public final void rule__Partition_Rule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:730:1: ( ( rulePartition_SingleLineRule ) | ( rulePartition_MultiLineRule ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            else if ( (LA2_0==21) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:731:1: ( rulePartition_SingleLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:731:1: ( rulePartition_SingleLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:732:1: rulePartition_SingleLineRule
                    {
                     before(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePartition_SingleLineRule_in_rule__Partition_Rule__Alternatives1499);
                    rulePartition_SingleLineRule();

                    state._fsp--;

                     after(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:737:6: ( rulePartition_MultiLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:737:6: ( rulePartition_MultiLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:738:1: rulePartition_MultiLineRule
                    {
                     before(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_rulePartition_MultiLineRule_in_rule__Partition_Rule__Alternatives1516);
                    rulePartition_MultiLineRule();

                    state._fsp--;

                     after(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:748:1: rule__LexicalPartitionHighlighting__Alternatives : ( ( ruleLexicalPartitionHighlighting_Rule ) | ( ruleLexicalPartitionHighlighting_JS ) );
    public final void rule__LexicalPartitionHighlighting__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:752:1: ( ( ruleLexicalPartitionHighlighting_Rule ) | ( ruleLexicalPartitionHighlighting_JS ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:753:1: ( ruleLexicalPartitionHighlighting_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:753:1: ( ruleLexicalPartitionHighlighting_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:754:1: ruleLexicalPartitionHighlighting_Rule
                    {
                     before(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_rule__LexicalPartitionHighlighting__Alternatives1548);
                    ruleLexicalPartitionHighlighting_Rule();

                    state._fsp--;

                     after(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:759:6: ( ruleLexicalPartitionHighlighting_JS )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:759:6: ( ruleLexicalPartitionHighlighting_JS )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:760:1: ruleLexicalPartitionHighlighting_JS
                    {
                     before(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_rule__LexicalPartitionHighlighting__Alternatives1565);
                    ruleLexicalPartitionHighlighting_JS();

                    state._fsp--;

                     after(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:770:1: rule__Scanner__Alternatives : ( ( ruleScanner_Keyword ) | ( ruleScanner_Rule ) );
    public final void rule__Scanner__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:774:1: ( ( ruleScanner_Keyword ) | ( ruleScanner_Rule ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            else if ( (LA4_0==15||LA4_0==17||LA4_0==21||(LA4_0>=28 && LA4_0<=29)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:775:1: ( ruleScanner_Keyword )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:775:1: ( ruleScanner_Keyword )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:776:1: ruleScanner_Keyword
                    {
                     before(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleScanner_Keyword_in_rule__Scanner__Alternatives1597);
                    ruleScanner_Keyword();

                    state._fsp--;

                     after(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:781:6: ( ruleScanner_Rule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:781:6: ( ruleScanner_Rule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:782:1: ruleScanner_Rule
                    {
                     before(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleScanner_Rule_in_rule__Scanner__Alternatives1614);
                    ruleScanner_Rule();

                    state._fsp--;

                     after(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 

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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:792:1: rule__Scanner_Rule__Alternatives : ( ( ruleScanner_SingleLineRule ) | ( ruleScanner_MultiLineRule ) | ( ruleScanner_CharacterRule ) | ( ruleScanner_JSRule ) | ( ruleScanner_WhitespaceRule ) );
    public final void rule__Scanner_Rule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:796:1: ( ( ruleScanner_SingleLineRule ) | ( ruleScanner_MultiLineRule ) | ( ruleScanner_CharacterRule ) | ( ruleScanner_JSRule ) | ( ruleScanner_WhitespaceRule ) )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt5=1;
                }
                break;
            case 21:
                {
                alt5=2;
                }
                break;
            case 28:
                {
                alt5=3;
                }
                break;
            case 15:
                {
                alt5=4;
                }
                break;
            case 29:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:797:1: ( ruleScanner_SingleLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:797:1: ( ruleScanner_SingleLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:798:1: ruleScanner_SingleLineRule
                    {
                     before(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_rule__Scanner_Rule__Alternatives1646);
                    ruleScanner_SingleLineRule();

                    state._fsp--;

                     after(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:803:6: ( ruleScanner_MultiLineRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:803:6: ( ruleScanner_MultiLineRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:804:1: ruleScanner_MultiLineRule
                    {
                     before(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_rule__Scanner_Rule__Alternatives1663);
                    ruleScanner_MultiLineRule();

                    state._fsp--;

                     after(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:809:6: ( ruleScanner_CharacterRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:809:6: ( ruleScanner_CharacterRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:810:1: ruleScanner_CharacterRule
                    {
                     before(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleScanner_CharacterRule_in_rule__Scanner_Rule__Alternatives1680);
                    ruleScanner_CharacterRule();

                    state._fsp--;

                     after(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:815:6: ( ruleScanner_JSRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:815:6: ( ruleScanner_JSRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:816:1: ruleScanner_JSRule
                    {
                     before(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleScanner_JSRule_in_rule__Scanner_Rule__Alternatives1697);
                    ruleScanner_JSRule();

                    state._fsp--;

                     after(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:821:6: ( ruleScanner_WhitespaceRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:821:6: ( ruleScanner_WhitespaceRule )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:822:1: ruleScanner_WhitespaceRule
                    {
                     before(grammarAccess.getScanner_RuleAccess().getScanner_WhitespaceRuleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleScanner_WhitespaceRule_in_rule__Scanner_Rule__Alternatives1714);
                    ruleScanner_WhitespaceRule();

                    state._fsp--;

                     after(grammarAccess.getScanner_RuleAccess().getScanner_WhitespaceRuleParserRuleCall_4()); 

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


    // $ANTLR start "rule__Scanner_WhitespaceRule__Alternatives_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:832:1: rule__Scanner_WhitespaceRule__Alternatives_1 : ( ( ( rule__Scanner_WhitespaceRule__Group_1_0__0 ) ) | ( ( rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1 ) ) | ( ( rule__Scanner_WhitespaceRule__FileURIAssignment_1_2 ) ) );
    public final void rule__Scanner_WhitespaceRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:836:1: ( ( ( rule__Scanner_WhitespaceRule__Group_1_0__0 ) ) | ( ( rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1 ) ) | ( ( rule__Scanner_WhitespaceRule__FileURIAssignment_1_2 ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt6=1;
                }
                break;
            case 31:
                {
                alt6=2;
                }
                break;
            case RULE_STRING:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:837:1: ( ( rule__Scanner_WhitespaceRule__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:837:1: ( ( rule__Scanner_WhitespaceRule__Group_1_0__0 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:838:1: ( rule__Scanner_WhitespaceRule__Group_1_0__0 )
                    {
                     before(grammarAccess.getScanner_WhitespaceRuleAccess().getGroup_1_0()); 
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:839:1: ( rule__Scanner_WhitespaceRule__Group_1_0__0 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:839:2: rule__Scanner_WhitespaceRule__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__0_in_rule__Scanner_WhitespaceRule__Alternatives_11746);
                    rule__Scanner_WhitespaceRule__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScanner_WhitespaceRuleAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:843:6: ( ( rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:843:6: ( ( rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:844:1: ( rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1 )
                    {
                     before(grammarAccess.getScanner_WhitespaceRuleAccess().getJavawhitespaceAssignment_1_1()); 
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:845:1: ( rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:845:2: rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1_in_rule__Scanner_WhitespaceRule__Alternatives_11764);
                    rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScanner_WhitespaceRuleAccess().getJavawhitespaceAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:849:6: ( ( rule__Scanner_WhitespaceRule__FileURIAssignment_1_2 ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:849:6: ( ( rule__Scanner_WhitespaceRule__FileURIAssignment_1_2 ) )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:850:1: ( rule__Scanner_WhitespaceRule__FileURIAssignment_1_2 )
                    {
                     before(grammarAccess.getScanner_WhitespaceRuleAccess().getFileURIAssignment_1_2()); 
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:851:1: ( rule__Scanner_WhitespaceRule__FileURIAssignment_1_2 )
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:851:2: rule__Scanner_WhitespaceRule__FileURIAssignment_1_2
                    {
                    pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__FileURIAssignment_1_2_in_rule__Scanner_WhitespaceRule__Alternatives_11782);
                    rule__Scanner_WhitespaceRule__FileURIAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getScanner_WhitespaceRuleAccess().getFileURIAssignment_1_2()); 

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
    // $ANTLR end "rule__Scanner_WhitespaceRule__Alternatives_1"


    // $ANTLR start "rule__LDef__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:862:1: rule__LDef__Group__0 : rule__LDef__Group__0__Impl rule__LDef__Group__1 ;
    public final void rule__LDef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:866:1: ( rule__LDef__Group__0__Impl rule__LDef__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:867:2: rule__LDef__Group__0__Impl rule__LDef__Group__1
            {
            pushFollow(FOLLOW_rule__LDef__Group__0__Impl_in_rule__LDef__Group__01813);
            rule__LDef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LDef__Group__1_in_rule__LDef__Group__01816);
            rule__LDef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__Group__0"


    // $ANTLR start "rule__LDef__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:874:1: rule__LDef__Group__0__Impl : ( ( rule__LDef__NameAssignment_0 ) ) ;
    public final void rule__LDef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:878:1: ( ( ( rule__LDef__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:879:1: ( ( rule__LDef__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:879:1: ( ( rule__LDef__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:880:1: ( rule__LDef__NameAssignment_0 )
            {
             before(grammarAccess.getLDefAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:881:1: ( rule__LDef__NameAssignment_0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:881:2: rule__LDef__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__LDef__NameAssignment_0_in_rule__LDef__Group__0__Impl1843);
            rule__LDef__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLDefAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__Group__0__Impl"


    // $ANTLR start "rule__LDef__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:891:1: rule__LDef__Group__1 : rule__LDef__Group__1__Impl rule__LDef__Group__2 ;
    public final void rule__LDef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:895:1: ( rule__LDef__Group__1__Impl rule__LDef__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:896:2: rule__LDef__Group__1__Impl rule__LDef__Group__2
            {
            pushFollow(FOLLOW_rule__LDef__Group__1__Impl_in_rule__LDef__Group__11873);
            rule__LDef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LDef__Group__2_in_rule__LDef__Group__11876);
            rule__LDef__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__Group__1"


    // $ANTLR start "rule__LDef__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:903:1: rule__LDef__Group__1__Impl : ( '{' ) ;
    public final void rule__LDef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:907:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:908:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:908:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:909:1: '{'
            {
             before(grammarAccess.getLDefAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,11,FOLLOW_11_in_rule__LDef__Group__1__Impl1904); 
             after(grammarAccess.getLDefAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__Group__1__Impl"


    // $ANTLR start "rule__LDef__Group__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:922:1: rule__LDef__Group__2 : rule__LDef__Group__2__Impl rule__LDef__Group__3 ;
    public final void rule__LDef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:926:1: ( rule__LDef__Group__2__Impl rule__LDef__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:927:2: rule__LDef__Group__2__Impl rule__LDef__Group__3
            {
            pushFollow(FOLLOW_rule__LDef__Group__2__Impl_in_rule__LDef__Group__21935);
            rule__LDef__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LDef__Group__3_in_rule__LDef__Group__21938);
            rule__LDef__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__Group__2"


    // $ANTLR start "rule__LDef__Group__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:934:1: rule__LDef__Group__2__Impl : ( ( rule__LDef__ParitioningAssignment_2 ) ) ;
    public final void rule__LDef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:938:1: ( ( ( rule__LDef__ParitioningAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:939:1: ( ( rule__LDef__ParitioningAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:939:1: ( ( rule__LDef__ParitioningAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:940:1: ( rule__LDef__ParitioningAssignment_2 )
            {
             before(grammarAccess.getLDefAccess().getParitioningAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:941:1: ( rule__LDef__ParitioningAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:941:2: rule__LDef__ParitioningAssignment_2
            {
            pushFollow(FOLLOW_rule__LDef__ParitioningAssignment_2_in_rule__LDef__Group__2__Impl1965);
            rule__LDef__ParitioningAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLDefAccess().getParitioningAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__Group__2__Impl"


    // $ANTLR start "rule__LDef__Group__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:951:1: rule__LDef__Group__3 : rule__LDef__Group__3__Impl rule__LDef__Group__4 ;
    public final void rule__LDef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:955:1: ( rule__LDef__Group__3__Impl rule__LDef__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:956:2: rule__LDef__Group__3__Impl rule__LDef__Group__4
            {
            pushFollow(FOLLOW_rule__LDef__Group__3__Impl_in_rule__LDef__Group__31995);
            rule__LDef__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LDef__Group__4_in_rule__LDef__Group__31998);
            rule__LDef__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__Group__3"


    // $ANTLR start "rule__LDef__Group__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:963:1: rule__LDef__Group__3__Impl : ( ( rule__LDef__LexicalHighlightingAssignment_3 ) ) ;
    public final void rule__LDef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:967:1: ( ( ( rule__LDef__LexicalHighlightingAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:968:1: ( ( rule__LDef__LexicalHighlightingAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:968:1: ( ( rule__LDef__LexicalHighlightingAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:969:1: ( rule__LDef__LexicalHighlightingAssignment_3 )
            {
             before(grammarAccess.getLDefAccess().getLexicalHighlightingAssignment_3()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:970:1: ( rule__LDef__LexicalHighlightingAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:970:2: rule__LDef__LexicalHighlightingAssignment_3
            {
            pushFollow(FOLLOW_rule__LDef__LexicalHighlightingAssignment_3_in_rule__LDef__Group__3__Impl2025);
            rule__LDef__LexicalHighlightingAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getLDefAccess().getLexicalHighlightingAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__Group__3__Impl"


    // $ANTLR start "rule__LDef__Group__4"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:980:1: rule__LDef__Group__4 : rule__LDef__Group__4__Impl ;
    public final void rule__LDef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:984:1: ( rule__LDef__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:985:2: rule__LDef__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__LDef__Group__4__Impl_in_rule__LDef__Group__42055);
            rule__LDef__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__Group__4"


    // $ANTLR start "rule__LDef__Group__4__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:991:1: rule__LDef__Group__4__Impl : ( '}' ) ;
    public final void rule__LDef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:995:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:996:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:996:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:997:1: '}'
            {
             before(grammarAccess.getLDefAccess().getRightCurlyBracketKeyword_4()); 
            match(input,12,FOLLOW_12_in_rule__LDef__Group__4__Impl2083); 
             after(grammarAccess.getLDefAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__Group__4__Impl"


    // $ANTLR start "rule__Paritioning__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1020:1: rule__Paritioning__Group__0 : rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1 ;
    public final void rule__Paritioning__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1024:1: ( rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1025:2: rule__Paritioning__Group__0__Impl rule__Paritioning__Group__1
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__0__Impl_in_rule__Paritioning__Group__02124);
            rule__Paritioning__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Paritioning__Group__1_in_rule__Paritioning__Group__02127);
            rule__Paritioning__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1032:1: rule__Paritioning__Group__0__Impl : ( 'partitioning' ) ;
    public final void rule__Paritioning__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1036:1: ( ( 'partitioning' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1037:1: ( 'partitioning' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1037:1: ( 'partitioning' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1038:1: 'partitioning'
            {
             before(grammarAccess.getParitioningAccess().getPartitioningKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__Paritioning__Group__0__Impl2155); 
             after(grammarAccess.getParitioningAccess().getPartitioningKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1051:1: rule__Paritioning__Group__1 : rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2 ;
    public final void rule__Paritioning__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1055:1: ( rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1056:2: rule__Paritioning__Group__1__Impl rule__Paritioning__Group__2
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__1__Impl_in_rule__Paritioning__Group__12186);
            rule__Paritioning__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Paritioning__Group__2_in_rule__Paritioning__Group__12189);
            rule__Paritioning__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1063:1: rule__Paritioning__Group__1__Impl : ( '{' ) ;
    public final void rule__Paritioning__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1067:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1068:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1068:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1069:1: '{'
            {
             before(grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,11,FOLLOW_11_in_rule__Paritioning__Group__1__Impl2217); 
             after(grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1082:1: rule__Paritioning__Group__2 : rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3 ;
    public final void rule__Paritioning__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1086:1: ( rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1087:2: rule__Paritioning__Group__2__Impl rule__Paritioning__Group__3
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__2__Impl_in_rule__Paritioning__Group__22248);
            rule__Paritioning__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Paritioning__Group__3_in_rule__Paritioning__Group__22251);
            rule__Paritioning__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1094:1: rule__Paritioning__Group__2__Impl : ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) ) ;
    public final void rule__Paritioning__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1098:1: ( ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1099:1: ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1099:1: ( ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1100:1: ( ( rule__Paritioning__PartitionsAssignment_2 ) ) ( ( rule__Paritioning__PartitionsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1100:1: ( ( rule__Paritioning__PartitionsAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1101:1: ( rule__Paritioning__PartitionsAssignment_2 )
            {
             before(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1102:1: ( rule__Paritioning__PartitionsAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1102:2: rule__Paritioning__PartitionsAssignment_2
            {
            pushFollow(FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl2280);
            rule__Paritioning__PartitionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1105:1: ( ( rule__Paritioning__PartitionsAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1106:1: ( rule__Paritioning__PartitionsAssignment_2 )*
            {
             before(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1107:1: ( rule__Paritioning__PartitionsAssignment_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1107:2: rule__Paritioning__PartitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl2292);
            	    rule__Paritioning__PartitionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getParitioningAccess().getPartitionsAssignment_2()); 

            }


            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1118:1: rule__Paritioning__Group__3 : rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4 ;
    public final void rule__Paritioning__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1122:1: ( rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1123:2: rule__Paritioning__Group__3__Impl rule__Paritioning__Group__4
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__3__Impl_in_rule__Paritioning__Group__32325);
            rule__Paritioning__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Paritioning__Group__4_in_rule__Paritioning__Group__32328);
            rule__Paritioning__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1130:1: rule__Paritioning__Group__3__Impl : ( ( rule__Paritioning__PartitionerAssignment_3 ) ) ;
    public final void rule__Paritioning__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1134:1: ( ( ( rule__Paritioning__PartitionerAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1135:1: ( ( rule__Paritioning__PartitionerAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1135:1: ( ( rule__Paritioning__PartitionerAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1136:1: ( rule__Paritioning__PartitionerAssignment_3 )
            {
             before(grammarAccess.getParitioningAccess().getPartitionerAssignment_3()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1137:1: ( rule__Paritioning__PartitionerAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1137:2: rule__Paritioning__PartitionerAssignment_3
            {
            pushFollow(FOLLOW_rule__Paritioning__PartitionerAssignment_3_in_rule__Paritioning__Group__3__Impl2355);
            rule__Paritioning__PartitionerAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getParitioningAccess().getPartitionerAssignment_3()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1147:1: rule__Paritioning__Group__4 : rule__Paritioning__Group__4__Impl ;
    public final void rule__Paritioning__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1151:1: ( rule__Paritioning__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1152:2: rule__Paritioning__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Paritioning__Group__4__Impl_in_rule__Paritioning__Group__42385);
            rule__Paritioning__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1158:1: rule__Paritioning__Group__4__Impl : ( '}' ) ;
    public final void rule__Paritioning__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1162:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1163:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1163:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1164:1: '}'
            {
             before(grammarAccess.getParitioningAccess().getRightCurlyBracketKeyword_4()); 
            match(input,12,FOLLOW_12_in_rule__Paritioning__Group__4__Impl2413); 
             after(grammarAccess.getParitioningAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1187:1: rule__Partition__Group__0 : rule__Partition__Group__0__Impl rule__Partition__Group__1 ;
    public final void rule__Partition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1191:1: ( rule__Partition__Group__0__Impl rule__Partition__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1192:2: rule__Partition__Group__0__Impl rule__Partition__Group__1
            {
            pushFollow(FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__02454);
            rule__Partition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__02457);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1199:1: rule__Partition__Group__0__Impl : ( 'partition' ) ;
    public final void rule__Partition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1203:1: ( ( 'partition' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1204:1: ( 'partition' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1204:1: ( 'partition' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1205:1: 'partition'
            {
             before(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__Partition__Group__0__Impl2485); 
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1218:1: rule__Partition__Group__1 : rule__Partition__Group__1__Impl ;
    public final void rule__Partition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1222:1: ( rule__Partition__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1223:2: rule__Partition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__12516);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1229:1: rule__Partition__Group__1__Impl : ( ( rule__Partition__NameAssignment_1 ) ) ;
    public final void rule__Partition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1233:1: ( ( ( rule__Partition__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1234:1: ( ( rule__Partition__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1234:1: ( ( rule__Partition__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1235:1: ( rule__Partition__NameAssignment_1 )
            {
             before(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1236:1: ( rule__Partition__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1236:2: rule__Partition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl2543);
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


    // $ANTLR start "rule__Paritioner_JS__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1250:1: rule__Paritioner_JS__Group__0 : rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1 ;
    public final void rule__Paritioner_JS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1254:1: ( rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1255:2: rule__Paritioner_JS__Group__0__Impl rule__Paritioner_JS__Group__1
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__0__Impl_in_rule__Paritioner_JS__Group__02577);
            rule__Paritioner_JS__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Paritioner_JS__Group__1_in_rule__Paritioner_JS__Group__02580);
            rule__Paritioner_JS__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1262:1: rule__Paritioner_JS__Group__0__Impl : ( 'script' ) ;
    public final void rule__Paritioner_JS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1266:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1267:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1267:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1268:1: 'script'
            {
             before(grammarAccess.getParitioner_JSAccess().getScriptKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__Paritioner_JS__Group__0__Impl2608); 
             after(grammarAccess.getParitioner_JSAccess().getScriptKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1281:1: rule__Paritioner_JS__Group__1 : rule__Paritioner_JS__Group__1__Impl ;
    public final void rule__Paritioner_JS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1285:1: ( rule__Paritioner_JS__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1286:2: rule__Paritioner_JS__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__Group__1__Impl_in_rule__Paritioner_JS__Group__12639);
            rule__Paritioner_JS__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1292:1: rule__Paritioner_JS__Group__1__Impl : ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) ) ;
    public final void rule__Paritioner_JS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1296:1: ( ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1297:1: ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1297:1: ( ( rule__Paritioner_JS__ScriptURIAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1298:1: ( rule__Paritioner_JS__ScriptURIAssignment_1 )
            {
             before(grammarAccess.getParitioner_JSAccess().getScriptURIAssignment_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1299:1: ( rule__Paritioner_JS__ScriptURIAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1299:2: rule__Paritioner_JS__ScriptURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Paritioner_JS__ScriptURIAssignment_1_in_rule__Paritioner_JS__Group__1__Impl2666);
            rule__Paritioner_JS__ScriptURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParitioner_JSAccess().getScriptURIAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1313:1: rule__Partitioner_Rule__Group__0 : rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1 ;
    public final void rule__Partitioner_Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1317:1: ( rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1318:2: rule__Partitioner_Rule__Group__0__Impl rule__Partitioner_Rule__Group__1
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__0__Impl_in_rule__Partitioner_Rule__Group__02700);
            rule__Partitioner_Rule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__1_in_rule__Partitioner_Rule__Group__02703);
            rule__Partitioner_Rule__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1325:1: rule__Partitioner_Rule__Group__0__Impl : ( 'rule' ) ;
    public final void rule__Partitioner_Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1329:1: ( ( 'rule' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1330:1: ( 'rule' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1330:1: ( 'rule' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1331:1: 'rule'
            {
             before(grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__Partitioner_Rule__Group__0__Impl2731); 
             after(grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1344:1: rule__Partitioner_Rule__Group__1 : rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2 ;
    public final void rule__Partitioner_Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1348:1: ( rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1349:2: rule__Partitioner_Rule__Group__1__Impl rule__Partitioner_Rule__Group__2
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__1__Impl_in_rule__Partitioner_Rule__Group__12762);
            rule__Partitioner_Rule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__2_in_rule__Partitioner_Rule__Group__12765);
            rule__Partitioner_Rule__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1356:1: rule__Partitioner_Rule__Group__1__Impl : ( '{' ) ;
    public final void rule__Partitioner_Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1360:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1361:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1361:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1362:1: '{'
            {
             before(grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,11,FOLLOW_11_in_rule__Partitioner_Rule__Group__1__Impl2793); 
             after(grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1375:1: rule__Partitioner_Rule__Group__2 : rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3 ;
    public final void rule__Partitioner_Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1379:1: ( rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1380:2: rule__Partitioner_Rule__Group__2__Impl rule__Partitioner_Rule__Group__3
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__2__Impl_in_rule__Partitioner_Rule__Group__22824);
            rule__Partitioner_Rule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__3_in_rule__Partitioner_Rule__Group__22827);
            rule__Partitioner_Rule__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1387:1: rule__Partitioner_Rule__Group__2__Impl : ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) ) ;
    public final void rule__Partitioner_Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1391:1: ( ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1392:1: ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1392:1: ( ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1393:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) ) ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1393:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1394:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )
            {
             before(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1395:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1395:2: rule__Partitioner_Rule__RuleListAssignment_2
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl2856);
            rule__Partitioner_Rule__RuleListAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1398:1: ( ( rule__Partitioner_Rule__RuleListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1399:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )*
            {
             before(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1400:1: ( rule__Partitioner_Rule__RuleListAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17||LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1400:2: rule__Partitioner_Rule__RuleListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl2868);
            	    rule__Partitioner_Rule__RuleListAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getPartitioner_RuleAccess().getRuleListAssignment_2()); 

            }


            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1411:1: rule__Partitioner_Rule__Group__3 : rule__Partitioner_Rule__Group__3__Impl ;
    public final void rule__Partitioner_Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1415:1: ( rule__Partitioner_Rule__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1416:2: rule__Partitioner_Rule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Partitioner_Rule__Group__3__Impl_in_rule__Partitioner_Rule__Group__32901);
            rule__Partitioner_Rule__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1422:1: rule__Partitioner_Rule__Group__3__Impl : ( '}' ) ;
    public final void rule__Partitioner_Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1426:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1427:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1427:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1428:1: '}'
            {
             before(grammarAccess.getPartitioner_RuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,12,FOLLOW_12_in_rule__Partitioner_Rule__Group__3__Impl2929); 
             after(grammarAccess.getPartitioner_RuleAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1449:1: rule__Partition_SingleLineRule__Group__0 : rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1 ;
    public final void rule__Partition_SingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1453:1: ( rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1454:2: rule__Partition_SingleLineRule__Group__0__Impl rule__Partition_SingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__0__Impl_in_rule__Partition_SingleLineRule__Group__02968);
            rule__Partition_SingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__1_in_rule__Partition_SingleLineRule__Group__02971);
            rule__Partition_SingleLineRule__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1461:1: rule__Partition_SingleLineRule__Group__0__Impl : ( 'single_line' ) ;
    public final void rule__Partition_SingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1465:1: ( ( 'single_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1466:1: ( 'single_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1466:1: ( 'single_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1467:1: 'single_line'
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Partition_SingleLineRule__Group__0__Impl2999); 
             after(grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1480:1: rule__Partition_SingleLineRule__Group__1 : rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2 ;
    public final void rule__Partition_SingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1484:1: ( rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1485:2: rule__Partition_SingleLineRule__Group__1__Impl rule__Partition_SingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__1__Impl_in_rule__Partition_SingleLineRule__Group__13030);
            rule__Partition_SingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__2_in_rule__Partition_SingleLineRule__Group__13033);
            rule__Partition_SingleLineRule__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1492:1: rule__Partition_SingleLineRule__Group__1__Impl : ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__Partition_SingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1496:1: ( ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1497:1: ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1497:1: ( ( rule__Partition_SingleLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1498:1: ( rule__Partition_SingleLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1499:1: ( rule__Partition_SingleLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1499:2: rule__Partition_SingleLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__ParitionAssignment_1_in_rule__Partition_SingleLineRule__Group__1__Impl3060);
            rule__Partition_SingleLineRule__ParitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPartition_SingleLineRuleAccess().getParitionAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1509:1: rule__Partition_SingleLineRule__Group__2 : rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3 ;
    public final void rule__Partition_SingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1513:1: ( rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1514:2: rule__Partition_SingleLineRule__Group__2__Impl rule__Partition_SingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__2__Impl_in_rule__Partition_SingleLineRule__Group__23090);
            rule__Partition_SingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__3_in_rule__Partition_SingleLineRule__Group__23093);
            rule__Partition_SingleLineRule__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1521:1: rule__Partition_SingleLineRule__Group__2__Impl : ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__Partition_SingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1525:1: ( ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1526:1: ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1526:1: ( ( rule__Partition_SingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1527:1: ( rule__Partition_SingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1528:1: ( rule__Partition_SingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1528:2: rule__Partition_SingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__StartSeqAssignment_2_in_rule__Partition_SingleLineRule__Group__2__Impl3120);
            rule__Partition_SingleLineRule__StartSeqAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqAssignment_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1538:1: rule__Partition_SingleLineRule__Group__3 : rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4 ;
    public final void rule__Partition_SingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1542:1: ( rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1543:2: rule__Partition_SingleLineRule__Group__3__Impl rule__Partition_SingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__3__Impl_in_rule__Partition_SingleLineRule__Group__33150);
            rule__Partition_SingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__4_in_rule__Partition_SingleLineRule__Group__33153);
            rule__Partition_SingleLineRule__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1550:1: rule__Partition_SingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__Partition_SingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1554:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1555:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1555:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1556:1: '=>'
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__Partition_SingleLineRule__Group__3__Impl3181); 
             after(grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1569:1: rule__Partition_SingleLineRule__Group__4 : rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5 ;
    public final void rule__Partition_SingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1573:1: ( rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1574:2: rule__Partition_SingleLineRule__Group__4__Impl rule__Partition_SingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__4__Impl_in_rule__Partition_SingleLineRule__Group__43212);
            rule__Partition_SingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__5_in_rule__Partition_SingleLineRule__Group__43215);
            rule__Partition_SingleLineRule__Group__5();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1581:1: rule__Partition_SingleLineRule__Group__4__Impl : ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1585:1: ( ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1586:1: ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1586:1: ( ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1587:1: ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )?
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1588:1: ( rule__Partition_SingleLineRule__EndSeqAssignment_4 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1588:2: rule__Partition_SingleLineRule__EndSeqAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Partition_SingleLineRule__EndSeqAssignment_4_in_rule__Partition_SingleLineRule__Group__4__Impl3242);
                    rule__Partition_SingleLineRule__EndSeqAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqAssignment_4()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1598:1: rule__Partition_SingleLineRule__Group__5 : rule__Partition_SingleLineRule__Group__5__Impl ;
    public final void rule__Partition_SingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1602:1: ( rule__Partition_SingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1603:2: rule__Partition_SingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group__5__Impl_in_rule__Partition_SingleLineRule__Group__53273);
            rule__Partition_SingleLineRule__Group__5__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1609:1: rule__Partition_SingleLineRule__Group__5__Impl : ( ( rule__Partition_SingleLineRule__Group_5__0 )? ) ;
    public final void rule__Partition_SingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1613:1: ( ( ( rule__Partition_SingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1614:1: ( ( rule__Partition_SingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1614:1: ( ( rule__Partition_SingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1615:1: ( rule__Partition_SingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1616:1: ( rule__Partition_SingleLineRule__Group_5__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1616:2: rule__Partition_SingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__0_in_rule__Partition_SingleLineRule__Group__5__Impl3300);
                    rule__Partition_SingleLineRule__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPartition_SingleLineRuleAccess().getGroup_5()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1638:1: rule__Partition_SingleLineRule__Group_5__0 : rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1 ;
    public final void rule__Partition_SingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1642:1: ( rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1643:2: rule__Partition_SingleLineRule__Group_5__0__Impl rule__Partition_SingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__0__Impl_in_rule__Partition_SingleLineRule__Group_5__03343);
            rule__Partition_SingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__1_in_rule__Partition_SingleLineRule__Group_5__03346);
            rule__Partition_SingleLineRule__Group_5__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1650:1: rule__Partition_SingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__Partition_SingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1654:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1655:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1655:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1656:1: 'escaped'
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,19,FOLLOW_19_in_rule__Partition_SingleLineRule__Group_5__0__Impl3374); 
             after(grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_5_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1669:1: rule__Partition_SingleLineRule__Group_5__1 : rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2 ;
    public final void rule__Partition_SingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1673:1: ( rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1674:2: rule__Partition_SingleLineRule__Group_5__1__Impl rule__Partition_SingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__1__Impl_in_rule__Partition_SingleLineRule__Group_5__13405);
            rule__Partition_SingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__2_in_rule__Partition_SingleLineRule__Group_5__13408);
            rule__Partition_SingleLineRule__Group_5__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1681:1: rule__Partition_SingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__Partition_SingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1685:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1686:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1686:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1687:1: 'by'
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,20,FOLLOW_20_in_rule__Partition_SingleLineRule__Group_5__1__Impl3436); 
             after(grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_5_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1700:1: rule__Partition_SingleLineRule__Group_5__2 : rule__Partition_SingleLineRule__Group_5__2__Impl ;
    public final void rule__Partition_SingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1704:1: ( rule__Partition_SingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1705:2: rule__Partition_SingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__Group_5__2__Impl_in_rule__Partition_SingleLineRule__Group_5__23467);
            rule__Partition_SingleLineRule__Group_5__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1711:1: rule__Partition_SingleLineRule__Group_5__2__Impl : ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__Partition_SingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1715:1: ( ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1716:1: ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1716:1: ( ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1717:1: ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1718:1: ( rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1718:2: rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_SingleLineRule__Group_5__2__Impl3494);
            rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1734:1: rule__Partition_MultiLineRule__Group__0 : rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1 ;
    public final void rule__Partition_MultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1738:1: ( rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1739:2: rule__Partition_MultiLineRule__Group__0__Impl rule__Partition_MultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__0__Impl_in_rule__Partition_MultiLineRule__Group__03530);
            rule__Partition_MultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__1_in_rule__Partition_MultiLineRule__Group__03533);
            rule__Partition_MultiLineRule__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1746:1: rule__Partition_MultiLineRule__Group__0__Impl : ( 'multi_line' ) ;
    public final void rule__Partition_MultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1750:1: ( ( 'multi_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1751:1: ( 'multi_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1751:1: ( 'multi_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1752:1: 'multi_line'
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__Partition_MultiLineRule__Group__0__Impl3561); 
             after(grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1765:1: rule__Partition_MultiLineRule__Group__1 : rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2 ;
    public final void rule__Partition_MultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1769:1: ( rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1770:2: rule__Partition_MultiLineRule__Group__1__Impl rule__Partition_MultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__1__Impl_in_rule__Partition_MultiLineRule__Group__13592);
            rule__Partition_MultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__2_in_rule__Partition_MultiLineRule__Group__13595);
            rule__Partition_MultiLineRule__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1777:1: rule__Partition_MultiLineRule__Group__1__Impl : ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1781:1: ( ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1782:1: ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1782:1: ( ( rule__Partition_MultiLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1783:1: ( rule__Partition_MultiLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1784:1: ( rule__Partition_MultiLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1784:2: rule__Partition_MultiLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__ParitionAssignment_1_in_rule__Partition_MultiLineRule__Group__1__Impl3622);
            rule__Partition_MultiLineRule__ParitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPartition_MultiLineRuleAccess().getParitionAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1794:1: rule__Partition_MultiLineRule__Group__2 : rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3 ;
    public final void rule__Partition_MultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1798:1: ( rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1799:2: rule__Partition_MultiLineRule__Group__2__Impl rule__Partition_MultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__2__Impl_in_rule__Partition_MultiLineRule__Group__23652);
            rule__Partition_MultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__3_in_rule__Partition_MultiLineRule__Group__23655);
            rule__Partition_MultiLineRule__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1806:1: rule__Partition_MultiLineRule__Group__2__Impl : ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1810:1: ( ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1811:1: ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1811:1: ( ( rule__Partition_MultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1812:1: ( rule__Partition_MultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1813:1: ( rule__Partition_MultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1813:2: rule__Partition_MultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__StartSeqAssignment_2_in_rule__Partition_MultiLineRule__Group__2__Impl3682);
            rule__Partition_MultiLineRule__StartSeqAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqAssignment_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1823:1: rule__Partition_MultiLineRule__Group__3 : rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4 ;
    public final void rule__Partition_MultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1827:1: ( rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1828:2: rule__Partition_MultiLineRule__Group__3__Impl rule__Partition_MultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__3__Impl_in_rule__Partition_MultiLineRule__Group__33712);
            rule__Partition_MultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__4_in_rule__Partition_MultiLineRule__Group__33715);
            rule__Partition_MultiLineRule__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1835:1: rule__Partition_MultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__Partition_MultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1839:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1840:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1840:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1841:1: '=>'
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__Partition_MultiLineRule__Group__3__Impl3743); 
             after(grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1854:1: rule__Partition_MultiLineRule__Group__4 : rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5 ;
    public final void rule__Partition_MultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1858:1: ( rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1859:2: rule__Partition_MultiLineRule__Group__4__Impl rule__Partition_MultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__4__Impl_in_rule__Partition_MultiLineRule__Group__43774);
            rule__Partition_MultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__5_in_rule__Partition_MultiLineRule__Group__43777);
            rule__Partition_MultiLineRule__Group__5();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1866:1: rule__Partition_MultiLineRule__Group__4__Impl : ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__Partition_MultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1870:1: ( ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1871:1: ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1871:1: ( ( rule__Partition_MultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1872:1: ( rule__Partition_MultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1873:1: ( rule__Partition_MultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1873:2: rule__Partition_MultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__EndSeqAssignment_4_in_rule__Partition_MultiLineRule__Group__4__Impl3804);
            rule__Partition_MultiLineRule__EndSeqAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqAssignment_4()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1883:1: rule__Partition_MultiLineRule__Group__5 : rule__Partition_MultiLineRule__Group__5__Impl ;
    public final void rule__Partition_MultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1887:1: ( rule__Partition_MultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1888:2: rule__Partition_MultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group__5__Impl_in_rule__Partition_MultiLineRule__Group__53834);
            rule__Partition_MultiLineRule__Group__5__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1894:1: rule__Partition_MultiLineRule__Group__5__Impl : ( ( rule__Partition_MultiLineRule__Group_5__0 )? ) ;
    public final void rule__Partition_MultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1898:1: ( ( ( rule__Partition_MultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1899:1: ( ( rule__Partition_MultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1899:1: ( ( rule__Partition_MultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1900:1: ( rule__Partition_MultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1901:1: ( rule__Partition_MultiLineRule__Group_5__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1901:2: rule__Partition_MultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__0_in_rule__Partition_MultiLineRule__Group__5__Impl3861);
                    rule__Partition_MultiLineRule__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPartition_MultiLineRuleAccess().getGroup_5()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1923:1: rule__Partition_MultiLineRule__Group_5__0 : rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1 ;
    public final void rule__Partition_MultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1927:1: ( rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1928:2: rule__Partition_MultiLineRule__Group_5__0__Impl rule__Partition_MultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__0__Impl_in_rule__Partition_MultiLineRule__Group_5__03904);
            rule__Partition_MultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__1_in_rule__Partition_MultiLineRule__Group_5__03907);
            rule__Partition_MultiLineRule__Group_5__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1935:1: rule__Partition_MultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__Partition_MultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1939:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1940:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1940:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1941:1: 'escaped'
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,19,FOLLOW_19_in_rule__Partition_MultiLineRule__Group_5__0__Impl3935); 
             after(grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_5_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1954:1: rule__Partition_MultiLineRule__Group_5__1 : rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2 ;
    public final void rule__Partition_MultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1958:1: ( rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1959:2: rule__Partition_MultiLineRule__Group_5__1__Impl rule__Partition_MultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__1__Impl_in_rule__Partition_MultiLineRule__Group_5__13966);
            rule__Partition_MultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__2_in_rule__Partition_MultiLineRule__Group_5__13969);
            rule__Partition_MultiLineRule__Group_5__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1966:1: rule__Partition_MultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__Partition_MultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1970:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1971:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1971:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1972:1: 'by'
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,20,FOLLOW_20_in_rule__Partition_MultiLineRule__Group_5__1__Impl3997); 
             after(grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_5_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1985:1: rule__Partition_MultiLineRule__Group_5__2 : rule__Partition_MultiLineRule__Group_5__2__Impl ;
    public final void rule__Partition_MultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1989:1: ( rule__Partition_MultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1990:2: rule__Partition_MultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__Group_5__2__Impl_in_rule__Partition_MultiLineRule__Group_5__24028);
            rule__Partition_MultiLineRule__Group_5__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:1996:1: rule__Partition_MultiLineRule__Group_5__2__Impl : ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__Partition_MultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2000:1: ( ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2001:1: ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2001:1: ( ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2002:1: ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2003:1: ( rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2003:2: rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_MultiLineRule__Group_5__2__Impl4055);
            rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2019:1: rule__LexicalHighlighting__Group__0 : rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1 ;
    public final void rule__LexicalHighlighting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2023:1: ( rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2024:2: rule__LexicalHighlighting__Group__0__Impl rule__LexicalHighlighting__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__0__Impl_in_rule__LexicalHighlighting__Group__04091);
            rule__LexicalHighlighting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__1_in_rule__LexicalHighlighting__Group__04094);
            rule__LexicalHighlighting__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2031:1: rule__LexicalHighlighting__Group__0__Impl : ( 'lexical_highlighting' ) ;
    public final void rule__LexicalHighlighting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2035:1: ( ( 'lexical_highlighting' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2036:1: ( 'lexical_highlighting' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2036:1: ( 'lexical_highlighting' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2037:1: 'lexical_highlighting'
            {
             before(grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__LexicalHighlighting__Group__0__Impl4122); 
             after(grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2050:1: rule__LexicalHighlighting__Group__1 : rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2 ;
    public final void rule__LexicalHighlighting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2054:1: ( rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2055:2: rule__LexicalHighlighting__Group__1__Impl rule__LexicalHighlighting__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__1__Impl_in_rule__LexicalHighlighting__Group__14153);
            rule__LexicalHighlighting__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__2_in_rule__LexicalHighlighting__Group__14156);
            rule__LexicalHighlighting__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2062:1: rule__LexicalHighlighting__Group__1__Impl : ( '{' ) ;
    public final void rule__LexicalHighlighting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2066:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2067:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2067:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2068:1: '{'
            {
             before(grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,11,FOLLOW_11_in_rule__LexicalHighlighting__Group__1__Impl4184); 
             after(grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2081:1: rule__LexicalHighlighting__Group__2 : rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3 ;
    public final void rule__LexicalHighlighting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2085:1: ( rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2086:2: rule__LexicalHighlighting__Group__2__Impl rule__LexicalHighlighting__Group__3
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__2__Impl_in_rule__LexicalHighlighting__Group__24215);
            rule__LexicalHighlighting__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__3_in_rule__LexicalHighlighting__Group__24218);
            rule__LexicalHighlighting__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2093:1: rule__LexicalHighlighting__Group__2__Impl : ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) ) ;
    public final void rule__LexicalHighlighting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2097:1: ( ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2098:1: ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2098:1: ( ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2099:1: ( ( rule__LexicalHighlighting__ListAssignment_2 ) ) ( ( rule__LexicalHighlighting__ListAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2099:1: ( ( rule__LexicalHighlighting__ListAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2100:1: ( rule__LexicalHighlighting__ListAssignment_2 )
            {
             before(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2101:1: ( rule__LexicalHighlighting__ListAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2101:2: rule__LexicalHighlighting__ListAssignment_2
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl4247);
            rule__LexicalHighlighting__ListAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2104:1: ( ( rule__LexicalHighlighting__ListAssignment_2 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2105:1: ( rule__LexicalHighlighting__ListAssignment_2 )*
            {
             before(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2106:1: ( rule__LexicalHighlighting__ListAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=15 && LA12_0<=16)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2106:2: rule__LexicalHighlighting__ListAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl4259);
            	    rule__LexicalHighlighting__ListAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getLexicalHighlightingAccess().getListAssignment_2()); 

            }


            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2117:1: rule__LexicalHighlighting__Group__3 : rule__LexicalHighlighting__Group__3__Impl ;
    public final void rule__LexicalHighlighting__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2121:1: ( rule__LexicalHighlighting__Group__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2122:2: rule__LexicalHighlighting__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__LexicalHighlighting__Group__3__Impl_in_rule__LexicalHighlighting__Group__34292);
            rule__LexicalHighlighting__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2128:1: rule__LexicalHighlighting__Group__3__Impl : ( '}' ) ;
    public final void rule__LexicalHighlighting__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2132:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2133:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2133:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2134:1: '}'
            {
             before(grammarAccess.getLexicalHighlightingAccess().getRightCurlyBracketKeyword_3()); 
            match(input,12,FOLLOW_12_in_rule__LexicalHighlighting__Group__3__Impl4320); 
             after(grammarAccess.getLexicalHighlightingAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2155:1: rule__LexicalPartitionHighlighting_JS__Group__0 : rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1 ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2159:1: ( rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2160:2: rule__LexicalPartitionHighlighting_JS__Group__0__Impl rule__LexicalPartitionHighlighting_JS__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__04359);
            rule__LexicalPartitionHighlighting_JS__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1_in_rule__LexicalPartitionHighlighting_JS__Group__04362);
            rule__LexicalPartitionHighlighting_JS__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2167:1: rule__LexicalPartitionHighlighting_JS__Group__0__Impl : ( 'script' ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2171:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2172:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2172:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2173:1: 'script'
            {
             before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__LexicalPartitionHighlighting_JS__Group__0__Impl4390); 
             after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2186:1: rule__LexicalPartitionHighlighting_JS__Group__1 : rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2 ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2190:1: ( rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2191:2: rule__LexicalPartitionHighlighting_JS__Group__1__Impl rule__LexicalPartitionHighlighting_JS__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__14421);
            rule__LexicalPartitionHighlighting_JS__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2_in_rule__LexicalPartitionHighlighting_JS__Group__14424);
            rule__LexicalPartitionHighlighting_JS__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2198:1: rule__LexicalPartitionHighlighting_JS__Group__1__Impl : ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2202:1: ( ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2203:1: ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2203:1: ( ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2204:1: ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 )
            {
             before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2205:1: ( rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2205:2: rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_JS__Group__1__Impl4451);
            rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2215:1: rule__LexicalPartitionHighlighting_JS__Group__2 : rule__LexicalPartitionHighlighting_JS__Group__2__Impl ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2219:1: ( rule__LexicalPartitionHighlighting_JS__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2220:2: rule__LexicalPartitionHighlighting_JS__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__24481);
            rule__LexicalPartitionHighlighting_JS__Group__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2226:1: rule__LexicalPartitionHighlighting_JS__Group__2__Impl : ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2230:1: ( ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2231:1: ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2231:1: ( ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2232:1: ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 )
            {
             before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURIAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2233:1: ( rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2233:2: rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2_in_rule__LexicalPartitionHighlighting_JS__Group__2__Impl4508);
            rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURIAssignment_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2249:1: rule__LexicalPartitionHighlighting_Rule__Group__0 : rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2253:1: ( rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2254:2: rule__LexicalPartitionHighlighting_Rule__Group__0__Impl rule__LexicalPartitionHighlighting_Rule__Group__1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__04544);
            rule__LexicalPartitionHighlighting_Rule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1_in_rule__LexicalPartitionHighlighting_Rule__Group__04547);
            rule__LexicalPartitionHighlighting_Rule__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2261:1: rule__LexicalPartitionHighlighting_Rule__Group__0__Impl : ( 'rule' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2265:1: ( ( 'rule' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2266:1: ( 'rule' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2266:1: ( 'rule' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2267:1: 'rule'
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl4575); 
             after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2280:1: rule__LexicalPartitionHighlighting_Rule__Group__1 : rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2284:1: ( rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2285:2: rule__LexicalPartitionHighlighting_Rule__Group__1__Impl rule__LexicalPartitionHighlighting_Rule__Group__2
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__14606);
            rule__LexicalPartitionHighlighting_Rule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2_in_rule__LexicalPartitionHighlighting_Rule__Group__14609);
            rule__LexicalPartitionHighlighting_Rule__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2292:1: rule__LexicalPartitionHighlighting_Rule__Group__1__Impl : ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2296:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2297:1: ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2297:1: ( ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2298:1: ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 )
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2299:1: ( rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2299:2: rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl4636);
            rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2309:1: rule__LexicalPartitionHighlighting_Rule__Group__2 : rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2313:1: ( rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2314:2: rule__LexicalPartitionHighlighting_Rule__Group__2__Impl rule__LexicalPartitionHighlighting_Rule__Group__3
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__24666);
            rule__LexicalPartitionHighlighting_Rule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3_in_rule__LexicalPartitionHighlighting_Rule__Group__24669);
            rule__LexicalPartitionHighlighting_Rule__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2321:1: rule__LexicalPartitionHighlighting_Rule__Group__2__Impl : ( '{' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2325:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2326:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2326:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2327:1: '{'
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,11,FOLLOW_11_in_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl4697); 
             after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2340:1: rule__LexicalPartitionHighlighting_Rule__Group__3 : rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4 ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2344:1: ( rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2345:2: rule__LexicalPartitionHighlighting_Rule__Group__3__Impl rule__LexicalPartitionHighlighting_Rule__Group__4
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__34728);
            rule__LexicalPartitionHighlighting_Rule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4_in_rule__LexicalPartitionHighlighting_Rule__Group__34731);
            rule__LexicalPartitionHighlighting_Rule__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2352:1: rule__LexicalPartitionHighlighting_Rule__Group__3__Impl : ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 )* ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2356:1: ( ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2357:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2357:1: ( ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2358:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 ) ) ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2358:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2359:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 )
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_3()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2360:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2360:2: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3_in_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl4760);
            rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_3()); 

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2363:1: ( ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2364:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 )*
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_3()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2365:1: ( rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID||LA13_0==30) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2365:2: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3_in_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl4772);
            	    rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListAssignment_3()); 

            }


            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2376:1: rule__LexicalPartitionHighlighting_Rule__Group__4 : rule__LexicalPartitionHighlighting_Rule__Group__4__Impl ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2380:1: ( rule__LexicalPartitionHighlighting_Rule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2381:2: rule__LexicalPartitionHighlighting_Rule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__44805);
            rule__LexicalPartitionHighlighting_Rule__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2387:1: rule__LexicalPartitionHighlighting_Rule__Group__4__Impl : ( '}' ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2391:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2392:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2392:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2393:1: '}'
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRightCurlyBracketKeyword_4()); 
            match(input,12,FOLLOW_12_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl4833); 
             after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__Token__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2416:1: rule__Token__Group__0 : rule__Token__Group__0__Impl rule__Token__Group__1 ;
    public final void rule__Token__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2420:1: ( rule__Token__Group__0__Impl rule__Token__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2421:2: rule__Token__Group__0__Impl rule__Token__Group__1
            {
            pushFollow(FOLLOW_rule__Token__Group__0__Impl_in_rule__Token__Group__04874);
            rule__Token__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Token__Group__1_in_rule__Token__Group__04877);
            rule__Token__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2428:1: rule__Token__Group__0__Impl : ( ( rule__Token__DefaultAssignment_0 )? ) ;
    public final void rule__Token__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2432:1: ( ( ( rule__Token__DefaultAssignment_0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2433:1: ( ( rule__Token__DefaultAssignment_0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2433:1: ( ( rule__Token__DefaultAssignment_0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2434:1: ( rule__Token__DefaultAssignment_0 )?
            {
             before(grammarAccess.getTokenAccess().getDefaultAssignment_0()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2435:1: ( rule__Token__DefaultAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2435:2: rule__Token__DefaultAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Token__DefaultAssignment_0_in_rule__Token__Group__0__Impl4904);
                    rule__Token__DefaultAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTokenAccess().getDefaultAssignment_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2445:1: rule__Token__Group__1 : rule__Token__Group__1__Impl rule__Token__Group__2 ;
    public final void rule__Token__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2449:1: ( rule__Token__Group__1__Impl rule__Token__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2450:2: rule__Token__Group__1__Impl rule__Token__Group__2
            {
            pushFollow(FOLLOW_rule__Token__Group__1__Impl_in_rule__Token__Group__14935);
            rule__Token__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Token__Group__2_in_rule__Token__Group__14938);
            rule__Token__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2457:1: rule__Token__Group__1__Impl : ( ( rule__Token__NameAssignment_1 ) ) ;
    public final void rule__Token__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2461:1: ( ( ( rule__Token__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2462:1: ( ( rule__Token__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2462:1: ( ( rule__Token__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2463:1: ( rule__Token__NameAssignment_1 )
            {
             before(grammarAccess.getTokenAccess().getNameAssignment_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2464:1: ( rule__Token__NameAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2464:2: rule__Token__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Token__NameAssignment_1_in_rule__Token__Group__1__Impl4965);
            rule__Token__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getNameAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2474:1: rule__Token__Group__2 : rule__Token__Group__2__Impl ;
    public final void rule__Token__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2478:1: ( rule__Token__Group__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2479:2: rule__Token__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Token__Group__2__Impl_in_rule__Token__Group__24995);
            rule__Token__Group__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2485:1: rule__Token__Group__2__Impl : ( ( rule__Token__Group_2__0 )? ) ;
    public final void rule__Token__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2489:1: ( ( ( rule__Token__Group_2__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2490:1: ( ( rule__Token__Group_2__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2490:1: ( ( rule__Token__Group_2__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2491:1: ( rule__Token__Group_2__0 )?
            {
             before(grammarAccess.getTokenAccess().getGroup_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2492:1: ( rule__Token__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==11) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2492:2: rule__Token__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Token__Group_2__0_in_rule__Token__Group__2__Impl5022);
                    rule__Token__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTokenAccess().getGroup_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2508:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2512:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2513:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
            {
            pushFollow(FOLLOW_rule__Token__Group_2__0__Impl_in_rule__Token__Group_2__05059);
            rule__Token__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Token__Group_2__1_in_rule__Token__Group_2__05062);
            rule__Token__Group_2__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2520:1: rule__Token__Group_2__0__Impl : ( '{' ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2524:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2525:1: ( '{' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2525:1: ( '{' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2526:1: '{'
            {
             before(grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0()); 
            match(input,11,FOLLOW_11_in_rule__Token__Group_2__0__Impl5090); 
             after(grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2539:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl rule__Token__Group_2__2 ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2543:1: ( rule__Token__Group_2__1__Impl rule__Token__Group_2__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2544:2: rule__Token__Group_2__1__Impl rule__Token__Group_2__2
            {
            pushFollow(FOLLOW_rule__Token__Group_2__1__Impl_in_rule__Token__Group_2__15121);
            rule__Token__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Token__Group_2__2_in_rule__Token__Group_2__15124);
            rule__Token__Group_2__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2551:1: rule__Token__Group_2__1__Impl : ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2555:1: ( ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2556:1: ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2556:1: ( ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2557:1: ( ( rule__Token__ScannerListAssignment_2_1 ) ) ( ( rule__Token__ScannerListAssignment_2_1 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2557:1: ( ( rule__Token__ScannerListAssignment_2_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2558:1: ( rule__Token__ScannerListAssignment_2_1 )
            {
             before(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2559:1: ( rule__Token__ScannerListAssignment_2_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2559:2: rule__Token__ScannerListAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl5153);
            rule__Token__ScannerListAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 

            }

            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2562:1: ( ( rule__Token__ScannerListAssignment_2_1 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2563:1: ( rule__Token__ScannerListAssignment_2_1 )*
            {
             before(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2564:1: ( rule__Token__ScannerListAssignment_2_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==15||LA16_0==17||LA16_0==21||LA16_0==23||(LA16_0>=28 && LA16_0<=29)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2564:2: rule__Token__ScannerListAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl5165);
            	    rule__Token__ScannerListAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getTokenAccess().getScannerListAssignment_2_1()); 

            }


            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2575:1: rule__Token__Group_2__2 : rule__Token__Group_2__2__Impl ;
    public final void rule__Token__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2579:1: ( rule__Token__Group_2__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2580:2: rule__Token__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Token__Group_2__2__Impl_in_rule__Token__Group_2__25198);
            rule__Token__Group_2__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2586:1: rule__Token__Group_2__2__Impl : ( '}' ) ;
    public final void rule__Token__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2590:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2591:1: ( '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2591:1: ( '}' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2592:1: '}'
            {
             before(grammarAccess.getTokenAccess().getRightCurlyBracketKeyword_2_2()); 
            match(input,12,FOLLOW_12_in_rule__Token__Group_2__2__Impl5226); 
             after(grammarAccess.getTokenAccess().getRightCurlyBracketKeyword_2_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2611:1: rule__Scanner_Keyword__Group__0 : rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1 ;
    public final void rule__Scanner_Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2615:1: ( rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2616:2: rule__Scanner_Keyword__Group__0__Impl rule__Scanner_Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__0__Impl_in_rule__Scanner_Keyword__Group__05263);
            rule__Scanner_Keyword__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__1_in_rule__Scanner_Keyword__Group__05266);
            rule__Scanner_Keyword__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2623:1: rule__Scanner_Keyword__Group__0__Impl : ( 'keywords' ) ;
    public final void rule__Scanner_Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2627:1: ( ( 'keywords' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2628:1: ( 'keywords' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2628:1: ( 'keywords' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2629:1: 'keywords'
            {
             before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__Scanner_Keyword__Group__0__Impl5294); 
             after(grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2642:1: rule__Scanner_Keyword__Group__1 : rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2 ;
    public final void rule__Scanner_Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2646:1: ( rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2647:2: rule__Scanner_Keyword__Group__1__Impl rule__Scanner_Keyword__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__1__Impl_in_rule__Scanner_Keyword__Group__15325);
            rule__Scanner_Keyword__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__2_in_rule__Scanner_Keyword__Group__15328);
            rule__Scanner_Keyword__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2654:1: rule__Scanner_Keyword__Group__1__Impl : ( '[' ) ;
    public final void rule__Scanner_Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2658:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2659:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2659:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2660:1: '['
            {
             before(grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1()); 
            match(input,24,FOLLOW_24_in_rule__Scanner_Keyword__Group__1__Impl5356); 
             after(grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2673:1: rule__Scanner_Keyword__Group__2 : rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3 ;
    public final void rule__Scanner_Keyword__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2677:1: ( rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2678:2: rule__Scanner_Keyword__Group__2__Impl rule__Scanner_Keyword__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__2__Impl_in_rule__Scanner_Keyword__Group__25387);
            rule__Scanner_Keyword__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__3_in_rule__Scanner_Keyword__Group__25390);
            rule__Scanner_Keyword__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2685:1: rule__Scanner_Keyword__Group__2__Impl : ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) ) ;
    public final void rule__Scanner_Keyword__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2689:1: ( ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2690:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2690:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2691:1: ( rule__Scanner_Keyword__KeywordsAssignment_2 )
            {
             before(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2692:1: ( rule__Scanner_Keyword__KeywordsAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2692:2: rule__Scanner_Keyword__KeywordsAssignment_2
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_2_in_rule__Scanner_Keyword__Group__2__Impl5417);
            rule__Scanner_Keyword__KeywordsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2702:1: rule__Scanner_Keyword__Group__3 : rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4 ;
    public final void rule__Scanner_Keyword__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2706:1: ( rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2707:2: rule__Scanner_Keyword__Group__3__Impl rule__Scanner_Keyword__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__3__Impl_in_rule__Scanner_Keyword__Group__35447);
            rule__Scanner_Keyword__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__4_in_rule__Scanner_Keyword__Group__35450);
            rule__Scanner_Keyword__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2714:1: rule__Scanner_Keyword__Group__3__Impl : ( ( rule__Scanner_Keyword__Group_3__0 )* ) ;
    public final void rule__Scanner_Keyword__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2718:1: ( ( ( rule__Scanner_Keyword__Group_3__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2719:1: ( ( rule__Scanner_Keyword__Group_3__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2719:1: ( ( rule__Scanner_Keyword__Group_3__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2720:1: ( rule__Scanner_Keyword__Group_3__0 )*
            {
             before(grammarAccess.getScanner_KeywordAccess().getGroup_3()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2721:1: ( rule__Scanner_Keyword__Group_3__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==26) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2721:2: rule__Scanner_Keyword__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__0_in_rule__Scanner_Keyword__Group__3__Impl5477);
            	    rule__Scanner_Keyword__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getScanner_KeywordAccess().getGroup_3()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2731:1: rule__Scanner_Keyword__Group__4 : rule__Scanner_Keyword__Group__4__Impl ;
    public final void rule__Scanner_Keyword__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2735:1: ( rule__Scanner_Keyword__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2736:2: rule__Scanner_Keyword__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group__4__Impl_in_rule__Scanner_Keyword__Group__45508);
            rule__Scanner_Keyword__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2742:1: rule__Scanner_Keyword__Group__4__Impl : ( ']' ) ;
    public final void rule__Scanner_Keyword__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2746:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2747:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2747:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2748:1: ']'
            {
             before(grammarAccess.getScanner_KeywordAccess().getRightSquareBracketKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__Scanner_Keyword__Group__4__Impl5536); 
             after(grammarAccess.getScanner_KeywordAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2771:1: rule__Scanner_Keyword__Group_3__0 : rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1 ;
    public final void rule__Scanner_Keyword__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2775:1: ( rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2776:2: rule__Scanner_Keyword__Group_3__0__Impl rule__Scanner_Keyword__Group_3__1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__0__Impl_in_rule__Scanner_Keyword__Group_3__05577);
            rule__Scanner_Keyword__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__1_in_rule__Scanner_Keyword__Group_3__05580);
            rule__Scanner_Keyword__Group_3__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2783:1: rule__Scanner_Keyword__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Scanner_Keyword__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2787:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2788:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2788:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2789:1: ','
            {
             before(grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0()); 
            match(input,26,FOLLOW_26_in_rule__Scanner_Keyword__Group_3__0__Impl5608); 
             after(grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2802:1: rule__Scanner_Keyword__Group_3__1 : rule__Scanner_Keyword__Group_3__1__Impl ;
    public final void rule__Scanner_Keyword__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2806:1: ( rule__Scanner_Keyword__Group_3__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2807:2: rule__Scanner_Keyword__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__Group_3__1__Impl_in_rule__Scanner_Keyword__Group_3__15639);
            rule__Scanner_Keyword__Group_3__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2813:1: rule__Scanner_Keyword__Group_3__1__Impl : ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) ) ;
    public final void rule__Scanner_Keyword__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2817:1: ( ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2818:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2818:1: ( ( rule__Scanner_Keyword__KeywordsAssignment_3_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2819:1: ( rule__Scanner_Keyword__KeywordsAssignment_3_1 )
            {
             before(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_3_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2820:1: ( rule__Scanner_Keyword__KeywordsAssignment_3_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2820:2: rule__Scanner_Keyword__KeywordsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_3_1_in_rule__Scanner_Keyword__Group_3__1__Impl5666);
            rule__Scanner_Keyword__KeywordsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getScanner_KeywordAccess().getKeywordsAssignment_3_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2834:1: rule__Keyword__Group__0 : rule__Keyword__Group__0__Impl rule__Keyword__Group__1 ;
    public final void rule__Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2838:1: ( rule__Keyword__Group__0__Impl rule__Keyword__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2839:2: rule__Keyword__Group__0__Impl rule__Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__05700);
            rule__Keyword__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__05703);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2846:1: rule__Keyword__Group__0__Impl : ( ( rule__Keyword__NameAssignment_0 ) ) ;
    public final void rule__Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2850:1: ( ( ( rule__Keyword__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2851:1: ( ( rule__Keyword__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2851:1: ( ( rule__Keyword__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2852:1: ( rule__Keyword__NameAssignment_0 )
            {
             before(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2853:1: ( rule__Keyword__NameAssignment_0 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2853:2: rule__Keyword__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl5730);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2863:1: rule__Keyword__Group__1 : rule__Keyword__Group__1__Impl ;
    public final void rule__Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2867:1: ( rule__Keyword__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2868:2: rule__Keyword__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__15760);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2874:1: rule__Keyword__Group__1__Impl : ( ( rule__Keyword__Group_1__0 )? ) ;
    public final void rule__Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2878:1: ( ( ( rule__Keyword__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2879:1: ( ( rule__Keyword__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2879:1: ( ( rule__Keyword__Group_1__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2880:1: ( rule__Keyword__Group_1__0 )?
            {
             before(grammarAccess.getKeywordAccess().getGroup_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2881:1: ( rule__Keyword__Group_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2881:2: rule__Keyword__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl5787);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2895:1: rule__Keyword__Group_1__0 : rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 ;
    public final void rule__Keyword__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2899:1: ( rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2900:2: rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__05822);
            rule__Keyword__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__05825);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2907:1: rule__Keyword__Group_1__0__Impl : ( 'since' ) ;
    public final void rule__Keyword__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2911:1: ( ( 'since' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2912:1: ( 'since' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2912:1: ( 'since' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2913:1: 'since'
            {
             before(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            match(input,27,FOLLOW_27_in_rule__Keyword__Group_1__0__Impl5853); 
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2926:1: rule__Keyword__Group_1__1 : rule__Keyword__Group_1__1__Impl ;
    public final void rule__Keyword__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2930:1: ( rule__Keyword__Group_1__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2931:2: rule__Keyword__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__15884);
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2937:1: rule__Keyword__Group_1__1__Impl : ( ( rule__Keyword__VersionAssignment_1_1 ) ) ;
    public final void rule__Keyword__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2941:1: ( ( ( rule__Keyword__VersionAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2942:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2942:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2943:1: ( rule__Keyword__VersionAssignment_1_1 )
            {
             before(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2944:1: ( rule__Keyword__VersionAssignment_1_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2944:2: rule__Keyword__VersionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl5911);
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


    // $ANTLR start "rule__Scanner_SingleLineRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2958:1: rule__Scanner_SingleLineRule__Group__0 : rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1 ;
    public final void rule__Scanner_SingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2962:1: ( rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2963:2: rule__Scanner_SingleLineRule__Group__0__Impl rule__Scanner_SingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__0__Impl_in_rule__Scanner_SingleLineRule__Group__05945);
            rule__Scanner_SingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__1_in_rule__Scanner_SingleLineRule__Group__05948);
            rule__Scanner_SingleLineRule__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2970:1: rule__Scanner_SingleLineRule__Group__0__Impl : ( 'single_line' ) ;
    public final void rule__Scanner_SingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2974:1: ( ( 'single_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2975:1: ( 'single_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2975:1: ( 'single_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2976:1: 'single_line'
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Scanner_SingleLineRule__Group__0__Impl5976); 
             after(grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2989:1: rule__Scanner_SingleLineRule__Group__1 : rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2 ;
    public final void rule__Scanner_SingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2993:1: ( rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:2994:2: rule__Scanner_SingleLineRule__Group__1__Impl rule__Scanner_SingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__1__Impl_in_rule__Scanner_SingleLineRule__Group__16007);
            rule__Scanner_SingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__2_in_rule__Scanner_SingleLineRule__Group__16010);
            rule__Scanner_SingleLineRule__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3001:1: rule__Scanner_SingleLineRule__Group__1__Impl : ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3005:1: ( ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3006:1: ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3006:1: ( ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3007:1: ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 )
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqAssignment_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3008:1: ( rule__Scanner_SingleLineRule__StartSeqAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3008:2: rule__Scanner_SingleLineRule__StartSeqAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__StartSeqAssignment_1_in_rule__Scanner_SingleLineRule__Group__1__Impl6037);
            rule__Scanner_SingleLineRule__StartSeqAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3018:1: rule__Scanner_SingleLineRule__Group__2 : rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3 ;
    public final void rule__Scanner_SingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3022:1: ( rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3023:2: rule__Scanner_SingleLineRule__Group__2__Impl rule__Scanner_SingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__2__Impl_in_rule__Scanner_SingleLineRule__Group__26067);
            rule__Scanner_SingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__3_in_rule__Scanner_SingleLineRule__Group__26070);
            rule__Scanner_SingleLineRule__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3030:1: rule__Scanner_SingleLineRule__Group__2__Impl : ( '=>' ) ;
    public final void rule__Scanner_SingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3034:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3035:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3035:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3036:1: '=>'
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__Scanner_SingleLineRule__Group__2__Impl6098); 
             after(grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3049:1: rule__Scanner_SingleLineRule__Group__3 : rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4 ;
    public final void rule__Scanner_SingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3053:1: ( rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3054:2: rule__Scanner_SingleLineRule__Group__3__Impl rule__Scanner_SingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__3__Impl_in_rule__Scanner_SingleLineRule__Group__36129);
            rule__Scanner_SingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__4_in_rule__Scanner_SingleLineRule__Group__36132);
            rule__Scanner_SingleLineRule__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3061:1: rule__Scanner_SingleLineRule__Group__3__Impl : ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3065:1: ( ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3066:1: ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3066:1: ( ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3067:1: ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )?
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqAssignment_3()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3068:1: ( rule__Scanner_SingleLineRule__EndSeqAssignment_3 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_STRING) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3068:2: rule__Scanner_SingleLineRule__EndSeqAssignment_3
                    {
                    pushFollow(FOLLOW_rule__Scanner_SingleLineRule__EndSeqAssignment_3_in_rule__Scanner_SingleLineRule__Group__3__Impl6159);
                    rule__Scanner_SingleLineRule__EndSeqAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqAssignment_3()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3078:1: rule__Scanner_SingleLineRule__Group__4 : rule__Scanner_SingleLineRule__Group__4__Impl ;
    public final void rule__Scanner_SingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3082:1: ( rule__Scanner_SingleLineRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3083:2: rule__Scanner_SingleLineRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group__4__Impl_in_rule__Scanner_SingleLineRule__Group__46190);
            rule__Scanner_SingleLineRule__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3089:1: rule__Scanner_SingleLineRule__Group__4__Impl : ( ( rule__Scanner_SingleLineRule__Group_4__0 )? ) ;
    public final void rule__Scanner_SingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3093:1: ( ( ( rule__Scanner_SingleLineRule__Group_4__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3094:1: ( ( rule__Scanner_SingleLineRule__Group_4__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3094:1: ( ( rule__Scanner_SingleLineRule__Group_4__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3095:1: ( rule__Scanner_SingleLineRule__Group_4__0 )?
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_4()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3096:1: ( rule__Scanner_SingleLineRule__Group_4__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==19) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3096:2: rule__Scanner_SingleLineRule__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__0_in_rule__Scanner_SingleLineRule__Group__4__Impl6217);
                    rule__Scanner_SingleLineRule__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScanner_SingleLineRuleAccess().getGroup_4()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3116:1: rule__Scanner_SingleLineRule__Group_4__0 : rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1 ;
    public final void rule__Scanner_SingleLineRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3120:1: ( rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3121:2: rule__Scanner_SingleLineRule__Group_4__0__Impl rule__Scanner_SingleLineRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__0__Impl_in_rule__Scanner_SingleLineRule__Group_4__06258);
            rule__Scanner_SingleLineRule__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__1_in_rule__Scanner_SingleLineRule__Group_4__06261);
            rule__Scanner_SingleLineRule__Group_4__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3128:1: rule__Scanner_SingleLineRule__Group_4__0__Impl : ( 'escaped' ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3132:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3133:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3133:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3134:1: 'escaped'
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_4_0()); 
            match(input,19,FOLLOW_19_in_rule__Scanner_SingleLineRule__Group_4__0__Impl6289); 
             after(grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_4_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3147:1: rule__Scanner_SingleLineRule__Group_4__1 : rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2 ;
    public final void rule__Scanner_SingleLineRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3151:1: ( rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3152:2: rule__Scanner_SingleLineRule__Group_4__1__Impl rule__Scanner_SingleLineRule__Group_4__2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__1__Impl_in_rule__Scanner_SingleLineRule__Group_4__16320);
            rule__Scanner_SingleLineRule__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__2_in_rule__Scanner_SingleLineRule__Group_4__16323);
            rule__Scanner_SingleLineRule__Group_4__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3159:1: rule__Scanner_SingleLineRule__Group_4__1__Impl : ( 'by' ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3163:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3164:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3164:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3165:1: 'by'
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_4_1()); 
            match(input,20,FOLLOW_20_in_rule__Scanner_SingleLineRule__Group_4__1__Impl6351); 
             after(grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_4_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3178:1: rule__Scanner_SingleLineRule__Group_4__2 : rule__Scanner_SingleLineRule__Group_4__2__Impl ;
    public final void rule__Scanner_SingleLineRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3182:1: ( rule__Scanner_SingleLineRule__Group_4__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3183:2: rule__Scanner_SingleLineRule__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__Group_4__2__Impl_in_rule__Scanner_SingleLineRule__Group_4__26382);
            rule__Scanner_SingleLineRule__Group_4__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3189:1: rule__Scanner_SingleLineRule__Group_4__2__Impl : ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) ) ;
    public final void rule__Scanner_SingleLineRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3193:1: ( ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3194:1: ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3194:1: ( ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3195:1: ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 )
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3196:1: ( rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3196:2: rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2
            {
            pushFollow(FOLLOW_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_SingleLineRule__Group_4__2__Impl6409);
            rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2();

            state._fsp--;


            }

             after(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqAssignment_4_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3212:1: rule__Scanner_MultiLineRule__Group__0 : rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1 ;
    public final void rule__Scanner_MultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3216:1: ( rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3217:2: rule__Scanner_MultiLineRule__Group__0__Impl rule__Scanner_MultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__0__Impl_in_rule__Scanner_MultiLineRule__Group__06445);
            rule__Scanner_MultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__1_in_rule__Scanner_MultiLineRule__Group__06448);
            rule__Scanner_MultiLineRule__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3224:1: rule__Scanner_MultiLineRule__Group__0__Impl : ( 'multi_line' ) ;
    public final void rule__Scanner_MultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3228:1: ( ( 'multi_line' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3229:1: ( 'multi_line' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3229:1: ( 'multi_line' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3230:1: 'multi_line'
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__Scanner_MultiLineRule__Group__0__Impl6476); 
             after(grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3243:1: rule__Scanner_MultiLineRule__Group__1 : rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2 ;
    public final void rule__Scanner_MultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3247:1: ( rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3248:2: rule__Scanner_MultiLineRule__Group__1__Impl rule__Scanner_MultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__1__Impl_in_rule__Scanner_MultiLineRule__Group__16507);
            rule__Scanner_MultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__2_in_rule__Scanner_MultiLineRule__Group__16510);
            rule__Scanner_MultiLineRule__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3255:1: rule__Scanner_MultiLineRule__Group__1__Impl : ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3259:1: ( ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3260:1: ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3260:1: ( ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3261:1: ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 )
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqAssignment_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3262:1: ( rule__Scanner_MultiLineRule__StartSeqAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3262:2: rule__Scanner_MultiLineRule__StartSeqAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__StartSeqAssignment_1_in_rule__Scanner_MultiLineRule__Group__1__Impl6537);
            rule__Scanner_MultiLineRule__StartSeqAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3272:1: rule__Scanner_MultiLineRule__Group__2 : rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3 ;
    public final void rule__Scanner_MultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3276:1: ( rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3277:2: rule__Scanner_MultiLineRule__Group__2__Impl rule__Scanner_MultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__2__Impl_in_rule__Scanner_MultiLineRule__Group__26567);
            rule__Scanner_MultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__3_in_rule__Scanner_MultiLineRule__Group__26570);
            rule__Scanner_MultiLineRule__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3284:1: rule__Scanner_MultiLineRule__Group__2__Impl : ( '=>' ) ;
    public final void rule__Scanner_MultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3288:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3289:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3289:1: ( '=>' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3290:1: '=>'
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__Scanner_MultiLineRule__Group__2__Impl6598); 
             after(grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3303:1: rule__Scanner_MultiLineRule__Group__3 : rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4 ;
    public final void rule__Scanner_MultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3307:1: ( rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3308:2: rule__Scanner_MultiLineRule__Group__3__Impl rule__Scanner_MultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__3__Impl_in_rule__Scanner_MultiLineRule__Group__36629);
            rule__Scanner_MultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__4_in_rule__Scanner_MultiLineRule__Group__36632);
            rule__Scanner_MultiLineRule__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3315:1: rule__Scanner_MultiLineRule__Group__3__Impl : ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3319:1: ( ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3320:1: ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3320:1: ( ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3321:1: ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 )
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqAssignment_3()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3322:1: ( rule__Scanner_MultiLineRule__EndSeqAssignment_3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3322:2: rule__Scanner_MultiLineRule__EndSeqAssignment_3
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__EndSeqAssignment_3_in_rule__Scanner_MultiLineRule__Group__3__Impl6659);
            rule__Scanner_MultiLineRule__EndSeqAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqAssignment_3()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3332:1: rule__Scanner_MultiLineRule__Group__4 : rule__Scanner_MultiLineRule__Group__4__Impl ;
    public final void rule__Scanner_MultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3336:1: ( rule__Scanner_MultiLineRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3337:2: rule__Scanner_MultiLineRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group__4__Impl_in_rule__Scanner_MultiLineRule__Group__46689);
            rule__Scanner_MultiLineRule__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3343:1: rule__Scanner_MultiLineRule__Group__4__Impl : ( ( rule__Scanner_MultiLineRule__Group_4__0 )? ) ;
    public final void rule__Scanner_MultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3347:1: ( ( ( rule__Scanner_MultiLineRule__Group_4__0 )? ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3348:1: ( ( rule__Scanner_MultiLineRule__Group_4__0 )? )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3348:1: ( ( rule__Scanner_MultiLineRule__Group_4__0 )? )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3349:1: ( rule__Scanner_MultiLineRule__Group_4__0 )?
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getGroup_4()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3350:1: ( rule__Scanner_MultiLineRule__Group_4__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3350:2: rule__Scanner_MultiLineRule__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__0_in_rule__Scanner_MultiLineRule__Group__4__Impl6716);
                    rule__Scanner_MultiLineRule__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScanner_MultiLineRuleAccess().getGroup_4()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3370:1: rule__Scanner_MultiLineRule__Group_4__0 : rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1 ;
    public final void rule__Scanner_MultiLineRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3374:1: ( rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3375:2: rule__Scanner_MultiLineRule__Group_4__0__Impl rule__Scanner_MultiLineRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__0__Impl_in_rule__Scanner_MultiLineRule__Group_4__06757);
            rule__Scanner_MultiLineRule__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__1_in_rule__Scanner_MultiLineRule__Group_4__06760);
            rule__Scanner_MultiLineRule__Group_4__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3382:1: rule__Scanner_MultiLineRule__Group_4__0__Impl : ( 'escaped' ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3386:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3387:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3387:1: ( 'escaped' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3388:1: 'escaped'
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_4_0()); 
            match(input,19,FOLLOW_19_in_rule__Scanner_MultiLineRule__Group_4__0__Impl6788); 
             after(grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_4_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3401:1: rule__Scanner_MultiLineRule__Group_4__1 : rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2 ;
    public final void rule__Scanner_MultiLineRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3405:1: ( rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3406:2: rule__Scanner_MultiLineRule__Group_4__1__Impl rule__Scanner_MultiLineRule__Group_4__2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__1__Impl_in_rule__Scanner_MultiLineRule__Group_4__16819);
            rule__Scanner_MultiLineRule__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__2_in_rule__Scanner_MultiLineRule__Group_4__16822);
            rule__Scanner_MultiLineRule__Group_4__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3413:1: rule__Scanner_MultiLineRule__Group_4__1__Impl : ( 'by' ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3417:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3418:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3418:1: ( 'by' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3419:1: 'by'
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_4_1()); 
            match(input,20,FOLLOW_20_in_rule__Scanner_MultiLineRule__Group_4__1__Impl6850); 
             after(grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_4_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3432:1: rule__Scanner_MultiLineRule__Group_4__2 : rule__Scanner_MultiLineRule__Group_4__2__Impl ;
    public final void rule__Scanner_MultiLineRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3436:1: ( rule__Scanner_MultiLineRule__Group_4__2__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3437:2: rule__Scanner_MultiLineRule__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__Group_4__2__Impl_in_rule__Scanner_MultiLineRule__Group_4__26881);
            rule__Scanner_MultiLineRule__Group_4__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3443:1: rule__Scanner_MultiLineRule__Group_4__2__Impl : ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) ) ;
    public final void rule__Scanner_MultiLineRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3447:1: ( ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3448:1: ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3448:1: ( ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3449:1: ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 )
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqAssignment_4_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3450:1: ( rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3450:2: rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2
            {
            pushFollow(FOLLOW_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_MultiLineRule__Group_4__2__Impl6908);
            rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2();

            state._fsp--;


            }

             after(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqAssignment_4_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3466:1: rule__Scanner_CharacterRule__Group__0 : rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1 ;
    public final void rule__Scanner_CharacterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3470:1: ( rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3471:2: rule__Scanner_CharacterRule__Group__0__Impl rule__Scanner_CharacterRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__0__Impl_in_rule__Scanner_CharacterRule__Group__06944);
            rule__Scanner_CharacterRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__1_in_rule__Scanner_CharacterRule__Group__06947);
            rule__Scanner_CharacterRule__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3478:1: rule__Scanner_CharacterRule__Group__0__Impl : ( 'character' ) ;
    public final void rule__Scanner_CharacterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3482:1: ( ( 'character' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3483:1: ( 'character' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3483:1: ( 'character' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3484:1: 'character'
            {
             before(grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__Scanner_CharacterRule__Group__0__Impl6975); 
             after(grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3497:1: rule__Scanner_CharacterRule__Group__1 : rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2 ;
    public final void rule__Scanner_CharacterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3501:1: ( rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3502:2: rule__Scanner_CharacterRule__Group__1__Impl rule__Scanner_CharacterRule__Group__2
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__1__Impl_in_rule__Scanner_CharacterRule__Group__17006);
            rule__Scanner_CharacterRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__2_in_rule__Scanner_CharacterRule__Group__17009);
            rule__Scanner_CharacterRule__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3509:1: rule__Scanner_CharacterRule__Group__1__Impl : ( '[' ) ;
    public final void rule__Scanner_CharacterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3513:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3514:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3514:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3515:1: '['
            {
             before(grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1()); 
            match(input,24,FOLLOW_24_in_rule__Scanner_CharacterRule__Group__1__Impl7037); 
             after(grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3528:1: rule__Scanner_CharacterRule__Group__2 : rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3 ;
    public final void rule__Scanner_CharacterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3532:1: ( rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3533:2: rule__Scanner_CharacterRule__Group__2__Impl rule__Scanner_CharacterRule__Group__3
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__2__Impl_in_rule__Scanner_CharacterRule__Group__27068);
            rule__Scanner_CharacterRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__3_in_rule__Scanner_CharacterRule__Group__27071);
            rule__Scanner_CharacterRule__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3540:1: rule__Scanner_CharacterRule__Group__2__Impl : ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) ) ;
    public final void rule__Scanner_CharacterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3544:1: ( ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3545:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3545:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_2 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3546:1: ( rule__Scanner_CharacterRule__CharactersAssignment_2 )
            {
             before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3547:1: ( rule__Scanner_CharacterRule__CharactersAssignment_2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3547:2: rule__Scanner_CharacterRule__CharactersAssignment_2
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_2_in_rule__Scanner_CharacterRule__Group__2__Impl7098);
            rule__Scanner_CharacterRule__CharactersAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_2()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3557:1: rule__Scanner_CharacterRule__Group__3 : rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4 ;
    public final void rule__Scanner_CharacterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3561:1: ( rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3562:2: rule__Scanner_CharacterRule__Group__3__Impl rule__Scanner_CharacterRule__Group__4
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__3__Impl_in_rule__Scanner_CharacterRule__Group__37128);
            rule__Scanner_CharacterRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__4_in_rule__Scanner_CharacterRule__Group__37131);
            rule__Scanner_CharacterRule__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3569:1: rule__Scanner_CharacterRule__Group__3__Impl : ( ( rule__Scanner_CharacterRule__Group_3__0 )* ) ;
    public final void rule__Scanner_CharacterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3573:1: ( ( ( rule__Scanner_CharacterRule__Group_3__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3574:1: ( ( rule__Scanner_CharacterRule__Group_3__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3574:1: ( ( rule__Scanner_CharacterRule__Group_3__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3575:1: ( rule__Scanner_CharacterRule__Group_3__0 )*
            {
             before(grammarAccess.getScanner_CharacterRuleAccess().getGroup_3()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3576:1: ( rule__Scanner_CharacterRule__Group_3__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==26) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3576:2: rule__Scanner_CharacterRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__0_in_rule__Scanner_CharacterRule__Group__3__Impl7158);
            	    rule__Scanner_CharacterRule__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getScanner_CharacterRuleAccess().getGroup_3()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3586:1: rule__Scanner_CharacterRule__Group__4 : rule__Scanner_CharacterRule__Group__4__Impl ;
    public final void rule__Scanner_CharacterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3590:1: ( rule__Scanner_CharacterRule__Group__4__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3591:2: rule__Scanner_CharacterRule__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group__4__Impl_in_rule__Scanner_CharacterRule__Group__47189);
            rule__Scanner_CharacterRule__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3597:1: rule__Scanner_CharacterRule__Group__4__Impl : ( ']' ) ;
    public final void rule__Scanner_CharacterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3601:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3602:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3602:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3603:1: ']'
            {
             before(grammarAccess.getScanner_CharacterRuleAccess().getRightSquareBracketKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__Scanner_CharacterRule__Group__4__Impl7217); 
             after(grammarAccess.getScanner_CharacterRuleAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3626:1: rule__Scanner_CharacterRule__Group_3__0 : rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1 ;
    public final void rule__Scanner_CharacterRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3630:1: ( rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3631:2: rule__Scanner_CharacterRule__Group_3__0__Impl rule__Scanner_CharacterRule__Group_3__1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__0__Impl_in_rule__Scanner_CharacterRule__Group_3__07258);
            rule__Scanner_CharacterRule__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__1_in_rule__Scanner_CharacterRule__Group_3__07261);
            rule__Scanner_CharacterRule__Group_3__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3638:1: rule__Scanner_CharacterRule__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Scanner_CharacterRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3642:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3643:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3643:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3644:1: ','
            {
             before(grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0()); 
            match(input,26,FOLLOW_26_in_rule__Scanner_CharacterRule__Group_3__0__Impl7289); 
             after(grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3657:1: rule__Scanner_CharacterRule__Group_3__1 : rule__Scanner_CharacterRule__Group_3__1__Impl ;
    public final void rule__Scanner_CharacterRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3661:1: ( rule__Scanner_CharacterRule__Group_3__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3662:2: rule__Scanner_CharacterRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__Group_3__1__Impl_in_rule__Scanner_CharacterRule__Group_3__17320);
            rule__Scanner_CharacterRule__Group_3__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3668:1: rule__Scanner_CharacterRule__Group_3__1__Impl : ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) ) ;
    public final void rule__Scanner_CharacterRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3672:1: ( ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3673:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3673:1: ( ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3674:1: ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 )
            {
             before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_3_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3675:1: ( rule__Scanner_CharacterRule__CharactersAssignment_3_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3675:2: rule__Scanner_CharacterRule__CharactersAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_3_1_in_rule__Scanner_CharacterRule__Group_3__1__Impl7347);
            rule__Scanner_CharacterRule__CharactersAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getScanner_CharacterRuleAccess().getCharactersAssignment_3_1()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3689:1: rule__Scanner_JSRule__Group__0 : rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1 ;
    public final void rule__Scanner_JSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3693:1: ( rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3694:2: rule__Scanner_JSRule__Group__0__Impl rule__Scanner_JSRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__0__Impl_in_rule__Scanner_JSRule__Group__07381);
            rule__Scanner_JSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__1_in_rule__Scanner_JSRule__Group__07384);
            rule__Scanner_JSRule__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3701:1: rule__Scanner_JSRule__Group__0__Impl : ( 'script' ) ;
    public final void rule__Scanner_JSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3705:1: ( ( 'script' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3706:1: ( 'script' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3706:1: ( 'script' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3707:1: 'script'
            {
             before(grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__Scanner_JSRule__Group__0__Impl7412); 
             after(grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3720:1: rule__Scanner_JSRule__Group__1 : rule__Scanner_JSRule__Group__1__Impl ;
    public final void rule__Scanner_JSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3724:1: ( rule__Scanner_JSRule__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3725:2: rule__Scanner_JSRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__Group__1__Impl_in_rule__Scanner_JSRule__Group__17443);
            rule__Scanner_JSRule__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3731:1: rule__Scanner_JSRule__Group__1__Impl : ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) ) ;
    public final void rule__Scanner_JSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3735:1: ( ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3736:1: ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3736:1: ( ( rule__Scanner_JSRule__FileURIAssignment_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3737:1: ( rule__Scanner_JSRule__FileURIAssignment_1 )
            {
             before(grammarAccess.getScanner_JSRuleAccess().getFileURIAssignment_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3738:1: ( rule__Scanner_JSRule__FileURIAssignment_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3738:2: rule__Scanner_JSRule__FileURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Scanner_JSRule__FileURIAssignment_1_in_rule__Scanner_JSRule__Group__1__Impl7470);
            rule__Scanner_JSRule__FileURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getScanner_JSRuleAccess().getFileURIAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3752:1: rule__Scanner_WhitespaceRule__Group__0 : rule__Scanner_WhitespaceRule__Group__0__Impl rule__Scanner_WhitespaceRule__Group__1 ;
    public final void rule__Scanner_WhitespaceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3756:1: ( rule__Scanner_WhitespaceRule__Group__0__Impl rule__Scanner_WhitespaceRule__Group__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3757:2: rule__Scanner_WhitespaceRule__Group__0__Impl rule__Scanner_WhitespaceRule__Group__1
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group__0__Impl_in_rule__Scanner_WhitespaceRule__Group__07504);
            rule__Scanner_WhitespaceRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group__1_in_rule__Scanner_WhitespaceRule__Group__07507);
            rule__Scanner_WhitespaceRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group__0"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3764:1: rule__Scanner_WhitespaceRule__Group__0__Impl : ( 'whitespace' ) ;
    public final void rule__Scanner_WhitespaceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3768:1: ( ( 'whitespace' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3769:1: ( 'whitespace' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3769:1: ( 'whitespace' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3770:1: 'whitespace'
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getWhitespaceKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__Scanner_WhitespaceRule__Group__0__Impl7535); 
             after(grammarAccess.getScanner_WhitespaceRuleAccess().getWhitespaceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group__0__Impl"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3783:1: rule__Scanner_WhitespaceRule__Group__1 : rule__Scanner_WhitespaceRule__Group__1__Impl ;
    public final void rule__Scanner_WhitespaceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3787:1: ( rule__Scanner_WhitespaceRule__Group__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3788:2: rule__Scanner_WhitespaceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group__1__Impl_in_rule__Scanner_WhitespaceRule__Group__17566);
            rule__Scanner_WhitespaceRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group__1"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3794:1: rule__Scanner_WhitespaceRule__Group__1__Impl : ( ( rule__Scanner_WhitespaceRule__Alternatives_1 ) ) ;
    public final void rule__Scanner_WhitespaceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3798:1: ( ( ( rule__Scanner_WhitespaceRule__Alternatives_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3799:1: ( ( rule__Scanner_WhitespaceRule__Alternatives_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3799:1: ( ( rule__Scanner_WhitespaceRule__Alternatives_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3800:1: ( rule__Scanner_WhitespaceRule__Alternatives_1 )
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getAlternatives_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3801:1: ( rule__Scanner_WhitespaceRule__Alternatives_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3801:2: rule__Scanner_WhitespaceRule__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Alternatives_1_in_rule__Scanner_WhitespaceRule__Group__1__Impl7593);
            rule__Scanner_WhitespaceRule__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getScanner_WhitespaceRuleAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group__1__Impl"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3815:1: rule__Scanner_WhitespaceRule__Group_1_0__0 : rule__Scanner_WhitespaceRule__Group_1_0__0__Impl rule__Scanner_WhitespaceRule__Group_1_0__1 ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3819:1: ( rule__Scanner_WhitespaceRule__Group_1_0__0__Impl rule__Scanner_WhitespaceRule__Group_1_0__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3820:2: rule__Scanner_WhitespaceRule__Group_1_0__0__Impl rule__Scanner_WhitespaceRule__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__0__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0__07627);
            rule__Scanner_WhitespaceRule__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__1_in_rule__Scanner_WhitespaceRule__Group_1_0__07630);
            rule__Scanner_WhitespaceRule__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0__0"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3827:1: rule__Scanner_WhitespaceRule__Group_1_0__0__Impl : ( '[' ) ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3831:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3832:1: ( '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3832:1: ( '[' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3833:1: '['
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0()); 
            match(input,24,FOLLOW_24_in_rule__Scanner_WhitespaceRule__Group_1_0__0__Impl7658); 
             after(grammarAccess.getScanner_WhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0__0__Impl"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3846:1: rule__Scanner_WhitespaceRule__Group_1_0__1 : rule__Scanner_WhitespaceRule__Group_1_0__1__Impl rule__Scanner_WhitespaceRule__Group_1_0__2 ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3850:1: ( rule__Scanner_WhitespaceRule__Group_1_0__1__Impl rule__Scanner_WhitespaceRule__Group_1_0__2 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3851:2: rule__Scanner_WhitespaceRule__Group_1_0__1__Impl rule__Scanner_WhitespaceRule__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__1__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0__17689);
            rule__Scanner_WhitespaceRule__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__2_in_rule__Scanner_WhitespaceRule__Group_1_0__17692);
            rule__Scanner_WhitespaceRule__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0__1"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3858:1: rule__Scanner_WhitespaceRule__Group_1_0__1__Impl : ( ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1 ) ) ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3862:1: ( ( ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3863:1: ( ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3863:1: ( ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3864:1: ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1 )
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getCharactersAssignment_1_0_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3865:1: ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3865:2: rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1_in_rule__Scanner_WhitespaceRule__Group_1_0__1__Impl7719);
            rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1();

            state._fsp--;


            }

             after(grammarAccess.getScanner_WhitespaceRuleAccess().getCharactersAssignment_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0__1__Impl"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0__2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3875:1: rule__Scanner_WhitespaceRule__Group_1_0__2 : rule__Scanner_WhitespaceRule__Group_1_0__2__Impl rule__Scanner_WhitespaceRule__Group_1_0__3 ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3879:1: ( rule__Scanner_WhitespaceRule__Group_1_0__2__Impl rule__Scanner_WhitespaceRule__Group_1_0__3 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3880:2: rule__Scanner_WhitespaceRule__Group_1_0__2__Impl rule__Scanner_WhitespaceRule__Group_1_0__3
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__2__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0__27749);
            rule__Scanner_WhitespaceRule__Group_1_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__3_in_rule__Scanner_WhitespaceRule__Group_1_0__27752);
            rule__Scanner_WhitespaceRule__Group_1_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0__2"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0__2__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3887:1: rule__Scanner_WhitespaceRule__Group_1_0__2__Impl : ( ( rule__Scanner_WhitespaceRule__Group_1_0_2__0 )* ) ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3891:1: ( ( ( rule__Scanner_WhitespaceRule__Group_1_0_2__0 )* ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3892:1: ( ( rule__Scanner_WhitespaceRule__Group_1_0_2__0 )* )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3892:1: ( ( rule__Scanner_WhitespaceRule__Group_1_0_2__0 )* )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3893:1: ( rule__Scanner_WhitespaceRule__Group_1_0_2__0 )*
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getGroup_1_0_2()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3894:1: ( rule__Scanner_WhitespaceRule__Group_1_0_2__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==26) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3894:2: rule__Scanner_WhitespaceRule__Group_1_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0_2__0_in_rule__Scanner_WhitespaceRule__Group_1_0__2__Impl7779);
            	    rule__Scanner_WhitespaceRule__Group_1_0_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getScanner_WhitespaceRuleAccess().getGroup_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0__2__Impl"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0__3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3904:1: rule__Scanner_WhitespaceRule__Group_1_0__3 : rule__Scanner_WhitespaceRule__Group_1_0__3__Impl ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3908:1: ( rule__Scanner_WhitespaceRule__Group_1_0__3__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3909:2: rule__Scanner_WhitespaceRule__Group_1_0__3__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__3__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0__37810);
            rule__Scanner_WhitespaceRule__Group_1_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0__3"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0__3__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3915:1: rule__Scanner_WhitespaceRule__Group_1_0__3__Impl : ( ']' ) ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3919:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3920:1: ( ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3920:1: ( ']' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3921:1: ']'
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3()); 
            match(input,25,FOLLOW_25_in_rule__Scanner_WhitespaceRule__Group_1_0__3__Impl7838); 
             after(grammarAccess.getScanner_WhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0__3__Impl"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0_2__0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3942:1: rule__Scanner_WhitespaceRule__Group_1_0_2__0 : rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl rule__Scanner_WhitespaceRule__Group_1_0_2__1 ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3946:1: ( rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl rule__Scanner_WhitespaceRule__Group_1_0_2__1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3947:2: rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl rule__Scanner_WhitespaceRule__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0_2__07877);
            rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0_2__1_in_rule__Scanner_WhitespaceRule__Group_1_0_2__07880);
            rule__Scanner_WhitespaceRule__Group_1_0_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0_2__0"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3954:1: rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl : ( ',' ) ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3958:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3959:1: ( ',' )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3959:1: ( ',' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3960:1: ','
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getCommaKeyword_1_0_2_0()); 
            match(input,26,FOLLOW_26_in_rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl7908); 
             after(grammarAccess.getScanner_WhitespaceRuleAccess().getCommaKeyword_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0_2__1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3973:1: rule__Scanner_WhitespaceRule__Group_1_0_2__1 : rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3977:1: ( rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3978:2: rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0_2__17939);
            rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0_2__1"


    // $ANTLR start "rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3984:1: rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl : ( ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1 ) ) ;
    public final void rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3988:1: ( ( ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1 ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3989:1: ( ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1 ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3989:1: ( ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1 ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3990:1: ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1 )
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getCharactersAssignment_1_0_2_1()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3991:1: ( rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1 )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:3991:2: rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1
            {
            pushFollow(FOLLOW_rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1_in_rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl7966);
            rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getScanner_WhitespaceRuleAccess().getCharactersAssignment_1_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl"


    // $ANTLR start "rule__LDef__NameAssignment_0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4006:1: rule__LDef__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__LDef__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4010:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4011:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4011:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4012:1: RULE_ID
            {
             before(grammarAccess.getLDefAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LDef__NameAssignment_08005); 
             after(grammarAccess.getLDefAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__NameAssignment_0"


    // $ANTLR start "rule__LDef__ParitioningAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4021:1: rule__LDef__ParitioningAssignment_2 : ( ruleParitioning ) ;
    public final void rule__LDef__ParitioningAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4025:1: ( ( ruleParitioning ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4026:1: ( ruleParitioning )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4026:1: ( ruleParitioning )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4027:1: ruleParitioning
            {
             before(grammarAccess.getLDefAccess().getParitioningParitioningParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParitioning_in_rule__LDef__ParitioningAssignment_28036);
            ruleParitioning();

            state._fsp--;

             after(grammarAccess.getLDefAccess().getParitioningParitioningParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__ParitioningAssignment_2"


    // $ANTLR start "rule__LDef__LexicalHighlightingAssignment_3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4036:1: rule__LDef__LexicalHighlightingAssignment_3 : ( ruleLexicalHighlighting ) ;
    public final void rule__LDef__LexicalHighlightingAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4040:1: ( ( ruleLexicalHighlighting ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4041:1: ( ruleLexicalHighlighting )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4041:1: ( ruleLexicalHighlighting )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4042:1: ruleLexicalHighlighting
            {
             before(grammarAccess.getLDefAccess().getLexicalHighlightingLexicalHighlightingParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_rule__LDef__LexicalHighlightingAssignment_38067);
            ruleLexicalHighlighting();

            state._fsp--;

             after(grammarAccess.getLDefAccess().getLexicalHighlightingLexicalHighlightingParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LDef__LexicalHighlightingAssignment_3"


    // $ANTLR start "rule__Paritioning__PartitionsAssignment_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4051:1: rule__Paritioning__PartitionsAssignment_2 : ( rulePartition ) ;
    public final void rule__Paritioning__PartitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4055:1: ( ( rulePartition ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4056:1: ( rulePartition )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4056:1: ( rulePartition )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4057:1: rulePartition
            {
             before(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_rulePartition_in_rule__Paritioning__PartitionsAssignment_28098);
            rulePartition();

            state._fsp--;

             after(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4066:1: rule__Paritioning__PartitionerAssignment_3 : ( rulePartitioner ) ;
    public final void rule__Paritioning__PartitionerAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4070:1: ( ( rulePartitioner ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4071:1: ( rulePartitioner )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4071:1: ( rulePartitioner )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4072:1: rulePartitioner
            {
             before(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 
            pushFollow(FOLLOW_rulePartitioner_in_rule__Paritioning__PartitionerAssignment_38129);
            rulePartitioner();

            state._fsp--;

             after(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4081:1: rule__Partition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Partition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4085:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4086:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4086:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4087:1: RULE_ID
            {
             before(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_18160); 
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


    // $ANTLR start "rule__Paritioner_JS__ScriptURIAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4096:1: rule__Paritioner_JS__ScriptURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Paritioner_JS__ScriptURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4100:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4101:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4101:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4102:1: RULE_STRING
            {
             before(grammarAccess.getParitioner_JSAccess().getScriptURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Paritioner_JS__ScriptURIAssignment_18191); 
             after(grammarAccess.getParitioner_JSAccess().getScriptURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4111:1: rule__Partitioner_Rule__RuleListAssignment_2 : ( rulePartition_Rule ) ;
    public final void rule__Partitioner_Rule__RuleListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4115:1: ( ( rulePartition_Rule ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4116:1: ( rulePartition_Rule )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4116:1: ( rulePartition_Rule )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4117:1: rulePartition_Rule
            {
             before(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_rulePartition_Rule_in_rule__Partitioner_Rule__RuleListAssignment_28222);
            rulePartition_Rule();

            state._fsp--;

             after(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4126:1: rule__Partition_SingleLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Partition_SingleLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4130:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4131:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4131:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4132:1: ( RULE_ID )
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4133:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4134:1: RULE_ID
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition_SingleLineRule__ParitionAssignment_18257); 
             after(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4145:1: rule__Partition_SingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4149:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4150:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4150:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4151:1: RULE_STRING
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__StartSeqAssignment_28292); 
             after(grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4160:1: rule__Partition_SingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4164:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4165:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4165:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4166:1: RULE_STRING
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EndSeqAssignment_48323); 
             after(grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4175:1: rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4179:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4180:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4180:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4181:1: RULE_STRING
            {
             before(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_28354); 
             after(grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4190:1: rule__Partition_MultiLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Partition_MultiLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4194:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4195:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4195:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4196:1: ( RULE_ID )
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4197:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4198:1: RULE_ID
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition_MultiLineRule__ParitionAssignment_18389); 
             after(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4209:1: rule__Partition_MultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4213:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4214:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4214:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4215:1: RULE_STRING
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__StartSeqAssignment_28424); 
             after(grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4224:1: rule__Partition_MultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4228:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4229:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4229:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4230:1: RULE_STRING
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EndSeqAssignment_48455); 
             after(grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4239:1: rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4243:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4244:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4244:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4245:1: RULE_STRING
            {
             before(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_28486); 
             after(grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4254:1: rule__LexicalHighlighting__ListAssignment_2 : ( ruleLexicalPartitionHighlighting ) ;
    public final void rule__LexicalHighlighting__ListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4258:1: ( ( ruleLexicalPartitionHighlighting ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4259:1: ( ruleLexicalPartitionHighlighting )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4259:1: ( ruleLexicalPartitionHighlighting )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4260:1: ruleLexicalPartitionHighlighting
            {
             before(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_rule__LexicalHighlighting__ListAssignment_28517);
            ruleLexicalPartitionHighlighting();

            state._fsp--;

             after(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4269:1: rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4273:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4274:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4274:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4275:1: ( RULE_ID )
            {
             before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4276:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4277:1: RULE_ID
            {
             before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_18552); 
             after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4288:1: rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4292:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4293:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4293:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4294:1: RULE_STRING
            {
             before(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_28587); 
             after(grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURISTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4303:1: rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4307:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4308:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4308:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4309:1: ( RULE_ID )
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4310:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4311:1: RULE_ID
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_18622); 
             after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4322:1: rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3 : ( ruleToken ) ;
    public final void rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4326:1: ( ( ruleToken ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4327:1: ( ruleToken )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4327:1: ( ruleToken )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4328:1: ruleToken
            {
             before(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleToken_in_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_38657);
            ruleToken();

            state._fsp--;

             after(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3"


    // $ANTLR start "rule__Token__DefaultAssignment_0"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4337:1: rule__Token__DefaultAssignment_0 : ( ( 'default' ) ) ;
    public final void rule__Token__DefaultAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4341:1: ( ( ( 'default' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4342:1: ( ( 'default' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4342:1: ( ( 'default' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4343:1: ( 'default' )
            {
             before(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4344:1: ( 'default' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4345:1: 'default'
            {
             before(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 
            match(input,30,FOLLOW_30_in_rule__Token__DefaultAssignment_08693); 
             after(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 

            }

             after(grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4360:1: rule__Token__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Token__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4364:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4365:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4365:1: ( RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4366:1: RULE_ID
            {
             before(grammarAccess.getTokenAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Token__NameAssignment_18732); 
             after(grammarAccess.getTokenAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4375:1: rule__Token__ScannerListAssignment_2_1 : ( ruleScanner ) ;
    public final void rule__Token__ScannerListAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4379:1: ( ( ruleScanner ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4380:1: ( ruleScanner )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4380:1: ( ruleScanner )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4381:1: ruleScanner
            {
             before(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleScanner_in_rule__Token__ScannerListAssignment_2_18763);
            ruleScanner();

            state._fsp--;

             after(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4390:1: rule__Scanner_Keyword__KeywordsAssignment_2 : ( ruleKeyword ) ;
    public final void rule__Scanner_Keyword__KeywordsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4394:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4395:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4395:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4396:1: ruleKeyword
            {
             before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_28794);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4405:1: rule__Scanner_Keyword__KeywordsAssignment_3_1 : ( ruleKeyword ) ;
    public final void rule__Scanner_Keyword__KeywordsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4409:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4410:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4410:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4411:1: ruleKeyword
            {
             before(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_3_18825);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4420:1: rule__Keyword__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Keyword__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4424:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4425:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4425:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4426:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_08856); 
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4435:1: rule__Keyword__VersionAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Keyword__VersionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4439:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4440:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4440:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4441:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_18887); 
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


    // $ANTLR start "rule__Scanner_SingleLineRule__StartSeqAssignment_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4450:1: rule__Scanner_SingleLineRule__StartSeqAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__StartSeqAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4454:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4455:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4455:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4456:1: RULE_STRING
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__StartSeqAssignment_18918); 
             after(grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4465:1: rule__Scanner_SingleLineRule__EndSeqAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__EndSeqAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4469:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4470:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4470:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4471:1: RULE_STRING
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EndSeqAssignment_38949); 
             after(grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4480:1: rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4484:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4485:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4485:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4486:1: RULE_STRING
            {
             before(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_28980); 
             after(grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4495:1: rule__Scanner_MultiLineRule__StartSeqAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__StartSeqAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4499:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4500:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4500:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4501:1: RULE_STRING
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__StartSeqAssignment_19011); 
             after(grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4510:1: rule__Scanner_MultiLineRule__EndSeqAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__EndSeqAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4514:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4515:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4515:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4516:1: RULE_STRING
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EndSeqAssignment_39042); 
             after(grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4525:1: rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4529:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4530:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4530:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4531:1: RULE_STRING
            {
             before(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_29073); 
             after(grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4540:1: rule__Scanner_CharacterRule__CharactersAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_CharacterRule__CharactersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4544:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4545:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4545:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4546:1: RULE_STRING
            {
             before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_29104); 
             after(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4555:1: rule__Scanner_CharacterRule__CharactersAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_CharacterRule__CharactersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4559:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4560:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4560:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4561:1: RULE_STRING
            {
             before(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_3_19135); 
             after(grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4570:1: rule__Scanner_JSRule__FileURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_JSRule__FileURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4574:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4575:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4575:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4576:1: RULE_STRING
            {
             before(grammarAccess.getScanner_JSRuleAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_JSRule__FileURIAssignment_19166); 
             after(grammarAccess.getScanner_JSRuleAccess().getFileURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4585:1: rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4589:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4590:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4590:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4591:1: RULE_STRING
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_19197); 
             after(grammarAccess.getScanner_WhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1"


    // $ANTLR start "rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4600:1: rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1 : ( RULE_STRING ) ;
    public final void rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4604:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4605:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4605:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4606:1: RULE_STRING
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_19228); 
             after(grammarAccess.getScanner_WhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1"


    // $ANTLR start "rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4615:1: rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1 : ( ( 'javawhitespace' ) ) ;
    public final void rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4619:1: ( ( ( 'javawhitespace' ) ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4620:1: ( ( 'javawhitespace' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4620:1: ( ( 'javawhitespace' ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4621:1: ( 'javawhitespace' )
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4622:1: ( 'javawhitespace' )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4623:1: 'javawhitespace'
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 
            match(input,31,FOLLOW_31_in_rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_19264); 
             after(grammarAccess.getScanner_WhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 

            }

             after(grammarAccess.getScanner_WhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1"


    // $ANTLR start "rule__Scanner_WhitespaceRule__FileURIAssignment_1_2"
    // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4638:1: rule__Scanner_WhitespaceRule__FileURIAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__Scanner_WhitespaceRule__FileURIAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4642:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4643:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4643:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef.ui/src-gen/org/eclipse/fx/code/editor/ldef/ui/contentassist/antlr/internal/InternalLDef.g:4644:1: RULE_STRING
            {
             before(grammarAccess.getScanner_WhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_1_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scanner_WhitespaceRule__FileURIAssignment_1_29303); 
             after(grammarAccess.getScanner_WhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scanner_WhitespaceRule__FileURIAssignment_1_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleLDef_in_entryRuleLDef61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLDef68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LDef__Group__0_in_ruleLDef94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioning_in_entryRuleParitioning121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioning128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__0_in_ruleParitioning154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_entryRulePartition181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__0_in_rulePartition214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_entryRulePartitioner241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner__Alternatives_in_rulePartitioner274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioner_JS308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__0_in_ruleParitioner_JS334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner_Rule368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__0_in_rulePartitioner_Rule394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_Rule428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_Rule__Alternatives_in_rulePartition_Rule454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_SingleLineRule488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__0_in_rulePartition_SingleLineRule514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_MultiLineRule548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__0_in_rulePartition_MultiLineRule574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalHighlighting608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__0_in_ruleLexicalHighlighting634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting__Alternatives_in_ruleLexicalPartitionHighlighting694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0_in_ruleLexicalPartitionHighlighting_JS754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0_in_ruleLexicalPartitionHighlighting_Rule814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_entryRuleToken841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleToken848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__0_in_ruleToken874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_entryRuleScanner901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner__Alternatives_in_ruleScanner934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Keyword968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__0_in_ruleScanner_Keyword994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0_in_ruleKeyword1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Rule1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Rule__Alternatives_in_ruleScanner_Rule1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule1141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_SingleLineRule1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__0_in_ruleScanner_SingleLineRule1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule1201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_MultiLineRule1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__0_in_ruleScanner_MultiLineRule1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule1261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_CharacterRule1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__0_in_ruleScanner_CharacterRule1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_JSRule1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__0_in_ruleScanner_JSRule1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_WhitespaceRule_in_entryRuleScanner_WhitespaceRule1381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_WhitespaceRule1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group__0_in_ruleScanner_WhitespaceRule1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_rule__Partitioner__Alternatives1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_rule__Partitioner__Alternatives1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_rule__Partition_Rule__Alternatives1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_rule__Partition_Rule__Alternatives1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_rule__LexicalPartitionHighlighting__Alternatives1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_rule__LexicalPartitionHighlighting__Alternatives1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_rule__Scanner__Alternatives1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_rule__Scanner__Alternatives1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_rule__Scanner_Rule__Alternatives1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_rule__Scanner_Rule__Alternatives1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_rule__Scanner_Rule__Alternatives1680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_rule__Scanner_Rule__Alternatives1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_WhitespaceRule_in_rule__Scanner_Rule__Alternatives1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__0_in_rule__Scanner_WhitespaceRule__Alternatives_11746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_1_in_rule__Scanner_WhitespaceRule__Alternatives_11764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__FileURIAssignment_1_2_in_rule__Scanner_WhitespaceRule__Alternatives_11782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LDef__Group__0__Impl_in_rule__LDef__Group__01813 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__LDef__Group__1_in_rule__LDef__Group__01816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LDef__NameAssignment_0_in_rule__LDef__Group__0__Impl1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LDef__Group__1__Impl_in_rule__LDef__Group__11873 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__LDef__Group__2_in_rule__LDef__Group__11876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__LDef__Group__1__Impl1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LDef__Group__2__Impl_in_rule__LDef__Group__21935 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__LDef__Group__3_in_rule__LDef__Group__21938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LDef__ParitioningAssignment_2_in_rule__LDef__Group__2__Impl1965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LDef__Group__3__Impl_in_rule__LDef__Group__31995 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__LDef__Group__4_in_rule__LDef__Group__31998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LDef__LexicalHighlightingAssignment_3_in_rule__LDef__Group__3__Impl2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LDef__Group__4__Impl_in_rule__LDef__Group__42055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__LDef__Group__4__Impl2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__0__Impl_in_rule__Paritioning__Group__02124 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__1_in_rule__Paritioning__Group__02127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Paritioning__Group__0__Impl2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__1__Impl_in_rule__Paritioning__Group__12186 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__2_in_rule__Paritioning__Group__12189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Paritioning__Group__1__Impl2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__2__Impl_in_rule__Paritioning__Group__22248 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__3_in_rule__Paritioning__Group__22251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl2280 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionsAssignment_2_in_rule__Paritioning__Group__2__Impl2292 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__3__Impl_in_rule__Paritioning__Group__32325 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__4_in_rule__Paritioning__Group__32328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__PartitionerAssignment_3_in_rule__Paritioning__Group__3__Impl2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioning__Group__4__Impl_in_rule__Paritioning__Group__42385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Paritioning__Group__4__Impl2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__02454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__02457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Partition__Group__0__Impl2485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__12516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__0__Impl_in_rule__Paritioner_JS__Group__02577 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__1_in_rule__Paritioner_JS__Group__02580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Paritioner_JS__Group__0__Impl2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__Group__1__Impl_in_rule__Paritioner_JS__Group__12639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paritioner_JS__ScriptURIAssignment_1_in_rule__Paritioner_JS__Group__1__Impl2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__0__Impl_in_rule__Partitioner_Rule__Group__02700 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__1_in_rule__Partitioner_Rule__Group__02703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Partitioner_Rule__Group__0__Impl2731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__1__Impl_in_rule__Partitioner_Rule__Group__12762 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__2_in_rule__Partitioner_Rule__Group__12765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Partitioner_Rule__Group__1__Impl2793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__2__Impl_in_rule__Partitioner_Rule__Group__22824 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__3_in_rule__Partitioner_Rule__Group__22827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl2856 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__RuleListAssignment_2_in_rule__Partitioner_Rule__Group__2__Impl2868 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_rule__Partitioner_Rule__Group__3__Impl_in_rule__Partitioner_Rule__Group__32901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Partitioner_Rule__Group__3__Impl2929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__0__Impl_in_rule__Partition_SingleLineRule__Group__02968 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__1_in_rule__Partition_SingleLineRule__Group__02971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Partition_SingleLineRule__Group__0__Impl2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__1__Impl_in_rule__Partition_SingleLineRule__Group__13030 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__2_in_rule__Partition_SingleLineRule__Group__13033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__ParitionAssignment_1_in_rule__Partition_SingleLineRule__Group__1__Impl3060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__2__Impl_in_rule__Partition_SingleLineRule__Group__23090 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__3_in_rule__Partition_SingleLineRule__Group__23093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__StartSeqAssignment_2_in_rule__Partition_SingleLineRule__Group__2__Impl3120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__3__Impl_in_rule__Partition_SingleLineRule__Group__33150 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__4_in_rule__Partition_SingleLineRule__Group__33153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Partition_SingleLineRule__Group__3__Impl3181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__4__Impl_in_rule__Partition_SingleLineRule__Group__43212 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__5_in_rule__Partition_SingleLineRule__Group__43215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__EndSeqAssignment_4_in_rule__Partition_SingleLineRule__Group__4__Impl3242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group__5__Impl_in_rule__Partition_SingleLineRule__Group__53273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__0_in_rule__Partition_SingleLineRule__Group__5__Impl3300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__0__Impl_in_rule__Partition_SingleLineRule__Group_5__03343 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__1_in_rule__Partition_SingleLineRule__Group_5__03346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Partition_SingleLineRule__Group_5__0__Impl3374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__1__Impl_in_rule__Partition_SingleLineRule__Group_5__13405 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__2_in_rule__Partition_SingleLineRule__Group_5__13408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Partition_SingleLineRule__Group_5__1__Impl3436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__Group_5__2__Impl_in_rule__Partition_SingleLineRule__Group_5__23467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_SingleLineRule__Group_5__2__Impl3494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__0__Impl_in_rule__Partition_MultiLineRule__Group__03530 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__1_in_rule__Partition_MultiLineRule__Group__03533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Partition_MultiLineRule__Group__0__Impl3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__1__Impl_in_rule__Partition_MultiLineRule__Group__13592 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__2_in_rule__Partition_MultiLineRule__Group__13595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__ParitionAssignment_1_in_rule__Partition_MultiLineRule__Group__1__Impl3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__2__Impl_in_rule__Partition_MultiLineRule__Group__23652 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__3_in_rule__Partition_MultiLineRule__Group__23655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__StartSeqAssignment_2_in_rule__Partition_MultiLineRule__Group__2__Impl3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__3__Impl_in_rule__Partition_MultiLineRule__Group__33712 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__4_in_rule__Partition_MultiLineRule__Group__33715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Partition_MultiLineRule__Group__3__Impl3743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__4__Impl_in_rule__Partition_MultiLineRule__Group__43774 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__5_in_rule__Partition_MultiLineRule__Group__43777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__EndSeqAssignment_4_in_rule__Partition_MultiLineRule__Group__4__Impl3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group__5__Impl_in_rule__Partition_MultiLineRule__Group__53834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__0_in_rule__Partition_MultiLineRule__Group__5__Impl3861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__0__Impl_in_rule__Partition_MultiLineRule__Group_5__03904 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__1_in_rule__Partition_MultiLineRule__Group_5__03907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Partition_MultiLineRule__Group_5__0__Impl3935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__1__Impl_in_rule__Partition_MultiLineRule__Group_5__13966 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__2_in_rule__Partition_MultiLineRule__Group_5__13969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Partition_MultiLineRule__Group_5__1__Impl3997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__Group_5__2__Impl_in_rule__Partition_MultiLineRule__Group_5__24028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_2_in_rule__Partition_MultiLineRule__Group_5__2__Impl4055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__0__Impl_in_rule__LexicalHighlighting__Group__04091 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__1_in_rule__LexicalHighlighting__Group__04094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__LexicalHighlighting__Group__0__Impl4122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__1__Impl_in_rule__LexicalHighlighting__Group__14153 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__2_in_rule__LexicalHighlighting__Group__14156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__LexicalHighlighting__Group__1__Impl4184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__2__Impl_in_rule__LexicalHighlighting__Group__24215 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__3_in_rule__LexicalHighlighting__Group__24218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl4247 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__ListAssignment_2_in_rule__LexicalHighlighting__Group__2__Impl4259 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_rule__LexicalHighlighting__Group__3__Impl_in_rule__LexicalHighlighting__Group__34292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__LexicalHighlighting__Group__3__Impl4320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__0__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__04359 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1_in_rule__LexicalPartitionHighlighting_JS__Group__04362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LexicalPartitionHighlighting_JS__Group__0__Impl4390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__1__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__14421 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2_in_rule__LexicalPartitionHighlighting_JS__Group__14424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_JS__Group__1__Impl4451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__Group__2__Impl_in_rule__LexicalPartitionHighlighting_JS__Group__24481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_2_in_rule__LexicalPartitionHighlighting_JS__Group__2__Impl4508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__04544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1_in_rule__LexicalPartitionHighlighting_Rule__Group__04547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LexicalPartitionHighlighting_Rule__Group__0__Impl4575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__14606 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2_in_rule__LexicalPartitionHighlighting_Rule__Group__14609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_1_in_rule__LexicalPartitionHighlighting_Rule__Group__1__Impl4636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__24666 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3_in_rule__LexicalPartitionHighlighting_Rule__Group__24669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__LexicalPartitionHighlighting_Rule__Group__2__Impl4697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__34728 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4_in_rule__LexicalPartitionHighlighting_Rule__Group__34731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3_in_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl4760 = new BitSet(new long[]{0x0000000040000012L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_3_in_rule__LexicalPartitionHighlighting_Rule__Group__3__Impl4772 = new BitSet(new long[]{0x0000000040000012L});
    public static final BitSet FOLLOW_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl_in_rule__LexicalPartitionHighlighting_Rule__Group__44805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__LexicalPartitionHighlighting_Rule__Group__4__Impl4833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__0__Impl_in_rule__Token__Group__04874 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_rule__Token__Group__1_in_rule__Token__Group__04877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__DefaultAssignment_0_in_rule__Token__Group__0__Impl4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__1__Impl_in_rule__Token__Group__14935 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Token__Group__2_in_rule__Token__Group__14938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__NameAssignment_1_in_rule__Token__Group__1__Impl4965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group__2__Impl_in_rule__Token__Group__24995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__0_in_rule__Token__Group__2__Impl5022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__0__Impl_in_rule__Token__Group_2__05059 = new BitSet(new long[]{0x0000000030A28000L});
    public static final BitSet FOLLOW_rule__Token__Group_2__1_in_rule__Token__Group_2__05062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Token__Group_2__0__Impl5090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__1__Impl_in_rule__Token__Group_2__15121 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Token__Group_2__2_in_rule__Token__Group_2__15124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl5153 = new BitSet(new long[]{0x0000000030A28002L});
    public static final BitSet FOLLOW_rule__Token__ScannerListAssignment_2_1_in_rule__Token__Group_2__1__Impl5165 = new BitSet(new long[]{0x0000000030A28002L});
    public static final BitSet FOLLOW_rule__Token__Group_2__2__Impl_in_rule__Token__Group_2__25198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Token__Group_2__2__Impl5226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__0__Impl_in_rule__Scanner_Keyword__Group__05263 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__1_in_rule__Scanner_Keyword__Group__05266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Scanner_Keyword__Group__0__Impl5294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__1__Impl_in_rule__Scanner_Keyword__Group__15325 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__2_in_rule__Scanner_Keyword__Group__15328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Scanner_Keyword__Group__1__Impl5356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__2__Impl_in_rule__Scanner_Keyword__Group__25387 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__3_in_rule__Scanner_Keyword__Group__25390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_2_in_rule__Scanner_Keyword__Group__2__Impl5417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__3__Impl_in_rule__Scanner_Keyword__Group__35447 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__4_in_rule__Scanner_Keyword__Group__35450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__0_in_rule__Scanner_Keyword__Group__3__Impl5477 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group__4__Impl_in_rule__Scanner_Keyword__Group__45508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Scanner_Keyword__Group__4__Impl5536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__0__Impl_in_rule__Scanner_Keyword__Group_3__05577 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__1_in_rule__Scanner_Keyword__Group_3__05580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Scanner_Keyword__Group_3__0__Impl5608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__Group_3__1__Impl_in_rule__Scanner_Keyword__Group_3__15639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_Keyword__KeywordsAssignment_3_1_in_rule__Scanner_Keyword__Group_3__1__Impl5666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__05700 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__05703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl5730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__15760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl5787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__05822 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__05825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Keyword__Group_1__0__Impl5853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__15884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl5911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__0__Impl_in_rule__Scanner_SingleLineRule__Group__05945 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__1_in_rule__Scanner_SingleLineRule__Group__05948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Scanner_SingleLineRule__Group__0__Impl5976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__1__Impl_in_rule__Scanner_SingleLineRule__Group__16007 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__2_in_rule__Scanner_SingleLineRule__Group__16010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__StartSeqAssignment_1_in_rule__Scanner_SingleLineRule__Group__1__Impl6037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__2__Impl_in_rule__Scanner_SingleLineRule__Group__26067 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__3_in_rule__Scanner_SingleLineRule__Group__26070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Scanner_SingleLineRule__Group__2__Impl6098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__3__Impl_in_rule__Scanner_SingleLineRule__Group__36129 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__4_in_rule__Scanner_SingleLineRule__Group__36132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__EndSeqAssignment_3_in_rule__Scanner_SingleLineRule__Group__3__Impl6159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group__4__Impl_in_rule__Scanner_SingleLineRule__Group__46190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__0_in_rule__Scanner_SingleLineRule__Group__4__Impl6217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__0__Impl_in_rule__Scanner_SingleLineRule__Group_4__06258 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__1_in_rule__Scanner_SingleLineRule__Group_4__06261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Scanner_SingleLineRule__Group_4__0__Impl6289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__1__Impl_in_rule__Scanner_SingleLineRule__Group_4__16320 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__2_in_rule__Scanner_SingleLineRule__Group_4__16323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Scanner_SingleLineRule__Group_4__1__Impl6351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__Group_4__2__Impl_in_rule__Scanner_SingleLineRule__Group_4__26382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_SingleLineRule__Group_4__2__Impl6409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__0__Impl_in_rule__Scanner_MultiLineRule__Group__06445 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__1_in_rule__Scanner_MultiLineRule__Group__06448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Scanner_MultiLineRule__Group__0__Impl6476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__1__Impl_in_rule__Scanner_MultiLineRule__Group__16507 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__2_in_rule__Scanner_MultiLineRule__Group__16510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__StartSeqAssignment_1_in_rule__Scanner_MultiLineRule__Group__1__Impl6537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__2__Impl_in_rule__Scanner_MultiLineRule__Group__26567 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__3_in_rule__Scanner_MultiLineRule__Group__26570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Scanner_MultiLineRule__Group__2__Impl6598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__3__Impl_in_rule__Scanner_MultiLineRule__Group__36629 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__4_in_rule__Scanner_MultiLineRule__Group__36632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__EndSeqAssignment_3_in_rule__Scanner_MultiLineRule__Group__3__Impl6659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group__4__Impl_in_rule__Scanner_MultiLineRule__Group__46689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__0_in_rule__Scanner_MultiLineRule__Group__4__Impl6716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__0__Impl_in_rule__Scanner_MultiLineRule__Group_4__06757 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__1_in_rule__Scanner_MultiLineRule__Group_4__06760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Scanner_MultiLineRule__Group_4__0__Impl6788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__1__Impl_in_rule__Scanner_MultiLineRule__Group_4__16819 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__2_in_rule__Scanner_MultiLineRule__Group_4__16822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Scanner_MultiLineRule__Group_4__1__Impl6850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__Group_4__2__Impl_in_rule__Scanner_MultiLineRule__Group_4__26881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_2_in_rule__Scanner_MultiLineRule__Group_4__2__Impl6908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__0__Impl_in_rule__Scanner_CharacterRule__Group__06944 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__1_in_rule__Scanner_CharacterRule__Group__06947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Scanner_CharacterRule__Group__0__Impl6975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__1__Impl_in_rule__Scanner_CharacterRule__Group__17006 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__2_in_rule__Scanner_CharacterRule__Group__17009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Scanner_CharacterRule__Group__1__Impl7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__2__Impl_in_rule__Scanner_CharacterRule__Group__27068 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__3_in_rule__Scanner_CharacterRule__Group__27071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_2_in_rule__Scanner_CharacterRule__Group__2__Impl7098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__3__Impl_in_rule__Scanner_CharacterRule__Group__37128 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__4_in_rule__Scanner_CharacterRule__Group__37131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__0_in_rule__Scanner_CharacterRule__Group__3__Impl7158 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group__4__Impl_in_rule__Scanner_CharacterRule__Group__47189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Scanner_CharacterRule__Group__4__Impl7217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__0__Impl_in_rule__Scanner_CharacterRule__Group_3__07258 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__1_in_rule__Scanner_CharacterRule__Group_3__07261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Scanner_CharacterRule__Group_3__0__Impl7289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__Group_3__1__Impl_in_rule__Scanner_CharacterRule__Group_3__17320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_CharacterRule__CharactersAssignment_3_1_in_rule__Scanner_CharacterRule__Group_3__1__Impl7347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__0__Impl_in_rule__Scanner_JSRule__Group__07381 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__1_in_rule__Scanner_JSRule__Group__07384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Scanner_JSRule__Group__0__Impl7412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__Group__1__Impl_in_rule__Scanner_JSRule__Group__17443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_JSRule__FileURIAssignment_1_in_rule__Scanner_JSRule__Group__1__Impl7470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group__0__Impl_in_rule__Scanner_WhitespaceRule__Group__07504 = new BitSet(new long[]{0x0000000081000020L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group__1_in_rule__Scanner_WhitespaceRule__Group__07507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Scanner_WhitespaceRule__Group__0__Impl7535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group__1__Impl_in_rule__Scanner_WhitespaceRule__Group__17566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Alternatives_1_in_rule__Scanner_WhitespaceRule__Group__1__Impl7593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__0__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0__07627 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__1_in_rule__Scanner_WhitespaceRule__Group_1_0__07630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Scanner_WhitespaceRule__Group_1_0__0__Impl7658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__1__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0__17689 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__2_in_rule__Scanner_WhitespaceRule__Group_1_0__17692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_1_in_rule__Scanner_WhitespaceRule__Group_1_0__1__Impl7719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__2__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0__27749 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__3_in_rule__Scanner_WhitespaceRule__Group_1_0__27752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0_2__0_in_rule__Scanner_WhitespaceRule__Group_1_0__2__Impl7779 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0__3__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0__37810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Scanner_WhitespaceRule__Group_1_0__3__Impl7838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0_2__07877 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0_2__1_in_rule__Scanner_WhitespaceRule__Group_1_0_2__07880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Scanner_WhitespaceRule__Group_1_0_2__0__Impl7908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl_in_rule__Scanner_WhitespaceRule__Group_1_0_2__17939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_1_in_rule__Scanner_WhitespaceRule__Group_1_0_2__1__Impl7966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LDef__NameAssignment_08005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioning_in_rule__LDef__ParitioningAssignment_28036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_rule__LDef__LexicalHighlightingAssignment_38067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_rule__Paritioning__PartitionsAssignment_28098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_rule__Paritioning__PartitionerAssignment_38129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_18160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Paritioner_JS__ScriptURIAssignment_18191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_rule__Partitioner_Rule__RuleListAssignment_28222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition_SingleLineRule__ParitionAssignment_18257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__StartSeqAssignment_28292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EndSeqAssignment_48323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_SingleLineRule__EscapeSeqAssignment_5_28354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition_MultiLineRule__ParitionAssignment_18389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__StartSeqAssignment_28424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EndSeqAssignment_48455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Partition_MultiLineRule__EscapeSeqAssignment_5_28486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_rule__LexicalHighlighting__ListAssignment_28517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_JS__PartitionAssignment_18552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__LexicalPartitionHighlighting_JS__ScriptURIAssignment_28587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LexicalPartitionHighlighting_Rule__PartitionAssignment_18622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_rule__LexicalPartitionHighlighting_Rule__TokenListAssignment_38657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Token__DefaultAssignment_08693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Token__NameAssignment_18732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_rule__Token__ScannerListAssignment_2_18763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_28794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__Scanner_Keyword__KeywordsAssignment_3_18825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_08856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_18887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__StartSeqAssignment_18918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EndSeqAssignment_38949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_SingleLineRule__EscapeSeqAssignment_4_28980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__StartSeqAssignment_19011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EndSeqAssignment_39042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_MultiLineRule__EscapeSeqAssignment_4_29073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_29104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_CharacterRule__CharactersAssignment_3_19135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_JSRule__FileURIAssignment_19166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_19197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_WhitespaceRule__CharactersAssignment_1_0_2_19228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Scanner_WhitespaceRule__JavawhitespaceAssignment_1_19264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scanner_WhitespaceRule__FileURIAssignment_1_29303 = new BitSet(new long[]{0x0000000000000002L});

}