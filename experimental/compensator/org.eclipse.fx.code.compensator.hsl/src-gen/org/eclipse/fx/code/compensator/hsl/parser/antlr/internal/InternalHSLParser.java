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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'for'", "'partition'", "'java-like-partitioner'", "'singlelinedoc'", "'multilinedoc'", "'javadoc'", "'char'", "'string'", "'rule-partitioner'", "'js-partitioner'", "'js-damager'", "'rule-damager'", "'default'", "'token'", "'keywords'", "'['", "','", "']'", "'since'", "'single-line'", "'=>'", "'escaped'", "'by'", "'multi-line'", "'character-rule'", "'javascript-rule'", "'whitespace-rule'", "'javawhitespace'", "'rgb'", "'('", "')'", "'bold'", "'italic'", "'underline'", "'strike-through'"
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

                if ( ((LA2_0>=23 && LA2_0<=24)) ) {
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
            case 21:
                {
                alt4=1;
                }
                break;
            case 15:
                {
                alt4=2;
                }
                break;
            case 22:
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:293:1: ruleJavaLikeParitioner returns [EObject current=null] : (otherlv_0= 'java-like-partitioner' otherlv_1= '{' otherlv_2= 'singlelinedoc' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'multilinedoc' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'javadoc' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'char' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'string' ( (otherlv_11= RULE_ID ) ) otherlv_12= '}' ) ;
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

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:296:28: ( (otherlv_0= 'java-like-partitioner' otherlv_1= '{' otherlv_2= 'singlelinedoc' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'multilinedoc' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'javadoc' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'char' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'string' ( (otherlv_11= RULE_ID ) ) otherlv_12= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:297:1: (otherlv_0= 'java-like-partitioner' otherlv_1= '{' otherlv_2= 'singlelinedoc' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'multilinedoc' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'javadoc' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'char' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'string' ( (otherlv_11= RULE_ID ) ) otherlv_12= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:297:1: (otherlv_0= 'java-like-partitioner' otherlv_1= '{' otherlv_2= 'singlelinedoc' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'multilinedoc' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'javadoc' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'char' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'string' ( (otherlv_11= RULE_ID ) ) otherlv_12= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:297:3: otherlv_0= 'java-like-partitioner' otherlv_1= '{' otherlv_2= 'singlelinedoc' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'multilinedoc' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'javadoc' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'char' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'string' ( (otherlv_11= RULE_ID ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleJavaLikeParitioner590); 

                	newLeafNode(otherlv_0, grammarAccess.getJavaLikeParitionerAccess().getJavaLikePartitionerKeyword_0());
                
            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleJavaLikeParitioner602); 

                	newLeafNode(otherlv_1, grammarAccess.getJavaLikeParitionerAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleJavaLikeParitioner614); 

                	newLeafNode(otherlv_2, grammarAccess.getJavaLikeParitionerAccess().getSinglelinedocKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:309:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:310:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:310:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:311:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaLikeParitionerRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaLikeParitioner634); 

            		newLeafNode(otherlv_3, grammarAccess.getJavaLikeParitionerAccess().getSingleLineDocParitionPartitionCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleJavaLikeParitioner646); 

                	newLeafNode(otherlv_4, grammarAccess.getJavaLikeParitionerAccess().getMultilinedocKeyword_4());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:326:1: ( (otherlv_5= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:327:1: (otherlv_5= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:327:1: (otherlv_5= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:328:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaLikeParitionerRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaLikeParitioner666); 

            		newLeafNode(otherlv_5, grammarAccess.getJavaLikeParitionerAccess().getMultiLineDocParitionPartitionCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleJavaLikeParitioner678); 

                	newLeafNode(otherlv_6, grammarAccess.getJavaLikeParitionerAccess().getJavadocKeyword_6());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:343:1: ( (otherlv_7= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:344:1: (otherlv_7= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:344:1: (otherlv_7= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:345:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaLikeParitionerRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaLikeParitioner698); 

            		newLeafNode(otherlv_7, grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionCrossReference_7_0()); 
            	

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleJavaLikeParitioner710); 

                	newLeafNode(otherlv_8, grammarAccess.getJavaLikeParitionerAccess().getCharKeyword_8());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:360:1: ( (otherlv_9= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:361:1: (otherlv_9= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:361:1: (otherlv_9= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:362:3: otherlv_9= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaLikeParitionerRule());
            	        }
                    
            otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaLikeParitioner730); 

            		newLeafNode(otherlv_9, grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionCrossReference_9_0()); 
            	

            }


            }

            otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleJavaLikeParitioner742); 

                	newLeafNode(otherlv_10, grammarAccess.getJavaLikeParitionerAccess().getStringKeyword_10());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:377:1: ( (otherlv_11= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:378:1: (otherlv_11= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:378:1: (otherlv_11= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:379:3: otherlv_11= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaLikeParitionerRule());
            	        }
                    
            otherlv_11=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJavaLikeParitioner762); 

            		newLeafNode(otherlv_11, grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionCrossReference_11_0()); 
            	

            }


            }

            otherlv_12=(Token)match(input,12,FOLLOW_12_in_ruleJavaLikeParitioner774); 

                	newLeafNode(otherlv_12, grammarAccess.getJavaLikeParitionerAccess().getRightCurlyBracketKeyword_12());
                

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:402:1: entryRuleRulePartitioner returns [EObject current=null] : iv_ruleRulePartitioner= ruleRulePartitioner EOF ;
    public final EObject entryRuleRulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRulePartitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:403:2: (iv_ruleRulePartitioner= ruleRulePartitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:404:2: iv_ruleRulePartitioner= ruleRulePartitioner EOF
            {
             newCompositeNode(grammarAccess.getRulePartitionerRule()); 
            pushFollow(FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner810);
            iv_ruleRulePartitioner=ruleRulePartitioner();

            state._fsp--;

             current =iv_ruleRulePartitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRulePartitioner820); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:411:1: ruleRulePartitioner returns [EObject current=null] : (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' ) ;
    public final EObject ruleRulePartitioner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_rules_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:414:28: ( (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:415:1: (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:415:1: (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:415:3: otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleRulePartitioner857); 

                	newLeafNode(otherlv_0, grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0());
                
            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleRulePartitioner869); 

                	newLeafNode(otherlv_1, grammarAccess.getRulePartitionerAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:423:1: ( (lv_rules_2_0= ruleParitionRule ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==32||LA5_0==36||LA5_0==38) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:424:1: (lv_rules_2_0= ruleParitionRule )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:424:1: (lv_rules_2_0= ruleParitionRule )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:425:3: lv_rules_2_0= ruleParitionRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRulePartitionerAccess().getRulesParitionRuleParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParitionRule_in_ruleRulePartitioner890);
            	    lv_rules_2_0=ruleParitionRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRulePartitionerRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_2_0, 
            	            		"ParitionRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleRulePartitioner903); 

                	newLeafNode(otherlv_3, grammarAccess.getRulePartitionerAccess().getRightCurlyBracketKeyword_3());
                

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:453:1: entryRuleJSParitioner returns [EObject current=null] : iv_ruleJSParitioner= ruleJSParitioner EOF ;
    public final EObject entryRuleJSParitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSParitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:454:2: (iv_ruleJSParitioner= ruleJSParitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:455:2: iv_ruleJSParitioner= ruleJSParitioner EOF
            {
             newCompositeNode(grammarAccess.getJSParitionerRule()); 
            pushFollow(FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner939);
            iv_ruleJSParitioner=ruleJSParitioner();

            state._fsp--;

             current =iv_ruleJSParitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSParitioner949); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:462:1: ruleJSParitioner returns [EObject current=null] : (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleJSParitioner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fileURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:465:28: ( (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:466:1: (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:466:1: (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:466:3: otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleJSParitioner986); 

                	newLeafNode(otherlv_0, grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:470:1: ( (lv_fileURI_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:471:1: (lv_fileURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:471:1: (lv_fileURI_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:472:3: lv_fileURI_1_0= RULE_STRING
            {
            lv_fileURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleJSParitioner1003); 

            			newLeafNode(lv_fileURI_1_0, grammarAccess.getJSParitionerAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getJSParitionerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fileURI",
                    		lv_fileURI_1_0, 
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:496:1: entryRuleDamager returns [EObject current=null] : iv_ruleDamager= ruleDamager EOF ;
    public final EObject entryRuleDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:497:2: (iv_ruleDamager= ruleDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:498:2: iv_ruleDamager= ruleDamager EOF
            {
             newCompositeNode(grammarAccess.getDamagerRule()); 
            pushFollow(FOLLOW_ruleDamager_in_entryRuleDamager1044);
            iv_ruleDamager=ruleDamager();

            state._fsp--;

             current =iv_ruleDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDamager1054); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:505:1: ruleDamager returns [EObject current=null] : (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager ) ;
    public final EObject ruleDamager() throws RecognitionException {
        EObject current = null;

        EObject this_RuleDamager_0 = null;

        EObject this_JSDamager_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:508:28: ( (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:509:1: (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:509:1: (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
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
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:510:5: this_RuleDamager_0= ruleRuleDamager
                    {
                     
                            newCompositeNode(grammarAccess.getDamagerAccess().getRuleDamagerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRuleDamager_in_ruleDamager1101);
                    this_RuleDamager_0=ruleRuleDamager();

                    state._fsp--;

                     
                            current = this_RuleDamager_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:520:5: this_JSDamager_1= ruleJSDamager
                    {
                     
                            newCompositeNode(grammarAccess.getDamagerAccess().getJSDamagerParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleJSDamager_in_ruleDamager1128);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:536:1: entryRuleJSDamager returns [EObject current=null] : iv_ruleJSDamager= ruleJSDamager EOF ;
    public final EObject entryRuleJSDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:537:2: (iv_ruleJSDamager= ruleJSDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:538:2: iv_ruleJSDamager= ruleJSDamager EOF
            {
             newCompositeNode(grammarAccess.getJSDamagerRule()); 
            pushFollow(FOLLOW_ruleJSDamager_in_entryRuleJSDamager1163);
            iv_ruleJSDamager=ruleJSDamager();

            state._fsp--;

             current =iv_ruleJSDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSDamager1173); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:545:1: ruleJSDamager returns [EObject current=null] : (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleJSDamager() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:548:28: ( (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:549:1: (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:549:1: (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:549:3: otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleJSDamager1210); 

                	newLeafNode(otherlv_0, grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:553:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:554:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:554:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:555:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJSDamagerRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJSDamager1230); 

            		newLeafNode(otherlv_1, grammarAccess.getJSDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:566:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:567:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:567:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:568:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleJSDamager1247); 

            			newLeafNode(lv_fileURI_2_0, grammarAccess.getJSDamagerAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getJSDamagerRule());
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
    // $ANTLR end "ruleJSDamager"


    // $ANTLR start "entryRuleRuleDamager"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:592:1: entryRuleRuleDamager returns [EObject current=null] : iv_ruleRuleDamager= ruleRuleDamager EOF ;
    public final EObject entryRuleRuleDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:593:2: (iv_ruleRuleDamager= ruleRuleDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:594:2: iv_ruleRuleDamager= ruleRuleDamager EOF
            {
             newCompositeNode(grammarAccess.getRuleDamagerRule()); 
            pushFollow(FOLLOW_ruleRuleDamager_in_entryRuleRuleDamager1288);
            iv_ruleRuleDamager=ruleRuleDamager();

            state._fsp--;

             current =iv_ruleRuleDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDamager1298); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:601:1: ruleRuleDamager returns [EObject current=null] : (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )* otherlv_6= '}' ) ;
    public final EObject ruleRuleDamager() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_tokens_3_0 = null;

        EObject lv_keywordGroups_4_0 = null;

        EObject lv_rules_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:604:28: ( (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )* otherlv_6= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:605:1: (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:605:1: (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )* otherlv_6= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:605:3: otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleRuleDamager1335); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:609:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:610:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:610:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:611:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleDamagerRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleDamager1355); 

            		newLeafNode(otherlv_1, grammarAccess.getRuleDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleRuleDamager1367); 

                	newLeafNode(otherlv_2, grammarAccess.getRuleDamagerAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:626:1: ( (lv_tokens_3_0= ruleScannerToken ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=25 && LA7_0<=26)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:627:1: (lv_tokens_3_0= ruleScannerToken )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:627:1: (lv_tokens_3_0= ruleScannerToken )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:628:3: lv_tokens_3_0= ruleScannerToken
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getTokensScannerTokenParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScannerToken_in_ruleRuleDamager1388);
            	    lv_tokens_3_0=ruleScannerToken();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRuleDamagerRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"tokens",
            	            		lv_tokens_3_0, 
            	            		"ScannerToken");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:644:3: ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==27) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:645:1: (lv_keywordGroups_4_0= ruleKeywordGroup )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:645:1: (lv_keywordGroups_4_0= ruleKeywordGroup )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:646:3: lv_keywordGroups_4_0= ruleKeywordGroup
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeywordGroup_in_ruleRuleDamager1410);
            	    lv_keywordGroups_4_0=ruleKeywordGroup();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRuleDamagerRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"keywordGroups",
            	            		lv_keywordGroups_4_0, 
            	            		"KeywordGroup");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:662:3: ( (lv_rules_5_0= ruleScannerRule ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==32||(LA9_0>=36 && LA9_0<=39)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:663:1: (lv_rules_5_0= ruleScannerRule )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:663:1: (lv_rules_5_0= ruleScannerRule )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:664:3: lv_rules_5_0= ruleScannerRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getRulesScannerRuleParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScannerRule_in_ruleRuleDamager1432);
            	    lv_rules_5_0=ruleScannerRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRuleDamagerRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_5_0, 
            	            		"ScannerRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_6=(Token)match(input,12,FOLLOW_12_in_ruleRuleDamager1445); 

                	newLeafNode(otherlv_6, grammarAccess.getRuleDamagerAccess().getRightCurlyBracketKeyword_6());
                

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:692:1: entryRuleScannerToken returns [EObject current=null] : iv_ruleScannerToken= ruleScannerToken EOF ;
    public final EObject entryRuleScannerToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerToken = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:693:2: (iv_ruleScannerToken= ruleScannerToken EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:694:2: iv_ruleScannerToken= ruleScannerToken EOF
            {
             newCompositeNode(grammarAccess.getScannerTokenRule()); 
            pushFollow(FOLLOW_ruleScannerToken_in_entryRuleScannerToken1481);
            iv_ruleScannerToken=ruleScannerToken();

            state._fsp--;

             current =iv_ruleScannerToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerToken1491); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:701:1: ruleScannerToken returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleScannerToken() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:704:28: ( ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:705:1: ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:705:1: ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:705:2: ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:705:2: ( (lv_default_0_0= 'default' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:706:1: (lv_default_0_0= 'default' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:706:1: (lv_default_0_0= 'default' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:707:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,25,FOLLOW_25_in_ruleScannerToken1534); 

                            newLeafNode(lv_default_0_0, grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerTokenRule());
                    	        }
                           		setWithLastConsumed(current, "default", true, "default");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleScannerToken1560); 

                	newLeafNode(otherlv_1, grammarAccess.getScannerTokenAccess().getTokenKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:724:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:725:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:725:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:726:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerToken1577); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:750:1: entryRuleKeywordGroup returns [EObject current=null] : iv_ruleKeywordGroup= ruleKeywordGroup EOF ;
    public final EObject entryRuleKeywordGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordGroup = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:751:2: (iv_ruleKeywordGroup= ruleKeywordGroup EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:752:2: iv_ruleKeywordGroup= ruleKeywordGroup EOF
            {
             newCompositeNode(grammarAccess.getKeywordGroupRule()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup1618);
            iv_ruleKeywordGroup=ruleKeywordGroup();

            state._fsp--;

             current =iv_ruleKeywordGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordGroup1628); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:759:1: ruleKeywordGroup returns [EObject current=null] : (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:762:28: ( (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:763:1: (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:763:1: (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:763:3: otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleKeywordGroup1665); 

                	newLeafNode(otherlv_0, grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:767:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:768:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:768:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:769:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getKeywordGroupRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeywordGroup1685); 

            		newLeafNode(otherlv_1, grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleKeywordGroup1697); 

                	newLeafNode(otherlv_2, grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:784:1: ( (lv_keywords_3_0= ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:785:1: (lv_keywords_3_0= ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:785:1: (lv_keywords_3_0= ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:786:3: lv_keywords_3_0= ruleKeyword
            {
             
            	        newCompositeNode(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleKeyword_in_ruleKeywordGroup1718);
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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:802:2: (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:802:4: otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) )
            	    {
            	    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleKeywordGroup1731); 

            	        	newLeafNode(otherlv_4, grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0());
            	        
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:806:1: ( (lv_keywords_5_0= ruleKeyword ) )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:807:1: (lv_keywords_5_0= ruleKeyword )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:807:1: (lv_keywords_5_0= ruleKeyword )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:808:3: lv_keywords_5_0= ruleKeyword
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeyword_in_ruleKeywordGroup1752);
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
            	    break loop11;
                }
            } while (true);

            otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleKeywordGroup1766); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:836:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:837:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:838:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword1802);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword1812); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:845:1: ruleKeyword returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_version_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:848:28: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:849:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:849:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:849:2: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:849:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:850:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:850:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:851:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1854); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:867:2: (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==31) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:867:4: otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleKeyword1872); 

                        	newLeafNode(otherlv_1, grammarAccess.getKeywordAccess().getSinceKeyword_1_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:871:1: ( (lv_version_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:872:1: (lv_version_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:872:1: (lv_version_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:873:3: lv_version_2_0= RULE_STRING
                    {
                    lv_version_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1889); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:897:1: entryRuleScannerRule returns [EObject current=null] : iv_ruleScannerRule= ruleScannerRule EOF ;
    public final EObject entryRuleScannerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:898:2: (iv_ruleScannerRule= ruleScannerRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:899:2: iv_ruleScannerRule= ruleScannerRule EOF
            {
             newCompositeNode(grammarAccess.getScannerRuleRule()); 
            pushFollow(FOLLOW_ruleScannerRule_in_entryRuleScannerRule1932);
            iv_ruleScannerRule=ruleScannerRule();

            state._fsp--;

             current =iv_ruleScannerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerRule1942); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:906:1: ruleScannerRule returns [EObject current=null] : (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule ) ;
    public final EObject ruleScannerRule() throws RecognitionException {
        EObject current = null;

        EObject this_ScannerSingleLineRule_0 = null;

        EObject this_ScannerMultiLineRule_1 = null;

        EObject this_ScannerCharacterRule_2 = null;

        EObject this_ScannerJSRule_3 = null;

        EObject this_ScannerWhitespaceRule_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:909:28: ( (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:910:1: (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:910:1: (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt13=1;
                }
                break;
            case 36:
                {
                alt13=2;
                }
                break;
            case 37:
                {
                alt13=3;
                }
                break;
            case 38:
                {
                alt13=4;
                }
                break;
            case 39:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:911:5: this_ScannerSingleLineRule_0= ruleScannerSingleLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleScannerSingleLineRule_in_ruleScannerRule1989);
                    this_ScannerSingleLineRule_0=ruleScannerSingleLineRule();

                    state._fsp--;

                     
                            current = this_ScannerSingleLineRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:921:5: this_ScannerMultiLineRule_1= ruleScannerMultiLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleScannerMultiLineRule_in_ruleScannerRule2016);
                    this_ScannerMultiLineRule_1=ruleScannerMultiLineRule();

                    state._fsp--;

                     
                            current = this_ScannerMultiLineRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:931:5: this_ScannerCharacterRule_2= ruleScannerCharacterRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleScannerCharacterRule_in_ruleScannerRule2043);
                    this_ScannerCharacterRule_2=ruleScannerCharacterRule();

                    state._fsp--;

                     
                            current = this_ScannerCharacterRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:941:5: this_ScannerJSRule_3= ruleScannerJSRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleScannerJSRule_in_ruleScannerRule2070);
                    this_ScannerJSRule_3=ruleScannerJSRule();

                    state._fsp--;

                     
                            current = this_ScannerJSRule_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:951:5: this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerWhitespaceRuleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_ruleScannerRule2097);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:967:1: entryRuleParitionRule returns [EObject current=null] : iv_ruleParitionRule= ruleParitionRule EOF ;
    public final EObject entryRuleParitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitionRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:968:2: (iv_ruleParitionRule= ruleParitionRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:969:2: iv_ruleParitionRule= ruleParitionRule EOF
            {
             newCompositeNode(grammarAccess.getParitionRuleRule()); 
            pushFollow(FOLLOW_ruleParitionRule_in_entryRuleParitionRule2132);
            iv_ruleParitionRule=ruleParitionRule();

            state._fsp--;

             current =iv_ruleParitionRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitionRule2142); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:976:1: ruleParitionRule returns [EObject current=null] : (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule ) ;
    public final EObject ruleParitionRule() throws RecognitionException {
        EObject current = null;

        EObject this_PartitionSingleLineRule_0 = null;

        EObject this_PartitionMultiLineRule_1 = null;

        EObject this_PartitionJSRule_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:979:28: ( (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:980:1: (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:980:1: (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt14=1;
                }
                break;
            case 36:
                {
                alt14=2;
                }
                break;
            case 38:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:981:5: this_PartitionSingleLineRule_0= rulePartitionSingleLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePartitionSingleLineRule_in_ruleParitionRule2189);
                    this_PartitionSingleLineRule_0=rulePartitionSingleLineRule();

                    state._fsp--;

                     
                            current = this_PartitionSingleLineRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:991:5: this_PartitionMultiLineRule_1= rulePartitionMultiLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePartitionMultiLineRule_in_ruleParitionRule2216);
                    this_PartitionMultiLineRule_1=rulePartitionMultiLineRule();

                    state._fsp--;

                     
                            current = this_PartitionMultiLineRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1001:5: this_PartitionJSRule_2= rulePartitionJSRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionJSRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePartitionJSRule_in_ruleParitionRule2243);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1017:1: entryRuleScannerSingleLineRule returns [EObject current=null] : iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF ;
    public final EObject entryRuleScannerSingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerSingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1018:2: (iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1019:2: iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF
            {
             newCompositeNode(grammarAccess.getScannerSingleLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule2278);
            iv_ruleScannerSingleLineRule=ruleScannerSingleLineRule();

            state._fsp--;

             current =iv_ruleScannerSingleLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerSingleLineRule2288); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1026:1: ruleScannerSingleLineRule returns [EObject current=null] : (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleScannerSingleLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_startSeq_2_0=null;
        Token otherlv_3=null;
        Token lv_endSeq_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_escapeSeq_7_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1029:28: ( (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1030:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1030:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1030:3: otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleScannerSingleLineRule2325); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1034:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1035:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1035:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1036:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerSingleLineRule2345); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1047:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1048:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1048:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1049:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2362); 

            			newLeafNode(lv_startSeq_2_0, grammarAccess.getScannerSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"startSeq",
                    		lv_startSeq_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleScannerSingleLineRule2379); 

                	newLeafNode(otherlv_3, grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1069:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1070:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1070:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1071:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2396); 

            			newLeafNode(lv_endSeq_4_0, grammarAccess.getScannerSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"endSeq",
                    		lv_endSeq_4_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1087:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1087:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleScannerSingleLineRule2414); 

                        	newLeafNode(otherlv_5, grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,35,FOLLOW_35_in_ruleScannerSingleLineRule2426); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1095:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1096:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1096:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1097:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2443); 

                    			newLeafNode(lv_escapeSeq_7_0, grammarAccess.getScannerSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"escapeSeq",
                            		lv_escapeSeq_7_0, 
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1121:1: entryRulePartitionSingleLineRule returns [EObject current=null] : iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF ;
    public final EObject entryRulePartitionSingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionSingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1122:2: (iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1123:2: iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionSingleLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule2486);
            iv_rulePartitionSingleLineRule=rulePartitionSingleLineRule();

            state._fsp--;

             current =iv_rulePartitionSingleLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionSingleLineRule2496); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1130:1: rulePartitionSingleLineRule returns [EObject current=null] : (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
    public final EObject rulePartitionSingleLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_startSeq_2_0=null;
        Token otherlv_3=null;
        Token lv_endSeq_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_escapeSeq_7_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1133:28: ( (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1134:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1134:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1134:3: otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_rulePartitionSingleLineRule2533); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1138:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1139:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1139:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1140:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionSingleLineRule2553); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1151:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1152:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1152:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1153:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2570); 

            			newLeafNode(lv_startSeq_2_0, grammarAccess.getPartitionSingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"startSeq",
                    		lv_startSeq_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,33,FOLLOW_33_in_rulePartitionSingleLineRule2587); 

                	newLeafNode(otherlv_3, grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1173:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1174:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1174:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1175:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2604); 

            			newLeafNode(lv_endSeq_4_0, grammarAccess.getPartitionSingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"endSeq",
                    		lv_endSeq_4_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1191:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==34) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1191:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_34_in_rulePartitionSingleLineRule2622); 

                        	newLeafNode(otherlv_5, grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,35,FOLLOW_35_in_rulePartitionSingleLineRule2634); 

                        	newLeafNode(otherlv_6, grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1199:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1200:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1200:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1201:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2651); 

                    			newLeafNode(lv_escapeSeq_7_0, grammarAccess.getPartitionSingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"escapeSeq",
                            		lv_escapeSeq_7_0, 
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1225:1: entryRuleScannerMultiLineRule returns [EObject current=null] : iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF ;
    public final EObject entryRuleScannerMultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerMultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1226:2: (iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1227:2: iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF
            {
             newCompositeNode(grammarAccess.getScannerMultiLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule2694);
            iv_ruleScannerMultiLineRule=ruleScannerMultiLineRule();

            state._fsp--;

             current =iv_ruleScannerMultiLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerMultiLineRule2704); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1234:1: ruleScannerMultiLineRule returns [EObject current=null] : (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleScannerMultiLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_startSeq_2_0=null;
        Token otherlv_3=null;
        Token lv_endSeq_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_escapeSeq_7_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1237:28: ( (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1238:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1238:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1238:3: otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleScannerMultiLineRule2741); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1242:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1243:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1243:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1244:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerMultiLineRule2761); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1255:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1256:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1256:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1257:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2778); 

            			newLeafNode(lv_startSeq_2_0, grammarAccess.getScannerMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"startSeq",
                    		lv_startSeq_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleScannerMultiLineRule2795); 

                	newLeafNode(otherlv_3, grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1277:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1278:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1278:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1279:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2812); 

            			newLeafNode(lv_endSeq_4_0, grammarAccess.getScannerMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"endSeq",
                    		lv_endSeq_4_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1295:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==34) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1295:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleScannerMultiLineRule2830); 

                        	newLeafNode(otherlv_5, grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,35,FOLLOW_35_in_ruleScannerMultiLineRule2842); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1303:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1304:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1304:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1305:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2859); 

                    			newLeafNode(lv_escapeSeq_7_0, grammarAccess.getScannerMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"escapeSeq",
                            		lv_escapeSeq_7_0, 
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1329:1: entryRulePartitionMultiLineRule returns [EObject current=null] : iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF ;
    public final EObject entryRulePartitionMultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionMultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1330:2: (iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1331:2: iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionMultiLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule2902);
            iv_rulePartitionMultiLineRule=rulePartitionMultiLineRule();

            state._fsp--;

             current =iv_rulePartitionMultiLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionMultiLineRule2912); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1338:1: rulePartitionMultiLineRule returns [EObject current=null] : (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
    public final EObject rulePartitionMultiLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_startSeq_2_0=null;
        Token otherlv_3=null;
        Token lv_endSeq_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_escapeSeq_7_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1341:28: ( (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1342:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1342:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1342:3: otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_rulePartitionMultiLineRule2949); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1346:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1347:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1347:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1348:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionMultiLineRule2969); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1359:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1360:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1360:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1361:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2986); 

            			newLeafNode(lv_startSeq_2_0, grammarAccess.getPartitionMultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"startSeq",
                    		lv_startSeq_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,33,FOLLOW_33_in_rulePartitionMultiLineRule3003); 

                	newLeafNode(otherlv_3, grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1381:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1382:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1382:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1383:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule3020); 

            			newLeafNode(lv_endSeq_4_0, grammarAccess.getPartitionMultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"endSeq",
                    		lv_endSeq_4_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1399:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==34) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1399:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_34_in_rulePartitionMultiLineRule3038); 

                        	newLeafNode(otherlv_5, grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,35,FOLLOW_35_in_rulePartitionMultiLineRule3050); 

                        	newLeafNode(otherlv_6, grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1407:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1408:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1408:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1409:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule3067); 

                    			newLeafNode(lv_escapeSeq_7_0, grammarAccess.getPartitionMultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"escapeSeq",
                            		lv_escapeSeq_7_0, 
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1433:1: entryRuleScannerCharacterRule returns [EObject current=null] : iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF ;
    public final EObject entryRuleScannerCharacterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerCharacterRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1434:2: (iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1435:2: iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF
            {
             newCompositeNode(grammarAccess.getScannerCharacterRuleRule()); 
            pushFollow(FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule3110);
            iv_ruleScannerCharacterRule=ruleScannerCharacterRule();

            state._fsp--;

             current =iv_ruleScannerCharacterRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerCharacterRule3120); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1442:1: ruleScannerCharacterRule returns [EObject current=null] : (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ;
    public final EObject ruleScannerCharacterRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_characters_3_0=null;
        Token otherlv_4=null;
        Token lv_characters_5_0=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1445:28: ( (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1446:1: (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1446:1: (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1446:3: otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleScannerCharacterRule3157); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1450:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1451:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1451:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1452:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerCharacterRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerCharacterRule3177); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleScannerCharacterRule3189); 

                	newLeafNode(otherlv_2, grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1467:1: ( (lv_characters_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1468:1: (lv_characters_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1468:1: (lv_characters_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1469:3: lv_characters_3_0= RULE_STRING
            {
            lv_characters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3206); 

            			newLeafNode(lv_characters_3_0, grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerCharacterRuleRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"characters",
                    		lv_characters_3_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1485:2: (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1485:4: otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleScannerCharacterRule3224); 

            	        	newLeafNode(otherlv_4, grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4_0());
            	        
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1489:1: ( (lv_characters_5_0= RULE_STRING ) )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1490:1: (lv_characters_5_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1490:1: (lv_characters_5_0= RULE_STRING )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1491:3: lv_characters_5_0= RULE_STRING
            	    {
            	    lv_characters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3241); 

            	    			newLeafNode(lv_characters_5_0, grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_4_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getScannerCharacterRuleRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"characters",
            	            		lv_characters_5_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleScannerCharacterRule3260); 

                	newLeafNode(otherlv_6, grammarAccess.getScannerCharacterRuleAccess().getRightSquareBracketKeyword_5());
                

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1519:1: entryRuleScannerJSRule returns [EObject current=null] : iv_ruleScannerJSRule= ruleScannerJSRule EOF ;
    public final EObject entryRuleScannerJSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerJSRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1520:2: (iv_ruleScannerJSRule= ruleScannerJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1521:2: iv_ruleScannerJSRule= ruleScannerJSRule EOF
            {
             newCompositeNode(grammarAccess.getScannerJSRuleRule()); 
            pushFollow(FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule3296);
            iv_ruleScannerJSRule=ruleScannerJSRule();

            state._fsp--;

             current =iv_ruleScannerJSRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerJSRule3306); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1528:1: ruleScannerJSRule returns [EObject current=null] : (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleScannerJSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1531:28: ( (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1532:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1532:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1532:3: otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleScannerJSRule3343); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1536:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1537:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1537:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1538:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerJSRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerJSRule3363); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1549:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1550:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1550:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1551:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerJSRule3380); 

            			newLeafNode(lv_fileURI_2_0, grammarAccess.getScannerJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerJSRuleRule());
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
    // $ANTLR end "ruleScannerJSRule"


    // $ANTLR start "entryRulePartitionJSRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1575:1: entryRulePartitionJSRule returns [EObject current=null] : iv_rulePartitionJSRule= rulePartitionJSRule EOF ;
    public final EObject entryRulePartitionJSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionJSRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1576:2: (iv_rulePartitionJSRule= rulePartitionJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1577:2: iv_rulePartitionJSRule= rulePartitionJSRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionJSRuleRule()); 
            pushFollow(FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule3421);
            iv_rulePartitionJSRule=rulePartitionJSRule();

            state._fsp--;

             current =iv_rulePartitionJSRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionJSRule3431); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1584:1: rulePartitionJSRule returns [EObject current=null] : (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePartitionJSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1587:28: ( (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1588:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1588:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1588:3: otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_rulePartitionJSRule3468); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1592:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1593:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1593:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1594:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionJSRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionJSRule3488); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1605:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1606:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1606:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1607:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionJSRule3505); 

            			newLeafNode(lv_fileURI_2_0, grammarAccess.getPartitionJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionJSRuleRule());
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
    // $ANTLR end "rulePartitionJSRule"


    // $ANTLR start "entryRuleScannerWhitespaceRule"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1631:1: entryRuleScannerWhitespaceRule returns [EObject current=null] : iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF ;
    public final EObject entryRuleScannerWhitespaceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerWhitespaceRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1632:2: (iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1633:2: iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF
            {
             newCompositeNode(grammarAccess.getScannerWhitespaceRuleRule()); 
            pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule3546);
            iv_ruleScannerWhitespaceRule=ruleScannerWhitespaceRule();

            state._fsp--;

             current =iv_ruleScannerWhitespaceRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerWhitespaceRule3556); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1640:1: ruleScannerWhitespaceRule returns [EObject current=null] : (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? ( (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) | ( (lv_javawhitespace_7_0= 'javawhitespace' ) ) | ( (lv_fileURI_8_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleScannerWhitespaceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_characters_3_0=null;
        Token otherlv_4=null;
        Token lv_characters_5_0=null;
        Token otherlv_6=null;
        Token lv_javawhitespace_7_0=null;
        Token lv_fileURI_8_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1643:28: ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? ( (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) | ( (lv_javawhitespace_7_0= 'javawhitespace' ) ) | ( (lv_fileURI_8_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1644:1: (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? ( (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) | ( (lv_javawhitespace_7_0= 'javawhitespace' ) ) | ( (lv_fileURI_8_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1644:1: (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? ( (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) | ( (lv_javawhitespace_7_0= 'javawhitespace' ) ) | ( (lv_fileURI_8_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1644:3: otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? ( (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) | ( (lv_javawhitespace_7_0= 'javawhitespace' ) ) | ( (lv_fileURI_8_0= RULE_STRING ) ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleScannerWhitespaceRule3593); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1648:1: ( (otherlv_1= RULE_ID ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1649:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1649:1: (otherlv_1= RULE_ID )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1650:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerWhitespaceRule3613); 

                    		newLeafNode(otherlv_1, grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1661:3: ( (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) | ( (lv_javawhitespace_7_0= 'javawhitespace' ) ) | ( (lv_fileURI_8_0= RULE_STRING ) ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt22=1;
                }
                break;
            case 40:
                {
                alt22=2;
                }
                break;
            case RULE_STRING:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1661:4: (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1661:4: (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1661:6: otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleScannerWhitespaceRule3628); 

                        	newLeafNode(otherlv_2, grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_2_0_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1665:1: ( (lv_characters_3_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1666:1: (lv_characters_3_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1666:1: (lv_characters_3_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1667:3: lv_characters_3_0= RULE_STRING
                    {
                    lv_characters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3645); 

                    			newLeafNode(lv_characters_3_0, grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"characters",
                            		lv_characters_3_0, 
                            		"STRING");
                    	    

                    }


                    }

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1683:2: (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==29) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1683:4: otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) )
                    	    {
                    	    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleScannerWhitespaceRule3663); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_2_0_2_0());
                    	        
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1687:1: ( (lv_characters_5_0= RULE_STRING ) )
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1688:1: (lv_characters_5_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1688:1: (lv_characters_5_0= RULE_STRING )
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1689:3: lv_characters_5_0= RULE_STRING
                    	    {
                    	    lv_characters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3680); 

                    	    			newLeafNode(lv_characters_5_0, grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"characters",
                    	            		lv_characters_5_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleScannerWhitespaceRule3699); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_2_0_3());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1710:6: ( (lv_javawhitespace_7_0= 'javawhitespace' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1710:6: ( (lv_javawhitespace_7_0= 'javawhitespace' ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1711:1: (lv_javawhitespace_7_0= 'javawhitespace' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1711:1: (lv_javawhitespace_7_0= 'javawhitespace' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1712:3: lv_javawhitespace_7_0= 'javawhitespace'
                    {
                    lv_javawhitespace_7_0=(Token)match(input,40,FOLLOW_40_in_ruleScannerWhitespaceRule3724); 

                            newLeafNode(lv_javawhitespace_7_0, grammarAccess.getScannerWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_2_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	        }
                           		setWithLastConsumed(current, "javawhitespace", true, "javawhitespace");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1726:6: ( (lv_fileURI_8_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1726:6: ( (lv_fileURI_8_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1727:1: (lv_fileURI_8_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1727:1: (lv_fileURI_8_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1728:3: lv_fileURI_8_0= RULE_STRING
                    {
                    lv_fileURI_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3760); 

                    			newLeafNode(lv_fileURI_8_0, grammarAccess.getScannerWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_2_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"fileURI",
                            		lv_fileURI_8_0, 
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1754:1: entryRuleRGBColor returns [EObject current=null] : iv_ruleRGBColor= ruleRGBColor EOF ;
    public final EObject entryRuleRGBColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRGBColor = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1755:2: (iv_ruleRGBColor= ruleRGBColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1756:2: iv_ruleRGBColor= ruleRGBColor EOF
            {
             newCompositeNode(grammarAccess.getRGBColorRule()); 
            pushFollow(FOLLOW_ruleRGBColor_in_entryRuleRGBColor3804);
            iv_ruleRGBColor=ruleRGBColor();

            state._fsp--;

             current =iv_ruleRGBColor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGBColor3814); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1763:1: ruleRGBColor returns [EObject current=null] : (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1766:28: ( (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1767:1: (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1767:1: (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1767:3: otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleRGBColor3851); 

                	newLeafNode(otherlv_0, grammarAccess.getRGBColorAccess().getRgbKeyword_0());
                
            otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleRGBColor3863); 

                	newLeafNode(otherlv_1, grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1775:1: ( (lv_r_2_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1776:1: (lv_r_2_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1776:1: (lv_r_2_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1777:3: lv_r_2_0= RULE_INT
            {
            lv_r_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3880); 

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

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleRGBColor3897); 

                	newLeafNode(otherlv_3, grammarAccess.getRGBColorAccess().getCommaKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1797:1: ( (lv_g_4_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1798:1: (lv_g_4_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1798:1: (lv_g_4_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1799:3: lv_g_4_0= RULE_INT
            {
            lv_g_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3914); 

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

            otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleRGBColor3931); 

                	newLeafNode(otherlv_5, grammarAccess.getRGBColorAccess().getCommaKeyword_5());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1819:1: ( (lv_b_6_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1820:1: (lv_b_6_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1820:1: (lv_b_6_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1821:3: lv_b_6_0= RULE_INT
            {
            lv_b_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3948); 

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

            otherlv_7=(Token)match(input,43,FOLLOW_43_in_ruleRGBColor3965); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1851:1: ruleFontType returns [Enumerator current=null] : ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) ) ;
    public final Enumerator ruleFontType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1853:28: ( ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1854:1: ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1854:1: ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt23=1;
                }
                break;
            case 45:
                {
                alt23=2;
                }
                break;
            case 46:
                {
                alt23=3;
                }
                break;
            case 47:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1854:2: (enumLiteral_0= 'bold' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1854:2: (enumLiteral_0= 'bold' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1854:4: enumLiteral_0= 'bold'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_44_in_ruleFontType4017); 

                            current = grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1860:6: (enumLiteral_1= 'italic' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1860:6: (enumLiteral_1= 'italic' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1860:8: enumLiteral_1= 'italic'
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_45_in_ruleFontType4034); 

                            current = grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1866:6: (enumLiteral_2= 'underline' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1866:6: (enumLiteral_2= 'underline' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1866:8: enumLiteral_2= 'underline'
                    {
                    enumLiteral_2=(Token)match(input,46,FOLLOW_46_in_ruleFontType4051); 

                            current = grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1872:6: (enumLiteral_3= 'strike-through' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1872:6: (enumLiteral_3= 'strike-through' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1872:8: enumLiteral_3= 'strike-through'
                    {
                    enumLiteral_3=(Token)match(input,47,FOLLOW_47_in_ruleFontType4068); 

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
    public static final BitSet FOLLOW_rulePartition_in_ruleModel165 = new BitSet(new long[]{0x0000000001804000L});
    public static final BitSet FOLLOW_ruleDamager_in_ruleModel187 = new BitSet(new long[]{0x0000000001E08000L});
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
    public static final BitSet FOLLOW_15_in_ruleJavaLikeParitioner590 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleJavaLikeParitioner602 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJavaLikeParitioner614 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaLikeParitioner634 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleJavaLikeParitioner646 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaLikeParitioner666 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleJavaLikeParitioner678 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaLikeParitioner698 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleJavaLikeParitioner710 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaLikeParitioner730 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleJavaLikeParitioner742 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJavaLikeParitioner762 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleJavaLikeParitioner774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRulePartitioner820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleRulePartitioner857 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleRulePartitioner869 = new BitSet(new long[]{0x0000005100000000L});
    public static final BitSet FOLLOW_ruleParitionRule_in_ruleRulePartitioner890 = new BitSet(new long[]{0x0000005100001000L});
    public static final BitSet FOLLOW_12_in_ruleRulePartitioner903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner939 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSParitioner949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleJSParitioner986 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJSParitioner1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDamager_in_entryRuleDamager1044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDamager1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_ruleDamager1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_ruleDamager1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_entryRuleJSDamager1163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSDamager1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleJSDamager1210 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJSDamager1230 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJSDamager1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_entryRuleRuleDamager1288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDamager1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleRuleDamager1335 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleDamager1355 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleRuleDamager1367 = new BitSet(new long[]{0x000000F10E001000L});
    public static final BitSet FOLLOW_ruleScannerToken_in_ruleRuleDamager1388 = new BitSet(new long[]{0x000000F10E001000L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_ruleRuleDamager1410 = new BitSet(new long[]{0x000000F108001000L});
    public static final BitSet FOLLOW_ruleScannerRule_in_ruleRuleDamager1432 = new BitSet(new long[]{0x000000F100001000L});
    public static final BitSet FOLLOW_12_in_ruleRuleDamager1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_entryRuleScannerToken1481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerToken1491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleScannerToken1534 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleScannerToken1560 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerToken1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup1618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordGroup1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleKeywordGroup1665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeywordGroup1685 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleKeywordGroup1697 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleKeywordGroup1718 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleKeywordGroup1731 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleKeywordGroup1752 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleKeywordGroup1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword1802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1854 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleKeyword1872 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_entryRuleScannerRule1932 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerRule1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_ruleScannerRule1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_ruleScannerRule2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_ruleScannerRule2043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_ruleScannerRule2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_ruleScannerRule2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_entryRuleParitionRule2132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitionRule2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_ruleParitionRule2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_ruleParitionRule2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_ruleParitionRule2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule2278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerSingleLineRule2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleScannerSingleLineRule2325 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerSingleLineRule2345 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2362 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleScannerSingleLineRule2379 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2396 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleScannerSingleLineRule2414 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleScannerSingleLineRule2426 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule2486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionSingleLineRule2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rulePartitionSingleLineRule2533 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionSingleLineRule2553 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2570 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_rulePartitionSingleLineRule2587 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2604 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_rulePartitionSingleLineRule2622 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_rulePartitionSingleLineRule2634 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule2694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerMultiLineRule2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleScannerMultiLineRule2741 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerMultiLineRule2761 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2778 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleScannerMultiLineRule2795 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2812 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleScannerMultiLineRule2830 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleScannerMultiLineRule2842 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule2902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionMultiLineRule2912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rulePartitionMultiLineRule2949 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionMultiLineRule2969 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2986 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_rulePartitionMultiLineRule3003 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule3020 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_rulePartitionMultiLineRule3038 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_rulePartitionMultiLineRule3050 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule3110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerCharacterRule3120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleScannerCharacterRule3157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerCharacterRule3177 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleScannerCharacterRule3189 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3206 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleScannerCharacterRule3224 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3241 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleScannerCharacterRule3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule3296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerJSRule3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleScannerJSRule3343 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerJSRule3363 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerJSRule3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule3421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionJSRule3431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rulePartitionJSRule3468 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionJSRule3488 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionJSRule3505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule3546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerWhitespaceRule3556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleScannerWhitespaceRule3593 = new BitSet(new long[]{0x0000010010000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerWhitespaceRule3613 = new BitSet(new long[]{0x0000010010000020L});
    public static final BitSet FOLLOW_28_in_ruleScannerWhitespaceRule3628 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3645 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleScannerWhitespaceRule3663 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3680 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleScannerWhitespaceRule3699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleScannerWhitespaceRule3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_entryRuleRGBColor3804 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGBColor3814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleRGBColor3851 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleRGBColor3863 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3880 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleRGBColor3897 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3914 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleRGBColor3931 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3948 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleRGBColor3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleFontType4017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFontType4034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleFontType4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleFontType4068 = new BitSet(new long[]{0x0000000000000002L});

}