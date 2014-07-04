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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'{'", "'}'", "'for'", "'partition'", "'rule-partitioner'", "'js-partitioner'", "'js-damager'", "'rule-damager'", "'default'", "'token'", "'fgcolor'", "':'", "'bgcolor'", "'font'", "'keywords'", "'['", "','", "']'", "'since'", "'single-line'", "'=>'", "'escaped'", "'by'", "'multi-line'", "'character-rule'", "'javascript-rule'", "'whitespace-rule'", "'#{'", "'}#'", "'rgb'", "'('", "')'", "'bold'", "'italic'", "'underline'", "'strike-through'"
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

                if ( ((LA2_0>=17 && LA2_0<=18)) ) {
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:243:1: rulePartitioner returns [EObject current=null] : (this_RulePartitioner_0= ruleRulePartitioner | this_JSParitioner_1= ruleJSParitioner ) ;
    public final EObject rulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject this_RulePartitioner_0 = null;

        EObject this_JSParitioner_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:246:28: ( (this_RulePartitioner_0= ruleRulePartitioner | this_JSParitioner_1= ruleJSParitioner ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:247:1: (this_RulePartitioner_0= ruleRulePartitioner | this_JSParitioner_1= ruleJSParitioner )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:247:1: (this_RulePartitioner_0= ruleRulePartitioner | this_JSParitioner_1= ruleJSParitioner )
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
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:258:5: this_JSParitioner_1= ruleJSParitioner
                    {
                     
                            newCompositeNode(grammarAccess.getPartitionerAccess().getJSParitionerParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleJSParitioner_in_rulePartitioner481);
                    this_JSParitioner_1=ruleJSParitioner();

                    state._fsp--;

                     
                            current = this_JSParitioner_1; 
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


    // $ANTLR start "entryRuleRulePartitioner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:274:1: entryRuleRulePartitioner returns [EObject current=null] : iv_ruleRulePartitioner= ruleRulePartitioner EOF ;
    public final EObject entryRuleRulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRulePartitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:275:2: (iv_ruleRulePartitioner= ruleRulePartitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:276:2: iv_ruleRulePartitioner= ruleRulePartitioner EOF
            {
             newCompositeNode(grammarAccess.getRulePartitionerRule()); 
            pushFollow(FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner516);
            iv_ruleRulePartitioner=ruleRulePartitioner();

            state._fsp--;

             current =iv_ruleRulePartitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRulePartitioner526); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:283:1: ruleRulePartitioner returns [EObject current=null] : (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' ) ;
    public final EObject ruleRulePartitioner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_rules_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:286:28: ( (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:287:1: (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:287:1: (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:287:3: otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleRulePartitioner563); 

                	newLeafNode(otherlv_0, grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0());
                
            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleRulePartitioner575); 

                	newLeafNode(otherlv_1, grammarAccess.getRulePartitionerAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:295:1: ( (lv_rules_2_0= ruleParitionRule ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==30||LA5_0==34||LA5_0==36) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:296:1: (lv_rules_2_0= ruleParitionRule )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:296:1: (lv_rules_2_0= ruleParitionRule )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:297:3: lv_rules_2_0= ruleParitionRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRulePartitionerAccess().getRulesParitionRuleParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParitionRule_in_ruleRulePartitioner596);
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleRulePartitioner609); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:325:1: entryRuleJSParitioner returns [EObject current=null] : iv_ruleJSParitioner= ruleJSParitioner EOF ;
    public final EObject entryRuleJSParitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSParitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:326:2: (iv_ruleJSParitioner= ruleJSParitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:327:2: iv_ruleJSParitioner= ruleJSParitioner EOF
            {
             newCompositeNode(grammarAccess.getJSParitionerRule()); 
            pushFollow(FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner645);
            iv_ruleJSParitioner=ruleJSParitioner();

            state._fsp--;

             current =iv_ruleJSParitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSParitioner655); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:334:1: ruleJSParitioner returns [EObject current=null] : (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleJSParitioner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fileURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:337:28: ( (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:338:1: (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:338:1: (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:338:3: otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleJSParitioner692); 

                	newLeafNode(otherlv_0, grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:342:1: ( (lv_fileURI_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:343:1: (lv_fileURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:343:1: (lv_fileURI_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:344:3: lv_fileURI_1_0= RULE_STRING
            {
            lv_fileURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleJSParitioner709); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:368:1: entryRuleDamager returns [EObject current=null] : iv_ruleDamager= ruleDamager EOF ;
    public final EObject entryRuleDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:369:2: (iv_ruleDamager= ruleDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:370:2: iv_ruleDamager= ruleDamager EOF
            {
             newCompositeNode(grammarAccess.getDamagerRule()); 
            pushFollow(FOLLOW_ruleDamager_in_entryRuleDamager750);
            iv_ruleDamager=ruleDamager();

            state._fsp--;

             current =iv_ruleDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDamager760); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:377:1: ruleDamager returns [EObject current=null] : (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager ) ;
    public final EObject ruleDamager() throws RecognitionException {
        EObject current = null;

        EObject this_RuleDamager_0 = null;

        EObject this_JSDamager_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:380:28: ( (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:381:1: (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:381:1: (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:382:5: this_RuleDamager_0= ruleRuleDamager
                    {
                     
                            newCompositeNode(grammarAccess.getDamagerAccess().getRuleDamagerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRuleDamager_in_ruleDamager807);
                    this_RuleDamager_0=ruleRuleDamager();

                    state._fsp--;

                     
                            current = this_RuleDamager_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:392:5: this_JSDamager_1= ruleJSDamager
                    {
                     
                            newCompositeNode(grammarAccess.getDamagerAccess().getJSDamagerParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleJSDamager_in_ruleDamager834);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:408:1: entryRuleJSDamager returns [EObject current=null] : iv_ruleJSDamager= ruleJSDamager EOF ;
    public final EObject entryRuleJSDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:409:2: (iv_ruleJSDamager= ruleJSDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:410:2: iv_ruleJSDamager= ruleJSDamager EOF
            {
             newCompositeNode(grammarAccess.getJSDamagerRule()); 
            pushFollow(FOLLOW_ruleJSDamager_in_entryRuleJSDamager869);
            iv_ruleJSDamager=ruleJSDamager();

            state._fsp--;

             current =iv_ruleJSDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSDamager879); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:417:1: ruleJSDamager returns [EObject current=null] : (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleJSDamager() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:420:28: ( (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:421:1: (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:421:1: (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:421:3: otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleJSDamager916); 

                	newLeafNode(otherlv_0, grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:425:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:426:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:426:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:427:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJSDamagerRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJSDamager936); 

            		newLeafNode(otherlv_1, grammarAccess.getJSDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:438:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:439:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:439:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:440:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleJSDamager953); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:464:1: entryRuleRuleDamager returns [EObject current=null] : iv_ruleRuleDamager= ruleRuleDamager EOF ;
    public final EObject entryRuleRuleDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:465:2: (iv_ruleRuleDamager= ruleRuleDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:466:2: iv_ruleRuleDamager= ruleRuleDamager EOF
            {
             newCompositeNode(grammarAccess.getRuleDamagerRule()); 
            pushFollow(FOLLOW_ruleRuleDamager_in_entryRuleRuleDamager994);
            iv_ruleRuleDamager=ruleRuleDamager();

            state._fsp--;

             current =iv_ruleRuleDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDamager1004); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:473:1: ruleRuleDamager returns [EObject current=null] : (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:476:28: ( (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:477:1: (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:477:1: (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:477:3: otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleRuleDamager1041); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:481:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:482:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:482:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:483:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleDamagerRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleDamager1061); 

            		newLeafNode(otherlv_1, grammarAccess.getRuleDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleRuleDamager1073); 

                	newLeafNode(otherlv_2, grammarAccess.getRuleDamagerAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:498:1: ( (lv_tokens_3_0= ruleScannerToken ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=19 && LA7_0<=20)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:499:1: (lv_tokens_3_0= ruleScannerToken )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:499:1: (lv_tokens_3_0= ruleScannerToken )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:500:3: lv_tokens_3_0= ruleScannerToken
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getTokensScannerTokenParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScannerToken_in_ruleRuleDamager1094);
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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:516:3: ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==25) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:517:1: (lv_keywordGroups_4_0= ruleKeywordGroup )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:517:1: (lv_keywordGroups_4_0= ruleKeywordGroup )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:518:3: lv_keywordGroups_4_0= ruleKeywordGroup
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeywordGroup_in_ruleRuleDamager1116);
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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:534:3: ( (lv_rules_5_0= ruleScannerRule ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==30||(LA9_0>=34 && LA9_0<=38)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:535:1: (lv_rules_5_0= ruleScannerRule )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:535:1: (lv_rules_5_0= ruleScannerRule )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:536:3: lv_rules_5_0= ruleScannerRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getRulesScannerRuleParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScannerRule_in_ruleRuleDamager1138);
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            otherlv_6=(Token)match(input,12,FOLLOW_12_in_ruleRuleDamager1151); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:564:1: entryRuleScannerToken returns [EObject current=null] : iv_ruleScannerToken= ruleScannerToken EOF ;
    public final EObject entryRuleScannerToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerToken = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:565:2: (iv_ruleScannerToken= ruleScannerToken EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:566:2: iv_ruleScannerToken= ruleScannerToken EOF
            {
             newCompositeNode(grammarAccess.getScannerTokenRule()); 
            pushFollow(FOLLOW_ruleScannerToken_in_entryRuleScannerToken1187);
            iv_ruleScannerToken=ruleScannerToken();

            state._fsp--;

             current =iv_ruleScannerToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerToken1197); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:573:1: ruleScannerToken returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? ) ;
    public final EObject ruleScannerToken() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_fgColor_6_0 = null;

        EObject lv_bgColor_9_0 = null;

        EObject lv_font_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:576:28: ( ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:577:1: ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:577:1: ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:577:2: ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:577:2: ( (lv_default_0_0= 'default' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:578:1: (lv_default_0_0= 'default' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:578:1: (lv_default_0_0= 'default' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:579:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,19,FOLLOW_19_in_ruleScannerToken1240); 

                            newLeafNode(lv_default_0_0, grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerTokenRule());
                    	        }
                           		setWithLastConsumed(current, "default", true, "default");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleScannerToken1266); 

                	newLeafNode(otherlv_1, grammarAccess.getScannerTokenAccess().getTokenKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:596:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:597:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:597:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:598:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerToken1283); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:614:2: (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==11) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:614:4: otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}'
                    {
                    otherlv_3=(Token)match(input,11,FOLLOW_11_in_ruleScannerToken1301); 

                        	newLeafNode(otherlv_3, grammarAccess.getScannerTokenAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:618:1: (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==21) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:618:3: otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) )
                            {
                            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleScannerToken1314); 

                                	newLeafNode(otherlv_4, grammarAccess.getScannerTokenAccess().getFgcolorKeyword_3_1_0());
                                
                            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleScannerToken1326); 

                                	newLeafNode(otherlv_5, grammarAccess.getScannerTokenAccess().getColonKeyword_3_1_1());
                                
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:626:1: ( (lv_fgColor_6_0= ruleColor ) )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:627:1: (lv_fgColor_6_0= ruleColor )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:627:1: (lv_fgColor_6_0= ruleColor )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:628:3: lv_fgColor_6_0= ruleColor
                            {
                             
                            	        newCompositeNode(grammarAccess.getScannerTokenAccess().getFgColorColorParserRuleCall_3_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleColor_in_ruleScannerToken1347);
                            lv_fgColor_6_0=ruleColor();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getScannerTokenRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"fgColor",
                                    		lv_fgColor_6_0, 
                                    		"Color");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:644:4: (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==23) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:644:6: otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) )
                            {
                            otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleScannerToken1362); 

                                	newLeafNode(otherlv_7, grammarAccess.getScannerTokenAccess().getBgcolorKeyword_3_2_0());
                                
                            otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleScannerToken1374); 

                                	newLeafNode(otherlv_8, grammarAccess.getScannerTokenAccess().getColonKeyword_3_2_1());
                                
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:652:1: ( (lv_bgColor_9_0= ruleColor ) )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:653:1: (lv_bgColor_9_0= ruleColor )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:653:1: (lv_bgColor_9_0= ruleColor )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:654:3: lv_bgColor_9_0= ruleColor
                            {
                             
                            	        newCompositeNode(grammarAccess.getScannerTokenAccess().getBgColorColorParserRuleCall_3_2_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleColor_in_ruleScannerToken1395);
                            lv_bgColor_9_0=ruleColor();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getScannerTokenRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"bgColor",
                                    		lv_bgColor_9_0, 
                                    		"Color");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:670:4: (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==24) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:670:6: otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) )
                            {
                            otherlv_10=(Token)match(input,24,FOLLOW_24_in_ruleScannerToken1410); 

                                	newLeafNode(otherlv_10, grammarAccess.getScannerTokenAccess().getFontKeyword_3_3_0());
                                
                            otherlv_11=(Token)match(input,22,FOLLOW_22_in_ruleScannerToken1422); 

                                	newLeafNode(otherlv_11, grammarAccess.getScannerTokenAccess().getColonKeyword_3_3_1());
                                
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:678:1: ( (lv_font_12_0= ruleFont ) )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:679:1: (lv_font_12_0= ruleFont )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:679:1: (lv_font_12_0= ruleFont )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:680:3: lv_font_12_0= ruleFont
                            {
                             
                            	        newCompositeNode(grammarAccess.getScannerTokenAccess().getFontFontParserRuleCall_3_3_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleFont_in_ruleScannerToken1443);
                            lv_font_12_0=ruleFont();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getScannerTokenRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"font",
                                    		lv_font_12_0, 
                                    		"Font");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,12,FOLLOW_12_in_ruleScannerToken1457); 

                        	newLeafNode(otherlv_13, grammarAccess.getScannerTokenAccess().getRightCurlyBracketKeyword_3_4());
                        

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
    // $ANTLR end "ruleScannerToken"


    // $ANTLR start "entryRuleKeywordGroup"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:708:1: entryRuleKeywordGroup returns [EObject current=null] : iv_ruleKeywordGroup= ruleKeywordGroup EOF ;
    public final EObject entryRuleKeywordGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordGroup = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:709:2: (iv_ruleKeywordGroup= ruleKeywordGroup EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:710:2: iv_ruleKeywordGroup= ruleKeywordGroup EOF
            {
             newCompositeNode(grammarAccess.getKeywordGroupRule()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup1495);
            iv_ruleKeywordGroup=ruleKeywordGroup();

            state._fsp--;

             current =iv_ruleKeywordGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordGroup1505); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:717:1: ruleKeywordGroup returns [EObject current=null] : (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:720:28: ( (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:721:1: (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:721:1: (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:721:3: otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleKeywordGroup1542); 

                	newLeafNode(otherlv_0, grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:725:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:726:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:726:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:727:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getKeywordGroupRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeywordGroup1562); 

            		newLeafNode(otherlv_1, grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleKeywordGroup1574); 

                	newLeafNode(otherlv_2, grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:742:1: ( (lv_keywords_3_0= ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:743:1: (lv_keywords_3_0= ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:743:1: (lv_keywords_3_0= ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:744:3: lv_keywords_3_0= ruleKeyword
            {
             
            	        newCompositeNode(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleKeyword_in_ruleKeywordGroup1595);
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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:760:2: (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==27) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:760:4: otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) )
            	    {
            	    otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleKeywordGroup1608); 

            	        	newLeafNode(otherlv_4, grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0());
            	        
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:764:1: ( (lv_keywords_5_0= ruleKeyword ) )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:765:1: (lv_keywords_5_0= ruleKeyword )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:765:1: (lv_keywords_5_0= ruleKeyword )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:766:3: lv_keywords_5_0= ruleKeyword
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeyword_in_ruleKeywordGroup1629);
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
            	    break loop15;
                }
            } while (true);

            otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleKeywordGroup1643); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:794:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:795:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:796:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword1679);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword1689); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:803:1: ruleKeyword returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_version_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:806:28: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:807:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:807:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:807:2: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:807:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:808:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:808:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:809:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1731); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:825:2: (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==29) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:825:4: otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleKeyword1749); 

                        	newLeafNode(otherlv_1, grammarAccess.getKeywordAccess().getSinceKeyword_1_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:829:1: ( (lv_version_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:830:1: (lv_version_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:830:1: (lv_version_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:831:3: lv_version_2_0= RULE_STRING
                    {
                    lv_version_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1766); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:855:1: entryRuleScannerRule returns [EObject current=null] : iv_ruleScannerRule= ruleScannerRule EOF ;
    public final EObject entryRuleScannerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:856:2: (iv_ruleScannerRule= ruleScannerRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:857:2: iv_ruleScannerRule= ruleScannerRule EOF
            {
             newCompositeNode(grammarAccess.getScannerRuleRule()); 
            pushFollow(FOLLOW_ruleScannerRule_in_entryRuleScannerRule1809);
            iv_ruleScannerRule=ruleScannerRule();

            state._fsp--;

             current =iv_ruleScannerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerRule1819); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:864:1: ruleScannerRule returns [EObject current=null] : (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule ) ;
    public final EObject ruleScannerRule() throws RecognitionException {
        EObject current = null;

        EObject this_ScannerSingleLineRule_0 = null;

        EObject this_ScannerMultiLineRule_1 = null;

        EObject this_ScannerCharacterRule_2 = null;

        EObject this_ScannerJSRule_3 = null;

        EObject this_ScannerWhitespaceRule_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:867:28: ( (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:868:1: (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:868:1: (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule )
            int alt17=5;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt17=1;
                }
                break;
            case 34:
                {
                alt17=2;
                }
                break;
            case 35:
                {
                alt17=3;
                }
                break;
            case 36:
                {
                alt17=4;
                }
                break;
            case 37:
            case 38:
                {
                alt17=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:869:5: this_ScannerSingleLineRule_0= ruleScannerSingleLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleScannerSingleLineRule_in_ruleScannerRule1866);
                    this_ScannerSingleLineRule_0=ruleScannerSingleLineRule();

                    state._fsp--;

                     
                            current = this_ScannerSingleLineRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:879:5: this_ScannerMultiLineRule_1= ruleScannerMultiLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleScannerMultiLineRule_in_ruleScannerRule1893);
                    this_ScannerMultiLineRule_1=ruleScannerMultiLineRule();

                    state._fsp--;

                     
                            current = this_ScannerMultiLineRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:889:5: this_ScannerCharacterRule_2= ruleScannerCharacterRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleScannerCharacterRule_in_ruleScannerRule1920);
                    this_ScannerCharacterRule_2=ruleScannerCharacterRule();

                    state._fsp--;

                     
                            current = this_ScannerCharacterRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:899:5: this_ScannerJSRule_3= ruleScannerJSRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleScannerJSRule_in_ruleScannerRule1947);
                    this_ScannerJSRule_3=ruleScannerJSRule();

                    state._fsp--;

                     
                            current = this_ScannerJSRule_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:909:5: this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerWhitespaceRuleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_ruleScannerRule1974);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:925:1: entryRuleParitionRule returns [EObject current=null] : iv_ruleParitionRule= ruleParitionRule EOF ;
    public final EObject entryRuleParitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitionRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:926:2: (iv_ruleParitionRule= ruleParitionRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:927:2: iv_ruleParitionRule= ruleParitionRule EOF
            {
             newCompositeNode(grammarAccess.getParitionRuleRule()); 
            pushFollow(FOLLOW_ruleParitionRule_in_entryRuleParitionRule2009);
            iv_ruleParitionRule=ruleParitionRule();

            state._fsp--;

             current =iv_ruleParitionRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitionRule2019); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:934:1: ruleParitionRule returns [EObject current=null] : (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule ) ;
    public final EObject ruleParitionRule() throws RecognitionException {
        EObject current = null;

        EObject this_PartitionSingleLineRule_0 = null;

        EObject this_PartitionMultiLineRule_1 = null;

        EObject this_PartitionJSRule_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:937:28: ( (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:938:1: (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:938:1: (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt18=1;
                }
                break;
            case 34:
                {
                alt18=2;
                }
                break;
            case 36:
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
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:939:5: this_PartitionSingleLineRule_0= rulePartitionSingleLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePartitionSingleLineRule_in_ruleParitionRule2066);
                    this_PartitionSingleLineRule_0=rulePartitionSingleLineRule();

                    state._fsp--;

                     
                            current = this_PartitionSingleLineRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:949:5: this_PartitionMultiLineRule_1= rulePartitionMultiLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePartitionMultiLineRule_in_ruleParitionRule2093);
                    this_PartitionMultiLineRule_1=rulePartitionMultiLineRule();

                    state._fsp--;

                     
                            current = this_PartitionMultiLineRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:959:5: this_PartitionJSRule_2= rulePartitionJSRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionJSRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePartitionJSRule_in_ruleParitionRule2120);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:975:1: entryRuleScannerSingleLineRule returns [EObject current=null] : iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF ;
    public final EObject entryRuleScannerSingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerSingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:976:2: (iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:977:2: iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF
            {
             newCompositeNode(grammarAccess.getScannerSingleLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule2155);
            iv_ruleScannerSingleLineRule=ruleScannerSingleLineRule();

            state._fsp--;

             current =iv_ruleScannerSingleLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerSingleLineRule2165); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:984:1: ruleScannerSingleLineRule returns [EObject current=null] : (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:987:28: ( (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:988:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:988:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:988:3: otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleScannerSingleLineRule2202); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:992:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:993:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:993:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:994:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerSingleLineRule2222); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1005:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1006:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1006:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1007:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2239); 

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

            otherlv_3=(Token)match(input,31,FOLLOW_31_in_ruleScannerSingleLineRule2256); 

                	newLeafNode(otherlv_3, grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1027:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1028:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1028:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1029:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2273); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1045:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1045:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_32_in_ruleScannerSingleLineRule2291); 

                        	newLeafNode(otherlv_5, grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleScannerSingleLineRule2303); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1053:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1054:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1054:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1055:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2320); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1079:1: entryRulePartitionSingleLineRule returns [EObject current=null] : iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF ;
    public final EObject entryRulePartitionSingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionSingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1080:2: (iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1081:2: iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionSingleLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule2363);
            iv_rulePartitionSingleLineRule=rulePartitionSingleLineRule();

            state._fsp--;

             current =iv_rulePartitionSingleLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionSingleLineRule2373); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1088:1: rulePartitionSingleLineRule returns [EObject current=null] : (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1091:28: ( (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1092:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1092:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1092:3: otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_rulePartitionSingleLineRule2410); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1096:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1097:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1097:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1098:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionSingleLineRule2430); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1109:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1110:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1110:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1111:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2447); 

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

            otherlv_3=(Token)match(input,31,FOLLOW_31_in_rulePartitionSingleLineRule2464); 

                	newLeafNode(otherlv_3, grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1131:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1132:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1132:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1133:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2481); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1149:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1149:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_32_in_rulePartitionSingleLineRule2499); 

                        	newLeafNode(otherlv_5, grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_rulePartitionSingleLineRule2511); 

                        	newLeafNode(otherlv_6, grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1157:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1158:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1158:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1159:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2528); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1183:1: entryRuleScannerMultiLineRule returns [EObject current=null] : iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF ;
    public final EObject entryRuleScannerMultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerMultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1184:2: (iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1185:2: iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF
            {
             newCompositeNode(grammarAccess.getScannerMultiLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule2571);
            iv_ruleScannerMultiLineRule=ruleScannerMultiLineRule();

            state._fsp--;

             current =iv_ruleScannerMultiLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerMultiLineRule2581); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1192:1: ruleScannerMultiLineRule returns [EObject current=null] : (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1195:28: ( (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1196:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1196:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1196:3: otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleScannerMultiLineRule2618); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1200:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1201:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1201:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1202:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerMultiLineRule2638); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1213:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1214:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1214:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1215:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2655); 

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

            otherlv_3=(Token)match(input,31,FOLLOW_31_in_ruleScannerMultiLineRule2672); 

                	newLeafNode(otherlv_3, grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1235:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1236:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1236:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1237:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2689); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1253:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1253:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_32_in_ruleScannerMultiLineRule2707); 

                        	newLeafNode(otherlv_5, grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleScannerMultiLineRule2719); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1261:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1262:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1262:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1263:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2736); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1287:1: entryRulePartitionMultiLineRule returns [EObject current=null] : iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF ;
    public final EObject entryRulePartitionMultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionMultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1288:2: (iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1289:2: iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionMultiLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule2779);
            iv_rulePartitionMultiLineRule=rulePartitionMultiLineRule();

            state._fsp--;

             current =iv_rulePartitionMultiLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionMultiLineRule2789); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1296:1: rulePartitionMultiLineRule returns [EObject current=null] : (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1299:28: ( (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1300:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1300:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1300:3: otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_rulePartitionMultiLineRule2826); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1304:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1305:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1305:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1306:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionMultiLineRule2846); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1317:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1318:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1318:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1319:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2863); 

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

            otherlv_3=(Token)match(input,31,FOLLOW_31_in_rulePartitionMultiLineRule2880); 

                	newLeafNode(otherlv_3, grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1339:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1340:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1340:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1341:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2897); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1357:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1357:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_32_in_rulePartitionMultiLineRule2915); 

                        	newLeafNode(otherlv_5, grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_rulePartitionMultiLineRule2927); 

                        	newLeafNode(otherlv_6, grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1365:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1366:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1366:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1367:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2944); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1391:1: entryRuleScannerCharacterRule returns [EObject current=null] : iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF ;
    public final EObject entryRuleScannerCharacterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerCharacterRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1392:2: (iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1393:2: iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF
            {
             newCompositeNode(grammarAccess.getScannerCharacterRuleRule()); 
            pushFollow(FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule2987);
            iv_ruleScannerCharacterRule=ruleScannerCharacterRule();

            state._fsp--;

             current =iv_ruleScannerCharacterRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerCharacterRule2997); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1400:1: ruleScannerCharacterRule returns [EObject current=null] : (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1403:28: ( (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1404:1: (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1404:1: (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1404:3: otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleScannerCharacterRule3034); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1408:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1409:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1409:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1410:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerCharacterRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerCharacterRule3054); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleScannerCharacterRule3066); 

                	newLeafNode(otherlv_2, grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1425:1: ( (lv_characters_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1426:1: (lv_characters_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1426:1: (lv_characters_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1427:3: lv_characters_3_0= RULE_STRING
            {
            lv_characters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3083); 

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

            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleScannerCharacterRule3100); 

                	newLeafNode(otherlv_4, grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1447:1: ( (lv_characters_5_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1448:1: (lv_characters_5_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1448:1: (lv_characters_5_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1449:3: lv_characters_5_0= RULE_STRING
            {
            lv_characters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3117); 

            			newLeafNode(lv_characters_5_0, grammarAccess.getScannerCharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_5_0()); 
            		

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

            otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleScannerCharacterRule3134); 

                	newLeafNode(otherlv_6, grammarAccess.getScannerCharacterRuleAccess().getRightSquareBracketKeyword_6());
                

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1477:1: entryRuleScannerJSRule returns [EObject current=null] : iv_ruleScannerJSRule= ruleScannerJSRule EOF ;
    public final EObject entryRuleScannerJSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerJSRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1478:2: (iv_ruleScannerJSRule= ruleScannerJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1479:2: iv_ruleScannerJSRule= ruleScannerJSRule EOF
            {
             newCompositeNode(grammarAccess.getScannerJSRuleRule()); 
            pushFollow(FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule3170);
            iv_ruleScannerJSRule=ruleScannerJSRule();

            state._fsp--;

             current =iv_ruleScannerJSRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerJSRule3180); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1486:1: ruleScannerJSRule returns [EObject current=null] : (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleScannerJSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1489:28: ( (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1490:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1490:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1490:3: otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleScannerJSRule3217); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1494:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1495:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1495:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1496:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerJSRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerJSRule3237); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1507:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1508:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1508:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1509:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerJSRule3254); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1533:1: entryRulePartitionJSRule returns [EObject current=null] : iv_rulePartitionJSRule= rulePartitionJSRule EOF ;
    public final EObject entryRulePartitionJSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionJSRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1534:2: (iv_rulePartitionJSRule= rulePartitionJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1535:2: iv_rulePartitionJSRule= rulePartitionJSRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionJSRuleRule()); 
            pushFollow(FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule3295);
            iv_rulePartitionJSRule=rulePartitionJSRule();

            state._fsp--;

             current =iv_rulePartitionJSRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionJSRule3305); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1542:1: rulePartitionJSRule returns [EObject current=null] : (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePartitionJSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1545:28: ( (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1546:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1546:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1546:3: otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_rulePartitionJSRule3342); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1550:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1551:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1551:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1552:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionJSRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionJSRule3362); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1563:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1564:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1564:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1565:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionJSRule3379); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1589:1: entryRuleScannerWhitespaceRule returns [EObject current=null] : iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF ;
    public final EObject entryRuleScannerWhitespaceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerWhitespaceRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1590:2: (iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1591:2: iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF
            {
             newCompositeNode(grammarAccess.getScannerWhitespaceRuleRule()); 
            pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule3420);
            iv_ruleScannerWhitespaceRule=ruleScannerWhitespaceRule();

            state._fsp--;

             current =iv_ruleScannerWhitespaceRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerWhitespaceRule3430); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1598:1: ruleScannerWhitespaceRule returns [EObject current=null] : ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) ) ;
    public final EObject ruleScannerWhitespaceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_characters_3_0=null;
        Token otherlv_4=null;
        Token lv_characters_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_jsDetector_8_0=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1601:28: ( ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1602:1: ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1602:1: ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==37) ) {
                alt25=1;
            }
            else if ( (LA25_0==38) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1602:2: (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1602:2: (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1602:4: otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' )
                    {
                    otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleScannerWhitespaceRule3468); 

                        	newLeafNode(otherlv_0, grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1606:1: ( (otherlv_1= RULE_ID ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==RULE_ID) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1607:1: (otherlv_1= RULE_ID )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1607:1: (otherlv_1= RULE_ID )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1608:3: otherlv_1= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                            	        }
                                    
                            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerWhitespaceRule3488); 

                            		newLeafNode(otherlv_1, grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_0_1_0()); 
                            	

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1619:3: (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1619:5: otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleScannerWhitespaceRule3502); 

                        	newLeafNode(otherlv_2, grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_0_2_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1623:1: ( (lv_characters_3_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1624:1: (lv_characters_3_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1624:1: (lv_characters_3_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1625:3: lv_characters_3_0= RULE_STRING
                    {
                    lv_characters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3519); 

                    			newLeafNode(lv_characters_3_0, grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_0_2_1_0()); 
                    		

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

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1641:2: (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==27) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1641:4: otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) )
                    	    {
                    	    otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleScannerWhitespaceRule3537); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_0_2_2_0());
                    	        
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1645:1: ( (lv_characters_5_0= RULE_STRING ) )
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1646:1: (lv_characters_5_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1646:1: (lv_characters_5_0= RULE_STRING )
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1647:3: lv_characters_5_0= RULE_STRING
                    	    {
                    	    lv_characters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3554); 

                    	    			newLeafNode(lv_characters_5_0, grammarAccess.getScannerWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_0_2_2_1_0()); 
                    	    		

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
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleScannerWhitespaceRule3573); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_0_2_3());
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1668:6: (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1668:6: (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1668:8: otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#'
                    {
                    otherlv_7=(Token)match(input,38,FOLLOW_38_in_ruleScannerWhitespaceRule3594); 

                        	newLeafNode(otherlv_7, grammarAccess.getScannerWhitespaceRuleAccess().getNumberSignLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1672:1: ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1673:1: (lv_jsDetector_8_0= RULE_ANY_OTHER )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1673:1: (lv_jsDetector_8_0= RULE_ANY_OTHER )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1674:3: lv_jsDetector_8_0= RULE_ANY_OTHER
                    {
                    lv_jsDetector_8_0=(Token)match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_ruleScannerWhitespaceRule3611); 

                    			newLeafNode(lv_jsDetector_8_0, grammarAccess.getScannerWhitespaceRuleAccess().getJsDetectorANY_OTHERTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"jsDetector",
                            		lv_jsDetector_8_0, 
                            		"ANY_OTHER");
                    	    

                    }


                    }

                    otherlv_9=(Token)match(input,39,FOLLOW_39_in_ruleScannerWhitespaceRule3628); 

                        	newLeafNode(otherlv_9, grammarAccess.getScannerWhitespaceRuleAccess().getRightCurlyBracketNumberSignKeyword_1_2());
                        

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
    // $ANTLR end "ruleScannerWhitespaceRule"


    // $ANTLR start "entryRuleColor"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1702:1: entryRuleColor returns [EObject current=null] : iv_ruleColor= ruleColor EOF ;
    public final EObject entryRuleColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColor = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1703:2: (iv_ruleColor= ruleColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1704:2: iv_ruleColor= ruleColor EOF
            {
             newCompositeNode(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor3665);
            iv_ruleColor=ruleColor();

            state._fsp--;

             current =iv_ruleColor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor3675); 

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
    // $ANTLR end "entryRuleColor"


    // $ANTLR start "ruleColor"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1711:1: ruleColor returns [EObject current=null] : this_RGBColor_0= ruleRGBColor ;
    public final EObject ruleColor() throws RecognitionException {
        EObject current = null;

        EObject this_RGBColor_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1714:28: (this_RGBColor_0= ruleRGBColor )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1716:5: this_RGBColor_0= ruleRGBColor
            {
             
                    newCompositeNode(grammarAccess.getColorAccess().getRGBColorParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleRGBColor_in_ruleColor3721);
            this_RGBColor_0=ruleRGBColor();

            state._fsp--;

             
                    current = this_RGBColor_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleColor"


    // $ANTLR start "entryRuleRGBColor"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1732:1: entryRuleRGBColor returns [EObject current=null] : iv_ruleRGBColor= ruleRGBColor EOF ;
    public final EObject entryRuleRGBColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRGBColor = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1733:2: (iv_ruleRGBColor= ruleRGBColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1734:2: iv_ruleRGBColor= ruleRGBColor EOF
            {
             newCompositeNode(grammarAccess.getRGBColorRule()); 
            pushFollow(FOLLOW_ruleRGBColor_in_entryRuleRGBColor3755);
            iv_ruleRGBColor=ruleRGBColor();

            state._fsp--;

             current =iv_ruleRGBColor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGBColor3765); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1741:1: ruleRGBColor returns [EObject current=null] : (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1744:28: ( (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1745:1: (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1745:1: (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1745:3: otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleRGBColor3802); 

                	newLeafNode(otherlv_0, grammarAccess.getRGBColorAccess().getRgbKeyword_0());
                
            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleRGBColor3814); 

                	newLeafNode(otherlv_1, grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1753:1: ( (lv_r_2_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1754:1: (lv_r_2_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1754:1: (lv_r_2_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1755:3: lv_r_2_0= RULE_INT
            {
            lv_r_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3831); 

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

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleRGBColor3848); 

                	newLeafNode(otherlv_3, grammarAccess.getRGBColorAccess().getCommaKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1775:1: ( (lv_g_4_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1776:1: (lv_g_4_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1776:1: (lv_g_4_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1777:3: lv_g_4_0= RULE_INT
            {
            lv_g_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3865); 

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

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleRGBColor3882); 

                	newLeafNode(otherlv_5, grammarAccess.getRGBColorAccess().getCommaKeyword_5());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1797:1: ( (lv_b_6_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1798:1: (lv_b_6_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1798:1: (lv_b_6_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1799:3: lv_b_6_0= RULE_INT
            {
            lv_b_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3899); 

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

            otherlv_7=(Token)match(input,42,FOLLOW_42_in_ruleRGBColor3916); 

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


    // $ANTLR start "entryRuleFont"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1827:1: entryRuleFont returns [EObject current=null] : iv_ruleFont= ruleFont EOF ;
    public final EObject entryRuleFont() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFont = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1828:2: (iv_ruleFont= ruleFont EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1829:2: iv_ruleFont= ruleFont EOF
            {
             newCompositeNode(grammarAccess.getFontRule()); 
            pushFollow(FOLLOW_ruleFont_in_entryRuleFont3952);
            iv_ruleFont=ruleFont();

            state._fsp--;

             current =iv_ruleFont; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFont3962); 

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
    // $ANTLR end "entryRuleFont"


    // $ANTLR start "ruleFont"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1836:1: ruleFont returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* ) ;
    public final EObject ruleFont() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_size_1_0=null;
        Enumerator lv_attributes_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1839:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1840:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1840:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1840:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )*
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1840:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1841:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1841:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1842:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFont4004); 

            			newLeafNode(lv_name_0_0, grammarAccess.getFontAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFontRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1858:2: ( (lv_size_1_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1859:1: (lv_size_1_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1859:1: (lv_size_1_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1860:3: lv_size_1_0= RULE_INT
            {
            lv_size_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFont4026); 

            			newLeafNode(lv_size_1_0, grammarAccess.getFontAccess().getSizeINTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFontRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"size",
                    		lv_size_1_0, 
                    		"INT");
            	    

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1876:2: ( (lv_attributes_2_0= ruleFontType ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=43 && LA26_0<=46)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1877:1: (lv_attributes_2_0= ruleFontType )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1877:1: (lv_attributes_2_0= ruleFontType )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1878:3: lv_attributes_2_0= ruleFontType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFontAccess().getAttributesFontTypeEnumRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFontType_in_ruleFont4052);
            	    lv_attributes_2_0=ruleFontType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFontRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_2_0, 
            	            		"FontType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
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
    // $ANTLR end "ruleFont"


    // $ANTLR start "ruleFontType"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1902:1: ruleFontType returns [Enumerator current=null] : ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) ) ;
    public final Enumerator ruleFontType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1904:28: ( ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1905:1: ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1905:1: ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) )
            int alt27=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt27=1;
                }
                break;
            case 44:
                {
                alt27=2;
                }
                break;
            case 45:
                {
                alt27=3;
                }
                break;
            case 46:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1905:2: (enumLiteral_0= 'bold' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1905:2: (enumLiteral_0= 'bold' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1905:4: enumLiteral_0= 'bold'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_43_in_ruleFontType4103); 

                            current = grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1911:6: (enumLiteral_1= 'italic' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1911:6: (enumLiteral_1= 'italic' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1911:8: enumLiteral_1= 'italic'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_44_in_ruleFontType4120); 

                            current = grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1917:6: (enumLiteral_2= 'underline' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1917:6: (enumLiteral_2= 'underline' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1917:8: enumLiteral_2= 'underline'
                    {
                    enumLiteral_2=(Token)match(input,45,FOLLOW_45_in_ruleFontType4137); 

                            current = grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1923:6: (enumLiteral_3= 'strike-through' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1923:6: (enumLiteral_3= 'strike-through' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1923:8: enumLiteral_3= 'strike-through'
                    {
                    enumLiteral_3=(Token)match(input,46,FOLLOW_46_in_ruleFontType4154); 

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
    public static final BitSet FOLLOW_rulePartition_in_ruleModel165 = new BitSet(new long[]{0x0000000000064000L});
    public static final BitSet FOLLOW_ruleDamager_in_ruleModel187 = new BitSet(new long[]{0x0000000000078000L});
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
    public static final BitSet FOLLOW_ruleJSParitioner_in_rulePartitioner481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRulePartitioner526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleRulePartitioner563 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleRulePartitioner575 = new BitSet(new long[]{0x0000001440000000L});
    public static final BitSet FOLLOW_ruleParitionRule_in_ruleRulePartitioner596 = new BitSet(new long[]{0x0000001440001000L});
    public static final BitSet FOLLOW_12_in_ruleRulePartitioner609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner645 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSParitioner655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleJSParitioner692 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJSParitioner709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDamager_in_entryRuleDamager750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDamager760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_ruleDamager807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_ruleDamager834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_entryRuleJSDamager869 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSDamager879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleJSDamager916 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJSDamager936 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJSDamager953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_entryRuleRuleDamager994 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDamager1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRuleDamager1041 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleDamager1061 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleRuleDamager1073 = new BitSet(new long[]{0x0000007C42180000L});
    public static final BitSet FOLLOW_ruleScannerToken_in_ruleRuleDamager1094 = new BitSet(new long[]{0x0000007C42180000L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_ruleRuleDamager1116 = new BitSet(new long[]{0x0000007C42180000L});
    public static final BitSet FOLLOW_ruleScannerRule_in_ruleRuleDamager1138 = new BitSet(new long[]{0x0000007C42181000L});
    public static final BitSet FOLLOW_12_in_ruleRuleDamager1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_entryRuleScannerToken1187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerToken1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleScannerToken1240 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleScannerToken1266 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerToken1283 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_ruleScannerToken1301 = new BitSet(new long[]{0x0000000001A01000L});
    public static final BitSet FOLLOW_21_in_ruleScannerToken1314 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleScannerToken1326 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleScannerToken1347 = new BitSet(new long[]{0x0000000001801000L});
    public static final BitSet FOLLOW_23_in_ruleScannerToken1362 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleScannerToken1374 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleScannerToken1395 = new BitSet(new long[]{0x0000000001001000L});
    public static final BitSet FOLLOW_24_in_ruleScannerToken1410 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleScannerToken1422 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFont_in_ruleScannerToken1443 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleScannerToken1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup1495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordGroup1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleKeywordGroup1542 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeywordGroup1562 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleKeywordGroup1574 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleKeywordGroup1595 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleKeywordGroup1608 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleKeywordGroup1629 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_ruleKeywordGroup1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword1679 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1731 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleKeyword1749 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_entryRuleScannerRule1809 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerRule1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_ruleScannerRule1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_ruleScannerRule1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_ruleScannerRule1920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_ruleScannerRule1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_ruleScannerRule1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_entryRuleParitionRule2009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitionRule2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_ruleParitionRule2066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_ruleParitionRule2093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_ruleParitionRule2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule2155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerSingleLineRule2165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleScannerSingleLineRule2202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerSingleLineRule2222 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2239 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleScannerSingleLineRule2256 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2273 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleScannerSingleLineRule2291 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleScannerSingleLineRule2303 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule2363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionSingleLineRule2373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rulePartitionSingleLineRule2410 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionSingleLineRule2430 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2447 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_rulePartitionSingleLineRule2464 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2481 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_rulePartitionSingleLineRule2499 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_rulePartitionSingleLineRule2511 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule2571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerMultiLineRule2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleScannerMultiLineRule2618 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerMultiLineRule2638 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2655 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleScannerMultiLineRule2672 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2689 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleScannerMultiLineRule2707 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleScannerMultiLineRule2719 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule2779 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionMultiLineRule2789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rulePartitionMultiLineRule2826 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionMultiLineRule2846 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2863 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_rulePartitionMultiLineRule2880 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2897 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_rulePartitionMultiLineRule2915 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_rulePartitionMultiLineRule2927 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule2987 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerCharacterRule2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleScannerCharacterRule3034 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerCharacterRule3054 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleScannerCharacterRule3066 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3083 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleScannerCharacterRule3100 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3117 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleScannerCharacterRule3134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule3170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerJSRule3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleScannerJSRule3217 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerJSRule3237 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerJSRule3254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule3295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionJSRule3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rulePartitionJSRule3342 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionJSRule3362 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionJSRule3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule3420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerWhitespaceRule3430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleScannerWhitespaceRule3468 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerWhitespaceRule3488 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleScannerWhitespaceRule3502 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3519 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleScannerWhitespaceRule3537 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3554 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_ruleScannerWhitespaceRule3573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleScannerWhitespaceRule3594 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleScannerWhitespaceRule3611 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleScannerWhitespaceRule3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor3665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor3675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_ruleColor3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_entryRuleRGBColor3755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGBColor3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleRGBColor3802 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleRGBColor3814 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3831 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleRGBColor3848 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3865 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleRGBColor3882 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3899 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleRGBColor3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFont_in_entryRuleFont3952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFont3962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFont4004 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFont4026 = new BitSet(new long[]{0x0000780000000002L});
    public static final BitSet FOLLOW_ruleFontType_in_ruleFont4052 = new BitSet(new long[]{0x0000780000000002L});
    public static final BitSet FOLLOW_43_in_ruleFontType4103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleFontType4120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFontType4137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleFontType4154 = new BitSet(new long[]{0x0000000000000002L});

}