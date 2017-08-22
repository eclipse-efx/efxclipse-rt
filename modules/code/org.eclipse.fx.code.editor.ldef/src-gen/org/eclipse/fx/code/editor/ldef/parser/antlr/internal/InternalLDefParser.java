package org.eclipse.fx.code.editor.ldef.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.fx.code.editor.ldef.services.LDefGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalLDefParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'*'", "'import'", "'{'", "'}'", "'integration'", "'javafx'", "'java'", "'e4'", "':'", "'partitioning'", "'partition'", "'script'", "'rule'", "'single_line'", "'pattern'", "'col'", "'=>'", "'escaped'", "'by'", "'multi_line'", "'lexical_highlighting'", "'token_def'", "';'", "'bold'", "'italic'", "'default'", "'keywords'", "'['", "','", "']'", "'enabledif'", "'since'", "'containing'", "'character'", "'and'", "'or'", "'('", "')'", "'exists'", "'eq'", "'in'", "'whitespace'", "'javawhitespace'"
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
    public static final int T__13=13;
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


        public InternalLDefParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLDefParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLDefParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLDef.g"; }



     	private LDefGrammarAccess grammarAccess;
     	
        public InternalLDefParser(TokenStream input, LDefGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	}
       	
       	@Override
       	protected LDefGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRoot"
    // InternalLDef.g:67:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // InternalLDef.g:68:2: (iv_ruleRoot= ruleRoot EOF )
            // InternalLDef.g:69:2: iv_ruleRoot= ruleRoot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRootRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoot; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // InternalLDef.g:76:1: ruleRoot returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_languageDefinition_3_0= ruleLanguageDef ) ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_languageDefinition_3_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:79:28: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_languageDefinition_3_0= ruleLanguageDef ) ) ) )
            // InternalLDef.g:80:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_languageDefinition_3_0= ruleLanguageDef ) ) )
            {
            // InternalLDef.g:80:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_languageDefinition_3_0= ruleLanguageDef ) ) )
            // InternalLDef.g:80:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_languageDefinition_3_0= ruleLanguageDef ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRootAccess().getPackageKeyword_0());
                  
            }
            // InternalLDef.g:84:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalLDef.g:85:1: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalLDef.g:85:1: (lv_name_1_0= ruleQualifiedName )
            // InternalLDef.g:86:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRootAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRootRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.fx.code.editor.ldef.LDef.QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalLDef.g:102:2: ( (lv_imports_2_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLDef.g:103:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // InternalLDef.g:103:1: (lv_imports_2_0= ruleImport )
            	    // InternalLDef.g:104:3: lv_imports_2_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRootAccess().getImportsImportParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_imports_2_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRootRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_2_0, 
            	              		"org.eclipse.fx.code.editor.ldef.LDef.Import");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalLDef.g:120:3: ( (lv_languageDefinition_3_0= ruleLanguageDef ) )
            // InternalLDef.g:121:1: (lv_languageDefinition_3_0= ruleLanguageDef )
            {
            // InternalLDef.g:121:1: (lv_languageDefinition_3_0= ruleLanguageDef )
            // InternalLDef.g:122:3: lv_languageDefinition_3_0= ruleLanguageDef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRootAccess().getLanguageDefinitionLanguageDefParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_languageDefinition_3_0=ruleLanguageDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRootRule());
              	        }
                     		set(
                     			current, 
                     			"languageDefinition",
                      		lv_languageDefinition_3_0, 
                      		"org.eclipse.fx.code.editor.ldef.LDef.LanguageDef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleValidID"
    // InternalLDef.g:146:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalLDef.g:147:2: (iv_ruleValidID= ruleValidID EOF )
            // InternalLDef.g:148:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalLDef.g:155:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:158:28: (this_ID_0= RULE_ID )
            // InternalLDef.g:159:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalLDef.g:174:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalLDef.g:175:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalLDef.g:176:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalLDef.g:183:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:186:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // InternalLDef.g:187:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // InternalLDef.g:187:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // InternalLDef.g:188:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_5);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalLDef.g:198:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    int LA2_2 = input.LA(2);

                    if ( (LA2_2==RULE_ID) && (synpred1_InternalLDef())) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // InternalLDef.g:198:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // InternalLDef.g:198:2: ( ( '.' )=>kw= '.' )
            	    // InternalLDef.g:198:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,12,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_5);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // InternalLDef.g:225:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // InternalLDef.g:226:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // InternalLDef.g:227:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // InternalLDef.g:234:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:237:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) )
            // InternalLDef.g:238:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            {
            // InternalLDef.g:238:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            // InternalLDef.g:239:5: this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_5);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalLDef.g:249:1: (kw= '.' kw= '*' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalLDef.g:250:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,12,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleImport"
    // InternalLDef.g:269:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalLDef.g:270:2: (iv_ruleImport= ruleImport EOF )
            // InternalLDef.g:271:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalLDef.g:278:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:281:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // InternalLDef.g:282:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // InternalLDef.g:282:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // InternalLDef.g:282:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // InternalLDef.g:286:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // InternalLDef.g:287:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // InternalLDef.g:287:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // InternalLDef.g:288:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportRule());
              	        }
                     		set(
                     			current, 
                     			"importedNamespace",
                      		lv_importedNamespace_1_0, 
                      		"org.eclipse.fx.code.editor.ldef.LDef.QualifiedNameWithWildCard");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleLanguageDef"
    // InternalLDef.g:312:1: entryRuleLanguageDef returns [EObject current=null] : iv_ruleLanguageDef= ruleLanguageDef EOF ;
    public final EObject entryRuleLanguageDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageDef = null;


        try {
            // InternalLDef.g:313:2: (iv_ruleLanguageDef= ruleLanguageDef EOF )
            // InternalLDef.g:314:2: iv_ruleLanguageDef= ruleLanguageDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLanguageDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLanguageDef=ruleLanguageDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLanguageDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLanguageDef"


    // $ANTLR start "ruleLanguageDef"
    // InternalLDef.g:321:1: ruleLanguageDef returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_paritioning_2_0= ruleParitioning ) ) ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) ) ( (lv_integration_4_0= ruleIntegration ) )? otherlv_5= '}' ) ;
    public final EObject ruleLanguageDef() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_paritioning_2_0 = null;

        EObject lv_lexicalHighlighting_3_0 = null;

        EObject lv_integration_4_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:324:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_paritioning_2_0= ruleParitioning ) ) ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) ) ( (lv_integration_4_0= ruleIntegration ) )? otherlv_5= '}' ) )
            // InternalLDef.g:325:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_paritioning_2_0= ruleParitioning ) ) ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) ) ( (lv_integration_4_0= ruleIntegration ) )? otherlv_5= '}' )
            {
            // InternalLDef.g:325:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_paritioning_2_0= ruleParitioning ) ) ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) ) ( (lv_integration_4_0= ruleIntegration ) )? otherlv_5= '}' )
            // InternalLDef.g:325:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_paritioning_2_0= ruleParitioning ) ) ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) ) ( (lv_integration_4_0= ruleIntegration ) )? otherlv_5= '}'
            {
            // InternalLDef.g:325:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalLDef.g:326:1: (lv_name_0_0= RULE_ID )
            {
            // InternalLDef.g:326:1: (lv_name_0_0= RULE_ID )
            // InternalLDef.g:327:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getLanguageDefAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLanguageDefRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLanguageDefAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalLDef.g:347:1: ( (lv_paritioning_2_0= ruleParitioning ) )
            // InternalLDef.g:348:1: (lv_paritioning_2_0= ruleParitioning )
            {
            // InternalLDef.g:348:1: (lv_paritioning_2_0= ruleParitioning )
            // InternalLDef.g:349:3: lv_paritioning_2_0= ruleParitioning
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLanguageDefAccess().getParitioningParitioningParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_9);
            lv_paritioning_2_0=ruleParitioning();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLanguageDefRule());
              	        }
                     		set(
                     			current, 
                     			"paritioning",
                      		lv_paritioning_2_0, 
                      		"org.eclipse.fx.code.editor.ldef.LDef.Paritioning");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalLDef.g:365:2: ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) )
            // InternalLDef.g:366:1: (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting )
            {
            // InternalLDef.g:366:1: (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting )
            // InternalLDef.g:367:3: lv_lexicalHighlighting_3_0= ruleLexicalHighlighting
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLanguageDefAccess().getLexicalHighlightingLexicalHighlightingParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_10);
            lv_lexicalHighlighting_3_0=ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLanguageDefRule());
              	        }
                     		set(
                     			current, 
                     			"lexicalHighlighting",
                      		lv_lexicalHighlighting_3_0, 
                      		"org.eclipse.fx.code.editor.ldef.LDef.LexicalHighlighting");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalLDef.g:383:2: ( (lv_integration_4_0= ruleIntegration ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalLDef.g:384:1: (lv_integration_4_0= ruleIntegration )
                    {
                    // InternalLDef.g:384:1: (lv_integration_4_0= ruleIntegration )
                    // InternalLDef.g:385:3: lv_integration_4_0= ruleIntegration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageDefAccess().getIntegrationIntegrationParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_11);
                    lv_integration_4_0=ruleIntegration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLanguageDefRule());
                      	        }
                             		set(
                             			current, 
                             			"integration",
                              		lv_integration_4_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.Integration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLanguageDefAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleLanguageDef"


    // $ANTLR start "entryRuleIntegration"
    // InternalLDef.g:413:1: entryRuleIntegration returns [EObject current=null] : iv_ruleIntegration= ruleIntegration EOF ;
    public final EObject entryRuleIntegration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegration = null;


        try {
            // InternalLDef.g:414:2: (iv_ruleIntegration= ruleIntegration EOF )
            // InternalLDef.g:415:2: iv_ruleIntegration= ruleIntegration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegrationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntegration=ruleIntegration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIntegration"


    // $ANTLR start "ruleIntegration"
    // InternalLDef.g:422:1: ruleIntegration returns [EObject current=null] : (otherlv_0= 'integration' otherlv_1= '{' ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+ otherlv_3= '}' ) ;
    public final EObject ruleIntegration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_codeIntegrationList_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:425:28: ( (otherlv_0= 'integration' otherlv_1= '{' ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+ otherlv_3= '}' ) )
            // InternalLDef.g:426:1: (otherlv_0= 'integration' otherlv_1= '{' ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+ otherlv_3= '}' )
            {
            // InternalLDef.g:426:1: (otherlv_0= 'integration' otherlv_1= '{' ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+ otherlv_3= '}' )
            // InternalLDef.g:426:3: otherlv_0= 'integration' otherlv_1= '{' ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIntegrationAccess().getIntegrationKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIntegrationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalLDef.g:434:1: ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalLDef.g:435:1: (lv_codeIntegrationList_2_0= ruleCodeIntegration )
            	    {
            	    // InternalLDef.g:435:1: (lv_codeIntegrationList_2_0= ruleCodeIntegration )
            	    // InternalLDef.g:436:3: lv_codeIntegrationList_2_0= ruleCodeIntegration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIntegrationAccess().getCodeIntegrationListCodeIntegrationParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_codeIntegrationList_2_0=ruleCodeIntegration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getIntegrationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"codeIntegrationList",
            	              		lv_codeIntegrationList_2_0, 
            	              		"org.eclipse.fx.code.editor.ldef.LDef.CodeIntegration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getIntegrationAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleIntegration"


    // $ANTLR start "entryRuleCodeIntegration"
    // InternalLDef.g:464:1: entryRuleCodeIntegration returns [EObject current=null] : iv_ruleCodeIntegration= ruleCodeIntegration EOF ;
    public final EObject entryRuleCodeIntegration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodeIntegration = null;


        try {
            // InternalLDef.g:465:2: (iv_ruleCodeIntegration= ruleCodeIntegration EOF )
            // InternalLDef.g:466:2: iv_ruleCodeIntegration= ruleCodeIntegration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCodeIntegrationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCodeIntegration=ruleCodeIntegration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCodeIntegration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCodeIntegration"


    // $ANTLR start "ruleCodeIntegration"
    // InternalLDef.g:473:1: ruleCodeIntegration returns [EObject current=null] : this_JavaFXIntegration_0= ruleJavaFXIntegration ;
    public final EObject ruleCodeIntegration() throws RecognitionException {
        EObject current = null;

        EObject this_JavaFXIntegration_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:476:28: (this_JavaFXIntegration_0= ruleJavaFXIntegration )
            // InternalLDef.g:478:5: this_JavaFXIntegration_0= ruleJavaFXIntegration
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCodeIntegrationAccess().getJavaFXIntegrationParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_JavaFXIntegration_0=ruleJavaFXIntegration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_JavaFXIntegration_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleCodeIntegration"


    // $ANTLR start "entryRuleJavaFXIntegration"
    // InternalLDef.g:494:1: entryRuleJavaFXIntegration returns [EObject current=null] : iv_ruleJavaFXIntegration= ruleJavaFXIntegration EOF ;
    public final EObject entryRuleJavaFXIntegration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaFXIntegration = null;


        try {
            // InternalLDef.g:495:2: (iv_ruleJavaFXIntegration= ruleJavaFXIntegration EOF )
            // InternalLDef.g:496:2: iv_ruleJavaFXIntegration= ruleJavaFXIntegration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaFXIntegrationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJavaFXIntegration=ruleJavaFXIntegration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaFXIntegration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJavaFXIntegration"


    // $ANTLR start "ruleJavaFXIntegration"
    // InternalLDef.g:503:1: ruleJavaFXIntegration returns [EObject current=null] : (otherlv_0= 'javafx' otherlv_1= '{' ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+ otherlv_3= '}' ) ;
    public final EObject ruleJavaFXIntegration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_codegenerationList_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:506:28: ( (otherlv_0= 'javafx' otherlv_1= '{' ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+ otherlv_3= '}' ) )
            // InternalLDef.g:507:1: (otherlv_0= 'javafx' otherlv_1= '{' ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+ otherlv_3= '}' )
            {
            // InternalLDef.g:507:1: (otherlv_0= 'javafx' otherlv_1= '{' ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+ otherlv_3= '}' )
            // InternalLDef.g:507:3: otherlv_0= 'javafx' otherlv_1= '{' ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJavaFXIntegrationAccess().getJavafxKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJavaFXIntegrationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalLDef.g:515:1: ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalLDef.g:516:1: (lv_codegenerationList_2_0= ruleCodegeneration )
            	    {
            	    // InternalLDef.g:516:1: (lv_codegenerationList_2_0= ruleCodegeneration )
            	    // InternalLDef.g:517:3: lv_codegenerationList_2_0= ruleCodegeneration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListCodegenerationParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_codegenerationList_2_0=ruleCodegeneration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getJavaFXIntegrationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"codegenerationList",
            	              		lv_codegenerationList_2_0, 
            	              		"org.eclipse.fx.code.editor.ldef.LDef.Codegeneration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getJavaFXIntegrationAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJavaFXIntegration"


    // $ANTLR start "entryRuleCodegeneration"
    // InternalLDef.g:545:1: entryRuleCodegeneration returns [EObject current=null] : iv_ruleCodegeneration= ruleCodegeneration EOF ;
    public final EObject entryRuleCodegeneration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodegeneration = null;


        try {
            // InternalLDef.g:546:2: (iv_ruleCodegeneration= ruleCodegeneration EOF )
            // InternalLDef.g:547:2: iv_ruleCodegeneration= ruleCodegeneration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCodegenerationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCodegeneration=ruleCodegeneration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCodegeneration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCodegeneration"


    // $ANTLR start "ruleCodegeneration"
    // InternalLDef.g:554:1: ruleCodegeneration returns [EObject current=null] : (this_JavaCodeGeneration_0= ruleJavaCodeGeneration | this_E4CodeGeneration_1= ruleE4CodeGeneration ) ;
    public final EObject ruleCodegeneration() throws RecognitionException {
        EObject current = null;

        EObject this_JavaCodeGeneration_0 = null;

        EObject this_E4CodeGeneration_1 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:557:28: ( (this_JavaCodeGeneration_0= ruleJavaCodeGeneration | this_E4CodeGeneration_1= ruleE4CodeGeneration ) )
            // InternalLDef.g:558:1: (this_JavaCodeGeneration_0= ruleJavaCodeGeneration | this_E4CodeGeneration_1= ruleE4CodeGeneration )
            {
            // InternalLDef.g:558:1: (this_JavaCodeGeneration_0= ruleJavaCodeGeneration | this_E4CodeGeneration_1= ruleE4CodeGeneration )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalLDef.g:559:5: this_JavaCodeGeneration_0= ruleJavaCodeGeneration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCodegenerationAccess().getJavaCodeGenerationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_JavaCodeGeneration_0=ruleJavaCodeGeneration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JavaCodeGeneration_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:569:5: this_E4CodeGeneration_1= ruleE4CodeGeneration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCodegenerationAccess().getE4CodeGenerationParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_E4CodeGeneration_1=ruleE4CodeGeneration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_E4CodeGeneration_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleCodegeneration"


    // $ANTLR start "entryRuleJavaCodeGeneration"
    // InternalLDef.g:585:1: entryRuleJavaCodeGeneration returns [EObject current=null] : iv_ruleJavaCodeGeneration= ruleJavaCodeGeneration EOF ;
    public final EObject entryRuleJavaCodeGeneration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaCodeGeneration = null;


        try {
            // InternalLDef.g:586:2: (iv_ruleJavaCodeGeneration= ruleJavaCodeGeneration EOF )
            // InternalLDef.g:587:2: iv_ruleJavaCodeGeneration= ruleJavaCodeGeneration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaCodeGenerationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJavaCodeGeneration=ruleJavaCodeGeneration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaCodeGeneration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJavaCodeGeneration"


    // $ANTLR start "ruleJavaCodeGeneration"
    // InternalLDef.g:594:1: ruleJavaCodeGeneration returns [EObject current=null] : (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? ) ;
    public final EObject ruleJavaCodeGeneration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_configValue_3_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:597:28: ( (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? ) )
            // InternalLDef.g:598:1: (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? )
            {
            // InternalLDef.g:598:1: (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? )
            // InternalLDef.g:598:3: otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJavaCodeGenerationAccess().getJavaKeyword_0());
                  
            }
            // InternalLDef.g:602:1: ( (lv_name_1_0= RULE_STRING ) )
            // InternalLDef.g:603:1: (lv_name_1_0= RULE_STRING )
            {
            // InternalLDef.g:603:1: (lv_name_1_0= RULE_STRING )
            // InternalLDef.g:604:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getJavaCodeGenerationAccess().getNameSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getJavaCodeGenerationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:620:2: (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalLDef.g:620:4: otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getJavaCodeGenerationAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // InternalLDef.g:624:1: ( (lv_configValue_3_0= ruleConfigValue ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalLDef.g:625:1: (lv_configValue_3_0= ruleConfigValue )
                    	    {
                    	    // InternalLDef.g:625:1: (lv_configValue_3_0= ruleConfigValue )
                    	    // InternalLDef.g:626:3: lv_configValue_3_0= ruleConfigValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJavaCodeGenerationAccess().getConfigValueConfigValueParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_18);
                    	    lv_configValue_3_0=ruleConfigValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJavaCodeGenerationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"configValue",
                    	              		lv_configValue_3_0, 
                    	              		"org.eclipse.fx.code.editor.ldef.LDef.ConfigValue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getJavaCodeGenerationAccess().getRightCurlyBracketKeyword_2_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJavaCodeGeneration"


    // $ANTLR start "entryRuleE4CodeGeneration"
    // InternalLDef.g:654:1: entryRuleE4CodeGeneration returns [EObject current=null] : iv_ruleE4CodeGeneration= ruleE4CodeGeneration EOF ;
    public final EObject entryRuleE4CodeGeneration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleE4CodeGeneration = null;


        try {
            // InternalLDef.g:655:2: (iv_ruleE4CodeGeneration= ruleE4CodeGeneration EOF )
            // InternalLDef.g:656:2: iv_ruleE4CodeGeneration= ruleE4CodeGeneration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getE4CodeGenerationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleE4CodeGeneration=ruleE4CodeGeneration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleE4CodeGeneration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleE4CodeGeneration"


    // $ANTLR start "ruleE4CodeGeneration"
    // InternalLDef.g:663:1: ruleE4CodeGeneration returns [EObject current=null] : (otherlv_0= 'e4' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? ) ;
    public final EObject ruleE4CodeGeneration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_configValue_3_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:666:28: ( (otherlv_0= 'e4' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? ) )
            // InternalLDef.g:667:1: (otherlv_0= 'e4' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? )
            {
            // InternalLDef.g:667:1: (otherlv_0= 'e4' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? )
            // InternalLDef.g:667:3: otherlv_0= 'e4' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getE4CodeGenerationAccess().getE4Keyword_0());
                  
            }
            // InternalLDef.g:671:1: ( (lv_name_1_0= RULE_STRING ) )
            // InternalLDef.g:672:1: (lv_name_1_0= RULE_STRING )
            {
            // InternalLDef.g:672:1: (lv_name_1_0= RULE_STRING )
            // InternalLDef.g:673:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getE4CodeGenerationAccess().getNameSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getE4CodeGenerationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:689:2: (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalLDef.g:689:4: otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getE4CodeGenerationAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // InternalLDef.g:693:1: ( (lv_configValue_3_0= ruleConfigValue ) )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalLDef.g:694:1: (lv_configValue_3_0= ruleConfigValue )
                    	    {
                    	    // InternalLDef.g:694:1: (lv_configValue_3_0= ruleConfigValue )
                    	    // InternalLDef.g:695:3: lv_configValue_3_0= ruleConfigValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getE4CodeGenerationAccess().getConfigValueConfigValueParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_18);
                    	    lv_configValue_3_0=ruleConfigValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getE4CodeGenerationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"configValue",
                    	              		lv_configValue_3_0, 
                    	              		"org.eclipse.fx.code.editor.ldef.LDef.ConfigValue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                    otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getE4CodeGenerationAccess().getRightCurlyBracketKeyword_2_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleE4CodeGeneration"


    // $ANTLR start "entryRuleConfigValue"
    // InternalLDef.g:723:1: entryRuleConfigValue returns [EObject current=null] : iv_ruleConfigValue= ruleConfigValue EOF ;
    public final EObject entryRuleConfigValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigValue = null;


        try {
            // InternalLDef.g:724:2: (iv_ruleConfigValue= ruleConfigValue EOF )
            // InternalLDef.g:725:2: iv_ruleConfigValue= ruleConfigValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConfigValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConfigValue=ruleConfigValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConfigValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleConfigValue"


    // $ANTLR start "ruleConfigValue"
    // InternalLDef.g:732:1: ruleConfigValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) ) ) ;
    public final EObject ruleConfigValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token lv_simpleValue_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_children_4_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:735:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) ) ) )
            // InternalLDef.g:736:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) ) )
            {
            // InternalLDef.g:736:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) ) )
            // InternalLDef.g:736:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) )
            {
            // InternalLDef.g:736:2: ( (lv_key_0_0= RULE_ID ) )
            // InternalLDef.g:737:1: (lv_key_0_0= RULE_ID )
            {
            // InternalLDef.g:737:1: (lv_key_0_0= RULE_ID )
            // InternalLDef.g:738:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_key_0_0, grammarAccess.getConfigValueAccess().getKeyIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getConfigValueRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"key",
                      		lv_key_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConfigValueAccess().getColonKeyword_1());
                  
            }
            // InternalLDef.g:758:1: ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_STRING) ) {
                alt13=1;
            }
            else if ( (LA13_0==15) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalLDef.g:758:2: ( (lv_simpleValue_2_0= RULE_STRING ) )
                    {
                    // InternalLDef.g:758:2: ( (lv_simpleValue_2_0= RULE_STRING ) )
                    // InternalLDef.g:759:1: (lv_simpleValue_2_0= RULE_STRING )
                    {
                    // InternalLDef.g:759:1: (lv_simpleValue_2_0= RULE_STRING )
                    // InternalLDef.g:760:3: lv_simpleValue_2_0= RULE_STRING
                    {
                    lv_simpleValue_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_simpleValue_2_0, grammarAccess.getConfigValueAccess().getSimpleValueSTRINGTerminalRuleCall_2_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getConfigValueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"simpleValue",
                              		lv_simpleValue_2_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLDef.g:777:6: (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' )
                    {
                    // InternalLDef.g:777:6: (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' )
                    // InternalLDef.g:777:8: otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}'
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getConfigValueAccess().getLeftCurlyBracketKeyword_2_1_0());
                          
                    }
                    // InternalLDef.g:781:1: ( (lv_children_4_0= ruleConfigValue ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalLDef.g:782:1: (lv_children_4_0= ruleConfigValue )
                    	    {
                    	    // InternalLDef.g:782:1: (lv_children_4_0= ruleConfigValue )
                    	    // InternalLDef.g:783:3: lv_children_4_0= ruleConfigValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getConfigValueAccess().getChildrenConfigValueParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_18);
                    	    lv_children_4_0=ruleConfigValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getConfigValueRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"children",
                    	              		lv_children_4_0, 
                    	              		"org.eclipse.fx.code.editor.ldef.LDef.ConfigValue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    otherlv_5=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getConfigValueAccess().getRightCurlyBracketKeyword_2_1_2());
                          
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleConfigValue"


    // $ANTLR start "entryRuleParitioning"
    // InternalLDef.g:811:1: entryRuleParitioning returns [EObject current=null] : iv_ruleParitioning= ruleParitioning EOF ;
    public final EObject entryRuleParitioning() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitioning = null;


        try {
            // InternalLDef.g:812:2: (iv_ruleParitioning= ruleParitioning EOF )
            // InternalLDef.g:813:2: iv_ruleParitioning= ruleParitioning EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParitioningRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParitioning=ruleParitioning();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParitioning; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleParitioning"


    // $ANTLR start "ruleParitioning"
    // InternalLDef.g:820:1: ruleParitioning returns [EObject current=null] : (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' ) ;
    public final EObject ruleParitioning() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_partitions_2_0 = null;

        EObject lv_partitioner_3_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:823:28: ( (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' ) )
            // InternalLDef.g:824:1: (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' )
            {
            // InternalLDef.g:824:1: (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' )
            // InternalLDef.g:824:3: otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParitioningAccess().getPartitioningKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalLDef.g:832:1: ( (lv_partitions_2_0= rulePartition ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==23) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalLDef.g:833:1: (lv_partitions_2_0= rulePartition )
            	    {
            	    // InternalLDef.g:833:1: (lv_partitions_2_0= rulePartition )
            	    // InternalLDef.g:834:3: lv_partitions_2_0= rulePartition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_partitions_2_0=rulePartition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getParitioningRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"partitions",
            	              		lv_partitions_2_0, 
            	              		"org.eclipse.fx.code.editor.ldef.LDef.Partition");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            // InternalLDef.g:850:3: ( (lv_partitioner_3_0= rulePartitioner ) )
            // InternalLDef.g:851:1: (lv_partitioner_3_0= rulePartitioner )
            {
            // InternalLDef.g:851:1: (lv_partitioner_3_0= rulePartitioner )
            // InternalLDef.g:852:3: lv_partitioner_3_0= rulePartitioner
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_11);
            lv_partitioner_3_0=rulePartitioner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParitioningRule());
              	        }
                     		set(
                     			current, 
                     			"partitioner",
                      		lv_partitioner_3_0, 
                      		"org.eclipse.fx.code.editor.ldef.LDef.Partitioner");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getParitioningAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleParitioning"


    // $ANTLR start "entryRulePartition"
    // InternalLDef.g:880:1: entryRulePartition returns [EObject current=null] : iv_rulePartition= rulePartition EOF ;
    public final EObject entryRulePartition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition = null;


        try {
            // InternalLDef.g:881:2: (iv_rulePartition= rulePartition EOF )
            // InternalLDef.g:882:2: iv_rulePartition= rulePartition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartition=rulePartition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalLDef.g:889:1: rulePartition returns [EObject current=null] : (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePartition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:892:28: ( (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalLDef.g:893:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalLDef.g:893:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalLDef.g:893:3: otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartitionAccess().getPartitionKeyword_0());
                  
            }
            // InternalLDef.g:897:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalLDef.g:898:1: (lv_name_1_0= RULE_ID )
            {
            // InternalLDef.g:898:1: (lv_name_1_0= RULE_ID )
            // InternalLDef.g:899:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPartitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePartition"


    // $ANTLR start "entryRulePartitioner"
    // InternalLDef.g:923:1: entryRulePartitioner returns [EObject current=null] : iv_rulePartitioner= rulePartitioner EOF ;
    public final EObject entryRulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitioner = null;


        try {
            // InternalLDef.g:924:2: (iv_rulePartitioner= rulePartitioner EOF )
            // InternalLDef.g:925:2: iv_rulePartitioner= rulePartitioner EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitionerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartitioner=rulePartitioner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartitioner; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalLDef.g:932:1: rulePartitioner returns [EObject current=null] : (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS ) ;
    public final EObject rulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject this_Partitioner_Rule_0 = null;

        EObject this_Paritioner_JS_1 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:935:28: ( (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS ) )
            // InternalLDef.g:936:1: (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS )
            {
            // InternalLDef.g:936:1: (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            else if ( (LA15_0==24) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalLDef.g:937:5: this_Partitioner_Rule_0= rulePartitioner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Partitioner_Rule_0=rulePartitioner_Rule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Partitioner_Rule_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:947:5: this_Paritioner_JS_1= ruleParitioner_JS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Paritioner_JS_1=ruleParitioner_JS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Paritioner_JS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePartitioner"


    // $ANTLR start "entryRuleParitioner_JS"
    // InternalLDef.g:963:1: entryRuleParitioner_JS returns [EObject current=null] : iv_ruleParitioner_JS= ruleParitioner_JS EOF ;
    public final EObject entryRuleParitioner_JS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitioner_JS = null;


        try {
            // InternalLDef.g:964:2: (iv_ruleParitioner_JS= ruleParitioner_JS EOF )
            // InternalLDef.g:965:2: iv_ruleParitioner_JS= ruleParitioner_JS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParitioner_JSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParitioner_JS=ruleParitioner_JS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParitioner_JS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleParitioner_JS"


    // $ANTLR start "ruleParitioner_JS"
    // InternalLDef.g:972:1: ruleParitioner_JS returns [EObject current=null] : (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleParitioner_JS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_scriptURI_1_0=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:975:28: ( (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) ) )
            // InternalLDef.g:976:1: (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) )
            {
            // InternalLDef.g:976:1: (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) )
            // InternalLDef.g:976:3: otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParitioner_JSAccess().getScriptKeyword_0());
                  
            }
            // InternalLDef.g:980:1: ( (lv_scriptURI_1_0= RULE_STRING ) )
            // InternalLDef.g:981:1: (lv_scriptURI_1_0= RULE_STRING )
            {
            // InternalLDef.g:981:1: (lv_scriptURI_1_0= RULE_STRING )
            // InternalLDef.g:982:3: lv_scriptURI_1_0= RULE_STRING
            {
            lv_scriptURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_scriptURI_1_0, grammarAccess.getParitioner_JSAccess().getScriptURISTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParitioner_JSRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"scriptURI",
                      		lv_scriptURI_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleParitioner_JS"


    // $ANTLR start "entryRulePartitioner_Rule"
    // InternalLDef.g:1006:1: entryRulePartitioner_Rule returns [EObject current=null] : iv_rulePartitioner_Rule= rulePartitioner_Rule EOF ;
    public final EObject entryRulePartitioner_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitioner_Rule = null;


        try {
            // InternalLDef.g:1007:2: (iv_rulePartitioner_Rule= rulePartitioner_Rule EOF )
            // InternalLDef.g:1008:2: iv_rulePartitioner_Rule= rulePartitioner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitioner_RuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartitioner_Rule=rulePartitioner_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartitioner_Rule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePartitioner_Rule"


    // $ANTLR start "rulePartitioner_Rule"
    // InternalLDef.g:1015:1: rulePartitioner_Rule returns [EObject current=null] : (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' ) ;
    public final EObject rulePartitioner_Rule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ruleList_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1018:28: ( (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' ) )
            // InternalLDef.g:1019:1: (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' )
            {
            // InternalLDef.g:1019:1: (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' )
            // InternalLDef.g:1019:3: otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalLDef.g:1027:1: ( (lv_ruleList_2_0= rulePartition_Rule ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24||LA16_0==26||LA16_0==32) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalLDef.g:1028:1: (lv_ruleList_2_0= rulePartition_Rule )
            	    {
            	    // InternalLDef.g:1028:1: (lv_ruleList_2_0= rulePartition_Rule )
            	    // InternalLDef.g:1029:3: lv_ruleList_2_0= rulePartition_Rule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_ruleList_2_0=rulePartition_Rule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPartitioner_RuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ruleList",
            	              		lv_ruleList_2_0, 
            	              		"org.eclipse.fx.code.editor.ldef.LDef.Partition_Rule");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPartitioner_RuleAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePartitioner_Rule"


    // $ANTLR start "entryRulePartition_Rule"
    // InternalLDef.g:1057:1: entryRulePartition_Rule returns [EObject current=null] : iv_rulePartition_Rule= rulePartition_Rule EOF ;
    public final EObject entryRulePartition_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_Rule = null;


        try {
            // InternalLDef.g:1058:2: (iv_rulePartition_Rule= rulePartition_Rule EOF )
            // InternalLDef.g:1059:2: iv_rulePartition_Rule= rulePartition_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_RuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartition_Rule=rulePartition_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_Rule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePartition_Rule"


    // $ANTLR start "rulePartition_Rule"
    // InternalLDef.g:1066:1: rulePartition_Rule returns [EObject current=null] : (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule | this_Partition_JSRule_2= rulePartition_JSRule ) ;
    public final EObject rulePartition_Rule() throws RecognitionException {
        EObject current = null;

        EObject this_Partition_SingleLineRule_0 = null;

        EObject this_Partition_MultiLineRule_1 = null;

        EObject this_Partition_JSRule_2 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1069:28: ( (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule | this_Partition_JSRule_2= rulePartition_JSRule ) )
            // InternalLDef.g:1070:1: (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule | this_Partition_JSRule_2= rulePartition_JSRule )
            {
            // InternalLDef.g:1070:1: (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule | this_Partition_JSRule_2= rulePartition_JSRule )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt17=1;
                }
                break;
            case 32:
                {
                alt17=2;
                }
                break;
            case 24:
                {
                alt17=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalLDef.g:1071:5: this_Partition_SingleLineRule_0= rulePartition_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Partition_SingleLineRule_0=rulePartition_SingleLineRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Partition_SingleLineRule_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:1081:5: this_Partition_MultiLineRule_1= rulePartition_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Partition_MultiLineRule_1=rulePartition_MultiLineRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Partition_MultiLineRule_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalLDef.g:1091:5: this_Partition_JSRule_2= rulePartition_JSRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartition_RuleAccess().getPartition_JSRuleParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Partition_JSRule_2=rulePartition_JSRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Partition_JSRule_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePartition_Rule"


    // $ANTLR start "entryRulePartition_SingleLineRule"
    // InternalLDef.g:1107:1: entryRulePartition_SingleLineRule returns [EObject current=null] : iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF ;
    public final EObject entryRulePartition_SingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_SingleLineRule = null;


        try {
            // InternalLDef.g:1108:2: (iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF )
            // InternalLDef.g:1109:2: iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartition_SingleLineRule=rulePartition_SingleLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_SingleLineRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePartition_SingleLineRule"


    // $ANTLR start "rulePartition_SingleLineRule"
    // InternalLDef.g:1116:1: rulePartition_SingleLineRule returns [EObject current=null] : (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )? (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? (otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) )? )? (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )? ) ;
    public final EObject rulePartition_SingleLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_startSeq_2_0=null;
        Token otherlv_3=null;
        Token lv_startPattern_4_0=null;
        Token lv_startSuffix_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_endSeq_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_escapeSeq_12_0=null;
        EObject lv_check_7_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1119:28: ( (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )? (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? (otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) )? )? (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )? ) )
            // InternalLDef.g:1120:1: (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )? (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? (otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) )? )? (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )? )
            {
            // InternalLDef.g:1120:1: (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )? (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? (otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) )? )? (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )? )
            // InternalLDef.g:1120:3: otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )? (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? (otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) )? )? (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0());
                  
            }
            // InternalLDef.g:1124:1: ( (otherlv_1= RULE_ID ) )
            // InternalLDef.g:1125:1: (otherlv_1= RULE_ID )
            {
            // InternalLDef.g:1125:1: (otherlv_1= RULE_ID )
            // InternalLDef.g:1126:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // InternalLDef.g:1137:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // InternalLDef.g:1138:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // InternalLDef.g:1138:1: (lv_startSeq_2_0= RULE_STRING )
            // InternalLDef.g:1139:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_startSeq_2_0, grammarAccess.getPartition_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"startSeq",
                      		lv_startSeq_2_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:1155:2: (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalLDef.g:1155:4: otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPartition_SingleLineRuleAccess().getPatternKeyword_3_0());
                          
                    }
                    // InternalLDef.g:1159:1: ( (lv_startPattern_4_0= RULE_STRING ) )
                    // InternalLDef.g:1160:1: (lv_startPattern_4_0= RULE_STRING )
                    {
                    // InternalLDef.g:1160:1: (lv_startPattern_4_0= RULE_STRING )
                    // InternalLDef.g:1161:3: lv_startPattern_4_0= RULE_STRING
                    {
                    lv_startPattern_4_0=(Token)match(input,RULE_STRING,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_startPattern_4_0, grammarAccess.getPartition_SingleLineRuleAccess().getStartPatternSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"startPattern",
                              		lv_startPattern_4_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }

                    // InternalLDef.g:1177:2: ( (lv_startSuffix_5_0= RULE_STRING ) )
                    // InternalLDef.g:1178:1: (lv_startSuffix_5_0= RULE_STRING )
                    {
                    // InternalLDef.g:1178:1: (lv_startSuffix_5_0= RULE_STRING )
                    // InternalLDef.g:1179:3: lv_startSuffix_5_0= RULE_STRING
                    {
                    lv_startSuffix_5_0=(Token)match(input,RULE_STRING,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_startSuffix_5_0, grammarAccess.getPartition_SingleLineRuleAccess().getStartSuffixSTRINGTerminalRuleCall_3_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"startSuffix",
                              		lv_startSuffix_5_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalLDef.g:1195:4: (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalLDef.g:1195:6: otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) )
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPartition_SingleLineRuleAccess().getColKeyword_4_0());
                          
                    }
                    // InternalLDef.g:1199:1: ( (lv_check_7_0= ruleCheck ) )
                    // InternalLDef.g:1200:1: (lv_check_7_0= ruleCheck )
                    {
                    // InternalLDef.g:1200:1: (lv_check_7_0= ruleCheck )
                    // InternalLDef.g:1201:3: lv_check_7_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPartition_SingleLineRuleAccess().getCheckCheckParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_28);
                    lv_check_7_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPartition_SingleLineRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_7_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalLDef.g:1217:4: (otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) )? )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalLDef.g:1217:6: otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) )?
                    {
                    otherlv_8=(Token)match(input,29,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_5_0());
                          
                    }
                    // InternalLDef.g:1221:1: ( (lv_endSeq_9_0= RULE_STRING ) )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RULE_STRING) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalLDef.g:1222:1: (lv_endSeq_9_0= RULE_STRING )
                            {
                            // InternalLDef.g:1222:1: (lv_endSeq_9_0= RULE_STRING )
                            // InternalLDef.g:1223:3: lv_endSeq_9_0= RULE_STRING
                            {
                            lv_endSeq_9_0=(Token)match(input,RULE_STRING,FOLLOW_30); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_endSeq_9_0, grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_5_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"endSeq",
                                      		lv_endSeq_9_0, 
                                      		"org.eclipse.xtext.common.Terminals.STRING");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalLDef.g:1239:5: (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalLDef.g:1239:7: otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,30,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_6_0());
                          
                    }
                    otherlv_11=(Token)match(input,31,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_6_1());
                          
                    }
                    // InternalLDef.g:1247:1: ( (lv_escapeSeq_12_0= RULE_STRING ) )
                    // InternalLDef.g:1248:1: (lv_escapeSeq_12_0= RULE_STRING )
                    {
                    // InternalLDef.g:1248:1: (lv_escapeSeq_12_0= RULE_STRING )
                    // InternalLDef.g:1249:3: lv_escapeSeq_12_0= RULE_STRING
                    {
                    lv_escapeSeq_12_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_12_0, grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_6_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_12_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePartition_SingleLineRule"


    // $ANTLR start "entryRulePartition_MultiLineRule"
    // InternalLDef.g:1273:1: entryRulePartition_MultiLineRule returns [EObject current=null] : iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF ;
    public final EObject entryRulePartition_MultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_MultiLineRule = null;


        try {
            // InternalLDef.g:1274:2: (iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF )
            // InternalLDef.g:1275:2: iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartition_MultiLineRule=rulePartition_MultiLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_MultiLineRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePartition_MultiLineRule"


    // $ANTLR start "rulePartition_MultiLineRule"
    // InternalLDef.g:1282:1: rulePartition_MultiLineRule returns [EObject current=null] : (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )? (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) ) (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )? ) ;
    public final EObject rulePartition_MultiLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_startSeq_2_0=null;
        Token otherlv_3=null;
        Token lv_startPattern_4_0=null;
        Token lv_startSuffix_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_endSeq_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_escapeSeq_12_0=null;
        EObject lv_check_7_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1285:28: ( (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )? (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) ) (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )? ) )
            // InternalLDef.g:1286:1: (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )? (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) ) (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )? )
            {
            // InternalLDef.g:1286:1: (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )? (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) ) (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )? )
            // InternalLDef.g:1286:3: otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )? (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? otherlv_8= '=>' ( (lv_endSeq_9_0= RULE_STRING ) ) (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0());
                  
            }
            // InternalLDef.g:1290:1: ( (otherlv_1= RULE_ID ) )
            // InternalLDef.g:1291:1: (otherlv_1= RULE_ID )
            {
            // InternalLDef.g:1291:1: (otherlv_1= RULE_ID )
            // InternalLDef.g:1292:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // InternalLDef.g:1303:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // InternalLDef.g:1304:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // InternalLDef.g:1304:1: (lv_startSeq_2_0= RULE_STRING )
            // InternalLDef.g:1305:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_startSeq_2_0, grammarAccess.getPartition_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"startSeq",
                      		lv_startSeq_2_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:1321:2: (otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==27) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalLDef.g:1321:4: otherlv_3= 'pattern' ( (lv_startPattern_4_0= RULE_STRING ) ) ( (lv_startSuffix_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPartition_MultiLineRuleAccess().getPatternKeyword_3_0());
                          
                    }
                    // InternalLDef.g:1325:1: ( (lv_startPattern_4_0= RULE_STRING ) )
                    // InternalLDef.g:1326:1: (lv_startPattern_4_0= RULE_STRING )
                    {
                    // InternalLDef.g:1326:1: (lv_startPattern_4_0= RULE_STRING )
                    // InternalLDef.g:1327:3: lv_startPattern_4_0= RULE_STRING
                    {
                    lv_startPattern_4_0=(Token)match(input,RULE_STRING,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_startPattern_4_0, grammarAccess.getPartition_MultiLineRuleAccess().getStartPatternSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"startPattern",
                              		lv_startPattern_4_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }

                    // InternalLDef.g:1343:2: ( (lv_startSuffix_5_0= RULE_STRING ) )
                    // InternalLDef.g:1344:1: (lv_startSuffix_5_0= RULE_STRING )
                    {
                    // InternalLDef.g:1344:1: (lv_startSuffix_5_0= RULE_STRING )
                    // InternalLDef.g:1345:3: lv_startSuffix_5_0= RULE_STRING
                    {
                    lv_startSuffix_5_0=(Token)match(input,RULE_STRING,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_startSuffix_5_0, grammarAccess.getPartition_MultiLineRuleAccess().getStartSuffixSTRINGTerminalRuleCall_3_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"startSuffix",
                              		lv_startSuffix_5_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalLDef.g:1361:4: (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalLDef.g:1361:6: otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) )
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPartition_MultiLineRuleAccess().getColKeyword_4_0());
                          
                    }
                    // InternalLDef.g:1365:1: ( (lv_check_7_0= ruleCheck ) )
                    // InternalLDef.g:1366:1: (lv_check_7_0= ruleCheck )
                    {
                    // InternalLDef.g:1366:1: (lv_check_7_0= ruleCheck )
                    // InternalLDef.g:1367:3: lv_check_7_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPartition_MultiLineRuleAccess().getCheckCheckParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_34);
                    lv_check_7_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPartition_MultiLineRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_7_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,29,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_5());
                  
            }
            // InternalLDef.g:1387:1: ( (lv_endSeq_9_0= RULE_STRING ) )
            // InternalLDef.g:1388:1: (lv_endSeq_9_0= RULE_STRING )
            {
            // InternalLDef.g:1388:1: (lv_endSeq_9_0= RULE_STRING )
            // InternalLDef.g:1389:3: lv_endSeq_9_0= RULE_STRING
            {
            lv_endSeq_9_0=(Token)match(input,RULE_STRING,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_endSeq_9_0, grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_6_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"endSeq",
                      		lv_endSeq_9_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:1405:2: (otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==30) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalLDef.g:1405:4: otherlv_10= 'escaped' otherlv_11= 'by' ( (lv_escapeSeq_12_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,30,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_7_0());
                          
                    }
                    otherlv_11=(Token)match(input,31,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_7_1());
                          
                    }
                    // InternalLDef.g:1413:1: ( (lv_escapeSeq_12_0= RULE_STRING ) )
                    // InternalLDef.g:1414:1: (lv_escapeSeq_12_0= RULE_STRING )
                    {
                    // InternalLDef.g:1414:1: (lv_escapeSeq_12_0= RULE_STRING )
                    // InternalLDef.g:1415:3: lv_escapeSeq_12_0= RULE_STRING
                    {
                    lv_escapeSeq_12_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_12_0, grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_7_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_12_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePartition_MultiLineRule"


    // $ANTLR start "entryRulePartition_JSRule"
    // InternalLDef.g:1439:1: entryRulePartition_JSRule returns [EObject current=null] : iv_rulePartition_JSRule= rulePartition_JSRule EOF ;
    public final EObject entryRulePartition_JSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_JSRule = null;


        try {
            // InternalLDef.g:1440:2: (iv_rulePartition_JSRule= rulePartition_JSRule EOF )
            // InternalLDef.g:1441:2: iv_rulePartition_JSRule= rulePartition_JSRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_JSRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartition_JSRule=rulePartition_JSRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_JSRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePartition_JSRule"


    // $ANTLR start "rulePartition_JSRule"
    // InternalLDef.g:1448:1: rulePartition_JSRule returns [EObject current=null] : (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? ) ;
    public final EObject rulePartition_JSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fileURI_2_0=null;
        Token otherlv_3=null;
        EObject lv_check_4_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1451:28: ( (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? ) )
            // InternalLDef.g:1452:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? )
            {
            // InternalLDef.g:1452:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? )
            // InternalLDef.g:1452:3: otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_fileURI_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartition_JSRuleAccess().getScriptKeyword_0());
                  
            }
            // InternalLDef.g:1456:1: ( (otherlv_1= RULE_ID ) )
            // InternalLDef.g:1457:1: (otherlv_1= RULE_ID )
            {
            // InternalLDef.g:1457:1: (otherlv_1= RULE_ID )
            // InternalLDef.g:1458:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_JSRuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getPartition_JSRuleAccess().getParitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // InternalLDef.g:1469:2: ( (lv_fileURI_2_0= RULE_STRING ) )
            // InternalLDef.g:1470:1: (lv_fileURI_2_0= RULE_STRING )
            {
            // InternalLDef.g:1470:1: (lv_fileURI_2_0= RULE_STRING )
            // InternalLDef.g:1471:3: lv_fileURI_2_0= RULE_STRING
            {
            lv_fileURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_fileURI_2_0, grammarAccess.getPartition_JSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_JSRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"fileURI",
                      		lv_fileURI_2_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:1487:2: (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==28) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalLDef.g:1487:4: otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPartition_JSRuleAccess().getColKeyword_3_0());
                          
                    }
                    // InternalLDef.g:1491:1: ( (lv_check_4_0= ruleCheck ) )
                    // InternalLDef.g:1492:1: (lv_check_4_0= ruleCheck )
                    {
                    // InternalLDef.g:1492:1: (lv_check_4_0= ruleCheck )
                    // InternalLDef.g:1493:3: lv_check_4_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPartition_JSRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_check_4_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPartition_JSRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_4_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePartition_JSRule"


    // $ANTLR start "entryRuleLexicalHighlighting"
    // InternalLDef.g:1517:1: entryRuleLexicalHighlighting returns [EObject current=null] : iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF ;
    public final EObject entryRuleLexicalHighlighting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalHighlighting = null;


        try {
            // InternalLDef.g:1518:2: (iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF )
            // InternalLDef.g:1519:2: iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalHighlightingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLexicalHighlighting=ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalHighlighting; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLexicalHighlighting"


    // $ANTLR start "ruleLexicalHighlighting"
    // InternalLDef.g:1526:1: ruleLexicalHighlighting returns [EObject current=null] : (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ ( (lv_vistual_3_0= ruleTokenVisuals ) )? otherlv_4= '}' ) ;
    public final EObject ruleLexicalHighlighting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_list_2_0 = null;

        EObject lv_vistual_3_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1529:28: ( (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ ( (lv_vistual_3_0= ruleTokenVisuals ) )? otherlv_4= '}' ) )
            // InternalLDef.g:1530:1: (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ ( (lv_vistual_3_0= ruleTokenVisuals ) )? otherlv_4= '}' )
            {
            // InternalLDef.g:1530:1: (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ ( (lv_vistual_3_0= ruleTokenVisuals ) )? otherlv_4= '}' )
            // InternalLDef.g:1530:3: otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ ( (lv_vistual_3_0= ruleTokenVisuals ) )? otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalLDef.g:1538:1: ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=24 && LA27_0<=25)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalLDef.g:1539:1: (lv_list_2_0= ruleLexicalPartitionHighlighting )
            	    {
            	    // InternalLDef.g:1539:1: (lv_list_2_0= ruleLexicalPartitionHighlighting )
            	    // InternalLDef.g:1540:3: lv_list_2_0= ruleLexicalPartitionHighlighting
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_list_2_0=ruleLexicalPartitionHighlighting();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLexicalHighlightingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"list",
            	              		lv_list_2_0, 
            	              		"org.eclipse.fx.code.editor.ldef.LDef.LexicalPartitionHighlighting");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            // InternalLDef.g:1556:3: ( (lv_vistual_3_0= ruleTokenVisuals ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==34) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalLDef.g:1557:1: (lv_vistual_3_0= ruleTokenVisuals )
                    {
                    // InternalLDef.g:1557:1: (lv_vistual_3_0= ruleTokenVisuals )
                    // InternalLDef.g:1558:3: lv_vistual_3_0= ruleTokenVisuals
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLexicalHighlightingAccess().getVistualTokenVisualsParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_11);
                    lv_vistual_3_0=ruleTokenVisuals();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLexicalHighlightingRule());
                      	        }
                             		set(
                             			current, 
                             			"vistual",
                              		lv_vistual_3_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.TokenVisuals");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLexicalHighlightingAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleLexicalHighlighting"


    // $ANTLR start "entryRuleTokenVisuals"
    // InternalLDef.g:1586:1: entryRuleTokenVisuals returns [EObject current=null] : iv_ruleTokenVisuals= ruleTokenVisuals EOF ;
    public final EObject entryRuleTokenVisuals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokenVisuals = null;


        try {
            // InternalLDef.g:1587:2: (iv_ruleTokenVisuals= ruleTokenVisuals EOF )
            // InternalLDef.g:1588:2: iv_ruleTokenVisuals= ruleTokenVisuals EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokenVisualsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTokenVisuals=ruleTokenVisuals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTokenVisuals; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTokenVisuals"


    // $ANTLR start "ruleTokenVisuals"
    // InternalLDef.g:1595:1: ruleTokenVisuals returns [EObject current=null] : (otherlv_0= 'token_def' otherlv_1= '{' ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+ otherlv_4= '}' ) ;
    public final EObject ruleTokenVisuals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_tokenVisuals_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1598:28: ( (otherlv_0= 'token_def' otherlv_1= '{' ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+ otherlv_4= '}' ) )
            // InternalLDef.g:1599:1: (otherlv_0= 'token_def' otherlv_1= '{' ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+ otherlv_4= '}' )
            {
            // InternalLDef.g:1599:1: (otherlv_0= 'token_def' otherlv_1= '{' ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+ otherlv_4= '}' )
            // InternalLDef.g:1599:3: otherlv_0= 'token_def' otherlv_1= '{' ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTokenVisualsAccess().getToken_defKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTokenVisualsAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalLDef.g:1607:1: ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalLDef.g:1607:2: ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';'
            	    {
            	    // InternalLDef.g:1607:2: ( (lv_tokenVisuals_2_0= ruleTokenVisual ) )
            	    // InternalLDef.g:1608:1: (lv_tokenVisuals_2_0= ruleTokenVisual )
            	    {
            	    // InternalLDef.g:1608:1: (lv_tokenVisuals_2_0= ruleTokenVisual )
            	    // InternalLDef.g:1609:3: lv_tokenVisuals_2_0= ruleTokenVisual
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTokenVisualsAccess().getTokenVisualsTokenVisualParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_tokenVisuals_2_0=ruleTokenVisual();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTokenVisualsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"tokenVisuals",
            	              		lv_tokenVisuals_2_0, 
            	              		"org.eclipse.fx.code.editor.ldef.LDef.TokenVisual");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,35,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTokenVisualsAccess().getSemicolonKeyword_2_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTokenVisualsAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleTokenVisuals"


    // $ANTLR start "entryRuleTokenVisual"
    // InternalLDef.g:1641:1: entryRuleTokenVisual returns [EObject current=null] : iv_ruleTokenVisual= ruleTokenVisual EOF ;
    public final EObject entryRuleTokenVisual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokenVisual = null;


        try {
            // InternalLDef.g:1642:2: (iv_ruleTokenVisual= ruleTokenVisual EOF )
            // InternalLDef.g:1643:2: iv_ruleTokenVisual= ruleTokenVisual EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokenVisualRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTokenVisual=ruleTokenVisual();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTokenVisual; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTokenVisual"


    // $ANTLR start "ruleTokenVisual"
    // InternalLDef.g:1650:1: ruleTokenVisual returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_colorSpec_1_0= RULE_STRING ) ) ( (lv_bold_2_0= 'bold' ) )? ( (lv_italic_3_0= 'italic' ) )? ) ;
    public final EObject ruleTokenVisual() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_colorSpec_1_0=null;
        Token lv_bold_2_0=null;
        Token lv_italic_3_0=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:1653:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_colorSpec_1_0= RULE_STRING ) ) ( (lv_bold_2_0= 'bold' ) )? ( (lv_italic_3_0= 'italic' ) )? ) )
            // InternalLDef.g:1654:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_colorSpec_1_0= RULE_STRING ) ) ( (lv_bold_2_0= 'bold' ) )? ( (lv_italic_3_0= 'italic' ) )? )
            {
            // InternalLDef.g:1654:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_colorSpec_1_0= RULE_STRING ) ) ( (lv_bold_2_0= 'bold' ) )? ( (lv_italic_3_0= 'italic' ) )? )
            // InternalLDef.g:1654:2: ( (otherlv_0= RULE_ID ) ) ( (lv_colorSpec_1_0= RULE_STRING ) ) ( (lv_bold_2_0= 'bold' ) )? ( (lv_italic_3_0= 'italic' ) )?
            {
            // InternalLDef.g:1654:2: ( (otherlv_0= RULE_ID ) )
            // InternalLDef.g:1655:1: (otherlv_0= RULE_ID )
            {
            // InternalLDef.g:1655:1: (otherlv_0= RULE_ID )
            // InternalLDef.g:1656:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTokenVisualRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getTokenVisualAccess().getTokenTokenCrossReference_0_0()); 
              	
            }

            }


            }

            // InternalLDef.g:1667:2: ( (lv_colorSpec_1_0= RULE_STRING ) )
            // InternalLDef.g:1668:1: (lv_colorSpec_1_0= RULE_STRING )
            {
            // InternalLDef.g:1668:1: (lv_colorSpec_1_0= RULE_STRING )
            // InternalLDef.g:1669:3: lv_colorSpec_1_0= RULE_STRING
            {
            lv_colorSpec_1_0=(Token)match(input,RULE_STRING,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_colorSpec_1_0, grammarAccess.getTokenVisualAccess().getColorSpecSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTokenVisualRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"colorSpec",
                      		lv_colorSpec_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:1685:2: ( (lv_bold_2_0= 'bold' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==36) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalLDef.g:1686:1: (lv_bold_2_0= 'bold' )
                    {
                    // InternalLDef.g:1686:1: (lv_bold_2_0= 'bold' )
                    // InternalLDef.g:1687:3: lv_bold_2_0= 'bold'
                    {
                    lv_bold_2_0=(Token)match(input,36,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_bold_2_0, grammarAccess.getTokenVisualAccess().getBoldBoldKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTokenVisualRule());
                      	        }
                             		setWithLastConsumed(current, "bold", true, "bold");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalLDef.g:1700:3: ( (lv_italic_3_0= 'italic' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==37) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalLDef.g:1701:1: (lv_italic_3_0= 'italic' )
                    {
                    // InternalLDef.g:1701:1: (lv_italic_3_0= 'italic' )
                    // InternalLDef.g:1702:3: lv_italic_3_0= 'italic'
                    {
                    lv_italic_3_0=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_italic_3_0, grammarAccess.getTokenVisualAccess().getItalicItalicKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTokenVisualRule());
                      	        }
                             		setWithLastConsumed(current, "italic", true, "italic");
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleTokenVisual"


    // $ANTLR start "entryRuleLexicalPartitionHighlighting"
    // InternalLDef.g:1723:1: entryRuleLexicalPartitionHighlighting returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting = null;


        try {
            // InternalLDef.g:1724:2: (iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF )
            // InternalLDef.g:1725:2: iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLexicalPartitionHighlighting=ruleLexicalPartitionHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLexicalPartitionHighlighting"


    // $ANTLR start "ruleLexicalPartitionHighlighting"
    // InternalLDef.g:1732:1: ruleLexicalPartitionHighlighting returns [EObject current=null] : (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS ) ;
    public final EObject ruleLexicalPartitionHighlighting() throws RecognitionException {
        EObject current = null;

        EObject this_LexicalPartitionHighlighting_Rule_0 = null;

        EObject this_LexicalPartitionHighlighting_JS_1 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1735:28: ( (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS ) )
            // InternalLDef.g:1736:1: (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS )
            {
            // InternalLDef.g:1736:1: (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            else if ( (LA32_0==24) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalLDef.g:1737:5: this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_LexicalPartitionHighlighting_Rule_0=ruleLexicalPartitionHighlighting_Rule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LexicalPartitionHighlighting_Rule_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:1747:5: this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_LexicalPartitionHighlighting_JS_1=ruleLexicalPartitionHighlighting_JS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LexicalPartitionHighlighting_JS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleLexicalPartitionHighlighting"


    // $ANTLR start "entryRuleLexicalPartitionHighlighting_JS"
    // InternalLDef.g:1763:1: entryRuleLexicalPartitionHighlighting_JS returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting_JS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting_JS = null;


        try {
            // InternalLDef.g:1764:2: (iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF )
            // InternalLDef.g:1765:2: iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLexicalPartitionHighlighting_JS=ruleLexicalPartitionHighlighting_JS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting_JS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLexicalPartitionHighlighting_JS"


    // $ANTLR start "ruleLexicalPartitionHighlighting_JS"
    // InternalLDef.g:1772:1: ruleLexicalPartitionHighlighting_JS returns [EObject current=null] : (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleLexicalPartitionHighlighting_JS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_scriptURI_2_0=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:1775:28: ( (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) ) )
            // InternalLDef.g:1776:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) )
            {
            // InternalLDef.g:1776:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) )
            // InternalLDef.g:1776:3: otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0());
                  
            }
            // InternalLDef.g:1780:1: ( (otherlv_1= RULE_ID ) )
            // InternalLDef.g:1781:1: (otherlv_1= RULE_ID )
            {
            // InternalLDef.g:1781:1: (otherlv_1= RULE_ID )
            // InternalLDef.g:1782:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_JSRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // InternalLDef.g:1793:2: ( (lv_scriptURI_2_0= RULE_STRING ) )
            // InternalLDef.g:1794:1: (lv_scriptURI_2_0= RULE_STRING )
            {
            // InternalLDef.g:1794:1: (lv_scriptURI_2_0= RULE_STRING )
            // InternalLDef.g:1795:3: lv_scriptURI_2_0= RULE_STRING
            {
            lv_scriptURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_scriptURI_2_0, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptURISTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_JSRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"scriptURI",
                      		lv_scriptURI_2_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleLexicalPartitionHighlighting_JS"


    // $ANTLR start "entryRuleLexicalPartitionHighlighting_Rule"
    // InternalLDef.g:1819:1: entryRuleLexicalPartitionHighlighting_Rule returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting_Rule = null;


        try {
            // InternalLDef.g:1820:2: (iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF )
            // InternalLDef.g:1821:2: iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLexicalPartitionHighlighting_Rule=ruleLexicalPartitionHighlighting_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting_Rule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLexicalPartitionHighlighting_Rule"


    // $ANTLR start "ruleLexicalPartitionHighlighting_Rule"
    // InternalLDef.g:1828:1: ruleLexicalPartitionHighlighting_Rule returns [EObject current=null] : (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' ) ;
    public final EObject ruleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_whitespace_2_0 = null;

        EObject lv_tokenList_4_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1831:28: ( (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' ) )
            // InternalLDef.g:1832:1: (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' )
            {
            // InternalLDef.g:1832:1: (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' )
            // InternalLDef.g:1832:3: otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0());
                  
            }
            // InternalLDef.g:1836:1: ( (otherlv_1= RULE_ID ) )
            // InternalLDef.g:1837:1: (otherlv_1= RULE_ID )
            {
            // InternalLDef.g:1837:1: (otherlv_1= RULE_ID )
            // InternalLDef.g:1838:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_RuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // InternalLDef.g:1849:2: ( (lv_whitespace_2_0= ruleWhitespaceRule ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==54) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalLDef.g:1850:1: (lv_whitespace_2_0= ruleWhitespaceRule )
                    {
                    // InternalLDef.g:1850:1: (lv_whitespace_2_0= ruleWhitespaceRule )
                    // InternalLDef.g:1851:3: lv_whitespace_2_0= ruleWhitespaceRule
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceWhitespaceRuleParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_7);
                    lv_whitespace_2_0=ruleWhitespaceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLexicalPartitionHighlighting_RuleRule());
                      	        }
                             		set(
                             			current, 
                             			"whitespace",
                              		lv_whitespace_2_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.WhitespaceRule");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,15,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // InternalLDef.g:1871:1: ( (lv_tokenList_4_0= ruleToken ) )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID||LA34_0==38) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalLDef.g:1872:1: (lv_tokenList_4_0= ruleToken )
            	    {
            	    // InternalLDef.g:1872:1: (lv_tokenList_4_0= ruleToken )
            	    // InternalLDef.g:1873:3: lv_tokenList_4_0= ruleToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_tokenList_4_0=ruleToken();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLexicalPartitionHighlighting_RuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"tokenList",
            	              		lv_tokenList_4_0, 
            	              		"org.eclipse.fx.code.editor.ldef.LDef.Token");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleLexicalPartitionHighlighting_Rule"


    // $ANTLR start "entryRuleToken"
    // InternalLDef.g:1901:1: entryRuleToken returns [EObject current=null] : iv_ruleToken= ruleToken EOF ;
    public final EObject entryRuleToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleToken = null;


        try {
            // InternalLDef.g:1902:2: (iv_ruleToken= ruleToken EOF )
            // InternalLDef.g:1903:2: iv_ruleToken= ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleToken=ruleToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleToken; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleToken"


    // $ANTLR start "ruleToken"
    // InternalLDef.g:1910:1: ruleToken returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? ) ;
    public final EObject ruleToken() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_scannerList_3_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1913:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? ) )
            // InternalLDef.g:1914:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? )
            {
            // InternalLDef.g:1914:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? )
            // InternalLDef.g:1914:2: ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )?
            {
            // InternalLDef.g:1914:2: ( (lv_default_0_0= 'default' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==38) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalLDef.g:1915:1: (lv_default_0_0= 'default' )
                    {
                    // InternalLDef.g:1915:1: (lv_default_0_0= 'default' )
                    // InternalLDef.g:1916:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,38,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_default_0_0, grammarAccess.getTokenAccess().getDefaultDefaultKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTokenRule());
                      	        }
                             		setWithLastConsumed(current, "default", true, "default");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalLDef.g:1929:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLDef.g:1930:1: (lv_name_1_0= RULE_ID )
            {
            // InternalLDef.g:1930:1: (lv_name_1_0= RULE_ID )
            // InternalLDef.g:1931:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getTokenAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTokenRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            // InternalLDef.g:1947:2: (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==15) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalLDef.g:1947:4: otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // InternalLDef.g:1951:1: ( (lv_scannerList_3_0= ruleScanner ) )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==24||(LA36_0>=26 && LA36_0<=27)||LA36_0==32||LA36_0==39||LA36_0==46) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalLDef.g:1952:1: (lv_scannerList_3_0= ruleScanner )
                    	    {
                    	    // InternalLDef.g:1952:1: (lv_scannerList_3_0= ruleScanner )
                    	    // InternalLDef.g:1953:3: lv_scannerList_3_0= ruleScanner
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_45);
                    	    lv_scannerList_3_0=ruleScanner();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTokenRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"scannerList",
                    	              		lv_scannerList_3_0, 
                    	              		"org.eclipse.fx.code.editor.ldef.LDef.Scanner");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);

                    otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getTokenAccess().getRightCurlyBracketKeyword_2_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleToken"


    // $ANTLR start "entryRuleScanner"
    // InternalLDef.g:1981:1: entryRuleScanner returns [EObject current=null] : iv_ruleScanner= ruleScanner EOF ;
    public final EObject entryRuleScanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner = null;


        try {
            // InternalLDef.g:1982:2: (iv_ruleScanner= ruleScanner EOF )
            // InternalLDef.g:1983:2: iv_ruleScanner= ruleScanner EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScannerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScanner=ruleScanner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalLDef.g:1990:1: ruleScanner returns [EObject current=null] : (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule ) ;
    public final EObject ruleScanner() throws RecognitionException {
        EObject current = null;

        EObject this_Scanner_Keyword_0 = null;

        EObject this_Scanner_Rule_1 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:1993:28: ( (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule ) )
            // InternalLDef.g:1994:1: (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule )
            {
            // InternalLDef.g:1994:1: (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==39) ) {
                alt38=1;
            }
            else if ( (LA38_0==24||(LA38_0>=26 && LA38_0<=27)||LA38_0==32||LA38_0==46) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalLDef.g:1995:5: this_Scanner_Keyword_0= ruleScanner_Keyword
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Scanner_Keyword_0=ruleScanner_Keyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Scanner_Keyword_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:2005:5: this_Scanner_Rule_1= ruleScanner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Scanner_Rule_1=ruleScanner_Rule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Scanner_Rule_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScanner"


    // $ANTLR start "entryRuleScanner_Keyword"
    // InternalLDef.g:2021:1: entryRuleScanner_Keyword returns [EObject current=null] : iv_ruleScanner_Keyword= ruleScanner_Keyword EOF ;
    public final EObject entryRuleScanner_Keyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_Keyword = null;


        try {
            // InternalLDef.g:2022:2: (iv_ruleScanner_Keyword= ruleScanner_Keyword EOF )
            // InternalLDef.g:2023:2: iv_ruleScanner_Keyword= ruleScanner_Keyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_KeywordRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScanner_Keyword=ruleScanner_Keyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_Keyword; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScanner_Keyword"


    // $ANTLR start "ruleScanner_Keyword"
    // InternalLDef.g:2030:1: ruleScanner_Keyword returns [EObject current=null] : (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' (otherlv_6= 'enabledif' ( (lv_enabledIf_7_0= ruleScannerCondition ) ) )? ) ;
    public final EObject ruleScanner_Keyword() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_keywords_2_0 = null;

        EObject lv_keywords_4_0 = null;

        EObject lv_enabledIf_7_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:2033:28: ( (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' (otherlv_6= 'enabledif' ( (lv_enabledIf_7_0= ruleScannerCondition ) ) )? ) )
            // InternalLDef.g:2034:1: (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' (otherlv_6= 'enabledif' ( (lv_enabledIf_7_0= ruleScannerCondition ) ) )? )
            {
            // InternalLDef.g:2034:1: (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' (otherlv_6= 'enabledif' ( (lv_enabledIf_7_0= ruleScannerCondition ) ) )? )
            // InternalLDef.g:2034:3: otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' (otherlv_6= 'enabledif' ( (lv_enabledIf_7_0= ruleScannerCondition ) ) )?
            {
            otherlv_0=(Token)match(input,39,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,40,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // InternalLDef.g:2042:1: ( (lv_keywords_2_0= ruleKeyword ) )
            // InternalLDef.g:2043:1: (lv_keywords_2_0= ruleKeyword )
            {
            // InternalLDef.g:2043:1: (lv_keywords_2_0= ruleKeyword )
            // InternalLDef.g:2044:3: lv_keywords_2_0= ruleKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_47);
            lv_keywords_2_0=ruleKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScanner_KeywordRule());
              	        }
                     		add(
                     			current, 
                     			"keywords",
                      		lv_keywords_2_0, 
                      		"org.eclipse.fx.code.editor.ldef.LDef.Keyword");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalLDef.g:2060:2: (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==41) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalLDef.g:2060:4: otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) )
            	    {
            	    otherlv_3=(Token)match(input,41,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalLDef.g:2064:1: ( (lv_keywords_4_0= ruleKeyword ) )
            	    // InternalLDef.g:2065:1: (lv_keywords_4_0= ruleKeyword )
            	    {
            	    // InternalLDef.g:2065:1: (lv_keywords_4_0= ruleKeyword )
            	    // InternalLDef.g:2066:3: lv_keywords_4_0= ruleKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_47);
            	    lv_keywords_4_0=ruleKeyword();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getScanner_KeywordRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"keywords",
            	              		lv_keywords_4_0, 
            	              		"org.eclipse.fx.code.editor.ldef.LDef.Keyword");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            otherlv_5=(Token)match(input,42,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getScanner_KeywordAccess().getRightSquareBracketKeyword_4());
                  
            }
            // InternalLDef.g:2086:1: (otherlv_6= 'enabledif' ( (lv_enabledIf_7_0= ruleScannerCondition ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==43) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalLDef.g:2086:3: otherlv_6= 'enabledif' ( (lv_enabledIf_7_0= ruleScannerCondition ) )
                    {
                    otherlv_6=(Token)match(input,43,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getScanner_KeywordAccess().getEnabledifKeyword_5_0());
                          
                    }
                    // InternalLDef.g:2090:1: ( (lv_enabledIf_7_0= ruleScannerCondition ) )
                    // InternalLDef.g:2091:1: (lv_enabledIf_7_0= ruleScannerCondition )
                    {
                    // InternalLDef.g:2091:1: (lv_enabledIf_7_0= ruleScannerCondition )
                    // InternalLDef.g:2092:3: lv_enabledIf_7_0= ruleScannerCondition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getEnabledIfScannerConditionParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_enabledIf_7_0=ruleScannerCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_KeywordRule());
                      	        }
                             		set(
                             			current, 
                             			"enabledIf",
                              		lv_enabledIf_7_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.ScannerCondition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScanner_Keyword"


    // $ANTLR start "entryRuleKeyword"
    // InternalLDef.g:2116:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // InternalLDef.g:2117:2: (iv_ruleKeyword= ruleKeyword EOF )
            // InternalLDef.g:2118:2: iv_ruleKeyword= ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyword; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalLDef.g:2125:1: ruleKeyword returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_version_2_0=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:2128:28: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) )
            // InternalLDef.g:2129:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            {
            // InternalLDef.g:2129:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            // InternalLDef.g:2129:2: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            {
            // InternalLDef.g:2129:2: ( (lv_name_0_0= RULE_STRING ) )
            // InternalLDef.g:2130:1: (lv_name_0_0= RULE_STRING )
            {
            // InternalLDef.g:2130:1: (lv_name_0_0= RULE_STRING )
            // InternalLDef.g:2131:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getKeywordAccess().getNameSTRINGTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getKeywordRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:2147:2: (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==44) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalLDef.g:2147:4: otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getKeywordAccess().getSinceKeyword_1_0());
                          
                    }
                    // InternalLDef.g:2151:1: ( (lv_version_2_0= RULE_STRING ) )
                    // InternalLDef.g:2152:1: (lv_version_2_0= RULE_STRING )
                    {
                    // InternalLDef.g:2152:1: (lv_version_2_0= RULE_STRING )
                    // InternalLDef.g:2153:3: lv_version_2_0= RULE_STRING
                    {
                    lv_version_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_version_2_0, grammarAccess.getKeywordAccess().getVersionSTRINGTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getKeywordRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"version",
                              		lv_version_2_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleScanner_Rule"
    // InternalLDef.g:2177:1: entryRuleScanner_Rule returns [EObject current=null] : iv_ruleScanner_Rule= ruleScanner_Rule EOF ;
    public final EObject entryRuleScanner_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_Rule = null;


        try {
            // InternalLDef.g:2178:2: (iv_ruleScanner_Rule= ruleScanner_Rule EOF )
            // InternalLDef.g:2179:2: iv_ruleScanner_Rule= ruleScanner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_RuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScanner_Rule=ruleScanner_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_Rule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScanner_Rule"


    // $ANTLR start "ruleScanner_Rule"
    // InternalLDef.g:2186:1: ruleScanner_Rule returns [EObject current=null] : (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule ) ;
    public final EObject ruleScanner_Rule() throws RecognitionException {
        EObject current = null;

        EObject this_Scanner_SingleLineRule_0 = null;

        EObject this_Scanner_MultiLineRule_1 = null;

        EObject this_Scanner_CharacterRule_2 = null;

        EObject this_Scanner_JSRule_3 = null;

        EObject this_Scanner_PatternRule_4 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:2189:28: ( (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule ) )
            // InternalLDef.g:2190:1: (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule )
            {
            // InternalLDef.g:2190:1: (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule )
            int alt42=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt42=1;
                }
                break;
            case 32:
                {
                alt42=2;
                }
                break;
            case 46:
                {
                alt42=3;
                }
                break;
            case 24:
                {
                alt42=4;
                }
                break;
            case 27:
                {
                alt42=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalLDef.g:2191:5: this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Scanner_SingleLineRule_0=ruleScanner_SingleLineRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Scanner_SingleLineRule_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:2201:5: this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Scanner_MultiLineRule_1=ruleScanner_MultiLineRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Scanner_MultiLineRule_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalLDef.g:2211:5: this_Scanner_CharacterRule_2= ruleScanner_CharacterRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Scanner_CharacterRule_2=ruleScanner_CharacterRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Scanner_CharacterRule_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalLDef.g:2221:5: this_Scanner_JSRule_3= ruleScanner_JSRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Scanner_JSRule_3=ruleScanner_JSRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Scanner_JSRule_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalLDef.g:2231:5: this_Scanner_PatternRule_4= ruleScanner_PatternRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_PatternRuleParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Scanner_PatternRule_4=ruleScanner_PatternRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Scanner_PatternRule_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScanner_Rule"


    // $ANTLR start "entryRuleScanner_SingleLineRule"
    // InternalLDef.g:2247:1: entryRuleScanner_SingleLineRule returns [EObject current=null] : iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF ;
    public final EObject entryRuleScanner_SingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_SingleLineRule = null;


        try {
            // InternalLDef.g:2248:2: (iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF )
            // InternalLDef.g:2249:2: iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScanner_SingleLineRule=ruleScanner_SingleLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_SingleLineRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScanner_SingleLineRule"


    // $ANTLR start "ruleScanner_SingleLineRule"
    // InternalLDef.g:2256:1: ruleScanner_SingleLineRule returns [EObject current=null] : (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )? (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )? (otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) )? )? (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )? (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )? ) ;
    public final EObject ruleScanner_SingleLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_startSeq_1_0=null;
        Token otherlv_2=null;
        Token lv_startPattern_3_0=null;
        Token lv_startSuffix_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_endSeq_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_escapeSeq_11_0=null;
        Token otherlv_12=null;
        EObject lv_check_6_0 = null;

        EObject lv_enabledIf_13_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:2259:28: ( (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )? (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )? (otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) )? )? (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )? (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )? ) )
            // InternalLDef.g:2260:1: (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )? (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )? (otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) )? )? (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )? (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )? )
            {
            // InternalLDef.g:2260:1: (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )? (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )? (otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) )? )? (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )? (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )? )
            // InternalLDef.g:2260:3: otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )? (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )? (otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) )? )? (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )? (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0());
                  
            }
            // InternalLDef.g:2264:1: ( (lv_startSeq_1_0= RULE_STRING ) )
            // InternalLDef.g:2265:1: (lv_startSeq_1_0= RULE_STRING )
            {
            // InternalLDef.g:2265:1: (lv_startSeq_1_0= RULE_STRING )
            // InternalLDef.g:2266:3: lv_startSeq_1_0= RULE_STRING
            {
            lv_startSeq_1_0=(Token)match(input,RULE_STRING,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_startSeq_1_0, grammarAccess.getScanner_SingleLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScanner_SingleLineRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"startSeq",
                      		lv_startSeq_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:2282:2: (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==27) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==RULE_STRING) ) {
                    int LA43_3 = input.LA(3);

                    if ( (LA43_3==RULE_STRING) ) {
                        alt43=1;
                    }
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalLDef.g:2282:4: otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getScanner_SingleLineRuleAccess().getPatternKeyword_2_0());
                          
                    }
                    // InternalLDef.g:2286:1: ( (lv_startPattern_3_0= RULE_STRING ) )
                    // InternalLDef.g:2287:1: (lv_startPattern_3_0= RULE_STRING )
                    {
                    // InternalLDef.g:2287:1: (lv_startPattern_3_0= RULE_STRING )
                    // InternalLDef.g:2288:3: lv_startPattern_3_0= RULE_STRING
                    {
                    lv_startPattern_3_0=(Token)match(input,RULE_STRING,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_startPattern_3_0, grammarAccess.getScanner_SingleLineRuleAccess().getStartPatternSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"startPattern",
                              		lv_startPattern_3_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }

                    // InternalLDef.g:2304:2: ( (lv_startSuffix_4_0= RULE_STRING ) )
                    // InternalLDef.g:2305:1: (lv_startSuffix_4_0= RULE_STRING )
                    {
                    // InternalLDef.g:2305:1: (lv_startSuffix_4_0= RULE_STRING )
                    // InternalLDef.g:2306:3: lv_startSuffix_4_0= RULE_STRING
                    {
                    lv_startSuffix_4_0=(Token)match(input,RULE_STRING,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_startSuffix_4_0, grammarAccess.getScanner_SingleLineRuleAccess().getStartSuffixSTRINGTerminalRuleCall_2_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"startSuffix",
                              		lv_startSuffix_4_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalLDef.g:2322:4: (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==28) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalLDef.g:2322:6: otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getScanner_SingleLineRuleAccess().getColKeyword_3_0());
                          
                    }
                    // InternalLDef.g:2326:1: ( (lv_check_6_0= ruleCheck ) )
                    // InternalLDef.g:2327:1: (lv_check_6_0= ruleCheck )
                    {
                    // InternalLDef.g:2327:1: (lv_check_6_0= ruleCheck )
                    // InternalLDef.g:2328:3: lv_check_6_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_SingleLineRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_53);
                    lv_check_6_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_SingleLineRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_6_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalLDef.g:2344:4: (otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) )? )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==29) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalLDef.g:2344:6: otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) )?
                    {
                    otherlv_7=(Token)match(input,29,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_4_0());
                          
                    }
                    // InternalLDef.g:2348:1: ( (lv_endSeq_8_0= RULE_STRING ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==RULE_STRING) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalLDef.g:2349:1: (lv_endSeq_8_0= RULE_STRING )
                            {
                            // InternalLDef.g:2349:1: (lv_endSeq_8_0= RULE_STRING )
                            // InternalLDef.g:2350:3: lv_endSeq_8_0= RULE_STRING
                            {
                            lv_endSeq_8_0=(Token)match(input,RULE_STRING,FOLLOW_55); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_endSeq_8_0, grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getScanner_SingleLineRuleRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"endSeq",
                                      		lv_endSeq_8_0, 
                                      		"org.eclipse.xtext.common.Terminals.STRING");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalLDef.g:2366:5: (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==30) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalLDef.g:2366:7: otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,30,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_5_0());
                          
                    }
                    otherlv_10=(Token)match(input,31,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_5_1());
                          
                    }
                    // InternalLDef.g:2374:1: ( (lv_escapeSeq_11_0= RULE_STRING ) )
                    // InternalLDef.g:2375:1: (lv_escapeSeq_11_0= RULE_STRING )
                    {
                    // InternalLDef.g:2375:1: (lv_escapeSeq_11_0= RULE_STRING )
                    // InternalLDef.g:2376:3: lv_escapeSeq_11_0= RULE_STRING
                    {
                    lv_escapeSeq_11_0=(Token)match(input,RULE_STRING,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_11_0, grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_11_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalLDef.g:2392:4: (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==43) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalLDef.g:2392:6: otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) )
                    {
                    otherlv_12=(Token)match(input,43,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getScanner_SingleLineRuleAccess().getEnabledifKeyword_6_0());
                          
                    }
                    // InternalLDef.g:2396:1: ( (lv_enabledIf_13_0= ruleScannerCondition ) )
                    // InternalLDef.g:2397:1: (lv_enabledIf_13_0= ruleScannerCondition )
                    {
                    // InternalLDef.g:2397:1: (lv_enabledIf_13_0= ruleScannerCondition )
                    // InternalLDef.g:2398:3: lv_enabledIf_13_0= ruleScannerCondition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_SingleLineRuleAccess().getEnabledIfScannerConditionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_enabledIf_13_0=ruleScannerCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_SingleLineRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"enabledIf",
                              		lv_enabledIf_13_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.ScannerCondition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScanner_SingleLineRule"


    // $ANTLR start "entryRuleScanner_MultiLineRule"
    // InternalLDef.g:2422:1: entryRuleScanner_MultiLineRule returns [EObject current=null] : iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF ;
    public final EObject entryRuleScanner_MultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_MultiLineRule = null;


        try {
            // InternalLDef.g:2423:2: (iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF )
            // InternalLDef.g:2424:2: iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScanner_MultiLineRule=ruleScanner_MultiLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_MultiLineRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScanner_MultiLineRule"


    // $ANTLR start "ruleScanner_MultiLineRule"
    // InternalLDef.g:2431:1: ruleScanner_MultiLineRule returns [EObject current=null] : (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )? (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )? otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) ) (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )? (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )? ) ;
    public final EObject ruleScanner_MultiLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_startSeq_1_0=null;
        Token otherlv_2=null;
        Token lv_startPattern_3_0=null;
        Token lv_startSuffix_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_endSeq_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_escapeSeq_11_0=null;
        Token otherlv_12=null;
        EObject lv_check_6_0 = null;

        EObject lv_enabledIf_13_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:2434:28: ( (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )? (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )? otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) ) (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )? (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )? ) )
            // InternalLDef.g:2435:1: (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )? (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )? otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) ) (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )? (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )? )
            {
            // InternalLDef.g:2435:1: (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )? (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )? otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) ) (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )? (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )? )
            // InternalLDef.g:2435:3: otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )? (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )? otherlv_7= '=>' ( (lv_endSeq_8_0= RULE_STRING ) ) (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )? (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0());
                  
            }
            // InternalLDef.g:2439:1: ( (lv_startSeq_1_0= RULE_STRING ) )
            // InternalLDef.g:2440:1: (lv_startSeq_1_0= RULE_STRING )
            {
            // InternalLDef.g:2440:1: (lv_startSeq_1_0= RULE_STRING )
            // InternalLDef.g:2441:3: lv_startSeq_1_0= RULE_STRING
            {
            lv_startSeq_1_0=(Token)match(input,RULE_STRING,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_startSeq_1_0, grammarAccess.getScanner_MultiLineRuleAccess().getStartSeqSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScanner_MultiLineRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"startSeq",
                      		lv_startSeq_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:2457:2: (otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==27) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalLDef.g:2457:4: otherlv_2= 'pattern' ( (lv_startPattern_3_0= RULE_STRING ) ) ( (lv_startSuffix_4_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getScanner_MultiLineRuleAccess().getPatternKeyword_2_0());
                          
                    }
                    // InternalLDef.g:2461:1: ( (lv_startPattern_3_0= RULE_STRING ) )
                    // InternalLDef.g:2462:1: (lv_startPattern_3_0= RULE_STRING )
                    {
                    // InternalLDef.g:2462:1: (lv_startPattern_3_0= RULE_STRING )
                    // InternalLDef.g:2463:3: lv_startPattern_3_0= RULE_STRING
                    {
                    lv_startPattern_3_0=(Token)match(input,RULE_STRING,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_startPattern_3_0, grammarAccess.getScanner_MultiLineRuleAccess().getStartPatternSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_MultiLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"startPattern",
                              		lv_startPattern_3_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }

                    // InternalLDef.g:2479:2: ( (lv_startSuffix_4_0= RULE_STRING ) )
                    // InternalLDef.g:2480:1: (lv_startSuffix_4_0= RULE_STRING )
                    {
                    // InternalLDef.g:2480:1: (lv_startSuffix_4_0= RULE_STRING )
                    // InternalLDef.g:2481:3: lv_startSuffix_4_0= RULE_STRING
                    {
                    lv_startSuffix_4_0=(Token)match(input,RULE_STRING,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_startSuffix_4_0, grammarAccess.getScanner_MultiLineRuleAccess().getStartSuffixSTRINGTerminalRuleCall_2_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_MultiLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"startSuffix",
                              		lv_startSuffix_4_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalLDef.g:2497:4: (otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==28) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalLDef.g:2497:6: otherlv_5= 'col' ( (lv_check_6_0= ruleCheck ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getScanner_MultiLineRuleAccess().getColKeyword_3_0());
                          
                    }
                    // InternalLDef.g:2501:1: ( (lv_check_6_0= ruleCheck ) )
                    // InternalLDef.g:2502:1: (lv_check_6_0= ruleCheck )
                    {
                    // InternalLDef.g:2502:1: (lv_check_6_0= ruleCheck )
                    // InternalLDef.g:2503:3: lv_check_6_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_MultiLineRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_34);
                    lv_check_6_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_MultiLineRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_6_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,29,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_4());
                  
            }
            // InternalLDef.g:2523:1: ( (lv_endSeq_8_0= RULE_STRING ) )
            // InternalLDef.g:2524:1: (lv_endSeq_8_0= RULE_STRING )
            {
            // InternalLDef.g:2524:1: (lv_endSeq_8_0= RULE_STRING )
            // InternalLDef.g:2525:3: lv_endSeq_8_0= RULE_STRING
            {
            lv_endSeq_8_0=(Token)match(input,RULE_STRING,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_endSeq_8_0, grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScanner_MultiLineRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"endSeq",
                      		lv_endSeq_8_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:2541:2: (otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==30) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalLDef.g:2541:4: otherlv_9= 'escaped' otherlv_10= 'by' ( (lv_escapeSeq_11_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,30,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_6_0());
                          
                    }
                    otherlv_10=(Token)match(input,31,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_6_1());
                          
                    }
                    // InternalLDef.g:2549:1: ( (lv_escapeSeq_11_0= RULE_STRING ) )
                    // InternalLDef.g:2550:1: (lv_escapeSeq_11_0= RULE_STRING )
                    {
                    // InternalLDef.g:2550:1: (lv_escapeSeq_11_0= RULE_STRING )
                    // InternalLDef.g:2551:3: lv_escapeSeq_11_0= RULE_STRING
                    {
                    lv_escapeSeq_11_0=(Token)match(input,RULE_STRING,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_11_0, grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_6_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_MultiLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_11_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalLDef.g:2567:4: (otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==43) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalLDef.g:2567:6: otherlv_12= 'enabledif' ( (lv_enabledIf_13_0= ruleScannerCondition ) )
                    {
                    otherlv_12=(Token)match(input,43,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getScanner_MultiLineRuleAccess().getEnabledifKeyword_7_0());
                          
                    }
                    // InternalLDef.g:2571:1: ( (lv_enabledIf_13_0= ruleScannerCondition ) )
                    // InternalLDef.g:2572:1: (lv_enabledIf_13_0= ruleScannerCondition )
                    {
                    // InternalLDef.g:2572:1: (lv_enabledIf_13_0= ruleScannerCondition )
                    // InternalLDef.g:2573:3: lv_enabledIf_13_0= ruleScannerCondition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_MultiLineRuleAccess().getEnabledIfScannerConditionParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_enabledIf_13_0=ruleScannerCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_MultiLineRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"enabledIf",
                              		lv_enabledIf_13_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.ScannerCondition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScanner_MultiLineRule"


    // $ANTLR start "entryRuleScanner_PatternRule"
    // InternalLDef.g:2597:1: entryRuleScanner_PatternRule returns [EObject current=null] : iv_ruleScanner_PatternRule= ruleScanner_PatternRule EOF ;
    public final EObject entryRuleScanner_PatternRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_PatternRule = null;


        try {
            // InternalLDef.g:2598:2: (iv_ruleScanner_PatternRule= ruleScanner_PatternRule EOF )
            // InternalLDef.g:2599:2: iv_ruleScanner_PatternRule= ruleScanner_PatternRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_PatternRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScanner_PatternRule=ruleScanner_PatternRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_PatternRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScanner_PatternRule"


    // $ANTLR start "ruleScanner_PatternRule"
    // InternalLDef.g:2606:1: ruleScanner_PatternRule returns [EObject current=null] : (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= 'containing' ( (lv_contentPattern_6_0= RULE_STRING ) ) (otherlv_7= 'enabledif' ( (lv_enabledIf_8_0= ruleScannerCondition ) ) )? ) ;
    public final EObject ruleScanner_PatternRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_startPattern_1_0=null;
        Token lv_length_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_contentPattern_6_0=null;
        Token otherlv_7=null;
        EObject lv_check_4_0 = null;

        EObject lv_enabledIf_8_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:2609:28: ( (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= 'containing' ( (lv_contentPattern_6_0= RULE_STRING ) ) (otherlv_7= 'enabledif' ( (lv_enabledIf_8_0= ruleScannerCondition ) ) )? ) )
            // InternalLDef.g:2610:1: (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= 'containing' ( (lv_contentPattern_6_0= RULE_STRING ) ) (otherlv_7= 'enabledif' ( (lv_enabledIf_8_0= ruleScannerCondition ) ) )? )
            {
            // InternalLDef.g:2610:1: (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= 'containing' ( (lv_contentPattern_6_0= RULE_STRING ) ) (otherlv_7= 'enabledif' ( (lv_enabledIf_8_0= ruleScannerCondition ) ) )? )
            // InternalLDef.g:2610:3: otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= 'containing' ( (lv_contentPattern_6_0= RULE_STRING ) ) (otherlv_7= 'enabledif' ( (lv_enabledIf_8_0= ruleScannerCondition ) ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_PatternRuleAccess().getPatternKeyword_0());
                  
            }
            // InternalLDef.g:2614:1: ( (lv_startPattern_1_0= RULE_STRING ) )
            // InternalLDef.g:2615:1: (lv_startPattern_1_0= RULE_STRING )
            {
            // InternalLDef.g:2615:1: (lv_startPattern_1_0= RULE_STRING )
            // InternalLDef.g:2616:3: lv_startPattern_1_0= RULE_STRING
            {
            lv_startPattern_1_0=(Token)match(input,RULE_STRING,FOLLOW_56); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_startPattern_1_0, grammarAccess.getScanner_PatternRuleAccess().getStartPatternSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScanner_PatternRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"startPattern",
                      		lv_startPattern_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:2632:2: ( (lv_length_2_0= RULE_INT ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_INT) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalLDef.g:2633:1: (lv_length_2_0= RULE_INT )
                    {
                    // InternalLDef.g:2633:1: (lv_length_2_0= RULE_INT )
                    // InternalLDef.g:2634:3: lv_length_2_0= RULE_INT
                    {
                    lv_length_2_0=(Token)match(input,RULE_INT,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_length_2_0, grammarAccess.getScanner_PatternRuleAccess().getLengthINTTerminalRuleCall_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_PatternRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"length",
                              		lv_length_2_0, 
                              		"org.eclipse.xtext.common.Terminals.INT");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalLDef.g:2650:3: (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==28) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalLDef.g:2650:5: otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getScanner_PatternRuleAccess().getColKeyword_3_0());
                          
                    }
                    // InternalLDef.g:2654:1: ( (lv_check_4_0= ruleCheck ) )
                    // InternalLDef.g:2655:1: (lv_check_4_0= ruleCheck )
                    {
                    // InternalLDef.g:2655:1: (lv_check_4_0= ruleCheck )
                    // InternalLDef.g:2656:3: lv_check_4_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_PatternRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_58);
                    lv_check_4_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_PatternRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_4_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,45,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getScanner_PatternRuleAccess().getContainingKeyword_4());
                  
            }
            // InternalLDef.g:2676:1: ( (lv_contentPattern_6_0= RULE_STRING ) )
            // InternalLDef.g:2677:1: (lv_contentPattern_6_0= RULE_STRING )
            {
            // InternalLDef.g:2677:1: (lv_contentPattern_6_0= RULE_STRING )
            // InternalLDef.g:2678:3: lv_contentPattern_6_0= RULE_STRING
            {
            lv_contentPattern_6_0=(Token)match(input,RULE_STRING,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_contentPattern_6_0, grammarAccess.getScanner_PatternRuleAccess().getContentPatternSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScanner_PatternRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"contentPattern",
                      		lv_contentPattern_6_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:2694:2: (otherlv_7= 'enabledif' ( (lv_enabledIf_8_0= ruleScannerCondition ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==43) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalLDef.g:2694:4: otherlv_7= 'enabledif' ( (lv_enabledIf_8_0= ruleScannerCondition ) )
                    {
                    otherlv_7=(Token)match(input,43,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getScanner_PatternRuleAccess().getEnabledifKeyword_6_0());
                          
                    }
                    // InternalLDef.g:2698:1: ( (lv_enabledIf_8_0= ruleScannerCondition ) )
                    // InternalLDef.g:2699:1: (lv_enabledIf_8_0= ruleScannerCondition )
                    {
                    // InternalLDef.g:2699:1: (lv_enabledIf_8_0= ruleScannerCondition )
                    // InternalLDef.g:2700:3: lv_enabledIf_8_0= ruleScannerCondition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_PatternRuleAccess().getEnabledIfScannerConditionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_enabledIf_8_0=ruleScannerCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_PatternRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"enabledIf",
                              		lv_enabledIf_8_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.ScannerCondition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScanner_PatternRule"


    // $ANTLR start "entryRuleScanner_CharacterRule"
    // InternalLDef.g:2724:1: entryRuleScanner_CharacterRule returns [EObject current=null] : iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF ;
    public final EObject entryRuleScanner_CharacterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_CharacterRule = null;


        try {
            // InternalLDef.g:2725:2: (iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF )
            // InternalLDef.g:2726:2: iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScanner_CharacterRule=ruleScanner_CharacterRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_CharacterRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScanner_CharacterRule"


    // $ANTLR start "ruleScanner_CharacterRule"
    // InternalLDef.g:2733:1: ruleScanner_CharacterRule returns [EObject current=null] : (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? (otherlv_8= 'enabledif' ( (lv_enabledIf_9_0= ruleScannerCondition ) ) )? ) ;
    public final EObject ruleScanner_CharacterRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_characters_2_0=null;
        Token otherlv_3=null;
        Token lv_characters_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_check_7_0 = null;

        EObject lv_enabledIf_9_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:2736:28: ( (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? (otherlv_8= 'enabledif' ( (lv_enabledIf_9_0= ruleScannerCondition ) ) )? ) )
            // InternalLDef.g:2737:1: (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? (otherlv_8= 'enabledif' ( (lv_enabledIf_9_0= ruleScannerCondition ) ) )? )
            {
            // InternalLDef.g:2737:1: (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? (otherlv_8= 'enabledif' ( (lv_enabledIf_9_0= ruleScannerCondition ) ) )? )
            // InternalLDef.g:2737:3: otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? (otherlv_8= 'enabledif' ( (lv_enabledIf_9_0= ruleScannerCondition ) ) )?
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,40,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // InternalLDef.g:2745:1: ( (lv_characters_2_0= RULE_STRING ) )
            // InternalLDef.g:2746:1: (lv_characters_2_0= RULE_STRING )
            {
            // InternalLDef.g:2746:1: (lv_characters_2_0= RULE_STRING )
            // InternalLDef.g:2747:3: lv_characters_2_0= RULE_STRING
            {
            lv_characters_2_0=(Token)match(input,RULE_STRING,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_characters_2_0, grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScanner_CharacterRuleRule());
              	        }
                     		addWithLastConsumed(
                     			current, 
                     			"characters",
                      		lv_characters_2_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:2763:2: (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==41) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalLDef.g:2763:4: otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,41,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalLDef.g:2767:1: ( (lv_characters_4_0= RULE_STRING ) )
            	    // InternalLDef.g:2768:1: (lv_characters_4_0= RULE_STRING )
            	    {
            	    // InternalLDef.g:2768:1: (lv_characters_4_0= RULE_STRING )
            	    // InternalLDef.g:2769:3: lv_characters_4_0= RULE_STRING
            	    {
            	    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_47); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_characters_4_0, grammarAccess.getScanner_CharacterRuleAccess().getCharactersSTRINGTerminalRuleCall_3_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getScanner_CharacterRuleRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"characters",
            	              		lv_characters_4_0, 
            	              		"org.eclipse.xtext.common.Terminals.STRING");
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            otherlv_5=(Token)match(input,42,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getScanner_CharacterRuleAccess().getRightSquareBracketKeyword_4());
                  
            }
            // InternalLDef.g:2789:1: (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==28) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalLDef.g:2789:3: otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) )
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getScanner_CharacterRuleAccess().getColKeyword_5_0());
                          
                    }
                    // InternalLDef.g:2793:1: ( (lv_check_7_0= ruleCheck ) )
                    // InternalLDef.g:2794:1: (lv_check_7_0= ruleCheck )
                    {
                    // InternalLDef.g:2794:1: (lv_check_7_0= ruleCheck )
                    // InternalLDef.g:2795:3: lv_check_7_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_CharacterRuleAccess().getCheckCheckParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_48);
                    lv_check_7_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_CharacterRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_7_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalLDef.g:2811:4: (otherlv_8= 'enabledif' ( (lv_enabledIf_9_0= ruleScannerCondition ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==43) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalLDef.g:2811:6: otherlv_8= 'enabledif' ( (lv_enabledIf_9_0= ruleScannerCondition ) )
                    {
                    otherlv_8=(Token)match(input,43,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getScanner_CharacterRuleAccess().getEnabledifKeyword_6_0());
                          
                    }
                    // InternalLDef.g:2815:1: ( (lv_enabledIf_9_0= ruleScannerCondition ) )
                    // InternalLDef.g:2816:1: (lv_enabledIf_9_0= ruleScannerCondition )
                    {
                    // InternalLDef.g:2816:1: (lv_enabledIf_9_0= ruleScannerCondition )
                    // InternalLDef.g:2817:3: lv_enabledIf_9_0= ruleScannerCondition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_CharacterRuleAccess().getEnabledIfScannerConditionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_enabledIf_9_0=ruleScannerCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_CharacterRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"enabledIf",
                              		lv_enabledIf_9_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.ScannerCondition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScanner_CharacterRule"


    // $ANTLR start "entryRuleScanner_JSRule"
    // InternalLDef.g:2841:1: entryRuleScanner_JSRule returns [EObject current=null] : iv_ruleScanner_JSRule= ruleScanner_JSRule EOF ;
    public final EObject entryRuleScanner_JSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_JSRule = null;


        try {
            // InternalLDef.g:2842:2: (iv_ruleScanner_JSRule= ruleScanner_JSRule EOF )
            // InternalLDef.g:2843:2: iv_ruleScanner_JSRule= ruleScanner_JSRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_JSRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScanner_JSRule=ruleScanner_JSRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_JSRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScanner_JSRule"


    // $ANTLR start "ruleScanner_JSRule"
    // InternalLDef.g:2850:1: ruleScanner_JSRule returns [EObject current=null] : (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? (otherlv_4= 'enabledif' ( (lv_condition_5_0= ruleScannerCondition ) ) )? ) ;
    public final EObject ruleScanner_JSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fileURI_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_check_3_0 = null;

        EObject lv_condition_5_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:2853:28: ( (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? (otherlv_4= 'enabledif' ( (lv_condition_5_0= ruleScannerCondition ) ) )? ) )
            // InternalLDef.g:2854:1: (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? (otherlv_4= 'enabledif' ( (lv_condition_5_0= ruleScannerCondition ) ) )? )
            {
            // InternalLDef.g:2854:1: (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? (otherlv_4= 'enabledif' ( (lv_condition_5_0= ruleScannerCondition ) ) )? )
            // InternalLDef.g:2854:3: otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? (otherlv_4= 'enabledif' ( (lv_condition_5_0= ruleScannerCondition ) ) )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0());
                  
            }
            // InternalLDef.g:2858:1: ( (lv_fileURI_1_0= RULE_STRING ) )
            // InternalLDef.g:2859:1: (lv_fileURI_1_0= RULE_STRING )
            {
            // InternalLDef.g:2859:1: (lv_fileURI_1_0= RULE_STRING )
            // InternalLDef.g:2860:3: lv_fileURI_1_0= RULE_STRING
            {
            lv_fileURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_fileURI_1_0, grammarAccess.getScanner_JSRuleAccess().getFileURISTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScanner_JSRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"fileURI",
                      		lv_fileURI_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalLDef.g:2876:2: (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==28) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalLDef.g:2876:4: otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getScanner_JSRuleAccess().getColKeyword_2_0());
                          
                    }
                    // InternalLDef.g:2880:1: ( (lv_check_3_0= ruleCheck ) )
                    // InternalLDef.g:2881:1: (lv_check_3_0= ruleCheck )
                    {
                    // InternalLDef.g:2881:1: (lv_check_3_0= ruleCheck )
                    // InternalLDef.g:2882:3: lv_check_3_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_JSRuleAccess().getCheckCheckParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_48);
                    lv_check_3_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_JSRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_3_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalLDef.g:2898:4: (otherlv_4= 'enabledif' ( (lv_condition_5_0= ruleScannerCondition ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==43) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalLDef.g:2898:6: otherlv_4= 'enabledif' ( (lv_condition_5_0= ruleScannerCondition ) )
                    {
                    otherlv_4=(Token)match(input,43,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getScanner_JSRuleAccess().getEnabledifKeyword_3_0());
                          
                    }
                    // InternalLDef.g:2902:1: ( (lv_condition_5_0= ruleScannerCondition ) )
                    // InternalLDef.g:2903:1: (lv_condition_5_0= ruleScannerCondition )
                    {
                    // InternalLDef.g:2903:1: (lv_condition_5_0= ruleScannerCondition )
                    // InternalLDef.g:2904:3: lv_condition_5_0= ruleScannerCondition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_JSRuleAccess().getConditionScannerConditionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_condition_5_0=ruleScannerCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_JSRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"condition",
                              		lv_condition_5_0, 
                              		"org.eclipse.fx.code.editor.ldef.LDef.ScannerCondition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScanner_JSRule"


    // $ANTLR start "entryRuleScannerCondition"
    // InternalLDef.g:2928:1: entryRuleScannerCondition returns [EObject current=null] : iv_ruleScannerCondition= ruleScannerCondition EOF ;
    public final EObject entryRuleScannerCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerCondition = null;


        try {
            // InternalLDef.g:2929:2: (iv_ruleScannerCondition= ruleScannerCondition EOF )
            // InternalLDef.g:2930:2: iv_ruleScannerCondition= ruleScannerCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScannerConditionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScannerCondition=ruleScannerCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScannerCondition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScannerCondition"


    // $ANTLR start "ruleScannerCondition"
    // InternalLDef.g:2937:1: ruleScannerCondition returns [EObject current=null] : (this_ScannerConditionExists_0= ruleScannerConditionExists | this_ScannerConditionEquals_1= ruleScannerConditionEquals | this_ScannerConditionJs_2= ruleScannerConditionJs | this_ScannerConditionComposite_3= ruleScannerConditionComposite ) ;
    public final EObject ruleScannerCondition() throws RecognitionException {
        EObject current = null;

        EObject this_ScannerConditionExists_0 = null;

        EObject this_ScannerConditionEquals_1 = null;

        EObject this_ScannerConditionJs_2 = null;

        EObject this_ScannerConditionComposite_3 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:2940:28: ( (this_ScannerConditionExists_0= ruleScannerConditionExists | this_ScannerConditionEquals_1= ruleScannerConditionEquals | this_ScannerConditionJs_2= ruleScannerConditionJs | this_ScannerConditionComposite_3= ruleScannerConditionComposite ) )
            // InternalLDef.g:2941:1: (this_ScannerConditionExists_0= ruleScannerConditionExists | this_ScannerConditionEquals_1= ruleScannerConditionEquals | this_ScannerConditionJs_2= ruleScannerConditionJs | this_ScannerConditionComposite_3= ruleScannerConditionComposite )
            {
            // InternalLDef.g:2941:1: (this_ScannerConditionExists_0= ruleScannerConditionExists | this_ScannerConditionEquals_1= ruleScannerConditionEquals | this_ScannerConditionJs_2= ruleScannerConditionJs | this_ScannerConditionComposite_3= ruleScannerConditionComposite )
            int alt61=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==52) ) {
                    alt61=2;
                }
                else if ( (LA61_1==51) ) {
                    alt61=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;
                }
                }
                break;
            case 24:
                {
                alt61=3;
                }
                break;
            case 47:
            case 48:
                {
                alt61=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalLDef.g:2942:5: this_ScannerConditionExists_0= ruleScannerConditionExists
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerConditionAccess().getScannerConditionExistsParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ScannerConditionExists_0=ruleScannerConditionExists();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ScannerConditionExists_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:2952:5: this_ScannerConditionEquals_1= ruleScannerConditionEquals
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerConditionAccess().getScannerConditionEqualsParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ScannerConditionEquals_1=ruleScannerConditionEquals();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ScannerConditionEquals_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalLDef.g:2962:5: this_ScannerConditionJs_2= ruleScannerConditionJs
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerConditionAccess().getScannerConditionJsParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ScannerConditionJs_2=ruleScannerConditionJs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ScannerConditionJs_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalLDef.g:2972:5: this_ScannerConditionComposite_3= ruleScannerConditionComposite
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerConditionAccess().getScannerConditionCompositeParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ScannerConditionComposite_3=ruleScannerConditionComposite();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ScannerConditionComposite_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScannerCondition"


    // $ANTLR start "entryRuleScannerConditionComposite"
    // InternalLDef.g:2988:1: entryRuleScannerConditionComposite returns [EObject current=null] : iv_ruleScannerConditionComposite= ruleScannerConditionComposite EOF ;
    public final EObject entryRuleScannerConditionComposite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerConditionComposite = null;


        try {
            // InternalLDef.g:2989:2: (iv_ruleScannerConditionComposite= ruleScannerConditionComposite EOF )
            // InternalLDef.g:2990:2: iv_ruleScannerConditionComposite= ruleScannerConditionComposite EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScannerConditionCompositeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScannerConditionComposite=ruleScannerConditionComposite();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScannerConditionComposite; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScannerConditionComposite"


    // $ANTLR start "ruleScannerConditionComposite"
    // InternalLDef.g:2997:1: ruleScannerConditionComposite returns [EObject current=null] : ( ( ( (lv_op_0_1= 'and' | lv_op_0_2= 'or' ) ) ) otherlv_1= '(' ( (lv_elements_2_0= ruleScannerCondition ) ) otherlv_3= ')' ) ;
    public final EObject ruleScannerConditionComposite() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:3000:28: ( ( ( ( (lv_op_0_1= 'and' | lv_op_0_2= 'or' ) ) ) otherlv_1= '(' ( (lv_elements_2_0= ruleScannerCondition ) ) otherlv_3= ')' ) )
            // InternalLDef.g:3001:1: ( ( ( (lv_op_0_1= 'and' | lv_op_0_2= 'or' ) ) ) otherlv_1= '(' ( (lv_elements_2_0= ruleScannerCondition ) ) otherlv_3= ')' )
            {
            // InternalLDef.g:3001:1: ( ( ( (lv_op_0_1= 'and' | lv_op_0_2= 'or' ) ) ) otherlv_1= '(' ( (lv_elements_2_0= ruleScannerCondition ) ) otherlv_3= ')' )
            // InternalLDef.g:3001:2: ( ( (lv_op_0_1= 'and' | lv_op_0_2= 'or' ) ) ) otherlv_1= '(' ( (lv_elements_2_0= ruleScannerCondition ) ) otherlv_3= ')'
            {
            // InternalLDef.g:3001:2: ( ( (lv_op_0_1= 'and' | lv_op_0_2= 'or' ) ) )
            // InternalLDef.g:3002:1: ( (lv_op_0_1= 'and' | lv_op_0_2= 'or' ) )
            {
            // InternalLDef.g:3002:1: ( (lv_op_0_1= 'and' | lv_op_0_2= 'or' ) )
            // InternalLDef.g:3003:1: (lv_op_0_1= 'and' | lv_op_0_2= 'or' )
            {
            // InternalLDef.g:3003:1: (lv_op_0_1= 'and' | lv_op_0_2= 'or' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==47) ) {
                alt62=1;
            }
            else if ( (LA62_0==48) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalLDef.g:3004:3: lv_op_0_1= 'and'
                    {
                    lv_op_0_1=(Token)match(input,47,FOLLOW_60); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_0_1, grammarAccess.getScannerConditionCompositeAccess().getOpAndKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScannerConditionCompositeRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:3016:8: lv_op_0_2= 'or'
                    {
                    lv_op_0_2=(Token)match(input,48,FOLLOW_60); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_0_2, grammarAccess.getScannerConditionCompositeAccess().getOpOrKeyword_0_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScannerConditionCompositeRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_0_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,49,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScannerConditionCompositeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalLDef.g:3035:1: ( (lv_elements_2_0= ruleScannerCondition ) )
            // InternalLDef.g:3036:1: (lv_elements_2_0= ruleScannerCondition )
            {
            // InternalLDef.g:3036:1: (lv_elements_2_0= ruleScannerCondition )
            // InternalLDef.g:3037:3: lv_elements_2_0= ruleScannerCondition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScannerConditionCompositeAccess().getElementsScannerConditionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_61);
            lv_elements_2_0=ruleScannerCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScannerConditionCompositeRule());
              	        }
                     		add(
                     			current, 
                     			"elements",
                      		lv_elements_2_0, 
                      		"org.eclipse.fx.code.editor.ldef.LDef.ScannerCondition");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getScannerConditionCompositeAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScannerConditionComposite"


    // $ANTLR start "entryRuleScannerConditionExists"
    // InternalLDef.g:3065:1: entryRuleScannerConditionExists returns [EObject current=null] : iv_ruleScannerConditionExists= ruleScannerConditionExists EOF ;
    public final EObject entryRuleScannerConditionExists() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerConditionExists = null;


        try {
            // InternalLDef.g:3066:2: (iv_ruleScannerConditionExists= ruleScannerConditionExists EOF )
            // InternalLDef.g:3067:2: iv_ruleScannerConditionExists= ruleScannerConditionExists EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScannerConditionExistsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScannerConditionExists=ruleScannerConditionExists();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScannerConditionExists; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScannerConditionExists"


    // $ANTLR start "ruleScannerConditionExists"
    // InternalLDef.g:3074:1: ruleScannerConditionExists returns [EObject current=null] : ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= 'exists' ) ;
    public final EObject ruleScannerConditionExists() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:3077:28: ( ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= 'exists' ) )
            // InternalLDef.g:3078:1: ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= 'exists' )
            {
            // InternalLDef.g:3078:1: ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= 'exists' )
            // InternalLDef.g:3078:2: ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= 'exists'
            {
            // InternalLDef.g:3078:2: ( (lv_key_0_0= RULE_STRING ) )
            // InternalLDef.g:3079:1: (lv_key_0_0= RULE_STRING )
            {
            // InternalLDef.g:3079:1: (lv_key_0_0= RULE_STRING )
            // InternalLDef.g:3080:3: lv_key_0_0= RULE_STRING
            {
            lv_key_0_0=(Token)match(input,RULE_STRING,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_key_0_0, grammarAccess.getScannerConditionExistsAccess().getKeySTRINGTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScannerConditionExistsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"key",
                      		lv_key_0_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScannerConditionExistsAccess().getExistsKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScannerConditionExists"


    // $ANTLR start "entryRuleScannerConditionEquals"
    // InternalLDef.g:3108:1: entryRuleScannerConditionEquals returns [EObject current=null] : iv_ruleScannerConditionEquals= ruleScannerConditionEquals EOF ;
    public final EObject entryRuleScannerConditionEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerConditionEquals = null;


        try {
            // InternalLDef.g:3109:2: (iv_ruleScannerConditionEquals= ruleScannerConditionEquals EOF )
            // InternalLDef.g:3110:2: iv_ruleScannerConditionEquals= ruleScannerConditionEquals EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScannerConditionEqualsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScannerConditionEquals=ruleScannerConditionEquals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScannerConditionEquals; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScannerConditionEquals"


    // $ANTLR start "ruleScannerConditionEquals"
    // InternalLDef.g:3117:1: ruleScannerConditionEquals returns [EObject current=null] : ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= 'eq' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleScannerConditionEquals() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:3120:28: ( ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= 'eq' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalLDef.g:3121:1: ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= 'eq' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalLDef.g:3121:1: ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= 'eq' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalLDef.g:3121:2: ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= 'eq' ( (lv_value_2_0= RULE_STRING ) )
            {
            // InternalLDef.g:3121:2: ( (lv_key_0_0= RULE_STRING ) )
            // InternalLDef.g:3122:1: (lv_key_0_0= RULE_STRING )
            {
            // InternalLDef.g:3122:1: (lv_key_0_0= RULE_STRING )
            // InternalLDef.g:3123:3: lv_key_0_0= RULE_STRING
            {
            lv_key_0_0=(Token)match(input,RULE_STRING,FOLLOW_63); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_key_0_0, grammarAccess.getScannerConditionEqualsAccess().getKeySTRINGTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScannerConditionEqualsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"key",
                      		lv_key_0_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,52,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScannerConditionEqualsAccess().getEqKeyword_1());
                  
            }
            // InternalLDef.g:3143:1: ( (lv_value_2_0= RULE_STRING ) )
            // InternalLDef.g:3144:1: (lv_value_2_0= RULE_STRING )
            {
            // InternalLDef.g:3144:1: (lv_value_2_0= RULE_STRING )
            // InternalLDef.g:3145:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_2_0, grammarAccess.getScannerConditionEqualsAccess().getValueSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScannerConditionEqualsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScannerConditionEquals"


    // $ANTLR start "entryRuleScannerConditionJs"
    // InternalLDef.g:3169:1: entryRuleScannerConditionJs returns [EObject current=null] : iv_ruleScannerConditionJs= ruleScannerConditionJs EOF ;
    public final EObject entryRuleScannerConditionJs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScannerConditionJs = null;


        try {
            // InternalLDef.g:3170:2: (iv_ruleScannerConditionJs= ruleScannerConditionJs EOF )
            // InternalLDef.g:3171:2: iv_ruleScannerConditionJs= ruleScannerConditionJs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScannerConditionJsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScannerConditionJs=ruleScannerConditionJs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScannerConditionJs; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScannerConditionJs"


    // $ANTLR start "ruleScannerConditionJs"
    // InternalLDef.g:3178:1: ruleScannerConditionJs returns [EObject current=null] : (otherlv_0= 'script' ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleScannerConditionJs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:3181:28: ( (otherlv_0= 'script' ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalLDef.g:3182:1: (otherlv_0= 'script' ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalLDef.g:3182:1: (otherlv_0= 'script' ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalLDef.g:3182:3: otherlv_0= 'script' ( (lv_value_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScannerConditionJsAccess().getScriptKeyword_0());
                  
            }
            // InternalLDef.g:3186:1: ( (lv_value_1_0= RULE_STRING ) )
            // InternalLDef.g:3187:1: (lv_value_1_0= RULE_STRING )
            {
            // InternalLDef.g:3187:1: (lv_value_1_0= RULE_STRING )
            // InternalLDef.g:3188:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getScannerConditionJsAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScannerConditionJsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScannerConditionJs"


    // $ANTLR start "entryRuleCheck"
    // InternalLDef.g:3212:1: entryRuleCheck returns [EObject current=null] : iv_ruleCheck= ruleCheck EOF ;
    public final EObject entryRuleCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheck = null;


        try {
            // InternalLDef.g:3213:2: (iv_ruleCheck= ruleCheck EOF )
            // InternalLDef.g:3214:2: iv_ruleCheck= ruleCheck EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCheckRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCheck=ruleCheck();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCheck; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCheck"


    // $ANTLR start "ruleCheck"
    // InternalLDef.g:3221:1: ruleCheck returns [EObject current=null] : (this_Range_0= ruleRange | this_Equals_1= ruleEquals ) ;
    public final EObject ruleCheck() throws RecognitionException {
        EObject current = null;

        EObject this_Range_0 = null;

        EObject this_Equals_1 = null;


         enterRule(); 
            
        try {
            // InternalLDef.g:3224:28: ( (this_Range_0= ruleRange | this_Equals_1= ruleEquals ) )
            // InternalLDef.g:3225:1: (this_Range_0= ruleRange | this_Equals_1= ruleEquals )
            {
            // InternalLDef.g:3225:1: (this_Range_0= ruleRange | this_Equals_1= ruleEquals )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==53) ) {
                alt63=1;
            }
            else if ( (LA63_0==52) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalLDef.g:3226:5: this_Range_0= ruleRange
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCheckAccess().getRangeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Range_0=ruleRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Range_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:3236:5: this_Equals_1= ruleEquals
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCheckAccess().getEqualsParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Equals_1=ruleEquals();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Equals_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleCheck"


    // $ANTLR start "entryRuleEquals"
    // InternalLDef.g:3252:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // InternalLDef.g:3253:2: (iv_ruleEquals= ruleEquals EOF )
            // InternalLDef.g:3254:2: iv_ruleEquals= ruleEquals EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEquals=ruleEquals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquals; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEquals"


    // $ANTLR start "ruleEquals"
    // InternalLDef.g:3261:1: ruleEquals returns [EObject current=null] : (otherlv_0= 'eq' ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleEquals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:3264:28: ( (otherlv_0= 'eq' ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalLDef.g:3265:1: (otherlv_0= 'eq' ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalLDef.g:3265:1: (otherlv_0= 'eq' ( (lv_value_1_0= RULE_INT ) ) )
            // InternalLDef.g:3265:3: otherlv_0= 'eq' ( (lv_value_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEqualsAccess().getEqKeyword_0());
                  
            }
            // InternalLDef.g:3269:1: ( (lv_value_1_0= RULE_INT ) )
            // InternalLDef.g:3270:1: (lv_value_1_0= RULE_INT )
            {
            // InternalLDef.g:3270:1: (lv_value_1_0= RULE_INT )
            // InternalLDef.g:3271:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getEqualsAccess().getValueINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEqualsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.eclipse.xtext.common.Terminals.INT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleEquals"


    // $ANTLR start "entryRuleRange"
    // InternalLDef.g:3295:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // InternalLDef.g:3296:2: (iv_ruleRange= ruleRange EOF )
            // InternalLDef.g:3297:2: iv_ruleRange= ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRange=ruleRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRange; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // InternalLDef.g:3304:1: ruleRange returns [EObject current=null] : (otherlv_0= 'in' ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) ) ( (lv_minValue_2_0= RULE_INT ) )? otherlv_3= ',' ( (lv_maxValue_4_0= RULE_INT ) )? ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) ) ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_ltIncl_1_1=null;
        Token lv_ltIncl_1_2=null;
        Token lv_minValue_2_0=null;
        Token otherlv_3=null;
        Token lv_maxValue_4_0=null;
        Token lv_gtIncl_5_1=null;
        Token lv_gtIncl_5_2=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:3307:28: ( (otherlv_0= 'in' ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) ) ( (lv_minValue_2_0= RULE_INT ) )? otherlv_3= ',' ( (lv_maxValue_4_0= RULE_INT ) )? ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) ) ) )
            // InternalLDef.g:3308:1: (otherlv_0= 'in' ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) ) ( (lv_minValue_2_0= RULE_INT ) )? otherlv_3= ',' ( (lv_maxValue_4_0= RULE_INT ) )? ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) ) )
            {
            // InternalLDef.g:3308:1: (otherlv_0= 'in' ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) ) ( (lv_minValue_2_0= RULE_INT ) )? otherlv_3= ',' ( (lv_maxValue_4_0= RULE_INT ) )? ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) ) )
            // InternalLDef.g:3308:3: otherlv_0= 'in' ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) ) ( (lv_minValue_2_0= RULE_INT ) )? otherlv_3= ',' ( (lv_maxValue_4_0= RULE_INT ) )? ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRangeAccess().getInKeyword_0());
                  
            }
            // InternalLDef.g:3312:1: ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) )
            // InternalLDef.g:3313:1: ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) )
            {
            // InternalLDef.g:3313:1: ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) )
            // InternalLDef.g:3314:1: (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' )
            {
            // InternalLDef.g:3314:1: (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==49) ) {
                alt64=1;
            }
            else if ( (LA64_0==40) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalLDef.g:3315:3: lv_ltIncl_1_1= '('
                    {
                    lv_ltIncl_1_1=(Token)match(input,49,FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_ltIncl_1_1, grammarAccess.getRangeAccess().getLtInclLeftParenthesisKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRangeRule());
                      	        }
                             		setWithLastConsumed(current, "ltIncl", lv_ltIncl_1_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:3327:8: lv_ltIncl_1_2= '['
                    {
                    lv_ltIncl_1_2=(Token)match(input,40,FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_ltIncl_1_2, grammarAccess.getRangeAccess().getLtInclLeftSquareBracketKeyword_1_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRangeRule());
                      	        }
                             		setWithLastConsumed(current, "ltIncl", lv_ltIncl_1_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // InternalLDef.g:3342:2: ( (lv_minValue_2_0= RULE_INT ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_INT) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalLDef.g:3343:1: (lv_minValue_2_0= RULE_INT )
                    {
                    // InternalLDef.g:3343:1: (lv_minValue_2_0= RULE_INT )
                    // InternalLDef.g:3344:3: lv_minValue_2_0= RULE_INT
                    {
                    lv_minValue_2_0=(Token)match(input,RULE_INT,FOLLOW_67); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_minValue_2_0, grammarAccess.getRangeAccess().getMinValueINTTerminalRuleCall_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRangeRule());
                      	        }
                             		addWithLastConsumed(
                             			current, 
                             			"minValue",
                              		lv_minValue_2_0, 
                              		"org.eclipse.xtext.common.Terminals.INT");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,41,FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRangeAccess().getCommaKeyword_3());
                  
            }
            // InternalLDef.g:3364:1: ( (lv_maxValue_4_0= RULE_INT ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_INT) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalLDef.g:3365:1: (lv_maxValue_4_0= RULE_INT )
                    {
                    // InternalLDef.g:3365:1: (lv_maxValue_4_0= RULE_INT )
                    // InternalLDef.g:3366:3: lv_maxValue_4_0= RULE_INT
                    {
                    lv_maxValue_4_0=(Token)match(input,RULE_INT,FOLLOW_69); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_maxValue_4_0, grammarAccess.getRangeAccess().getMaxValueINTTerminalRuleCall_4_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRangeRule());
                      	        }
                             		addWithLastConsumed(
                             			current, 
                             			"maxValue",
                              		lv_maxValue_4_0, 
                              		"org.eclipse.xtext.common.Terminals.INT");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalLDef.g:3382:3: ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) )
            // InternalLDef.g:3383:1: ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) )
            {
            // InternalLDef.g:3383:1: ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) )
            // InternalLDef.g:3384:1: (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' )
            {
            // InternalLDef.g:3384:1: (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==50) ) {
                alt67=1;
            }
            else if ( (LA67_0==42) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalLDef.g:3385:3: lv_gtIncl_5_1= ')'
                    {
                    lv_gtIncl_5_1=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_gtIncl_5_1, grammarAccess.getRangeAccess().getGtInclRightParenthesisKeyword_5_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRangeRule());
                      	        }
                             		setWithLastConsumed(current, "gtIncl", lv_gtIncl_5_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalLDef.g:3397:8: lv_gtIncl_5_2= ']'
                    {
                    lv_gtIncl_5_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_gtIncl_5_2, grammarAccess.getRangeAccess().getGtInclRightSquareBracketKeyword_5_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRangeRule());
                      	        }
                             		setWithLastConsumed(current, "gtIncl", lv_gtIncl_5_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleWhitespaceRule"
    // InternalLDef.g:3420:1: entryRuleWhitespaceRule returns [EObject current=null] : iv_ruleWhitespaceRule= ruleWhitespaceRule EOF ;
    public final EObject entryRuleWhitespaceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhitespaceRule = null;


        try {
            // InternalLDef.g:3421:2: (iv_ruleWhitespaceRule= ruleWhitespaceRule EOF )
            // InternalLDef.g:3422:2: iv_ruleWhitespaceRule= ruleWhitespaceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhitespaceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWhitespaceRule=ruleWhitespaceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhitespaceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleWhitespaceRule"


    // $ANTLR start "ruleWhitespaceRule"
    // InternalLDef.g:3429:1: ruleWhitespaceRule returns [EObject current=null] : (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleWhitespaceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_characters_2_0=null;
        Token otherlv_3=null;
        Token lv_characters_4_0=null;
        Token otherlv_5=null;
        Token lv_javawhitespace_6_0=null;
        Token lv_fileURI_7_0=null;

         enterRule(); 
            
        try {
            // InternalLDef.g:3432:28: ( (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) ) )
            // InternalLDef.g:3433:1: (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) )
            {
            // InternalLDef.g:3433:1: (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) )
            // InternalLDef.g:3433:3: otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getWhitespaceRuleAccess().getWhitespaceKeyword_0());
                  
            }
            // InternalLDef.g:3437:1: ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) )
            int alt69=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt69=1;
                }
                break;
            case 55:
                {
                alt69=2;
                }
                break;
            case RULE_STRING:
                {
                alt69=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // InternalLDef.g:3437:2: (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
                    {
                    // InternalLDef.g:3437:2: (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
                    // InternalLDef.g:3437:4: otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getWhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0());
                          
                    }
                    // InternalLDef.g:3441:1: ( (lv_characters_2_0= RULE_STRING ) )
                    // InternalLDef.g:3442:1: (lv_characters_2_0= RULE_STRING )
                    {
                    // InternalLDef.g:3442:1: (lv_characters_2_0= RULE_STRING )
                    // InternalLDef.g:3443:3: lv_characters_2_0= RULE_STRING
                    {
                    lv_characters_2_0=(Token)match(input,RULE_STRING,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_characters_2_0, grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getWhitespaceRuleRule());
                      	        }
                             		addWithLastConsumed(
                             			current, 
                             			"characters",
                              		lv_characters_2_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }

                    // InternalLDef.g:3459:2: (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==41) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalLDef.g:3459:4: otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) )
                    	    {
                    	    otherlv_3=(Token)match(input,41,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getWhitespaceRuleAccess().getCommaKeyword_1_0_2_0());
                    	          
                    	    }
                    	    // InternalLDef.g:3463:1: ( (lv_characters_4_0= RULE_STRING ) )
                    	    // InternalLDef.g:3464:1: (lv_characters_4_0= RULE_STRING )
                    	    {
                    	    // InternalLDef.g:3464:1: (lv_characters_4_0= RULE_STRING )
                    	    // InternalLDef.g:3465:3: lv_characters_4_0= RULE_STRING
                    	    {
                    	    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_47); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_characters_4_0, grammarAccess.getWhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_2_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getWhitespaceRuleRule());
                    	      	        }
                    	             		addWithLastConsumed(
                    	             			current, 
                    	             			"characters",
                    	              		lv_characters_4_0, 
                    	              		"org.eclipse.xtext.common.Terminals.STRING");
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getWhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalLDef.g:3486:6: ( (lv_javawhitespace_6_0= 'javawhitespace' ) )
                    {
                    // InternalLDef.g:3486:6: ( (lv_javawhitespace_6_0= 'javawhitespace' ) )
                    // InternalLDef.g:3487:1: (lv_javawhitespace_6_0= 'javawhitespace' )
                    {
                    // InternalLDef.g:3487:1: (lv_javawhitespace_6_0= 'javawhitespace' )
                    // InternalLDef.g:3488:3: lv_javawhitespace_6_0= 'javawhitespace'
                    {
                    lv_javawhitespace_6_0=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_javawhitespace_6_0, grammarAccess.getWhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getWhitespaceRuleRule());
                      	        }
                             		setWithLastConsumed(current, "javawhitespace", true, "javawhitespace");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalLDef.g:3502:6: ( (lv_fileURI_7_0= RULE_STRING ) )
                    {
                    // InternalLDef.g:3502:6: ( (lv_fileURI_7_0= RULE_STRING ) )
                    // InternalLDef.g:3503:1: (lv_fileURI_7_0= RULE_STRING )
                    {
                    // InternalLDef.g:3503:1: (lv_fileURI_7_0= RULE_STRING )
                    // InternalLDef.g:3504:3: lv_fileURI_7_0= RULE_STRING
                    {
                    lv_fileURI_7_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_fileURI_7_0, grammarAccess.getWhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_1_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getWhitespaceRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"fileURI",
                              		lv_fileURI_7_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleWhitespaceRule"

    // $ANTLR start synpred1_InternalLDef
    public final void synpred1_InternalLDef_fragment() throws RecognitionException {   
        // InternalLDef.g:198:3: ( '.' )
        // InternalLDef.g:199:2: '.'
        {
        match(input,12,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalLDef

    // Delegated rules

    public final boolean synpred1_InternalLDef() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalLDef_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000190000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000105000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000105010000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000078000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000070000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000022L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000038000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000403010000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0040000000008000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000004000010010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x000040810D000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x000040810D010000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0001800001000020L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000080078000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000080070000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000080060000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000080040000022L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000080040000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000200010000040L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000080010000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0002010000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000020000000040L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0004040000000040L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0004040000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0080010000000020L});

}