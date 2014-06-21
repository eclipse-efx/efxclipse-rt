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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'{'", "'}'", "'partition'", "'rule-partitioner'", "'js-partitioner'", "'scanner'", "'default'", "'token'", "'fgcolor'", "':'", "'bgcolor'", "'font'", "'keywords'", "'['", "','", "']'", "'since'", "'single-line'", "'=>'", "'escaped'", "'by'", "'multi-line'", "'character-rule'", "'javascript-rule'", "'whitespace-rule'", "'#{'", "'}#'", "'rgb'", "'('", "')'", "'bold'", "'italic'", "'underline'", "'strike-through'"
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_scanner_3_0= ruleScanner ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_partitions_2_0 = null;

        EObject lv_scanner_3_0 = null;

        EObject lv_partitioner_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:80:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_scanner_3_0= ruleScanner ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:81:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_scanner_3_0= ruleScanner ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:81:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_scanner_3_0= ruleScanner ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:81:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_scanner_3_0= ruleScanner ) )+ ( (lv_partitioner_4_0= rulePartitioner ) ) otherlv_5= '}'
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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:121:3: ( (lv_scanner_3_0= ruleScanner ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:122:1: (lv_scanner_3_0= ruleScanner )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:122:1: (lv_scanner_3_0= ruleScanner )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:123:3: lv_scanner_3_0= ruleScanner
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getScannerScannerParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScanner_in_ruleModel187);
            	    lv_scanner_3_0=ruleScanner();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"scanner",
            	            		lv_scanner_3_0, 
            	            		"Scanner");
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

                if ( (LA4_0==28||LA4_0==32||LA4_0==34) ) {
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


    // $ANTLR start "entryRuleScanner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:346:1: entryRuleScanner returns [EObject current=null] : iv_ruleScanner= ruleScanner EOF ;
    public final EObject entryRuleScanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:347:2: (iv_ruleScanner= ruleScanner EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:348:2: iv_ruleScanner= ruleScanner EOF
            {
             newCompositeNode(grammarAccess.getScannerRule()); 
            pushFollow(FOLLOW_ruleScanner_in_entryRuleScanner715);
            iv_ruleScanner=ruleScanner();

            state._fsp--;

             current =iv_ruleScanner; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner725); 

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
    // $ANTLR end "entryRuleScanner"


    // $ANTLR start "ruleScanner"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:355:1: ruleScanner returns [EObject current=null] : (otherlv_0= 'scanner' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' ) ;
    public final EObject ruleScanner() throws RecognitionException {
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:358:28: ( (otherlv_0= 'scanner' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:359:1: (otherlv_0= 'scanner' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:359:1: (otherlv_0= 'scanner' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:359:3: otherlv_0= 'scanner' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokens_3_0= ruleScannerToken ) )* ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )* ( (lv_rules_5_0= ruleScannerRule ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleScanner762); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerAccess().getScannerKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:363:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:364:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:364:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:365:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScanner782); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerAccess().getPartitionPartitionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleScanner794); 

                	newLeafNode(otherlv_2, grammarAccess.getScannerAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:380:1: ( (lv_tokens_3_0= ruleScannerToken ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=17 && LA5_0<=18)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:381:1: (lv_tokens_3_0= ruleScannerToken )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:381:1: (lv_tokens_3_0= ruleScannerToken )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:382:3: lv_tokens_3_0= ruleScannerToken
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScannerAccess().getTokensScannerTokenParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScannerToken_in_ruleScanner815);
            	    lv_tokens_3_0=ruleScannerToken();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScannerRule());
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
            	    break loop5;
                }
            } while (true);

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:398:3: ( (lv_keywordGroups_4_0= ruleKeywordGroup ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==23) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:399:1: (lv_keywordGroups_4_0= ruleKeywordGroup )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:399:1: (lv_keywordGroups_4_0= ruleKeywordGroup )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:400:3: lv_keywordGroups_4_0= ruleKeywordGroup
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScannerAccess().getKeywordGroupsKeywordGroupParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeywordGroup_in_ruleScanner837);
            	    lv_keywordGroups_4_0=ruleKeywordGroup();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScannerRule());
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
            	    break loop6;
                }
            } while (true);

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:416:3: ( (lv_rules_5_0= ruleScannerRule ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==28||(LA7_0>=32 && LA7_0<=36)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:417:1: (lv_rules_5_0= ruleScannerRule )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:417:1: (lv_rules_5_0= ruleScannerRule )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:418:3: lv_rules_5_0= ruleScannerRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScannerAccess().getRulesScannerRuleParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleScannerRule_in_ruleScanner859);
            	    lv_rules_5_0=ruleScannerRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScannerRule());
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
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            otherlv_6=(Token)match(input,12,FOLLOW_12_in_ruleScanner872); 

                	newLeafNode(otherlv_6, grammarAccess.getScannerAccess().getRightCurlyBracketKeyword_6());
                

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
    // $ANTLR end "ruleScanner"


    // $ANTLR start "entryRuleScannerToken"
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:446:1: entryRuleScannerToken returns [EObject current=null] : iv_ruleScannerToken= ruleScannerToken EOF ;
    public final EObject entryRuleScannerToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerToken = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:447:2: (iv_ruleScannerToken= ruleScannerToken EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:448:2: iv_ruleScannerToken= ruleScannerToken EOF
            {
             newCompositeNode(grammarAccess.getScannerTokenRule()); 
            pushFollow(FOLLOW_ruleScannerToken_in_entryRuleScannerToken908);
            iv_ruleScannerToken=ruleScannerToken();

            state._fsp--;

             current =iv_ruleScannerToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerToken918); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:455:1: ruleScannerToken returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:458:28: ( ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:459:1: ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:459:1: ( ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:459:2: ( (lv_default_0_0= 'default' ) )? otherlv_1= 'token' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:459:2: ( (lv_default_0_0= 'default' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:460:1: (lv_default_0_0= 'default' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:460:1: (lv_default_0_0= 'default' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:461:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,17,FOLLOW_17_in_ruleScannerToken961); 

                            newLeafNode(lv_default_0_0, grammarAccess.getScannerTokenAccess().getDefaultDefaultKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerTokenRule());
                    	        }
                           		setWithLastConsumed(current, "default", true, "default");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleScannerToken987); 

                	newLeafNode(otherlv_1, grammarAccess.getScannerTokenAccess().getTokenKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:478:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:479:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:479:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:480:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerToken1004); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:496:2: (otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==11) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:496:4: otherlv_3= '{' (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )? (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )? (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )? otherlv_13= '}'
                    {
                    otherlv_3=(Token)match(input,11,FOLLOW_11_in_ruleScannerToken1022); 

                        	newLeafNode(otherlv_3, grammarAccess.getScannerTokenAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:500:1: (otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==19) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:500:3: otherlv_4= 'fgcolor' otherlv_5= ':' ( (lv_fgColor_6_0= ruleColor ) )
                            {
                            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleScannerToken1035); 

                                	newLeafNode(otherlv_4, grammarAccess.getScannerTokenAccess().getFgcolorKeyword_3_1_0());
                                
                            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleScannerToken1047); 

                                	newLeafNode(otherlv_5, grammarAccess.getScannerTokenAccess().getColonKeyword_3_1_1());
                                
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:508:1: ( (lv_fgColor_6_0= ruleColor ) )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:509:1: (lv_fgColor_6_0= ruleColor )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:509:1: (lv_fgColor_6_0= ruleColor )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:510:3: lv_fgColor_6_0= ruleColor
                            {
                             
                            	        newCompositeNode(grammarAccess.getScannerTokenAccess().getFgColorColorParserRuleCall_3_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleColor_in_ruleScannerToken1068);
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

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:526:4: (otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==21) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:526:6: otherlv_7= 'bgcolor' otherlv_8= ':' ( (lv_bgColor_9_0= ruleColor ) )
                            {
                            otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleScannerToken1083); 

                                	newLeafNode(otherlv_7, grammarAccess.getScannerTokenAccess().getBgcolorKeyword_3_2_0());
                                
                            otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleScannerToken1095); 

                                	newLeafNode(otherlv_8, grammarAccess.getScannerTokenAccess().getColonKeyword_3_2_1());
                                
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:534:1: ( (lv_bgColor_9_0= ruleColor ) )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:535:1: (lv_bgColor_9_0= ruleColor )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:535:1: (lv_bgColor_9_0= ruleColor )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:536:3: lv_bgColor_9_0= ruleColor
                            {
                             
                            	        newCompositeNode(grammarAccess.getScannerTokenAccess().getBgColorColorParserRuleCall_3_2_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleColor_in_ruleScannerToken1116);
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

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:552:4: (otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==22) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:552:6: otherlv_10= 'font' otherlv_11= ':' ( (lv_font_12_0= ruleFont ) )
                            {
                            otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleScannerToken1131); 

                                	newLeafNode(otherlv_10, grammarAccess.getScannerTokenAccess().getFontKeyword_3_3_0());
                                
                            otherlv_11=(Token)match(input,20,FOLLOW_20_in_ruleScannerToken1143); 

                                	newLeafNode(otherlv_11, grammarAccess.getScannerTokenAccess().getColonKeyword_3_3_1());
                                
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:560:1: ( (lv_font_12_0= ruleFont ) )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:561:1: (lv_font_12_0= ruleFont )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:561:1: (lv_font_12_0= ruleFont )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:562:3: lv_font_12_0= ruleFont
                            {
                             
                            	        newCompositeNode(grammarAccess.getScannerTokenAccess().getFontFontParserRuleCall_3_3_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleFont_in_ruleScannerToken1164);
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

                    otherlv_13=(Token)match(input,12,FOLLOW_12_in_ruleScannerToken1178); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:590:1: entryRuleKeywordGroup returns [EObject current=null] : iv_ruleKeywordGroup= ruleKeywordGroup EOF ;
    public final EObject entryRuleKeywordGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordGroup = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:591:2: (iv_ruleKeywordGroup= ruleKeywordGroup EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:592:2: iv_ruleKeywordGroup= ruleKeywordGroup EOF
            {
             newCompositeNode(grammarAccess.getKeywordGroupRule()); 
            pushFollow(FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup1216);
            iv_ruleKeywordGroup=ruleKeywordGroup();

            state._fsp--;

             current =iv_ruleKeywordGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordGroup1226); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:599:1: ruleKeywordGroup returns [EObject current=null] : (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:602:28: ( (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:603:1: (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:603:1: (otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:603:3: otherlv_0= 'keywords' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_keywords_3_0= ruleKeyword ) ) (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )* otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleKeywordGroup1263); 

                	newLeafNode(otherlv_0, grammarAccess.getKeywordGroupAccess().getKeywordsKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:607:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:608:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:608:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:609:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getKeywordGroupRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeywordGroup1283); 

            		newLeafNode(otherlv_1, grammarAccess.getKeywordGroupAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleKeywordGroup1295); 

                	newLeafNode(otherlv_2, grammarAccess.getKeywordGroupAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:624:1: ( (lv_keywords_3_0= ruleKeyword ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:625:1: (lv_keywords_3_0= ruleKeyword )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:625:1: (lv_keywords_3_0= ruleKeyword )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:626:3: lv_keywords_3_0= ruleKeyword
            {
             
            	        newCompositeNode(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleKeyword_in_ruleKeywordGroup1316);
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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:642:2: (otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==25) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:642:4: otherlv_4= ',' ( (lv_keywords_5_0= ruleKeyword ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleKeywordGroup1329); 

            	        	newLeafNode(otherlv_4, grammarAccess.getKeywordGroupAccess().getCommaKeyword_4_0());
            	        
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:646:1: ( (lv_keywords_5_0= ruleKeyword ) )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:647:1: (lv_keywords_5_0= ruleKeyword )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:647:1: (lv_keywords_5_0= ruleKeyword )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:648:3: lv_keywords_5_0= ruleKeyword
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getKeywordGroupAccess().getKeywordsKeywordParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeyword_in_ruleKeywordGroup1350);
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
            	    break loop13;
                }
            } while (true);

            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleKeywordGroup1364); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:676:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:677:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:678:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword1400);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword1410); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:685:1: ruleKeyword returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_version_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:688:28: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:689:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:689:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:689:2: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:689:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:690:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:690:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:691:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1452); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:707:2: (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:707:4: otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleKeyword1470); 

                        	newLeafNode(otherlv_1, grammarAccess.getKeywordAccess().getSinceKeyword_1_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:711:1: ( (lv_version_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:712:1: (lv_version_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:712:1: (lv_version_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:713:3: lv_version_2_0= RULE_STRING
                    {
                    lv_version_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1487); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:737:1: entryRuleScannerRule returns [EObject current=null] : iv_ruleScannerRule= ruleScannerRule EOF ;
    public final EObject entryRuleScannerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:738:2: (iv_ruleScannerRule= ruleScannerRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:739:2: iv_ruleScannerRule= ruleScannerRule EOF
            {
             newCompositeNode(grammarAccess.getScannerRuleRule()); 
            pushFollow(FOLLOW_ruleScannerRule_in_entryRuleScannerRule1530);
            iv_ruleScannerRule=ruleScannerRule();

            state._fsp--;

             current =iv_ruleScannerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerRule1540); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:746:1: ruleScannerRule returns [EObject current=null] : (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule ) ;
    public final EObject ruleScannerRule() throws RecognitionException {
        EObject current = null;

        EObject this_ScannerSingleLineRule_0 = null;

        EObject this_ScannerMultiLineRule_1 = null;

        EObject this_ScannerCharacterRule_2 = null;

        EObject this_ScannerJSRule_3 = null;

        EObject this_ScannerWhitespaceRule_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:749:28: ( (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:750:1: (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:750:1: (this_ScannerSingleLineRule_0= ruleScannerSingleLineRule | this_ScannerMultiLineRule_1= ruleScannerMultiLineRule | this_ScannerCharacterRule_2= ruleScannerCharacterRule | this_ScannerJSRule_3= ruleScannerJSRule | this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule )
            int alt15=5;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt15=1;
                }
                break;
            case 32:
                {
                alt15=2;
                }
                break;
            case 33:
                {
                alt15=3;
                }
                break;
            case 34:
                {
                alt15=4;
                }
                break;
            case 35:
            case 36:
                {
                alt15=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:751:5: this_ScannerSingleLineRule_0= ruleScannerSingleLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerSingleLineRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleScannerSingleLineRule_in_ruleScannerRule1587);
                    this_ScannerSingleLineRule_0=ruleScannerSingleLineRule();

                    state._fsp--;

                     
                            current = this_ScannerSingleLineRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:761:5: this_ScannerMultiLineRule_1= ruleScannerMultiLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerMultiLineRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleScannerMultiLineRule_in_ruleScannerRule1614);
                    this_ScannerMultiLineRule_1=ruleScannerMultiLineRule();

                    state._fsp--;

                     
                            current = this_ScannerMultiLineRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:771:5: this_ScannerCharacterRule_2= ruleScannerCharacterRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerCharacterRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleScannerCharacterRule_in_ruleScannerRule1641);
                    this_ScannerCharacterRule_2=ruleScannerCharacterRule();

                    state._fsp--;

                     
                            current = this_ScannerCharacterRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:781:5: this_ScannerJSRule_3= ruleScannerJSRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerJSRuleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleScannerJSRule_in_ruleScannerRule1668);
                    this_ScannerJSRule_3=ruleScannerJSRule();

                    state._fsp--;

                     
                            current = this_ScannerJSRule_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:791:5: this_ScannerWhitespaceRule_4= ruleScannerWhitespaceRule
                    {
                     
                            newCompositeNode(grammarAccess.getScannerRuleAccess().getScannerWhitespaceRuleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_ruleScannerRule1695);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:807:1: entryRuleParitionRule returns [EObject current=null] : iv_ruleParitionRule= ruleParitionRule EOF ;
    public final EObject entryRuleParitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitionRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:808:2: (iv_ruleParitionRule= ruleParitionRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:809:2: iv_ruleParitionRule= ruleParitionRule EOF
            {
             newCompositeNode(grammarAccess.getParitionRuleRule()); 
            pushFollow(FOLLOW_ruleParitionRule_in_entryRuleParitionRule1730);
            iv_ruleParitionRule=ruleParitionRule();

            state._fsp--;

             current =iv_ruleParitionRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitionRule1740); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:816:1: ruleParitionRule returns [EObject current=null] : (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule ) ;
    public final EObject ruleParitionRule() throws RecognitionException {
        EObject current = null;

        EObject this_PartitionSingleLineRule_0 = null;

        EObject this_PartitionMultiLineRule_1 = null;

        EObject this_PartitionJSRule_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:819:28: ( (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:820:1: (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:820:1: (this_PartitionSingleLineRule_0= rulePartitionSingleLineRule | this_PartitionMultiLineRule_1= rulePartitionMultiLineRule | this_PartitionJSRule_2= rulePartitionJSRule )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt16=1;
                }
                break;
            case 32:
                {
                alt16=2;
                }
                break;
            case 34:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:821:5: this_PartitionSingleLineRule_0= rulePartitionSingleLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionSingleLineRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePartitionSingleLineRule_in_ruleParitionRule1787);
                    this_PartitionSingleLineRule_0=rulePartitionSingleLineRule();

                    state._fsp--;

                     
                            current = this_PartitionSingleLineRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:831:5: this_PartitionMultiLineRule_1= rulePartitionMultiLineRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionMultiLineRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePartitionMultiLineRule_in_ruleParitionRule1814);
                    this_PartitionMultiLineRule_1=rulePartitionMultiLineRule();

                    state._fsp--;

                     
                            current = this_PartitionMultiLineRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:841:5: this_PartitionJSRule_2= rulePartitionJSRule
                    {
                     
                            newCompositeNode(grammarAccess.getParitionRuleAccess().getPartitionJSRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePartitionJSRule_in_ruleParitionRule1841);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:857:1: entryRuleScannerSingleLineRule returns [EObject current=null] : iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF ;
    public final EObject entryRuleScannerSingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerSingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:858:2: (iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:859:2: iv_ruleScannerSingleLineRule= ruleScannerSingleLineRule EOF
            {
             newCompositeNode(grammarAccess.getScannerSingleLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule1876);
            iv_ruleScannerSingleLineRule=ruleScannerSingleLineRule();

            state._fsp--;

             current =iv_ruleScannerSingleLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerSingleLineRule1886); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:866:1: ruleScannerSingleLineRule returns [EObject current=null] : (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:869:28: ( (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:870:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:870:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:870:3: otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleScannerSingleLineRule1923); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:874:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:875:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:875:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:876:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerSingleLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerSingleLineRule1943); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerSingleLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:887:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:888:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:888:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:889:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule1960); 

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

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleScannerSingleLineRule1977); 

                	newLeafNode(otherlv_3, grammarAccess.getScannerSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:909:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:910:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:910:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:911:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule1994); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:927:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==30) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:927:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleScannerSingleLineRule2012); 

                        	newLeafNode(otherlv_5, grammarAccess.getScannerSingleLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,31,FOLLOW_31_in_ruleScannerSingleLineRule2024); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerSingleLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:935:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:936:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:936:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:937:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2041); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:961:1: entryRulePartitionSingleLineRule returns [EObject current=null] : iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF ;
    public final EObject entryRulePartitionSingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionSingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:962:2: (iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:963:2: iv_rulePartitionSingleLineRule= rulePartitionSingleLineRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionSingleLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule2084);
            iv_rulePartitionSingleLineRule=rulePartitionSingleLineRule();

            state._fsp--;

             current =iv_rulePartitionSingleLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionSingleLineRule2094); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:970:1: rulePartitionSingleLineRule returns [EObject current=null] : (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:973:28: ( (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:974:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:974:1: (otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:974:3: otherlv_0= 'single-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_rulePartitionSingleLineRule2131); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:978:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:979:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:979:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:980:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionSingleLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionSingleLineRule2151); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionSingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:991:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:992:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:992:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:993:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2168); 

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

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_rulePartitionSingleLineRule2185); 

                	newLeafNode(otherlv_3, grammarAccess.getPartitionSingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1013:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1014:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1014:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1015:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2202); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1031:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1031:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_rulePartitionSingleLineRule2220); 

                        	newLeafNode(otherlv_5, grammarAccess.getPartitionSingleLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,31,FOLLOW_31_in_rulePartitionSingleLineRule2232); 

                        	newLeafNode(otherlv_6, grammarAccess.getPartitionSingleLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1039:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1040:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1040:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1041:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2249); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1065:1: entryRuleScannerMultiLineRule returns [EObject current=null] : iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF ;
    public final EObject entryRuleScannerMultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerMultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1066:2: (iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1067:2: iv_ruleScannerMultiLineRule= ruleScannerMultiLineRule EOF
            {
             newCompositeNode(grammarAccess.getScannerMultiLineRuleRule()); 
            pushFollow(FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule2292);
            iv_ruleScannerMultiLineRule=ruleScannerMultiLineRule();

            state._fsp--;

             current =iv_ruleScannerMultiLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerMultiLineRule2302); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1074:1: ruleScannerMultiLineRule returns [EObject current=null] : (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1077:28: ( (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1078:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1078:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1078:3: otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleScannerMultiLineRule2339); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1082:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1083:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1083:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1084:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerMultiLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerMultiLineRule2359); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerMultiLineRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1095:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1096:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1096:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1097:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2376); 

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

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleScannerMultiLineRule2393); 

                	newLeafNode(otherlv_3, grammarAccess.getScannerMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1117:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1118:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1118:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1119:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2410); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1135:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1135:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleScannerMultiLineRule2428); 

                        	newLeafNode(otherlv_5, grammarAccess.getScannerMultiLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,31,FOLLOW_31_in_ruleScannerMultiLineRule2440); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerMultiLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1143:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1144:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1144:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1145:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2457); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1169:1: entryRulePartitionMultiLineRule returns [EObject current=null] : iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF ;
    public final EObject entryRulePartitionMultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionMultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1170:2: (iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1171:2: iv_rulePartitionMultiLineRule= rulePartitionMultiLineRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionMultiLineRuleRule()); 
            pushFollow(FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule2500);
            iv_rulePartitionMultiLineRule=rulePartitionMultiLineRule();

            state._fsp--;

             current =iv_rulePartitionMultiLineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionMultiLineRule2510); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1178:1: rulePartitionMultiLineRule returns [EObject current=null] : (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1181:28: ( (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1182:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1182:1: (otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1182:3: otherlv_0= 'multi-line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_rulePartitionMultiLineRule2547); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1186:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1187:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1187:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1188:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionMultiLineRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionMultiLineRule2567); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionMultiLineRuleAccess().getTokenPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1199:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1200:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1200:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1201:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2584); 

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

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_rulePartitionMultiLineRule2601); 

                	newLeafNode(otherlv_3, grammarAccess.getPartitionMultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1221:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1222:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1222:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1223:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2618); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1239:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==30) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1239:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_rulePartitionMultiLineRule2636); 

                        	newLeafNode(otherlv_5, grammarAccess.getPartitionMultiLineRuleAccess().getEscapedKeyword_5_0());
                        
                    otherlv_6=(Token)match(input,31,FOLLOW_31_in_rulePartitionMultiLineRule2648); 

                        	newLeafNode(otherlv_6, grammarAccess.getPartitionMultiLineRuleAccess().getByKeyword_5_1());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1247:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1248:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1248:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1249:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2665); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1273:1: entryRuleScannerCharacterRule returns [EObject current=null] : iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF ;
    public final EObject entryRuleScannerCharacterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerCharacterRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1274:2: (iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1275:2: iv_ruleScannerCharacterRule= ruleScannerCharacterRule EOF
            {
             newCompositeNode(grammarAccess.getScannerCharacterRuleRule()); 
            pushFollow(FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule2708);
            iv_ruleScannerCharacterRule=ruleScannerCharacterRule();

            state._fsp--;

             current =iv_ruleScannerCharacterRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerCharacterRule2718); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1282:1: ruleScannerCharacterRule returns [EObject current=null] : (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1285:28: ( (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1286:1: (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1286:1: (otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1286:3: otherlv_0= 'character-rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleScannerCharacterRule2755); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1290:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1291:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1291:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1292:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerCharacterRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerCharacterRule2775); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerCharacterRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleScannerCharacterRule2787); 

                	newLeafNode(otherlv_2, grammarAccess.getScannerCharacterRuleAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1307:1: ( (lv_characters_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1308:1: (lv_characters_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1308:1: (lv_characters_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1309:3: lv_characters_3_0= RULE_STRING
            {
            lv_characters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerCharacterRule2804); 

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

            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleScannerCharacterRule2821); 

                	newLeafNode(otherlv_4, grammarAccess.getScannerCharacterRuleAccess().getCommaKeyword_4());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1329:1: ( (lv_characters_5_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1330:1: (lv_characters_5_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1330:1: (lv_characters_5_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1331:3: lv_characters_5_0= RULE_STRING
            {
            lv_characters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerCharacterRule2838); 

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

            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleScannerCharacterRule2855); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1359:1: entryRuleScannerJSRule returns [EObject current=null] : iv_ruleScannerJSRule= ruleScannerJSRule EOF ;
    public final EObject entryRuleScannerJSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerJSRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1360:2: (iv_ruleScannerJSRule= ruleScannerJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1361:2: iv_ruleScannerJSRule= ruleScannerJSRule EOF
            {
             newCompositeNode(grammarAccess.getScannerJSRuleRule()); 
            pushFollow(FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule2891);
            iv_ruleScannerJSRule=ruleScannerJSRule();

            state._fsp--;

             current =iv_ruleScannerJSRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerJSRule2901); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1368:1: ruleScannerJSRule returns [EObject current=null] : (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleScannerJSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1371:28: ( (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1372:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1372:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1372:3: otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleScannerJSRule2938); 

                	newLeafNode(otherlv_0, grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1376:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1377:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1377:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1378:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getScannerJSRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerJSRule2958); 

            		newLeafNode(otherlv_1, grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1389:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1390:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1390:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1391:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerJSRule2975); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1415:1: entryRulePartitionJSRule returns [EObject current=null] : iv_rulePartitionJSRule= rulePartitionJSRule EOF ;
    public final EObject entryRulePartitionJSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitionJSRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1416:2: (iv_rulePartitionJSRule= rulePartitionJSRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1417:2: iv_rulePartitionJSRule= rulePartitionJSRule EOF
            {
             newCompositeNode(grammarAccess.getPartitionJSRuleRule()); 
            pushFollow(FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule3016);
            iv_rulePartitionJSRule=rulePartitionJSRule();

            state._fsp--;

             current =iv_rulePartitionJSRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitionJSRule3026); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1424:1: rulePartitionJSRule returns [EObject current=null] : (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePartitionJSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1427:28: ( (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1428:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1428:1: (otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1428:3: otherlv_0= 'javascript-rule' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_rulePartitionJSRule3063); 

                	newLeafNode(otherlv_0, grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1432:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1433:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1433:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1434:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPartitionJSRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartitionJSRule3083); 

            		newLeafNode(otherlv_1, grammarAccess.getPartitionJSRuleAccess().getTokenPartitionCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1445:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1446:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1446:1: (lv_fileURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1447:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartitionJSRule3100); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1471:1: entryRuleScannerWhitespaceRule returns [EObject current=null] : iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF ;
    public final EObject entryRuleScannerWhitespaceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerWhitespaceRule = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1472:2: (iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1473:2: iv_ruleScannerWhitespaceRule= ruleScannerWhitespaceRule EOF
            {
             newCompositeNode(grammarAccess.getScannerWhitespaceRuleRule()); 
            pushFollow(FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule3141);
            iv_ruleScannerWhitespaceRule=ruleScannerWhitespaceRule();

            state._fsp--;

             current =iv_ruleScannerWhitespaceRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScannerWhitespaceRule3151); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1480:1: ruleScannerWhitespaceRule returns [EObject current=null] : ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsMethod_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) ) ;
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
        Token lv_jsMethod_8_0=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1483:28: ( ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsMethod_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1484:1: ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsMethod_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1484:1: ( (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) ) | (otherlv_7= '#{' ( (lv_jsMethod_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            else if ( (LA23_0==36) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1484:2: (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1484:2: (otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1484:4: otherlv_0= 'whitespace-rule' ( (otherlv_1= RULE_ID ) )? (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' )
                    {
                    otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleScannerWhitespaceRule3189); 

                        	newLeafNode(otherlv_0, grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1488:1: ( (otherlv_1= RULE_ID ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_ID) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1489:1: (otherlv_1= RULE_ID )
                            {
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1489:1: (otherlv_1= RULE_ID )
                            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1490:3: otherlv_1= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                            	        }
                                    
                            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleScannerWhitespaceRule3209); 

                            		newLeafNode(otherlv_1, grammarAccess.getScannerWhitespaceRuleAccess().getTokenScannerTokenCrossReference_0_1_0()); 
                            	

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1501:3: (otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1501:5: otherlv_2= '[' ( (lv_characters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleScannerWhitespaceRule3223); 

                        	newLeafNode(otherlv_2, grammarAccess.getScannerWhitespaceRuleAccess().getLeftSquareBracketKeyword_0_2_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1505:1: ( (lv_characters_3_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1506:1: (lv_characters_3_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1506:1: (lv_characters_3_0= RULE_STRING )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1507:3: lv_characters_3_0= RULE_STRING
                    {
                    lv_characters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3240); 

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

                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1523:2: (otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==25) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1523:4: otherlv_4= ',' ( (lv_characters_5_0= RULE_STRING ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleScannerWhitespaceRule3258); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getScannerWhitespaceRuleAccess().getCommaKeyword_0_2_2_0());
                    	        
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1527:1: ( (lv_characters_5_0= RULE_STRING ) )
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1528:1: (lv_characters_5_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1528:1: (lv_characters_5_0= RULE_STRING )
                    	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1529:3: lv_characters_5_0= RULE_STRING
                    	    {
                    	    lv_characters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3275); 

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
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleScannerWhitespaceRule3294); 

                        	newLeafNode(otherlv_6, grammarAccess.getScannerWhitespaceRuleAccess().getRightSquareBracketKeyword_0_2_3());
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1550:6: (otherlv_7= '#{' ( (lv_jsMethod_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1550:6: (otherlv_7= '#{' ( (lv_jsMethod_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1550:8: otherlv_7= '#{' ( (lv_jsMethod_8_0= RULE_ANY_OTHER ) ) otherlv_9= '}#'
                    {
                    otherlv_7=(Token)match(input,36,FOLLOW_36_in_ruleScannerWhitespaceRule3315); 

                        	newLeafNode(otherlv_7, grammarAccess.getScannerWhitespaceRuleAccess().getNumberSignLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1554:1: ( (lv_jsMethod_8_0= RULE_ANY_OTHER ) )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1555:1: (lv_jsMethod_8_0= RULE_ANY_OTHER )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1555:1: (lv_jsMethod_8_0= RULE_ANY_OTHER )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1556:3: lv_jsMethod_8_0= RULE_ANY_OTHER
                    {
                    lv_jsMethod_8_0=(Token)match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_ruleScannerWhitespaceRule3332); 

                    			newLeafNode(lv_jsMethod_8_0, grammarAccess.getScannerWhitespaceRuleAccess().getJsMethodANY_OTHERTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScannerWhitespaceRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"jsMethod",
                            		lv_jsMethod_8_0, 
                            		"ANY_OTHER");
                    	    

                    }


                    }

                    otherlv_9=(Token)match(input,37,FOLLOW_37_in_ruleScannerWhitespaceRule3349); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1584:1: entryRuleColor returns [EObject current=null] : iv_ruleColor= ruleColor EOF ;
    public final EObject entryRuleColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColor = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1585:2: (iv_ruleColor= ruleColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1586:2: iv_ruleColor= ruleColor EOF
            {
             newCompositeNode(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor3386);
            iv_ruleColor=ruleColor();

            state._fsp--;

             current =iv_ruleColor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor3396); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1593:1: ruleColor returns [EObject current=null] : this_RGBColor_0= ruleRGBColor ;
    public final EObject ruleColor() throws RecognitionException {
        EObject current = null;

        EObject this_RGBColor_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1596:28: (this_RGBColor_0= ruleRGBColor )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1598:5: this_RGBColor_0= ruleRGBColor
            {
             
                    newCompositeNode(grammarAccess.getColorAccess().getRGBColorParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleRGBColor_in_ruleColor3442);
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1614:1: entryRuleRGBColor returns [EObject current=null] : iv_ruleRGBColor= ruleRGBColor EOF ;
    public final EObject entryRuleRGBColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRGBColor = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1615:2: (iv_ruleRGBColor= ruleRGBColor EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1616:2: iv_ruleRGBColor= ruleRGBColor EOF
            {
             newCompositeNode(grammarAccess.getRGBColorRule()); 
            pushFollow(FOLLOW_ruleRGBColor_in_entryRuleRGBColor3476);
            iv_ruleRGBColor=ruleRGBColor();

            state._fsp--;

             current =iv_ruleRGBColor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGBColor3486); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1623:1: ruleRGBColor returns [EObject current=null] : (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' ) ;
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
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1626:28: ( (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1627:1: (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1627:1: (otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')' )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1627:3: otherlv_0= 'rgb' otherlv_1= '(' ( (lv_r_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_g_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_b_6_0= RULE_INT ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleRGBColor3523); 

                	newLeafNode(otherlv_0, grammarAccess.getRGBColorAccess().getRgbKeyword_0());
                
            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleRGBColor3535); 

                	newLeafNode(otherlv_1, grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1635:1: ( (lv_r_2_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1636:1: (lv_r_2_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1636:1: (lv_r_2_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1637:3: lv_r_2_0= RULE_INT
            {
            lv_r_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3552); 

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

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleRGBColor3569); 

                	newLeafNode(otherlv_3, grammarAccess.getRGBColorAccess().getCommaKeyword_3());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1657:1: ( (lv_g_4_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1658:1: (lv_g_4_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1658:1: (lv_g_4_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1659:3: lv_g_4_0= RULE_INT
            {
            lv_g_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3586); 

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

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleRGBColor3603); 

                	newLeafNode(otherlv_5, grammarAccess.getRGBColorAccess().getCommaKeyword_5());
                
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1679:1: ( (lv_b_6_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1680:1: (lv_b_6_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1680:1: (lv_b_6_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1681:3: lv_b_6_0= RULE_INT
            {
            lv_b_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGBColor3620); 

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

            otherlv_7=(Token)match(input,40,FOLLOW_40_in_ruleRGBColor3637); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1709:1: entryRuleFont returns [EObject current=null] : iv_ruleFont= ruleFont EOF ;
    public final EObject entryRuleFont() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFont = null;


        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1710:2: (iv_ruleFont= ruleFont EOF )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1711:2: iv_ruleFont= ruleFont EOF
            {
             newCompositeNode(grammarAccess.getFontRule()); 
            pushFollow(FOLLOW_ruleFont_in_entryRuleFont3673);
            iv_ruleFont=ruleFont();

            state._fsp--;

             current =iv_ruleFont; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFont3683); 

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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1718:1: ruleFont returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* ) ;
    public final EObject ruleFont() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_size_1_0=null;
        Enumerator lv_attributes_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1721:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1722:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1722:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )* )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1722:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_size_1_0= RULE_INT ) ) ( (lv_attributes_2_0= ruleFontType ) )*
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1722:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1723:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1723:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1724:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFont3725); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1740:2: ( (lv_size_1_0= RULE_INT ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1741:1: (lv_size_1_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1741:1: (lv_size_1_0= RULE_INT )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1742:3: lv_size_1_0= RULE_INT
            {
            lv_size_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFont3747); 

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

            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1758:2: ( (lv_attributes_2_0= ruleFontType ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=41 && LA24_0<=44)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1759:1: (lv_attributes_2_0= ruleFontType )
            	    {
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1759:1: (lv_attributes_2_0= ruleFontType )
            	    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1760:3: lv_attributes_2_0= ruleFontType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFontAccess().getAttributesFontTypeEnumRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFontType_in_ruleFont3773);
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
            	    break loop24;
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
    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1784:1: ruleFontType returns [Enumerator current=null] : ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) ) ;
    public final Enumerator ruleFontType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1786:28: ( ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) ) )
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1787:1: ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) )
            {
            // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1787:1: ( (enumLiteral_0= 'bold' ) | (enumLiteral_1= 'italic' ) | (enumLiteral_2= 'underline' ) | (enumLiteral_3= 'strike-through' ) )
            int alt25=4;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt25=1;
                }
                break;
            case 42:
                {
                alt25=2;
                }
                break;
            case 43:
                {
                alt25=3;
                }
                break;
            case 44:
                {
                alt25=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1787:2: (enumLiteral_0= 'bold' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1787:2: (enumLiteral_0= 'bold' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1787:4: enumLiteral_0= 'bold'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_41_in_ruleFontType3824); 

                            current = grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getFontTypeAccess().getBoldEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1793:6: (enumLiteral_1= 'italic' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1793:6: (enumLiteral_1= 'italic' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1793:8: enumLiteral_1= 'italic'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_42_in_ruleFontType3841); 

                            current = grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getFontTypeAccess().getItalicEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1799:6: (enumLiteral_2= 'underline' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1799:6: (enumLiteral_2= 'underline' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1799:8: enumLiteral_2= 'underline'
                    {
                    enumLiteral_2=(Token)match(input,43,FOLLOW_43_in_ruleFontType3858); 

                            current = grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getFontTypeAccess().getUnderlineEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1805:6: (enumLiteral_3= 'strike-through' )
                    {
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1805:6: (enumLiteral_3= 'strike-through' )
                    // ../org.eclipse.fx.code.compensator.hsl/src-gen/org/eclipse/fx/code/compensator/hsl/parser/antlr/internal/InternalHSL.g:1805:8: enumLiteral_3= 'strike-through'
                    {
                    enumLiteral_3=(Token)match(input,44,FOLLOW_44_in_ruleFontType3875); 

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
    public static final BitSet FOLLOW_rulePartition_in_ruleModel165 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_ruleScanner_in_ruleModel187 = new BitSet(new long[]{0x000000000001C000L});
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
    public static final BitSet FOLLOW_11_in_ruleRulePartitioner540 = new BitSet(new long[]{0x0000000510000000L});
    public static final BitSet FOLLOW_ruleParitionRule_in_ruleRulePartitioner561 = new BitSet(new long[]{0x0000000510001000L});
    public static final BitSet FOLLOW_12_in_ruleRulePartitioner574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJSParitioner_in_entryRuleJSParitioner610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJSParitioner620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleJSParitioner657 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJSParitioner674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_entryRuleScanner715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleScanner762 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScanner782 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleScanner794 = new BitSet(new long[]{0x0000001F10860000L});
    public static final BitSet FOLLOW_ruleScannerToken_in_ruleScanner815 = new BitSet(new long[]{0x0000001F10860000L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_ruleScanner837 = new BitSet(new long[]{0x0000001F10860000L});
    public static final BitSet FOLLOW_ruleScannerRule_in_ruleScanner859 = new BitSet(new long[]{0x0000001F10861000L});
    public static final BitSet FOLLOW_12_in_ruleScanner872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerToken_in_entryRuleScannerToken908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerToken918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleScannerToken961 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleScannerToken987 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerToken1004 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_ruleScannerToken1022 = new BitSet(new long[]{0x0000000000681000L});
    public static final BitSet FOLLOW_19_in_ruleScannerToken1035 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleScannerToken1047 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleScannerToken1068 = new BitSet(new long[]{0x0000000000601000L});
    public static final BitSet FOLLOW_21_in_ruleScannerToken1083 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleScannerToken1095 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleColor_in_ruleScannerToken1116 = new BitSet(new long[]{0x0000000000401000L});
    public static final BitSet FOLLOW_22_in_ruleScannerToken1131 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleScannerToken1143 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFont_in_ruleScannerToken1164 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleScannerToken1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordGroup_in_entryRuleKeywordGroup1216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordGroup1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleKeywordGroup1263 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeywordGroup1283 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleKeywordGroup1295 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleKeywordGroup1316 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleKeywordGroup1329 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleKeywordGroup1350 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleKeywordGroup1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword1400 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1452 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleKeyword1470 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerRule_in_entryRuleScannerRule1530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerRule1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_ruleScannerRule1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_ruleScannerRule1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_ruleScannerRule1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_ruleScannerRule1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_ruleScannerRule1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitionRule_in_entryRuleParitionRule1730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitionRule1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_ruleParitionRule1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_ruleParitionRule1814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_ruleParitionRule1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerSingleLineRule_in_entryRuleScannerSingleLineRule1876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerSingleLineRule1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleScannerSingleLineRule1923 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerSingleLineRule1943 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule1960 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleScannerSingleLineRule1977 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule1994 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleScannerSingleLineRule2012 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleScannerSingleLineRule2024 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerSingleLineRule2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionSingleLineRule_in_entryRulePartitionSingleLineRule2084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionSingleLineRule2094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulePartitionSingleLineRule2131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionSingleLineRule2151 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2168 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePartitionSingleLineRule2185 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2202 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_rulePartitionSingleLineRule2220 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_rulePartitionSingleLineRule2232 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionSingleLineRule2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerMultiLineRule_in_entryRuleScannerMultiLineRule2292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerMultiLineRule2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleScannerMultiLineRule2339 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerMultiLineRule2359 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2376 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleScannerMultiLineRule2393 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2410 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleScannerMultiLineRule2428 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleScannerMultiLineRule2440 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerMultiLineRule2457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionMultiLineRule_in_entryRulePartitionMultiLineRule2500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionMultiLineRule2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rulePartitionMultiLineRule2547 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionMultiLineRule2567 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2584 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePartitionMultiLineRule2601 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2618 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_rulePartitionMultiLineRule2636 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_rulePartitionMultiLineRule2648 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionMultiLineRule2665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerCharacterRule_in_entryRuleScannerCharacterRule2708 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerCharacterRule2718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleScannerCharacterRule2755 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerCharacterRule2775 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleScannerCharacterRule2787 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerCharacterRule2804 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleScannerCharacterRule2821 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerCharacterRule2838 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleScannerCharacterRule2855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerJSRule_in_entryRuleScannerJSRule2891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerJSRule2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleScannerJSRule2938 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerJSRule2958 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerJSRule2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitionJSRule_in_entryRulePartitionJSRule3016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitionJSRule3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rulePartitionJSRule3063 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartitionJSRule3083 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartitionJSRule3100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScannerWhitespaceRule_in_entryRuleScannerWhitespaceRule3141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScannerWhitespaceRule3151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleScannerWhitespaceRule3189 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleScannerWhitespaceRule3209 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleScannerWhitespaceRule3223 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3240 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleScannerWhitespaceRule3258 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScannerWhitespaceRule3275 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleScannerWhitespaceRule3294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleScannerWhitespaceRule3315 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleScannerWhitespaceRule3332 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleScannerWhitespaceRule3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor3386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_ruleColor3442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGBColor_in_entryRuleRGBColor3476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGBColor3486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleRGBColor3523 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleRGBColor3535 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3552 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleRGBColor3569 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3586 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleRGBColor3603 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGBColor3620 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleRGBColor3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFont_in_entryRuleFont3673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFont3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFont3725 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFont3747 = new BitSet(new long[]{0x00001E0000000002L});
    public static final BitSet FOLLOW_ruleFontType_in_ruleFont3773 = new BitSet(new long[]{0x00001E0000000002L});
    public static final BitSet FOLLOW_41_in_ruleFontType3824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleFontType3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleFontType3858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleFontType3875 = new BitSet(new long[]{0x0000000000000002L});

}