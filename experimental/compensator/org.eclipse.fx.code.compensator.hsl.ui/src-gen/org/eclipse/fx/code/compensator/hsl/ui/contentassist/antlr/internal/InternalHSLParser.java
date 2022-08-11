/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'java-like-partitioner'", "'java_like_partitioner'", "'rule-partitioner'", "'rule_partitioner'", "'js-partitioner'", "'js_partitioner'", "'js-damager'", "'js_damager'", "'rule-damager'", "'rule_damager'", "'single-line'", "'single_line'", "'multi-line'", "'multi_line'", "'character-rule'", "'character_rule'", "'javascript-rule'", "'javascript_rule'", "'whitespace-rule'", "'whitespace_rule'", "'bold'", "'italic'", "'underline'", "'strike-through'", "'{'", "'}'", "'for'", "'partition'", "'singlelinedoc'", "'multilinedoc'", "'javadoc'", "'char'", "'string'", "'token'", "'keywords'", "'['", "']'", "','", "'since'", "'=>'", "'escaped'", "'by'", "'rgb'", "'('", "')'", "'default'", "'javawhitespace'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
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
            case 13:
            case 14:
                {
                alt1=1;
                }
                break;
            case 11:
            case 12:
                {
                alt1=2;
                }
                break;
            case 15:
            case 16:
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


    // $ANTLR start "rule__JavaLikeParitioner__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:755:1: rule__JavaLikeParitioner__Alternatives_0 : ( ( 'java-like-partitioner' ) | ( 'java_like_partitioner' ) );
    public final void rule__JavaLikeParitioner__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:759:1: ( ( 'java-like-partitioner' ) | ( 'java_like_partitioner' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:760:1: ( 'java-like-partitioner' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:760:1: ( 'java-like-partitioner' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:761:1: 'java-like-partitioner'
                    {
                     before(grammarAccess.getJavaLikeParitionerAccess().getJavaLikePartitionerKeyword_0_0()); 
                    match(input,11,FOLLOW_11_in_rule__JavaLikeParitioner__Alternatives_01557); 
                     after(grammarAccess.getJavaLikeParitionerAccess().getJavaLikePartitionerKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:768:6: ( 'java_like_partitioner' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:768:6: ( 'java_like_partitioner' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:769:1: 'java_like_partitioner'
                    {
                     before(grammarAccess.getJavaLikeParitionerAccess().getJava_like_partitionerKeyword_0_1()); 
                    match(input,12,FOLLOW_12_in_rule__JavaLikeParitioner__Alternatives_01577); 
                     after(grammarAccess.getJavaLikeParitionerAccess().getJava_like_partitionerKeyword_0_1()); 

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
    // $ANTLR end "rule__JavaLikeParitioner__Alternatives_0"


    // $ANTLR start "rule__RulePartitioner__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:781:1: rule__RulePartitioner__Alternatives_0 : ( ( 'rule-partitioner' ) | ( 'rule_partitioner' ) );
    public final void rule__RulePartitioner__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:785:1: ( ( 'rule-partitioner' ) | ( 'rule_partitioner' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:786:1: ( 'rule-partitioner' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:786:1: ( 'rule-partitioner' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:787:1: 'rule-partitioner'
                    {
                     before(grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0_0()); 
                    match(input,13,FOLLOW_13_in_rule__RulePartitioner__Alternatives_01612); 
                     after(grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:794:6: ( 'rule_partitioner' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:794:6: ( 'rule_partitioner' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:795:1: 'rule_partitioner'
                    {
                     before(grammarAccess.getRulePartitionerAccess().getRule_partitionerKeyword_0_1()); 
                    match(input,14,FOLLOW_14_in_rule__RulePartitioner__Alternatives_01632); 
                     after(grammarAccess.getRulePartitionerAccess().getRule_partitionerKeyword_0_1()); 

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
    // $ANTLR end "rule__RulePartitioner__Alternatives_0"


    // $ANTLR start "rule__JSParitioner__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:807:1: rule__JSParitioner__Alternatives_0 : ( ( 'js-partitioner' ) | ( 'js_partitioner' ) );
    public final void rule__JSParitioner__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:811:1: ( ( 'js-partitioner' ) | ( 'js_partitioner' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==16) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:812:1: ( 'js-partitioner' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:812:1: ( 'js-partitioner' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:813:1: 'js-partitioner'
                    {
                     before(grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__JSParitioner__Alternatives_01667); 
                     after(grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:820:6: ( 'js_partitioner' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:820:6: ( 'js_partitioner' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:821:1: 'js_partitioner'
                    {
                     before(grammarAccess.getJSParitionerAccess().getJs_partitionerKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__JSParitioner__Alternatives_01687); 
                     after(grammarAccess.getJSParitionerAccess().getJs_partitionerKeyword_0_1()); 

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
    // $ANTLR end "rule__JSParitioner__Alternatives_0"


    // $ANTLR start "rule__Damager__Alternatives"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:833:1: rule__Damager__Alternatives : ( ( ruleRuleDamager ) | ( ruleJSDamager ) );
    public final void rule__Damager__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:837:1: ( ( ruleRuleDamager ) | ( ruleJSDamager ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=19 && LA5_0<=20)) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=17 && LA5_0<=18)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:838:1: ( ruleRuleDamager )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:838:1: ( ruleRuleDamager )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:839:1: ruleRuleDamager
                    {
                     before(grammarAccess.getDamagerAccess().getRuleDamagerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRuleDamager_in_rule__Damager__Alternatives1721);
                    ruleRuleDamager();

                    state._fsp--;

                     after(grammarAccess.getDamagerAccess().getRuleDamagerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:844:6: ( ruleJSDamager )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:844:6: ( ruleJSDamager )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:845:1: ruleJSDamager
                    {
                     before(grammarAccess.getDamagerAccess().getJSDamagerParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleJSDamager_in_rule__Damager__Alternatives1738);
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


    // $ANTLR start "rule__JSDamager__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:855:1: rule__JSDamager__Alternatives_0 : ( ( 'js-damager' ) | ( 'js_damager' ) );
    public final void rule__JSDamager__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:859:1: ( ( 'js-damager' ) | ( 'js_damager' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            else if ( (LA6_0==18) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:860:1: ( 'js-damager' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:860:1: ( 'js-damager' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:861:1: 'js-damager'
                    {
                     before(grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0_0()); 
                    match(input,17,FOLLOW_17_in_rule__JSDamager__Alternatives_01771); 
                     after(grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:868:6: ( 'js_damager' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:868:6: ( 'js_damager' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:869:1: 'js_damager'
                    {
                     before(grammarAccess.getJSDamagerAccess().getJs_damagerKeyword_0_1()); 
                    match(input,18,FOLLOW_18_in_rule__JSDamager__Alternatives_01791); 
                     after(grammarAccess.getJSDamagerAccess().getJs_damagerKeyword_0_1()); 

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
    // $ANTLR end "rule__JSDamager__Alternatives_0"


    // $ANTLR start "rule__RuleDamager__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:881:1: rule__RuleDamager__Alternatives_0 : ( ( 'rule-damager' ) | ( 'rule_damager' ) );
    public final void rule__RuleDamager__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:885:1: ( ( 'rule-damager' ) | ( 'rule_damager' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:886:1: ( 'rule-damager' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:886:1: ( 'rule-damager' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:887:1: 'rule-damager'
                    {
                     before(grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0_0()); 
                    match(input,19,FOLLOW_19_in_rule__RuleDamager__Alternatives_01826); 
                     after(grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:894:6: ( 'rule_damager' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:894:6: ( 'rule_damager' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:895:1: 'rule_damager'
                    {
                     before(grammarAccess.getRuleDamagerAccess().getRule_damagerKeyword_0_1()); 
                    match(input,20,FOLLOW_20_in_rule__RuleDamager__Alternatives_01846); 
                     after(grammarAccess.getRuleDamagerAccess().getRule_damagerKeyword_0_1()); 

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
    // $ANTLR end "rule__RuleDamager__Alternatives_0"


    // $ANTLR start "rule__ScannerRule__Alternatives"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:907:1: rule__ScannerRule__Alternatives : ( ( ruleScannerSingleLineRule ) | ( ruleScannerMultiLineRule ) | ( ruleScannerCharacterRule ) | ( ruleScannerJSRule ) | ( ruleScannerWhitespaceRule ) );
    public final void rule__ScannerRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:911:1: ( ( ruleScannerSingleLineRule ) | ( ruleScannerMultiLineRule ) | ( ruleScannerCharacterRule ) | ( ruleScannerJSRule ) | ( ruleScannerWhitespaceRule ) )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 21:
            case 22:
                {
                alt8=1;
                }
                break;
            case 23:
            case 24:
                {
                alt8=2;
                }
                break;
            case 25:
            case 26:
                {
                alt8=3;
                }
                break;
            case 27:
            case 28:
                {
                alt8=4;
                }
                break;
            case 29:
            case 30:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:912:1: ( ruleScannerSingleLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:912:1: ( ruleScannerSingleLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:913:1: ruleScannerSingleLineRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleScannerSingleLineRule_in_rule__ScannerRule__Alternatives1880);
                    ruleScannerSingleLineRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:918:6: ( ruleScannerMultiLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:918:6: ( ruleScannerMultiLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:919:1: ruleScannerMultiLineRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleScannerMultiLineRule_in_rule__ScannerRule__Alternatives1897);
                    ruleScannerMultiLineRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:924:6: ( ruleScannerCharacterRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:924:6: ( ruleScannerCharacterRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:925:1: ruleScannerCharacterRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleScannerCharacterRule_in_rule__ScannerRule__Alternatives1914);
                    ruleScannerCharacterRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:930:6: ( ruleScannerJSRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:930:6: ( ruleScannerJSRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:931:1: ruleScannerJSRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleScannerJSRule_in_rule__ScannerRule__Alternatives1931);
                    ruleScannerJSRule();

                    state._fsp--;

                     after(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:936:6: ( ruleScannerWhitespaceRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:936:6: ( ruleScannerWhitespaceRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:937:1: ruleScannerWhitespaceRule
                    {
                     before(grammarAccess.getScannerRuleAccess().getScannerWhitespaceRuleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_rule__ScannerRule__Alternatives1948);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:947:1: rule__ParitionRule__Alternatives : ( ( rulePartitionSingleLineRule ) | ( rulePartitionMultiLineRule ) | ( rulePartitionJSRule ) );
    public final void rule__ParitionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:951:1: ( ( rulePartitionSingleLineRule ) | ( rulePartitionMultiLineRule ) | ( rulePartitionJSRule ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 21:
            case 22:
                {
                alt9=1;
                }
                break;
            case 23:
            case 24:
                {
                alt9=2;
                }
                break;
            case 27:
            case 28:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:952:1: ( rulePartitionSingleLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:952:1: ( rulePartitionSingleLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:953:1: rulePartitionSingleLineRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePartitionSingleLineRule_in_rule__ParitionRule__Alternatives1980);
                    rulePartitionSingleLineRule();

                    state._fsp--;

                     after(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:958:6: ( rulePartitionMultiLineRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:958:6: ( rulePartitionMultiLineRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:959:1: rulePartitionMultiLineRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_rulePartitionMultiLineRule_in_rule__ParitionRule__Alternatives1997);
                    rulePartitionMultiLineRule();

                    state._fsp--;

                     after(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:964:6: ( rulePartitionJSRule )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:964:6: ( rulePartitionJSRule )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:965:1: rulePartitionJSRule
                    {
                     before(grammarAccess.getParitionRuleAccess().getPartitionJSRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_rulePartitionJSRule_in_rule__ParitionRule__Alternatives2014);
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


    // $ANTLR start "rule__ScannerSingleLineRule__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:975:1: rule__ScannerSingleLineRule__Alternatives_0 : ( ( 'single-line' ) | ( 'single_line' ) );
    public final void rule__ScannerSingleLineRule__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:979:1: ( ( 'single-line' ) | ( 'single_line' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            else if ( (LA10_0==22) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:980:1: ( 'single-line' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:980:1: ( 'single-line' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:981:1: 'single-line'
                    {
                     before(grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0_0()); 
                    match(input,21,FOLLOW_21_in_rule__ScannerSingleLineRule__Alternatives_02047); 
                     after(grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:988:6: ( 'single_line' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:988:6: ( 'single_line' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:989:1: 'single_line'
                    {
                     before(grammarAccess.getScannerSingleLineRuleAccess().getSingle_lineKeyword_0_1()); 
                    match(input,22,FOLLOW_22_in_rule__ScannerSingleLineRule__Alternatives_02067); 
                     after(grammarAccess.getScannerSingleLineRuleAccess().getSingle_lineKeyword_0_1()); 

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
    // $ANTLR end "rule__ScannerSingleLineRule__Alternatives_0"


    // $ANTLR start "rule__PartitionSingleLineRule__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1001:1: rule__PartitionSingleLineRule__Alternatives_0 : ( ( 'single-line' ) | ( 'single_line' ) );
    public final void rule__PartitionSingleLineRule__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1005:1: ( ( 'single-line' ) | ( 'single_line' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            else if ( (LA11_0==22) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1006:1: ( 'single-line' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1006:1: ( 'single-line' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1007:1: 'single-line'
                    {
                     before(grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0_0()); 
                    match(input,21,FOLLOW_21_in_rule__PartitionSingleLineRule__Alternatives_02102); 
                     after(grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1014:6: ( 'single_line' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1014:6: ( 'single_line' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1015:1: 'single_line'
                    {
                     before(grammarAccess.getPartitionSingleLineRuleAccess().getSingle_lineKeyword_0_1()); 
                    match(input,22,FOLLOW_22_in_rule__PartitionSingleLineRule__Alternatives_02122); 
                     after(grammarAccess.getPartitionSingleLineRuleAccess().getSingle_lineKeyword_0_1()); 

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
    // $ANTLR end "rule__PartitionSingleLineRule__Alternatives_0"


    // $ANTLR start "rule__ScannerMultiLineRule__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1027:1: rule__ScannerMultiLineRule__Alternatives_0 : ( ( 'multi-line' ) | ( 'multi_line' ) );
    public final void rule__ScannerMultiLineRule__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1031:1: ( ( 'multi-line' ) | ( 'multi_line' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            else if ( (LA12_0==24) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1032:1: ( 'multi-line' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1032:1: ( 'multi-line' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1033:1: 'multi-line'
                    {
                     before(grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0_0()); 
                    match(input,23,FOLLOW_23_in_rule__ScannerMultiLineRule__Alternatives_02157); 
                     after(grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1040:6: ( 'multi_line' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1040:6: ( 'multi_line' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1041:1: 'multi_line'
                    {
                     before(grammarAccess.getScannerMultiLineRuleAccess().getMulti_lineKeyword_0_1()); 
                    match(input,24,FOLLOW_24_in_rule__ScannerMultiLineRule__Alternatives_02177); 
                     after(grammarAccess.getScannerMultiLineRuleAccess().getMulti_lineKeyword_0_1()); 

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
    // $ANTLR end "rule__ScannerMultiLineRule__Alternatives_0"


    // $ANTLR start "rule__PartitionMultiLineRule__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1053:1: rule__PartitionMultiLineRule__Alternatives_0 : ( ( 'multi-line' ) | ( 'multi_line' ) );
    public final void rule__PartitionMultiLineRule__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1057:1: ( ( 'multi-line' ) | ( 'multi_line' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            else if ( (LA13_0==24) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1058:1: ( 'multi-line' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1058:1: ( 'multi-line' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1059:1: 'multi-line'
                    {
                     before(grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0_0()); 
                    match(input,23,FOLLOW_23_in_rule__PartitionMultiLineRule__Alternatives_02212); 
                     after(grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1066:6: ( 'multi_line' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1066:6: ( 'multi_line' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1067:1: 'multi_line'
                    {
                     before(grammarAccess.getPartitionMultiLineRuleAccess().getMulti_lineKeyword_0_1()); 
                    match(input,24,FOLLOW_24_in_rule__PartitionMultiLineRule__Alternatives_02232); 
                     after(grammarAccess.getPartitionMultiLineRuleAccess().getMulti_lineKeyword_0_1()); 

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
    // $ANTLR end "rule__PartitionMultiLineRule__Alternatives_0"


    // $ANTLR start "rule__ScannerCharacterRule__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1079:1: rule__ScannerCharacterRule__Alternatives_0 : ( ( 'character-rule' ) | ( 'character_rule' ) );
    public final void rule__ScannerCharacterRule__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1083:1: ( ( 'character-rule' ) | ( 'character_rule' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            else if ( (LA14_0==26) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1084:1: ( 'character-rule' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1084:1: ( 'character-rule' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1085:1: 'character-rule'
                    {
                     before(grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0_0()); 
                    match(input,25,FOLLOW_25_in_rule__ScannerCharacterRule__Alternatives_02267); 
                     after(grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1092:6: ( 'character_rule' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1092:6: ( 'character_rule' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1093:1: 'character_rule'
                    {
                     before(grammarAccess.getScannerCharacterRuleAccess().getCharacter_ruleKeyword_0_1()); 
                    match(input,26,FOLLOW_26_in_rule__ScannerCharacterRule__Alternatives_02287); 
                     after(grammarAccess.getScannerCharacterRuleAccess().getCharacter_ruleKeyword_0_1()); 

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
    // $ANTLR end "rule__ScannerCharacterRule__Alternatives_0"


    // $ANTLR start "rule__ScannerJSRule__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1105:1: rule__ScannerJSRule__Alternatives_0 : ( ( 'javascript-rule' ) | ( 'javascript_rule' ) );
    public final void rule__ScannerJSRule__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1109:1: ( ( 'javascript-rule' ) | ( 'javascript_rule' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            else if ( (LA15_0==28) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1110:1: ( 'javascript-rule' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1110:1: ( 'javascript-rule' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1111:1: 'javascript-rule'
                    {
                     before(grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0_0()); 
                    match(input,27,FOLLOW_27_in_rule__ScannerJSRule__Alternatives_02322); 
                     after(grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1118:6: ( 'javascript_rule' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1118:6: ( 'javascript_rule' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1119:1: 'javascript_rule'
                    {
                     before(grammarAccess.getScannerJSRuleAccess().getJavascript_ruleKeyword_0_1()); 
                    match(input,28,FOLLOW_28_in_rule__ScannerJSRule__Alternatives_02342); 
                     after(grammarAccess.getScannerJSRuleAccess().getJavascript_ruleKeyword_0_1()); 

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
    // $ANTLR end "rule__ScannerJSRule__Alternatives_0"


    // $ANTLR start "rule__PartitionJSRule__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1131:1: rule__PartitionJSRule__Alternatives_0 : ( ( 'javascript-rule' ) | ( 'javascript_rule' ) );
    public final void rule__PartitionJSRule__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1135:1: ( ( 'javascript-rule' ) | ( 'javascript_rule' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            else if ( (LA16_0==28) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1136:1: ( 'javascript-rule' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1136:1: ( 'javascript-rule' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1137:1: 'javascript-rule'
                    {
                     before(grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0_0()); 
                    match(input,27,FOLLOW_27_in_rule__PartitionJSRule__Alternatives_02377); 
                     after(grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1144:6: ( 'javascript_rule' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1144:6: ( 'javascript_rule' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1145:1: 'javascript_rule'
                    {
                     before(grammarAccess.getPartitionJSRuleAccess().getJavascript_ruleKeyword_0_1()); 
                    match(input,28,FOLLOW_28_in_rule__PartitionJSRule__Alternatives_02397); 
                     after(grammarAccess.getPartitionJSRuleAccess().getJavascript_ruleKeyword_0_1()); 

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
    // $ANTLR end "rule__PartitionJSRule__Alternatives_0"


    // $ANTLR start "rule__ScannerWhitespaceRule__Alternatives_0"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1157:1: rule__ScannerWhitespaceRule__Alternatives_0 : ( ( 'whitespace-rule' ) | ( 'whitespace_rule' ) );
    public final void rule__ScannerWhitespaceRule__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1161:1: ( ( 'whitespace-rule' ) | ( 'whitespace_rule' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            else if ( (LA17_0==30) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1162:1: ( 'whitespace-rule' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1162:1: ( 'whitespace-rule' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1163:1: 'whitespace-rule'
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0_0()); 
                    match(input,29,FOLLOW_29_in_rule__ScannerWhitespaceRule__Alternatives_02432); 
                     after(grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1170:6: ( 'whitespace_rule' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1170:6: ( 'whitespace_rule' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1171:1: 'whitespace_rule'
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getWhitespace_ruleKeyword_0_1()); 
                    match(input,30,FOLLOW_30_in_rule__ScannerWhitespaceRule__Alternatives_02452); 
                     after(grammarAccess.getScannerWhitespaceRuleAccess().getWhitespace_ruleKeyword_0_1()); 

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
    // $ANTLR end "rule__ScannerWhitespaceRule__Alternatives_0"


    // $ANTLR start "rule__ScannerWhitespaceRule__Alternatives_2"
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1183:1: rule__ScannerWhitespaceRule__Alternatives_2 : ( ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) ) | ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) ) | ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) ) );
    public final void rule__ScannerWhitespaceRule__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1187:1: ( ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) ) | ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) ) | ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt18=1;
                }
                break;
            case 57:
                {
                alt18=2;
                }
                break;
            case RULE_STRING:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1188:1: ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1188:1: ( ( rule__ScannerWhitespaceRule__Group_2_0__0 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1189:1: ( rule__ScannerWhitespaceRule__Group_2_0__0 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_2_0()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1190:1: ( rule__ScannerWhitespaceRule__Group_2_0__0 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1190:2: rule__ScannerWhitespaceRule__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0_in_rule__ScannerWhitespaceRule__Alternatives_22486);
                    rule__ScannerWhitespaceRule__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1194:6: ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1194:6: ( ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1195:1: ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceAssignment_2_1()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1196:1: ( rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1196:2: rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1_in_rule__ScannerWhitespaceRule__Alternatives_22504);
                    rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1200:6: ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1200:6: ( ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1201:1: ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 )
                    {
                     before(grammarAccess.getScannerWhitespaceRuleAccess().getFileURIAssignment_2_2()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1202:1: ( rule__ScannerWhitespaceRule__FileURIAssignment_2_2 )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1202:2: rule__ScannerWhitespaceRule__FileURIAssignment_2_2
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__FileURIAssignment_2_2_in_rule__ScannerWhitespaceRule__Alternatives_22522);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1211:1: rule__FontType__Alternatives : ( ( ( 'bold' ) ) | ( ( 'italic' ) ) | ( ( 'underline' ) ) | ( ( 'strike-through' ) ) );
    public final void rule__FontType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1215:1: ( ( ( 'bold' ) ) | ( ( 'italic' ) ) | ( ( 'underline' ) ) | ( ( 'strike-through' ) ) )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt19=1;
                }
                break;
            case 32:
                {
                alt19=2;
                }
                break;
            case 33:
                {
                alt19=3;
                }
                break;
            case 34:
                {
                alt19=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1216:1: ( ( 'bold' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1216:1: ( ( 'bold' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1217:1: ( 'bold' )
                    {
                     before(grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1218:1: ( 'bold' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1218:3: 'bold'
                    {
                    match(input,31,FOLLOW_31_in_rule__FontType__Alternatives2556); 

                    }

                     after(grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1223:6: ( ( 'italic' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1223:6: ( ( 'italic' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1224:1: ( 'italic' )
                    {
                     before(grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1225:1: ( 'italic' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1225:3: 'italic'
                    {
                    match(input,32,FOLLOW_32_in_rule__FontType__Alternatives2577); 

                    }

                     after(grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1230:6: ( ( 'underline' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1230:6: ( ( 'underline' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1231:1: ( 'underline' )
                    {
                     before(grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1232:1: ( 'underline' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1232:3: 'underline'
                    {
                    match(input,33,FOLLOW_33_in_rule__FontType__Alternatives2598); 

                    }

                     after(grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1237:6: ( ( 'strike-through' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1237:6: ( ( 'strike-through' ) )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1238:1: ( 'strike-through' )
                    {
                     before(grammarAccess.getFontTypeAccess().getStrike_throughEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1239:1: ( 'strike-through' )
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1239:3: 'strike-through'
                    {
                    match(input,34,FOLLOW_34_in_rule__FontType__Alternatives2619); 

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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1251:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1255:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1256:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02652);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02655);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1263:1: rule__Model__Group__0__Impl : ( ( rule__Model__NameAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1267:1: ( ( ( rule__Model__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1268:1: ( ( rule__Model__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1268:1: ( ( rule__Model__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1269:1: ( rule__Model__NameAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1270:1: ( rule__Model__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1270:2: rule__Model__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__NameAssignment_0_in_rule__Model__Group__0__Impl2682);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1280:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1284:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1285:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12712);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12715);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1292:1: rule__Model__Group__1__Impl : ( '{' ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1296:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1297:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1297:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1298:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,35,FOLLOW_35_in_rule__Model__Group__1__Impl2743); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1311:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1315:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1316:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22774);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__22777);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1323:1: rule__Model__Group__2__Impl : ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1327:1: ( ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1328:1: ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1328:1: ( ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1329:1: ( ( rule__Model__PartitionsAssignment_2 ) ) ( ( rule__Model__PartitionsAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1329:1: ( ( rule__Model__PartitionsAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1330:1: ( rule__Model__PartitionsAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1331:1: ( rule__Model__PartitionsAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1331:2: rule__Model__PartitionsAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2806);
            rule__Model__PartitionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1334:1: ( ( rule__Model__PartitionsAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1335:1: ( rule__Model__PartitionsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getPartitionsAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1336:1: ( rule__Model__PartitionsAssignment_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==38) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1336:2: rule__Model__PartitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2818);
            	    rule__Model__PartitionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1347:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1351:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1352:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__32851);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__4_in_rule__Model__Group__32854);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1359:1: rule__Model__Group__3__Impl : ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1363:1: ( ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1364:1: ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1364:1: ( ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1365:1: ( ( rule__Model__DamagersAssignment_3 ) ) ( ( rule__Model__DamagersAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1365:1: ( ( rule__Model__DamagersAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1366:1: ( rule__Model__DamagersAssignment_3 )
            {
             before(grammarAccess.getModelAccess().getDamagersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1367:1: ( rule__Model__DamagersAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1367:2: rule__Model__DamagersAssignment_3
            {
            pushFollow(FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2883);
            rule__Model__DamagersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDamagersAssignment_3()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1370:1: ( ( rule__Model__DamagersAssignment_3 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1371:1: ( rule__Model__DamagersAssignment_3 )*
            {
             before(grammarAccess.getModelAccess().getDamagersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1372:1: ( rule__Model__DamagersAssignment_3 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=17 && LA21_0<=20)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1372:2: rule__Model__DamagersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2895);
            	    rule__Model__DamagersAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1383:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1387:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1388:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__42928);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__5_in_rule__Model__Group__42931);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1395:1: rule__Model__Group__4__Impl : ( ( rule__Model__PartitionerAssignment_4 ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1399:1: ( ( ( rule__Model__PartitionerAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1400:1: ( ( rule__Model__PartitionerAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1400:1: ( ( rule__Model__PartitionerAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1401:1: ( rule__Model__PartitionerAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getPartitionerAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1402:1: ( rule__Model__PartitionerAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1402:2: rule__Model__PartitionerAssignment_4
            {
            pushFollow(FOLLOW_rule__Model__PartitionerAssignment_4_in_rule__Model__Group__4__Impl2958);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1412:1: rule__Model__Group__5 : rule__Model__Group__5__Impl rule__Model__Group__6 ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1416:1: ( rule__Model__Group__5__Impl rule__Model__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1417:2: rule__Model__Group__5__Impl rule__Model__Group__6
            {
            pushFollow(FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__52988);
            rule__Model__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__6_in_rule__Model__Group__52991);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1424:1: rule__Model__Group__5__Impl : ( '}' ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1428:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1429:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1429:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1430:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__Model__Group__5__Impl3019); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1443:1: rule__Model__Group__6 : rule__Model__Group__6__Impl rule__Model__Group__7 ;
    public final void rule__Model__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1447:1: ( rule__Model__Group__6__Impl rule__Model__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1448:2: rule__Model__Group__6__Impl rule__Model__Group__7
            {
            pushFollow(FOLLOW_rule__Model__Group__6__Impl_in_rule__Model__Group__63050);
            rule__Model__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__7_in_rule__Model__Group__63053);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1455:1: rule__Model__Group__6__Impl : ( 'for' ) ;
    public final void rule__Model__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1459:1: ( ( 'for' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1460:1: ( 'for' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1460:1: ( 'for' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1461:1: 'for'
            {
             before(grammarAccess.getModelAccess().getForKeyword_6()); 
            match(input,37,FOLLOW_37_in_rule__Model__Group__6__Impl3081); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1474:1: rule__Model__Group__7 : rule__Model__Group__7__Impl ;
    public final void rule__Model__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1478:1: ( rule__Model__Group__7__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1479:2: rule__Model__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__7__Impl_in_rule__Model__Group__73112);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1485:1: rule__Model__Group__7__Impl : ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) ) ;
    public final void rule__Model__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1489:1: ( ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1490:1: ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1490:1: ( ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1491:1: ( ( rule__Model__ContentTypesAssignment_7 ) ) ( ( rule__Model__ContentTypesAssignment_7 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1491:1: ( ( rule__Model__ContentTypesAssignment_7 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1492:1: ( rule__Model__ContentTypesAssignment_7 )
            {
             before(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1493:1: ( rule__Model__ContentTypesAssignment_7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1493:2: rule__Model__ContentTypesAssignment_7
            {
            pushFollow(FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl3141);
            rule__Model__ContentTypesAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1496:1: ( ( rule__Model__ContentTypesAssignment_7 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1497:1: ( rule__Model__ContentTypesAssignment_7 )*
            {
             before(grammarAccess.getModelAccess().getContentTypesAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1498:1: ( rule__Model__ContentTypesAssignment_7 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_STRING) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1498:2: rule__Model__ContentTypesAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl3153);
            	    rule__Model__ContentTypesAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1525:1: rule__Partition__Group__0 : rule__Partition__Group__0__Impl rule__Partition__Group__1 ;
    public final void rule__Partition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1529:1: ( rule__Partition__Group__0__Impl rule__Partition__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1530:2: rule__Partition__Group__0__Impl rule__Partition__Group__1
            {
            pushFollow(FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__03202);
            rule__Partition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__03205);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1537:1: rule__Partition__Group__0__Impl : ( 'partition' ) ;
    public final void rule__Partition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1541:1: ( ( 'partition' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1542:1: ( 'partition' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1542:1: ( 'partition' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1543:1: 'partition'
            {
             before(grammarAccess.getPartitionAccess().getPartitionKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__Partition__Group__0__Impl3233); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1556:1: rule__Partition__Group__1 : rule__Partition__Group__1__Impl ;
    public final void rule__Partition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1560:1: ( rule__Partition__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1561:2: rule__Partition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__13264);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1567:1: rule__Partition__Group__1__Impl : ( ( rule__Partition__NameAssignment_1 ) ) ;
    public final void rule__Partition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1571:1: ( ( ( rule__Partition__NameAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1572:1: ( ( rule__Partition__NameAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1572:1: ( ( rule__Partition__NameAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1573:1: ( rule__Partition__NameAssignment_1 )
            {
             before(grammarAccess.getPartitionAccess().getNameAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1574:1: ( rule__Partition__NameAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1574:2: rule__Partition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl3291);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1588:1: rule__JavaLikeParitioner__Group__0 : rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1 ;
    public final void rule__JavaLikeParitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1592:1: ( rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1593:2: rule__JavaLikeParitioner__Group__0__Impl rule__JavaLikeParitioner__Group__1
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__0__Impl_in_rule__JavaLikeParitioner__Group__03325);
            rule__JavaLikeParitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__1_in_rule__JavaLikeParitioner__Group__03328);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1600:1: rule__JavaLikeParitioner__Group__0__Impl : ( ( rule__JavaLikeParitioner__Alternatives_0 ) ) ;
    public final void rule__JavaLikeParitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1604:1: ( ( ( rule__JavaLikeParitioner__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1605:1: ( ( rule__JavaLikeParitioner__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1605:1: ( ( rule__JavaLikeParitioner__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1606:1: ( rule__JavaLikeParitioner__Alternatives_0 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1607:1: ( rule__JavaLikeParitioner__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1607:2: rule__JavaLikeParitioner__Alternatives_0
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Alternatives_0_in_rule__JavaLikeParitioner__Group__0__Impl3355);
            rule__JavaLikeParitioner__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getJavaLikeParitionerAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1617:1: rule__JavaLikeParitioner__Group__1 : rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2 ;
    public final void rule__JavaLikeParitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1621:1: ( rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1622:2: rule__JavaLikeParitioner__Group__1__Impl rule__JavaLikeParitioner__Group__2
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__1__Impl_in_rule__JavaLikeParitioner__Group__13385);
            rule__JavaLikeParitioner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__2_in_rule__JavaLikeParitioner__Group__13388);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1629:1: rule__JavaLikeParitioner__Group__1__Impl : ( '{' ) ;
    public final void rule__JavaLikeParitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1633:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1634:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1634:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1635:1: '{'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,35,FOLLOW_35_in_rule__JavaLikeParitioner__Group__1__Impl3416); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1648:1: rule__JavaLikeParitioner__Group__2 : rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3 ;
    public final void rule__JavaLikeParitioner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1652:1: ( rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1653:2: rule__JavaLikeParitioner__Group__2__Impl rule__JavaLikeParitioner__Group__3
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__2__Impl_in_rule__JavaLikeParitioner__Group__23447);
            rule__JavaLikeParitioner__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__3_in_rule__JavaLikeParitioner__Group__23450);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1660:1: rule__JavaLikeParitioner__Group__2__Impl : ( 'singlelinedoc' ) ;
    public final void rule__JavaLikeParitioner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1664:1: ( ( 'singlelinedoc' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1665:1: ( 'singlelinedoc' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1665:1: ( 'singlelinedoc' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1666:1: 'singlelinedoc'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSinglelinedocKeyword_2()); 
            match(input,39,FOLLOW_39_in_rule__JavaLikeParitioner__Group__2__Impl3478); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1679:1: rule__JavaLikeParitioner__Group__3 : rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4 ;
    public final void rule__JavaLikeParitioner__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1683:1: ( rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1684:2: rule__JavaLikeParitioner__Group__3__Impl rule__JavaLikeParitioner__Group__4
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__3__Impl_in_rule__JavaLikeParitioner__Group__33509);
            rule__JavaLikeParitioner__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__4_in_rule__JavaLikeParitioner__Group__33512);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1691:1: rule__JavaLikeParitioner__Group__3__Impl : ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) ) ;
    public final void rule__JavaLikeParitioner__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1695:1: ( ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1696:1: ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1696:1: ( ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1697:1: ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1698:1: ( rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1698:2: rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3_in_rule__JavaLikeParitioner__Group__3__Impl3539);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1708:1: rule__JavaLikeParitioner__Group__4 : rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5 ;
    public final void rule__JavaLikeParitioner__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1712:1: ( rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1713:2: rule__JavaLikeParitioner__Group__4__Impl rule__JavaLikeParitioner__Group__5
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__4__Impl_in_rule__JavaLikeParitioner__Group__43569);
            rule__JavaLikeParitioner__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__5_in_rule__JavaLikeParitioner__Group__43572);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1720:1: rule__JavaLikeParitioner__Group__4__Impl : ( 'multilinedoc' ) ;
    public final void rule__JavaLikeParitioner__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1724:1: ( ( 'multilinedoc' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1725:1: ( 'multilinedoc' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1725:1: ( 'multilinedoc' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1726:1: 'multilinedoc'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultilinedocKeyword_4()); 
            match(input,40,FOLLOW_40_in_rule__JavaLikeParitioner__Group__4__Impl3600); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1739:1: rule__JavaLikeParitioner__Group__5 : rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6 ;
    public final void rule__JavaLikeParitioner__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1743:1: ( rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1744:2: rule__JavaLikeParitioner__Group__5__Impl rule__JavaLikeParitioner__Group__6
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__5__Impl_in_rule__JavaLikeParitioner__Group__53631);
            rule__JavaLikeParitioner__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__6_in_rule__JavaLikeParitioner__Group__53634);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1751:1: rule__JavaLikeParitioner__Group__5__Impl : ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) ) ;
    public final void rule__JavaLikeParitioner__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1755:1: ( ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1756:1: ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1756:1: ( ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1757:1: ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1758:1: ( rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1758:2: rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5_in_rule__JavaLikeParitioner__Group__5__Impl3661);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1768:1: rule__JavaLikeParitioner__Group__6 : rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7 ;
    public final void rule__JavaLikeParitioner__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1772:1: ( rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1773:2: rule__JavaLikeParitioner__Group__6__Impl rule__JavaLikeParitioner__Group__7
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__6__Impl_in_rule__JavaLikeParitioner__Group__63691);
            rule__JavaLikeParitioner__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__7_in_rule__JavaLikeParitioner__Group__63694);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1780:1: rule__JavaLikeParitioner__Group__6__Impl : ( 'javadoc' ) ;
    public final void rule__JavaLikeParitioner__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1784:1: ( ( 'javadoc' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1785:1: ( 'javadoc' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1785:1: ( 'javadoc' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1786:1: 'javadoc'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavadocKeyword_6()); 
            match(input,41,FOLLOW_41_in_rule__JavaLikeParitioner__Group__6__Impl3722); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1799:1: rule__JavaLikeParitioner__Group__7 : rule__JavaLikeParitioner__Group__7__Impl rule__JavaLikeParitioner__Group__8 ;
    public final void rule__JavaLikeParitioner__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1803:1: ( rule__JavaLikeParitioner__Group__7__Impl rule__JavaLikeParitioner__Group__8 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1804:2: rule__JavaLikeParitioner__Group__7__Impl rule__JavaLikeParitioner__Group__8
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__7__Impl_in_rule__JavaLikeParitioner__Group__73753);
            rule__JavaLikeParitioner__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__8_in_rule__JavaLikeParitioner__Group__73756);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1811:1: rule__JavaLikeParitioner__Group__7__Impl : ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) ) ;
    public final void rule__JavaLikeParitioner__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1815:1: ( ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1816:1: ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1816:1: ( ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1817:1: ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionAssignment_7()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1818:1: ( rule__JavaLikeParitioner__JavaDocParitionAssignment_7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1818:2: rule__JavaLikeParitioner__JavaDocParitionAssignment_7
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__JavaDocParitionAssignment_7_in_rule__JavaLikeParitioner__Group__7__Impl3783);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1828:1: rule__JavaLikeParitioner__Group__8 : rule__JavaLikeParitioner__Group__8__Impl rule__JavaLikeParitioner__Group__9 ;
    public final void rule__JavaLikeParitioner__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1832:1: ( rule__JavaLikeParitioner__Group__8__Impl rule__JavaLikeParitioner__Group__9 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1833:2: rule__JavaLikeParitioner__Group__8__Impl rule__JavaLikeParitioner__Group__9
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__8__Impl_in_rule__JavaLikeParitioner__Group__83813);
            rule__JavaLikeParitioner__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__9_in_rule__JavaLikeParitioner__Group__83816);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1840:1: rule__JavaLikeParitioner__Group__8__Impl : ( 'char' ) ;
    public final void rule__JavaLikeParitioner__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1844:1: ( ( 'char' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1845:1: ( 'char' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1845:1: ( 'char' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1846:1: 'char'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharKeyword_8()); 
            match(input,42,FOLLOW_42_in_rule__JavaLikeParitioner__Group__8__Impl3844); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1859:1: rule__JavaLikeParitioner__Group__9 : rule__JavaLikeParitioner__Group__9__Impl rule__JavaLikeParitioner__Group__10 ;
    public final void rule__JavaLikeParitioner__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1863:1: ( rule__JavaLikeParitioner__Group__9__Impl rule__JavaLikeParitioner__Group__10 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1864:2: rule__JavaLikeParitioner__Group__9__Impl rule__JavaLikeParitioner__Group__10
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__9__Impl_in_rule__JavaLikeParitioner__Group__93875);
            rule__JavaLikeParitioner__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__10_in_rule__JavaLikeParitioner__Group__93878);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1871:1: rule__JavaLikeParitioner__Group__9__Impl : ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) ) ;
    public final void rule__JavaLikeParitioner__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1875:1: ( ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1876:1: ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1876:1: ( ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1877:1: ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionAssignment_9()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1878:1: ( rule__JavaLikeParitioner__CharacterParitionAssignment_9 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1878:2: rule__JavaLikeParitioner__CharacterParitionAssignment_9
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__CharacterParitionAssignment_9_in_rule__JavaLikeParitioner__Group__9__Impl3905);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1888:1: rule__JavaLikeParitioner__Group__10 : rule__JavaLikeParitioner__Group__10__Impl rule__JavaLikeParitioner__Group__11 ;
    public final void rule__JavaLikeParitioner__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1892:1: ( rule__JavaLikeParitioner__Group__10__Impl rule__JavaLikeParitioner__Group__11 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1893:2: rule__JavaLikeParitioner__Group__10__Impl rule__JavaLikeParitioner__Group__11
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__10__Impl_in_rule__JavaLikeParitioner__Group__103935);
            rule__JavaLikeParitioner__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__11_in_rule__JavaLikeParitioner__Group__103938);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1900:1: rule__JavaLikeParitioner__Group__10__Impl : ( 'string' ) ;
    public final void rule__JavaLikeParitioner__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1904:1: ( ( 'string' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1905:1: ( 'string' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1905:1: ( 'string' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1906:1: 'string'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringKeyword_10()); 
            match(input,43,FOLLOW_43_in_rule__JavaLikeParitioner__Group__10__Impl3966); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1919:1: rule__JavaLikeParitioner__Group__11 : rule__JavaLikeParitioner__Group__11__Impl rule__JavaLikeParitioner__Group__12 ;
    public final void rule__JavaLikeParitioner__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1923:1: ( rule__JavaLikeParitioner__Group__11__Impl rule__JavaLikeParitioner__Group__12 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1924:2: rule__JavaLikeParitioner__Group__11__Impl rule__JavaLikeParitioner__Group__12
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__11__Impl_in_rule__JavaLikeParitioner__Group__113997);
            rule__JavaLikeParitioner__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__12_in_rule__JavaLikeParitioner__Group__114000);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1931:1: rule__JavaLikeParitioner__Group__11__Impl : ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) ) ;
    public final void rule__JavaLikeParitioner__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1935:1: ( ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1936:1: ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1936:1: ( ( rule__JavaLikeParitioner__StringParitionAssignment_11 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1937:1: ( rule__JavaLikeParitioner__StringParitionAssignment_11 )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionAssignment_11()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1938:1: ( rule__JavaLikeParitioner__StringParitionAssignment_11 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1938:2: rule__JavaLikeParitioner__StringParitionAssignment_11
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__StringParitionAssignment_11_in_rule__JavaLikeParitioner__Group__11__Impl4027);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1948:1: rule__JavaLikeParitioner__Group__12 : rule__JavaLikeParitioner__Group__12__Impl ;
    public final void rule__JavaLikeParitioner__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1952:1: ( rule__JavaLikeParitioner__Group__12__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1953:2: rule__JavaLikeParitioner__Group__12__Impl
            {
            pushFollow(FOLLOW_rule__JavaLikeParitioner__Group__12__Impl_in_rule__JavaLikeParitioner__Group__124057);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1959:1: rule__JavaLikeParitioner__Group__12__Impl : ( '}' ) ;
    public final void rule__JavaLikeParitioner__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1963:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1964:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1964:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:1965:1: '}'
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getRightCurlyBracketKeyword_12()); 
            match(input,36,FOLLOW_36_in_rule__JavaLikeParitioner__Group__12__Impl4085); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2004:1: rule__RulePartitioner__Group__0 : rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1 ;
    public final void rule__RulePartitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2008:1: ( rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2009:2: rule__RulePartitioner__Group__0__Impl rule__RulePartitioner__Group__1
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__0__Impl_in_rule__RulePartitioner__Group__04142);
            rule__RulePartitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__1_in_rule__RulePartitioner__Group__04145);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2016:1: rule__RulePartitioner__Group__0__Impl : ( ( rule__RulePartitioner__Alternatives_0 ) ) ;
    public final void rule__RulePartitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2020:1: ( ( ( rule__RulePartitioner__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2021:1: ( ( rule__RulePartitioner__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2021:1: ( ( rule__RulePartitioner__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2022:1: ( rule__RulePartitioner__Alternatives_0 )
            {
             before(grammarAccess.getRulePartitionerAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2023:1: ( rule__RulePartitioner__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2023:2: rule__RulePartitioner__Alternatives_0
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Alternatives_0_in_rule__RulePartitioner__Group__0__Impl4172);
            rule__RulePartitioner__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getRulePartitionerAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2033:1: rule__RulePartitioner__Group__1 : rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2 ;
    public final void rule__RulePartitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2037:1: ( rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2038:2: rule__RulePartitioner__Group__1__Impl rule__RulePartitioner__Group__2
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__1__Impl_in_rule__RulePartitioner__Group__14202);
            rule__RulePartitioner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__2_in_rule__RulePartitioner__Group__14205);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2045:1: rule__RulePartitioner__Group__1__Impl : ( '{' ) ;
    public final void rule__RulePartitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2049:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2050:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2050:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2051:1: '{'
            {
             before(grammarAccess.getRulePartitionerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,35,FOLLOW_35_in_rule__RulePartitioner__Group__1__Impl4233); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2064:1: rule__RulePartitioner__Group__2 : rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3 ;
    public final void rule__RulePartitioner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2068:1: ( rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2069:2: rule__RulePartitioner__Group__2__Impl rule__RulePartitioner__Group__3
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__2__Impl_in_rule__RulePartitioner__Group__24264);
            rule__RulePartitioner__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RulePartitioner__Group__3_in_rule__RulePartitioner__Group__24267);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2076:1: rule__RulePartitioner__Group__2__Impl : ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) ) ;
    public final void rule__RulePartitioner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2080:1: ( ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2081:1: ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2081:1: ( ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2082:1: ( ( rule__RulePartitioner__RulesAssignment_2 ) ) ( ( rule__RulePartitioner__RulesAssignment_2 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2082:1: ( ( rule__RulePartitioner__RulesAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2083:1: ( rule__RulePartitioner__RulesAssignment_2 )
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2084:1: ( rule__RulePartitioner__RulesAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2084:2: rule__RulePartitioner__RulesAssignment_2
            {
            pushFollow(FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl4296);
            rule__RulePartitioner__RulesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 

            }

            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2087:1: ( ( rule__RulePartitioner__RulesAssignment_2 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2088:1: ( rule__RulePartitioner__RulesAssignment_2 )*
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2089:1: ( rule__RulePartitioner__RulesAssignment_2 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=21 && LA23_0<=24)||(LA23_0>=27 && LA23_0<=28)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2089:2: rule__RulePartitioner__RulesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl4308);
            	    rule__RulePartitioner__RulesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2100:1: rule__RulePartitioner__Group__3 : rule__RulePartitioner__Group__3__Impl ;
    public final void rule__RulePartitioner__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2104:1: ( rule__RulePartitioner__Group__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2105:2: rule__RulePartitioner__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__RulePartitioner__Group__3__Impl_in_rule__RulePartitioner__Group__34341);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2111:1: rule__RulePartitioner__Group__3__Impl : ( '}' ) ;
    public final void rule__RulePartitioner__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2115:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2116:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2116:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2117:1: '}'
            {
             before(grammarAccess.getRulePartitionerAccess().getRightCurlyBracketKeyword_3()); 
            match(input,36,FOLLOW_36_in_rule__RulePartitioner__Group__3__Impl4369); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2138:1: rule__JSParitioner__Group__0 : rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1 ;
    public final void rule__JSParitioner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2142:1: ( rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2143:2: rule__JSParitioner__Group__0__Impl rule__JSParitioner__Group__1
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__0__Impl_in_rule__JSParitioner__Group__04408);
            rule__JSParitioner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSParitioner__Group__1_in_rule__JSParitioner__Group__04411);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2150:1: rule__JSParitioner__Group__0__Impl : ( ( rule__JSParitioner__Alternatives_0 ) ) ;
    public final void rule__JSParitioner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2154:1: ( ( ( rule__JSParitioner__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2155:1: ( ( rule__JSParitioner__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2155:1: ( ( rule__JSParitioner__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2156:1: ( rule__JSParitioner__Alternatives_0 )
            {
             before(grammarAccess.getJSParitionerAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2157:1: ( rule__JSParitioner__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2157:2: rule__JSParitioner__Alternatives_0
            {
            pushFollow(FOLLOW_rule__JSParitioner__Alternatives_0_in_rule__JSParitioner__Group__0__Impl4438);
            rule__JSParitioner__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getJSParitionerAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2167:1: rule__JSParitioner__Group__1 : rule__JSParitioner__Group__1__Impl ;
    public final void rule__JSParitioner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2171:1: ( rule__JSParitioner__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2172:2: rule__JSParitioner__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JSParitioner__Group__1__Impl_in_rule__JSParitioner__Group__14468);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2178:1: rule__JSParitioner__Group__1__Impl : ( ( rule__JSParitioner__FileURIAssignment_1 ) ) ;
    public final void rule__JSParitioner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2182:1: ( ( ( rule__JSParitioner__FileURIAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2183:1: ( ( rule__JSParitioner__FileURIAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2183:1: ( ( rule__JSParitioner__FileURIAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2184:1: ( rule__JSParitioner__FileURIAssignment_1 )
            {
             before(grammarAccess.getJSParitionerAccess().getFileURIAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2185:1: ( rule__JSParitioner__FileURIAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2185:2: rule__JSParitioner__FileURIAssignment_1
            {
            pushFollow(FOLLOW_rule__JSParitioner__FileURIAssignment_1_in_rule__JSParitioner__Group__1__Impl4495);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2199:1: rule__JSDamager__Group__0 : rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1 ;
    public final void rule__JSDamager__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2203:1: ( rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2204:2: rule__JSDamager__Group__0__Impl rule__JSDamager__Group__1
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__0__Impl_in_rule__JSDamager__Group__04529);
            rule__JSDamager__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSDamager__Group__1_in_rule__JSDamager__Group__04532);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2211:1: rule__JSDamager__Group__0__Impl : ( ( rule__JSDamager__Alternatives_0 ) ) ;
    public final void rule__JSDamager__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2215:1: ( ( ( rule__JSDamager__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2216:1: ( ( rule__JSDamager__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2216:1: ( ( rule__JSDamager__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2217:1: ( rule__JSDamager__Alternatives_0 )
            {
             before(grammarAccess.getJSDamagerAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2218:1: ( rule__JSDamager__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2218:2: rule__JSDamager__Alternatives_0
            {
            pushFollow(FOLLOW_rule__JSDamager__Alternatives_0_in_rule__JSDamager__Group__0__Impl4559);
            rule__JSDamager__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getJSDamagerAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2228:1: rule__JSDamager__Group__1 : rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2 ;
    public final void rule__JSDamager__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2232:1: ( rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2233:2: rule__JSDamager__Group__1__Impl rule__JSDamager__Group__2
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__1__Impl_in_rule__JSDamager__Group__14589);
            rule__JSDamager__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JSDamager__Group__2_in_rule__JSDamager__Group__14592);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2240:1: rule__JSDamager__Group__1__Impl : ( ( rule__JSDamager__PartitionAssignment_1 ) ) ;
    public final void rule__JSDamager__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2244:1: ( ( ( rule__JSDamager__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2245:1: ( ( rule__JSDamager__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2245:1: ( ( rule__JSDamager__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2246:1: ( rule__JSDamager__PartitionAssignment_1 )
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2247:1: ( rule__JSDamager__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2247:2: rule__JSDamager__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__JSDamager__PartitionAssignment_1_in_rule__JSDamager__Group__1__Impl4619);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2257:1: rule__JSDamager__Group__2 : rule__JSDamager__Group__2__Impl ;
    public final void rule__JSDamager__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2261:1: ( rule__JSDamager__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2262:2: rule__JSDamager__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__JSDamager__Group__2__Impl_in_rule__JSDamager__Group__24649);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2268:1: rule__JSDamager__Group__2__Impl : ( ( rule__JSDamager__FileURIAssignment_2 ) ) ;
    public final void rule__JSDamager__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2272:1: ( ( ( rule__JSDamager__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2273:1: ( ( rule__JSDamager__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2273:1: ( ( rule__JSDamager__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2274:1: ( rule__JSDamager__FileURIAssignment_2 )
            {
             before(grammarAccess.getJSDamagerAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2275:1: ( rule__JSDamager__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2275:2: rule__JSDamager__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__JSDamager__FileURIAssignment_2_in_rule__JSDamager__Group__2__Impl4676);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2291:1: rule__RuleDamager__Group__0 : rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1 ;
    public final void rule__RuleDamager__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2295:1: ( rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2296:2: rule__RuleDamager__Group__0__Impl rule__RuleDamager__Group__1
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__0__Impl_in_rule__RuleDamager__Group__04712);
            rule__RuleDamager__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__1_in_rule__RuleDamager__Group__04715);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2303:1: rule__RuleDamager__Group__0__Impl : ( ( rule__RuleDamager__Alternatives_0 ) ) ;
    public final void rule__RuleDamager__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2307:1: ( ( ( rule__RuleDamager__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2308:1: ( ( rule__RuleDamager__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2308:1: ( ( rule__RuleDamager__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2309:1: ( rule__RuleDamager__Alternatives_0 )
            {
             before(grammarAccess.getRuleDamagerAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2310:1: ( rule__RuleDamager__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2310:2: rule__RuleDamager__Alternatives_0
            {
            pushFollow(FOLLOW_rule__RuleDamager__Alternatives_0_in_rule__RuleDamager__Group__0__Impl4742);
            rule__RuleDamager__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getRuleDamagerAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2320:1: rule__RuleDamager__Group__1 : rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2 ;
    public final void rule__RuleDamager__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2324:1: ( rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2325:2: rule__RuleDamager__Group__1__Impl rule__RuleDamager__Group__2
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__1__Impl_in_rule__RuleDamager__Group__14772);
            rule__RuleDamager__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__2_in_rule__RuleDamager__Group__14775);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2332:1: rule__RuleDamager__Group__1__Impl : ( ( rule__RuleDamager__PartitionAssignment_1 ) ) ;
    public final void rule__RuleDamager__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2336:1: ( ( ( rule__RuleDamager__PartitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2337:1: ( ( rule__RuleDamager__PartitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2337:1: ( ( rule__RuleDamager__PartitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2338:1: ( rule__RuleDamager__PartitionAssignment_1 )
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2339:1: ( rule__RuleDamager__PartitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2339:2: rule__RuleDamager__PartitionAssignment_1
            {
            pushFollow(FOLLOW_rule__RuleDamager__PartitionAssignment_1_in_rule__RuleDamager__Group__1__Impl4802);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2349:1: rule__RuleDamager__Group__2 : rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3 ;
    public final void rule__RuleDamager__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2353:1: ( rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2354:2: rule__RuleDamager__Group__2__Impl rule__RuleDamager__Group__3
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__2__Impl_in_rule__RuleDamager__Group__24832);
            rule__RuleDamager__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__3_in_rule__RuleDamager__Group__24835);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2361:1: rule__RuleDamager__Group__2__Impl : ( '{' ) ;
    public final void rule__RuleDamager__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2365:1: ( ( '{' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2366:1: ( '{' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2366:1: ( '{' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2367:1: '{'
            {
             before(grammarAccess.getRuleDamagerAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__RuleDamager__Group__2__Impl4863); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2380:1: rule__RuleDamager__Group__3 : rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4 ;
    public final void rule__RuleDamager__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2384:1: ( rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2385:2: rule__RuleDamager__Group__3__Impl rule__RuleDamager__Group__4
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__3__Impl_in_rule__RuleDamager__Group__34894);
            rule__RuleDamager__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__4_in_rule__RuleDamager__Group__34897);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2392:1: rule__RuleDamager__Group__3__Impl : ( ( rule__RuleDamager__TokensAssignment_3 )* ) ;
    public final void rule__RuleDamager__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2396:1: ( ( ( rule__RuleDamager__TokensAssignment_3 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2397:1: ( ( rule__RuleDamager__TokensAssignment_3 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2397:1: ( ( rule__RuleDamager__TokensAssignment_3 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2398:1: ( rule__RuleDamager__TokensAssignment_3 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getTokensAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2399:1: ( rule__RuleDamager__TokensAssignment_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==44||LA24_0==56) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2399:2: rule__RuleDamager__TokensAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__TokensAssignment_3_in_rule__RuleDamager__Group__3__Impl4924);
            	    rule__RuleDamager__TokensAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2409:1: rule__RuleDamager__Group__4 : rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5 ;
    public final void rule__RuleDamager__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2413:1: ( rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2414:2: rule__RuleDamager__Group__4__Impl rule__RuleDamager__Group__5
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__4__Impl_in_rule__RuleDamager__Group__44955);
            rule__RuleDamager__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__5_in_rule__RuleDamager__Group__44958);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2421:1: rule__RuleDamager__Group__4__Impl : ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* ) ;
    public final void rule__RuleDamager__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2425:1: ( ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2426:1: ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2426:1: ( ( rule__RuleDamager__KeywordGroupsAssignment_4 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2427:1: ( rule__RuleDamager__KeywordGroupsAssignment_4 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getKeywordGroupsAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2428:1: ( rule__RuleDamager__KeywordGroupsAssignment_4 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==45) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2428:2: rule__RuleDamager__KeywordGroupsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__KeywordGroupsAssignment_4_in_rule__RuleDamager__Group__4__Impl4985);
            	    rule__RuleDamager__KeywordGroupsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2438:1: rule__RuleDamager__Group__5 : rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6 ;
    public final void rule__RuleDamager__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2442:1: ( rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2443:2: rule__RuleDamager__Group__5__Impl rule__RuleDamager__Group__6
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__5__Impl_in_rule__RuleDamager__Group__55016);
            rule__RuleDamager__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDamager__Group__6_in_rule__RuleDamager__Group__55019);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2450:1: rule__RuleDamager__Group__5__Impl : ( ( rule__RuleDamager__RulesAssignment_5 )* ) ;
    public final void rule__RuleDamager__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2454:1: ( ( ( rule__RuleDamager__RulesAssignment_5 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2455:1: ( ( rule__RuleDamager__RulesAssignment_5 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2455:1: ( ( rule__RuleDamager__RulesAssignment_5 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2456:1: ( rule__RuleDamager__RulesAssignment_5 )*
            {
             before(grammarAccess.getRuleDamagerAccess().getRulesAssignment_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2457:1: ( rule__RuleDamager__RulesAssignment_5 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=21 && LA26_0<=30)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2457:2: rule__RuleDamager__RulesAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__RuleDamager__RulesAssignment_5_in_rule__RuleDamager__Group__5__Impl5046);
            	    rule__RuleDamager__RulesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2467:1: rule__RuleDamager__Group__6 : rule__RuleDamager__Group__6__Impl ;
    public final void rule__RuleDamager__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2471:1: ( rule__RuleDamager__Group__6__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2472:2: rule__RuleDamager__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__RuleDamager__Group__6__Impl_in_rule__RuleDamager__Group__65077);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2478:1: rule__RuleDamager__Group__6__Impl : ( '}' ) ;
    public final void rule__RuleDamager__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2482:1: ( ( '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2483:1: ( '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2483:1: ( '}' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2484:1: '}'
            {
             before(grammarAccess.getRuleDamagerAccess().getRightCurlyBracketKeyword_6()); 
            match(input,36,FOLLOW_36_in_rule__RuleDamager__Group__6__Impl5105); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2511:1: rule__ScannerToken__Group__0 : rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1 ;
    public final void rule__ScannerToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2515:1: ( rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2516:2: rule__ScannerToken__Group__0__Impl rule__ScannerToken__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__0__Impl_in_rule__ScannerToken__Group__05150);
            rule__ScannerToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__1_in_rule__ScannerToken__Group__05153);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2523:1: rule__ScannerToken__Group__0__Impl : ( ( rule__ScannerToken__DefaultAssignment_0 )? ) ;
    public final void rule__ScannerToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2527:1: ( ( ( rule__ScannerToken__DefaultAssignment_0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2528:1: ( ( rule__ScannerToken__DefaultAssignment_0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2528:1: ( ( rule__ScannerToken__DefaultAssignment_0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2529:1: ( rule__ScannerToken__DefaultAssignment_0 )?
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2530:1: ( rule__ScannerToken__DefaultAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==56) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2530:2: rule__ScannerToken__DefaultAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ScannerToken__DefaultAssignment_0_in_rule__ScannerToken__Group__0__Impl5180);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2540:1: rule__ScannerToken__Group__1 : rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2 ;
    public final void rule__ScannerToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2544:1: ( rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2545:2: rule__ScannerToken__Group__1__Impl rule__ScannerToken__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__1__Impl_in_rule__ScannerToken__Group__15211);
            rule__ScannerToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerToken__Group__2_in_rule__ScannerToken__Group__15214);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2552:1: rule__ScannerToken__Group__1__Impl : ( 'token' ) ;
    public final void rule__ScannerToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2556:1: ( ( 'token' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2557:1: ( 'token' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2557:1: ( 'token' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2558:1: 'token'
            {
             before(grammarAccess.getScannerTokenAccess().getTokenKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__ScannerToken__Group__1__Impl5242); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2571:1: rule__ScannerToken__Group__2 : rule__ScannerToken__Group__2__Impl ;
    public final void rule__ScannerToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2575:1: ( rule__ScannerToken__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2576:2: rule__ScannerToken__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerToken__Group__2__Impl_in_rule__ScannerToken__Group__25273);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2582:1: rule__ScannerToken__Group__2__Impl : ( ( rule__ScannerToken__NameAssignment_2 ) ) ;
    public final void rule__ScannerToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2586:1: ( ( ( rule__ScannerToken__NameAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2587:1: ( ( rule__ScannerToken__NameAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2587:1: ( ( rule__ScannerToken__NameAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2588:1: ( rule__ScannerToken__NameAssignment_2 )
            {
             before(grammarAccess.getScannerTokenAccess().getNameAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2589:1: ( rule__ScannerToken__NameAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2589:2: rule__ScannerToken__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerToken__NameAssignment_2_in_rule__ScannerToken__Group__2__Impl5300);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2605:1: rule__KeywordGroup__Group__0 : rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1 ;
    public final void rule__KeywordGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2609:1: ( rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2610:2: rule__KeywordGroup__Group__0__Impl rule__KeywordGroup__Group__1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__0__Impl_in_rule__KeywordGroup__Group__05336);
            rule__KeywordGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__1_in_rule__KeywordGroup__Group__05339);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2617:1: rule__KeywordGroup__Group__0__Impl : ( 'keywords' ) ;
    public final void rule__KeywordGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2621:1: ( ( 'keywords' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2622:1: ( 'keywords' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2622:1: ( 'keywords' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2623:1: 'keywords'
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0()); 
            match(input,45,FOLLOW_45_in_rule__KeywordGroup__Group__0__Impl5367); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2636:1: rule__KeywordGroup__Group__1 : rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2 ;
    public final void rule__KeywordGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2640:1: ( rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2641:2: rule__KeywordGroup__Group__1__Impl rule__KeywordGroup__Group__2
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__1__Impl_in_rule__KeywordGroup__Group__15398);
            rule__KeywordGroup__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__2_in_rule__KeywordGroup__Group__15401);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2648:1: rule__KeywordGroup__Group__1__Impl : ( ( rule__KeywordGroup__TokenAssignment_1 ) ) ;
    public final void rule__KeywordGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2652:1: ( ( ( rule__KeywordGroup__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2653:1: ( ( rule__KeywordGroup__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2653:1: ( ( rule__KeywordGroup__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2654:1: ( rule__KeywordGroup__TokenAssignment_1 )
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2655:1: ( rule__KeywordGroup__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2655:2: rule__KeywordGroup__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__TokenAssignment_1_in_rule__KeywordGroup__Group__1__Impl5428);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2665:1: rule__KeywordGroup__Group__2 : rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3 ;
    public final void rule__KeywordGroup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2669:1: ( rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2670:2: rule__KeywordGroup__Group__2__Impl rule__KeywordGroup__Group__3
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__2__Impl_in_rule__KeywordGroup__Group__25458);
            rule__KeywordGroup__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__3_in_rule__KeywordGroup__Group__25461);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2677:1: rule__KeywordGroup__Group__2__Impl : ( '[' ) ;
    public final void rule__KeywordGroup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2681:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2682:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2682:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2683:1: '['
            {
             before(grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2()); 
            match(input,46,FOLLOW_46_in_rule__KeywordGroup__Group__2__Impl5489); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2696:1: rule__KeywordGroup__Group__3 : rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4 ;
    public final void rule__KeywordGroup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2700:1: ( rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2701:2: rule__KeywordGroup__Group__3__Impl rule__KeywordGroup__Group__4
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__3__Impl_in_rule__KeywordGroup__Group__35520);
            rule__KeywordGroup__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__4_in_rule__KeywordGroup__Group__35523);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2708:1: rule__KeywordGroup__Group__3__Impl : ( ( rule__KeywordGroup__KeywordsAssignment_3 ) ) ;
    public final void rule__KeywordGroup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2712:1: ( ( ( rule__KeywordGroup__KeywordsAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2713:1: ( ( rule__KeywordGroup__KeywordsAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2713:1: ( ( rule__KeywordGroup__KeywordsAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2714:1: ( rule__KeywordGroup__KeywordsAssignment_3 )
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2715:1: ( rule__KeywordGroup__KeywordsAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2715:2: rule__KeywordGroup__KeywordsAssignment_3
            {
            pushFollow(FOLLOW_rule__KeywordGroup__KeywordsAssignment_3_in_rule__KeywordGroup__Group__3__Impl5550);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2725:1: rule__KeywordGroup__Group__4 : rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5 ;
    public final void rule__KeywordGroup__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2729:1: ( rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2730:2: rule__KeywordGroup__Group__4__Impl rule__KeywordGroup__Group__5
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__4__Impl_in_rule__KeywordGroup__Group__45580);
            rule__KeywordGroup__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group__5_in_rule__KeywordGroup__Group__45583);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2737:1: rule__KeywordGroup__Group__4__Impl : ( ( rule__KeywordGroup__Group_4__0 )* ) ;
    public final void rule__KeywordGroup__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2741:1: ( ( ( rule__KeywordGroup__Group_4__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2742:1: ( ( rule__KeywordGroup__Group_4__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2742:1: ( ( rule__KeywordGroup__Group_4__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2743:1: ( rule__KeywordGroup__Group_4__0 )*
            {
             before(grammarAccess.getKeywordGroupAccess().getGroup_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2744:1: ( rule__KeywordGroup__Group_4__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==48) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2744:2: rule__KeywordGroup__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__KeywordGroup__Group_4__0_in_rule__KeywordGroup__Group__4__Impl5610);
            	    rule__KeywordGroup__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2754:1: rule__KeywordGroup__Group__5 : rule__KeywordGroup__Group__5__Impl ;
    public final void rule__KeywordGroup__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2758:1: ( rule__KeywordGroup__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2759:2: rule__KeywordGroup__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group__5__Impl_in_rule__KeywordGroup__Group__55641);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2765:1: rule__KeywordGroup__Group__5__Impl : ( ']' ) ;
    public final void rule__KeywordGroup__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2769:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2770:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2770:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2771:1: ']'
            {
             before(grammarAccess.getKeywordGroupAccess().getRightSquareBracketKeyword_5()); 
            match(input,47,FOLLOW_47_in_rule__KeywordGroup__Group__5__Impl5669); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2796:1: rule__KeywordGroup__Group_4__0 : rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1 ;
    public final void rule__KeywordGroup__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2800:1: ( rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2801:2: rule__KeywordGroup__Group_4__0__Impl rule__KeywordGroup__Group_4__1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__0__Impl_in_rule__KeywordGroup__Group_4__05712);
            rule__KeywordGroup__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__1_in_rule__KeywordGroup__Group_4__05715);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2808:1: rule__KeywordGroup__Group_4__0__Impl : ( ',' ) ;
    public final void rule__KeywordGroup__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2812:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2813:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2813:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2814:1: ','
            {
             before(grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0()); 
            match(input,48,FOLLOW_48_in_rule__KeywordGroup__Group_4__0__Impl5743); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2827:1: rule__KeywordGroup__Group_4__1 : rule__KeywordGroup__Group_4__1__Impl ;
    public final void rule__KeywordGroup__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2831:1: ( rule__KeywordGroup__Group_4__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2832:2: rule__KeywordGroup__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__KeywordGroup__Group_4__1__Impl_in_rule__KeywordGroup__Group_4__15774);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2838:1: rule__KeywordGroup__Group_4__1__Impl : ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) ) ;
    public final void rule__KeywordGroup__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2842:1: ( ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2843:1: ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2843:1: ( ( rule__KeywordGroup__KeywordsAssignment_4_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2844:1: ( rule__KeywordGroup__KeywordsAssignment_4_1 )
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsAssignment_4_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2845:1: ( rule__KeywordGroup__KeywordsAssignment_4_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2845:2: rule__KeywordGroup__KeywordsAssignment_4_1
            {
            pushFollow(FOLLOW_rule__KeywordGroup__KeywordsAssignment_4_1_in_rule__KeywordGroup__Group_4__1__Impl5801);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2859:1: rule__Keyword__Group__0 : rule__Keyword__Group__0__Impl rule__Keyword__Group__1 ;
    public final void rule__Keyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2863:1: ( rule__Keyword__Group__0__Impl rule__Keyword__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2864:2: rule__Keyword__Group__0__Impl rule__Keyword__Group__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__05835);
            rule__Keyword__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__05838);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2871:1: rule__Keyword__Group__0__Impl : ( ( rule__Keyword__NameAssignment_0 ) ) ;
    public final void rule__Keyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2875:1: ( ( ( rule__Keyword__NameAssignment_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2876:1: ( ( rule__Keyword__NameAssignment_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2876:1: ( ( rule__Keyword__NameAssignment_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2877:1: ( rule__Keyword__NameAssignment_0 )
            {
             before(grammarAccess.getKeywordAccess().getNameAssignment_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2878:1: ( rule__Keyword__NameAssignment_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2878:2: rule__Keyword__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl5865);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2888:1: rule__Keyword__Group__1 : rule__Keyword__Group__1__Impl ;
    public final void rule__Keyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2892:1: ( rule__Keyword__Group__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2893:2: rule__Keyword__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__15895);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2899:1: rule__Keyword__Group__1__Impl : ( ( rule__Keyword__Group_1__0 )? ) ;
    public final void rule__Keyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2903:1: ( ( ( rule__Keyword__Group_1__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2904:1: ( ( rule__Keyword__Group_1__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2904:1: ( ( rule__Keyword__Group_1__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2905:1: ( rule__Keyword__Group_1__0 )?
            {
             before(grammarAccess.getKeywordAccess().getGroup_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2906:1: ( rule__Keyword__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==49) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2906:2: rule__Keyword__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl5922);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2920:1: rule__Keyword__Group_1__0 : rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 ;
    public final void rule__Keyword__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2924:1: ( rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2925:2: rule__Keyword__Group_1__0__Impl rule__Keyword__Group_1__1
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__05957);
            rule__Keyword__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__05960);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2932:1: rule__Keyword__Group_1__0__Impl : ( 'since' ) ;
    public final void rule__Keyword__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2936:1: ( ( 'since' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2937:1: ( 'since' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2937:1: ( 'since' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2938:1: 'since'
            {
             before(grammarAccess.getKeywordAccess().getSinceKeyword_1_0()); 
            match(input,49,FOLLOW_49_in_rule__Keyword__Group_1__0__Impl5988); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2951:1: rule__Keyword__Group_1__1 : rule__Keyword__Group_1__1__Impl ;
    public final void rule__Keyword__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2955:1: ( rule__Keyword__Group_1__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2956:2: rule__Keyword__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__16019);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2962:1: rule__Keyword__Group_1__1__Impl : ( ( rule__Keyword__VersionAssignment_1_1 ) ) ;
    public final void rule__Keyword__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2966:1: ( ( ( rule__Keyword__VersionAssignment_1_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2967:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2967:1: ( ( rule__Keyword__VersionAssignment_1_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2968:1: ( rule__Keyword__VersionAssignment_1_1 )
            {
             before(grammarAccess.getKeywordAccess().getVersionAssignment_1_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2969:1: ( rule__Keyword__VersionAssignment_1_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2969:2: rule__Keyword__VersionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl6046);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2983:1: rule__ScannerSingleLineRule__Group__0 : rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1 ;
    public final void rule__ScannerSingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2987:1: ( rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2988:2: rule__ScannerSingleLineRule__Group__0__Impl rule__ScannerSingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__0__Impl_in_rule__ScannerSingleLineRule__Group__06080);
            rule__ScannerSingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__1_in_rule__ScannerSingleLineRule__Group__06083);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2995:1: rule__ScannerSingleLineRule__Group__0__Impl : ( ( rule__ScannerSingleLineRule__Alternatives_0 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:2999:1: ( ( ( rule__ScannerSingleLineRule__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3000:1: ( ( rule__ScannerSingleLineRule__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3000:1: ( ( rule__ScannerSingleLineRule__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3001:1: ( rule__ScannerSingleLineRule__Alternatives_0 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3002:1: ( rule__ScannerSingleLineRule__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3002:2: rule__ScannerSingleLineRule__Alternatives_0
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Alternatives_0_in_rule__ScannerSingleLineRule__Group__0__Impl6110);
            rule__ScannerSingleLineRule__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getScannerSingleLineRuleAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3012:1: rule__ScannerSingleLineRule__Group__1 : rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2 ;
    public final void rule__ScannerSingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3016:1: ( rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3017:2: rule__ScannerSingleLineRule__Group__1__Impl rule__ScannerSingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__1__Impl_in_rule__ScannerSingleLineRule__Group__16140);
            rule__ScannerSingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__2_in_rule__ScannerSingleLineRule__Group__16143);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3024:1: rule__ScannerSingleLineRule__Group__1__Impl : ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3028:1: ( ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3029:1: ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3029:1: ( ( rule__ScannerSingleLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3030:1: ( rule__ScannerSingleLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3031:1: ( rule__ScannerSingleLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3031:2: rule__ScannerSingleLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__TokenAssignment_1_in_rule__ScannerSingleLineRule__Group__1__Impl6170);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3041:1: rule__ScannerSingleLineRule__Group__2 : rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3 ;
    public final void rule__ScannerSingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3045:1: ( rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3046:2: rule__ScannerSingleLineRule__Group__2__Impl rule__ScannerSingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__2__Impl_in_rule__ScannerSingleLineRule__Group__26200);
            rule__ScannerSingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__3_in_rule__ScannerSingleLineRule__Group__26203);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3053:1: rule__ScannerSingleLineRule__Group__2__Impl : ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3057:1: ( ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3058:1: ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3058:1: ( ( rule__ScannerSingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3059:1: ( rule__ScannerSingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3060:1: ( rule__ScannerSingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3060:2: rule__ScannerSingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__StartSeqAssignment_2_in_rule__ScannerSingleLineRule__Group__2__Impl6230);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3070:1: rule__ScannerSingleLineRule__Group__3 : rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4 ;
    public final void rule__ScannerSingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3074:1: ( rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3075:2: rule__ScannerSingleLineRule__Group__3__Impl rule__ScannerSingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__3__Impl_in_rule__ScannerSingleLineRule__Group__36260);
            rule__ScannerSingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__4_in_rule__ScannerSingleLineRule__Group__36263);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3082:1: rule__ScannerSingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__ScannerSingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3086:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3087:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3087:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3088:1: '=>'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,50,FOLLOW_50_in_rule__ScannerSingleLineRule__Group__3__Impl6291); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3101:1: rule__ScannerSingleLineRule__Group__4 : rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5 ;
    public final void rule__ScannerSingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3105:1: ( rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3106:2: rule__ScannerSingleLineRule__Group__4__Impl rule__ScannerSingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__4__Impl_in_rule__ScannerSingleLineRule__Group__46322);
            rule__ScannerSingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__5_in_rule__ScannerSingleLineRule__Group__46325);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3113:1: rule__ScannerSingleLineRule__Group__4__Impl : ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__ScannerSingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3117:1: ( ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3118:1: ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3118:1: ( ( rule__ScannerSingleLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3119:1: ( rule__ScannerSingleLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3120:1: ( rule__ScannerSingleLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3120:2: rule__ScannerSingleLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__EndSeqAssignment_4_in_rule__ScannerSingleLineRule__Group__4__Impl6352);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3130:1: rule__ScannerSingleLineRule__Group__5 : rule__ScannerSingleLineRule__Group__5__Impl ;
    public final void rule__ScannerSingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3134:1: ( rule__ScannerSingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3135:2: rule__ScannerSingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group__5__Impl_in_rule__ScannerSingleLineRule__Group__56382);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3141:1: rule__ScannerSingleLineRule__Group__5__Impl : ( ( rule__ScannerSingleLineRule__Group_5__0 )? ) ;
    public final void rule__ScannerSingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3145:1: ( ( ( rule__ScannerSingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3146:1: ( ( rule__ScannerSingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3146:1: ( ( rule__ScannerSingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3147:1: ( rule__ScannerSingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3148:1: ( rule__ScannerSingleLineRule__Group_5__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==51) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3148:2: rule__ScannerSingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__0_in_rule__ScannerSingleLineRule__Group__5__Impl6409);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3170:1: rule__ScannerSingleLineRule__Group_5__0 : rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1 ;
    public final void rule__ScannerSingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3174:1: ( rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3175:2: rule__ScannerSingleLineRule__Group_5__0__Impl rule__ScannerSingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__0__Impl_in_rule__ScannerSingleLineRule__Group_5__06452);
            rule__ScannerSingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__1_in_rule__ScannerSingleLineRule__Group_5__06455);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3182:1: rule__ScannerSingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__ScannerSingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3186:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3187:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3187:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3188:1: 'escaped'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,51,FOLLOW_51_in_rule__ScannerSingleLineRule__Group_5__0__Impl6483); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3201:1: rule__ScannerSingleLineRule__Group_5__1 : rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2 ;
    public final void rule__ScannerSingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3205:1: ( rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3206:2: rule__ScannerSingleLineRule__Group_5__1__Impl rule__ScannerSingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__1__Impl_in_rule__ScannerSingleLineRule__Group_5__16514);
            rule__ScannerSingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__2_in_rule__ScannerSingleLineRule__Group_5__16517);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3213:1: rule__ScannerSingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__ScannerSingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3217:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3218:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3218:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3219:1: 'by'
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,52,FOLLOW_52_in_rule__ScannerSingleLineRule__Group_5__1__Impl6545); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3232:1: rule__ScannerSingleLineRule__Group_5__2 : rule__ScannerSingleLineRule__Group_5__2__Impl ;
    public final void rule__ScannerSingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3236:1: ( rule__ScannerSingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3237:2: rule__ScannerSingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__Group_5__2__Impl_in_rule__ScannerSingleLineRule__Group_5__26576);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3243:1: rule__ScannerSingleLineRule__Group_5__2__Impl : ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__ScannerSingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3247:1: ( ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3248:1: ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3248:1: ( ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3249:1: ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3250:1: ( rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3250:2: rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerSingleLineRule__Group_5__2__Impl6603);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3266:1: rule__PartitionSingleLineRule__Group__0 : rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1 ;
    public final void rule__PartitionSingleLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3270:1: ( rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3271:2: rule__PartitionSingleLineRule__Group__0__Impl rule__PartitionSingleLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__0__Impl_in_rule__PartitionSingleLineRule__Group__06639);
            rule__PartitionSingleLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__1_in_rule__PartitionSingleLineRule__Group__06642);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3278:1: rule__PartitionSingleLineRule__Group__0__Impl : ( ( rule__PartitionSingleLineRule__Alternatives_0 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3282:1: ( ( ( rule__PartitionSingleLineRule__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3283:1: ( ( rule__PartitionSingleLineRule__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3283:1: ( ( rule__PartitionSingleLineRule__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3284:1: ( rule__PartitionSingleLineRule__Alternatives_0 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3285:1: ( rule__PartitionSingleLineRule__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3285:2: rule__PartitionSingleLineRule__Alternatives_0
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Alternatives_0_in_rule__PartitionSingleLineRule__Group__0__Impl6669);
            rule__PartitionSingleLineRule__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPartitionSingleLineRuleAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3295:1: rule__PartitionSingleLineRule__Group__1 : rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2 ;
    public final void rule__PartitionSingleLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3299:1: ( rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3300:2: rule__PartitionSingleLineRule__Group__1__Impl rule__PartitionSingleLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__1__Impl_in_rule__PartitionSingleLineRule__Group__16699);
            rule__PartitionSingleLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__2_in_rule__PartitionSingleLineRule__Group__16702);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3307:1: rule__PartitionSingleLineRule__Group__1__Impl : ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3311:1: ( ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3312:1: ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3312:1: ( ( rule__PartitionSingleLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3313:1: ( rule__PartitionSingleLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3314:1: ( rule__PartitionSingleLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3314:2: rule__PartitionSingleLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__ParitionAssignment_1_in_rule__PartitionSingleLineRule__Group__1__Impl6729);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3324:1: rule__PartitionSingleLineRule__Group__2 : rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3 ;
    public final void rule__PartitionSingleLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3328:1: ( rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3329:2: rule__PartitionSingleLineRule__Group__2__Impl rule__PartitionSingleLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__2__Impl_in_rule__PartitionSingleLineRule__Group__26759);
            rule__PartitionSingleLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__3_in_rule__PartitionSingleLineRule__Group__26762);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3336:1: rule__PartitionSingleLineRule__Group__2__Impl : ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3340:1: ( ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3341:1: ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3341:1: ( ( rule__PartitionSingleLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3342:1: ( rule__PartitionSingleLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3343:1: ( rule__PartitionSingleLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3343:2: rule__PartitionSingleLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__StartSeqAssignment_2_in_rule__PartitionSingleLineRule__Group__2__Impl6789);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3353:1: rule__PartitionSingleLineRule__Group__3 : rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4 ;
    public final void rule__PartitionSingleLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3357:1: ( rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3358:2: rule__PartitionSingleLineRule__Group__3__Impl rule__PartitionSingleLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__3__Impl_in_rule__PartitionSingleLineRule__Group__36819);
            rule__PartitionSingleLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__4_in_rule__PartitionSingleLineRule__Group__36822);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3365:1: rule__PartitionSingleLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__PartitionSingleLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3369:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3370:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3370:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3371:1: '=>'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,50,FOLLOW_50_in_rule__PartitionSingleLineRule__Group__3__Impl6850); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3384:1: rule__PartitionSingleLineRule__Group__4 : rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5 ;
    public final void rule__PartitionSingleLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3388:1: ( rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3389:2: rule__PartitionSingleLineRule__Group__4__Impl rule__PartitionSingleLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__4__Impl_in_rule__PartitionSingleLineRule__Group__46881);
            rule__PartitionSingleLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__5_in_rule__PartitionSingleLineRule__Group__46884);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3396:1: rule__PartitionSingleLineRule__Group__4__Impl : ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__PartitionSingleLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3400:1: ( ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3401:1: ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3401:1: ( ( rule__PartitionSingleLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3402:1: ( rule__PartitionSingleLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3403:1: ( rule__PartitionSingleLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3403:2: rule__PartitionSingleLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__EndSeqAssignment_4_in_rule__PartitionSingleLineRule__Group__4__Impl6911);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3413:1: rule__PartitionSingleLineRule__Group__5 : rule__PartitionSingleLineRule__Group__5__Impl ;
    public final void rule__PartitionSingleLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3417:1: ( rule__PartitionSingleLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3418:2: rule__PartitionSingleLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group__5__Impl_in_rule__PartitionSingleLineRule__Group__56941);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3424:1: rule__PartitionSingleLineRule__Group__5__Impl : ( ( rule__PartitionSingleLineRule__Group_5__0 )? ) ;
    public final void rule__PartitionSingleLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3428:1: ( ( ( rule__PartitionSingleLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3429:1: ( ( rule__PartitionSingleLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3429:1: ( ( rule__PartitionSingleLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3430:1: ( rule__PartitionSingleLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3431:1: ( rule__PartitionSingleLineRule__Group_5__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==51) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3431:2: rule__PartitionSingleLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__0_in_rule__PartitionSingleLineRule__Group__5__Impl6968);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3453:1: rule__PartitionSingleLineRule__Group_5__0 : rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1 ;
    public final void rule__PartitionSingleLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3457:1: ( rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3458:2: rule__PartitionSingleLineRule__Group_5__0__Impl rule__PartitionSingleLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__0__Impl_in_rule__PartitionSingleLineRule__Group_5__07011);
            rule__PartitionSingleLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__1_in_rule__PartitionSingleLineRule__Group_5__07014);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3465:1: rule__PartitionSingleLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__PartitionSingleLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3469:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3470:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3470:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3471:1: 'escaped'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,51,FOLLOW_51_in_rule__PartitionSingleLineRule__Group_5__0__Impl7042); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3484:1: rule__PartitionSingleLineRule__Group_5__1 : rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2 ;
    public final void rule__PartitionSingleLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3488:1: ( rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3489:2: rule__PartitionSingleLineRule__Group_5__1__Impl rule__PartitionSingleLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__1__Impl_in_rule__PartitionSingleLineRule__Group_5__17073);
            rule__PartitionSingleLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__2_in_rule__PartitionSingleLineRule__Group_5__17076);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3496:1: rule__PartitionSingleLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__PartitionSingleLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3500:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3501:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3501:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3502:1: 'by'
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1()); 
            match(input,52,FOLLOW_52_in_rule__PartitionSingleLineRule__Group_5__1__Impl7104); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3515:1: rule__PartitionSingleLineRule__Group_5__2 : rule__PartitionSingleLineRule__Group_5__2__Impl ;
    public final void rule__PartitionSingleLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3519:1: ( rule__PartitionSingleLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3520:2: rule__PartitionSingleLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__Group_5__2__Impl_in_rule__PartitionSingleLineRule__Group_5__27135);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3526:1: rule__PartitionSingleLineRule__Group_5__2__Impl : ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__PartitionSingleLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3530:1: ( ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3531:1: ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3531:1: ( ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3532:1: ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3533:1: ( rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3533:2: rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionSingleLineRule__Group_5__2__Impl7162);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3549:1: rule__ScannerMultiLineRule__Group__0 : rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1 ;
    public final void rule__ScannerMultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3553:1: ( rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3554:2: rule__ScannerMultiLineRule__Group__0__Impl rule__ScannerMultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__0__Impl_in_rule__ScannerMultiLineRule__Group__07198);
            rule__ScannerMultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__1_in_rule__ScannerMultiLineRule__Group__07201);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3561:1: rule__ScannerMultiLineRule__Group__0__Impl : ( ( rule__ScannerMultiLineRule__Alternatives_0 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3565:1: ( ( ( rule__ScannerMultiLineRule__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3566:1: ( ( rule__ScannerMultiLineRule__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3566:1: ( ( rule__ScannerMultiLineRule__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3567:1: ( rule__ScannerMultiLineRule__Alternatives_0 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3568:1: ( rule__ScannerMultiLineRule__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3568:2: rule__ScannerMultiLineRule__Alternatives_0
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Alternatives_0_in_rule__ScannerMultiLineRule__Group__0__Impl7228);
            rule__ScannerMultiLineRule__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getScannerMultiLineRuleAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3578:1: rule__ScannerMultiLineRule__Group__1 : rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2 ;
    public final void rule__ScannerMultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3582:1: ( rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3583:2: rule__ScannerMultiLineRule__Group__1__Impl rule__ScannerMultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__1__Impl_in_rule__ScannerMultiLineRule__Group__17258);
            rule__ScannerMultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__2_in_rule__ScannerMultiLineRule__Group__17261);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3590:1: rule__ScannerMultiLineRule__Group__1__Impl : ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3594:1: ( ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3595:1: ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3595:1: ( ( rule__ScannerMultiLineRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3596:1: ( rule__ScannerMultiLineRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3597:1: ( rule__ScannerMultiLineRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3597:2: rule__ScannerMultiLineRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__TokenAssignment_1_in_rule__ScannerMultiLineRule__Group__1__Impl7288);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3607:1: rule__ScannerMultiLineRule__Group__2 : rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3 ;
    public final void rule__ScannerMultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3611:1: ( rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3612:2: rule__ScannerMultiLineRule__Group__2__Impl rule__ScannerMultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__2__Impl_in_rule__ScannerMultiLineRule__Group__27318);
            rule__ScannerMultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__3_in_rule__ScannerMultiLineRule__Group__27321);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3619:1: rule__ScannerMultiLineRule__Group__2__Impl : ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3623:1: ( ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3624:1: ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3624:1: ( ( rule__ScannerMultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3625:1: ( rule__ScannerMultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3626:1: ( rule__ScannerMultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3626:2: rule__ScannerMultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__StartSeqAssignment_2_in_rule__ScannerMultiLineRule__Group__2__Impl7348);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3636:1: rule__ScannerMultiLineRule__Group__3 : rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4 ;
    public final void rule__ScannerMultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3640:1: ( rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3641:2: rule__ScannerMultiLineRule__Group__3__Impl rule__ScannerMultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__3__Impl_in_rule__ScannerMultiLineRule__Group__37378);
            rule__ScannerMultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__4_in_rule__ScannerMultiLineRule__Group__37381);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3648:1: rule__ScannerMultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__ScannerMultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3652:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3653:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3653:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3654:1: '=>'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,50,FOLLOW_50_in_rule__ScannerMultiLineRule__Group__3__Impl7409); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3667:1: rule__ScannerMultiLineRule__Group__4 : rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5 ;
    public final void rule__ScannerMultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3671:1: ( rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3672:2: rule__ScannerMultiLineRule__Group__4__Impl rule__ScannerMultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__4__Impl_in_rule__ScannerMultiLineRule__Group__47440);
            rule__ScannerMultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__5_in_rule__ScannerMultiLineRule__Group__47443);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3679:1: rule__ScannerMultiLineRule__Group__4__Impl : ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__ScannerMultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3683:1: ( ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3684:1: ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3684:1: ( ( rule__ScannerMultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3685:1: ( rule__ScannerMultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3686:1: ( rule__ScannerMultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3686:2: rule__ScannerMultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__EndSeqAssignment_4_in_rule__ScannerMultiLineRule__Group__4__Impl7470);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3696:1: rule__ScannerMultiLineRule__Group__5 : rule__ScannerMultiLineRule__Group__5__Impl ;
    public final void rule__ScannerMultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3700:1: ( rule__ScannerMultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3701:2: rule__ScannerMultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group__5__Impl_in_rule__ScannerMultiLineRule__Group__57500);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3707:1: rule__ScannerMultiLineRule__Group__5__Impl : ( ( rule__ScannerMultiLineRule__Group_5__0 )? ) ;
    public final void rule__ScannerMultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3711:1: ( ( ( rule__ScannerMultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3712:1: ( ( rule__ScannerMultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3712:1: ( ( rule__ScannerMultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3713:1: ( rule__ScannerMultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3714:1: ( rule__ScannerMultiLineRule__Group_5__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==51) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3714:2: rule__ScannerMultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__0_in_rule__ScannerMultiLineRule__Group__5__Impl7527);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3736:1: rule__ScannerMultiLineRule__Group_5__0 : rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1 ;
    public final void rule__ScannerMultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3740:1: ( rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3741:2: rule__ScannerMultiLineRule__Group_5__0__Impl rule__ScannerMultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__0__Impl_in_rule__ScannerMultiLineRule__Group_5__07570);
            rule__ScannerMultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__1_in_rule__ScannerMultiLineRule__Group_5__07573);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3748:1: rule__ScannerMultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__ScannerMultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3752:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3753:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3753:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3754:1: 'escaped'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,51,FOLLOW_51_in_rule__ScannerMultiLineRule__Group_5__0__Impl7601); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3767:1: rule__ScannerMultiLineRule__Group_5__1 : rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2 ;
    public final void rule__ScannerMultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3771:1: ( rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3772:2: rule__ScannerMultiLineRule__Group_5__1__Impl rule__ScannerMultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__1__Impl_in_rule__ScannerMultiLineRule__Group_5__17632);
            rule__ScannerMultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__2_in_rule__ScannerMultiLineRule__Group_5__17635);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3779:1: rule__ScannerMultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__ScannerMultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3783:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3784:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3784:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3785:1: 'by'
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,52,FOLLOW_52_in_rule__ScannerMultiLineRule__Group_5__1__Impl7663); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3798:1: rule__ScannerMultiLineRule__Group_5__2 : rule__ScannerMultiLineRule__Group_5__2__Impl ;
    public final void rule__ScannerMultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3802:1: ( rule__ScannerMultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3803:2: rule__ScannerMultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__Group_5__2__Impl_in_rule__ScannerMultiLineRule__Group_5__27694);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3809:1: rule__ScannerMultiLineRule__Group_5__2__Impl : ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__ScannerMultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3813:1: ( ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3814:1: ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3814:1: ( ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3815:1: ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3816:1: ( rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3816:2: rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerMultiLineRule__Group_5__2__Impl7721);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3832:1: rule__PartitionMultiLineRule__Group__0 : rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1 ;
    public final void rule__PartitionMultiLineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3836:1: ( rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3837:2: rule__PartitionMultiLineRule__Group__0__Impl rule__PartitionMultiLineRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__0__Impl_in_rule__PartitionMultiLineRule__Group__07757);
            rule__PartitionMultiLineRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__1_in_rule__PartitionMultiLineRule__Group__07760);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3844:1: rule__PartitionMultiLineRule__Group__0__Impl : ( ( rule__PartitionMultiLineRule__Alternatives_0 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3848:1: ( ( ( rule__PartitionMultiLineRule__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3849:1: ( ( rule__PartitionMultiLineRule__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3849:1: ( ( rule__PartitionMultiLineRule__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3850:1: ( rule__PartitionMultiLineRule__Alternatives_0 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3851:1: ( rule__PartitionMultiLineRule__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3851:2: rule__PartitionMultiLineRule__Alternatives_0
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Alternatives_0_in_rule__PartitionMultiLineRule__Group__0__Impl7787);
            rule__PartitionMultiLineRule__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPartitionMultiLineRuleAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3861:1: rule__PartitionMultiLineRule__Group__1 : rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2 ;
    public final void rule__PartitionMultiLineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3865:1: ( rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3866:2: rule__PartitionMultiLineRule__Group__1__Impl rule__PartitionMultiLineRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__1__Impl_in_rule__PartitionMultiLineRule__Group__17817);
            rule__PartitionMultiLineRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__2_in_rule__PartitionMultiLineRule__Group__17820);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3873:1: rule__PartitionMultiLineRule__Group__1__Impl : ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3877:1: ( ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3878:1: ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3878:1: ( ( rule__PartitionMultiLineRule__ParitionAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3879:1: ( rule__PartitionMultiLineRule__ParitionAssignment_1 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3880:1: ( rule__PartitionMultiLineRule__ParitionAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3880:2: rule__PartitionMultiLineRule__ParitionAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__ParitionAssignment_1_in_rule__PartitionMultiLineRule__Group__1__Impl7847);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3890:1: rule__PartitionMultiLineRule__Group__2 : rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3 ;
    public final void rule__PartitionMultiLineRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3894:1: ( rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3895:2: rule__PartitionMultiLineRule__Group__2__Impl rule__PartitionMultiLineRule__Group__3
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__2__Impl_in_rule__PartitionMultiLineRule__Group__27877);
            rule__PartitionMultiLineRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__3_in_rule__PartitionMultiLineRule__Group__27880);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3902:1: rule__PartitionMultiLineRule__Group__2__Impl : ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3906:1: ( ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3907:1: ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3907:1: ( ( rule__PartitionMultiLineRule__StartSeqAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3908:1: ( rule__PartitionMultiLineRule__StartSeqAssignment_2 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3909:1: ( rule__PartitionMultiLineRule__StartSeqAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3909:2: rule__PartitionMultiLineRule__StartSeqAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__StartSeqAssignment_2_in_rule__PartitionMultiLineRule__Group__2__Impl7907);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3919:1: rule__PartitionMultiLineRule__Group__3 : rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4 ;
    public final void rule__PartitionMultiLineRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3923:1: ( rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3924:2: rule__PartitionMultiLineRule__Group__3__Impl rule__PartitionMultiLineRule__Group__4
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__3__Impl_in_rule__PartitionMultiLineRule__Group__37937);
            rule__PartitionMultiLineRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__4_in_rule__PartitionMultiLineRule__Group__37940);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3931:1: rule__PartitionMultiLineRule__Group__3__Impl : ( '=>' ) ;
    public final void rule__PartitionMultiLineRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3935:1: ( ( '=>' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3936:1: ( '=>' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3936:1: ( '=>' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3937:1: '=>'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,50,FOLLOW_50_in_rule__PartitionMultiLineRule__Group__3__Impl7968); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3950:1: rule__PartitionMultiLineRule__Group__4 : rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5 ;
    public final void rule__PartitionMultiLineRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3954:1: ( rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3955:2: rule__PartitionMultiLineRule__Group__4__Impl rule__PartitionMultiLineRule__Group__5
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__4__Impl_in_rule__PartitionMultiLineRule__Group__47999);
            rule__PartitionMultiLineRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__5_in_rule__PartitionMultiLineRule__Group__48002);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3962:1: rule__PartitionMultiLineRule__Group__4__Impl : ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) ) ;
    public final void rule__PartitionMultiLineRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3966:1: ( ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3967:1: ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3967:1: ( ( rule__PartitionMultiLineRule__EndSeqAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3968:1: ( rule__PartitionMultiLineRule__EndSeqAssignment_4 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3969:1: ( rule__PartitionMultiLineRule__EndSeqAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3969:2: rule__PartitionMultiLineRule__EndSeqAssignment_4
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__EndSeqAssignment_4_in_rule__PartitionMultiLineRule__Group__4__Impl8029);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3979:1: rule__PartitionMultiLineRule__Group__5 : rule__PartitionMultiLineRule__Group__5__Impl ;
    public final void rule__PartitionMultiLineRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3983:1: ( rule__PartitionMultiLineRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3984:2: rule__PartitionMultiLineRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group__5__Impl_in_rule__PartitionMultiLineRule__Group__58059);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3990:1: rule__PartitionMultiLineRule__Group__5__Impl : ( ( rule__PartitionMultiLineRule__Group_5__0 )? ) ;
    public final void rule__PartitionMultiLineRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3994:1: ( ( ( rule__PartitionMultiLineRule__Group_5__0 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3995:1: ( ( rule__PartitionMultiLineRule__Group_5__0 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3995:1: ( ( rule__PartitionMultiLineRule__Group_5__0 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3996:1: ( rule__PartitionMultiLineRule__Group_5__0 )?
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getGroup_5()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3997:1: ( rule__PartitionMultiLineRule__Group_5__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==51) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:3997:2: rule__PartitionMultiLineRule__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__0_in_rule__PartitionMultiLineRule__Group__5__Impl8086);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4019:1: rule__PartitionMultiLineRule__Group_5__0 : rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1 ;
    public final void rule__PartitionMultiLineRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4023:1: ( rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4024:2: rule__PartitionMultiLineRule__Group_5__0__Impl rule__PartitionMultiLineRule__Group_5__1
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__0__Impl_in_rule__PartitionMultiLineRule__Group_5__08129);
            rule__PartitionMultiLineRule__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__1_in_rule__PartitionMultiLineRule__Group_5__08132);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4031:1: rule__PartitionMultiLineRule__Group_5__0__Impl : ( 'escaped' ) ;
    public final void rule__PartitionMultiLineRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4035:1: ( ( 'escaped' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4036:1: ( 'escaped' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4036:1: ( 'escaped' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4037:1: 'escaped'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0()); 
            match(input,51,FOLLOW_51_in_rule__PartitionMultiLineRule__Group_5__0__Impl8160); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4050:1: rule__PartitionMultiLineRule__Group_5__1 : rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2 ;
    public final void rule__PartitionMultiLineRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4054:1: ( rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4055:2: rule__PartitionMultiLineRule__Group_5__1__Impl rule__PartitionMultiLineRule__Group_5__2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__1__Impl_in_rule__PartitionMultiLineRule__Group_5__18191);
            rule__PartitionMultiLineRule__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__2_in_rule__PartitionMultiLineRule__Group_5__18194);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4062:1: rule__PartitionMultiLineRule__Group_5__1__Impl : ( 'by' ) ;
    public final void rule__PartitionMultiLineRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4066:1: ( ( 'by' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4067:1: ( 'by' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4067:1: ( 'by' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4068:1: 'by'
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1()); 
            match(input,52,FOLLOW_52_in_rule__PartitionMultiLineRule__Group_5__1__Impl8222); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4081:1: rule__PartitionMultiLineRule__Group_5__2 : rule__PartitionMultiLineRule__Group_5__2__Impl ;
    public final void rule__PartitionMultiLineRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4085:1: ( rule__PartitionMultiLineRule__Group_5__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4086:2: rule__PartitionMultiLineRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__Group_5__2__Impl_in_rule__PartitionMultiLineRule__Group_5__28253);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4092:1: rule__PartitionMultiLineRule__Group_5__2__Impl : ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) ) ;
    public final void rule__PartitionMultiLineRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4096:1: ( ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4097:1: ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4097:1: ( ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4098:1: ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqAssignment_5_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4099:1: ( rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4099:2: rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2
            {
            pushFollow(FOLLOW_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionMultiLineRule__Group_5__2__Impl8280);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4115:1: rule__ScannerCharacterRule__Group__0 : rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1 ;
    public final void rule__ScannerCharacterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4119:1: ( rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4120:2: rule__ScannerCharacterRule__Group__0__Impl rule__ScannerCharacterRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__0__Impl_in_rule__ScannerCharacterRule__Group__08316);
            rule__ScannerCharacterRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__1_in_rule__ScannerCharacterRule__Group__08319);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4127:1: rule__ScannerCharacterRule__Group__0__Impl : ( ( rule__ScannerCharacterRule__Alternatives_0 ) ) ;
    public final void rule__ScannerCharacterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4131:1: ( ( ( rule__ScannerCharacterRule__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4132:1: ( ( rule__ScannerCharacterRule__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4132:1: ( ( rule__ScannerCharacterRule__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4133:1: ( rule__ScannerCharacterRule__Alternatives_0 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4134:1: ( rule__ScannerCharacterRule__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4134:2: rule__ScannerCharacterRule__Alternatives_0
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Alternatives_0_in_rule__ScannerCharacterRule__Group__0__Impl8346);
            rule__ScannerCharacterRule__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getScannerCharacterRuleAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4144:1: rule__ScannerCharacterRule__Group__1 : rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2 ;
    public final void rule__ScannerCharacterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4148:1: ( rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4149:2: rule__ScannerCharacterRule__Group__1__Impl rule__ScannerCharacterRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__1__Impl_in_rule__ScannerCharacterRule__Group__18376);
            rule__ScannerCharacterRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__2_in_rule__ScannerCharacterRule__Group__18379);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4156:1: rule__ScannerCharacterRule__Group__1__Impl : ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerCharacterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4160:1: ( ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4161:1: ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4161:1: ( ( rule__ScannerCharacterRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4162:1: ( rule__ScannerCharacterRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4163:1: ( rule__ScannerCharacterRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4163:2: rule__ScannerCharacterRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__TokenAssignment_1_in_rule__ScannerCharacterRule__Group__1__Impl8406);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4173:1: rule__ScannerCharacterRule__Group__2 : rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3 ;
    public final void rule__ScannerCharacterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4177:1: ( rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4178:2: rule__ScannerCharacterRule__Group__2__Impl rule__ScannerCharacterRule__Group__3
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__2__Impl_in_rule__ScannerCharacterRule__Group__28436);
            rule__ScannerCharacterRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__3_in_rule__ScannerCharacterRule__Group__28439);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4185:1: rule__ScannerCharacterRule__Group__2__Impl : ( '[' ) ;
    public final void rule__ScannerCharacterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4189:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4190:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4190:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4191:1: '['
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2()); 
            match(input,46,FOLLOW_46_in_rule__ScannerCharacterRule__Group__2__Impl8467); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4204:1: rule__ScannerCharacterRule__Group__3 : rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4 ;
    public final void rule__ScannerCharacterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4208:1: ( rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4209:2: rule__ScannerCharacterRule__Group__3__Impl rule__ScannerCharacterRule__Group__4
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__3__Impl_in_rule__ScannerCharacterRule__Group__38498);
            rule__ScannerCharacterRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__4_in_rule__ScannerCharacterRule__Group__38501);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4216:1: rule__ScannerCharacterRule__Group__3__Impl : ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) ) ;
    public final void rule__ScannerCharacterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4220:1: ( ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4221:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4221:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_3 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4222:1: ( rule__ScannerCharacterRule__CharactersAssignment_3 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_3()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4223:1: ( rule__ScannerCharacterRule__CharactersAssignment_3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4223:2: rule__ScannerCharacterRule__CharactersAssignment_3
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_3_in_rule__ScannerCharacterRule__Group__3__Impl8528);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4233:1: rule__ScannerCharacterRule__Group__4 : rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5 ;
    public final void rule__ScannerCharacterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4237:1: ( rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4238:2: rule__ScannerCharacterRule__Group__4__Impl rule__ScannerCharacterRule__Group__5
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__4__Impl_in_rule__ScannerCharacterRule__Group__48558);
            rule__ScannerCharacterRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__5_in_rule__ScannerCharacterRule__Group__48561);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4245:1: rule__ScannerCharacterRule__Group__4__Impl : ( ( rule__ScannerCharacterRule__Group_4__0 )* ) ;
    public final void rule__ScannerCharacterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4249:1: ( ( ( rule__ScannerCharacterRule__Group_4__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4250:1: ( ( rule__ScannerCharacterRule__Group_4__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4250:1: ( ( rule__ScannerCharacterRule__Group_4__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4251:1: ( rule__ScannerCharacterRule__Group_4__0 )*
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getGroup_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4252:1: ( rule__ScannerCharacterRule__Group_4__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==48) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4252:2: rule__ScannerCharacterRule__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__0_in_rule__ScannerCharacterRule__Group__4__Impl8588);
            	    rule__ScannerCharacterRule__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4262:1: rule__ScannerCharacterRule__Group__5 : rule__ScannerCharacterRule__Group__5__Impl ;
    public final void rule__ScannerCharacterRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4266:1: ( rule__ScannerCharacterRule__Group__5__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4267:2: rule__ScannerCharacterRule__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group__5__Impl_in_rule__ScannerCharacterRule__Group__58619);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4273:1: rule__ScannerCharacterRule__Group__5__Impl : ( ']' ) ;
    public final void rule__ScannerCharacterRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4277:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4278:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4278:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4279:1: ']'
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getRightSquareBracketKeyword_5()); 
            match(input,47,FOLLOW_47_in_rule__ScannerCharacterRule__Group__5__Impl8647); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4304:1: rule__ScannerCharacterRule__Group_4__0 : rule__ScannerCharacterRule__Group_4__0__Impl rule__ScannerCharacterRule__Group_4__1 ;
    public final void rule__ScannerCharacterRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4308:1: ( rule__ScannerCharacterRule__Group_4__0__Impl rule__ScannerCharacterRule__Group_4__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4309:2: rule__ScannerCharacterRule__Group_4__0__Impl rule__ScannerCharacterRule__Group_4__1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__0__Impl_in_rule__ScannerCharacterRule__Group_4__08690);
            rule__ScannerCharacterRule__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__1_in_rule__ScannerCharacterRule__Group_4__08693);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4316:1: rule__ScannerCharacterRule__Group_4__0__Impl : ( ',' ) ;
    public final void rule__ScannerCharacterRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4320:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4321:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4321:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4322:1: ','
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4_0()); 
            match(input,48,FOLLOW_48_in_rule__ScannerCharacterRule__Group_4__0__Impl8721); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4335:1: rule__ScannerCharacterRule__Group_4__1 : rule__ScannerCharacterRule__Group_4__1__Impl ;
    public final void rule__ScannerCharacterRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4339:1: ( rule__ScannerCharacterRule__Group_4__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4340:2: rule__ScannerCharacterRule__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__Group_4__1__Impl_in_rule__ScannerCharacterRule__Group_4__18752);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4346:1: rule__ScannerCharacterRule__Group_4__1__Impl : ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) ) ;
    public final void rule__ScannerCharacterRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4350:1: ( ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4351:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4351:1: ( ( rule__ScannerCharacterRule__CharactersAssignment_4_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4352:1: ( rule__ScannerCharacterRule__CharactersAssignment_4_1 )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersAssignment_4_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4353:1: ( rule__ScannerCharacterRule__CharactersAssignment_4_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4353:2: rule__ScannerCharacterRule__CharactersAssignment_4_1
            {
            pushFollow(FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_4_1_in_rule__ScannerCharacterRule__Group_4__1__Impl8779);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4367:1: rule__ScannerJSRule__Group__0 : rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1 ;
    public final void rule__ScannerJSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4371:1: ( rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4372:2: rule__ScannerJSRule__Group__0__Impl rule__ScannerJSRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__0__Impl_in_rule__ScannerJSRule__Group__08813);
            rule__ScannerJSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerJSRule__Group__1_in_rule__ScannerJSRule__Group__08816);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4379:1: rule__ScannerJSRule__Group__0__Impl : ( ( rule__ScannerJSRule__Alternatives_0 ) ) ;
    public final void rule__ScannerJSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4383:1: ( ( ( rule__ScannerJSRule__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4384:1: ( ( rule__ScannerJSRule__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4384:1: ( ( rule__ScannerJSRule__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4385:1: ( rule__ScannerJSRule__Alternatives_0 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4386:1: ( rule__ScannerJSRule__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4386:2: rule__ScannerJSRule__Alternatives_0
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Alternatives_0_in_rule__ScannerJSRule__Group__0__Impl8843);
            rule__ScannerJSRule__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getScannerJSRuleAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4396:1: rule__ScannerJSRule__Group__1 : rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2 ;
    public final void rule__ScannerJSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4400:1: ( rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4401:2: rule__ScannerJSRule__Group__1__Impl rule__ScannerJSRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__1__Impl_in_rule__ScannerJSRule__Group__18873);
            rule__ScannerJSRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerJSRule__Group__2_in_rule__ScannerJSRule__Group__18876);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4408:1: rule__ScannerJSRule__Group__1__Impl : ( ( rule__ScannerJSRule__TokenAssignment_1 ) ) ;
    public final void rule__ScannerJSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4412:1: ( ( ( rule__ScannerJSRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4413:1: ( ( rule__ScannerJSRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4413:1: ( ( rule__ScannerJSRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4414:1: ( rule__ScannerJSRule__TokenAssignment_1 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4415:1: ( rule__ScannerJSRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4415:2: rule__ScannerJSRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__TokenAssignment_1_in_rule__ScannerJSRule__Group__1__Impl8903);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4425:1: rule__ScannerJSRule__Group__2 : rule__ScannerJSRule__Group__2__Impl ;
    public final void rule__ScannerJSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4429:1: ( rule__ScannerJSRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4430:2: rule__ScannerJSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__Group__2__Impl_in_rule__ScannerJSRule__Group__28933);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4436:1: rule__ScannerJSRule__Group__2__Impl : ( ( rule__ScannerJSRule__FileURIAssignment_2 ) ) ;
    public final void rule__ScannerJSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4440:1: ( ( ( rule__ScannerJSRule__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4441:1: ( ( rule__ScannerJSRule__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4441:1: ( ( rule__ScannerJSRule__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4442:1: ( rule__ScannerJSRule__FileURIAssignment_2 )
            {
             before(grammarAccess.getScannerJSRuleAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4443:1: ( rule__ScannerJSRule__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4443:2: rule__ScannerJSRule__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__ScannerJSRule__FileURIAssignment_2_in_rule__ScannerJSRule__Group__2__Impl8960);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4459:1: rule__PartitionJSRule__Group__0 : rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1 ;
    public final void rule__PartitionJSRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4463:1: ( rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4464:2: rule__PartitionJSRule__Group__0__Impl rule__PartitionJSRule__Group__1
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__0__Impl_in_rule__PartitionJSRule__Group__08996);
            rule__PartitionJSRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionJSRule__Group__1_in_rule__PartitionJSRule__Group__08999);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4471:1: rule__PartitionJSRule__Group__0__Impl : ( ( rule__PartitionJSRule__Alternatives_0 ) ) ;
    public final void rule__PartitionJSRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4475:1: ( ( ( rule__PartitionJSRule__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4476:1: ( ( rule__PartitionJSRule__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4476:1: ( ( rule__PartitionJSRule__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4477:1: ( rule__PartitionJSRule__Alternatives_0 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4478:1: ( rule__PartitionJSRule__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4478:2: rule__PartitionJSRule__Alternatives_0
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Alternatives_0_in_rule__PartitionJSRule__Group__0__Impl9026);
            rule__PartitionJSRule__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPartitionJSRuleAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4488:1: rule__PartitionJSRule__Group__1 : rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2 ;
    public final void rule__PartitionJSRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4492:1: ( rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4493:2: rule__PartitionJSRule__Group__1__Impl rule__PartitionJSRule__Group__2
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__1__Impl_in_rule__PartitionJSRule__Group__19056);
            rule__PartitionJSRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PartitionJSRule__Group__2_in_rule__PartitionJSRule__Group__19059);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4500:1: rule__PartitionJSRule__Group__1__Impl : ( ( rule__PartitionJSRule__TokenAssignment_1 ) ) ;
    public final void rule__PartitionJSRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4504:1: ( ( ( rule__PartitionJSRule__TokenAssignment_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4505:1: ( ( rule__PartitionJSRule__TokenAssignment_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4505:1: ( ( rule__PartitionJSRule__TokenAssignment_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4506:1: ( rule__PartitionJSRule__TokenAssignment_1 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4507:1: ( rule__PartitionJSRule__TokenAssignment_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4507:2: rule__PartitionJSRule__TokenAssignment_1
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__TokenAssignment_1_in_rule__PartitionJSRule__Group__1__Impl9086);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4517:1: rule__PartitionJSRule__Group__2 : rule__PartitionJSRule__Group__2__Impl ;
    public final void rule__PartitionJSRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4521:1: ( rule__PartitionJSRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4522:2: rule__PartitionJSRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__Group__2__Impl_in_rule__PartitionJSRule__Group__29116);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4528:1: rule__PartitionJSRule__Group__2__Impl : ( ( rule__PartitionJSRule__FileURIAssignment_2 ) ) ;
    public final void rule__PartitionJSRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4532:1: ( ( ( rule__PartitionJSRule__FileURIAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4533:1: ( ( rule__PartitionJSRule__FileURIAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4533:1: ( ( rule__PartitionJSRule__FileURIAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4534:1: ( rule__PartitionJSRule__FileURIAssignment_2 )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getFileURIAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4535:1: ( rule__PartitionJSRule__FileURIAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4535:2: rule__PartitionJSRule__FileURIAssignment_2
            {
            pushFollow(FOLLOW_rule__PartitionJSRule__FileURIAssignment_2_in_rule__PartitionJSRule__Group__2__Impl9143);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4551:1: rule__ScannerWhitespaceRule__Group__0 : rule__ScannerWhitespaceRule__Group__0__Impl rule__ScannerWhitespaceRule__Group__1 ;
    public final void rule__ScannerWhitespaceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4555:1: ( rule__ScannerWhitespaceRule__Group__0__Impl rule__ScannerWhitespaceRule__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4556:2: rule__ScannerWhitespaceRule__Group__0__Impl rule__ScannerWhitespaceRule__Group__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__0__Impl_in_rule__ScannerWhitespaceRule__Group__09179);
            rule__ScannerWhitespaceRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__1_in_rule__ScannerWhitespaceRule__Group__09182);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4563:1: rule__ScannerWhitespaceRule__Group__0__Impl : ( ( rule__ScannerWhitespaceRule__Alternatives_0 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4567:1: ( ( ( rule__ScannerWhitespaceRule__Alternatives_0 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4568:1: ( ( rule__ScannerWhitespaceRule__Alternatives_0 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4568:1: ( ( rule__ScannerWhitespaceRule__Alternatives_0 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4569:1: ( rule__ScannerWhitespaceRule__Alternatives_0 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getAlternatives_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4570:1: ( rule__ScannerWhitespaceRule__Alternatives_0 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4570:2: rule__ScannerWhitespaceRule__Alternatives_0
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Alternatives_0_in_rule__ScannerWhitespaceRule__Group__0__Impl9209);
            rule__ScannerWhitespaceRule__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getScannerWhitespaceRuleAccess().getAlternatives_0()); 

            }


            }

        }
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4580:1: rule__ScannerWhitespaceRule__Group__1 : rule__ScannerWhitespaceRule__Group__1__Impl rule__ScannerWhitespaceRule__Group__2 ;
    public final void rule__ScannerWhitespaceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4584:1: ( rule__ScannerWhitespaceRule__Group__1__Impl rule__ScannerWhitespaceRule__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4585:2: rule__ScannerWhitespaceRule__Group__1__Impl rule__ScannerWhitespaceRule__Group__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__1__Impl_in_rule__ScannerWhitespaceRule__Group__19239);
            rule__ScannerWhitespaceRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__2_in_rule__ScannerWhitespaceRule__Group__19242);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4592:1: rule__ScannerWhitespaceRule__Group__1__Impl : ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? ) ;
    public final void rule__ScannerWhitespaceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4596:1: ( ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4597:1: ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4597:1: ( ( rule__ScannerWhitespaceRule__TokenAssignment_1 )? )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4598:1: ( rule__ScannerWhitespaceRule__TokenAssignment_1 )?
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenAssignment_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4599:1: ( rule__ScannerWhitespaceRule__TokenAssignment_1 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4599:2: rule__ScannerWhitespaceRule__TokenAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__TokenAssignment_1_in_rule__ScannerWhitespaceRule__Group__1__Impl9269);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4609:1: rule__ScannerWhitespaceRule__Group__2 : rule__ScannerWhitespaceRule__Group__2__Impl ;
    public final void rule__ScannerWhitespaceRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4613:1: ( rule__ScannerWhitespaceRule__Group__2__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4614:2: rule__ScannerWhitespaceRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group__2__Impl_in_rule__ScannerWhitespaceRule__Group__29300);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4620:1: rule__ScannerWhitespaceRule__Group__2__Impl : ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4624:1: ( ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4625:1: ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4625:1: ( ( rule__ScannerWhitespaceRule__Alternatives_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4626:1: ( rule__ScannerWhitespaceRule__Alternatives_2 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getAlternatives_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4627:1: ( rule__ScannerWhitespaceRule__Alternatives_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4627:2: rule__ScannerWhitespaceRule__Alternatives_2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Alternatives_2_in_rule__ScannerWhitespaceRule__Group__2__Impl9327);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4643:1: rule__ScannerWhitespaceRule__Group_2_0__0 : rule__ScannerWhitespaceRule__Group_2_0__0__Impl rule__ScannerWhitespaceRule__Group_2_0__1 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4647:1: ( rule__ScannerWhitespaceRule__Group_2_0__0__Impl rule__ScannerWhitespaceRule__Group_2_0__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4648:2: rule__ScannerWhitespaceRule__Group_2_0__0__Impl rule__ScannerWhitespaceRule__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__09363);
            rule__ScannerWhitespaceRule__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1_in_rule__ScannerWhitespaceRule__Group_2_0__09366);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4655:1: rule__ScannerWhitespaceRule__Group_2_0__0__Impl : ( '[' ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4659:1: ( ( '[' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4660:1: ( '[' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4660:1: ( '[' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4661:1: '['
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_2_0_0()); 
            match(input,46,FOLLOW_46_in_rule__ScannerWhitespaceRule__Group_2_0__0__Impl9394); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4674:1: rule__ScannerWhitespaceRule__Group_2_0__1 : rule__ScannerWhitespaceRule__Group_2_0__1__Impl rule__ScannerWhitespaceRule__Group_2_0__2 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4678:1: ( rule__ScannerWhitespaceRule__Group_2_0__1__Impl rule__ScannerWhitespaceRule__Group_2_0__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4679:2: rule__ScannerWhitespaceRule__Group_2_0__1__Impl rule__ScannerWhitespaceRule__Group_2_0__2
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__19425);
            rule__ScannerWhitespaceRule__Group_2_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2_in_rule__ScannerWhitespaceRule__Group_2_0__19428);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4686:1: rule__ScannerWhitespaceRule__Group_2_0__1__Impl : ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4690:1: ( ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4691:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4691:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4692:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_2_0_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4693:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4693:2: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1_in_rule__ScannerWhitespaceRule__Group_2_0__1__Impl9455);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4703:1: rule__ScannerWhitespaceRule__Group_2_0__2 : rule__ScannerWhitespaceRule__Group_2_0__2__Impl rule__ScannerWhitespaceRule__Group_2_0__3 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4707:1: ( rule__ScannerWhitespaceRule__Group_2_0__2__Impl rule__ScannerWhitespaceRule__Group_2_0__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4708:2: rule__ScannerWhitespaceRule__Group_2_0__2__Impl rule__ScannerWhitespaceRule__Group_2_0__3
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__29485);
            rule__ScannerWhitespaceRule__Group_2_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3_in_rule__ScannerWhitespaceRule__Group_2_0__29488);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4715:1: rule__ScannerWhitespaceRule__Group_2_0__2__Impl : ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4719:1: ( ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4720:1: ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4720:1: ( ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )* )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4721:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )*
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getGroup_2_0_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4722:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==48) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4722:2: rule__ScannerWhitespaceRule__Group_2_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0_in_rule__ScannerWhitespaceRule__Group_2_0__2__Impl9515);
            	    rule__ScannerWhitespaceRule__Group_2_0_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4732:1: rule__ScannerWhitespaceRule__Group_2_0__3 : rule__ScannerWhitespaceRule__Group_2_0__3__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4736:1: ( rule__ScannerWhitespaceRule__Group_2_0__3__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4737:2: rule__ScannerWhitespaceRule__Group_2_0__3__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__39546);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4743:1: rule__ScannerWhitespaceRule__Group_2_0__3__Impl : ( ']' ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4747:1: ( ( ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4748:1: ( ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4748:1: ( ']' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4749:1: ']'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_2_0_3()); 
            match(input,47,FOLLOW_47_in_rule__ScannerWhitespaceRule__Group_2_0__3__Impl9574); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4770:1: rule__ScannerWhitespaceRule__Group_2_0_2__0 : rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl rule__ScannerWhitespaceRule__Group_2_0_2__1 ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4774:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl rule__ScannerWhitespaceRule__Group_2_0_2__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4775:2: rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl rule__ScannerWhitespaceRule__Group_2_0_2__1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__09613);
            rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1_in_rule__ScannerWhitespaceRule__Group_2_0_2__09616);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4782:1: rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl : ( ',' ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4786:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4787:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4787:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4788:1: ','
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_2_0_2_0()); 
            match(input,48,FOLLOW_48_in_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl9644); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4801:1: rule__ScannerWhitespaceRule__Group_2_0_2__1 : rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4805:1: ( rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4806:2: rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__19675);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4812:1: rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl : ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) ) ;
    public final void rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4816:1: ( ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4817:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4817:1: ( ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4818:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersAssignment_2_0_2_1()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4819:1: ( rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4819:2: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1
            {
            pushFollow(FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1_in_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl9702);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4833:1: rule__RGBColor__Group__0 : rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1 ;
    public final void rule__RGBColor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4837:1: ( rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4838:2: rule__RGBColor__Group__0__Impl rule__RGBColor__Group__1
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__0__Impl_in_rule__RGBColor__Group__09736);
            rule__RGBColor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__1_in_rule__RGBColor__Group__09739);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4845:1: rule__RGBColor__Group__0__Impl : ( 'rgb' ) ;
    public final void rule__RGBColor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4849:1: ( ( 'rgb' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4850:1: ( 'rgb' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4850:1: ( 'rgb' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4851:1: 'rgb'
            {
             before(grammarAccess.getRGBColorAccess().getRgbKeyword_0()); 
            match(input,53,FOLLOW_53_in_rule__RGBColor__Group__0__Impl9767); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4864:1: rule__RGBColor__Group__1 : rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2 ;
    public final void rule__RGBColor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4868:1: ( rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4869:2: rule__RGBColor__Group__1__Impl rule__RGBColor__Group__2
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__1__Impl_in_rule__RGBColor__Group__19798);
            rule__RGBColor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__2_in_rule__RGBColor__Group__19801);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4876:1: rule__RGBColor__Group__1__Impl : ( '(' ) ;
    public final void rule__RGBColor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4880:1: ( ( '(' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4881:1: ( '(' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4881:1: ( '(' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4882:1: '('
            {
             before(grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1()); 
            match(input,54,FOLLOW_54_in_rule__RGBColor__Group__1__Impl9829); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4895:1: rule__RGBColor__Group__2 : rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3 ;
    public final void rule__RGBColor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4899:1: ( rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4900:2: rule__RGBColor__Group__2__Impl rule__RGBColor__Group__3
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__2__Impl_in_rule__RGBColor__Group__29860);
            rule__RGBColor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__3_in_rule__RGBColor__Group__29863);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4907:1: rule__RGBColor__Group__2__Impl : ( ( rule__RGBColor__RAssignment_2 ) ) ;
    public final void rule__RGBColor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4911:1: ( ( ( rule__RGBColor__RAssignment_2 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4912:1: ( ( rule__RGBColor__RAssignment_2 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4912:1: ( ( rule__RGBColor__RAssignment_2 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4913:1: ( rule__RGBColor__RAssignment_2 )
            {
             before(grammarAccess.getRGBColorAccess().getRAssignment_2()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4914:1: ( rule__RGBColor__RAssignment_2 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4914:2: rule__RGBColor__RAssignment_2
            {
            pushFollow(FOLLOW_rule__RGBColor__RAssignment_2_in_rule__RGBColor__Group__2__Impl9890);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4924:1: rule__RGBColor__Group__3 : rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4 ;
    public final void rule__RGBColor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4928:1: ( rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4929:2: rule__RGBColor__Group__3__Impl rule__RGBColor__Group__4
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__3__Impl_in_rule__RGBColor__Group__39920);
            rule__RGBColor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__4_in_rule__RGBColor__Group__39923);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4936:1: rule__RGBColor__Group__3__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4940:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4941:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4941:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4942:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_3()); 
            match(input,48,FOLLOW_48_in_rule__RGBColor__Group__3__Impl9951); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4955:1: rule__RGBColor__Group__4 : rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5 ;
    public final void rule__RGBColor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4959:1: ( rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4960:2: rule__RGBColor__Group__4__Impl rule__RGBColor__Group__5
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__4__Impl_in_rule__RGBColor__Group__49982);
            rule__RGBColor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__5_in_rule__RGBColor__Group__49985);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4967:1: rule__RGBColor__Group__4__Impl : ( ( rule__RGBColor__GAssignment_4 ) ) ;
    public final void rule__RGBColor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4971:1: ( ( ( rule__RGBColor__GAssignment_4 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4972:1: ( ( rule__RGBColor__GAssignment_4 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4972:1: ( ( rule__RGBColor__GAssignment_4 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4973:1: ( rule__RGBColor__GAssignment_4 )
            {
             before(grammarAccess.getRGBColorAccess().getGAssignment_4()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4974:1: ( rule__RGBColor__GAssignment_4 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4974:2: rule__RGBColor__GAssignment_4
            {
            pushFollow(FOLLOW_rule__RGBColor__GAssignment_4_in_rule__RGBColor__Group__4__Impl10012);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4984:1: rule__RGBColor__Group__5 : rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6 ;
    public final void rule__RGBColor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4988:1: ( rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4989:2: rule__RGBColor__Group__5__Impl rule__RGBColor__Group__6
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__5__Impl_in_rule__RGBColor__Group__510042);
            rule__RGBColor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__6_in_rule__RGBColor__Group__510045);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:4996:1: rule__RGBColor__Group__5__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5000:1: ( ( ',' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5001:1: ( ',' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5001:1: ( ',' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5002:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_5()); 
            match(input,48,FOLLOW_48_in_rule__RGBColor__Group__5__Impl10073); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5015:1: rule__RGBColor__Group__6 : rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7 ;
    public final void rule__RGBColor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5019:1: ( rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5020:2: rule__RGBColor__Group__6__Impl rule__RGBColor__Group__7
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__6__Impl_in_rule__RGBColor__Group__610104);
            rule__RGBColor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RGBColor__Group__7_in_rule__RGBColor__Group__610107);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5027:1: rule__RGBColor__Group__6__Impl : ( ( rule__RGBColor__BAssignment_6 ) ) ;
    public final void rule__RGBColor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5031:1: ( ( ( rule__RGBColor__BAssignment_6 ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5032:1: ( ( rule__RGBColor__BAssignment_6 ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5032:1: ( ( rule__RGBColor__BAssignment_6 ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5033:1: ( rule__RGBColor__BAssignment_6 )
            {
             before(grammarAccess.getRGBColorAccess().getBAssignment_6()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5034:1: ( rule__RGBColor__BAssignment_6 )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5034:2: rule__RGBColor__BAssignment_6
            {
            pushFollow(FOLLOW_rule__RGBColor__BAssignment_6_in_rule__RGBColor__Group__6__Impl10134);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5044:1: rule__RGBColor__Group__7 : rule__RGBColor__Group__7__Impl ;
    public final void rule__RGBColor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5048:1: ( rule__RGBColor__Group__7__Impl )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5049:2: rule__RGBColor__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__RGBColor__Group__7__Impl_in_rule__RGBColor__Group__710164);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5055:1: rule__RGBColor__Group__7__Impl : ( ')' ) ;
    public final void rule__RGBColor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5059:1: ( ( ')' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5060:1: ( ')' )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5060:1: ( ')' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5061:1: ')'
            {
             before(grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_7()); 
            match(input,55,FOLLOW_55_in_rule__RGBColor__Group__7__Impl10192); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5092:1: rule__Model__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5096:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5097:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5097:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5098:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Model__NameAssignment_010245); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5107:1: rule__Model__PartitionsAssignment_2 : ( rulePartition ) ;
    public final void rule__Model__PartitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5111:1: ( ( rulePartition ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5112:1: ( rulePartition )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5112:1: ( rulePartition )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5113:1: rulePartition
            {
             before(grammarAccess.getModelAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_rulePartition_in_rule__Model__PartitionsAssignment_210276);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5122:1: rule__Model__DamagersAssignment_3 : ( ruleDamager ) ;
    public final void rule__Model__DamagersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5126:1: ( ( ruleDamager ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5127:1: ( ruleDamager )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5127:1: ( ruleDamager )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5128:1: ruleDamager
            {
             before(grammarAccess.getModelAccess().getDamagersDamagerParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDamager_in_rule__Model__DamagersAssignment_310307);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5137:1: rule__Model__PartitionerAssignment_4 : ( rulePartitioner ) ;
    public final void rule__Model__PartitionerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5141:1: ( ( rulePartitioner ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5142:1: ( rulePartitioner )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5142:1: ( rulePartitioner )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5143:1: rulePartitioner
            {
             before(grammarAccess.getModelAccess().getPartitionerPartitionerParserRuleCall_4_0()); 
            pushFollow(FOLLOW_rulePartitioner_in_rule__Model__PartitionerAssignment_410338);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5152:1: rule__Model__ContentTypesAssignment_7 : ( RULE_STRING ) ;
    public final void rule__Model__ContentTypesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5156:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5157:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5157:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5158:1: RULE_STRING
            {
             before(grammarAccess.getModelAccess().getContentTypesSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Model__ContentTypesAssignment_710369); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5167:1: rule__Partition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Partition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5171:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5172:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5172:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5173:1: RULE_ID
            {
             before(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_110400); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5182:1: rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5186:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5187:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5187:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5188:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionPartitionCrossReference_3_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5189:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5190:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionPartitionIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_310435); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5201:1: rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5205:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5206:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5206:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5207:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionPartitionCrossReference_5_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5208:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5209:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionPartitionIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_510474); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5220:1: rule__JavaLikeParitioner__JavaDocParitionAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__JavaDocParitionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5224:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5225:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5225:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5226:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionCrossReference_7_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5227:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5228:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__JavaDocParitionAssignment_710513); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5239:1: rule__JavaLikeParitioner__CharacterParitionAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__CharacterParitionAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5243:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5244:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5244:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5245:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionCrossReference_9_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5246:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5247:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__CharacterParitionAssignment_910552); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5258:1: rule__JavaLikeParitioner__StringParitionAssignment_11 : ( ( RULE_ID ) ) ;
    public final void rule__JavaLikeParitioner__StringParitionAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5262:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5263:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5263:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5264:1: ( RULE_ID )
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionCrossReference_11_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5265:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5266:1: RULE_ID
            {
             before(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionIDTerminalRuleCall_11_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__StringParitionAssignment_1110591); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5277:1: rule__RulePartitioner__RulesAssignment_2 : ( ruleParitionRule ) ;
    public final void rule__RulePartitioner__RulesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5281:1: ( ( ruleParitionRule ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5282:1: ( ruleParitionRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5282:1: ( ruleParitionRule )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5283:1: ruleParitionRule
            {
             before(grammarAccess.getRulePartitionerAccess().getRulesParitionRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParitionRule_in_rule__RulePartitioner__RulesAssignment_210626);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5292:1: rule__JSParitioner__FileURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JSParitioner__FileURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5296:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5297:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5297:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5298:1: RULE_STRING
            {
             before(grammarAccess.getJSParitionerAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JSParitioner__FileURIAssignment_110657); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5307:1: rule__JSDamager__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__JSDamager__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5311:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5312:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5312:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5313:1: ( RULE_ID )
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5314:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5315:1: RULE_ID
            {
             before(grammarAccess.getJSDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__JSDamager__PartitionAssignment_110692); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5326:1: rule__JSDamager__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__JSDamager__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5330:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5331:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5331:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5332:1: RULE_STRING
            {
             before(grammarAccess.getJSDamagerAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__JSDamager__FileURIAssignment_210727); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5341:1: rule__RuleDamager__PartitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__RuleDamager__PartitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5345:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5346:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5346:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5347:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5348:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5349:1: RULE_ID
            {
             before(grammarAccess.getRuleDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RuleDamager__PartitionAssignment_110762); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5360:1: rule__RuleDamager__TokensAssignment_3 : ( ruleScannerToken ) ;
    public final void rule__RuleDamager__TokensAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5364:1: ( ( ruleScannerToken ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5365:1: ( ruleScannerToken )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5365:1: ( ruleScannerToken )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5366:1: ruleScannerToken
            {
             before(grammarAccess.getRuleDamagerAccess().getTokensScannerTokenParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleScannerToken_in_rule__RuleDamager__TokensAssignment_310797);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5375:1: rule__RuleDamager__KeywordGroupsAssignment_4 : ( ruleKeywordGroup ) ;
    public final void rule__RuleDamager__KeywordGroupsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5379:1: ( ( ruleKeywordGroup ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5380:1: ( ruleKeywordGroup )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5380:1: ( ruleKeywordGroup )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5381:1: ruleKeywordGroup
            {
             before(grammarAccess.getRuleDamagerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_rule__RuleDamager__KeywordGroupsAssignment_410828);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5390:1: rule__RuleDamager__RulesAssignment_5 : ( ruleScannerRule ) ;
    public final void rule__RuleDamager__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5394:1: ( ( ruleScannerRule ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5395:1: ( ruleScannerRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5395:1: ( ruleScannerRule )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5396:1: ruleScannerRule
            {
             before(grammarAccess.getRuleDamagerAccess().getRulesScannerRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleScannerRule_in_rule__RuleDamager__RulesAssignment_510859);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5405:1: rule__ScannerToken__DefaultAssignment_0 : ( ( 'default' ) ) ;
    public final void rule__ScannerToken__DefaultAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5409:1: ( ( ( 'default' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5410:1: ( ( 'default' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5410:1: ( ( 'default' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5411:1: ( 'default' )
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5412:1: ( 'default' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5413:1: 'default'
            {
             before(grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0()); 
            match(input,56,FOLLOW_56_in_rule__ScannerToken__DefaultAssignment_010895); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5428:1: rule__ScannerToken__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ScannerToken__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5432:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5433:1: ( RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5433:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5434:1: RULE_ID
            {
             before(grammarAccess.getScannerTokenAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerToken__NameAssignment_210934); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5443:1: rule__KeywordGroup__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__KeywordGroup__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5447:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5448:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5448:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5449:1: ( RULE_ID )
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5450:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5451:1: RULE_ID
            {
             before(grammarAccess.getKeywordGroupAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeywordGroup__TokenAssignment_110969); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5462:1: rule__KeywordGroup__KeywordsAssignment_3 : ( ruleKeyword ) ;
    public final void rule__KeywordGroup__KeywordsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5466:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5467:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5467:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5468:1: ruleKeyword
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_311004);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5477:1: rule__KeywordGroup__KeywordsAssignment_4_1 : ( ruleKeyword ) ;
    public final void rule__KeywordGroup__KeywordsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5481:1: ( ( ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5482:1: ( ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5482:1: ( ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5483:1: ruleKeyword
            {
             before(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_4_111035);
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5492:1: rule__Keyword__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Keyword__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5496:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5497:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5497:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5498:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_011066); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5507:1: rule__Keyword__VersionAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Keyword__VersionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5511:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5512:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5512:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5513:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_111097); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5522:1: rule__ScannerSingleLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerSingleLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5526:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5527:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5527:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5528:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5529:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5530:1: RULE_ID
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerSingleLineRule__TokenAssignment_111132); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5541:1: rule__ScannerSingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5545:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5546:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5546:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5547:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__StartSeqAssignment_211167); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5556:1: rule__ScannerSingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5560:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5561:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5561:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5562:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EndSeqAssignment_411198); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5571:1: rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5575:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5576:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5576:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5577:1: RULE_STRING
            {
             before(grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_211229); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5586:1: rule__PartitionSingleLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionSingleLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5590:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5591:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5591:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5592:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5593:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5594:1: RULE_ID
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionSingleLineRule__ParitionAssignment_111264); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5605:1: rule__PartitionSingleLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5609:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5610:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5610:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5611:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__StartSeqAssignment_211299); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5620:1: rule__PartitionSingleLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5624:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5625:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5625:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5626:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EndSeqAssignment_411330); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5635:1: rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5639:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5640:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5640:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5641:1: RULE_STRING
            {
             before(grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_211361); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5650:1: rule__ScannerMultiLineRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerMultiLineRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5654:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5655:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5655:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5656:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5657:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5658:1: RULE_ID
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerMultiLineRule__TokenAssignment_111396); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5669:1: rule__ScannerMultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5673:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5674:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5674:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5675:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__StartSeqAssignment_211431); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5684:1: rule__ScannerMultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5688:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5689:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5689:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5690:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EndSeqAssignment_411462); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5699:1: rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5703:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5704:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5704:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5705:1: RULE_STRING
            {
             before(grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_211493); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5714:1: rule__PartitionMultiLineRule__ParitionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionMultiLineRule__ParitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5718:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5719:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5719:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5720:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5721:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5722:1: RULE_ID
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionMultiLineRule__ParitionAssignment_111528); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5733:1: rule__PartitionMultiLineRule__StartSeqAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__StartSeqAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5737:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5738:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5738:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5739:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__StartSeqAssignment_211563); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5748:1: rule__PartitionMultiLineRule__EndSeqAssignment_4 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__EndSeqAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5752:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5753:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5753:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5754:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EndSeqAssignment_411594); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5763:1: rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5767:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5768:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5768:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5769:1: RULE_STRING
            {
             before(grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_211625); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5778:1: rule__ScannerCharacterRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerCharacterRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5782:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5783:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5783:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5784:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5785:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5786:1: RULE_ID
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerCharacterRule__TokenAssignment_111660); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5797:1: rule__ScannerCharacterRule__CharactersAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ScannerCharacterRule__CharactersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5801:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5802:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5802:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5803:1: RULE_STRING
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_311695); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5812:1: rule__ScannerCharacterRule__CharactersAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__ScannerCharacterRule__CharactersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5816:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5817:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5817:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5818:1: RULE_STRING
            {
             before(grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_4_111726); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5827:1: rule__ScannerJSRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerJSRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5831:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5832:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5832:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5833:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5834:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5835:1: RULE_ID
            {
             before(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerJSRule__TokenAssignment_111761); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5846:1: rule__ScannerJSRule__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ScannerJSRule__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5850:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5851:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5851:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5852:1: RULE_STRING
            {
             before(grammarAccess.getScannerJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerJSRule__FileURIAssignment_211796); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5861:1: rule__PartitionJSRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PartitionJSRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5865:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5866:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5866:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5867:1: ( RULE_ID )
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5868:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5869:1: RULE_ID
            {
             before(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PartitionJSRule__TokenAssignment_111831); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5880:1: rule__PartitionJSRule__FileURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PartitionJSRule__FileURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5884:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5885:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5885:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5886:1: RULE_STRING
            {
             before(grammarAccess.getPartitionJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__PartitionJSRule__FileURIAssignment_211866); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5895:1: rule__ScannerWhitespaceRule__TokenAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ScannerWhitespaceRule__TokenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5899:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5900:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5900:1: ( ( RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5901:1: ( RULE_ID )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5902:1: ( RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5903:1: RULE_ID
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ScannerWhitespaceRule__TokenAssignment_111901); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5914:1: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5918:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5919:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5919:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5920:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_111936); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5929:1: rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5933:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5934:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5934:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5935:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_111967); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5944:1: rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1 : ( ( 'javawhitespace' ) ) ;
    public final void rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5948:1: ( ( ( 'javawhitespace' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5949:1: ( ( 'javawhitespace' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5949:1: ( ( 'javawhitespace' ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5950:1: ( 'javawhitespace' )
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_2_1_0()); 
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5951:1: ( 'javawhitespace' )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5952:1: 'javawhitespace'
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_2_1_0()); 
            match(input,57,FOLLOW_57_in_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_112003); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5967:1: rule__ScannerWhitespaceRule__FileURIAssignment_2_2 : ( RULE_STRING ) ;
    public final void rule__ScannerWhitespaceRule__FileURIAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5971:1: ( ( RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5972:1: ( RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5972:1: ( RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5973:1: RULE_STRING
            {
             before(grammarAccess.getScannerWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_2_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__FileURIAssignment_2_212042); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5982:1: rule__RGBColor__RAssignment_2 : ( RULE_INT ) ;
    public final void rule__RGBColor__RAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5986:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5987:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5987:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5988:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getRINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__RAssignment_212073); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:5997:1: rule__RGBColor__GAssignment_4 : ( RULE_INT ) ;
    public final void rule__RGBColor__GAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6001:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6002:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6002:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6003:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getGINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__GAssignment_412104); 
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
    // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6012:1: rule__RGBColor__BAssignment_6 : ( RULE_INT ) ;
    public final void rule__RGBColor__BAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6016:1: ( ( RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6017:1: ( RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6017:1: ( RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl.ui/src-gen/org/eclipse/fx/code/compensator/hsl/ui/contentassist/antlr/internal/InternalHSL.g:6018:1: RULE_INT
            {
             before(grammarAccess.getRGBColorAccess().getBINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RGBColor__BAssignment_612135); 
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
    public static final BitSet FOLLOW_11_in_rule__JavaLikeParitioner__Alternatives_01557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__JavaLikeParitioner__Alternatives_01577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__RulePartitioner__Alternatives_01612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__RulePartitioner__Alternatives_01632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JSParitioner__Alternatives_01667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JSParitioner__Alternatives_01687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_rule__Damager__Alternatives1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_rule__Damager__Alternatives1738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__JSDamager__Alternatives_01771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__JSDamager__Alternatives_01791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__RuleDamager__Alternatives_01826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__RuleDamager__Alternatives_01846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_rule__ScannerRule__Alternatives1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_rule__ScannerRule__Alternatives1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_rule__ScannerRule__Alternatives1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_rule__ScannerRule__Alternatives1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_rule__ScannerRule__Alternatives1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_rule__ParitionRule__Alternatives1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_rule__ParitionRule__Alternatives1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_rule__ParitionRule__Alternatives2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ScannerSingleLineRule__Alternatives_02047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ScannerSingleLineRule__Alternatives_02067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PartitionSingleLineRule__Alternatives_02102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PartitionSingleLineRule__Alternatives_02122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ScannerMultiLineRule__Alternatives_02157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ScannerMultiLineRule__Alternatives_02177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__PartitionMultiLineRule__Alternatives_02212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__PartitionMultiLineRule__Alternatives_02232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ScannerCharacterRule__Alternatives_02267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ScannerCharacterRule__Alternatives_02287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ScannerJSRule__Alternatives_02322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ScannerJSRule__Alternatives_02342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__PartitionJSRule__Alternatives_02377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PartitionJSRule__Alternatives_02397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ScannerWhitespaceRule__Alternatives_02432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ScannerWhitespaceRule__Alternatives_02452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0_in_rule__ScannerWhitespaceRule__Alternatives_22486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_1_in_rule__ScannerWhitespaceRule__Alternatives_22504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__FileURIAssignment_2_2_in_rule__ScannerWhitespaceRule__Alternatives_22522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__FontType__Alternatives2556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__FontType__Alternatives2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__FontType__Alternatives2598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__FontType__Alternatives2619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02652 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NameAssignment_0_in_rule__Model__Group__0__Impl2682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12712 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Model__Group__1__Impl2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22774 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__22777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2806 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionsAssignment_2_in_rule__Model__Group__2__Impl2818 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__32851 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__32854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2883 = new BitSet(new long[]{0x00000000001E0002L});
    public static final BitSet FOLLOW_rule__Model__DamagersAssignment_3_in_rule__Model__Group__3__Impl2895 = new BitSet(new long[]{0x00000000001E0002L});
    public static final BitSet FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__42928 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Model__Group__5_in_rule__Model__Group__42931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__PartitionerAssignment_4_in_rule__Model__Group__4__Impl2958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__52988 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Model__Group__6_in_rule__Model__Group__52991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Model__Group__5__Impl3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__6__Impl_in_rule__Model__Group__63050 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Model__Group__7_in_rule__Model__Group__63053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Model__Group__6__Impl3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__7__Impl_in_rule__Model__Group__73112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl3141 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Model__ContentTypesAssignment_7_in_rule__Model__Group__7__Impl3153 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Partition__Group__0__Impl_in_rule__Partition__Group__03202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Partition__Group__1_in_rule__Partition__Group__03205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Partition__Group__0__Impl3233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__Group__1__Impl_in_rule__Partition__Group__13264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Partition__NameAssignment_1_in_rule__Partition__Group__1__Impl3291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__0__Impl_in_rule__JavaLikeParitioner__Group__03325 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__1_in_rule__JavaLikeParitioner__Group__03328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Alternatives_0_in_rule__JavaLikeParitioner__Group__0__Impl3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__1__Impl_in_rule__JavaLikeParitioner__Group__13385 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__2_in_rule__JavaLikeParitioner__Group__13388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__JavaLikeParitioner__Group__1__Impl3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__2__Impl_in_rule__JavaLikeParitioner__Group__23447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__3_in_rule__JavaLikeParitioner__Group__23450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__JavaLikeParitioner__Group__2__Impl3478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__3__Impl_in_rule__JavaLikeParitioner__Group__33509 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__4_in_rule__JavaLikeParitioner__Group__33512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_3_in_rule__JavaLikeParitioner__Group__3__Impl3539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__4__Impl_in_rule__JavaLikeParitioner__Group__43569 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__5_in_rule__JavaLikeParitioner__Group__43572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__JavaLikeParitioner__Group__4__Impl3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__5__Impl_in_rule__JavaLikeParitioner__Group__53631 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__6_in_rule__JavaLikeParitioner__Group__53634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_5_in_rule__JavaLikeParitioner__Group__5__Impl3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__6__Impl_in_rule__JavaLikeParitioner__Group__63691 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__7_in_rule__JavaLikeParitioner__Group__63694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__JavaLikeParitioner__Group__6__Impl3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__7__Impl_in_rule__JavaLikeParitioner__Group__73753 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__8_in_rule__JavaLikeParitioner__Group__73756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__JavaDocParitionAssignment_7_in_rule__JavaLikeParitioner__Group__7__Impl3783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__8__Impl_in_rule__JavaLikeParitioner__Group__83813 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__9_in_rule__JavaLikeParitioner__Group__83816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__JavaLikeParitioner__Group__8__Impl3844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__9__Impl_in_rule__JavaLikeParitioner__Group__93875 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__10_in_rule__JavaLikeParitioner__Group__93878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__CharacterParitionAssignment_9_in_rule__JavaLikeParitioner__Group__9__Impl3905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__10__Impl_in_rule__JavaLikeParitioner__Group__103935 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__11_in_rule__JavaLikeParitioner__Group__103938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__JavaLikeParitioner__Group__10__Impl3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__11__Impl_in_rule__JavaLikeParitioner__Group__113997 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__12_in_rule__JavaLikeParitioner__Group__114000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__StringParitionAssignment_11_in_rule__JavaLikeParitioner__Group__11__Impl4027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JavaLikeParitioner__Group__12__Impl_in_rule__JavaLikeParitioner__Group__124057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__JavaLikeParitioner__Group__12__Impl4085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__0__Impl_in_rule__RulePartitioner__Group__04142 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__1_in_rule__RulePartitioner__Group__04145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Alternatives_0_in_rule__RulePartitioner__Group__0__Impl4172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__1__Impl_in_rule__RulePartitioner__Group__14202 = new BitSet(new long[]{0x0000000019E00000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__2_in_rule__RulePartitioner__Group__14205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__RulePartitioner__Group__1__Impl4233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__2__Impl_in_rule__RulePartitioner__Group__24264 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__3_in_rule__RulePartitioner__Group__24267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl4296 = new BitSet(new long[]{0x0000000019E00002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__RulesAssignment_2_in_rule__RulePartitioner__Group__2__Impl4308 = new BitSet(new long[]{0x0000000019E00002L});
    public static final BitSet FOLLOW_rule__RulePartitioner__Group__3__Impl_in_rule__RulePartitioner__Group__34341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__RulePartitioner__Group__3__Impl4369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__0__Impl_in_rule__JSParitioner__Group__04408 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__1_in_rule__JSParitioner__Group__04411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Alternatives_0_in_rule__JSParitioner__Group__0__Impl4438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__Group__1__Impl_in_rule__JSParitioner__Group__14468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSParitioner__FileURIAssignment_1_in_rule__JSParitioner__Group__1__Impl4495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__0__Impl_in_rule__JSDamager__Group__04529 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__1_in_rule__JSDamager__Group__04532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Alternatives_0_in_rule__JSDamager__Group__0__Impl4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__1__Impl_in_rule__JSDamager__Group__14589 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__2_in_rule__JSDamager__Group__14592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__PartitionAssignment_1_in_rule__JSDamager__Group__1__Impl4619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__Group__2__Impl_in_rule__JSDamager__Group__24649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JSDamager__FileURIAssignment_2_in_rule__JSDamager__Group__2__Impl4676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__0__Impl_in_rule__RuleDamager__Group__04712 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__1_in_rule__RuleDamager__Group__04715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Alternatives_0_in_rule__RuleDamager__Group__0__Impl4742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__1__Impl_in_rule__RuleDamager__Group__14772 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__2_in_rule__RuleDamager__Group__14775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__PartitionAssignment_1_in_rule__RuleDamager__Group__1__Impl4802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__2__Impl_in_rule__RuleDamager__Group__24832 = new BitSet(new long[]{0x010030107FE00000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__3_in_rule__RuleDamager__Group__24835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__RuleDamager__Group__2__Impl4863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__3__Impl_in_rule__RuleDamager__Group__34894 = new BitSet(new long[]{0x010030107FE00000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__4_in_rule__RuleDamager__Group__34897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__TokensAssignment_3_in_rule__RuleDamager__Group__3__Impl4924 = new BitSet(new long[]{0x0100100000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__4__Impl_in_rule__RuleDamager__Group__44955 = new BitSet(new long[]{0x010030107FE00000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__5_in_rule__RuleDamager__Group__44958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__KeywordGroupsAssignment_4_in_rule__RuleDamager__Group__4__Impl4985 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__5__Impl_in_rule__RuleDamager__Group__55016 = new BitSet(new long[]{0x010030107FE00000L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__6_in_rule__RuleDamager__Group__55019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDamager__RulesAssignment_5_in_rule__RuleDamager__Group__5__Impl5046 = new BitSet(new long[]{0x000000007FE00002L});
    public static final BitSet FOLLOW_rule__RuleDamager__Group__6__Impl_in_rule__RuleDamager__Group__65077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__RuleDamager__Group__6__Impl5105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__0__Impl_in_rule__ScannerToken__Group__05150 = new BitSet(new long[]{0x0100100000000000L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__1_in_rule__ScannerToken__Group__05153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__DefaultAssignment_0_in_rule__ScannerToken__Group__0__Impl5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__1__Impl_in_rule__ScannerToken__Group__15211 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__2_in_rule__ScannerToken__Group__15214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ScannerToken__Group__1__Impl5242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__Group__2__Impl_in_rule__ScannerToken__Group__25273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerToken__NameAssignment_2_in_rule__ScannerToken__Group__2__Impl5300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__0__Impl_in_rule__KeywordGroup__Group__05336 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__1_in_rule__KeywordGroup__Group__05339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__KeywordGroup__Group__0__Impl5367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__1__Impl_in_rule__KeywordGroup__Group__15398 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__2_in_rule__KeywordGroup__Group__15401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__TokenAssignment_1_in_rule__KeywordGroup__Group__1__Impl5428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__2__Impl_in_rule__KeywordGroup__Group__25458 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__3_in_rule__KeywordGroup__Group__25461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__KeywordGroup__Group__2__Impl5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__3__Impl_in_rule__KeywordGroup__Group__35520 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__4_in_rule__KeywordGroup__Group__35523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__KeywordsAssignment_3_in_rule__KeywordGroup__Group__3__Impl5550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__4__Impl_in_rule__KeywordGroup__Group__45580 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__5_in_rule__KeywordGroup__Group__45583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__0_in_rule__KeywordGroup__Group__4__Impl5610 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group__5__Impl_in_rule__KeywordGroup__Group__55641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__KeywordGroup__Group__5__Impl5669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__0__Impl_in_rule__KeywordGroup__Group_4__05712 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__1_in_rule__KeywordGroup__Group_4__05715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__KeywordGroup__Group_4__0__Impl5743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__Group_4__1__Impl_in_rule__KeywordGroup__Group_4__15774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeywordGroup__KeywordsAssignment_4_1_in_rule__KeywordGroup__Group_4__1__Impl5801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__0__Impl_in_rule__Keyword__Group__05835 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1_in_rule__Keyword__Group__05838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__NameAssignment_0_in_rule__Keyword__Group__0__Impl5865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group__1__Impl_in_rule__Keyword__Group__15895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0_in_rule__Keyword__Group__1__Impl5922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__0__Impl_in_rule__Keyword__Group_1__05957 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1_in_rule__Keyword__Group_1__05960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__Keyword__Group_1__0__Impl5988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__Group_1__1__Impl_in_rule__Keyword__Group_1__16019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__VersionAssignment_1_1_in_rule__Keyword__Group_1__1__Impl6046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__0__Impl_in_rule__ScannerSingleLineRule__Group__06080 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__1_in_rule__ScannerSingleLineRule__Group__06083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Alternatives_0_in_rule__ScannerSingleLineRule__Group__0__Impl6110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__1__Impl_in_rule__ScannerSingleLineRule__Group__16140 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__2_in_rule__ScannerSingleLineRule__Group__16143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__TokenAssignment_1_in_rule__ScannerSingleLineRule__Group__1__Impl6170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__2__Impl_in_rule__ScannerSingleLineRule__Group__26200 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__3_in_rule__ScannerSingleLineRule__Group__26203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__StartSeqAssignment_2_in_rule__ScannerSingleLineRule__Group__2__Impl6230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__3__Impl_in_rule__ScannerSingleLineRule__Group__36260 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__4_in_rule__ScannerSingleLineRule__Group__36263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ScannerSingleLineRule__Group__3__Impl6291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__4__Impl_in_rule__ScannerSingleLineRule__Group__46322 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__5_in_rule__ScannerSingleLineRule__Group__46325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__EndSeqAssignment_4_in_rule__ScannerSingleLineRule__Group__4__Impl6352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group__5__Impl_in_rule__ScannerSingleLineRule__Group__56382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__0_in_rule__ScannerSingleLineRule__Group__5__Impl6409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__0__Impl_in_rule__ScannerSingleLineRule__Group_5__06452 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__1_in_rule__ScannerSingleLineRule__Group_5__06455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ScannerSingleLineRule__Group_5__0__Impl6483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__1__Impl_in_rule__ScannerSingleLineRule__Group_5__16514 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__2_in_rule__ScannerSingleLineRule__Group_5__16517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ScannerSingleLineRule__Group_5__1__Impl6545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__Group_5__2__Impl_in_rule__ScannerSingleLineRule__Group_5__26576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerSingleLineRule__Group_5__2__Impl6603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__0__Impl_in_rule__PartitionSingleLineRule__Group__06639 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__1_in_rule__PartitionSingleLineRule__Group__06642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Alternatives_0_in_rule__PartitionSingleLineRule__Group__0__Impl6669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__1__Impl_in_rule__PartitionSingleLineRule__Group__16699 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__2_in_rule__PartitionSingleLineRule__Group__16702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__ParitionAssignment_1_in_rule__PartitionSingleLineRule__Group__1__Impl6729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__2__Impl_in_rule__PartitionSingleLineRule__Group__26759 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__3_in_rule__PartitionSingleLineRule__Group__26762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__StartSeqAssignment_2_in_rule__PartitionSingleLineRule__Group__2__Impl6789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__3__Impl_in_rule__PartitionSingleLineRule__Group__36819 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__4_in_rule__PartitionSingleLineRule__Group__36822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__PartitionSingleLineRule__Group__3__Impl6850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__4__Impl_in_rule__PartitionSingleLineRule__Group__46881 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__5_in_rule__PartitionSingleLineRule__Group__46884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__EndSeqAssignment_4_in_rule__PartitionSingleLineRule__Group__4__Impl6911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group__5__Impl_in_rule__PartitionSingleLineRule__Group__56941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__0_in_rule__PartitionSingleLineRule__Group__5__Impl6968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__0__Impl_in_rule__PartitionSingleLineRule__Group_5__07011 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__1_in_rule__PartitionSingleLineRule__Group_5__07014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__PartitionSingleLineRule__Group_5__0__Impl7042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__1__Impl_in_rule__PartitionSingleLineRule__Group_5__17073 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__2_in_rule__PartitionSingleLineRule__Group_5__17076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__PartitionSingleLineRule__Group_5__1__Impl7104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__Group_5__2__Impl_in_rule__PartitionSingleLineRule__Group_5__27135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionSingleLineRule__Group_5__2__Impl7162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__0__Impl_in_rule__ScannerMultiLineRule__Group__07198 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__1_in_rule__ScannerMultiLineRule__Group__07201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Alternatives_0_in_rule__ScannerMultiLineRule__Group__0__Impl7228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__1__Impl_in_rule__ScannerMultiLineRule__Group__17258 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__2_in_rule__ScannerMultiLineRule__Group__17261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__TokenAssignment_1_in_rule__ScannerMultiLineRule__Group__1__Impl7288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__2__Impl_in_rule__ScannerMultiLineRule__Group__27318 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__3_in_rule__ScannerMultiLineRule__Group__27321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__StartSeqAssignment_2_in_rule__ScannerMultiLineRule__Group__2__Impl7348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__3__Impl_in_rule__ScannerMultiLineRule__Group__37378 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__4_in_rule__ScannerMultiLineRule__Group__37381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ScannerMultiLineRule__Group__3__Impl7409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__4__Impl_in_rule__ScannerMultiLineRule__Group__47440 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__5_in_rule__ScannerMultiLineRule__Group__47443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__EndSeqAssignment_4_in_rule__ScannerMultiLineRule__Group__4__Impl7470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group__5__Impl_in_rule__ScannerMultiLineRule__Group__57500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__0_in_rule__ScannerMultiLineRule__Group__5__Impl7527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__0__Impl_in_rule__ScannerMultiLineRule__Group_5__07570 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__1_in_rule__ScannerMultiLineRule__Group_5__07573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ScannerMultiLineRule__Group_5__0__Impl7601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__1__Impl_in_rule__ScannerMultiLineRule__Group_5__17632 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__2_in_rule__ScannerMultiLineRule__Group_5__17635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ScannerMultiLineRule__Group_5__1__Impl7663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__Group_5__2__Impl_in_rule__ScannerMultiLineRule__Group_5__27694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_2_in_rule__ScannerMultiLineRule__Group_5__2__Impl7721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__0__Impl_in_rule__PartitionMultiLineRule__Group__07757 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__1_in_rule__PartitionMultiLineRule__Group__07760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Alternatives_0_in_rule__PartitionMultiLineRule__Group__0__Impl7787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__1__Impl_in_rule__PartitionMultiLineRule__Group__17817 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__2_in_rule__PartitionMultiLineRule__Group__17820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__ParitionAssignment_1_in_rule__PartitionMultiLineRule__Group__1__Impl7847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__2__Impl_in_rule__PartitionMultiLineRule__Group__27877 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__3_in_rule__PartitionMultiLineRule__Group__27880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__StartSeqAssignment_2_in_rule__PartitionMultiLineRule__Group__2__Impl7907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__3__Impl_in_rule__PartitionMultiLineRule__Group__37937 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__4_in_rule__PartitionMultiLineRule__Group__37940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__PartitionMultiLineRule__Group__3__Impl7968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__4__Impl_in_rule__PartitionMultiLineRule__Group__47999 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__5_in_rule__PartitionMultiLineRule__Group__48002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__EndSeqAssignment_4_in_rule__PartitionMultiLineRule__Group__4__Impl8029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group__5__Impl_in_rule__PartitionMultiLineRule__Group__58059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__0_in_rule__PartitionMultiLineRule__Group__5__Impl8086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__0__Impl_in_rule__PartitionMultiLineRule__Group_5__08129 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__1_in_rule__PartitionMultiLineRule__Group_5__08132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__PartitionMultiLineRule__Group_5__0__Impl8160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__1__Impl_in_rule__PartitionMultiLineRule__Group_5__18191 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__2_in_rule__PartitionMultiLineRule__Group_5__18194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__PartitionMultiLineRule__Group_5__1__Impl8222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__Group_5__2__Impl_in_rule__PartitionMultiLineRule__Group_5__28253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_2_in_rule__PartitionMultiLineRule__Group_5__2__Impl8280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__0__Impl_in_rule__ScannerCharacterRule__Group__08316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__1_in_rule__ScannerCharacterRule__Group__08319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Alternatives_0_in_rule__ScannerCharacterRule__Group__0__Impl8346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__1__Impl_in_rule__ScannerCharacterRule__Group__18376 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__2_in_rule__ScannerCharacterRule__Group__18379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__TokenAssignment_1_in_rule__ScannerCharacterRule__Group__1__Impl8406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__2__Impl_in_rule__ScannerCharacterRule__Group__28436 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__3_in_rule__ScannerCharacterRule__Group__28439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ScannerCharacterRule__Group__2__Impl8467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__3__Impl_in_rule__ScannerCharacterRule__Group__38498 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__4_in_rule__ScannerCharacterRule__Group__38501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_3_in_rule__ScannerCharacterRule__Group__3__Impl8528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__4__Impl_in_rule__ScannerCharacterRule__Group__48558 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__5_in_rule__ScannerCharacterRule__Group__48561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__0_in_rule__ScannerCharacterRule__Group__4__Impl8588 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group__5__Impl_in_rule__ScannerCharacterRule__Group__58619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ScannerCharacterRule__Group__5__Impl8647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__0__Impl_in_rule__ScannerCharacterRule__Group_4__08690 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__1_in_rule__ScannerCharacterRule__Group_4__08693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ScannerCharacterRule__Group_4__0__Impl8721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__Group_4__1__Impl_in_rule__ScannerCharacterRule__Group_4__18752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerCharacterRule__CharactersAssignment_4_1_in_rule__ScannerCharacterRule__Group_4__1__Impl8779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__0__Impl_in_rule__ScannerJSRule__Group__08813 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__1_in_rule__ScannerJSRule__Group__08816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Alternatives_0_in_rule__ScannerJSRule__Group__0__Impl8843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__1__Impl_in_rule__ScannerJSRule__Group__18873 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__2_in_rule__ScannerJSRule__Group__18876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__TokenAssignment_1_in_rule__ScannerJSRule__Group__1__Impl8903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__Group__2__Impl_in_rule__ScannerJSRule__Group__28933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerJSRule__FileURIAssignment_2_in_rule__ScannerJSRule__Group__2__Impl8960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__0__Impl_in_rule__PartitionJSRule__Group__08996 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__1_in_rule__PartitionJSRule__Group__08999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Alternatives_0_in_rule__PartitionJSRule__Group__0__Impl9026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__1__Impl_in_rule__PartitionJSRule__Group__19056 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__2_in_rule__PartitionJSRule__Group__19059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__TokenAssignment_1_in_rule__PartitionJSRule__Group__1__Impl9086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__Group__2__Impl_in_rule__PartitionJSRule__Group__29116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PartitionJSRule__FileURIAssignment_2_in_rule__PartitionJSRule__Group__2__Impl9143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__0__Impl_in_rule__ScannerWhitespaceRule__Group__09179 = new BitSet(new long[]{0x0200400000000030L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__1_in_rule__ScannerWhitespaceRule__Group__09182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Alternatives_0_in_rule__ScannerWhitespaceRule__Group__0__Impl9209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__1__Impl_in_rule__ScannerWhitespaceRule__Group__19239 = new BitSet(new long[]{0x0200400000000030L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__2_in_rule__ScannerWhitespaceRule__Group__19242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__TokenAssignment_1_in_rule__ScannerWhitespaceRule__Group__1__Impl9269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group__2__Impl_in_rule__ScannerWhitespaceRule__Group__29300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Alternatives_2_in_rule__ScannerWhitespaceRule__Group__2__Impl9327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__09363 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1_in_rule__ScannerWhitespaceRule__Group_2_0__09366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ScannerWhitespaceRule__Group_2_0__0__Impl9394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__19425 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2_in_rule__ScannerWhitespaceRule__Group_2_0__19428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_1_in_rule__ScannerWhitespaceRule__Group_2_0__1__Impl9455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__2__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__29485 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3_in_rule__ScannerWhitespaceRule__Group_2_0__29488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0_in_rule__ScannerWhitespaceRule__Group_2_0__2__Impl9515 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0__3__Impl_in_rule__ScannerWhitespaceRule__Group_2_0__39546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ScannerWhitespaceRule__Group_2_0__3__Impl9574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__09613 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1_in_rule__ScannerWhitespaceRule__Group_2_0_2__09616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ScannerWhitespaceRule__Group_2_0_2__0__Impl9644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl_in_rule__ScannerWhitespaceRule__Group_2_0_2__19675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_1_in_rule__ScannerWhitespaceRule__Group_2_0_2__1__Impl9702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__0__Impl_in_rule__RGBColor__Group__09736 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__1_in_rule__RGBColor__Group__09739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__RGBColor__Group__0__Impl9767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__1__Impl_in_rule__RGBColor__Group__19798 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__2_in_rule__RGBColor__Group__19801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__RGBColor__Group__1__Impl9829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__2__Impl_in_rule__RGBColor__Group__29860 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__3_in_rule__RGBColor__Group__29863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__RAssignment_2_in_rule__RGBColor__Group__2__Impl9890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__3__Impl_in_rule__RGBColor__Group__39920 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__4_in_rule__RGBColor__Group__39923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__RGBColor__Group__3__Impl9951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__4__Impl_in_rule__RGBColor__Group__49982 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__5_in_rule__RGBColor__Group__49985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__GAssignment_4_in_rule__RGBColor__Group__4__Impl10012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__5__Impl_in_rule__RGBColor__Group__510042 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__6_in_rule__RGBColor__Group__510045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__RGBColor__Group__5__Impl10073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__6__Impl_in_rule__RGBColor__Group__610104 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__7_in_rule__RGBColor__Group__610107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__BAssignment_6_in_rule__RGBColor__Group__6__Impl10134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RGBColor__Group__7__Impl_in_rule__RGBColor__Group__710164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__RGBColor__Group__7__Impl10192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_010245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_rule__Model__PartitionsAssignment_210276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDamager_in_rule__Model__DamagersAssignment_310307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_rule__Model__PartitionerAssignment_410338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Model__ContentTypesAssignment_710369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Partition__NameAssignment_110400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__SingleLineDocParitionAssignment_310435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__MultiLineDocParitionAssignment_510474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__JavaDocParitionAssignment_710513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__CharacterParitionAssignment_910552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JavaLikeParitioner__StringParitionAssignment_1110591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_rule__RulePartitioner__RulesAssignment_210626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JSParitioner__FileURIAssignment_110657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__JSDamager__PartitionAssignment_110692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__JSDamager__FileURIAssignment_210727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RuleDamager__PartitionAssignment_110762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_rule__RuleDamager__TokensAssignment_310797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_rule__RuleDamager__KeywordGroupsAssignment_410828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_rule__RuleDamager__RulesAssignment_510859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__ScannerToken__DefaultAssignment_010895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerToken__NameAssignment_210934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeywordGroup__TokenAssignment_110969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_311004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__KeywordGroup__KeywordsAssignment_4_111035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__NameAssignment_011066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__VersionAssignment_1_111097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerSingleLineRule__TokenAssignment_111132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__StartSeqAssignment_211167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EndSeqAssignment_411198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerSingleLineRule__EscapeSeqAssignment_5_211229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionSingleLineRule__ParitionAssignment_111264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__StartSeqAssignment_211299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EndSeqAssignment_411330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionSingleLineRule__EscapeSeqAssignment_5_211361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerMultiLineRule__TokenAssignment_111396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__StartSeqAssignment_211431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EndSeqAssignment_411462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerMultiLineRule__EscapeSeqAssignment_5_211493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionMultiLineRule__ParitionAssignment_111528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__StartSeqAssignment_211563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EndSeqAssignment_411594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionMultiLineRule__EscapeSeqAssignment_5_211625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerCharacterRule__TokenAssignment_111660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_311695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerCharacterRule__CharactersAssignment_4_111726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerJSRule__TokenAssignment_111761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerJSRule__FileURIAssignment_211796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PartitionJSRule__TokenAssignment_111831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__PartitionJSRule__FileURIAssignment_211866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ScannerWhitespaceRule__TokenAssignment_111901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_111936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__CharactersAssignment_2_0_2_111967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__ScannerWhitespaceRule__JavawhitespaceAssignment_2_112003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ScannerWhitespaceRule__FileURIAssignment_2_212042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__RAssignment_212073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__GAssignment_412104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RGBColor__BAssignment_612135 = new BitSet(new long[]{0x0000000000000002L});

}