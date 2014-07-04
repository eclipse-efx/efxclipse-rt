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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'{'", "'}'", "'partition'", "'rule-partitioner'", "'js-partitioner'", "'js-damager'", "'rule-damager'", "'default'", "'token'", "'fgcolor'", "':'", "'bgcolor'", "'font'", "'keywords'", "'['", "','", "']'", "'since'", "'single-line'", "'=>'", "'escaped'", "'by'", "'multi-line'", "'character-rule'", "'javascript-rule'", "'whitespace-rule'", "'#{'", "'}#'", "'rgb'", "'('", "')'", "'bold'", "'italic'", "'underline'", "'strike-through'"
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_damagers_3_0= ruleDamager ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_partitions_2_0 = null;

        EObject lv_damagers_3_0 = null;

        EObject lv_partitioner_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:80:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_damagers_3_0= ruleDamager ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:81:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_damagers_3_0= ruleDamager ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:81:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_damagers_3_0= ruleDamager ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:81:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_damagers_3_0= ruleDamager ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}'
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

                if ( (LA1_0==13) ) {
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

                if ( ((LA2_0>=16 && LA2_0<=17)) ) {
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:169:1: entryRulePartition returns [EObject current=null] : iv_rulePartition= rulePartition EOF ;
    public final EObject entryRulePartition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:170:2: (iv_rulePartition= rulePartition EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:171:2: iv_rulePartition= rulePartition EOF
            {
             newCompositeNode(grammarAccess.getPartitionRule()); 
            pushFollow(FOLLOW_rulePartition_in_entryRulePartition257);
            iv_rulePartition=rulePartition();

            state._fsp--;

             current =iv_rulePartition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition267); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:178:1: rulePartition returns [EObject current=null] : (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePartition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:181:28: ( (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:182:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:182:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:182:3: otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_rulePartition304); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionAccess().getPartitionKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:186:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:187:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:187:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:188:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition321); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:212:1: entryRulePartitioner returns [EObject current=null] : iv_rulePartitioner= rulePartitioner EOF ;
    public final EObject entryRulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:213:2: (iv_rulePartitioner= rulePartitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:214:2: iv_rulePartitioner= rulePartitioner EOF
            {
             newCompositeNode(grammarAccess.getPartitionerRule()); 
            pushFollow(FOLLOW_rulePartitioner_in_entryRulePartitioner362);
            iv_rulePartitioner=rulePartitioner();

            state._fsp--;

             current =iv_rulePartitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner372); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:221:1: rulePartitioner returns [EObject current=null] : (this_RulePartitioner_0= ruleRulePartitioner | this_JSParitioner_1= ruleJSParitioner ) ;
    public final EObject rulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject this_RulePartitioner_0 = null;

        EObject this_JSParitioner_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:224:28: ( (this_RulePartitioner_0= ruleRulePartitioner | this_JSParitioner_1= ruleJSParitioner ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:225:1: (this_RulePartitioner_0= ruleRulePartitioner | this_JSParitioner_1= ruleJSParitioner )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:225:1: (this_RulePartitioner_0= ruleRulePartitioner | this_JSParitioner_1= ruleJSParitioner )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
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
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:226:5: this_RulePartitioner_0= ruleRulePartitioner
                    {
                     
                            newCompositeNode(grammarAccess.getPartitionerAccess().getRulePartitionerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRulePartitioner_in_rulePartitioner419);
                    this_RulePartitioner_0=ruleRulePartitioner();

                    state._fsp--;

                     
                            current = this_RulePartitioner_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:236:5: this_JSParitioner_1= ruleJSParitioner
                    {
                     
                            newCompositeNode(grammarAccess.getPartitionerAccess().getJSParitionerParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleJSParitioner_in_rulePartitioner446);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:252:1: entryRuleRulePartitioner returns [EObject current=null] : iv_ruleRulePartitioner= ruleRulePartitioner EOF ;
    public final EObject entryRuleRulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRulePartitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:253:2: (iv_ruleRulePartitioner= ruleRulePartitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:254:2: iv_ruleRulePartitioner= ruleRulePartitioner EOF
            {
             newCompositeNode(grammarAccess.getRulePartitionerRule()); 
            pushFollow(FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner481);
            iv_ruleRulePartitioner=ruleRulePartitioner();

            state._fsp--;

             current =iv_ruleRulePartitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRulePartitioner491); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:261:1: ruleRulePartitioner returns [EObject current=null] : (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' ) ;
    public final EObject ruleRulePartitioner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_rules_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:264:28: ( (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:265:1: (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:265:1: (otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:265:3: otherlv_0= 'rule-partitioner' otherlv_1= '{' ( (lv_rules_2_0= ruleParitionRule ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleRulePartitioner528); 

                	newLeafNode(otherlv_0, grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0());
                
            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleRulePartitioner540); 

                	newLeafNode(otherlv_1, grammarAccess.getRulePartitionerAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:273:1: ( (lv_rules_2_0= ruleParitionRule ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==29||LA4_0==33||LA4_0==35) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:274:1: (lv_rules_2_0= ruleParitionRule )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:274:1: (lv_rules_2_0= ruleParitionRule )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:275:3: lv_rules_2_0= ruleParitionRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRulePartitionerAccess().getRulesParitionRuleParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParitionRule_in_ruleRulePartitioner561);
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleRulePartitioner574); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:303:1: entryRuleJSParitioner returns [EObject current=null] : iv_ruleJSParitioner= ruleJSParitioner EOF ;
    public final EObject entryRuleJSParitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSParitioner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:304:2: (iv_ruleJSParitioner= ruleJSParitioner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:305:2: iv_ruleJSParitioner= ruleJSParitioner EOF
            {
             newCompositeNode(grammarAccess.getJSParitionerRule()); 
            pushFollow(FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner610);
            iv_ruleJSParitioner=ruleJSParitioner();

            state._fsp--;

             current =iv_ruleJSParitioner; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSParitioner620); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:312:1: ruleJSParitioner returns [EObject current=null] : (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleJSParitioner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fileURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:315:28: ( (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:316:1: (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:316:1: (otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:316:3: otherlv_0= 'js-partitioner' ( (lv_fileURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleJSParitioner657); 

                	newLeafNode(otherlv_0, grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:320:1: ( (lv_fileURI_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:321:1: (lv_fileURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:321:1: (lv_fileURI_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:322:3: lv_fileURI_1_0= RULE_STRING
            {
            lv_fileURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleJSParitioner674); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:346:1: entryRuleDamager returns [EObject current=null] : iv_ruleDamager= ruleDamager EOF ;
    public final EObject entryRuleDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:347:2: (iv_ruleDamager= ruleDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:348:2: iv_ruleDamager= ruleDamager EOF
            {
             newCompositeNode(grammarAccess.getDamagerRule()); 
            pushFollow(FOLLOW_ruleDamager_in_entryRuleDamager715);
            iv_ruleDamager=ruleDamager();

            state._fsp--;

             current =iv_ruleDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDamager725); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:355:1: ruleDamager returns [EObject current=null] : (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager ) ;
    public final EObject ruleDamager() throws RecognitionException {
        EObject current = null;

        EObject this_RuleDamager_0 = null;

        EObject this_JSDamager_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:358:28: ( (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:359:1: (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:359:1: (this_RuleDamager_0= ruleRuleDamager | this_JSDamager_1= ruleJSDamager )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
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
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:360:5: this_RuleDamager_0= ruleRuleDamager
                    {
                     
                            newCompositeNode(grammarAccess.getDamagerAccess().getRuleDamagerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRuleDamager_in_ruleDamager772);
                    this_RuleDamager_0=ruleRuleDamager();

                    state._fsp--;

                     
                            current = this_RuleDamager_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:370:5: this_JSDamager_1= ruleJSDamager
                    {
                     
                            newCompositeNode(grammarAccess.getDamagerAccess().getJSDamagerParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleJSDamager_in_ruleDamager799);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:386:1: entryRuleJSDamager returns [EObject current=null] : iv_ruleJSDamager= ruleJSDamager EOF ;
    public final EObject entryRuleJSDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:387:2: (iv_ruleJSDamager= ruleJSDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:388:2: iv_ruleJSDamager= ruleJSDamager EOF
            {
             newCompositeNode(grammarAccess.getJSDamagerRule()); 
            pushFollow(FOLLOW_ruleJSDamager_in_entryRuleJSDamager834);
            iv_ruleJSDamager=ruleJSDamager();

            state._fsp--;

             current =iv_ruleJSDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJSDamager844); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:395:1: ruleJSDamager returns [EObject current=null] : (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleJSDamager() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:398:28: ( (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:399:1: (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:399:1: (otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:399:3: otherlv_0= 'js-damager' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleJSDamager881); 

                	newLeafNode(otherlv_0, grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:403:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:404:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:404:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:405:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJSDamagerRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJSDamager901); 

            		newLeafNode(otherlv_1, grammarAccess.getJSDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:416:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:417:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:417:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:418:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleJSDamager918); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:442:1: entryRuleRuleDamager returns [EObject current=null] : iv_ruleRuleDamager= ruleRuleDamager EOF ;
    public final EObject entryRuleRuleDamager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDamager = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:443:2: (iv_ruleRuleDamager= ruleRuleDamager EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:444:2: iv_ruleRuleDamager= ruleRuleDamager EOF
            {
             newCompositeNode(grammarAccess.getRuleDamagerRule()); 
            pushFollow(FOLLOW_ruleRuleDamager_in_entryRuleRuleDamager959);
            iv_ruleRuleDamager=ruleRuleDamager();

            state._fsp--;

             current =iv_ruleRuleDamager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDamager969); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:451:1: ruleRuleDamager returns [EObject current=null] : (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:454:28: ( (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:455:1: (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:455:1: (otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:455:3: otherlv_0= 'rule-damager' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleRuleDamager1006); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:459:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:460:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:460:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:461:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleDamagerRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleDamager1026); 

            		newLeafNode(otherlv_1, grammarAccess.getRuleDamagerAccess().getPartitionPartitionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleRuleDamager1038); 

                	newLeafNode(otherlv_2, grammarAccess.getRuleDamagerAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:476:1: ( (lv_tokens_3_0= ruleScannerToken ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=18 && LA6_0<=19)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:477:1: (lv_tokens_3_0= ruleScannerToken )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:477:1: (lv_tokens_3_0= ruleScannerToken )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:478:3: lv_tokens_3_0= ruleScannerToken
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getTokensScannerTokenParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScannerToken_in_ruleRuleDamager1059);
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
            	    break loop6;
                }
            } while (true);

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:494:3: ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:495:1: (lv_keywordGroups_4_0= ruleKeywordGroup )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:495:1: (lv_keywordGroups_4_0= ruleKeywordGroup )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:496:3: lv_keywordGroups_4_0= ruleKeywordGroup
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeywordGroup_in_ruleRuleDamager1081);
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
            	    break loop7;
                }
            } while (true);

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:512:3: ( (lv_rules_5_0= ruleScannerRule ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==29||(LA8_0>=33 && LA8_0<=37)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:513:1: (lv_rules_5_0= ruleScannerRule )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:513:1: (lv_rules_5_0= ruleScannerRule )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:514:3: lv_rules_5_0= ruleScannerRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDamagerAccess().getRulesScannerRuleParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScannerRule_in_ruleRuleDamager1103);
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            otherlv_6=(Token)match(input,12,FOLLOW_12_in_ruleRuleDamager1116); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:542:1: entryRuleScannerToken returns [EObject current=null] : iv_ruleScannerToken= ruleScannerToken EOF ;
    public final EObject entryRuleScannerToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerToken = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:543:2: (iv_ruleScannerToken= ruleScannerToken EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:544:2: iv_ruleScannerToken= ruleScannerToken EOF
            {
             newCompositeNode(grammarAccess.getScannerTokenRule()); 
            pushFollow(FOLLOW_ruleScannerToken_in_entryRuleScannerToken1152);
            iv_ruleScannerToken=ruleScannerToken();

            state._fsp--;

             current =iv_ruleScannerToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerToken1162); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:551:1: ruleScannerToken returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:554:28: ( ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:555:1: ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:555:1: ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:555:2: ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:555:2: ( (lv_default_0_0= 'default' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:556:1: (lv_default_0_0= 'default' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:556:1: (lv_default_0_0= 'default' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:557:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,18,FOLLOW_18_in_ruleScannerToken1205); 

                            newLeafNode(lv_default_0_0, grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerTokenRule());
                    	        }
                           		setWithLastConsumed(current, "default", true, "default");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleScannerToken1231); 

                	newLeafNode(otherlv_1, grammarAccess.getScannerTokenAccess().getTokenKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:574:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:575:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:575:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:576:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerToken1248); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:592:2: (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==11) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:592:4: otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}'
                    {
                    otherlv_3=(Token)match(input,11,FOLLOW_11_in_ruleScannerToken1266); 

                        	newLeafNode(otherlv_3, grammarAccess.getScannerTokenAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:596:1: (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==20) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:596:3: otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) )
                            {
                            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleScannerToken1279); 

                                	newLeafNode(otherlv_4, grammarAccess.getScannerTokenAccess().getFgcolorKeyword_3_1_0());
                                
                            otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleScannerToken1291); 

                                	newLeafNode(otherlv_5, grammarAccess.getScannerTokenAccess().getColonKeyword_3_1_1());
                                
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:604:1: ( (lv_fgColor_6_0= ruleColor ) )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:605:1: (lv_fgColor_6_0= ruleColor )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:605:1: (lv_fgColor_6_0= ruleColor )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:606:3: lv_fgColor_6_0= ruleColor
                            {
                             
                            	        newCompositeNode(grammarAccess.getScannerTokenAccess().getFgColorColorParserRuleCall_3_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleColor_in_ruleScannerToken1312);
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

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:622:4: (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==22) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:622:6: otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) )
                            {
                            otherlv_7=(Token)match(input,22,FOLLOW_22_in_ruleScannerToken1327); 

                                	newLeafNode(otherlv_7, grammarAccess.getScannerTokenAccess().getBgcolorKeyword_3_2_0());
                                
                            otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleScannerToken1339); 

                                	newLeafNode(otherlv_8, grammarAccess.getScannerTokenAccess().getColonKeyword_3_2_1());
                                
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:630:1: ( (lv_bgColor_9_0= ruleColor ) )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:631:1: (lv_bgColor_9_0= ruleColor )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:631:1: (lv_bgColor_9_0= ruleColor )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:632:3: lv_bgColor_9_0= ruleColor
                            {
                             
                            	        newCompositeNode(grammarAccess.getScannerTokenAccess().getBgColorColorParserRuleCall_3_2_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleColor_in_ruleScannerToken1360);
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

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:648:4: (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==23) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:648:6: otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) )
                            {
                            otherlv_10=(Token)match(input,23,FOLLOW_23_in_ruleScannerToken1375); 

                                	newLeafNode(otherlv_10, grammarAccess.getScannerTokenAccess().getFontKeyword_3_3_0());
                                
                            otherlv_11=(Token)match(input,21,FOLLOW_21_in_ruleScannerToken1387); 

                                	newLeafNode(otherlv_11, grammarAccess.getScannerTokenAccess().getColonKeyword_3_3_1());
                                
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:656:1: ( (lv_font_12_0= ruleFont ) )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:657:1: (lv_font_12_0= ruleFont )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:657:1: (lv_font_12_0= ruleFont )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:658:3: lv_font_12_0= ruleFont
                            {
                             
                            	        newCompositeNode(grammarAccess.getScannerTokenAccess().getFontFontParserRuleCall_3_3_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleFont_in_ruleScannerToken1408);
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

                    otherlv_13=(Token)match(input,12,FOLLOW_12_in_ruleScannerToken1422); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:686:1: entryRuleKeywordGroup returns [EObject current=null] : iv_ruleKeywordGroup= ruleKeywordGroup EOF ;
    public final EObject entryRuleKeywordGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordGroup = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:687:2: (iv_ruleKeywordGroup= ruleKeywordGroup EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:688:2: iv_ruleKeywordGroup= ruleKeywordGroup EOF
            {
             newCompositeNode(grammarAccess.getKeywordGroupRule()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup1460);
            iv_ruleKeywordGroup=ruleKeywordGroup();

            state._fsp--;

             current =iv_ruleKeywordGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordGroup1470); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:695:1: ruleKeywordGroup returns [EObject current=null] : (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:698:28: ( (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:699:1: (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:699:1: (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:699:3: otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleKeywordGroup1507); 

                	newLeafNode(otherlv_0, grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:703:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:704:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:704:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:705:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getKeywordGroupRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeywordGroup1527); 

            		newLeafNode(otherlv_1, grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleKeywordGroup1539); 

                	newLeafNode(otherlv_2, grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:720:1: ( (lv_keywords_3_0= ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:721:1: (lv_keywords_3_0= ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:721:1: (lv_keywords_3_0= ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:722:3: lv_keywords_3_0= ruleKeyword
            {
             
            	        newCompositeNode(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleKeyword_in_ruleKeywordGroup1560);
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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:738:2: (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==26) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:738:4: otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) )
            	    {
            	    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleKeywordGroup1573); 

            	        	newLeafNode(otherlv_4, grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0());
            	        
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:742:1: ( (lv_keywords_5_0= ruleKeyword ) )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:743:1: (lv_keywords_5_0= ruleKeyword )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:743:1: (lv_keywords_5_0= ruleKeyword )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:744:3: lv_keywords_5_0= ruleKeyword
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeyword_in_ruleKeywordGroup1594);
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
            	    break loop14;
                }
            } while (true);

            otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleKeywordGroup1608); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:772:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:773:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:774:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword1644);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword1654); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:781:1: ruleKeyword returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_version_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:784:28: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:785:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:785:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:785:2: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:785:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:786:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:786:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:787:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1696); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:803:2: (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:803:4: otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleKeyword1714); 

                        	newLeafNode(otherlv_1, grammarAccess.getKeywordAccess().getSinceKeyword_1_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:807:1: ( (lv_version_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:808:1: (lv_version_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:808:1: (lv_version_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:809:3: lv_version_2_0= RULE_STRING
                    {
                    lv_version_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1731); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:833:1: entryRuleScannerRule returns [EObject current=null] : iv_ruleScannerRule= ruleScannerRule EOF ;
    public final EObject entryRuleScannerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:834:2: (iv_ruleScannerRule= ruleScannerRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:835:2: iv_ruleScannerRule= ruleScannerRule EOF
            {
             newCompositeNode(grammarAccess.getScannerRuleRule()); 
            pushFollow(FOLLOW_ruleScannerRule_in_entryRuleScannerRule1774);
            iv_ruleScannerRule=ruleScannerRule();

            state._fsp--;

             current =iv_ruleScannerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerRule1784); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:842:1: ruleScannerRule returns [EObject current=null] : (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule ) ;
    public final EObject ruleScannerRule() throws RecognitionException {
        EObject current = null;

        EObject this_ScannerSingleLineRule_0 = null;

        EObject this_ScannerMultiLineRule_1 = null;

        EObject this_ScannerCharacterRule_2 = null;

        EObject this_ScannerJSRule_3 = null;

        EObject this_ScannerWhitespaceRule_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:845:28: ( (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:846:1: (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:846:1: (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule )
            int alt16=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt16=1;
                }
                break;
            case 33:
                {
                alt16=2;
                }
                break;
            case 34:
                {
                alt16=3;
                }
                break;
            case 35:
                {
                alt16=4;
                }
                break;
            case 36:
            case 37:
                {
                alt16=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:847:5: this_ScannerSingleLineRule_0= ruleScannerSingleLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleScannerSingleLineRule_in_ruleScannerRule1831);
                    this_ScannerSingleLineRule_0=ruleScannerSingleLineRule();

                    state._fsp--;

                     
                            current = this_ScannerSingleLineRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:857:5: this_ScannerMultiLineRule_1= ruleScannerMultiLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleScannerMultiLineRule_in_ruleScannerRule1858);
                    this_ScannerMultiLineRule_1=ruleScannerMultiLineRule();

                    state._fsp--;

                     
                            current = this_ScannerMultiLineRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:867:5: this_ScannerCharacterRule_2= ruleScannerCharacterRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleScannerCharacterRule_in_ruleScannerRule1885);
                    this_ScannerCharacterRule_2=ruleScannerCharacterRule();

                    state._fsp--;

                     
                            current = this_ScannerCharacterRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:877:5: this_ScannerJSRule_3= ruleScannerJSRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleScannerJSRule_in_ruleScannerRule1912);
                    this_ScannerJSRule_3=ruleScannerJSRule();

                    state._fsp--;

                     
                            current = this_ScannerJSRule_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:887:5: this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerWhitespaceRuleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_ruleScannerRule1939);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:903:1: entryRuleParitionRule returns [EObject current=null] : iv_ruleParitionRule= ruleParitionRule EOF ;
    public final EObject entryRuleParitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitionRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:904:2: (iv_ruleParitionRule= ruleParitionRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:905:2: iv_ruleParitionRule= ruleParitionRule EOF
            {
             newCompositeNode(grammarAccess.getParitionRuleRule()); 
            pushFollow(FOLLOW_ruleParitionRule_in_entryRuleParitionRule1974);
            iv_ruleParitionRule=ruleParitionRule();

            state._fsp--;

             current =iv_ruleParitionRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitionRule1984); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:912:1: ruleParitionRule returns [EObject current=null] : (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule ) ;
    public final EObject ruleParitionRule() throws RecognitionException {
        EObject current = null;

        EObject this_PartitionSingleLineRule_0 = null;

        EObject this_PartitionMultiLineRule_1 = null;

        EObject this_PartitionJSRule_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:915:28: ( (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:916:1: (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:916:1: (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt17=1;
                }
                break;
            case 33:
                {
                alt17=2;
                }
                break;
            case 35:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:917:5: this_PartitionSingleLineRule_0= rulePartitionSingleLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePartitionSingleLineRule_in_ruleParitionRule2031);
                    this_PartitionSingleLineRule_0=rulePartitionSingleLineRule();

                    state._fsp--;

                     
                            current = this_PartitionSingleLineRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:927:5: this_PartitionMultiLineRule_1= rulePartitionMultiLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePartitionMultiLineRule_in_ruleParitionRule2058);
                    this_PartitionMultiLineRule_1=rulePartitionMultiLineRule();

                    state._fsp--;

                     
                            current = this_PartitionMultiLineRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:937:5: this_PartitionJSRule_2= rulePartitionJSRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionJSRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePartitionJSRule_in_ruleParitionRule2085);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:953:1: entryRuleScannerSingleLineRule returns [EObject current=null] : iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF ;
    public final EObject entryRuleScannerSingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerSingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:954:2: (iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:955:2: iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF
            {
             newCompositeNode(grammarAccess.getScannerSingleLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule2120);
            iv_ruleScannerSingleLineRule=ruleScannerSingleLineRule();

            state._fsp--;

             current =iv_ruleScannerSingleLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerSingleLineRule2130); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:962:1: ruleScannerSingleLineRule returns [EObject current=null] : (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:965:28: ( (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:966:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:966:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:966:3: otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleScannerSingleLineRule2167); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:970:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:971:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:971:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:972:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerSingleLineRule2187); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:983:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:984:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:984:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:985:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2204); 

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

            otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleScannerSingleLineRule2221); 

                	newLeafNode(otherlv_3, grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1005:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1006:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1006:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1007:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2238); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1023:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==31) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1023:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleScannerSingleLineRule2256); 

                        	newLeafNode(otherlv_5, grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleScannerSingleLineRule2268); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1031:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1032:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1032:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1033:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2285); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1057:1: entryRulePartitionSingleLineRule returns [EObject current=null] : iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF ;
    public final EObject entryRulePartitionSingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionSingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1058:2: (iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1059:2: iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionSingleLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule2328);
            iv_rulePartitionSingleLineRule=rulePartitionSingleLineRule();

            state._fsp--;

             current =iv_rulePartitionSingleLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionSingleLineRule2338); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1066:1: rulePartitionSingleLineRule returns [EObject current=null] : (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1069:28: ( (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1070:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1070:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1070:3: otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_rulePartitionSingleLineRule2375); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1074:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1075:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1075:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1076:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionSingleLineRule2395); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1087:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1088:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1088:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1089:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2412); 

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

            otherlv_3=(Token)match(input,30,FOLLOW_30_in_rulePartitionSingleLineRule2429); 

                	newLeafNode(otherlv_3, grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1109:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1110:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1110:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1111:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2446); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1127:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1127:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_rulePartitionSingleLineRule2464); 

                        	newLeafNode(otherlv_5, grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,32,FOLLOW_32_in_rulePartitionSingleLineRule2476); 

                        	newLeafNode(otherlv_6, grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1135:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1136:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1136:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1137:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2493); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1161:1: entryRuleScannerMultiLineRule returns [EObject current=null] : iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF ;
    public final EObject entryRuleScannerMultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerMultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1162:2: (iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1163:2: iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF
            {
             newCompositeNode(grammarAccess.getScannerMultiLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule2536);
            iv_ruleScannerMultiLineRule=ruleScannerMultiLineRule();

            state._fsp--;

             current =iv_ruleScannerMultiLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerMultiLineRule2546); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1170:1: ruleScannerMultiLineRule returns [EObject current=null] : (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1173:28: ( (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1174:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1174:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1174:3: otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleScannerMultiLineRule2583); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1178:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1179:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1179:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1180:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerMultiLineRule2603); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1191:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1192:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1192:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1193:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2620); 

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

            otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleScannerMultiLineRule2637); 

                	newLeafNode(otherlv_3, grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1213:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1214:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1214:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1215:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2654); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1231:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1231:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleScannerMultiLineRule2672); 

                        	newLeafNode(otherlv_5, grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleScannerMultiLineRule2684); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1239:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1240:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1240:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1241:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2701); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1265:1: entryRulePartitionMultiLineRule returns [EObject current=null] : iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF ;
    public final EObject entryRulePartitionMultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionMultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1266:2: (iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1267:2: iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionMultiLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule2744);
            iv_rulePartitionMultiLineRule=rulePartitionMultiLineRule();

            state._fsp--;

             current =iv_rulePartitionMultiLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionMultiLineRule2754); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1274:1: rulePartitionMultiLineRule returns [EObject current=null] : (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1277:28: ( (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1278:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1278:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1278:3: otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_rulePartitionMultiLineRule2791); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1282:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1283:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1283:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1284:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionMultiLineRule2811); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionMultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1295:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1296:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1296:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1297:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2828); 

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

            otherlv_3=(Token)match(input,30,FOLLOW_30_in_rulePartitionMultiLineRule2845); 

                	newLeafNode(otherlv_3, grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1317:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1318:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1318:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1319:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2862); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1335:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1335:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_rulePartitionMultiLineRule2880); 

                        	newLeafNode(otherlv_5, grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,32,FOLLOW_32_in_rulePartitionMultiLineRule2892); 

                        	newLeafNode(otherlv_6, grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1343:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1344:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1344:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1345:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2909); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1369:1: entryRuleScannerCharacterRule returns [EObject current=null] : iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF ;
    public final EObject entryRuleScannerCharacterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerCharacterRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1370:2: (iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1371:2: iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF
            {
             newCompositeNode(grammarAccess.getScannerCharacterRuleRule()); 
            pushFollow(FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule2952);
            iv_ruleScannerCharacterRule=ruleScannerCharacterRule();

            state._fsp--;

             current =iv_ruleScannerCharacterRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerCharacterRule2962); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1378:1: ruleScannerCharacterRule returns [EObject current=null] : (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1381:28: ( (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1382:1: (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1382:1: (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1382:3: otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleScannerCharacterRule2999); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1386:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1387:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1387:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1388:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerCharacterRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerCharacterRule3019); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleScannerCharacterRule3031); 

                	newLeafNode(otherlv_2, grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1403:1: ( (lv_characters_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1404:1: (lv_characters_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1404:1: (lv_characters_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1405:3: lv_characters_3_0= RULE_STRING
            {
            lv_characters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3048); 

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

            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleScannerCharacterRule3065); 

                	newLeafNode(otherlv_4, grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1425:1: ( (lv_characters_5_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1426:1: (lv_characters_5_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1426:1: (lv_characters_5_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1427:3: lv_characters_5_0= RULE_STRING
            {
            lv_characters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3082); 

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

            otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleScannerCharacterRule3099); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1455:1: entryRuleScannerJSRule returns [EObject current=null] : iv_ruleScannerJSRule= ruleScannerJSRule EOF ;
    public final EObject entryRuleScannerJSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerJSRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1456:2: (iv_ruleScannerJSRule= ruleScannerJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1457:2: iv_ruleScannerJSRule= ruleScannerJSRule EOF
            {
             newCompositeNode(grammarAccess.getScannerJSRuleRule()); 
            pushFollow(FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule3135);
            iv_ruleScannerJSRule=ruleScannerJSRule();

            state._fsp--;

             current =iv_ruleScannerJSRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerJSRule3145); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1464:1: ruleScannerJSRule returns [EObject current=null] : (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleScannerJSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1467:28: ( (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1468:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1468:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1468:3: otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleScannerJSRule3182); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1472:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1473:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1473:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1474:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerJSRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerJSRule3202); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1485:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1486:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1486:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1487:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerJSRule3219); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1511:1: entryRulePartitionJSRule returns [EObject current=null] : iv_rulePartitionJSRule= rulePartitionJSRule EOF ;
    public final EObject entryRulePartitionJSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionJSRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1512:2: (iv_rulePartitionJSRule= rulePartitionJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1513:2: iv_rulePartitionJSRule= rulePartitionJSRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionJSRuleRule()); 
            pushFollow(FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule3260);
            iv_rulePartitionJSRule=rulePartitionJSRule();

            state._fsp--;

             current =iv_rulePartitionJSRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionJSRule3270); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1520:1: rulePartitionJSRule returns [EObject current=null] : (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePartitionJSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1523:28: ( (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1524:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1524:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1524:3: otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_rulePartitionJSRule3307); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1528:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1529:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1529:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1530:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionJSRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionJSRule3327); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1541:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1542:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1542:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1543:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionJSRule3344); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1567:1: entryRuleScannerWhitespaceRule returns [EObject current=null] : iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF ;
    public final EObject entryRuleScannerWhitespaceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerWhitespaceRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1568:2: (iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1569:2: iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF
            {
             newCompositeNode(grammarAccess.getScannerWhitespaceRuleRule()); 
            pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule3385);
            iv_ruleScannerWhitespaceRule=ruleScannerWhitespaceRule();

            state._fsp--;

             current =iv_ruleScannerWhitespaceRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerWhitespaceRule3395); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1576:1: ruleScannerWhitespaceRule returns [EObject current=null] : ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1579:28: ( ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1580:1: ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1580:1: ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            else if ( (LA24_0==37) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1580:2: (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1580:2: (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1580:4: otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' )
                    {
                    otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleScannerWhitespaceRule3433); 

                        	newLeafNode(otherlv_0, grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1584:1: ( (otherlv_1= RULE_ID ) )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==RULE_ID) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1585:1: (otherlv_1= RULE_ID )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1585:1: (otherlv_1= RULE_ID )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1586:3: otherlv_1= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                            	        }
                                    
                            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerWhitespaceRule3453); 

                            		newLeafNode(otherlv_1, grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_0_1_0()); 
                            	

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1597:3: (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1597:5: otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleScannerWhitespaceRule3467); 

                        	newLeafNode(otherlv_2, grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_0_2_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1601:1: ( (lv_characters_3_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1602:1: (lv_characters_3_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1602:1: (lv_characters_3_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1603:3: lv_characters_3_0= RULE_STRING
                    {
                    lv_characters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3484); 

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

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1619:2: (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==26) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1619:4: otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleScannerWhitespaceRule3502); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_0_2_2_0());
                    	        
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1623:1: ( (lv_characters_5_0= RULE_STRING ) )
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1624:1: (lv_characters_5_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1624:1: (lv_characters_5_0= RULE_STRING )
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1625:3: lv_characters_5_0= RULE_STRING
                    	    {
                    	    lv_characters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3519); 

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
                    	    break loop23;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleScannerWhitespaceRule3538); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_0_2_3());
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1646:6: (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1646:6: (otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1646:8: otherlv_7= '#{' ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#'
                    {
                    otherlv_7=(Token)match(input,37,FOLLOW_37_in_ruleScannerWhitespaceRule3559); 

                        	newLeafNode(otherlv_7, grammarAccess.getScannerWhitespaceRuleAccess().getNumberSignLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1650:1: ( (lv_jsDetector_8_0= RULE_ANY_OTHER ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1651:1: (lv_jsDetector_8_0= RULE_ANY_OTHER )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1651:1: (lv_jsDetector_8_0= RULE_ANY_OTHER )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1652:3: lv_jsDetector_8_0= RULE_ANY_OTHER
                    {
                    lv_jsDetector_8_0=(Token)match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_ruleScannerWhitespaceRule3576); 

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

                    otherlv_9=(Token)match(input,38,FOLLOW_38_in_ruleScannerWhitespaceRule3593); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1680:1: entryRuleColor returns [EObject current=null] : iv_ruleColor= ruleColor EOF ;
    public final EObject entryRuleColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColor = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1681:2: (iv_ruleColor= ruleColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1682:2: iv_ruleColor= ruleColor EOF
            {
             newCompositeNode(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor3630);
            iv_ruleColor=ruleColor();

            state._fsp--;

             current =iv_ruleColor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor3640); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1689:1: ruleColor returns [EObject current=null] : this_RGBColor_0= ruleRGBColor ;
    public final EObject ruleColor() throws RecognitionException {
        EObject current = null;

        EObject this_RGBColor_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1692:28: (this_RGBColor_0= ruleRGBColor )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1694:5: this_RGBColor_0= ruleRGBColor
            {
             
                    newCompositeNode(grammarAccess.getColorAccess().getRGBColorParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleRGBColor_in_ruleColor3686);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1710:1: entryRuleRGBColor returns [EObject current=null] : iv_ruleRGBColor= ruleRGBColor EOF ;
    public final EObject entryRuleRGBColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRGBColor = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1711:2: (iv_ruleRGBColor= ruleRGBColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1712:2: iv_ruleRGBColor= ruleRGBColor EOF
            {
             newCompositeNode(grammarAccess.getRGBColorRule()); 
            pushFollow(FOLLOW_ruleRGBColor_in_entryRuleRGBColor3720);
            iv_ruleRGBColor=ruleRGBColor();

            state._fsp--;

             current =iv_ruleRGBColor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGBColor3730); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1719:1: ruleRGBColor returns [EObject current=null] : (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1722:28: ( (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1723:1: (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1723:1: (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1723:3: otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleRGBColor3767); 

                	newLeafNode(otherlv_0, grammarAccess.getRGBColorAccess().getRgbKeyword_0());
                
            otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleRGBColor3779); 

                	newLeafNode(otherlv_1, grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1731:1: ( (lv_r_2_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1732:1: (lv_r_2_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1732:1: (lv_r_2_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1733:3: lv_r_2_0= RULE_INT
            {
            lv_r_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3796); 

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

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleRGBColor3813); 

                	newLeafNode(otherlv_3, grammarAccess.getRGBColorAccess().getCommaKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1753:1: ( (lv_g_4_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1754:1: (lv_g_4_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1754:1: (lv_g_4_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1755:3: lv_g_4_0= RULE_INT
            {
            lv_g_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3830); 

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

            otherlv_5=(Token)match(input,26,FOLLOW_26_in_ruleRGBColor3847); 

                	newLeafNode(otherlv_5, grammarAccess.getRGBColorAccess().getCommaKeyword_5());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1775:1: ( (lv_b_6_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1776:1: (lv_b_6_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1776:1: (lv_b_6_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1777:3: lv_b_6_0= RULE_INT
            {
            lv_b_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3864); 

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

            otherlv_7=(Token)match(input,41,FOLLOW_41_in_ruleRGBColor3881); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1805:1: entryRuleFont returns [EObject current=null] : iv_ruleFont= ruleFont EOF ;
    public final EObject entryRuleFont() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFont = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1806:2: (iv_ruleFont= ruleFont EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1807:2: iv_ruleFont= ruleFont EOF
            {
             newCompositeNode(grammarAccess.getFontRule()); 
            pushFollow(FOLLOW_ruleFont_in_entryRuleFont3917);
            iv_ruleFont=ruleFont();

            state._fsp--;

             current =iv_ruleFont; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFont3927); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1814:1: ruleFont returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* ) ;
    public final EObject ruleFont() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_size_1_0=null;
        Enumerator lv_attributes_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1817:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1818:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1818:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1818:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )*
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1818:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1819:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1819:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1820:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFont3969); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1836:2: ( (lv_size_1_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1837:1: (lv_size_1_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1837:1: (lv_size_1_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1838:3: lv_size_1_0= RULE_INT
            {
            lv_size_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFont3991); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1854:2: ( (lv_attributes_2_0= ruleFontType ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=42 && LA25_0<=45)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1855:1: (lv_attributes_2_0= ruleFontType )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1855:1: (lv_attributes_2_0= ruleFontType )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1856:3: lv_attributes_2_0= ruleFontType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFontAccess().getAttributesFontTypeEnumRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFontType_in_ruleFont4017);
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
            	    break loop25;
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1880:1: ruleFontType returns [Enumerator current=null] : ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) ) ;
    public final Enumerator ruleFontType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1882:28: ( ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1883:1: ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1883:1: ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt26=1;
                }
                break;
            case 43:
                {
                alt26=2;
                }
                break;
            case 44:
                {
                alt26=3;
                }
                break;
            case 45:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1883:2: (enumLiteral_0= 'bold' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1883:2: (enumLiteral_0= 'bold' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1883:4: enumLiteral_0= 'bold'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_42_in_ruleFontType4068); 

                            current = grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1889:6: (enumLiteral_1= 'italic' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1889:6: (enumLiteral_1= 'italic' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1889:8: enumLiteral_1= 'italic'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_43_in_ruleFontType4085); 

                            current = grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1895:6: (enumLiteral_2= 'underline' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1895:6: (enumLiteral_2= 'underline' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1895:8: enumLiteral_2= 'underline'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_44_in_ruleFontType4102); 

                            current = grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1901:6: (enumLiteral_3= 'strike-through' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1901:6: (enumLiteral_3= 'strike-through' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1901:8: enumLiteral_3= 'strike-through'
                    {
                    enumLiteral_3=(Token)match(input,45,FOLLOW_45_in_ruleFontType4119); 

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
    public static final BitSet FOLLOW_11_in_ruleModel144 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rulePartition_in_ruleModel165 = new BitSet(new long[]{0x0000000000032000L});
    public static final BitSet FOLLOW_ruleDamager_in_ruleModel187 = new BitSet(new long[]{0x000000000003C000L});
    public static final BitSet FOLLOW_rulePartitioner_in_ruleModel209 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleModel221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_entryRulePartition257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePartition304 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_entryRulePartitioner362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_rulePartitioner419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_rulePartitioner446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRulePartitioner_in_entryRuleRulePartitioner481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRulePartitioner491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleRulePartitioner528 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleRulePartitioner540 = new BitSet(new long[]{0x0000000A20000000L});
    public static final BitSet FOLLOW_ruleParitionRule_in_ruleRulePartitioner561 = new BitSet(new long[]{0x0000000A20001000L});
    public static final BitSet FOLLOW_12_in_ruleRulePartitioner574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSParitioner620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleJSParitioner657 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJSParitioner674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDamager_in_entryRuleDamager715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDamager725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_ruleDamager772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_ruleDamager799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSDamager_in_entryRuleJSDamager834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSDamager844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleJSDamager881 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJSDamager901 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJSDamager918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDamager_in_entryRuleRuleDamager959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDamager969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleRuleDamager1006 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleDamager1026 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleRuleDamager1038 = new BitSet(new long[]{0x0000003E210C0000L});
    public static final BitSet FOLLOW_ruleScannerToken_in_ruleRuleDamager1059 = new BitSet(new long[]{0x0000003E210C0000L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_ruleRuleDamager1081 = new BitSet(new long[]{0x0000003E210C0000L});
    public static final BitSet FOLLOW_ruleScannerRule_in_ruleRuleDamager1103 = new BitSet(new long[]{0x0000003E210C1000L});
    public static final BitSet FOLLOW_12_in_ruleRuleDamager1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_entryRuleScannerToken1152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerToken1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleScannerToken1205 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleScannerToken1231 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerToken1248 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_ruleScannerToken1266 = new BitSet(new long[]{0x0000000000D01000L});
    public static final BitSet FOLLOW_20_in_ruleScannerToken1279 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleScannerToken1291 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleScannerToken1312 = new BitSet(new long[]{0x0000000000C01000L});
    public static final BitSet FOLLOW_22_in_ruleScannerToken1327 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleScannerToken1339 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleScannerToken1360 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_23_in_ruleScannerToken1375 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleScannerToken1387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFont_in_ruleScannerToken1408 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleScannerToken1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup1460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordGroup1470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleKeywordGroup1507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeywordGroup1527 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleKeywordGroup1539 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleKeywordGroup1560 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleKeywordGroup1573 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleKeywordGroup1594 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_27_in_ruleKeywordGroup1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword1644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1696 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleKeyword1714 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_entryRuleScannerRule1774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerRule1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_ruleScannerRule1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_ruleScannerRule1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_ruleScannerRule1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_ruleScannerRule1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_ruleScannerRule1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_entryRuleParitionRule1974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitionRule1984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_ruleParitionRule2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_ruleParitionRule2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_ruleParitionRule2085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule2120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerSingleLineRule2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleScannerSingleLineRule2167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerSingleLineRule2187 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2204 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleScannerSingleLineRule2221 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2238 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleScannerSingleLineRule2256 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleScannerSingleLineRule2268 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule2328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionSingleLineRule2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rulePartitionSingleLineRule2375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionSingleLineRule2395 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2412 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rulePartitionSingleLineRule2429 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2446 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rulePartitionSingleLineRule2464 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_rulePartitionSingleLineRule2476 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule2536 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerMultiLineRule2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleScannerMultiLineRule2583 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerMultiLineRule2603 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2620 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleScannerMultiLineRule2637 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2654 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleScannerMultiLineRule2672 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleScannerMultiLineRule2684 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule2744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionMultiLineRule2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rulePartitionMultiLineRule2791 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionMultiLineRule2811 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2828 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rulePartitionMultiLineRule2845 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2862 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rulePartitionMultiLineRule2880 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_rulePartitionMultiLineRule2892 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule2952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerCharacterRule2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleScannerCharacterRule2999 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerCharacterRule3019 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleScannerCharacterRule3031 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3048 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleScannerCharacterRule3065 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerCharacterRule3082 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleScannerCharacterRule3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule3135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerJSRule3145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleScannerJSRule3182 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerJSRule3202 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerJSRule3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule3260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionJSRule3270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rulePartitionJSRule3307 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionJSRule3327 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionJSRule3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule3385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerWhitespaceRule3395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleScannerWhitespaceRule3433 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerWhitespaceRule3453 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleScannerWhitespaceRule3467 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3484 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleScannerWhitespaceRule3502 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3519 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_27_in_ruleScannerWhitespaceRule3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleScannerWhitespaceRule3559 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleScannerWhitespaceRule3576 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleScannerWhitespaceRule3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor3630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_ruleColor3686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_entryRuleRGBColor3720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGBColor3730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleRGBColor3767 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleRGBColor3779 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3796 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleRGBColor3813 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3830 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleRGBColor3847 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3864 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleRGBColor3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFont_in_entryRuleFont3917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFont3927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFont3969 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFont3991 = new BitSet(new long[]{0x00003C0000000002L});
    public static final BitSet FOLLOW_ruleFontType_in_ruleFont4017 = new BitSet(new long[]{0x00003C0000000002L});
    public static final BitSet FOLLOW_42_in_ruleFontType4068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleFontType4085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleFontType4102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFontType4119 = new BitSet(new long[]{0x0000000000000002L});

}