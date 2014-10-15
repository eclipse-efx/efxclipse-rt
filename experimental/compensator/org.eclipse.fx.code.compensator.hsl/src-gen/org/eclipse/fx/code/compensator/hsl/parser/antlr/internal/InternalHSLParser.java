package org.eclipse.fx.code.compensator.hsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.fx.code.compensator.hsl.services.HSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalHSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'for'", "'partition'", "'java-like-partitioner'", "'java_like_partitioner'", "'singlelinedoc'", "'multilinedoc'", "'javadoc'", "'char'", "'string'", "'rule-partitioner'", "'rule_partitioner'", "'js-partitioner'", "'js_partitioner'", "'js-damager'", "'js_damager'", "'rule-damager'", "'rule_damager'", "'default'", "'token'", "'keywords'", "'['", "','", "']'", "'since'", "'single-line'", "'single_line'", "'=>'", "'escaped'", "'by'", "'multi-line'", "'multi_line'", "'character-rule'", "'character_rule'", "'javascript-rule'", "'javascript_rule'", "'whitespace-rule'", "'whitespace_rule'", "'javawhitespace'", "'rgb'", "'('", "')'", "'bold'", "'italic'", "'underline'", "'strike-through'"
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
    public String getGrammarFileName() { return "../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g"; }



     	private HSLGrammarAccess grammarAccess;
     	
        public InternalHSLParser(TokenStream input, HSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected HSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:69:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_damagers_3_0= ruleDamager ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' otherlv_6= 'for' ( (lv_contentTypes_7_0= RULE_STRING ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_contentTypes_7_0=null;
        EObject lv_partitions_2_0 = null;

        EObject lv_damagers_3_0 = null;

        EObject lv_partitioner_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:80:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_damagers_3_0= ruleDamager ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' otherlv_6= 'for' ( (lv_contentTypes_7_0= RULE_STRING ) )+ ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:81:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_damagers_3_0= ruleDamager ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' otherlv_6= 'for' ( (lv_contentTypes_7_0= RULE_STRING ) )+ )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:81:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_damagers_3_0= ruleDamager ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' otherlv_6= 'for' ( (lv_contentTypes_7_0= RULE_STRING ) )+ )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:81:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_damagers_3_0= ruleDamager ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' otherlv_6= 'for' ( (lv_contentTypes_7_0= RULE_STRING ) )+
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:81:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:82:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:82:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:83:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel127); 

            			newLeafNode(lv_name_0_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModelRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleModel144); 

                	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:103:1: ( (lv_partitions_2_0= rulePartition ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:104:1: (lv_partitions_2_0= rulePartition )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:104:1: (lv_partitions_2_0= rulePartition )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:105:3: lv_partitions_2_0= rulePartition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePartition_in_ruleModel165);
            	    lv_partitions_2_0=rulePartition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"partitions",
            	            		lv_partitions_2_0, 
            	            		"Partition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:121:3: ( (lv_damagers_3_0= ruleDamager ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=26 && LA2_0<=29)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:122:1: (lv_damagers_3_0= ruleDamager )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:122:1: (lv_damagers_3_0= ruleDamager )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:123:3: lv_damagers_3_0= ruleDamager
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getDamagersDamagerParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDamager_in_ruleModel187);
            	    lv_damagers_3_0=ruleDamager();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"damagers",
            	            		lv_damagers_3_0, 
            	            		"Damager");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:139:3: ( (lv_partitioner_4_0= rulePartitioner ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:140:1: (lv_partitioner_4_0= rulePartitioner )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:140:1: (lv_partitioner_4_0= rulePartitioner )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:141:3: lv_partitioner_4_0= rulePartitioner
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getPartitionerPartitionerParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_rulePartitioner_in_ruleModel209);
            lv_partitioner_4_0=rulePartitioner();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"partitioner",
                    		lv_partitioner_4_0, 
                    		"Partitioner");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleModel221); 

                	newLeafNode(otherlv_5, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5());
                
            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleModel233); 

                	newLeafNode(otherlv_6, grammarAccess.getModelAccess().getForKeyword_6());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:165:1: ( (lv_contentTypes_7_0= RULE_STRING ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_STRING) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:166:1: (lv_contentTypes_7_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:166:1: (lv_contentTypes_7_0= RULE_STRING )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:167:3: lv_contentTypes_7_0= RULE_STRING
            	    {
            	    lv_contentTypes_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel250); 

            	    			newLeafNode(lv_contentTypes_7_0, grammarAccess.getModelAccess().getContentTypesSTRINGTerminalRuleCall_7_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getModelRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"contentTypes",
            	            		lv_contentTypes_7_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRulePartition"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:191:1: entryRulePartition returns [EObject current=null] : iv_rulePartition= rulePartition EOF ;
    public final EObject entryRulePartition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:192:2: (iv_rulePartition= rulePartition EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:193:2: iv_rulePartition= rulePartition EOF
            {
             newCompositeNode(grammarAccess.getPartitionRule()); 
            pushFollow(FOLLOW_rulePartition_in_entryRulePartition292);
            iv_rulePartition=rulePartition();

            state._fsp--;

             current =iv_rulePartition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition302); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePartition"


    // $ANTLR start "rulePartition"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:200:1: rulePartition returns [EObject current=null] : (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePartition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:203:28: ( (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:204:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:204:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:204:3: otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_rulePartition339); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionAccess().getPartitionKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:208:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:209:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:209:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:210:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition356); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePartition"


    // $ANTLR start "entryRulePartitioner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:234:1: entryRulePartitioner returns [EObject current=null] : iv_rulePartitioner= rulePartitioner EOF ;
    public final EObject entryRulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:235:2: (iv_rulePartitioner= rulePartitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:236:2: iv_rulePartitioner= rulePartitioner EOF
            {
             newCompositeNode(grammarAccess.getPartitionerRule()); 
            pushFollow(FOLLOW_rulePartitioner_in_entryRulePartitioner397);
            iv_rulePartitioner=rulePartitioner();

            state._fsp--;

             current =iv_rulePartitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner407); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePartitioner"


    // $ANTLR start "rulePartitioner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:243:1: rulePartitioner returns [EObject current=null] : (this_RulePartitioner_0= ruleRulePartitioner | this_JavaLikeParitioner_1= ruleJavaLikeParitioner | this_JSParitioner_2= ruleJSParitioner ) ;
    public final EObject rulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject this_RulePartitioner_0 = null;

        EObject this_JavaLikeParitioner_1 = null;

        EObject this_JSParitioner_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:246:28: ( (this_RulePartitioner_0= ruleRulePartitioner | this_JavaLikeParitioner_1= ruleJavaLikeParitioner | this_JSParitioner_2= ruleJSParitioner ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:247:1: (this_RulePartitioner_0= ruleRulePartitioner | this_JavaLikeParitioner_1= ruleJavaLikeParitioner | this_JSParitioner_2= ruleJSParitioner )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:247:1: (this_RulePartitioner_0= ruleRulePartitioner | this_JavaLikeParitioner_1= ruleJavaLikeParitioner | this_JSParitioner_2= ruleJSParitioner )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 22:
            case 23:
                {
                alt4=1;
                }
                break;
            case 15:
            case 16:
                {
                alt4=2;
                }
                break;
            case 24:
            case 25:
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
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:248:5: this_RulePartitioner_0= ruleRulePartitioner
                    {
                     
                            newCompositeNode(grammarAccess.getPartitionerAccess().getRulePartitionerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRulePartitioner_in_rulePartitioner454);
                    this_RulePartitioner_0=ruleRulePartitioner();

                    state._fsp--;

                     
                            current = this_RulePartitioner_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:258:5: this_JavaLikeParitioner_1= ruleJavaLikeParitioner
                    {
                     
                            newCompositeNode(grammarAccess.getPartitionerAccess().getJavaLikeParitionerParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleJavaLikeParitioner_in_rulePartitioner481);
                    this_JavaLikeParitioner_1=ruleJavaLikeParitioner();

                    state._fsp--;

                     
                            current = this_JavaLikeParitioner_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:268:5: this_JSParitioner_2= ruleJSParitioner
                    {
                     
                            newCompositeNode(grammarAccess.getPartitionerAccess().getJSParitionerParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleJSParitioner_in_rulePartitioner508);
                    this_JSParitioner_2=ruleJSParitioner();

                    state._fsp--;

                     
                            current = this_JSParitioner_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePartitioner"


    // $ANTLR start "entryRuleJavaLikeParitioner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:284:1: entryRuleJavaLikeParitioner returns [EObject current=null] : iv_ruleJavaLikeParitioner= ruleJavaLikeParitioner EOF ;
    public final EObject entryRuleJavaLikeParitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaLikeParitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:285:2: (iv_ruleJavaLikeParitioner= ruleJavaLikeParitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:286:2: iv_ruleJavaLikeParitioner= ruleJavaLikeParitioner EOF
            {
             newCompositeNode(grammarAccess.getJavaLikeParitionerRule()); 
            pushFollow(FOLLOW_ruleJavaLikeParitioner_in_entryRuleJavaLikeParitioner543);
            iv_ruleJavaLikeParitioner=ruleJavaLikeParitioner();

            state._fsp--;

             current =iv_ruleJavaLikeParitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaLikeParitioner553); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJavaLikeParitioner"


    // $ANTLR start "ruleJavaLikeParitioner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:293:1: ruleJavaLikeParitioner returns [EObject current=null] : ( (otherlv_0= 'java-like-partitioner' | otherlv_1= 'java_like_partitioner' ) otherlv_2= '{' otherlv_3= 'singlelinedoc' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'multilinedoc' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'javadoc' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'char' ( (otherlv_10= RULE_ID ) ) otherlv_11= 'string' ( (otherlv_12= RULE_ID ) ) otherlv_13= '}' ) ;
    public final EObject ruleJavaLikeParitioner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:296:28: ( ( (otherlv_0= 'java-like-partitioner' | otherlv_1= 'java_like_partitioner' ) otherlv_2= '{' otherlv_3= 'singlelinedoc' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'multilinedoc' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'javadoc' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'char' ( (otherlv_10= RULE_ID ) ) otherlv_11= 'string' ( (otherlv_12= RULE_ID ) ) otherlv_13= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:297:1: ( (otherlv_0= 'java-like-partitioner' | otherlv_1= 'java_like_partitioner' ) otherlv_2= '{' otherlv_3= 'singlelinedoc' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'multilinedoc' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'javadoc' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'char' ( (otherlv_10= RULE_ID ) ) otherlv_11= 'string' ( (otherlv_12= RULE_ID ) ) otherlv_13= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:297:1: ( (otherlv_0= 'java-like-partitioner' | otherlv_1= 'java_like_partitioner' ) otherlv_2= '{' otherlv_3= 'singlelinedoc' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'multilinedoc' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'javadoc' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'char' ( (otherlv_10= RULE_ID ) ) otherlv_11= 'string' ( (otherlv_12= RULE_ID ) ) otherlv_13= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:297:2: (otherlv_0= 'java-like-partitioner' | otherlv_1= 'java_like_partitioner' ) otherlv_2= '{' otherlv_3= 'singlelinedoc' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'multilinedoc' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'javadoc' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'char' ( (otherlv_10= RULE_ID ) ) otherlv_11= 'string' ( (otherlv_12= RULE_ID ) ) otherlv_13= '}'
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:297:2: (otherlv_0= 'java-like-partitioner' | otherlv_1= 'java_like_partitioner' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==16) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:297:4: otherlv_0= 'java-like-partitioner'
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleJavaLikeParitioner591); 

                        	newLeafNode(otherlv_0, grammarAccess.getJavaLikeParitionerAccess().getJavaLikePartitionerKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:302:7: otherlv_1= 'java_like_partitioner'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJavaLikeParitioner609); 

                        	newLeafNode(otherlv_1, grammarAccess.getJavaLikeParitionerAccess().getJava_like_partitionerKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleJavaLikeParitioner622); 

                	newLeafNode(otherlv_2, grammarAccess.getJavaLikeParitionerAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleJavaLikeParitioner634); 

                	newLeafNode(otherlv_3, grammarAccess.getJavaLikeParitionerAccess().getSinglelinedocKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:314:1: ( (otherlv_4= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:315:1: (otherlv_4= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:315:1: (otherlv_4= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:316:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaLikeParitionerRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaLikeParitioner654); 

            		newLeafNode(otherlv_4, grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionPartitionCrossReference_3_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleJavaLikeParitioner666); 

                	newLeafNode(otherlv_5, grammarAccess.getJavaLikeParitionerAccess().getMultilinedocKeyword_4());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:331:1: ( (otherlv_6= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:332:1: (otherlv_6= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:332:1: (otherlv_6= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:333:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaLikeParitionerRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaLikeParitioner686); 

            		newLeafNode(otherlv_6, grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionPartitionCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleJavaLikeParitioner698); 

                	newLeafNode(otherlv_7, grammarAccess.getJavaLikeParitionerAccess().getJavadocKeyword_6());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:348:1: ( (otherlv_8= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:349:1: (otherlv_8= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:349:1: (otherlv_8= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:350:3: otherlv_8= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaLikeParitionerRule());
            	        }
                    
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaLikeParitioner718); 

            		newLeafNode(otherlv_8, grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionCrossReference_7_0()); 
            	

            }


            }

            otherlv_9=(Token)match(input,20,FOLLOW_20_in_ruleJavaLikeParitioner730); 

                	newLeafNode(otherlv_9, grammarAccess.getJavaLikeParitionerAccess().getCharKeyword_8());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:365:1: ( (otherlv_10= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:366:1: (otherlv_10= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:366:1: (otherlv_10= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:367:3: otherlv_10= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaLikeParitionerRule());
            	        }
                    
            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaLikeParitioner750); 

            		newLeafNode(otherlv_10, grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionCrossReference_9_0()); 
            	

            }


            }

            otherlv_11=(Token)match(input,21,FOLLOW_21_in_ruleJavaLikeParitioner762); 

                	newLeafNode(otherlv_11, grammarAccess.getJavaLikeParitionerAccess().getStringKeyword_10());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:382:1: ( (otherlv_12= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:383:1: (otherlv_12= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:383:1: (otherlv_12= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:384:3: otherlv_12= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaLikeParitionerRule());
            	        }
                    
            otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaLikeParitioner782); 

            		newLeafNode(otherlv_12, grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionCrossReference_11_0()); 
            	

            }


            }

            otherlv_13=(Token)match(input,12,FOLLOW_12_in_ruleJavaLikeParitioner794); 

                	newLeafNode(otherlv_13, grammarAccess.getJavaLikeParitionerAccess().getRightCurlyBracketKeyword_12());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJavaLikeParitioner"


    // $ANTLR start "entryRuleRulePartitioner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:407:1: entryRuleRulePartitioner returns [EObject current=null] : iv_ruleRulePartitioner= ruleRulePartitioner EOF ;
    public final EObject entryRuleRulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRulePartitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:408:2: (iv_ruleRulePartitioner= ruleRulePartitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:409:2: iv_ruleRulePartitioner= ruleRulePartitioner EOF
            {
             newCompositeNode(grammarAccess.getRulePartitionerRule()); 
            pushFollow(FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner830);
            iv_ruleRulePartitioner=ruleRulePartitioner();

            state._fsp--;

             current =iv_ruleRulePartitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRulePartitioner840); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRulePartitioner"


    // $ANTLR start "ruleRulePartitioner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:416:1: ruleRulePartitioner returns [EObject current=null] : ( (otherlv_0= 'rule-partitioner' | otherlv_1= 'rule_partitioner' ) otherlv_2= '{' ( (lv_rules_3_0= ruleParitionRule ) )+ otherlv_4= '}' ) ;
    public final EObject ruleRulePartitioner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rules_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:419:28: ( ( (otherlv_0= 'rule-partitioner' | otherlv_1= 'rule_partitioner' ) otherlv_2= '{' ( (lv_rules_3_0= ruleParitionRule ) )+ otherlv_4= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:420:1: ( (otherlv_0= 'rule-partitioner' | otherlv_1= 'rule_partitioner' ) otherlv_2= '{' ( (lv_rules_3_0= ruleParitionRule ) )+ otherlv_4= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:420:1: ( (otherlv_0= 'rule-partitioner' | otherlv_1= 'rule_partitioner' ) otherlv_2= '{' ( (lv_rules_3_0= ruleParitionRule ) )+ otherlv_4= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:420:2: (otherlv_0= 'rule-partitioner' | otherlv_1= 'rule_partitioner' ) otherlv_2= '{' ( (lv_rules_3_0= ruleParitionRule ) )+ otherlv_4= '}'
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:420:2: (otherlv_0= 'rule-partitioner' | otherlv_1= 'rule_partitioner' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==22) ) {
                alt6=1;
            }
            else if ( (LA6_0==23) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:420:4: otherlv_0= 'rule-partitioner'
                    {
                    otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleRulePartitioner878); 

                        	newLeafNode(otherlv_0, grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:425:7: otherlv_1= 'rule_partitioner'
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleRulePartitioner896); 

                        	newLeafNode(otherlv_1, grammarAccess.getRulePartitionerAccess().getRule_partitionerKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleRulePartitioner909); 

                	newLeafNode(otherlv_2, grammarAccess.getRulePartitionerAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:433:1: ( (lv_rules_3_0= ruleParitionRule ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=37 && LA7_0<=38)||(LA7_0>=42 && LA7_0<=43)||(LA7_0>=46 && LA7_0<=47)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:434:1: (lv_rules_3_0= ruleParitionRule )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:434:1: (lv_rules_3_0= ruleParitionRule )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:435:3: lv_rules_3_0= ruleParitionRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRulePartitionerAccess().getRulesParitionRuleParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParitionRule_in_ruleRulePartitioner930);
            	    lv_rules_3_0=ruleParitionRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRulePartitionerRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_3_0, 
            	            		"ParitionRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleRulePartitioner943); 

                	newLeafNode(otherlv_4, grammarAccess.getRulePartitionerAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRulePartitioner"


    // $ANTLR start "entryRuleJSParitioner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:463:1: entryRuleJSParitioner returns [EObject current=null] : iv_ruleJSParitioner= ruleJSParitioner EOF ;
    public final EObject entryRuleJSParitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSParitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:464:2: (iv_ruleJSParitioner= ruleJSParitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:465:2: iv_ruleJSParitioner= ruleJSParitioner EOF
            {
             newCompositeNode(grammarAccess.getJSParitionerRule()); 
            pushFollow(FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner979);
            iv_ruleJSParitioner=ruleJSParitioner();

            state._fsp--;

             current =iv_ruleJSParitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSParitioner989); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSParitioner"


    // $ANTLR start "ruleJSParitioner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:472:1: ruleJSParitioner returns [EObject current=null] : ( (otherlv_0= 'js-partitioner' | otherlv_1= 'js_partitioner' ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleJSParitioner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:475:28: ( ( (otherlv_0= 'js-partitioner' | otherlv_1= 'js_partitioner' ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:476:1: ( (otherlv_0= 'js-partitioner' | otherlv_1= 'js_partitioner' ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:476:1: ( (otherlv_0= 'js-partitioner' | otherlv_1= 'js_partitioner' ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:476:2: (otherlv_0= 'js-partitioner' | otherlv_1= 'js_partitioner' ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:476:2: (otherlv_0= 'js-partitioner' | otherlv_1= 'js_partitioner' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            else if ( (LA8_0==25) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:476:4: otherlv_0= 'js-partitioner'
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleJSParitioner1027); 

                        	newLeafNode(otherlv_0, grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:481:7: otherlv_1= 'js_partitioner'
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleJSParitioner1045); 

                        	newLeafNode(otherlv_1, grammarAccess.getJSParitionerAccess().getJs_partitionerKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:485:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:486:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:486:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:487:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleJSParitioner1063); 

            			newLeafNode(lv_fileURI_2_0, grammarAccess.getJSParitionerAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getJSParitionerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fileURI",
                    		lv_fileURI_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSParitioner"


    // $ANTLR start "entryRuleDamager"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:511:1: entryRuleDamager returns [EObject current=null] : iv_ruleDamager= ruleDamager EOF ;
    public final EObject entryRuleDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:512:2: (iv_ruleDamager= ruleDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:513:2: iv_ruleDamager= ruleDamager EOF
            {
             newCompositeNode(grammarAccess.getDamagerRule()); 
            pushFollow(FOLLOW_ruleDamager_in_entryRuleDamager1104);
            iv_ruleDamager=ruleDamager();

            state._fsp--;

             current =iv_ruleDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDamager1114); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDamager"


    // $ANTLR start "ruleDamager"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:520:1: ruleDamager returns [EObject current=null] : (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager ) ;
    public final EObject ruleDamager() throws RecognitionException {
        EObject current = null;

        EObject this_RuleDamager_0 = null;

        EObject this_JSDamager_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:523:28: ( (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:524:1: (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:524:1: (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=28 && LA9_0<=29)) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=26 && LA9_0<=27)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:525:5: this_RuleDamager_0= ruleRuleDamager
                    {
                     
                            newCompositeNode(grammarAccess.getDamagerAccess().getRuleDamagerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRuleDamager_in_ruleDamager1161);
                    this_RuleDamager_0=ruleRuleDamager();

                    state._fsp--;

                     
                            current = this_RuleDamager_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:535:5: this_JSDamager_1= ruleJSDamager
                    {
                     
                            newCompositeNode(grammarAccess.getDamagerAccess().getJSDamagerParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleJSDamager_in_ruleDamager1188);
                    this_JSDamager_1=ruleJSDamager();

                    state._fsp--;

                     
                            current = this_JSDamager_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDamager"


    // $ANTLR start "entryRuleJSDamager"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:551:1: entryRuleJSDamager returns [EObject current=null] : iv_ruleJSDamager= ruleJSDamager EOF ;
    public final EObject entryRuleJSDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:552:2: (iv_ruleJSDamager= ruleJSDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:553:2: iv_ruleJSDamager= ruleJSDamager EOF
            {
             newCompositeNode(grammarAccess.getJSDamagerRule()); 
            pushFollow(FOLLOW_ruleJSDamager_in_entryRuleJSDamager1223);
            iv_ruleJSDamager=ruleJSDamager();

            state._fsp--;

             current =iv_ruleJSDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSDamager1233); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSDamager"


    // $ANTLR start "ruleJSDamager"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:560:1: ruleJSDamager returns [EObject current=null] : ( (otherlv_0= 'js-damager' | otherlv_1= 'js_damager' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleJSDamager() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_fileURI_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:563:28: ( ( (otherlv_0= 'js-damager' | otherlv_1= 'js_damager' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:564:1: ( (otherlv_0= 'js-damager' | otherlv_1= 'js_damager' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:564:1: ( (otherlv_0= 'js-damager' | otherlv_1= 'js_damager' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:564:2: (otherlv_0= 'js-damager' | otherlv_1= 'js_damager' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:564:2: (otherlv_0= 'js-damager' | otherlv_1= 'js_damager' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==26) ) {
                alt10=1;
            }
            else if ( (LA10_0==27) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:564:4: otherlv_0= 'js-damager'
                    {
                    otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleJSDamager1271); 

                        	newLeafNode(otherlv_0, grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:569:7: otherlv_1= 'js_damager'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleJSDamager1289); 

                        	newLeafNode(otherlv_1, grammarAccess.getJSDamagerAccess().getJs_damagerKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:573:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:574:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:574:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:575:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJSDamagerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJSDamager1310); 

            		newLeafNode(otherlv_2, grammarAccess.getJSDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:586:2: ( (lv_fileURI_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:587:1: (lv_fileURI_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:587:1: (lv_fileURI_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:588:3: lv_fileURI_3_0= RULE_STRING
            {
            lv_fileURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleJSDamager1327); 

            			newLeafNode(lv_fileURI_3_0, grammarAccess.getJSDamagerAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getJSDamagerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fileURI",
                    		lv_fileURI_3_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSDamager"


    // $ANTLR start "entryRuleRuleDamager"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:612:1: entryRuleRuleDamager returns [EObject current=null] : iv_ruleRuleDamager= ruleRuleDamager EOF ;
    public final EObject entryRuleRuleDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:613:2: (iv_ruleRuleDamager= ruleRuleDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:614:2: iv_ruleRuleDamager= ruleRuleDamager EOF
            {
             newCompositeNode(grammarAccess.getRuleDamagerRule()); 
            pushFollow(FOLLOW_ruleRuleDamager_in_entryRuleRuleDamager1368);
            iv_ruleRuleDamager=ruleRuleDamager();

            state._fsp--;

             current =iv_ruleRuleDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDamager1378); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleDamager"


    // $ANTLR start "ruleRuleDamager"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:621:1: ruleRuleDamager returns [EObject current=null] : ( (otherlv_0= 'rule-damager' | otherlv_1= 'rule_damager' ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_tokens_4_0= ruleScannerToken ) )* ( (lv_keywordGroups_5_0= ruleKeywordGroup ) )* ( (lv_rules_6_0= ruleScannerRule ) )* otherlv_7= '}' ) ;
    public final EObject ruleRuleDamager() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_tokens_4_0 = null;

        EObject lv_keywordGroups_5_0 = null;

        EObject lv_rules_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:624:28: ( ( (otherlv_0= 'rule-damager' | otherlv_1= 'rule_damager' ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_tokens_4_0= ruleScannerToken ) )* ( (lv_keywordGroups_5_0= ruleKeywordGroup ) )* ( (lv_rules_6_0= ruleScannerRule ) )* otherlv_7= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:625:1: ( (otherlv_0= 'rule-damager' | otherlv_1= 'rule_damager' ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_tokens_4_0= ruleScannerToken ) )* ( (lv_keywordGroups_5_0= ruleKeywordGroup ) )* ( (lv_rules_6_0= ruleScannerRule ) )* otherlv_7= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:625:1: ( (otherlv_0= 'rule-damager' | otherlv_1= 'rule_damager' ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_tokens_4_0= ruleScannerToken ) )* ( (lv_keywordGroups_5_0= ruleKeywordGroup ) )* ( (lv_rules_6_0= ruleScannerRule ) )* otherlv_7= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:625:2: (otherlv_0= 'rule-damager' | otherlv_1= 'rule_damager' ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_tokens_4_0= ruleScannerToken ) )* ( (lv_keywordGroups_5_0= ruleKeywordGroup ) )* ( (lv_rules_6_0= ruleScannerRule ) )* otherlv_7= '}'
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:625:2: (otherlv_0= 'rule-damager' | otherlv_1= 'rule_damager' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            else if ( (LA11_0==29) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:625:4: otherlv_0= 'rule-damager'
                    {
                    otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleRuleDamager1416); 

                        	newLeafNode(otherlv_0, grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:630:7: otherlv_1= 'rule_damager'
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleRuleDamager1434); 

                        	newLeafNode(otherlv_1, grammarAccess.getRuleDamagerAccess().getRule_damagerKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:634:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:635:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:635:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:636:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleDamagerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleDamager1455); 

            		newLeafNode(otherlv_2, grammarAccess.getRuleDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,11,FOLLOW_11_in_ruleRuleDamager1467); 

                	newLeafNode(otherlv_3, grammarAccess.getRuleDamagerAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:651:1: ( (lv_tokens_4_0= ruleScannerToken ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=30 && LA12_0<=31)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:652:1: (lv_tokens_4_0= ruleScannerToken )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:652:1: (lv_tokens_4_0= ruleScannerToken )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:653:3: lv_tokens_4_0= ruleScannerToken
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getTokensScannerTokenParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScannerToken_in_ruleRuleDamager1488);
            	    lv_tokens_4_0=ruleScannerToken();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRuleDamagerRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"tokens",
            	            		lv_tokens_4_0, 
            	            		"ScannerToken");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:669:3: ( (lv_keywordGroups_5_0= ruleKeywordGroup ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==32) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:670:1: (lv_keywordGroups_5_0= ruleKeywordGroup )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:670:1: (lv_keywordGroups_5_0= ruleKeywordGroup )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:671:3: lv_keywordGroups_5_0= ruleKeywordGroup
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeywordGroup_in_ruleRuleDamager1510);
            	    lv_keywordGroups_5_0=ruleKeywordGroup();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRuleDamagerRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"keywordGroups",
            	            		lv_keywordGroups_5_0, 
            	            		"KeywordGroup");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:687:3: ( (lv_rules_6_0= ruleScannerRule ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=37 && LA14_0<=38)||(LA14_0>=42 && LA14_0<=49)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:688:1: (lv_rules_6_0= ruleScannerRule )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:688:1: (lv_rules_6_0= ruleScannerRule )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:689:3: lv_rules_6_0= ruleScannerRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getRulesScannerRuleParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScannerRule_in_ruleRuleDamager1532);
            	    lv_rules_6_0=ruleScannerRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRuleDamagerRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_6_0, 
            	            		"ScannerRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_7=(Token)match(input,12,FOLLOW_12_in_ruleRuleDamager1545); 

                	newLeafNode(otherlv_7, grammarAccess.getRuleDamagerAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleDamager"


    // $ANTLR start "entryRuleScannerToken"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:717:1: entryRuleScannerToken returns [EObject current=null] : iv_ruleScannerToken= ruleScannerToken EOF ;
    public final EObject entryRuleScannerToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerToken = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:718:2: (iv_ruleScannerToken= ruleScannerToken EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:719:2: iv_ruleScannerToken= ruleScannerToken EOF
            {
             newCompositeNode(grammarAccess.getScannerTokenRule()); 
            pushFollow(FOLLOW_ruleScannerToken_in_entryRuleScannerToken1581);
            iv_ruleScannerToken=ruleScannerToken();

            state._fsp--;

             current =iv_ruleScannerToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerToken1591); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScannerToken"


    // $ANTLR start "ruleScannerToken"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:726:1: ruleScannerToken returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleScannerToken() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:729:28: ( ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:730:1: ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:730:1: ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:730:2: ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:730:2: ( (lv_default_0_0= 'default' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==30) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:731:1: (lv_default_0_0= 'default' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:731:1: (lv_default_0_0= 'default' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:732:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,30,FOLLOW_30_in_ruleScannerToken1634); 

                            newLeafNode(lv_default_0_0, grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerTokenRule());
                    	        }
                           		setWithLastConsumed(current, "default", true, "default");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleScannerToken1660); 

                	newLeafNode(otherlv_1, grammarAccess.getScannerTokenAccess().getTokenKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:749:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:750:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:750:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:751:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerToken1677); 

            			newLeafNode(lv_name_2_0, grammarAccess.getScannerTokenAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerTokenRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScannerToken"


    // $ANTLR start "entryRuleKeywordGroup"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:775:1: entryRuleKeywordGroup returns [EObject current=null] : iv_ruleKeywordGroup= ruleKeywordGroup EOF ;
    public final EObject entryRuleKeywordGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordGroup = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:776:2: (iv_ruleKeywordGroup= ruleKeywordGroup EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:777:2: iv_ruleKeywordGroup= ruleKeywordGroup EOF
            {
             newCompositeNode(grammarAccess.getKeywordGroupRule()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup1718);
            iv_ruleKeywordGroup=ruleKeywordGroup();

            state._fsp--;

             current =iv_ruleKeywordGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordGroup1728); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordGroup"


    // $ANTLR start "ruleKeywordGroup"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:784:1: ruleKeywordGroup returns [EObject current=null] : (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' ) ;
    public final EObject ruleKeywordGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_keywords_3_0 = null;

        EObject lv_keywords_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:787:28: ( (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:788:1: (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:788:1: (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:788:3: otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleKeywordGroup1765); 

                	newLeafNode(otherlv_0, grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:792:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:793:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:793:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:794:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getKeywordGroupRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeywordGroup1785); 

            		newLeafNode(otherlv_1, grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleKeywordGroup1797); 

                	newLeafNode(otherlv_2, grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:809:1: ( (lv_keywords_3_0= ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:810:1: (lv_keywords_3_0= ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:810:1: (lv_keywords_3_0= ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:811:3: lv_keywords_3_0= ruleKeyword
            {
             
            	        newCompositeNode(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleKeyword_in_ruleKeywordGroup1818);
            lv_keywords_3_0=ruleKeyword();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getKeywordGroupRule());
            	        }
                   		add(
                   			current, 
                   			"keywords",
                    		lv_keywords_3_0, 
                    		"Keyword");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:827:2: (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==34) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:827:4: otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) )
            	    {
            	    otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleKeywordGroup1831); 

            	        	newLeafNode(otherlv_4, grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0());
            	        
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:831:1: ( (lv_keywords_5_0= ruleKeyword ) )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:832:1: (lv_keywords_5_0= ruleKeyword )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:832:1: (lv_keywords_5_0= ruleKeyword )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:833:3: lv_keywords_5_0= ruleKeyword
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeyword_in_ruleKeywordGroup1852);
            	    lv_keywords_5_0=ruleKeyword();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getKeywordGroupRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"keywords",
            	            		lv_keywords_5_0, 
            	            		"Keyword");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_6=(Token)match(input,35,FOLLOW_35_in_ruleKeywordGroup1866); 

                	newLeafNode(otherlv_6, grammarAccess.getKeywordGroupAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordGroup"


    // $ANTLR start "entryRuleKeyword"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:861:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:862:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:863:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword1902);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword1912); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:870:1: ruleKeyword returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_version_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:873:28: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:874:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:874:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:874:2: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:874:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:875:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:875:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:876:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1954); 

            			newLeafNode(lv_name_0_0, grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeywordRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:892:2: (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==36) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:892:4: otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleKeyword1972); 

                        	newLeafNode(otherlv_1, grammarAccess.getKeywordAccess().getSinceKeyword_1_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:896:1: ( (lv_version_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:897:1: (lv_version_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:897:1: (lv_version_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:898:3: lv_version_2_0= RULE_STRING
                    {
                    lv_version_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1989); 

                    			newLeafNode(lv_version_2_0, grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"version",
                            		lv_version_2_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleScannerRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:922:1: entryRuleScannerRule returns [EObject current=null] : iv_ruleScannerRule= ruleScannerRule EOF ;
    public final EObject entryRuleScannerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:923:2: (iv_ruleScannerRule= ruleScannerRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:924:2: iv_ruleScannerRule= ruleScannerRule EOF
            {
             newCompositeNode(grammarAccess.getScannerRuleRule()); 
            pushFollow(FOLLOW_ruleScannerRule_in_entryRuleScannerRule2032);
            iv_ruleScannerRule=ruleScannerRule();

            state._fsp--;

             current =iv_ruleScannerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerRule2042); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScannerRule"


    // $ANTLR start "ruleScannerRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:931:1: ruleScannerRule returns [EObject current=null] : (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule ) ;
    public final EObject ruleScannerRule() throws RecognitionException {
        EObject current = null;

        EObject this_ScannerSingleLineRule_0 = null;

        EObject this_ScannerMultiLineRule_1 = null;

        EObject this_ScannerCharacterRule_2 = null;

        EObject this_ScannerJSRule_3 = null;

        EObject this_ScannerWhitespaceRule_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:934:28: ( (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:935:1: (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:935:1: (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule )
            int alt18=5;
            switch ( input.LA(1) ) {
            case 37:
            case 38:
                {
                alt18=1;
                }
                break;
            case 42:
            case 43:
                {
                alt18=2;
                }
                break;
            case 44:
            case 45:
                {
                alt18=3;
                }
                break;
            case 46:
            case 47:
                {
                alt18=4;
                }
                break;
            case 48:
            case 49:
                {
                alt18=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:936:5: this_ScannerSingleLineRule_0= ruleScannerSingleLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleScannerSingleLineRule_in_ruleScannerRule2089);
                    this_ScannerSingleLineRule_0=ruleScannerSingleLineRule();

                    state._fsp--;

                     
                            current = this_ScannerSingleLineRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:946:5: this_ScannerMultiLineRule_1= ruleScannerMultiLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleScannerMultiLineRule_in_ruleScannerRule2116);
                    this_ScannerMultiLineRule_1=ruleScannerMultiLineRule();

                    state._fsp--;

                     
                            current = this_ScannerMultiLineRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:956:5: this_ScannerCharacterRule_2= ruleScannerCharacterRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleScannerCharacterRule_in_ruleScannerRule2143);
                    this_ScannerCharacterRule_2=ruleScannerCharacterRule();

                    state._fsp--;

                     
                            current = this_ScannerCharacterRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:966:5: this_ScannerJSRule_3= ruleScannerJSRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleScannerJSRule_in_ruleScannerRule2170);
                    this_ScannerJSRule_3=ruleScannerJSRule();

                    state._fsp--;

                     
                            current = this_ScannerJSRule_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:976:5: this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerWhitespaceRuleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_ruleScannerRule2197);
                    this_ScannerWhitespaceRule_4=ruleScannerWhitespaceRule();

                    state._fsp--;

                     
                            current = this_ScannerWhitespaceRule_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScannerRule"


    // $ANTLR start "entryRuleParitionRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:992:1: entryRuleParitionRule returns [EObject current=null] : iv_ruleParitionRule= ruleParitionRule EOF ;
    public final EObject entryRuleParitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitionRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:993:2: (iv_ruleParitionRule= ruleParitionRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:994:2: iv_ruleParitionRule= ruleParitionRule EOF
            {
             newCompositeNode(grammarAccess.getParitionRuleRule()); 
            pushFollow(FOLLOW_ruleParitionRule_in_entryRuleParitionRule2232);
            iv_ruleParitionRule=ruleParitionRule();

            state._fsp--;

             current =iv_ruleParitionRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitionRule2242); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParitionRule"


    // $ANTLR start "ruleParitionRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1001:1: ruleParitionRule returns [EObject current=null] : (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule ) ;
    public final EObject ruleParitionRule() throws RecognitionException {
        EObject current = null;

        EObject this_PartitionSingleLineRule_0 = null;

        EObject this_PartitionMultiLineRule_1 = null;

        EObject this_PartitionJSRule_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1004:28: ( (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1005:1: (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1005:1: (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 37:
            case 38:
                {
                alt19=1;
                }
                break;
            case 42:
            case 43:
                {
                alt19=2;
                }
                break;
            case 46:
            case 47:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1006:5: this_PartitionSingleLineRule_0= rulePartitionSingleLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePartitionSingleLineRule_in_ruleParitionRule2289);
                    this_PartitionSingleLineRule_0=rulePartitionSingleLineRule();

                    state._fsp--;

                     
                            current = this_PartitionSingleLineRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1016:5: this_PartitionMultiLineRule_1= rulePartitionMultiLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePartitionMultiLineRule_in_ruleParitionRule2316);
                    this_PartitionMultiLineRule_1=rulePartitionMultiLineRule();

                    state._fsp--;

                     
                            current = this_PartitionMultiLineRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1026:5: this_PartitionJSRule_2= rulePartitionJSRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionJSRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePartitionJSRule_in_ruleParitionRule2343);
                    this_PartitionJSRule_2=rulePartitionJSRule();

                    state._fsp--;

                     
                            current = this_PartitionJSRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParitionRule"


    // $ANTLR start "entryRuleScannerSingleLineRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1042:1: entryRuleScannerSingleLineRule returns [EObject current=null] : iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF ;
    public final EObject entryRuleScannerSingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerSingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1043:2: (iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1044:2: iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF
            {
             newCompositeNode(grammarAccess.getScannerSingleLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule2378);
            iv_ruleScannerSingleLineRule=ruleScannerSingleLineRule();

            state._fsp--;

             current =iv_ruleScannerSingleLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerSingleLineRule2388); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScannerSingleLineRule"


    // $ANTLR start "ruleScannerSingleLineRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1051:1: ruleScannerSingleLineRule returns [EObject current=null] : ( (otherlv_0= 'single-line' | otherlv_1= 'single_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleScannerSingleLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_startSeq_3_0=null;
        Token otherlv_4=null;
        Token lv_endSeq_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_escapeSeq_8_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1054:28: ( ( (otherlv_0= 'single-line' | otherlv_1= 'single_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1055:1: ( (otherlv_0= 'single-line' | otherlv_1= 'single_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1055:1: ( (otherlv_0= 'single-line' | otherlv_1= 'single_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1055:2: (otherlv_0= 'single-line' | otherlv_1= 'single_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1055:2: (otherlv_0= 'single-line' | otherlv_1= 'single_line' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==37) ) {
                alt20=1;
            }
            else if ( (LA20_0==38) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1055:4: otherlv_0= 'single-line'
                    {
                    otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleScannerSingleLineRule2426); 

                        	newLeafNode(otherlv_0, grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1060:7: otherlv_1= 'single_line'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleScannerSingleLineRule2444); 

                        	newLeafNode(otherlv_1, grammarAccess.getScannerSingleLineRuleAccess().getSingle_lineKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1064:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1065:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1065:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1066:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerSingleLineRule2465); 

            		newLeafNode(otherlv_2, grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1077:2: ( (lv_startSeq_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1078:1: (lv_startSeq_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1078:1: (lv_startSeq_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1079:3: lv_startSeq_3_0= RULE_STRING
            {
            lv_startSeq_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2482); 

            			newLeafNode(lv_startSeq_3_0, grammarAccess.getScannerSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"startSeq",
                    		lv_startSeq_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleScannerSingleLineRule2499); 

                	newLeafNode(otherlv_4, grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1099:1: ( (lv_endSeq_5_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1100:1: (lv_endSeq_5_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1100:1: (lv_endSeq_5_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1101:3: lv_endSeq_5_0= RULE_STRING
            {
            lv_endSeq_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2516); 

            			newLeafNode(lv_endSeq_5_0, grammarAccess.getScannerSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"endSeq",
                    		lv_endSeq_5_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1117:2: (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==40) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1117:4: otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,40,FOLLOW_40_in_ruleScannerSingleLineRule2534); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,41,FOLLOW_41_in_ruleScannerSingleLineRule2546); 

                        	newLeafNode(otherlv_7, grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1125:1: ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1126:1: (lv_escapeSeq_8_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1126:1: (lv_escapeSeq_8_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1127:3: lv_escapeSeq_8_0= RULE_STRING
                    {
                    lv_escapeSeq_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2563); 

                    			newLeafNode(lv_escapeSeq_8_0, grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"escapeSeq",
                            		lv_escapeSeq_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScannerSingleLineRule"


    // $ANTLR start "entryRulePartitionSingleLineRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1151:1: entryRulePartitionSingleLineRule returns [EObject current=null] : iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF ;
    public final EObject entryRulePartitionSingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionSingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1152:2: (iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1153:2: iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionSingleLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule2606);
            iv_rulePartitionSingleLineRule=rulePartitionSingleLineRule();

            state._fsp--;

             current =iv_rulePartitionSingleLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionSingleLineRule2616); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePartitionSingleLineRule"


    // $ANTLR start "rulePartitionSingleLineRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1160:1: rulePartitionSingleLineRule returns [EObject current=null] : ( (otherlv_0= 'single-line' | otherlv_1= 'single_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) ;
    public final EObject rulePartitionSingleLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_startSeq_3_0=null;
        Token otherlv_4=null;
        Token lv_endSeq_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_escapeSeq_8_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1163:28: ( ( (otherlv_0= 'single-line' | otherlv_1= 'single_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1164:1: ( (otherlv_0= 'single-line' | otherlv_1= 'single_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1164:1: ( (otherlv_0= 'single-line' | otherlv_1= 'single_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1164:2: (otherlv_0= 'single-line' | otherlv_1= 'single_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1164:2: (otherlv_0= 'single-line' | otherlv_1= 'single_line' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==37) ) {
                alt22=1;
            }
            else if ( (LA22_0==38) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1164:4: otherlv_0= 'single-line'
                    {
                    otherlv_0=(Token)match(input,37,FOLLOW_37_in_rulePartitionSingleLineRule2654); 

                        	newLeafNode(otherlv_0, grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1169:7: otherlv_1= 'single_line'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_rulePartitionSingleLineRule2672); 

                        	newLeafNode(otherlv_1, grammarAccess.getPartitionSingleLineRuleAccess().getSingle_lineKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1173:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1174:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1174:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1175:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionSingleLineRule2693); 

            		newLeafNode(otherlv_2, grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1186:2: ( (lv_startSeq_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1187:1: (lv_startSeq_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1187:1: (lv_startSeq_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1188:3: lv_startSeq_3_0= RULE_STRING
            {
            lv_startSeq_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2710); 

            			newLeafNode(lv_startSeq_3_0, grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"startSeq",
                    		lv_startSeq_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_39_in_rulePartitionSingleLineRule2727); 

                	newLeafNode(otherlv_4, grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1208:1: ( (lv_endSeq_5_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1209:1: (lv_endSeq_5_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1209:1: (lv_endSeq_5_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1210:3: lv_endSeq_5_0= RULE_STRING
            {
            lv_endSeq_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2744); 

            			newLeafNode(lv_endSeq_5_0, grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"endSeq",
                    		lv_endSeq_5_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1226:2: (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==40) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1226:4: otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,40,FOLLOW_40_in_rulePartitionSingleLineRule2762); 

                        	newLeafNode(otherlv_6, grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,41,FOLLOW_41_in_rulePartitionSingleLineRule2774); 

                        	newLeafNode(otherlv_7, grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1234:1: ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1235:1: (lv_escapeSeq_8_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1235:1: (lv_escapeSeq_8_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1236:3: lv_escapeSeq_8_0= RULE_STRING
                    {
                    lv_escapeSeq_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2791); 

                    			newLeafNode(lv_escapeSeq_8_0, grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"escapeSeq",
                            		lv_escapeSeq_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePartitionSingleLineRule"


    // $ANTLR start "entryRuleScannerMultiLineRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1260:1: entryRuleScannerMultiLineRule returns [EObject current=null] : iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF ;
    public final EObject entryRuleScannerMultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerMultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1261:2: (iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1262:2: iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF
            {
             newCompositeNode(grammarAccess.getScannerMultiLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule2834);
            iv_ruleScannerMultiLineRule=ruleScannerMultiLineRule();

            state._fsp--;

             current =iv_ruleScannerMultiLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerMultiLineRule2844); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScannerMultiLineRule"


    // $ANTLR start "ruleScannerMultiLineRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1269:1: ruleScannerMultiLineRule returns [EObject current=null] : ( (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleScannerMultiLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_startSeq_3_0=null;
        Token otherlv_4=null;
        Token lv_endSeq_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_escapeSeq_8_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1272:28: ( ( (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1273:1: ( (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1273:1: ( (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1273:2: (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1273:2: (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==42) ) {
                alt24=1;
            }
            else if ( (LA24_0==43) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1273:4: otherlv_0= 'multi-line'
                    {
                    otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleScannerMultiLineRule2882); 

                        	newLeafNode(otherlv_0, grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1278:7: otherlv_1= 'multi_line'
                    {
                    otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleScannerMultiLineRule2900); 

                        	newLeafNode(otherlv_1, grammarAccess.getScannerMultiLineRuleAccess().getMulti_lineKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1282:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1283:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1283:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1284:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerMultiLineRule2921); 

            		newLeafNode(otherlv_2, grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1295:2: ( (lv_startSeq_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1296:1: (lv_startSeq_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1296:1: (lv_startSeq_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1297:3: lv_startSeq_3_0= RULE_STRING
            {
            lv_startSeq_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2938); 

            			newLeafNode(lv_startSeq_3_0, grammarAccess.getScannerMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"startSeq",
                    		lv_startSeq_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleScannerMultiLineRule2955); 

                	newLeafNode(otherlv_4, grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1317:1: ( (lv_endSeq_5_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1318:1: (lv_endSeq_5_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1318:1: (lv_endSeq_5_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1319:3: lv_endSeq_5_0= RULE_STRING
            {
            lv_endSeq_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2972); 

            			newLeafNode(lv_endSeq_5_0, grammarAccess.getScannerMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"endSeq",
                    		lv_endSeq_5_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1335:2: (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==40) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1335:4: otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,40,FOLLOW_40_in_ruleScannerMultiLineRule2990); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,41,FOLLOW_41_in_ruleScannerMultiLineRule3002); 

                        	newLeafNode(otherlv_7, grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1343:1: ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1344:1: (lv_escapeSeq_8_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1344:1: (lv_escapeSeq_8_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1345:3: lv_escapeSeq_8_0= RULE_STRING
                    {
                    lv_escapeSeq_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule3019); 

                    			newLeafNode(lv_escapeSeq_8_0, grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"escapeSeq",
                            		lv_escapeSeq_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScannerMultiLineRule"


    // $ANTLR start "entryRulePartitionMultiLineRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1369:1: entryRulePartitionMultiLineRule returns [EObject current=null] : iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF ;
    public final EObject entryRulePartitionMultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionMultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1370:2: (iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1371:2: iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionMultiLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule3062);
            iv_rulePartitionMultiLineRule=rulePartitionMultiLineRule();

            state._fsp--;

             current =iv_rulePartitionMultiLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionMultiLineRule3072); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePartitionMultiLineRule"


    // $ANTLR start "rulePartitionMultiLineRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1378:1: rulePartitionMultiLineRule returns [EObject current=null] : ( (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) ;
    public final EObject rulePartitionMultiLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_startSeq_3_0=null;
        Token otherlv_4=null;
        Token lv_endSeq_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_escapeSeq_8_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1381:28: ( ( (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1382:1: ( (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1382:1: ( (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1382:2: (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' ) ( (otherlv_2= RULE_ID ) ) ( (lv_startSeq_3_0= RULE_STRING ) ) otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1382:2: (otherlv_0= 'multi-line' | otherlv_1= 'multi_line' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==42) ) {
                alt26=1;
            }
            else if ( (LA26_0==43) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1382:4: otherlv_0= 'multi-line'
                    {
                    otherlv_0=(Token)match(input,42,FOLLOW_42_in_rulePartitionMultiLineRule3110); 

                        	newLeafNode(otherlv_0, grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1387:7: otherlv_1= 'multi_line'
                    {
                    otherlv_1=(Token)match(input,43,FOLLOW_43_in_rulePartitionMultiLineRule3128); 

                        	newLeafNode(otherlv_1, grammarAccess.getPartitionMultiLineRuleAccess().getMulti_lineKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1391:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1392:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1392:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1393:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionMultiLineRule3149); 

            		newLeafNode(otherlv_2, grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1404:2: ( (lv_startSeq_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1405:1: (lv_startSeq_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1405:1: (lv_startSeq_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1406:3: lv_startSeq_3_0= RULE_STRING
            {
            lv_startSeq_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule3166); 

            			newLeafNode(lv_startSeq_3_0, grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"startSeq",
                    		lv_startSeq_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_39_in_rulePartitionMultiLineRule3183); 

                	newLeafNode(otherlv_4, grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1426:1: ( (lv_endSeq_5_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1427:1: (lv_endSeq_5_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1427:1: (lv_endSeq_5_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1428:3: lv_endSeq_5_0= RULE_STRING
            {
            lv_endSeq_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule3200); 

            			newLeafNode(lv_endSeq_5_0, grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"endSeq",
                    		lv_endSeq_5_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1444:2: (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1444:4: otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,40,FOLLOW_40_in_rulePartitionMultiLineRule3218); 

                        	newLeafNode(otherlv_6, grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,41,FOLLOW_41_in_rulePartitionMultiLineRule3230); 

                        	newLeafNode(otherlv_7, grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1452:1: ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1453:1: (lv_escapeSeq_8_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1453:1: (lv_escapeSeq_8_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1454:3: lv_escapeSeq_8_0= RULE_STRING
                    {
                    lv_escapeSeq_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule3247); 

                    			newLeafNode(lv_escapeSeq_8_0, grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"escapeSeq",
                            		lv_escapeSeq_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePartitionMultiLineRule"


    // $ANTLR start "entryRuleScannerCharacterRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1478:1: entryRuleScannerCharacterRule returns [EObject current=null] : iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF ;
    public final EObject entryRuleScannerCharacterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerCharacterRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1479:2: (iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1480:2: iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF
            {
             newCompositeNode(grammarAccess.getScannerCharacterRuleRule()); 
            pushFollow(FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule3290);
            iv_ruleScannerCharacterRule=ruleScannerCharacterRule();

            state._fsp--;

             current =iv_ruleScannerCharacterRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerCharacterRule3300); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScannerCharacterRule"


    // $ANTLR start "ruleScannerCharacterRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1487:1: ruleScannerCharacterRule returns [EObject current=null] : ( (otherlv_0= 'character-rule' | otherlv_1= 'character_rule' ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' ) ;
    public final EObject ruleScannerCharacterRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_characters_4_0=null;
        Token otherlv_5=null;
        Token lv_characters_6_0=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1490:28: ( ( (otherlv_0= 'character-rule' | otherlv_1= 'character_rule' ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1491:1: ( (otherlv_0= 'character-rule' | otherlv_1= 'character_rule' ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1491:1: ( (otherlv_0= 'character-rule' | otherlv_1= 'character_rule' ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1491:2: (otherlv_0= 'character-rule' | otherlv_1= 'character_rule' ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']'
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1491:2: (otherlv_0= 'character-rule' | otherlv_1= 'character_rule' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==44) ) {
                alt28=1;
            }
            else if ( (LA28_0==45) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1491:4: otherlv_0= 'character-rule'
                    {
                    otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleScannerCharacterRule3338); 

                        	newLeafNode(otherlv_0, grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1496:7: otherlv_1= 'character_rule'
                    {
                    otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleScannerCharacterRule3356); 

                        	newLeafNode(otherlv_1, grammarAccess.getScannerCharacterRuleAccess().getCharacter_ruleKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1500:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1501:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1501:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1502:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerCharacterRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerCharacterRule3377); 

            		newLeafNode(otherlv_2, grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleScannerCharacterRule3389); 

                	newLeafNode(otherlv_3, grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1517:1: ( (lv_characters_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1518:1: (lv_characters_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1518:1: (lv_characters_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1519:3: lv_characters_4_0= RULE_STRING
            {
            lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3406); 

            			newLeafNode(lv_characters_4_0, grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerCharacterRuleRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"characters",
                    		lv_characters_4_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1535:2: (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==34) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1535:4: otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleScannerCharacterRule3424); 

            	        	newLeafNode(otherlv_5, grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4_0());
            	        
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1539:1: ( (lv_characters_6_0= RULE_STRING ) )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1540:1: (lv_characters_6_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1540:1: (lv_characters_6_0= RULE_STRING )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1541:3: lv_characters_6_0= RULE_STRING
            	    {
            	    lv_characters_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3441); 

            	    			newLeafNode(lv_characters_6_0, grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_4_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getScannerCharacterRuleRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"characters",
            	            		lv_characters_6_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            otherlv_7=(Token)match(input,35,FOLLOW_35_in_ruleScannerCharacterRule3460); 

                	newLeafNode(otherlv_7, grammarAccess.getScannerCharacterRuleAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScannerCharacterRule"


    // $ANTLR start "entryRuleScannerJSRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1569:1: entryRuleScannerJSRule returns [EObject current=null] : iv_ruleScannerJSRule= ruleScannerJSRule EOF ;
    public final EObject entryRuleScannerJSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerJSRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1570:2: (iv_ruleScannerJSRule= ruleScannerJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1571:2: iv_ruleScannerJSRule= ruleScannerJSRule EOF
            {
             newCompositeNode(grammarAccess.getScannerJSRuleRule()); 
            pushFollow(FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule3496);
            iv_ruleScannerJSRule=ruleScannerJSRule();

            state._fsp--;

             current =iv_ruleScannerJSRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerJSRule3506); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScannerJSRule"


    // $ANTLR start "ruleScannerJSRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1578:1: ruleScannerJSRule returns [EObject current=null] : ( (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleScannerJSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_fileURI_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1581:28: ( ( (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1582:1: ( (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1582:1: ( (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1582:2: (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1582:2: (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==46) ) {
                alt30=1;
            }
            else if ( (LA30_0==47) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1582:4: otherlv_0= 'javascript-rule'
                    {
                    otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleScannerJSRule3544); 

                        	newLeafNode(otherlv_0, grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1587:7: otherlv_1= 'javascript_rule'
                    {
                    otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleScannerJSRule3562); 

                        	newLeafNode(otherlv_1, grammarAccess.getScannerJSRuleAccess().getJavascript_ruleKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1591:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1592:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1592:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1593:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerJSRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerJSRule3583); 

            		newLeafNode(otherlv_2, grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1604:2: ( (lv_fileURI_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1605:1: (lv_fileURI_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1605:1: (lv_fileURI_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1606:3: lv_fileURI_3_0= RULE_STRING
            {
            lv_fileURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerJSRule3600); 

            			newLeafNode(lv_fileURI_3_0, grammarAccess.getScannerJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerJSRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fileURI",
                    		lv_fileURI_3_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScannerJSRule"


    // $ANTLR start "entryRulePartitionJSRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1630:1: entryRulePartitionJSRule returns [EObject current=null] : iv_rulePartitionJSRule= rulePartitionJSRule EOF ;
    public final EObject entryRulePartitionJSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionJSRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1631:2: (iv_rulePartitionJSRule= rulePartitionJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1632:2: iv_rulePartitionJSRule= rulePartitionJSRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionJSRuleRule()); 
            pushFollow(FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule3641);
            iv_rulePartitionJSRule=rulePartitionJSRule();

            state._fsp--;

             current =iv_rulePartitionJSRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionJSRule3651); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePartitionJSRule"


    // $ANTLR start "rulePartitionJSRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1639:1: rulePartitionJSRule returns [EObject current=null] : ( (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) ) ;
    public final EObject rulePartitionJSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_fileURI_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1642:28: ( ( (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1643:1: ( (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1643:1: ( (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1643:2: (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' ) ( (otherlv_2= RULE_ID ) ) ( (lv_fileURI_3_0= RULE_STRING ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1643:2: (otherlv_0= 'javascript-rule' | otherlv_1= 'javascript_rule' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==46) ) {
                alt31=1;
            }
            else if ( (LA31_0==47) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1643:4: otherlv_0= 'javascript-rule'
                    {
                    otherlv_0=(Token)match(input,46,FOLLOW_46_in_rulePartitionJSRule3689); 

                        	newLeafNode(otherlv_0, grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1648:7: otherlv_1= 'javascript_rule'
                    {
                    otherlv_1=(Token)match(input,47,FOLLOW_47_in_rulePartitionJSRule3707); 

                        	newLeafNode(otherlv_1, grammarAccess.getPartitionJSRuleAccess().getJavascript_ruleKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1652:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1653:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1653:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1654:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionJSRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionJSRule3728); 

            		newLeafNode(otherlv_2, grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1665:2: ( (lv_fileURI_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1666:1: (lv_fileURI_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1666:1: (lv_fileURI_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1667:3: lv_fileURI_3_0= RULE_STRING
            {
            lv_fileURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionJSRule3745); 

            			newLeafNode(lv_fileURI_3_0, grammarAccess.getPartitionJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionJSRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fileURI",
                    		lv_fileURI_3_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePartitionJSRule"


    // $ANTLR start "entryRuleScannerWhitespaceRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1691:1: entryRuleScannerWhitespaceRule returns [EObject current=null] : iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF ;
    public final EObject entryRuleScannerWhitespaceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerWhitespaceRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1692:2: (iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1693:2: iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF
            {
             newCompositeNode(grammarAccess.getScannerWhitespaceRuleRule()); 
            pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule3786);
            iv_ruleScannerWhitespaceRule=ruleScannerWhitespaceRule();

            state._fsp--;

             current =iv_ruleScannerWhitespaceRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerWhitespaceRule3796); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScannerWhitespaceRule"


    // $ANTLR start "ruleScannerWhitespaceRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1700:1: ruleScannerWhitespaceRule returns [EObject current=null] : ( (otherlv_0= 'whitespace-rule' | otherlv_1= 'whitespace_rule' ) ( (otherlv_2= RULE_ID ) )? ( (otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' ) | ( (lv_javawhitespace_8_0= 'javawhitespace' ) ) | ( (lv_fileURI_9_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleScannerWhitespaceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_characters_4_0=null;
        Token otherlv_5=null;
        Token lv_characters_6_0=null;
        Token otherlv_7=null;
        Token lv_javawhitespace_8_0=null;
        Token lv_fileURI_9_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1703:28: ( ( (otherlv_0= 'whitespace-rule' | otherlv_1= 'whitespace_rule' ) ( (otherlv_2= RULE_ID ) )? ( (otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' ) | ( (lv_javawhitespace_8_0= 'javawhitespace' ) ) | ( (lv_fileURI_9_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1704:1: ( (otherlv_0= 'whitespace-rule' | otherlv_1= 'whitespace_rule' ) ( (otherlv_2= RULE_ID ) )? ( (otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' ) | ( (lv_javawhitespace_8_0= 'javawhitespace' ) ) | ( (lv_fileURI_9_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1704:1: ( (otherlv_0= 'whitespace-rule' | otherlv_1= 'whitespace_rule' ) ( (otherlv_2= RULE_ID ) )? ( (otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' ) | ( (lv_javawhitespace_8_0= 'javawhitespace' ) ) | ( (lv_fileURI_9_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1704:2: (otherlv_0= 'whitespace-rule' | otherlv_1= 'whitespace_rule' ) ( (otherlv_2= RULE_ID ) )? ( (otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' ) | ( (lv_javawhitespace_8_0= 'javawhitespace' ) ) | ( (lv_fileURI_9_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1704:2: (otherlv_0= 'whitespace-rule' | otherlv_1= 'whitespace_rule' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==48) ) {
                alt32=1;
            }
            else if ( (LA32_0==49) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1704:4: otherlv_0= 'whitespace-rule'
                    {
                    otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleScannerWhitespaceRule3834); 

                        	newLeafNode(otherlv_0, grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1709:7: otherlv_1= 'whitespace_rule'
                    {
                    otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleScannerWhitespaceRule3852); 

                        	newLeafNode(otherlv_1, grammarAccess.getScannerWhitespaceRuleAccess().getWhitespace_ruleKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1713:2: ( (otherlv_2= RULE_ID ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1714:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1714:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1715:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerWhitespaceRule3873); 

                    		newLeafNode(otherlv_2, grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1726:3: ( (otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' ) | ( (lv_javawhitespace_8_0= 'javawhitespace' ) ) | ( (lv_fileURI_9_0= RULE_STRING ) ) )
            int alt35=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt35=1;
                }
                break;
            case 50:
                {
                alt35=2;
                }
                break;
            case RULE_STRING:
                {
                alt35=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1726:4: (otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1726:4: (otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1726:6: otherlv_3= '[' ( (lv_characters_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )* otherlv_7= ']'
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleScannerWhitespaceRule3888); 

                        	newLeafNode(otherlv_3, grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_2_0_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1730:1: ( (lv_characters_4_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1731:1: (lv_characters_4_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1731:1: (lv_characters_4_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1732:3: lv_characters_4_0= RULE_STRING
                    {
                    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3905); 

                    			newLeafNode(lv_characters_4_0, grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"characters",
                            		lv_characters_4_0, 
                            		"STRING");
                    	    

                    }


                    }

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1748:2: (otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==34) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1748:4: otherlv_5= ',' ( (lv_characters_6_0= RULE_STRING ) )
                    	    {
                    	    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleScannerWhitespaceRule3923); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_2_0_2_0());
                    	        
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1752:1: ( (lv_characters_6_0= RULE_STRING ) )
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1753:1: (lv_characters_6_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1753:1: (lv_characters_6_0= RULE_STRING )
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1754:3: lv_characters_6_0= RULE_STRING
                    	    {
                    	    lv_characters_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3940); 

                    	    			newLeafNode(lv_characters_6_0, grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"characters",
                    	            		lv_characters_6_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,35,FOLLOW_35_in_ruleScannerWhitespaceRule3959); 

                        	newLeafNode(otherlv_7, grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_2_0_3());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1775:6: ( (lv_javawhitespace_8_0= 'javawhitespace' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1775:6: ( (lv_javawhitespace_8_0= 'javawhitespace' ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1776:1: (lv_javawhitespace_8_0= 'javawhitespace' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1776:1: (lv_javawhitespace_8_0= 'javawhitespace' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1777:3: lv_javawhitespace_8_0= 'javawhitespace'
                    {
                    lv_javawhitespace_8_0=(Token)match(input,50,FOLLOW_50_in_ruleScannerWhitespaceRule3984); 

                            newLeafNode(lv_javawhitespace_8_0, grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_2_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	        }
                           		setWithLastConsumed(current, "javawhitespace", true, "javawhitespace");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1791:6: ( (lv_fileURI_9_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1791:6: ( (lv_fileURI_9_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1792:1: (lv_fileURI_9_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1792:1: (lv_fileURI_9_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1793:3: lv_fileURI_9_0= RULE_STRING
                    {
                    lv_fileURI_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule4020); 

                    			newLeafNode(lv_fileURI_9_0, grammarAccess.getScannerWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_2_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"fileURI",
                            		lv_fileURI_9_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScannerWhitespaceRule"


    // $ANTLR start "entryRuleRGBColor"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1819:1: entryRuleRGBColor returns [EObject current=null] : iv_ruleRGBColor= ruleRGBColor EOF ;
    public final EObject entryRuleRGBColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRGBColor = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1820:2: (iv_ruleRGBColor= ruleRGBColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1821:2: iv_ruleRGBColor= ruleRGBColor EOF
            {
             newCompositeNode(grammarAccess.getRGBColorRule()); 
            pushFollow(FOLLOW_ruleRGBColor_in_entryRuleRGBColor4064);
            iv_ruleRGBColor=ruleRGBColor();

            state._fsp--;

             current =iv_ruleRGBColor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGBColor4074); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRGBColor"


    // $ANTLR start "ruleRGBColor"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1828:1: ruleRGBColor returns [EObject current=null] : (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' ) ;
    public final EObject ruleRGBColor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_r_2_0=null;
        Token otherlv_3=null;
        Token lv_g_4_0=null;
        Token otherlv_5=null;
        Token lv_b_6_0=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1831:28: ( (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1832:1: (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1832:1: (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1832:3: otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleRGBColor4111); 

                	newLeafNode(otherlv_0, grammarAccess.getRGBColorAccess().getRgbKeyword_0());
                
            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleRGBColor4123); 

                	newLeafNode(otherlv_1, grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1840:1: ( (lv_r_2_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1841:1: (lv_r_2_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1841:1: (lv_r_2_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1842:3: lv_r_2_0= RULE_INT
            {
            lv_r_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor4140); 

            			newLeafNode(lv_r_2_0, grammarAccess.getRGBColorAccess().getRINTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRGBColorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"r",
                    		lv_r_2_0, 
                    		"INT");
            	    

            }


            }

            otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleRGBColor4157); 

                	newLeafNode(otherlv_3, grammarAccess.getRGBColorAccess().getCommaKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1862:1: ( (lv_g_4_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1863:1: (lv_g_4_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1863:1: (lv_g_4_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1864:3: lv_g_4_0= RULE_INT
            {
            lv_g_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor4174); 

            			newLeafNode(lv_g_4_0, grammarAccess.getRGBColorAccess().getGINTTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRGBColorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"g",
                    		lv_g_4_0, 
                    		"INT");
            	    

            }


            }

            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleRGBColor4191); 

                	newLeafNode(otherlv_5, grammarAccess.getRGBColorAccess().getCommaKeyword_5());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1884:1: ( (lv_b_6_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1885:1: (lv_b_6_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1885:1: (lv_b_6_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1886:3: lv_b_6_0= RULE_INT
            {
            lv_b_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor4208); 

            			newLeafNode(lv_b_6_0, grammarAccess.getRGBColorAccess().getBINTTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRGBColorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"b",
                    		lv_b_6_0, 
                    		"INT");
            	    

            }


            }

            otherlv_7=(Token)match(input,53,FOLLOW_53_in_ruleRGBColor4225); 

                	newLeafNode(otherlv_7, grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRGBColor"


    // $ANTLR start "ruleFontType"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1916:1: ruleFontType returns [Enumerator current=null] : ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) ) ;
    public final Enumerator ruleFontType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1918:28: ( ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1919:1: ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1919:1: ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) )
            int alt36=4;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt36=1;
                }
                break;
            case 55:
                {
                alt36=2;
                }
                break;
            case 56:
                {
                alt36=3;
                }
                break;
            case 57:
                {
                alt36=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1919:2: (enumLiteral_0= 'bold' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1919:2: (enumLiteral_0= 'bold' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1919:4: enumLiteral_0= 'bold'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_54_in_ruleFontType4277); 

                            current = grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1925:6: (enumLiteral_1= 'italic' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1925:6: (enumLiteral_1= 'italic' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1925:8: enumLiteral_1= 'italic'
                    {
                    enumLiteral_1=(Token)match(input,55,FOLLOW_55_in_ruleFontType4294); 

                            current = grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1931:6: (enumLiteral_2= 'underline' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1931:6: (enumLiteral_2= 'underline' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1931:8: enumLiteral_2= 'underline'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_56_in_ruleFontType4311); 

                            current = grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1937:6: (enumLiteral_3= 'strike-through' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1937:6: (enumLiteral_3= 'strike-through' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1937:8: enumLiteral_3= 'strike-through'
                    {
                    enumLiteral_3=(Token)match(input,57,FOLLOW_57_in_ruleFontType4328); 

                            current = grammarAccess.getFontTypeAccess().getStrike_throughEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getFontTypeAccess().getStrike_throughEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFontType"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel127 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleModel144 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rulePartition_in_ruleModel165 = new BitSet(new long[]{0x000000003C004000L});
    public static final BitSet FOLLOW_ruleDamager_in_ruleModel187 = new BitSet(new long[]{0x000000003FC18000L});
    public static final BitSet FOLLOW_rulePartitioner_in_ruleModel209 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleModel221 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleModel233 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel250 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rulePartition_in_entryRulePartition292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rulePartition339 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_entryRulePartitioner397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_rulePartitioner454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaLikeParitioner_in_rulePartitioner481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_rulePartitioner508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaLikeParitioner_in_entryRuleJavaLikeParitioner543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaLikeParitioner553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleJavaLikeParitioner591 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_16_in_ruleJavaLikeParitioner609 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleJavaLikeParitioner622 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleJavaLikeParitioner634 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaLikeParitioner654 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleJavaLikeParitioner666 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaLikeParitioner686 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleJavaLikeParitioner698 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaLikeParitioner718 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleJavaLikeParitioner730 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaLikeParitioner750 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleJavaLikeParitioner762 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaLikeParitioner782 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleJavaLikeParitioner794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRulePartitioner840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleRulePartitioner878 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_23_in_ruleRulePartitioner896 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleRulePartitioner909 = new BitSet(new long[]{0x0000CC6000000000L});
    public static final BitSet FOLLOW_ruleParitionRule_in_ruleRulePartitioner930 = new BitSet(new long[]{0x0000CC6000001000L});
    public static final BitSet FOLLOW_12_in_ruleRulePartitioner943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSParitioner989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleJSParitioner1027 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_25_in_ruleJSParitioner1045 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJSParitioner1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDamager_in_entryRuleDamager1104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDamager1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_ruleDamager1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_ruleDamager1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_entryRuleJSDamager1223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSDamager1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleJSDamager1271 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_27_in_ruleJSDamager1289 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJSDamager1310 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJSDamager1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_entryRuleRuleDamager1368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDamager1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleRuleDamager1416 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_29_in_ruleRuleDamager1434 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleDamager1455 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleRuleDamager1467 = new BitSet(new long[]{0x0003FC61C0001000L});
    public static final BitSet FOLLOW_ruleScannerToken_in_ruleRuleDamager1488 = new BitSet(new long[]{0x0003FC61C0001000L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_ruleRuleDamager1510 = new BitSet(new long[]{0x0003FC6100001000L});
    public static final BitSet FOLLOW_ruleScannerRule_in_ruleRuleDamager1532 = new BitSet(new long[]{0x0003FC6000001000L});
    public static final BitSet FOLLOW_12_in_ruleRuleDamager1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_entryRuleScannerToken1581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerToken1591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleScannerToken1634 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleScannerToken1660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerToken1677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup1718 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordGroup1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleKeywordGroup1765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeywordGroup1785 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleKeywordGroup1797 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleKeywordGroup1818 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_34_in_ruleKeywordGroup1831 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleKeywordGroup1852 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_35_in_ruleKeywordGroup1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword1902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1954 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_ruleKeyword1972 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_entryRuleScannerRule2032 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerRule2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_ruleScannerRule2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_ruleScannerRule2116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_ruleScannerRule2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_ruleScannerRule2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_ruleScannerRule2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_entryRuleParitionRule2232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitionRule2242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_ruleParitionRule2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_ruleParitionRule2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_ruleParitionRule2343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule2378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerSingleLineRule2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleScannerSingleLineRule2426 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_38_in_ruleScannerSingleLineRule2444 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerSingleLineRule2465 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2482 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleScannerSingleLineRule2499 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2516 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleScannerSingleLineRule2534 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleScannerSingleLineRule2546 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule2606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionSingleLineRule2616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rulePartitionSingleLineRule2654 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_38_in_rulePartitionSingleLineRule2672 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionSingleLineRule2693 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2710 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_rulePartitionSingleLineRule2727 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2744 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_rulePartitionSingleLineRule2762 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_rulePartitionSingleLineRule2774 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule2834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerMultiLineRule2844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleScannerMultiLineRule2882 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_43_in_ruleScannerMultiLineRule2900 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerMultiLineRule2921 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2938 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleScannerMultiLineRule2955 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2972 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleScannerMultiLineRule2990 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleScannerMultiLineRule3002 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule3062 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionMultiLineRule3072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rulePartitionMultiLineRule3110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_43_in_rulePartitionMultiLineRule3128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionMultiLineRule3149 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule3166 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_rulePartitionMultiLineRule3183 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule3200 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_rulePartitionMultiLineRule3218 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_rulePartitionMultiLineRule3230 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule3247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule3290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerCharacterRule3300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleScannerCharacterRule3338 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_45_in_ruleScannerCharacterRule3356 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerCharacterRule3377 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleScannerCharacterRule3389 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3406 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_34_in_ruleScannerCharacterRule3424 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3441 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_35_in_ruleScannerCharacterRule3460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule3496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerJSRule3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleScannerJSRule3544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_47_in_ruleScannerJSRule3562 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerJSRule3583 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerJSRule3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule3641 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionJSRule3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rulePartitionJSRule3689 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_47_in_rulePartitionJSRule3707 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionJSRule3728 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionJSRule3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule3786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerWhitespaceRule3796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleScannerWhitespaceRule3834 = new BitSet(new long[]{0x0004000200000030L});
    public static final BitSet FOLLOW_49_in_ruleScannerWhitespaceRule3852 = new BitSet(new long[]{0x0004000200000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerWhitespaceRule3873 = new BitSet(new long[]{0x0004000200000020L});
    public static final BitSet FOLLOW_33_in_ruleScannerWhitespaceRule3888 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3905 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_34_in_ruleScannerWhitespaceRule3923 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3940 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_35_in_ruleScannerWhitespaceRule3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleScannerWhitespaceRule3984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_entryRuleRGBColor4064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGBColor4074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleRGBColor4111 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleRGBColor4123 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor4140 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleRGBColor4157 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor4174 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleRGBColor4191 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor4208 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleRGBColor4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleFontType4277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleFontType4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleFontType4311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleFontType4328 = new BitSet(new long[]{0x0000000000000002L});

}