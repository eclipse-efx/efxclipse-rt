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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'*'", "'import'", "'{'", "'}'", "'integration'", "'javafx'", "'java'", "'e4'", "':'", "'partitioning'", "'partition'", "'script'", "'rule'", "'single_line'", "'col'", "'=>'", "'escaped'", "'by'", "'multi_line'", "'lexical_highlighting'", "'token_def'", "';'", "'bold'", "'italic'", "'default'", "'keywords'", "'['", "','", "']'", "'since'", "'pattern'", "'containing'", "'character'", "'eq'", "'in'", "'('", "')'", "'whitespace'", "'javawhitespace'"
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


        public InternalLDefParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLDefParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLDefParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g"; }



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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:67:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:68:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:69:2: iv_ruleRoot= ruleRoot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRootRule()); 
            }
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoot; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot85); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:76:1: ruleRoot returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_languageDefinition_3_0= ruleLanguageDef ) ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_languageDefinition_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:79:28: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_languageDefinition_3_0= ruleLanguageDef ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:80:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_languageDefinition_3_0= ruleLanguageDef ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:80:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_languageDefinition_3_0= ruleLanguageDef ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:80:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_languageDefinition_3_0= ruleLanguageDef ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleRoot122); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRootAccess().getPackageKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:84:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:85:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:85:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:86:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRootAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleRoot143);
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
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:102:2: ( (lv_imports_2_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:103:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:103:1: (lv_imports_2_0= ruleImport )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:104:3: lv_imports_2_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRootAccess().getImportsImportParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImport_in_ruleRoot164);
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
            	              		"Import");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:120:3: ( (lv_languageDefinition_3_0= ruleLanguageDef ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:121:1: (lv_languageDefinition_3_0= ruleLanguageDef )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:121:1: (lv_languageDefinition_3_0= ruleLanguageDef )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:122:3: lv_languageDefinition_3_0= ruleLanguageDef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRootAccess().getLanguageDefinitionLanguageDefParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLanguageDef_in_ruleRoot186);
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
                      		"LanguageDef");
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:146:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:147:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:148:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID223);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID234); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:155:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:158:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:159:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID273); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:174:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:175:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:176:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName318);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName329); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:183:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:186:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:187:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:187:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:188:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName376);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:198:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
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
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:198:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:198:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:198:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,12,FOLLOW_12_in_ruleQualifiedName404); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName427);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:225:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:226:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:227:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard475);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard486); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:234:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:237:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:238:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:238:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:239:5: this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard533);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:249:1: (kw= '.' kw= '*' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:250:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,12,FOLLOW_12_in_ruleQualifiedNameWithWildCard552); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleQualifiedNameWithWildCard565); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:269:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:270:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:271:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport607);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport617); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:278:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:281:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:282:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:282:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:282:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleImport654); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:286:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:287:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:287:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:288:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport675);
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
                      		"QualifiedNameWithWildCard");
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:312:1: entryRuleLanguageDef returns [EObject current=null] : iv_ruleLanguageDef= ruleLanguageDef EOF ;
    public final EObject entryRuleLanguageDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageDef = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:313:2: (iv_ruleLanguageDef= ruleLanguageDef EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:314:2: iv_ruleLanguageDef= ruleLanguageDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLanguageDefRule()); 
            }
            pushFollow(FOLLOW_ruleLanguageDef_in_entryRuleLanguageDef711);
            iv_ruleLanguageDef=ruleLanguageDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLanguageDef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLanguageDef721); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:321:1: ruleLanguageDef returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_paritioning_2_0= ruleParitioning ) ) ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) ) ( (lv_integration_4_0= ruleIntegration ) )? otherlv_5= '}' ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:324:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_paritioning_2_0= ruleParitioning ) ) ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) ) ( (lv_integration_4_0= ruleIntegration ) )? otherlv_5= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:325:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_paritioning_2_0= ruleParitioning ) ) ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) ) ( (lv_integration_4_0= ruleIntegration ) )? otherlv_5= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:325:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_paritioning_2_0= ruleParitioning ) ) ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) ) ( (lv_integration_4_0= ruleIntegration ) )? otherlv_5= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:325:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_paritioning_2_0= ruleParitioning ) ) ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) ) ( (lv_integration_4_0= ruleIntegration ) )? otherlv_5= '}'
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:325:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:326:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:326:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:327:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLanguageDef763); if (state.failed) return current;
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
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleLanguageDef780); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLanguageDefAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:347:1: ( (lv_paritioning_2_0= ruleParitioning ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:348:1: (lv_paritioning_2_0= ruleParitioning )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:348:1: (lv_paritioning_2_0= ruleParitioning )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:349:3: lv_paritioning_2_0= ruleParitioning
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLanguageDefAccess().getParitioningParitioningParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleParitioning_in_ruleLanguageDef801);
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
                      		"Paritioning");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:365:2: ( (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:366:1: (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:366:1: (lv_lexicalHighlighting_3_0= ruleLexicalHighlighting )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:367:3: lv_lexicalHighlighting_3_0= ruleLexicalHighlighting
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLanguageDefAccess().getLexicalHighlightingLexicalHighlightingParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_ruleLanguageDef822);
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
                      		"LexicalHighlighting");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:383:2: ( (lv_integration_4_0= ruleIntegration ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:384:1: (lv_integration_4_0= ruleIntegration )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:384:1: (lv_integration_4_0= ruleIntegration )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:385:3: lv_integration_4_0= ruleIntegration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageDefAccess().getIntegrationIntegrationParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegration_in_ruleLanguageDef843);
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
                              		"Integration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleLanguageDef856); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:413:1: entryRuleIntegration returns [EObject current=null] : iv_ruleIntegration= ruleIntegration EOF ;
    public final EObject entryRuleIntegration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegration = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:414:2: (iv_ruleIntegration= ruleIntegration EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:415:2: iv_ruleIntegration= ruleIntegration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegrationRule()); 
            }
            pushFollow(FOLLOW_ruleIntegration_in_entryRuleIntegration892);
            iv_ruleIntegration=ruleIntegration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegration902); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:422:1: ruleIntegration returns [EObject current=null] : (otherlv_0= 'integration' otherlv_1= '{' ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+ otherlv_3= '}' ) ;
    public final EObject ruleIntegration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_codeIntegrationList_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:425:28: ( (otherlv_0= 'integration' otherlv_1= '{' ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:426:1: (otherlv_0= 'integration' otherlv_1= '{' ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:426:1: (otherlv_0= 'integration' otherlv_1= '{' ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:426:3: otherlv_0= 'integration' otherlv_1= '{' ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleIntegration939); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIntegrationAccess().getIntegrationKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleIntegration951); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIntegrationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:434:1: ( (lv_codeIntegrationList_2_0= ruleCodeIntegration ) )+
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
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:435:1: (lv_codeIntegrationList_2_0= ruleCodeIntegration )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:435:1: (lv_codeIntegrationList_2_0= ruleCodeIntegration )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:436:3: lv_codeIntegrationList_2_0= ruleCodeIntegration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIntegrationAccess().getCodeIntegrationListCodeIntegrationParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCodeIntegration_in_ruleIntegration972);
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
            	              		"CodeIntegration");
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

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleIntegration985); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:464:1: entryRuleCodeIntegration returns [EObject current=null] : iv_ruleCodeIntegration= ruleCodeIntegration EOF ;
    public final EObject entryRuleCodeIntegration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodeIntegration = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:465:2: (iv_ruleCodeIntegration= ruleCodeIntegration EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:466:2: iv_ruleCodeIntegration= ruleCodeIntegration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCodeIntegrationRule()); 
            }
            pushFollow(FOLLOW_ruleCodeIntegration_in_entryRuleCodeIntegration1021);
            iv_ruleCodeIntegration=ruleCodeIntegration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCodeIntegration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodeIntegration1031); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:473:1: ruleCodeIntegration returns [EObject current=null] : this_JavaFXIntegration_0= ruleJavaFXIntegration ;
    public final EObject ruleCodeIntegration() throws RecognitionException {
        EObject current = null;

        EObject this_JavaFXIntegration_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:476:28: (this_JavaFXIntegration_0= ruleJavaFXIntegration )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:478:5: this_JavaFXIntegration_0= ruleJavaFXIntegration
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCodeIntegrationAccess().getJavaFXIntegrationParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleJavaFXIntegration_in_ruleCodeIntegration1077);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:494:1: entryRuleJavaFXIntegration returns [EObject current=null] : iv_ruleJavaFXIntegration= ruleJavaFXIntegration EOF ;
    public final EObject entryRuleJavaFXIntegration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaFXIntegration = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:495:2: (iv_ruleJavaFXIntegration= ruleJavaFXIntegration EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:496:2: iv_ruleJavaFXIntegration= ruleJavaFXIntegration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaFXIntegrationRule()); 
            }
            pushFollow(FOLLOW_ruleJavaFXIntegration_in_entryRuleJavaFXIntegration1111);
            iv_ruleJavaFXIntegration=ruleJavaFXIntegration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaFXIntegration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaFXIntegration1121); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:503:1: ruleJavaFXIntegration returns [EObject current=null] : (otherlv_0= 'javafx' otherlv_1= '{' ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+ otherlv_3= '}' ) ;
    public final EObject ruleJavaFXIntegration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_codegenerationList_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:506:28: ( (otherlv_0= 'javafx' otherlv_1= '{' ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:507:1: (otherlv_0= 'javafx' otherlv_1= '{' ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:507:1: (otherlv_0= 'javafx' otherlv_1= '{' ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:507:3: otherlv_0= 'javafx' otherlv_1= '{' ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleJavaFXIntegration1158); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJavaFXIntegrationAccess().getJavafxKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleJavaFXIntegration1170); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJavaFXIntegrationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:515:1: ( (lv_codegenerationList_2_0= ruleCodegeneration ) )+
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
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:516:1: (lv_codegenerationList_2_0= ruleCodegeneration )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:516:1: (lv_codegenerationList_2_0= ruleCodegeneration )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:517:3: lv_codegenerationList_2_0= ruleCodegeneration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getJavaFXIntegrationAccess().getCodegenerationListCodegenerationParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCodegeneration_in_ruleJavaFXIntegration1191);
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
            	              		"Codegeneration");
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

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleJavaFXIntegration1204); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:545:1: entryRuleCodegeneration returns [EObject current=null] : iv_ruleCodegeneration= ruleCodegeneration EOF ;
    public final EObject entryRuleCodegeneration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodegeneration = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:546:2: (iv_ruleCodegeneration= ruleCodegeneration EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:547:2: iv_ruleCodegeneration= ruleCodegeneration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCodegenerationRule()); 
            }
            pushFollow(FOLLOW_ruleCodegeneration_in_entryRuleCodegeneration1240);
            iv_ruleCodegeneration=ruleCodegeneration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCodegeneration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodegeneration1250); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:554:1: ruleCodegeneration returns [EObject current=null] : (this_JavaCodeGeneration_0= ruleJavaCodeGeneration | this_E4CodeGeneration_1= ruleE4CodeGeneration ) ;
    public final EObject ruleCodegeneration() throws RecognitionException {
        EObject current = null;

        EObject this_JavaCodeGeneration_0 = null;

        EObject this_E4CodeGeneration_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:557:28: ( (this_JavaCodeGeneration_0= ruleJavaCodeGeneration | this_E4CodeGeneration_1= ruleE4CodeGeneration ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:558:1: (this_JavaCodeGeneration_0= ruleJavaCodeGeneration | this_E4CodeGeneration_1= ruleE4CodeGeneration )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:558:1: (this_JavaCodeGeneration_0= ruleJavaCodeGeneration | this_E4CodeGeneration_1= ruleE4CodeGeneration )
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:559:5: this_JavaCodeGeneration_0= ruleJavaCodeGeneration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCodegenerationAccess().getJavaCodeGenerationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJavaCodeGeneration_in_ruleCodegeneration1297);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:569:5: this_E4CodeGeneration_1= ruleE4CodeGeneration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCodegenerationAccess().getE4CodeGenerationParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleE4CodeGeneration_in_ruleCodegeneration1324);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:585:1: entryRuleJavaCodeGeneration returns [EObject current=null] : iv_ruleJavaCodeGeneration= ruleJavaCodeGeneration EOF ;
    public final EObject entryRuleJavaCodeGeneration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaCodeGeneration = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:586:2: (iv_ruleJavaCodeGeneration= ruleJavaCodeGeneration EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:587:2: iv_ruleJavaCodeGeneration= ruleJavaCodeGeneration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaCodeGenerationRule()); 
            }
            pushFollow(FOLLOW_ruleJavaCodeGeneration_in_entryRuleJavaCodeGeneration1359);
            iv_ruleJavaCodeGeneration=ruleJavaCodeGeneration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaCodeGeneration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaCodeGeneration1369); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:594:1: ruleJavaCodeGeneration returns [EObject current=null] : (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? ) ;
    public final EObject ruleJavaCodeGeneration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_configValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:597:28: ( (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:598:1: (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:598:1: (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:598:3: otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleJavaCodeGeneration1406); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJavaCodeGenerationAccess().getJavaKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:602:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:603:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:603:1: (lv_name_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:604:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleJavaCodeGeneration1423); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:620:2: (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:620:4: otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleJavaCodeGeneration1441); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getJavaCodeGenerationAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:624:1: ( (lv_configValue_3_0= ruleConfigValue ) )+
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
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:625:1: (lv_configValue_3_0= ruleConfigValue )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:625:1: (lv_configValue_3_0= ruleConfigValue )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:626:3: lv_configValue_3_0= ruleConfigValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJavaCodeGenerationAccess().getConfigValueConfigValueParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleConfigValue_in_ruleJavaCodeGeneration1462);
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
                    	              		"ConfigValue");
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

                    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleJavaCodeGeneration1475); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:654:1: entryRuleE4CodeGeneration returns [EObject current=null] : iv_ruleE4CodeGeneration= ruleE4CodeGeneration EOF ;
    public final EObject entryRuleE4CodeGeneration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleE4CodeGeneration = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:655:2: (iv_ruleE4CodeGeneration= ruleE4CodeGeneration EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:656:2: iv_ruleE4CodeGeneration= ruleE4CodeGeneration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getE4CodeGenerationRule()); 
            }
            pushFollow(FOLLOW_ruleE4CodeGeneration_in_entryRuleE4CodeGeneration1513);
            iv_ruleE4CodeGeneration=ruleE4CodeGeneration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleE4CodeGeneration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleE4CodeGeneration1523); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:663:1: ruleE4CodeGeneration returns [EObject current=null] : (otherlv_0= 'e4' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? ) ;
    public final EObject ruleE4CodeGeneration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_configValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:666:28: ( (otherlv_0= 'e4' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:667:1: (otherlv_0= 'e4' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:667:1: (otherlv_0= 'e4' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:667:3: otherlv_0= 'e4' ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleE4CodeGeneration1560); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getE4CodeGenerationAccess().getE4Keyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:671:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:672:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:672:1: (lv_name_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:673:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleE4CodeGeneration1577); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:689:2: (otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:689:4: otherlv_2= '{' ( (lv_configValue_3_0= ruleConfigValue ) )+ otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleE4CodeGeneration1595); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getE4CodeGenerationAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:693:1: ( (lv_configValue_3_0= ruleConfigValue ) )+
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
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:694:1: (lv_configValue_3_0= ruleConfigValue )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:694:1: (lv_configValue_3_0= ruleConfigValue )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:695:3: lv_configValue_3_0= ruleConfigValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getE4CodeGenerationAccess().getConfigValueConfigValueParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleConfigValue_in_ruleE4CodeGeneration1616);
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
                    	              		"ConfigValue");
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

                    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleE4CodeGeneration1629); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:723:1: entryRuleConfigValue returns [EObject current=null] : iv_ruleConfigValue= ruleConfigValue EOF ;
    public final EObject entryRuleConfigValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigValue = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:724:2: (iv_ruleConfigValue= ruleConfigValue EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:725:2: iv_ruleConfigValue= ruleConfigValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConfigValueRule()); 
            }
            pushFollow(FOLLOW_ruleConfigValue_in_entryRuleConfigValue1667);
            iv_ruleConfigValue=ruleConfigValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConfigValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigValue1677); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:732:1: ruleConfigValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) ) ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:735:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:736:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:736:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:736:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:736:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:737:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:737:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:738:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConfigValue1719); if (state.failed) return current;
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
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleConfigValue1736); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConfigValueAccess().getColonKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:758:1: ( ( (lv_simpleValue_2_0= RULE_STRING ) ) | (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' ) )
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:758:2: ( (lv_simpleValue_2_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:758:2: ( (lv_simpleValue_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:759:1: (lv_simpleValue_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:759:1: (lv_simpleValue_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:760:3: lv_simpleValue_2_0= RULE_STRING
                    {
                    lv_simpleValue_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConfigValue1754); if (state.failed) return current;
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
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:777:6: (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:777:6: (otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:777:8: otherlv_3= '{' ( (lv_children_4_0= ruleConfigValue ) )+ otherlv_5= '}'
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleConfigValue1778); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getConfigValueAccess().getLeftCurlyBracketKeyword_2_1_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:781:1: ( (lv_children_4_0= ruleConfigValue ) )+
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
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:782:1: (lv_children_4_0= ruleConfigValue )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:782:1: (lv_children_4_0= ruleConfigValue )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:783:3: lv_children_4_0= ruleConfigValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getConfigValueAccess().getChildrenConfigValueParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleConfigValue_in_ruleConfigValue1799);
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
                    	              		"ConfigValue");
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

                    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleConfigValue1812); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:811:1: entryRuleParitioning returns [EObject current=null] : iv_ruleParitioning= ruleParitioning EOF ;
    public final EObject entryRuleParitioning() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitioning = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:812:2: (iv_ruleParitioning= ruleParitioning EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:813:2: iv_ruleParitioning= ruleParitioning EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParitioningRule()); 
            }
            pushFollow(FOLLOW_ruleParitioning_in_entryRuleParitioning1850);
            iv_ruleParitioning=ruleParitioning();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParitioning; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioning1860); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:820:1: ruleParitioning returns [EObject current=null] : (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' ) ;
    public final EObject ruleParitioning() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_partitions_2_0 = null;

        EObject lv_partitioner_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:823:28: ( (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:824:1: (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:824:1: (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:824:3: otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleParitioning1897); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParitioningAccess().getPartitioningKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleParitioning1909); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:832:1: ( (lv_partitions_2_0= rulePartition ) )+
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
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:833:1: (lv_partitions_2_0= rulePartition )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:833:1: (lv_partitions_2_0= rulePartition )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:834:3: lv_partitions_2_0= rulePartition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePartition_in_ruleParitioning1930);
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
            	              		"Partition");
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:850:3: ( (lv_partitioner_3_0= rulePartitioner ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:851:1: (lv_partitioner_3_0= rulePartitioner )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:851:1: (lv_partitioner_3_0= rulePartitioner )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:852:3: lv_partitioner_3_0= rulePartitioner
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePartitioner_in_ruleParitioning1952);
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
                      		"Partitioner");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleParitioning1964); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:880:1: entryRulePartition returns [EObject current=null] : iv_rulePartition= rulePartition EOF ;
    public final EObject entryRulePartition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:881:2: (iv_rulePartition= rulePartition EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:882:2: iv_rulePartition= rulePartition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitionRule()); 
            }
            pushFollow(FOLLOW_rulePartition_in_entryRulePartition2000);
            iv_rulePartition=rulePartition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition2010); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:889:1: rulePartition returns [EObject current=null] : (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePartition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:892:28: ( (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:893:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:893:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:893:3: otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_rulePartition2047); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartitionAccess().getPartitionKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:897:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:898:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:898:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:899:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition2064); if (state.failed) return current;
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
                      		"ID");
              	    
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:923:1: entryRulePartitioner returns [EObject current=null] : iv_rulePartitioner= rulePartitioner EOF ;
    public final EObject entryRulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitioner = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:924:2: (iv_rulePartitioner= rulePartitioner EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:925:2: iv_rulePartitioner= rulePartitioner EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitionerRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_in_entryRulePartitioner2105);
            iv_rulePartitioner=rulePartitioner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartitioner; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner2115); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:932:1: rulePartitioner returns [EObject current=null] : (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS ) ;
    public final EObject rulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject this_Partitioner_Rule_0 = null;

        EObject this_Paritioner_JS_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:935:28: ( (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:936:1: (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:936:1: (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS )
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:937:5: this_Partitioner_Rule_0= rulePartitioner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePartitioner_Rule_in_rulePartitioner2162);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:947:5: this_Paritioner_JS_1= ruleParitioner_JS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParitioner_JS_in_rulePartitioner2189);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:963:1: entryRuleParitioner_JS returns [EObject current=null] : iv_ruleParitioner_JS= ruleParitioner_JS EOF ;
    public final EObject entryRuleParitioner_JS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitioner_JS = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:964:2: (iv_ruleParitioner_JS= ruleParitioner_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:965:2: iv_ruleParitioner_JS= ruleParitioner_JS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParitioner_JSRule()); 
            }
            pushFollow(FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS2224);
            iv_ruleParitioner_JS=ruleParitioner_JS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParitioner_JS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioner_JS2234); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:972:1: ruleParitioner_JS returns [EObject current=null] : (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleParitioner_JS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_scriptURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:975:28: ( (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:976:1: (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:976:1: (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:976:3: otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleParitioner_JS2271); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParitioner_JSAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:980:1: ( (lv_scriptURI_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:981:1: (lv_scriptURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:981:1: (lv_scriptURI_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:982:3: lv_scriptURI_1_0= RULE_STRING
            {
            lv_scriptURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleParitioner_JS2288); if (state.failed) return current;
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
                      		"STRING");
              	    
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1006:1: entryRulePartitioner_Rule returns [EObject current=null] : iv_rulePartitioner_Rule= rulePartitioner_Rule EOF ;
    public final EObject entryRulePartitioner_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitioner_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1007:2: (iv_rulePartitioner_Rule= rulePartitioner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1008:2: iv_rulePartitioner_Rule= rulePartitioner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitioner_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule2329);
            iv_rulePartitioner_Rule=rulePartitioner_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartitioner_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner_Rule2339); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1015:1: rulePartitioner_Rule returns [EObject current=null] : (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' ) ;
    public final EObject rulePartitioner_Rule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ruleList_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1018:28: ( (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1019:1: (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1019:1: (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1019:3: otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_rulePartitioner_Rule2376); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_rulePartitioner_Rule2388); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1027:1: ( (lv_ruleList_2_0= rulePartition_Rule ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26||LA16_0==31) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1028:1: (lv_ruleList_2_0= rulePartition_Rule )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1028:1: (lv_ruleList_2_0= rulePartition_Rule )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1029:3: lv_ruleList_2_0= rulePartition_Rule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePartition_Rule_in_rulePartitioner_Rule2409);
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
            	              		"Partition_Rule");
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

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_rulePartitioner_Rule2422); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1057:1: entryRulePartition_Rule returns [EObject current=null] : iv_rulePartition_Rule= rulePartition_Rule EOF ;
    public final EObject entryRulePartition_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1058:2: (iv_rulePartition_Rule= rulePartition_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1059:2: iv_rulePartition_Rule= rulePartition_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule2458);
            iv_rulePartition_Rule=rulePartition_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_Rule2468); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1066:1: rulePartition_Rule returns [EObject current=null] : (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule ) ;
    public final EObject rulePartition_Rule() throws RecognitionException {
        EObject current = null;

        EObject this_Partition_SingleLineRule_0 = null;

        EObject this_Partition_MultiLineRule_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1069:28: ( (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1070:1: (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1070:1: (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            else if ( (LA17_0==31) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1071:5: this_Partition_SingleLineRule_0= rulePartition_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePartition_SingleLineRule_in_rulePartition_Rule2515);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1081:5: this_Partition_MultiLineRule_1= rulePartition_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_rulePartition_MultiLineRule_in_rulePartition_Rule2542);
                    this_Partition_MultiLineRule_1=rulePartition_MultiLineRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Partition_MultiLineRule_1; 
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1097:1: entryRulePartition_SingleLineRule returns [EObject current=null] : iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF ;
    public final EObject entryRulePartition_SingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_SingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1098:2: (iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1099:2: iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule2577);
            iv_rulePartition_SingleLineRule=rulePartition_SingleLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_SingleLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_SingleLineRule2587); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1106:1: rulePartition_SingleLineRule returns [EObject current=null] : (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? (otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) )? )? (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )? ) ;
    public final EObject rulePartition_SingleLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_startSeq_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_endSeq_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_escapeSeq_9_0=null;
        EObject lv_check_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1109:28: ( (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? (otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) )? )? (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1110:1: (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? (otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) )? )? (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1110:1: (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? (otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) )? )? (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1110:3: otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? (otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) )? )? (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_rulePartition_SingleLineRule2624); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1114:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1115:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1115:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1116:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition_SingleLineRule2644); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1127:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1128:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1128:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1129:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2661); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1145:2: (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1145:4: otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_27_in_rulePartition_SingleLineRule2679); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPartition_SingleLineRuleAccess().getColKeyword_3_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1149:1: ( (lv_check_4_0= ruleCheck ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1150:1: (lv_check_4_0= ruleCheck )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1150:1: (lv_check_4_0= ruleCheck )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1151:3: lv_check_4_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPartition_SingleLineRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCheck_in_rulePartition_SingleLineRule2700);
                    lv_check_4_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPartition_SingleLineRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_4_0, 
                              		"Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1167:4: (otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) )? )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1167:6: otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) )?
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_rulePartition_SingleLineRule2715); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_4_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1171:1: ( (lv_endSeq_6_0= RULE_STRING ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_STRING) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1172:1: (lv_endSeq_6_0= RULE_STRING )
                            {
                            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1172:1: (lv_endSeq_6_0= RULE_STRING )
                            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1173:3: lv_endSeq_6_0= RULE_STRING
                            {
                            lv_endSeq_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2732); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_endSeq_6_0, grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"endSeq",
                                      		lv_endSeq_6_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1189:5: (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1189:7: otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,29,FOLLOW_29_in_rulePartition_SingleLineRule2753); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_5_0());
                          
                    }
                    otherlv_8=(Token)match(input,30,FOLLOW_30_in_rulePartition_SingleLineRule2765); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_5_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1197:1: ( (lv_escapeSeq_9_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1198:1: (lv_escapeSeq_9_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1198:1: (lv_escapeSeq_9_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1199:3: lv_escapeSeq_9_0= RULE_STRING
                    {
                    lv_escapeSeq_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2782); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_9_0, grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_9_0, 
                              		"STRING");
                      	    
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1223:1: entryRulePartition_MultiLineRule returns [EObject current=null] : iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF ;
    public final EObject entryRulePartition_MultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_MultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1224:2: (iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1225:2: iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule2825);
            iv_rulePartition_MultiLineRule=rulePartition_MultiLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_MultiLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_MultiLineRule2835); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1232:1: rulePartition_MultiLineRule returns [EObject current=null] : (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) ) (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )? ) ;
    public final EObject rulePartition_MultiLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_startSeq_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_endSeq_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_escapeSeq_9_0=null;
        EObject lv_check_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1235:28: ( (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) ) (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1236:1: (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) ) (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1236:1: (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) ) (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1236:3: otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= '=>' ( (lv_endSeq_6_0= RULE_STRING ) ) (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_rulePartition_MultiLineRule2872); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1240:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1241:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1241:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1242:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition_MultiLineRule2892); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1253:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1254:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1254:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1255:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2909); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1271:2: (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==27) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1271:4: otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_27_in_rulePartition_MultiLineRule2927); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPartition_MultiLineRuleAccess().getColKeyword_3_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1275:1: ( (lv_check_4_0= ruleCheck ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1276:1: (lv_check_4_0= ruleCheck )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1276:1: (lv_check_4_0= ruleCheck )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1277:3: lv_check_4_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPartition_MultiLineRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCheck_in_rulePartition_MultiLineRule2948);
                    lv_check_4_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPartition_MultiLineRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_4_0, 
                              		"Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,28,FOLLOW_28_in_rulePartition_MultiLineRule2962); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_4());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1297:1: ( (lv_endSeq_6_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1298:1: (lv_endSeq_6_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1298:1: (lv_endSeq_6_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1299:3: lv_endSeq_6_0= RULE_STRING
            {
            lv_endSeq_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2979); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_endSeq_6_0, grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"endSeq",
                      		lv_endSeq_6_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1315:2: (otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1315:4: otherlv_7= 'escaped' otherlv_8= 'by' ( (lv_escapeSeq_9_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,29,FOLLOW_29_in_rulePartition_MultiLineRule2997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_6_0());
                          
                    }
                    otherlv_8=(Token)match(input,30,FOLLOW_30_in_rulePartition_MultiLineRule3009); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_6_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1323:1: ( (lv_escapeSeq_9_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1324:1: (lv_escapeSeq_9_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1324:1: (lv_escapeSeq_9_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1325:3: lv_escapeSeq_9_0= RULE_STRING
                    {
                    lv_escapeSeq_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule3026); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_9_0, grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_6_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_9_0, 
                              		"STRING");
                      	    
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


    // $ANTLR start "entryRuleLexicalHighlighting"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1349:1: entryRuleLexicalHighlighting returns [EObject current=null] : iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF ;
    public final EObject entryRuleLexicalHighlighting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalHighlighting = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1350:2: (iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1351:2: iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting3069);
            iv_ruleLexicalHighlighting=ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalHighlighting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalHighlighting3079); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1358:1: ruleLexicalHighlighting returns [EObject current=null] : (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ ( (lv_vistual_3_0= ruleTokenVisuals ) )? otherlv_4= '}' ) ;
    public final EObject ruleLexicalHighlighting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_list_2_0 = null;

        EObject lv_vistual_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1361:28: ( (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ ( (lv_vistual_3_0= ruleTokenVisuals ) )? otherlv_4= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1362:1: (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ ( (lv_vistual_3_0= ruleTokenVisuals ) )? otherlv_4= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1362:1: (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ ( (lv_vistual_3_0= ruleTokenVisuals ) )? otherlv_4= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1362:3: otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ ( (lv_vistual_3_0= ruleTokenVisuals ) )? otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleLexicalHighlighting3116); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleLexicalHighlighting3128); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1370:1: ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=24 && LA24_0<=25)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1371:1: (lv_list_2_0= ruleLexicalPartitionHighlighting )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1371:1: (lv_list_2_0= ruleLexicalPartitionHighlighting )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1372:3: lv_list_2_0= ruleLexicalPartitionHighlighting
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_ruleLexicalHighlighting3149);
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
            	              		"LexicalPartitionHighlighting");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1388:3: ( (lv_vistual_3_0= ruleTokenVisuals ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1389:1: (lv_vistual_3_0= ruleTokenVisuals )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1389:1: (lv_vistual_3_0= ruleTokenVisuals )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1390:3: lv_vistual_3_0= ruleTokenVisuals
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLexicalHighlightingAccess().getVistualTokenVisualsParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTokenVisuals_in_ruleLexicalHighlighting3171);
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
                              		"TokenVisuals");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleLexicalHighlighting3184); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1418:1: entryRuleTokenVisuals returns [EObject current=null] : iv_ruleTokenVisuals= ruleTokenVisuals EOF ;
    public final EObject entryRuleTokenVisuals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokenVisuals = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1419:2: (iv_ruleTokenVisuals= ruleTokenVisuals EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1420:2: iv_ruleTokenVisuals= ruleTokenVisuals EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokenVisualsRule()); 
            }
            pushFollow(FOLLOW_ruleTokenVisuals_in_entryRuleTokenVisuals3220);
            iv_ruleTokenVisuals=ruleTokenVisuals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTokenVisuals; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTokenVisuals3230); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1427:1: ruleTokenVisuals returns [EObject current=null] : (otherlv_0= 'token_def' otherlv_1= '{' ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+ otherlv_4= '}' ) ;
    public final EObject ruleTokenVisuals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_tokenVisuals_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1430:28: ( (otherlv_0= 'token_def' otherlv_1= '{' ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+ otherlv_4= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1431:1: (otherlv_0= 'token_def' otherlv_1= '{' ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+ otherlv_4= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1431:1: (otherlv_0= 'token_def' otherlv_1= '{' ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+ otherlv_4= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1431:3: otherlv_0= 'token_def' otherlv_1= '{' ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleTokenVisuals3267); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTokenVisualsAccess().getToken_defKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleTokenVisuals3279); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTokenVisualsAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1439:1: ( ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';' )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1439:2: ( (lv_tokenVisuals_2_0= ruleTokenVisual ) ) otherlv_3= ';'
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1439:2: ( (lv_tokenVisuals_2_0= ruleTokenVisual ) )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1440:1: (lv_tokenVisuals_2_0= ruleTokenVisual )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1440:1: (lv_tokenVisuals_2_0= ruleTokenVisual )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1441:3: lv_tokenVisuals_2_0= ruleTokenVisual
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTokenVisualsAccess().getTokenVisualsTokenVisualParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTokenVisual_in_ruleTokenVisuals3301);
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
            	              		"TokenVisual");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleTokenVisuals3313); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTokenVisualsAccess().getSemicolonKeyword_2_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleTokenVisuals3327); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1473:1: entryRuleTokenVisual returns [EObject current=null] : iv_ruleTokenVisual= ruleTokenVisual EOF ;
    public final EObject entryRuleTokenVisual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokenVisual = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1474:2: (iv_ruleTokenVisual= ruleTokenVisual EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1475:2: iv_ruleTokenVisual= ruleTokenVisual EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokenVisualRule()); 
            }
            pushFollow(FOLLOW_ruleTokenVisual_in_entryRuleTokenVisual3363);
            iv_ruleTokenVisual=ruleTokenVisual();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTokenVisual; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTokenVisual3373); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1482:1: ruleTokenVisual returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_colorSpec_1_0= RULE_STRING ) ) ( (lv_bold_2_0= 'bold' ) )? ( (lv_italic_3_0= 'italic' ) )? ) ;
    public final EObject ruleTokenVisual() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_colorSpec_1_0=null;
        Token lv_bold_2_0=null;
        Token lv_italic_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1485:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_colorSpec_1_0= RULE_STRING ) ) ( (lv_bold_2_0= 'bold' ) )? ( (lv_italic_3_0= 'italic' ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1486:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_colorSpec_1_0= RULE_STRING ) ) ( (lv_bold_2_0= 'bold' ) )? ( (lv_italic_3_0= 'italic' ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1486:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_colorSpec_1_0= RULE_STRING ) ) ( (lv_bold_2_0= 'bold' ) )? ( (lv_italic_3_0= 'italic' ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1486:2: ( (otherlv_0= RULE_ID ) ) ( (lv_colorSpec_1_0= RULE_STRING ) ) ( (lv_bold_2_0= 'bold' ) )? ( (lv_italic_3_0= 'italic' ) )?
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1486:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1487:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1487:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1488:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTokenVisualRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTokenVisual3418); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getTokenVisualAccess().getTokenTokenCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1499:2: ( (lv_colorSpec_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1500:1: (lv_colorSpec_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1500:1: (lv_colorSpec_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1501:3: lv_colorSpec_1_0= RULE_STRING
            {
            lv_colorSpec_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTokenVisual3435); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1517:2: ( (lv_bold_2_0= 'bold' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==35) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1518:1: (lv_bold_2_0= 'bold' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1518:1: (lv_bold_2_0= 'bold' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1519:3: lv_bold_2_0= 'bold'
                    {
                    lv_bold_2_0=(Token)match(input,35,FOLLOW_35_in_ruleTokenVisual3458); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1532:3: ( (lv_italic_3_0= 'italic' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==36) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1533:1: (lv_italic_3_0= 'italic' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1533:1: (lv_italic_3_0= 'italic' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1534:3: lv_italic_3_0= 'italic'
                    {
                    lv_italic_3_0=(Token)match(input,36,FOLLOW_36_in_ruleTokenVisual3490); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1555:1: entryRuleLexicalPartitionHighlighting returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1556:2: (iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1557:2: iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting3540);
            iv_ruleLexicalPartitionHighlighting=ruleLexicalPartitionHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting3550); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1564:1: ruleLexicalPartitionHighlighting returns [EObject current=null] : (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS ) ;
    public final EObject ruleLexicalPartitionHighlighting() throws RecognitionException {
        EObject current = null;

        EObject this_LexicalPartitionHighlighting_Rule_0 = null;

        EObject this_LexicalPartitionHighlighting_JS_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1567:28: ( (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1568:1: (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1568:1: (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==25) ) {
                alt29=1;
            }
            else if ( (LA29_0==24) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1569:5: this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_ruleLexicalPartitionHighlighting3597);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1579:5: this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_ruleLexicalPartitionHighlighting3624);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1595:1: entryRuleLexicalPartitionHighlighting_JS returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting_JS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting_JS = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1596:2: (iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1597:2: iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS3659);
            iv_ruleLexicalPartitionHighlighting_JS=ruleLexicalPartitionHighlighting_JS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting_JS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS3669); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1604:1: ruleLexicalPartitionHighlighting_JS returns [EObject current=null] : (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleLexicalPartitionHighlighting_JS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_scriptURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1607:28: ( (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1608:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1608:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1608:3: otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleLexicalPartitionHighlighting_JS3706); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1612:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1613:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1613:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1614:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_JSRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_JS3726); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1625:2: ( (lv_scriptURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1626:1: (lv_scriptURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1626:1: (lv_scriptURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1627:3: lv_scriptURI_2_0= RULE_STRING
            {
            lv_scriptURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexicalPartitionHighlighting_JS3743); if (state.failed) return current;
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
                      		"STRING");
              	    
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1651:1: entryRuleLexicalPartitionHighlighting_Rule returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1652:2: (iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1653:2: iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule3784);
            iv_ruleLexicalPartitionHighlighting_Rule=ruleLexicalPartitionHighlighting_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule3794); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1660:1: ruleLexicalPartitionHighlighting_Rule returns [EObject current=null] : (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1663:28: ( (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1664:1: (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1664:1: (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1664:3: otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleLexicalPartitionHighlighting_Rule3831); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1668:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1669:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1669:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1670:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_RuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_Rule3851); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1681:2: ( (lv_whitespace_2_0= ruleWhitespaceRule ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==50) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1682:1: (lv_whitespace_2_0= ruleWhitespaceRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1682:1: (lv_whitespace_2_0= ruleWhitespaceRule )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1683:3: lv_whitespace_2_0= ruleWhitespaceRule
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceWhitespaceRuleParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleWhitespaceRule_in_ruleLexicalPartitionHighlighting_Rule3872);
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
                              		"WhitespaceRule");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleLexicalPartitionHighlighting_Rule3885); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1703:1: ( (lv_tokenList_4_0= ruleToken ) )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID||LA31_0==37) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1704:1: (lv_tokenList_4_0= ruleToken )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1704:1: (lv_tokenList_4_0= ruleToken )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1705:3: lv_tokenList_4_0= ruleToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleToken_in_ruleLexicalPartitionHighlighting_Rule3906);
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
            	              		"Token");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleLexicalPartitionHighlighting_Rule3919); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1733:1: entryRuleToken returns [EObject current=null] : iv_ruleToken= ruleToken EOF ;
    public final EObject entryRuleToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleToken = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1734:2: (iv_ruleToken= ruleToken EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1735:2: iv_ruleToken= ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_ruleToken_in_entryRuleToken3955);
            iv_ruleToken=ruleToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleToken; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleToken3965); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1742:1: ruleToken returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? ) ;
    public final EObject ruleToken() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_scannerList_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1745:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1746:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1746:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1746:2: ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )?
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1746:2: ( (lv_default_0_0= 'default' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==37) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1747:1: (lv_default_0_0= 'default' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1747:1: (lv_default_0_0= 'default' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1748:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,37,FOLLOW_37_in_ruleToken4008); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1761:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1762:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1762:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1763:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleToken4039); if (state.failed) return current;
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
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1779:2: (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==15) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1779:4: otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleToken4057); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1783:1: ( (lv_scannerList_3_0= ruleScanner ) )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==24||LA33_0==26||LA33_0==31||LA33_0==38||LA33_0==43||LA33_0==45) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1784:1: (lv_scannerList_3_0= ruleScanner )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1784:1: (lv_scannerList_3_0= ruleScanner )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1785:3: lv_scannerList_3_0= ruleScanner
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleScanner_in_ruleToken4078);
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
                    	              		"Scanner");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);

                    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleToken4091); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1813:1: entryRuleScanner returns [EObject current=null] : iv_ruleScanner= ruleScanner EOF ;
    public final EObject entryRuleScanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1814:2: (iv_ruleScanner= ruleScanner EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1815:2: iv_ruleScanner= ruleScanner EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScannerRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_in_entryRuleScanner4129);
            iv_ruleScanner=ruleScanner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner4139); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1822:1: ruleScanner returns [EObject current=null] : (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule ) ;
    public final EObject ruleScanner() throws RecognitionException {
        EObject current = null;

        EObject this_Scanner_Keyword_0 = null;

        EObject this_Scanner_Rule_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1825:28: ( (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1826:1: (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1826:1: (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==38) ) {
                alt35=1;
            }
            else if ( (LA35_0==24||LA35_0==26||LA35_0==31||LA35_0==43||LA35_0==45) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1827:5: this_Scanner_Keyword_0= ruleScanner_Keyword
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_Keyword_in_ruleScanner4186);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1837:5: this_Scanner_Rule_1= ruleScanner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_Rule_in_ruleScanner4213);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1853:1: entryRuleScanner_Keyword returns [EObject current=null] : iv_ruleScanner_Keyword= ruleScanner_Keyword EOF ;
    public final EObject entryRuleScanner_Keyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_Keyword = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1854:2: (iv_ruleScanner_Keyword= ruleScanner_Keyword EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1855:2: iv_ruleScanner_Keyword= ruleScanner_Keyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_KeywordRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword4248);
            iv_ruleScanner_Keyword=ruleScanner_Keyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_Keyword; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Keyword4258); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1862:1: ruleScanner_Keyword returns [EObject current=null] : (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleScanner_Keyword() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_keywords_2_0 = null;

        EObject lv_keywords_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1865:28: ( (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1866:1: (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1866:1: (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1866:3: otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleScanner_Keyword4295); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleScanner_Keyword4307); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1874:1: ( (lv_keywords_2_0= ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1875:1: (lv_keywords_2_0= ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1875:1: (lv_keywords_2_0= ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1876:3: lv_keywords_2_0= ruleKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleKeyword_in_ruleScanner_Keyword4328);
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
                      		"Keyword");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1892:2: (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==40) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1892:4: otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) )
            	    {
            	    otherlv_3=(Token)match(input,40,FOLLOW_40_in_ruleScanner_Keyword4341); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1896:1: ( (lv_keywords_4_0= ruleKeyword ) )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1897:1: (lv_keywords_4_0= ruleKeyword )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1897:1: (lv_keywords_4_0= ruleKeyword )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1898:3: lv_keywords_4_0= ruleKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleKeyword_in_ruleScanner_Keyword4362);
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
            	              		"Keyword");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_5=(Token)match(input,41,FOLLOW_41_in_ruleScanner_Keyword4376); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getScanner_KeywordAccess().getRightSquareBracketKeyword_4());
                  
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1926:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1927:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1928:2: iv_ruleKeyword= ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword4412);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyword; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword4422); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1935:1: ruleKeyword returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_version_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1938:28: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1939:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1939:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1939:2: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1939:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1940:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1940:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1941:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword4464); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1957:2: (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==42) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1957:4: otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleKeyword4482); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getKeywordAccess().getSinceKeyword_1_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1961:1: ( (lv_version_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1962:1: (lv_version_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1962:1: (lv_version_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1963:3: lv_version_2_0= RULE_STRING
                    {
                    lv_version_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword4499); if (state.failed) return current;
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
                              		"STRING");
                      	    
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1987:1: entryRuleScanner_Rule returns [EObject current=null] : iv_ruleScanner_Rule= ruleScanner_Rule EOF ;
    public final EObject entryRuleScanner_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1988:2: (iv_ruleScanner_Rule= ruleScanner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1989:2: iv_ruleScanner_Rule= ruleScanner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule4542);
            iv_ruleScanner_Rule=ruleScanner_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Rule4552); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1996:1: ruleScanner_Rule returns [EObject current=null] : (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule ) ;
    public final EObject ruleScanner_Rule() throws RecognitionException {
        EObject current = null;

        EObject this_Scanner_SingleLineRule_0 = null;

        EObject this_Scanner_MultiLineRule_1 = null;

        EObject this_Scanner_CharacterRule_2 = null;

        EObject this_Scanner_JSRule_3 = null;

        EObject this_Scanner_PatternRule_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1999:28: ( (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2000:1: (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2000:1: (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule )
            int alt38=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt38=1;
                }
                break;
            case 31:
                {
                alt38=2;
                }
                break;
            case 45:
                {
                alt38=3;
                }
                break;
            case 24:
                {
                alt38=4;
                }
                break;
            case 43:
                {
                alt38=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2001:5: this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_ruleScanner_Rule4599);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2011:5: this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_ruleScanner_Rule4626);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2021:5: this_Scanner_CharacterRule_2= ruleScanner_CharacterRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_CharacterRule_in_ruleScanner_Rule4653);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2031:5: this_Scanner_JSRule_3= ruleScanner_JSRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_JSRule_in_ruleScanner_Rule4680);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2041:5: this_Scanner_PatternRule_4= ruleScanner_PatternRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_PatternRuleParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_PatternRule_in_ruleScanner_Rule4707);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2057:1: entryRuleScanner_SingleLineRule returns [EObject current=null] : iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF ;
    public final EObject entryRuleScanner_SingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_SingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2058:2: (iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2059:2: iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule4742);
            iv_ruleScanner_SingleLineRule=ruleScanner_SingleLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_SingleLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_SingleLineRule4752); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2066:1: ruleScanner_SingleLineRule returns [EObject current=null] : (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? (otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) )? )? (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleScanner_SingleLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_startSeq_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_endSeq_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_escapeSeq_8_0=null;
        EObject lv_check_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2069:28: ( (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? (otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) )? )? (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2070:1: (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? (otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) )? )? (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2070:1: (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? (otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) )? )? (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2070:3: otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? (otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) )? )? (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleScanner_SingleLineRule4789); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2074:1: ( (lv_startSeq_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2075:1: (lv_startSeq_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2075:1: (lv_startSeq_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2076:3: lv_startSeq_1_0= RULE_STRING
            {
            lv_startSeq_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4806); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2092:2: (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==27) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2092:4: otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleScanner_SingleLineRule4824); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getScanner_SingleLineRuleAccess().getColKeyword_2_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2096:1: ( (lv_check_3_0= ruleCheck ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2097:1: (lv_check_3_0= ruleCheck )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2097:1: (lv_check_3_0= ruleCheck )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2098:3: lv_check_3_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_SingleLineRuleAccess().getCheckCheckParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCheck_in_ruleScanner_SingleLineRule4845);
                    lv_check_3_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_SingleLineRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_3_0, 
                              		"Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2114:4: (otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) )? )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==28) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2114:6: otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) )?
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleScanner_SingleLineRule4860); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2118:1: ( (lv_endSeq_5_0= RULE_STRING ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==RULE_STRING) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2119:1: (lv_endSeq_5_0= RULE_STRING )
                            {
                            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2119:1: (lv_endSeq_5_0= RULE_STRING )
                            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2120:3: lv_endSeq_5_0= RULE_STRING
                            {
                            lv_endSeq_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4877); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_endSeq_5_0, grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getScanner_SingleLineRuleRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"endSeq",
                                      		lv_endSeq_5_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2136:5: (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==29) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2136:7: otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleScanner_SingleLineRule4898); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_4_0());
                          
                    }
                    otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleScanner_SingleLineRule4910); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_4_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2144:1: ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2145:1: (lv_escapeSeq_8_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2145:1: (lv_escapeSeq_8_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2146:3: lv_escapeSeq_8_0= RULE_STRING
                    {
                    lv_escapeSeq_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4927); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_8_0, grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_8_0, 
                              		"STRING");
                      	    
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2170:1: entryRuleScanner_MultiLineRule returns [EObject current=null] : iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF ;
    public final EObject entryRuleScanner_MultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_MultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2171:2: (iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2172:2: iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule4970);
            iv_ruleScanner_MultiLineRule=ruleScanner_MultiLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_MultiLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_MultiLineRule4980); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2179:1: ruleScanner_MultiLineRule returns [EObject current=null] : (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleScanner_MultiLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_startSeq_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_endSeq_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_escapeSeq_8_0=null;
        EObject lv_check_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2182:28: ( (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2183:1: (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2183:1: (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2183:3: otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? otherlv_4= '=>' ( (lv_endSeq_5_0= RULE_STRING ) ) (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleScanner_MultiLineRule5017); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2187:1: ( (lv_startSeq_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2188:1: (lv_startSeq_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2188:1: (lv_startSeq_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2189:3: lv_startSeq_1_0= RULE_STRING
            {
            lv_startSeq_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule5034); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2205:2: (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==27) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2205:4: otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleScanner_MultiLineRule5052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getScanner_MultiLineRuleAccess().getColKeyword_2_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2209:1: ( (lv_check_3_0= ruleCheck ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2210:1: (lv_check_3_0= ruleCheck )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2210:1: (lv_check_3_0= ruleCheck )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2211:3: lv_check_3_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_MultiLineRuleAccess().getCheckCheckParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCheck_in_ruleScanner_MultiLineRule5073);
                    lv_check_3_0=ruleCheck();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScanner_MultiLineRuleRule());
                      	        }
                             		set(
                             			current, 
                             			"check",
                              		lv_check_3_0, 
                              		"Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleScanner_MultiLineRule5087); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2231:1: ( (lv_endSeq_5_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2232:1: (lv_endSeq_5_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2232:1: (lv_endSeq_5_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2233:3: lv_endSeq_5_0= RULE_STRING
            {
            lv_endSeq_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule5104); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_endSeq_5_0, grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScanner_MultiLineRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"endSeq",
                      		lv_endSeq_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2249:2: (otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==29) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2249:4: otherlv_6= 'escaped' otherlv_7= 'by' ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleScanner_MultiLineRule5122); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_5_0());
                          
                    }
                    otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleScanner_MultiLineRule5134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_5_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2257:1: ( (lv_escapeSeq_8_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2258:1: (lv_escapeSeq_8_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2258:1: (lv_escapeSeq_8_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2259:3: lv_escapeSeq_8_0= RULE_STRING
                    {
                    lv_escapeSeq_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule5151); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_8_0, grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_MultiLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_8_0, 
                              		"STRING");
                      	    
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2283:1: entryRuleScanner_PatternRule returns [EObject current=null] : iv_ruleScanner_PatternRule= ruleScanner_PatternRule EOF ;
    public final EObject entryRuleScanner_PatternRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_PatternRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2284:2: (iv_ruleScanner_PatternRule= ruleScanner_PatternRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2285:2: iv_ruleScanner_PatternRule= ruleScanner_PatternRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_PatternRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_PatternRule_in_entryRuleScanner_PatternRule5194);
            iv_ruleScanner_PatternRule=ruleScanner_PatternRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_PatternRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_PatternRule5204); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2292:1: ruleScanner_PatternRule returns [EObject current=null] : (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= 'containing' ( (lv_contentPattern_6_0= RULE_STRING ) ) ) ;
    public final EObject ruleScanner_PatternRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_startPattern_1_0=null;
        Token lv_length_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_contentPattern_6_0=null;
        EObject lv_check_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2295:28: ( (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= 'containing' ( (lv_contentPattern_6_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2296:1: (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= 'containing' ( (lv_contentPattern_6_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2296:1: (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= 'containing' ( (lv_contentPattern_6_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2296:3: otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )? otherlv_5= 'containing' ( (lv_contentPattern_6_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleScanner_PatternRule5241); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_PatternRuleAccess().getPatternKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2300:1: ( (lv_startPattern_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2301:1: (lv_startPattern_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2301:1: (lv_startPattern_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2302:3: lv_startPattern_1_0= RULE_STRING
            {
            lv_startPattern_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_PatternRule5258); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2318:2: ( (lv_length_2_0= RULE_INT ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_INT) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2319:1: (lv_length_2_0= RULE_INT )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2319:1: (lv_length_2_0= RULE_INT )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2320:3: lv_length_2_0= RULE_INT
                    {
                    lv_length_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleScanner_PatternRule5280); if (state.failed) return current;
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
                              		"INT");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2336:3: (otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==27) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2336:5: otherlv_3= 'col' ( (lv_check_4_0= ruleCheck ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleScanner_PatternRule5299); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getScanner_PatternRuleAccess().getColKeyword_3_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2340:1: ( (lv_check_4_0= ruleCheck ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2341:1: (lv_check_4_0= ruleCheck )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2341:1: (lv_check_4_0= ruleCheck )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2342:3: lv_check_4_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_PatternRuleAccess().getCheckCheckParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCheck_in_ruleScanner_PatternRule5320);
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
                              		"Check");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,44,FOLLOW_44_in_ruleScanner_PatternRule5334); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getScanner_PatternRuleAccess().getContainingKeyword_4());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2362:1: ( (lv_contentPattern_6_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2363:1: (lv_contentPattern_6_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2363:1: (lv_contentPattern_6_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2364:3: lv_contentPattern_6_0= RULE_STRING
            {
            lv_contentPattern_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_PatternRule5351); if (state.failed) return current;
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
                      		"STRING");
              	    
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
    // $ANTLR end "ruleScanner_PatternRule"


    // $ANTLR start "entryRuleScanner_CharacterRule"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2388:1: entryRuleScanner_CharacterRule returns [EObject current=null] : iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF ;
    public final EObject entryRuleScanner_CharacterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_CharacterRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2389:2: (iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2390:2: iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule5392);
            iv_ruleScanner_CharacterRule=ruleScanner_CharacterRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_CharacterRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_CharacterRule5402); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2397:1: ruleScanner_CharacterRule returns [EObject current=null] : (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? ) ;
    public final EObject ruleScanner_CharacterRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_characters_2_0=null;
        Token otherlv_3=null;
        Token lv_characters_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_check_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2400:28: ( (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2401:1: (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2401:1: (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2401:3: otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )?
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleScanner_CharacterRule5439); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleScanner_CharacterRule5451); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2409:1: ( (lv_characters_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2410:1: (lv_characters_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2410:1: (lv_characters_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2411:3: lv_characters_2_0= RULE_STRING
            {
            lv_characters_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule5468); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2427:2: (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==40) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2427:4: otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,40,FOLLOW_40_in_ruleScanner_CharacterRule5486); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2431:1: ( (lv_characters_4_0= RULE_STRING ) )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2432:1: (lv_characters_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2432:1: (lv_characters_4_0= RULE_STRING )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2433:3: lv_characters_4_0= RULE_STRING
            	    {
            	    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule5503); if (state.failed) return current;
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
            	              		"STRING");
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            otherlv_5=(Token)match(input,41,FOLLOW_41_in_ruleScanner_CharacterRule5522); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getScanner_CharacterRuleAccess().getRightSquareBracketKeyword_4());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2453:1: (otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==27) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2453:3: otherlv_6= 'col' ( (lv_check_7_0= ruleCheck ) )
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleScanner_CharacterRule5535); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getScanner_CharacterRuleAccess().getColKeyword_5_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2457:1: ( (lv_check_7_0= ruleCheck ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2458:1: (lv_check_7_0= ruleCheck )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2458:1: (lv_check_7_0= ruleCheck )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2459:3: lv_check_7_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_CharacterRuleAccess().getCheckCheckParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCheck_in_ruleScanner_CharacterRule5556);
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
                              		"Check");
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2483:1: entryRuleScanner_JSRule returns [EObject current=null] : iv_ruleScanner_JSRule= ruleScanner_JSRule EOF ;
    public final EObject entryRuleScanner_JSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_JSRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2484:2: (iv_ruleScanner_JSRule= ruleScanner_JSRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2485:2: iv_ruleScanner_JSRule= ruleScanner_JSRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_JSRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule5594);
            iv_ruleScanner_JSRule=ruleScanner_JSRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_JSRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_JSRule5604); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2492:1: ruleScanner_JSRule returns [EObject current=null] : (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? ) ;
    public final EObject ruleScanner_JSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fileURI_1_0=null;
        Token otherlv_2=null;
        EObject lv_check_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2495:28: ( (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2496:1: (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2496:1: (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2496:3: otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleScanner_JSRule5641); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2500:1: ( (lv_fileURI_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2501:1: (lv_fileURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2501:1: (lv_fileURI_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2502:3: lv_fileURI_1_0= RULE_STRING
            {
            lv_fileURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_JSRule5658); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2518:2: (otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==27) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2518:4: otherlv_2= 'col' ( (lv_check_3_0= ruleCheck ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleScanner_JSRule5676); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getScanner_JSRuleAccess().getColKeyword_2_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2522:1: ( (lv_check_3_0= ruleCheck ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2523:1: (lv_check_3_0= ruleCheck )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2523:1: (lv_check_3_0= ruleCheck )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2524:3: lv_check_3_0= ruleCheck
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScanner_JSRuleAccess().getCheckCheckParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCheck_in_ruleScanner_JSRule5697);
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
                              		"Check");
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


    // $ANTLR start "entryRuleCheck"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2548:1: entryRuleCheck returns [EObject current=null] : iv_ruleCheck= ruleCheck EOF ;
    public final EObject entryRuleCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheck = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2549:2: (iv_ruleCheck= ruleCheck EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2550:2: iv_ruleCheck= ruleCheck EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCheckRule()); 
            }
            pushFollow(FOLLOW_ruleCheck_in_entryRuleCheck5735);
            iv_ruleCheck=ruleCheck();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCheck; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCheck5745); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2557:1: ruleCheck returns [EObject current=null] : (this_Range_0= ruleRange | this_Equals_1= ruleEquals ) ;
    public final EObject ruleCheck() throws RecognitionException {
        EObject current = null;

        EObject this_Range_0 = null;

        EObject this_Equals_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2560:28: ( (this_Range_0= ruleRange | this_Equals_1= ruleEquals ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2561:1: (this_Range_0= ruleRange | this_Equals_1= ruleEquals )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2561:1: (this_Range_0= ruleRange | this_Equals_1= ruleEquals )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==47) ) {
                alt50=1;
            }
            else if ( (LA50_0==46) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2562:5: this_Range_0= ruleRange
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCheckAccess().getRangeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRange_in_ruleCheck5792);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2572:5: this_Equals_1= ruleEquals
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCheckAccess().getEqualsParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEquals_in_ruleCheck5819);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2588:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2589:2: (iv_ruleEquals= ruleEquals EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2590:2: iv_ruleEquals= ruleEquals EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualsRule()); 
            }
            pushFollow(FOLLOW_ruleEquals_in_entryRuleEquals5854);
            iv_ruleEquals=ruleEquals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquals; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquals5864); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2597:1: ruleEquals returns [EObject current=null] : (otherlv_0= 'eq' ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleEquals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2600:28: ( (otherlv_0= 'eq' ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2601:1: (otherlv_0= 'eq' ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2601:1: (otherlv_0= 'eq' ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2601:3: otherlv_0= 'eq' ( (lv_value_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleEquals5901); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEqualsAccess().getEqKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2605:1: ( (lv_value_1_0= RULE_INT ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2606:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2606:1: (lv_value_1_0= RULE_INT )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2607:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEquals5918); if (state.failed) return current;
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
                      		"INT");
              	    
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2631:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2632:2: (iv_ruleRange= ruleRange EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2633:2: iv_ruleRange= ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRule()); 
            }
            pushFollow(FOLLOW_ruleRange_in_entryRuleRange5959);
            iv_ruleRange=ruleRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRange5969); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2640:1: ruleRange returns [EObject current=null] : (otherlv_0= 'in' ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) ) ( (lv_minValue_2_0= RULE_INT ) )? otherlv_3= ',' ( (lv_maxValue_4_0= RULE_INT ) )? ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) ) ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2643:28: ( (otherlv_0= 'in' ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) ) ( (lv_minValue_2_0= RULE_INT ) )? otherlv_3= ',' ( (lv_maxValue_4_0= RULE_INT ) )? ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2644:1: (otherlv_0= 'in' ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) ) ( (lv_minValue_2_0= RULE_INT ) )? otherlv_3= ',' ( (lv_maxValue_4_0= RULE_INT ) )? ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2644:1: (otherlv_0= 'in' ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) ) ( (lv_minValue_2_0= RULE_INT ) )? otherlv_3= ',' ( (lv_maxValue_4_0= RULE_INT ) )? ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2644:3: otherlv_0= 'in' ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) ) ( (lv_minValue_2_0= RULE_INT ) )? otherlv_3= ',' ( (lv_maxValue_4_0= RULE_INT ) )? ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleRange6006); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRangeAccess().getInKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2648:1: ( ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2649:1: ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2649:1: ( (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2650:1: (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2650:1: (lv_ltIncl_1_1= '(' | lv_ltIncl_1_2= '[' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==48) ) {
                alt51=1;
            }
            else if ( (LA51_0==39) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2651:3: lv_ltIncl_1_1= '('
                    {
                    lv_ltIncl_1_1=(Token)match(input,48,FOLLOW_48_in_ruleRange6026); if (state.failed) return current;
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2663:8: lv_ltIncl_1_2= '['
                    {
                    lv_ltIncl_1_2=(Token)match(input,39,FOLLOW_39_in_ruleRange6055); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2678:2: ( (lv_minValue_2_0= RULE_INT ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_INT) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2679:1: (lv_minValue_2_0= RULE_INT )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2679:1: (lv_minValue_2_0= RULE_INT )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2680:3: lv_minValue_2_0= RULE_INT
                    {
                    lv_minValue_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRange6088); if (state.failed) return current;
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
                              		"INT");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,40,FOLLOW_40_in_ruleRange6106); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRangeAccess().getCommaKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2700:1: ( (lv_maxValue_4_0= RULE_INT ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_INT) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2701:1: (lv_maxValue_4_0= RULE_INT )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2701:1: (lv_maxValue_4_0= RULE_INT )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2702:3: lv_maxValue_4_0= RULE_INT
                    {
                    lv_maxValue_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRange6123); if (state.failed) return current;
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
                              		"INT");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2718:3: ( ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2719:1: ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2719:1: ( (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2720:1: (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2720:1: (lv_gtIncl_5_1= ')' | lv_gtIncl_5_2= ']' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==49) ) {
                alt54=1;
            }
            else if ( (LA54_0==41) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2721:3: lv_gtIncl_5_1= ')'
                    {
                    lv_gtIncl_5_1=(Token)match(input,49,FOLLOW_49_in_ruleRange6149); if (state.failed) return current;
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2733:8: lv_gtIncl_5_2= ']'
                    {
                    lv_gtIncl_5_2=(Token)match(input,41,FOLLOW_41_in_ruleRange6178); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2756:1: entryRuleWhitespaceRule returns [EObject current=null] : iv_ruleWhitespaceRule= ruleWhitespaceRule EOF ;
    public final EObject entryRuleWhitespaceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhitespaceRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2757:2: (iv_ruleWhitespaceRule= ruleWhitespaceRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2758:2: iv_ruleWhitespaceRule= ruleWhitespaceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhitespaceRuleRule()); 
            }
            pushFollow(FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule6230);
            iv_ruleWhitespaceRule=ruleWhitespaceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhitespaceRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhitespaceRule6240); if (state.failed) return current;

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2765:1: ruleWhitespaceRule returns [EObject current=null] : (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2768:28: ( (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2769:1: (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2769:1: (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2769:3: otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) )
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleWhitespaceRule6277); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getWhitespaceRuleAccess().getWhitespaceKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2773:1: ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) )
            int alt56=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt56=1;
                }
                break;
            case 51:
                {
                alt56=2;
                }
                break;
            case RULE_STRING:
                {
                alt56=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2773:2: (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2773:2: (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2773:4: otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleWhitespaceRule6291); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getWhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2777:1: ( (lv_characters_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2778:1: (lv_characters_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2778:1: (lv_characters_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2779:3: lv_characters_2_0= RULE_STRING
                    {
                    lv_characters_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWhitespaceRule6308); if (state.failed) return current;
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
                              		"STRING");
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2795:2: (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==40) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2795:4: otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) )
                    	    {
                    	    otherlv_3=(Token)match(input,40,FOLLOW_40_in_ruleWhitespaceRule6326); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getWhitespaceRuleAccess().getCommaKeyword_1_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2799:1: ( (lv_characters_4_0= RULE_STRING ) )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2800:1: (lv_characters_4_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2800:1: (lv_characters_4_0= RULE_STRING )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2801:3: lv_characters_4_0= RULE_STRING
                    	    {
                    	    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWhitespaceRule6343); if (state.failed) return current;
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
                    	              		"STRING");
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,41,FOLLOW_41_in_ruleWhitespaceRule6362); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getWhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2822:6: ( (lv_javawhitespace_6_0= 'javawhitespace' ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2822:6: ( (lv_javawhitespace_6_0= 'javawhitespace' ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2823:1: (lv_javawhitespace_6_0= 'javawhitespace' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2823:1: (lv_javawhitespace_6_0= 'javawhitespace' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2824:3: lv_javawhitespace_6_0= 'javawhitespace'
                    {
                    lv_javawhitespace_6_0=(Token)match(input,51,FOLLOW_51_in_ruleWhitespaceRule6387); if (state.failed) return current;
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2838:6: ( (lv_fileURI_7_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2838:6: ( (lv_fileURI_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2839:1: (lv_fileURI_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2839:1: (lv_fileURI_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2840:3: lv_fileURI_7_0= RULE_STRING
                    {
                    lv_fileURI_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWhitespaceRule6423); if (state.failed) return current;
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
                              		"STRING");
                      	    
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
        // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:198:3: ( '.' )
        // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:199:2: '.'
        {
        match(input,12,FOLLOW_12_in_synpred1_InternalLDef395); if (state.failed) return ;

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


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoot122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRoot143 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleImport_in_ruleRoot164 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleLanguageDef_in_ruleRoot186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName376 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedName404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName427 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard533 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedNameWithWildCard552 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedNameWithWildCard565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleImport654 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLanguageDef_in_entryRuleLanguageDef711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageDef721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLanguageDef763 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLanguageDef780 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleParitioning_in_ruleLanguageDef801 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_ruleLanguageDef822 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_ruleIntegration_in_ruleLanguageDef843 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLanguageDef856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegration_in_entryRuleIntegration892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegration902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleIntegration939 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleIntegration951 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleCodeIntegration_in_ruleIntegration972 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleIntegration985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeIntegration_in_entryRuleCodeIntegration1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodeIntegration1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaFXIntegration_in_ruleCodeIntegration1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaFXIntegration_in_entryRuleJavaFXIntegration1111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaFXIntegration1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleJavaFXIntegration1158 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleJavaFXIntegration1170 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_ruleCodegeneration_in_ruleJavaFXIntegration1191 = new BitSet(new long[]{0x0000000000190000L});
    public static final BitSet FOLLOW_16_in_ruleJavaFXIntegration1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodegeneration_in_entryRuleCodegeneration1240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodegeneration1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaCodeGeneration_in_ruleCodegeneration1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleE4CodeGeneration_in_ruleCodegeneration1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaCodeGeneration_in_entryRuleJavaCodeGeneration1359 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaCodeGeneration1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleJavaCodeGeneration1406 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJavaCodeGeneration1423 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleJavaCodeGeneration1441 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConfigValue_in_ruleJavaCodeGeneration1462 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_ruleJavaCodeGeneration1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleE4CodeGeneration_in_entryRuleE4CodeGeneration1513 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleE4CodeGeneration1523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleE4CodeGeneration1560 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleE4CodeGeneration1577 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleE4CodeGeneration1595 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConfigValue_in_ruleE4CodeGeneration1616 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_ruleE4CodeGeneration1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigValue_in_entryRuleConfigValue1667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigValue1677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConfigValue1719 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleConfigValue1736 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConfigValue1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleConfigValue1778 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConfigValue_in_ruleConfigValue1799 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_ruleConfigValue1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioning_in_entryRuleParitioning1850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioning1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleParitioning1897 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParitioning1909 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rulePartition_in_ruleParitioning1930 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_rulePartitioner_in_ruleParitioning1952 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParitioning1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_entryRulePartition2000 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rulePartition2047 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition2064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_entryRulePartitioner2105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_rulePartitioner2162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_rulePartitioner2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS2224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioner_JS2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleParitioner_JS2271 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleParitioner_JS2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule2329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner_Rule2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rulePartitioner_Rule2376 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePartitioner_Rule2388 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_rulePartitioner_Rule2409 = new BitSet(new long[]{0x0000000084010000L});
    public static final BitSet FOLLOW_16_in_rulePartitioner_Rule2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule2458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_Rule2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_rulePartition_Rule2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_rulePartition_Rule2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule2577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_SingleLineRule2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePartition_SingleLineRule2624 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition_SingleLineRule2644 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2661 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_27_in_rulePartition_SingleLineRule2679 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleCheck_in_rulePartition_SingleLineRule2700 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_28_in_rulePartition_SingleLineRule2715 = new BitSet(new long[]{0x0000000020000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2732 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_rulePartition_SingleLineRule2753 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rulePartition_SingleLineRule2765 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule2825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_MultiLineRule2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rulePartition_MultiLineRule2872 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition_MultiLineRule2892 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2909 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_rulePartition_MultiLineRule2927 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleCheck_in_rulePartition_MultiLineRule2948 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rulePartition_MultiLineRule2962 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2979 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_rulePartition_MultiLineRule2997 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rulePartition_MultiLineRule3009 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting3069 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalHighlighting3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleLexicalHighlighting3116 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLexicalHighlighting3128 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_ruleLexicalHighlighting3149 = new BitSet(new long[]{0x0000000203010000L});
    public static final BitSet FOLLOW_ruleTokenVisuals_in_ruleLexicalHighlighting3171 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLexicalHighlighting3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokenVisuals_in_entryRuleTokenVisuals3220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTokenVisuals3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleTokenVisuals3267 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTokenVisuals3279 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTokenVisual_in_ruleTokenVisuals3301 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleTokenVisuals3313 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_ruleTokenVisuals3327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokenVisual_in_entryRuleTokenVisual3363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTokenVisual3373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTokenVisual3418 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTokenVisual3435 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_35_in_ruleTokenVisual3458 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_ruleTokenVisual3490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting3540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting3550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_ruleLexicalPartitionHighlighting3597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_ruleLexicalPartitionHighlighting3624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS3659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS3669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleLexicalPartitionHighlighting_JS3706 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_JS3726 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexicalPartitionHighlighting_JS3743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule3784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleLexicalPartitionHighlighting_Rule3831 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_Rule3851 = new BitSet(new long[]{0x0004000000008000L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_ruleLexicalPartitionHighlighting_Rule3872 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLexicalPartitionHighlighting_Rule3885 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_ruleToken_in_ruleLexicalPartitionHighlighting_Rule3906 = new BitSet(new long[]{0x0000002000010010L});
    public static final BitSet FOLLOW_16_in_ruleLexicalPartitionHighlighting_Rule3919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_entryRuleToken3955 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleToken3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleToken4008 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleToken4039 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleToken4057 = new BitSet(new long[]{0x0000284085000000L});
    public static final BitSet FOLLOW_ruleScanner_in_ruleToken4078 = new BitSet(new long[]{0x0000284085010000L});
    public static final BitSet FOLLOW_16_in_ruleToken4091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_entryRuleScanner4129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner4139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_ruleScanner4186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_ruleScanner4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword4248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Keyword4258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleScanner_Keyword4295 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleScanner_Keyword4307 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleScanner_Keyword4328 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_40_in_ruleScanner_Keyword4341 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleScanner_Keyword4362 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_41_in_ruleScanner_Keyword4376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword4412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword4422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword4464 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleKeyword4482 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword4499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule4542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Rule4552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_ruleScanner_Rule4599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_ruleScanner_Rule4626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_ruleScanner_Rule4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_ruleScanner_Rule4680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_PatternRule_in_ruleScanner_Rule4707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule4742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_SingleLineRule4752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleScanner_SingleLineRule4789 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4806 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_27_in_ruleScanner_SingleLineRule4824 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleCheck_in_ruleScanner_SingleLineRule4845 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_28_in_ruleScanner_SingleLineRule4860 = new BitSet(new long[]{0x0000000020000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4877 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleScanner_SingleLineRule4898 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleScanner_SingleLineRule4910 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule4970 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_MultiLineRule4980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleScanner_MultiLineRule5017 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule5034 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleScanner_MultiLineRule5052 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleCheck_in_ruleScanner_MultiLineRule5073 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleScanner_MultiLineRule5087 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule5104 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleScanner_MultiLineRule5122 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleScanner_MultiLineRule5134 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule5151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_PatternRule_in_entryRuleScanner_PatternRule5194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_PatternRule5204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleScanner_PatternRule5241 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_PatternRule5258 = new BitSet(new long[]{0x0000100008000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleScanner_PatternRule5280 = new BitSet(new long[]{0x0000100008000000L});
    public static final BitSet FOLLOW_27_in_ruleScanner_PatternRule5299 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleCheck_in_ruleScanner_PatternRule5320 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleScanner_PatternRule5334 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_PatternRule5351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule5392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_CharacterRule5402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleScanner_CharacterRule5439 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleScanner_CharacterRule5451 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule5468 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_40_in_ruleScanner_CharacterRule5486 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule5503 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_41_in_ruleScanner_CharacterRule5522 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleScanner_CharacterRule5535 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleCheck_in_ruleScanner_CharacterRule5556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule5594 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_JSRule5604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleScanner_JSRule5641 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_JSRule5658 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleScanner_JSRule5676 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleCheck_in_ruleScanner_JSRule5697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCheck_in_entryRuleCheck5735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCheck5745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_ruleCheck5792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquals_in_ruleCheck5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquals_in_entryRuleEquals5854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquals5864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleEquals5901 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEquals5918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_entryRuleRange5959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRange5969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleRange6006 = new BitSet(new long[]{0x0001008000000000L});
    public static final BitSet FOLLOW_48_in_ruleRange6026 = new BitSet(new long[]{0x0000010000000040L});
    public static final BitSet FOLLOW_39_in_ruleRange6055 = new BitSet(new long[]{0x0000010000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRange6088 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleRange6106 = new BitSet(new long[]{0x0002020000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRange6123 = new BitSet(new long[]{0x0002020000000000L});
    public static final BitSet FOLLOW_49_in_ruleRange6149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleRange6178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule6230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhitespaceRule6240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleWhitespaceRule6277 = new BitSet(new long[]{0x0008008000000020L});
    public static final BitSet FOLLOW_39_in_ruleWhitespaceRule6291 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWhitespaceRule6308 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_40_in_ruleWhitespaceRule6326 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWhitespaceRule6343 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_41_in_ruleWhitespaceRule6362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleWhitespaceRule6387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWhitespaceRule6423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred1_InternalLDef395 = new BitSet(new long[]{0x0000000000000002L});

}